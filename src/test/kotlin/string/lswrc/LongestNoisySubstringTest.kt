package string.lswrc

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.randomString
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.time.measureTimedValue

class LongestNoisySubstringTest {
    @Test
    fun getLengthOfabcabcbb() {
        val actual = LongestNoisySubstring("abcabcbb").getLength()
        val expected = 3
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfbbbbb() {
        val actual = LongestNoisySubstring("bbbbb").getLength()
        val expected = 1
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfpwwkew() {
        val actual = LongestNoisySubstring("pwwkew").getLength()
        val expected = 3
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfasdfpnvqwnbiewlvmopqelvoaisdfjdfpqionfmsdlkfoiqwfnlvnpaoijfn() {
        val actual = LongestNoisySubstring("asdfpnvqwnbiewlvmopqelvoaisdfjdfpqionfmsdlkfoiqwfnlvnpaoijfn").getLength()
        val expected = 9
        assertEquals(expected, actual)
    }

    @Test
    fun getLengthOfMaxLength() {
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 !\"#\$%&'()*+,-./:;<=>?@[\\]^_`{|}~"
        val worker = LongestNoisySubstring(randomString(50000, alphabet))
        val result = measureTimedValue { worker.getLength() }
        println(result.value)
        assertTrue { result.duration < 10.seconds }
    }
}