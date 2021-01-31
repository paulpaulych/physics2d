package physics2d.core.internal

import physics2d.core.api.CommonLineEquation
import physics2d.core.api.Line
import physics2d.core.api.Pt

internal class LineImpl(p1: Pt, p2: Pt): Line {

    override val points = Pair(p1, p2)
    override val common by lazy { commonLineEquation(p1, p2) }

    init {
        require(p1 != p2) { "points must be different to create line" }
    }

    override fun toString() = "LineImpl(points=$points)"
}

private fun commonLineEquation(p1: Pt, p2: Pt): CommonLineEquation {
    val directingVector = p2 - p1
    val normal = anyOrthogonalFor(directingVector)
        ?: error("no orthogonal vectors for: $directingVector")
    val (a, b) = normal
    val c = (a*(p2.x + p1.x) + b*(p2.y + p1.y)) / (-2)
    return CommonLineEquation(a, b, c)
}