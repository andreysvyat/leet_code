package reversesll

import common.ListNode

class ReverseSingleLinkedList {
    fun reverse(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head

        var tail: ListNode? = head.next
        var rev = head
        rev.next = null

        while (tail != null) {
            val tmp = tail
            tail = tail.next
            tmp.next = rev
            rev = tmp
        }

        return rev
    }
}