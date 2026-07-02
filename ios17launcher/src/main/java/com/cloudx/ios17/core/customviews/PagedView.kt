package com.cloudx.ios17.core.customviews

import android.animation.LayoutTransition
import android.animation.TimeInterpolator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.util.AttributeSet
import android.view.InputDevice
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewDebug
import android.view.ViewGroup
import android.view.ViewParent
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.view.animation.Interpolator
import android.widget.ScrollView
import android.widget.Scroller
import com.cloudx.ios17.R
import com.cloudx.ios17.core.Utilities
import com.cloudx.ios17.core.customviews.pageindicators.PageIndicator
import com.cloudx.ios17.core.touch.OverScroll
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt
import kotlin.math.sign
import kotlin.math.sin
import timber.log.Timber

abstract class PagedView<T> @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ViewGroup(context, attrs, defStyle) where T : View, T : PageIndicator {

    private var mFreeScroll = false
    private var mSettleOnPageInFreeScroll = false

    protected var mFlingThresholdVelocity = 0
    protected var mMinFlingVelocity = 0
    protected var mMinSnapVelocity = 0

    protected var mFirstLayout = true

    @ViewDebug.ExportedProperty(category = "launcher")
    protected var mCurrentPage = 0

    @ViewDebug.ExportedProperty(category = "launcher")
    protected var mNextPage = INVALID_PAGE

    protected var mMaxScrollX = 0

    @JvmField
    var mScroller: Scroller = Scroller(context)

    private var mDefaultInterpolator: Interpolator? = null
    private var mVelocityTracker: VelocityTracker? = null
    protected var mPageSpacing = 0

    private var mDownMotionX = 0f
    private var mDownMotionY = 0f
    private var mLastMotionX = 0f
    private var mLastMotionXRemainder = 0f
    private var mTotalMotionX = 0f

    protected var mPageScrolls: IntArray? = null

    protected var mTouchState = TOUCH_STATE_REST
    protected var mTouchSlop = 0
    private var mMaximumVelocity = 0
    protected var mAllowOverScroll = true
    protected var mActivePointerId = INVALID_POINTER
    protected var mIsPageInTransition = false
    protected var mWasInOverscroll = false

    protected var mOverScrollX = 0
    protected var mUnboundedScrollX = 0

    private var mPageIndicatorViewId = 0
    protected var mPageIndicator: T? = null

    protected val mInsets = Rect()
    protected var mIsRtl = false
    protected var mIsLayoutValid = false

    private val mTmpIntPair = IntArray(2)

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PagedView, defStyle, 0)
        mPageIndicatorViewId = typedArray.getResourceId(R.styleable.PagedView_pageIndicator, -1)
        typedArray.recycle()

        isHapticFeedbackEnabled = false
        mIsRtl = false
        init()
    }

    protected fun init() {
        mScroller = Scroller(getContext())
        mCurrentPage = 0

        val configuration = ViewConfiguration.get(getContext())
        mTouchSlop = configuration.scaledPagingTouchSlop
        mMaximumVelocity = configuration.scaledMaximumFlingVelocity

        val density = resources.displayMetrics.density
        mFlingThresholdVelocity = (FLING_THRESHOLD_VELOCITY * density).toInt()
        mMinFlingVelocity = (MIN_FLING_VELOCITY * density).toInt()
        mMinSnapVelocity = (MIN_SNAP_VELOCITY * density).toInt()

        if (Utilities.ATLEAST_OREO) {
            defaultFocusHighlightEnabled = false
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun initParentViews(parent: View) {
        if (mPageIndicatorViewId > -1) {
            mPageIndicator = parent.findViewById<View>(mPageIndicatorViewId) as T
            mPageIndicator?.setMarkersCount(childCount)
        }
    }

    fun getPageIndicator(): T? = mPageIndicator

    fun getCurrentPage(): Int = mCurrentPage

    fun getNextPage(): Int = if (mNextPage != INVALID_PAGE) mNextPage else mCurrentPage

    fun getPageCount(): Int = childCount

    fun getPageAt(index: Int): View = getChildAt(index)

    protected fun indexToPage(index: Int): Int = index

    protected fun updateCurrentPageScroll() {
        var newX = 0
        if (0 <= mCurrentPage && mCurrentPage < getPageCount()) {
            newX = getScrollForPage(mCurrentPage)
        }
        scrollTo(newX, 0)
        mScroller.finalX = newX
        forceFinishScroller(true)
    }

    fun abortScrollerAnimation(resetNextPage: Boolean) {
        mScroller.abortAnimation()
        if (resetNextPage) {
            mNextPage = INVALID_PAGE
            pageEndTransition()
        }
    }

    private fun forceFinishScroller(resetNextPage: Boolean) {
        mScroller.forceFinished(true)
        if (resetNextPage) {
            mNextPage = INVALID_PAGE
            pageEndTransition()
        }
    }

    private fun validateNewPage(newPage: Int): Int =
        Utilities.boundToRange(newPage, 0, getPageCount() - 1)

    fun setCurrentPage(currentPage: Int) {
        if (!mScroller.isFinished) {
            abortScrollerAnimation(true)
        }
        if (childCount == 0) {
            return
        }
        val prevPage = mCurrentPage
        mCurrentPage = validateNewPage(currentPage)
        updateCurrentPageScroll()
        notifyPageSwitchListener(prevPage)
        invalidate()
    }

    protected fun notifyPageSwitchListener(prevPage: Int) {
        updatePageIndicator()
    }

    private fun updatePageIndicator() {
        mPageIndicator?.setActiveMarker(getNextPage())
    }

    protected fun pageBeginTransition() {
        if (!mIsPageInTransition) {
            mIsPageInTransition = true
            onPageBeginTransition()
        }
    }

    protected fun pageEndTransition() {
        if (mIsPageInTransition) {
            mIsPageInTransition = false
            onPageEndTransition()
        }
    }

    protected fun isPageInTransition(): Boolean = mIsPageInTransition

    protected open fun onPageBeginTransition() {
    }

    protected open fun onPageEndTransition() {
        mWasInOverscroll = false
    }

    protected fun getUnboundedScrollX(): Int = mUnboundedScrollX

    override fun scrollBy(x: Int, y: Int) {
        scrollTo(getUnboundedScrollX() + x, scrollY + y)
    }

    override fun scrollTo(xPosition: Int, y: Int) {
        var x = xPosition
        if (mFreeScroll) {
            if (!mScroller.isFinished && (x > mMaxScrollX || x < 0)) {
                forceFinishScroller(false)
            }
            x = Utilities.boundToRange(x, 0, mMaxScrollX)
        }

        mUnboundedScrollX = x

        val isXBeforeFirstPage = if (mIsRtl) x > mMaxScrollX else x < 0
        val isXAfterLastPage = if (mIsRtl) x < 0 else x > mMaxScrollX
        if (isXBeforeFirstPage) {
            super.scrollTo(if (mIsRtl) mMaxScrollX else 0, y)
            if (mAllowOverScroll) {
                mWasInOverscroll = true
                if (mIsRtl) {
                    overScroll((x - mMaxScrollX).toFloat())
                } else {
                    overScroll(x.toFloat())
                }
            }
        } else if (isXAfterLastPage) {
            super.scrollTo(if (mIsRtl) 0 else mMaxScrollX, y)
            if (mAllowOverScroll) {
                mWasInOverscroll = true
                if (mIsRtl) {
                    overScroll(x.toFloat())
                } else {
                    overScroll((x - mMaxScrollX).toFloat())
                }
            }
        } else {
            if (mWasInOverscroll) {
                overScroll(0f)
                mWasInOverscroll = false
            }
            mOverScrollX = x
            super.scrollTo(x, y)
        }
    }

    private fun sendScrollAccessibilityEvent() {
    }

    protected fun computeScrollHelper(): Boolean = computeScrollHelper(true)

    protected fun announcePageForAccessibility() {
    }

    protected fun computeScrollHelper(shouldInvalidate: Boolean): Boolean {
        if (mScroller.computeScrollOffset()) {
            if (getUnboundedScrollX() != mScroller.currX || scrollY != mScroller.currY ||
                mOverScrollX != mScroller.currX
            ) {
                scrollTo(mScroller.currX, mScroller.currY)
            }
            if (shouldInvalidate) {
                invalidate()
            }
            return true
        } else if (mNextPage != INVALID_PAGE && shouldInvalidate) {
            sendScrollAccessibilityEvent()

            val prevPage = mCurrentPage
            mCurrentPage = validateNewPage(mNextPage)
            mNextPage = INVALID_PAGE
            notifyPageSwitchListener(prevPage)

            if (mTouchState == TOUCH_STATE_REST) {
                pageEndTransition()
            }

            if (canAnnouncePageDescription()) {
                announcePageForAccessibility()
            }
        }
        return false
    }

    override fun computeScroll() {
        computeScrollHelper()
    }

    fun getExpectedHeight(): Int = measuredHeight

    fun getNormalChildHeight(): Int =
        getExpectedHeight() - paddingTop - paddingBottom - mInsets.top - mInsets.bottom

    fun getExpectedWidth(): Int = measuredWidth

    fun getNormalChildWidth(): Int =
        getExpectedWidth() - paddingLeft - paddingRight - mInsets.left - mInsets.right

    override fun requestLayout() {
        mIsLayoutValid = false
        super.requestLayout()
    }

    override fun forceLayout() {
        mIsLayoutValid = false
        super.forceLayout()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (childCount == 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            return
        }

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        if (widthMode == MeasureSpec.UNSPECIFIED || heightMode == MeasureSpec.UNSPECIFIED) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            return
        }

        if (widthSize <= 0 || heightSize <= 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            return
        }

        if (DEBUG) {
            Timber.tag(TAG).d("PagedView.onMeasure(): $widthSize, $heightSize")
        }

        val myWidthSpec = MeasureSpec.makeMeasureSpec(widthSize - mInsets.left - mInsets.right, MeasureSpec.EXACTLY)
        val myHeightSpec = MeasureSpec.makeMeasureSpec(heightSize - mInsets.top - mInsets.bottom, MeasureSpec.EXACTLY)

        measureChildren(myWidthSpec, myHeightSpec)
        setMeasuredDimension(widthSize, heightSize)
    }

    @SuppressLint("DrawAllocation")
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        mIsLayoutValid = true
        val childCount = childCount
        var pageScrollChanged = false
        val pageScrolls = mPageScrolls
        if (pageScrolls == null || childCount != pageScrolls.size) {
            mPageScrolls = IntArray(childCount)
            pageScrollChanged = true
        }

        if (childCount == 0) {
            return
        }

        if (DEBUG) {
            Timber.tag(TAG).d("PagedView.onLayout()")
        }

        if (getPageScrolls(mPageScrolls!!, true, SIMPLE_SCROLL_LOGIC)) {
            pageScrollChanged = true
        }

        val transition = layoutTransition
        if (transition != null && transition.isRunning) {
            transition.addTransitionListener(object : LayoutTransition.TransitionListener {
                override fun startTransition(
                    transition: LayoutTransition,
                    container: ViewGroup,
                    view: View,
                    transitionType: Int
                ) {
                }

                override fun endTransition(
                    transition: LayoutTransition,
                    container: ViewGroup,
                    view: View,
                    transitionType: Int
                ) {
                    if (!transition.isRunning) {
                        transition.removeTransitionListener(this)
                        updateMaxScrollX()
                    }
                }
            })
        } else {
            updateMaxScrollX()
        }

        if (mFirstLayout && mCurrentPage >= 0 && mCurrentPage < childCount) {
            updateCurrentPageScroll()
            mFirstLayout = false
        }

        if (mScroller.isFinished && pageScrollChanged) {
            setCurrentPage(getNextPage())
        }
    }

    protected fun getPageScrolls(
        outPageScrolls: IntArray,
        layoutChildren: Boolean,
        scrollLogic: ComputePageScrollsLogic
    ): Boolean {
        val childCount = childCount

        val startIndex = if (mIsRtl) childCount - 1 else 0
        val endIndex = if (mIsRtl) -1 else childCount
        val delta = if (mIsRtl) -1 else 1

        val verticalCenter = (paddingTop + measuredHeight + mInsets.top - mInsets.bottom - paddingBottom) / 2

        val scrollOffsetLeft = mInsets.left + paddingLeft
        val scrollOffsetRight = width - paddingRight - mInsets.right
        var pageScrollChanged = false

        var i = startIndex
        var childLeft = scrollOffsetLeft
        while (i != endIndex) {
            val child = getPageAt(i)
            if (scrollLogic.shouldIncludeView(child)) {
                val childWidth = child.measuredWidth
                val childRight = childLeft + childWidth

                if (layoutChildren) {
                    val childHeight = child.measuredHeight
                    val childTop = verticalCenter - childHeight / 2
                    child.layout(childLeft, childTop, childRight, childTop + childHeight)
                }

                val pageScroll = if (mIsRtl) {
                    childLeft - scrollOffsetLeft
                } else {
                    max(0, childRight - scrollOffsetRight)
                }
                if (outPageScrolls[i] != pageScroll) {
                    pageScrollChanged = true
                    outPageScrolls[i] = pageScroll
                }

                childLeft += childWidth + mPageSpacing + getChildGap()
            }
            i += delta
        }
        return pageScrollChanged
    }

    protected open fun getChildGap(): Int = 0

    private fun updateMaxScrollX() {
        mMaxScrollX = computeMaxScrollX()
    }

    protected open fun computeMaxScrollX(): Int {
        val childCount = childCount
        return if (childCount > 0) {
            val index = if (mIsRtl) 0 else childCount - 1
            getScrollForPage(index)
        } else {
            0
        }
    }

    fun setPageSpacing(pageSpacing: Int) {
        mPageSpacing = pageSpacing
        requestLayout()
    }

    private fun dispatchPageCountChanged() {
        mPageIndicator?.setMarkersCount(childCount)
        invalidate()
    }

    override fun onViewAdded(child: View) {
        super.onViewAdded(child)
        dispatchPageCountChanged()
    }

    override fun onViewRemoved(child: View) {
        super.onViewRemoved(child)
        mCurrentPage = validateNewPage(mCurrentPage)
        dispatchPageCountChanged()
    }

    protected fun getChildOffset(index: Int): Int {
        if (index < 0 || index > childCount - 1) {
            return 0
        }
        return getPageAt(index).left
    }

    override fun requestChildRectangleOnScreen(child: View, rectangle: Rect, immediate: Boolean): Boolean {
        val page = indexToPage(indexOfChild(child))
        if (page != mCurrentPage || !mScroller.isFinished) {
            if (immediate) {
                setCurrentPage(page)
            } else {
                snapToPage(page)
            }
            return true
        }
        return false
    }

    override fun onRequestFocusInDescendants(direction: Int, previouslyFocusedRect: Rect?): Boolean {
        val focusablePage = if (mNextPage != INVALID_PAGE) mNextPage else mCurrentPage
        val view = getPageAt(focusablePage)
        return view.requestFocus(direction, previouslyFocusedRect)
    }

    override fun dispatchUnhandledMove(focused: View, direction: Int): Boolean {
        var moveDirection = direction
        if (super.dispatchUnhandledMove(focused, moveDirection)) {
            return true
        }

        if (mIsRtl) {
            if (moveDirection == View.FOCUS_LEFT) {
                moveDirection = View.FOCUS_RIGHT
            } else if (moveDirection == View.FOCUS_RIGHT) {
                moveDirection = View.FOCUS_LEFT
            }
        }
        if (moveDirection == View.FOCUS_LEFT) {
            if (getCurrentPage() > 0) {
                snapToPage(getCurrentPage() - 1)
                getChildAt(getCurrentPage() - 1).requestFocus(moveDirection)
                return true
            }
        } else if (moveDirection == View.FOCUS_RIGHT) {
            if (getCurrentPage() < getPageCount() - 1) {
                snapToPage(getCurrentPage() + 1)
                getChildAt(getCurrentPage() + 1).requestFocus(moveDirection)
                return true
            }
        }
        return false
    }

    override fun addFocusables(views: ArrayList<View>, direction: Int, focusableMode: Int) {
        if (descendantFocusability == FOCUS_BLOCK_DESCENDANTS) {
            return
        }

        if (mCurrentPage >= 0 && mCurrentPage < getPageCount()) {
            getPageAt(mCurrentPage).addFocusables(views, direction, focusableMode)
        }
        if (direction == View.FOCUS_LEFT) {
            if (mCurrentPage > 0) {
                getPageAt(mCurrentPage - 1).addFocusables(views, direction, focusableMode)
            }
        } else if (direction == View.FOCUS_RIGHT) {
            if (mCurrentPage < getPageCount() - 1) {
                getPageAt(mCurrentPage + 1).addFocusables(views, direction, focusableMode)
            }
        }
    }

    override fun focusableViewAvailable(focused: View) {
        val current = getPageAt(mCurrentPage)
        var view = focused
        while (true) {
            if (view == current) {
                super.focusableViewAvailable(focused)
                return
            }
            if (view == this) {
                return
            }
            val parent: ViewParent = view.parent
            if (parent is View) {
                view = parent
            } else {
                return
            }
        }
    }

    override fun requestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        if (disallowIntercept) {
            val currentPage = getPageAt(mCurrentPage)
            currentPage.cancelLongPress()
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept)
    }

    private fun isTouchPointInViewportWithBuffer(x: Int, y: Int): Boolean {
        sTmpRect.set(-measuredWidth / 2, 0, 3 * measuredWidth / 2, measuredHeight)
        return sTmpRect.contains(x, y)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        acquireVelocityTrackerAndAddMovement(ev)

        if (childCount <= 0) {
            return super.onInterceptTouchEvent(ev)
        }

        val action = ev.action
        if (action == MotionEvent.ACTION_MOVE && mTouchState == TOUCH_STATE_SCROLLING) {
            return true
        }

        when (action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_MOVE -> {
                if (mActivePointerId != INVALID_POINTER) {
                    determineScrollingStart(ev)
                }
            }

            MotionEvent.ACTION_DOWN -> {
                val x = ev.x
                val y = ev.y
                mDownMotionX = x
                mDownMotionY = y
                mLastMotionX = x
                mLastMotionXRemainder = 0f
                mTotalMotionX = 0f
                mActivePointerId = ev.getPointerId(0)

                val xDist = abs(mScroller.finalX - mScroller.currX)
                val finishedScrolling = mScroller.isFinished || xDist < mTouchSlop / 3

                if (finishedScrolling) {
                    mTouchState = TOUCH_STATE_REST
                    if (!mScroller.isFinished && !mFreeScroll) {
                        setCurrentPage(getNextPage())
                        pageEndTransition()
                    }
                } else {
                    mTouchState = if (isTouchPointInViewportWithBuffer(mDownMotionX.toInt(), mDownMotionY.toInt())) {
                        TOUCH_STATE_SCROLLING
                    } else {
                        TOUCH_STATE_REST
                    }
                }
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> resetTouchState()

            MotionEvent.ACTION_POINTER_UP -> {
                onSecondaryPointerUp(ev)
                releaseVelocityTracker()
            }
        }

        return mTouchState != TOUCH_STATE_REST
    }

    fun isHandlingTouch(): Boolean = mTouchState != TOUCH_STATE_REST

    protected fun determineScrollingStart(ev: MotionEvent) {
        determineScrollingStart(ev, 1.0f)
    }

    protected open fun determineScrollingStart(ev: MotionEvent, touchSlopScale: Float) {
        val pointerIndex = ev.findPointerIndex(mActivePointerId)
        if (pointerIndex == -1) {
            return
        }

        val x = ev.getX(pointerIndex)
        val y = ev.getY(pointerIndex)
        if (!isTouchPointInViewportWithBuffer(x.toInt(), y.toInt())) {
            return
        }

        val xDiff = abs(x - mLastMotionX).toInt()

        val touchSlop = (touchSlopScale * mTouchSlop).roundToInt()
        val xMoved = xDiff > touchSlop

        if (xMoved) {
            mTouchState = TOUCH_STATE_SCROLLING
            mTotalMotionX += abs(mLastMotionX - x)
            mLastMotionX = x
            mLastMotionXRemainder = 0f
            onScrollInteractionBegin()
            pageBeginTransition()
            requestDisallowInterceptTouchEvent(true)
        }
    }

    protected fun cancelCurrentPageLongPress() {
        val currentPage = getPageAt(mCurrentPage)
        currentPage.cancelLongPress()
    }

    protected fun getScrollProgress(screenCenter: Int, view: View, page: Int): Float {
        val halfScreenSize = measuredWidth / 2

        val delta = screenCenter - (getScrollForPage(page) + halfScreenSize)
        val count = childCount

        val adjacentPage = if ((delta < 0 && !mIsRtl) || (delta > 0 && mIsRtl)) {
            page - 1
        } else {
            page + 1
        }

        val totalDistance = if (adjacentPage < 0 || adjacentPage > count - 1) {
            view.measuredWidth + mPageSpacing
        } else {
            abs(getScrollForPage(adjacentPage) - getScrollForPage(page))
        }

        var scrollProgress = delta / (totalDistance * 1.0f)
        scrollProgress = min(scrollProgress, MAX_SCROLL_PROGRESS)
        scrollProgress = max(scrollProgress, -MAX_SCROLL_PROGRESS)
        return scrollProgress
    }

    fun getScrollForPage(index: Int): Int {
        val pageScrolls = mPageScrolls
        return if (pageScrolls == null || index >= pageScrolls.size || index < 0) {
            0
        } else {
            pageScrolls[index]
        }
    }

    fun getLayoutTransitionOffsetForPage(index: Int): Int {
        val pageScrolls = mPageScrolls
        return if (pageScrolls == null || index >= pageScrolls.size || index < 0) {
            0
        } else {
            val child = getChildAt(index)
            val scrollOffset = if (mIsRtl) paddingRight else paddingLeft
            val baselineX = pageScrolls[index] + scrollOffset
            (child.x - baselineX).toInt()
        }
    }

    protected fun dampedOverScroll(amount: Float) {
        if (amount.compareTo(0f) == 0) {
            return
        }

        val overScrollAmount = OverScroll.dampedScroll(amount, measuredWidth)
        if (amount < 0) {
            mOverScrollX = overScrollAmount
            super.scrollTo(mOverScrollX, scrollY)
        } else {
            mOverScrollX = mMaxScrollX + overScrollAmount
            super.scrollTo(mOverScrollX, scrollY)
        }
        invalidate()
    }

    protected open fun overScroll(amount: Float) {
        dampedOverScroll(amount)
    }

    protected fun enableFreeScroll(settleOnPageInFreeScroll: Boolean) {
        setEnableFreeScroll(true)
        mSettleOnPageInFreeScroll = settleOnPageInFreeScroll
    }

    private fun setEnableFreeScroll(freeScroll: Boolean) {
        val wasFreeScroll = mFreeScroll
        mFreeScroll = freeScroll

        if (mFreeScroll) {
            setCurrentPage(getNextPage())
        } else if (wasFreeScroll) {
            snapToPage(getNextPage())
        }

        setEnableOverscroll(!freeScroll)
    }

    protected fun setEnableOverscroll(enable: Boolean) {
        mAllowOverScroll = enable
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        super.onTouchEvent(ev)

        if (childCount <= 0) {
            return super.onTouchEvent(ev)
        }

        acquireVelocityTrackerAndAddMovement(ev)

        val action = ev.action

        when (action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_DOWN -> {
                if (!mScroller.isFinished) {
                    abortScrollerAnimation(false)
                }

                mDownMotionX = ev.x
                mLastMotionX = mDownMotionX
                mDownMotionY = ev.y
                mLastMotionXRemainder = 0f
                mTotalMotionX = 0f
                mActivePointerId = ev.getPointerId(0)

                if (mTouchState == TOUCH_STATE_SCROLLING) {
                    onScrollInteractionBegin()
                    pageBeginTransition()
                }
            }

            MotionEvent.ACTION_MOVE -> {
                if (mTouchState == TOUCH_STATE_SCROLLING) {
                    val pointerIndex = ev.findPointerIndex(mActivePointerId)

                    if (pointerIndex == -1) {
                        return true
                    }

                    val x = ev.getX(pointerIndex)
                    val deltaX = mLastMotionX + mLastMotionXRemainder - x

                    mTotalMotionX += abs(deltaX)

                    if (abs(deltaX) >= 1.0f) {
                        scrollBy(deltaX.toInt(), 0)
                        mLastMotionX = x
                        mLastMotionXRemainder = deltaX - deltaX.toInt()
                    } else {
                        awakenScrollBars()
                    }
                } else {
                    determineScrollingStart(ev)
                }
            }

            MotionEvent.ACTION_UP -> {
                if (mTouchState == TOUCH_STATE_SCROLLING) {
                    val activePointerId = mActivePointerId
                    val pointerIndex = ev.findPointerIndex(activePointerId)
                    val x = ev.getX(pointerIndex)
                    val velocityTracker = mVelocityTracker!!
                    velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity.toFloat())
                    val velocityX = velocityTracker.getXVelocity(activePointerId).toInt()
                    val deltaX = (x - mDownMotionX).toInt()
                    val pageWidth = getPageAt(mCurrentPage).measuredWidth
                    val isSignificantMove = abs(deltaX) > pageWidth * SIGNIFICANT_MOVE_THRESHOLD

                    mTotalMotionX += abs(mLastMotionX + mLastMotionXRemainder - x)
                    val isFling = mTotalMotionX > mTouchSlop && shouldFlingForVelocity(velocityX)

                    if (!mFreeScroll) {
                        var returnToOriginalPage = false
                        if (abs(deltaX) > pageWidth * RETURN_TO_ORIGINAL_PAGE_THRESHOLD &&
                            sign(velocityX.toFloat()) != sign(deltaX.toFloat()) && isFling
                        ) {
                            returnToOriginalPage = true
                        }

                        val isDeltaXLeft = if (mIsRtl) deltaX > 0 else deltaX < 0
                        val isVelocityXLeft = if (mIsRtl) velocityX > 0 else velocityX < 0
                        if (((isSignificantMove && !isDeltaXLeft && !isFling) || (isFling && !isVelocityXLeft)) &&
                            mCurrentPage > 0
                        ) {
                            val finalPage = if (returnToOriginalPage) mCurrentPage else mCurrentPage - 1
                            snapToPageWithVelocity(finalPage, velocityX)
                        } else if (((isSignificantMove && isDeltaXLeft && !isFling) ||
                                (isFling && isVelocityXLeft)) &&
                            mCurrentPage < childCount - 1
                        ) {
                            val finalPage = if (returnToOriginalPage) mCurrentPage else mCurrentPage + 1
                            snapToPageWithVelocity(finalPage, velocityX)
                        } else {
                            snapToDestination()
                        }
                    } else {
                        if (!mScroller.isFinished) {
                            abortScrollerAnimation(true)
                        }

                        val scaleX = scaleX
                        val velocityScrollX = (-velocityX * scaleX).toInt()
                        val initialScrollX = (scrollX * scaleX).toInt()

                        mScroller.fling(
                            initialScrollX,
                            scrollY,
                            velocityScrollX,
                            0,
                            Int.MIN_VALUE,
                            Int.MAX_VALUE,
                            0,
                            0
                        )
                        val unscaledScrollX = (mScroller.finalX / scaleX).toInt()
                        mNextPage = getPageNearestToCenterOfScreen(unscaledScrollX)
                        val firstPageScroll = getScrollForPage(if (!mIsRtl) 0 else getPageCount() - 1)
                        val lastPageScroll = getScrollForPage(if (!mIsRtl) getPageCount() - 1 else 0)
                        if (mSettleOnPageInFreeScroll && unscaledScrollX > 0 && unscaledScrollX < mMaxScrollX) {
                            val finalX = if (unscaledScrollX < firstPageScroll / 2) {
                                0
                            } else if (unscaledScrollX > (lastPageScroll + mMaxScrollX) / 2) {
                                mMaxScrollX
                            } else {
                                getScrollForPage(mNextPage)
                            }

                            mScroller.finalX = (finalX * scaleX).toInt()
                            val extraScrollDuration = OVERSCROLL_PAGE_SNAP_ANIMATION_DURATION - mScroller.duration
                            if (extraScrollDuration > 0) {
                                mScroller.extendDuration(extraScrollDuration)
                            }
                        }
                        invalidate()
                    }
                    onScrollInteractionEnd()
                } else if (mTouchState == TOUCH_STATE_PREV_PAGE) {
                    val nextPage = max(0, mCurrentPage - 1)
                    if (nextPage != mCurrentPage) {
                        snapToPage(nextPage)
                    } else {
                        snapToDestination()
                    }
                } else if (mTouchState == TOUCH_STATE_NEXT_PAGE) {
                    val nextPage = min(childCount - 1, mCurrentPage + 1)
                    if (nextPage != mCurrentPage) {
                        snapToPage(nextPage)
                    } else {
                        snapToDestination()
                    }
                }

                resetTouchState()
            }

            MotionEvent.ACTION_CANCEL -> {
                if (mTouchState == TOUCH_STATE_SCROLLING) {
                    snapToDestination()
                    onScrollInteractionEnd()
                }
                resetTouchState()
            }

            MotionEvent.ACTION_POINTER_UP -> {
                onSecondaryPointerUp(ev)
                releaseVelocityTracker()
            }
        }

        return true
    }

    protected fun shouldFlingForVelocity(velocityX: Int): Boolean = abs(velocityX) > mFlingThresholdVelocity

    private fun resetTouchState() {
        releaseVelocityTracker()
        mTouchState = TOUCH_STATE_REST
        mActivePointerId = INVALID_POINTER
    }

    protected open fun onScrollInteractionBegin() {
    }

    protected open fun onScrollInteractionEnd() {
    }

    override fun onGenericMotionEvent(event: MotionEvent): Boolean {
        if (event.source and InputDevice.SOURCE_CLASS_POINTER != 0) {
            when (event.action) {
                MotionEvent.ACTION_SCROLL -> {
                    val vscroll: Float
                    val hscroll: Float
                    if (event.metaState and KeyEvent.META_SHIFT_ON != 0) {
                        vscroll = 0f
                        hscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL)
                    } else {
                        vscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL)
                        hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL)
                    }
                    if (hscroll != 0f || vscroll != 0f) {
                        val isForwardScroll = if (mIsRtl) {
                            hscroll < 0 || vscroll < 0
                        } else {
                            hscroll > 0 || vscroll > 0
                        }
                        if (isForwardScroll) {
                            scrollRight()
                        } else {
                            scrollLeft()
                        }
                        return true
                    }
                }
            }
        }
        return super.onGenericMotionEvent(event)
    }

    private fun acquireVelocityTrackerAndAddMovement(ev: MotionEvent) {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain()
        }
        mVelocityTracker!!.addMovement(ev)
    }

    private fun releaseVelocityTracker() {
        val velocityTracker = mVelocityTracker
        if (velocityTracker != null) {
            velocityTracker.clear()
            velocityTracker.recycle()
            mVelocityTracker = null
        }
    }

    private fun onSecondaryPointerUp(ev: MotionEvent) {
        val pointerIndex =
            (ev.action and MotionEvent.ACTION_POINTER_INDEX_MASK) shr MotionEvent.ACTION_POINTER_INDEX_SHIFT
        val pointerId = ev.getPointerId(pointerIndex)
        if (pointerId == mActivePointerId) {
            val newPointerIndex = if (pointerIndex == 0) 1 else 0
            mDownMotionX = ev.getX(newPointerIndex)
            mLastMotionX = mDownMotionX
            mLastMotionXRemainder = 0f
            mActivePointerId = ev.getPointerId(newPointerIndex)
            mVelocityTracker?.clear()
        }
    }

    override fun requestChildFocus(child: View, focused: View) {
        super.requestChildFocus(child, focused)
        val page = indexToPage(indexOfChild(child))
        if (page >= 0 && page != getCurrentPage() && !isInTouchMode) {
            snapToPage(page)
        }
    }

    fun getPageNearestToCenterOfScreen(): Int = getPageNearestToCenterOfScreen(scrollX)

    private fun getPageNearestToCenterOfScreen(scaledScrollX: Int): Int {
        val screenCenter = scaledScrollX + measuredWidth / 2
        var minDistanceFromScreenCenter = Int.MAX_VALUE
        var minDistanceFromScreenCenterIndex = -1
        val childCount = childCount
        for (i in 0 until childCount) {
            val layout = getPageAt(i)
            val childWidth = layout.measuredWidth
            val halfChildWidth = childWidth / 2
            val childCenter = getChildOffset(i) + halfChildWidth
            val distanceFromScreenCenter = abs(childCenter - screenCenter)
            if (distanceFromScreenCenter < minDistanceFromScreenCenter) {
                minDistanceFromScreenCenter = distanceFromScreenCenter
                minDistanceFromScreenCenterIndex = i
            }
        }
        return minDistanceFromScreenCenterIndex
    }

    protected fun snapToDestination() {
        snapToPage(getPageNearestToCenterOfScreen(), getPageSnapDuration())
    }

    protected fun isInOverScroll(): Boolean = mOverScrollX > mMaxScrollX || mOverScrollX < 0

    protected fun getPageSnapDuration(): Int =
        WorkspacePageSwipeAnimationPolicy.pageSnapDuration(
            isInOverScroll = isInOverScroll(),
            overScrollDurationMs = OVERSCROLL_PAGE_SNAP_ANIMATION_DURATION
        )

    private fun distanceInfluenceForSnapDuration(value: Float): Float {
        var f = value
        f -= 0.5f
        f *= 0.3f * Math.PI.toFloat() / 2.0f
        return sin(f)
    }

    protected fun snapToPageWithVelocity(whichPageInput: Int, velocityInput: Int): Boolean {
        var whichPage = validateNewPage(whichPageInput)
        val halfScreenSize = measuredWidth / 2

        val newX = getScrollForPage(whichPage)
        val delta = newX - getUnboundedScrollX()

        if (abs(velocityInput) < mMinFlingVelocity) {
            return snapToPage(whichPage, WorkspacePageSwipeAnimationPolicy.PAGE_SNAP_DURATION_MS)
        }

        val distanceRatio = min(1f, 1.0f * abs(delta) / (2 * halfScreenSize))
        val distance = halfScreenSize + halfScreenSize * distanceInfluenceForSnapDuration(distanceRatio)

        var velocity = abs(velocityInput)
        velocity = max(mMinSnapVelocity, velocity)

        val duration = WorkspacePageSwipeAnimationPolicy.flingSnapDuration(
            4 * (1000 * abs(distance / velocity)).roundToInt()
        )

        return snapToPage(whichPage, delta, duration)
    }

    fun snapToPage(whichPage: Int): Boolean =
        snapToPage(whichPage, WorkspacePageSwipeAnimationPolicy.PAGE_SNAP_DURATION_MS)

    fun snapToPageImmediately(whichPage: Int): Boolean =
        snapToPage(whichPage, WorkspacePageSwipeAnimationPolicy.PAGE_SNAP_DURATION_MS, true, null)

    fun snapToPage(whichPage: Int, duration: Int): Boolean = snapToPage(whichPage, duration, false, null)

    fun snapToPage(whichPage: Int, duration: Int, interpolator: TimeInterpolator?): Boolean =
        snapToPage(whichPage, duration, false, interpolator)

    protected fun snapToPage(
        whichPageInput: Int,
        duration: Int,
        immediate: Boolean,
        interpolator: TimeInterpolator?
    ): Boolean {
        val whichPage = validateNewPage(whichPageInput)

        val newX = getScrollForPage(whichPage)
        val delta = newX - getUnboundedScrollX()
        return snapToPage(whichPage, delta, duration, immediate, interpolator)
    }

    protected fun snapToPage(whichPage: Int, delta: Int, duration: Int): Boolean =
        snapToPage(whichPage, delta, duration, false, null)

    protected fun snapToPage(
        whichPageInput: Int,
        delta: Int,
        durationInput: Int,
        immediate: Boolean,
        interpolator: TimeInterpolator?
    ): Boolean {
        if (mFirstLayout) {
            setCurrentPage(whichPageInput)
            return false
        }

        val whichPage = validateNewPage(whichPageInput)

        mNextPage = whichPage

        var duration = durationInput
        awakenScrollBars(duration)
        if (immediate) {
            duration = 0
        } else if (duration == 0) {
            duration = abs(delta)
        }

        if (duration != 0) {
            pageBeginTransition()
        }

        if (!mScroller.isFinished) {
            abortScrollerAnimation(false)
        }

        mScroller.startScroll(getUnboundedScrollX(), 0, delta, 0, duration)

        updatePageIndicator()

        if (immediate) {
            computeScroll()
            pageEndTransition()
        }

        invalidate()
        return abs(delta) > 0
    }

    fun scrollLeft(): Boolean {
        if (getNextPage() > 0) {
            snapToPage(getNextPage() - 1)
            return true
        }
        return false
    }

    fun scrollRight(): Boolean {
        if (getNextPage() < childCount - 1) {
            snapToPage(getNextPage() + 1)
            return true
        }
        return false
    }

    override fun getAccessibilityClassName(): CharSequence = ScrollView::class.java.name

    protected fun isPageOrderFlipped(): Boolean = false

    @Suppress("DEPRECATION")
    override fun onInitializeAccessibilityNodeInfo(info: AccessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(info)
        val pagesFlipped = isPageOrderFlipped()
        info.isScrollable = getPageCount() > 1
        if (getCurrentPage() < getPageCount() - 1) {
            info.addAction(
                if (pagesFlipped) {
                    AccessibilityNodeInfo.ACTION_SCROLL_BACKWARD
                } else {
                    AccessibilityNodeInfo.ACTION_SCROLL_FORWARD
                }
            )
        }
        if (getCurrentPage() > 0) {
            info.addAction(
                if (pagesFlipped) {
                    AccessibilityNodeInfo.ACTION_SCROLL_FORWARD
                } else {
                    AccessibilityNodeInfo.ACTION_SCROLL_BACKWARD
                }
            )
        }

        info.isLongClickable = false
        info.removeAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_LONG_CLICK)
    }

    override fun sendAccessibilityEvent(eventType: Int) {
        if (eventType != AccessibilityEvent.TYPE_VIEW_SCROLLED) {
            super.sendAccessibilityEvent(eventType)
        }
    }

    override fun onInitializeAccessibilityEvent(event: AccessibilityEvent) {
        super.onInitializeAccessibilityEvent(event)
        event.isScrollable = getPageCount() > 1
    }

    override fun performAccessibilityAction(action: Int, arguments: Bundle?): Boolean {
        if (super.performAccessibilityAction(action, arguments)) {
            return true
        }
        val pagesFlipped = isPageOrderFlipped()
        when (action) {
            AccessibilityNodeInfo.ACTION_SCROLL_FORWARD -> {
                if (if (pagesFlipped) scrollLeft() else scrollRight()) {
                    return true
                }
            }
            AccessibilityNodeInfo.ACTION_SCROLL_BACKWARD -> {
                if (if (pagesFlipped) scrollRight() else scrollLeft()) {
                    return true
                }
            }
        }
        return false
    }

    protected fun canAnnouncePageDescription(): Boolean = true

    protected fun getCurrentPageDescription(): String =
        getContext().getString(R.string.default_scroll_format, getNextPage() + 1, childCount)

    protected fun getDownMotionX(): Float = mDownMotionX

    protected fun getDownMotionY(): Float = mDownMotionY

    protected fun interface ComputePageScrollsLogic {
        fun shouldIncludeView(view: View): Boolean
    }

    fun getVisibleChildrenRange(): IntArray {
        var visibleLeft = 0f
        var visibleRight = visibleLeft + measuredWidth
        val scaleX = scaleX
        if (scaleX < 1 && scaleX > 0) {
            val mid = measuredWidth / 2f
            visibleLeft = mid - (mid - visibleLeft) / scaleX
            visibleRight = mid + (visibleRight - mid) / scaleX
        }

        var leftChild = -1
        var rightChild = -1
        val childCount = childCount
        for (i in 0 until childCount) {
            val child = getPageAt(i)

            val left = child.left + child.translationX - scrollX
            if (left <= visibleRight && left + child.measuredWidth >= visibleLeft) {
                if (leftChild == -1) {
                    leftChild = i
                }
                rightChild = i
            }
        }
        mTmpIntPair[0] = leftChild
        mTmpIntPair[1] = rightChild
        return mTmpIntPair
    }

    fun isScrollerFinished(): Boolean = mScroller.isFinished

    companion object {
        private const val TAG = "PagedView"
        private const val DEBUG = false

        protected const val INVALID_PAGE = -1

        private val SIMPLE_SCROLL_LOGIC = ComputePageScrollsLogic { view -> view.visibility != GONE }

        const val PAGE_SNAP_ANIMATION_DURATION = 750
        const val SLOW_PAGE_SNAP_ANIMATION_DURATION = 950

        private const val OVERSCROLL_PAGE_SNAP_ANIMATION_DURATION = 270

        private const val RETURN_TO_ORIGINAL_PAGE_THRESHOLD = 0.33f
        private const val SIGNIFICANT_MOVE_THRESHOLD = 0.4f

        private const val MAX_SCROLL_PROGRESS = 1.0f

        private const val FLING_THRESHOLD_VELOCITY = 500
        private const val MIN_SNAP_VELOCITY = 1500
        private const val MIN_FLING_VELOCITY = 250

        const val INVALID_RESTORE_PAGE = -1001

        protected const val TOUCH_STATE_REST = 0
        protected const val TOUCH_STATE_SCROLLING = 1
        protected const val TOUCH_STATE_PREV_PAGE = 2
        protected const val TOUCH_STATE_NEXT_PAGE = 3

        protected const val INVALID_POINTER = -1

        private val sTmpRect = Rect()
    }
}
