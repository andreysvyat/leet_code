package yacoder.dictionary

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TrieNodeTest {
    @Test
    fun toStringTest() {
        val trieNode = TrieNode(
            'w',
            mutableSetOf(
                TrieNode(
                    'o',
                    mutableSetOf(
                        TrieNode(
                            'r',
                            mutableSetOf(
                                TrieNode('d',mutableSetOf(), true),
                                TrieNode('k', mutableSetOf(), true)
                            )
                        ),
                        TrieNode(
                            'l',
                            mutableSetOf(
                                TrieNode('k', mutableSetOf(), true)
                            )
                        )
                    )
                )
            )
        )

        assertEquals(
            """
                w
                └──o
                   ├──l
                   │  └──k<
                   └──r
                      ├──d<
                      └──k<""".trimIndent(),
            trieNode.toString()
        )
    }

    @Test
    fun nodeContainsTest() {
        val trieNode = TrieNode(' ', mutableSetOf(
            TrieNode('a', mutableSetOf(TrieNode('e', mutableSetOf(), true))),
            TrieNode('b', mutableSetOf()),
            TrieNode('c', mutableSetOf()),
            TrieNode('d', mutableSetOf())
        ))
        assertTrue { trieNode.contains('a') }
    }
}