package com.vhmsoft.launcherios26.ui.launcher.icon

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class IconCropView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {
    private enum class DragMode {
        None,
        Move,
        Resize
    }

    private val bitmapPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
    private val dimPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = 0x99000000.toInt()
    }
    private val framePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        style = Paint.Style.STROKE
        strokeWidth = dp(2f)
    }
    private val gridPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = 0xCCFFFFFF.toInt()
        style = Paint.Style.STROKE
        strokeWidth = dp(1f)
    }
    private val cornerPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        style = Paint.Style.STROKE
        strokeWidth = dp(3f)
        strokeCap = Paint.Cap.SQUARE
    }

    private var bitmap: Bitmap? = null
    private val imageRect = RectF()
    private val cropRect = RectF()
    private val imageMatrix = Matrix()
    private var dragMode = DragMode.None
    private var activeHandle: CropResizeHandle? = null
    private var lastX = 0f
    private var lastY = 0f

    fun setBitmap(bitmap: Bitmap) {
        this.bitmap = bitmap
        configureGeometry()
        invalidate()
    }

    fun croppedBitmap(outputSize: Int): Bitmap? {
        val source = bitmap ?: return null
        if (imageRect.width() <= 0f || imageRect.height() <= 0f || cropRect.width() <= 0f) {
            return null
        }
        val scaleX = source.width / imageRect.width()
        val scaleY = source.height / imageRect.height()
        val srcLeft = ((cropRect.left - imageRect.left) * scaleX).toInt().coerceIn(0, source.width - 1)
        val srcTop = ((cropRect.top - imageRect.top) * scaleY).toInt().coerceIn(0, source.height - 1)
        val srcSize = min(
            (cropRect.width() * scaleX).toInt(),
            (cropRect.height() * scaleY).toInt()
        ).coerceAtLeast(1)
        val safeSize = min(srcSize, min(source.width - srcLeft, source.height - srcTop)).coerceAtLeast(1)
        val cropped = Bitmap.createBitmap(source, srcLeft, srcTop, safeSize, safeSize)
        return Bitmap.createScaledBitmap(cropped, outputSize, outputSize, true)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        configureGeometry()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val source = bitmap ?: return
        canvas.drawBitmap(source, imageMatrix, bitmapPaint)
        drawDimmedOutsideCrop(canvas)
        drawCropFrame(canvas)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (bitmap == null || cropRect.isEmpty) return false
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                parent?.requestDisallowInterceptTouchEvent(true)
                lastX = event.x
                lastY = event.y
                activeHandle = hitHandle(event.x, event.y)
                dragMode = if (activeHandle != null) {
                    DragMode.Resize
                } else if (cropRect.contains(event.x, event.y)) {
                    DragMode.Move
                } else {
                    DragMode.None
                }
                return dragMode != DragMode.None
            }

            MotionEvent.ACTION_MOVE -> {
                val dx = event.x - lastX
                val dy = event.y - lastY
                when (dragMode) {
                    DragMode.Move -> moveCrop(dx, dy)
                    DragMode.Resize -> activeHandle?.let { resizeCrop(it, dx, dy) }
                    DragMode.None -> Unit
                }
                lastX = event.x
                lastY = event.y
                invalidate()
                return true
            }

            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> {
                dragMode = DragMode.None
                activeHandle = null
                parent?.requestDisallowInterceptTouchEvent(false)
                return true
            }
        }
        return true
    }

    private fun configureGeometry() {
        val source = bitmap ?: return
        if (width <= 0 || height <= 0) return

        val viewRect = RectF(0f, 0f, width.toFloat(), height.toFloat())
        val scale = min(width / source.width.toFloat(), height / source.height.toFloat())
        val drawWidth = source.width * scale
        val drawHeight = source.height * scale
        val left = (width - drawWidth) / 2f
        val top = (height - drawHeight) / 2f
        imageRect.set(left, top, left + drawWidth, top + drawHeight)
        imageMatrix.reset()
        imageMatrix.setRectToRect(
            RectF(0f, 0f, source.width.toFloat(), source.height.toFloat()),
            imageRect,
            Matrix.ScaleToFit.CENTER
        )

        if (cropRect.isEmpty || !viewRect.contains(cropRect)) {
            val crop = IconCropGeometryPolicy.initialCropRect(imageRect.toCropRect(), 0.74f)
            cropRect.set(crop.left, crop.top, crop.right, crop.bottom)
        } else {
            val crop = IconCropGeometryPolicy.move(cropRect.toCropRect(), 0f, 0f, imageRect.toCropRect())
            cropRect.set(crop.left, crop.top, crop.right, crop.bottom)
        }
    }

    private fun drawDimmedOutsideCrop(canvas: Canvas) {
        val outer = Path().apply {
            fillType = Path.FillType.EVEN_ODD
            addRect(0f, 0f, width.toFloat(), height.toFloat(), Path.Direction.CW)
            addRoundRect(cropRect, cropRect.width() * 0.15f, cropRect.width() * 0.15f, Path.Direction.CW)
        }
        canvas.drawPath(outer, dimPaint)
    }

    private fun drawCropFrame(canvas: Canvas) {
        val radius = cropRect.width() * 0.15f
        canvas.drawRoundRect(cropRect, radius, radius, framePaint)

        val oneThirdX = cropRect.left + cropRect.width() / 3f
        val twoThirdX = cropRect.left + cropRect.width() * 2f / 3f
        val oneThirdY = cropRect.top + cropRect.height() / 3f
        val twoThirdY = cropRect.top + cropRect.height() * 2f / 3f
        canvas.drawLine(oneThirdX, cropRect.top, oneThirdX, cropRect.bottom, gridPaint)
        canvas.drawLine(twoThirdX, cropRect.top, twoThirdX, cropRect.bottom, gridPaint)
        canvas.drawLine(cropRect.left, oneThirdY, cropRect.right, oneThirdY, gridPaint)
        canvas.drawLine(cropRect.left, twoThirdY, cropRect.right, twoThirdY, gridPaint)

        val handle = dp(34f)
        drawCorner(canvas, cropRect.left, cropRect.top, handle, 1f, 1f)
        drawCorner(canvas, cropRect.right, cropRect.top, handle, -1f, 1f)
        drawCorner(canvas, cropRect.left, cropRect.bottom, handle, 1f, -1f)
        drawCorner(canvas, cropRect.right, cropRect.bottom, handle, -1f, -1f)
    }

    private fun drawCorner(canvas: Canvas, x: Float, y: Float, length: Float, xDirection: Float, yDirection: Float) {
        canvas.drawLine(x, y, x + length * xDirection, y, cornerPaint)
        canvas.drawLine(x, y, x, y + length * yDirection, cornerPaint)
    }

    private fun moveCrop(dx: Float, dy: Float) {
        val crop = IconCropGeometryPolicy.move(cropRect.toCropRect(), dx, dy, imageRect.toCropRect())
        cropRect.set(crop.left, crop.top, crop.right, crop.bottom)
    }

    private fun resizeCrop(handle: CropResizeHandle, dx: Float, dy: Float) {
        val minSize = min(imageRect.width(), imageRect.height()) * 0.24f
        val crop = IconCropGeometryPolicy.resize(
            crop = cropRect.toCropRect(),
            handle = handle,
            dx = dx,
            dy = dy,
            bounds = imageRect.toCropRect(),
            minSize = max(minSize, dp(96f))
        )
        cropRect.set(crop.left, crop.top, crop.right, crop.bottom)
    }

    private fun hitHandle(x: Float, y: Float): CropResizeHandle? {
        val touchRadius = dp(42f)
        return when {
            abs(x - cropRect.left) <= touchRadius && abs(y - cropRect.top) <= touchRadius -> CropResizeHandle.TopLeft
            abs(x - cropRect.right) <= touchRadius && abs(y - cropRect.top) <= touchRadius -> CropResizeHandle.TopRight
            abs(x - cropRect.left) <= touchRadius && abs(y - cropRect.bottom) <= touchRadius -> CropResizeHandle.BottomLeft
            abs(x - cropRect.right) <= touchRadius && abs(y - cropRect.bottom) <= touchRadius -> CropResizeHandle.BottomRight
            else -> null
        }
    }

    private fun RectF.toCropRect(): CropRect {
        return CropRect(left, top, right, bottom)
    }

    private fun dp(value: Float): Float {
        return value * resources.displayMetrics.density
    }
}
