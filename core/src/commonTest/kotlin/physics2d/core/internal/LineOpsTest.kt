package physics2d.core.internal

import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import physics2d.core.*
import physics2d.core.api.pt
import physics2d.core.yEq2xPlus2
import physics2d.core.yEqXLine
import physics2d.core.yEqZeroLine
import kotlin.math.sqrt
import kotlin.test.Test

class LineOpsTest {

    @Test
    fun points_belong_to_YEq0() {
        l[pt(0, 0), pt(1, 0), pt(-3, 0)] forEachAssert {
            it.belongsTo(yEqZeroLine) shouldBe true
        }
    }

    @Test
    fun points_not_belong_to_YEq0() {
        l[pt(0, 1), pt(1, 3), pt(-3, 4)] forEachAssert {
            it.belongsTo(yEqZeroLine) shouldBe false
        }
    }

    @Test
    fun points_belong_to_YEqX() {
        l[pt(-10, -10), pt(10, 10), pt(300, 300)] forEachAssert {
            it.belongsTo(yEqXLine) shouldBe true
        }
    }

    @Test
    fun points_not_belong_to_YEqX() {
        l[pt(-301, -300), pt(201, 200), pt(300, 400)].forEach {
            it.belongsTo(yEqXLine) shouldBe false
        }
    }

    @Test
    fun distance_between_pt_and_line() {
        pt(0, 0).distanceTo(yEqXLine) should beDouble(0.0)
        pt(-sqrt(2.0), sqrt(2.0)).distanceTo(yEqXLine) should beDouble(2.0)
        pt(0, 5).distanceTo(yEqZeroLine) should beDouble(5.0)
        pt(0, -5).distanceTo(yEqZeroLine) should beDouble(5.0)
        pt(-3, 1).distanceTo(yEq2xPlus2) should beDouble(sqrt(6.0))
    }
}
