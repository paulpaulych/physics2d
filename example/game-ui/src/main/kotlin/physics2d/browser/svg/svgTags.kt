package physics2d.browser.svg

import kotlinx.html.TagConsumer
import react.RBuilder
import react.dom.RDOMBuilder
import react.dom.tag

class SvgRect(
    override val consumer: TagConsumer<*>
): SvgTag("rect", consumer, mapOf(), null, false, true)

inline fun RBuilder.svgRect(block: RDOMBuilder<SvgRect>.() -> Unit) = tag(block, ::SvgRect)

class SvgCircle(
    override val consumer: TagConsumer<*>
): SvgTag("circle", consumer, mapOf(), null, false, true)

inline fun RBuilder.svgCircle(block: RDOMBuilder<SvgCircle>.() -> Unit) = tag(block, ::SvgCircle)

class SvgLine(
    override val consumer: TagConsumer<*>
): SvgTag("line", consumer, mapOf(), null, false, true)

inline fun RBuilder.svgLine(block: RDOMBuilder<SvgLine>.() -> Unit) = tag(block, ::SvgLine)

class SvgGroup(
    override val consumer: TagConsumer<*>
): SvgTag("g", consumer, mapOf(), null, false, true)

inline fun RBuilder.g(block: RDOMBuilder<SvgGroup>.() -> Unit) = tag(block, ::SvgGroup)
