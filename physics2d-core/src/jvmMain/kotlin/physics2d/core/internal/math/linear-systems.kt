package physics2d.core.internal.math

import Jama.Matrix

actual fun solveLinearSystem(a: Array<DoubleArray>, b: DoubleArray): DoubleArray {
    return try {
        val bVector = Matrix(b.map(::doubleArrayOf).toTypedArray())
        val x = Matrix(a)
            .solve(bVector)
            .columnPackedCopy
        x.truncate(b.size)
    } catch (e: Throwable) {
        error("cannot solve linear equations system: $e")
    }
}

private fun DoubleArray.truncate(size: Int): DoubleArray {
    return asList().subList(0, size).toDoubleArray()
}