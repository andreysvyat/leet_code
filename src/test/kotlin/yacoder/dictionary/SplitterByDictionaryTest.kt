package yacoder.dictionary

import org.junit.jupiter.api.RepeatedTest
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class SplitterByDictionaryTest {
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
        val dictionary =
            arrayOf("asdf", "batw", "dfr", "eqvpen", "ixoar", "kbaer", "lane", "p", "panqit", "qwefvob", "vat")
        val splitter = newDictionary(sentence, dictionary)

        val exp = "p"
        val act = splitter.getSentenceWithSpaces().trim()

        assertEquals(exp, act)
    }

    @Test
    fun getSentenceOfSingleWord() {
        val sentence = "panqit"
        val dictionary =
            arrayOf("asdf", "batw", "dfr", "eqvpen", "ixoar", "kbaer", "lane", "p", "panqit", "qwefvob", "vat")
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
    fun getSentenceOfDictAbAbcCdE() {
        val sentence = "abcde"
        val dictionary = arrayOf("ab", "abc", "cd", "cde", "e")
        val splitter = newDictionary(sentence, dictionary)
        val exp = "ab cde"
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
    fun getSentenceAAAA() {
        val sentence = "aaaa"
        val dictionary = arrayOf("aa", "aaa")
        val splitter = newDictionary(sentence, dictionary)

        val exp = "aa aa"
        val act = splitter.getSentenceWithSpaces().trim()

        assertEquals(exp, act)
    }

    @Test
    fun getSentenceWithOverlappingWords() {
        val sentence = "abce"
        val dictionary = arrayOf("abc", "ab", "ce")
        val splitter = newDictionary(sentence, dictionary)

        val exp = "ab ce"
        val act = splitter.getSentenceWithSpaces().trim()

        assertEquals(exp, act)
    }

    @Test
    fun getSentenceWithSpacesPathologicalExponentialCase() {
        // "aaaa...a" (30 штук) + "b". Словарь — все строки из 'a' длины 1..10.
        // Валидного разбиения не существует ('b' вне словаря), но из-за отсутствия
        // мемоизации рекурсия перебирает ~2^30 разбиений префикса из 'a' — уйдёт в минуты.
        val sentence = "a".repeat(30)
        val dictionary = (1..10).map { "a".repeat(it) }.toTypedArray()
        val splitter = newDictionary(sentence, dictionary)
        splitter.getSentenceWithSpaces()
    }

    @RepeatedTest(1000)
    fun getSentenceWithSpacesForBigDictionary() {
        val dict = Array(2000) { getRandomString(Random.nextInt(3, 20)) }.distinct().toTypedArray()
        val selectedWords = mutableListOf<String>()
        val sentence = generateStringFromDictionary(dict, 100, selectedWords)
        val expected = selectedWords.joinToString(" ")
        val actual = SplitterByDictionary(sentence, dict).getSentenceWithSpaces()
        assertEquals(expected, actual)
    }

    fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }

    fun generateStringFromDictionary(
        dictionary: Array<String>,
        maxLength: Int = 100,
        selectedWords: MutableList<String>
    ): String {
        require(dictionary.isNotEmpty()) { "Словарь не должен быть пустым" }
        require(maxLength > 0) { "Максимальная длина должна быть положительной" }

        val result = StringBuilder()

        while (result.length <= maxLength) {
            // Получаем случайное слово из словаря
            val randomWord = dictionary[Random.nextInt(dictionary.size)]

            // Проверяем, поместится ли слово с пробелом (если строка не пуста)
            val potentialLength = result.length + randomWord.length

            if (potentialLength <= maxLength) {
                result.append(randomWord)
                selectedWords.add(randomWord)
            } else {
                break
            }
        }
        return result.toString()
    }

    private fun newDictionary(
        sentence: String,
        dictionary: Array<String>
    ): SplitterByDictionary = SplitterByDictionary(sentence, dictionary)
}