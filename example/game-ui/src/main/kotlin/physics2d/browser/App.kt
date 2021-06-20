package physics2d.browser

import physics2d.browser.game.*
import physics2d.browser.platform.Key
import physics2d.browser.platform.useKeyListener
import physics2d.game.api.command.startCmd
import physics2d.game.core.GameConfig
import react.*
import react.dom.h1

private const val FIELD_WIDTH = 1000
private const val FIELD_HEIGHT = 1000

val App = functionalComponent<RProps> {
    val (started, setStarted) = useState(false)

    useKeyListener { key ->
        if(key == Key.Enter) {
            setStarted(true)
        }
    }

    if(started) {
        game {
            attrs {
                this.config = gameConfig()
                this.field = startCmd(this.config)
            }
        }
    } else {
        h1 { +"press Enter to start game" }
    }
}

private fun gameConfig() = GameConfig(
    fieldHeight = FIELD_HEIGHT,
    fieldWidth = FIELD_WIDTH
)

