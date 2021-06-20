package physics2d.browser.game

import physics2d.browser.platform.Key
import physics2d.browser.platform.Key.*
import physics2d.browser.platform.svg.*
import physics2d.browser.platform.useKeyListener
import physics2d.game.api.command.tick
import physics2d.game.core.GameConfig
import physics2d.game.core.GameField
import physics2d.game.core.Turn
import physics2d.game.core.Turn.MoveTo
import react.*
import react.dom.div

data class RGameProps(
    var config: GameConfig,
    var field: GameField
): RProps

fun RBuilder.game(handler: RHandler<RGameProps>): ReactElement =
    child(RGame, handler = handler)

private val RGame = functionalComponent<RGameProps> { props ->

    val (fieldState, setFieldState) = useState(props.field)

    useTurnListener { turn ->
        val newField = tick(fieldState, turn)
        setFieldState(newField)
    }

    div {
        svg {
            val fieldWidth = props.config.fieldWidth
            val fieldHeight = props.config.fieldHeight
            width = fieldWidth
            height = fieldHeight
            viewBox = "0 0 $fieldWidth $fieldHeight"
            fill = "blue"
            field {
                attrs {
                    this.gameState = fieldState
                    this.fieldWidth = fieldWidth
                    this.fieldHeight = fieldHeight
                }
            }
        }
    }
}

private fun RBuilder.useTurnListener(fn: (Turn) -> Unit) {
    useKeyListener { key: Key ->
        val turn = when(key){
            ArrowUp -> MoveTo(0.0, -0.0)
            ArrowDown -> MoveTo(0.0, 0.0)
            ArrowLeft -> MoveTo(-10.0,0.0)
            ArrowRight -> MoveTo(10.0, 0.0)
            else -> null
        }
        turn?.let(fn)
    }
}