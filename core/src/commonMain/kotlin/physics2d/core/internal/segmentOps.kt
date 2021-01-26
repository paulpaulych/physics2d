package physics2d.core.internal

import physics2d.core.api.Line
import physics2d.core.api.Pt
import physics2d.core.api.line

internal fun Segment.len() = (to - from).len

internal fun Pt.belongsTo(lineSegment: Segment): Boolean {
    val (from, to) = lineSegment
    return to-from == (this-from) + (to-this)
}

internal fun Segment.belongsTo(line: Line) = from.belongsTo(line) && to.belongsTo(line)

internal fun intersectionOf(a: Segment, b: Segment): Segment? {
    require(a.belongsTo(line(b.from, b.to))){
        "cannot find intersection of segment which not belong to the same line"
    }
    //TODO: выпилить
    fun List<Pt>.validation() {
        if(size != 0 || size != 2){
            error("invalid size of intersection array: $this")
        }
    }
    return intersectionPts(a, b).apply(List<Pt>::validation).takeIf { it.size == 2 }
        ?.let { Segment(it[0], it[1]) }
}

private fun intersectionPts(a: Segment, b: Segment) =
    listOf(a.from, a.to).filter { it.belongsTo(b) } +
        listOf(b.from, b.to).filter { it.belongsTo(a) }
