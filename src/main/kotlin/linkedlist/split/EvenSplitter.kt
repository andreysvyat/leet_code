package linkedlist.split

import common.ListNode

class EvenSplitter(
    private val head: ListNode?,
    private val parts: Int
) {
    fun getPartLength(): IntArray {
        if(head == null){
            return IntArray(parts)
        }
        val listLength = head.length()
        val avgPartsLength = listLength / parts
        val partsLenArray = IntArray(parts)
        if (avgPartsLength == 0) {
            var i = 0
            while (i < listLength){
                partsLenArray[i] = 1
                i++
            }
        } else {
            var extendingCountDown = listLength - avgPartsLength * parts
            for (i in 0..<parts) {
                if(extendingCountDown > 0){
                    partsLenArray[i] = avgPartsLength + 1
                } else {
                    partsLenArray[i] = avgPartsLength
                }
                extendingCountDown--
            }
        }
        return partsLenArray
    }

    fun splitHeadToParts() : Array<ListNode?> {
        val partLengths = getPartLength()
        var listPointer = head
        var listStartPointer = head
        val result = Array<ListNode?>(parts) {_ -> null}
        var i = 0
        while (i < parts){
            var j = partLengths[i]
            while (j > 1){
                j--
                listPointer = listPointer?.next
            }
            val tmp = listPointer?.next
            listPointer?.next = null
            result[i] = listStartPointer
            listPointer = tmp
            listStartPointer = tmp
            i++
        }
        return result
    }
}

fun ListNode.length(): Int {
    var counter = 0
    var current: ListNode? = this
    while (current != null) {
        counter++
        current = current.next
    }
    return counter
}