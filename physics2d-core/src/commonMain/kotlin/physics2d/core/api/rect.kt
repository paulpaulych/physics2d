package physics2d.core.api

data class Rect internal constructor(
    val start: Vec,
    val size: Vec)

fun rect(from: Vec, to: Vec) = Rect(from, to)
