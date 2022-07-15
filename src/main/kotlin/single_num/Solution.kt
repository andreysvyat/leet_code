package single_num

fun main() {
	val sol = Solution()
	println(sol.singleNumber(intArrayOf(4,1,2,1,2)) == 4)
	println(sol.singleNumber(intArrayOf(2,2,1)) == 1)
	println(sol.singleNumber(intArrayOf(1)) == 1)
}

class Solution {
	fun singleNumber(nums: IntArray): Int {
		var counter = 0
		val numCounter = mutableMapOf<Int, Int>()
		for(num in nums){
			counter++
			if (numCounter.containsKey(num)) {
				numCounter[num] = numCounter[num]!!.plus(1)
			}else{
				numCounter[num] = 1
			}
		}
		var res = 0
		for (pair in numCounter.entries){
			counter++
			if(pair.value == 1){
				res = pair.key
				break
			}
		}
		return res
	}
}