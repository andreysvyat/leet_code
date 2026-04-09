package yacoder.pmq

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.seconds
import kotlin.time.measureTime

class MaxDifferenceTest {
    private val chars = "+-?"

    @Test
    fun firstExampleCase() {
        val diffCalculator = MaxDifference(
            arrayOf(
                "+-+",
                "??-",
                "?-?",
                "++?"
            )
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(5, actual)
    }

    @Test
    fun secondExampleCase() {
        val diffCalculator = MaxDifference(
            arrayOf(
                "??+++-?-?-",
                "-??+???--+",
                "?-+?+-?+--",
                "??????--?+",
                "++--?--+-?",
                "?-?+++?+-?"
            )
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(12, actual)
    }

    @Test
    fun crossMatrixWithSingleQuery() {
        val diffCalculator = MaxDifference(
            arrayOf(
                "+--",
                "+?+",
                "--+"
            )
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(4, actual)
    }

    @Test
    fun randomLongExampleTestTimeAndSpaceMeasure() {
        val matrix = generateMatrix()
        val diffCalculator = MaxDifference(matrix)
        val runtime = Runtime.getRuntime()
        val start = runtime.totalMemory() - runtime.freeMemory()
        val time = measureTime { diffCalculator.maxDifference() }
        val stop = runtime.totalMemory() - runtime.freeMemory()
        assertTrue { time < 1.seconds }
        val space = (stop - start)
        assertTrue { (256 * 1024 * 1024) > space }
        println(space)
    }

    private fun generateMatrix(n: Int, m: Int): Array<String> {
        return Array(n) {
            buildString(0) {
                repeat(m) { append(chars.random()) }
            }
        }
    }

    private fun generateMatrix(): Array<String> {
        return generateMatrix(1000, 1000)
    }

    @Test
    fun testOppositeMatrix() {
        val matrixA = arrayOf(
            "+-+",
            "++-",
            "+-+",
            "+++"
        )

        val matrixB = arrayOf(
            "+-+",
            "---",
            "---",
            "++-"
        )
        
        val matrixC = arrayOf(
            "+-+",
            "+--",
            "+-+",
            "+++"
        )
        
        val matrixCOpp = arrayOf(
            "+-+",
            "---",
            "---",
            "++-"
        )
        
        val matrixD = arrayOf(
            "+-+",
            "-+-",
            "---",
            "++-"
        )


        MatrixCalculations(matrixA).printMe()
        MatrixCalculations(matrixB).printMe()
        MatrixCalculations(matrixC).printMe()
        MatrixCalculations(matrixC).printMe()
        MatrixCalculations(matrixCOpp).printMe()
        MatrixCalculations(matrixD).printMe()
    }

    @Test
    fun testTranspose() {
        val matrix = arrayOf(
            "+--",
            "+?+",
            "--+",
            "-+-"
        )
        val transposed = matrix.transpose()
        assertEquals(3, transposed.size)
        for (row in transposed) {
            kotlin.test.assertEquals(4, row.length)
        }
        assertEquals("++--", transposed[0])
        assertEquals("-?-+", transposed[1])
        assertEquals("-++-", transposed[2])
    }
}

fun Array<String>.calculateCrossDiffs(): IntArray{
    val sumRows = this.calculateRows()
    val sumCols = this.transpose().calculateRows()
    val crossDiffs = IntArray(sumRows.size * sumCols.size)
    for (i in sumRows.indices){
        for (j in sumCols.indices){
            crossDiffs[(i+1) * j] = sumRows[i] - sumCols[j]
        }
    }
    return crossDiffs
}

fun IntArray.printMe() {
    println(this.joinToString(","))
}

class MatrixCalculations(
    val rowSum: IntArray,
    val colSum: IntArray,
    val diffMaxRowSumMinColSum: Int,
    val crossDiffs: IntArray
) {
    constructor(matrix: Array<String>) : this(
        matrix.calculateRows(),
        matrix.transpose().calculateRows(),
        matrix.calculateRows().max() - matrix.transpose().calculateRows().min(),
        matrix.calculateCrossDiffs()
    )

    fun printMe() {
        println("=====================")
        rowSum.printMe()
        colSum.printMe()
        println(diffMaxRowSumMinColSum)
        crossDiffs.printMe()
        println("=====================")
    }
}