package physics2d.browser

import physics2d.browser.game.*
import physics2d.game.Config
import physics2d.game.Game
import react.*

private const val FIELD_WIDTH = 1000
private const val FIELD_HEIGHT = 1000

val App = functionalComponent<RProps> {
    val (game) = useState(createGame())
    game {
        attrs {
            this.game = game
        }
    }
}

private fun createGame(): Game {
    val gameConfig = Config(
        fieldHeight = FIELD_HEIGHT,
        fieldWidth = FIELD_WIDTH)
    return Game(gameConfig)
}
