package yacoder.pmq

class BruteForceMaxDifference(
    val matrix: Array<String>
) {
    fun maxDifference(): Int {
        return matrix
            .getUndefinedSigns()
            .toList()
            .powerSet()
            .maxOfOrNull { DefinedMatrix(matrix, it.toTypedArray()).maxRowSumDifferenceToMinColSum() }!!
    }
}

fun <T> Collection<T>.powerSet(): Sequence<Set<T>> = sequence {
    val elements = this@powerSet.toList()

    if (elements.isEmpty()) {
        yield(emptySet())
        return@sequence
    }

    val head = elements.first()
    val restPowerSet = elements.drop(1).powerSet()

    for (subset in restPowerSet) {
        yield(subset)           // подмножества без head
        yield(subset + head)    // подмножества с head
    }
}