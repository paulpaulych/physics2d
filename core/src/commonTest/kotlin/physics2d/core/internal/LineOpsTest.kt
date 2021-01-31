package physics2d.core.internal

import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import physics2d.core.*
import physics2d.core.api.pt
import physics2d.core.api.xAxis
import physics2d.core.yEq2xPlus2
import physics2d.core.yEqXLine
import kotlin.math.sqrt
import kotlin.test.Test

// TODO: each test should check single concept.
//  Replace current test methods with smth like
//  "perpendicular to line containing src point is (0, 0)"
class LineOpsTest {

    @Test
    fun points_belong_to_YEq0() {
        listOf(
            pt(0, 0),
            pt(1, 0),
            pt(-3, 0)
        ) forEachAssert {
            it.belongsTo(xAxis) shouldBe true
        }
    }

    @Test
    fun points_not_belong_to_YEq0() {
        listOf(
            pt(0, 1),
            pt(1, 3),
            pt(-3, 4)
        ) forEachAssert {
            it.belongsTo(xAxis) shouldBe false
        }
    }

    @Test
    fun points_belong_to_YEqX() {
        listOf(
            pt(-10, -10),
            pt(10, 10),
            pt(300, 300)
        ) forEachAssert {
            it.belongsTo(yEqXLine) shouldBe true
        }
    }

    @Test
    fun points_not_belong_to_YEqX() {
        listOf(
            pt(-301, -300),
            pt(201, 200),
            pt(300, 400)
        ) forEachAssert  {
            it.belongsTo(yEqXLine) shouldBe false
        }
    }

    @Test
    fun distance_between_pt_and_line() {
        pt(0, 0).distanceTo(yEqXLine) should beDouble(0.0)
        pt(-sqrt(2.0), sqrt(2.0)).distanceTo(yEqXLine) should beDouble(2.0)
        pt(0, 5).distanceTo(xAxis) should beDouble(5.0)
        pt(0, -5).distanceTo(xAxis) should beDouble(5.0)

        pt(-1, 0).distanceTo(yEq2xPlus2) should beDouble(0.0)
    }

    @Test
    fun perpendicular_to_xAxis() {
        pt(0, 1).perpendicularTo(xAxis) shouldBe pt(0, -1)
        pt(0, 0).perpendicularTo(xAxis) shouldBe pt(0, 0)
        pt(100000, 1).perpendicularTo(xAxis) shouldBe pt(0, -1)
        pt(-500, 300).perpendicularTo(xAxis) shouldBe pt(0, -300)
    }

    @Test
    fun perpendicular_to_yEqXLine() {
        pt(1, 1).perpendicularTo(yEqXLine) shouldBe pt(0, 0)
        pt(0, 1).perpendicularTo(yEqXLine) shouldBe pt(0.5, -0.5)
    }
}
