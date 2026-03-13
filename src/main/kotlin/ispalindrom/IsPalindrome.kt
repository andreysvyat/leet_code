package ispalindrom

import common.ListNode

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null || head.next == null) return true

        val slow = getSecondPart(head)
        val prev: ListNode? = reverse(slow)
        return areListEquals(head, prev)
    }

    fun getSecondPart(head: ListNode?): ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head?.next

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }

    fun areListEquals(a: ListNode?, b: ListNode?): Boolean {
        var pA = a
        var pB = b
        while (pB != null) {
            if(pA?.`val` != pB.`val`) return false
            pA = pA.next
            pB = pB.next
        }
        return true
    }

    fun reverse(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr: ListNode? = head?.next
        head?.next = null
        var temp: ListNode?

        while (curr != null) {
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        }
        return prev
    }
}