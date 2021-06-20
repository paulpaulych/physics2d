package physics2d.core.internal.math

@JsModule("linear-solve")
@JsNonModule
external object LinearSystems {
    fun solve(a: Array<Array<Double>>, b: Array<Double>): Array<Double>
}

actual fun solveLinearSystem(a: Array<DoubleArray>, b: DoubleArray): DoubleArray {
    return try {
        LinearSystems.solve(a.map { it.toTypedArray() }.toTypedArray(), b.toTypedArray()).toDoubleArray()
    } catch (e: Throwable) {
        error("cannot solve linear equations system: $e")
    }
}

