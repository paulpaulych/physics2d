package physics2d.core.api

data class Rect internal constructor(
    val start: Pt,
    val size: Pt)

fun rect(from: Pt, to: Pt) =
    Rect(from, to)
