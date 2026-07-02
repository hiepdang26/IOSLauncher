package com.cloudx.ios17.features.launcher

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
import android.view.ScaleGestureDetector
import android.view.View
import kotlin.math.max
import kotlin.math.min

class HomeWidgetPhotoCropView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {
    private enum class DragMode {
        None,
        Crop,
        Image
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

    private val imageMatrix = Matrix()
    private val imageRect = RectF()
    private val cropRect = RectF()
    private val viewRect = RectF()
    private var bitmap: Bitmap? = null
    private var outputSize = HomeWidgetPhotoPolicy.OutputSize(width = 720, height = 720)
    private var dragMode = DragMode.None
    private var lastX = 0f
    private var lastY = 0f
    private var currentScaleMultiplier = 1f

    private val scaleDetector = ScaleGestureDetector(context, object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scaleImage(detector.scaleFactor, detector.focusX, detector.focusY)
            return true
        }
    })

    fun setBitmap(bitmap: Bitmap, outputSize: HomeWidgetPhotoPolicy.OutputSize) {
        this.bitmap = bitmap
        this.outputSize = outputSize
        currentScaleMultiplier = 1f
        configureGeometry(resetCrop = true)
        invalidate()
    }

    fun croppedBitmap(): Bitmap? {
        val source = bitmap ?: return null
        val sourceRect = HomeWidgetPhotoPolicy.sourceRectForCrop(
            imageRect = imageRect.toPolicyRect(),
            cropRect = cropRect.toPolicyRect(),
            bitmapWidth = source.width,
            bitmapHeight = source.height
        ) ?: return null
        val cropped = Bitmap.createBitmap(
            source,
            sourceRect.left,
            sourceRect.top,
            sourceRect.width.coerceAtLeast(1),
            sourceRect.height.coerceAtLeast(1)
        )
        return Bitmap.createScaledBitmap(cropped, outputSize.width, outputSize.height, true)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        configureGeometry(resetCrop = cropRect.isEmpty)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val source = bitmap ?: return
        canvas.drawColor(Color.BLACK)
        updateImageMatrix()
        canvas.drawBitmap(source, imageMatrix, bitmapPaint)
        drawDimmedOutsideCrop(canvas)
        drawCropFrame(canvas)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (bitmap == null || cropRect.isEmpty) return false
        scaleDetector.onTouchEvent(event)
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                parent?.requestDisallowInterceptTouchEvent(true)
                lastX = event.x
                lastY = event.y
                dragMode = if (cropRect.contains(event.x, event.y)) DragMode.Crop else DragMode.Image
                return true
            }
            MotionEvent.ACTION_POINTER_DOWN -> {
                dragMode = DragMode.None
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                if (!scaleDetector.isInProgress && event.pointerCount == 1) {
                    val dx = event.x - lastX
                    val dy = event.y - lastY
                    when (dragMode) {
                        DragMode.Crop -> moveCrop(dx, dy)
                        DragMode.Image -> moveImage(dx, dy)
                        DragMode.None -> Unit
                    }
                }
                lastX = event.x
                lastY = event.y
                invalidate()
                return true
            }
            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> {
                dragMode = DragMode.None
                parent?.requestDisallowInterceptTouchEvent(false)
                return true
            }
        }
        return true
    }

    private fun configureGeometry(resetCrop: Boolean) {
        val source = bitmap ?: return
        if (width <= 0 || height <= 0 || source.width <= 0 || source.height <= 0) return

        viewRect.set(0f, 0f, width.toFloat(), height.toFloat())
        if (resetCrop || cropRect.isEmpty) {
            val aspect = outputSize.width.toFloat() / outputSize.height.toFloat()
            val maxCropWidth = width * HomeWidgetPhotoCropLayoutPolicy.CROP_MAX_WIDTH_FRACTION
            val maxCropHeight = height * HomeWidgetPhotoCropLayoutPolicy.CROP_MAX_HEIGHT_FRACTION
            var cropWidth = maxCropWidth
            var cropHeight = cropWidth / aspect
            if (cropHeight > maxCropHeight) {
                cropHeight = maxCropHeight
                cropWidth = cropHeight * aspect
            }
            val left = (width - cropWidth) / 2f
            val top = (height - cropHeight) / 2f
            cropRect.set(left, top, left + cropWidth, top + cropHeight)
        } else {
            clampCropTo(viewRect)
        }

        val baseScale = max(width / source.width.toFloat(), height / source.height.toFloat())
        val drawWidth = source.width * baseScale * currentScaleMultiplier
        val drawHeight = source.height * baseScale * currentScaleMultiplier
        val left = (width - drawWidth) / 2f
        val top = (height - drawHeight) / 2f
        imageRect.set(left, top, left + drawWidth, top + drawHeight)
        ensureImageCoversCrop()
    }

    private fun scaleImage(scaleFactor: Float, focusX: Float, focusY: Float) {
        val safeScale = scaleFactor.coerceIn(0.85f, 1.2f)
        val nextMultiplier = (currentScaleMultiplier * safeScale).coerceIn(1f, 4f)
        val actualScale = nextMultiplier / currentScaleMultiplier
        currentScaleMultiplier = nextMultiplier
        imageRect.set(
            focusX + (imageRect.left - focusX) * actualScale,
            focusY + (imageRect.top - focusY) * actualScale,
            focusX + (imageRect.right - focusX) * actualScale,
            focusY + (imageRect.bottom - focusY) * actualScale
        )
        ensureImageCoversCrop()
        invalidate()
    }

    private fun moveCrop(dx: Float, dy: Float) {
        val bounds = RectF(
            max(viewRect.left, imageRect.left),
            max(viewRect.top, imageRect.top),
            min(viewRect.right, imageRect.right),
            min(viewRect.bottom, imageRect.bottom)
        )
        val width = cropRect.width()
        val height = cropRect.height()
        val left = (cropRect.left + dx).coerceIn(bounds.left, bounds.right - width)
        val top = (cropRect.top + dy).coerceIn(bounds.top, bounds.bottom - height)
        cropRect.set(left, top, left + width, top + height)
    }

    private fun moveImage(dx: Float, dy: Float) {
        imageRect.offset(dx, dy)
        ensureImageCoversCrop()
    }

    private fun ensureImageCoversCrop() {
        var offsetX = 0f
        var offsetY = 0f
        if (imageRect.left > cropRect.left) offsetX = cropRect.left - imageRect.left
        if (imageRect.right < cropRect.right) offsetX = cropRect.right - imageRect.right
        if (imageRect.top > cropRect.top) offsetY = cropRect.top - imageRect.top
        if (imageRect.bottom < cropRect.bottom) offsetY = cropRect.bottom - imageRect.bottom
        imageRect.offset(offsetX, offsetY)
        clampCropTo(RectF(max(viewRect.left, imageRect.left), max(viewRect.top, imageRect.top), min(viewRect.right, imageRect.right), min(viewRect.bottom, imageRect.bottom)))
    }

    private fun clampCropTo(bounds: RectF) {
        if (bounds.width() <= cropRect.width() || bounds.height() <= cropRect.height()) {
            return
        }
        val width = cropRect.width()
        val height = cropRect.height()
        val left = cropRect.left.coerceIn(bounds.left, bounds.right - width)
        val top = cropRect.top.coerceIn(bounds.top, bounds.bottom - height)
        cropRect.set(left, top, left + width, top + height)
    }

    private fun updateImageMatrix() {
        val source = bitmap ?: return
        imageMatrix.reset()
        imageMatrix.setRectToRect(
            RectF(0f, 0f, source.width.toFloat(), source.height.toFloat()),
            imageRect,
            Matrix.ScaleToFit.FILL
        )
    }

    private fun drawDimmedOutsideCrop(canvas: Canvas) {
        val outer = Path().apply {
            fillType = Path.FillType.EVEN_ODD
            addRect(0f, 0f, width.toFloat(), height.toFloat(), Path.Direction.CW)
            addRoundRect(cropRect, dp(3f), dp(3f), Path.Direction.CW)
        }
        canvas.drawPath(outer, dimPaint)
    }

    private fun drawCropFrame(canvas: Canvas) {
        canvas.drawRoundRect(cropRect, dp(3f), dp(3f), framePaint)
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

    private fun RectF.toPolicyRect(): HomeWidgetPhotoPolicy.FloatRect {
        return HomeWidgetPhotoPolicy.FloatRect(left, top, right, bottom)
    }

    private fun dp(value: Float): Float {
        return value * resources.displayMetrics.density
    }
}
