package physics2d.core.internal

import io.kotest.matchers.shouldBe
import physics2d.core.api.line
import physics2d.core.api.pt
import kotlin.test.Test

class LineOpsTest {

    @Test
    fun pointsBelongToYEq0() {
        l[pt(0, 0), pt(1, 0), pt(-3, 0)].forEach {
            it.belongsTo(yEqZeroLine) shouldBe true
        }
    }
    @Test
    fun pointsNotBelongToYEq0() {
        l[pt(0, 1), pt(1, 3), pt(-3, 4)].forEach {
            it.belongsTo(yEqZeroLine) shouldBe false
        }
    }
    @Test
    fun pointsBelongToYEqX() {
        l[pt(-10, -10), pt(10, 10), pt(300, 300)].forEach {
            it.belongsTo(yEqXLine) shouldBe true
        }
    }
    @Test
    fun pointsNotBelongToYEqX() {
        l[pt(-301, -300), pt(201, 200), pt(300, 400)].forEach {
            it.belongsTo(yEqXLine) shouldBe false
        }
    }

    @Test
    fun projectPointToDiagonal() {
        with(pt(100, 200)) {
            projectionTo(yEqXLine)
        } shouldBe pt(100, 100)
    }

    @Test
    fun projectPointToHorizontal() {
        with(pt(100, 100)){
            projectionTo(yEqZeroLine)
        } shouldBe pt(100, 0)
    }

    @Test
    fun projectZeroPointToLine() {
        val p = pt(0, 0)
        p.projectionTo(yEq2xPlus2) shouldBe pt(0, 2)
    }

    @Test
    fun projectNegativePointToHorizontal() {
        val p = pt(-3, 1)
        p.projectionTo(yEq2xPlus2) shouldBe pt(-1, 0)
    }
}

private val yEqZeroLine = line(pt(0, 0), pt(1, 0))
private val yEqXLine = line(pt(0, 0), pt(1, 1))
private val yEq2xPlus2 = line(pt(0, 2), pt(1, 4))