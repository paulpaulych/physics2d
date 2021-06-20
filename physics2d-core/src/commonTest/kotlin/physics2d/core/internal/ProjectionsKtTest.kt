package physics2d.core.internal

import io.kotest.matchers.be
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import physics2d.core.*
import physics2d.core.api.Lines.xAxis
import physics2d.core.api.Lines.yAxis
import physics2d.core.api.Segment
import physics2d.core.api.rect
import physics2d.core.api.vec
import physics2d.core.yEq2xPlus2
import physics2d.core.yEqMinusX
import physics2d.core.yEqXLine
import kotlin.test.Test

// TODO: make tests parametrized
class ProjectionsKtTest {

    @Test
    fun project_point() {
        projection(
            of = vec(200, 0),
            onto = yEqXLine
        ) shouldBe vec(100, 100)
        projection(
            of = vec(100, 100),
            onto = xAxis
        ) shouldBe vec(100, 0)
        projection(
            of = vec(0, 2),
            onto = yEq2xPlus2
        ) shouldBe vec(0, 2)
        projection(
            of = vec(-3, 1),
            onto = yEq2xPlus2
        ) shouldBe vec(-1, 0)
    }

    @Test
    fun project_rect() {
        var rect = rect(vec(0, 0), vec(2, 2))
        projection(rect, xAxis) shouldBe Segment(vec(0,0), vec(2,0))
        projection(rect, yAxis) shouldBe Segment(vec(0,0), vec(0,2))
        projection(rect, yEqXLine) shouldBe Segment(vec(0,0), vec(2,2))
        projection(rect, yEqMinusX) shouldBe Segment(vec(-1,1), vec(1,-1))

        rect = rect(vec(-30, -30), vec(40, 40))
        projection(rect, xAxis) shouldBe Segment(vec(10,0), vec(-30,0))
        projection(rect, yAxis) shouldBe Segment(vec(0,10), vec(0,-30))
        projection(rect, yEqXLine) shouldBe Segment(vec(-30,-30), vec(10,10))
        projection(rect, yEqMinusX) shouldBe Segment(vec(-20,20), vec(20,-20))
    }


    @Test
    fun any_orthogonal_for() {
        listOf(
            vec(0, 1),
            vec(1, 0),
            vec(-1, 4),
            vec(-100, 100),
        ) forEachAssert {
            anyOrthogonalFor(it) should beOrthogonalTo(it)
        }
    }

    @Test
    fun truncate_by_len () {
        listOf(
            vec(0, 10) to 5.0 to be(vec(0, 5)),
            vec(300, 400) to 250.0 to be(vec(150, 200)),
            vec(-30, -40) to 5.0 to be(vec(-3, -4)),
        ) forEachAssert { (given, expected) ->
            given.first.resizeToLen(given.second) should expected
        }
    }
}