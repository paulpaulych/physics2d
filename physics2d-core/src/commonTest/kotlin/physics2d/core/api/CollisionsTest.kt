package physics2d.core.api

import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import physics2d.core.api.collisions.collisionFor
import physics2d.core.beIn
import kotlin.test.Test

internal class CollisionsTest {

    @Test
    fun noCollisionBetweenAabbs() {
        collisionFor(
            rect(vec(0, 0), vec(2, 2)),
            rect(vec(-3, -3), vec(2, 2))
        ) shouldBe null

        collisionFor(
            rect(vec(100, 100), vec(200, 200)),
            rect(vec(300, 300), vec(500, 300))
        ) shouldBe null
    }

    @ExperimentalStdlibApi
    @Test
    fun collisionBetweenAabbs() {
        val res = collisionFor(
            rect(vec(0, 0), vec(400, 300)),
            rect(vec(200, 200), vec(400, 300))
        )

        res?.v should beIn(
            vec(0, 100),
            vec(0, -100)
        )
    }
}
