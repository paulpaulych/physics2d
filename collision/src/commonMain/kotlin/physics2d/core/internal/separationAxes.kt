package physics2d.core.internal

import physics2d.core.api.Rect
import physics2d.core.api.xAxis
import physics2d.core.api.yAxis

fun separationAxesFor(a: Rect, b: Rect) = listOf(xAxis, yAxis)