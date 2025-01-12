package cyclic_sort

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SolutionKtTest {

    @Test
    fun testCyclicSortCase1() {
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), sort(intArrayOf(3, 1, 5, 4, 2)))
    }

    @Test
    fun testCyclicSortCase2() {
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6), sort(intArrayOf(2, 6, 4, 3, 1, 5)))
    }

    @Test
    fun testCyclicSortCase3() {
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6), sort(intArrayOf(1, 5, 6, 4, 3, 2)))
    }
}