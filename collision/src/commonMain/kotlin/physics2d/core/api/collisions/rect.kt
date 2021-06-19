package physics2d.core.api.collisions

import physics2d.core.api.Lines.xAxis
import physics2d.core.api.Lines.yAxis
import physics2d.core.api.Rect
import physics2d.core.api.Segment
import physics2d.core.api.Vec
import physics2d.core.internal.*
import physics2d.core.internal.intersectionOf
import physics2d.core.internal.len

data class Collision internal constructor(
    val v: Vec,
    val len: Double)

fun collisionFor(a: Rect, b: Rect): Collision? {
    val axes = separationAxesFor(a, b)
    val projections = axes.fold(listOf<Segment>()) { intersections, axis ->
        val intersection = intersectionOf(
            projection(of = a, onto = axis),
            projection(of = b, onto = axis)
        )
        if(intersection == null) intersections
        else intersections + intersection
    }
    return projections.associateWith(Segment::len)
        .minByOrNull { it.value }
        ?.let { (v, len) -> Collision(v.p2 - v.p1, len) }
}

private fun separationAxesFor(a: Rect, b: Rect) = listOf(xAxis, yAxis)