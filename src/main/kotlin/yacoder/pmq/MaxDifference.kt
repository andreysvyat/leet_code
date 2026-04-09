package yacoder.pmq

fun Array<String>.transpose(): Array<String> {
    if (isEmpty()) return emptyArray()
    return this[0].indices.map { j ->
        this.indices.map { i -> this[i][j] }.joinToString("")
    }.toTypedArray()
}

fun Array<String>.calculateRows(): IntArray {
    val sums = IntArray(this.size)
    for (i in 0 until this.size) {
        sums[i] = this[i].calculateRow()
    }
    return sums
}

fun String.calculateRow(): Int {
    var result = 0
    for (c in this) {
        when (c) {
            '+' -> result += 1
            '-' -> result -= 1
            else -> throw IllegalArgumentException()
        }
    }
    return result
}

fun Array<String>.getUndefinedSigns(): Array<Pair<Int, Int>> {
    val addresses = ArrayList<Pair<Int, Int>>()
    for (i in 0 until size) {
        for (j in 0 until this[i].length) {
            if (this[i][j] == '?') {
                addresses.add(Pair(i, j))
            }
        }
    }
    return addresses.toTypedArray()
}

class DefinedMatrix(
    matrix: Array<out String>,
    sign: String,
    alternateSignAddresses: Array<Pair<Int, Int>>
) {
    private val internalMatrix: Array<String>

    init {
        val alternateSign = if (sign == "+") "-" else "+"
        internalMatrix = Array(matrix.size) { i ->
            var newLine = matrix[i]
            alternateSignAddresses
                .filter { address -> address.first == i }
                .forEach { xy ->
                    newLine = newLine
                        .replaceRange(xy.second, xy.second + 1, alternateSign)
                }
            newLine = newLine.replace("?", sign)
            newLine
        }
    }

    constructor(matrix: Array<String>) : this(matrix, "+", emptyArray())
    constructor(matrix: Array<String>, sign: String) : this(matrix, sign, emptyArray())
    constructor(matrix: Array<String>, alternateSignAddresses: Array<Pair<Int, Int>>) : this(
        matrix,
        "+",
        alternateSignAddresses
    )

    fun matrix(): Array<out String> {
        return internalMatrix
    }

    fun maxRowSumDifferenceToMinColSum(): Int {
        val maxRowSum = this.internalMatrix.calculateRows().max()
        val minColSum = this.internalMatrix.transpose().calculateRows().min()
        return maxRowSum - minColSum
    }

    fun getRowSums(): IntArray {
        return this.internalMatrix.calculateRows()
    }

    fun getColumnSums(): IntArray {
        return this.internalMatrix.transpose().calculateRows()
    }
}

class MaxDifference(
    val matrix: Array<String>
) {
    fun maxDifference(): Int {
        val definedPlus = DefinedMatrix(matrix)
        val maxRowSum = definedPlus.getRowSums().max()
        val definedMinus = DefinedMatrix(matrix, "-")
        val minColSum = definedMinus.getColumnSums().min()
        return maxRowSum - minColSum
    }
}

fun main() {
    val sizes = readln().split(" ")
    val n = sizes[0].toInt()
    val m = sizes[1].toInt()
    val matrix = MatrixReader(n, m).readMatrixLines()
    println(MaxDifference(matrix).maxDifference())
}