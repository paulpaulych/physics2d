package physics2d.core.internal

import io.kotest.matchers.shouldBe
import physics2d.core.api.figures.aabb
import physics2d.core.api.pt
import physics2d.core.api.xAxis
import physics2d.core.api.yAxis
import physics2d.core.yEq2xPlus2
import physics2d.core.yEqMinusX
import physics2d.core.yEqXLine
import kotlin.test.Test

class ProjectionsTest {

    @Test
    fun project_point() {
        pt(200, 0).projectTo(yEqXLine) shouldBe pt(100, 100)
        pt(100, 100).projectTo(xAxis) shouldBe pt(100, 0)
        pt(0, 2).projectTo(yEq2xPlus2) shouldBe pt(0, 2)
        pt(-3, 1).projectTo(yEq2xPlus2) shouldBe pt(-1, 0)
    }

    @Test
    fun project_aabb() {
        with(aabb(0, 0, 1, 1)) {
            projectTo(xAxis) shouldBe Segment(pt(0,0), pt(2,0))
            projectTo(yAxis) shouldBe Segment(pt(0,0), pt(0,2))
            projectTo(yEqXLine) shouldBe Segment(pt(0,0), pt(2,2))
            projectTo(yEqMinusX) shouldBe Segment(pt(-1,1), pt(1,-1))
        }

        with(aabb(-30, -30, 20, 20)) {
            projectTo(xAxis) shouldBe Segment(pt(10,0), pt(-30,0))
            projectTo(yAxis) shouldBe Segment(pt(0,10), pt(0,-30))
            projectTo(yEqXLine) shouldBe Segment(pt(-30,-30), pt(10,10))
            projectTo(yEqMinusX) shouldBe Segment(pt(-20,20), pt(20,-20))
        }
    }
}