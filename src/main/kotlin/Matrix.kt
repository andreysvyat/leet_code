class NumMatrix(private val matrix: Array<IntArray>) {
	fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
		var sum = 0
		for (i in col1..col2) {
			for (j in row1..row2)
				sum += matrix[j][i]
		}
		return sum
	}
}

fun main(args: Array<String>) {
	val mtrx = arrayOf(
		intArrayOf(3, 0, 1, 4, 2),
		intArrayOf(5, 6, 3, 2, 1),
		intArrayOf(1, 2, 0, 1, 5),
		intArrayOf(4, 1, 0, 1, 7),
		intArrayOf(1, 0, 3, 0, 5)
	)
	println(NumMatrix(mtrx).sumRegion(2, 1, 4, 3))
	println(NumMatrix(mtrx).sumRegion(1, 1, 2, 2))
	println(NumMatrix(mtrx).sumRegion(1, 2, 2, 4))
}