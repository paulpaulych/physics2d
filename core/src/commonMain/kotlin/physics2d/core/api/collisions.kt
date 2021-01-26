package physics2d.core.api

import physics2d.core.api.figures.AABB
import physics2d.core.internal.*
import physics2d.core.internal.intersectionOf
import physics2d.core.internal.len

data class Collision(val v: Segment)

fun collisionFor(a: AABB, b: AABB): Collision? {
    val intersectionsByAxes: List<Segment> =
        separationAxesFor(a, b)
            .fold(listOf<Segment>()) { intersectionsOfProjections, axis ->
                intersectionOf(a.projectionTo(axis), b.projectionTo(axis))
                    ?.let { intersectionsOfProjections + it }
                    ?: intersectionsOfProjections
            }
    return intersectionsByAxes.minByOrNull(Segment::len)?.let(::Collision)
}
