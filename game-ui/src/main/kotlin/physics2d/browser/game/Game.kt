package physics2d.browser.game

import physics2d.browser.Key
import physics2d.browser.Key.*
import physics2d.browser.listenerForKeys
import physics2d.browser.removeKeyListener
import physics2d.browser.setKeyListener
import physics2d.browser.svg.*
import physics2d.core.api.pt
import physics2d.game.Game
import physics2d.game.GameState
import physics2d.game.Turn
import physics2d.game.Turn.MoveTo
import react.*
import react.dom.div
import react.dom.h1

data class RGameProps(var game: Game): RProps

fun RBuilder.game(handler: RHandler<RGameProps>) = child(RGame, handler = handler)

val RGame = functionalComponent<RGameProps> { props ->
    val game = props.game
    val (state, setState) = useState<GameState?>(null)
    fun doTurn(turn: Turn) = setState(game.tick(turn))
    useKeyListener { key: Key ->
        val turn = when(key){
            ArrowUp -> MoveTo(pt(0, -10))
            ArrowDown -> MoveTo(pt(0, 10))
            ArrowLeft -> MoveTo(pt(-10, 0))
            ArrowRight -> MoveTo(pt(10, 0))
        }
        doTurn(turn)
    }

    div {
        state?.let { state ->
            svg {
                val fieldWidth = game.config.fieldWidth
                val fieldHeight = game.config.fieldHeight
                width = fieldWidth
                height = fieldHeight
                viewBox = "0 0 $fieldWidth $fieldHeight"
                fill = "blue"
                field {
                    attrs {
                        gameState = state
                        this.fieldWidth = fieldWidth
                        this.fieldHeight = fieldHeight
                    }
                }
            }
        } ?: h1 { +"press any arrow key to start game" }
    }
}

fun RBuilder.useKeyListener(act: (Key) -> Unit) {
    useEffectWithCleanup {
        val listener = listenerForKeys(act)
        setKeyListener(listener);

        { removeKeyListener(listener) }
    }
}