package physics2d.browser.svg

import kotlinx.html.TagConsumer
import react.RBuilder
import react.dom.RDOMBuilder
import react.dom.tag

class SVDRect(
    override val consumer: TagConsumer<*>
): SvgTag("rect", consumer, mapOf(), null, false, true)

inline fun RBuilder.rect(block: RDOMBuilder<SVDRect>.() -> Unit) = tag(block, ::SVDRect)

class SvgCircle(
    override val consumer: TagConsumer<*>
): SvgTag("circle", consumer, mapOf(), null, false, true)

inline fun RBuilder.circle(block: RDOMBuilder<SvgCircle>.() -> Unit) = tag(block, ::SvgCircle)

class SvgLine(
    override val consumer: TagConsumer<*>
): SvgTag("line", consumer, mapOf(), null, false, true)

inline fun RBuilder.line(block: RDOMBuilder<SvgLine>.() -> Unit) = tag(block, ::SvgLine)
