package physics2d.core.internal

import physics2d.core.api.Line
import physics2d.core.api.Vec
import physics2d.core.api.Segment
import physics2d.core.api.Rect
import physics2d.core.api.vec
import physics2d.core.internal.math.standardFormedLineEquation

private const val MAX_VALUE = Double.MAX_VALUE
private const val MIN_VALUE = -Double.MAX_VALUE

fun projection(of: Vec, onto: Line): Vec {
    return of + of.perpendicularTo(onto)
}

fun projection(of: Rect, onto: Line): Segment {
    val rect = of
    val line = onto
    val cornerProjections =  cornerPointsOf(rect)
        .map { v -> projection(v, line) }
    return cornerProjections.toSegmentOn(line)
}

private fun List<Vec>.toSegmentOn(line: Line): Segment {
    require(size >= 2) { "points list size must be greater than 1" }
    val maxPoint = Vec(MAX_VALUE, MAX_VALUE)
    val minPoint = Vec(MIN_VALUE, MIN_VALUE)
    val comparator = if(isVertical(line)) byY() else byX()
    val ends = fold(Pair(minPoint, maxPoint)) { (curMin, curMax), next ->
        Pair(min(next, curMin, comparator), max(next, curMax, comparator))
    }
    return Segment(ends.first, ends.second)
}

private fun isVertical(line: Line): Boolean {
    val equation = standardFormedLineEquation(line.v1, line.v2)
    return equation.b.isZero()
}

private fun cornerPointsOf(rect: Rect): List<Vec> {
    return listOf(
        rect.start,
        rect.start + vec(0.0, rect.size.y),
        rect.start + vec(rect.size.x, 0.0),
        rect.start + rect.size
    )
}

private fun byX() = Comparator<Vec> { a, b -> a.x.compareTo(b.x) }
private fun byY() = Comparator<Vec> { a, b -> a.y.compareTo(b.y) }

