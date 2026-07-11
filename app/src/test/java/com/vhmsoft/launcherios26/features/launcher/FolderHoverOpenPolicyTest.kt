package com.vhmsoft.launcherios26.features.launcher

import com.vhmsoft.launcherios26.core.database.model.LauncherItem
import com.vhmsoft.launcherios26.core.utils.Constants
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class FolderHoverOpenPolicyTest {

    @Test
    fun canScheduleOpen_onlyForNonFolderDraggedOverClosedFolder() {
        assertTrue(
            FolderHoverOpenPolicy.canScheduleOpen(
                folderInterest = true,
                movingItemType = Constants.ITEM_TYPE_APPLICATION,
                targetItemType = Constants.ITEM_TYPE_FOLDER,
                folderAlreadyOpen = false
            )
        )
    }

    @Test
    fun canScheduleOpen_ignoresQuickPassesAndNonFolders() {
        assertFalse(
            FolderHoverOpenPolicy.canScheduleOpen(
                folderInterest = false,
                movingItemType = Constants.ITEM_TYPE_APPLICATION,
                targetItemType = Constants.ITEM_TYPE_FOLDER,
                folderAlreadyOpen = false
            )
        )
        assertFalse(
            FolderHoverOpenPolicy.canScheduleOpen(
                folderInterest = true,
                movingItemType = Constants.ITEM_TYPE_APPLICATION,
                targetItemType = Constants.ITEM_TYPE_APPLICATION,
                folderAlreadyOpen = false
            )
        )
        assertFalse(
            FolderHoverOpenPolicy.canScheduleOpen(
                folderInterest = true,
                movingItemType = Constants.ITEM_TYPE_FOLDER,
                targetItemType = Constants.ITEM_TYPE_FOLDER,
                folderAlreadyOpen = false
            )
        )
    }

    @Test
    fun canScheduleOpen_ignoresAlreadyOpenFolder() {
        assertFalse(
            FolderHoverOpenPolicy.canScheduleOpen(
                folderInterest = true,
                movingItemType = Constants.ITEM_TYPE_APPLICATION,
                targetItemType = Constants.ITEM_TYPE_FOLDER,
                folderAlreadyOpen = true
            )
        )
    }

    @Test
    fun canScheduleCreationPreview_allowsDraggingAppOverAnotherApp() {
        assertTrue(
            FolderHoverOpenPolicy.canScheduleCreationPreview(
                folderInterest = true,
                movingItemType = Constants.ITEM_TYPE_APPLICATION,
                targetItemType = Constants.ITEM_TYPE_APPLICATION,
                folderAlreadyOpen = false,
                previewAlreadyShownForTarget = false
            )
        )
    }

    @Test
    fun canScheduleCreationPreview_ignoresFoldersAndRepeatedPreview() {
        assertFalse(
            FolderHoverOpenPolicy.canScheduleCreationPreview(
                folderInterest = true,
                movingItemType = Constants.ITEM_TYPE_FOLDER,
                targetItemType = Constants.ITEM_TYPE_APPLICATION,
                folderAlreadyOpen = false,
                previewAlreadyShownForTarget = false
            )
        )
        assertFalse(
            FolderHoverOpenPolicy.canScheduleCreationPreview(
                folderInterest = true,
                movingItemType = Constants.ITEM_TYPE_APPLICATION,
                targetItemType = Constants.ITEM_TYPE_FOLDER,
                folderAlreadyOpen = false,
                previewAlreadyShownForTarget = false
            )
        )
        assertFalse(
            FolderHoverOpenPolicy.canScheduleCreationPreview(
                folderInterest = true,
                movingItemType = Constants.ITEM_TYPE_APPLICATION,
                targetItemType = Constants.ITEM_TYPE_APPLICATION,
                folderAlreadyOpen = false,
                previewAlreadyShownForTarget = true
            )
        )
    }

    @Test
    fun dropArcControlPoint_liftsDraggedIconAboveTheStraightLine() {
        val control = FolderHoverOpenPolicy.dropArcControlPoint(
            startX = 40f,
            startY = 420f,
            endX = 210f,
            endY = 120f
        )

        assertEquals(125f, control.x)
        assertTrue(control.y < 120f)
    }

    @Test
    fun dropArcMotion_usesFolderPreviewMiniIconScale() {
        assertEquals(0.2f, FolderHoverOpenPolicy.FOLDER_PREVIEW_MINI_ICON_SCALE)
        assertEquals(650L, FolderHoverOpenPolicy.DROP_ARC_ANIMATION_MS)
        assertTrue(FolderHoverOpenPolicy.FOLDER_PREVIEW_STROKE_WIDTH_DP > 0)
    }

    @Test
    fun folderPreviewCellBounds_placesDraggedAppInSecondSlotForNewFolder() {
        val bounds = FolderHoverOpenPolicy.folderPreviewCellBounds(
            iconLeft = 100f,
            iconTop = 200f,
            iconSize = 120,
            cell = 1
        )

        assertEquals(148f, bounds.left, 0.01f)
        assertEquals(212f, bounds.top, 0.01f)
        assertEquals(172f, bounds.right, 0.01f)
        assertEquals(236f, bounds.bottom, 0.01f)
    }

    @Test
    fun folderPreviewCellBounds_placesFourthAppAtFirstColumnSecondRow() {
        val bounds = FolderHoverOpenPolicy.folderPreviewCellBounds(
            iconLeft = 100f,
            iconTop = 200f,
            iconSize = 120,
            cell = 3
        )

        assertEquals(112f, bounds.left, 0.01f)
        assertEquals(248f, bounds.top, 0.01f)
    }

    @Test
    fun folderPreviewCellBounds_clampsCellsBeyondVisiblePreview() {
        val bounds = FolderHoverOpenPolicy.folderPreviewCellBounds(
            iconLeft = 100f,
            iconTop = 200f,
            iconSize = 120,
            cell = 14
        )

        assertEquals(184f, bounds.left, 0.01f)
        assertEquals(284f, bounds.top, 0.01f)
    }

    @Test
    fun dropArcSnapshotTargetTopLeft_centersScaledSnapshotOnDestinationCell() {
        val target = FolderHoverOpenPolicy.dropArcSnapshotTargetTopLeft(
            iconLeft = 100f,
            iconTop = 200f,
            iconSize = 120,
            cell = 1
        )

        assertEquals(100f, target.x, 0.01f)
        assertEquals(164f, target.y, 0.01f)
    }

    @Test
    fun isExternalDropIntoOpenFolder_detectsAppsFromOutsideFolder() {
        val folder = LauncherItem().apply { id = "123" }
        val outsideApp = LauncherItem().apply { container = Constants.CONTAINER_DESKTOP.toLong() }
        val insideApp = LauncherItem().apply { container = 123L }

        assertTrue(FolderHoverOpenPolicy.isExternalDropIntoOpenFolder(outsideApp, folder))
        assertFalse(FolderHoverOpenPolicy.isExternalDropIntoOpenFolder(insideApp, folder))
    }
}
