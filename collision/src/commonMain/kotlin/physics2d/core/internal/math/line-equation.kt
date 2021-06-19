package physics2d.core.internal.math

import physics2d.core.api.Vec
import physics2d.core.internal.anyOrthogonalFor
import physics2d.core.internal.isZero

internal data class CommonLineEquation(
    val a: Double,
    val b: Double,
    val c: Double
) {
    init {
        require(!a.isZero() || !b.isZero()){
            "A and B cannot be both equal to zero"
        }
    }
}

internal fun standardFormedLineEquation(p1: Vec, p2: Vec): CommonLineEquation {
    val directingVector = p2 - p1
    val normal = anyOrthogonalFor(directingVector)
        ?: error("no orthogonal vectors for: $directingVector")
    val (a, b) = normal
    val c = (a*(p2.x + p1.x) + b*(p2.y + p1.y)) / (-2)
    return CommonLineEquation(a, b, c)
}