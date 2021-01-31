package physics2d.core.internal

import physics2d.core.api.Pt
import physics2d.core.api.pt

internal fun crossProduct(a: Pt, b: Pt): Double? =
    (a.len*b.len).takeIf(Double::isNotZero)
        ?.times(absSinBetween(a, b))

internal fun absSinBetween(a: Pt, b: Pt) = cosToSin(absCosBetween(a, b))

internal fun absCosBetween(a: Pt, b: Pt) = dotProduct(a, b) / (a.len * b.len)

internal fun dotProduct(a: Pt, b: Pt) = a.x*b.x + a.y*b.y

internal fun Pt.resizeToLen(requiredLen: Double): Pt {
    if(requiredLen.isZero()){
        return pt(0, 0)
    }
    require(requiredLen > 0) { "required len must not be negative. Given: $requiredLen" }
    return (requiredLen / len) * this
}

internal fun anyOrthogonalFor(pt: Pt): Pt? = when {
    pt.x.isNotZero() -> Pt(-pt.y / pt.x, 1.0)
    pt.y.isNotZero() -> Pt(1.0, -pt.x / pt.y)
    else -> null
}

internal operator fun Int.times(p: Pt): Pt = Pt(p.x*this, p.y*this)

internal fun byX() = Comparator<Pt> { a, b -> a.x.compareTo(b.x) }
internal fun byY() = Comparator<Pt> { a, b -> a.y.compareTo(b.y) }