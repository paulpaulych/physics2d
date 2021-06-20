package physics2d.core.internal.math

import physics2d.core.api.Vec
import physics2d.core.internal.isNotZero
import kotlin.math.sqrt

internal fun crossProduct(a: Vec, b: Vec): Double? =
    (a.len*b.len).takeIf(Double::isNotZero)
        ?.times(absSinBetween(a, b))

internal fun absSinBetween(a: Vec, b: Vec) = cosToSin(absCosBetween(a, b))

internal fun absCosBetween(a: Vec, b: Vec) = dotProduct(a, b) / (a.len * b.len)

internal fun dotProduct(a: Vec, b: Vec) = a.x*b.x + a.y*b.y

private fun cosToSin(cos: Double): Double {
    return sqrt(1 - cos*cos)
}
