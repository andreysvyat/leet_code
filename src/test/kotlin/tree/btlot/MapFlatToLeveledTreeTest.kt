package tree.btlot

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MapFlatToLeveledTreeTest {
    @Test
    fun mapFlatToLeveledTreeTest1_2_3_null_null_4() {
        val given = listOf(1, 2, 3, null, null, 4)
        val expected = listOf(listOf(1), listOf(2, 3), listOf(4))
        val actual = mapFlatToLeveledTree(given)
        assertEquals(expected, actual)
    }

    @Test
    fun mapFlatToLeveledTreeTest1_2_3_4_5_6() {
        val given = listOf(1, 2, 3, 4, 5, 6)
        val expected = listOf(listOf(1), listOf(2, 3), listOf(4, 5, 6))
        val actual = mapFlatToLeveledTree(given)
        assertEquals(expected, actual)
    }
}