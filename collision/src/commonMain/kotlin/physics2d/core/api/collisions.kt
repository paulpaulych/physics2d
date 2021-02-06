package physics2d.core.api

import physics2d.core.internal.*
import physics2d.core.internal.intersectionOf
import physics2d.core.internal.len

data class Collision internal constructor(
    val segment: Segment,
    val len: Double)

fun collisionFor(a: AABB, b: AABB): Collision? {
    val axes = separationAxesFor(a, b)
    val projections = axes.fold(listOf<Segment>()) { acc, axis ->
        val aProj = a.projectTo(axis)
        val bProj = b.projectTo(axis)
        val intersection = intersectionOf(aProj, bProj)
        acc.addIfNotNull(intersection)
    }
    return projections.associateWith(Segment::len)
        .minByOrNull { it.value }
        ?.let { (v, len) -> Collision(v, len) }
}
