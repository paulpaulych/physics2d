package physics2d.core.api

import io.kotest.matchers.shouldBe
import physics2d.core.api.figures.aabb
import kotlin.test.Test

internal class CollisionsTest {

    @Test
    fun noCollisionBetweenAabbs() {
        collisionFor(
            aabb(pt(0, 0), 1, 1),
            aabb(pt(-3, -3), 1, 1)
        ) shouldBe null

        collisionFor(
            aabb(pt(100, 100), 100, 100),
            aabb(pt(300, 300), 100, 200)
        ) shouldBe null
    }

    @Test
    fun collisionBetweenAabbs() {
        collisionFor(
            aabb(pt(100, 100), 1000, 1000),
            aabb(pt(300, 300), 100, 100)
        ) shouldBe null
    }
}