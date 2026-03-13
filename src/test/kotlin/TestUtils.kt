import common.ListNode

fun arrayAssertionMessage(expect: IntArray, actual: IntArray): String {
    return "\n${actual.contentToString()} but expected\n${expect.contentToString()}\n"
}



fun IntArray.toHead(): ListNode {
    val nodes = this.map { ListNode(it) }
    nodes.reduce { acc, current ->
        acc.next = current
        return@reduce current
    }
    return nodes[0]
}