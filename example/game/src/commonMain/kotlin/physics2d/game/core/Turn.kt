package physics2d.game.core

sealed class Turn {
    data class MoveTo(val x: Double, val y: Double): Turn()
}