package yacoder.pmq

import kotlin.test.Test
import kotlin.test.assertEquals

class GetPowerSetTest {
    @Test
    fun getAddressesPowerSet() {
        val addresses = arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 0), Pair(1, 1))
        val actual = addresses.toList().powerSet().toSet()

        val expected = setOf(
            emptySet(),
            setOf(Pair(0, 0)),
            setOf(Pair(0, 1)),
            setOf(Pair(1, 0)),
            setOf(Pair(1, 1)),
            setOf(Pair(0, 0), Pair(0, 1)),
            setOf(Pair(0, 0), Pair(1, 0)),
            setOf(Pair(0, 0), Pair(1, 1)),
            setOf(Pair(0, 1), Pair(1, 0)),
            setOf(Pair(0, 1), Pair(1, 1)),
            setOf(Pair(1, 0), Pair(1, 1)),
            setOf(Pair(0, 0), Pair(0, 1), Pair(1, 0)),
            setOf(Pair(0, 0), Pair(0, 1), Pair(1, 1)),
            setOf(Pair(0, 0), Pair(1, 0), Pair(1, 1)),
            setOf(Pair(0, 1), Pair(1, 0), Pair(1, 1)),
            setOf(Pair(0, 0), Pair(0, 1), Pair(1, 0), Pair(1, 1))
        )

        // Простое сравнение множеств — порядок не важен
        assertEquals(expected, actual)
    }

}