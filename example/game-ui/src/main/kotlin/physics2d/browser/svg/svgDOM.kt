package physics2d.browser.svg

import kotlinx.html.HTMLTag
import kotlinx.html.HtmlBlockInlineTag
import kotlinx.html.TagConsumer
import react.RBuilder
import react.dom.RDOMBuilder
import react.dom.tag

open class SvgTag(
    override val tagName : String,
    override val consumer : TagConsumer<*>,
    initialAttributes : Map<String, String>,
    override val namespace : String? = null,
    override val inlineTag: Boolean,
    override val emptyTag: Boolean
): HTMLTag(tagName, consumer, initialAttributes, namespace, inlineTag, emptyTag)

inline fun RBuilder.svg(block: RDOMBuilder<Svg>.() -> Unit) = tag(block, ::Svg)

open class Svg(override val consumer: TagConsumer<*>)
    : SvgTag(
        tagName = "svg",
        consumer,
        mapOf(),
        "http://www.w3.org/2000/svg",
        false,
        false
    ), HtmlBlockInlineTag
