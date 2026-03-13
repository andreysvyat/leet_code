package linked_list_cycle

import common.ListNode

fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    while (fast?.next != null){
        fast = fast.next!!.next
        slow = slow!!.next
        if(slow == fast){
            return true
        }
    }
    return false
}