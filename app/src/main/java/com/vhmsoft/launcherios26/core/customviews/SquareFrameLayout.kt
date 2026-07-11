package com.vhmsoft.launcherios26.core.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.core.DeviceProfile
import com.vhmsoft.launcherios26.core.LauncherLiquidGlassDrawableFactory
import com.vhmsoft.launcherios26.core.LauncherLiquidGlassStylePolicy
import com.vhmsoft.launcherios26.core.LauncherRealtimeLiquidGlassPolicy
import com.vhmsoft.launcherios26.core.blur.BlurViewDelegate
import com.vhmsoft.launcherios26.core.blur.BlurWallpaperProvider

class SquareFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var mBlurDelegate: BlurViewDelegate? = null
    private var folderPreviewMaterial: Drawable? = null
    private var folderPreviewGlass: LauncherRealtimeLiquidGlassLayout? = null
    private var folderPreviewRealtimeEnabled = false

    init {
        setWillNotDraw(false)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = minOf(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }

    fun enableBlur() {
        disableRealtimeLiquidGlassFolderPreview()
        mBlurDelegate = BlurViewDelegate(this, BlurWallpaperProvider.blurConfigAppGroup, null)
        folderPreviewMaterial = LauncherLiquidGlassDrawableFactory.create(
            context,
            LauncherLiquidGlassStylePolicy.folderPreview(enabled = true, darkMode = false)
        )
        setWillNotDraw(false)
    }

    fun disableBlur() {
        mBlurDelegate = null
        folderPreviewMaterial = null
        disableRealtimeLiquidGlassFolderPreview()
        invalidate()
    }

    fun enableRealtimeLiquidGlassFolderPreview() {
        mBlurDelegate = null
        folderPreviewMaterial = null
        folderPreviewRealtimeEnabled = true
        setWillNotDraw(false)
        updateRealtimeLiquidGlassFolderPreview()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        updateRealtimeLiquidGlassFolderPreview()
    }

    override fun onDraw(canvas: Canvas) {
        mBlurDelegate?.let { delegate ->
            val count = canvas.save()
            canvas.clipPath(DeviceProfile.path)
            delegate.draw(canvas)
            canvas.restoreToCount(count)
        }
        folderPreviewMaterial?.let { material ->
            material.setBounds(0, 0, width, height)
            material.draw(canvas)
        }
        super.onDraw(canvas)
    }

    private fun updateRealtimeLiquidGlassFolderPreview() {
        if (!folderPreviewRealtimeEnabled) return

        val source = realtimeLiquidGlassSource() ?: return
        val style = LauncherLiquidGlassStylePolicy.folderPreview(
            enabled = true,
            liquidGlass = true
        )
        val glass = folderPreviewGlass ?: LauncherRealtimeLiquidGlassLayout(context).apply {
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
            isClickable = false
            isFocusable = false
        }.also { folderPreviewGlass = it }

        glass.blurCornerRadius = dp(style.radiusDp).toFloat()
        glass.applyRealtimeLiquidGlass(
            enabled = true,
            source = source,
            profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PREVIEW,
                radiusDp = style.radiusDp,
                darkMode = false
            )
        )
        glass.setLiquidMaterial(LauncherLiquidGlassDrawableFactory.create(context, style))

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
        invalidate()
    }

    private fun disableRealtimeLiquidGlassFolderPreview() {
        folderPreviewRealtimeEnabled = false
        folderPreviewGlass?.let { glass ->
            if (glass.parent === this) {
                removeView(glass)
            }
        }
        folderPreviewGlass = null
    }

    private fun realtimeLiquidGlassSource(): ViewGroup? {
        return rootView?.findViewById<ViewGroup>(R.id.liquid_glass_source)
            ?: rootView as? ViewGroup
    }

    private fun dp(value: Int): Int =
        (value * resources.displayMetrics.density + 0.5f).toInt()
}
