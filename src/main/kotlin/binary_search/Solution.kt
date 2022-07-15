package binary_search

fun main() {
	println(Solution().search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
	println(Solution().search(intArrayOf(-1, 0, 3, 5, 9, 12), 4))
	println(Solution().search(intArrayOf(5), -5))
	println(Solution().search(intArrayOf(2, 5), 2))
}

class Solution {
	fun search(nums: IntArray, target: Int): Int {
		if (nums.isEmpty()) return -1
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
						if (nums[right] == target) return right
						if (nums[left] == target) return left
						if (nums[right] != target && nums[left] != target) return -1
					}
				}
		}
		return currIndex
	}
}