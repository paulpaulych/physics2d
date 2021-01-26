package physics2d.core.internal

@JsModule("linear-solve")
@JsNonModule
external object LinearSystems {
    fun solve(a: Array<Array<Double>>, b: Array<Double>): Array<Double>
}

actual fun solveLinearEquationsSystem(a: List<List<Double>>, b: List<Double>): Array<Double> =
    try {
        LinearSystems.solve(
            a.map(List<Double>::toTypedArray).toTypedArray(),
            b.toTypedArray())
    } catch (e: Throwable) {
        error("cannot solve linear equations system: $e")
    }
