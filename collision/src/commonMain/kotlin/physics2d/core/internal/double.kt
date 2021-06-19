package physics2d.core.internal

import kotlin.math.abs

internal fun Double.isZero() = abs(this) < 0.00001
internal fun Double.isNotZero() = !isZero()
internal fun Double.eq(other: Double) = abs(this - other) < 0.00001
