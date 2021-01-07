package svg

import kotlinx.html.attributesMapOf
import react.dom.RDOMBuilder
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal class SVGProperty<T: SVGTag, P>: ReadWriteProperty<RDOMBuilder<T>, P> {
    override fun setValue(thisRef: RDOMBuilder<T>, property: KProperty<*>, value: P) {
        val pair = attributesMapOf(property.name, value.toString())
        thisRef.attrs.attributes += pair
    }
    override fun getValue(thisRef: RDOMBuilder<T>, property: KProperty<*>): P {
        TODO("Not yet implemented")
    }
}

// from https://developer.mozilla.org/en-US/docs/Web/SVG/Attribute
var RDOMBuilder<SVGTag>.cx: Int by SVGProperty()
var RDOMBuilder<SVGTag>.cy: Int by SVGProperty()
var RDOMBuilder<SVGTag>.r: Int by SVGProperty()
var RDOMBuilder<SVGTag>.fill: String by SVGProperty()
var RDOMBuilder<SVGTag>.height: Int by SVGProperty()
var RDOMBuilder<SVGTag>.x: Int by SVGProperty()
var RDOMBuilder<SVGTag>.y: Int by SVGProperty()
var RDOMBuilder<SVGTag>.viewBox: String by SVGProperty()
var RDOMBuilder<SVGTag>.width: Int by SVGProperty()




