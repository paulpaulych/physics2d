package physics2d.core.api

import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import physics2d.core.beIn
import kotlin.test.Test

internal class CollisionsTest {

    @Test
    fun noCollisionBetweenAabbs() {
        collisionFor(
            rect(pt(0, 0), pt(2, 2)),
            rect(pt(-3, -3), pt(2, 2))
        ) shouldBe null

        collisionFor(
            rect(pt(100, 100), pt(200, 200)),
            rect(pt(300, 300), pt(500, 300))
        ) shouldBe null
    }

    @ExperimentalStdlibApi
    @Test
    fun collisionBetweenAabbs() {
        val res = collisionFor(
            rect(pt(0, 0), pt(400, 300)),
            rect(pt(200, 200), pt(400, 300))
        )

        res?.v should beIn(
            pt(0, 100),
            pt(0, -100)
        )
    }
}
