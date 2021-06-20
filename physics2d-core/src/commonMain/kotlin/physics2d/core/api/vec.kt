package physics2d.core.api

import physics2d.core.internal.eq
import kotlin.math.roundToInt
import kotlin.math.sqrt

data class Vec internal constructor(
    val x: Double,
    val y: Double
){

    operator fun minus(o: Vec): Vec = Vec(o.x - x, o.y - y)
    operator fun plus(o: Vec): Vec = Vec(o.x + x, o.y + y)
    operator fun unaryMinus() = Vec(-x, -y)
    operator fun Double.times(p: Vec): Vec = Vec(p.x*this, p.y*this)

    override fun equals(other: Any?) = when {
        this === other -> true
        other == null -> false
        other !is Vec -> false
        !x.eq(other.x) -> false
        !y.eq(other.y) -> false
        else -> true
    }

    override fun hashCode() = 31 * x.roundToInt() + y.roundToInt()

    val len by lazy { sqrt(x*x + y*y) }
}

fun vec(x: Int, y: Int) = Vec(x.toDouble(), y.toDouble())
fun vec(x: Double, y: Double) = Vec(x, y)

internal operator fun Int.times(p: Vec): Vec = Vec(p.x*this, p.y*this)
