import react.*
import svg.*

val App = functionalComponent<RProps> {
    svg {
        width = 1000
        height = 1000
        viewBox = "0 0 1000 1000"
        rect {
            width = 500
            height = 500
            x = 100
            y = 100
            fill = "black"
        }
        circle {
            r = 100
            cx = 600
            cy = 600
            fill = "blue"
        }
    }
}
