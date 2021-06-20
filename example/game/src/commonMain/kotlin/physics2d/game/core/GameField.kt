package physics2d.game.core

import physics2d.core.api.Rect
import physics2d.core.api.rect
import physics2d.core.api.vec

data class GameField(
    val player: Rect,
    val bricks: List<Rect>
)

internal fun initialField(config: GameConfig) = GameField(
    player = rect(config.fieldCenter(), vec(30, 30)),
    bricks = listOf()
)

private fun GameConfig.fieldCenter() = vec(fieldWidth / 2, fieldHeight / 2)