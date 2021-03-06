/**
 * Klasa posiada jeden parametr typu sparametryzowanego (generics)
 * Zaznaczone jest tez że jest to klasa sparametryzowana<>
 * Parametr jest typu ogólnego T i jest przechowywany w zmiennej loot
 * Może to być parametr dowolnego typu
 */
class LootBox<T>(item: T) {
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

class Fedora(val name: String, val value: Int)

class Coin(val value: Int)

fun main(args: Array<String>) {
    var obraz = Fedora("standardowy kapelusz", 15)
    val lootBoxOne: LootBox<Fedora> = LootBox(obraz)
    val coinIn = Coin(15)
    val lootBoxTwo: LootBox<Coin> = LootBox(coinIn)

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