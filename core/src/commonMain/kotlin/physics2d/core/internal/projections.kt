package physics2d.core.internal

import physics2d.core.api.Line
import physics2d.core.api.Pt
import physics2d.core.api.figures.AABB
import physics2d.core.api.pt
import kotlin.Double.Companion.MAX_VALUE
import kotlin.Double.Companion.MIN_VALUE

internal fun Pt.projectionTo(line: Line) = this + perpendicularVectorTo(line)

internal fun AABB.projectionTo(line: Line): Segment =
    pointsToProject()
        .map { it.projectionTo(line) }
        .extremePointsOnOneLine()
        .let { Segment(it.first, it.second) }

private fun List<Pt>.extremePointsOnOneLine(): Pair<Pt, Pt> {
    val leftTopPoint = Pt(MIN_VALUE, MIN_VALUE)
    val rightBottomPoint = Pt(MAX_VALUE, MAX_VALUE)
    val init = leftTopPoint to rightBottomPoint
    return fold(init) { (curMin, curMax), next ->
        val nexMin = if(next.x < curMin.x || next.y < curMin.y)
            next else curMin
        val nexMax = if(next.x > curMin.x || next.y > curMin.y)
            next else curMax
        nexMin to nexMax
    }
}

private fun AABB.pointsToProject() = listOf(
    // angles
    pt(x, y),
    Pt(x, x + 2*wx),
    Pt(x + 2*wx, y),
    Pt(x + 2*wx, x + 2*wx),
    // half-widths
    Pt(x, y + hy),
    Pt(x + wx, y),
    Pt(x + 2*wx, y + hy),
    Pt(x + wx, y + 2 * hy)
)
