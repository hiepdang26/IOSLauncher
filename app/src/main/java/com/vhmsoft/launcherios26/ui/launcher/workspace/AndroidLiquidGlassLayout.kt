package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.vhmsoft.launcherios26.BuildConfig
import com.vhmsoft.launcherios26.core.LauncherLiquidGlassTuning
import com.qmdeve.liquidglass.widget.LiquidGlassView

class AndroidLiquidGlassLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private var glassView: LiquidGlassView? = null
    private var visibilityOverlay: View? = null
    private var realtimeEnabled = false
    private var glassSource: ViewGroup? = null
    private var glassSurface: AndroidLiquidGlassPolicy.Surface = AndroidLiquidGlassPolicy.Surface.SEARCH_PILL
    private var glassProfile: AndroidLiquidGlassPolicy.Profile? = null
    private var configuredProfile: AndroidLiquidGlassPolicy.Profile? = null
    private var fallbackBackgroundDrawable: Drawable? = null
    private var forceRecreateOnNextUpdate = false

    fun applyLiquidGlass(
        enabled: Boolean,
        source: ViewGroup?,
        surface: AndroidLiquidGlassPolicy.Surface,
        profile: AndroidLiquidGlassPolicy.Profile
    ) {
        realtimeEnabled = AndroidLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(
            liquidGlassEnabled = enabled,
            sdkInt = Build.VERSION.SDK_INT
        )
        glassSource = source
        glassSurface = surface
        glassProfile = profile
        forceRecreateOnNextUpdate = forceRecreateOnNextUpdate ||
            AndroidLiquidGlassPolicy.shouldForceRecreateRealtimeViewOnApply(
                surface = surface,
                realtimeLiquidGlassActive = isRealtimeLiquidGlassActive()
            )
        updateGlass()
    }

    fun applyFallbackBackground(drawable: Drawable?) {
        fallbackBackgroundDrawable = drawable
        updateFallbackBackground()
    }

    fun isRealtimeLiquidGlassActive(): Boolean =
        visibility == VISIBLE &&
            realtimeEnabled &&
            glassView?.parent === this &&
            glassView?.visibility == VISIBLE

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        updateGlass()
    }

    override fun onDetachedFromWindow() {
        glassView?.visibility = GONE
        super.onDetachedFromWindow()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val glass = glassView?.takeIf { it.parent === this }
        val glassVisibility = glass?.visibility
        glass?.visibility = GONE
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        glassVisibility?.let { glass?.visibility = it }
        if (glass?.parent === this && glass.visibility != GONE) {
            glass.measure(
                MeasureSpec.makeMeasureSpec(measuredWidth, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(measuredHeight, MeasureSpec.EXACTLY)
            )
        }
    }

    private fun updateGlass() {
        val profile = glassProfile
        val source = glassSource
        val sourceContainsTarget = source?.let { sourceContainsTarget(it) } ?: false
        if (
            !realtimeEnabled ||
            profile == null ||
            source == null ||
            !AndroidLiquidGlassPolicy.shouldBindRealtimeSource(
                sourceContainsTarget = sourceContainsTarget
            )
        ) {
            glassView?.takeIf { it.parent === this }?.visibility = GONE
            visibilityOverlay?.takeIf { it.parent === this }?.visibility = GONE
            updateFallbackBackground()
            logGlassState("hide reason=${hideReason(profile, source, sourceContainsTarget)}")
            return
        }
        val forceRecreate = forceRecreateOnNextUpdate
        forceRecreateOnNextUpdate = false

        val glass = if (
            AndroidLiquidGlassPolicy.shouldRecreateRealtimeView(
                surface = glassSurface,
                currentProfile = configuredProfile,
                nextProfile = profile,
                forceRefresh = forceRecreate,
                realtimeLiquidGlassActive = isRealtimeLiquidGlassActive()
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
                LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        } else if (indexOfChild(glass) != 0) {
            removeView(glass)
            addView(
                glass,
                0,
                LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }

        glass.visibility = VISIBLE
        glass.bind(source)
        glass.invalidate()
        updateFallbackBackground()
        updateVisibilityOverlay(profile)
        logGlassState("bind profile=$profile")
    }

    private fun sourceContainsTarget(source: ViewGroup): Boolean {
        var current: View? = this
        while (current != null) {
            if (current === source) return true
            current = current.parent as? View
        }
        return false
    }

    private fun updateFallbackBackground() {
        val realtimeActive = isRealtimeLiquidGlassActive()
        background = if (AndroidLiquidGlassPolicy.shouldUseTransparentContentBackground(glassSurface, realtimeActive)) {
            null
        } else if (AndroidLiquidGlassPolicy.shouldDrawFallbackBackground(glassSurface, realtimeActive)) {
            fallbackBackgroundDrawable
        } else {
            null
        }
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

    private fun configureGlass(
        glass: LiquidGlassView,
        profile: AndroidLiquidGlassPolicy.Profile
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

    private fun updateVisibilityOverlay(profile: AndroidLiquidGlassPolicy.Profile) {
        if (
            !AndroidLiquidGlassPolicy.shouldDrawVisibilityOverlay(
                surface = glassSurface,
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
                LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        } else if (indexOfChild(overlay) != visibilityOverlayIndex()) {
            removeView(overlay)
            addView(
                overlay,
                visibilityOverlayIndex(),
                LayoutParams(
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

    private fun visibilityOverlayDrawable(profile: AndroidLiquidGlassPolicy.Profile): GradientDrawable =
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

    private fun dp(value: Int): Int =
        (value * resources.displayMetrics.density + 0.5f).toInt()

    private fun hideReason(
        profile: AndroidLiquidGlassPolicy.Profile?,
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
            "surface=$glassSurface $message " +
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
        private const val TAG = "AndroidLiquidGlass"
    }
}
