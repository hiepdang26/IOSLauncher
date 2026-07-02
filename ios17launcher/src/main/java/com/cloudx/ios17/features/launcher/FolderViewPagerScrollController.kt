package com.cloudx.ios17.features.launcher

import android.content.Context
import android.view.animation.DecelerateInterpolator
import android.widget.Scroller
import androidx.viewpager.widget.ViewPager

object FolderViewPagerScrollController {
    fun install(viewPager: ViewPager): Boolean =
        runCatching {
            val scrollerField = ViewPager::class.java.getDeclaredField("mScroller")
            scrollerField.isAccessible = true
            scrollerField.set(
                viewPager,
                FixedDurationScroller(
                    context = viewPager.context,
                    durationMs = FolderDragSessionPolicy.FOLDER_PAGE_SCROLL_ANIMATION_MS
                )
            )
            true
        }.getOrDefault(false)

    private class FixedDurationScroller(
        context: Context,
        private val durationMs: Int
    ) : Scroller(context, DecelerateInterpolator()) {
        override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int) {
            super.startScroll(startX, startY, dx, dy, durationMs)
        }

        override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
            super.startScroll(startX, startY, dx, dy, durationMs)
        }
    }
}
