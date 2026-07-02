package com.cloudx.ios17.core.customviews

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.Property
import android.util.TypedValue
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.cloudx.ios17.BlissLauncher
import com.cloudx.ios17.R
import com.cloudx.ios17.core.DeviceProfile
import com.cloudx.ios17.core.HomeIconRenderPolicy
import com.cloudx.ios17.core.LauncherAppLabelStylePolicy
import com.cloudx.ios17.core.LauncherFolderTitlePolicy
import com.cloudx.ios17.core.Utilities
import com.cloudx.ios17.core.database.model.ApplicationItem
import com.cloudx.ios17.core.database.model.CalendarIcon
import com.cloudx.ios17.core.database.model.FolderItem
import com.cloudx.ios17.core.database.model.LauncherItem
import com.cloudx.ios17.core.database.model.ShortcutItem
import com.cloudx.ios17.core.utils.Constants
import com.cloudx.ios17.features.notification.DotRenderer
import java.util.Calendar

/** Created by falcon on 20/3/18. */
class BlissFrameLayout @JvmOverloads constructor(
    private val mContext: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(mContext, attrs, defStyleAttr) {

    private var hasBadge = false
    private val mTempIconBounds = Rect()
    private lateinit var mDeviceProfile: DeviceProfile
    private var mBadgeScale = 0f
    private var mIconSize = 0
    private var mWithText = false
    private lateinit var mDotRenderer: DotRenderer
    private var mLauncherItem: LauncherItem? = null

    var launcherItem: LauncherItem
        get() = mLauncherItem!!
        set(value) {
            mLauncherItem = value
            when (value.itemType) {
                Constants.ITEM_TYPE_APPLICATION -> bindApplicationItem(value as ApplicationItem)
                Constants.ITEM_TYPE_SHORTCUT -> bindShortcutItem(value as ShortcutItem)
                Constants.ITEM_TYPE_FOLDER -> bindFolderItem(value as FolderItem)
            }
        }

    init {
        init()
    }

    private fun init() {
        setWillNotDraw(false)
        mDeviceProfile = BlissLauncher.getApplication(mContext).deviceProfile
        mDotRenderer = DotRenderer(mContext, mDeviceProfile.iconSizePx)
        mIconSize = mDeviceProfile.iconSizePx
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
        drawBadgeIfNecessary(canvas)
    }

    private fun drawBadgeIfNecessary(canvas: Canvas) {
        if (hasBadge) {
            getIconBounds(mTempIconBounds)
            mDotRenderer.drawDot(canvas, mTempIconBounds)
        }
    }

    fun setWithText(withText: Boolean) {
        mWithText = withText
    }

    private fun getIconBounds(outBounds: Rect) {
        val cellHeightPx = if (mWithText) {
            mDeviceProfile.cellHeightWithoutPaddingPx
        } else {
            mDeviceProfile.hotseatCellHeightWithoutPaddingPx
        }
        val top = (height - cellHeightPx) / 2
        val left = (width - mIconSize) / 2
        val right = left + mIconSize
        val bottom = top + mIconSize
        outBounds.set(left, top, right, bottom)
    }

    fun applyBadge(isBadge: Boolean, withText: Boolean) {
        mWithText = withText
        val wasBadged = hasBadge
        hasBadge = isBadge
        val isBadged = hasBadge
        val newBadgeScale = if (isBadge) 1f else 0f

        if (wasBadged xor isBadged) {
            if (isShown) {
                ObjectAnimator.ofFloat(this, BADGE_SCALE_PROPERTY, newBadgeScale).start()
            } else {
                mBadgeScale = newBadgeScale
                invalidate()
            }
        }
    }

    private fun applyIconMetrics(icon: SquareFrameLayout, label: TextView) {
        val layoutParams = icon.layoutParams as LinearLayout.LayoutParams
        layoutParams.width = mIconSize
        layoutParams.height = mIconSize
        layoutParams.leftMargin = 0
        layoutParams.rightMargin = 0
        icon.layoutParams = layoutParams

        label.setPadding(
            Utilities.pxFromDp(4, mContext).toInt(),
            0,
            Utilities.pxFromDp(4, mContext).toInt(),
            0
        )
        label.typeface = Typeface.create(LauncherAppLabelStylePolicy.FONT_FAMILY, Typeface.NORMAL)
        label.includeFontPadding = false
        label.letterSpacing = 0f
        label.setShadowLayer(
            Utilities.pxFromDp(LauncherAppLabelStylePolicy.SHADOW_RADIUS_DP, resources.displayMetrics).toFloat(),
            0f,
            Utilities.pxFromDp(LauncherAppLabelStylePolicy.SHADOW_DY_DP, resources.displayMetrics).toFloat(),
            LauncherAppLabelStylePolicy.SHADOW_COLOR
        )
        label.setTextSize(TypedValue.COMPLEX_UNIT_PX, mDeviceProfile.iconTextSizePx.toFloat())
    }

    private fun bindFolderItem(folderItem: FolderItem) {
        val label = findViewById<TextView>(R.id.app_label)
        val icon = findViewById<SquareFrameLayout>(R.id.app_icon)
        val squareImageView = findViewById<SquareImageView>(R.id.icon_image_view)
        icon.enableBlur()
        applyIconMetrics(icon, label)
        squareImageView.iconContentScale = 1f
        squareImageView.setImageDrawable(folderItem.icon)
        label.text = LauncherFolderTitlePolicy.homeTitle(
            rawTitle = folderItem.title?.toString(),
            defaultFolderName = resources.getString(R.string.folder_default_name)
        )
        tag = arrayListOf(squareImageView, label, folderItem)
    }

    private fun bindShortcutItem(shortcutItem: ShortcutItem) {
        val label = findViewById<TextView>(R.id.app_label)
        val icon = findViewById<SquareFrameLayout>(R.id.app_icon)
        val squareImageView = findViewById<SquareImageView>(R.id.icon_image_view)
        applyIconMetrics(icon, label)
        squareImageView.iconContentScale = HomeIconRenderPolicy.homeScreenIconContentScale
        squareImageView.setImageDrawable(shortcutItem.icon)
        label.text = shortcutItem.title.toString()
        tag = arrayListOf(squareImageView, label, shortcutItem)
    }

    private fun bindApplicationItem(applicationItem: ApplicationItem) {
        val label = findViewById<TextView>(R.id.app_label)
        val icon = findViewById<SquareFrameLayout>(R.id.app_icon)
        val squareImageView = findViewById<SquareImageView>(R.id.icon_image_view)
        applyIconMetrics(icon, label)
        squareImageView.iconContentScale = HomeIconRenderPolicy.homeScreenIconContentScale
        if (applicationItem.appType == ApplicationItem.TYPE_CLOCK) {
            val analogClock = findViewById<CustomAnalogClock>(R.id.icon_clock)
            analogClock.setAutoUpdate(true)
            analogClock.visibility = View.VISIBLE
            squareImageView.visibility = GONE
        } else if (applicationItem.appType == ApplicationItem.TYPE_CALENDAR) {
            val monthTextView = findViewById<TextView>(R.id.calendar_month_textview)
            monthTextView.layoutParams.height = mDeviceProfile.monthTextviewHeight
            monthTextView.layoutParams.width = mDeviceProfile.calendarIconWidth
            val monthPx = mDeviceProfile.monthTextSize
            monthTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, (monthPx / 2).toFloat())

            val dateTextView = findViewById<TextView>(R.id.calendar_date_textview)
            dateTextView.layoutParams.height = mDeviceProfile.dateTextviewHeight
            dateTextView.layoutParams.width = mDeviceProfile.calendarIconWidth
            val datePx = mDeviceProfile.dateTextSize
            dateTextView.setPadding(
                0,
                mDeviceProfile.dateTextTopPadding,
                0,
                mDeviceProfile.dateTextBottomPadding
            )

            dateTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, (datePx / 2).toFloat())

            findViewById<View>(R.id.icon_calendar).visibility = View.VISIBLE
            squareImageView.visibility = GONE

            val calendarIcon = CalendarIcon(monthTextView, dateTextView)
            calendarIcon.monthTextView.text = Utilities.convertMonthToString()
            calendarIcon.dayTextView.text = Calendar.getInstance().get(Calendar.DAY_OF_MONTH).toString()
        } else {
            squareImageView.setImageDrawable(applicationItem.icon)
        }
        label.text = applicationItem.title.toString()
        tag = arrayListOf(squareImageView, label, applicationItem)
    }

    companion object {
        private val BADGE_SCALE_PROPERTY = object : Property<BlissFrameLayout, Float>(
            Float::class.java,
            "badgeScale"
        ) {
            override fun get(bubbleTextView: BlissFrameLayout): Float = bubbleTextView.mBadgeScale

            override fun set(bubbleTextView: BlissFrameLayout, value: Float) {
                bubbleTextView.mBadgeScale = value
                bubbleTextView.invalidate()
            }
        }
    }
}
