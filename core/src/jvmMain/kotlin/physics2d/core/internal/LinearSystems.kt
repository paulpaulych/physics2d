package physics2d.core.internal

import mikera.matrixx.Matrix
import mikera.matrixx.solve.Linear

actual fun solveLinearEquationsSystem(a: List<List<Double>>, b: List<Double>): Array<Double> =
    try {
        
        val a = Matrix()
        Linear.solve()
        //
//        LinearSystems.solve(
//            a.map(List<Double>::toTypedArray).toTypedArray(),
//            b.toTypedArray())
    } catch (e: Throwable) {
        error("cannot solve linear equations system: $e")
    }
