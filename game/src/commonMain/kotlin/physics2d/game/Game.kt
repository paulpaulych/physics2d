package physics2d.game

import physics2d.core.api.Vec
import physics2d.core.api.Rect
import physics2d.core.api.vec
import physics2d.core.api.rect

fun initialState(config: Config) = GameState(
    player = rect(config.fieldCenter(), vec(30, 30))
)

data class GameState(
    val player: Rect,
)

internal fun interface Action {
    fun act(state: GameState): GameState
}

class Game(
    val config: Config
) {
    private var state = initialState(config)

    fun tick(turn: Turn?): GameState =
        actionFor(turn)
            .act(state)
            .apply(::state::set)
            .apply {
                println("setting new state: $this")
            }
}

private fun actionFor(turn: Turn?) = when(turn){
    null -> noAction
    is Turn.MoveTo -> Action { state ->
        val rect = state.player
        GameState(rect.copy(start = rect.start + turn.vec))
    }
}

private val noAction = Action { it }

sealed class Turn {
    data class MoveTo(val vec: Vec): Turn()
}

data class Config(
    val fieldWidth: Int,
    val fieldHeight: Int
) {
    init {
        require(fieldHeight > 100) {
            "field height must be > 100"
        }
        require(fieldWidth > 100) {
            "field width must be > 100"
        }
    }
}

private fun Config.fieldCenter() = vec(fieldWidth / 2, fieldHeight / 2)