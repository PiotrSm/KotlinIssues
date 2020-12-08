import java.io.*
import java.math.*
import java.text.*
import java.util.*
import java.util.regex.*

fun handshake(n: BigInteger): BigInteger {

   // return fuctorial(n).divide(BigInteger.valueOf(2).multiply(fuctorial(n.subtract(BigInteger.valueOf(2)))))
    return n.multiply(n.subtract(BigInteger.ONE))

}


fun main(args: Array<String>) {
    val scan = Scanner("2\n2\n5277")

    val t = scan.nextLine().trim().toInt()


    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toBigInteger()

        val result = handshake(n)

        println(result)
    }
}