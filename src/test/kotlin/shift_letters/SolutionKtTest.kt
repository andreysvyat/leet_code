package shift_letters

import arrayAssertionMessage
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.converter.SimpleArgumentConverter
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParserSettings
import java.util.stream.Stream
import kotlin.test.assertEquals

val MAPPER = ObjectMapper()

class SolutionKtTest {

    companion object {

        @JvmStatic
        val parserSettings: CsvParserSettings

        @JvmStatic
        val cases: List<Array<String>>

        @JvmStatic
        fun getParamsFromResources(): Stream<Arguments> {
            return cases
                .mapIndexed { i, r -> Arguments.of(r[0], r[1], r[2], i + 1) }
                .stream()
        }

        init {
            parserSettings = CsvParserSettings()
            parserSettings.maxCharsPerColumn = 100_000
            parserSettings.isQuoteDetectionEnabled = true
            cases = CsvParser(parserSettings)
                .parseAll(
                    Companion::class.java.getResourceAsStream(
                        "/shift_letters/testcases.csv"
                    )
                )
        }
    }

    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("getParamsFromResources")
    fun shiftingLettersTest(
        s: String,
        @ConvertWith(ShiftsConverter::class) shifts: Array<IntArray>,
        expect: String,
        index: Int
    ) {
        val actual = shiftingLetters(s, shifts)
        assertEquals(expect, actual)
    }

    @Test
    fun prepareShiftsArrayTest() {
        val result = prepareShiftsArray(3, arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 2, 1), intArrayOf(0, 2, 1)))
        val expect = intArrayOf(0, 1, 2)
        assertArrayEquals(expect, result, arrayAssertionMessage(expect, result))
    }

    @Test
    fun prepareShiftsArrayTest5Len() {
        val result = prepareShiftsArray(5,
            arrayOf(
                intArrayOf(0, 1, 0),
                intArrayOf(1, 2, 1),
                intArrayOf(3, 4, 0),
                intArrayOf(0, 2, 1)
            )
        )
        val expect = intArrayOf(0, 1, 2, -1, -1)
        assertArrayEquals(expect, result, arrayAssertionMessage(expect, result))
    }

    @Test
    fun doRingShiftTestForwardA2B(){
        val result = doRingShift(1, 'a')
        assertEquals('b', result)
    }

    @Test
    fun doRingShiftTestForwardA2Z(){
        val result = doRingShift(25, 'a')
        assertEquals('z', result)
    }

    @Test
    fun doRingShiftTestForwardA2A(){
        val result = doRingShift(26, 'a')
        assertEquals('a', result)
    }

    @Test
    fun doRingShiftTestZeroShift(){
        val result = doRingShift(0, 'a')
        assertEquals('a', result)
    }

    @Test
    fun doRingShiftTestBackwardA2Z(){
        val result = doRingShift(-1, 'a')
        assertEquals('z', result)
    }

    @Test
    fun doRingShiftTestBackwardA2B(){
        val result = doRingShift(-25, 'a')
        assertEquals('b', result)
    }

    @Test
    fun doRingShiftTestBackwardA2A(){
        val result = doRingShift(-26, 'a')
        assertEquals('a', result)
    }
}

class ShiftsConverter : SimpleArgumentConverter() {

    override fun convert(source: Any?, targetType: Class<*>?): Any {
        return MAPPER.readValue(source?.toString() ?: "", Array<IntArray>::class.java)
    }
}