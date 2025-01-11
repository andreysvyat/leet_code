package linked_list_cycle

fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    while (fast != null && fast.next != null){
        fast = fast.next!!.next
        slow = slow!!.next
        if(slow == fast){
            return true
        }
    }
    return false
}

data class ListNode(
    var `val`: Int,
    var next: ListNode?
){
    constructor(`val`: Int): this(`val`, null)

    override fun toString(): String {
        return "${`val`}"
    }
}