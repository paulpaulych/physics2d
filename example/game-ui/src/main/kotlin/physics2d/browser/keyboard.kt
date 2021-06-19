package physics2d.browser

import org.w3c.dom.events.Event
import org.w3c.dom.events.EventListener
import org.w3c.dom.events.KeyboardEvent


enum class Key {
    ArrowUp,
    ArrowDown,
    ArrowLeft,
    ArrowRight;

    companion object {
        fun valueOfOrNull(s: String): Key? {
            return try {
                valueOf(s)
            } catch (e: Throwable) {
                null
            }
        }
    }
}

fun listenerForKeys(action: (Key) -> Unit) =
    EventListener { event: Event ->
        event.let { it as? KeyboardEvent }
            ?.let { Key.valueOfOrNull(it.key) }
            ?.let(action)
    }
