package physics2d.core.internal

import physics2d.core.api.figures.AABB
import physics2d.core.api.xAxes
import physics2d.core.api.yAxes

fun separationAxesFor(a: AABB, b: AABB) = listOf(xAxes, yAxes)