package com.vhmsoft.launcherios26.ui.launcher.icon

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PixelFormat
import android.graphics.PointF
import android.graphics.RadialGradient
import android.graphics.RectF
import android.graphics.Shader
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp
import java.text.Normalizer
import java.util.Calendar
import java.util.Locale
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

object IosLauncherIconTheme {
    fun createIcon(app: LauncherApp, fallbackIcon: Drawable): Drawable {
        return roleFor(app)?.let { role ->
            IosSystemIconDrawable(role)
        } ?: IosMaskedIconDrawable(app.iconKey, fallbackIcon)
    }

    private fun roleFor(app: LauncherApp): IconRole? {
        val label = normalize(app.label)
        val packageName = app.packageName.lowercase(Locale.ROOT)

        return when {
            packageName == "com.android.vending" || label.has("play store", "cua hang play", "app store") -> IconRole.STORE
            packageName.contains("calendar") || label.has("calendar", "lich") -> IconRole.CALENDAR
            packageName.contains("camera") || label.has("camera", "may anh", "hd camera") -> IconRole.CAMERA
            packageName.contains("photos") || label.has("photos", "photo", "gallery", "anh", "hinh anh") -> IconRole.PHOTOS
            packageName.contains("maps") || label.has("maps", "map", "ban do") -> IconRole.MAPS
            packageName.contains("clock") || label.has("clock", "dong ho") -> IconRole.CLOCK
            packageName.contains("weather") || label.has("weather", "thoi tiet") -> IconRole.WEATHER
            packageName.contains("settings") || label.has("settings", "cai dat") -> IconRole.SETTINGS
            packageName.contains("dialer") || label.has("phone", "dien thoai", "goi dien") -> IconRole.PHONE
            packageName.contains("messaging") || label.has("messages", "message", "tin nhan", "sms") -> IconRole.MESSAGES
            packageName.contains("browser") || packageName.contains("chrome") || label.has("safari", "browser", "chrome", "coc coc") -> IconRole.BROWSER
            packageName.contains("music") || label.has("music", "nhac", "itunes") -> IconRole.MUSIC
            packageName.contains("gmail") || label.has("mail", "gmail", "email", "thu") -> IconRole.MAIL
            packageName.contains("contacts") || label.has("contacts", "contact", "lien he", "danh ba") -> IconRole.CONTACTS
            packageName.contains("files") || label.has("files", "file", "tep tin") -> IconRole.FILES
            label.has("notes", "note", "ghi chu", "keep") -> IconRole.NOTES
            label.has("news", "tin tuc") -> IconRole.NEWS
            label.has("home", "nha") -> IconRole.HOME
            label.has("stocks", "chung khoan") -> IconRole.STOCKS
            label.has("reminders", "nhac nho") -> IconRole.REMINDERS
            label.has("videos", "video") -> IconRole.VIDEOS
            label.has("books", "book", "sach") -> IconRole.BOOKS
            label.has("health", "suc khoe") -> IconRole.HEALTH
            label.has("wallet") -> IconRole.WALLET
            else -> null
        }
    }

    private fun normalize(value: String): String {
        return Normalizer.normalize(value.trim().lowercase(Locale.ROOT), Normalizer.Form.NFD)
            .replace("\\p{Mn}+".toRegex(), "")
    }

    private fun String.has(vararg tokens: String): Boolean {
        return tokens.any { token -> contains(token) }
    }
}

private enum class IconRole {
    MAIL,
    CALENDAR,
    PHOTOS,
    CAMERA,
    MAPS,
    CLOCK,
    WEATHER,
    NEWS,
    HOME,
    NOTES,
    STOCKS,
    REMINDERS,
    VIDEOS,
    STORE,
    BOOKS,
    HEALTH,
    WALLET,
    SETTINGS,
    PHONE,
    BROWSER,
    MESSAGES,
    MUSIC,
    CONTACTS,
    FILES
}

private class IosSystemIconDrawable(
    private val role: IconRole
) : Drawable() {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }
    private val iconPath = Path()
    private val rect = RectF()
    private var alphaValue = 255

    override fun draw(canvas: Canvas) {
        val bounds = bounds
        if (bounds.isEmpty) return

        val size = min(bounds.width(), bounds.height()).toFloat()
        val left = bounds.left + (bounds.width() - size) / 2f
        val top = bounds.top + (bounds.height() - size) / 2f
        val area = RectF(left, top, left + size, top + size)
        val radius = size * 0.23f

        canvas.save()
        iconPath.reset()
        iconPath.addRoundRect(area, radius, radius, Path.Direction.CW)
        canvas.clipPath(iconPath)
        drawBackground(canvas, area, role)
        drawGlyph(canvas, area, role)
        canvas.restore()
    }

    override fun setAlpha(alpha: Int) {
        alphaValue = alpha
        invalidateSelf()
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
        strokePaint.colorFilter = colorFilter
        invalidateSelf()
    }

    @Deprecated("Deprecated in Java")
    override fun getOpacity(): Int = PixelFormat.TRANSLUCENT

    private fun drawBackground(canvas: Canvas, area: RectF, role: IconRole) {
        paint.alpha = alphaValue
        paint.style = Paint.Style.FILL
        paint.shader = when (role) {
            IconRole.MAIL -> gradient(area, 0xFF32A8FF.toInt(), 0xFF0B70FF.toInt())
            IconRole.CAMERA -> gradient(area, 0xFFF6F6F6.toInt(), 0xFF9CA5AE.toInt())
            IconRole.MAPS -> gradient(area, 0xFFF5F7F8.toInt(), 0xFFDDEAF4.toInt())
            IconRole.WEATHER -> gradient(area, 0xFF43B3FF.toInt(), 0xFF1683FF.toInt())
            IconRole.NEWS -> gradient(area, 0xFFFF6D73.toInt(), 0xFFFF2F57.toInt())
            IconRole.HOME -> gradient(area, 0xFFFFFFFF.toInt(), 0xFFF2F4F7.toInt())
            IconRole.STOCKS -> gradient(area, 0xFF111318.toInt(), 0xFF020306.toInt())
            IconRole.VIDEOS -> gradient(area, 0xFF69D5FF.toInt(), 0xFF23A3E8.toInt())
            IconRole.STORE -> gradient(area, 0xFF56C8FF.toInt(), 0xFF0C82FF.toInt())
            IconRole.BOOKS -> gradient(area, 0xFFFFB13B.toInt(), 0xFFFF8A00.toInt())
            IconRole.WALLET -> gradient(area, 0xFF26282D.toInt(), 0xFF050506.toInt())
            IconRole.SETTINGS -> gradient(area, 0xFFE8EDF2.toInt(), 0xFFAAB4BF.toInt())
            IconRole.PHONE -> gradient(area, 0xFF51F36A.toInt(), 0xFF13BF36.toInt())
            IconRole.BROWSER -> gradient(area, 0xFFFFFFFF.toInt(), 0xFFEAF5FF.toInt())
            IconRole.MESSAGES -> gradient(area, 0xFF54F56D.toInt(), 0xFF0EC83C.toInt())
            IconRole.MUSIC -> gradient(area, 0xFFFFFFFF.toInt(), 0xFFFFF3F8.toInt())
            IconRole.CONTACTS -> gradient(area, 0xFFF1F5F8.toInt(), 0xFFC7D3DF.toInt())
            IconRole.FILES -> gradient(area, 0xFFFFC737.toInt(), 0xFFFF9F18.toInt())
            else -> gradient(area, 0xFFFFFFFF.toInt(), 0xFFF1F3F6.toInt())
        }
        canvas.drawRect(area, paint)
        paint.shader = null
    }

    private fun drawGlyph(canvas: Canvas, area: RectF, role: IconRole) {
        when (role) {
            IconRole.MAIL -> drawMail(canvas, area)
            IconRole.CALENDAR -> drawCalendar(canvas, area)
            IconRole.PHOTOS -> drawPhotos(canvas, area)
            IconRole.CAMERA -> drawCamera(canvas, area)
            IconRole.MAPS -> drawMaps(canvas, area)
            IconRole.CLOCK -> drawClock(canvas, area)
            IconRole.WEATHER -> drawWeather(canvas, area)
            IconRole.NEWS -> drawNews(canvas, area)
            IconRole.HOME -> drawHome(canvas, area)
            IconRole.NOTES -> drawNotes(canvas, area)
            IconRole.STOCKS -> drawStocks(canvas, area)
            IconRole.REMINDERS -> drawReminders(canvas, area)
            IconRole.VIDEOS -> drawVideos(canvas, area)
            IconRole.STORE -> drawStore(canvas, area)
            IconRole.BOOKS -> drawBooks(canvas, area)
            IconRole.HEALTH -> drawHealth(canvas, area)
            IconRole.WALLET -> drawWallet(canvas, area)
            IconRole.SETTINGS -> drawSettings(canvas, area)
            IconRole.PHONE -> drawPhone(canvas, area)
            IconRole.BROWSER -> drawBrowser(canvas, area)
            IconRole.MESSAGES -> drawMessages(canvas, area)
            IconRole.MUSIC -> drawMusic(canvas, area)
            IconRole.CONTACTS -> drawContacts(canvas, area)
            IconRole.FILES -> drawFiles(canvas, area)
        }
    }

    private fun drawMail(canvas: Canvas, area: RectF) {
        val r = area.width()
        strokePaint.alpha = alphaValue
        strokePaint.color = Color.WHITE
        strokePaint.strokeWidth = r * 0.055f
        rect.set(area.left + r * 0.19f, area.top + r * 0.29f, area.right - r * 0.19f, area.bottom - r * 0.29f)
        canvas.drawRoundRect(rect, r * 0.045f, r * 0.045f, strokePaint)
        iconPath.reset()
        iconPath.moveTo(rect.left, rect.top + r * 0.03f)
        iconPath.lineTo(area.centerX(), area.centerY() + r * 0.09f)
        iconPath.lineTo(rect.right, rect.top + r * 0.03f)
        canvas.drawPath(iconPath, strokePaint)
    }

    private fun drawCalendar(canvas: Canvas, area: RectF) {
        drawSolidRound(canvas, area, Color.WHITE)
        val r = area.width()
        drawCenteredText(canvas, "Friday", area.centerX(), area.top + r * 0.22f, r * 0.13f, 0xFFFF4D57.toInt(), Typeface.BOLD)
        val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH).toString()
        drawCenteredText(canvas, day, area.centerX(), area.top + r * 0.63f, r * 0.45f, 0xFF1B1B1F.toInt(), Typeface.NORMAL)
    }

    private fun drawPhotos(canvas: Canvas, area: RectF) {
        drawSolidRound(canvas, area, Color.WHITE)
        val colors = intArrayOf(
            0xFFFF3B30.toInt(),
            0xFFFF9500.toInt(),
            0xFFFFCC00.toInt(),
            0xFF34C759.toInt(),
            0xFF32ADE6.toInt(),
            0xFF007AFF.toInt(),
            0xFFAF52DE.toInt(),
            0xFFFF2D55.toInt()
        )
        val r = area.width()
        colors.forEachIndexed { index, color ->
            paint.color = color
            paint.alpha = (alphaValue * 0.82f).toInt()
            canvas.save()
            canvas.rotate((index * 45).toFloat(), area.centerX(), area.centerY())
            rect.set(area.centerX() - r * 0.09f, area.top + r * 0.18f, area.centerX() + r * 0.09f, area.centerY() + r * 0.05f)
            canvas.drawOval(rect, paint)
            canvas.restore()
        }
        paint.alpha = alphaValue
        paint.color = Color.WHITE
        canvas.drawCircle(area.centerX(), area.centerY(), r * 0.11f, paint)
    }

    private fun drawCamera(canvas: Canvas, area: RectF) {
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = 0xFF101115.toInt()
        rect.set(area.left + r * 0.18f, area.top + r * 0.34f, area.right - r * 0.16f, area.bottom - r * 0.23f)
        canvas.drawRoundRect(rect, r * 0.08f, r * 0.08f, paint)
        paint.color = 0xFF2B3038.toInt()
        rect.set(area.left + r * 0.29f, area.top + r * 0.25f, area.left + r * 0.49f, area.top + r * 0.36f)
        canvas.drawRoundRect(rect, r * 0.045f, r * 0.045f, paint)
        paint.color = 0xFF040506.toInt()
        canvas.drawCircle(area.centerX(), area.centerY() + r * 0.08f, r * 0.18f, paint)
        paint.color = 0xFF1E2630.toInt()
        canvas.drawCircle(area.centerX(), area.centerY() + r * 0.08f, r * 0.11f, paint)
        paint.color = 0xFFFF2D55.toInt()
        canvas.drawCircle(area.right - r * 0.23f, area.top + r * 0.41f, r * 0.035f, paint)
    }

    private fun drawMaps(canvas: Canvas, area: RectF) {
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = 0xFF4CD964.toInt()
        drawStripe(canvas, area, -0.17f, 0.16f, paint)
        paint.color = 0xFFFFCC00.toInt()
        drawStripe(canvas, area, 0.18f, 0.14f, paint)
        strokePaint.alpha = alphaValue
        strokePaint.strokeWidth = r * 0.08f
        strokePaint.color = 0xFF007AFF.toInt()
        iconPath.reset()
        iconPath.moveTo(area.left + r * 0.21f, area.bottom - r * 0.17f)
        iconPath.cubicTo(area.left + r * 0.33f, area.top + r * 0.42f, area.right - r * 0.31f, area.bottom - r * 0.56f, area.right - r * 0.15f, area.top + r * 0.21f)
        canvas.drawPath(iconPath, strokePaint)
        drawPin(canvas, area.left + r * 0.32f, area.top + r * 0.36f, r * 0.13f, 0xFFFF3B30.toInt())
    }

    private fun drawClock(canvas: Canvas, area: RectF) {
        drawSolidRound(canvas, area, Color.WHITE)
        val r = area.width()
        strokePaint.alpha = alphaValue
        strokePaint.color = 0xFF111111.toInt()
        strokePaint.strokeWidth = r * 0.018f
        canvas.drawCircle(area.centerX(), area.centerY(), r * 0.34f, strokePaint)
        for (tick in 0 until 12) {
            val angle = Math.toRadians((tick * 30 - 90).toDouble())
            val start = PointF(
                area.centerX() + cos(angle).toFloat() * r * 0.27f,
                area.centerY() + sin(angle).toFloat() * r * 0.27f
            )
            val end = PointF(
                area.centerX() + cos(angle).toFloat() * r * 0.31f,
                area.centerY() + sin(angle).toFloat() * r * 0.31f
            )
            canvas.drawLine(start.x, start.y, end.x, end.y, strokePaint)
        }
        strokePaint.strokeWidth = r * 0.035f
        canvas.drawLine(area.centerX(), area.centerY(), area.centerX(), area.top + r * 0.31f, strokePaint)
        strokePaint.color = 0xFFFF3B30.toInt()
        canvas.drawLine(area.centerX(), area.centerY(), area.right - r * 0.27f, area.centerY() + r * 0.13f, strokePaint)
    }

    private fun drawWeather(canvas: Canvas, area: RectF) {
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = 0xFFFFCC00.toInt()
        canvas.drawCircle(area.right - r * 0.27f, area.top + r * 0.32f, r * 0.15f, paint)
        drawCloud(canvas, area.left + r * 0.22f, area.top + r * 0.44f, r * 0.55f, Color.WHITE)
    }

    private fun drawNews(canvas: Canvas, area: RectF) {
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = Color.WHITE
        rect.set(area.left + r * 0.24f, area.top + r * 0.18f, area.right - r * 0.2f, area.bottom - r * 0.18f)
        canvas.drawRoundRect(rect, r * 0.04f, r * 0.04f, paint)
        paint.color = 0xFFFF2D55.toInt()
        repeat(4) { index ->
            rect.set(area.left + r * 0.33f, area.top + r * (0.3f + index * 0.11f), area.right - r * 0.27f, area.top + r * (0.34f + index * 0.11f))
            canvas.drawRoundRect(rect, r * 0.015f, r * 0.015f, paint)
        }
    }

    private fun drawHome(canvas: Canvas, area: RectF) {
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = 0xFFFF9500.toInt()
        iconPath.reset()
        iconPath.moveTo(area.left + r * 0.18f, area.centerY())
        iconPath.lineTo(area.centerX(), area.top + r * 0.24f)
        iconPath.lineTo(area.right - r * 0.18f, area.centerY())
        iconPath.close()
        canvas.drawPath(iconPath, paint)
        rect.set(area.left + r * 0.28f, area.centerY() - r * 0.01f, area.right - r * 0.28f, area.bottom - r * 0.2f)
        canvas.drawRoundRect(rect, r * 0.04f, r * 0.04f, paint)
    }

    private fun drawNotes(canvas: Canvas, area: RectF) {
        drawSolidRound(canvas, area, Color.WHITE)
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = 0xFFFFCC00.toInt()
        rect.set(area.left, area.top, area.right, area.top + r * 0.23f)
        canvas.drawRect(rect, paint)
        strokePaint.alpha = (alphaValue * 0.62f).toInt()
        strokePaint.color = 0xFFC9CDD2.toInt()
        strokePaint.strokeWidth = r * 0.017f
        repeat(4) { index ->
            val y = area.top + r * (0.38f + index * 0.13f)
            canvas.drawLine(area.left + r * 0.18f, y, area.right - r * 0.15f, y, strokePaint)
        }
    }

    private fun drawStocks(canvas: Canvas, area: RectF) {
        val r = area.width()
        strokePaint.alpha = alphaValue
        strokePaint.strokeWidth = r * 0.04f
        strokePaint.color = 0xFF34C759.toInt()
        iconPath.reset()
        iconPath.moveTo(area.left + r * 0.12f, area.bottom - r * 0.35f)
        iconPath.lineTo(area.left + r * 0.33f, area.bottom - r * 0.52f)
        iconPath.lineTo(area.left + r * 0.5f, area.bottom - r * 0.42f)
        iconPath.lineTo(area.right - r * 0.12f, area.top + r * 0.28f)
        canvas.drawPath(iconPath, strokePaint)
        strokePaint.color = 0xFF4DA3FF.toInt()
        canvas.drawLine(area.left + r * 0.14f, area.centerY(), area.right - r * 0.12f, area.centerY(), strokePaint)
    }

    private fun drawReminders(canvas: Canvas, area: RectF) {
        drawSolidRound(canvas, area, Color.WHITE)
        val r = area.width()
        val colors = intArrayOf(0xFFFF9500.toInt(), 0xFF34C759.toInt(), 0xFF007AFF.toInt(), 0xFFFF2D55.toInt())
        repeat(4) { index ->
            val y = area.top + r * (0.3f + index * 0.13f)
            paint.alpha = alphaValue
            paint.color = colors[index]
            canvas.drawCircle(area.left + r * 0.24f, y, r * 0.035f, paint)
            strokePaint.alpha = (alphaValue * 0.55f).toInt()
            strokePaint.color = 0xFFC7CDD3.toInt()
            strokePaint.strokeWidth = r * 0.02f
            canvas.drawLine(area.left + r * 0.34f, y, area.right - r * 0.18f, y, strokePaint)
        }
    }

    private fun drawVideos(canvas: Canvas, area: RectF) {
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = Color.WHITE
        rect.set(area.left + r * 0.17f, area.top + r * 0.36f, area.right - r * 0.17f, area.bottom - r * 0.2f)
        canvas.drawRoundRect(rect, r * 0.06f, r * 0.06f, paint)
        paint.color = 0xFF111111.toInt()
        repeat(3) { index ->
            rect.set(area.left + r * (0.17f + index * 0.22f), area.top + r * 0.18f, area.left + r * (0.31f + index * 0.22f), area.top + r * 0.31f)
            canvas.drawRect(rect, paint)
        }
    }

    private fun drawStore(canvas: Canvas, area: RectF) {
        val r = area.width()
        strokePaint.alpha = alphaValue
        strokePaint.color = Color.WHITE
        strokePaint.strokeWidth = r * 0.075f
        canvas.drawLine(area.centerX() - r * 0.18f, area.bottom - r * 0.24f, area.centerX() + r * 0.18f, area.top + r * 0.24f, strokePaint)
        canvas.drawLine(area.centerX() + r * 0.18f, area.bottom - r * 0.24f, area.centerX() - r * 0.18f, area.top + r * 0.24f, strokePaint)
        strokePaint.strokeWidth = r * 0.06f
        canvas.drawLine(area.left + r * 0.25f, area.bottom - r * 0.33f, area.right - r * 0.25f, area.bottom - r * 0.33f, strokePaint)
    }

    private fun drawBooks(canvas: Canvas, area: RectF) {
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = Color.WHITE
        rect.set(area.left + r * 0.2f, area.top + r * 0.26f, area.centerX() - r * 0.02f, area.bottom - r * 0.2f)
        canvas.drawRoundRect(rect, r * 0.03f, r * 0.03f, paint)
        rect.set(area.centerX() + r * 0.02f, area.top + r * 0.26f, area.right - r * 0.2f, area.bottom - r * 0.2f)
        canvas.drawRoundRect(rect, r * 0.03f, r * 0.03f, paint)
    }

    private fun drawHealth(canvas: Canvas, area: RectF) {
        drawSolidRound(canvas, area, Color.WHITE)
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = 0xFFFF2D55.toInt()
        canvas.drawCircle(area.centerX() - r * 0.09f, area.centerY() - r * 0.05f, r * 0.105f, paint)
        canvas.drawCircle(area.centerX() + r * 0.09f, area.centerY() - r * 0.05f, r * 0.105f, paint)
        iconPath.reset()
        iconPath.moveTo(area.centerX() - r * 0.2f, area.centerY())
        iconPath.lineTo(area.centerX(), area.centerY() + r * 0.24f)
        iconPath.lineTo(area.centerX() + r * 0.2f, area.centerY())
        iconPath.close()
        canvas.drawPath(iconPath, paint)
    }

    private fun drawWallet(canvas: Canvas, area: RectF) {
        val r = area.width()
        val colors = intArrayOf(0xFFFF3B30.toInt(), 0xFFFF9500.toInt(), 0xFF34C759.toInt(), 0xFF007AFF.toInt())
        colors.forEachIndexed { index, color ->
            paint.alpha = alphaValue
            paint.color = color
            rect.set(area.left + r * 0.19f, area.top + r * (0.23f + index * 0.105f), area.right - r * 0.18f, area.top + r * (0.31f + index * 0.105f))
            canvas.drawRoundRect(rect, r * 0.035f, r * 0.035f, paint)
        }
    }

    private fun drawSettings(canvas: Canvas, area: RectF) {
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = 0xFF7F8A96.toInt()
        canvas.drawCircle(area.centerX(), area.centerY(), r * 0.27f, paint)
        paint.color = 0xFFDCE2E8.toInt()
        canvas.drawCircle(area.centerX(), area.centerY(), r * 0.15f, paint)
        strokePaint.alpha = alphaValue
        strokePaint.color = 0xFF7F8A96.toInt()
        strokePaint.strokeWidth = r * 0.055f
        repeat(8) { index ->
            val angle = Math.toRadians((index * 45).toDouble())
            canvas.drawLine(
                area.centerX() + cos(angle).toFloat() * r * 0.31f,
                area.centerY() + sin(angle).toFloat() * r * 0.31f,
                area.centerX() + cos(angle).toFloat() * r * 0.39f,
                area.centerY() + sin(angle).toFloat() * r * 0.39f,
                strokePaint
            )
        }
    }

    private fun drawPhone(canvas: Canvas, area: RectF) {
        val r = area.width()
        strokePaint.alpha = alphaValue
        strokePaint.color = Color.WHITE
        strokePaint.strokeWidth = r * 0.12f
        iconPath.reset()
        iconPath.moveTo(area.left + r * 0.32f, area.top + r * 0.28f)
        iconPath.cubicTo(area.left + r * 0.28f, area.top + r * 0.48f, area.left + r * 0.48f, area.bottom - r * 0.28f, area.right - r * 0.28f, area.bottom - r * 0.34f)
        canvas.drawPath(iconPath, strokePaint)
    }

    private fun drawBrowser(canvas: Canvas, area: RectF) {
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = 0xFF2EA7FF.toInt()
        canvas.drawCircle(area.centerX(), area.centerY(), r * 0.32f, paint)
        paint.color = Color.WHITE
        canvas.drawCircle(area.centerX(), area.centerY(), r * 0.27f, paint)
        paint.color = 0xFFFF3B30.toInt()
        drawNeedle(canvas, area, -1f)
        paint.color = 0xFF007AFF.toInt()
        drawNeedle(canvas, area, 1f)
    }

    private fun drawMessages(canvas: Canvas, area: RectF) {
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = Color.WHITE
        rect.set(area.left + r * 0.18f, area.top + r * 0.26f, area.right - r * 0.18f, area.bottom - r * 0.28f)
        canvas.drawOval(rect, paint)
        iconPath.reset()
        iconPath.moveTo(area.left + r * 0.39f, area.bottom - r * 0.31f)
        iconPath.lineTo(area.left + r * 0.3f, area.bottom - r * 0.17f)
        iconPath.lineTo(area.left + r * 0.51f, area.bottom - r * 0.28f)
        iconPath.close()
        canvas.drawPath(iconPath, paint)
    }

    private fun drawMusic(canvas: Canvas, area: RectF) {
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = 0xFFFF2D55.toInt()
        paint.style = Paint.Style.FILL
        rect.set(area.left + r * 0.36f, area.bottom - r * 0.34f, area.left + r * 0.52f, area.bottom - r * 0.18f)
        canvas.drawOval(rect, paint)
        strokePaint.alpha = alphaValue
        strokePaint.color = 0xFFFF2D55.toInt()
        strokePaint.strokeWidth = r * 0.07f
        canvas.drawLine(area.left + r * 0.5f, area.bottom - r * 0.27f, area.left + r * 0.5f, area.top + r * 0.23f, strokePaint)
        canvas.drawLine(area.left + r * 0.5f, area.top + r * 0.23f, area.right - r * 0.25f, area.top + r * 0.17f, strokePaint)
    }

    private fun drawContacts(canvas: Canvas, area: RectF) {
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = 0xFF8E8E93.toInt()
        canvas.drawCircle(area.centerX(), area.top + r * 0.36f, r * 0.13f, paint)
        rect.set(area.left + r * 0.27f, area.top + r * 0.54f, area.right - r * 0.27f, area.bottom - r * 0.2f)
        canvas.drawOval(rect, paint)
        paint.color = 0xFF34C759.toInt()
        rect.set(area.right - r * 0.16f, area.top + r * 0.16f, area.right, area.bottom - r * 0.16f)
        canvas.drawRect(rect, paint)
    }

    private fun drawFiles(canvas: Canvas, area: RectF) {
        val r = area.width()
        paint.alpha = alphaValue
        paint.color = Color.WHITE
        rect.set(area.left + r * 0.18f, area.top + r * 0.28f, area.right - r * 0.18f, area.bottom - r * 0.22f)
        canvas.drawRoundRect(rect, r * 0.055f, r * 0.055f, paint)
        paint.color = 0xFFFFC737.toInt()
        rect.set(area.left + r * 0.18f, area.top + r * 0.2f, area.left + r * 0.5f, area.top + r * 0.35f)
        canvas.drawRoundRect(rect, r * 0.045f, r * 0.045f, paint)
    }

    private fun drawCloud(canvas: Canvas, left: Float, top: Float, size: Float, color: Int) {
        paint.alpha = alphaValue
        paint.color = color
        canvas.drawCircle(left + size * 0.26f, top + size * 0.36f, size * 0.17f, paint)
        canvas.drawCircle(left + size * 0.45f, top + size * 0.28f, size * 0.21f, paint)
        canvas.drawCircle(left + size * 0.66f, top + size * 0.38f, size * 0.16f, paint)
        rect.set(left + size * 0.16f, top + size * 0.36f, left + size * 0.77f, top + size * 0.58f)
        canvas.drawRoundRect(rect, size * 0.11f, size * 0.11f, paint)
    }

    private fun drawNeedle(canvas: Canvas, area: RectF, direction: Float) {
        val r = area.width()
        iconPath.reset()
        iconPath.moveTo(area.centerX(), area.centerY() - r * 0.26f * direction)
        iconPath.lineTo(area.centerX() + r * 0.09f, area.centerY())
        iconPath.lineTo(area.centerX(), area.centerY() + r * 0.26f * direction)
        iconPath.lineTo(area.centerX() - r * 0.09f, area.centerY())
        iconPath.close()
        canvas.drawPath(iconPath, paint)
    }

    private fun drawStripe(canvas: Canvas, area: RectF, offset: Float, width: Float, paint: Paint) {
        val r = area.width()
        iconPath.reset()
        iconPath.moveTo(area.left + r * offset, area.bottom)
        iconPath.lineTo(area.left + r * (offset + width), area.bottom)
        iconPath.lineTo(area.right + r * (offset + width), area.top)
        iconPath.lineTo(area.right + r * offset, area.top)
        iconPath.close()
        canvas.drawPath(iconPath, paint)
    }

    private fun drawPin(canvas: Canvas, x: Float, y: Float, radius: Float, color: Int) {
        paint.alpha = alphaValue
        paint.color = color
        canvas.drawCircle(x, y, radius, paint)
        iconPath.reset()
        iconPath.moveTo(x - radius * 0.75f, y + radius * 0.45f)
        iconPath.lineTo(x, y + radius * 1.65f)
        iconPath.lineTo(x + radius * 0.75f, y + radius * 0.45f)
        iconPath.close()
        canvas.drawPath(iconPath, paint)
        paint.color = Color.WHITE
        canvas.drawCircle(x, y, radius * 0.38f, paint)
    }

    private fun drawSolidRound(canvas: Canvas, area: RectF, color: Int) {
        paint.alpha = alphaValue
        paint.style = Paint.Style.FILL
        paint.shader = null
        paint.color = color
        canvas.drawRect(area, paint)
    }

    private fun drawCenteredText(
        canvas: Canvas,
        text: String,
        x: Float,
        baselineCenterY: Float,
        size: Float,
        color: Int,
        style: Int
    ) {
        paint.alpha = alphaValue
        paint.shader = null
        paint.color = color
        paint.textAlign = Paint.Align.CENTER
        paint.typeface = Typeface.create("sans-serif", style)
        paint.textSize = size
        val metrics = paint.fontMetrics
        canvas.drawText(text, x, baselineCenterY - (metrics.ascent + metrics.descent) / 2f, paint)
    }

    private fun gradient(area: RectF, startColor: Int, endColor: Int): LinearGradient {
        return LinearGradient(area.left, area.top, area.right, area.bottom, startColor, endColor, Shader.TileMode.CLAMP)
    }
}

private class IosMaskedIconDrawable(
    private val key: String,
    private val source: Drawable
) : Drawable() {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val clipPath = Path()
    private var alphaValue = 255

    override fun draw(canvas: Canvas) {
        val bounds = bounds
        if (bounds.isEmpty) return

        val size = min(bounds.width(), bounds.height()).toFloat()
        val left = bounds.left + (bounds.width() - size) / 2f
        val top = bounds.top + (bounds.height() - size) / 2f
        val area = RectF(left, top, left + size, top + size)
        val radius = size * 0.23f

        canvas.save()
        clipPath.reset()
        clipPath.addRoundRect(area, radius, radius, Path.Direction.CW)
        canvas.clipPath(clipPath)
        paint.shader = fallbackGradient(area)
        paint.alpha = alphaValue
        canvas.drawRect(area, paint)
        paint.shader = null
        source.alpha = alphaValue
        source.setBounds(area.left.toInt(), area.top.toInt(), area.right.toInt(), area.bottom.toInt())
        source.draw(canvas)
        canvas.restore()
    }

    override fun setAlpha(alpha: Int) {
        alphaValue = alpha
        invalidateSelf()
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        source.colorFilter = colorFilter
        invalidateSelf()
    }

    @Deprecated("Deprecated in Java")
    override fun getOpacity(): Int = PixelFormat.TRANSLUCENT

    private fun fallbackGradient(area: RectF): RadialGradient {
        val seed = key.hashCode()
        val start = Color.HSVToColor(
            floatArrayOf(
                ((seed and 0xFF) * 360f / 255f),
                0.3f,
                0.95f
            )
        )
        val end = Color.HSVToColor(
            floatArrayOf(
                (((seed shr 8) and 0xFF) * 360f / 255f),
                0.38f,
                0.72f
            )
        )
        return RadialGradient(area.centerX(), area.top, area.width() * 0.9f, start, end, Shader.TileMode.CLAMP)
    }
}
