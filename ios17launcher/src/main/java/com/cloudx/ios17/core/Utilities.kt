package com.cloudx.ios17.core

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.TextUtils
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern
import kotlin.math.ceil
import kotlin.math.roundToInt
import org.apache.commons.lang3.StringUtils
import timber.log.Timber

object Utilities {
    private const val TAG = "Utilities"

    private val sTrimPattern: Pattern =
        Pattern.compile("^[\\s|\\p{javaSpaceChar}]*(.*)[\\s|\\p{javaSpaceChar}]*$")

    /** Use hard coded values to compile with android source. */
    @JvmField
    val ATLEAST_R = Build.VERSION.SDK_INT >= 30

    @JvmField
    val ATLEAST_OREO = Build.VERSION.SDK_INT >= 26

    @JvmField
    val ATLEAST_NOUGAT_MR1 = Build.VERSION.SDK_INT >= 25

    @JvmField
    val ATLEAST_NOUGAT = Build.VERSION.SDK_INT >= 24

    @JvmField
    val ATLEAST_MARSHMALLOW = Build.VERSION.SDK_INT >= 23

    private val CPU_COUNT = Runtime.getRuntime().availableProcessors()
    private val CORE_POOL_SIZE = CPU_COUNT + 1
    private val MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1
    private const val KEEP_ALIVE = 1L

    /**
     * An [Executor] to be used with async task with no limit on the queue size.
     */
    @JvmField
    val THREAD_POOL_EXECUTOR: Executor = ThreadPoolExecutor(
        CORE_POOL_SIZE,
        MAXIMUM_POOL_SIZE,
        KEEP_ALIVE,
        TimeUnit.SECONDS,
        LinkedBlockingQueue()
    )

    /** Compresses the bitmap to a byte array for serialization. */
    @JvmStatic
    fun flattenBitmap(bitmap: Bitmap): ByteArray? {
        val size = bitmap.width * bitmap.height * 4
        val out = ByteArrayOutputStream(size)
        return try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            out.flush()
            out.close()
            out.toByteArray()
        } catch (_: IOException) {
            Timber.tag(TAG).w("Could not write bitmap")
            null
        }
    }

    @JvmStatic
    fun dpiFromPx(size: Int, metrics: DisplayMetrics): Float {
        val densityRatio = metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT
        return size / densityRatio
    }

    @JvmStatic
    fun pxFromDp(size: Float, metrics: DisplayMetrics): Int =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size, metrics).roundToInt()

    @JvmStatic
    fun pxFromDp(dp: Int, context: Context): Float {
        val metrics = context.resources.displayMetrics
        return dp * (metrics.densityDpi / 160f)
    }

    @JvmStatic
    fun pxFromSp(size: Float, metrics: DisplayMetrics): Int =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, size, metrics).roundToInt()

    /** Calculates the height of a given string at a specific text size. */
    @JvmStatic
    fun calculateTextHeight(textSizePx: Float): Int {
        val paint = Paint()
        paint.textSize = textSizePx
        val fontMetrics = paint.fontMetrics
        return ceil((fontMetrics.bottom - fontMetrics.top).toDouble()).toInt()
    }

    @JvmStatic
    fun convertMonthToString(): String {
        val cal = Calendar.getInstance()
        val monthDate = SimpleDateFormat("MMM", Locale.getDefault())
        return monthDate.format(cal.time)
    }

    /**
     * Trims the string, removing all whitespace at the beginning and end of the
     * string. Non-breaking whitespaces are also removed.
     */
    @JvmStatic
    fun trim(s: CharSequence?): String? {
        if (s == null) {
            return null
        }

        val matcher = sTrimPattern.matcher(s)
        return matcher.replaceAll("$1")
    }

    @JvmStatic
    fun getAllChildrenViews(view: View): ArrayList<View> {
        if (view !is ViewGroup) {
            return arrayListOf(view)
        }

        val result = ArrayList<View>()
        for (i in 0 until view.childCount) {
            val child = view.getChildAt(i)

            val viewArrayList = ArrayList<View>()
            viewArrayList.add(view)
            viewArrayList.addAll(getAllChildrenViews(child))

            result.addAll(viewArrayList)
        }

        return result
    }

    @JvmStatic
    fun drawableToBitmap(drawable: Drawable?): Bitmap? = drawableToBitmap(drawable, true)

    @JvmStatic
    fun drawableToBitmap(drawable: Drawable?, forceCreate: Boolean): Bitmap? =
        drawableToBitmap(drawable, forceCreate, 0)

    @JvmStatic
    fun drawableToBitmap(drawable: Drawable?, forceCreate: Boolean, fallbackSize: Int): Bitmap? {
        val safeDrawable = drawable!!
        if (!forceCreate && safeDrawable is BitmapDrawable) {
            return safeDrawable.bitmap
        }

        var width = safeDrawable.intrinsicWidth
        var height = safeDrawable.intrinsicHeight

        if (width <= 0 || height <= 0) {
            if (fallbackSize > 0) {
                width = fallbackSize
                height = fallbackSize
            } else {
                return null
            }
        }

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        safeDrawable.setBounds(0, 0, canvas.width, canvas.height)
        safeDrawable.draw(canvas)
        return bitmap
    }

    @JvmStatic
    fun isBootCompleted(): Boolean = "1" == getSystemProperty("sys.boot_completed", "1")

    @JvmStatic
    fun getSystemProperty(property: String, defaultValue: String): String {
        try {
            val clazz = Class.forName("android.os.SystemProperties")
            val getter = clazz.getDeclaredMethod("get", String::class.java)
            val value = getter.invoke(null, property) as String?
            if (!TextUtils.isEmpty(value)) {
                return value!!
            }
        } catch (_: Exception) {
            Timber.tag(TAG).d("Unable to read system properties")
        }
        return defaultValue
    }

    /**
     * Utility method to determine whether the given point, in local coordinates, is
     * inside the view, where the area of the view is expanded by the slop factor.
     */
    @JvmStatic
    fun pointInView(v: View, localX: Float, localY: Float, slop: Float): Boolean =
        localX >= -slop &&
            localY >= -slop &&
            localX < v.width + slop &&
            localY < v.height + slop

    /**
     * Ensures that a value is within given bounds.
     */
    @JvmStatic
    fun boundToRange(value: Int, lowerBound: Int, upperBound: Int): Int =
        maxOf(lowerBound, minOf(value, upperBound))

    @JvmStatic
    fun stripCaseAndAccents(input: String): String =
        StringUtils.stripAccents(input.lowercase(Locale.getDefault()))
}
