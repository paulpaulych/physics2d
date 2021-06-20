package physics2d.core

import io.kotest.assertions.withClue
import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import physics2d.core.api.Vec
import physics2d.core.internal.eq
import io.kotest.matchers.collections.beIn as beInMatcher

infix fun <T> Iterable<T>.forEachAssert(match: (T) -> Unit) {
    forEach { cur ->
        withClue("given collection item: $cur"){
            match(cur)
        }
    }
}

fun beDouble(other: Double) = matcher<Double?> {
    MatcherResult(
        this != null && eq(other),
        "$this should be $other",
        "$this is not $other"
    )
}

fun beOrthogonalTo(other: Vec) = matcher<Vec?> {
    MatcherResult(
        this != null && 0.0.eq(x * other.x + y * other.y),
        "$this should be orthogonal to $other",
        "$this is not orthogonal to $other"
    )
}

fun <T> matcher(test: T.() -> MatcherResult) = object : Matcher<T> {
    override fun test(value: T) = test(value)
}

fun <T> beIn(vararg e: T): Matcher<T> = beInMatcher(e.asList())