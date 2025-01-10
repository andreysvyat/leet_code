package word_subset

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TestUnitFunctions {
    @Test
    fun isSubsetTestLetter() {
        assertTrue("e".isSubset("facebook"))
    }

    @Test
    fun isSubsetTestSubset() {
        assertTrue("fbywn".isSubset("bvwylnffbe"))
    }

    @Test
    fun testMap() {
        val result: Map<Char, Int> = arrayOf("aaaba", "aabcb", "cbcca", "abcca", "ccaca").calculateMaxFrequency()

        assertEquals(4, result['a'])
        assertEquals(2, result['b'])
        assertEquals(3, result['c'])
    }

    @Test
    fun testIsNotUniversal(){
        assertFalse("aaaba".isUniversal(mapOf('a' to 1, 'b' to 1, 'c' to 1)))
    }

    @Test
    fun testIsUniversal(){
        assertTrue("aabcb".isUniversal(mapOf('a' to 1, 'b' to 1, 'c' to 1)))
    }

    @Test
    fun testIsEmptyUniversal(){
        assertFalse("".isUniversal(mapOf('a' to 1, 'b' to 1, 'c' to 1)))
    }
}