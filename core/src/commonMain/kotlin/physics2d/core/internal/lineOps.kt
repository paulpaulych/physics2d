package physics2d.core.internal

import physics2d.core.api.Line
import physics2d.core.api.Pt
import kotlin.math.abs
import kotlin.math.sqrt

internal fun Line.normal() = Pt(common.a, common.b)

internal fun Pt.belongsTo(line: Line): Boolean {
    val (a, b) = line.points
    return crossProduct(this - a, this - b)?.isZero()
        ?: true
}

internal fun Pt.perpendicularTo(line: Line): Pt =
    line.normal()
        .resizeToLen(distanceTo(line))
        .directFromTo(this, line)

internal fun Pt.distanceTo(line: Line): Double {
    val (a, b, c) = line.common
    return abs(a*x + b*y + c) / sqrt(a*a + b*b)
}

private fun Pt.directFromTo(fromPt: Pt, toLine: Line): Pt {
    val revertNeeded =
        (this + fromPt).distanceTo(toLine) > (this-fromPt).distanceTo(toLine)
    return if(revertNeeded) -this else this
}
