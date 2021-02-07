package physics2d.browser.game

import physics2d.browser.svg.*
import physics2d.game.GameState
import react.*

data class RFieldProps(
    var fieldWidth: Int,
    var fieldHeight: Int,
    var gameState: GameState
): RProps

val RField = functionalComponent<RFieldProps> { props ->
    g {
        background(props.fieldWidth, props.fieldHeight)
        svgRect {
            attrs {
                val rect = props.gameState.rect
                width = rect.size.x.toInt()
                height = rect.size.y.toInt()
                x = rect.start.x.toInt()
                y = rect.start.y.toInt()
                fill = "red"
            }
        }
    }
}

fun RBuilder.field(handler: RHandler<RFieldProps>): ReactElement =
    child(RField, handler = handler)

fun RBuilder.background(w: Int, h: Int) {
    svgRect {
        attrs {
            width = w
            height = h
            x = 0
            y = 0
            fill = "black"
            fillOpacity = 0.25
        }
    }
}

enum class Color(val string: String){
    Black("black"),
    Red("red"),
    Green("black");
}

fun Color.next() = ordinal.let { Color.values()[it + 1] }