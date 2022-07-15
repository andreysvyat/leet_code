package search_in_rotated_sorted_arr_ii

fun main() {
	val sol = Solution()
	println(sol.search(intArrayOf(5, 6, 7, 0, 0, 1, 2, 3), 5))
	println(sol.search(intArrayOf(5, 6, 7, 0), 5))
	println(sol.search(intArrayOf(5, 6, 7), 5))
	println(sol.search(intArrayOf(5, 5, 5), 5))
	println(sol.search(intArrayOf(), 5))
	println(sol.search(intArrayOf(5), 5))
	println(sol.search(intArrayOf(2,5,6,0,0,1,2), 3))
}

class Solution {
	fun search(nums: IntArray, target: Int): Boolean {
		if (nums.isEmpty())
			return false
		val pivot = findPivot(nums, target)
		if (pivot == -1)
			return true
		return binarySearch(nums.sliceArray(pivot until nums.size), target)
	}

	private fun findPivot(nums: IntArray, target: Int): Int = with(nums) {
		for (i in 0..this.size) {
			if (target == nums[i])
				return@with -1
			val curr = i % this.size
			val next = (i + 1) % this.size
			if (nums[curr] > nums[next])
				return@with next
		}
		return@with 0
	}

	private fun binarySearch(nums: IntArray, target: Int): Boolean {
		var left = 0
		var right = nums.size - 1
		var currIndex = nums.size / 2
		while (nums[currIndex] != target) {
			if (nums[currIndex] < target) {
				left = currIndex
				currIndex += (right - left) / 2
			} else
				if (nums[currIndex] > target) {
					right = currIndex
					currIndex -= (right - left) / 2
				} else {
					if (right - left <= 1) {
						if (nums[right] == target) return true
						if (nums[left] == target) return true
						if (nums[right] != target && nums[left] != target) return false
					}
				}
		}
		return true
	}
}
