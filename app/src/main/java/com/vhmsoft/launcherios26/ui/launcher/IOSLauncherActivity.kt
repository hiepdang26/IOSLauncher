package com.vhmsoft.launcherios26.ui.launcher

import android.app.role.RoleManager
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherFolder
import com.vhmsoft.launcherios26.databinding.ActivityIosLauncherBinding
import com.vhmsoft.launcherios26.di.RepositoryProvider
import com.vhmsoft.launcherios26.ui.applibrary.AppLibraryActivity
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherAppOptionsController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherCategoryDetailController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherFolderController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherKeyboardController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherRemoveAppController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherSearchController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherSystemUiController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherVisualEffectsController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherWidgetSheetController
import com.vhmsoft.launcherios26.ui.launcher.workspace.AppLibraryGroupBuilder
import com.vhmsoft.launcherios26.ui.launcher.workspace.AppLibraryGroupUiModel
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherDockAdapter
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherDragCallback
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeItemUiModel
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeLayoutBuilder
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconAdapter
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconUiModel
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherPageAdapter
import com.vhmsoft.launcherios26.ui.launcher.workspace.WidgetAppAdapter
import kotlin.math.abs

class IOSLauncherActivity : AppCompatActivity(), IOSLauncherContract.View {
    private lateinit var binding: ActivityIosLauncherBinding
    private lateinit var presenter: IOSLauncherPresenter
    private lateinit var systemUiController: LauncherSystemUiController
    private lateinit var keyboardController: LauncherKeyboardController
    private lateinit var visualEffectsController: LauncherVisualEffectsController
    private lateinit var appOptionsController: LauncherAppOptionsController
    private lateinit var removeAppController: LauncherRemoveAppController
    private lateinit var searchController: LauncherSearchController
    private lateinit var folderController: LauncherFolderController
    private lateinit var widgetSheetController: LauncherWidgetSheetController
    private lateinit var categoryDetailController: LauncherCategoryDetailController
    private lateinit var workspacePageAdapter: LauncherPageAdapter
    private lateinit var dockAdapter: LauncherDockAdapter
    private lateinit var categoryDetailAdapter: LauncherIconAdapter
    private lateinit var folderContentAdapter: LauncherIconAdapter
    private lateinit var folderItemTouchHelper: ItemTouchHelper
    private lateinit var widgetAppAdapter: WidgetAppAdapter
    private val state = LauncherUiState()
    private val indicatorHandler = Handler(Looper.getMainLooper())
    private val hideIndicatorRunnable = Runnable { hidePageIndicator() }
    private val folderEdgeSwitchHandler = Handler(Looper.getMainLooper())
    private val folderEdgeSwitchRunnable = Runnable { performFolderExitEdgeSwitch() }
    private val homeEdgeSwitchHandler = Handler(Looper.getMainLooper())
    private val homeEdgeSwitchRunnable = Runnable { performHomeEdgeSwitch() }
    private var homeItems: List<LauncherHomeItemUiModel> = emptyList()
    private var pullDownStartX = 0f
    private var pullDownStartY = 0f
    private var pullDownGestureArmed = false
    private val emptyLongPressHandler = Handler(Looper.getMainLooper())
    private val emptyLongPressRunnable = Runnable {
        if (emptyLongPressArmed) {
            emptyLongPressArmed = false
            setHomeEditing(true)
        }
    }
    private var emptyLongPressStartX = 0f
    private var emptyLongPressStartY = 0f
    private var emptyLongPressArmed = false
    private var lastLauncherMode = false
    private var editingHome = false
    private var forceSettingsPanel = false
    private var skipNextResumeReload = true
    private var waitingForLauncherSelection = false
    private var folderExitDragActive = false
    private var folderExitDragCollapsed = false
    private var folderExitDragCenterX = 0f
    private var folderExitDragCenterY = 0f
    private var folderExitEdgeDirection = 0
    private var folderExitDragPage = 0
    private var folderExitPreviewIndex = NO_PREVIEW_INDEX
    private var folderExitDraggedApp: LauncherIconUiModel? = null
    private var folderExitBaseHomeItems: List<LauncherHomeItemUiModel> = emptyList()
    private var homeEdgeDragActive = false
    private var homeEdgeDragCenterX = 0f
    private var homeEdgeDragCenterY = 0f
    private var homeEdgeDragPage = 0
    private var homeEdgeDirection = 0
    private var homeEdgePreviewIndex = NO_PREVIEW_INDEX
    private var homeEdgeFolderTargetIndex = NO_PREVIEW_INDEX
    private var homeEdgeDraggedApp: LauncherIconUiModel? = null
    private var homeEdgeBaseItems: List<LauncherHomeItemUiModel> = emptyList()
    private var homeEdgeCommitted = false
    private val appLibraryLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == android.app.Activity.RESULT_OK && ::presenter.isInitialized) {
            presenter.refreshApps()
        }
    }
    private val homeRoleLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        waitingForLauncherSelection = false
        if (isCurrentDefaultLauncher()) {
            forceSettingsPanel = false
        }
        updateLauncherMode(forceAnimate = true)
        if (!isCurrentDefaultLauncher()) {
            Toast.makeText(this, R.string.launcher_default_not_selected, Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityIosLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.state = state
        forceSettingsPanel = shouldOpenSettingsPanel(intent)
        systemUiController = LauncherSystemUiController(this, binding)
        keyboardController = LauncherKeyboardController(this)
        visualEffectsController = LauncherVisualEffectsController(binding)
        removeAppController = LauncherRemoveAppController(
            activity = this,
            showError = { message -> showError(message) }
        )
        appOptionsController = LauncherAppOptionsController(
            activity = this,
            binding = binding,
            visualEffectsController = visualEffectsController,
            onAppInfoClicked = { item -> presenter.onAppInfoOptionClicked(item.app) },
            onHideClicked = { item -> presenter.onHideAppOptionClicked(item.app) },
            onEditHomeClicked = { setHomeEditing(true) },
            onDeleteClicked = { item -> showRemoveAppDialog(item.app) }
        )
        widgetSheetController = LauncherWidgetSheetController(
            activity = this,
            binding = binding,
            applySystemUi = { applyLauncherSystemUi() }
        )
        searchController = LauncherSearchController(
            activity = this,
            binding = binding,
            keyboardController = keyboardController,
            visualEffectsController = visualEffectsController,
            dismissAppOptions = { appOptionsController.dismiss() },
            clearPageIndicatorCallbacks = { indicatorHandler.removeCallbacks(hideIndicatorRunnable) },
            hideCategoryDetail = { hideCategoryDetail() },
            applySystemUi = { applyLauncherSystemUi() },
            onSearchAppClicked = { item -> presenter.onOpenAppOptionClicked(item.app) },
            onSearchAppLongClicked = { item, anchor ->
                hideSearchOverlay(clearQuery = false)
                showAnchoredAppOptions(item, anchor)
                true
            },
            onLibrarySearchAppClicked = { item -> presenter.onOpenAppOptionClicked(item.app) }
        )

        installBackHandling()
        installSystemInsetHandling()
        setupWorkspaceViews()
        presenter = IOSLauncherPresenter(
            RepositoryProvider.provideLauncherRepository(applicationContext)
        )
        binding.presenter = presenter
        binding.makeDefaultLauncherRow.root.setOnClickListener {
            presenter.onSetDefaultLauncherClicked()
        }
        presenter.attachView(this)
        updateLauncherMode()
        applyLauncherSystemUi()
        presenter.loadLauncherData()
    }

    override fun onResume() {
        super.onResume()
        updateLauncherMode()
        applyLauncherSystemUi()
        if (skipNextResumeReload) {
            skipNextResumeReload = false
        } else if (::presenter.isInitialized) {
            presenter.refreshApps()
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        when {
            isHomeIntent(intent) -> forceSettingsPanel = false
            shouldOpenSettingsPanel(intent) -> forceSettingsPanel = true
        }
        updateLauncherMode(forceAnimate = true)
        applyLauncherSystemUi()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            applyLauncherSystemUi()
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (::binding.isInitialized) {
            if (handleHomeEdgeExternalDragEvent(ev)) {
                return super.dispatchTouchEvent(ev)
            }
            if (handleFolderExitExternalDragEvent(ev)) {
                return super.dispatchTouchEvent(ev)
            }
            handleEmptyLongPressForEdit(ev)
            if (handlePullDownSearchGesture(ev)) {
                return true
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    private fun installBackHandling() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                when {
                    binding.workspace.widgetSheetOverlay.visibility == View.VISIBLE -> {
                        hideWidgetSheet()
                    }

                    binding.workspace.editWidgetPrompt.visibility == View.VISIBLE -> {
                        hideEditWidgetPrompt()
                    }

                    binding.workspace.folderOverlay.visibility == View.VISIBLE -> {
                        hideFolderOverlay()
                    }

                    editingHome -> {
                        setHomeEditing(false)
                    }

                    binding.workspace.librarySearchOverlay.visibility == View.VISIBLE -> {
                        hideLibrarySearchOverlay()
                    }

                    binding.workspace.categoryDetailOverlay.visibility == View.VISIBLE -> {
                        hideCategoryDetail()
                    }

                    binding.workspace.searchOverlay.visibility == View.VISIBLE -> {
                        hideSearchOverlay()
                    }

                    forceSettingsPanel && isCurrentDefaultLauncher() -> {
                        forceSettingsPanel = false
                        updateLauncherMode(forceAnimate = true)
                        applyLauncherSystemUi()
                    }

                    else -> {
                        isEnabled = false
                        onBackPressedDispatcher.onBackPressed()
                    }
                }
            }
        })
    }

    override fun onDestroy() {
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        emptyLongPressHandler.removeCallbacks(emptyLongPressRunnable)
        folderEdgeSwitchHandler.removeCallbacks(folderEdgeSwitchRunnable)
        homeEdgeSwitchHandler.removeCallbacks(homeEdgeSwitchRunnable)
        appOptionsController.dismiss()
        presenter.detachView()
        super.onDestroy()
    }

    override fun showLoading(isLoading: Boolean) {
        state.loading.set(isLoading)
    }

    override fun showLauncherApps(apps: List<LauncherIconUiModel>, folders: List<LauncherFolder>) {
        homeItems = LauncherHomeLayoutBuilder.build(apps, folders)
        state.appCount.set(apps.size)
        workspacePageAdapter.submitItems(homeItems)
        workspacePageAdapter.submitLibraryGroups(AppLibraryGroupBuilder.buildGroups(apps))
        dockAdapter.submitApps(apps.take(DOCK_APP_COUNT))
        widgetAppAdapter.submitApps(apps)
        searchController.submitApps(apps)
        updateOpenFolderContent()
        updateWorkspaceChromeForPage(binding.workspace.workspacePager.currentItem)
        updatePageIndicatorDots(binding.workspace.workspacePager.currentItem)
    }

    private fun handleHomeItemsChanged(
        items: List<LauncherHomeItemUiModel>,
        refreshWorkspace: Boolean = true
    ) {
        homeItems = items
        presenter.onHomeItemsChanged(items)
        if (refreshWorkspace) {
            workspacePageAdapter.submitItems(homeItems)
        }
        updateOpenFolderContent()
        updateWorkspaceChromeForPage(binding.workspace.workspacePager.currentItem)
        updatePageIndicatorDots(binding.workspace.workspacePager.currentItem)
    }

    private fun handleHomePageDragMoved(
        item: LauncherHomeItemUiModel?,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ): Boolean {
        if (homeEdgeCommitted) return true
        if (!editingHome) return false
        val draggedApp = (item as? LauncherHomeItemUiModel.App)?.iconItem ?: return false
        val rootLocation = IntArray(2)
        binding.workspace.root.getLocationOnScreen(rootLocation)
        val rootWidth = binding.workspace.root.width.takeIf { it > 0 } ?: resources.displayMetrics.widthPixels
        val rootCenterX = centerXOnScreen - rootLocation[0]
        val inEdgeZone = rootCenterX <= dp(HOME_EDGE_SWITCH_ZONE_DP) ||
            rootCenterX >= rootWidth - dp(HOME_EDGE_SWITCH_ZONE_DP)
        if (!homeEdgeDragActive && !inEdgeZone) return false

        beginHomeEdgeDragIfNeeded(draggedApp)
        updateHomeEdgeDragPosition(centerXOnScreen, centerYOnScreen)
        return true
    }

    private fun handleHomePageDragEnded(
        item: LauncherHomeItemUiModel?,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ): Boolean {
        if (!homeEdgeDragActive) return false
        if (homeEdgeCommitted) return true

        updateHomeEdgeDragPosition(centerXOnScreen, centerYOnScreen)
        return true
    }

    private fun finishHomeEdgeDrag(commit: Boolean) {
        if (!homeEdgeDragActive || homeEdgeCommitted) return

        if (!commit) {
            hideHomeEdgeDragPreview(restoreWorkspace = true)
            return
        }
        homeEdgeCommitted = true

        val draggedApp = homeEdgeDraggedApp
            ?: return hideHomeEdgeDragPreview(restoreWorkspace = true)
        val folderTargetIndex = homeEdgeFolderDropIndex()
        val updatedItems = if (folderTargetIndex != NO_PREVIEW_INDEX) {
            addAppToHomeFolderAtIndex(
                baseItems = homeEdgeBaseItems,
                folderIndex = folderTargetIndex,
                app = draggedApp
            )
        } else {
            val dropIndex = if (homeEdgePreviewIndex != NO_PREVIEW_INDEX) {
                homeEdgePreviewIndex
            } else {
                homeEdgeHomeDropIndex()
            }
            insertItemAtHomeIndex(
                baseItems = homeEdgeBaseItems,
                index = dropIndex,
                item = LauncherHomeItemUiModel.App(draggedApp)
            )
        }

        homeEdgeSwitchHandler.removeCallbacks(homeEdgeSwitchRunnable)
        hideFolderEdgeGlows()
        binding.workspace.workspacePager.postDelayed(
            {
                hideHomeEdgeDragPreview(restoreWorkspace = false)
                handleHomeItemsChanged(updatedItems)
            },
            HOME_EDGE_DROP_COMMIT_DELAY_MS
        )
    }

    private fun beginHomeEdgeDragIfNeeded(draggedApp: LauncherIconUiModel) {
        if (homeEdgeDraggedApp != null) return

        homeEdgeDraggedApp = draggedApp
        homeEdgeCommitted = false
        homeEdgeBaseItems = homeItems.filterNot { item ->
            item is LauncherHomeItemUiModel.App && item.iconItem.app.iconKey == draggedApp.app.iconKey
        }
        homeEdgeDragPage = binding.workspace.workspacePager.currentItem.coerceAtMost(
            maxOf(0, homePageCountForItemCount(homeEdgeBaseItems.size + 1) - 1)
        )
        homeEdgePreviewIndex = NO_PREVIEW_INDEX
        binding.workspace.workspacePager.isUserInputEnabled = false
        binding.workspace.selectedIconImage.setImageDrawable(draggedApp.icon)
        binding.workspace.selectedIconLabel.text = draggedApp.label
        binding.workspace.selectedIconPreview.apply {
            animate().cancel()
            alpha = 1f
            scaleX = 1.08f
            scaleY = 1.08f
            elevation = dp(DRAG_PREVIEW_ELEVATION_DP).toFloat()
            translationZ = dp(DRAG_PREVIEW_ELEVATION_DP).toFloat()
            visibility = View.VISIBLE
        }
        homeEdgeDragActive = true
    }

    private fun handleHomeEdgeExternalDragEvent(event: MotionEvent): Boolean {
        if (!homeEdgeDragActive) return false

        if (homeEdgeCommitted) return true

        when (event.actionMasked) {
            MotionEvent.ACTION_MOVE -> updateHomeEdgeDragPosition(event.rawX, event.rawY)

            MotionEvent.ACTION_UP -> {
                updateHomeEdgeDragPosition(event.rawX, event.rawY)
                finishHomeEdgeDrag(commit = true)
            }

            MotionEvent.ACTION_CANCEL -> {
                updateHomeEdgeDragPosition(event.rawX, event.rawY)
                finishHomeEdgeDrag(commit = false)
            }
        }
        return true
    }

    private fun updateHomeEdgeDragPosition(centerXOnScreen: Float, centerYOnScreen: Float) {
        if (homeEdgeDraggedApp == null) return

        val rootLocation = IntArray(2)
        binding.workspace.root.getLocationOnScreen(rootLocation)
        val previewWidth = binding.workspace.selectedIconPreview.width.takeIf { it > 0 } ?: dp(DRAG_PREVIEW_WIDTH_DP)
        val previewHeight = binding.workspace.selectedIconPreview.height.takeIf { it > 0 } ?: dp(DRAG_PREVIEW_HEIGHT_DP)
        val rootWidth = binding.workspace.root.width.takeIf { it > 0 } ?: resources.displayMetrics.widthPixels
        val rootHeight = binding.workspace.root.height.takeIf { it > 0 } ?: resources.displayMetrics.heightPixels
        val rootCenterX = (centerXOnScreen - rootLocation[0]).coerceIn(0f, rootWidth.toFloat())
        val rootCenterY = (centerYOnScreen - rootLocation[1]).coerceIn(0f, rootHeight.toFloat())
        val left = (rootCenterX - previewWidth / 2f)
            .toInt()
            .coerceIn(dp(4), rootWidth - previewWidth - dp(4))
        val top = (rootCenterY - dp(DRAG_PREVIEW_ICON_CENTER_Y_DP))
            .toInt()
            .coerceIn(dp(12), rootHeight - previewHeight - dp(12))

        homeEdgeDragCenterX = rootCenterX
        homeEdgeDragCenterY = rootCenterY
        binding.workspace.selectedIconPreview.layoutParams =
            (binding.workspace.selectedIconPreview.layoutParams as android.widget.FrameLayout.LayoutParams).apply {
                leftMargin = left
                topMargin = top
            }
        updateHomeEdgeState(rootCenterX, rootWidth)
        updateHomeEdgePreview()
    }

    private fun updateHomeEdgePreview() {
        if (!homeEdgeDragActive || homeEdgeDraggedApp == null) return

        val insertIndex = homeEdgeHomeDropIndex()
        val folderTargetIndex = homeEdgeFolderDropIndex()
        if (insertIndex == homeEdgePreviewIndex && folderTargetIndex == homeEdgeFolderTargetIndex) return

        homeEdgePreviewIndex = insertIndex
        homeEdgeFolderTargetIndex = folderTargetIndex
        val draggedApp = homeEdgeDraggedApp ?: return
        val previewItems = if (folderTargetIndex != NO_PREVIEW_INDEX) {
            addAppToHomeFolderAtIndex(
                baseItems = homeEdgeBaseItems,
                folderIndex = folderTargetIndex,
                app = draggedApp
            )
        } else {
            insertItemAtHomeIndex(
                baseItems = homeEdgeBaseItems,
                index = insertIndex,
                item = LauncherHomeItemUiModel.Placeholder()
            )
        }
        workspacePageAdapter.submitDragPreviewItems(
            items = previewItems,
            focusPage = homeEdgeDragPage
        )
    }

    private fun updateHomeEdgeState(rootCenterX: Float, rootWidth: Int) {
        val edgeZone = dp(HOME_EDGE_SWITCH_ZONE_DP)
        val direction = when {
            rootCenterX <= edgeZone -> -1
            rootCenterX >= rootWidth - edgeZone -> 1
            else -> 0
        }

        binding.workspace.folderDragLeftEdgeGlow.visibility = if (direction < 0) View.VISIBLE else View.GONE
        binding.workspace.folderDragRightEdgeGlow.visibility = if (direction > 0) View.VISIBLE else View.GONE

        if (direction == 0) {
            homeEdgeSwitchHandler.removeCallbacks(homeEdgeSwitchRunnable)
            homeEdgeDirection = 0
            return
        }
        if (direction == homeEdgeDirection) return

        homeEdgeSwitchHandler.removeCallbacks(homeEdgeSwitchRunnable)
        homeEdgeDirection = direction
        homeEdgeSwitchHandler.postDelayed(homeEdgeSwitchRunnable, HOME_EDGE_SWITCH_DELAY_MS)
    }

    private fun performHomeEdgeSwitch() {
        val direction = homeEdgeDirection
        if (!homeEdgeDragActive || direction == 0) return

        var baseChanged = false
        if (direction < 0 && homeEdgeDragPage == 0) {
            homeEdgeBaseItems = List(HOME_PAGE_SIZE) { LauncherHomeItemUiModel.Placeholder() } + homeEdgeBaseItems
            homeEdgeDragPage = 0
            baseChanged = true
        } else {
            val targetPage = maxOf(0, homeEdgeDragPage + direction)
            if (targetPage >= homePageCountForItemCount(homeEdgeBaseItems.size + 1)) {
                homeEdgeBaseItems = ensurePageExists(homeEdgeBaseItems, targetPage)
                baseChanged = true
            }
            homeEdgeDragPage = targetPage
        }
        homeEdgePreviewIndex = NO_PREVIEW_INDEX
        homeEdgeFolderTargetIndex = NO_PREVIEW_INDEX
        val animated = binding.workspace.workspacePager.currentItem != homeEdgeDragPage
        if (baseChanged) {
            workspacePageAdapter.submitItems(homeEdgeBaseItems)
        }
        binding.workspace.workspacePager.postDelayed({
            if (homeEdgeDragActive) {
                binding.workspace.workspacePager.setCurrentItem(homeEdgeDragPage, animated)
                binding.workspace.workspacePager.post {
                    updateHomeEdgePreview()
                }
            }
        }, if (baseChanged) HOME_EDGE_NEW_PAGE_SWITCH_START_DELAY_MS else HOME_EDGE_SWITCH_START_DELAY_MS)
        showPageIndicator(homeEdgeDragPage)
        homeEdgeDirection = 0
    }

    private fun ensurePageExists(
        items: List<LauncherHomeItemUiModel>,
        page: Int
    ): List<LauncherHomeItemUiModel> {
        val requiredSize = page * HOME_PAGE_SIZE + 1
        if (items.size >= requiredSize) return items

        return items.toMutableList().apply {
            while (size < requiredSize) {
                add(LauncherHomeItemUiModel.Placeholder())
            }
        }
    }

    private fun homeEdgeHomeDropIndex(): Int {
        val pager = binding.workspace.workspacePager
        val pagerWidth = pager.width.takeIf { it > 0 } ?: return homeEdgeBaseItems.size
        val pagerHeight = pager.height.takeIf { it > 0 } ?: return homeEdgeBaseItems.size
        val rootLocation = IntArray(2)
        val pagerLocation = IntArray(2)
        binding.workspace.root.getLocationOnScreen(rootLocation)
        pager.getLocationOnScreen(pagerLocation)

        val pagerLeftInRoot = pagerLocation[0] - rootLocation[0]
        val pagerTopInRoot = pagerLocation[1] - rootLocation[1]
        val localX = (homeEdgeDragCenterX - pagerLeftInRoot).coerceIn(0f, (pagerWidth - 1).toFloat())
        val localY = (homeEdgeDragCenterY - pagerTopInRoot).coerceIn(0f, (pagerHeight - 1).toFloat())
        val cellWidth = pagerWidth / HOME_PAGE_COLUMNS.toFloat()
        val cellHeight = pagerHeight / HOME_PAGE_ROWS.toFloat()
        val column = (localX / cellWidth).toInt().coerceIn(0, HOME_PAGE_COLUMNS - 1)
        val row = (localY / cellHeight).toInt().coerceIn(0, HOME_PAGE_ROWS - 1)
        val insertAfterTarget = localX - column * cellWidth > cellWidth / 2f
        return homeEdgeDragPage * HOME_PAGE_SIZE +
            row * HOME_PAGE_COLUMNS +
            column +
            if (insertAfterTarget) 1 else 0
    }

    private fun homeEdgeFolderDropIndex(): Int {
        val target = homeEdgeTargetCell() ?: return NO_PREVIEW_INDEX
        val item = homeEdgeBaseItems.getOrNull(target.index) ?: return NO_PREVIEW_INDEX
        if (item !is LauncherHomeItemUiModel.Folder) return NO_PREVIEW_INDEX
        val overFolderCenter = target.localXInCell in HOME_FOLDER_DROP_MIN_X..HOME_FOLDER_DROP_MAX_X &&
            target.localYInCell in HOME_FOLDER_DROP_MIN_Y..HOME_FOLDER_DROP_MAX_Y
        return if (overFolderCenter) target.index else NO_PREVIEW_INDEX
    }

    private fun homeEdgeTargetCell(): HomeEdgeTargetCell? {
        val pager = binding.workspace.workspacePager
        val pagerWidth = pager.width.takeIf { it > 0 } ?: return null
        val pagerHeight = pager.height.takeIf { it > 0 } ?: return null
        val rootLocation = IntArray(2)
        val pagerLocation = IntArray(2)
        binding.workspace.root.getLocationOnScreen(rootLocation)
        pager.getLocationOnScreen(pagerLocation)

        val pagerLeftInRoot = pagerLocation[0] - rootLocation[0]
        val pagerTopInRoot = pagerLocation[1] - rootLocation[1]
        val localX = (homeEdgeDragCenterX - pagerLeftInRoot).coerceIn(0f, (pagerWidth - 1).toFloat())
        val localY = (homeEdgeDragCenterY - pagerTopInRoot).coerceIn(0f, (pagerHeight - 1).toFloat())
        val cellWidth = pagerWidth / HOME_PAGE_COLUMNS.toFloat()
        val cellHeight = pagerHeight / HOME_PAGE_ROWS.toFloat()
        val column = (localX / cellWidth).toInt().coerceIn(0, HOME_PAGE_COLUMNS - 1)
        val row = (localY / cellHeight).toInt().coerceIn(0, HOME_PAGE_ROWS - 1)
        val localXInCell = ((localX - column * cellWidth) / cellWidth).coerceIn(0f, 1f)
        val localYInCell = ((localY - row * cellHeight) / cellHeight).coerceIn(0f, 1f)
        return HomeEdgeTargetCell(
            index = homeEdgeDragPage * HOME_PAGE_SIZE + row * HOME_PAGE_COLUMNS + column,
            localXInCell = localXInCell,
            localYInCell = localYInCell
        )
    }

    private fun addAppToHomeFolderAtIndex(
        baseItems: List<LauncherHomeItemUiModel>,
        folderIndex: Int,
        app: LauncherIconUiModel
    ): List<LauncherHomeItemUiModel> {
        return baseItems.toMutableList().apply {
            val folder = getOrNull(folderIndex) as? LauncherHomeItemUiModel.Folder ?: return baseItems
            if (folder.apps.any { item -> item.app.iconKey == app.app.iconKey }) return baseItems
            this[folderIndex] = folder.copy(apps = folder.apps + app)
        }
    }

    private fun insertItemAtHomeIndex(
        baseItems: List<LauncherHomeItemUiModel>,
        index: Int,
        item: LauncherHomeItemUiModel
    ): List<LauncherHomeItemUiModel> {
        val targetIndex = index.coerceAtLeast(0)
        return baseItems.toMutableList().apply {
            while (size < targetIndex) {
                add(LauncherHomeItemUiModel.Placeholder())
            }
            add(targetIndex.coerceAtMost(size), item)
        }
    }

    private fun hideHomeEdgeDragPreview(restoreWorkspace: Boolean) {
        if (restoreWorkspace) {
            workspacePageAdapter.submitItems(homeItems)
            updateWorkspaceChromeForPage(binding.workspace.workspacePager.currentItem)
            updatePageIndicatorDots(binding.workspace.workspacePager.currentItem)
        }
        homeEdgeDragActive = false
        homeEdgeDraggedApp = null
        homeEdgeBaseItems = emptyList()
        homeEdgePreviewIndex = NO_PREVIEW_INDEX
        homeEdgeFolderTargetIndex = NO_PREVIEW_INDEX
        homeEdgeDirection = 0
        homeEdgeCommitted = false
        homeEdgeSwitchHandler.removeCallbacks(homeEdgeSwitchRunnable)
        hideFolderEdgeGlows()
        binding.workspace.workspacePager.isUserInputEnabled = true
        binding.workspace.selectedIconPreview.animate().cancel()
        binding.workspace.selectedIconPreview.apply {
            visibility = View.GONE
            alpha = 1f
            scaleX = 1f
            scaleY = 1f
            translationZ = 0f
        }
    }

    private fun showFolderOverlay(folder: LauncherHomeItemUiModel.Folder) {
        folderController.show(folder)
    }

    private fun hideFolderOverlay(restoreFolderExitPreview: Boolean = true) {
        hideFolderExitDragPreview(restoreWorkspace = restoreFolderExitPreview)
        resetFolderExitDragVisuals()
        folderController.hide()
    }

    private fun updateOpenFolderContent() {
        folderController.updateContent(homeItems)
    }

    private fun handleOpenFolderItemsChanged(items: List<LauncherHomeItemUiModel>) {
        val folderId = folderController.currentFolderId() ?: return
        val reorderedApps = LauncherHomeLayoutBuilder.flattenApps(items)
        val updatedItems = homeItems.flatMap { item ->
            if (item is LauncherHomeItemUiModel.Folder && item.id == folderId) {
                LauncherHomeLayoutBuilder.normalize(listOf(item.copy(apps = reorderedApps)))
            } else {
                listOf(item)
            }
        }
        handleHomeItemsChanged(updatedItems)
    }

    private fun handleFolderItemDroppedOutside(item: LauncherHomeItemUiModel): Boolean {
        val draggedApp = folderExitDraggedApp
            ?: (item as? LauncherHomeItemUiModel.App)?.iconItem
            ?: return false
        val baseItems = folderExitBaseHomeItems.ifEmpty {
            removeAppFromOpenFolder(draggedApp)
        }
        val dropIndex = if (folderExitPreviewIndex != NO_PREVIEW_INDEX) {
            folderExitPreviewIndex
        } else {
            folderExitHomeDropIndex(baseItems.size)
        }
        val updatedItems = baseItems.toMutableList().apply {
            add(
                dropIndex.coerceIn(0, size),
                LauncherHomeItemUiModel.App(draggedApp)
            )
        }

        hideFolderExitDragPreview(restoreWorkspace = false)
        handleHomeItemsChanged(updatedItems)
        hideFolderOverlay(restoreFolderExitPreview = false)
        return true
    }

    private fun isFolderDragCenterOutsidePanel(centerXOnScreen: Float, centerYOnScreen: Float): Boolean {
        val panelLocation = IntArray(2)
        binding.workspace.folderContentPanel.getLocationOnScreen(panelLocation)

        val panelLeft = panelLocation[0] - dp(FOLDER_EXIT_SLOP_DP)
        val panelTop = panelLocation[1] - dp(FOLDER_EXIT_SLOP_DP)
        val panelRight = panelLocation[0] + binding.workspace.folderContentPanel.width + dp(FOLDER_EXIT_SLOP_DP)
        val panelBottom = panelLocation[1] + binding.workspace.folderContentPanel.height + dp(FOLDER_EXIT_SLOP_DP)
        return centerXOnScreen < panelLeft ||
            centerXOnScreen > panelRight ||
            centerYOnScreen < panelTop ||
            centerYOnScreen > panelBottom
    }

    private fun handleFolderDragOutsideChanged(
        item: LauncherHomeItemUiModel?,
        outside: Boolean,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ) {
        if (outside) {
            showFolderExitDragPreview(item, centerXOnScreen, centerYOnScreen)
        } else {
            hideFolderExitDragPreview(restoreWorkspace = true)
            restoreOpenFolderAfterExitDrag()
        }
    }

    private fun showFolderExitDragPreview(
        item: LauncherHomeItemUiModel?,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ) {
        val draggedApp = (item as? LauncherHomeItemUiModel.App)?.iconItem ?: return
        beginFolderExitDragIfNeeded(draggedApp)

        collapseOpenFolderForExitDrag()
        binding.workspace.selectedIconPreview.apply {
            animate().cancel()
            alpha = 1f
            scaleX = 1.08f
            scaleY = 1.08f
            elevation = dp(DRAG_PREVIEW_ELEVATION_DP).toFloat()
            translationZ = dp(DRAG_PREVIEW_ELEVATION_DP).toFloat()
            visibility = View.VISIBLE
        }
        updateFolderExitDragPosition(centerXOnScreen, centerYOnScreen)
    }

    private fun hideFolderExitDragPreview(restoreWorkspace: Boolean = false) {
        if (restoreWorkspace && folderExitBaseHomeItems.isNotEmpty()) {
            workspacePageAdapter.submitItems(homeItems)
            updateWorkspaceChromeForPage(binding.workspace.workspacePager.currentItem)
            updatePageIndicatorDots(binding.workspace.workspacePager.currentItem)
        }
        folderExitDragActive = false
        folderExitDraggedApp = null
        folderExitBaseHomeItems = emptyList()
        folderExitPreviewIndex = NO_PREVIEW_INDEX
        folderExitEdgeDirection = 0
        folderEdgeSwitchHandler.removeCallbacks(folderEdgeSwitchRunnable)
        hideFolderEdgeGlows()
        binding.workspace.workspacePager.isUserInputEnabled = true
        binding.workspace.selectedIconPreview.animate().cancel()
        binding.workspace.selectedIconPreview.apply {
            visibility = View.GONE
            alpha = 1f
            scaleX = 1f
            scaleY = 1f
            translationZ = 0f
        }
    }

    private fun beginFolderExitDragIfNeeded(draggedApp: LauncherIconUiModel) {
        if (folderExitDraggedApp != null) return

        folderExitDraggedApp = draggedApp
        folderExitBaseHomeItems = removeAppFromOpenFolder(draggedApp)
        folderExitDragPage = binding.workspace.workspacePager.currentItem.coerceIn(
            0,
            homePageCountForItemCount(folderExitBaseHomeItems.size + 1) - 1
        )
        folderExitPreviewIndex = NO_PREVIEW_INDEX
        binding.workspace.workspacePager.isUserInputEnabled = false
    }

    private fun removeAppFromOpenFolder(draggedApp: LauncherIconUiModel): List<LauncherHomeItemUiModel> {
        val folderId = folderController.currentFolderId() ?: return homeItems
        return homeItems.flatMap { homeItem ->
            if (homeItem is LauncherHomeItemUiModel.Folder && homeItem.id == folderId) {
                val remainingApps = homeItem.apps.filterNot { app ->
                    app.app.iconKey == draggedApp.app.iconKey
                }
                LauncherHomeLayoutBuilder.normalize(listOf(homeItem.copy(apps = remainingApps)))
            } else {
                listOf(homeItem)
            }
        }
    }

    private fun handleFolderExitExternalDragEvent(event: MotionEvent): Boolean {
        if (!folderExitDragActive) return false

        when (event.actionMasked) {
            MotionEvent.ACTION_MOVE -> updateFolderExitDragPosition(event.rawX, event.rawY)

            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> {
                updateFolderExitDragPosition(event.rawX, event.rawY)
                folderEdgeSwitchHandler.removeCallbacks(folderEdgeSwitchRunnable)
                hideFolderEdgeGlows()
                folderExitEdgeDirection = 0
            }
        }
        return true
    }

    private fun updateFolderExitDragPosition(centerXOnScreen: Float, centerYOnScreen: Float) {
        if (folderExitDraggedApp == null) return

        val rootLocation = IntArray(2)
        binding.workspace.root.getLocationOnScreen(rootLocation)
        val previewWidth = binding.workspace.selectedIconPreview.width.takeIf { it > 0 } ?: dp(DRAG_PREVIEW_WIDTH_DP)
        val previewHeight = binding.workspace.selectedIconPreview.height.takeIf { it > 0 } ?: dp(DRAG_PREVIEW_HEIGHT_DP)
        val rootWidth = binding.workspace.root.width.takeIf { it > 0 } ?: resources.displayMetrics.widthPixels
        val rootHeight = binding.workspace.root.height.takeIf { it > 0 } ?: resources.displayMetrics.heightPixels
        val rootCenterX = (centerXOnScreen - rootLocation[0]).coerceIn(0f, rootWidth.toFloat())
        val rootCenterY = (centerYOnScreen - rootLocation[1]).coerceIn(0f, rootHeight.toFloat())
        val left = (rootCenterX - previewWidth / 2f)
            .toInt()
            .coerceIn(dp(4), rootWidth - previewWidth - dp(4))
        val top = (rootCenterY - dp(DRAG_PREVIEW_ICON_CENTER_Y_DP))
            .toInt()
            .coerceIn(dp(12), rootHeight - previewHeight - dp(12))

        folderExitDragCenterX = rootCenterX
        folderExitDragCenterY = rootCenterY
        binding.workspace.selectedIconPreview.layoutParams =
            (binding.workspace.selectedIconPreview.layoutParams as android.widget.FrameLayout.LayoutParams).apply {
                leftMargin = left
                topMargin = top
            }
        updateFolderExitEdgeState(rootCenterX, rootWidth)
        updateFolderExitHomePreview()
    }

    private fun updateFolderExitHomePreview() {
        val baseItems = folderExitBaseHomeItems
        if (baseItems.isEmpty() || folderExitDraggedApp == null) return

        val insertIndex = folderExitHomeDropIndex(baseItems.size).coerceIn(0, baseItems.size)
        if (insertIndex == folderExitPreviewIndex) return

        folderExitPreviewIndex = insertIndex
        val previewItems = baseItems.toMutableList().apply {
            add(insertIndex, LauncherHomeItemUiModel.Placeholder())
        }
        workspacePageAdapter.submitItems(previewItems)
        updateWorkspaceChromeForPage(folderExitDragPage)
        updatePageIndicatorDots(folderExitDragPage)
    }

    private fun updateFolderExitEdgeState(rootCenterX: Float, rootWidth: Int) {
        val edgeZone = dp(FOLDER_EDGE_SWITCH_ZONE_DP)
        val direction = when {
            rootCenterX <= edgeZone -> -1
            rootCenterX >= rootWidth - edgeZone -> 1
            else -> 0
        }

        binding.workspace.folderDragLeftEdgeGlow.visibility = if (direction < 0) View.VISIBLE else View.GONE
        binding.workspace.folderDragRightEdgeGlow.visibility = if (direction > 0) View.VISIBLE else View.GONE

        if (direction == 0 || !canSwitchFolderExitPage(direction)) {
            folderEdgeSwitchHandler.removeCallbacks(folderEdgeSwitchRunnable)
            folderExitEdgeDirection = 0
            return
        }
        if (direction == folderExitEdgeDirection) return

        folderEdgeSwitchHandler.removeCallbacks(folderEdgeSwitchRunnable)
        folderExitEdgeDirection = direction
        folderEdgeSwitchHandler.postDelayed(folderEdgeSwitchRunnable, FOLDER_EDGE_SWITCH_DELAY_MS)
    }

    private fun performFolderExitEdgeSwitch() {
        val direction = folderExitEdgeDirection
        if (direction == 0 || !canSwitchFolderExitPage(direction)) return

        folderExitDragPage = (folderExitDragPage + direction).coerceIn(
            0,
            homePageCountForItemCount(folderExitBaseHomeItems.size + 1) - 1
        )
        folderExitPreviewIndex = NO_PREVIEW_INDEX
        binding.workspace.workspacePager.setCurrentItem(folderExitDragPage, true)
        showPageIndicator(folderExitDragPage)
        updateFolderExitHomePreview()
        folderExitEdgeDirection = 0
    }

    private fun canSwitchFolderExitPage(direction: Int): Boolean {
        val targetPage = folderExitDragPage + direction
        return targetPage in 0 until homePageCountForItemCount(folderExitBaseHomeItems.size + 1)
    }

    private fun hideFolderEdgeGlows() {
        binding.workspace.folderDragLeftEdgeGlow.visibility = View.GONE
        binding.workspace.folderDragRightEdgeGlow.visibility = View.GONE
    }

    private fun collapseOpenFolderForExitDrag() {
        if (folderExitDragCollapsed) return

        folderExitDragCollapsed = true
        binding.workspace.folderOverlay.setBackgroundColor(Color.TRANSPARENT)
        visualEffectsController.clearHomeBlur()
        binding.workspace.folderContentPanel.animate().cancel()
        binding.workspace.folderContentPanel.animate()
            .alpha(0f)
            .scaleX(0.16f)
            .scaleY(0.16f)
            .setDuration(160L)
            .setInterpolator(DecelerateInterpolator())
            .start()
        binding.workspace.folderTitle.animate().cancel()
        binding.workspace.folderTitle.animate()
            .alpha(0f)
            .translationY(dp(10).toFloat())
            .setDuration(120L)
            .start()
    }

    private fun restoreOpenFolderAfterExitDrag() {
        if (!folderExitDragCollapsed) return

        folderExitDragCollapsed = false
        binding.workspace.folderOverlay.setBackgroundColor(FOLDER_OVERLAY_DIM_COLOR)
        visualEffectsController.applyHomeBlur()
        binding.workspace.folderContentPanel.animate().cancel()
        binding.workspace.folderContentPanel.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(150L)
            .setInterpolator(DecelerateInterpolator())
            .start()
        binding.workspace.folderTitle.animate().cancel()
        binding.workspace.folderTitle.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(140L)
            .start()
    }

    private fun resetFolderExitDragVisuals() {
        folderExitDragActive = false
        folderExitDragCollapsed = false
        folderExitEdgeDirection = 0
        folderEdgeSwitchHandler.removeCallbacks(folderEdgeSwitchRunnable)
        hideFolderEdgeGlows()
        binding.workspace.workspacePager.isUserInputEnabled = true
        binding.workspace.folderOverlay.setBackgroundColor(FOLDER_OVERLAY_DIM_COLOR)
    }

    private fun folderExitHomeDropIndex(itemCountAfterRemoval: Int): Int {
        if (!folderExitDragActive) return itemCountAfterRemoval

        val pager = binding.workspace.workspacePager
        val pagerWidth = pager.width.takeIf { it > 0 } ?: return itemCountAfterRemoval
        val pagerHeight = pager.height.takeIf { it > 0 } ?: return itemCountAfterRemoval
        val rootLocation = IntArray(2)
        val pagerLocation = IntArray(2)
        binding.workspace.root.getLocationOnScreen(rootLocation)
        pager.getLocationOnScreen(pagerLocation)

        val pagerLeftInRoot = pagerLocation[0] - rootLocation[0]
        val pagerTopInRoot = pagerLocation[1] - rootLocation[1]
        val localX = (folderExitDragCenterX - pagerLeftInRoot).coerceIn(0f, (pagerWidth - 1).toFloat())
        val localY = (folderExitDragCenterY - pagerTopInRoot).coerceIn(0f, (pagerHeight - 1).toFloat())
        val cellWidth = pagerWidth / HOME_PAGE_COLUMNS.toFloat()
        val cellHeight = pagerHeight / HOME_PAGE_ROWS.toFloat()
        val column = (localX / cellWidth)
            .toInt()
            .coerceIn(0, HOME_PAGE_COLUMNS - 1)
        val row = (localY / cellHeight)
            .toInt()
            .coerceIn(0, HOME_PAGE_ROWS - 1)
        val insertAfterTarget = localX - column * cellWidth > cellWidth / 2f
        val pageCount = homePageCountForItemCount(itemCountAfterRemoval + 1)
        val page = folderExitDragPage.coerceIn(0, pageCount - 1)
        val targetIndex = page * HOME_PAGE_SIZE + row * HOME_PAGE_COLUMNS + column
        return (targetIndex + if (insertAfterTarget) 1 else 0).coerceIn(0, itemCountAfterRemoval)
    }

    private fun homePageCountForItemCount(itemCount: Int): Int {
        return maxOf(1, (itemCount + HOME_PAGE_SIZE - 1) / HOME_PAGE_SIZE)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun openDefaultLauncherSelection() {
        if (isCurrentDefaultLauncher()) {
            forceSettingsPanel = false
            updateLauncherMode(forceAnimate = true)
            showAlreadyDefaultLauncher()
            return
        }

        Toast.makeText(this, R.string.launcher_default_opening, Toast.LENGTH_SHORT).show()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && requestHomeRole()) {
            return
        }

        openHomeSettings()
    }

    private fun openHomeSettings() {
        runCatching {
            startActivity(Intent(Settings.ACTION_HOME_SETTINGS))
        }.onFailure {
            runCatching {
                startActivity(Intent(Settings.ACTION_MANAGE_DEFAULT_APPS_SETTINGS))
            }.onFailure {
                showError(getString(R.string.launcher_default_prompt_failed))
            }
        }
    }

    override fun showAlreadyDefaultLauncher() {
        Toast.makeText(this, R.string.launcher_default_already, Toast.LENGTH_SHORT).show()
    }

    override fun openAppLibrarySettings() {
        appLibraryLauncher.launch(Intent(this, AppLibraryActivity::class.java))
    }

    override fun openApp(app: LauncherApp) {
        if (app.packageName == packageName) {
            showSettingsPanelFromLauncher()
            return
        }

        val launchIntent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
            component = ComponentName(app.packageName, app.className)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
        }

        runCatching { startActivity(launchIntent) }.onFailure {
            showError(getString(R.string.launcher_open_app_failed, app.label))
        }
    }

    private fun showSettingsPanelFromLauncher() {
        appOptionsController.dismiss()
        forceSettingsPanel = true
        if (editingHome) {
            setHomeEditing(false)
        }
        hideEditWidgetPrompt()
        hideWidgetSheet()
        hideFolderOverlay()
        hideCategoryDetail()
        hideLibrarySearchOverlay()
        hideSearchOverlay()
        updateLauncherMode()
        applyLauncherSystemUi()
    }

    private fun installSystemInsetHandling() {
        systemUiController.installInsetHandling()
    }

    private fun setupWorkspaceViews() {
        workspacePageAdapter = LauncherPageAdapter(
            onIconClicked = { item -> presenter.onOpenAppOptionClicked(item.app) },
            onIconLongClicked = { item, anchor ->
                if (!editingHome) {
                    showAnchoredAppOptions(item, anchor)
                }
                true
            },
            onRemoveClicked = { item -> showRemoveAppDialog(item.app) },
            onFolderClicked = { folder -> showFolderOverlay(folder) },
            onHomeItemsChanged = { items -> handleHomeItemsChanged(items, refreshWorkspace = false) },
            onHomeDragMoved = { item, _, centerX, centerY ->
                handleHomePageDragMoved(item, centerX, centerY)
            },
            onHomeDragEnded = { item, _, centerX, centerY ->
                handleHomePageDragEnded(item, centerX, centerY)
            },
            onLibrarySearchClicked = { showLibrarySearchOverlay() },
            onLibraryGroupClicked = { group -> showCategoryDetail(group) }
        )
        dockAdapter = LauncherDockAdapter(
            onIconClicked = { item -> presenter.onOpenAppOptionClicked(item.app) },
            onRemoveClicked = { item -> showRemoveAppDialog(item.app) }
        )
        categoryDetailAdapter = LauncherIconAdapter(
            onIconClicked = { item -> presenter.onOpenAppOptionClicked(item.app) },
            onIconLongClicked = { item, anchor ->
                hideCategoryDetail()
                showAnchoredAppOptions(item, anchor)
                true
            }
        )
        categoryDetailController = LauncherCategoryDetailController(
            activity = this,
            binding = binding,
            categoryDetailAdapter = categoryDetailAdapter,
            keyboardController = keyboardController,
            dismissAppOptions = { appOptionsController.dismiss() },
            clearPageIndicatorCallbacks = { indicatorHandler.removeCallbacks(hideIndicatorRunnable) },
            applySystemUi = { applyLauncherSystemUi() }
        )
        folderContentAdapter = LauncherIconAdapter(
            onIconClicked = { item -> presenter.onOpenAppOptionClicked(item.app) },
            onIconLongClicked = { item, anchor ->
                hideFolderOverlay()
                showAnchoredAppOptions(item, anchor)
                true
            },
            onRemoveClicked = { item -> showRemoveAppDialog(item.app) },
            onDragRequested = { holder ->
                if (::folderItemTouchHelper.isInitialized) {
                    folderItemTouchHelper.startDrag(holder)
                }
            },
            onOrderChanged = { items -> handleOpenFolderItemsChanged(items) }
        )
        folderController = LauncherFolderController(
            activity = this,
            binding = binding,
            folderContentAdapter = folderContentAdapter,
            visualEffectsController = visualEffectsController,
            dismissAppOptions = { appOptionsController.dismiss() },
            clearPageIndicatorCallbacks = { indicatorHandler.removeCallbacks(hideIndicatorRunnable) },
            isEditingHome = { editingHome },
            isCurrentPageLibrary = { isLibraryPage(binding.workspace.workspacePager.currentItem) }
        )
        widgetAppAdapter = WidgetAppAdapter()

        binding.workspace.workspacePager.apply {
            adapter = workspacePageAdapter
            offscreenPageLimit = 1
            clipChildren = false
            clipToPadding = false
            setPageTransformer(null)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    updateWorkspaceChromeForPage(position)
                    showPageIndicator(position)
                }
            })
        }
        searchController.install()
        binding.workspace.editOptionsButton.setOnClickListener {
            toggleEditWidgetPrompt()
        }
        binding.workspace.doneEditButton.setOnClickListener {
            setHomeEditing(false)
        }
        binding.workspace.editWidgetPrompt.setOnClickListener {
            hideEditWidgetPrompt()
            showWidgetSheet()
        }
        binding.workspace.widgetSheetOverlay.setOnClickListener {
            hideWidgetSheet()
        }
        binding.workspace.widgetSheet.setOnTouchListener { _, event ->
            handleWidgetSheetDrag(event)
        }
        binding.workspace.categoryDetailOverlay.setOnClickListener {
            hideCategoryDetail()
        }
        binding.workspace.categoryDetailContent.setOnClickListener {
            hideCategoryDetail()
        }
        binding.workspace.categoryDetailRecyclerView.setOnClickListener {
            hideCategoryDetail()
        }
        binding.workspace.contextOverlay.setOnClickListener {
            appOptionsController.dismiss()
        }

        binding.workspace.dockRecyclerView.apply {
            layoutManager = GridLayoutManager(this@IOSLauncherActivity, DOCK_APP_COUNT)
            adapter = dockAdapter
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator().apply {
                addDuration = 140L
                moveDuration = 160L
            }
        }
        binding.workspace.categoryDetailRecyclerView.apply {
            layoutManager = GridLayoutManager(this@IOSLauncherActivity, SEARCH_COLUMNS)
            adapter = categoryDetailAdapter
            itemAnimator = null
            setHasFixedSize(true)
            post {
                categoryDetailAdapter.setItemHeight(dp(SEARCH_ICON_CELL_HEIGHT_DP))
            }
        }
        binding.workspace.folderOverlay.setOnClickListener {
            hideFolderOverlay()
        }
        binding.workspace.folderContentPanel.setOnClickListener {
            // Keep outside-tap dismissal from firing when interacting with the folder contents.
        }
        binding.workspace.folderRecyclerView.apply {
            layoutManager = GridLayoutManager(this@IOSLauncherActivity, FOLDER_COLUMNS)
            adapter = folderContentAdapter
            itemAnimator = null
            folderItemTouchHelper = ItemTouchHelper(
                LauncherDragCallback(
                    adapter = folderContentAdapter,
                    allowFolderDrop = false,
                    reorderOnMove = true,
                    isDroppedOutside = { _, _, centerX, centerY ->
                        isFolderDragCenterOutsidePanel(centerX, centerY)
                    },
                    onDragOutsideChanged = { item, _, outside, centerX, centerY ->
                        handleFolderDragOutsideChanged(item, outside, centerX, centerY)
                    },
                    onDroppedOutside = { item -> handleFolderItemDroppedOutside(item) }
                )
            )
            folderItemTouchHelper.attachToRecyclerView(this)
            setHasFixedSize(true)
            post {
                folderContentAdapter.setItemHeight(dp(FOLDER_ICON_CELL_HEIGHT_DP))
            }
        }
        binding.workspace.widgetAppsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@IOSLauncherActivity)
            adapter = widgetAppAdapter
            itemAnimator = null
            overScrollMode = View.OVER_SCROLL_NEVER
            setHasFixedSize(true)
        }
    }

    private fun handleEmptyLongPressForEdit(event: MotionEvent) {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                emptyLongPressStartX = event.rawX
                emptyLongPressStartY = event.rawY
                emptyLongPressArmed = canStartEmptyLongPressEdit() &&
                    !isPointInsideLauncherIcon(event.rawX.toInt(), event.rawY.toInt())
                if (emptyLongPressArmed) {
                    emptyLongPressHandler.postDelayed(emptyLongPressRunnable, EMPTY_LONG_PRESS_MS)
                }
            }

            MotionEvent.ACTION_MOVE -> {
                if (!emptyLongPressArmed) return

                val dx = abs(event.rawX - emptyLongPressStartX)
                val dy = abs(event.rawY - emptyLongPressStartY)
                if (dx > dp(EMPTY_LONG_PRESS_SLOP_DP) || dy > dp(EMPTY_LONG_PRESS_SLOP_DP)) {
                    cancelEmptyLongPressEdit()
                }
            }

            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> cancelEmptyLongPressEdit()
        }
    }

    private fun canStartEmptyLongPressEdit(): Boolean {
        return state.launcherMode.get() &&
            !editingHome &&
            binding.workspace.searchOverlay.visibility != View.VISIBLE &&
            binding.workspace.librarySearchOverlay.visibility != View.VISIBLE &&
            binding.workspace.categoryDetailOverlay.visibility != View.VISIBLE &&
            binding.workspace.folderOverlay.visibility != View.VISIBLE &&
            binding.workspace.widgetSheetOverlay.visibility != View.VISIBLE &&
            binding.workspace.contextOverlay.visibility != View.VISIBLE &&
            !appOptionsController.isShowing() &&
            !isLibraryPage(binding.workspace.workspacePager.currentItem)
    }

    private fun cancelEmptyLongPressEdit() {
        emptyLongPressArmed = false
        emptyLongPressHandler.removeCallbacks(emptyLongPressRunnable)
    }

    private fun isPointInsideLauncherIcon(rawX: Int, rawY: Int): Boolean {
        return isPointInsideViewWithId(
            binding.workspace.root,
            rawX,
            rawY,
            setOf(R.id.iconPlate)
        )
    }

    private fun isPointInsideViewWithId(
        view: View,
        rawX: Int,
        rawY: Int,
        targetIds: Set<Int>
    ): Boolean {
        if (view.visibility != View.VISIBLE) return false

        val location = IntArray(2)
        view.getLocationOnScreen(location)
        val inside = rawX >= location[0] &&
            rawX <= location[0] + view.width &&
            rawY >= location[1] &&
            rawY <= location[1] + view.height
        if (!inside) return false
        if (view.id in targetIds) return true

        if (view is ViewGroup) {
            for (index in 0 until view.childCount) {
                if (isPointInsideViewWithId(view.getChildAt(index), rawX, rawY, targetIds)) {
                    return true
                }
            }
        }
        return false
    }

    private fun handlePullDownSearchGesture(event: MotionEvent): Boolean {
        if (!state.launcherMode.get()) return false
        if (editingHome) return false
        if (binding.workspace.widgetSheetOverlay.visibility == View.VISIBLE) return false
        if (binding.workspace.editWidgetPrompt.visibility == View.VISIBLE) return false
        if (binding.workspace.searchOverlay.visibility == View.VISIBLE) return false
        if (binding.workspace.librarySearchOverlay.visibility == View.VISIBLE) return false
        if (binding.workspace.categoryDetailOverlay.visibility == View.VISIBLE) return false
        if (binding.workspace.folderOverlay.visibility == View.VISIBLE) return false
        if (isLibraryPage(binding.workspace.workspacePager.currentItem)) return false
        if (binding.workspace.contextOverlay.visibility == View.VISIBLE || appOptionsController.isShowing()) return false

        return when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                pullDownStartX = event.rawX
                pullDownStartY = event.rawY
                pullDownGestureArmed = true
                false
            }

            MotionEvent.ACTION_MOVE -> {
                if (!pullDownGestureArmed) return false

                val dx = event.rawX - pullDownStartX
                val dy = event.rawY - pullDownStartY
                val verticalThreshold = dp(PULL_DOWN_SEARCH_THRESHOLD_DP)
                val horizontalEscape = dp(PULL_DOWN_HORIZONTAL_ESCAPE_DP)

                if (abs(dx) > horizontalEscape && abs(dx) > abs(dy) * 1.2f) {
                    pullDownGestureArmed = false
                    return false
                }
                if (dy < -dp(12)) {
                    pullDownGestureArmed = false
                    return false
                }
                if (dy > verticalThreshold && dy > abs(dx) * 1.35f) {
                    pullDownGestureArmed = false
                    showSearchOverlay()
                    return true
                }
                false
            }

            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> {
                pullDownGestureArmed = false
                false
            }

            else -> false
        }
    }

    private fun showPageIndicator(position: Int) {
        if (binding.workspace.searchOverlay.visibility == View.VISIBLE) return
        if (isLibraryPage(position)) {
            indicatorHandler.removeCallbacks(hideIndicatorRunnable)
            binding.workspace.pageIndicator.visibility = View.GONE
            return
        }

        updatePageIndicatorDots(position)
        if (workspacePageAdapter.itemCount <= 1) return

        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        binding.workspace.searchPill.animate().cancel()
        binding.workspace.searchPill.visibility = View.GONE
        binding.workspace.pageIndicator.apply {
            animate().cancel()
            alpha = 1f
            visibility = View.VISIBLE
        }
        if (!editingHome) {
            indicatorHandler.postDelayed(hideIndicatorRunnable, PAGE_INDICATOR_VISIBLE_MS)
        }
    }

    private fun hidePageIndicator() {
        if (binding.workspace.searchOverlay.visibility == View.VISIBLE) return
        if (editingHome) return

        binding.workspace.pageIndicator.animate()
            .alpha(0f)
            .setDuration(160L)
            .withEndAction {
                binding.workspace.pageIndicator.visibility = View.GONE
                binding.workspace.searchPill.apply {
                    alpha = 0f
                    visibility = View.VISIBLE
                    animate().alpha(1f).setDuration(160L).start()
                }
            }
            .start()
    }

    private fun updatePageIndicatorDots(selectedPosition: Int) {
        val pageCount = workspacePageAdapter.itemCount
        binding.workspace.pageIndicator.removeAllViews()
        if (pageCount <= 1) return

        repeat(pageCount) { index ->
            val selected = index == selectedPosition.coerceIn(0, pageCount - 1)
            val dotSize = if (selected) dp(8) else dp(6)
            val dot = View(this).apply {
                alpha = if (selected) 1f else 0.52f
                background = GradientDrawable().apply {
                    shape = GradientDrawable.OVAL
                    setColor(Color.WHITE)
                }
                layoutParams = android.widget.LinearLayout.LayoutParams(dotSize, dotSize).apply {
                    marginStart = dp(6)
                    marginEnd = dp(6)
                }
            }
            binding.workspace.pageIndicator.addView(dot)
        }
    }

    private fun updateWorkspaceChromeForPage(position: Int) {
        val libraryPage = isLibraryPage(position)
        binding.workspace.bottomControlSlot.visibility = if (libraryPage) View.GONE else View.VISIBLE
        binding.workspace.dockRecyclerView.visibility = if (libraryPage) View.GONE else View.VISIBLE
        if (libraryPage) {
            indicatorHandler.removeCallbacks(hideIndicatorRunnable)
            binding.workspace.pageIndicator.visibility = View.GONE
        } else if (editingHome) {
            binding.workspace.searchPill.visibility = View.GONE
            updatePageIndicatorDots(position)
            binding.workspace.pageIndicator.visibility = View.VISIBLE
        }
    }

    private fun isLibraryPage(position: Int): Boolean {
        return workspacePageAdapter.itemCount > 0 && position == workspacePageAdapter.itemCount - 1
    }

    private fun setHomeEditing(enabled: Boolean) {
        if (editingHome == enabled) return

        editingHome = enabled
        appOptionsController.dismiss()
        workspacePageAdapter.setEditing(enabled)
        dockAdapter.setEditing(enabled)
        if (::folderController.isInitialized) {
            folderController.setEditing(enabled)
        }

        if (enabled) {
            hideSearchOverlay()
            hideLibrarySearchOverlay()
            hideCategoryDetail()
            binding.workspace.editTopBar.apply {
                animate().cancel()
                alpha = 0f
                translationY = -dp(12).toFloat()
                visibility = View.VISIBLE
                animate()
                    .alpha(1f)
                    .translationY(0f)
                    .setDuration(160L)
                    .start()
            }
            binding.workspace.searchPill.visibility = View.GONE
            updatePageIndicatorDots(binding.workspace.workspacePager.currentItem)
            binding.workspace.pageIndicator.alpha = 1f
            binding.workspace.pageIndicator.visibility = View.VISIBLE
        } else {
            hideEditWidgetPrompt()
            hideWidgetSheet()
            binding.workspace.editTopBar.animate()
                .alpha(0f)
                .translationY(-dp(12).toFloat())
                .setDuration(130L)
                .withEndAction {
                    binding.workspace.editTopBar.visibility = View.GONE
                    binding.workspace.editTopBar.translationY = 0f
                }
                .start()
            binding.workspace.pageIndicator.visibility = View.GONE
            if (!isLibraryPage(binding.workspace.workspacePager.currentItem)) {
                binding.workspace.searchPill.apply {
                    alpha = 0f
                    visibility = View.VISIBLE
                    animate().alpha(1f).setDuration(140L).start()
                }
            }
        }
    }

    private fun toggleEditWidgetPrompt() {
        widgetSheetController.toggleEditWidgetPrompt()
    }

    private fun hideEditWidgetPrompt() {
        widgetSheetController.hideEditWidgetPrompt()
    }

    private fun showWidgetSheet() {
        widgetSheetController.showWidgetSheet()
    }

    private fun hideWidgetSheet() {
        widgetSheetController.hideWidgetSheet()
    }

    private fun handleWidgetSheetDrag(event: MotionEvent): Boolean {
        return widgetSheetController.handleWidgetSheetDrag(event)
    }

    private fun showRemoveAppDialog(app: LauncherApp) {
        removeAppController.showRemoveAppDialog(app)
    }
    private fun showSearchOverlay() {
        searchController.showSearchOverlay()
    }

    private fun hideSearchOverlay(clearQuery: Boolean = true) {
        searchController.hideSearchOverlay(clearQuery)
    }

    private fun showLibrarySearchOverlay() {
        searchController.showLibrarySearchOverlay()
    }

    private fun hideLibrarySearchOverlay() {
        searchController.hideLibrarySearchOverlay()
    }

    private fun showCategoryDetail(group: AppLibraryGroupUiModel) {
        categoryDetailController.show(group)
    }

    private fun hideCategoryDetail() {
        categoryDetailController.hide()
    }

    private fun applyLauncherSystemUi() {
        systemUiController.applyLauncherSystemUi()
    }

    override fun showAppOptions(item: LauncherIconUiModel) {
        showAnchoredAppOptions(item, binding.workspace.root)
    }

    private fun showAnchoredAppOptions(item: LauncherIconUiModel, anchor: android.view.View) {
        appOptionsController.show(item, anchor)
    }

    private fun dp(value: Int): Int {
        return (value * resources.displayMetrics.density).toInt()
    }

    private fun updateLauncherMode(forceAnimate: Boolean = false) {
        val showLauncherWorkspace = isCurrentDefaultLauncher() && !forceSettingsPanel
        state.launcherMode.set(showLauncherWorkspace)
        binding.launcher.setBackgroundResource(
            if (showLauncherWorkspace) R.drawable.bg_ios_wallpaper else R.color.settings_background
        )
        if (showLauncherWorkspace && (forceAnimate || !lastLauncherMode)) {
            binding.workspace.root.apply {
                alpha = 0f
                translationY = 28f
                animate()
                    .alpha(1f)
                    .translationY(0f)
                    .setDuration(260L)
                    .start()
            }
        }
        lastLauncherMode = showLauncherWorkspace
    }

    private fun shouldOpenSettingsPanel(intent: Intent?): Boolean {
        return intent?.action == Intent.ACTION_MAIN &&
            intent.hasCategory(Intent.CATEGORY_LAUNCHER) &&
            !intent.hasCategory(Intent.CATEGORY_HOME)
    }

    private fun isHomeIntent(intent: Intent?): Boolean {
        return intent?.action == Intent.ACTION_MAIN &&
            intent.hasCategory(Intent.CATEGORY_HOME)
    }

    private fun isCurrentDefaultLauncher(): Boolean {
        val homeIntent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_HOME)
        }
        val resolveInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            packageManager.resolveActivity(
                homeIntent,
                PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_DEFAULT_ONLY.toLong())
            )
        } else {
            @Suppress("DEPRECATION")
            packageManager.resolveActivity(homeIntent, PackageManager.MATCH_DEFAULT_ONLY)
        }
        return resolveInfo?.activityInfo?.packageName == packageName
    }

    override fun openAppInfo(app: LauncherApp) {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = Uri.parse("package:${app.packageName}")
        }
        runCatching { startActivity(intent) }.onFailure {
            showError(getString(R.string.launcher_default_prompt_failed))
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun requestHomeRole(): Boolean {
        val roleManager = getSystemService(RoleManager::class.java)
        if (!roleManager.isRoleAvailable(RoleManager.ROLE_HOME)) {
            return false
        }

        return runCatching {
            waitingForLauncherSelection = true
            homeRoleLauncher.launch(roleManager.createRequestRoleIntent(RoleManager.ROLE_HOME))
        }.isSuccess
    }

    private data class HomeEdgeTargetCell(
        val index: Int,
        val localXInCell: Float,
        val localYInCell: Float
    )

    private companion object {
        const val DOCK_APP_COUNT = 4
        const val SEARCH_COLUMNS = 4
        const val FOLDER_COLUMNS = 3
        const val SEARCH_ICON_CELL_HEIGHT_DP = 104
        const val FOLDER_ICON_CELL_HEIGHT_DP = 108
        const val PAGE_INDICATOR_VISIBLE_MS = 2500L
        const val PULL_DOWN_SEARCH_THRESHOLD_DP = 54
        const val PULL_DOWN_HORIZONTAL_ESCAPE_DP = 28
        const val FOLDER_EXIT_SLOP_DP = 28
        const val DRAG_PREVIEW_WIDTH_DP = 94
        const val DRAG_PREVIEW_HEIGHT_DP = 118
        const val DRAG_PREVIEW_ICON_CENTER_Y_DP = 36
        const val DRAG_PREVIEW_ELEVATION_DP = 70
        const val HOME_EDGE_SWITCH_ZONE_DP = 30
        const val HOME_EDGE_SWITCH_DELAY_MS = 420L
        const val HOME_EDGE_SWITCH_START_DELAY_MS = 45L
        const val HOME_EDGE_NEW_PAGE_SWITCH_START_DELAY_MS = 95L
        const val HOME_EDGE_DROP_COMMIT_DELAY_MS = 90L
        const val HOME_FOLDER_DROP_MIN_X = 0.24f
        const val HOME_FOLDER_DROP_MAX_X = 0.76f
        const val HOME_FOLDER_DROP_MIN_Y = 0.08f
        const val HOME_FOLDER_DROP_MAX_Y = 0.66f
        const val FOLDER_EDGE_SWITCH_ZONE_DP = 30
        const val FOLDER_EDGE_SWITCH_DELAY_MS = 320L
        const val FOLDER_OVERLAY_DIM_COLOR = 0x22000000
        const val HOME_PAGE_COLUMNS = 4
        const val HOME_PAGE_ROWS = 6
        const val HOME_PAGE_SIZE = HOME_PAGE_COLUMNS * HOME_PAGE_ROWS
        const val NO_PREVIEW_INDEX = -1
        const val EMPTY_LONG_PRESS_MS = 520L
        const val EMPTY_LONG_PRESS_SLOP_DP = 10
    }
}
