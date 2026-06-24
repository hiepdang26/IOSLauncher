package com.cloudx.ios17.core.customviews

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.Scroller
import androidx.core.view.GestureDetectorCompat
import com.cloudx.ios17.BlissLauncher
import com.cloudx.ios17.R
import com.cloudx.ios17.features.launcher.DetectSwipeGestureListener
import com.cloudx.ios17.features.launcher.LauncherActivity
import com.cloudx.ios17.features.launcher.OnSwipeDownListener
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import timber.log.Timber

class HorizontalPager @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ViewGroup(context, attrs, defStyle), Insettable {

    private var pageWidthSpec: Int
    private var pageWidth = 0

    private var firstLayout = true
    private var currentPage = 0

    private val mScroller: Scroller
    private var mVelocityTracker: VelocityTracker? = null

    private var mTouchSlop = 0
    private var mMaximumVelocity = 0

    private var mLastMotionX = 0f
    private var mLastMotionY = 0f

    private var mTouchState = TOUCH_STATE_REST
    private var mAllowLongPress = false
    private var mDock: DockGridLayout? = null

    private val mListeners: MutableSet<OnScrollListener> = HashSet()
    private var mIsUiCreated = false
    private lateinit var gestureDetectorCompat: GestureDetectorCompat
    private var insets: Rect = InsettableRectPolicy.defaultInsets()
    private var mLastMotionRawY = 0f

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HorizontalPager)
        pageWidthSpec = typedArray.getDimensionPixelSize(R.styleable.HorizontalPager_pageWidth, SPEC_UNDEFINED)
        typedArray.recycle()

        mScroller = Scroller(getContext())
        init()
    }

    private fun init() {
        currentPage = 0
        mIsUiCreated = false

        val configuration = ViewConfiguration.get(getContext())
        mTouchSlop = configuration.scaledTouchSlop
        mMaximumVelocity = configuration.scaledMaximumFlingVelocity

        val gestureListener = DetectSwipeGestureListener()
        if (getContext() is LauncherActivity) {
            gestureListener.setListener(getContext() as OnSwipeDownListener)
        }

        gestureDetectorCompat = GestureDetectorCompat(getContext(), gestureListener)
    }

    fun setDock(dock: DockGridLayout) {
        mDock = dock
    }

    fun getCurrentPage(): Int = currentPage

    fun setCurrentPage(currentPage: Int) {
        this.currentPage = max(0, min(currentPage, childCount))
        scrollTo(getScrollXForPage(this.currentPage), 0)
        invalidate()
    }

    fun getPageWidth(): Int = pageWidth

    fun setPageWidth(pageWidth: Int) {
        pageWidthSpec = pageWidth
    }

    private fun getScrollXForPage(whichPage: Int): Int = whichPage * pageWidth - pageWidthPadding()

    override fun computeScroll() {
        if (!mScroller.isFinished && mScroller.computeScrollOffset()) {
            val oldX = scrollX
            val oldY = scrollY
            val x = mScroller.currX
            val y = mScroller.currY

            if (oldX != x || oldY != y) {
                scrollTo(x, y)
            }
            postInvalidateOnAnimation()
        }
    }

    override fun dispatchDraw(canvas: Canvas) {
        val drawingTime = drawingTime
        val count = childCount
        for (i in 0 until count) {
            drawChild(canvas, getChildAt(i), drawingTime)
        }

        if (pageWidth == 0) {
            return
        }
        for (listener in mListeners) {
            val adjustedScrollX = scrollX + pageWidthPadding()
            if (adjustedScrollX % pageWidth == 0) {
                listener.onViewScrollFinished(adjustedScrollX / pageWidth)
            } else {
                listener.onScroll(adjustedScrollX)
            }
        }
    }

    fun pageWidthPadding(): Int = (measuredWidth - pageWidth) / 2

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        pageWidth = if (pageWidthSpec == SPEC_UNDEFINED) measuredWidth else pageWidthSpec
        pageWidth = min(pageWidth, measuredWidth)
        val pageHeight = MeasureSpec.getSize(heightMeasureSpec)

        val count = childCount
        for (i in 0 until count) {
            var childWidth = pageWidth
            var childHeight = pageHeight
            val child = getChildAt(i)
            if (child !is Insettable) {
                childWidth -= insets.width()
                childHeight -= insets.height()
            }
            child.measure(
                MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY)
            )
        }

        if (firstLayout) {
            scrollTo(getScrollXForPage(currentPage), 0)
            firstLayout = false
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        var childLeft = 0

        val count = childCount
        for (i in 0 until count) {
            val child = getChildAt(i)
            if (child.visibility != View.GONE) {
                val childWidth = child.measuredWidth
                var childTop = 0
                if (child !is Insettable) {
                    childLeft += insets.left
                    childTop += insets.top
                }
                child.layout(childLeft, childTop, childLeft + childWidth, child.measuredHeight)
                childLeft += childWidth
                if (child !is Insettable) {
                    childLeft += insets.right
                }
            }
        }
    }

    override fun requestChildRectangleOnScreen(child: View, rectangle: Rect, immediate: Boolean): Boolean {
        val screen = indexOfChild(child)
        return screen != currentPage || !mScroller.isFinished
    }

    override fun onRequestFocusInDescendants(direction: Int, previouslyFocusedRect: Rect?): Boolean {
        if (childCount <= 1) {
            return false
        }
        getChildAt(currentPage).requestFocus(direction, previouslyFocusedRect)
        return false
    }

    override fun dispatchUnhandledMove(focused: View, direction: Int): Boolean {
        if (direction == View.FOCUS_LEFT) {
            if (getCurrentPage() > 0) {
                snapToPage(getCurrentPage() - 1)
                return true
            }
        } else if (direction == View.FOCUS_RIGHT) {
            if (getCurrentPage() < childCount - 1) {
                snapToPage(getCurrentPage() + 1)
                return true
            }
        }
        return super.dispatchUnhandledMove(focused, direction)
    }

    override fun addFocusables(views: ArrayList<View>, direction: Int) {
        getChildAt(currentPage).addFocusables(views, direction)
        if (direction == View.FOCUS_LEFT) {
            if (currentPage > 0) {
                getChildAt(currentPage - 1).addFocusables(views, direction)
            }
        } else if (direction == View.FOCUS_RIGHT) {
            if (currentPage < childCount - 1) {
                getChildAt(currentPage + 1).addFocusables(views, direction)
            }
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val action = ev.action
        if (action == MotionEvent.ACTION_MOVE && mTouchState != TOUCH_STATE_REST) {
            Timber.tag(TAG).d("onInterceptTouchEvent::shortcut=true")
            return true
        }

        val x = ev.x
        val y = ev.y

        mLastMotionRawY = ev.rawY

        when (action) {
            MotionEvent.ACTION_MOVE -> {
                if (mTouchState == TOUCH_STATE_REST) {
                    checkStartScroll(x, y)
                }
            }
            MotionEvent.ACTION_DOWN -> {
                mLastMotionX = x
                mLastMotionY = y
                mAllowLongPress = true
                mTouchState = if (mScroller.isFinished) TOUCH_STATE_REST else TOUCH_STATE_HORIZONTAL_SCROLLING
            }
            MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> {
                mTouchState = TOUCH_STATE_REST
            }
        }

        return mTouchState != TOUCH_STATE_REST
    }

    private fun checkStartScroll(x: Float, y: Float) {
        val xDiff = abs(x - mLastMotionX).toInt()
        val yDiff = abs(y - mLastMotionY).toInt()

        val xMoved = xDiff > mTouchSlop
        val yMoved = yDiff > mTouchSlop

        if (xMoved || yMoved) {
            if (yMoved && y - mLastMotionY > 0 && yDiff > xDiff && inThresholdRegion() && canStartSwipeDown()) {
                mTouchState = TOUCH_STATE_VERTICAL_SCROLLING
                (getContext() as OnSwipeDownListener).onSwipeStart()
            } else if (xMoved && yDiff < xDiff && inThresholdRegion()) {
                mTouchState = TOUCH_STATE_HORIZONTAL_SCROLLING
                enableChildrenCache()
            }
            if (mAllowLongPress) {
                mAllowLongPress = false
                val currentScreen = getChildAt(currentPage)
                currentScreen?.cancelLongPress()
            }
        }
    }

    private fun inThresholdRegion(): Boolean =
        mLastMotionRawY < BlissLauncher.getApplication(getContext()).deviceProfile.availableHeightPx

    private fun canStartSwipeDown(): Boolean {
        return (getContext() as? OnSwipeDownListener)?.canStartSwipeDown() == true
    }

    fun enableChildrenCache() {
        setChildrenDrawingCacheEnabled(true)
    }

    fun setUiCreated(isUiCreated: Boolean) {
        mIsUiCreated = isUiCreated
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain()
        }
        mVelocityTracker!!.addMovement(ev)

        val action = ev.action
        val x = ev.x
        val y = ev.y
        if (mIsUiCreated) {
            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    if (!mScroller.isFinished) {
                        mScroller.abortAnimation()
                    }

                    mLastMotionX = x
                    mLastMotionY = y
                }
                MotionEvent.ACTION_MOVE -> {
                    if (mTouchState == TOUCH_STATE_REST) {
                        checkStartScroll(x, y)
                    } else if (mTouchState == TOUCH_STATE_VERTICAL_SCROLLING) {
                        val diffY = (y - mLastMotionY).toInt()
                        (getContext() as OnSwipeDownListener).onSwipe(diffY)
                    } else if (mTouchState == TOUCH_STATE_HORIZONTAL_SCROLLING) {
                        var deltaX = (mLastMotionX - x).toInt()
                        mLastMotionX = x

                        if (scrollX < 0 || scrollX > getChildAt(childCount - 1).left) {
                            deltaX /= 2
                        }

                        scrollBy(deltaX, 0)
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (mTouchState == TOUCH_STATE_VERTICAL_SCROLLING) {
                        (getContext() as OnSwipeDownListener).onSwipeFinish()
                    }
                    if (mTouchState == TOUCH_STATE_HORIZONTAL_SCROLLING) {
                        val velocityTracker = mVelocityTracker!!
                        velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity.toFloat())
                        val velocityX = velocityTracker.xVelocity.toInt()

                        if (velocityX > SNAP_VELOCITY && currentPage > 0) {
                            snapToPage(currentPage - 1)
                        } else if (velocityX < -SNAP_VELOCITY && currentPage < childCount - 1) {
                            snapToPage(currentPage + 1)
                        } else {
                            snapToDestination()
                        }

                        if (mVelocityTracker != null) {
                            mVelocityTracker!!.recycle()
                            mVelocityTracker = null
                        }
                    }
                    mTouchState = TOUCH_STATE_REST
                }
                MotionEvent.ACTION_CANCEL -> {
                    mTouchState = TOUCH_STATE_REST
                }
            }
        }

        return true
    }

    private fun snapToDestination() {
        val startX = getScrollXForPage(currentPage)
        var whichPage = currentPage
        if (scrollX < startX - width / 8) {
            whichPage = max(0, whichPage - 1)
        } else if (scrollX > startX + width / 8) {
            whichPage = min(childCount - 1, whichPage + 1)
        }
        snapToPage(whichPage)
    }

    @JvmOverloads
    fun snapToPage(whichPage: Int, duration: Int = 400) {
        enableChildrenCache()

        val changingPages = whichPage != currentPage
        currentPage = whichPage

        val focusedChild = focusedChild
        if (focusedChild != null && changingPages && focusedChild == getChildAt(currentPage)) {
            focusedChild.clearFocus()
        }

        val newX = getScrollXForPage(whichPage)
        val delta = newX - scrollX
        mScroller.startScroll(scrollX, 0, delta, 0, duration)
        invalidate()
    }

    override fun onSaveInstanceState(): Parcelable {
        val state = SavedState(super.onSaveInstanceState())
        state.currentScreen = currentPage
        return state
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        val savedState = state as SavedState
        super.onRestoreInstanceState(savedState.superState)
        if (savedState.currentScreen != INVALID_SCREEN) {
            currentPage = savedState.currentScreen
        }
    }

    fun scrollLeft(duration: Int) {
        if (currentPage > 0 && mScroller.isFinished) {
            snapToPage(currentPage - 1, duration)
        }
    }

    fun scrollRight(duration: Int) {
        if (currentPage < childCount - 1 && mScroller.isFinished) {
            snapToPage(currentPage + 1, duration)
        }
    }

    fun getScreenForView(v: View?): Int {
        var result = -1
        if (v != null) {
            val viewParent: ViewParent = v.parent
            val count = childCount
            for (i in 0 until count) {
                if (viewParent == getChildAt(i)) {
                    return i
                }
            }
        }
        return result
    }

    fun allowLongPress(): Boolean = mAllowLongPress

    override fun setInsets(insets: Rect?) {
        this.insets = InsettableRectPolicy.nonNull(insets)
        updateInsetsForChildren()
        postInvalidate()
    }

    private fun updateInsetsForChildren() {
        val childCount = childCount
        for (index in 0 until childCount) {
            val child = getChildAt(index)
            if (child is Insettable) {
                Timber.tag(TAG).d("child is instance of insettable")
                child.setInsets(InsettableRectPolicy.nonNull(insets))
            }
        }
    }

    override fun onViewAdded(child: View) {
        super.onViewAdded(child)
        Timber.tag(TAG).d("onViewAdded() called with: child = [$child]")
        if (child is Insettable) {
            Timber.tag(TAG).d("child is instance of insettable")
            child.setInsets(InsettableRectPolicy.nonNull(insets))
        }
    }

    class SavedState : BaseSavedState {
        var currentScreen: Int = INVALID_SCREEN

        constructor(superState: Parcelable?) : super(superState)

        private constructor(parcel: Parcel) : super(parcel) {
            currentScreen = parcel.readInt()
        }

        override fun writeToParcel(out: Parcel, flags: Int) {
            super.writeToParcel(out, flags)
            out.writeInt(currentScreen)
        }

        companion object {
            @JvmField
            val CREATOR: Parcelable.Creator<SavedState> = object : Parcelable.Creator<SavedState> {
                override fun createFromParcel(parcel: Parcel): SavedState = SavedState(parcel)

                override fun newArray(size: Int): Array<SavedState?> = arrayOfNulls(size)
            }
        }
    }

    fun addOnScrollListener(listener: OnScrollListener) {
        mListeners.add(listener)
    }

    fun removeOnScrollListener(listener: OnScrollListener) {
        mListeners.remove(listener)
    }

    interface OnScrollListener {
        fun onScroll(scrollX: Int)

        fun onViewScrollFinished(currentPage: Int)
    }

    companion object {
        private const val TAG = "HorizontalPager"
        private const val INVALID_SCREEN = -1

        const val SPEC_UNDEFINED = -1

        private const val SNAP_VELOCITY = 1000

        private const val TOUCH_STATE_REST = 0
        private const val TOUCH_STATE_HORIZONTAL_SCROLLING = 1
        private const val TOUCH_STATE_VERTICAL_SCROLLING = 2
    }
}
