package physics2d.core.internal

import Jama.Matrix

actual fun solveLinearEquationsSystem(a: Array<DoubleArray>, b: DoubleArray): DoubleArray =
    try {
        val bVector = Matrix(b.map(::doubleArrayOf).toTypedArray())
        val x = Matrix(a).solve(bVector)
        x.columnPackedCopy.truncate(b.size)
    } catch (e: Throwable) {
        error("cannot solve linear equations system: $e")
    }

private fun DoubleArray.truncate(size: Int) = asList().subList(0, size).toDoubleArray()