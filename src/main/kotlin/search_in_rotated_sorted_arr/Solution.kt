package search_in_rotated_sorted_arr

fun main() {
	val sol = Solution()
	println(sol.search(intArrayOf(5, 4), 5))
	println(sol.search(intArrayOf(5, 6, 7), 6))
	println(sol.search(intArrayOf(5, 6, 7, 0, 1, 2), 1))
	println(sol.search(intArrayOf(), 5))
	println(sol.search(intArrayOf(5), 5))
	println(sol.search(intArrayOf(5), 4))
	println(sol.search(intArrayOf(2, 5, 6, 0, 1, 2), 3))
	println(sol.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
}

class Solution {
	fun search(nums: IntArray, target: Int): Int {
		for(i in nums.indices){
			if(nums[i] == target)
				return i
		}
		return -1
	}
}
