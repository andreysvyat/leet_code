package find_lost_number

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SolutionKtTest {

    @Test
    fun missingNumberTest1() {
        assertEquals(2, missingNumber(intArrayOf(4, 0, 3, 1)))
    }

    @Test
    fun missingNumberTest2() {
        assertEquals(7, missingNumber(intArrayOf(8, 3, 5, 2, 4, 6, 0, 1)))
    }

    @Test
    fun missingNumberTest3() {
        assertEquals(2, missingNumber(intArrayOf(0, 1)))
    }

    @Test
    fun missingNumberTest4() {
        assertEquals(1, missingNumber(intArrayOf(0)))
    }
}