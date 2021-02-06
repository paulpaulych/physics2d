package physics2d.browser

import physics2d.browser.svg.*
import physics2d.core.api.Line
import physics2d.core.api.Pt
import physics2d.core.api.pt
import react.RBuilder
import react.RProps
import react.child
import react.functionalComponent

interface FieldProps: RProps {
    var pts: List<Pt>
    var projections: List<Pt>
    var lines: List<Line>
}

val Field = functionalComponent<FieldProps> { props ->
    svg {
        width = 1000
        height = 1000
        viewBox = "0 0 1000 1000"
        rect {
            width = 1000
            height = 1000
            x = 0
            y = 0
            fill = "black"
        }
        props.lines.forEach(::drawLine)
        props.pts.forEach(::drawPoint)
        props.projections.forEach(::drawProjection)
    }
}

private fun RBuilder.drawLine(line: Line) {
//    (0.0, 0.0, 1000.0, 1000.0)
//        ?.let { borders ->
//            println("borders: $borders")
//            line {
//                x1 = borders.first.x
//                y1 = borders.first.y
//                x2 = borders.second.x
//                y2 = borders.second.y
//                stroke = "red"
//            }
//        }
}

private fun RBuilder.drawPoint(pt: Pt){
    circle {
        r = 10.0
        cx = pt.x
        cy = pt.y
        fill = "blue"
    }
}

private fun RBuilder.drawProjection(pt: Pt){
    circle {
        r = 10.0
        cx = pt.x
        cy = pt.y
        fill = "green"
    }
}

val App = functionalComponent<RProps> {
//    child(Field){
//        attrs {
//            val line = line(pt(0, 0), pt(1, 1))
//            val pointss = listOf(pt(100, 200), pt(200, 300))
//            lines = listOf(line)
//            pts = pointss
//            projections = pointss.map(line::project)
//        }
//    }
}
