package com.vhmsoft.launcherios26.core.customviews

import android.graphics.Rect

object InsettableRectPolicy {
    @JvmStatic
    fun defaultInsets(): Rect = Rect()

    @JvmStatic
    fun nonNull(insets: Rect?): Rect = insets?.let { Rect(it) } ?: defaultInsets()
}
