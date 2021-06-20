package physics2d.core.internal

import io.kotest.matchers.shouldBe
import kotlin.test.Test


class DoubleKtTest {

    @Test
    fun double_eq() {
        0.0.eq(1.0) shouldBe false
        0.0.eq(0.0001) shouldBe false
        0.0.eq(0.0000001) shouldBe true

        2.0.eq(1.0) shouldBe false
        2.0.eq(2.0001) shouldBe false
        2.0.eq(2.0000001) shouldBe true
    }
}