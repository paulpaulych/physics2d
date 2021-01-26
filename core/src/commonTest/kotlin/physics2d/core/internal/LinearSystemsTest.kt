package physics2d.core.internal

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class LinearSystemsTest {

    @Test
    fun solveLinearSystem() {
        val a = l[
                l[0.0, -1.0, 1.0],
                l[-1.0, 3.0, 0.0],
                l[2.0, 0.0, 6.0]]
        val b = l[2.0, 5.0, 20.0]

        val res = solveLinearEquationsSystem(a, b)

        res[0] shouldBe -0.5
        res[1] shouldBe 1.5
        res[2] shouldBe 3.5
    }

    @Test
    fun solveLinearSystemX2() {
        val a = l[l[1.0]]
        val b = l[3.0]

        val res = solveLinearEquationsSystem(a, b)

        res[0] shouldBe 3.0
    }
}
