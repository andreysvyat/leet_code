package find_lost_number

fun missingNumber(nums: IntArray): Int {
    var i = 0
    val n = nums.size
    while (i < n) {
        val j = nums[i]
        if (j < n && nums[i] != nums[j]) {
            nums[i] = nums[j].also { nums[j] = nums[i] }
        } else {
            i++
        }
    }

    for (j in 0..<n){
        if (j != nums[j]){
            return j
        }
    }
    return n
}