package com.vhmsoft.launcherios26.features.launcher

object HomeWidgetTouchDragPolicy {

    fun shouldPreviewPlacement(previousDropKey: String?, currentDropKey: String): Boolean {
        return previousDropKey != currentDropKey
    }

    fun shouldAnimateDisplacement(nowMs: Long, lastAnimationMs: Long, throttleMs: Long): Boolean {
        return nowMs - lastAnimationMs >= throttleMs
    }

    fun shouldHandleMove(active: Boolean): Boolean = active

    fun shouldHandleEnd(active: Boolean): Boolean = active

    fun shouldAnimateDisplacedApp(requestedAnimation: Boolean, appIsWobbling: Boolean): Boolean {
        return requestedAnimation
    }

    fun shouldCancelDisplacedAppAnimator(appIsWobbling: Boolean): Boolean {
        return !appIsWobbling
    }

    fun shouldRestoreDisplacementForInvalidPreview(outsideHome: Boolean): Boolean {
        return outsideHome
    }
}
