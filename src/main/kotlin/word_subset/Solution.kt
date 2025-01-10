package word_subset

import kotlin.math.max

fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
    val maxFreq = words2.calculateMaxFrequency()
    return words1.filter { it.isUniversal(maxFreq) }
}

fun String.isSubset(of: String): Boolean {
    val ofMap = of.toCharArray().groupBy { c -> c }
    val thisMap = this.toCharArray().groupBy { c -> c }

    return thisMap.all { e -> ofMap[e.key] != null && (ofMap[e.key]!!.size >= e.value.size) }
}

fun String.toFrequencyMap(): Map<Char, Int> {
    return this.groupBy { c -> c }.map { e -> e.key to e.value.size }.toMap()
}

fun String.isUniversal(maxFreq: Map<Char, Int>): Boolean {
    val frequencyMap = this.toFrequencyMap()
    return maxFreq.all { e -> frequencyMap[e.key] != null && frequencyMap[e.key]!! >= e.value }
}

fun Array<String>.calculateMaxFrequency(): Map<Char, Int> {
    return this.fold(mutableMapOf()) { acc, s ->
        val fM = s.toFrequencyMap()
        fM.forEach { c, f -> acc.compute(c) { mc, mf -> max(mf ?: 0, f) } }
        return@fold acc
    }
}