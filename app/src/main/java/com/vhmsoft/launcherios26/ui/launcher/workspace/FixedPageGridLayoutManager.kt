package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager

class FixedPageGridLayoutManager(
    context: Context,
    spanCount: Int
) : GridLayoutManager(context, spanCount) {
    override fun canScrollVertically(): Boolean = false
}
