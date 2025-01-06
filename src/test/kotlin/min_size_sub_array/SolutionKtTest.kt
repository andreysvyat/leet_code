package min_size_sub_array

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SolutionKtTest {

    @Test
    fun minSubArrayLenTest() {
        val result = minSubArrayLen(7, intArrayOf(2,3,1,2,4,3))
        assertEquals(2, result)
    }

    @Test
    fun minSubArrayLenTestSliding() {
        val result = minSubArrayLenSlidingWindow(7, intArrayOf(2,3,1,2,4,3))
        assertEquals(2, result)
    }
}