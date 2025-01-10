package word_subset

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.seconds
import kotlin.time.measureTimedValue

class SolutionKtTest {

    companion object {
        @JvmStatic
        val MAPPER = ObjectMapper().registerModule(KotlinModule.Builder().build())

        @JvmStatic
        fun getParamsFromResources(): Stream<Arguments> {
            return MAPPER.readValue(
                Companion::class.java.getResourceAsStream(
                    "/word_subset/testcases.json"
                ),
                Array<WordSubsetTestCase>::class.java
            )
                .mapIndexed { i, r -> Arguments.of(r.w1, r.w2, r.expect, i + 1) }
                .stream()
        }
    }

    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("getParamsFromResources")
    fun wordSubsetsTest(w1: Array<String>, w2: Array<String>, expect: List<String>) {
        val (result, timeTaken) = measureTimedValue {  wordSubsets(w1, w2) }
        assertEquals(expect, result)
        assertTrue { timeTaken < 2.seconds }
    }
}

data class WordSubsetTestCase(
    val w1: Array<String>,
    val w2: Array<String>,
    val expect: List<String>
)