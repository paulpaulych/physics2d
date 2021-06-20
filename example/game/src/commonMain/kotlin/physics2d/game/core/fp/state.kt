package physics2d.game.core.fp

import physics2d.game.core.fp.List.Companion.cons
import physics2d.game.core.fp.List.Companion.empty
import physics2d.game.core.fp.List.Companion.foldRight

data class State<S, out A>(
    val run: (S) -> Pair<A, S>
) {
    companion object {

        fun <S, A> unit(a: A): State<S, A> = State { s -> a to s }

        fun <S, A, B, C> map2(
            ra: State<S, A>,
            rb: State<S, B>,
            f: (A, B) -> C
        ): State<S, C> = ra.flatMap { a ->
            rb.map { b ->
                f(a, b)
            }
        }

        fun <S, A> sequence(fs: List<State<S, A>>): State<S, List<A>> {
            return fs.foldRight(unit(empty())) { f, cur ->
                map2(f, cur, ::cons)
            }
        }
    }

    fun <B> map(f: (A) -> B): State<S, B> =
        flatMap { a -> unit(f(a)) }

    fun <B> flatMap(f: (A) -> State<S, B>): State<S, B> =
        State { s ->
            val (a, s2) = this.run(s)
            f(a).run(s2)
        }
}

fun <S> get(): State<S, S> = State { s -> Pair(s, s) }

fun <S> set(s: S): State<S, Unit> = State { Unit to s }

fun <S> modify(f: (S) -> S): State<S, Unit> =
     get<S>().flatMap { s -> set(s) }


