package com.vhmsoft.launcherios26.core.customviews

import android.content.Context
import android.graphics.drawable.GradientDrawable
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
    private var visibilityOverlay: View? = null
    private var realtimeEnabled: Boolean = false
    private var glassSource: ViewGroup? = null
    private var glassSurface: LauncherRealtimeLiquidGlassPolicy.Surface? = null
    private var glassProfile: LauncherRealtimeLiquidGlassPolicy.Profile? = null
    private var configuredProfile: LauncherRealtimeLiquidGlassPolicy.Profile? = null

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
        visibility == VISIBLE &&
            glassView?.parent === this &&
            realtimeEnabled &&
            glassView?.visibility == VISIBLE

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
        super.onDetachedFromWindow()
    }

    override fun onVisibilityChanged(changedView: View, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        if (
            changedView === this &&
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnVisibilityChanged(
                realtimeEnabled = realtimeEnabled,
                visible = visibility == VISIBLE
            )
        ) {
            updateGlass()
        }
    }

    fun refreshRealtimeLiquidGlass() {
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

        val glass = if (
            LauncherRealtimeLiquidGlassPolicy.shouldRecreateRealtimeView(
                currentProfile = configuredProfile,
                nextProfile = profile
            )
        ) {
            glassView?.takeIf { it.parent === this }?.let { removeView(it) }
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
        } else if (indexOfChild(glass) != 0 && configuredProfile == null) {
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

        glass.visibility = VISIBLE
        glass.bind(source)
        glass.invalidate()
        updateVisibilityOverlay(profile)
        logGlassState("bind profile=$profile")
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
        visibilityOverlay?.takeIf { it.parent === this }?.visibility = GONE
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

    private fun updateVisibilityOverlay(profile: LauncherRealtimeLiquidGlassPolicy.Profile) {
        val surface = glassSurface ?: return hideVisibilityOverlay()
        if (
            !LauncherRealtimeLiquidGlassPolicy.shouldDrawVisibilityOverlay(
                surface = surface,
                realtimeLiquidGlassActive = isRealtimeLiquidGlassActive()
            )
        ) {
            hideVisibilityOverlay()
            return
        }

        val overlay = visibilityOverlay ?: View(context).apply {
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
            isEnabled = false
            isClickable = false
            isFocusable = false
        }.also { visibilityOverlay = it }

        overlay.background = visibilityOverlayDrawable(profile)
        if (overlay.parent !== this) {
            addView(
                overlay,
                visibilityOverlayIndex(),
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        } else if (indexOfChild(overlay) != visibilityOverlayIndex()) {
            removeView(overlay)
            addView(
                overlay,
                visibilityOverlayIndex(),
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }
        overlay.visibility = VISIBLE
    }

    private fun hideVisibilityOverlay() {
        visibilityOverlay?.takeIf { it.parent === this }?.visibility = GONE
    }

    private fun visibilityOverlayIndex(): Int =
        if (glassView?.parent === this) {
            (indexOfChild(glassView) + 1).coerceAtLeast(1)
        } else {
            0
        }

    private fun visibilityOverlayDrawable(
        profile: LauncherRealtimeLiquidGlassPolicy.Profile
    ): GradientDrawable =
        GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                0x22FFFFFF,
                0x0CFFFFFF,
                0x1200273C
            )
        ).apply {
            cornerRadius = profile.cornerRadius
            setStroke(dp(1), 0x2AFFFFFF)
        }

    private fun measureDecorationToBounds(view: View?) {
        if (view?.parent !== this || view.visibility == GONE) return
        val widthSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, View.MeasureSpec.EXACTLY)
        val heightSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, View.MeasureSpec.EXACTLY)
        view.measure(widthSpec, heightSpec)
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
