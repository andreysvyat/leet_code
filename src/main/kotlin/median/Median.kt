package median

import java.lang.Integer.*

class Solution {
	fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
		val nums = merge(nums1, nums2)
		return if (nums.size % 2 != 0) nums[(nums.size / 2)] * 1.0
		else (nums[nums.size / 2 - 1] + nums[(nums.size / 2)]) / 2.0
	}

	private fun merge(nums1: IntArray, nums2: IntArray): IntArray{
		if(nums1.isEmpty() && nums2.isEmpty()) throw RuntimeException("Both can't be empty")
		if(nums1.isEmpty()) return nums2
		if(nums2.isEmpty()) return nums1

		val nums = IntArray(nums1.size + nums2.size)
		var i = 0
		var j = 0
		while (i < nums1.size && j < nums2.size) {
			nums[i + j] = min(nums1[i], nums2[j])
			if (nums[i + j] == nums1[i]) i++
			else j++
			if (i == nums1.size) {
				while (j < nums2.size) {
					nums[i + j] = nums2[j]
					j++
				}
			}
			if (j == nums2.size) {
				while (i < nums1.size) {
					nums[i + j] = nums1[i]
					i++
				}
			}
		}
		return nums
	}
}

fun main() {
	println(Solution().findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
	println(Solution().findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
	println(Solution().findMedianSortedArrays(intArrayOf(2, 6, 8), intArrayOf(-3, 2, 5)))
	println(Solution().findMedianSortedArrays(intArrayOf(-3, 2, 5), intArrayOf(2, 6, 8)))
	println(Solution().findMedianSortedArrays(intArrayOf(-3, 2, 5), intArrayOf(4, 2, 6, 8)))
	println(Solution().findMedianSortedArrays(intArrayOf(-3, 2, 5), intArrayOf(-4, 2, 6, 8)))
}

//0 - 0, 1
//1 - 2, 3
//2 - 3, 4
//3 - 5, 6