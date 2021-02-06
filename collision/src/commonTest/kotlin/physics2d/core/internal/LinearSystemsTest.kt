package physics2d.core.internal

import io.kotest.matchers.should
import physics2d.core.beDouble
import kotlin.test.Test

class LinearSystemsTest {

    @Test
    fun solveLinearSystem() {
        val a = arrayOf(
            doubleArrayOf(0.0, -1.0, 1.0),
            doubleArrayOf(-1.0, 3.0, 0.0),
            doubleArrayOf(2.0, 0.0, 6.0))
        val b = doubleArrayOf(2.0, 5.0, 20.0)

        val res = solveLinearEquationsSystem(a, b)

        res[0] should beDouble(-0.5)
        res[1] should beDouble(1.5)
        res[2] should beDouble(3.5)
    }

    @Test
    fun solveLinearSystemX2() {
        val a = arrayOf(doubleArrayOf(1.0))
        val b = doubleArrayOf(3.0)

        val res = solveLinearEquationsSystem(a, b)

        res[0] should beDouble(3.0)
    }
}
