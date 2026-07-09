package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.qmdeve.liquidglass.widget.LiquidGlassView

class AndroidLiquidGlassLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private var glassView: LiquidGlassView? = null
    private var realtimeEnabled = false
    private var glassSource: ViewGroup? = null
    private var glassProfile: AndroidLiquidGlassPolicy.Profile? = null
    private var configuredProfile: AndroidLiquidGlassPolicy.Profile? = null

    fun applyLiquidGlass(
        enabled: Boolean,
        source: ViewGroup?,
        profile: AndroidLiquidGlassPolicy.Profile
    ) {
        realtimeEnabled = AndroidLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(
            liquidGlassEnabled = enabled,
            sdkInt = Build.VERSION.SDK_INT
        )
        glassSource = source
        glassProfile = profile
        updateGlass()
    }

    fun applyFallbackBackground(drawable: Drawable?) {
        background = if (AndroidLiquidGlassPolicy.shouldDrawFallbackBackground(isRealtimeLiquidGlassActive())) {
            drawable
        } else {
            null
        }
    }

    fun isRealtimeLiquidGlassActive(): Boolean =
        realtimeEnabled && glassView?.parent === this && glassView?.visibility == VISIBLE

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
        if (!realtimeEnabled || profile == null || source == null) {
            glassView?.takeIf { it.parent === this }?.visibility = GONE
            return
        }

        val glass = if (
            AndroidLiquidGlassPolicy.shouldRecreateRealtimeView(
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
                LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        } else if (indexOfChild(glass) != 0 && configuredProfile == null) {
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
    }

    private fun createGlass(): LiquidGlassView {
        return LiquidGlassView(context).apply {
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
            isEnabled = false
            isClickable = false
            isFocusable = false
            setDraggableEnabled(false)
            setElasticEnabled(false)
            setTouchEffectEnabled(false)
        }
    }

    private fun configureGlass(
        glass: LiquidGlassView,
        profile: AndroidLiquidGlassPolicy.Profile
    ) {
        glass.setCornerRadius(dp(profile.radiusDp.toFloat()))
        glass.setBlurRadius(dp(profile.blurRadiusDp))
        glass.setRefractionHeight(dp(profile.refractionHeightDp))
        glass.setRefractionOffset(dp(profile.refractionOffsetDp))
        glass.setDispersion(profile.dispersion)
        glass.setTintColorRed(1f)
        glass.setTintColorGreen(1f)
        glass.setTintColorBlue(1f)
        glass.setTintAlpha(profile.tintAlpha)
    }

    private fun dp(value: Float): Float =
        value * resources.displayMetrics.density
}
