package physics2d.core.internal

import io.kotest.matchers.shouldBe
import physics2d.core.api.pt
import kotlin.test.Test

class SegmentOpsTest {

    @Test
    fun pt_belongs_to_segment() {
        val segment = Segment(pt(0, 0), pt(0, 5))
        pt(0, 2).belongsTo(segment) shouldBe true
        pt(0, 0).belongsTo(segment) shouldBe true
        pt(0, 5).belongsTo(segment) shouldBe true

        pt(1, 0).belongsTo(segment) shouldBe false
        pt(2, 5).belongsTo(segment) shouldBe false
        pt(0, -1).belongsTo(segment) shouldBe false
        pt(0, 6).belongsTo(segment) shouldBe false


        val segment2 = Segment(pt(-10, -10), pt(10, 10))
        pt(0, 0).belongsTo(segment2) shouldBe true
        pt(-3, -3).belongsTo(segment2) shouldBe true
        pt(10, 10).belongsTo(segment2) shouldBe true

        pt(1, 0).belongsTo(segment2) shouldBe false
        pt(2, 5).belongsTo(segment2) shouldBe false
        pt(0, -1).belongsTo(segment2) shouldBe false
        pt(0, 6).belongsTo(segment2) shouldBe false
    }

    @Test
    fun intersection_equal_to_one_of_segments() {
        intersectionOf(
            Segment(pt(0, 0), pt(0, 5)),
            Segment(pt(0, 3), pt(0, 4)),
        ) shouldBe Segment(pt(0, 3), pt(0, 4))
    }
}