package physics2d.core.internal

import physics2d.core.api.Line
import physics2d.core.api.Pt
import physics2d.core.api.normal
import kotlin.math.sqrt

internal fun Pt.belongsTo(line: Line): Boolean {
    val (a, b) = line.points
    return vectorProduct(this, a - b).isZero()
}

internal fun Pt.distanceTo(line: Line) = line.common
    .let { (a, b, c) -> (a*x + b*y + c) / sqrt(a*a + b*b) }

internal fun Pt.perpendicularVectorTo(line: Line): Pt {
    val directingVector = line.normal()
        .truncateByLen(distanceTo(line))
        .directedFromTo(this, line)
    return this + directingVector
}

internal fun Pt.directedFromTo(fromPt: Pt, toLine: Line): Pt {
    val revertNeeded =
        (this + fromPt).distanceTo(toLine) > (this-fromPt).distanceTo(toLine)
    return if(revertNeeded) -this else this
}