package subsequent_thee_length_palindrome

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParserSettings
import java.util.stream.Stream
import kotlin.time.measureTimedValue

class SolutionKtTest {

    companion object {

        @JvmStatic
        val parserSettings: CsvParserSettings

        @JvmStatic
        val cases: List<Array<String>>

        @JvmStatic
        fun getParamsFromResources(): Stream<Arguments> {
            return cases
                .mapIndexed { i, r -> Arguments.of(r[0], r[1], i + 1) }
                .stream()
        }

        init {
            parserSettings = CsvParserSettings()
            parserSettings.maxCharsPerColumn = 100_000
            cases = CsvParser(parserSettings)
                .parseAll(
                    Companion::class.java.getResourceAsStream(
                        "/subsequent_thee_length_palindrome/testcases.csv"
                    )
                )
        }
    }


    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("getParamsFromResources")
    fun countPalindromicSubsequence(expect: Int, case: String, index: Int) {
        val (result, time) = measureTimedValue { countPalindromicSubsequence(case) }
        println(time)
        assertEquals(expect, result)
    }

    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("getParamsFromResources")
    fun countPalindromicSubsequenceLeetCodeA1(expect: Int, case: String, index: Int) {
        val (result, time) = measureTimedValue { countPalindromicSubsequenceLeetCodeA1(case) }
        println(time)
        assertEquals(expect, result)
    }

    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("getParamsFromResources")
    fun countPalindromicSubsequenceLeetCodeA2(expect: Int, case: String, index: Int) {
        val (result, time) = measureTimedValue { countPalindromicSubsequenceLeetCodeA2(case) }
        println(time)
        assertEquals(expect, result)
    }
}