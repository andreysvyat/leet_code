package min_size_sub_array

import kotlin.math.min

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    val scan = nums.scan(0) { acc, i -> acc + i }.toIntArray()
    var size = nums.size + 1
    for (start in 0..nums.size) {
        var l = 0
        var r = nums.size - 1
        var end = -1
        while (l <= r) {
            val mid = (l + r) / 2
            if (scan[mid + 1] - scan[start] >= target) {
                end = mid
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        if (end != -1) size = min(size, end - start + 1)
    }
    return if (size <= nums.size) size else 0
}

fun minSubArrayLenSlidingWindow(target: Int, nums: IntArray): Int {
    var l = 0
    var size = nums.size + 1
    var sum = 0
    for (r in 0..<nums.size){
        sum += nums[r]
        println("(${l}, ${r}) ${nums.slice(l..r)} ${sum}")
        while (sum >= target){
            size = min(size, r - l + 1)
            sum -= nums[l]
            l++
        }
    }
    return if (size <= nums.size) size else 0
}