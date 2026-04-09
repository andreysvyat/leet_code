package yacoder.pmq

class RowMaxColMinSumDifferenceCalculator(
    private val matrix: Array<IntArray>
) {
    fun maxDifference(): Int {
        val sums = calculateRowAndColSums()
        var maxDiff = Int.MIN_VALUE
        for (i in sums.rows.indices) {
            for (j in sums.cols.indices) {
                val row = sums.rows[i].index
                val col = sums.cols[j].index
                val dif =
                    if (matrix[row][col] == 0) sums.rows[i].value - sums.cols[j].value - 2 else sums.rows[i].value - sums.cols[j].value
                if (dif > maxDiff) {
                    maxDiff = dif
                }
            }
        }
        return maxDiff
    }

    fun calculateRowAndColSums(): Sums {
        val rowSums = matrix
            .map { row -> row.sumOf { if (it == 0) 1 else it } }
            .mapIndexed { index, value -> SumDescriptor(value, index) }
        val colSums = (0 until matrix[0].size).map { colIndex ->
            SumDescriptor(
                matrix
                    .map { row -> row[colIndex] }
                    .sumOf { if (it == 0) -1 else it },
                colIndex
            )
        }
        return Sums(rowSums, colSums)
    }
}

class SumDescriptor(val value: Int, val index: Int) : Comparable<SumDescriptor> {
    override fun equals(other: Any?): Boolean {
        return other is SumDescriptor && value == other.value && index == other.index
    }

    override fun hashCode(): Int {
        var result = value
        result = 31 * result + index
        return result
    }

    override fun toString(): String {
        return "SumDescriptor(value=$value, index=$index)"
    }

    override fun compareTo(other: SumDescriptor): Int {
        return value.compareTo(other.value)
    }
}

class Sums(
    val rows: List<SumDescriptor>,
    val cols: List<SumDescriptor>
)

fun main() {
    val sizes = readln().split(" ")
    val n = sizes[0].toInt()
    val m = sizes[1].toInt()
    val matrix = MatrixReader(n, m).readMatrix()
    println(RowMaxColMinSumDifferenceCalculator(matrix).maxDifference())
}
