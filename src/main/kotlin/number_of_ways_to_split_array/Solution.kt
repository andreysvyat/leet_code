package number_of_ways_to_split_array

fun waysToSplitArray(nums: IntArray): Int {
    val scan = nums.scan(0) { acc: Long, i -> acc + i }.toLongArray()
    var splitCount = 0
    for (i in 1..scan.size - 2) {
        if (scan[i] >= scan[scan.size - 1] - scan[i])
            splitCount++
    }
    return splitCount;
}