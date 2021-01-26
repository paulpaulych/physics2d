package physics2d.core.internal

import Jama.Matrix

actual fun solveLinearEquationsSystem(a: Array<DoubleArray>, b: DoubleArray): DoubleArray =
    try {
        val x = Matrix(a)
            .solve(Matrix(b.map(::doubleArrayOf).toTypedArray()))
        x.columnPackedCopy.trunc(b.size)
    } catch (e: Throwable) {
        error("cannot solve linear equations system: $e")
    }

fun DoubleArray.trunc(size: Int) = asList().subList(0, size).toDoubleArray()