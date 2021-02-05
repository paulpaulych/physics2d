package physics2d.core.internal

import physics2d.core.api.Line
import physics2d.core.api.Pt
import physics2d.core.api.Segment
import physics2d.core.api.line
import kotlin.math.max
import kotlin.math.min

internal fun Segment.len() = (p2 - p1).len

//TODO: переписать как-нибудь более адекватно
internal fun Pt.belongsTo(segment: Segment): Boolean {
    val (p1, p2) = segment
    if(p1.x.eq(p2.x)) {
        val min = min(p1.y, p2.y)
        val max = max(p1.y, p2.y)
        return x.eq(p1.x) && y in min..max
    }
    if(p1.y.eq(p2.y)) {
        val min = min(p1.x, p2.x)
        val max = max(p1.x, p2.x)
        return y.eq(p1.y) && x in min..max
    }
    val p = (x - p2.x) / (p1.x - p2.x)
    if(p !in (0.0..1.1)){
        return false
    }
    if (p != (y - p2.y) / (p1.y - p2.y)){
        return false
    }
    return true
}

internal fun Segment.belongsTo(line: Line) =
    p1.belongsTo(line) && p2.belongsTo(line)

internal fun intersectionOf(a: Segment, b: Segment): Segment? {
    require(a.belongsTo(line(b.p1, b.p2))){
        "cannot find intersection of segment which not belong to the same line"
    }
    return intersectionPts(a, b)
        .takeIf { it.size == 2 }
        ?.let { Segment(it.first(), it.last()) }
}

private fun intersectionPts(a: Segment, b: Segment): Set<Pt> {
    val aEndsOnb = listOf(a.p1, a.p2).filter { it.belongsTo(b) }
    val bEndsOnA = listOf(b.p1, b.p2).filter { it.belongsTo(a) }
    return (aEndsOnb + bEndsOnA).toSet()
}
