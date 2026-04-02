package array.watercontainer

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.time.measureTimedValue

class WaterContainersTest {
    @Test
    fun testWaterContainersFromFirstExample() {
        val containers = WaterContainers(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))
        assertEquals(49, containers.getLargest())
    }

    @Test
    fun testWaterContainersFromSecondExample() {
        val containers = WaterContainers(intArrayOf(1, 1))
        assertEquals(1, containers.getLargest())
    }

    @Test
    fun testWaterContainersFromFirstExampleReversedBounds() {
        val containers = WaterContainers(intArrayOf(1, 7, 6, 2, 5, 4, 8, 3, 8))
        assertEquals(49, containers.getLargest())
    }

    @Test
    fun testLongRandomExample() {
        val height = IntArray(10 * 10 * 10 * 10 * 10) { Random.nextInt(0, 10001) }
        val containers = WaterContainers(height)
        val (result, time) = measureTimedValue { containers.getLargest() }
        println(time)
        val (expect, bruteTime) = measureTimedValue { containers.getLargestBruteForce() }
        println(bruteTime)
        assertTrue { time < bruteTime }
        assertEquals(expect, result)
    }

    @Test
    fun testSpaceCalculatorFirsExample() {
        val containers = WaterContainers(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))
        val actual = containers.calculateSpaceByPointers(1, 8)
        assertEquals(49, actual)
    }

    @Test
    fun testSpaceCalculatorOneMore() {
        val containers = WaterContainers(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))
        val actual = containers.calculateSpaceByPointers(0, 1)
        assertEquals(1, actual)
    }

    @Test
    fun testSpaceCalculatorSameBounds() {
        val containers = WaterContainers(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))
        val actual = containers.calculateSpaceByPointers(1, 1)
        assertEquals(0, actual)
    }
}
