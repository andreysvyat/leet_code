package reversesll

import common.ListNode

class ReversePartOfSingleLinkedList {
    fun reverseLinkedList(head: ListNode?, from: Int, to: Int): ListNode? {
        if(head?.next == null || from == to) return head

        val suffix = getSublist(head, to)
        val reversePart = getSublist(head, from - 1, to)
        val prefix = getSublist(head, 0, from - 1)
        val resultPrefix = concatLists(prefix, ReverseSingleLinkedList().reverse(reversePart))
        return concatLists(resultPrefix, suffix)
    }

    fun concatLists(listA: ListNode?, listB: ListNode?): ListNode? {
        if (listA == null && listB == null) return null
        if (listA == null) return listB
        if (listB == null) return listA
        var current: ListNode = listA
        while (current.next != null) {
            current = current.next!!
        }
        current.next = listB
        return listA
    }

    fun getSublist(head: ListNode?, from: Int, to: Int): ListNode? {
        if (head == null) return null
        var count = 0
        var current = head
        var result: ListNode? = null
        var rCurr = result
        while (count < to) {
            if (count == from) {
                result = current
                rCurr = current
            }
            if (count > from){
                rCurr = rCurr?.next
            }
            if (count == to - 1) {
                rCurr?.next = null
            }
            current = current?.next
            count++
        }
        return result
    }

    fun getSublist(head: ListNode?, from: Int): ListNode? {
        if (head == null) return null
        var count = 0
        var current = head
        while (current != null && count <= from) {
            if(count == from) {
                return current
            }
            current = current.next
            count++
        }
        return current
    }
}