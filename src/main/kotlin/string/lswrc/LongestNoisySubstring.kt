package string.lswrc

class LongestNoisySubstring(private val input: String) {
    fun getLength(): Int {
        val charSet = mutableSetOf<Char>()
        var maxLen = 0
        var lPointer = 0
        var rPointer = 0
        while (rPointer < input.length) {
            val len = rPointer - lPointer
            if (len > maxLen) {
                maxLen = len
            }
            if (charSet.contains(input[rPointer])) {
                lPointer = rPointer
            } else {
                charSet.add(input[rPointer])
            }
            rPointer++
        }
        return maxLen
    }
}