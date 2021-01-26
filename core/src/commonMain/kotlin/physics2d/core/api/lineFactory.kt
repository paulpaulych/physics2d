package physics2d.core.api

import physics2d.core.internal.LineImpl

val xAxes = line(Pt(0.0, 0.0), Pt(1.0, 0.0))
val yAxes = line(Pt(0.0, 0.0), Pt(0.0, 1.0))
fun line(pt1: Pt, pt2: Pt): Line = LineImpl(pt1, pt2)
