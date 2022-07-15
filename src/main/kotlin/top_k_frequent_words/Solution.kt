package top_k_frequent_words

fun main() {
	val sol = Solution()
	println(
		sol.topKFrequent(arrayOf(), 2) ==
				emptyList<String>()
	)
	println(
		sol.topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 2) ==
				listOf("i", "love")
	)
	println(
		sol.topKFrequent(arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"), 4) ==
				listOf("the", "is", "sunny", "day")
	)
	println(
		sol.topKFrequent(arrayOf("a", "aa", "aaa", "aaaa", "aaaaa"), 3) ==
				listOf("aaaaa", "aaaa", "aaa")
	)
}

class Solution {
	fun topKFrequent(words: Array<String>, k: Int): List<String> {
		if (words.isEmpty())
			return emptyList()
		val occurrence = hashMapOf<String, Int>()
		for (word in words) {
			occurrence[word] = (occurrence[word] ?: 0) + 1
		}
		val result = occurrence.entries.sortedWith(
			compareBy(
				{ it.value },
				{ it.key }
			)
		).map { it.key }.reversed()
		return result.subList(0, k)
	}
}