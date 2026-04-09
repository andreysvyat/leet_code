package yacoder.pmq

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class BruteForceMaxDifferenceTest {
    @Test
    fun firstExampleCase() {
        val diffCalculator = BruteForceMaxDifference(
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
        val diffCalculator = BruteForceMaxDifference(
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
        val diffCalculator = BruteForceMaxDifference(
            arrayOf(
                "+--",
                "+?+",
                "--+"
            )
        )
        val actual = diffCalculator.maxDifference()
        assertEquals(4, actual)
    }
}