package yacoder.pmq

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.seconds
import kotlin.time.measureTime

class RowMaxColMinSumDifferenceCalculatorTest {
    @Test
    fun calculateRowAndColSums() {
        val matrix = arrayOf(
            "+-+",
            "??-",
            "?-?",
            "++?"
        ).toMatrix()

        val diffCalculator = RowMaxColMinSumDifferenceCalculator(matrix)

        val expectsRowSums = listOf(
            SumDescriptor(1, 0),
            SumDescriptor(1, 1),
            SumDescriptor(1, 2),
            SumDescriptor(3, 3)
        )
        val expectsColSums = listOf(
            SumDescriptor(0, 0),
            SumDescriptor(-2, 1),
            SumDescriptor(-2, 2)
        )

        val actual = diffCalculator.calculateRowAndColSums()
        assertContentEquals(expectsRowSums, actual.rows)
        assertContentEquals(expectsColSums, actual.cols)
    }

    @Test
    fun firstExampleCase() {
        val matrix = arrayOf(
            "+-+",
            "??-",
            "?-?",
            "++?"
        ).toMatrix()
        val diffCalculator = RowMaxColMinSumDifferenceCalculator(
            matrix
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(5, actual)
    }

    @Test
    fun secondExampleCase() {
        val matrix = arrayOf(
            "??+++-?-?-",
            "-??+???--+",
            "?-+?+-?+--",
            "??????--?+",
            "++--?--+-?",
            "?-?+++?+-?"
        ).toMatrix()
        val diffCalculator = RowMaxColMinSumDifferenceCalculator(
            matrix
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(12, actual)
    }

    @Test
    fun crossMatrixWithSingleQuery() {
        val diffCalculator = RowMaxColMinSumDifferenceCalculator(
            arrayOf(
                "+--",
                "+?+",
                "--+"
            ).toMatrix()
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(4, actual)
    }

    @Test
    fun testFullyUndefined() {
        val diffCalculator = RowMaxColMinSumDifferenceCalculator(
            arrayOf(
                "???",
                "???",
                "???"
            ).toMatrix()
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(4, actual)
    }

    @Test
    fun testUndefinedDiagonal() {
        val diffCalculator = RowMaxColMinSumDifferenceCalculator(
            arrayOf(
                "?+",
                "-?"
            ).toMatrix()
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(2, actual)
    }

    @Test
    fun testUndefinedFrame() {
        val diffCalculator = RowMaxColMinSumDifferenceCalculator(
            arrayOf(
                "???",
                "?+?",
                "???"
            ).toMatrix()
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(4, actual)
    }

    @Test
    fun testUndefinedDiagonals() {
        val diffCalculator = RowMaxColMinSumDifferenceCalculator(
            arrayOf(
                "?+?",
                "+?-",
                "?-?"
            ).toMatrix()
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(4, actual)
    }

    @Test
    fun testUndefinedH() {
        val diffCalculator = RowMaxColMinSumDifferenceCalculator(
            arrayOf(
                "?+?",
                "???",
                "?-?"
            ).toMatrix()
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(4, actual)
    }

    @Test
    fun testUndefinedAllInsteadOfOnePlusAndOneMinus() {
        val diffCalculator = RowMaxColMinSumDifferenceCalculator(
            arrayOf(
                "?+??",
                "????",
                "??-?",
                "????"
            ).toMatrix()
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(6, actual)
    }

    @Test
    fun testSingleUndefinedColumn() {
        val diffCalculator = RowMaxColMinSumDifferenceCalculator(
            arrayOf(
                "?",
                "?"
            ).toMatrix()
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(1, actual)
    }

    @Test
    fun testNegativeMaxDifference() {
        val diffCalculator = RowMaxColMinSumDifferenceCalculator(
            arrayOf(
                "---"
            ).toMatrix()
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(-2, actual)
    }

    @Test
    fun randomLongExampleTestTimeAndSpaceMeasure() {
        val diffCalculator = RowMaxColMinSumDifferenceCalculator(generateMatrix())
        val runtime = Runtime.getRuntime()
        val start = runtime.totalMemory() - runtime.freeMemory()
        val time = measureTime { diffCalculator.maxDifference() }
        val stop = runtime.totalMemory() - runtime.freeMemory()
        assertTrue { time < 1.seconds }
        val space = (stop - start)
        assertTrue { (256 * 1024 * 1024) > space }
        println(space)
    }

    private val vals = intArrayOf(-1, 0, 1)

    private fun generateMatrix(n: Int, m: Int): Array<IntArray> {
        return Array(n) { Array(m) { vals.random() }.toIntArray() }
    }

    private fun generateMatrix(): Array<IntArray> {
        return generateMatrix(1000, 1000)
    }
}

fun Array<String>.toMatrix(): Array<IntArray> {
    return this.map { row ->
        row.map { char ->
            when (char) {
                '+' -> 1
                '-' -> -1
                '?' -> 0
                else -> throw IllegalStateException("Invalid char: $char")
            }
        }.toIntArray()
    }.toTypedArray()
}