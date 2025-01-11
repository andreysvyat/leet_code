package ispalindrom

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SolutionTest {

    @Test
    fun testIsPalindromeCase1() {
        val head = intArrayOf(1, 2, 2, 1).toHead()
        assertTrue { Solution().isPalindrome(head) }
    }

    @Test
    fun testIsPalindromeCase2() {
        val head = intArrayOf(
            1,2,2,1,5,7,5,3,8,9,0,6,5,9,6,9,2,1,3,0,8,8,4,8,9,0,3,5,6,8,9,0,1,3,
            2,1,0,9,8,6,5,3,0,9,8,4,8,8,0,3,1,2,9,6,9,5,6,0,9,8,3,5,7,5,1,2,2,1
        ).toHead()
        assertFalse { Solution().isPalindrome(head) }
    }

    @Test
    fun testIsPalindromeCase21() {
        val head = intArrayOf(
            1,2,2,1,5,7,5,3,8,9,0,6,5,9,6,9,2,1,3,0,8,8,4,8,9,0,3,5,6,8,9,0,1,2,
            2,1,0,9,8,6,5,3,0,9,8,4,8,8,0,3,1,2,9,6,9,5,6,0,9,8,3,5,7,5,1,2,2,1
        ).toHead()
        assertTrue { Solution().isPalindrome(head) }
    }

    @Test
    fun testIsPalindromeCase22() {
        val head = intArrayOf(
            1,2,2,1,5,7,5,3,8,9,0,6,5,9,6,9,2,1,3,0,8,8,4,8,9,0,3,5,6,8,9,0,1,2,
            5,
            2,1,0,9,8,6,5,3,0,9,8,4,8,8,0,3,1,2,9,6,9,5,6,0,9,8,3,5,7,5,1,2,2,1
        ).toHead()
        assertTrue { Solution().isPalindrome(head) }
    }

    @Test
    fun testIsPalindromeCase3() {
        val head = intArrayOf(
            1, 2, 3, 4, 2, 1
        ).toHead()
        assertFalse { Solution().isPalindrome(head) }
    }

    @Test
    fun testIsPalindromeCase4() {
        val head = intArrayOf(
            1, 2, 3, 4, 2, 1
        ).toHead()
        assertFalse { Solution().isPalindrome(head) }
    }
}

fun IntArray.toHead(): ListNode {
    val nodes = this.map { ListNode(it) }
    nodes.reduce { acc, current ->
        acc.next = current
        return@reduce current
    }
    return nodes[0]
}