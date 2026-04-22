package yacoder.dictionary

class SplitterByDictionary(
    private val sentence: String,
    dictionary: Array<out String>
) {
    private val trie: Trie = Trie()

    init {
        for (word in dictionary) {
            trie.add(word)
        }
    }

    fun getSentenceWithSpaces(): String {
        return getWords(sentence).joinToString(" ")
    }

    private fun getWords(sentence: String): List<String> {
        var pointer = 0
        var current = trie
        val words = mutableListOf<String>()
        while (pointer < sentence.length) {
            val c = sentence[pointer]
            current = current.getSubtrieFor(c) ?: return words
            if (current.isEndOfWord()) {
                val nextSentence = sentence.substring(pointer + 1)
                if (nextSentence.isEmpty()) {
                    return listOf(sentence)
                }
                val nextWords = getWords(nextSentence)
                if (nextWords.isNotEmpty()) {
                    words.add(sentence.substring(0, pointer + 1))
                    words.addAll(nextWords)
                }
            }
            pointer++
        }
        return words
    }
}