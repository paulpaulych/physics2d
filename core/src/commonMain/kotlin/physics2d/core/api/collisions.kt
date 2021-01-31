package physics2d.core.api

import physics2d.core.api.figures.AABB
import physics2d.core.internal.*
import physics2d.core.internal.intersectionOf
import physics2d.core.internal.len

data class Collision(val v: Segment)

fun collisionFor(a: AABB, b: AABB): Collision? {
    val axes = separationAxesFor(a, b)
    val projections = axes.fold(listOf<Segment>()) { acc, axis ->
        val aProj = a.projectTo(axis)
        val bProj = b.projectTo(axis)
        val intersection = intersectionOf(aProj, bProj)
        acc.addIfNotNull(intersection)
    }
    return projections.minByOrNull(Segment::len)
        ?.let(::Collision)
}
