package linked_list_cycle

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SolutionKtTest {
    @Test
    fun case1(){
        val cycleTarget = ListNode(2)
        val end = ListNode(-4, cycleTarget)
        cycleTarget.next = ListNode(0, end)
        val root = ListNode(3, cycleTarget)

        assertTrue(hasCycle(root))
    }
}