package klinkedlistmerge

import java.util.*

fun main() {
	testMerge()
	testResult()
}
fun contendEquals(a: List<Int>, b: List<Int>): Boolean {
	if (a.size != b.size) return false
	a.forEachIndexed { i, item ->
		if (item != b[i]) return false
	}
	return true
}
fun mergeArrays(lists: Array<LinkedList<Int>>): LinkedList<Int> {
	return if (lists.isEmpty())
		LinkedList()
	else if (lists.size == 1)
		lists[0]
	else if (lists.size == 2) {
		merge(lists[0], lists[1])
	} else {
		if (lists.size % 2 != 0) {
			merge(mergeArrays(lists.sliceArray(0..lists.size - 2)), lists[lists.size - 1])
		} else {
			merge(
				mergeArrays(lists.sliceArray(0..lists.size / 2)),
				mergeArrays(lists.sliceArray(lists.size / 2 + 1 until lists.size))
			)
		}
	}
}
fun merge(a: LinkedList<Int>, b: LinkedList<Int>): LinkedList<Int> {
	if (a.isEmpty()) return b
	if (b.isEmpty()) return a
	val result = LinkedList<Int>()
	while (!a.isEmpty() || !b.isEmpty()) {
		if (a.peek() < b.peek())
			result.addLast(a.poll())
		else
			result.addLast(b.poll())
		if (a.isEmpty()) {
			result.addAll(b)
			break
		}
		if (b.isEmpty()) {
			result.addAll(a)
			break
		}
	}
	return result
}
fun testMerge() {
	merge(
		LinkedList(listOf(2, 6, 7, 9)),
		LinkedList(listOf(1, 3, 4))
	)
}
fun testResult() {
	println(contendEquals(mergeArrays(emptyArray()), listOf()))
	println(contendEquals(mergeArrays(arrayOf(LinkedList())), LinkedList()))
	println(contendEquals(mergeArrays(arrayOf(LinkedList(listOf(1, 3, 4)))), listOf(1, 3, 4)))
	println(
		contendEquals(
			mergeArrays(
				arrayOf(
					LinkedList(listOf(2)),
					LinkedList(listOf(1))
				)
			), listOf(1, 2)
		)
	)
	println(
		contendEquals(
			mergeArrays(
				arrayOf(
					LinkedList(listOf(1, 1, 1)),
					LinkedList(listOf(2, 3, 4)),
					LinkedList(listOf(1, 1, 1))
				)
			), listOf(1, 1, 1, 1, 1, 1, 2, 3, 4)
		)
	)
	println(
		contendEquals(
			mergeArrays(
				arrayOf(
					LinkedList(listOf(1, 4, 5)),
					LinkedList(listOf(1, 3, 4)),
					LinkedList(listOf(2, 6))
				)
			), listOf(1, 1, 2, 3, 4, 4, 5, 6)
		)
	)
	println(contendEquals(mergeArrays(generateArray()), genFlat()))
}
/*
fun mergeArraysGlob(lists: Array<LinkedList<Int>>): LinkedList<Int> {
	return if (lists.isEmpty())
		LinkedList()
	else if (lists.size == 1)
		lists[0]
	else {
		val res = LinkedList<Int>()

		var fullSize = 0
		for (list in lists)
			fullSize += list.size

		val cursor = Cursor(0, lists.size)

		while (fullSize > 0) {
			if (lists[cursor.current()].isEmpty())
				cursor.next()
			while (
				!lists[cursor.current()].isEmpty()
				&& isMin(lists[cursor.current()].peek(), lists, cursor.current())
			) {
				res.addLast(lists[cursor.current()].pop())
				fullSize--
			}
			cursor.next()
		}
		res
	}
}

class Cursor(
	private var pos: Int,
	private val mod: Int
) {
	fun current() = pos
	fun next(): Int {
		pos++
		pos %= mod
		return pos
	}
}


fun isMin(item: Int, lists: Array<LinkedList<Int>>, cursor: Int): Boolean {
	for (i in lists.indices) {
		if (lists[i].isEmpty())
			continue
		if (i != cursor && item > lists[i].peek())
			return false
	}
	return true
}
*/
var intArrCounter = 0
var arrCounter = 0

fun generateArray(): Array<LinkedList<Int>> = generateSequence {
	val intArr = LinkedList(generateSequence {
		(intArrCounter++).let {
			if (it >= MAX_INT_ARR_SIZE) {
				intArrCounter = 0
				return@let null
			}
			it
		}
	}.toList())
	(arrCounter++).let {
		if (it >= MAX_ARR_SIZE) return@let null
		intArr
	}
}.toList().toTypedArray()

var intCounter = 0
var extCounter = 0

fun genFlat(): ArrayList<Int> = ArrayList(generateSequence {
	if (extCounter >= MAX_INT_ARR_SIZE)
		return@generateSequence null
	if (intCounter < MAX_ARR_SIZE - 1) {
		intCounter++
		return@generateSequence extCounter
	} else {
		intCounter = 0
		extCounter++
	}
}.toList())