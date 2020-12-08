/**
 * Klasa posiada jeden parametr typu sparametryzowanego (generics)
 * Zaznaczone jest tez że jest to klasa sparametryzowana<>
 * Parametr jest typu ogólnego T i jest przechowywany w zmiennej loot
 * Może to być parametr dowolnego typu
 */
class LootBox<T>(item: T) {
    private var loot: T = item

    fun fetch(): T? {
        return loot
    }
}

class Fedora (val name: String,val value: Int)

class Coin(val value: Int)

fun main(args: Array<String>) {
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("standardowy kapelusz",15))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))

    lootBoxOne.fetch()?.run {
        println("Wyjąłeś $name za skrzyni")
    }
}