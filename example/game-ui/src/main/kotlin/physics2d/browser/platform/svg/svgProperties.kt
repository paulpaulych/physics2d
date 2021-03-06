package physics2d.browser.platform.svg

import kotlinx.html.attributesMapOf
import react.dom.RDOMBuilder
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal class SVGProperty<T: SvgTag, P>(
    private val htmlKey: String? = null
): ReadWriteProperty<RDOMBuilder<T>, P> {

    override fun setValue(thisRef: RDOMBuilder<T>, property: KProperty<*>, value: P) {
        val key = htmlKey ?: property.name
        val pair = attributesMapOf(key, value.toString())
        thisRef.attrs.attributes += pair
    }
    override fun getValue(thisRef: RDOMBuilder<T>, property: KProperty<*>): P {
        throw UnsupportedOperationException("get operation on svg property np supported")
    }
}

// from https://developer.mozilla.org/en-US/docs/Web/SVG/Attribute
var RDOMBuilder<SvgTag>.x: Int by SVGProperty()
var RDOMBuilder<SvgTag>.y: Int by SVGProperty()
var RDOMBuilder<SvgTag>.height: Int by SVGProperty()
var RDOMBuilder<SvgTag>.width: Int by SVGProperty()
var RDOMBuilder<SvgTag>.cx: Double by SVGProperty()
var RDOMBuilder<SvgTag>.cy: Double by SVGProperty()
var RDOMBuilder<SvgTag>.r: Double by SVGProperty()
var RDOMBuilder<SvgTag>.fill: String by SVGProperty()
var RDOMBuilder<SvgTag>.viewBox: String by SVGProperty()
var RDOMBuilder<SvgTag>.x1: Double by SVGProperty()
var RDOMBuilder<SvgTag>.x2: Double by SVGProperty()
var RDOMBuilder<SvgTag>.y1: Double by SVGProperty()
var RDOMBuilder<SvgTag>.y2: Double by SVGProperty()
var RDOMBuilder<SvgTag>.stroke: String by SVGProperty()
var RDOMBuilder<SvgTag>.fillOpacity: Double by SVGProperty("fillOpacity")





