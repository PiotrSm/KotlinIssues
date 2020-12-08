/**
 * Klasa posiada jeden parametr typu sparametryzowanego (generics)
 * Zaznaczone jest tez że jest to klasa sparametryzowana<>
 * Parametr jest typu ogólnego T i jest przechowywany w zmiennej loot
 * Parametrem może być klasa pochodna od typu Loot
 */
class LootBoxExtra<T : Loot>(item: T) {
    private var loot: T = item
    var open = false

    fun fetch(): T? {
        return loot
    }

    fun fetchIf(): T? {
        //zwraca zawartość loot tylko wedy jeżeli zmienna open jest true
        return loot.takeIf { open }
    }
    //funkcja przyjmuje jako argument funkcję która przekształca obiekt T i zwraca obiekt R
    fun <R> fetch(lootModFunction: (T) -> R): R? {
        return lootModFunction(loot).takeIf { open }
    }
}

//najlepiej stworzyć klasę nadrzędna która będzie parametrem w klasie generic
open class Loot(val value: Int)

class FedoraExtra(val name: String,  value: Int): Loot(value)

class CoinExtra( value: Int): Loot(value)

fun main(args: Array<String>) {
    var obraz = FedoraExtra("standardowy kapelusz", 15)
    val lootBoxOne: LootBox<FedoraExtra> = LootBox(obraz)
    val coinIn = CoinExtra(15)
    val lootBoxTwo: LootBox<CoinExtra> = LootBox(coinIn)

    lootBoxOne.fetch()?.run {
        println("Wyjąłeś $name za skrzyni")
    }

    lootBoxOne.open = true// ustawiamy zmienną open na true aby funkcja fetchIf zwróciła nam wartość
    //funkcja nie zadziała jeżeli zmienna open jest false
    lootBoxOne.fetchIf()?.run {
        println("Wyjąłeś $name za skrzyni, jeżli otwarta")
    }


    val coin = lootBoxTwo.fetch()
    //użycie pierwszej metody fetch - bez parametrów i warunków
    println("wartość monety to ${coin?.value}")

    lootBoxTwo.open = true//trzeba ustawić zmienną open na true aby dostac wartość
    val coin2 = lootBoxTwo.fetchIf()
    coin2?.let {
        println("wartość monety 2 to ${it.value}")
    }

    val coin3 = lootBoxTwo.fetch {
        Coin(it.value * 3)
    }
    coin3?.let {
        println("wartość monety 3 to ${it.value}")
    }

}