package count_vowel_strings_in_ranges

val VOWEL_LETTERS = "aeiou"

fun vowelStringsAccepted(words: Array<String>, queries: Array<IntArray>): IntArray {
    val prefixSums = calculatePrefixes(words)
    val result = IntArray(queries.size)
    for (id in queries.indices){
        val prefSumL = queries[id][0]
        val prefSumR = queries[id][1]
        result[id] = prefixSums[prefSumR] - if (prefSumL == 0) 0 else prefixSums[prefSumL - 1]
    }
    return result
}

fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
    val init = if (isStartsAndEndsWithVowel(words[0])) 1 else 0
    val prefixSums = words.scan(init) {acc: Int, word: String ->
        if (isStartsAndEndsWithVowel(word)) acc + 1 else acc
    }
    val result = IntArray(queries.size)
    for (id in queries.indices){
        result[id] = calculatePrefixDiff(queries[id], prefixSums)
    }
    return result
}

fun calculatePrefixes(words: Array<String>): IntArray {
    val prefixSums = words.scan(0) {acc: Int, word: String ->
        if (isStartsAndEndsWithVowel(word)) acc + 1 else acc
    }.toIntArray()
    return prefixSums
}

fun calculatePrefixDiff(
    query: IntArray,
    prefixSums: List<Int>
): Int {
    val prefSumL = query[0] + 1
    val prefSumR = query[1] + 1
    return prefixSums[prefSumR] - prefixSums[prefSumL - 1]
}

fun isStartsAndEndsWithVowel(word: String): Boolean {
    val vowelStart = VOWEL_LETTERS.contains(word.first())
    val vowelEnds = VOWEL_LETTERS.contains(word.last())
    return vowelStart && vowelEnds
}