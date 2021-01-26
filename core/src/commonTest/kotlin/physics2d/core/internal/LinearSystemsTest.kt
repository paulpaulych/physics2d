package physics2d.core.internal

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class LinearSystemsTest {

    @Test
    fun solveLinearSystem() {
        val a = ar[
                ar[0.0, -1.0, 1.0],
                ar[-1.0, 3.0, 0.0],
                ar[2.0, 0.0, 6.0]]
        val b = ar[2.0, 5.0, 20.0]

        val res = solveLinearEquationsSystem(a, b)

        res[0] shouldBe -0.5
        res[1] shouldBe 1.5
        res[2] shouldBe 3.5
    }

    @Test
    fun solveLinearSystemX2() {
        val a = ar[ar[1.0]]
        val b = ar[3.0]

        val res = solveLinearEquationsSystem(a, b)

        res[0] shouldBe 3.0
    }
}
