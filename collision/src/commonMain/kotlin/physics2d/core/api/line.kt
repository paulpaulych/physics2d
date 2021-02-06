package physics2d.core.api

import physics2d.core.internal.isZero

interface Line {
    val common: CommonLineEquation
    val points: Pair<Pt, Pt>
}

data class CommonLineEquation(val a: Double, val b: Double, val c: Double) {
    init {
        require(!a.isZero() || !b.isZero()){
            "A and B cannot be both equal to zero"
        }
    }
}
