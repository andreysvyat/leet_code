import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class LangFunctionsTest {
    @Test
    fun testShift() {
        val expected = 16
        val actual = 1 shl 4
        assertEquals(expected, actual)
    }
}