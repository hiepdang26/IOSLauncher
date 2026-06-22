package com.cloudx.ios17.core.customviews

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.content.res.Resources
import android.content.res.Resources.Theme
import android.content.res.TypedArray
import android.graphics.Bitmap
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Matrix
import android.graphics.Outline
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PixelFormat
import android.graphics.PorterDuff.Mode
import android.graphics.Rect
import android.graphics.Region
import android.graphics.Shader
import android.graphics.Shader.TileMode
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import com.cloudx.ios17.core.utils.AdaptiveIconUtils
import java.io.IOException
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException

class AdaptiveIconDrawableCompat internal constructor(
    state: LayerState?,
    res: Resources?
) : Drawable(), Drawable.Callback {

    private val mMask: Path
    private val mMaskMatrix: Matrix
    private val mTransparentRegion: Region

    private var mMaskBitmap: Bitmap? = null

    internal var mLayerState: LayerState

    private var mLayersShader: Shader? = null
    private var mLayersBitmap: Bitmap? = null

    private val mTmpOutRect = Rect()
    private var mHotspotBounds: Rect? = null
    private var mMutated = false

    private var mSuspendChildInvalidation = false
    private var mChildRequestedInvalidation = false
    private val mCanvas: Canvas
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG or Paint.FILTER_BITMAP_FLAG)

    private var methodCreatePathFromPathData: Method? = null
    private var methodExtractThemeAttrs: Method? = null

    private var mUseMyUglyWorkaround = true

    constructor() : this(null as LayerState?, null)

    constructor(backgroundDrawable: Drawable?, foregroundDrawable: Drawable?) : this(
        backgroundDrawable,
        foregroundDrawable,
        true
    )

    constructor(
        backgroundDrawable: Drawable?,
        foregroundDrawable: Drawable?,
        useMyUglyWorkaround: Boolean
    ) : this(null as LayerState?, null) {
        if (backgroundDrawable != null) {
            addLayer(BACKGROUND_ID, createChildDrawable(backgroundDrawable))
        }
        if (foregroundDrawable != null) {
            addLayer(FOREGROUND_ID, createChildDrawable(foregroundDrawable))
        }
        mUseMyUglyWorkaround = useMyUglyWorkaround
    }

    init {
        initReflections()

        mLayerState = createConstantState(state, res)

        if (sMask == null) {
            sMask = PathParser.createPathFromPathData(maskPath)
        }
        mMask = PathParser.createPathFromPathData(maskPath)
        mMaskMatrix = Matrix()
        mCanvas = Canvas()
        mTransparentRegion = Region()
    }

    @SuppressLint("PrivateApi", "DiscouragedPrivateApi")
    private fun initReflections() {
        try {
            val pathParser = javaClass.classLoader!!.loadClass("android.util.PathParser")
            methodCreatePathFromPathData = pathParser.getDeclaredMethod("createPathFromPathData", String::class.java)
            methodExtractThemeAttrs = TypedArray::class.java.getDeclaredMethod("extractThemeAttrs")
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> invoke(method: Method?, obj: Any, vararg params: Any?): T? {
        if (method == null) {
            return null
        }
        return try {
            method.invoke(obj, *params) as T
        } catch (e: IllegalAccessException) {
            null
        } catch (e: InvocationTargetException) {
            null
        }
    }

    private val maskPath: String
        get() = AdaptiveIconUtils.getMaskPath()

    private fun createChildDrawable(drawable: Drawable): ChildDrawable {
        val layer = ChildDrawable(mLayerState.mDensity)
        layer.mDrawable = drawable
        layer.mDrawable?.callback = this
        mLayerState.mChildrenChangingConfigurations =
            mLayerState.mChildrenChangingConfigurations or (layer.mDrawable?.changingConfigurations ?: 0)
        return layer
    }

    internal fun createConstantState(state: LayerState?, res: Resources?): LayerState =
        LayerState(state, this, res)

    private fun addLayer(index: Int, layer: ChildDrawable) {
        mLayerState.mChildren[index] = layer
        mLayerState.invalidateCache()
    }

    @Throws(XmlPullParserException::class, IOException::class)
    override fun inflate(r: Resources, parser: XmlPullParser, attrs: AttributeSet, theme: Theme?) {
        super.inflate(r, parser, attrs, theme)

        val state = mLayerState
        resolveDensity(r, 0)

        inflateLayers(r, parser, attrs, theme)
    }

    @JvmName("getIconMask")
    fun getIconMask(): Path = mMask

    override fun onBoundsChange(bounds: Rect) {
        if (bounds.isEmpty) {
            return
        }
        updateLayerBounds(bounds)
    }

    private fun updateLayerBounds(bounds: Rect) {
        try {
            suspendChildInvalidation()
            updateLayerBoundsInternal(bounds)
            updateMaskBoundsInternal(bounds)
        } finally {
            resumeChildInvalidation()
        }
    }

    private fun updateLayerBoundsInternal(bounds: Rect) {
        val cX = bounds.width() / 2
        val cY = bounds.height() / 2

        for (i in 0 until LayerState.N_CHILDREN) {
            val drawable = mLayerState.mChildren[i].mDrawable ?: continue

            val insetWidth = (bounds.width() / (DEFAULT_VIEW_PORT_SCALE * 2)).toInt()
            val insetHeight = (bounds.height() / (DEFAULT_VIEW_PORT_SCALE * 2)).toInt()
            val outRect = mTmpOutRect
            outRect.set(cX - insetWidth, cY - insetHeight, cX + insetWidth, cY + insetHeight)

            drawable.bounds = outRect
        }
    }

    private fun updateMaskBoundsInternal(bounds: Rect) {
        mMaskMatrix.setScale(bounds.width() / MASK_SIZE, bounds.height() / MASK_SIZE)
        sMask!!.transform(mMaskMatrix, mMask)

        if (mMaskBitmap == null || mMaskBitmap!!.width != bounds.width() || mMaskBitmap!!.height != bounds.height()) {
            mMaskBitmap = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ALPHA_8)
            mLayersBitmap = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ARGB_8888)
        }

        mCanvas.setBitmap(mMaskBitmap)
        mPaint.shader = null
        mPaint.color = Color.WHITE
        mCanvas.drawPath(mMask, mPaint)

        mMaskMatrix.postTranslate(bounds.left.toFloat(), bounds.top.toFloat())
        mMask.reset()
        sMask!!.transform(mMaskMatrix, mMask)
        mTransparentRegion.setEmpty()
        mLayersShader = null
    }

    override fun draw(canvas: Canvas) {
        val layersBitmap = mLayersBitmap ?: return
        if (mLayersShader == null) {
            mCanvas.setBitmap(layersBitmap)
            for (i in 0 until LayerState.N_CHILDREN) {
                mLayerState.mChildren[i].mDrawable?.draw(mCanvas)
            }
            mLayersShader = BitmapShader(layersBitmap, TileMode.CLAMP, TileMode.CLAMP)
            mPaint.shader = mLayersShader
        }
        val maskBitmap = mMaskBitmap
        if (maskBitmap != null) {
            val bounds = bounds
            canvas.drawBitmap(maskBitmap, bounds.left.toFloat(), bounds.top.toFloat(), mPaint)
        }
    }

    override fun invalidateSelf() {
        mLayersShader = null
        super.invalidateSelf()
    }

    override fun getOutline(outline: Outline) {
        outline.setConvexPath(mMask)
    }

    fun getSafeZone(): Region {
        mMaskMatrix.reset()
        mMaskMatrix.setScale(SAFEZONE_SCALE, SAFEZONE_SCALE, bounds.centerX().toFloat(), bounds.centerY().toFloat())
        val path = Path()
        mMask.transform(mMaskMatrix, path)
        val safezoneRegion = Region(bounds)
        safezoneRegion.setPath(path, safezoneRegion)
        return safezoneRegion
    }

    override fun getTransparentRegion(): Region? {
        if (mTransparentRegion.isEmpty) {
            mMask.toggleInverseFillType()
            mTransparentRegion.set(bounds)
            mTransparentRegion.setPath(mMask, mTransparentRegion)
            mMask.toggleInverseFillType()
        }
        return mTransparentRegion
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun inflateLayers(
        r: Resources,
        parser: XmlPullParser,
        attrs: AttributeSet,
        theme: Theme?
    ) {
        val state = mLayerState

        val innerDepth = parser.depth + 1
        var type = parser.next()
        var depth = parser.depth
        while (type != XmlPullParser.END_DOCUMENT && (depth >= innerDepth || type != XmlPullParser.END_TAG)) {
            if (type != XmlPullParser.START_TAG) {
                type = parser.next()
                depth = parser.depth
                continue
            }

            if (depth > innerDepth) {
                type = parser.next()
                depth = parser.depth
                continue
            }

            val childIndex = when (parser.name) {
                "background" -> BACKGROUND_ID
                "foreground" -> FOREGROUND_ID
                else -> {
                    type = parser.next()
                    depth = parser.depth
                    continue
                }
            }

            val layer = ChildDrawable(state.mDensity)
            val typedArray = obtainAttributes(r, theme, attrs, intArrayOf(android.R.attr.drawable))
            updateLayerFromTypedArray(layer, typedArray)
            typedArray.recycle()

            if (layer.mDrawable == null && layer.mThemeAttrs == null) {
                do {
                    type = parser.next()
                } while (type == XmlPullParser.TEXT)

                if (type != XmlPullParser.START_TAG) {
                    throw XmlPullParserException(
                        parser.positionDescription +
                            ": <foreground> or <background> tag requires a 'drawable'attribute or child tag defining a drawable"
                    )
                }

                layer.mDrawable = Drawable.createFromXmlInner(r, parser, attrs, theme)
                layer.mDrawable?.callback = this
                state.mChildrenChangingConfigurations =
                    state.mChildrenChangingConfigurations or (layer.mDrawable?.changingConfigurations ?: 0)
            }
            addLayer(childIndex, layer)

            type = parser.next()
            depth = parser.depth
        }
    }

    private fun updateLayerFromTypedArray(layer: ChildDrawable, typedArray: TypedArray) {
        val state = mLayerState

        state.mChildrenChangingConfigurations =
            state.mChildrenChangingConfigurations or typedArray.changingConfigurations

        layer.mThemeAttrs = invoke(methodExtractThemeAttrs, typedArray)

        @SuppressLint("ResourceType")
        val drawable = getDrawable(typedArray, 0)
        if (drawable != null) {
            layer.mDrawable?.callback = null

            layer.mDrawable = drawable
            layer.mDrawable?.callback = this
            state.mChildrenChangingConfigurations =
                state.mChildrenChangingConfigurations or (layer.mDrawable?.changingConfigurations ?: 0)
        }
    }

    private fun getDrawable(typedArray: TypedArray, index: Int): Drawable? {
        val value = TypedValue()
        typedArray.getValue(index, value)
        if (value.resourceId != 0) {
            return typedArray.resources.getDrawableForDensity(
                value.resourceId,
                DisplayMetrics.DENSITY_DEFAULT,
                null
            )
        }
        return null
    }

    override fun canApplyTheme(): Boolean =
        mLayerState.canApplyTheme() || super.canApplyTheme()

    private fun suspendChildInvalidation() {
        mSuspendChildInvalidation = true
    }

    private fun resumeChildInvalidation() {
        mSuspendChildInvalidation = false

        if (mChildRequestedInvalidation) {
            mChildRequestedInvalidation = false
            invalidateSelf()
        }
    }

    override fun invalidateDrawable(who: Drawable) {
        if (mSuspendChildInvalidation) {
            mChildRequestedInvalidation = true
        } else {
            invalidateSelf()
        }
    }

    override fun scheduleDrawable(who: Drawable, what: Runnable, `when`: Long) {
        scheduleSelf(what, `when`)
    }

    override fun unscheduleDrawable(who: Drawable, what: Runnable) {
        unscheduleSelf(what)
    }

    override fun getChangingConfigurations(): Int =
        super.getChangingConfigurations() or mLayerState.changingConfigurations

    override fun setHotspot(x: Float, y: Float) {
        for (i in 0 until LayerState.N_CHILDREN) {
            mLayerState.mChildren[i].mDrawable?.setHotspot(x, y)
        }
    }

    override fun setHotspotBounds(left: Int, top: Int, right: Int, bottom: Int) {
        for (i in 0 until LayerState.N_CHILDREN) {
            mLayerState.mChildren[i].mDrawable?.setHotspotBounds(left, top, right, bottom)
        }

        val hotspotBounds = mHotspotBounds
        if (hotspotBounds == null) {
            mHotspotBounds = Rect(left, top, right, bottom)
        } else {
            hotspotBounds.set(left, top, right, bottom)
        }
    }

    override fun getHotspotBounds(outRect: Rect) {
        val hotspotBounds = mHotspotBounds
        if (hotspotBounds != null) {
            outRect.set(hotspotBounds)
        } else {
            super.getHotspotBounds(outRect)
        }
    }

    override fun setVisible(visible: Boolean, restart: Boolean): Boolean {
        val changed = super.setVisible(visible, restart)
        for (i in 0 until LayerState.N_CHILDREN) {
            mLayerState.mChildren[i].mDrawable?.setVisible(visible, restart)
        }
        return changed
    }

    override fun setDither(dither: Boolean) {
        for (i in 0 until LayerState.N_CHILDREN) {
            mLayerState.mChildren[i].mDrawable?.setDither(dither)
        }
    }

    override fun setAlpha(alpha: Int) {
        for (i in 0 until LayerState.N_CHILDREN) {
            mLayerState.mChildren[i].mDrawable?.alpha = alpha
        }
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        for (i in 0 until LayerState.N_CHILDREN) {
            mLayerState.mChildren[i].mDrawable?.colorFilter = colorFilter
        }
    }

    override fun setTintList(tint: ColorStateList?) {
        for (i in 0 until LayerState.N_CHILDREN) {
            mLayerState.mChildren[i].mDrawable?.setTintList(tint)
        }
    }

    override fun setTintMode(tintMode: Mode?) {
        for (i in 0 until LayerState.N_CHILDREN) {
            mLayerState.mChildren[i].mDrawable?.setTintMode(tintMode)
        }
    }

    fun setOpacity(opacity: Int) {
        mLayerState.mOpacityOverride = opacity
    }

    override fun getOpacity(): Int {
        if (mLayerState.mOpacityOverride != PixelFormat.UNKNOWN) {
            return mLayerState.mOpacityOverride
        }
        return mLayerState.opacity
    }

    override fun setAutoMirrored(mirrored: Boolean) {
        mLayerState.mAutoMirrored = mirrored
        for (i in 0 until LayerState.N_CHILDREN) {
            mLayerState.mChildren[i].mDrawable?.isAutoMirrored = mirrored
        }
    }

    override fun isAutoMirrored(): Boolean = mLayerState.mAutoMirrored

    override fun jumpToCurrentState() {
        for (i in 0 until LayerState.N_CHILDREN) {
            mLayerState.mChildren[i].mDrawable?.jumpToCurrentState()
        }
    }

    override fun isStateful(): Boolean = mLayerState.isStateful()

    override fun onStateChange(state: IntArray): Boolean {
        var changed = false

        for (i in 0 until LayerState.N_CHILDREN) {
            val drawable = mLayerState.mChildren[i].mDrawable
            if (drawable != null && drawable.isStateful && drawable.setState(state)) {
                changed = true
            }
        }

        if (changed) {
            updateLayerBounds(bounds)
        }

        return changed
    }

    override fun onLevelChange(level: Int): Boolean {
        var changed = false

        for (i in 0 until LayerState.N_CHILDREN) {
            val drawable = mLayerState.mChildren[i].mDrawable
            if (drawable != null && drawable.setLevel(level)) {
                changed = true
            }
        }

        if (changed) {
            updateLayerBounds(bounds)
        }

        return changed
    }

    override fun getIntrinsicWidth(): Int = (maxIntrinsicWidth * 1f).toInt()

    private val maxIntrinsicWidth: Int
        get() {
            var width = -1
            for (i in 0 until LayerState.N_CHILDREN) {
                val drawable = mLayerState.mChildren[i].mDrawable ?: continue
                val childWidth = drawable.intrinsicWidth
                if (childWidth > width) {
                    width = childWidth
                }
            }
            return width
        }

    override fun getIntrinsicHeight(): Int = (maxIntrinsicHeight * 1f).toInt()

    private val maxIntrinsicHeight: Int
        get() {
            var height = -1
            for (i in 0 until LayerState.N_CHILDREN) {
                val drawable = mLayerState.mChildren[i].mDrawable ?: continue
                val childHeight = drawable.intrinsicHeight
                if (childHeight > height) {
                    height = childHeight
                }
            }
            return height
        }

    override fun getConstantState(): ConstantState? {
        if (mLayerState.canConstantState()) {
            mLayerState.mChangingConfigurations = changingConfigurations
            return mLayerState
        }
        return null
    }

    override fun mutate(): Drawable {
        if (!mMutated && super.mutate() === this) {
            mLayerState = createConstantState(mLayerState, null)
            for (i in 0 until LayerState.N_CHILDREN) {
                mLayerState.mChildren[i].mDrawable?.mutate()
            }
            mMutated = true
        }
        return this
    }

    val foreground: Drawable?
        get() = mLayerState.mChildren[FOREGROUND_ID].mDrawable

    val background: Drawable?
        get() = mLayerState.mChildren[BACKGROUND_ID].mDrawable

    class ChildDrawable {
        var mDrawable: Drawable? = null
        var mThemeAttrs: IntArray? = null
        var mDensity: Int

        constructor(density: Int) {
            mDensity = density
        }

        constructor(orig: ChildDrawable, owner: AdaptiveIconDrawableCompat, res: Resources?) {
            val drawable = orig.mDrawable
            val clone: Drawable?
            if (drawable != null) {
                val constantState = drawable.constantState
                clone = when {
                    constantState == null -> drawable
                    res != null -> constantState.newDrawable(res)
                    else -> constantState.newDrawable()
                }
                clone.callback = owner
                clone.bounds = drawable.bounds
                clone.level = drawable.level
            } else {
                clone = null
            }

            mDrawable = clone
            mThemeAttrs = orig.mThemeAttrs

            mDensity = resolveDensity(res, orig.mDensity)
        }

        fun canApplyTheme(): Boolean =
            mThemeAttrs != null || (mDrawable != null && mDrawable!!.canApplyTheme())

        fun setDensity(targetDensity: Int) {
            if (mDensity != targetDensity) {
                mDensity = targetDensity
            }
        }
    }

    class LayerState(
        orig: LayerState?,
        private val owner: AdaptiveIconDrawableCompat,
        res: Resources?
    ) : ConstantState() {
        private var mThemeAttrs: IntArray? = null

        var mChildren: Array<ChildDrawable>

        var mDensity: Int

        var mSrcDensityOverride = 0

        var mOpacityOverride = PixelFormat.UNKNOWN

        var mChangingConfigurations = 0
        var mChildrenChangingConfigurations = 0

        private var mCheckedOpacity = false
        private var mOpacity = 0

        private var mCheckedStateful = false
        private var mIsStateful = false
        var mAutoMirrored = false

        init {
            mDensity = resolveDensity(res, orig?.mDensity ?: 0)
            mChildren = Array(N_CHILDREN) { ChildDrawable(mDensity) }
            if (orig != null) {
                val origChildDrawable = orig.mChildren

                mChangingConfigurations = orig.mChangingConfigurations
                mChildrenChangingConfigurations = orig.mChildrenChangingConfigurations

                for (i in 0 until N_CHILDREN) {
                    mChildren[i] = ChildDrawable(origChildDrawable[i], owner, res)
                }

                mCheckedOpacity = orig.mCheckedOpacity
                mOpacity = orig.mOpacity
                mCheckedStateful = orig.mCheckedStateful
                mIsStateful = orig.mIsStateful
                mAutoMirrored = orig.mAutoMirrored
                mThemeAttrs = orig.mThemeAttrs
                mOpacityOverride = orig.mOpacityOverride
                mSrcDensityOverride = orig.mSrcDensityOverride
            }
        }

        fun setDensity(targetDensity: Int) {
            if (mDensity != targetDensity) {
                mDensity = targetDensity
            }
        }

        override fun canApplyTheme(): Boolean {
            if (mThemeAttrs != null || super.canApplyTheme()) {
                return true
            }

            for (i in 0 until N_CHILDREN) {
                if (mChildren[i].canApplyTheme()) {
                    return true
                }
            }
            return false
        }

        override fun newDrawable(): Drawable = AdaptiveIconDrawableCompat(this, null)

        override fun newDrawable(res: Resources?): Drawable = AdaptiveIconDrawableCompat(this, null)

        override fun getChangingConfigurations(): Int =
            mChangingConfigurations or mChildrenChangingConfigurations

        val opacity: Int
            get() {
                if (mCheckedOpacity) {
                    return mOpacity
                }

                var firstIndex = -1
                for (i in 0 until N_CHILDREN) {
                    if (mChildren[i].mDrawable != null) {
                        firstIndex = i
                        break
                    }
                }

                var opacity = if (firstIndex >= 0) {
                    mChildren[firstIndex].mDrawable!!.opacity
                } else {
                    PixelFormat.TRANSPARENT
                }

                for (i in firstIndex + 1 until N_CHILDREN) {
                    val drawable = mChildren[i].mDrawable
                    if (drawable != null) {
                        opacity = Drawable.resolveOpacity(opacity, drawable.opacity)
                    }
                }

                mOpacity = opacity
                mCheckedOpacity = true
                return opacity
            }

        fun isStateful(): Boolean {
            if (mCheckedStateful) {
                return mIsStateful
            }

            var isStateful = false
            for (i in 0 until N_CHILDREN) {
                val drawable = mChildren[i].mDrawable
                if (drawable != null && drawable.isStateful) {
                    isStateful = true
                    break
                }
            }

            mIsStateful = isStateful
            mCheckedStateful = true
            return isStateful
        }

        fun canConstantState(): Boolean {
            for (i in 0 until N_CHILDREN) {
                val drawable = mChildren[i].mDrawable
                if (drawable != null && drawable.constantState == null) {
                    return false
                }
            }
            return true
        }

        fun invalidateCache() {
            mCheckedOpacity = false
            mCheckedStateful = false
        }

        companion object {
            const val N_CHILDREN = 2
        }
    }

    companion object {
        @JvmField
        var MASK_SIZE = 180f

        private const val SAFEZONE_SCALE = 66f / 72f
        private const val EXTRA_INSET_PERCENTAGE = 1 / 4f
        private const val DEFAULT_VIEW_PORT_SCALE = 1f / (1 + 2 * EXTRA_INSET_PERCENTAGE)

        private var sMask: Path? = null

        private const val BACKGROUND_ID = 0
        private const val FOREGROUND_ID = 1

        @JvmStatic
        fun resolveDensity(r: Resources?, parentDensity: Int): Int {
            val densityDpi = r?.displayMetrics?.densityDpi ?: parentDensity
            return if (densityDpi == 0) DisplayMetrics.DENSITY_DEFAULT else densityDpi
        }

        @JvmStatic
        fun getExtraInsetFraction(): Float = EXTRA_INSET_PERCENTAGE

        @JvmStatic
        fun getExtraInsetPercentage(): Float = EXTRA_INSET_PERCENTAGE

        fun obtainAttributes(res: Resources, theme: Theme?, set: AttributeSet, attrs: IntArray): TypedArray =
            theme?.obtainStyledAttributes(set, attrs, 0, 0) ?: res.obtainAttributes(set, attrs)
    }
}
