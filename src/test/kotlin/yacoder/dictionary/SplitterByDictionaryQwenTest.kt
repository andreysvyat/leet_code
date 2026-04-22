package yacoder.dictionary

import kotlin.test.Test
import kotlin.test.assertEquals

class SplitterByDictionaryQwenTest {
    @Test
    fun getSentenceWithSpacesFirstCase() {
        val sentence = "whatcanido"
        val dictionary = arrayOf("a", "an", "can", "do", "i", "what")
        val splitter = newDictionary(sentence, dictionary)

        val exp = "what can i do"
        val act = splitter.getSentenceWithSpaces().trim()

        assertEquals(exp, act)
    }

    @Test
    fun getSentenceWithSpacesSecondCase() {
        val sentence = "panqitqwefvoblanedfrixoareqvpenvat"
        val dictionary = arrayOf("asdf", "batw", "dfr", "eqvpen", "ixoar", "kbaer", "lane", "panqit", "qwefvob", "vat")
        val splitter = newDictionary(sentence, dictionary)

        val exp = "panqit qwefvob lane dfr ixoar eqvpen vat"
        val act = splitter.getSentenceWithSpaces().trim()

        assertEquals(exp, act)
    }

    @Test
    fun getSentenceOfSingleLetter() {
        val sentence = "p"
        val dictionary = arrayOf("asdf", "batw", "dfr", "eqvpen", "ixoar", "kbaer", "lane", "p", "panqit", "qwefvob", "vat")
        val splitter = newDictionary(sentence, dictionary)

        val exp = "p"
        val act = splitter.getSentenceWithSpaces().trim()

        assertEquals(exp, act)
    }

    @Test
    fun getSentenceOfSingleWord() {
        val sentence = "panqit"
        val dictionary = arrayOf("asdf", "batw", "dfr", "eqvpen", "ixoar", "kbaer", "lane", "p", "panqit", "qwefvob", "vat")
        val splitter = newDictionary(sentence, dictionary)

        val exp = "panqit"
        val act = splitter.getSentenceWithSpaces().trim()

        assertEquals(exp, act)
    }

    @Test
    fun getSentenceOfDictAbAbcDe() {
        val sentence = "abcde"
        val dictionary = arrayOf("ab", "abc", "de")
        val splitter = newDictionary(sentence, dictionary)
        val exp = "abc de"
        val act = splitter.getSentenceWithSpaces().trim()
        assertEquals(exp, act)
    }

    @Test
    fun getSentenceOfDictAbcdE() {
        val sentence = "abcde"
        val dictionary = arrayOf("abcd", "e")
        val splitter = newDictionary(sentence, dictionary)
        val exp = "abcd e"
        val act = splitter.getSentenceWithSpaces().trim()
        assertEquals(exp, act)
    }


    @Test
    fun getSentenceWithOverlappingWords() {
        val sentence = "panqitqwefvoblanedfrixoareqvpenvat"
        val dictionary = arrayOf("asdf", "batw", "dfrixoar", "dfr", "eqvpen", "ixoar", "kbaer", "lanedfr", "panqit", "qwefvob", "vat")
        val splitter = newDictionary(sentence, dictionary)

        val exp = "panqit qwefvob lane dfr ixoar eqvpen vat"
        val act = splitter.getSentenceWithSpaces().trim()

        assertEquals(exp, act)
    }

    @Test
    fun getSentenceOfDictAbAbcCdE() {
        val sentence = "abcde"
        val dictionary = arrayOf("ab", "abc", "cd", "cde", "e")
        val splitter = newDictionary(sentence, dictionary)
        val exp = "ab cd e"
        val act = splitter.getSentenceWithSpaces().trim()
        assertEquals(exp, act)
    }

    private fun newDictionary(
        sentence: String,
        dictionary: Array<String>
    ) = SplitterByDictionaryQwen(sentence, dictionary)
}