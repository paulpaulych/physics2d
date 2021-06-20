package physics2d.browser.platform

import org.w3c.dom.events.EventListener
import org.w3c.dom.events.KeyboardEvent
import physics2d.browser.removeKeyListener
import physics2d.browser.setKeyListener
import react.RBuilder
import react.useEffectWithCleanup

enum class Key {
    ArrowUp,
    ArrowDown,
    ArrowLeft,
    ArrowRight,

    Enter;

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

internal fun RBuilder.useKeyListener(act: (Key) -> Unit) {
    useEffectWithCleanup {
        val listener = listenerForKeys(act)
        setKeyListener(listener);

        { removeKeyListener(listener) }
    }
}

private fun listenerForKeys(action: (Key) -> Unit): EventListener {
    return EventListener { event ->
        event.let { it as? KeyboardEvent }
            ?.let { Key.valueOfOrNull(it.key) }
            ?.let(action)
    }
}
