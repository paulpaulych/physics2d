package physics2d.core.api

data class Line internal constructor(
    val v1: Vec,
    val v2: Vec
) {
    init {
        require(v1 != v2) {
            "points must be different to create line"
        }
    }
}

object Lines {
    val xAxis = line(Vec(0.0, 0.0), Vec(1.0, 0.0))
    val yAxis = line(Vec(0.0, 0.0), Vec(0.0, 1.0))
}

fun line(vec1: Vec, vec2: Vec): Line = Line(vec1, vec2)

