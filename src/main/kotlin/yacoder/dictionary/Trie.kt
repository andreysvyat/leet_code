package yacoder.dictionary

class Trie(private val root: TrieNode) {

    constructor(): this(TrieNode(' ', mutableSetOf()))

    fun add(word: String): Boolean {
        var current = root
        for (c in word) {
            if (!current.contains(c)) {
                val newNode = TrieNode(c, mutableSetOf())
                current.children.add(newNode)
                current = newNode
            } else {
                current = current.getChild(c)
            }
        }
        current.isEndOfWord = true
        return true
    }

    fun findPrefix(word: String): TrieNode {
        var wordPointer = 0
        var current = root
        while (!current.children.isEmpty()) {
            current = current.children.find { node -> node.char == word.elementAt(wordPointer) } ?: return current
            wordPointer++
        }
        return current
    }

    fun getSubtrieFor(char: Char): Trie? {
        return root.children.find { node -> node.char == char }?.let { Trie(it) }
    }

    fun isEndOfWord() = root.isEndOfWord

    override fun equals(other: Any?): Boolean {
        return (this === other) || (other is Trie && root == other.root)
    }

    override fun toString(): String {
        return root.toString()
    }

    override fun hashCode(): Int {
        return root.hashCode()
    }
}

data class TrieNode(
    val char: Char,
    val children: MutableSet<TrieNode>,
    var isEndOfWord: Boolean
) {
    constructor(char: Char, children: MutableSet<TrieNode>) : this(char, children, false)

    fun contains(char: Char): Boolean {
        return children.any { node -> node.char == char }
    }

    fun getChild(char: Char): TrieNode {
        return children.find { node -> node.char == char }!!
    }

    override fun hashCode(): Int {
        return char.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return other is TrieNode &&
                other.char == char &&
                other.children == children &&
                other.isEndOfWord == isEndOfWord
    }

    override fun toString(): String {
        return buildString {
            append(char)
            if (children.isNotEmpty()) {
                val sortedChildren = children.sortedBy { it.char }
                for ((index, child) in sortedChildren.withIndex()) {
                    val isLast = index == sortedChildren.lastIndex
                    append("\n")
                    appendChild(child, "", isLast)
                }
            }
        }
    }

    private fun StringBuilder.appendChild(node: TrieNode, prefix: String, isLast: Boolean) {
        val connector = if (isLast) "└──" else "├──"
        append(prefix + connector + node.char)
        if (node.isEndOfWord) append("<")

        if (node.children.isNotEmpty()) {
            val newPrefix = prefix + if (isLast) "   " else "│  "
            val sortedChildren = node.children.sortedBy { it.char }
            for ((index, child) in sortedChildren.withIndex()) {
                val childIsLast = index == sortedChildren.lastIndex
                append("\n")
                appendChild(child, newPrefix, childIsLast)
            }
        }
    }
}