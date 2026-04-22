package yacoder.dictionary

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull


class TrieTest {

    private val testTrie = Trie(
        TrieNode(
            ' ',
            mutableSetOf(
                TrieNode(
                    'w',
                    mutableSetOf(
                        TrieNode(
                            'o',
                            mutableSetOf(
                                TrieNode(
                                    'r',
                                    mutableSetOf(
                                        TrieNode('d',mutableSetOf(),true)
                                    )
                                )
                            )
                        ),
                        TrieNode(
                            'e',
                            mutableSetOf(
                                TrieNode('b', mutableSetOf(), true),
                                TrieNode(
                                    'e',
                                    mutableSetOf(
                                        TrieNode('d', mutableSetOf(), true)
                                    )
                                )
                            ),
                            true
                        )
                    )
                ),
                TrieNode(
                    'r',
                    mutableSetOf(
                        TrieNode(
                            'e',
                            mutableSetOf(
                                TrieNode(
                                    'a',
                                    mutableSetOf(
                                        TrieNode('d', mutableSetOf(), true),
                                    )
                                )
                            )
                        ),
                        TrieNode(
                            'a',
                            mutableSetOf(
                                TrieNode('t', mutableSetOf(), true),
                                TrieNode(
                                    'n',
                                    mutableSetOf(
                                        TrieNode('k', mutableSetOf(), true)
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
    )

    @Test
    fun getSubtrieFor() {
        val actual = testTrie.getSubtrieFor('w')
        val expected = Trie(
            TrieNode(
                'w',
                mutableSetOf(
                    TrieNode(
                        'o',
                        mutableSetOf(
                            TrieNode(
                                'r',
                                mutableSetOf(
                                    TrieNode('d', mutableSetOf(), true)
                                )
                            )
                        )
                    ),
                    TrieNode(
                        'e',
                        mutableSetOf(
                            TrieNode('b', mutableSetOf(), true),
                            TrieNode(
                                'e',
                                mutableSetOf(
                                    TrieNode('d', mutableSetOf(), true)
                                )
                            )
                        ),
                        true
                    )
                )
            )
        )
        assertEquals(expected, actual)
        val nextExpected = Trie(
            TrieNode(
                'o',
                mutableSetOf(
                    TrieNode(
                        'r',
                        mutableSetOf(
                            TrieNode('d', mutableSetOf(), true)
                        )
                    )
                )
            )
        )
        val nextActual = actual!!.getSubtrieFor('o')
        assertEquals(nextExpected, nextActual)
        assertNull(nextActual?.getSubtrieFor('k'))
    }

    @Test
    fun testFindPrefixForWordle() {
        assertEquals(
            TrieNode('d', mutableSetOf(), true),
            testTrie.findPrefix("wordle")
        )
    }

    @Test
    fun testFindPrefixForRank() {
        assertEquals(
            TrieNode('k', mutableSetOf(), true),
            testTrie.findPrefix("rank")
        )
    }

    @Test
    fun testFindPrefixForWork() {
        assertEquals(
            TrieNode(
                'r',
                mutableSetOf(
                    TrieNode('d', mutableSetOf(), true)
                )
            ), testTrie.findPrefix("work")
        )
    }

    @Test
    fun testFindPrefixForReentrant() {
        assertEquals(
            TrieNode(
                'e',
                mutableSetOf(
                    TrieNode(
                        'a',
                        mutableSetOf(
                            TrieNode('d', mutableSetOf(), true)
                        )
                    )
                )
            ), testTrie.findPrefix("reentrant")
        )
    }

    @Test
    fun addAddReentrant() {
        println(testTrie)
        testTrie.add("reentrant")
        println(testTrie)
        val expectedTrie = Trie(
            TrieNode(
                ' ',
                mutableSetOf(
                    TrieNode(
                        'w',
                        mutableSetOf(
                            TrieNode(
                                'o',
                                mutableSetOf(
                                    TrieNode(
                                        'r',
                                        mutableSetOf(
                                            TrieNode('d', mutableSetOf(), true)
                                        )
                                    )
                                )
                            ),
                            TrieNode(
                                'e',
                                mutableSetOf(
                                    TrieNode('b', mutableSetOf(), true),
                                    TrieNode(
                                        'e',
                                        mutableSetOf(
                                            TrieNode('d', mutableSetOf(), true)
                                        )
                                    )
                                ),
                                true
                            )
                        )
                    ),
                    TrieNode(
                        'r',
                        mutableSetOf(
                            TrieNode(
                                'e',
                                mutableSetOf(
                                    TrieNode(
                                        'a',
                                        mutableSetOf(
                                            TrieNode('d', mutableSetOf(), true)
                                        )
                                    ),
                                    TrieNode(
                                        'e',
                                        mutableSetOf(
                                            TrieNode(
                                                'n',
                                                mutableSetOf(
                                                    TrieNode(
                                                        't',
                                                        mutableSetOf(
                                                            TrieNode(
                                                                'r',
                                                                mutableSetOf(
                                                                    TrieNode(
                                                                        'a',
                                                                        mutableSetOf(
                                                                            TrieNode(
                                                                                'n',
                                                                                mutableSetOf(
                                                                                    TrieNode('t', mutableSetOf(), true)
                                                                                )
                                                                            )
                                                                        )
                                                                    )
                                                                )
                                                            )
                                                        )
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            ),
                            TrieNode(
                                'a',
                                mutableSetOf(
                                    TrieNode('t', mutableSetOf(), true),
                                    TrieNode(
                                        'n',
                                        mutableSetOf(
                                            TrieNode('k', mutableSetOf(), true)
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
        assertEquals(expectedTrie, testTrie)
    }
}