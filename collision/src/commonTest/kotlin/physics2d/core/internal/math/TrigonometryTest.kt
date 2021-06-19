package physics2d.core.internal.math

import io.kotest.matchers.*
import physics2d.core.api.vec
import physics2d.core.beDouble
import physics2d.core.internal.math.absCosBetween
import physics2d.core.internal.math.absSinBetween
import physics2d.core.internal.math.crossProduct
import physics2d.core.internal.math.dotProduct
import kotlin.math.sqrt
import kotlin.test.Test

class TrigonometryTest {

    @Test
    fun dotProductTest() {
        dotProduct(vec(0, 0), vec(10, 10)) shouldBe 0
        dotProduct(vec(0.0, 1E-1), vec(10, 10)) shouldBe 1
        dotProduct(vec(-1, -3), vec(2, -3)) shouldBe 7
    }

    @Test
    fun absSinBetweenTest() {
        absSinBetween(vec(-1, 1), vec(0, 1)) should beDouble(1/sqrt(2.0))
        absSinBetween(vec(1, 0), vec(0, 1)) should beDouble(1.0)
        absSinBetween(vec(0, 1), vec(0, -1)) should beDouble(0.0)
        absSinBetween(vec(0, 1), vec(0, 1)) should beDouble(0.0)
    }

    @Test
    fun absCosBetweenTest() {
        absCosBetween(vec(1, 0), vec(0, 1)) should beDouble(0.0)
        absCosBetween(vec(1, 0), vec(-1, 0)) should beDouble(-1.0)
        absCosBetween(vec(1, 0), vec(1, 1)) should beDouble(1/sqrt(2.0))
        absCosBetween(vec(1, 1), vec(1, 0)) should beDouble(1/sqrt(2.0))
    }

    @Test
    fun crossProductTest() {
        crossProduct(vec(1, 0), vec(0, 1)) should beDouble(1.0)
        crossProduct(vec(-4, 0), vec(0, 3)) should beDouble(12.0)
        crossProduct(vec(4, 0), vec(4, 4)) should beDouble(16.0)
        crossProduct(vec(4, 0), vec(4, 2)) should beDouble(8.0)
        crossProduct(vec(0, 0), vec(4, 2)) shouldBe null
    }
}
