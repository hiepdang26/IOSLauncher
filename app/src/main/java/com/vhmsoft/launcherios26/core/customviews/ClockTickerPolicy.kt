package com.vhmsoft.launcherios26.core.customviews

object ClockTickerPolicy {
    fun shouldAnimate(
        autoUpdate: Boolean,
        attachedToWindow: Boolean,
        aggregatedVisible: Boolean,
        windowVisible: Boolean
    ): Boolean = autoUpdate && attachedToWindow && aggregatedVisible && windowVisible
}
