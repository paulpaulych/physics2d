package physics2d.core.internal

import physics2d.core.api.Line
import physics2d.core.api.Pt
import physics2d.core.api.figures.AABB
import physics2d.core.api.pt

private const val MAX_VALUE = Double.MAX_VALUE
private const val MIN_VALUE = -Double.MAX_VALUE

internal fun Pt.projectTo(line: Line) = this + perpendicularTo(line)

internal fun AABB.projectTo(line: Line): Segment =
    pointsToProject()
        .map { it.projectTo(line) }
        .toSegmentOn(line)

private fun List<Pt>.toSegmentOn(line: Line): Segment {
    require(size >= 2) { "points list size must be greater than 1" }
    val maxPoint = Pt(MAX_VALUE, MAX_VALUE)
    val minPoint = Pt(MIN_VALUE, MIN_VALUE)
    val comparator = if(line.isVertical()) byY() else byX()
    val ends = fold(Pair(minPoint, maxPoint)) { (curMin, curMax), next ->
        Pair(min(next, curMin, comparator), max(next, curMax, comparator))
    }
    return Segment(ends.first, ends.second)
}

private fun Line.isVertical() = common.b.isZero()

// TODO: are half-widths needed?
private fun AABB.pointsToProject() = listOf(
    // angles
    p,
    p + pt(0.0, 2*wx),
    p + pt(2*wx, 0.0),
    p + pt(2*wx, 2*wx),
    // half-widths
    p + pt(0.0, hy),
    p + pt(wx, 0.0),
    p + pt(2*wx, hy),
    p + pt(wx, 2*hy),
)
