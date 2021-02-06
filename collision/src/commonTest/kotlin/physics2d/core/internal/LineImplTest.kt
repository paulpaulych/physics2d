package physics2d.core.internal

import io.kotest.matchers.*
import physics2d.core.api.CommonLineEquation
import physics2d.core.api.Pt
import physics2d.core.api.pt
import physics2d.core.api.xAxis
import physics2d.core.matcher
import physics2d.core.yEq2xPlus2
import physics2d.core.yEqXLine
import kotlin.test.Test

class LineImplTest {

    @Test
    fun get_common_equation_yEqXLine() {
        yEqXLine.common should haveSolution(pt(300, 300))
        yEqXLine.common should haveSolution(pt(-300, -300))
        yEqXLine.common shouldNot haveSolution(pt(0, 300))
        yEqXLine.common shouldNot haveSolution(pt(300, 0))
    }

    @Test
    fun get_common_equation_yEq2xPlus2() {
        yEq2xPlus2.common should haveSolution(pt(0, 2))
        yEq2xPlus2.common should haveSolution(pt(1, 4))
        yEq2xPlus2.common should haveSolution(pt(300, 602))
        yEq2xPlus2.common should haveSolution(pt(-300, -598))

        yEq2xPlus2.common shouldNot haveSolution(pt(-300, 0))
        yEq2xPlus2.common shouldNot haveSolution(pt(0, -0))
    }

    @Test
    fun get_common_equation_xAxis() {
        xAxis.common should haveSolution(pt(0, 0))
        xAxis.common should haveSolution(pt(1, 0))
        xAxis.common should haveSolution(pt(2000, 0))
        xAxis.common should haveSolution(pt(-10000, 0))

        xAxis.common shouldNot haveSolution(pt(300, 602))
        xAxis.common shouldNot haveSolution(pt(-300, -598))
        xAxis.common shouldNot haveSolution(pt(-300, 1))
        xAxis.common shouldNot haveSolution(pt(0, -1))
    }

}

private fun haveSolution(pt: Pt) = matcher<CommonLineEquation> {
    MatcherResult(
        0.0.eq(a*pt.x + b*pt.y + c),
        "$this should have solution: $pt",
        "$this shouldn't have solution: $pt"
    )
}