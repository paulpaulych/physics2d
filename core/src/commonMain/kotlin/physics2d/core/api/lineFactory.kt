package physics2d.core.api

import physics2d.core.internal.LineImpl

val xAxis = line(Pt(0.0, 0.0), Pt(1.0, 0.0))
val yAxis = line(Pt(0.0, 0.0), Pt(0.0, 1.0))

fun line(pt1: Pt, pt2: Pt): Line = LineImpl(pt1, pt2)
