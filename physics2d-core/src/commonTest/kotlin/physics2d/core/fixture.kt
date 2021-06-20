package physics2d.core

import physics2d.core.api.line
import physics2d.core.api.vec

internal val yEqXLine = line(vec(0, 0), vec(1, 1))
internal val yEq2xPlus2 = line(vec(0, 2), vec(1, 4))
internal val yEqMinusX = line(vec(0, 0), vec(-1, 1))