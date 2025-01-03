package number_of_ways_to_split_array

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionKtTest {

    private val longCases: Array<IntArray>

    init {
        val mapper = ObjectMapper()
        longCases = mapper.readValue(
            this::class.java.getResourceAsStream("/number_of_ways_to_split_array/test_case.json"),
            Array<IntArray>::class.java
        )
    }

    @Test
    fun waysToSplitArrayCase1() {
        assertEquals(2, waysToSplitArray(intArrayOf(10, 4, -8, 7)))
    }

    @Test
    fun waysToSplitArrayCase2() {
        assertEquals(2, waysToSplitArray(intArrayOf(2, 3, 1, 0)))
    }

    @Test
    fun waysToSplitArrayCase3() {
        assertEquals(0, waysToSplitArray(intArrayOf(6, -1, 9)))
    }

    @Test
    fun waysToSplitArrayCase4() {
        val result: Int = waysToSplitArray(this.longCases[0])
        assertEquals(4, result)
    }

    @Test
    fun waysToSplitArrayCase5() {
        val result: Int = waysToSplitArray(this.longCases[1])
        assertEquals(9, result)
    }

    @Test
    fun waysToSplitArrayCase6() {
        val result: Int = waysToSplitArray(this.longCases[2])
        assertEquals(245, result)
    }

    @Test
    fun waysToSplitArrayCase7() {
        val result: Int = waysToSplitArray(this.longCases[3])
        assertEquals(7354, result)
    }

    @Test
    fun waysToSplitArrayCase8() {
        val result: Int = waysToSplitArray(this.longCases[4])
        assertEquals(70710, result)
    }

    @Test
    fun waysToSplitArrayCase9() {
        val result: Int = waysToSplitArray(this.longCases[5])
        assertEquals(34230, result)
    }
}