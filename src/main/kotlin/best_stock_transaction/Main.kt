package best_stock_transaction

import java.lang.Math.pow

fun main() {
    val arr = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val mrx = Array(2) { IntArray(5) }
    for (i in mrx.indices) {
        mrx[i] = arr.copyOfRange()
    }
    for (i in mrx.indices){
        for (j in mrx[i].indices){
            print("%s ".format(mrx[i][j]))
        }
        println()
    }
}