package physics2d.core.api.figures

import physics2d.core.api.Pt
import physics2d.core.api.pt

data class AABB internal constructor(
    val p: Pt,
    val wx: Double,
    val hy: Double){

    init {
        require(wx > 0) { "x-half-wide must be positive, given = $wx"}
        require(hy > 0) { "y-half-wide must be positive, given = $hy"}
    }
}

fun aabb(x: Double, y: Double, wx: Double, hy: Double) =
    AABB(pt(x, y), wx, hy)

fun aabb(x: Int, y: Int, wx: Int, hy: Int) =
    AABB(pt(x, y), wx.toDouble(), hy.toDouble())

fun aabb(p: Pt, wx: Int, hy: Int) =
    AABB(p, wx.toDouble(), hy.toDouble())