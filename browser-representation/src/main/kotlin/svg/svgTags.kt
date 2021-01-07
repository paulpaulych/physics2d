package svg

import kotlinx.html.TagConsumer
import react.RBuilder
import react.dom.RDOMBuilder
import react.dom.tag

class SVDRect(
    override val consumer: TagConsumer<*>
): SVGTag("rect", consumer, mapOf(), null, false, true)

inline fun RBuilder.rect(block: RDOMBuilder<SVDRect>.() -> Unit) = tag(block, ::SVDRect)

class SVDCircle(
    override val consumer: TagConsumer<*>
): SVGTag("circle", consumer, mapOf(), null, false, true)

inline fun RBuilder.circle(block: RDOMBuilder<SVDCircle>.() -> Unit) = tag(block, ::SVDCircle)
