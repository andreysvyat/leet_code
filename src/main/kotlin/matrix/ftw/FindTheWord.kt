package matrix.ftw

class FindTheWord(
    private val word: String,
    private val matrix: Array<CharArray>
) {
    fun exist(): Boolean {
        val addresses = getFirstLetterAddresses()
        for (address in addresses) {
            if (annealWord(address[0], address[1]))
                return true
        }
        return false
    }

    fun annealWord(startI: Int, startJ: Int): Boolean {
        return recAnnealWord(startI, startJ, 0, setOf())
    }

    private fun recAnnealWord(
        currI: Int,
        currJ: Int,
        charIdx: Int,
        used: Set<Pair<Int, Int>>
    ): Boolean {
        if (charIdx == word.length - 1) return true
        val nextLetterAddresses = getNextLetterAddresses(currI, currJ, word[charIdx + 1])
        if (!nextLetterAddresses.isEmpty())
            return nextLetterAddresses
                .filter { (nI, nJ) -> !used.contains(nI to nJ) }
                .map { recAnnealWord(it[0], it[1], charIdx + 1, used + (currI to currJ)) }
                .any { annealed -> annealed }
        return false
    }

    fun getFirstLetterAddresses(): List<IntArray> {
        val firstChar = word.elementAt(0)
        return matrix.flatMapIndexed { i, row ->
            row.mapIndexed { j, char ->
                if (char == firstChar) intArrayOf(i, j) else null
            }.filterNotNull()
        }
    }

    fun getNextLetterAddresses(i: Int, j: Int, letter: Char): List<IntArray> {
        val result = mutableListOf<IntArray>()
        if (i > 0 && matrix[i - 1][j] == letter)
            result.add(intArrayOf(i - 1, j))
        if (j < matrix[0].size - 1 && matrix[i][j + 1] == letter)
            result.add(intArrayOf(i, j + 1))
        if (i < matrix.size - 1 && matrix[i + 1][j] == letter)
            result.add(intArrayOf(i + 1, j))
        if (j > 0 && matrix[i][j - 1] == letter)
            result.add(intArrayOf(i, j - 1))
        return result
    }
}