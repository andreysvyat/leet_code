package array.watercontainer

import kotlin.math.min

class WaterContainers (
    private val bounds : IntArray
) {
    private var lPointer: Int = 0
    private var rPointer: Int = bounds.size - 1

    fun getLargest() : Int {
        return getLargestTwoPointers()
    }

    fun getLargestBruteForce() : Int {
        var maxSpace = 0
        for (i in 0 until bounds.size) {
            for (j in i until bounds.size) {
                val space = calculateSpaceByPointers(i, j)
                if(space > maxSpace) {
                    maxSpace = space
                }
            }
        }
        return maxSpace
    }

    fun getLargestTwoPointers() : Int {
        var maxSpace = 0
        while (lPointer < rPointer) {
            val space = calculateSpaceByPointers()
            if(space > maxSpace) {
                maxSpace = space
            }
            if(bounds[lPointer] < bounds[rPointer]) {
                lPointer++
            } else {
                rPointer--
            }
        }
        return maxSpace
    }

    fun calculateSpaceByPointers(lPointer: Int, rPointer: Int): Int {
        val h = min(bounds[rPointer], bounds[lPointer])
        val l = rPointer - lPointer
        return h * l
    }

    fun calculateSpaceByPointers() : Int {
        return calculateSpaceByPointers(lPointer, rPointer)
    }
}
