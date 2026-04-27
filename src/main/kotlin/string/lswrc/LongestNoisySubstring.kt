package string.lswrc

import kotlin.math.max

class LongestNoisySubstring(private val input: String) {
    fun getLength(): Int {
        if (input.length <= 1) {
            return input.length
        }
        val lastOccurrences = HashMap<Char, Int>()
        var maxLen = 1
        var lPointer = 0
        var rPointer = 0
        while (rPointer < input.length) {
            val current = input[rPointer]
            val lastPosition = lastOccurrences.getOrDefault(current, -1)
            if (lastPosition >= lPointer) {
                lPointer = lastPosition + 1
            }
            val len = rPointer - lPointer + 1
            if (len > maxLen) {
                maxLen = len
            }
            lastOccurrences[input[rPointer]] = rPointer
            rPointer++
        }
        return max(maxLen, rPointer - lPointer)
    }
}