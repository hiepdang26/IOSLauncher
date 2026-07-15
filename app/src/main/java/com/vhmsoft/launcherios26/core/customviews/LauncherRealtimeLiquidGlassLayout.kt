package com.vhmsoft.launcherios26.core.customviews

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.vhmsoft.launcherios26.BuildConfig
import com.vhmsoft.launcherios26.core.LauncherLiquidGlassTuning
import com.vhmsoft.launcherios26.core.LauncherRealtimeLiquidGlassPolicy
import com.qmdeve.liquidglass.widget.LiquidGlassView

class LauncherRealtimeLiquidGlassLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : BlurLayout(context, attrs) {

    private var glassView: LiquidGlassView? = null
    private var realtimeEnabled: Boolean = false
    private var glassSource: ViewGroup? = null
    private var glassSurface: LauncherRealtimeLiquidGlassPolicy.Surface? = null
    private var glassProfile: LauncherRealtimeLiquidGlassPolicy.Profile? = null
    private var configuredProfile: LauncherRealtimeLiquidGlassPolicy.Profile? = null
    private var boundSource: ViewGroup? = null
    private var sourceBoundWhileVisible: Boolean = false
    private var forceRecreateOnNextUpdate: Boolean = false

    fun applyRealtimeLiquidGlass(
        enabled: Boolean,
        source: ViewGroup?,
        surface: LauncherRealtimeLiquidGlassPolicy.Surface,
        profile: LauncherRealtimeLiquidGlassPolicy.Profile
    ) {
        realtimeEnabled = LauncherRealtimeLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(
            liquidGlassEnabled = enabled,
            sdkInt = Build.VERSION.SDK_INT
        )
        glassSource = source
        glassSurface = surface
        glassProfile = profile
        updateGlass()
    }

    fun isRealtimeLiquidGlassActive(): Boolean =
        LauncherRealtimeLiquidGlassPolicy.isRealtimeGlassActive(
            hostVisible = visibility == VISIBLE,
            hostShown = isShown,
            hostWidth = width,
            hostHeight = height,
            glassAttached = glassView?.parent === this,
            glassVisible = glassView?.visibility == VISIBLE,
            glassShown = glassView?.isShown == true,
            glassWidth = glassView?.width ?: 0,
            glassHeight = glassView?.height ?: 0,
            realtimeEnabled = realtimeEnabled
        )

    override fun shouldDrawBlurBackground(): Boolean =
        LauncherRealtimeLiquidGlassPolicy.shouldDrawFallbackBlur(
            realtimeLiquidGlassActive = isRealtimeLiquidGlassActive()
        )

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        updateGlass()
    }

    override fun onDetachedFromWindow() {
        glassView?.visibility = GONE
        sourceBoundWhileVisible = false
        super.onDetachedFromWindow()
    }

    override fun onVisibilityChanged(changedView: View, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        if (changedView === this && visibility != VISIBLE) {
            sourceBoundWhileVisible = false
        }
        if (
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnVisibilityChanged(
                realtimeEnabled = realtimeEnabled,
                visible = visibility == VISIBLE
            )
        ) {
            updateGlass()
        }
    }

    override fun onVisibilityAggregated(isVisible: Boolean) {
        super.onVisibilityAggregated(isVisible)
        if (!isVisible) {
            sourceBoundWhileVisible = false
        } else if (
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnVisibilityChanged(
                realtimeEnabled = realtimeEnabled,
                visible = true
            )
        ) {
            updateGlass()
        }
    }

    fun refreshRealtimeLiquidGlass() {
        forceRecreateOnNextUpdate = forceRecreateOnNextUpdate ||
            LauncherRealtimeLiquidGlassPolicy.shouldForceRecreateRealtimeViewOnRefresh(
                surface = glassSurface,
                realtimeLiquidGlassActive = isRealtimeLiquidGlassActive()
            )
        updateGlass()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val glass = glassView?.takeIf { it.parent === this }
        val glassVisibility = glass?.visibility

        glass?.visibility = GONE
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        glassVisibility?.let { glass?.visibility = it }

        measureDecorationToBounds(glass)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        layoutDecorationToBounds(glassView)
    }

    private fun updateGlass() {
        val profile = glassProfile
        val source = glassSource
        val sourceContainsTarget = source?.let { sourceContainsTarget(it) } ?: false
        if (
            !realtimeEnabled ||
            profile == null ||
            source == null ||
            !LauncherRealtimeLiquidGlassPolicy.shouldBindRealtimeSource(
                sourceContainsTarget = sourceContainsTarget
            )
        ) {
            hideGlass()
            logGlassState("hide reason=${hideReason(profile, source, sourceContainsTarget)}")
            invalidate()
            return
        }
        if (blurCornerRadius != profile.cornerRadius) {
            blurCornerRadius = profile.cornerRadius
        }
        val forceRecreate = forceRecreateOnNextUpdate
        forceRecreateOnNextUpdate = false
        val activeBeforeUpdate = isRealtimeLiquidGlassActive()

        val glass = if (
            LauncherRealtimeLiquidGlassPolicy.shouldRecreateRealtimeView(
                surface = glassSurface,
                currentProfile = configuredProfile,
                nextProfile = profile,
                forceRefresh = forceRecreate,
                realtimeLiquidGlassActive = activeBeforeUpdate
            )
        ) {
            glassView?.takeIf { it.parent === this }?.let { removeView(it) }
            boundSource = null
            sourceBoundWhileVisible = false
            createGlass().also { newGlass ->
                configureGlass(newGlass, profile)
                glassView = newGlass
                configuredProfile = profile
            }
        } else {
            glassView ?: createGlass().also { newGlass ->
                configureGlass(newGlass, profile)
                glassView = newGlass
                configuredProfile = profile
            }
        }

        if (glass.parent !== this) {
            addView(
                glass,
                0,
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        } else if (indexOfChild(glass) != 0) {
            removeView(glass)
            addView(
                glass,
                0,
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }

        val sourceChanged = boundSource !== source
        val shouldBindSource = LauncherRealtimeLiquidGlassPolicy.shouldBindRealtimeViewSource(
            sourceChanged = sourceChanged,
            realtimeLiquidGlassActive = activeBeforeUpdate,
            sourceBoundWhileVisible = sourceBoundWhileVisible
        )
        glass.visibility = VISIBLE
        if (shouldBindSource) {
            glass.bind(source)
            boundSource = source
            sourceBoundWhileVisible = isShown
        }
        layoutDecorationToBounds(glass)
        glass.invalidate()
        logGlassState("${if (shouldBindSource) "bind" else "reuse-bind"} profile=$profile")
        invalidate()
    }

    private fun createGlass(): LiquidGlassView {
        return LiquidGlassView(context).apply {
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
            isEnabled = false
            isClickable = false
            isFocusable = false
            setDraggableEnabled(LauncherLiquidGlassTuning.DRAGGABLE_ENABLED)
            setElasticEnabled(LauncherLiquidGlassTuning.ELASTIC_ENABLED)
            setTouchEffectEnabled(LauncherLiquidGlassTuning.TOUCH_EFFECT_ENABLED)
        }
    }

    private fun hideGlass() {
        glassView?.takeIf { it.parent === this }?.visibility = GONE
        sourceBoundWhileVisible = false
        invalidate()
    }

    private fun sourceContainsTarget(source: ViewGroup): Boolean {
        var current: View? = this
        while (current != null) {
            if (current === source) return true
            current = current.parent as? View
        }
        return false
    }

    private fun configureGlass(
        glass: LiquidGlassView,
        profile: LauncherRealtimeLiquidGlassPolicy.Profile
    ) {
        glass.setCornerRadius(profile.cornerRadius)
        glass.setBlurRadius(profile.blurRadiusDp)
        glass.setRefractionHeight(profile.refractionHeightDp)
        glass.setRefractionOffset(profile.refractionOffsetDp)
        glass.setDispersion(profile.dispersion)
        glass.setTintColorRed(profile.tintRed)
        glass.setTintColorGreen(profile.tintGreen)
        glass.setTintColorBlue(profile.tintBlue)
        glass.setTintAlpha(profile.tintAlpha)
    }

    private fun measureDecorationToBounds(view: View?) {
        if (view?.parent !== this || view.visibility == GONE) return
        val widthSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, View.MeasureSpec.EXACTLY)
        val heightSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, View.MeasureSpec.EXACTLY)
        view.measure(widthSpec, heightSpec)
    }

    private fun layoutDecorationToBounds(view: View?) {
        if (
            view?.parent !== this ||
            view.visibility == GONE ||
            !LauncherRealtimeLiquidGlassPolicy.shouldLayoutRealtimeViewToHostBounds(
                hostWidth = width,
                hostHeight = height,
                realtimeLiquidGlassActive = realtimeEnabled &&
                    visibility == VISIBLE &&
                    isShown &&
                    view.visibility == VISIBLE
            )
        ) {
            return
        }
        measureDecorationToBounds(view)
        view.layout(0, 0, width, height)
    }

    private fun dp(value: Int): Int =
        (value * resources.displayMetrics.density + 0.5f).toInt()

    private fun hideReason(
        profile: LauncherRealtimeLiquidGlassPolicy.Profile?,
        source: ViewGroup?,
        sourceContainsTarget: Boolean
    ): String =
        when {
            !realtimeEnabled -> "realtime-disabled"
            profile == null -> "profile-null"
            source == null -> "source-null"
            sourceContainsTarget -> "source-contains-target"
            else -> "policy-blocked"
        }

    private fun logGlassState(message: String) {
        if (!BuildConfig.DEBUG) return
        Log.d(
            TAG,
            "surface=${glassSurface ?: "UNKNOWN"} $message " +
                "active=${isRealtimeLiquidGlassActive()} " +
                "host=${debugSummary(this)} " +
                "source=${debugSummary(glassSource)} " +
                "glass=${debugSummary(glassView)}"
        )
    }

    private fun debugSummary(view: View?): String {
        if (view == null) return "null"
        val idName = if (view.id != View.NO_ID) {
            runCatching { resources.getResourceEntryName(view.id) }.getOrElse { view.id.toString() }
        } else {
            "no-id"
        }
        val location = IntArray(2)
        if (view.isAttachedToWindow) {
            view.getLocationInWindow(location)
        }
        val childCount = (view as? ViewGroup)?.childCount?.let { " children=$it" } ?: ""
        return "${view.javaClass.simpleName}#$idName" +
            " vis=${visibilityLabel(view.visibility)} shown=${view.isShown}" +
            " alpha=${view.alpha} size=${view.width}x${view.height}" +
            " measured=${view.measuredWidth}x${view.measuredHeight}" +
            " loc=${location[0]},${location[1]} bg=${view.background != null}$childCount"
    }

    private fun visibilityLabel(visibility: Int): String =
        when (visibility) {
            VISIBLE -> "VISIBLE"
            INVISIBLE -> "INVISIBLE"
            GONE -> "GONE"
            else -> visibility.toString()
        }

    companion object {
        private const val TAG = "LauncherRTGlass"
    }

}
