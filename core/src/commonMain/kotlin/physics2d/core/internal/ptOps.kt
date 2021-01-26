package physics2d.core.internal

import physics2d.core.api.Pt
import kotlin.math.sqrt

internal fun vectorProduct(a: Pt, b: Pt) = a.len * b.len * sinBetween(a, b)

internal fun cosBetween(a: Pt, b: Pt) = scalarProduct(a, b) / (a.len * b.len)

internal fun sinBetween(a: Pt, b: Pt) = cosBetween(a, b).let { sqrt(1 - it*it) }

internal fun scalarProduct(a: Pt, b: Pt): Double = a.x*b.x + a.y*b.y

internal fun Pt.truncateByLen(requiredLen: Double) = requiredLen / len * this

internal fun anyOrthogonalFor(pt: Pt) = Pt(1.0, -pt.x/pt.y)

//fun Line.yByX(x: Double): PointsRes = when {
//    isXConstant() -> if ((c/a - x).isZero()) Continuum else None
//    else -> Single(-(c + a*x)/b)
//}
//
//fun Line.xByY(y: Double): PointsRes = when {
//    isYConstant() -> if ((c/b - y).isZero()) Continuum else None
//    else -> Single(-(c + b*y)/a)
//}

//sealed class PointsRes {
//    object None: PointsRes()
//    object Continuum: PointsRes()
//    class Single(value: Double): PointsRes()
//}
//
//fun Line.isXConstant() = common.b.isZero()
//fun Line.isYConstant() = common.a.isZero()

internal operator fun Int.times(p: Pt): Pt = Pt(p.x*this, p.y*this)
