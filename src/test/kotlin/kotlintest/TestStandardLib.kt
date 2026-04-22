package kotlintest

import kotlin.test.Test
import kotlin.test.assertTrue

class TestStandardLib {
    @Test
    fun testSetEquals() {
        @Suppress("ReplaceAssertBooleanWithAssertEquality")
        assertTrue(setOf("v1", "v2") == setOf("v1", "v2"))
    }
}