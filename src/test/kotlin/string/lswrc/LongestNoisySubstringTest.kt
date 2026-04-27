package string.lswrc

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.randomString
import kotlin.time.Duration.Companion.seconds
import kotlin.time.measureTimedValue

class LongestNoisySubstringTest {
    @Test
    fun getLengthOfabcabcbb() {
        val str = "abcabcbb"
        val actual = getLongestNoisySubstring(str).getLength()
        val expected = getBrutefoceSolution(str).getLength()
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfbbbbb() {
        val str = "bbbbb"
        val actual = getLongestNoisySubstring(str).getLength()
        val expected = getBrutefoceSolution(str).getLength()
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfpwwkew() {
        val str = "pwwkew"
        val actual = getLongestNoisySubstring(str).getLength()
        val expected = getBrutefoceSolution(str).getLength()
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfau() {
        val str = "au"
        val actual = getLongestNoisySubstring(str).getLength()
        val expected = getBrutefoceSolution(str).getLength()
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfdvdf() {
        val str = "dvdf"
        val actual = getLongestNoisySubstring(str).getLength()
        val expected = getBrutefoceSolution(str).getLength()
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfasdfpnvqwnbiewlvmopqelvoaisdfjdfpqionfmsdlkfoiqwfnlvnpaoijfn() {
        val str = "asdfpnvqwnbiewlvmopqelvoaisdfjdfpqionfmsdlkfoiqwfnlvnpaoijfn"
        val actual = getLongestNoisySubstring(str).getLength()
        val expected = getBrutefoceSolution(str).getLength()
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfSpace() {
        val actual = getLongestNoisySubstring(" ").getLength()
        val expected = getBrutefoceSolution(" ").getLength()
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfEmptyString() {
        val actual = getLongestNoisySubstring("").getLength()
        val expected = getBrutefoceSolution("").getLength()
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfMaxLength() {
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 !\"#\$%&'()*+,-./:;<=>?@[\\]^_`{|}~"
        val string = randomString(50000, alphabet)
        val worker = LongestNoisySubstring(string)
        val result = measureTimedValue { worker.getLength() }
        val expected = getBrutefoceSolution(string).getLength()
        assertTrue { result.duration < 10.seconds }
        assertEquals(expected, result.value)
    }

    private fun getLongestNoisySubstring(str: String): LongestNoisySubstring =
        LongestNoisySubstring(str)

    private fun getBrutefoceSolution(str: String): LongestNoisySubstringBruteforce = LongestNoisySubstringBruteforce(str)
}