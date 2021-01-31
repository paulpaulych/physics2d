package physics2d.core.internal

import io.kotest.matchers.*
import physics2d.core.api.pt
import physics2d.core.beDouble
import physics2d.core.beOrthogonalTo
import physics2d.core.forEachAssert
import kotlin.math.sqrt
import kotlin.test.Test

class PtOpsTest {

    @Test
    fun any_orthogonal_for() {
        l[
            pt(0, 1),
            pt(1, 0),
            pt(-1, 4),
            pt(-100, 100),
        ] forEachAssert {
            anyOrthogonalFor(it) should beOrthogonalTo(it)
        }
    }

    @Test
    fun truncate_by_len () {
        l[
            pt(0, 10) to 5.0 to be(pt(0, 5)),
            pt(300, 400) to 250.0 to be(pt(150, 200)),
            pt(-30, -40) to 5.0 to be(pt(-3, -4)),
        ] forEachAssert { (given, expected) ->
            given.first.resizeToLen(given.second) should expected
        }
    }

    @Test
    fun scalar_product() {
        dotProduct(pt(0, 0), pt(10, 10)) shouldBe 0
        dotProduct(pt(0.0, 1E-1), pt(10, 10)) shouldBe 1
        dotProduct(pt(-1, -3), pt(2, -3)) shouldBe 7
    }

    @Test
    fun sin_between_pts() {
        absSinBetween(pt(-1, 1), pt(0, 1)) should beDouble(1/sqrt(2.0))
        absSinBetween(pt(1, 0), pt(0, 1)) should beDouble(1.0)
        absSinBetween(pt(0, 1), pt(0, -1)) should beDouble(0.0)
        absSinBetween(pt(0, 1), pt(0, 1)) should beDouble(0.0)
    }

    @Test
    fun cos_between_pts() {
        absCosBetween(pt(1, 0), pt(0, 1)) should beDouble(0.0)
        absCosBetween(pt(1, 0), pt(-1, 0)) should beDouble(-1.0)
        absCosBetween(pt(1, 0), pt(1, 1)) should beDouble(1/sqrt(2.0))
        absCosBetween(pt(1, 1), pt(1, 0)) should beDouble(1/sqrt(2.0))
    }

    @Test
    fun vector_product() {
        crossProduct(pt(1, 0), pt(0, 1)) should beDouble(1.0)
        crossProduct(pt(-4, 0), pt(0, 3)) should beDouble(12.0)
        crossProduct(pt(4, 0), pt(4, 4)) should beDouble(16.0)
        crossProduct(pt(4, 0), pt(4, 2)) should beDouble(8.0)
        crossProduct(pt(0, 0), pt(4, 2)) shouldBe null
    }
}
