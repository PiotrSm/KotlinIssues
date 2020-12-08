var bestDivisor = 1
var sumOfBestDisisor = 1

fun main() {

    val input = 198 //99
    compareSumWithBest(input)

    for (i in 2..Math.sqrt(input.toDouble()).toInt()) {
        if (input % i == 0) {
            compareSumWithBest(i)
            if (input / i != i) {
                compareSumWithBest(input / i)
            }
        }
    }
    println("Best divisor: $bestDivisor")
}

val compareSumWithBest = { input: Int ->
    val sumOfDigits = makeSumOfDigits(input)
    if (sumOfDigits > sumOfBestDisisor || (sumOfDigits == sumOfBestDisisor && input < bestDivisor)) {
        bestDivisor = input
        sumOfBestDisisor = sumOfDigits
    }
}

var makeSumOfDigits = { i: Int ->
    print("$i  ")
    println(i.toString().chars().map(Character::getNumericValue).sum())
    i.toString().chars().map(Character::getNumericValue).sum()
}
