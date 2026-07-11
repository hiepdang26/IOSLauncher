package com.vhmsoft.launcherios26.core.customviews

import android.graphics.Rect

/**
 * Allows the implementing view to not draw underneath system bars, e.g. the
 * notification bar on top and home key area on the bottom.
 */
interface Insettable {
    fun setInsets(insets: Rect?)
}
