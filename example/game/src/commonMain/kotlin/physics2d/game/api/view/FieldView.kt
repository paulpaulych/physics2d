package physics2d.game.api.view

data class RectData(
    val startX: Double,
    val startY: Double,
    val sizeX: Double,
    val sizeY: Double
)

data class FieldView(
    val player: RectData,
    val bricks: List<RectData>
)
