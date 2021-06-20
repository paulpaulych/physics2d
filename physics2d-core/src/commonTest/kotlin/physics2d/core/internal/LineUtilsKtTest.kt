package physics2d.core.internal

import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import physics2d.core.*
import physics2d.core.api.Lines.xAxis
import physics2d.core.api.vec
import physics2d.core.yEq2xPlus2
import physics2d.core.yEqXLine
import kotlin.math.sqrt
import kotlin.test.Test

// TODO: each test should check single concept.
//  Replace current test methods with smth like
//  "perpendicular to line containing src point is (0, 0)"
class LineUtilsKtTest {

    @Test
    fun points_belong_to_YEq0() {
        listOf(
            vec(0, 0),
            vec(1, 0),
            vec(-3, 0)
        ) forEachAssert {
            it.belongsTo(xAxis) shouldBe true
        }
    }

    @Test
    fun points_not_belong_to_YEq0() {
        listOf(
            vec(0, 1),
            vec(1, 3),
            vec(-3, 4)
        ) forEachAssert {
            it.belongsTo(xAxis) shouldBe false
        }
    }

    @Test
    fun points_belong_to_YEqX() {
        listOf(
            vec(-10, -10),
            vec(10, 10),
            vec(300, 300)
        ) forEachAssert {
            it.belongsTo(yEqXLine) shouldBe true
        }
    }

    @Test
    fun points_not_belong_to_YEqX() {
        listOf(
            vec(-301, -300),
            vec(201, 200),
            vec(300, 400)
        ) forEachAssert  {
            it.belongsTo(yEqXLine) shouldBe false
        }
    }

    @Test
    fun distance_between_pt_and_line() {
        vec(0, 0).distanceTo(yEqXLine) should beDouble(0.0)
        vec(-sqrt(2.0), sqrt(2.0)).distanceTo(yEqXLine) should beDouble(2.0)
        vec(0, 5).distanceTo(xAxis) should beDouble(5.0)
        vec(0, -5).distanceTo(xAxis) should beDouble(5.0)

        vec(-1, 0).distanceTo(yEq2xPlus2) should beDouble(0.0)
    }

    @Test
    fun perpendicular_to_xAxis() {
        vec(0, 1).perpendicularTo(xAxis) shouldBe vec(0, -1)
        vec(0, 0).perpendicularTo(xAxis) shouldBe vec(0, 0)
        vec(100000, 1).perpendicularTo(xAxis) shouldBe vec(0, -1)
        vec(-500, 300).perpendicularTo(xAxis) shouldBe vec(0, -300)
    }

    @Test
    fun perpendicular_to_yEqXLine() {
        vec(1, 1).perpendicularTo(yEqXLine) shouldBe vec(0, 0)
        vec(0, 1).perpendicularTo(yEqXLine) shouldBe vec(0.5, -0.5)
    }
}
