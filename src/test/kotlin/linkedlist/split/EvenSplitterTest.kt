package linkedlist.split

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import toHead

class EvenSplitterTest {

    @Test
    fun getPartLengthFor7() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val given = arr.toHead()
        val splitter = EvenSplitter(given, 3)

        assertArrayEquals(intArrayOf(3, 2, 2), splitter.getPartLength())
    }

    @Test
    fun getPartLengthFor6() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6)
        val given = arr.toHead()
        val splitter = EvenSplitter(given, 3)

        assertArrayEquals(intArrayOf(2, 2, 2), splitter.getPartLength())
    }

    @Test
    fun getPartsForHeadLenLessThanPartsCount() {
        val arr = intArrayOf(1, 2, 3)
        val given = arr.toHead()
        val splitter = EvenSplitter(given, 5)

        assertArrayEquals(intArrayOf(1, 1, 1, 0, 0), splitter.getPartLength())
    }

    @Test
    fun getPartsForNullHead() {
        val splitter = EvenSplitter(null, 5)

        assertArrayEquals(intArrayOf(0, 0, 0, 0, 0), splitter.getPartLength())
    }

    @Test
    fun getPartLensForSingleItem() {
        val splitter = EvenSplitter(ListNode(1), 5)
        assertArrayEquals(intArrayOf(1, 0, 0, 0, 0), splitter.getPartLength())
    }

    @Test
    fun get3PartLengthsFor5List() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        val given = arr.toHead()
        val splitter = EvenSplitter(given, 3)

        assertArrayEquals(intArrayOf(2, 2, 1), splitter.getPartLength())
    }

    @Test
    fun splitList7To3Parts() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val given = arr.toHead()
        val splitter = EvenSplitter(given, 3)

        assertArrayEquals(
            arrayOf(intArrayOf(1, 2, 3).toHead(), intArrayOf(4, 5).toHead(), intArrayOf(6, 7).toHead()),
            splitter.splitHeadToParts()
        )
    }

    @Test
    fun splitList6To3Parts() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6)
        val given = arr.toHead()
        val splitter = EvenSplitter(given, 3)

        assertArrayEquals(
            arrayOf(intArrayOf(1, 2).toHead(), intArrayOf(3, 4).toHead(), intArrayOf(5, 6).toHead()),
            splitter.splitHeadToParts()
        )
    }

    @Test
    fun splitList1To5Parts() {
        val arr = intArrayOf(1)
        val given = arr.toHead()
        val splitter = EvenSplitter(given, 5)

        assertArrayEquals(
            arrayOf(intArrayOf(1).toHead(), null, null, null, null),
            splitter.splitHeadToParts()
        )
    }

    @Test
    fun splitList3To5Parts() {
        val arr = intArrayOf(1, 2, 3)
        val given = arr.toHead()
        val splitter = EvenSplitter(given, 5)

        assertArrayEquals(
            arrayOf(intArrayOf(1).toHead(), intArrayOf(2).toHead(), intArrayOf(3).toHead(), null, null),
            splitter.splitHeadToParts()
        )
    }

    @Test
    fun splitList5To3Parts() {
        val arr = intArrayOf(0, 1, 2, 3, 4)
        val given = arr.toHead()
        val splitter = EvenSplitter(given, 3)
        val expected = arrayOf(intArrayOf(0, 1).toHead(), intArrayOf(2, 3).toHead(), intArrayOf(4).toHead())
        val actual = splitter.splitHeadToParts()

        assertArrayEquals(expected, actual)
    }
}