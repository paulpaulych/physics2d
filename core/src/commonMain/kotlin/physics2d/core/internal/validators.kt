package physics2d.core.internal

internal fun requireNotZero(v: Double) =
    require(v.isNotZero()){ "B must not be zero" }
