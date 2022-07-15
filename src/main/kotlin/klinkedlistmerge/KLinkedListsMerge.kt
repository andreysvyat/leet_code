package klinkedlistmerge

fun main() {
	Solution().printMerges()
	testMergeKLlist()
}

fun testMergeKLlist() {
	println(
		Solution().mergeKLists(
			arrayOf(
				toLList(1, 4, 5),
				toLList(1, 3, 4),
				toLList(2, 6)
			)
		)
	)
}

class ListNode(var `val`: Int) {
	var next: ListNode? = null

	override fun toString() = with(this) {
		if (next == null)
			return@with "$`val`"
		var res = "$`val`->"
		var curr = next!!
		while (!curr.isLast()) {
			res = "$res${curr.`val`}->"
			curr = curr.next!!
		}
		"$res${curr.`val`}"
	}
}

class Solution {
	fun mergeKLists(lists: Array<ListNode?>): ListNode? {
		return if (lists.isEmpty())
			null
		else if (lists.size == 1)
			lists[0]
		else if (lists.size == 2) {
			merge(lists[0], lists[1])
		} else {
			if (lists.size % 2 != 0) {
				merge(mergeKLists(lists.sliceArray(0..lists.size - 2)), lists[lists.size - 1])
			} else {
				merge(
					mergeKLists(lists.sliceArray(0..lists.size / 2)),
					mergeKLists(lists.sliceArray(lists.size / 2 + 1 until lists.size))
				)
			}
		}
	}

	private fun merge(a: ListNode?, b: ListNode?): ListNode? {
		if (a == null && b == null)
			return null
		if(a == null)
			return b
		if(b == null)
			return a
		var cA = a!!
		var cB = b!!
		val result = ListNode(0)
		var cR = result
		while (true) {
			if (cA < cB) {
				cR.next = cA.copy()
				cR = cR.next!!
				if (cA.isLast()) {
					cR.next = cB
					break
				}
				cA = cA.next!!
			} else {
				cR.next = cB.copy()
				cR = cR.next!!
				if (cB.isLast()) {
					cR.next = cA
					break
				}
				cB = cB.next!!
			}
			if(cA.isLast() && cB.isLast()){
				cR.next = minOf(cA, cB).copy()
				cR = cR.next!!
				cR.next = maxOf(cA,cB).copy()
				break
			}
		}
		return result.next
	}

	fun printMerges() {
		println(
			this.merge(
				toLList(2, 6, 7, 9),
				toLList(1, 3, 4)
			)
		)
		println(
			Solution().merge(
				toLList(1, 2, 3, 4, 5),
				toLList(1, 2, 3, 4, 5)
			)
		)
		println(
			Solution().merge(
				toLList(1),
				toLList(1)
			)
		)
		println(
			Solution().merge(
				toLList(),
				toLList()
			)
		)
	}
}

operator fun ListNode.compareTo(other: ListNode): Int = this.`val`.compareTo(other.`val`)
fun ListNode.copy() = ListNode(this.`val`)
fun ListNode.isLast() = this.next == null
fun minOf(a: ListNode, b: ListNode): ListNode = if (a <= b) a else b
fun maxOf(a: ListNode, b: ListNode): ListNode = if (a > b) a else b

fun ListNode.next() = ListNode(this.next!!.`val`)


fun toLList(vararg item: Int): ListNode? {
	if (item.isEmpty()) return null
	val result = ListNode(item[0])
	var curr = result
	for (i in 1..item.lastIndex) {
		curr.next = ListNode(item[i])
		curr = curr.next!!
	}
	return result
}

const val MAX_INT_ARR_SIZE = 500
const val MAX_ARR_SIZE = 10000