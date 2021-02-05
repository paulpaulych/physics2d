package physics2d.core.api

import physics2d.core.internal.eq
import kotlin.math.roundToInt
import kotlin.math.sqrt

data class Pt internal constructor(val x: Double, val y: Double){

    operator fun minus(o: Pt): Pt = Pt(o.x - x, o.y - y)
    operator fun plus(o: Pt): Pt = Pt(o.x + x, o.y + y)
    operator fun unaryMinus() = Pt(-x, -y)
    operator fun Double.times(p: Pt): Pt = Pt(p.x*this, p.y*this)

    override fun equals(other: Any?) = when {
        this === other -> true
        other == null -> false
        other !is Pt -> false
        !x.eq(other.x) -> false
        !y.eq(other.y) -> false
        else -> true
    }

    override fun hashCode() = 31 * x.roundToInt() + y.roundToInt()

    val len by lazy { sqrt(x*x + y*y) }
}

fun pt(x: Int, y: Int) = Pt(x.toDouble(), y.toDouble())
fun pt(x: Double, y: Double) = Pt(x, y)
