package com.cloudx.ios17.core.customviews

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.cloudx.ios17.core.LauncherRealtimeLiquidGlassPolicy
import com.cloudx.ios17.core.Utilities
import com.cloudx.ios17.core.blur.BlurWallpaperProvider
import com.example.liquidglass.BlurMethod
import com.example.liquidglass.LiquidGlassView
import kotlin.math.max
import kotlin.math.roundToInt

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
    private val viewWindowLocation = IntArray(2)
    private val wallpaperPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
    private val wallpaperProvider by lazy { BlurWallpaperProvider.getInstance(context) }

    companion object {
        private var cachedSystemWallpaper: Bitmap? = null
    }

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
        if (drawable == null) {
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
        glassView?.parent === this && realtimeEnabled

    override fun shouldDrawBlurBackground(): Boolean =
        LauncherRealtimeLiquidGlassPolicy.shouldDrawFallbackBlur(
            realtimeLiquidGlassActive = isRealtimeLiquidGlassActive()
        )

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        updateGlass()
    }

    override fun onDetachedFromWindow() {
        removeGlass()
        super.onDetachedFromWindow()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

    private fun updateGlass() {
        val profile = glassProfile
        val source = glassSource
        if (!realtimeEnabled || profile == null || source == null) {
            removeGlass()
            return
        }

        val glass = if (
            glassView == null ||
            LauncherRealtimeLiquidGlassPolicy.shouldConfigureRealtimeProfile(
                currentProfile = configuredProfile,
                nextProfile = profile
            )
        ) {
            replaceGlass(profile)
        } else {
            glassView ?: replaceGlass(profile)
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

        glass.setCustomBackdropCapture { captureBackdrop() }
        glass.invalidate()
        updateMaterialOverlay()
    }

    private fun replaceGlass(profile: LauncherRealtimeLiquidGlassPolicy.Profile): LiquidGlassView {
        removeGlass()
        return createGlass(profile).also { created ->
            glassView = created
            configuredProfile = profile
            addView(
                created,
                0,
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }
    }

    private fun createGlass(profile: LauncherRealtimeLiquidGlassPolicy.Profile): LiquidGlassView {
        return LiquidGlassView(context).apply {
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
            isEnabled = false
            isClickable = false
            isFocusable = false
            enableBackdropBlur = true
            enableChromaticAberration = false
            enableChromaticDispersion = false
            enableShadow = false
            enableEdgeHighlight = true
            enableOptimizedCapture = false
            enableDynamicBackground = profile.dynamicBackground
            blurMethod = BlurMethod.BOX_BLUR
            highQualityBlur = false
            downsampleScale = 2
            globalDownsampleFactor = profile.globalDownsampleFactor
            aberrationDownsample = profile.aberrationDownsample
            blurAmount = profile.blurAmount
            saturation = profile.saturation
            aberrationIntensity = profile.aberrationIntensity
            displacementScale = profile.displacementScale
            elasticity = 0f
            cornerRadius = dp(profile.radiusDp).toFloat()
            overLight = true
            edgeHighlightBorderWidth = resources.displayMetrics.density
            edgeHighlightOpacity = profile.edgeHighlightOpacity
        }
    }

    private fun captureBackdrop(): Bitmap? {
        val captureWidth = width
        val captureHeight = height
        if (
            captureWidth <= 0 ||
            captureHeight <= 0
        ) {
            return null
        }

        return try {
            val bitmap = Bitmap.createBitmap(
                captureWidth,
                captureHeight,
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(bitmap)
            getLocationInWindow(viewWindowLocation)
            drawWallpaperBase(canvas)
            bitmap
        } catch (_: OutOfMemoryError) {
            null
        } catch (_: IllegalArgumentException) {
            null
        }
    }

    private fun drawWallpaperBase(canvas: Canvas) {
        val wallpaper = wallpaperProvider.wallpapers?.background
            ?: systemWallpaperBitmap()
            ?: wallpaperProvider.placeholder
            ?: return
        if (wallpaper.isRecycled || wallpaper.width <= 0 || wallpaper.height <= 0) return

        val displayWidth = resources.displayMetrics.widthPixels.toFloat().coerceAtLeast(width.toFloat())
        val displayHeight = resources.displayMetrics.heightPixels.toFloat().coerceAtLeast(height.toFloat())
        val scale = max(
            displayWidth / wallpaper.width.toFloat(),
            displayHeight / wallpaper.height.toFloat()
        )
        val saveCount = canvas.save()
        canvas.translate(
            -viewWindowLocation[0].toFloat(),
            -viewWindowLocation[1].toFloat()
        )
        canvas.scale(scale, scale)
        canvas.drawBitmap(wallpaper, 0f, 0f, wallpaperPaint)
        canvas.restoreToCount(saveCount)
    }

    private fun systemWallpaperBitmap(): Bitmap? {
        cachedSystemWallpaper?.takeIf { !it.isRecycled }?.let { return it }

        val raw = try {
            val drawable = WallpaperManager.getInstance(context).drawable
            when (drawable) {
                is BitmapDrawable -> drawable.bitmap?.copy(Bitmap.Config.ARGB_8888, false)
                else -> Utilities.drawableToBitmap(drawable, true)
            }
        } catch (_: Exception) {
            null
        } ?: return null

        val displayWidth = resources.displayMetrics.widthPixels.coerceAtLeast(1)
        val displayHeight = resources.displayMetrics.heightPixels.coerceAtLeast(1)
        val scale = max(
            displayWidth.toFloat() / raw.width.toFloat(),
            displayHeight.toFloat() / raw.height.toFloat()
        )
        val scaledWidth = (raw.width * scale).roundToInt().coerceAtLeast(displayWidth)
        val scaledHeight = (raw.height * scale).roundToInt().coerceAtLeast(displayHeight)
        val scaled = if (scaledWidth != raw.width || scaledHeight != raw.height) {
            Bitmap.createScaledBitmap(raw, scaledWidth, scaledHeight, true)
        } else {
            raw
        }
        val left = ((scaled.width - displayWidth) / 2).coerceAtLeast(0)
        val top = ((scaled.height - displayHeight) / 2).coerceAtLeast(0)
        val cropped = Bitmap.createBitmap(
            scaled,
            left,
            top,
            displayWidth.coerceAtMost(scaled.width - left),
            displayHeight.coerceAtMost(scaled.height - top)
        )
        if (scaled !== raw) {
            raw.recycle()
            scaled.recycle()
        } else if (cropped !== raw) {
            raw.recycle()
        }
        cachedSystemWallpaper = cropped
        return cropped
    }

    private fun removeGlass() {
        glassView?.let { glass ->
            if (glass.parent === this) {
                removeView(glass)
            }
        }
        glassView = null
        configuredProfile = null
        updateMaterialOverlay()
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

    private fun dp(value: Int): Int =
        (value * resources.displayMetrics.density + 0.5f).toInt()
}
