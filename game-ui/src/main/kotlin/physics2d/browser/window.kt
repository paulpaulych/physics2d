package physics2d.browser

import kotlinx.browser.window
import org.w3c.dom.events.EventListener

fun setKeyListener(action: EventListener) =
    window.addEventListener("keydown", action)

fun removeKeyListener(action: EventListener) =
    window.removeEventListener("keydown", action)
