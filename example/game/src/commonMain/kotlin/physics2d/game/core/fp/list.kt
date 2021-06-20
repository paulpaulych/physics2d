package physics2d.game.core.fp

sealed class List<out A> {

    object Nil : List<Nothing>()

    data class Cons<out A>(
        val head: A,
        val tail: List<A>
    ) : List<A>()

    companion object {

        fun <A> empty(): List<A> = Nil
        fun <A> cons(head: A, tail: List<A>): List<A> = Cons(head, tail)
        fun <A> of(vararg aa: A): List<A> {
            val tail = aa.sliceArray(1 until aa.size)
            return if (aa.isEmpty()) Nil else Cons(aa[0], of(*tail))
        }

        fun <A> tail(xs: List<A>): List<A> = when(xs) {
            Nil -> error("Nil cannot have a `tail`")
            is Cons -> xs.tail
        }

        fun <A> replaceHead(xs: List<A>, x: A): List<A> = when (xs) {
            is Nil -> error("Cannot replace `head` of a Nil list")
            is Cons -> Cons(x, xs.tail)
        }

        tailrec fun <A> drop(l: List<A>, n: Int): List<A> =
            if (n == 0) l
            else when (l) {
                is Cons -> drop(l.tail, n - 1)
                is Nil -> error("Cannot drop more elements than in list")
            }

        tailrec fun <A> dropWhile(l: List<A>, f: (A) -> Boolean): List<A> =
            when (l) {
                is Cons -> if (f(l.head)) dropWhile(l.tail, f) else l
                is Nil -> l
            }

        fun <A> init(l: List<A>): List<A> = when (l) {
            is Cons -> when(l.tail) {
                Nil -> Nil
                is Cons -> Cons(l.head, init(l.tail))
            }
            is Nil -> error("Cannot init Nil list")
        }

        fun <A, B> List<A>.foldRight(
            z: B,
            f: (A, B) -> B
        ): B = when (this) {
            is Nil -> z
            is Cons -> f(head, tail.foldRight(z, f))
        }

        fun <A> List<A>.length(): Int =
            foldRight(0) { _, acc -> acc + 1 }

        tailrec fun <A, B> List<A>.foldLeft(
            z: B,
            f: (B, A) -> B
        ): B = when (this) {
            is Nil -> z
            is Cons -> tail.foldLeft(f(z, head), f)
        }
    }
}
