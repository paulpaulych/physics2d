package physics2d.core.internal

import io.kotest.matchers.shouldBe
import physics2d.core.api.Segment
import physics2d.core.api.vec
import kotlin.test.Test

class SegmentUtilsKtTest {

    @Test
    fun pt_belongs_to_segment() {
        val segment = Segment(vec(0, 0), vec(0, 5))
        vec(0, 2).belongsTo(segment) shouldBe true
        vec(0, 0).belongsTo(segment) shouldBe true
        vec(0, 5).belongsTo(segment) shouldBe true

        vec(1, 0).belongsTo(segment) shouldBe false
        vec(2, 5).belongsTo(segment) shouldBe false
        vec(0, -1).belongsTo(segment) shouldBe false
        vec(0, 6).belongsTo(segment) shouldBe false


        val segment2 = Segment(vec(-10, -10), vec(10, 10))
        vec(0, 0).belongsTo(segment2) shouldBe true
        vec(-3, -3).belongsTo(segment2) shouldBe true
        vec(10, 10).belongsTo(segment2) shouldBe true

        vec(1, 0).belongsTo(segment2) shouldBe false
        vec(2, 5).belongsTo(segment2) shouldBe false
        vec(0, -1).belongsTo(segment2) shouldBe false
        vec(0, 6).belongsTo(segment2) shouldBe false
    }

    @Test
    fun intersection_equal_to_one_of_segments() {
        intersectionOf(
            Segment(vec(0, 0), vec(0, 5)),
            Segment(vec(0, 3), vec(0, 4)),
        ) shouldBe Segment(vec(0, 3), vec(0, 4))
    }
}