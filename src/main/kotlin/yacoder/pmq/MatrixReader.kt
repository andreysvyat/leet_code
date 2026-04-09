package yacoder.pmq

class MatrixReader(private val linesAmount: Int, private val columnsAmount: Int) {
    fun readMatrixLines(): Array<String> {
        return Array(linesAmount) {
            val line = readln()
            if (line.length != columnsAmount) {
                throw IllegalStateException("Invalid matrix length: $line")
            }
            return@Array line
        }
    }

    fun readMatrix(): Array<IntArray> {
        return Array(linesAmount) {
            val line = readln()
            if (line.length != columnsAmount) {
                throw IllegalStateException("Invalid matrix line length: $line")
            }
            line.map { char ->
                when (char) {
                    '+' -> 1
                    '-' -> -1
                    '?' -> 0
                    else -> throw IllegalStateException("Invalid char: $char")
                }
            }.toIntArray()
        }
    }
}