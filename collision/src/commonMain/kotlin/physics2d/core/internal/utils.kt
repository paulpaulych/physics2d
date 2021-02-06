package physics2d.core.internal
import kotlin.math.abs
import kotlin.math.sqrt

internal fun Double.isZero() = abs(this) < 0.00001
internal fun Double.isNotZero() = !isZero()
internal fun Double.eq(other: Double) = abs(this - other) < 0.00001
internal fun cosToSin(cos: Double) = sqrt(1 - cos*cos)

internal val l = ListBuilder()
internal class ListBuilder {
    operator fun <T> get(vararg values: T) = values.toList()
}

internal val ar = ArrayBuilder()
@Suppress("UNCHECKED_CAST")
internal class ArrayBuilder {
    inline operator fun <reified T> get(vararg values: T) = values as Array<T>
    operator fun get(vararg values: Double): DoubleArray = values
}

internal fun <T> List<T>.addIfNotNull(e: T?): List<T> =
    if(e == null) this else this + e

internal fun <T> min(a: T, b: T, comparator: Comparator<T>): T =
    if(comparator.compare(a, b) > 0) a else b

internal fun <T> max(a: T, b: T, comparator: Comparator<T>): T =
    min(a, b, comparator.reversed())
