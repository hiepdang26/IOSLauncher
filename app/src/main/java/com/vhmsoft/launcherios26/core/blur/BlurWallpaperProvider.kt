package com.vhmsoft.launcherios26.core.blur

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.Toast
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.core.runOnMainThread
import com.vhmsoft.launcherios26.core.safeForEach
import com.vhmsoft.launcherios26.core.utils.SingletonHolder
import com.vhmsoft.launcherios26.core.utils.ensureOnMainThread
import com.vhmsoft.launcherios26.core.utils.useApplicationContext
import java.util.ArrayList
import kotlin.math.max
import timber.log.Timber

class BlurWallpaperProvider(val context: Context) {

    private val wallpaperManager: WallpaperManager = WallpaperManager.getInstance(context)
    private val listeners = ArrayList<Listener>()
    private val displayMetrics = DisplayMetrics()

    var wallpapers: BlurSizes? = null
        private set(value) {
            if (field != value) {
                field?.recycle()
                field = value
            }
        }
    var placeholder: Bitmap? = null
        private set(value) {
            if (field != value) {
                field?.recycle()
                field = value
            }
        }

    private val vibrancyPaint = Paint(Paint.FILTER_BITMAP_FLAG or Paint.ANTI_ALIAS_FLAG)

    private val mUpdateRunnable = Runnable { updateWallpaper() }

    private val wallpaperFilter = BlurWallpaperFilter(context)
    private var applyTask: WallpaperFilter.ApplyTask<BlurSizes>? = null

    private var updatePending = false

    init {
        isEnabled = getEnabledStatus()
        updateAsync()
    }

    private fun getEnabledStatus() = wallpaperManager.wallpaperInfo == null

    fun updateAsync() {
        com.vhmsoft.launcherios26.core.Utilities.THREAD_POOL_EXECUTOR.execute(mUpdateRunnable)
    }

    private fun updateWallpaper() {
        if (applyTask != null) {
            updatePending = true
            return
        }

        // Prepare a placeholder before hand so that it can be used in case wallpaper is null
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        display.getRealMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
        placeholder = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(placeholder!!)
        canvas.drawColor(0x44000000)

        val enabled = getEnabledStatus()
        if (enabled != isEnabled) {
            isEnabled = enabled
            com.vhmsoft.launcherios26.core.runOnMainThread { listeners.safeForEach(Listener::onEnabledChanged) }
        }

        if (!isEnabled) {
            wallpapers = null
            return
        }

        var wallpaper =
            try {
                com.vhmsoft.launcherios26.core.Utilities.drawableToBitmap(wallpaperManager.drawable, true) as Bitmap
            } catch (e: Exception) {
                Timber.w(e, "Unable to load wallpaper for blur")
                com.vhmsoft.launcherios26.core.runOnMainThread {
                    if (BlurWallpaperErrorPolicy.shouldShowLoadFailureToast(e.message)) {
                        val msg = "Failed: ${e.message}"
                        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
                    }
                    notifyWallpaperChanged()
                }
                return
            }
        wallpaper = scaleAndCropToScreenSize(wallpaper)
        wallpaper = applyVibrancy(wallpaper)
        applyTask =
            wallpaperFilter.apply(wallpaper).setCallback { result, error ->
                if (error == null) {
                    this@BlurWallpaperProvider.wallpapers = result
                    com.vhmsoft.launcherios26.core.runOnMainThread(::notifyWallpaperChanged)
                    wallpaper.recycle()
                } else {
                    if (error is OutOfMemoryError) {
                        com.vhmsoft.launcherios26.core.runOnMainThread {
                            Toast.makeText(
                                context,
                                context.getString(R.string.toast_failed),
                                Toast.LENGTH_LONG
                            )
                                .show()
                            notifyWallpaperChanged()
                        }
                    }
                    wallpaper.recycle()
                }
            }
        applyTask = null
        if (updatePending) {
            updatePending = false
            updateWallpaper()
        }
    }

    private fun notifyWallpaperChanged() {
        listeners.forEach(Listener::onWallpaperChanged)
    }

    private fun applyVibrancy(wallpaper: Bitmap?): Bitmap {
        val width = wallpaper!!.width
        val height = wallpaper.height
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas()
        canvas.setBitmap(bitmap)
        val colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(1.25f)
        val filter = ColorMatrixColorFilter(colorMatrix)
        vibrancyPaint.colorFilter = filter
        canvas.drawBitmap(wallpaper, 0f, 0f, vibrancyPaint)
        wallpaper.recycle()
        return bitmap
    }

    private fun scaleAndCropToScreenSize(wallpaper: Bitmap): Bitmap {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        display.getRealMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
        val widthFactor = width.toFloat() / wallpaper.width
        val heightFactor = height.toFloat() / wallpaper.height
        val upscaleFactor = Math.max(widthFactor, heightFactor)
        if (upscaleFactor <= 0) {
            return wallpaper
        }
        val scaledWidth = max(width.toFloat(), wallpaper.width * upscaleFactor).toInt()
        val scaledHeight = max(height.toFloat(), wallpaper.height * upscaleFactor).toInt()
        val scaledWallpaper = Bitmap.createScaledBitmap(wallpaper, scaledWidth, scaledHeight, false)
        val navigationBarHeight = 0
        /*if (BlissLauncher.getApplication(context).getDeviceProfile().hasSoftNavigationBar(context)) {

            int resourceId = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            if (resourceId > 0) {
                navigationBarHeight = context.getResources().getDimensionPixelSize(resourceId);
            }
        }*/
        val y: Int =
            if (scaledWallpaper.height > height) {
                (scaledWallpaper.height - height) / 2
            } else 0

        val newBitmap =
            Bitmap.createBitmap(scaledWallpaper, 0, y, width, height - navigationBarHeight)
        wallpaper.recycle()
        scaledWallpaper.recycle()
        return newBitmap
    }

    fun addListener(listener: Listener) {
        listeners.add(listener)
    }

    fun removeListener(listener: Listener) {
        listeners.remove(listener)
    }

    fun createBlurDrawable(config: BlurConfig = blurConfigDock) = BlurDrawable(this, config)

    interface Listener {
        fun onWallpaperChanged() {}
        fun onEnabledChanged() {}
    }

    data class BlurSizes(
        val background: Bitmap,
        val dock: Bitmap,
        val appGroup: Bitmap,
        val widget: Bitmap
    ) {
        fun recycle() {
            background.recycle()
            dock.recycle()
            appGroup.recycle()
            widget.recycle()
        }
    }

    data class BlurConfig(val getDrawable: (BlurSizes) -> Bitmap, val scale: Int, val radius: Int)

    companion object :
        SingletonHolder<BlurWallpaperProvider, Context>(
            ensureOnMainThread(useApplicationContext(::BlurWallpaperProvider))
        ) {

        val blurConfigBackground = BlurConfig({ it.background }, 2, 8)

        val blurConfigDock = BlurConfig({ it.dock }, 4, 12)

        val blurConfigAppGroup = BlurConfig({ it.appGroup }, 6, 12)

        val blurConfigWidget = BlurConfig({ it.widget }, 6, 10)

        var isEnabled: Boolean = false
        private var sEnabledFlag: Int = 0

        fun isEnabled(flag: Int): Boolean {
            return isEnabled && sEnabledFlag and flag != 0
        }
    }
}
