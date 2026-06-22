package com.cloudx.ios17.core.customviews

import android.animation.LayoutTransition
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.cloudx.ios17.core.customviews.pageindicators.PageIndicatorDots
import com.cloudx.ios17.features.launcher.LauncherActivity

class Workspace @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyle: Int = 0
) : PagedView<PageIndicatorDots>(context, attrs, defStyle), View.OnTouchListener {
    private val mLauncher: LauncherActivity = LauncherActivity.getLauncher(context)
    private var mLayoutTransition: LayoutTransition? = null

    init {
        isHapticFeedbackEnabled = false
        initWorkspace()
        setOnTouchListener { _, _ -> false }
    }

    private fun initWorkspace() {
        mCurrentPage = DEFAULT_PAGE
        clipToPadding = false
        setupLayoutTransition()
    }

    private fun setupLayoutTransition() {
        mLayoutTransition = LayoutTransition().apply {
            enableTransitionType(LayoutTransition.DISAPPEARING)
            enableTransitionType(LayoutTransition.CHANGE_DISAPPEARING)
            disableTransitionType(LayoutTransition.APPEARING)
            disableTransitionType(LayoutTransition.CHANGE_APPEARING)
        }
        layoutTransition = mLayoutTransition
    }

    fun enableLayoutTransitions() {
        layoutTransition = mLayoutTransition
    }

    fun disableLayoutTransitions() {
        layoutTransition = null
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean = false

    companion object {
        private const val DEFAULT_PAGE = 0
    }
}
