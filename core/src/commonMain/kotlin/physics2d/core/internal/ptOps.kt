package physics2d.core.internal

import physics2d.core.api.Pt

internal fun vectorProduct(a: Pt, b: Pt): Double? =
    (a.len*b.len).takeIf(Double::isNotZero)
        ?.times(absSinBetween(a, b))

internal fun absSinBetween(a: Pt, b: Pt) = cosToSin(absCosBetween(a, b))

internal fun absCosBetween(a: Pt, b: Pt) = scalarProduct(a, b) / (a.len * b.len)

internal fun scalarProduct(a: Pt, b: Pt) = a.x*b.x + a.y*b.y

internal fun Pt.truncateByLen(requiredLen: Double): Pt {
    require(requiredLen > 0) { "required len must be positive" }
    return requiredLen / len * this
}

internal fun anyOrthogonalFor(pt: Pt) = Pt(1.0, -pt.x/pt.y)

internal operator fun Int.times(p: Pt): Pt = Pt(p.x*this, p.y*this)
