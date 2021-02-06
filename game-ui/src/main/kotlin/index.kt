import kotlinx.browser.document
import physics2d.browser.App
import react.child
import react.dom.render

fun main() {
    render(document.getElementById("root")) {
        child(App)
    }
}