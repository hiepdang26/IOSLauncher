package com.vhmsoft.launcherios26.features.weather

import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.BitmapDrawable
import android.util.DisplayMetrics
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.core.utils.Constants
import timber.log.Timber

object WeatherIconUtils {

    private const val TAG = "WeatherIconUtils"
    private val D = Constants.DEBUG

    @JvmStatic
    fun getWeatherIconResource(context: Context, iconSet: String, conditionCode: Int): Int {
        if (iconSet.startsWith("ext:") || iconSet == Constants.MONOCHROME) {
            return 0
        }

        val res = context.resources
        val resId = res.getIdentifier(
            "weather_${iconSet}_${WeatherUtils.addOffsetToConditionCodeFromWeatherContract(conditionCode)}",
            "drawable",
            context.packageName
        )

        if (resId != 0) {
            return resId
        }

        return R.drawable.weather_color_na
    }

    @JvmStatic
    fun getWeatherIconBitmap(
        context: Context,
        iconSet: String,
        color: Int,
        conditionCode: Int
    ): Bitmap? = getWeatherIconBitmap(context, iconSet, color, conditionCode, 0)

    @JvmStatic
    fun getWeatherIconBitmap(
        context: Context,
        iconSet: String,
        color: Int,
        conditionCode: Int,
        density: Int
    ): Bitmap? {
        var resolvedIconSet = iconSet
        val isMonoSet = Constants.MONOCHROME == resolvedIconSet
        var res: Resources? = null
        var resId = 0
        val fixedConditionCode = WeatherUtils.addOffsetToConditionCodeFromWeatherContract(conditionCode)

        if (resolvedIconSet.startsWith("ext:")) {
            val packageName = resolvedIconSet.substring(4)
            try {
                res = context.packageManager.getResourcesForApplication(packageName)
                resId = res.getIdentifier("weather_$fixedConditionCode", "drawable", packageName)
            } catch (e: PackageManager.NameNotFoundException) {
                resolvedIconSet = Constants.COLOR_STD
            }
        }
        if (resId == 0) {
            val identifier =
                if (isMonoSet) "weather_$fixedConditionCode" else "weather_${resolvedIconSet}_$fixedConditionCode"
            res = context.resources
            resId = res.getIdentifier(identifier, "drawable", context.packageName)
        }

        if (resId == 0) {
            resId = if (isMonoSet) R.drawable.weather_na else R.drawable.weather_color_na
        }

        return getOverlaidBitmap(requireNotNull(res), resId, if (isMonoSet) color else 0, density)
    }

    @JvmStatic
    fun getOverlaidBitmap(res: Resources, resId: Int, color: Int): Bitmap? {
        return getOverlaidBitmap(res, resId, color, 0)
    }

    @JvmStatic
    fun getOverlaidBitmap(res: Resources, resId: Int, color: Int, density: Int): Bitmap? {
        val src = getBitmapFromResource(res, resId, density)
        if (color == 0 || src == null) {
            return src
        }

        val dest = Bitmap.createBitmap(src.width, src.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(dest)
        val paint = Paint()

        paint.colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        canvas.drawBitmap(src, 0f, 0f, paint)
        return dest
    }

    @JvmStatic
    fun getBitmapFromResource(res: Resources, resId: Int, density: Int): Bitmap? {
        if (density == 0) {
            if (D) {
                Timber.tag(TAG).d("Decoding resource id = $resId for default density")
            }
            return BitmapFactory.decodeResource(res, resId)
        }

        if (D) {
            Timber.tag(TAG).d("Decoding resource id = $resId for density = $density")
        }
        val drawable = res.getDrawableForDensity(resId, density) ?: return null
        if (drawable is BitmapDrawable) {
            return drawable.bitmap
        }

        val result = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(result)
        drawable.setBounds(0, 0, result.width, result.height)
        drawable.draw(canvas)
        canvas.setBitmap(null)

        return result
    }

    @JvmStatic
    fun getNextHigherDensity(context: Context): Int {
        val density = context.resources.displayMetrics.densityDpi

        return when (density) {
            DisplayMetrics.DENSITY_LOW -> DisplayMetrics.DENSITY_MEDIUM
            DisplayMetrics.DENSITY_MEDIUM -> DisplayMetrics.DENSITY_HIGH
            DisplayMetrics.DENSITY_HIGH -> DisplayMetrics.DENSITY_XHIGH
            DisplayMetrics.DENSITY_XHIGH -> DisplayMetrics.DENSITY_XXHIGH
            DisplayMetrics.DENSITY_XXHIGH -> DisplayMetrics.DENSITY_XXXHIGH
            else -> density
        }
    }
}
