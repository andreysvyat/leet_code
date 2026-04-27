package string.lswrc

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.randomString
import kotlin.time.Duration.Companion.seconds
import kotlin.time.measureTimedValue

class LongestNoisySubstringBrutefoceTest {
    @Test
    fun getLengthOfabcabcbb() {
        val actual = getLongestNoisySubstring("abcabcbb").getLength()
        val expected = 3
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfbbbbb() {
        val actual = getLongestNoisySubstring("bbbbb").getLength()
        val expected = 1
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfpwwkew() {
        val actual = getLongestNoisySubstring("pwwkew").getLength()
        val expected = 3
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfau() {
        val actual = getLongestNoisySubstring("au").getLength()
        val expected = 2
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfdvdf() {
        val actual = getLongestNoisySubstring("dvdf").getLength()
        val expected = 3
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfasdfpnvqwnbiewlvmopqelvoaisdfjdfpqionfmsdlkfoiqwfnlvnpaoijfn() {
        val actual = getLongestNoisySubstring("asdfpnvqwnbiewlvmopqelvoaisdfjdfpqionfmsdlkfoiqwfnlvnpaoijfn").getLength()
        val expected = 12
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfSpace() {
        val actual = getLongestNoisySubstring(" ").getLength()
        val expected = 1
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfEmptyString() {
        val actual = getLongestNoisySubstring("").getLength()
        val expected = 0
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfMaxLength() {
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 !\"#\$%&'()*+,-./:;<=>?@[\\]^_`{|}~"
        val worker = LongestNoisySubstring(randomString(50000, alphabet))
        val result = measureTimedValue { worker.getLength() }
        println(result.value)
        assertTrue { result.duration < 1.seconds }
    }

    private fun getLongestNoisySubstring(str: String): LongestNoisySubstringBruteforce =
        LongestNoisySubstringBruteforce(str)
}