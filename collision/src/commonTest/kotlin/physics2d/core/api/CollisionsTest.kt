package physics2d.core.api

import io.kotest.matchers.shouldBe
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
        //todo:
        collisionFor(
            aabb(pt(0, 0), 200, 150),
            aabb(pt(200, 200), 200, 200)
        ) shouldBe Collision(
            segment = Segment(pt(200, 200), pt(200, 300)),
            len = 100.0
        )
    }
}