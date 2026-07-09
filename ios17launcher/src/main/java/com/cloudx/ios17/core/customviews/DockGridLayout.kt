package com.cloudx.ios17.core.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewOutlineProvider
import android.widget.GridLayout
import com.cloudx.ios17.core.DeviceProfile
import com.cloudx.ios17.core.LauncherHomeLayoutPreferences
import com.cloudx.ios17.core.LauncherLiquidGlassDrawableFactory
import com.cloudx.ios17.core.LauncherLiquidGlassStylePolicy
import com.cloudx.ios17.core.blur.BlurViewDelegate
import com.cloudx.ios17.core.blur.BlurWallpaperProvider
import com.cloudx.ios17.core.utils.OffsetParent

class DockGridLayout
@JvmOverloads
constructor(private val mContext: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    GridLayout(mContext, attrs, defStyleAttr), com.cloudx.ios17.core.customviews.Insettable, OffsetParent {

    private val offsetParentDelegate = OffsetParent.OffsetParentDelegate()
    private val lastInsets = Rect()
    private var appliedDockStyle = DockStylePolicy.Style.ROUNDED
    private var aboveBlurStyleDrawable: Drawable? = null
    private var externalRealtimeLiquidGlassEnabled = false
    private var dockBlurEnabled = true

    override val offsetX: Float
        get() = translationX
    override val offsetY: Float
        get() = translationY

    private val blurDelegate = BlurViewDelegate(this, BlurWallpaperProvider.blurConfigDock, attrs)
    private val defaultBlurOverlayColor = blurDelegate.overlayColor

    init {
        setWillNotDraw(false)
    }

    override fun onDraw(canvas: Canvas) {
        if (!externalRealtimeLiquidGlassEnabled) {
            if (
                DockStylePolicy.drawsWallpaperBlur(
                    style = appliedDockStyle,
                    dockBlurEnabled = dockBlurEnabled,
                    externalRealtimeLiquidGlassEnabled = externalRealtimeLiquidGlassEnabled
                )
            ) {
                blurDelegate.draw(canvas)
            }
            if (DockStylePolicy.drawsStyleAboveBlur(appliedDockStyle)) {
                aboveBlurStyleDrawable?.setBounds(0, 0, width, height)
                aboveBlurStyleDrawable?.draw(canvas)
            }
        }
        super.onDraw(canvas)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        applyDockStyle(lastInsets)
    }

    override fun setInsets(insets: Rect?) {
        val safeInsets = InsettableRectPolicy.nonNull(insets)
        lastInsets.set(safeInsets)
        applyDockStyle(safeInsets)
    }

    fun refreshStyle() {
        applyDockStyle(lastInsets)
    }

    fun setExternalRealtimeLiquidGlassEnabled(enabled: Boolean) {
        if (externalRealtimeLiquidGlassEnabled != enabled) {
            externalRealtimeLiquidGlassEnabled = enabled
            invalidate()
        }
    }

    private fun applyDockStyle(safeInsets: Rect) {
        val deviceProfile = com.cloudx.ios17.BlissLauncher.getApplication(mContext).deviceProfile
        val lp = layoutParams as? com.cloudx.ios17.core.customviews.InsettableRelativeLayout.LayoutParams ?: return
        val metrics = DockStylePolicy.layoutMetrics(deviceProfile.hotseatCellHeightPx, safeInsets.bottom)
        lp.height = metrics.heightPx
        val dockStyle = currentDockStyle()
        val blurEnabled = isDockBlurEnabled()
        appliedDockStyle = dockStyle
        dockBlurEnabled = blurEnabled
        when (dockStyle) {
            DockStylePolicy.Style.CURRENT -> {
                aboveBlurStyleDrawable = null
                blurDelegate.overlayColor = defaultBlurOverlayColor
                background = null
                clipToOutline = false
                outlineProvider = ViewOutlineProvider.BACKGROUND
                blurDelegate.blurCornerRadius = 0f
                lp.leftMargin = 0
                lp.rightMargin = 0
                lp.bottomMargin = 0
                setPadding(
                    deviceProfile.iconDrawablePaddingPx / 2,
                    0,
                    deviceProfile.iconDrawablePaddingPx / 2,
                    metrics.bottomPaddingPx
                )
            }

            DockStylePolicy.Style.ROUNDED -> {
                blurDelegate.overlayColor = 0
                blurDelegate.blurCornerRadius = dp(38).toFloat()
                outlineProvider = blurDelegate.outlineProvider
                clipToOutline = true
                background = null
                aboveBlurStyleDrawable = GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    LauncherLiquidGlassStylePolicy.dockGradient(
                        enabled = blurEnabled,
                        darkMode = styleDarkModeForLiquidGlass(),
                        liquidGlass = false
                    )
                ).apply {
                    cornerRadius = dp(38).toFloat()
                }
                lp.leftMargin = dp(LauncherHomeLayoutPreferences.DOCK_HORIZONTAL_MARGIN_DP)
                lp.rightMargin = dp(LauncherHomeLayoutPreferences.DOCK_HORIZONTAL_MARGIN_DP)
                lp.bottomMargin = dp(LauncherHomeLayoutPreferences.DOCK_BOTTOM_MARGIN_DP)
                setPadding(
                    0,
                    0,
                    0,
                    metrics.bottomPaddingPx
                )
            }

            DockStylePolicy.Style.LIQUID_GLASS -> {
                blurDelegate.overlayColor = 0
                blurDelegate.blurCornerRadius = dp(38).toFloat()
                outlineProvider = blurDelegate.outlineProvider
                clipToOutline = true
                background = null
                aboveBlurStyleDrawable = LauncherLiquidGlassDrawableFactory.create(
                    context = context,
                    style = LauncherLiquidGlassStylePolicy.dockMaterial(
                        enabled = blurEnabled,
                        darkMode = styleDarkModeForLiquidGlass(),
                        liquidGlass = isLiquidGlassEnabled()
                    )
                )
                lp.leftMargin = dp(LauncherHomeLayoutPreferences.DOCK_HORIZONTAL_MARGIN_DP)
                lp.rightMargin = dp(LauncherHomeLayoutPreferences.DOCK_HORIZONTAL_MARGIN_DP)
                lp.bottomMargin = dp(LauncherHomeLayoutPreferences.DOCK_BOTTOM_MARGIN_DP)
                setPadding(
                    0,
                    0,
                    0,
                    metrics.bottomPaddingPx
                )
            }
        }
        applyChildMetrics(deviceProfile, dockStyle)
        layoutParams = lp
        invalidate()
    }

    private fun applyChildMetrics(deviceProfile: DeviceProfile, dockStyle: DockStylePolicy.Style) {
        val childWidth = when (dockStyle) {
            DockStylePolicy.Style.CURRENT -> deviceProfile.cellWidthPx
            DockStylePolicy.Style.ROUNDED,
            DockStylePolicy.Style.LIQUID_GLASS -> deviceProfile.hotseatCellWidthPx
        }
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val params = child.layoutParams as? GridLayout.LayoutParams ?: continue
            params.setGravity(Gravity.CENTER)
            if (params.width != childWidth || params.height != deviceProfile.hotseatCellHeightPx) {
                params.width = childWidth
                params.height = deviceProfile.hotseatCellHeightPx
            }
            child.layoutParams = params
        }
    }

    private fun currentDockStyle(): DockStylePolicy.Style {
        val prefs = mContext.getSharedPreferences(DockStylePolicy.LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
        return DockStylePolicy.styleFor(
            iphone8StyleEnabled = prefs.getBoolean(DockStylePolicy.KEY_LAYOUT_IPHONE8_STYLE, false),
            liquidGlassEnabled = prefs.getBoolean(LauncherHomeLayoutPreferences.KEY_LAYOUT_LIQUID_GLASS, false),
            darkModeEnabled = prefs.getBoolean(LauncherHomeLayoutPreferences.KEY_LAYOUT_DARK_MODE, false)
        )
    }

    private fun isDarkModeEnabled(): Boolean {
        val prefs = mContext.getSharedPreferences(DockStylePolicy.LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(LauncherHomeLayoutPreferences.KEY_LAYOUT_DARK_MODE, false)
    }

    private fun isLiquidGlassEnabled(): Boolean {
        val prefs = mContext.getSharedPreferences(DockStylePolicy.LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(LauncherHomeLayoutPreferences.KEY_LAYOUT_LIQUID_GLASS, false)
    }

    private fun styleDarkModeForLiquidGlass(): Boolean =
        isDarkModeEnabled() && !isLiquidGlassEnabled()

    private fun isDockBlurEnabled(): Boolean {
        return LauncherHomeLayoutPreferences.isDockBlurEnabled(mContext)
    }

    private fun dp(value: Int): Int = (value * resources.displayMetrics.density + 0.5f).toInt()

    override fun setTranslationX(translationX: Float) {
        super.setTranslationX(translationX)
        offsetParentDelegate.notifyOffsetChanged()
    }

    override fun setTranslationY(translationY: Float) {
        super.setTranslationY(translationY)
        offsetParentDelegate.notifyOffsetChanged()
    }

    override fun addOnOffsetChangeListener(listener: OffsetParent.OnOffsetChangeListener) {
        offsetParentDelegate.addOnOffsetChangeListener(listener)
    }

    override fun removeOnOffsetChangeListener(listener: OffsetParent.OnOffsetChangeListener) {
        offsetParentDelegate.removeOnOffsetChangeListener(listener)
    }
}
