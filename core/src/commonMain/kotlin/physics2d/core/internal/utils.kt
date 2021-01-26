package physics2d.core.internal
import kotlin.math.abs
import kotlin.math.sqrt

internal fun Double.isZero() = abs(this) < 0.00001
internal fun Double.isNotZero() = !isZero()
internal fun Double.eq(other: Double) = abs(this - other) < 0.00001
internal fun cosToSin(cos: Double) = sqrt(1 - cos*cos)

val l = ListBuilder()
class ListBuilder {
    operator fun <T> get(vararg values: T) = values.toList()
}

val ar = ArrayBuilder()
@Suppress("UNCHECKED_CAST")
class ArrayBuilder {
    inline operator fun <reified T> get(vararg values: T) = values as Array<T>
    operator fun get(vararg values: Double): DoubleArray = values
}
