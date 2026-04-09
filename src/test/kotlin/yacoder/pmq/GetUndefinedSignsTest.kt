package yacoder.pmq

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class GetUndefinedSignsTest {
    @Test
    fun testDefinedMatrixAllMinus() {
        val matrix = arrayOf(
            "+-+",
            "??-",
            "?-?",
            "++?"
        )
        val actual = matrix.getUndefinedSigns()
        assertArrayEquals(arrayOf(Pair(1,0), Pair(1,1), Pair(2,0), Pair(2,2), Pair(3,2)), actual)
    }
}