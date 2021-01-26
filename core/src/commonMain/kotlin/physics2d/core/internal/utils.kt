package physics2d.core.internal
import kotlin.math.abs

fun Double.isZero() = abs(this) < 0.00001
fun Double.isNotZero() = !isZero()
fun Double.eq(other: Double) = (this - other) < 0.00001

val l = ListBuilder()
class ListBuilder {
    operator fun <T> get(vararg values: T) = values.toList()
}

val ar = ArrayBuilder()
class ArrayBuilder {
    operator fun <T> get(vararg values: T) = values
}

