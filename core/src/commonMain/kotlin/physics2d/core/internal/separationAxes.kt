package physics2d.core.internal

import physics2d.core.api.figures.AABB
import physics2d.core.api.xAxis
import physics2d.core.api.yAxis

fun separationAxesFor(a: AABB, b: AABB) = listOf(xAxis, yAxis)