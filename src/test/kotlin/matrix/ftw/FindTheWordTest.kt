package matrix.ftw

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class FindTheWordTest {
    private val testMatrix = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    )

    @Test
    fun testAnnealWordCEDFrom02() {
        val findTheWord = FindTheWord(
            "CED",
            testMatrix
        )
        assertFalse { findTheWord.annealWord(0, 2) }
    }

    @Test
    fun testAnnealWordCEDFrom12() {
        val findTheWord = FindTheWord(
            "CED",
            testMatrix
        )
        assertTrue { findTheWord.annealWord(1, 2) }
    }

    @Test
    fun existABCCED() {
        val findTheWord = FindTheWord(
            "ABCCED",
            testMatrix
        )
        assertTrue { findTheWord.exist() }
    }

    @Test
    fun existSEE() {
        val findTheWord = FindTheWord(
            "SEE",
            testMatrix
        )
        assertTrue { findTheWord.exist() }
    }

    @Test
    fun existABCB() {
        val findTheWord = FindTheWord(
            "ABCB",
            testMatrix
        )
        assertFalse { findTheWord.exist() }
    }

    @Test
    fun findFirstCharAddressesSEE() {
        val findTheWord = FindTheWord(
            "SEE",
            testMatrix
        )
        val actual = findTheWord.getFirstLetterAddresses()
        assertEquals(2, actual.size)
        assertContentEquals(intArrayOf(1, 0), actual[0])
        assertContentEquals(intArrayOf(1, 3), actual[1])
    }

    @Test
    fun findFirstCharAddressesABCB() {
        val findTheWord = FindTheWord(
            "ABCB",
            testMatrix
        )
        val actual = findTheWord.getFirstLetterAddresses()
        assertEquals(2, actual.size)
        assertContentEquals(intArrayOf(0, 0), actual[0])
        assertContentEquals(intArrayOf(2, 0), actual[1])
    }

    @Test
    fun testCheckNextFrom00Left() {
        val findTheWord = FindTheWord(
            "",
            testMatrix
        )
        val actual = findTheWord.getNextLetterAddresses(0, 0, 'B')
        assertEquals(1, actual.size)
        assertContentEquals(intArrayOf(0, 1), actual[0])
    }

    @Test
    fun testCheckNextFrom00Bottom() {
        val findTheWord = FindTheWord(
            "",
            testMatrix
        )
        val actual = findTheWord.getNextLetterAddresses(0, 0, 'S')
        assertEquals(1, actual.size)
        assertContentEquals(intArrayOf(1, 0), actual[0])
    }

    @Test
    fun testCheckNonNextFrom00() {
        val findTheWord = FindTheWord(
            "",
            testMatrix
        )
        val actual = findTheWord.getNextLetterAddresses(0, 0, 'F')
        assertEquals(0, actual.size)
    }

    @Test
    fun testCheckNextFrom11Top() {
        val findTheWord = FindTheWord(
            "",
            testMatrix
        )
        val actual = findTheWord.getNextLetterAddresses(0, 0, 'B')
        assertEquals(1, actual.size)
        assertContentEquals(intArrayOf(0, 1), actual[0])
    }

    @Test
    fun testCheckNextFrom11Wright() {
        val findTheWord = FindTheWord(
            "",
            testMatrix
        )
        val actual = findTheWord.getNextLetterAddresses(1, 1, 'C')
        assertEquals(1, actual.size)
        assertContentEquals(intArrayOf(1, 2), actual[0])
    }

    @Test
    fun testCheckNextFrom11Bottom() {
        val findTheWord = FindTheWord(
            "",
            testMatrix
        )
        val actual = findTheWord.getNextLetterAddresses(1, 1, 'D')
        assertEquals(1, actual.size)
        assertContentEquals(intArrayOf(2, 1), actual[0])
    }

    @Test
    fun testCheckNextFrom11Left() {
        val findTheWord = FindTheWord(
            "",
            testMatrix
        )
        val actual = findTheWord.getNextLetterAddresses(1, 1, 'S')
        assertEquals(1, actual.size)
        assertContentEquals(intArrayOf(1, 0), actual[0])
    }

    @Test
    fun testCheckNotNextFrom11() {
        val findTheWord = FindTheWord(
            "",
            testMatrix
        )
        val actual = findTheWord.getNextLetterAddresses(1, 1, 'E')
        assertEquals(0, actual.size)
    }

    @Test
    fun testCheckNextFrom03() {
        val findTheWord = FindTheWord(
            "",
            testMatrix
        )
        val actual = findTheWord.getNextLetterAddresses(0, 3, 'S')
        assertEquals(1, actual.size)
        assertContentEquals(intArrayOf(1, 3), actual[0])
    }

    @Test
    fun testCheckNotNextFrom03() {
        val findTheWord = FindTheWord(
            "",
            testMatrix
        )
        val actual = findTheWord.getNextLetterAddresses(0, 3, 'Y')
        assertEquals(0, actual.size)
    }

    @Test
    fun testCheckNotNextFrom13() {
        val findTheWord = FindTheWord(
            "",
            testMatrix
        )
        val actual = findTheWord.getNextLetterAddresses(1, 3, 'E')
        assertEquals(2, actual.size)
        assertContentEquals(intArrayOf(0, 3), actual[0])
        assertContentEquals(intArrayOf(2, 3), actual[1])
    }
}