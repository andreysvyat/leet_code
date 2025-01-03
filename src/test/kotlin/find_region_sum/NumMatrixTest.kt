package find_region_sum

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumMatrixTest {

    val mtrx = arrayOf(
        intArrayOf(3, 0, 1, 4, 2),
        intArrayOf(5, 6, 3, 2, 1),
        intArrayOf(1, 2, 0, 1, 5),
        intArrayOf(4, 1, 0, 1, 7),
        intArrayOf(1, 0, 3, 0, 5)
    )

    @Test
    fun sumRegionCase1() {
        val actual = NumMatrix(mtrx).sumRegion(2, 1, 4, 3)
        assertEquals(8, actual)
    }

    @Test
    fun sumRegionCase2() {
        val actual = NumMatrix(mtrx).sumRegion(1, 1, 2, 2)
        assertEquals(11, actual)
    }

    @Test
    fun sumRegionCase3() {
        val actual = NumMatrix(mtrx).sumRegion(1, 2, 2, 4)
        assertEquals(12, actual)
    }
}