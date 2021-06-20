package physics2d.game.api.command

import physics2d.game.core.*
import physics2d.game.core.fp.get
import physics2d.game.core.onTickMutation

fun tick(field: GameField, turn: Turn?): GameField {
    val fieldMutation = onTickMutation(turn)
        .flatMap { get() }
    val (next, _) = fieldMutation.run(field)
    return next
}
