package com.vhmsoft.launcherios26.core.customviews

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.vhmsoft.launcherios26.core.LauncherRealtimeLiquidGlassPolicy
import com.qmdeve.liquidglass.widget.LiquidGlassView

class LauncherRealtimeLiquidGlassLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : BlurLayout(context, attrs) {

    private var glassView: LiquidGlassView? = null
    private var realtimeEnabled: Boolean = false
    private var glassSource: ViewGroup? = null
    private var glassProfile: LauncherRealtimeLiquidGlassPolicy.Profile? = null
    private var configuredProfile: LauncherRealtimeLiquidGlassPolicy.Profile? = null
    private var materialOverlay: View? = null
    private var materialDrawable: Drawable? = null

    fun applyRealtimeLiquidGlass(
        enabled: Boolean,
        source: ViewGroup?,
        profile: LauncherRealtimeLiquidGlassPolicy.Profile
    ) {
        realtimeEnabled = LauncherRealtimeLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(
            liquidGlassEnabled = enabled,
            sdkInt = Build.VERSION.SDK_INT
        )
        glassSource = source
        glassProfile = profile
        updateGlass()
    }

    fun setLiquidMaterial(drawable: Drawable?) {
        materialDrawable = drawable
        updateMaterialOverlay()
    }

    private fun updateMaterialOverlay() {
        val drawable = materialDrawable
        val shouldDrawOverlay = LauncherRealtimeLiquidGlassPolicy.shouldDrawMaterialOverlay(
            realtimeLiquidGlassActive = isRealtimeLiquidGlassActive(),
            hasMaterialDrawable = drawable != null
        )
        if (!shouldDrawOverlay || drawable == null) {
            materialOverlay?.let { overlay ->
                if (overlay.parent === this) {
                    removeView(overlay)
                }
            }
            materialOverlay = null
            return
        }

        val overlay = materialOverlay ?: View(context).apply {
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
            isClickable = false
            isFocusable = false
        }.also { materialOverlay = it }
        overlay.background = drawable
        ensureMaterialOverlayOrder()
    }

    fun isRealtimeLiquidGlassActive(): Boolean =
        glassView?.parent === this && realtimeEnabled && glassView?.visibility == VISIBLE

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
        val overlay = materialOverlay?.takeIf { it.parent === this }
        val glassVisibility = glass?.visibility
        val overlayVisibility = overlay?.visibility

        glass?.visibility = GONE
        overlay?.visibility = GONE
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        glassVisibility?.let { glass?.visibility = it }
        overlayVisibility?.let { overlay?.visibility = it }

        measureDecorationToBounds(glass)
        measureDecorationToBounds(overlay)
    }

    private fun updateGlass() {
        val profile = glassProfile
        val source = glassSource
        if (
            !realtimeEnabled ||
            profile == null ||
            source == null ||
            !LauncherRealtimeLiquidGlassPolicy.shouldBindRealtimeSource(
                sourceContainsTarget = sourceContainsTarget(source)
            )
        ) {
            hideGlass()
            return
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
        updateMaterialOverlay()
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

    private fun hideGlass() {
        glassView?.takeIf { it.parent === this }?.visibility = GONE
        updateMaterialOverlay()
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
        glass.setCornerRadius(dp(profile.radiusDp.toFloat()))
        glass.setBlurRadius(dp(profile.blurRadiusDp))
        glass.setRefractionHeight(dp(profile.refractionHeightDp))
        glass.setRefractionOffset(dp(profile.refractionOffsetDp))
        glass.setDispersion(profile.dispersion)
        glass.setTintColorRed(profile.tintRed)
        glass.setTintColorGreen(profile.tintGreen)
        glass.setTintColorBlue(profile.tintBlue)
        glass.setTintAlpha(profile.tintAlpha)
    }

    private fun ensureMaterialOverlayOrder() {
        val overlay = materialOverlay ?: return
        val targetIndex = if (glassView?.parent === this) 1 else 0
        val layoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        if (overlay.parent !== this) {
            addView(
                overlay,
                targetIndex.coerceAtMost(childCount),
                layoutParams
            )
            return
        }

        if (indexOfChild(overlay) != targetIndex) {
            removeView(overlay)
            addView(
                overlay,
                targetIndex.coerceAtMost(childCount),
                layoutParams
            )
        }
    }

    private fun measureDecorationToBounds(view: View?) {
        if (view?.parent !== this || view.visibility == GONE) return
        val widthSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, View.MeasureSpec.EXACTLY)
        val heightSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, View.MeasureSpec.EXACTLY)
        view.measure(widthSpec, heightSpec)
    }

    private fun dp(value: Int): Int =
        (value * resources.displayMetrics.density + 0.5f).toInt()

    private fun dp(value: Float): Float =
        value * resources.displayMetrics.density
}
