package physics2d.core.internal

import physics2d.core.api.Line
import physics2d.core.api.Pt
import physics2d.core.api.normal
import kotlin.math.abs
import kotlin.math.sqrt

internal fun Pt.belongsTo(line: Line): Boolean {
    val (a, b) = line.points
    return vectorProduct(this - a, this - b)?.isZero()
        ?: true
}

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

internal fun Pt.distanceTo(line: Line): Double {
    val (a, b, c) = line.common
    return abs(a*x + b*y + c) / sqrt(a*a + b*b)
}
