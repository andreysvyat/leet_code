package count_vowel_strings_in_ranges

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class SolutionKtTest {

    companion object {
        val MAPPER = ObjectMapper()
    }

    @Test
    @Disabled("Requires fixes test data")
    fun vowelStringsTestMany() {
        val words = MAPPER.readValue(
            this::class.java.getResourceAsStream("/count_vowel_strings_in_ranges/many_words.json"),
            Array<String>::class.java
        )
        val queries = MAPPER.readValue(
            this::class.java.getResourceAsStream("/count_vowel_strings_in_ranges/many_queries.json"),
            Array<IntArray>::class.java
        )
        val expect = MAPPER.readValue(
            this::class.java.getResourceAsStream("/count_vowel_strings_in_ranges/many_result.json"),
            IntArray::class.java
        )

        assertNotNull(words)
        assertNotNull(queries)

        val result = vowelStrings(words, queries)
        assertArrayEquals(expect, result, "\n${expect.contentToString()}\n${result.contentToString()}\n")
    }

    @Test
    fun vowelStringsTestExample() {
        val result: IntArray = vowelStrings(
            arrayOf("aba", "bcb", "ece", "aa", "e"),
            arrayOf(intArrayOf(0, 2), intArrayOf(1, 4), intArrayOf(1, 1))
        )

        val expect = intArrayOf(2, 3, 0)
        assertArrayEquals(
            expect, result, "\n${expect.contentToString()}\n${result.contentToString()}\n")
    }

    @Test
    fun vowelStringsTestExampleAndLast() {
        val result = vowelStrings(
            arrayOf("aba", "bcb", "ece", "aa", "e"),
            arrayOf(intArrayOf(0, 2), intArrayOf(1, 4), intArrayOf(1, 1), intArrayOf(4, 4))
        )

        val expect = intArrayOf(2, 3, 0, 1)
        assertArrayEquals(expect, result, "\n${expect.contentToString()}\n${result.contentToString()}\n")
    }

    @Test
    fun prefixDiffCalculator() {
        val prefixSums = listOf(1, 2, 2, 3, 4, 5)
        val result = calculatePrefixDiff(intArrayOf(1, 1), prefixSums)

        assertEquals(0, result)
    }

    @Test
    fun testPrefixCalculation() {
        val expect = intArrayOf(0, 1, 1, 2, 3, 4)

        val result = calculatePrefixes(arrayOf("aba", "bcb", "ece", "aa", "e"))

        assertArrayEquals(expect, result, "\n${expect.contentToString()}\n${result.contentToString()}\n")
    }
}