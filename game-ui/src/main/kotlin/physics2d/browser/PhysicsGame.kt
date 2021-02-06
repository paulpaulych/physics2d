package physics2d.browser

enum class FigureType { Rect }

enum class ButtonDirection { Left, Right, Up, Down }

sealed class Event {
    class ButtonPressed(direction: ButtonDirection): Event()
    class FigureTypeChanged(new: FigureType): Event()
}

interface PhysicsGame {
    fun state(userActions: List<Event>): State
}

interface Figure {
    val type: FigureType
}

interface State {
    val figures: List<Figure>
    val collisionsIndices: List<Pair<Int, Int>>
}
