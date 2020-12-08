fun main(args: Array<String>) {
    val n = 3
    val m = 2
    val result = solve(n, m)

    println(solve(4, 5))

    println({
        val n = 4
        val m = 5
        n + m
    }())

    println(addNumbers())
    println(addNumbersArg(4))
    println(addNumbersArg2(4, 5))
    println("solve " + solve(689715240, 759842301))
    minusTwo(4, 5, solve)
    minusTwo(4, 5) { n, m -> n + m }
    println(minusTwoReturn(4, 5, solve))
    println(minusTwoReturn(8, 5, { n, m -> n }))
    println(addNumbersArgLong(689715240, 759842301))
    println(plus(4,5))
}

val addNumbers: () -> String = {
    val n = 4
    val m = 5
    (n + m).toString()
}
val addNumbersArg: (Int) -> String = { n ->
    val m = 5
    (n + m).toString()
}
val addNumbersArg2: (Int, Int) -> Int = { n, m -> n + m }

var solve = { n: Int, m: Int -> n - 1 + n * (m - 1) }

val plus = { n: Int, m: Int -> n + m }

fun minusTwo(n: Int, m: Int, solve: (Int, Int) -> Int) {
    println(solve(n, m) - 2)
}

fun minusTwoReturn(n: Int, m: Int, solve: (Int, Int) -> Int): Int {
    return (solve(n, m) - 2)
}

val addNumbersArgLong: (Int, Int) -> Long = { n, m -> n - 1 + n * (m - 1).toLong() }