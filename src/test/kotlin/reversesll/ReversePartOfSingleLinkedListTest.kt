package reversesll

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import toHead

class ReversePartOfSingleLinkedListTest {

    @Test
    fun concatLists() {
        val listA = intArrayOf(1,2,3,4,5).toHead()
        val listB = intArrayOf(1,2,3,4,5).toHead()
        val concatenated = ReversePartOfSingleLinkedList().concatLists(listA, listB)
        assertEquals(intArrayOf(1,2,3,4,5,1,2,3,4,5).toHead(), concatenated)
    }

    @Test
    fun getSublist() {
        val lList = intArrayOf(1,2,3,4,5,6,7,8,9,10).toHead()
        val sublist = ReversePartOfSingleLinkedList().getSublist(lList, 3, 7)
        assertEquals(intArrayOf(4,5,6,7).toHead(), sublist)
    }

    @Test
    fun getSublistFullList() {
        val lList = intArrayOf(1,2,3,4,5,6,7,8,9,10).toHead()
        val sublist = ReversePartOfSingleLinkedList().getSublist(lList, 0, 11)
        assertEquals(intArrayOf(1,2,3,4,5,6,7,8,9,10).toHead(), sublist)
        assertEquals(intArrayOf(1,2,3,4,5,6,7,8,9,10).toHead(), lList)
    }

    @Test
    fun getSuffix() {
        val lList = intArrayOf(1,2,3,4,5,6,7,8,9,10).toHead()
        val sublist = ReversePartOfSingleLinkedList().getSublist(lList, 5)
        assertEquals(intArrayOf(6,7,8,9,10).toHead(), sublist)
        assertEquals(intArrayOf(1,2,3,4,5,6,7,8,9,10).toHead(), lList)
    }

    @Test
    fun getSublistFromNull(){
        val sublist = ReversePartOfSingleLinkedList().getSublist(null, 3, 7)
        assertNull(sublist)
    }

    @Test
    fun reverseLinkedList() {
        val head = intArrayOf(1,2,3,4,5).toHead()
        val result = ReversePartOfSingleLinkedList().reverseLinkedList(head, 2, 4)
        assertEquals(intArrayOf(1,4,3,2,5).toHead(), result)
    }

    @Test
    fun reverseLinkedListWith2ElementsWithSameFromAndTo() {
        val head = intArrayOf(1,5).toHead()
        val result = ReversePartOfSingleLinkedList().reverseLinkedList(head, 2, 2)
        assertEquals(intArrayOf(1,5).toHead(), result)
    }

    @Test
    fun reverseLinkedListWith2Elements() {
        val head = intArrayOf(1,5).toHead()
        val result = ReversePartOfSingleLinkedList().reverseLinkedList(head, 1, 2)
        assertEquals(intArrayOf(5,1).toHead(), result)
    }

    @Test
    fun getSuffixWithLastPointer(){
        val head = intArrayOf(1,5).toHead()
        val result = ReversePartOfSingleLinkedList().getSublist(head, 2)
        assertNull(result)
    }
}