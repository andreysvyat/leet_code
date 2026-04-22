package yacoder.dictionary

import kotlin.math.min

class SplitterByDictionaryQwen(
    private val sentence: String,
    private val dictionary: Array<String>
) {
    fun getSentenceWithSpaces(): String {
        val n = sentence.length
        if (n == 0) return ""

        // Преобразуем словарь в Set для быстрого поиска O(1)
        val wordSet = dictionary.toSet()

        // dp[i] = true, если префикс sentence[0..i-1] можно разбить на слова из словаря
        val dp = BooleanArray(n + 1)
        dp[0] = true // Пустая строка всегда может быть "разбита"

        // parent[i] хранит слово, которое заканчивается на позиции i-1 (т.е. входит в диапазон [j, i))
        // Если parent[i] != null, значит dp[i] = true и последнее слово - это parent[i]
        val parent = arrayOfNulls<String>(n + 1)

        // Заполняем таблицу DP
        for (i in 1..n) {
            // Проверяем все возможные слова, которые могут заканчиваться на позиции i
            // Слово может иметь длину от 1 до min(i, 20), так как макс длина слова 20
            val maxWordLen = min(i, 20)

            for (len in 1..maxWordLen) {
                val j = i - len // Начальный индекс текущего слова

                // Если префикс до начала этого слова можно разбить (dp[j] == true)
                // И текущее подстрока есть в словаре
                if (dp[j]) {
                    val substring = sentence.substring(j, i)
                    if (wordSet.contains(substring)) {
                        dp[i] = true
                        parent[i] = substring
                        break // Нашли хотя бы один способ разбить префикс до i, переходим к следующему i
                    }
                }
            }
        }

        // По условию гарантируется, что решение существует, поэтому dp[n] должно быть true
        if (!dp[n]) {
            // На случай, если входные данные нарушают условие гарантии
            return sentence
        }

        // Восстанавливаем ответ, идя с конца
        val words = mutableListOf<String>()
        var idx = n
        while (idx > 0) {
            val word = parent[idx] ?: break
            // Защита от непредвиденных ошибок
            words.add(word)
            idx -= word.length
        }

        // Так как мы шли с конца, список слов нужно перевернуть
        words.reverse()

        // Формируем итоговую строку с пробелами
        return words.joinToString(" ")
    }
}