package physics2d.game.core

import physics2d.core.api.Vec
import physics2d.core.api.vec
import physics2d.game.core.fp.State
import physics2d.game.core.fp.modify

internal typealias FieldMutation = State<GameField, Unit>

internal fun onTickMutation(turn: Turn?): FieldMutation {
    return actionFor(turn)
}

private fun actionFor(turn: Turn?): FieldMutation = when(turn){
    null -> identity
    is Turn.MoveTo -> moveTo(vec(turn.x, turn.y))
}

private fun moveTo(vec: Vec): FieldMutation {
    return modify { field ->
        val newPlayer = field.player.copy(
            start = field.player.start + vec
        )
        field.copy(player = newPlayer)
    }
}

private val identity: FieldMutation = FieldMutation.unit(Unit)
private val printField: FieldMutation = modify { gameField ->
    println("hello from printField: $gameField")
    gameField
}
