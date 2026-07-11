package com.vhmsoft.launcherios26.core.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.BlissLauncher
import com.vhmsoft.launcherios26.core.DeviceProfile
import com.vhmsoft.launcherios26.core.LauncherFolderPreviewBackgroundPolicy
import com.vhmsoft.launcherios26.core.LauncherHomeLayoutPreferences
import com.vhmsoft.launcherios26.core.LauncherLiquidGlassDrawableFactory
import com.vhmsoft.launcherios26.core.LauncherLiquidGlassStylePolicy
import com.vhmsoft.launcherios26.core.database.model.FolderItem
import timber.log.Timber

class GraphicsUtil(private val mContext: Context) {

    private val appIconWidth: Int
    private val liquidGlassEnabled: Boolean
    private val darkModeEnabled: Boolean
    private val folderBlurEnabled: Boolean

    init {
        val deviceProfile = BlissLauncher.getApplication(mContext).deviceProfile
        appIconWidth = deviceProfile.iconSizePx
        liquidGlassEnabled = LauncherHomeLayoutPreferences.isLiquidGlassEnabled(mContext)
        darkModeEnabled = LauncherHomeLayoutPreferences.isDarkModeEnabled(mContext)
        folderBlurEnabled = LauncherHomeLayoutPreferences.isFolderBlurEnabled(mContext)
    }

    /**
     * Takes 1 or more drawables and merges them to form a single Drawable.
     */
    fun generateFolderIcon(context: Context, vararg sources: Drawable): Drawable {
        val width = appIconWidth
        val height = width

        Timber.tag(TAG).i("generateFolderIcon: $width*$height")
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        val xOrigin = bitmap.width / 10
        val yOrigin = bitmap.height / 10
        var x = xOrigin
        var y = yOrigin
        val xIncrement = bitmap.width / 10
        val yIncrement = bitmap.height / 10
        var count = 0
        var total = 0
        for (drawable in sources) {
            drawable.setBounds(x, y, (x + width / 5f).toInt(), (y + height / 5f).toInt())
            drawable.draw(canvas)
            x += (width / 5f + xIncrement).toInt()
            count++
            total++
            if (count == 3) {
                count = 0
                y += (height / 5f + yIncrement).toInt()
                x = xOrigin
            }
            if (total > 8) {
                break
            }
        }

        return convertToRoundedCorner(context, addBackground(bitmap, true))
    }

    fun generateFolderIcon(context: Context, app: FolderItem): Drawable {
        val folderItems = requireNotNull(app.items)
        val drawables = Array(folderItems.size) { index -> requireNotNull(folderItems[index].icon) }
        return generateFolderIcon(context, *drawables)
    }

    /** Scales icons to match the icon pack. */
    fun scaleImage(context: Context, image: Drawable?, scaleFactor: Float): Drawable? {
        if (image !is BitmapDrawable) {
            return image
        }
        val bitmap = image.bitmap
        val sizeX = Math.round(image.intrinsicWidth * scaleFactor)
        val sizeY = Math.round(image.intrinsicHeight * scaleFactor)
        val bitmapResized = Bitmap.createScaledBitmap(bitmap, sizeX, sizeY, false)
        return BitmapDrawable(context.resources, bitmapResized)
    }

    fun addBackground(bitmap: Bitmap, isFolder: Boolean): Bitmap {
        var workingBitmap = bitmap
        if (!hasTransparency(workingBitmap)) {
            workingBitmap = Bitmap.createScaledBitmap(
                workingBitmap,
                appIconWidth,
                appIconWidth * workingBitmap.height / workingBitmap.width,
                true
            )
            return workingBitmap
        }
        if (workingBitmap.width >= appIconWidth) {
            workingBitmap = Bitmap.createScaledBitmap(
                workingBitmap,
                appIconWidth,
                appIconWidth * workingBitmap.height / workingBitmap.width,
                true
            )
        }

        val width = appIconWidth
        val height = width
        val mergedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(mergedBitmap)
        drawIconBackground(canvas, workingBitmap, isFolder, width, height)

        val paint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG or Paint.FILTER_BITMAP_FLAG)
        canvas.drawBitmap(
            workingBitmap,
            ((width - workingBitmap.width) / 2).toFloat(),
            ((height - workingBitmap.height) / 2).toFloat(),
            paint
        )
        return mergedBitmap
    }

    fun addBackground(appIcon: Drawable, isFolder: Boolean): Bitmap {
        val bitmap =
            if (appIcon is BitmapDrawable) {
                appIcon.bitmap
            } else {
                Bitmap.createBitmap(appIcon.intrinsicWidth, appIcon.intrinsicHeight, Bitmap.Config.ARGB_8888).also {
                    val canvas = Canvas(it)
                    appIcon.setBounds(0, 0, canvas.width, canvas.height)
                    appIcon.draw(canvas)
                }
            }
        return addBackground(bitmap, isFolder)
    }

    private fun drawIconBackground(
        canvas: Canvas,
        workingBitmap: Bitmap,
        isFolder: Boolean,
        width: Int,
        height: Int
    ) {
        if (!isFolder) {
            canvas.drawColor(getDominantColor(workingBitmap))
            return
        }

        val useRealtimeGlass = LauncherFolderPreviewBackgroundPolicy.shouldUseRealtimeLiquidGlass(
            liquidGlassEnabled = liquidGlassEnabled,
            folderBlurEnabled = folderBlurEnabled,
            darkModeEnabled = darkModeEnabled
        )
        if (!LauncherFolderPreviewBackgroundPolicy.shouldDrawBitmapBackground(useRealtimeGlass)) {
            return
        }

        val style = LauncherLiquidGlassStylePolicy.folderPreview(
            enabled = liquidGlassEnabled || (folderBlurEnabled && !darkModeEnabled),
            darkMode = darkModeEnabled,
            liquidGlass = liquidGlassEnabled
        )
        LauncherLiquidGlassDrawableFactory.create(mContext, style).apply {
            setBounds(0, 0, width, height)
            draw(canvas)
        }
    }

    fun convertToRoundedCorner(context: Context, src: Bitmap): BitmapDrawable {
        return BitmapDrawable(context.resources, BitmapUtils.getCroppedBitmap(src, DeviceProfile.path))
    }

    fun hasTransparency(bitmap: Bitmap): Boolean {
        for (y in 0 until bitmap.height) {
            for (x in 0 until bitmap.width) {
                if (Color.alpha(bitmap.getPixel(x, y)) < 255) {
                    return true
                }
            }
        }

        return false
    }

    fun getDominantColor(drawable: Drawable): Int {
        return getDominantColor((drawable as BitmapDrawable).bitmap)
    }

    @SuppressLint("UseSparseArrays")
    private fun getDominantColor(bitmap: Bitmap): Int {
        val colors = HashMap<Int, Int>()

        for (x in 0 until bitmap.width) {
            for (y in 0 until bitmap.height) {
                if (Color.alpha(bitmap.getPixel(x, y)) == 255) {
                    val color = bitmap.getPixel(x, y)
                    colors[color] = (colors[color] ?: 0) + 1
                }
            }
        }

        var color = Color.TRANSPARENT
        var occurrences = 0
        return if (colors.keys.size > 1) {
            for (key in colors.keys) {
                val count = colors[key] ?: 0
                if (count > occurrences) {
                    occurrences = count
                    color = key
                }
            }

            color
        } else {
            Timber.tag(TAG).i("getDominantColor: white")
            Color.WHITE
        }
    }

    companion object {
        private const val TAG = "BLISS_GRAPHICS"
    }
}
