package physics2d.browser.game

import physics2d.browser.platform.svg.*
import physics2d.game.core.GameField
import react.*

data class RFieldProps(
    var fieldWidth: Int,
    var fieldHeight: Int,
    var gameState: GameField
): RProps

fun RBuilder.field(handler: RHandler<RFieldProps>): ReactElement {
    return child(RField, handler = handler)
}

private val RField = functionalComponent<RFieldProps> { props ->
    g {
        background(props.fieldWidth, props.fieldHeight)
        svgRect {
            attrs {
                val rect = props.gameState.player
                width = rect.size.x.toInt()
                height = rect.size.y.toInt()
                x = rect.start.x.toInt()
                y = rect.start.y.toInt()
                fill = "red"
            }
        }
    }
}

private fun RBuilder.background(w: Int, h: Int) {
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
