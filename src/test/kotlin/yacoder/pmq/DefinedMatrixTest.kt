package yacoder.pmq

import org.junit.jupiter.api.Assertions.assertArrayEquals
import kotlin.test.Test

class DefinedMatrixTest {
    @Test
    fun testDefinedMatrix() {
        val matrix = arrayOf(
            "+-+",
            "??-",
            "?-?",
            "++?"
        )

        val definedMatrix = DefinedMatrix(matrix, arrayOf(Pair(1,0), Pair(3, 2)))
        assertArrayEquals(arrayOf(
            "+-+",
            "-+-",
            "+-+",
            "++-"
        ), definedMatrix.matrix())
    }

    @Test
    fun testDefinedMatrixAllPlus() {
        val matrix = arrayOf(
            "+-+",
            "??-",
            "?-?",
            "++?"
        )

        val definedMatrix = DefinedMatrix(matrix)
        assertArrayEquals(arrayOf(
            "+-+",
            "++-",
            "+-+",
            "+++"
        ), definedMatrix.matrix())
    }
}