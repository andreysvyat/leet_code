package tree.btlot

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Exp2Test {
    @Test
    fun exp2_5() {
        val actual = exp2(5)
        assertEquals(32, actual)
    }

    @Test
    fun exp2_0() {
        val actual = exp2(0)
        assertEquals(1, actual)
    }
}