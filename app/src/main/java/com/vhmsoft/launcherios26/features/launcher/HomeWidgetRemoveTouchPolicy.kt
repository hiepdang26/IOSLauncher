package com.vhmsoft.launcherios26.features.launcher

object HomeWidgetRemoveTouchPolicy {

    enum class Action {
        DOWN,
        MOVE,
        UP,
        CANCEL,
        OTHER
    }

    data class Decision(
        val consume: Boolean,
        val trackRemoveButton: Boolean,
        val pressed: Boolean,
        val remove: Boolean
    )

    fun decide(
        action: Action,
        editing: Boolean,
        draggingWidget: Boolean,
        hitRemoveButton: Boolean,
        trackingRemoveButton: Boolean
    ): Decision {
        if (draggingWidget) {
            return idle()
        }
        if (!editing) {
            return idle()
        }
        return when (action) {
            Action.DOWN -> if (hitRemoveButton) {
                Decision(
                    consume = true,
                    trackRemoveButton = false,
                    pressed = false,
                    remove = true
                )
            } else {
                idle()
            }
            Action.MOVE -> if (trackingRemoveButton) {
                Decision(
                    consume = true,
                    trackRemoveButton = true,
                    pressed = hitRemoveButton,
                    remove = false
                )
            } else {
                idle()
            }
            Action.UP -> if (trackingRemoveButton) {
                Decision(
                    consume = true,
                    trackRemoveButton = false,
                    pressed = false,
                    remove = hitRemoveButton
                )
            } else {
                idle()
            }
            Action.CANCEL -> if (trackingRemoveButton) {
                Decision(
                    consume = true,
                    trackRemoveButton = false,
                    pressed = false,
                    remove = false
                )
            } else {
                idle()
            }
            Action.OTHER -> if (trackingRemoveButton) {
                Decision(
                    consume = true,
                    trackRemoveButton = true,
                    pressed = hitRemoveButton,
                    remove = false
                )
            } else {
                idle()
            }
        }
    }

    private fun idle(): Decision {
        return Decision(
            consume = false,
            trackRemoveButton = false,
            pressed = false,
            remove = false
        )
    }
}
