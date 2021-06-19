//package physics2d.core.internal.math
//
//import io.kotest.data.forAll
//import io.kotest.data.row
//import io.kotest.matchers.*
//import physics2d.core.api.Vec
//import physics2d.core.api.vec
//import physics2d.core.api.xAxis
//import physics2d.core.internal.eq
//import physics2d.core.matcher
//import physics2d.core.yEq2xPlus2
//import physics2d.core.yEqXLine
//import kotlin.test.Test
// TODO: включить
////TODO: make tests parametrized
//class LineEquationTest {
//
//    @Test
//    fun get_common_equation_yEqXLine() {
//        forAll(
//            row(yEqXLine, vec(300, 300)),
//            row(yEqXLine, vec(-300, -300)),
//            row(yEqXLine, vec(0, 300)),
//            row(yEqXLine, vec(300, 0)),
//        ) { (line, pt) ->
//            standardFormedLineEquation(line.v1, line.v2) should haveSolution(pt)
//        }
//    }
//
//    @Test
//    fun get_common_equation_yEq2xPlus2() {
//        yEq2xPlus2.common should haveSolution(vec(0, 2))
//        yEq2xPlus2.common should haveSolution(vec(1, 4))
//        yEq2xPlus2.common should haveSolution(vec(300, 602))
//        yEq2xPlus2.common should haveSolution(vec(-300, -598))
//
//        yEq2xPlus2.common shouldNot haveSolution(vec(-300, 0))
//        yEq2xPlus2.common shouldNot haveSolution(vec(0, -0))
//    }
//
//    @Test
//    fun get_common_equation_xAxis() {
//        xAxis.common should haveSolution(vec(0, 0))
//        xAxis.common should haveSolution(vec(1, 0))
//        xAxis.common should haveSolution(vec(2000, 0))
//        xAxis.common should haveSolution(vec(-10000, 0))
//
//        xAxis.common shouldNot haveSolution(vec(300, 602))
//        xAxis.common shouldNot haveSolution(vec(-300, -598))
//        xAxis.common shouldNot haveSolution(vec(-300, 1))
//        xAxis.common shouldNot haveSolution(vec(0, -1))
//    }
//
//}
//
//private fun haveSolution(vec: Vec) = matcher<CommonLineEquation> {
//    MatcherResult(
//        0.0.eq(a*vec.x + b*vec.y + c),
//        "$this should have solution: $vec",
//        "$this shouldn't have solution: $vec"
//    )
//}