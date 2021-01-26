package physics2d.core.internal

expect fun solveLinearEquationsSystem(
    a: List<List<Double>>,
    b: List<Double>
): Array<Double>
