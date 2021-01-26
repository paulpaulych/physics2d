package physics2d.core.internal

@JsModule("linear-solve")
@JsNonModule
external object LinearSystems {
    fun solve(a: Array<Array<Double>>, b: Array<Double>): Array<Double>
}

actual fun solveLinearEquationsSystem(a: Array<DoubleArray>, b: DoubleArray): DoubleArray =
    try {
        LinearSystems.solve(a.map { it.toTypedArray() }.toTypedArray(), b.toTypedArray()).toDoubleArray()
    } catch (e: Throwable) {
        error("cannot solve linear equations system: $e")
    }
