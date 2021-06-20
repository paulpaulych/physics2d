package physics2d.game.api.command

import physics2d.game.core.GameConfig
import physics2d.game.core.GameField
import physics2d.game.core.initialField

fun startCmd(cfg: GameConfig): GameField {
    return initialField(cfg)
}
