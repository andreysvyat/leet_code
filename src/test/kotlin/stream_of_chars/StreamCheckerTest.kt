package stream_of_chars

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StreamCheckerTest {

    @Test
    fun queryCase1() {
        val checker = StreamChecker(arrayOf("cd", "f", "kl"))
        val result = arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l")
            .map { checker.query(it[0]) }
        assertEquals(
            listOf(false, false, false, true, false, true, false, false, false, false, false, true),
            result
        )
    }

    @Test
    fun queryCase2() {
        val checker = StreamChecker(arrayOf("cd", "f", "kl", "abcdefghijklm"))
        val result = arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m")
            .map { checker.query(it[0]) }
        assertEquals(
            listOf(false, false, false, true, false, true, false, false, false, false, false, true, true),
            result
        )
    }

    @Test
    fun queryCase3() {
        val checker = StreamChecker(
            arrayOf("bcde", "klmn")
        )
        val result = arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "k", "l", "m", "n")
            .map { checker.query(it[0]) }
        assertEquals(
            listOf(
                false, false, false, false, true, false, false, false, false,
                false, false, false, false, false, false, false, true
            ),
            result
        )
    }

    @Test
    fun queryCase31() {
        val checker = StreamChecker(
            arrayOf("bcde", "klmn", "bcfg", "bcfhi")
        )
        val result = arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "k", "l", "m", "n")
            .map { checker.query(it[0]) }
        assertEquals(
            listOf(
                false, false, false, false, true, false, false, false, false,
                false, false, false, false, false, false, false, true
            ),
            result
        )
    }

    @Test
    fun queryCase4() {
        val checker = StreamChecker(
            arrayOf("abc", "abcde", "abcdefg", "abcdefghi", "abcdefghijk", "abcdefghijklm", "abcdefghijklmkl")
        )
        val result = arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "k", "l", "m", "n")
            .map { checker.query(it[0]) }
        assertEquals(
            listOf(
                false, false, true, false, true, false, true, false, true,
                false, true, false, true, false, true, false, false
            ),
            result
        )
    }

    @Test
    fun queryCase5() {
        val checker = StreamChecker(
            arrayOf("abc", "cde", "defg", "efghi", "hijk", "jklm", "lmkl")
        )
        val result = arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "k", "l", "m", "n")
            .map { checker.query(it[0]) }
        assertEquals(
            listOf(
                false, false, true, false, true, false, true, false, true,
                false, true, false, true, false, true, false, false
            ),
            result
        )
    }

    @Test
    fun queryCase6() {
        val checker = StreamChecker(
            Array(2000) { "a".repeat(200) }
        )
        val result = Array(40000) { "a" }.map { checker.query(it[0]) }
        assertEquals(
            List(40000) { it >= 199 },
            result
        )
    }

    @Test
    fun queryCase7() {
        val checker = StreamChecker(
            arrayOf("ab", "ba", "aaab", "abab", "baa")
        )
        val result = arrayOf(
            "a", "a", "a", "a", "a",
            "b", "a", "b", "a", "b",
            "b", "b",
            "a", "b", "a", "b",
            "b", "b", "b",
            "a", "b", "a", "b", "a", "a",
            "a",
            "b", "a", "a",
            "a"
        ).map { checker.query(it[0]) }
        assertEquals(
            listOf(
                false, false, false, false, false,
                true, true, true, true, true,
                false, false,
                true, true, true, true,
                false, false, false,
                true, true, true, true, true, true,
                false,
                true, true, true,
                false
            ),
            result
        )
    }

    @Test
    fun queryCase8() {
        val checker = StreamChecker(
            Array(2000) { "c".repeat(200) } + arrayOf("xyz")
        )
        val result =
            Array(40000) { if (it % 3 == 0) "x" else if (it % 3 == 1) "y" else "z" }.map { checker.query(it[0]) }
        assertEquals(
            List(40000) { it % 3 == 2 },
            result
        )
    }

    @Test
    fun queryCase9() {
        val checker = StreamChecker(
            Array(1999) { "z".repeat(200) } + arrayOf("abcdefghijklmnopqrstuvwxyz")
        )
        val result = Array(40000) {
            ('a' + (it % 26)).toString()
        }.map { checker.query(it[0]) }
        assertEquals(
            List(40000) { it % 26 == 25 },
            result
        )
    }
}