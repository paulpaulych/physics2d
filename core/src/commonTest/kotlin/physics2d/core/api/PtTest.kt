package physics2d.core.api

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import physics2d.core.internal.times
import kotlin.test.Test

class PtTest {

    @Test
    fun pt_equals() {
        pt(1.2E-10, 3.2E-10) shouldBe pt(1.0E-10, 3.0E-10)
        pt(-1, -11) shouldNotBe pt(-1.0001, -11.0)
        pt(-1, -11) shouldNotBe pt(-1.0, -11.0001)
    }

    @Test
    fun times() {
        3 * pt(1, 3) shouldBe pt(3, 9)
        (-1000) * pt(-2, 0) shouldBe pt(2000, 0)
    }
}