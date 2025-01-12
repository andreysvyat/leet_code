package cyclic_sort

fun sort(array: IntArray): IntArray {
    var i = 0
    while (i < array.size) {
        val j = array[i] - 1
        if (array[i] != array[j]) {
            array[i] = array[j].also { array[j] = array[i] }
        } else {
            i++
        }
    }
    return array
}