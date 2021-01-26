package physics2d.core

import physics2d.core.api.line
import physics2d.core.api.pt

internal val yEqZeroLine = line(pt(0, 0), pt(1, 0))
internal val yEqXLine = line(pt(0, 0), pt(1, 1))
internal val yEq2xPlus2 = line(pt(0, 2), pt(1, 4))