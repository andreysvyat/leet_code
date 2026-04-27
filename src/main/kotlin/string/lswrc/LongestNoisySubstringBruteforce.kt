package string.lswrc

class LongestNoisySubstringBruteforce(private val input: String) {
    fun getLength(): Int {
        var maxLength = 0
        for (i in input.indices) {
            var j = i + 1
            while (j < input.length && !input.substring(i, j).contains(input[j])) {
                j++
            }
            if (maxLength < j - i) {
                maxLength = j - i
            }
        }
        return maxLength
    }
}