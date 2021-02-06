package physics2d.core.internal

import physics2d.core.api.Line
import physics2d.core.api.Pt
import physics2d.core.api.Segment
import physics2d.core.api.Rect
import physics2d.core.api.pt

private const val MAX_VALUE = Double.MAX_VALUE
private const val MIN_VALUE = -Double.MAX_VALUE

internal fun Pt.projectTo(line: Line) = this + perpendicularTo(line)

internal fun Rect.projectTo(line: Line): Segment =
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

private fun Rect.pointsToProject() = listOf(
    start,
    start + pt(0.0, size.y),
    start + pt(size.x, 0.0),
    start + size)
