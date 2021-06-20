package physics2d.core.api

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import physics2d.core.internal.times
import kotlin.test.Test

class PtTest {

    @Test
    fun pt_equals() {
        vec(1.2E-10, 3.2E-10) shouldBe vec(1.0E-10, 3.0E-10)
        vec(-1, -11) shouldNotBe vec(-1.0001, -11.0)
        vec(-1, -11) shouldNotBe vec(-1.0, -11.0001)
    }

    @Test
    fun times() {
        3 * vec(1, 3) shouldBe vec(3, 9)
        (-1000) * vec(-2, 0) shouldBe vec(2000, 0)
    }
}