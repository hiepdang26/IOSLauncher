package com.vhmsoft.launcherios26.features.launcher

import com.vhmsoft.launcherios26.core.database.model.LauncherItem
import com.vhmsoft.launcherios26.core.utils.Constants
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

object FolderHoverOpenPolicy {
    data class Point(val x: Float, val y: Float)
    data class Bounds(val left: Float, val top: Float, val right: Float, val bottom: Float) {
        val width: Float
            get() = right - left
        val height: Float
            get() = bottom - top
    }

    const val OPEN_DELAY_MS = 650L
    const val HOT_SCALE = 1.08f
    const val PREVIEW_SCALE = 1.16f
    const val HOT_ANIMATION_MS = 120L
    const val COLD_ANIMATION_MS = 140L
    const val PREVIEW_ANIMATION_MS = 180L
    const val DROP_ARC_ANIMATION_MS = 650L
    const val FOLDER_PREVIEW_MINI_ICON_SCALE = 0.2f
    const val FOLDER_PREVIEW_CORNER_RADIUS_FRACTION = 0.22f
    const val FOLDER_PREVIEW_STROKE_WIDTH_DP = 2
    const val FOLDER_PREVIEW_COLUMNS = 3
    const val MAX_FOLDER_PREVIEW_ICONS = 9
    const val FOLDER_PREVIEW_ORIGIN_FRACTION = 0.1f
    const val FOLDER_PREVIEW_GAP_FRACTION = 0.1f

    fun canScheduleOpen(
        folderInterest: Boolean,
        movingItemType: Int,
        targetItemType: Int?,
        folderAlreadyOpen: Boolean
    ): Boolean =
        folderInterest &&
            !folderAlreadyOpen &&
            movingItemType != Constants.ITEM_TYPE_FOLDER &&
            targetItemType == Constants.ITEM_TYPE_FOLDER

    fun canScheduleCreationPreview(
        folderInterest: Boolean,
        movingItemType: Int,
        targetItemType: Int?,
        folderAlreadyOpen: Boolean,
        previewAlreadyShownForTarget: Boolean
    ): Boolean =
        folderInterest &&
            !folderAlreadyOpen &&
            !previewAlreadyShownForTarget &&
            movingItemType != Constants.ITEM_TYPE_FOLDER &&
            targetItemType == Constants.ITEM_TYPE_APPLICATION

    fun dropArcControlPoint(startX: Float, startY: Float, endX: Float, endY: Float): Point {
        val horizontalDistance = abs(endX - startX)
        val verticalDistance = abs(endY - startY)
        val lift = max(48f, horizontalDistance * 0.22f + verticalDistance * 0.18f)
        return Point(
            x = (startX + endX) / 2f,
            y = min(startY, endY) - lift
        )
    }

    fun folderPreviewCellBounds(iconLeft: Float, iconTop: Float, iconSize: Int, cell: Int): Bounds {
        val visibleCell = cell.coerceIn(0, MAX_FOLDER_PREVIEW_ICONS - 1)
        val iconSizeFloat = iconSize.toFloat()
        val miniIconSize = iconSizeFloat * FOLDER_PREVIEW_MINI_ICON_SCALE
        val origin = iconSizeFloat * FOLDER_PREVIEW_ORIGIN_FRACTION
        val gap = iconSizeFloat * FOLDER_PREVIEW_GAP_FRACTION
        val column = visibleCell % FOLDER_PREVIEW_COLUMNS
        val row = visibleCell / FOLDER_PREVIEW_COLUMNS
        val left = iconLeft + origin + column * (miniIconSize + gap)
        val top = iconTop + origin + row * (miniIconSize + gap)
        return Bounds(
            left = left,
            top = top,
            right = left + miniIconSize,
            bottom = top + miniIconSize
        )
    }

    fun dropArcSnapshotTargetTopLeft(iconLeft: Float, iconTop: Float, iconSize: Int, cell: Int): Point {
        val bounds = folderPreviewCellBounds(iconLeft, iconTop, iconSize, cell)
        return Point(
            x = bounds.left + bounds.width / 2f - iconSize / 2f,
            y = bounds.top + bounds.height / 2f - iconSize / 2f
        )
    }

    fun isExternalDropIntoOpenFolder(movingItem: LauncherItem, folder: LauncherItem): Boolean =
        movingItem.container != folder.id.toLongOrNull()
}
