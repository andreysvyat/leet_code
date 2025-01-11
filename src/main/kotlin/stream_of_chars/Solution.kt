package stream_of_chars

import java.util.concurrent.atomic.AtomicBoolean


/**
 * 1 <= words.length <= 2000
 * 1 <= words\[i].length <= 200
 * words\[i] consists of lowercase English letters.
 * letter is a lowercase English letter.
 * At most 4 * 104 calls will be made to query.
 */
class StreamChecker(words: Array<String>) {
    val trie: TrieNode = buildTrie(words)
    var suffixes: List<TrieNode> = listOf()

    /**
     * checks if a suffix of these characters is a string of a given array of strings words
     */
    fun query(letter: Char): Boolean {
        val extended = suffixes.filter { it.char == letter } + trie.findChildByValue(letter)
        val result = extended
            .filterNotNull()
            .filter { it.char == letter }
            .any { it.isTerminal() }
        suffixes = extended.filterNotNull().flatMap { it.children }

        return result
    }
}

data class TrieNode(
    val char: Char,
    val terminal: AtomicBoolean,
    val children: MutableList<TrieNode>
) {
    constructor(char: Char) : this(char, AtomicBoolean(false), mutableListOf())
    constructor(char: Char, vararg leafs: Char) : this(
        char,
        AtomicBoolean(false),
        leafs.map { TrieNode(it) }.toMutableList()
    )

    fun findChildByValue(char: Char): TrieNode? {
        return children.find { it.char == char }
    }

    fun add(char: Char): TrieNode {
        val newLeaf = TrieNode(char)
        children.add(newLeaf)
        return newLeaf
    }

    fun isTerminal(): Boolean {
        return terminal.get()
    }

    override fun toString(): String {
        return "${char}${if (terminal.get()) "]" else ""}${children.map { it.toString() }.joinToString()}"
    }
}

fun buildTrie(words: Array<String>): TrieNode {
    val root = TrieNode(0.toChar())
    var current = root
    for (word in words) {
        for (c in word) {
            current = current.findChildByValue(c) ?: current.add(c)
        }
        current.terminal.set(true)
        current = root

    }
    return root
}