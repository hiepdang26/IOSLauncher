package com.vhmsoft.launcherios26.features.launcher

object HomeWidgetInteractionPolicy {
    data class Bounds(
        val left: Int,
        val top: Int,
        val right: Int,
        val bottom: Int
    )

    data class Point(
        val x: Float,
        val y: Float
    )

    enum class TouchAction {
        MOVE,
        UP,
        CANCEL,
        OTHER
    }

    fun shouldAttachLauncherTouchTracking(
        widgetType: String,
        isProviderContent: Boolean
    ): Boolean {
        return widgetType != SYSTEM_WIDGET_TYPE || !isProviderContent
    }

    fun shouldCaptureGlobalDragMotion(
        active: Boolean,
        action: TouchAction
    ): Boolean {
        return active && action != TouchAction.OTHER
    }

    fun dragStartPoint(
        rawX: Float,
        rawY: Float,
        sourceBounds: Bounds
    ): Point {
        if (
            rawX >= sourceBounds.left &&
            rawX <= sourceBounds.right &&
            rawY >= sourceBounds.top &&
            rawY <= sourceBounds.bottom
        ) {
            return Point(rawX, rawY)
        }
        return Point(
            x = (sourceBounds.left + sourceBounds.right) / 2f,
            y = (sourceBounds.top + sourceBounds.bottom) / 2f
        )
    }

    private const val SYSTEM_WIDGET_TYPE = "system"
}
