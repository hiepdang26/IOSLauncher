package com.cloudx.ios17.core

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Matrix
import android.graphics.Path
import android.graphics.Point
import android.graphics.Rect
import android.graphics.RectF
import android.util.DisplayMetrics
import android.view.WindowManager
import com.cloudx.ios17.core.customviews.PathParser
import com.cloudx.ios17.core.utils.AdaptiveIconUtils

class DeviceProfile(context: Context) {

    private val homeLayoutSettings = LauncherHomeLayoutPreferences.read(context)
    private val widthCm: Float
    private val ratio: Float
    private var statusBarHeight = 0

    @JvmField
    var cellHeightWithoutPaddingPx = 0

    @JvmField
    var hotseatCellHeightWithoutPaddingPx = 0

    @JvmField
    var fillResIconDpi = 0

    interface LauncherLayoutChangeListener {
        fun onLauncherLayoutChanged()
    }

    /** Number of icons per row and column in the workspace. */
    @JvmField
    var numRows = 0

    @JvmField
    var numColumns = 0

    @JvmField
    var maxAppsPerPage = 0

    /** Number of icons per row and column in the folder. */
    @JvmField
    var numFolderRows = 0

    @JvmField
    var numFolderColumns = 0

    /** Number of icons inside the hotseat area. */
    @JvmField
    var numHotseatIcons = 0

    // Device properties in current orientation.
    @JvmField
    val widthPx: Int

    @JvmField
    val heightPx: Int

    @JvmField
    val availableWidthPx: Int

    @JvmField
    val availableHeightPx: Int

    // Page indicator.
    @JvmField
    var pageIndicatorSizePx = 0

    @JvmField
    var pageIndicatorTopPaddingPx = 0

    @JvmField
    var pageIndicatorBottomPaddingPx = 0

    // Workspace icons.
    @JvmField
    var iconSizePx = 0

    @JvmField
    var iconTextSizePx = 0

    @JvmField
    var iconDrawablePaddingPx = 0

    // Calendar icon.
    @JvmField
    var dateTextSize = 0

    @JvmField
    var monthTextSize = 0

    @JvmField
    var dateTextviewHeight = 0

    @JvmField
    var monthTextviewHeight = 0

    @JvmField
    var calendarIconWidth = 0

    @JvmField
    var dateTextBottomPadding = 0

    @JvmField
    var dateTextTopPadding = 0

    // Uninstall icon.
    @JvmField
    var uninstallIconSizePx = 0

    @JvmField
    var uninstallIconPadding = 0

    @JvmField
    var cellWidthPx = 0

    @JvmField
    var cellHeightPx = 0

    @JvmField
    var workspaceCellPaddingXPx = 0

    // Widget.
    @JvmField
    var maxWidgetWidth = 0

    @JvmField
    var maxWidgetHeight = 0

    // Folder.
    @JvmField
    var folderBackgroundOffset = 0

    @JvmField
    var folderIconSizePx = 0

    @JvmField
    var folderIconPreviewPadding = 0

    // Folder cell.
    @JvmField
    var folderCellWidthPx = 0

    @JvmField
    var folderCellHeightPx = 0

    // Folder child.
    @JvmField
    var folderChildIconSizePx = 0

    @JvmField
    var folderChildTextSizePx = 0

    @JvmField
    var folderChildDrawablePaddingPx = 0

    // Hotseat.
    @JvmField
    var hotseatCellWidthPx = 0

    @JvmField
    var hotseatCellHeightPx = 0

    // In portrait: size = height, in landscape: size = width.
    @JvmField
    var hotseatBarSizePx = 0

    @JvmField
    var hotseatBarTopPaddingPx = 0

    @JvmField
    var hotseatBarBottomPaddingPx = 0

    @JvmField
    var hotseatBarLeftNavBarLeftPaddingPx = 0

    @JvmField
    var hotseatBarLeftNavBarRightPaddingPx = 0

    @JvmField
    var hotseatBarRightNavBarLeftPaddingPx = 0

    @JvmField
    var hotseatBarRightNavBarRightPaddingPx = 0

    // All apps.
    @JvmField
    var allAppsCellHeightPx = 0

    @JvmField
    var allAppsNumCols = 0

    @JvmField
    var allAppsNumPredictiveCols = 0

    @JvmField
    var allAppsButtonVisualSize = 0

    @JvmField
    var allAppsIconSizePx = 0

    @JvmField
    var allAppsIconDrawablePaddingPx = 0

    @JvmField
    var allAppsIconTextSizePx = 0f

    // Drop target.
    @JvmField
    var dropTargetBarSizePx = 0

    private val mInsets = Rect()
    private val mListeners = ArrayList<LauncherLayoutChangeListener>()

    init {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val dm = DisplayMetrics()
        display.getMetrics(dm)

        val smallestSize = Point()
        val largestSize = Point()
        display.getCurrentSizeRange(smallestSize, largestSize)

        availableWidthPx = smallestSize.x
        availableHeightPx = largestSize.y

        val realSize = Point()
        display.getRealSize(realSize)

        widthPx = realSize.x
        val x = widthPx / dm.densityDpi.toDouble()
        ratio = dm.densityDpi.toFloat() / dm.xdpi
        widthCm = (x * 2.540001f).toFloat()
        heightPx = realSize.y

        val portraitContext = getContext(context, Configuration.ORIENTATION_PORTRAIT)
        val res = portraitContext.resources

        statusBarHeight = 0
        val resourceId = res.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            statusBarHeight = res.getDimensionPixelSize(resourceId)
        }

        pageIndicatorSizePx = Utilities.pxFromDp(18f, dm)
        pageIndicatorTopPaddingPx = Utilities.pxFromDp(8f, dm)
        pageIndicatorBottomPaddingPx = Utilities.pxFromDp(8f, dm)

        numColumns = homeLayoutSettings.columns
        numRows = homeLayoutSettings.rows
        numFolderColumns = 3
        numHotseatIcons = numColumns
        numFolderRows = numFolderColumns

        updateAvailableDimensions(dm, res)
    }

    private fun updateAvailableDimensions(dm: DisplayMetrics, res: Resources) {
        updateIconSize(1f, res, dm)
        path = getRoundedCornerPath(iconSizePx)
    }

    private fun updateIconSize(scale: Float, res: Resources, dm: DisplayMetrics) {
        val responsiveIconSizeDp = LauncherHomeLayoutPreferences.responsiveIconSizeDp(
            iconSizeDp = homeLayoutSettings.iconSizeDp,
            density = dm.density,
            availableWidthPx = availableWidthPx,
            availableHeightPx = availableHeightPx
        )
        iconTextSizePx = (
            Utilities.pxFromSp(
                LauncherHomeLayoutPreferences.appLabelTextSizeSp(responsiveIconSizeDp),
                dm
            ) * scale
        ).toInt()
        val labelGapPx = Utilities.pxFromDp(4f, dm)
        val labelHeightPx = Utilities.calculateTextHeight(iconTextSizePx.toFloat())
        iconSizePx = LauncherHomeLayoutPreferences.resolveIconSizePx(
            preferredIconSizeDp = homeLayoutSettings.iconSizeDp,
            density = dm.density,
            availableWidthPx = availableWidthPx,
            availableHeightPx = availableHeightPx,
            rows = numRows,
            columns = numColumns,
            labelHeightPx = labelHeightPx,
            labelGapPx = labelGapPx
        )
        iconDrawablePaddingPx = LauncherHomeLayoutPreferences.horizontalGapPx(
            availableWidthPx = availableWidthPx,
            iconSizePx = iconSizePx,
            columns = numColumns
        )

        val tempUninstallIconSize = iconSizePx * 72 / 192
        uninstallIconSizePx =
            if (tempUninstallIconSize > iconDrawablePaddingPx) {
                iconDrawablePaddingPx
            } else {
                tempUninstallIconSize
            }
        uninstallIconPadding = iconSizePx * 10 / 192

        calendarIconWidth = iconSizePx
        monthTextviewHeight = iconSizePx * 40 / 192
        monthTextSize = iconSizePx * 48 / 192
        dateTextviewHeight = iconSizePx * 152 / 192
        dateTextSize = iconSizePx * 154 / 192

        dateTextTopPadding =
            (dateTextviewHeight - (1.14 * Utilities.calculateTextHeight(dateTextSize.toFloat() / 2)).toInt()) / 2
        dateTextBottomPadding =
            (dateTextviewHeight - (0.86 * Utilities.calculateTextHeight(dateTextSize.toFloat() / 2)).toInt()) / 2

        cellHeightWithoutPaddingPx = iconSizePx + labelGapPx + labelHeightPx

        val hotseatExtraHeightPx = Utilities.pxFromDp(
            LauncherHomeLayoutPreferences.DOCK_EXTRA_HEIGHT_DP.toFloat(),
            dm
        )
        hotseatCellHeightWithoutPaddingPx = iconSizePx
        hotseatCellHeightPx = hotseatCellHeightWithoutPaddingPx + hotseatExtraHeightPx

        val workspaceHeightPx = (
            availableHeightPx -
                Utilities.pxFromDp(LauncherHomeLayoutPreferences.HOME_PAGE_TOP_PADDING_DP.toFloat(), dm) -
                pageIndicatorHeight -
                Utilities.pxFromDp(LauncherHomeLayoutPreferences.INDICATOR_DOCK_GAP_DP.toFloat(), dm) -
                Utilities.pxFromDp(LauncherHomeLayoutPreferences.DOCK_BOTTOM_MARGIN_DP.toFloat(), dm) -
                hotseatCellHeightPx
            ).coerceAtLeast(cellHeightWithoutPaddingPx * numRows)

        cellHeightPx = workspaceHeightPx / numRows
        cellWidthPx = iconSizePx + iconDrawablePaddingPx
        hotseatCellWidthPx = (
            availableWidthPx -
                2 * Utilities.pxFromDp(LauncherHomeLayoutPreferences.DOCK_HORIZONTAL_MARGIN_DP.toFloat(), dm)
            ).coerceAtLeast(numColumns) / numColumns

        maxAppsPerPage = numColumns * numRows

        folderIconSizePx = iconSizePx

        fillResIconDpi = getLauncherIconDensity(iconSizePx)

        maxWidgetWidth = availableWidthPx - 2 * Utilities.pxFromDp(8f, dm)
        maxWidgetHeight = workspaceHeight
    }

    private fun getCurrentWidth(): Int = minOf(widthPx, heightPx)

    private fun getCurrentHeight(): Int = maxOf(widthPx, heightPx)

    val workspaceHeight: Int
        get() = cellHeightPx * numRows

    fun getAvailableWidthPx(): Int = availableWidthPx

    val pageIndicatorHeight: Int
        get() = pageIndicatorSizePx + pageIndicatorBottomPaddingPx + pageIndicatorTopPaddingPx

    fun getMaxWidgetWidth(): Int = maxWidgetWidth

    fun getMaxWidgetHeight(): Int = maxWidgetHeight

    fun getCellHeight(containerType: Int): Int =
        when (containerType) {
            TYPE_WORKSPACE -> cellHeightPx
            TYPE_FOLDER -> folderCellHeightPx
            TYPE_HOTSEAT -> hotseatCellHeightPx
            else -> 0
        }

    fun getRoundedCornerPath(iconSize: Int): Path =
        resizePath(PathParser.createPathFromPathData(AdaptiveIconUtils.getMaskPath()), iconSize, iconSize)

    private fun resizePath(path: Path, width: Int, height: Int): Path {
        val bounds = RectF(0f, 0f, width.toFloat(), height.toFloat())
        val resizedPath = Path(path)
        val src = RectF()
        resizedPath.computeBounds(src, true)

        val resizeMatrix = Matrix()
        resizeMatrix.setRectToRect(src, bounds, Matrix.ScaleToFit.CENTER)
        resizedPath.transform(resizeMatrix)

        return resizedPath
    }

    fun hasSoftNavigationBar(context: Context): Boolean {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val dm = DisplayMetrics()
        display.getMetrics(dm)

        val smallestSize = Point()
        val largestSize = Point()
        display.getCurrentSizeRange(smallestSize, largestSize)

        val availableHeight = largestSize.y

        val realSize = Point()
        display.getRealSize(realSize)
        val realHeight = realSize.y
        val portraitContext = getContext(context, Configuration.ORIENTATION_PORTRAIT)
        val res = portraitContext.resources

        statusBarHeight = 0
        val resourceId = res.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            statusBarHeight = res.getDimensionPixelSize(resourceId)
        }

        return realHeight - availableHeight - statusBarHeight > 0
    }

    private fun getLauncherIconDensity(requiredSize: Int): Int {
        val densityBuckets = intArrayOf(
            DisplayMetrics.DENSITY_LOW,
            DisplayMetrics.DENSITY_MEDIUM,
            DisplayMetrics.DENSITY_TV,
            DisplayMetrics.DENSITY_HIGH,
            DisplayMetrics.DENSITY_XHIGH,
            DisplayMetrics.DENSITY_XXHIGH,
            DisplayMetrics.DENSITY_XXXHIGH
        )

        var density = DisplayMetrics.DENSITY_XXXHIGH
        for (i in densityBuckets.indices.reversed()) {
            val expectedSize =
                ICON_SIZE_DEFINED_IN_APP_DP * densityBuckets[i] / DisplayMetrics.DENSITY_DEFAULT
            if (expectedSize >= requiredSize) {
                density = densityBuckets[i]
            }
        }

        return density
    }

    companion object {
        private const val TYPE_WORKSPACE = 0
        private const val TYPE_FOLDER = 1
        private const val TYPE_HOTSEAT = 2
        private const val ICON_SIZE_DEFINED_IN_APP_DP = 48f

        @JvmField
        var path: Path = Path()

        @JvmStatic
        fun calculateCellWidth(width: Int, countX: Int): Int = width / countX

        @JvmStatic
        fun calculateCellHeight(height: Int, countY: Int): Int = height / countY

        private fun getContext(c: Context, orientation: Int): Context {
            val configuration = Configuration(c.resources.configuration)
            configuration.orientation = orientation
            return c.createConfigurationContext(configuration)
        }

    }
}
