package svg

import kotlinx.html.HTMLTag
import kotlinx.html.HtmlBlockInlineTag
import kotlinx.html.TagConsumer
import kotlinx.html.attributesMapOf
import react.RBuilder
import react.ReactElement
import styled.StyledDOMBuilder
import styled.styledTag

open class SVGTag(
    override val tagName : String,
    override val consumer : TagConsumer<*>,
    initialAttributes : Map<String, String>,
    override val namespace : String? = null,
    override val inlineTag: Boolean,
    override val emptyTag: Boolean
): HTMLTag(tagName, consumer, initialAttributes, namespace, inlineTag, emptyTag)

inline fun RBuilder.svg(classes: String? = null, block: StyledDOMBuilder<Svg>.() -> Unit): ReactElement =
    styledTag(block) { Svg(attributesMapOf("class", classes), it) }

open class Svg(
    initialAttributes: Map<String, String>,
    override val consumer: TagConsumer<*>
): SVGTag(
    tagName = "svg",
    consumer,
    initialAttributes,
    "http://www.w3.org/2000/svg",
    false,
    false
), HtmlBlockInlineTag
