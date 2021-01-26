package physics2d.core.internal

import io.kotest.matchers.shouldBe
import physics2d.core.api.pt
import physics2d.core.yEq2xPlus2
import physics2d.core.yEqXLine
import physics2d.core.yEqZeroLine
import kotlin.test.Test

class ProjectionsTest {

    @Test
    fun project_point_to_diagonal() {
        with(pt(100, 200)) {
            projectionTo(yEqXLine)
        } shouldBe pt(100, 100)
    }

    @Test
    fun project_point_to_horizontal() {
        with(pt(100, 100)){
            projectionTo(yEqZeroLine)
        } shouldBe pt(100, 0)
    }

    @Test
    fun project_zero_point_to_line() {
        val p = pt(0, 0)
        p.projectionTo(yEq2xPlus2) shouldBe pt(0, 2)
    }

    @Test
    fun project_negative_point_to_horizontal() {
        val p = pt(-3, 1)
        p.projectionTo(yEq2xPlus2) shouldBe pt(-1, 0)
    }

}