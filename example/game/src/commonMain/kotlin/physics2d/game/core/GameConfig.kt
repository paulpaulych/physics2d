package physics2d.game.core

data class GameConfig(
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
