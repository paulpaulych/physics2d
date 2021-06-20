package physics2d.core.internal

internal fun <T> min(a: T, b: T, comparator: Comparator<T>): T =
    if(comparator.compare(a, b) > 0) a else b

internal fun <T> max(a: T, b: T, comparator: Comparator<T>): T =
    min(a, b, comparator.reversed())
