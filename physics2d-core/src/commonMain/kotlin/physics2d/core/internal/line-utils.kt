package physics2d.core.internal

import physics2d.core.api.Line
import physics2d.core.api.Vec
import physics2d.core.api.vec
import physics2d.core.internal.math.crossProduct
import physics2d.core.internal.math.standardFormedLineEquation
import kotlin.math.abs
import kotlin.math.sqrt

internal fun Vec.belongsTo(line: Line): Boolean =
    crossProduct(this - line.v1, this - line.v2)
        ?.isZero()
        ?: true

internal fun Vec.perpendicularTo(line: Line): Vec =
    normalVectorFor(line)
        .resizeToLen(distanceTo(line))
        .directFromTo(this, line)


internal fun Vec.distanceTo(line: Line): Double {
    val (a, b, c) = standardFormedLineEquation(line.v1, line.v2)
    return abs(a*x + b*y + c) / sqrt(a*a + b*b)
}

private fun normalVectorFor(line: Line): Vec =
    standardFormedLineEquation(line.v1, line.v2)
        .let { (a, b, _) -> Vec(a, b)}

private fun Vec.directFromTo(fromVec: Vec, toLine: Line): Vec {
    val revertNeeded =
        (this + fromVec).distanceTo(toLine) > (this-fromVec).distanceTo(toLine)
    return if(revertNeeded) -this else this
}

internal fun Vec.resizeToLen(requiredLen: Double): Vec {
    if(requiredLen.isZero()){
        return vec(0, 0)
    }
    require(requiredLen > 0) {
        "required len must be non-negative. Given: $requiredLen"
    }
    return (requiredLen / len) * this
}

internal fun anyOrthogonalFor(vec: Vec): Vec? = when {
    vec.x.isNotZero() -> Vec(-vec.y / vec.x, 1.0)
    vec.y.isNotZero() -> Vec(1.0, -vec.x / vec.y)
    else -> null
}
