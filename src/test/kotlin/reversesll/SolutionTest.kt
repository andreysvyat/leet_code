package reversesll

import common.ListNode
import toHead
import kotlin.test.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun reverse() {
        val testData = intArrayOf(1,2,3,4,5).toHead()
        val reversed = ReverseSingleLinkedList().reverse(testData)
        val expected = intArrayOf(5,4,3,2,1).toHead()
        assertEquals(expected, reversed)
    }

    @Test
    fun reverseEmpty() {
        val testData = null
        val reversed = ReverseSingleLinkedList().reverse(testData)
        val expected = null
        assertEquals(expected, reversed)
    }

    @Test
    fun reverseSingle() {
        val testData = ListNode(1)
        val reversed = ReverseSingleLinkedList().reverse(testData)
        val expected = ListNode(1)
        assertEquals(expected, reversed)
    }
}