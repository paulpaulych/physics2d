package physics2d.core.api

data class Segment internal constructor(
    val p1: Vec,
    val p2: Vec
) {

    init {
        require(p1 != p2) {
            "segment length must be positive, given points: p1=$p1, p2=$p2"
        }
    }

    override fun equals(other: Any?) = when {
        this === other -> true
        other == null -> false
        other !is Segment -> false
        p1 == other.p1 &&  p2 == other.p2-> true
        p1 == other.p2 &&  p2 == other.p1-> true
        else -> false
    }

    override fun hashCode() = 31 * (p1.hashCode() + p2.hashCode())
}
