package com.vhmsoft.launcherios26.ui.launcher

import android.Manifest
import android.app.SearchManager
import android.app.role.RoleManager
import android.app.Dialog
import android.app.WallpaperManager
import android.content.ComponentName
import android.content.res.ColorStateList
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.SeekBar
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherFolder
import com.vhmsoft.launcherios26.data.repository.LauncherRepository
import com.vhmsoft.launcherios26.databinding.ActivityIosLauncherBinding
import com.vhmsoft.launcherios26.databinding.DialogFeatureDownloadBinding
import com.vhmsoft.launcherios26.databinding.DialogRatingPromptBinding
import com.vhmsoft.launcherios26.databinding.ViewLauncherBlurSwitchRowBinding
import com.vhmsoft.launcherios26.databinding.ViewLauncherPlainSwitchRowBinding
import com.vhmsoft.launcherios26.databinding.ViewLauncherSettingRowBinding
import com.vhmsoft.launcherios26.di.RepositoryProvider
import com.vhmsoft.launcherios26.ui.applibrary.AppLibraryActivity
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherAppOptionsController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherAnimationSettings
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherBlurSettings
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherCategoryDetailController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherFolderController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherKeyboardController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherRemoveAppController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherSearchController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherSystemUiController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherVisualEffectsController
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherWidgetSheetController
import com.vhmsoft.launcherios26.ui.launcher.icon.IosLauncherIconTheme
import com.vhmsoft.launcherios26.ui.launcher.workspace.AppLibraryGroupBuilder
import com.vhmsoft.launcherios26.ui.launcher.workspace.AppLibraryGroupUiModel
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherDockAdapter
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherDockDragCallback
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherDockHomeEdgeDragPolicy
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherDockHomeDropResolver
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherDragCallback
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherDragPreviewPositioner
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherDropCommitRenderGate
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherFolderExitDropResolver
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeDragBaseBuilder
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeEdgePreviewPolicy
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeHoverDropAction
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeHoverDropPolicy
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeItemDropResolver
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeItemUiModel
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeLayoutBuilder
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeLayoutStatePolicy
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomePageEdgeDragPolicy
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeScreenGridPolicy
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconAdapter
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconUiModel
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIos17DragDropPolicy
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIos17DragGeometryPolicy
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherPagedFolderGridLayoutManager
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherPageAdapter
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherPageIndicatorWindowPolicy
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherPageIndicatorWheelView
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherResponsiveWorkspaceLayout
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherResponsiveWorkspaceSpec
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherScaledBoundsHitTest
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherSingleDragCommitGuard
import com.vhmsoft.launcherios26.ui.launcher.workspace.WidgetAppAdapter
import com.vhmsoft.launcherios26.ui.settings.feature.LauncherExternalFeature
import com.vhmsoft.launcherios26.ui.settings.feature.LauncherExternalFeatureCatalog
import com.vhmsoft.launcherios26.ui.settings.feature.LauncherExternalFeatureCode
import kotlinx.coroutines.launch
import kotlin.math.abs

class IOSLauncherActivity : AppCompatActivity(), IOSLauncherContract.View {
    private lateinit var binding: ActivityIosLauncherBinding
    private lateinit var presenter: IOSLauncherPresenter
    private lateinit var launcherRepository: LauncherRepository
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
    private lateinit var dockItemTouchHelper: ItemTouchHelper
    private lateinit var folderItemTouchHelper: ItemTouchHelper
    private lateinit var widgetAppAdapter: WidgetAppAdapter
    private val layoutPreferences by lazy {
        getSharedPreferences(LAYOUT_PREFERENCES_NAME, MODE_PRIVATE)
    }
    private val dropCommitRenderGate by lazy {
        LauncherDropCommitRenderGate { action ->
            binding.workspace.root.postOnAnimation(action)
        }
    }
    private val state = LauncherUiState()
    private val indicatorHandler = Handler(Looper.getMainLooper())
    private val hideIndicatorRunnable = Runnable { hidePageIndicator() }
    private val folderEdgeSwitchHandler = Handler(Looper.getMainLooper())
    private val folderEdgeSwitchRunnable = Runnable { performFolderExitEdgeSwitch() }
    private val homeEdgeSwitchHandler = Handler(Looper.getMainLooper())
    private val homeEdgeSwitchRunnable = Runnable { performHomeEdgeSwitch() }
    private var homeItems: List<LauncherHomeItemUiModel> = emptyList()
    private var dockItems: List<LauncherHomeItemUiModel> = emptyList()
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
    private var defaultWelcomeOverlay: View? = null
    private var hasPositionedInitialHomePage = false
    private var lastWorkspacePagePosition = RecyclerView.NO_POSITION
    private var layoutDarkMode = false
    private var layoutIphone8Style = false
    private var layoutAutoArrange = false
    private var layoutLiquidGlass = false
    private var homeIconSizeDp = DEFAULT_HOME_ICON_SIZE_DP
    private var homeGridRows = DEFAULT_HOME_GRID_ROWS
    private var effectiveHomeIconSizeDp = DEFAULT_HOME_ICON_SIZE_DP
    private var effectiveHomeGridRows = DEFAULT_HOME_GRID_ROWS
    private val homePageSize: Int
        get() = HOME_PAGE_COLUMNS * effectiveHomeGridRows
    private var folderExitDragActive = false
    private var folderExitDragCollapsed = false
    private var folderExitDragCenterX = 0f
    private var folderExitDragCenterY = 0f
    private var folderExitDragCenterXOnScreen = 0f
    private var folderExitDragCenterYOnScreen = 0f
    private var folderExitEdgeDirection = 0
    private var folderExitDragPage = 0
    private var folderExitPreviewIndex = NO_PREVIEW_INDEX
    private var folderExitFolderTargetIndex = NO_PREVIEW_INDEX
    private var folderExitDraggedApp: LauncherIconUiModel? = null
    private var folderExitBaseHomeItems: List<LauncherHomeItemUiModel> = emptyList()
    private var folderExitPreviewIconKey: String? = null
    private val folderExitDropCommitGuard = LauncherSingleDragCommitGuard()
    private var folderExitPendingCenterXOnScreen = 0f
    private var folderExitPendingCenterYOnScreen = 0f
    private var folderExitPositionFramePosted = false
    private var folderExitDragMetrics: FolderExitDragMetrics? = null
    private val folderExitPositionRunnable = Runnable {
        folderExitPositionFramePosted = false
        applyFolderExitDragPosition(
            folderExitPendingCenterXOnScreen,
            folderExitPendingCenterYOnScreen
        )
    }
    private var homeEdgeDragActive = false
    private var homeEdgeDragCenterX = 0f
    private var homeEdgeDragCenterY = 0f
    private var homeEdgeDragPage = 0
    private var homeEdgeSourcePage = 0
    private var homeEdgeHasLeftSourcePage = false
    private var homeEdgeDirection = 0
    private var homeEdgePreviewIndex = NO_PREVIEW_INDEX
    private var homeEdgeFolderTargetIndex = NO_PREVIEW_INDEX
    private var homeEdgeDraggedItem: LauncherHomeItemUiModel? = null
    private var homeEdgeDragPlaceholder: LauncherHomeItemUiModel.Placeholder? = null
    private var homeEdgeBaseItems: List<LauncherHomeItemUiModel> = emptyList()
    private var homeEdgeDragFromDock = false
    private var homeEdgeCommitted = false
    private var homeEdgeTouchActive = false
    private var homeEdgePageSwitching = false
    private var homeDockDragActive = false
    private var homeDockDraggedApp: LauncherIconUiModel? = null
    private var pendingIconChangeApp: LauncherApp? = null
    private var openFolderSource = FolderSource.HOME
    private var indicatorMode = IndicatorMode.SEARCH
    private var indicatorWheelView: LauncherPageIndicatorWheelView? = null
    private val appLibraryLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == android.app.Activity.RESULT_OK && ::presenter.isInitialized) {
            presenter.refreshApps()
        }
    }
    private val customIconImageLauncher = registerForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri ->
        val app = pendingIconChangeApp
        pendingIconChangeApp = null
        if (uri == null || app == null || !::launcherRepository.isInitialized) return@registerForActivityResult

        takePersistableReadPermission(uri)
        launcherRepository.saveCustomIconUri(app, uri.toString())
        presenter.clearIconCache()
        presenter.refreshApps()
        showError(getString(R.string.settings_change_icon_done, app.label))
    }
    private val wallpaperImageLauncher = registerForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri ->
        if (uri == null) return@registerForActivityResult

        takePersistableReadPermission(uri)
        layoutPreferences.edit()
            .putString(KEY_CUSTOM_WALLPAPER_URI, uri.toString())
            .apply()
        applyLauncherRootBackground(state.launcherMode)
        showError(getString(R.string.settings_wallpaper_applied))
    }
    private val homeRoleLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        handleDefaultLauncherSelectionReturn(showNotSelectedToast = true)
    }
    private val homeSettingsLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        handleDefaultLauncherSelectionReturn(showNotSelectedToast = true)
    }
    private val weatherLocationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        updateWidgetWeatherPermissionState()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityIosLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        layoutDarkMode = layoutPreferences.getBoolean(KEY_LAYOUT_DARK_MODE, false)
        layoutIphone8Style = layoutPreferences.getBoolean(KEY_LAYOUT_IPHONE8_STYLE, false)
        layoutAutoArrange = layoutPreferences.getBoolean(KEY_LAYOUT_AUTO_ARRANGE, false)
        layoutLiquidGlass = layoutPreferences.getBoolean(KEY_LAYOUT_LIQUID_GLASS, false)
        homeIconSizeDp = layoutPreferences.getInt(KEY_HOME_ICON_SIZE_DP, DEFAULT_HOME_ICON_SIZE_DP)
            .coerceIn(MIN_HOME_ICON_SIZE_DP, MAX_HOME_ICON_SIZE_DP)
        homeGridRows = layoutPreferences.getInt(KEY_HOME_GRID_ROWS, DEFAULT_HOME_GRID_ROWS)
            .takeIf { rows -> rows == HOME_GRID_ROWS_5 || rows == HOME_GRID_ROWS_6 }
            ?: DEFAULT_HOME_GRID_ROWS
        effectiveHomeIconSizeDp = homeIconSizeDp
        effectiveHomeGridRows = homeGridRows
        IosLauncherIconTheme.setDarkMode(layoutDarkMode)
        forceSettingsPanel = shouldOpenSettingsPanel(intent)
        systemUiController = LauncherSystemUiController(this, binding)
        keyboardController = LauncherKeyboardController(this)
        visualEffectsController = LauncherVisualEffectsController(binding)
        visualEffectsController.setBlurSettings(currentBlurSettings())
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
            visualEffectsController = visualEffectsController,
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
            showSearchTrigger = { animated -> showSearchControlInIndicator(animated) },
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
        launcherRepository = RepositoryProvider.provideLauncherRepository(applicationContext)
        presenter = IOSLauncherPresenter(launcherRepository)
        setupSettingsRows()
        setupLayoutSettingsPage()
        setupLiquidGlassSettingsPage()
        setupBlurEffectSettingsPage()
        setupAnimationSettingsPage()
        setupSettingsDrawer()
        updateLauncherContentDescription()
        applyLayoutAppearance()
        presenter.attachView(this)
        updateLauncherMode()
        applyLauncherSystemUi()
        presenter.loadLauncherData()
    }

    override fun onResume() {
        super.onResume()
        updateLauncherMode()
        applyLauncherSystemUi()
        if (waitingForLauncherSelection && isCurrentDefaultLauncher()) {
            handleDefaultLauncherSelectionReturn(showNotSelectedToast = false)
        } else {
            showDefaultWelcomeIfNeeded()
        }
        updateWidgetWeatherPermissionState()
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
        showDefaultWelcomeIfNeeded()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus && ::systemUiController.isInitialized) {
            applyLauncherSystemUi()
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (::binding.isInitialized) {
            if (handleHomeDockExternalDragEvent(ev)) {
                return super.dispatchTouchEvent(ev)
            }
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

    private fun setupSettingsRows() {
        binding.settingsSocialBar.bringToFront()
        binding.likeButton.setOnClickListener {
            presenter.onRateClicked()
        }
        binding.mailButton.setOnClickListener {
            presenter.onMailClicked()
        }
        binding.shareButton.setOnClickListener {
            presenter.onShareClicked()
        }
        binding.settingsMenuButton.setOnClickListener {
            presenter.onSettingsMenuClicked()
        }
        binding.settingsFab.setOnClickListener {
            presenter.onRateClicked()
        }

        bindSettingsRow(
            row = binding.lockScreenRow,
            titleRes = R.string.settings_lock_screen,
            iconRes = R.drawable.ic_lock_24,
            iconColorRes = R.color.icon_lock,
            showDivider = true,
            onClick = { presenter.onLockScreenClicked() }
        )
        bindSettingsRow(
            row = binding.controlCenterRow,
            titleRes = R.string.settings_control_center,
            iconRes = R.drawable.ic_toggles_24,
            iconColorRes = R.color.icon_control,
            showDivider = true,
            onClick = { presenter.onControlCenterClicked() }
        )
        bindSettingsRow(
            row = binding.assistiveTouchRow,
            titleRes = R.string.settings_assistive_touch,
            iconRes = R.drawable.ic_assistive_24,
            iconColorRes = R.color.icon_assistive,
            showDivider = false,
            onClick = { presenter.onAssistiveTouchClicked() }
        )
        bindSettingsRow(
            row = binding.layoutRow,
            titleRes = R.string.settings_layout,
            iconRes = R.drawable.ic_grid_24,
            iconColorRes = R.color.icon_layout,
            showDivider = true,
            onClick = { presenter.onLayoutSettingsClicked() }
        )
        bindSettingsRow(binding.weatherRow, R.string.settings_weather, R.drawable.ic_weather_24, R.color.icon_weather)
        bindSettingsRow(
            row = binding.liquidGlassRow,
            titleRes = R.string.settings_liquid_glass,
            iconRes = R.drawable.ic_drop_24,
            iconColorRes = R.color.icon_liquid,
            showDivider = true,
            onClick = { showLiquidGlassSettingsPage() }
        )
        bindSettingsRow(
            row = binding.blurEffectRow,
            titleRes = R.string.settings_blur_effect,
            iconRes = R.drawable.ic_dots_24,
            iconColorRes = R.color.icon_blur,
            showDivider = true,
            onClick = { showBlurEffectSettingsPage() }
        )
        bindSettingsRow(
            row = binding.motionWallpaperRow,
            titleRes = R.string.settings_motion_wallpaper,
            iconRes = R.drawable.ic_moon_24,
            iconColorRes = R.color.icon_motion,
            showDivider = true,
            onClick = { showAnimationSettingsPage() }
        )
        bindSettingsRow(
            row = binding.wallpaperRow,
            titleRes = R.string.settings_wallpaper,
            iconRes = R.drawable.ic_wallpaper_24,
            iconColorRes = R.color.icon_wallpaper,
            showDivider = true,
            onClick = { showWallpaperSettingsDialog() }
        )
        bindSettingsRow(
            row = binding.changeIconRow,
            titleRes = R.string.settings_change_icon,
            iconRes = R.drawable.ic_icon_change_24,
            iconColorRes = R.color.icon_change,
            showDivider = true,
            onClick = { showChangeIconAppPicker() }
        )
        bindSettingsRow(
            row = binding.renameRow,
            titleRes = R.string.settings_rename,
            iconRes = R.drawable.ic_text_ab_24,
            iconColorRes = R.color.icon_rename,
            showDivider = true,
            onClick = { showRenameAppPicker() }
        )
        bindSettingsRow(
            row = binding.appLibraryRow,
            titleRes = R.string.settings_app_library,
            iconRes = R.drawable.ic_library_24,
            iconColorRes = R.color.icon_library,
            showDivider = true,
            onClick = { presenter.onAppLibraryClicked() }
        )
        bindSettingsRow(
            row = binding.hiddenAppsRow,
            titleRes = R.string.settings_hidden_apps,
            iconRes = R.drawable.ic_eye_off_20,
            iconColorRes = R.color.icon_hidden,
            showDivider = true,
            onClick = { showHiddenAppsSettingsDialog() }
        )
        bindSettingsRow(
            row = binding.notificationsRow,
            titleRes = R.string.settings_notifications,
            iconRes = R.drawable.ic_notification_badge_24,
            iconColorRes = R.color.icon_notification,
            showDivider = true,
            onClick = { openNotificationAccessSettings() }
        )
        bindSettingsRow(
            row = binding.makeDefaultLauncherRow,
            titleRes = R.string.settings_make_default_launcher,
            iconRes = R.drawable.ic_circle_outline_24,
            iconColorRes = R.color.icon_make_default,
            showDivider = false,
            onClick = { showDefaultLauncherPrompt() }
        )
        bindSettingsRow(
            row = binding.rateRow,
            titleRes = R.string.settings_rate_5_star,
            iconRes = R.drawable.ic_star_24,
            iconColorRes = R.color.icon_rate,
            showDivider = true,
            onClick = { presenter.onRateClicked() }
        )
        bindSettingsRow(
            row = binding.moreAppsRow,
            titleRes = R.string.settings_more_apps,
            iconRes = R.drawable.ic_download_24,
            iconColorRes = R.color.icon_download,
            showDivider = false
        )
    }

    private fun bindSettingsRow(
        row: ViewLauncherSettingRowBinding,
        titleRes: Int,
        iconRes: Int,
        iconColorRes: Int,
        showDivider: Boolean = true,
        onClick: (() -> Unit)? = null
    ) {
        row.rowTitle.setText(titleRes)
        row.rowIcon.setImageResource(iconRes)
        row.iconContainer.backgroundTintList = ColorStateList.valueOf(getColor(iconColorRes))
        row.rowDivider.visibility = if (showDivider) View.VISIBLE else View.GONE
        row.root.setOnClickListener(if (onClick == null) null else View.OnClickListener { onClick() })
        row.root.isClickable = onClick != null
        row.root.isFocusable = onClick != null
    }

    private fun setupLayoutSettingsPage() {
        binding.layoutBackButton.setOnClickListener {
            hideLayoutSettingsPage()
        }
        binding.darkModeSwitch.setOnCheckedChangeListener(null)
        binding.darkModeSwitch.isChecked = layoutDarkMode
        binding.darkModeSwitch.setOnCheckedChangeListener { _, checked ->
            presenter.onLayoutDarkModeChanged(checked)
        }
        binding.darkModeRow.setOnClickListener {
            binding.darkModeSwitch.isChecked = !binding.darkModeSwitch.isChecked
        }
        binding.iphone8Switch.setOnCheckedChangeListener(null)
        binding.iphone8Switch.isChecked = layoutIphone8Style
        binding.iphone8Switch.setOnCheckedChangeListener { _, checked ->
            applyIphone8Style(checked, persist = true)
        }
        binding.iphone8Row.setOnClickListener {
            binding.iphone8Switch.isChecked = !binding.iphone8Switch.isChecked
        }
        binding.bottomSpacingSwitch.isChecked = false
        binding.bottomSpacingRow.setOnClickListener {
            binding.bottomSpacingSwitch.isChecked = !binding.bottomSpacingSwitch.isChecked
        }
        binding.autoArrangeSwitch.setOnCheckedChangeListener(null)
        binding.autoArrangeSwitch.isChecked = layoutAutoArrange
        binding.autoArrangeSwitch.setOnCheckedChangeListener { _, checked ->
            applyAutoArrange(checked, persist = true)
        }
        binding.autoArrangeRow.setOnClickListener {
            binding.autoArrangeSwitch.isChecked = !binding.autoArrangeSwitch.isChecked
        }
        binding.iconSizeSeekBar.max = MAX_HOME_ICON_SIZE_DP - MIN_HOME_ICON_SIZE_DP
        binding.iconSizeSeekBar.progress = homeIconSizeDp - MIN_HOME_ICON_SIZE_DP
        binding.iconSizeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    applyHomeIconSize(MIN_HOME_ICON_SIZE_DP + progress, persist = true)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit

            override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit
        })
        binding.grid5x4Option.setOnClickListener {
            applyHomeGridRows(HOME_GRID_ROWS_5, persist = true)
        }
        binding.grid6x4Option.setOnClickListener {
            applyHomeGridRows(HOME_GRID_ROWS_6, persist = true)
        }
        applyHomeLayoutSettingsUi()
        tintLayoutSwitches()
    }

    private fun setupLiquidGlassSettingsPage() {
        binding.liquidGlassBackButton.setOnClickListener {
            hideLiquidGlassSettingsPage()
        }
        binding.liquidGlassSwitch.setOnCheckedChangeListener(null)
        binding.liquidGlassSwitch.isChecked = layoutLiquidGlass
        binding.liquidGlassSwitch.setOnCheckedChangeListener { _, checked ->
            applyLiquidGlass(checked, persist = true)
        }
        binding.liquidGlassOptionsCard.setOnClickListener {
            binding.liquidGlassSwitch.isChecked = !binding.liquidGlassSwitch.isChecked
        }
        applyLiquidGlassSettingsAppearance()
    }

    private fun setupBlurEffectSettingsPage() {
        binding.blurBackButton.setOnClickListener {
            hideBlurEffectSettingsPage()
        }
        applyBlurSettingsUi()
        applyBlurSettingsAppearance()
    }

    private fun setupAnimationSettingsPage() {
        binding.animationBackButton.setOnClickListener {
            hideAnimationSettingsPage()
        }
        applyAnimationSettingsUi()
        applyAnimationSettingsAppearance()
    }

    private fun setupSettingsDrawer() {
        binding.settingsDrawerDim.setOnClickListener {
            hideSettingsDrawer()
        }
        binding.settingsDrawerPanel.setOnClickListener {
            // Consume drawer panel taps so only the dimmed area closes it.
        }
        binding.drawerReloadRow.setOnClickListener {
            hideSettingsDrawer()
            presenter.refreshApps()
            showError(getString(R.string.drawer_reload_done))
        }
        binding.drawerPrivacyRow.setOnClickListener {
            showDrawerComingSoon(R.string.drawer_privacy_policy)
        }
        binding.drawerGuideRow.setOnClickListener {
            showDrawerComingSoon(R.string.drawer_user_guide)
        }
        binding.drawerWebsiteRow.setOnClickListener {
            showDrawerComingSoon(R.string.drawer_website)
        }
        binding.drawerAboutRow.setOnClickListener {
            showDrawerComingSoon(R.string.drawer_about_us)
        }
    }

    private fun installBackHandling() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                when {
                    defaultWelcomeOverlay != null -> {
                        dismissDefaultWelcomeOverlay()
                    }

                    binding.layoutSettingsPanel.visibility == View.VISIBLE -> {
                        hideLayoutSettingsPage()
                    }

                    binding.liquidGlassSettingsPanel.visibility == View.VISIBLE -> {
                        hideLiquidGlassSettingsPage()
                    }

                    binding.blurSettingsPanel.visibility == View.VISIBLE -> {
                        hideBlurEffectSettingsPage()
                    }

                    binding.animationSettingsPanel.visibility == View.VISIBLE -> {
                        hideAnimationSettingsPage()
                    }

                    binding.settingsDrawerOverlay.visibility == View.VISIBLE -> {
                        hideSettingsDrawer()
                    }

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
        state.loading = isLoading
    }

    override fun showLauncherApps(
        apps: List<LauncherIconUiModel>,
        folders: List<LauncherFolder>,
        dockFolders: List<LauncherFolder>,
        dockOrder: List<String>
    ) {
        val builtHomeItems = LauncherHomeLayoutBuilder.build(apps, folders)
        val restoredHomeItems = LauncherHomeLayoutStatePolicy.restore(
            encoded = layoutPreferences.getString(KEY_HOME_LAYOUT_ITEMS, null),
            apps = apps,
            folders = folders,
            fallbackItems = builtHomeItems
        )
        homeItems = arrangeHomeItems(restoredHomeItems)
        dockItems = buildDockItems(apps, dockFolders, dockOrder)
        state.appCount = apps.size
        updateLauncherContentDescription()
        workspacePageAdapter.submitItems(homeItems)
        workspacePageAdapter.submitLibraryGroups(AppLibraryGroupBuilder.buildGroups(apps))
        if (!hasPositionedInitialHomePage && workspacePageAdapter.homePageCount() > 0) {
            binding.workspace.workspacePager.setCurrentItem(workspacePageAdapter.firstHomeAdapterPosition(), false)
            hasPositionedInitialHomePage = true
        }
        dockAdapter.submitItems(dockItems)
        widgetAppAdapter.submitApps(apps)
        searchController.submitApps(apps)
        updateOpenFolderContent()
        applyWorkspaceAppearance()
        updateWorkspaceChromeForPage(binding.workspace.workspacePager.currentItem)
        updatePageIndicatorDotsForAdapterPosition(binding.workspace.workspacePager.currentItem)
        showDefaultWelcomeIfNeeded()
    }

    private fun handleHomeItemsChanged(
        items: List<LauncherHomeItemUiModel>,
        refreshWorkspace: Boolean = true,
        preferredPage: Int? = null,
        refreshOpenFolder: Boolean = true,
        refreshAppearance: Boolean = true
    ) {
        homeItems = arrangeHomeItems(items)
        saveHomeLayoutItems(homeItems)
        presenter.onHomeItemsChanged(homeItems)
        if (refreshWorkspace) {
            workspacePageAdapter.submitItems(homeItems)
            preferredPage?.let { page ->
                val targetHomePage = page.coerceIn(
                    0,
                    (workspacePageAdapter.homePageCount() - 1).coerceAtLeast(0)
                )
                val targetPage = workspacePageAdapter.adapterPositionForHomePage(targetHomePage)
                if (binding.workspace.workspacePager.currentItem != targetPage) {
                    binding.workspace.workspacePager.setCurrentItem(targetPage, false)
                }
            }
        }
        val chromePage = preferredPage
            ?.coerceIn(0, (workspacePageAdapter.homePageCount() - 1).coerceAtLeast(0))
            ?.let { page -> workspacePageAdapter.adapterPositionForHomePage(page) }
            ?: binding.workspace.workspacePager.currentItem
        if (refreshOpenFolder) {
            updateOpenFolderContent()
        }
        if (refreshAppearance) {
            applyWorkspaceAppearance()
        }
        updateWorkspaceChromeForPage(chromePage)
        updatePageIndicatorDotsForAdapterPosition(chromePage)
    }

    private fun arrangeHomeItems(items: List<LauncherHomeItemUiModel>): List<LauncherHomeItemUiModel> {
        val arrangedItems = LauncherHomeLayoutStatePolicy.arrange(
            items = items,
            autoArrange = layoutAutoArrange
        )
        return LauncherHomeScreenGridPolicy.removeEmptyPages(
            items = arrangedItems,
            pageSize = homePageSize
        )
    }

    private fun shouldRefreshWorkspaceAfterHomeItemsChanged(items: List<LauncherHomeItemUiModel>): Boolean {
        return arrangeHomeItems(items) != items ||
            layoutAutoArrange && items.any { item -> item is LauncherHomeItemUiModel.Placeholder }
    }

    private fun saveHomeLayoutItems(items: List<LauncherHomeItemUiModel>) {
        layoutPreferences.edit()
            .putString(KEY_HOME_LAYOUT_ITEMS, LauncherHomeLayoutStatePolicy.encode(items))
            .apply()
    }

    private fun handleDockItemsChanged(
        items: List<LauncherHomeItemUiModel>,
        refreshDock: Boolean = true
    ) {
        dockItems = normalizeDockItems(items)
        presenter.onDockItemsChanged(dockItems)
        if (refreshDock) {
            dockAdapter.submitItems(dockItems)
        }
        updateOpenFolderContent()
    }

    private fun buildDockItems(
        apps: List<LauncherIconUiModel>,
        folders: List<LauncherFolder>,
        dockOrder: List<String>
    ): List<LauncherHomeItemUiModel> {
        val appByKey = apps.associateBy { item -> item.app.iconKey }
        val folderKeys = folders
            .flatMap { folder -> folder.appIconKeys }
            .filter { iconKey -> iconKey in appByKey }
        val orderedKeys = dockOrder.filter { iconKey -> iconKey in appByKey }
        val fallbackKeys = apps
            .map { item -> item.app.iconKey }
            .filterNot { iconKey -> iconKey in orderedKeys || iconKey in folderKeys }
        val candidateKeys = (orderedKeys + folderKeys + fallbackKeys).distinct()
        val candidateApps = candidateKeys.mapNotNull { iconKey -> appByKey[iconKey] }
            .ifEmpty { apps.take(DOCK_APP_COUNT) }

        return normalizeDockItems(LauncherHomeLayoutBuilder.build(candidateApps, folders))
    }

    private fun normalizeDockItems(items: List<LauncherHomeItemUiModel>): List<LauncherHomeItemUiModel> {
        return LauncherHomeLayoutBuilder.normalize(items)
            .filterNot { item -> item is LauncherHomeItemUiModel.Placeholder }
            .take(DOCK_APP_COUNT)
    }

    private fun handleHomePageDragMoved(
        item: LauncherHomeItemUiModel?,
        viewHolder: RecyclerView.ViewHolder,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ): Boolean {
        if (homeEdgeCommitted) return true
        if (!editingHome) return false
        val draggedItem = item?.takeUnless { current ->
            current is LauncherHomeItemUiModel.Placeholder
        } ?: return false
        val draggedApp = (draggedItem as? LauncherHomeItemUiModel.App)?.iconItem
        if (draggedApp != null &&
            (homeDockDragActive || isPointInsideView(binding.workspace.dockRecyclerView, centerXOnScreen, centerYOnScreen))
        ) {
            beginHomeDockDragIfNeeded(draggedApp)
            updateHomeDockDragPosition(centerXOnScreen, centerYOnScreen)
            return true
        }

        val rootLocation = IntArray(2)
        binding.workspace.root.getLocationOnScreen(rootLocation)
        val rootWidth = binding.workspace.root.width.takeIf { it > 0 } ?: resources.displayMetrics.widthPixels
        val rootCenterX = centerXOnScreen - rootLocation[0]
        val direction = homeEdgeDirectionForCenter(rootCenterX, rootWidth)
        if (!LauncherHomePageEdgeDragPolicy.shouldStart(
                editingHome = editingHome,
                hasDraggableItem = true,
                alreadyActive = homeEdgeDragActive,
                direction = direction
            )
        ) {
            return false
        }

        beginHomeEdgeDragIfNeeded(draggedItem, viewHolder)
        updateHomeEdgeDragPosition(centerXOnScreen, centerYOnScreen)
        return true
    }

    private fun handleHomePageDragEnded(
        item: LauncherHomeItemUiModel?,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ): Boolean {
        val draggedApp = (item as? LauncherHomeItemUiModel.App)?.iconItem
        if (draggedApp != null && isPointInsideView(binding.workspace.dockRecyclerView, centerXOnScreen, centerYOnScreen)) {
            animateHomeIconIntoDock(draggedApp, centerXOnScreen, centerYOnScreen)
            return true
        }
        if (homeDockDragActive) {
            hideHomeDockDragPreview()
            return true
        }

        if (!homeEdgeDragActive) return false
        if (homeEdgeCommitted) return true

        if (homeEdgeTouchActive) return true

        updateHomeEdgeDragPosition(centerXOnScreen, centerYOnScreen)
        finishHomeEdgeDrag(commit = true)
        return true
    }

    private fun beginHomeDockDragIfNeeded(draggedApp: LauncherIconUiModel) {
        if (homeDockDraggedApp != null) return

        homeDockDraggedApp = draggedApp
        binding.workspace.workspacePager.isUserInputEnabled = false
        binding.workspace.selectedIconImage.setImageDrawable(draggedApp.displayIcon)
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
        homeDockDragActive = true
    }

    private fun handleHomeDockExternalDragEvent(event: MotionEvent): Boolean {
        if (!homeDockDragActive) return false

        when (event.actionMasked) {
            MotionEvent.ACTION_MOVE -> updateHomeDockDragPosition(event.rawX, event.rawY)

            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> updateHomeDockDragPosition(event.rawX, event.rawY)
        }
        return true
    }

    private fun updateHomeDockDragPosition(centerXOnScreen: Float, centerYOnScreen: Float) {
        if (homeDockDraggedApp == null) return

        val rootLocation = IntArray(2)
        binding.workspace.root.getLocationOnScreen(rootLocation)
        val previewWidth = binding.workspace.selectedIconPreview.width.takeIf { it > 0 } ?: dp(DRAG_PREVIEW_WIDTH_DP)
        val previewHeight = binding.workspace.selectedIconPreview.height.takeIf { it > 0 } ?: dp(DRAG_PREVIEW_HEIGHT_DP)
        val rootWidth = binding.workspace.root.width.takeIf { it > 0 } ?: resources.displayMetrics.widthPixels
        val rootHeight = binding.workspace.root.height.takeIf { it > 0 } ?: resources.displayMetrics.heightPixels
        val rootCenterX = (centerXOnScreen - rootLocation[0]).coerceIn(0f, rootWidth.toFloat())
        val rootCenterY = (centerYOnScreen - rootLocation[1]).coerceIn(0f, rootHeight.toFloat())
        val previewPosition = LauncherDragPreviewPositioner.positionForIconCenter(
            rootWidth = rootWidth,
            rootHeight = rootHeight,
            previewWidth = previewWidth,
            previewHeight = previewHeight,
            iconCenterY = dp(DRAG_PREVIEW_ICON_CENTER_Y_DP),
            centerX = rootCenterX,
            centerY = rootCenterY,
            horizontalPadding = dp(4),
            verticalPadding = dp(12)
        )

        binding.workspace.selectedIconPreview.x = previewPosition.left.toFloat()
        binding.workspace.selectedIconPreview.y = previewPosition.top.toFloat()
    }

    private fun hideHomeDockDragPreview() {
        if (!homeDockDragActive) return

        homeDockDragActive = false
        homeDockDraggedApp = null
        binding.workspace.workspacePager.isUserInputEnabled = true
        forceHideSelectedIconPreview()
    }

    private fun animateHomeIconIntoDock(
        item: LauncherIconUiModel,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ) {
        if (!homeDockDragActive || binding.workspace.selectedIconPreview.visibility != View.VISIBLE) {
            hideHomeDockDragPreview()
            binding.workspace.root.post {
                moveHomeIconToDock(item, centerXOnScreen, centerYOnScreen)
            }
            return
        }

        homeDockDragActive = false
        homeDockDraggedApp = null
        binding.workspace.workspacePager.isUserInputEnabled = true

        val preview = binding.workspace.selectedIconPreview
        val target = dockDropPreviewTarget(item, centerXOnScreen, centerYOnScreen)
        preview.animate().cancel()
        binding.workspace.selectedIconLabel.animate().cancel()
        preview.pivotX = preview.width / 2f
        preview.pivotY = dp(DRAG_PREVIEW_ICON_CENTER_Y_DP).toFloat()
        preview.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        binding.workspace.selectedIconLabel.animate()
            .alpha(0f)
            .setDuration(HOME_DOCK_DROP_IN_MS)
            .start()
        preview.animate()
            .x(target.left)
            .y(target.top)
            .scaleX(HOME_DOCK_DROP_SHRINK_SCALE)
            .scaleY(HOME_DOCK_DROP_SHRINK_SCALE)
            .alpha(0.92f)
            .setDuration(HOME_DOCK_DROP_IN_MS)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction {
                moveHomeIconToDock(item, centerXOnScreen, centerYOnScreen)
                preview.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .alpha(0f)
                    .setDuration(HOME_DOCK_DROP_POP_MS)
                    .setInterpolator(OvershootInterpolator(1.18f))
                    .withEndAction { forceHideSelectedIconPreview() }
                    .start()
            }
            .start()
    }

    private fun dockDropPreviewTarget(
        item: LauncherIconUiModel,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ): DockDropPreviewTarget {
        val rootLocation = IntArray(2)
        binding.workspace.root.getLocationOnScreen(rootLocation)
        val previewWidth = binding.workspace.selectedIconPreview.width.takeIf { it > 0 }
            ?: dp(DRAG_PREVIEW_WIDTH_DP)
        val folderTargetIndex = dockDropTargetIndexForPoint(centerXOnScreen, centerYOnScreen, item)
        val targetCenter = if (folderTargetIndex != NO_PREVIEW_INDEX) {
            dockChildCenterOnScreen(folderTargetIndex) ?: dockSlotCenterOnScreen(centerXOnScreen)
        } else {
            dockSlotCenterOnScreen(centerXOnScreen)
        }

        return DockDropPreviewTarget(
            left = targetCenter.first - rootLocation[0] - previewWidth / 2f,
            top = targetCenter.second - rootLocation[1] - dp(DRAG_PREVIEW_ICON_CENTER_Y_DP)
        )
    }

    private fun dockChildCenterOnScreen(position: Int): Pair<Float, Float>? {
        val recyclerView = binding.workspace.dockRecyclerView
        val child = recyclerView.findViewHolderForAdapterPosition(position)?.itemView ?: return null
        val iconPlate = child.findViewById<View>(R.id.iconPlate) ?: child
        val childLocation = IntArray(2)
        child.getLocationOnScreen(childLocation)
        return Pair(
            childLocation[0] + iconPlate.left + iconPlate.width / 2f,
            childLocation[1] + iconPlate.top + iconPlate.height / 2f
        )
    }

    private fun dockSlotCenterOnScreen(centerXOnScreen: Float): Pair<Float, Float> {
        val recyclerView = binding.workspace.dockRecyclerView
        val dockLocation = IntArray(2)
        recyclerView.getLocationOnScreen(dockLocation)
        val dockWidth = recyclerView.width.takeIf { it > 0 } ?: resources.displayMetrics.widthPixels
        val dockHeight = recyclerView.height.takeIf { it > 0 } ?: dp(effectiveHomeIconSizeDp + DOCK_VERTICAL_EXTRA_DP)
        val dockIndex = dockDropIndexForPoint(centerXOnScreen, dockAdapter.itemCount)
        val slotWidth = dockWidth / DOCK_APP_COUNT.toFloat()
        return Pair(
            dockLocation[0] + slotWidth * (dockIndex + 0.5f),
            dockLocation[1] + dockHeight / 2f
        )
    }

    private fun handleDockDragEnded(
        item: LauncherHomeItemUiModel,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ): Boolean {
        if (!editingHome) return false
        if (homeEdgeDragActive && homeEdgeDragFromDock) {
            if (homeEdgeCommitted) return true
            if (homeEdgeTouchActive) return true

            updateHomeEdgeDragPosition(centerXOnScreen, centerYOnScreen)
            finishHomeEdgeDrag(commit = true)
            return true
        }
        if (isPointInsideView(binding.workspace.dockRecyclerView, centerXOnScreen, centerYOnScreen)) {
            return false
        }
        if (!isPointInsideView(binding.workspace.workspacePager, centerXOnScreen, centerYOnScreen)) {
            return false
        }

        binding.workspace.root.post {
            moveDockItemToHome(item, centerXOnScreen, centerYOnScreen)
        }
        return true
    }

    private fun handleDockDragMoved(
        item: LauncherHomeItemUiModel,
        viewHolder: RecyclerView.ViewHolder,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ): Boolean {
        if (homeEdgeDragActive && !homeEdgeDragFromDock) return false

        val rootLocation = IntArray(2)
        binding.workspace.root.getLocationOnScreen(rootLocation)
        val rootWidth = binding.workspace.root.width.takeIf { width -> width > 0 }
            ?: resources.displayMetrics.widthPixels
        val rootCenterX = centerXOnScreen - rootLocation[0]
        val inEdgeZone = homeEdgeDirectionForCenter(rootCenterX, rootWidth) != 0
        val shouldHandle = LauncherDockHomeEdgeDragPolicy.shouldHandle(
            editingHome = editingHome,
            alreadyActive = homeEdgeDragActive && homeEdgeDragFromDock,
            inDock = isPointInsideView(binding.workspace.dockRecyclerView, centerXOnScreen, centerYOnScreen),
            inWorkspace = isPointInsideView(binding.workspace.workspacePager, centerXOnScreen, centerYOnScreen),
            inEdgeZone = inEdgeZone
        )
        if (!shouldHandle) {
            if (homeEdgeDragActive && homeEdgeDragFromDock) {
                finishHomeEdgeDrag(commit = false)
            }
            return false
        }

        beginDockHomeEdgeDragIfNeeded(item, viewHolder)
        updateHomeEdgeDragPosition(centerXOnScreen, centerYOnScreen)
        return true
    }

    private fun moveHomeIconToDock(
        item: LauncherIconUiModel,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ) {
        val currentDockItems = removeAppFromItems(dockAdapter.itemsSnapshot(), item).toMutableList()
        val folderTargetIndex = dockDropTargetIndexForPoint(centerXOnScreen, centerYOnScreen, item)
        if (folderTargetIndex in currentDockItems.indices) {
            currentDockItems[folderTargetIndex] = mergeAppIntoDockTarget(currentDockItems[folderTargetIndex], item)
            handleDockItemsChanged(currentDockItems)
            handleHomeItemsChanged(removeAppFromHomeItems(homeItems, item))
            return
        }

        val dockIndex = dockDropIndexForPoint(centerXOnScreen, currentDockItems.size)
        currentDockItems.add(
            dockIndex.coerceIn(0, currentDockItems.size),
            LauncherHomeItemUiModel.App(item)
        )
        val overflowItem = if (currentDockItems.size > DOCK_APP_COUNT) {
            currentDockItems.removeAt(DOCK_APP_COUNT)
        } else {
            null
        }

        handleDockItemsChanged(currentDockItems)

        val removedFromHome = removeAppFromHomeItems(homeItems, item)
        val updatedItems = if (overflowItem == null) {
            removedFromHome
        } else {
            insertOverflowDockItemIntoHome(removedFromHome, overflowItem, item, centerXOnScreen)
        }
        handleHomeItemsChanged(updatedItems)
    }

    private fun mergeAppIntoDockTarget(
        target: LauncherHomeItemUiModel,
        app: LauncherIconUiModel
    ): LauncherHomeItemUiModel {
        return when (target) {
            is LauncherHomeItemUiModel.App -> LauncherHomeItemUiModel.Folder(
                id = "dock_folder_${System.nanoTime()}",
                title = LauncherHomeLayoutBuilder.DEFAULT_FOLDER_TITLE,
                apps = listOf(target.iconItem, app)
            )

            is LauncherHomeItemUiModel.Folder -> {
                if (target.apps.any { folderApp -> folderApp.app.iconKey == app.app.iconKey }) {
                    target
                } else {
                    target.copy(apps = target.apps + app)
                }
            }

            is LauncherHomeItemUiModel.Placeholder -> LauncherHomeItemUiModel.App(app)
        }
    }

    private fun insertOverflowDockItemIntoHome(
        baseItems: List<LauncherHomeItemUiModel>,
        overflowItem: LauncherHomeItemUiModel,
        draggedItem: LauncherIconUiModel,
        centerXOnScreen: Float
    ): List<LauncherHomeItemUiModel> {
        val overflowApps = overflowItem.containedApps()
            .filter { overflowApp -> overflowApp.app.iconKey != draggedItem.app.iconKey }
            .filterNot { overflowApp -> containsHomeApp(baseItems, overflowApp) }
        if (overflowApps.isEmpty()) return baseItems

        var insertionIndex = homeDropIndexForPoint(
            centerXOnScreen = centerXOnScreen,
            centerYOnScreen = dockDropFallbackHomeY(),
            itemCountAfterRemoval = baseItems.size
        )
        return overflowApps.fold(baseItems) { currentItems, overflowApp ->
            insertItemAtHomeIndex(
                baseItems = currentItems,
                index = insertionIndex++.coerceIn(0, currentItems.size),
                item = LauncherHomeItemUiModel.App(overflowApp)
            )
        }
    }

    private fun moveDockItemToHome(
        item: LauncherHomeItemUiModel,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ) {
        val updatedDockItems = dockAdapter.itemsSnapshot()
            .filterNot { dockItem -> dockItem.stableId == item.stableId }
        val baseItems = item.containedApps().fold(homeItems) { currentItems, app ->
            removeAppFromHomeItems(currentItems, app)
        }
        val folderTargetIndex = if (item is LauncherHomeItemUiModel.App) {
            homeFolderDropIndexForPoint(
                centerXOnScreen = centerXOnScreen,
                centerYOnScreen = centerYOnScreen,
                items = baseItems
            )
        } else {
            NO_PREVIEW_INDEX
        }
        val dropIndex = homeDropIndexForPoint(
            centerXOnScreen = centerXOnScreen,
            centerYOnScreen = centerYOnScreen,
            itemCountAfterRemoval = baseItems.size,
            items = baseItems
        )
        val updatedItems = LauncherDockHomeDropResolver.resolveDrop(
            baseItems = baseItems,
            dockItem = item,
            dropIndex = dropIndex,
            folderTargetIndex = folderTargetIndex.takeIf { index -> index != NO_PREVIEW_INDEX }
        )
        handleDockItemsChanged(updatedDockItems)
        handleHomeItemsChanged(updatedItems)
    }

    private fun removeAppFromHomeItems(
        items: List<LauncherHomeItemUiModel>,
        app: LauncherIconUiModel
    ): List<LauncherHomeItemUiModel> {
        return removeAppFromItems(items, app)
    }

    private fun removeAppFromItems(
        items: List<LauncherHomeItemUiModel>,
        app: LauncherIconUiModel
    ): List<LauncherHomeItemUiModel> {
        val filteredItems = items.mapNotNull { item ->
            when (item) {
                is LauncherHomeItemUiModel.App -> {
                    item.takeIf { current -> current.iconItem.app.iconKey != app.app.iconKey }
                }

                is LauncherHomeItemUiModel.Folder -> {
                    val remainingApps = item.apps.filterNot { folderApp ->
                        folderApp.app.iconKey == app.app.iconKey
                    }
                    item.copy(apps = remainingApps)
                }

                is LauncherHomeItemUiModel.Placeholder -> item
            }
        }
        return LauncherHomeLayoutBuilder.normalize(filteredItems)
    }

    private fun containsHomeApp(
        items: List<LauncherHomeItemUiModel>,
        app: LauncherIconUiModel
    ): Boolean {
        return items.any { item ->
            item.containedApps().any { containedApp ->
                containedApp.app.iconKey == app.app.iconKey
            }
        }
    }

    private fun dockDropTargetIndexForPoint(
        centerXOnScreen: Float,
        centerYOnScreen: Float,
        draggedApp: LauncherIconUiModel
    ): Int {
        val recyclerView = binding.workspace.dockRecyclerView
        val recyclerLocation = IntArray(2)
        recyclerView.getLocationOnScreen(recyclerLocation)
        val localX = centerXOnScreen - recyclerLocation[0]
        val localY = centerYOnScreen - recyclerLocation[1]
        val draggedItem = LauncherHomeItemUiModel.App(draggedApp)

        for (childIndex in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(childIndex)
            val holder = recyclerView.getChildViewHolder(child)
            val position = holder.bindingAdapterPosition
            if (position == RecyclerView.NO_POSITION) continue
            val targetItem = dockAdapter.itemAt(position) ?: continue

            val iconPlate = child.findViewById<View>(R.id.iconPlate) ?: child
            val plateLeft = child.left + iconPlate.left.toFloat()
            val plateTop = child.top + iconPlate.top.toFloat()
            val plateRight = child.left + iconPlate.right.toFloat()
            val plateBottom = child.top + iconPlate.bottom.toFloat()
            if (!LauncherIos17DragGeometryPolicy.intersectsTargetIcon(
                    dragCenterX = localX,
                    dragCenterY = localY,
                    dragIconWidth = iconPlate.width.toFloat(),
                    dragIconHeight = iconPlate.height.toFloat(),
                    targetLeft = plateLeft,
                    targetTop = plateTop,
                    targetRight = plateRight,
                    targetBottom = plateBottom
                )
            ) {
                continue
            }
            if (iconPlate.width <= 0 || iconPlate.height <= 0) continue

            val action = LauncherHomeHoverDropPolicy.resolveAction(
                draggedItem = draggedItem,
                targetItem = targetItem,
                localXInCell = ((localX - plateLeft) / iconPlate.width).coerceIn(0f, 1f),
                localYInCell = ((localY - plateTop) / iconPlate.height).coerceIn(0f, 1f)
            )
            if (action == LauncherHomeHoverDropAction.FOLDER) {
                return position
            }
        }
        return NO_PREVIEW_INDEX
    }

    private fun dockDropIndexForPoint(centerXOnScreen: Float, itemCount: Int): Int {
        val dockLocation = IntArray(2)
        binding.workspace.dockRecyclerView.getLocationOnScreen(dockLocation)
        val dockWidth = binding.workspace.dockRecyclerView.width.takeIf { width -> width > 0 }
            ?: return itemCount
        val localX = (centerXOnScreen - dockLocation[0]).coerceIn(0f, (dockWidth - 1).toFloat())
        val slotWidth = dockWidth / DOCK_APP_COUNT.toFloat()
        return (localX / slotWidth).toInt().coerceIn(0, DOCK_APP_COUNT - 1)
    }

    private fun homeDropIndexForPoint(
        centerXOnScreen: Float,
        centerYOnScreen: Float,
        itemCountAfterRemoval: Int,
        items: List<LauncherHomeItemUiModel> = homeItems
    ): Int {
        val pager = binding.workspace.workspacePager
        val pagerWidth = pager.width.takeIf { width -> width > 0 } ?: return itemCountAfterRemoval
        val pagerHeight = pager.height.takeIf { height -> height > 0 } ?: return itemCountAfterRemoval
        val pagerLocation = IntArray(2)
        pager.getLocationOnScreen(pagerLocation)

        val localX = (centerXOnScreen - pagerLocation[0]).coerceIn(0f, (pagerWidth - 1).toFloat())
        val localY = (centerYOnScreen - pagerLocation[1]).coerceIn(0f, (pagerHeight - 1).toFloat())
        val cellWidth = pagerWidth / HOME_PAGE_COLUMNS.toFloat()
        val cellHeight = pagerHeight / effectiveHomeGridRows.toFloat()
        val column = (localX / cellWidth).toInt().coerceIn(0, HOME_PAGE_COLUMNS - 1)
        val row = (localY / cellHeight).toInt().coerceIn(0, effectiveHomeGridRows - 1)
        val insertAfterTarget = localX - column * cellWidth > cellWidth / 2f
        val pageCount = homePageCountForItemCount(itemCountAfterRemoval + 1)
        val page = currentHomePageIndex().coerceIn(0, pageCount - 1)
        val targetIndex = page * homePageSize + row * HOME_PAGE_COLUMNS + column
        val targetItem = items.getOrNull(targetIndex)
        if (targetItem == null || targetItem is LauncherHomeItemUiModel.Placeholder) {
            return targetIndex
        }
        return (targetIndex + if (insertAfterTarget) 1 else 0).coerceIn(0, itemCountAfterRemoval)
    }

    private fun homeFolderDropIndexForPoint(
        centerXOnScreen: Float,
        centerYOnScreen: Float,
        items: List<LauncherHomeItemUiModel>
    ): Int {
        val target = homeTargetCellForPoint(centerXOnScreen, centerYOnScreen, items)
            ?: return NO_PREVIEW_INDEX
        val item = items.getOrNull(target.index) ?: return NO_PREVIEW_INDEX
        if (item !is LauncherHomeItemUiModel.App && item !is LauncherHomeItemUiModel.Folder) {
            return NO_PREVIEW_INDEX
        }
        val overTargetCenter = LauncherIos17DragGeometryPolicy.isFolderInterest(
            localXInIcon = target.localXInCell,
            localYInIcon = target.localYInCell
        )
        return if (overTargetCenter) target.index else NO_PREVIEW_INDEX
    }

    private fun homeTargetCellForPoint(
        centerXOnScreen: Float,
        centerYOnScreen: Float,
        items: List<LauncherHomeItemUiModel>
    ): HomeEdgeTargetCell? {
        val pager = binding.workspace.workspacePager
        val pagerWidth = pager.width.takeIf { width -> width > 0 } ?: return null
        val pagerHeight = pager.height.takeIf { height -> height > 0 } ?: return null
        val pagerLocation = IntArray(2)
        pager.getLocationOnScreen(pagerLocation)

        val localX = (centerXOnScreen - pagerLocation[0]).coerceIn(0f, (pagerWidth - 1).toFloat())
        val localY = (centerYOnScreen - pagerLocation[1]).coerceIn(0f, (pagerHeight - 1).toFloat())
        val cellWidth = pagerWidth / HOME_PAGE_COLUMNS.toFloat()
        val cellHeight = pagerHeight / effectiveHomeGridRows.toFloat()
        val column = (localX / cellWidth).toInt().coerceIn(0, HOME_PAGE_COLUMNS - 1)
        val row = (localY / cellHeight).toInt().coerceIn(0, effectiveHomeGridRows - 1)
        val pageCount = homePageCountForItemCount(items.size + 1)
        val page = currentHomePageIndex().coerceIn(0, pageCount - 1)
        return HomeEdgeTargetCell(
            index = page * homePageSize + row * HOME_PAGE_COLUMNS + column,
            localXInCell = ((localX - column * cellWidth) / cellWidth).coerceIn(0f, 1f),
            localYInCell = ((localY - row * cellHeight) / cellHeight).coerceIn(0f, 1f)
        )
    }

    private fun dockDropFallbackHomeY(): Float {
        val pagerLocation = IntArray(2)
        binding.workspace.workspacePager.getLocationOnScreen(pagerLocation)
        return pagerLocation[1] + binding.workspace.workspacePager.height * 0.72f
    }

    private fun finishHomeEdgeDrag(commit: Boolean) {
        if (!homeEdgeDragActive || homeEdgeCommitted) return

        if (!commit) {
            hideHomeEdgeDragPreview(restoreWorkspace = true)
            return
        }
        homeEdgeCommitted = true

        val draggedItem = homeEdgeDraggedItem
            ?: return hideHomeEdgeDragPreview(restoreWorkspace = true)
        val draggedApp = (draggedItem as? LauncherHomeItemUiModel.App)?.iconItem
        val folderTargetIndex = if (draggedApp != null) {
            homeEdgeFolderDropIndex()
        } else {
            NO_PREVIEW_INDEX
        }
        val dropIndex = if (homeEdgePreviewIndex != NO_PREVIEW_INDEX) {
            homeEdgePreviewIndex
        } else {
            homeEdgeHomeDropIndex()
        }
        val updatedItems = if (draggedApp != null) {
            if (homeEdgeDragFromDock) {
                LauncherDockHomeDropResolver.resolveDrop(
                    baseItems = homeEdgeBaseItems,
                    dockItem = draggedItem,
                    dropIndex = dropIndex,
                    folderTargetIndex = folderTargetIndex.takeIf { index -> index != NO_PREVIEW_INDEX }
                )
            } else {
                LauncherFolderExitDropResolver.resolveDrop(
                    baseItems = homeEdgeBaseItems,
                    draggedApp = draggedApp,
                    dropIndex = dropIndex,
                    folderTargetIndex = folderTargetIndex.takeIf { index -> index != NO_PREVIEW_INDEX }
                )
            }
        } else if (homeEdgeDragFromDock) {
            LauncherDockHomeDropResolver.resolveDrop(
                baseItems = homeEdgeBaseItems,
                dockItem = draggedItem,
                dropIndex = dropIndex,
                folderTargetIndex = null
            )
        } else {
            LauncherHomeItemDropResolver.resolveDrop(
                baseItems = homeEdgeBaseItems,
                draggedItem = draggedItem,
                dropIndex = dropIndex,
                sourcePlaceholderStableId = homeEdgeDragPlaceholder?.stableId,
                columns = HOME_PAGE_COLUMNS,
                rows = effectiveHomeGridRows
            )
        }
        val committedPage = homeEdgeDragPage
        val updatedDockItems = if (homeEdgeDragFromDock) {
            dockAdapter.itemsSnapshot()
                .filterNot { dockItem -> dockItem.stableId == draggedItem.stableId }
        } else {
            null
        }

        homeEdgeSwitchHandler.removeCallbacks(homeEdgeSwitchRunnable)
        hideFolderEdgeGlows()
        binding.workspace.workspacePager.post {
            if (!homeEdgeCommitted) return@post
            updatedDockItems?.let { items -> handleDockItemsChanged(items) }
            handleHomeItemsChanged(updatedItems, preferredPage = committedPage)
            dropCommitRenderGate.afterCommittedRender {
                hideHomeEdgeDragPreview(restoreWorkspace = false)
            }
        }
    }

    private fun beginHomeEdgeDragIfNeeded(
        draggedItem: LauncherHomeItemUiModel,
        viewHolder: RecyclerView.ViewHolder
    ) {
        if (homeEdgeDraggedItem != null) return

        homeEdgeDraggedItem = draggedItem
        homeEdgeDragFromDock = false
        homeEdgeCommitted = false
        homeEdgeTouchActive = true
        homeEdgePageSwitching = false
        homeEdgeDragPlaceholder = LauncherHomeItemUiModel.Placeholder.forDragSession()
        homeEdgeBaseItems = LauncherHomeDragBaseBuilder.forMovingItem(
            items = homeItems,
            draggedItem = draggedItem,
            placeholder = homeEdgeDragPlaceholder
        )
        homeEdgeSourcePage = currentHomePageIndex()
        homeEdgeHasLeftSourcePage = false
        homeEdgeDragPage = currentHomePageIndex().coerceAtMost(
            maxOf(0, homePageCountForItemCount(homeEdgeBaseItems.size + 1) - 1)
        )
        homeEdgePreviewIndex = NO_PREVIEW_INDEX
        binding.workspace.workspacePager.isUserInputEnabled = false
        binding.workspace.selectedIconImage.setImageDrawable(homeEdgePreviewDrawable(draggedItem, viewHolder))
        binding.workspace.selectedIconLabel.text = draggedItem.label
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

    private fun beginDockHomeEdgeDragIfNeeded(
        draggedItem: LauncherHomeItemUiModel,
        viewHolder: RecyclerView.ViewHolder
    ) {
        if (homeEdgeDraggedItem != null) return

        homeEdgeDraggedItem = draggedItem
        homeEdgeDragFromDock = true
        homeEdgeCommitted = false
        homeEdgeTouchActive = true
        homeEdgePageSwitching = false
        homeEdgeDragPlaceholder = LauncherHomeItemUiModel.Placeholder.forDragSession()
        homeEdgeBaseItems = draggedItem.containedApps().fold(homeItems) { currentItems, app ->
            removeAppFromHomeItems(currentItems, app)
        }
        homeEdgeSourcePage = currentHomePageIndex()
        homeEdgeHasLeftSourcePage = true
        homeEdgeDragPage = currentHomePageIndex().coerceAtMost(
            maxOf(0, homePageCountForItemCount(homeEdgeBaseItems.size + 1) - 1)
        )
        homeEdgePreviewIndex = NO_PREVIEW_INDEX
        homeEdgeFolderTargetIndex = NO_PREVIEW_INDEX
        homeEdgeDirection = 0
        binding.workspace.workspacePager.isUserInputEnabled = false
        binding.workspace.selectedIconImage.setImageDrawable(homeEdgePreviewDrawable(draggedItem, viewHolder))
        binding.workspace.selectedIconLabel.text = draggedItem.label
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

    private fun homeEdgePreviewDrawable(
        item: LauncherHomeItemUiModel,
        viewHolder: RecyclerView.ViewHolder
    ): Drawable? {
        if (item is LauncherHomeItemUiModel.App) {
            return item.iconItem.displayIcon
        }

        val fallbackDrawable = (item as? LauncherHomeItemUiModel.Folder)
            ?.apps
            ?.firstOrNull()
            ?.displayIcon
        val iconPlate = viewHolder.itemView.findViewById<View>(R.id.iconPlate)
            ?: return fallbackDrawable
        if (iconPlate.width <= 0 || iconPlate.height <= 0) {
            return fallbackDrawable
        }

        val removeBadge = iconPlate.findViewById<View>(R.id.removeBadge)
        val previousBadgeVisibility = removeBadge?.visibility
        return try {
            removeBadge?.visibility = View.GONE
            val bitmap = Bitmap.createBitmap(
                iconPlate.width,
                iconPlate.height,
                Bitmap.Config.ARGB_8888
            )
            iconPlate.draw(Canvas(bitmap))
            BitmapDrawable(resources, bitmap)
        } finally {
            if (previousBadgeVisibility != null) {
                removeBadge.visibility = previousBadgeVisibility
            }
        }
    }

    private fun handleHomeEdgeExternalDragEvent(event: MotionEvent): Boolean {
        if (!homeEdgeDragActive) return false

        if (homeEdgeCommitted) return true

        when (event.actionMasked) {
            MotionEvent.ACTION_MOVE -> updateHomeEdgeDragPosition(event.rawX, event.rawY)

            MotionEvent.ACTION_UP -> {
                homeEdgeTouchActive = false
                updateHomeEdgeDragPosition(event.rawX, event.rawY)
                finishHomeEdgeDrag(commit = true)
            }

            MotionEvent.ACTION_CANCEL -> {
                homeEdgeTouchActive = false
                updateHomeEdgeDragPosition(event.rawX, event.rawY)
                finishHomeEdgeDrag(commit = false)
            }
        }
        return true
    }

    private fun updateHomeEdgeDragPosition(centerXOnScreen: Float, centerYOnScreen: Float) {
        if (homeEdgeDraggedItem == null) return

        val rootLocation = IntArray(2)
        binding.workspace.root.getLocationOnScreen(rootLocation)
        val previewWidth = binding.workspace.selectedIconPreview.width.takeIf { it > 0 } ?: dp(DRAG_PREVIEW_WIDTH_DP)
        val previewHeight = binding.workspace.selectedIconPreview.height.takeIf { it > 0 } ?: dp(DRAG_PREVIEW_HEIGHT_DP)
        val rootWidth = binding.workspace.root.width.takeIf { it > 0 } ?: resources.displayMetrics.widthPixels
        val rootHeight = binding.workspace.root.height.takeIf { it > 0 } ?: resources.displayMetrics.heightPixels
        val rootCenterX = (centerXOnScreen - rootLocation[0]).coerceIn(0f, rootWidth.toFloat())
        val rootCenterY = (centerYOnScreen - rootLocation[1]).coerceIn(0f, rootHeight.toFloat())
        val previewPosition = LauncherDragPreviewPositioner.positionForIconCenter(
            rootWidth = rootWidth,
            rootHeight = rootHeight,
            previewWidth = previewWidth,
            previewHeight = previewHeight,
            iconCenterY = dp(DRAG_PREVIEW_ICON_CENTER_Y_DP),
            centerX = rootCenterX,
            centerY = rootCenterY,
            horizontalPadding = dp(4),
            verticalPadding = dp(12)
        )

        homeEdgeDragCenterX = rootCenterX
        homeEdgeDragCenterY = rootCenterY
        binding.workspace.selectedIconPreview.x = previewPosition.left.toFloat()
        binding.workspace.selectedIconPreview.y = previewPosition.top.toFloat()
        updateHomeEdgeState(rootCenterX, rootWidth)
        updateHomeEdgePreview()
    }

    private fun updateHomeEdgePreview() {
        val draggedItem = homeEdgeDraggedItem ?: return
        if (!LauncherHomeEdgePreviewPolicy.shouldUpdatePreview(
                dragActive = homeEdgeDragActive,
                pageSwitching = homeEdgePageSwitching,
                edgeDirection = currentHomeEdgeDirection(),
                dragPage = homeEdgeDragPage,
                sourcePage = homeEdgeSourcePage,
                hasLeftSourcePage = homeEdgeHasLeftSourcePage
            )
        ) {
            homeEdgePreviewIndex = NO_PREVIEW_INDEX
            homeEdgeFolderTargetIndex = NO_PREVIEW_INDEX
            workspacePageAdapter.clearTemporaryHomeDragPreview()
            return
        }

        val insertIndex = homeEdgeHomeDropIndex()
        val draggedApp = (draggedItem as? LauncherHomeItemUiModel.App)?.iconItem
        val folderTargetIndex = if (draggedApp != null) {
            homeEdgeFolderDropIndex()
        } else {
            NO_PREVIEW_INDEX
        }
        if (insertIndex == homeEdgePreviewIndex && folderTargetIndex == homeEdgeFolderTargetIndex) return

        homeEdgePreviewIndex = insertIndex
        homeEdgeFolderTargetIndex = folderTargetIndex
        val previewItems = if (draggedApp != null && folderTargetIndex != NO_PREVIEW_INDEX) {
            LauncherFolderExitDropResolver.resolveDrop(
                baseItems = homeEdgeBaseItems,
                draggedApp = draggedApp,
                dropIndex = insertIndex,
                folderTargetIndex = folderTargetIndex
            )
        } else {
            LauncherHomeItemDropResolver.resolveDrop(
                baseItems = homeEdgeBaseItems,
                draggedItem = homeEdgeDragPlaceholder
                    ?: LauncherHomeItemUiModel.Placeholder.forGridIndex(insertIndex),
                dropIndex = insertIndex,
                columns = HOME_PAGE_COLUMNS,
                rows = effectiveHomeGridRows
            )
        }
        workspacePageAdapter.applyTemporaryHomeDragPreview(
            baseItems = homeEdgeBaseItems,
            previewItems = previewItems,
            focusPage = homeEdgeDragPage
        )
    }

    private fun updateHomeEdgeState(rootCenterX: Float, rootWidth: Int) {
        val direction = homeEdgeDirectionForCenter(rootCenterX, rootWidth)

        binding.workspace.folderDragLeftEdgeGlow.visibility = if (direction < 0) View.VISIBLE else View.GONE
        binding.workspace.folderDragRightEdgeGlow.visibility = if (direction > 0) View.VISIBLE else View.GONE

        if (homeEdgePageSwitching) {
            homeEdgeSwitchHandler.removeCallbacks(homeEdgeSwitchRunnable)
            homeEdgeDirection = 0
            return
        }

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

    private fun currentHomeEdgeDirection(): Int {
        val rootWidth = binding.workspace.root.width
        if (rootWidth <= 0) return 0
        return homeEdgeDirectionForCenter(homeEdgeDragCenterX, rootWidth)
    }

    private fun homeEdgeDirectionForCenter(rootCenterX: Float, rootWidth: Int): Int {
        return LauncherHomePageEdgeDragPolicy.directionForCenter(
            rootCenterX = rootCenterX,
            rootWidth = rootWidth,
            edgeZonePx = dp(HOME_EDGE_SWITCH_ZONE_DP)
        )
    }

    private fun performHomeEdgeSwitch() {
        val direction = homeEdgeDirection
        if (!homeEdgeDragActive || homeEdgeCommitted || homeEdgePageSwitching || direction == 0) return

        var baseChanged = false
        if (direction < 0 && homeEdgeDragPage == 0) {
            homeEdgeDirection = 0
            hideFolderEdgeGlows()
            return
        } else {
            val targetPage = maxOf(0, homeEdgeDragPage + direction)
            if (targetPage >= homePageCountForItemCount(homeEdgeBaseItems.size + 1)) {
                if (!LauncherIos17DragDropPolicy.canCreateNextPage(
                        currentPageItemCount = homeEdgePageItemCount(homeEdgeDragPage),
                        autoArrange = layoutAutoArrange
                    )
                ) {
                    homeEdgeDirection = 0
                    hideFolderEdgeGlows()
                    return
                }
                homeEdgeBaseItems = ensurePageExists(homeEdgeBaseItems, targetPage)
                baseChanged = true
            }
            homeEdgeDragPage = targetPage
            if (targetPage != homeEdgeSourcePage) {
                homeEdgeHasLeftSourcePage = true
            }
        }
        homeEdgePreviewIndex = NO_PREVIEW_INDEX
        homeEdgeFolderTargetIndex = NO_PREVIEW_INDEX
        workspacePageAdapter.clearTemporaryHomeDragPreview()
        if (baseChanged) {
            workspacePageAdapter.ensureTemporaryHomePage(homeEdgeDragPage)
        }
        binding.workspace.workspacePager.postDelayed({
            if (homeEdgeDragActive) {
                smoothScrollHomeEdgeToPage(homeEdgeDragPage)
            }
        }, if (baseChanged) HOME_EDGE_NEW_PAGE_SWITCH_START_DELAY_MS else HOME_EDGE_SWITCH_START_DELAY_MS)
        showPageIndicator(workspacePageAdapter.adapterPositionForHomePage(homeEdgeDragPage))
        homeEdgeDirection = 0
    }

    private fun homeEdgePageItemCount(page: Int): Int {
        val start = page.coerceAtLeast(0) * homePageSize
        val end = start + homePageSize
        return homeEdgeBaseItems
            .subList(start.coerceAtMost(homeEdgeBaseItems.size), end.coerceAtMost(homeEdgeBaseItems.size))
            .count { item -> item !is LauncherHomeItemUiModel.Placeholder }
    }

    private fun smoothScrollHomeEdgeToPage(homePage: Int) {
        val targetAdapterPosition = workspacePageAdapter.adapterPositionForHomePage(homePage)
        val pager = binding.workspace.workspacePager
        if (pager.currentItem == targetAdapterPosition) {
            pager.post { updateHomeEdgePreview() }
            return
        }

        homeEdgePageSwitching = true
        val recyclerView = pager.getChildAt(0) as? RecyclerView
        val layoutManager = recyclerView?.layoutManager as? LinearLayoutManager
        if (layoutManager == null) {
            pager.setCurrentItem(targetAdapterPosition, true)
        } else {
            val smoothScroller = object : LinearSmoothScroller(this) {
                override fun calculateTimeForScrolling(dx: Int): Int {
                    return HOME_EDGE_PAGE_SWITCH_ANIMATION_MS.toInt()
                }

                override fun calculateTimeForDeceleration(dx: Int): Int {
                    return HOME_EDGE_PAGE_SWITCH_ANIMATION_MS.toInt()
                }

                override fun getHorizontalSnapPreference(): Int {
                    return SNAP_TO_START
                }
            }
            smoothScroller.targetPosition = targetAdapterPosition
            layoutManager.startSmoothScroll(smoothScroller)
        }

        pager.postDelayed(
            {
                homeEdgePageSwitching = false
                if (!homeEdgeDragActive || homeEdgeCommitted) return@postDelayed
                if (pager.currentItem != targetAdapterPosition &&
                    pager.scrollState == ViewPager2.SCROLL_STATE_IDLE
                ) {
                    pager.setCurrentItem(targetAdapterPosition, false)
                }
                updateHomeEdgePreview()
            },
            HOME_EDGE_PAGE_SWITCH_ANIMATION_MS + HOME_EDGE_PAGE_SWITCH_SETTLE_MS
        )
    }

    private fun ensurePageExists(
        items: List<LauncherHomeItemUiModel>,
        page: Int
    ): List<LauncherHomeItemUiModel> {
        return LauncherHomeScreenGridPolicy.ensurePageExists(
            items = items,
            page = page,
            pageSize = homePageSize
        )
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
        val cellHeight = pagerHeight / effectiveHomeGridRows.toFloat()
        val column = (localX / cellWidth).toInt().coerceIn(0, HOME_PAGE_COLUMNS - 1)
        val row = (localY / cellHeight).toInt().coerceIn(0, effectiveHomeGridRows - 1)
        val insertAfterTarget = localX - column * cellWidth > cellWidth / 2f
        val targetIndex = homeEdgeDragPage * homePageSize +
            row * HOME_PAGE_COLUMNS +
            column
        if (homeEdgeBaseItems.getOrNull(targetIndex) is LauncherHomeItemUiModel.Placeholder) {
            return targetIndex
        }
        return targetIndex + if (insertAfterTarget) 1 else 0
    }

    private fun homeEdgeFolderDropIndex(): Int {
        val target = homeEdgeTargetCell() ?: return NO_PREVIEW_INDEX
        val item = homeEdgeBaseItems.getOrNull(target.index) ?: return NO_PREVIEW_INDEX
        if (item !is LauncherHomeItemUiModel.App && item !is LauncherHomeItemUiModel.Folder) {
            return NO_PREVIEW_INDEX
        }
        val overTargetCenter = LauncherIos17DragGeometryPolicy.isFolderInterest(
            localXInIcon = target.localXInCell,
            localYInIcon = target.localYInCell
        )
        return if (overTargetCenter) target.index else NO_PREVIEW_INDEX
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
        val cellHeight = pagerHeight / effectiveHomeGridRows.toFloat()
        val column = (localX / cellWidth).toInt().coerceIn(0, HOME_PAGE_COLUMNS - 1)
        val row = (localY / cellHeight).toInt().coerceIn(0, effectiveHomeGridRows - 1)
        val localXInCell = ((localX - column * cellWidth) / cellWidth).coerceIn(0f, 1f)
        val localYInCell = ((localY - row * cellHeight) / cellHeight).coerceIn(0f, 1f)
        return HomeEdgeTargetCell(
            index = homeEdgeDragPage * homePageSize + row * HOME_PAGE_COLUMNS + column,
            localXInCell = localXInCell,
            localYInCell = localYInCell
        )
    }

    private fun insertItemAtHomeIndex(
        baseItems: List<LauncherHomeItemUiModel>,
        index: Int,
        item: LauncherHomeItemUiModel
    ): List<LauncherHomeItemUiModel> {
        val targetIndex = index.coerceAtLeast(0)
        return baseItems.toMutableList().apply {
            while (size < targetIndex) {
                add(LauncherHomeItemUiModel.Placeholder.forGridIndex(size))
            }
            val boundedIndex = targetIndex.coerceAtMost(size)
            if (getOrNull(boundedIndex) is LauncherHomeItemUiModel.Placeholder) {
                this[boundedIndex] = item
            } else {
                add(boundedIndex, item)
            }
        }
    }

    private fun hideHomeEdgeDragPreview(restoreWorkspace: Boolean) {
        workspacePageAdapter.clearTemporaryHomeDragPreview()
        if (restoreWorkspace) {
            workspacePageAdapter.submitItems(homeItems)
            updateWorkspaceChromeForPage(binding.workspace.workspacePager.currentItem)
            updatePageIndicatorDotsForAdapterPosition(binding.workspace.workspacePager.currentItem)
        }
        homeEdgeDragActive = false
        homeEdgeDraggedItem = null
        homeEdgeDragPlaceholder = null
        homeEdgeBaseItems = emptyList()
        homeEdgeDragFromDock = false
        homeEdgeSourcePage = 0
        homeEdgeHasLeftSourcePage = false
        homeEdgePreviewIndex = NO_PREVIEW_INDEX
        homeEdgeFolderTargetIndex = NO_PREVIEW_INDEX
        homeEdgeDirection = 0
        homeEdgeCommitted = false
        homeEdgeTouchActive = false
        homeEdgePageSwitching = false
        homeEdgeSwitchHandler.removeCallbacks(homeEdgeSwitchRunnable)
        hideFolderEdgeGlows()
        binding.workspace.workspacePager.isUserInputEnabled = true
        forceHideSelectedIconPreview()
    }

    private fun showFolderOverlay(folder: LauncherHomeItemUiModel.Folder, source: FolderSource = FolderSource.HOME) {
        openFolderSource = source
        folderController.show(folder)
    }

    private fun hideFolderOverlay(
        restoreFolderExitPreview: Boolean = true,
        restoreFolderOverlayBackground: Boolean = true,
        animate: Boolean = true
    ) {
        hideFolderExitDragPreview(restoreWorkspace = restoreFolderExitPreview)
        resetFolderExitDragVisuals(restoreFolderOverlayBackground)
        folderController.hide(animate = animate)
        if (!animate && !restoreFolderOverlayBackground) {
            binding.workspace.folderOverlay.setBackgroundColor(folderOverlayDimColor())
        }
        openFolderSource = FolderSource.HOME
    }

    private fun updateOpenFolderContent() {
        folderController.updateContent(
            if (openFolderSource == FolderSource.DOCK) {
                dockItems
            } else {
                homeItems
            }
        )
    }

    private fun handleOpenFolderItemsChanged(items: List<LauncherHomeItemUiModel>) {
        val folderId = folderController.currentFolderId() ?: return
        val reorderedApps = LauncherHomeLayoutBuilder.flattenApps(items)
        if (openFolderSource == FolderSource.DOCK) {
            val updatedDockItems = dockItems.flatMap { item ->
                if (item is LauncherHomeItemUiModel.Folder && item.id == folderId) {
                    LauncherHomeLayoutBuilder.normalize(listOf(item.copy(apps = reorderedApps)))
                } else {
                    listOf(item)
                }
            }
            handleDockItemsChanged(updatedDockItems)
            return
        }

        val updatedItems = homeItems.flatMap { item ->
            if (item is LauncherHomeItemUiModel.Folder && item.id == folderId) {
                LauncherHomeLayoutBuilder.normalize(listOf(item.copy(apps = reorderedApps)))
            } else {
                listOf(item)
            }
        }
        handleHomeItemsChanged(updatedItems)
    }

    private fun handleFolderItemDroppedOutside(item: LauncherHomeItemUiModel?): Boolean {
        val draggedApp = folderExitDraggedApp
            ?: (item as? LauncherHomeItemUiModel.App)?.iconItem
            ?: return false
        if (!folderExitDropCommitGuard.tryCommit()) return true

        val baseItems = folderExitBaseHomeItems.ifEmpty {
            removeAppFromOpenFolder(draggedApp)
        }
        val folderTargetIndex = folderExitFolderDropIndex(baseItems)
            .takeIf { index -> index != NO_PREVIEW_INDEX }
        val dropIndex = if (folderExitPreviewIndex != NO_PREVIEW_INDEX) {
            folderExitPreviewIndex
        } else {
            folderExitHomeDropIndex()
        }
        val updatedItems = LauncherFolderExitDropResolver.resolveDrop(
            baseItems = baseItems,
            draggedApp = draggedApp,
            dropIndex = dropIndex,
            folderTargetIndex = folderTargetIndex
        )

        if (openFolderSource == FolderSource.DOCK) {
            handleDockItemsChanged(removeAppFromDockFolder(draggedApp))
        }
        folderContentAdapter.clearActiveTouch()
        folderContentAdapter.setActiveDragStableId(null)
        handleHomeItemsChanged(
            items = updatedItems,
            preferredPage = folderExitDragPage,
            refreshOpenFolder = false,
            refreshAppearance = false
        )
        dropCommitRenderGate.afterCommittedRender {
            hideFolderOverlay(
                restoreFolderExitPreview = false,
                restoreFolderOverlayBackground = false,
                animate = false
            )
        }
        return true
    }

    private fun isFolderDragCenterOutsidePanel(centerXOnScreen: Float, centerYOnScreen: Float): Boolean {
        val panel = binding.workspace.folderContentPanel
        val panelLocation = IntArray(2)
        panel.getLocationOnScreen(panelLocation)
        val hitScaleX = if (folderExitDragCollapsed) FOLDER_EXIT_COLLAPSED_PANEL_SCALE else panel.scaleX
        val hitScaleY = if (folderExitDragCollapsed) FOLDER_EXIT_COLLAPSED_PANEL_SCALE else panel.scaleY

        return LauncherScaledBoundsHitTest.isOutside(
            pointX = centerXOnScreen,
            pointY = centerYOnScreen,
            left = panelLocation[0].toFloat(),
            top = panelLocation[1].toFloat(),
            width = panel.width.toFloat(),
            height = panel.height.toFloat(),
            scaleX = hitScaleX,
            scaleY = hitScaleY,
            slop = dp(FOLDER_EXIT_SLOP_DP).toFloat()
        )
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

    private fun handleFolderDragMoved(
        item: LauncherHomeItemUiModel?,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ): Boolean {
        if (!editingHome) return false
        if (!isFolderDragCenterOutsidePanel(centerXOnScreen, centerYOnScreen)) {
            return false
        }

        showFolderExitDragPreview(item, centerXOnScreen, centerYOnScreen)
        return true
    }

    private fun handleFolderDragEnded(
        item: LauncherHomeItemUiModel?,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ): Boolean {
        if (!folderExitDragActive) return false

        val dropCenterX = folderExitDragCenterXOnScreen.takeIf { it > 0f } ?: centerXOnScreen
        val dropCenterY = folderExitDragCenterYOnScreen.takeIf { it > 0f } ?: centerYOnScreen
        updateFolderExitDragPosition(dropCenterX, dropCenterY, immediate = true)
        return if (isFolderDragCenterOutsidePanel(dropCenterX, dropCenterY)) {
            handleFolderItemDroppedOutside(item)
        } else {
            hideFolderExitDragPreview(restoreWorkspace = true)
            restoreOpenFolderAfterExitDrag()
            true
        }
    }

    private fun showFolderExitDragPreview(
        item: LauncherHomeItemUiModel?,
        centerXOnScreen: Float,
        centerYOnScreen: Float
    ) {
        val draggedApp = (item as? LauncherHomeItemUiModel.App)?.iconItem
            ?: folderExitDraggedApp
            ?: return
        beginFolderExitDragIfNeeded(draggedApp)

        collapseOpenFolderForExitDrag()
        bindFolderExitDragPreviewIfNeeded(draggedApp)
        val firstPosition = folderExitDragCenterXOnScreen == 0f && folderExitDragCenterYOnScreen == 0f
        updateFolderExitDragPosition(centerXOnScreen, centerYOnScreen, immediate = firstPosition)
    }

    private fun bindFolderExitDragPreviewIfNeeded(draggedApp: LauncherIconUiModel) {
        val iconKey = draggedApp.app.iconKey
        if (folderExitPreviewIconKey == iconKey &&
            binding.workspace.selectedIconPreview.visibility == View.VISIBLE
        ) {
            return
        }

        folderExitPreviewIconKey = iconKey
        binding.workspace.selectedIconImage.setImageDrawable(draggedApp.displayIcon)
        binding.workspace.selectedIconLabel.text = draggedApp.label
        binding.workspace.selectedIconPreview.bringToFront()
        binding.workspace.selectedIconPreview.apply {
            animate().cancel()
            setLayerType(View.LAYER_TYPE_HARDWARE, null)
            alpha = 1f
            scaleX = 1.08f
            scaleY = 1.08f
            elevation = dp(DRAG_PREVIEW_ELEVATION_DP).toFloat()
            translationZ = dp(FOLDER_EXIT_PREVIEW_ELEVATION_DP).toFloat()
            visibility = View.VISIBLE
        }
        if (folderExitDragMetrics == null) {
            folderExitDragMetrics = captureFolderExitDragMetrics()
        }
    }

    private fun hideFolderExitDragPreview(restoreWorkspace: Boolean = false) {
        if (restoreWorkspace && folderExitBaseHomeItems.isNotEmpty()) {
            workspacePageAdapter.submitItems(homeItems)
            updateWorkspaceChromeForPage(binding.workspace.workspacePager.currentItem)
            updatePageIndicatorDotsForAdapterPosition(binding.workspace.workspacePager.currentItem)
        }
        folderExitDragActive = false
        folderExitDraggedApp = null
        folderExitBaseHomeItems = emptyList()
        folderExitPreviewIconKey = null
        folderExitDragMetrics = null
        folderExitPreviewIndex = NO_PREVIEW_INDEX
        folderExitFolderTargetIndex = NO_PREVIEW_INDEX
        folderExitEdgeDirection = 0
        folderExitDragCenterXOnScreen = 0f
        folderExitDragCenterYOnScreen = 0f
        folderExitPendingCenterXOnScreen = 0f
        folderExitPendingCenterYOnScreen = 0f
        folderExitPositionFramePosted = false
        binding.workspace.root.removeCallbacks(folderExitPositionRunnable)
        if (::folderContentAdapter.isInitialized) {
            folderContentAdapter.clearActiveTouch()
            folderContentAdapter.setActiveDragStableId(null)
        }
        folderEdgeSwitchHandler.removeCallbacks(folderEdgeSwitchRunnable)
        hideFolderEdgeGlows()
        binding.workspace.workspacePager.isUserInputEnabled = true
        forceHideSelectedIconPreview()
    }

    private fun beginFolderExitDragIfNeeded(draggedApp: LauncherIconUiModel) {
        if (folderExitDraggedApp != null) return

        folderExitDragActive = true
        folderExitDropCommitGuard.beginDrag()
        folderExitDraggedApp = draggedApp
        folderExitBaseHomeItems = removeAppFromOpenFolder(draggedApp)
        folderExitDragPage = currentHomePageIndex().coerceIn(
            0,
            homePageCountForItemCount(folderExitBaseHomeItems.size + 1) - 1
        )
        folderExitPreviewIndex = NO_PREVIEW_INDEX
        folderExitFolderTargetIndex = NO_PREVIEW_INDEX
        folderExitPreviewIconKey = null
        folderExitDragMetrics = null
        binding.workspace.workspacePager.isUserInputEnabled = false
    }

    private fun removeAppFromOpenFolder(draggedApp: LauncherIconUiModel): List<LauncherHomeItemUiModel> {
        val folderId = folderController.currentFolderId() ?: return homeItems
        if (openFolderSource == FolderSource.DOCK) {
            return homeItems
        }
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

    private fun removeAppFromDockFolder(draggedApp: LauncherIconUiModel): List<LauncherHomeItemUiModel> {
        val folderId = folderController.currentFolderId() ?: return dockItems
        return dockItems.flatMap { dockItem ->
            if (dockItem is LauncherHomeItemUiModel.Folder && dockItem.id == folderId) {
                val remainingApps = dockItem.apps.filterNot { app ->
                    app.app.iconKey == draggedApp.app.iconKey
                }
                LauncherHomeLayoutBuilder.normalize(listOf(dockItem.copy(apps = remainingApps)))
            } else {
                listOf(dockItem)
            }
        }
    }

    private fun handleFolderExitExternalDragEvent(event: MotionEvent): Boolean {
        if (!folderExitDragActive) return false

        if (::folderContentAdapter.isInitialized) {
            folderContentAdapter.updateActiveTouch(event.rawX, event.rawY)
        }
        when (event.actionMasked) {
            MotionEvent.ACTION_MOVE -> updateFolderExitDragPosition(event.rawX, event.rawY)

            MotionEvent.ACTION_UP -> {
                updateFolderExitDragPosition(event.rawX, event.rawY, immediate = true)
                folderEdgeSwitchHandler.removeCallbacks(folderEdgeSwitchRunnable)
                hideFolderEdgeGlows()
                folderExitEdgeDirection = 0
                if (isFolderDragCenterOutsidePanel(event.rawX, event.rawY)) {
                    handleFolderItemDroppedOutside(null)
                } else {
                    hideFolderExitDragPreview(restoreWorkspace = true)
                    restoreOpenFolderAfterExitDrag()
                }
            }

            MotionEvent.ACTION_CANCEL -> {
                updateFolderExitDragPosition(event.rawX, event.rawY, immediate = true)
                folderEdgeSwitchHandler.removeCallbacks(folderEdgeSwitchRunnable)
                hideFolderEdgeGlows()
                folderExitEdgeDirection = 0
                hideFolderExitDragPreview(restoreWorkspace = true)
                restoreOpenFolderAfterExitDrag()
            }
        }
        return true
    }

    private fun updateFolderExitDragPosition(
        centerXOnScreen: Float,
        centerYOnScreen: Float,
        immediate: Boolean = false
    ) {
        if (folderExitDraggedApp == null) return

        folderExitPendingCenterXOnScreen = centerXOnScreen
        folderExitPendingCenterYOnScreen = centerYOnScreen
        if (immediate) {
            binding.workspace.root.removeCallbacks(folderExitPositionRunnable)
            folderExitPositionFramePosted = false
            applyFolderExitDragPosition(centerXOnScreen, centerYOnScreen)
            return
        }

        if (folderExitPositionFramePosted) return

        folderExitPositionFramePosted = true
        binding.workspace.root.postOnAnimation(folderExitPositionRunnable)
    }

    private fun applyFolderExitDragPosition(centerXOnScreen: Float, centerYOnScreen: Float) {
        if (folderExitDraggedApp == null) return

        folderExitDragCenterXOnScreen = centerXOnScreen
        folderExitDragCenterYOnScreen = centerYOnScreen
        val metrics = folderExitDragMetrics ?: captureFolderExitDragMetrics().also { metrics ->
            folderExitDragMetrics = metrics
        }
        val rootCenterX = (centerXOnScreen - metrics.rootLeftOnScreen).coerceIn(0f, metrics.rootWidth.toFloat())
        val rootCenterY = (centerYOnScreen - metrics.rootTopOnScreen).coerceIn(0f, metrics.rootHeight.toFloat())
        val previewPosition = LauncherDragPreviewPositioner.positionForIconCenter(
            rootWidth = metrics.rootWidth,
            rootHeight = metrics.rootHeight,
            previewWidth = metrics.previewWidth,
            previewHeight = metrics.previewHeight,
            iconCenterY = dp(DRAG_PREVIEW_ICON_CENTER_Y_DP),
            centerX = rootCenterX,
            centerY = rootCenterY,
            horizontalPadding = dp(4),
            verticalPadding = dp(12)
        )

        folderExitDragCenterX = rootCenterX
        folderExitDragCenterY = rootCenterY
        binding.workspace.selectedIconPreview.x = previewPosition.left.toFloat()
        binding.workspace.selectedIconPreview.y = previewPosition.top.toFloat()
        updateFolderExitEdgeState(rootCenterX, metrics.rootWidth)
        updateFolderExitHomePreview()
    }

    private fun captureFolderExitDragMetrics(): FolderExitDragMetrics {
        val rootLocation = IntArray(2)
        val pagerLocation = IntArray(2)
        binding.workspace.root.getLocationOnScreen(rootLocation)
        binding.workspace.workspacePager.getLocationOnScreen(pagerLocation)

        val rootWidth = binding.workspace.root.width.takeIf { it > 0 }
            ?: resources.displayMetrics.widthPixels
        val rootHeight = binding.workspace.root.height.takeIf { it > 0 }
            ?: resources.displayMetrics.heightPixels
        val previewWidth = binding.workspace.selectedIconPreview.width.takeIf { it > 0 }
            ?: dp(DRAG_PREVIEW_WIDTH_DP)
        val previewHeight = binding.workspace.selectedIconPreview.height.takeIf { it > 0 }
            ?: dp(DRAG_PREVIEW_HEIGHT_DP)
        val pagerWidth = binding.workspace.workspacePager.width.takeIf { it > 0 } ?: rootWidth
        val pagerHeight = binding.workspace.workspacePager.height.takeIf { it > 0 } ?: rootHeight
        val cellWidth = pagerWidth / HOME_PAGE_COLUMNS.toFloat()
        val cellHeight = pagerHeight / effectiveHomeGridRows.toFloat()

        return FolderExitDragMetrics(
            rootLeftOnScreen = rootLocation[0],
            rootTopOnScreen = rootLocation[1],
            rootWidth = rootWidth,
            rootHeight = rootHeight,
            previewWidth = previewWidth,
            previewHeight = previewHeight,
            pagerLeftInRoot = (pagerLocation[0] - rootLocation[0]).toFloat(),
            pagerTopInRoot = (pagerLocation[1] - rootLocation[1]).toFloat(),
            pagerWidth = pagerWidth,
            pagerHeight = pagerHeight,
            cellWidth = cellWidth,
            cellHeight = cellHeight
        )
    }

    private fun updateFolderExitHomePreview() {
        val baseItems = folderExitBaseHomeItems
        if (baseItems.isEmpty() || folderExitDraggedApp == null) return

        val insertIndex = folderExitHomeDropIndex()
        val folderTargetIndex = folderExitFolderDropIndex(baseItems)
        if (insertIndex == folderExitPreviewIndex && folderTargetIndex == folderExitFolderTargetIndex) return

        folderExitPreviewIndex = insertIndex
        folderExitFolderTargetIndex = folderTargetIndex
        val draggedApp = folderExitDraggedApp ?: return
        val previewItems = if (folderTargetIndex != NO_PREVIEW_INDEX) {
            LauncherFolderExitDropResolver.resolveDrop(
                baseItems = baseItems,
                draggedApp = draggedApp,
                dropIndex = insertIndex,
                folderTargetIndex = folderTargetIndex
            )
        } else {
            insertItemAtHomeIndex(
                baseItems = baseItems,
                index = insertIndex,
                item = LauncherHomeItemUiModel.Placeholder.forGridIndex(insertIndex)
            )
        }
        workspacePageAdapter.submitDragPreviewItems(
            items = previewItems,
            focusPage = folderExitDragPage
        )
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

        var baseChanged = false
        val targetPage = maxOf(0, folderExitDragPage + direction)
        if (targetPage >= homePageCountForItemCount(folderExitBaseHomeItems.size + 1)) {
            folderExitBaseHomeItems = ensurePageExists(folderExitBaseHomeItems, targetPage)
            baseChanged = true
        }
        folderExitDragPage = targetPage
        folderExitPreviewIndex = NO_PREVIEW_INDEX
        folderExitFolderTargetIndex = NO_PREVIEW_INDEX
        if (baseChanged) {
            workspacePageAdapter.submitDragPreviewItems(
                items = folderExitBaseHomeItems,
                focusPage = folderExitDragPage
            )
        }
        binding.workspace.workspacePager.setCurrentItem(
            workspacePageAdapter.adapterPositionForHomePage(folderExitDragPage),
            false
        )
        showPageIndicator(workspacePageAdapter.adapterPositionForHomePage(folderExitDragPage))
        updateFolderExitHomePreview()
        folderExitEdgeDirection = 0
    }

    private fun canSwitchFolderExitPage(direction: Int): Boolean {
        val targetPage = folderExitDragPage + direction
        return targetPage >= 0 &&
            targetPage <= homePageCountForItemCount(folderExitBaseHomeItems.size + 1)
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
            .scaleX(FOLDER_EXIT_COLLAPSED_PANEL_SCALE)
            .scaleY(FOLDER_EXIT_COLLAPSED_PANEL_SCALE)
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
        binding.workspace.folderOverlay.setBackgroundColor(folderOverlayDimColor())
        visualEffectsController.applyFolderBlur()
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

    private fun resetFolderExitDragVisuals(
        restoreFolderOverlayBackground: Boolean = true
    ) {
        folderExitDragActive = false
        folderExitDragCollapsed = false
        folderExitEdgeDirection = 0
        folderExitFolderTargetIndex = NO_PREVIEW_INDEX
        folderExitPreviewIconKey = null
        folderExitDragMetrics = null
        folderExitDragCenterXOnScreen = 0f
        folderExitDragCenterYOnScreen = 0f
        folderExitPendingCenterXOnScreen = 0f
        folderExitPendingCenterYOnScreen = 0f
        folderExitPositionFramePosted = false
        binding.workspace.root.removeCallbacks(folderExitPositionRunnable)
        folderEdgeSwitchHandler.removeCallbacks(folderEdgeSwitchRunnable)
        hideFolderEdgeGlows()
        binding.workspace.workspacePager.isUserInputEnabled = true
        if (restoreFolderOverlayBackground) {
            binding.workspace.folderOverlay.setBackgroundColor(folderOverlayDimColor())
        }
    }

    private fun folderExitHomeDropIndex(): Int {
        if (!folderExitDragActive) return folderExitBaseHomeItems.size

        val metrics = folderExitDragMetrics ?: return folderExitBaseHomeItems.size
        val localX = (folderExitDragCenterX - metrics.pagerLeftInRoot)
            .coerceIn(0f, (metrics.pagerWidth - 1).toFloat())
        val localY = (folderExitDragCenterY - metrics.pagerTopInRoot)
            .coerceIn(0f, (metrics.pagerHeight - 1).toFloat())
        val column = (localX / metrics.cellWidth)
            .toInt()
            .coerceIn(0, HOME_PAGE_COLUMNS - 1)
        val row = (localY / metrics.cellHeight)
            .toInt()
            .coerceIn(0, effectiveHomeGridRows - 1)
        val insertAfterTarget = localX - column * metrics.cellWidth > metrics.cellWidth / 2f
        val page = folderExitDragPage.coerceAtLeast(0)
        val targetIndex = page * homePageSize + row * HOME_PAGE_COLUMNS + column
        return targetIndex + if (insertAfterTarget) 1 else 0
    }

    private fun folderExitFolderDropIndex(baseItems: List<LauncherHomeItemUiModel>): Int {
        val target = folderExitTargetCell() ?: return NO_PREVIEW_INDEX
        val item = baseItems.getOrNull(target.index) ?: return NO_PREVIEW_INDEX
        if (item !is LauncherHomeItemUiModel.App && item !is LauncherHomeItemUiModel.Folder) {
            return NO_PREVIEW_INDEX
        }
        val overTargetCenter = LauncherIos17DragGeometryPolicy.isFolderInterest(
            localXInIcon = target.localXInCell,
            localYInIcon = target.localYInCell
        )
        return if (overTargetCenter) target.index else NO_PREVIEW_INDEX
    }

    private fun folderExitTargetCell(): HomeEdgeTargetCell? {
        val metrics = folderExitDragMetrics ?: return null
        val localX = (folderExitDragCenterX - metrics.pagerLeftInRoot)
            .coerceIn(0f, (metrics.pagerWidth - 1).toFloat())
        val localY = (folderExitDragCenterY - metrics.pagerTopInRoot)
            .coerceIn(0f, (metrics.pagerHeight - 1).toFloat())
        val column = (localX / metrics.cellWidth)
            .toInt()
            .coerceIn(0, HOME_PAGE_COLUMNS - 1)
        val row = (localY / metrics.cellHeight)
            .toInt()
            .coerceIn(0, effectiveHomeGridRows - 1)
        val localXInCell = ((localX - column * metrics.cellWidth) / metrics.cellWidth)
            .coerceIn(0f, 1f)
        val localYInCell = ((localY - row * metrics.cellHeight) / metrics.cellHeight)
            .coerceIn(0f, 1f)
        return HomeEdgeTargetCell(
            index = folderExitDragPage * homePageSize + row * HOME_PAGE_COLUMNS + column,
            localXInCell = localXInCell,
            localYInCell = localYInCell
        )
    }

    private fun homePageCountForItemCount(itemCount: Int): Int {
        return maxOf(1, (itemCount + homePageSize - 1) / homePageSize)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showExternalFeatureDownloadPrompt(featureCode: LauncherExternalFeatureCode) {
        showFeatureDownloadDialog(LauncherExternalFeatureCatalog.requireFeature(featureCode))
    }

    override fun showSettingsDrawer() {
        val overlay = binding.settingsDrawerOverlay
        val dimView = binding.settingsDrawerDim
        val panel = binding.settingsDrawerPanel
        val drawerWidth = settingsDrawerWidth()

        panel.animate().cancel()
        dimView.animate().cancel()
        overlay.bringToFront()
        panel.translationX = -drawerWidth
        dimView.alpha = 0f
        overlay.visibility = View.VISIBLE

        dimView.animate()
            .alpha(1f)
            .setDuration(DRAWER_DIM_ANIMATION_MS)
            .start()
        panel.animate()
            .translationX(0f)
            .setDuration(DRAWER_OPEN_ANIMATION_MS)
            .setInterpolator(DecelerateInterpolator())
            .start()
    }

    private fun hideLayoutSettingsPage() {
        if (binding.layoutSettingsPanel.visibility != View.VISIBLE) return

        binding.layoutSettingsPanel.animate()
            .alpha(0f)
            .translationX(dp(28).toFloat())
            .setDuration(150L)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction {
                binding.layoutSettingsPanel.visibility = View.GONE
                binding.layoutSettingsPanel.alpha = 1f
                binding.layoutSettingsPanel.translationX = 0f
                if (!state.launcherMode) {
                    binding.settingsFab.visibility = View.VISIBLE
                }
            }
            .start()
    }

    private fun hideLiquidGlassSettingsPage() {
        if (binding.liquidGlassSettingsPanel.visibility != View.VISIBLE) return

        binding.liquidGlassSettingsPanel.animate()
            .alpha(0f)
            .translationX(dp(28).toFloat())
            .setDuration(150L)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction {
                binding.liquidGlassSettingsPanel.visibility = View.GONE
                binding.liquidGlassSettingsPanel.alpha = 1f
                binding.liquidGlassSettingsPanel.translationX = 0f
                if (!state.launcherMode) {
                    binding.settingsFab.visibility = View.VISIBLE
                }
            }
            .start()
    }

    private fun hideBlurEffectSettingsPage() {
        if (binding.blurSettingsPanel.visibility != View.VISIBLE) return

        binding.blurSettingsPanel.animate()
            .alpha(0f)
            .translationX(dp(28).toFloat())
            .setDuration(150L)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction {
                binding.blurSettingsPanel.visibility = View.GONE
                binding.blurSettingsPanel.alpha = 1f
                binding.blurSettingsPanel.translationX = 0f
                if (!state.launcherMode) {
                    binding.settingsFab.visibility = View.VISIBLE
                }
            }
            .start()
    }

    private fun hideAnimationSettingsPage() {
        if (binding.animationSettingsPanel.visibility != View.VISIBLE) return

        binding.animationSettingsPanel.animate()
            .alpha(0f)
            .translationX(dp(28).toFloat())
            .setDuration(150L)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction {
                binding.animationSettingsPanel.visibility = View.GONE
                binding.animationSettingsPanel.alpha = 1f
                binding.animationSettingsPanel.translationX = 0f
                if (!state.launcherMode) {
                    binding.settingsFab.visibility = View.VISIBLE
                }
            }
            .start()
    }

    private fun hideSettingsDrawer() {
        val overlay = binding.settingsDrawerOverlay
        if (overlay.visibility != View.VISIBLE) {
            return
        }

        val dimView = binding.settingsDrawerDim
        val panel = binding.settingsDrawerPanel
        panel.animate().cancel()
        dimView.animate().cancel()
        dimView.animate()
            .alpha(0f)
            .setDuration(DRAWER_DIM_ANIMATION_MS)
            .start()
        panel.animate()
            .translationX(-settingsDrawerWidth())
            .setDuration(DRAWER_CLOSE_ANIMATION_MS)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction {
                overlay.visibility = View.GONE
                panel.translationX = 0f
                dimView.alpha = 1f
            }
            .start()
    }

    private fun showDrawerComingSoon(titleRes: Int) {
        hideSettingsDrawer()
        showError(getString(R.string.app_option_coming_soon, getString(titleRes)))
    }

    private fun currentBlurSettings(): LauncherBlurSettings {
        return LauncherBlurSettings(
            enabled = layoutPreferences.getBoolean(KEY_BLUR_EFFECT_ENABLED, true),
            folderEnabled = layoutPreferences.getBoolean(KEY_BLUR_FOLDER_ENABLED, true),
            widgetEnabled = layoutPreferences.getBoolean(KEY_BLUR_WIDGET_ENABLED, true),
            searchEnabled = layoutPreferences.getBoolean(KEY_BLUR_SEARCH_ENABLED, true)
        )
    }

    private fun applyBlurSettings(settings: LauncherBlurSettings, persist: Boolean) {
        if (persist) {
            layoutPreferences.edit()
                .putBoolean(KEY_BLUR_EFFECT_ENABLED, settings.enabled)
                .putBoolean(KEY_BLUR_FOLDER_ENABLED, settings.folderEnabled)
                .putBoolean(KEY_BLUR_WIDGET_ENABLED, settings.widgetEnabled)
                .putBoolean(KEY_BLUR_SEARCH_ENABLED, settings.searchEnabled)
                .apply()
        }
        visualEffectsController.setBlurSettings(settings)
        applyBlurSettingsUi()
    }

    private fun applyBlurSettingsUi() {
        val settings = currentBlurSettings()
        bindBlurSwitchRow(
            row = binding.blurMasterRow,
            titleRes = R.string.settings_blur_master,
            checked = settings.enabled,
            enabled = true
        ) { checked ->
            applyBlurSettings(settings.copy(enabled = checked), persist = true)
        }
        bindBlurSwitchRow(
            row = binding.blurFolderRow,
            titleRes = R.string.settings_blur_folder,
            checked = settings.folderEnabled,
            enabled = settings.enabled
        ) { checked ->
            applyBlurSettings(currentBlurSettings().copy(folderEnabled = checked), persist = true)
        }
        bindBlurSwitchRow(
            row = binding.blurWidgetRow,
            titleRes = R.string.settings_blur_widget,
            checked = settings.widgetEnabled,
            enabled = settings.enabled
        ) { checked ->
            applyBlurSettings(currentBlurSettings().copy(widgetEnabled = checked), persist = true)
        }
        bindBlurSwitchRow(
            row = binding.blurSearchRow,
            titleRes = R.string.settings_blur_search,
            checked = settings.searchEnabled,
            enabled = settings.enabled
        ) { checked ->
            applyBlurSettings(currentBlurSettings().copy(searchEnabled = checked), persist = true)
        }
    }

    private fun bindBlurSwitchRow(
        row: ViewLauncherBlurSwitchRowBinding,
        titleRes: Int,
        checked: Boolean,
        enabled: Boolean,
        onCheckedChanged: (Boolean) -> Unit
    ) {
        row.rowTitle.setText(titleRes)
        row.iconContainer.backgroundTintList = ColorStateList.valueOf(getColor(R.color.icon_blur))
        row.rowSwitch.setOnCheckedChangeListener(null)
        row.rowSwitch.isChecked = checked
        row.rowSwitch.isEnabled = enabled
        row.rowSwitch.setOnCheckedChangeListener { _, isChecked ->
            onCheckedChanged(isChecked)
        }
        row.root.alpha = if (enabled) 1f else 0.45f
        row.root.isClickable = enabled
        row.root.isFocusable = enabled
        row.root.setOnClickListener(if (enabled) {
            View.OnClickListener {
                row.rowSwitch.isChecked = !row.rowSwitch.isChecked
            }
        } else {
            null
        })
    }

    private fun currentAnimationSettings(): LauncherAnimationSettings {
        return LauncherAnimationSettings(
            unlockEnabled = layoutPreferences.getBoolean(
                KEY_ANIMATION_UNLOCK_ENABLED,
                DEFAULT_ANIMATION_UNLOCK_ENABLED
            ),
            openCloseEnabled = layoutPreferences.getBoolean(
                KEY_ANIMATION_OPEN_CLOSE_ENABLED,
                DEFAULT_ANIMATION_OPEN_CLOSE_ENABLED
            ),
            parallaxZoomEnabled = layoutPreferences.getBoolean(
                KEY_ANIMATION_PARALLAX_ZOOM_ENABLED,
                DEFAULT_ANIMATION_PARALLAX_ZOOM_ENABLED
            )
        )
    }

    private fun applyAnimationSettings(settings: LauncherAnimationSettings, persist: Boolean) {
        if (persist) {
            layoutPreferences.edit()
                .putBoolean(KEY_ANIMATION_UNLOCK_ENABLED, settings.unlockEnabled)
                .putBoolean(KEY_ANIMATION_OPEN_CLOSE_ENABLED, settings.openCloseEnabled)
                .putBoolean(KEY_ANIMATION_PARALLAX_ZOOM_ENABLED, settings.parallaxZoomEnabled)
                .apply()
        }
        applyAnimationSettingsUi()
    }

    private fun applyAnimationSettingsUi() {
        val settings = currentAnimationSettings()
        bindPlainSwitchRow(
            row = binding.animationUnlockRow,
            titleRes = R.string.settings_animation_unlock,
            checked = settings.unlockEnabled,
            showDivider = true
        ) { checked ->
            applyAnimationSettings(currentAnimationSettings().copy(unlockEnabled = checked), persist = true)
        }
        bindPlainSwitchRow(
            row = binding.animationOpenCloseRow,
            titleRes = R.string.settings_animation_open_close,
            checked = settings.openCloseEnabled,
            showDivider = true
        ) { checked ->
            applyAnimationSettings(currentAnimationSettings().copy(openCloseEnabled = checked), persist = true)
        }
        bindPlainSwitchRow(
            row = binding.animationParallaxRow,
            titleRes = R.string.settings_animation_parallax_zoom,
            checked = settings.parallaxZoomEnabled,
            showDivider = false
        ) { checked ->
            applyAnimationSettings(currentAnimationSettings().copy(parallaxZoomEnabled = checked), persist = true)
            if (checked && !openLiveWallpaperChooser()) {
                applyAnimationSettings(currentAnimationSettings().copy(parallaxZoomEnabled = false), persist = true)
            }
        }
    }

    private fun bindPlainSwitchRow(
        row: ViewLauncherPlainSwitchRowBinding,
        titleRes: Int,
        checked: Boolean,
        showDivider: Boolean,
        onCheckedChanged: (Boolean) -> Unit
    ) {
        row.rowTitle.setText(titleRes)
        row.rowDivider.visibility = if (showDivider) View.VISIBLE else View.GONE
        row.rowSwitch.setOnCheckedChangeListener(null)
        row.rowSwitch.isChecked = checked
        row.rowSwitch.setOnCheckedChangeListener { _, isChecked ->
            onCheckedChanged(isChecked)
        }
        row.root.setOnClickListener {
            row.rowSwitch.isChecked = !row.rowSwitch.isChecked
        }
    }

    private fun openLiveWallpaperChooser(): Boolean {
        return runCatching {
            startActivity(Intent(WallpaperManager.ACTION_LIVE_WALLPAPER_CHOOSER))
            true
        }.onFailure {
            showError(getString(R.string.settings_live_wallpaper_failed))
        }.getOrDefault(false)
    }

    private fun showWallpaperSettingsDialog() {
        val actions = arrayOf(
            getString(R.string.settings_wallpaper_choose_image),
            getString(R.string.settings_wallpaper_system),
            getString(R.string.settings_wallpaper_reset)
        )
        AlertDialog.Builder(this)
            .setTitle(R.string.settings_wallpaper)
            .setItems(actions) { _, which ->
                when (which) {
                    0 -> wallpaperImageLauncher.launch(arrayOf("image/*"))
                    1 -> openSystemWallpaperPicker()
                    2 -> resetCustomWallpaper()
                }
            }
            .show()
    }

    private fun openSystemWallpaperPicker() {
        runCatching {
            startActivity(Intent.createChooser(Intent(Intent.ACTION_SET_WALLPAPER), getString(R.string.settings_wallpaper)))
        }.onFailure {
            showError(getString(R.string.launcher_default_prompt_failed))
        }
    }

    private fun resetCustomWallpaper() {
        layoutPreferences.edit()
            .remove(KEY_CUSTOM_WALLPAPER_URI)
            .apply()
        applyLauncherRootBackground(state.launcherMode)
        showError(getString(R.string.settings_wallpaper_reset_done))
    }

    private fun showRenameAppPicker() {
        showAppSelectionDialog(getString(R.string.settings_rename)) { app ->
            showRenameAppDialog(app)
        }
    }

    private fun showChangeIconAppPicker() {
        showAppSelectionDialog(getString(R.string.settings_change_icon)) { app ->
            showChangeIconDialog(app)
        }
    }

    private fun showAppSelectionDialog(
        title: String,
        onAppSelected: (LauncherApp) -> Unit
    ) {
        if (!::launcherRepository.isInitialized) return

        lifecycleScope.launch {
            val apps = runCatching {
                launcherRepository.getAllInstalledApps()
                    .filterNot { app -> app.packageName == packageName }
                    .sortedBy { app -> app.label.lowercase() }
            }.getOrElse { error ->
                showError(error.message ?: getString(R.string.settings_no_apps_found))
                return@launch
            }
            if (apps.isEmpty()) {
                showError(getString(R.string.settings_no_apps_found))
                return@launch
            }

            AlertDialog.Builder(this@IOSLauncherActivity)
                .setTitle(title)
                .setItems(apps.map { app -> app.label }.toTypedArray()) { _, which ->
                    onAppSelected(apps[which])
                }
                .show()
        }
    }

    override fun showRenameAppDialog(app: LauncherApp) {
        val input = EditText(this).apply {
            setSingleLine(true)
            hint = getString(R.string.settings_rename_hint)
            setText(app.label)
            selectAll()
            setPadding(dp(18), dp(8), dp(18), dp(8))
        }
        val container = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(20), dp(8), dp(20), 0)
            addView(input)
        }

        AlertDialog.Builder(this)
            .setTitle(R.string.settings_rename)
            .setView(container)
            .setPositiveButton(R.string.dialog_ok) { _, _ ->
                launcherRepository.saveCustomLabel(app, input.text?.toString().orEmpty())
                presenter.refreshApps()
                showError(getString(R.string.settings_rename_done, app.label))
            }
            .setNeutralButton(R.string.dialog_reset) { _, _ ->
                launcherRepository.saveCustomLabel(app, "")
                presenter.refreshApps()
            }
            .setNegativeButton(R.string.dialog_cancel, null)
            .show()
    }

    override fun showChangeIconDialog(app: LauncherApp) {
        val actions = arrayOf(
            getString(R.string.settings_change_icon_choose_image),
            getString(R.string.settings_change_icon_reset)
        )
        AlertDialog.Builder(this)
            .setTitle(app.label)
            .setItems(actions) { _, which ->
                when (which) {
                    0 -> {
                        pendingIconChangeApp = app
                        customIconImageLauncher.launch(arrayOf("image/*"))
                    }
                    1 -> {
                        launcherRepository.saveCustomIconUri(app, null)
                        presenter.clearIconCache()
                        presenter.refreshApps()
                        showError(getString(R.string.settings_change_icon_reset_done, app.label))
                    }
                }
            }
            .show()
    }

    override fun showHideAppDialog(app: LauncherApp) {
        AlertDialog.Builder(this)
            .setTitle(R.string.settings_hidden_apps)
            .setMessage(getString(R.string.settings_hide_app_confirm, app.label))
            .setPositiveButton(R.string.dialog_hide) { _, _ ->
                launcherRepository.setAppHidden(app, true)
                presenter.refreshApps()
                showError(getString(R.string.settings_hide_app_done, app.label))
            }
            .setNegativeButton(R.string.dialog_cancel, null)
            .show()
    }

    private fun showHiddenAppsSettingsDialog() {
        if (!::launcherRepository.isInitialized) return

        lifecycleScope.launch {
            val apps = runCatching {
                launcherRepository.getAllInstalledApps()
                    .filterNot { app -> app.packageName == packageName }
                    .sortedBy { app -> app.label.lowercase() }
            }.getOrElse { error ->
                showError(error.message ?: getString(R.string.settings_no_apps_found))
                return@launch
            }
            if (apps.isEmpty()) {
                showError(getString(R.string.settings_no_apps_found))
                return@launch
            }

            val hiddenKeys = launcherRepository.getHiddenIconKeys().toMutableSet()
            val checked = apps.map { app -> app.iconKey in hiddenKeys }.toBooleanArray()
            AlertDialog.Builder(this@IOSLauncherActivity)
                .setTitle(R.string.settings_hidden_apps)
                .setMultiChoiceItems(apps.map { app -> app.label }.toTypedArray(), checked) { _, which, isChecked ->
                    checked[which] = isChecked
                }
                .setPositiveButton(R.string.dialog_done) { _, _ ->
                    apps.forEachIndexed { index, app ->
                        launcherRepository.setAppHidden(app, checked[index])
                    }
                    presenter.refreshApps()
                    showError(getString(R.string.settings_hidden_apps_done))
                }
                .setNegativeButton(R.string.dialog_cancel, null)
                .show()
        }
    }

    private fun openNotificationAccessSettings() {
        runCatching {
            startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
        }.onFailure {
            showError(getString(R.string.settings_notification_access_failed))
        }
    }

    private fun takePersistableReadPermission(uri: Uri) {
        runCatching {
            contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
    }

    private fun settingsDrawerWidth(): Float {
        val measuredWidth = binding.settingsDrawerPanel.width
        return if (measuredWidth > 0) {
            measuredWidth.toFloat()
        } else {
            resources.getDimensionPixelSize(R.dimen.settings_drawer_width).toFloat()
        }
    }

    private fun showFeatureDownloadDialog(feature: LauncherExternalFeature) {
        val packageName = getString(feature.packageNameRes)
        val dialog = Dialog(this)
        val dialogBinding = DialogFeatureDownloadBinding.inflate(layoutInflater)
        dialogBinding.downloadMessage.setText(feature.messageRes)
        dialogBinding.downloadPreview.setImageResource(feature.previewDrawableRes)
        dialogBinding.cancelButton.setOnClickListener {
            dialog.dismiss()
        }
        dialogBinding.okButton.setOnClickListener {
            dialog.dismiss()
            openExternalPackage(packageName)
        }

        dialog.setContentView(dialogBinding.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setOnShowListener {
            dialog.window?.apply {
                setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                setDimAmount(0.56f)
                setLayout((resources.displayMetrics.widthPixels * 0.86f).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }
        dialog.show()
    }

    private fun openExternalPackage(packageName: String) {
        val marketIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("market://details?id=${Uri.encode(packageName)}")
        ).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        runCatching {
            startActivity(Intent.createChooser(marketIntent, null))
        }.onFailure {
            openExternalPackageSearch(packageName)
        }
    }

    private fun openExternalPackageSearch(packageName: String) {
        val searchIntent = Intent(Intent.ACTION_WEB_SEARCH).apply {
            putExtra(SearchManager.QUERY, packageName)
        }
        runCatching {
            startActivity(searchIntent)
        }.onFailure {
            val webIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/search?q=${Uri.encode(packageName)}")
            )
            runCatching {
                startActivity(webIntent)
            }.onFailure {
                showError(getString(R.string.launcher_open_app_failed, packageName))
            }
        }
    }

    private fun launcherShareText(): String {
        return getString(R.string.share_app_text, packageName)
    }

    private fun startShareActivity(intent: Intent) {
        runCatching {
            startActivity(intent)
        }.onFailure {
            showError(getString(R.string.share_no_app_found))
        }
    }

    private fun showRatingDialog() {
        val dialog = Dialog(this)
        val dialogBinding = DialogRatingPromptBinding.inflate(layoutInflater)
        var selectedRating = 0
        val stars = listOf(
            dialogBinding.ratingStar1,
            dialogBinding.ratingStar2,
            dialogBinding.ratingStar3,
            dialogBinding.ratingStar4,
            dialogBinding.ratingStar5
        )

        fun updateStars(rating: Int) {
            selectedRating = rating
            stars.forEachIndexed { index, imageView ->
                val tintColor = if (index < selectedRating) {
                    getColor(R.color.rating_star_selected)
                } else {
                    getColor(R.color.rating_star_empty)
                }
                imageView.imageTintList = ColorStateList.valueOf(tintColor)
            }
        }

        stars.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                updateStars(index + 1)
            }
        }
        dialogBinding.ratingLaterButton.setOnClickListener {
            dialog.dismiss()
        }
        dialogBinding.ratingNoButton.setOnClickListener {
            dialog.dismiss()
        }
        dialogBinding.ratingSendButton.setOnClickListener {
            dialog.dismiss()
            openExternalPackage(packageName)
        }

        updateStars(0)
        dialog.setContentView(dialogBinding.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setOnShowListener {
            dialog.window?.apply {
                setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                setDimAmount(0.46f)
                setLayout((resources.displayMetrics.widthPixels * 0.88f).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }
        dialog.show()
    }

    private fun showDefaultLauncherPrompt() {
        val dialog = Dialog(this)
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            background = roundedBackground(Color.WHITE, 26)
            setPadding(dp(20), dp(30), dp(20), 0)
        }
        content.addView(
            ImageView(this).apply {
                setImageResource(R.mipmap.ic_launcher)
                contentDescription = getString(R.string.app_name)
            },
            LinearLayout.LayoutParams(dp(72), dp(72)).apply {
                gravity = Gravity.CENTER_HORIZONTAL
            }
        )
        content.addView(
            TextView(this).apply {
                text = getString(R.string.default_launcher_prompt_title)
                gravity = Gravity.CENTER
                setTextColor(Color.BLACK)
                textSize = 23f
                typeface = Typeface.DEFAULT_BOLD
            },
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = dp(12)
            }
        )
        content.addView(
            TextView(this).apply {
                text = getString(R.string.default_launcher_prompt_message)
                gravity = Gravity.CENTER
                setTextColor(0xFF222222.toInt())
                textSize = 18f
                setLineSpacing(dp(2).toFloat(), 1f)
            },
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = dp(18)
                leftMargin = dp(6)
                rightMargin = dp(6)
            }
        )
        content.addView(
            View(this).apply { setBackgroundColor(0xFFE2E2E2.toInt()) },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(1)).apply {
                topMargin = dp(28)
            }
        )

        val buttonRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
        }
        val cancelButton = TextView(this).apply {
            text = getString(R.string.dialog_cancel)
            gravity = Gravity.CENTER
            setTextColor(0xFF168BFF.toInt())
            textSize = 18f
            typeface = Typeface.DEFAULT_BOLD
            isClickable = true
            isFocusable = true
            foreground = obtainStyledForeground()
            setOnClickListener { dialog.dismiss() }
        }
        val okButton = TextView(this).apply {
            text = getString(R.string.dialog_ok)
            gravity = Gravity.CENTER
            setTextColor(0xFFFF1F2D.toInt())
            textSize = 18f
            typeface = Typeface.DEFAULT_BOLD
            isClickable = true
            isFocusable = true
            foreground = obtainStyledForeground()
            setOnClickListener {
                dialog.dismiss()
                presenter.onSetDefaultLauncherClicked()
            }
        }
        buttonRow.addView(cancelButton, LinearLayout.LayoutParams(0, dp(56), 1f))
        buttonRow.addView(
            View(this).apply { setBackgroundColor(0xFFE2E2E2.toInt()) },
            LinearLayout.LayoutParams(dp(1), dp(56))
        )
        buttonRow.addView(okButton, LinearLayout.LayoutParams(0, dp(56), 1f))
        content.addView(
            buttonRow,
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(56))
        )

        dialog.setContentView(content)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setOnShowListener {
            dialog.window?.apply {
                setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                setDimAmount(0.52f)
                setLayout((resources.displayMetrics.widthPixels * 0.88f).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }
        dialog.show()
    }

    override fun openDefaultLauncherSelection() {
        val promptAction = LauncherDefaultSelectionPolicy.resolvePromptConfirmation(
            isCurrentDefaultLauncher = isCurrentDefaultLauncher()
        )
        if (promptAction.openLauncherImmediately) {
            forceSettingsPanel = false
            showAlreadyDefaultLauncher()
            openCopiedIos17Launcher()
            return
        }
        if (!promptAction.openSystemLauncherSelection) {
            waitingForLauncherSelection = false
            showError(getString(R.string.launcher_default_prompt_failed))
            return
        }

        Toast.makeText(this, R.string.launcher_default_opening, Toast.LENGTH_SHORT).show()
        if (openHomeSettings()) {
            return
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && requestHomeRole()) {
            return
        }

        waitingForLauncherSelection = false
        showError(getString(R.string.launcher_default_prompt_failed))
    }

    override fun openCopiedIos17Launcher() {
        val intent = Intent(Intent.ACTION_MAIN).apply {
            component = ComponentName(
                packageName,
                "com.cloudx.ios17.features.launcher.LauncherActivity"
            )
            addCategory(Intent.CATEGORY_HOME)
            addCategory(Intent.CATEGORY_DEFAULT)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
        }
        runCatching { startActivity(intent) }.onFailure {
            showError(getString(R.string.launcher_default_prompt_failed))
        }
    }

    private fun resetFoldersForDefaultLauncher() {
        val resetHomeItems = LauncherHomeLayoutStatePolicy.resetFoldersToApps(homeItems)
        if (resetHomeItems != homeItems) {
            handleHomeItemsChanged(
                items = resetHomeItems,
                preferredPage = 0,
                refreshOpenFolder = false
            )
            hideFolderOverlay()
        }

        val resetDockItems = LauncherHomeLayoutStatePolicy.resetFoldersToApps(dockItems)
            .take(DOCK_APP_COUNT)
        if (resetDockItems != dockItems) {
            handleDockItemsChanged(resetDockItems)
        }
    }

    private fun openHomeSettings(): Boolean {
        return runCatching {
            waitingForLauncherSelection = true
            homeSettingsLauncher.launch(Intent(Settings.ACTION_HOME_SETTINGS))
        }.recoverCatching {
            waitingForLauncherSelection = true
            homeSettingsLauncher.launch(Intent(Settings.ACTION_MANAGE_DEFAULT_APPS_SETTINGS))
        }.isSuccess.also { opened ->
            if (!opened) {
                waitingForLauncherSelection = false
            }
        }
    }

    private fun handleDefaultLauncherSelectionReturn(showNotSelectedToast: Boolean) {
        waitingForLauncherSelection = false
        if (isCurrentDefaultLauncher()) {
            forceSettingsPanel = false
            openCopiedIos17Launcher()
        } else {
            updateLauncherMode(forceAnimate = true)
            if (showNotSelectedToast) {
                Toast.makeText(this, R.string.launcher_default_not_selected, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showDefaultWelcomeIfNeeded() {
        if (!::binding.isInitialized || defaultWelcomeOverlay != null) return
        val shouldShowWelcome = LauncherDefaultWelcomePolicy.shouldShowWelcome(
            isDefaultLauncher = state.launcherMode && isCurrentDefaultLauncher(),
            hasShownWelcome = layoutPreferences.getBoolean(KEY_DEFAULT_LAUNCHER_WELCOME_SHOWN, false)
        )
        if (!shouldShowWelcome) return

        showDefaultWelcomeOverlay()
    }

    private fun showDefaultWelcomeOverlay() {
        if (::workspacePageAdapter.isInitialized && workspacePageAdapter.homePageCount() > 0) {
            binding.workspace.workspacePager.setCurrentItem(
                workspacePageAdapter.firstHomeAdapterPosition(),
                false
            )
        }
        val overlay = FrameLayout(this).apply {
            isClickable = true
            isFocusable = true
            alpha = 0f
        }
        overlay.addView(
            View(this).apply {
                setBackgroundColor(0x26000000)
            },
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )

        val panel = FrameLayout(this).apply {
            setBackgroundColor(0xFF31D3C9.toInt())
            elevation = dp(20).toFloat()
        }
        val copyColumn = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.START
        }
        copyColumn.addView(
            TextView(this).apply {
                text = getString(R.string.default_launcher_welcome_title)
                setTextColor(Color.BLACK)
                textSize = 44f
            },
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )
        copyColumn.addView(
            TextView(this).apply {
                text = getString(R.string.default_launcher_welcome_subtitle)
                setTextColor(Color.BLACK)
                textSize = 28f
                typeface = Typeface.DEFAULT_BOLD
            },
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = dp(22)
            }
        )
        copyColumn.addView(
            TextView(this).apply {
                text = getString(R.string.default_launcher_welcome_hint)
                setTextColor(0x99000000.toInt())
                textSize = 23f
            },
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = dp(10)
            }
        )
        panel.addView(
            copyColumn,
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.TOP or Gravity.START
                leftMargin = dp(40)
                topMargin = dp(64)
                rightMargin = dp(40)
            }
        )
        panel.addView(
            TextView(this).apply {
                text = getString(R.string.dialog_ok)
                gravity = Gravity.CENTER
                setTextColor(Color.WHITE)
                textSize = 20f
                typeface = Typeface.DEFAULT_BOLD
                background = roundedBackground(0x33333333, 4)
                isClickable = true
                isFocusable = true
                foreground = obtainStyledForeground()
                setOnClickListener { dismissDefaultWelcomeOverlay() }
            },
            FrameLayout.LayoutParams(dp(94), dp(58)).apply {
                gravity = Gravity.TOP or Gravity.END
                topMargin = dp(142)
                rightMargin = dp(36)
            }
        )
        overlay.addView(
            panel,
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dp(280),
                Gravity.TOP
            )
        )

        defaultWelcomeOverlay = overlay
        binding.launcher.addView(
            overlay,
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        overlay.bringToFront()
        overlay.animate()
            .alpha(1f)
            .setDuration(180L)
            .setInterpolator(DecelerateInterpolator())
            .start()
    }

    private fun dismissDefaultWelcomeOverlay() {
        layoutPreferences.edit()
            .putBoolean(KEY_DEFAULT_LAUNCHER_WELCOME_SHOWN, true)
            .apply()
        val overlay = defaultWelcomeOverlay ?: return
        defaultWelcomeOverlay = null
        overlay.animate()
            .alpha(0f)
            .setDuration(140L)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction {
                (overlay.parent as? ViewGroup)?.removeView(overlay)
            }
            .start()
    }

    override fun showAlreadyDefaultLauncher() {
        Toast.makeText(this, R.string.launcher_default_already, Toast.LENGTH_SHORT).show()
    }

    override fun openAppLibrarySettings() {
        runCatching {
            appLibraryLauncher.launch(Intent(this, AppLibraryActivity::class.java))
        }.onFailure {
            showError(getString(R.string.launcher_open_app_failed, getString(R.string.settings_app_library)))
        }
    }

    override fun shareLauncherApp() {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_app_subject))
            putExtra(Intent.EXTRA_TEXT, launcherShareText())
        }
        startShareActivity(
            intent = Intent.createChooser(shareIntent, getString(R.string.share_app_chooser_title))
        )
    }

    override fun shareLauncherAppByMail() {
        val mailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_app_subject))
            putExtra(Intent.EXTRA_TEXT, launcherShareText())
        }
        startShareActivity(
            intent = Intent.createChooser(mailIntent, getString(R.string.share_mail_chooser_title))
        )
    }

    override fun showRatingPrompt() {
        showRatingDialog()
    }

    override fun showLayoutSettingsPage() {
        binding.layoutSettingsPanel.apply {
            animate().cancel()
            alpha = 0f
            translationX = dp(28).toFloat()
            visibility = View.VISIBLE
            bringToFront()
            animate()
                .alpha(1f)
                .translationX(0f)
                .setDuration(180L)
                .setInterpolator(DecelerateInterpolator())
                .start()
        }
        binding.settingsFab.visibility = View.GONE
    }

    private fun showLiquidGlassSettingsPage() {
        binding.liquidGlassSettingsPanel.apply {
            animate().cancel()
            alpha = 0f
            translationX = dp(28).toFloat()
            visibility = View.VISIBLE
            bringToFront()
            animate()
                .alpha(1f)
                .translationX(0f)
                .setDuration(180L)
                .setInterpolator(DecelerateInterpolator())
                .start()
        }
        binding.settingsFab.visibility = View.GONE
    }

    private fun showBlurEffectSettingsPage() {
        applyBlurSettingsUi()
        binding.blurSettingsPanel.apply {
            animate().cancel()
            alpha = 0f
            translationX = dp(28).toFloat()
            visibility = View.VISIBLE
            bringToFront()
            animate()
                .alpha(1f)
                .translationX(0f)
                .setDuration(180L)
                .setInterpolator(DecelerateInterpolator())
                .start()
        }
        binding.settingsFab.visibility = View.GONE
    }

    private fun showAnimationSettingsPage() {
        applyAnimationSettingsUi()
        binding.animationSettingsPanel.apply {
            animate().cancel()
            alpha = 0f
            translationX = dp(28).toFloat()
            visibility = View.VISIBLE
            bringToFront()
            animate()
                .alpha(1f)
                .translationX(0f)
                .setDuration(180L)
                .setInterpolator(DecelerateInterpolator())
                .start()
        }
        binding.settingsFab.visibility = View.GONE
    }

    override fun applyLayoutDarkMode(enabled: Boolean) {
        val changed = layoutDarkMode != enabled
        layoutDarkMode = enabled
        if (changed) {
            layoutPreferences.edit()
                .putBoolean(KEY_LAYOUT_DARK_MODE, enabled)
                .apply()
        }
        applyLayoutAppearance()
    }

    private fun applyIphone8Style(enabled: Boolean, persist: Boolean) {
        val changed = layoutIphone8Style != enabled
        layoutIphone8Style = enabled
        if (persist && changed) {
            layoutPreferences.edit()
                .putBoolean(KEY_LAYOUT_IPHONE8_STYLE, enabled)
                .apply()
        }
        binding.iphone8Switch.setOnCheckedChangeListener(null)
        binding.iphone8Switch.isChecked = enabled
        binding.iphone8Switch.setOnCheckedChangeListener { _, checked ->
            applyIphone8Style(checked, persist = true)
        }
        applyResponsiveWorkspaceLayout()
        applyWorkspaceAppearance()
    }

    private fun applyAutoArrange(enabled: Boolean, persist: Boolean) {
        val changed = layoutAutoArrange != enabled
        layoutAutoArrange = enabled
        if (persist && changed) {
            layoutPreferences.edit()
                .putBoolean(KEY_LAYOUT_AUTO_ARRANGE, enabled)
                .apply()
        }
        binding.autoArrangeSwitch.setOnCheckedChangeListener(null)
        binding.autoArrangeSwitch.isChecked = enabled
        binding.autoArrangeSwitch.setOnCheckedChangeListener { _, checked ->
            applyAutoArrange(checked, persist = true)
        }
        if (!enabled || homeItems.isEmpty()) return

        val compactedItems = arrangeHomeItems(homeItems)
        if (compactedItems != homeItems) {
            handleHomeItemsChanged(compactedItems)
        }
    }

    private fun applyLiquidGlass(enabled: Boolean, persist: Boolean) {
        val changed = layoutLiquidGlass != enabled
        layoutLiquidGlass = enabled
        if (persist && changed) {
            layoutPreferences.edit()
                .putBoolean(KEY_LAYOUT_LIQUID_GLASS, enabled)
                .apply()
        }
        binding.liquidGlassSwitch.setOnCheckedChangeListener(null)
        binding.liquidGlassSwitch.isChecked = enabled
        binding.liquidGlassSwitch.setOnCheckedChangeListener { _, checked ->
            applyLiquidGlass(checked, persist = true)
        }
        applyLiquidGlassSettingsAppearance()
        applyWorkspaceAppearance()
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

        if (currentAnimationSettings().shouldAnimateAppOpen) {
            animateAndStartApp(launchIntent, app)
        } else {
            startAppIntent(launchIntent, app, animateTransition = false)
        }
    }

    private fun animateAndStartApp(launchIntent: Intent, app: LauncherApp) {
        val workspaceRoot = binding.workspace.root
        workspaceRoot.animate().cancel()
        workspaceRoot.animate()
            .scaleX(1.018f)
            .scaleY(1.018f)
            .alpha(0.9f)
            .setDuration(APP_OPEN_PREVIEW_ANIMATION_MS)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction {
                workspaceRoot.animate().cancel()
                workspaceRoot.scaleX = 1f
                workspaceRoot.scaleY = 1f
                workspaceRoot.alpha = 1f
                startAppIntent(launchIntent, app, animateTransition = true)
            }
            .start()
    }

    private fun startAppIntent(
        launchIntent: Intent,
        app: LauncherApp,
        animateTransition: Boolean
    ) {
        runCatching {
            startActivity(launchIntent)
            if (animateTransition) {
                @Suppress("DEPRECATION")
                overridePendingTransition(R.anim.ios_app_open_enter, R.anim.ios_launcher_open_exit)
            }
        }.onFailure {
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
            onFolderClicked = { folder -> showFolderOverlay(folder, FolderSource.HOME) },
            onHomeItemsChanged = { items ->
                handleHomeItemsChanged(
                    items = items,
                    refreshWorkspace = shouldRefreshWorkspaceAfterHomeItemsChanged(items)
                )
            },
            onHomeDragMoved = { item, holder, centerX, centerY ->
                handleHomePageDragMoved(item, holder, centerX, centerY)
            },
            onHomeDragEnded = { item, _, centerX, centerY ->
                handleHomePageDragEnded(item, centerX, centerY)
            },
            onLibrarySearchClicked = { showLibrarySearchOverlay() },
            onLibraryGroupClicked = { group -> showCategoryDetail(group) },
            onWidgetEditClicked = { setHomeEditing(true) },
            onWidgetAppClicked = { item -> presenter.onOpenAppOptionClicked(item.app) },
            onWeatherPermissionClicked = { requestWeatherLocationPermission() }
        )
        workspacePageAdapter.setWeatherLocationGranted(hasWeatherLocationPermission())
        workspacePageAdapter.setIconSizeDp(effectiveHomeIconSizeDp)
        workspacePageAdapter.setHomeGridRows(effectiveHomeGridRows)
        dockAdapter = LauncherDockAdapter(
            onIconClicked = { item -> presenter.onOpenAppOptionClicked(item.app) },
            onFolderClicked = { folder -> showFolderOverlay(folder, FolderSource.DOCK) },
            onRemoveClicked = { item -> showRemoveAppDialog(item.app) },
            onDragRequested = { holder ->
                if (::dockItemTouchHelper.isInitialized) {
                    dockItemTouchHelper.startDrag(holder)
                }
            },
            onOrderChanged = { items -> handleDockItemsChanged(items, refreshDock = false) }
        )
        dockAdapter.setIconSizeDp(effectiveHomeIconSizeDp)
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
                folderExitDropCommitGuard.beginDrag()
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
            isCurrentPageLibrary = { isLibraryPage(binding.workspace.workspacePager.currentItem) },
            showSearchTrigger = { animated -> showSearchControlInIndicator(animated) }
        )
        widgetAppAdapter = WidgetAppAdapter {
            workspacePageAdapter.addSuggestionsWidget()
            hideWidgetSheet()
        }

        binding.workspace.workspacePager.apply {
            adapter = workspacePageAdapter
            offscreenPageLimit = 1
            clipChildren = true
            clipToPadding = true
            setPageTransformer(null)
            post {
                (getChildAt(0) as? RecyclerView)?.apply {
                    clipChildren = true
                    clipToPadding = true
                    overScrollMode = View.OVER_SCROLL_NEVER
                }
            }
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    updatePageIndicatorScroll(position, positionOffset)
                }

                override fun onPageSelected(position: Int) {
                    val wasWidgetPage = isWidgetPage(lastWorkspacePagePosition)
                    lastWorkspacePagePosition = position
                    if (editingHome && wasWidgetPage && !isWidgetPage(position)) {
                        setHomeEditing(false)
                    }
                    updateWorkspaceChromeForPage(position)
                    showPageIndicator(position)
                }
            })
        }
        binding.workspace.root.addOnLayoutChangeListener { _, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            if (right - left != oldRight - oldLeft || bottom - top != oldBottom - oldTop) {
                applyResponsiveWorkspaceLayout()
            }
        }
        searchController.install()
        binding.workspace.searchPill.visibility = View.GONE
        binding.workspace.pageIndicator.setOnClickListener {
            if (indicatorMode == IndicatorMode.SEARCH) {
                showSearchOverlay()
            }
        }
        showSearchControlInIndicator(animated = false)
        binding.workspace.editOptionsButton.text = getString(R.string.launcher_widget_add)
        binding.workspace.editOptionsButton.textSize = 18f
        binding.workspace.editOptionsButton.setOnClickListener {
            showWidgetSheet()
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
        binding.workspace.widgetWeatherOption.setOnClickListener {
            workspacePageAdapter.addWeatherWidget()
            hideWidgetSheet()
        }
        binding.workspace.widgetBatteryOption.setOnClickListener {
            workspacePageAdapter.addBatteryWidget()
            hideWidgetSheet()
        }
        binding.workspace.widgetPictureOption.setOnClickListener {
            workspacePageAdapter.addPictureWidget()
            hideWidgetSheet()
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
            clipChildren = false
            clipToPadding = false
            itemAnimator = DefaultItemAnimator().apply {
                supportsChangeAnimations = false
                addDuration = 140L
                moveDuration = 160L
            }
            setOnTouchListener { _, event ->
                dockAdapter.updateActiveTouch(event.rawX, event.rawY)
                false
            }
            dockItemTouchHelper = ItemTouchHelper(
                LauncherDockDragCallback(
                    adapter = dockAdapter,
                    isDragCenterInDock = { centerX, centerY ->
                        isPointInsideView(binding.workspace.dockRecyclerView, centerX, centerY)
                    },
                    onDragMoved = { item, viewHolder, centerX, centerY ->
                        handleDockDragMoved(item, viewHolder, centerX, centerY)
                    },
                    onDragEnded = { item, _, centerX, centerY ->
                        handleDockDragEnded(item, centerX, centerY)
                    }
                )
            )
            dockItemTouchHelper.attachToRecyclerView(this)
        }
        binding.workspace.root.post {
            applyResponsiveWorkspaceLayout()
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
            layoutManager = LauncherPagedFolderGridLayoutManager()
            adapter = folderContentAdapter
            itemAnimator = null
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if (newState != RecyclerView.SCROLL_STATE_IDLE) return

                    val folderLayoutManager = recyclerView.layoutManager as? LauncherPagedFolderGridLayoutManager
                    val snapDistance = folderLayoutManager?.distanceToNearestPage() ?: 0
                    if (snapDistance != 0) {
                        recyclerView.smoothScrollBy(snapDistance, 0)
                    }
                }
            })
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
                    onDroppedOutside = { item -> handleFolderItemDroppedOutside(item) },
                    onDragMoved = { item, _, centerX, centerY ->
                        handleFolderDragMoved(item, centerX, centerY)
                    },
                    onDragEnded = { item, _, centerX, centerY ->
                        handleFolderDragEnded(item, centerX, centerY)
                    }
                )
            )
            folderItemTouchHelper.attachToRecyclerView(this)
            setHasFixedSize(true)
            setOnTouchListener { _, event ->
                folderContentAdapter.updateActiveTouch(event.rawX, event.rawY)
                false
            }
            post {
                folderContentAdapter.setIconSizeDp(FOLDER_ICON_SIZE_DP)
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
        return state.launcherMode &&
            !editingHome &&
            binding.workspace.searchOverlay.visibility != View.VISIBLE &&
            binding.workspace.librarySearchOverlay.visibility != View.VISIBLE &&
            binding.workspace.categoryDetailOverlay.visibility != View.VISIBLE &&
            binding.workspace.folderOverlay.visibility != View.VISIBLE &&
            binding.workspace.widgetSheetOverlay.visibility != View.VISIBLE &&
            binding.workspace.contextOverlay.visibility != View.VISIBLE &&
            !appOptionsController.isShowing() &&
            !isWidgetPage(binding.workspace.workspacePager.currentItem) &&
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

    private fun isPointInsideView(view: View, rawX: Float, rawY: Float): Boolean {
        if (view.visibility != View.VISIBLE) return false

        val location = IntArray(2)
        view.getLocationOnScreen(location)
        return rawX >= location[0] &&
            rawX <= location[0] + view.width &&
            rawY >= location[1] &&
            rawY <= location[1] + view.height
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
        if (!state.launcherMode) return false
        if (editingHome) return false
        if (binding.workspace.widgetSheetOverlay.visibility == View.VISIBLE) return false
        if (binding.workspace.editWidgetPrompt.visibility == View.VISIBLE) return false
        if (binding.workspace.searchOverlay.visibility == View.VISIBLE) return false
        if (binding.workspace.librarySearchOverlay.visibility == View.VISIBLE) return false
        if (binding.workspace.categoryDetailOverlay.visibility == View.VISIBLE) return false
        if (binding.workspace.folderOverlay.visibility == View.VISIBLE) return false
        if (isWidgetPage(binding.workspace.workspacePager.currentItem)) return false
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
        if (!isHomePage(position)) {
            indicatorHandler.removeCallbacks(hideIndicatorRunnable)
            binding.workspace.pageIndicator.visibility = View.GONE
            return
        }

        if (homeIndicatorPageCount() <= 1) {
            showSearchControlInIndicator(animated = false)
            return
        }
        showDotsInIndicator(workspacePageAdapter.homePagePositionForAdapterPosition(position), animate = true)

        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        binding.workspace.searchPill.visibility = View.GONE
        if (!editingHome) {
            indicatorHandler.postDelayed(hideIndicatorRunnable, PAGE_INDICATOR_VISIBLE_MS)
        }
    }

    private fun hidePageIndicator() {
        if (binding.workspace.searchOverlay.visibility == View.VISIBLE) return
        if (editingHome) return

        showSearchControlInIndicator(animated = true)
    }

    private fun updatePageIndicatorDots(selectedPosition: Int) {
        if (indicatorMode != IndicatorMode.DOTS && !editingHome) return

        val pageCount = homeIndicatorPageCount()
        if (pageCount <= 1) return

        val selectedPage = selectedPosition.coerceIn(0, pageCount - 1)
        val markers = LauncherPageIndicatorWindowPolicy.markers(
            pageCount = pageCount,
            selectedPage = selectedPage
        )
        ensureIndicatorWheelView().setMarkers(markers, animate = false)
    }

    private fun showDotsInIndicator(position: Int, animate: Boolean) {
        showDotsIndicatorFrame()
        updatePageIndicatorDots(position)
        if (animate) {
            binding.workspace.pageIndicator.animate()
                .alpha(1f)
                .setDuration(120L)
                .setInterpolator(DecelerateInterpolator())
                .start()
        }
    }

    private fun updatePageIndicatorScroll(position: Int, positionOffset: Float) {
        if (binding.workspace.searchOverlay.visibility == View.VISIBLE) return
        if (!::workspacePageAdapter.isInitialized) return
        if (!isHomePage(position) && !isHomePage(position + 1)) return

        val pageCount = homeIndicatorPageCount()
        if (pageCount <= 1) return

        val homePagePosition = (
            position - workspacePageAdapter.firstHomeAdapterPosition() + positionOffset
        ).coerceIn(0f, (pageCount - 1).toFloat())
        showDotsIndicatorFrame()
        ensureIndicatorWheelView().setScrollPosition(
            pageCount = pageCount,
            pagePosition = homePagePosition
        )
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        if (!editingHome) {
            indicatorHandler.postDelayed(hideIndicatorRunnable, PAGE_INDICATOR_VISIBLE_MS)
        }
    }

    private fun showDotsIndicatorFrame() {
        indicatorMode = IndicatorMode.DOTS
        ensureDotsIndicatorFrame()
        ensureIndicatorWheelView()
        binding.workspace.searchPill.animate().cancel()
        binding.workspace.searchPill.visibility = View.GONE
        if (homeIndicatorPageCount() <= 1) {
            binding.workspace.pageIndicator.removeAllViews()
            binding.workspace.pageIndicator.visibility = View.GONE
            return
        }
        binding.workspace.pageIndicator.apply {
            animate().cancel()
            isClickable = false
            alpha = 1f
            visibility = View.VISIBLE
        }
    }

    private fun showSearchControlInIndicator(animated: Boolean) {
        if (binding.workspace.searchOverlay.visibility == View.VISIBLE) return
        if (isWidgetPage(binding.workspace.workspacePager.currentItem)) return
        if (isLibraryPage(binding.workspace.workspacePager.currentItem)) return
        if (editingHome) return

        indicatorMode = IndicatorMode.SEARCH
        ensureSearchIndicatorFrame()
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        binding.workspace.searchPill.animate().cancel()
        binding.workspace.searchPill.visibility = View.GONE
        binding.workspace.pageIndicator.apply {
            animate().cancel()
            isClickable = true
            alpha = 1f
            visibility = View.VISIBLE
            removeAllViews()
            addView(createIndicatorSearchText())
        }
        if (animated) {
            val child = binding.workspace.pageIndicator.getChildAt(0) ?: return
            child.alpha = 0f
            child.animate()
                .alpha(1f)
                .setDuration(150L)
                .setInterpolator(DecelerateInterpolator())
                .start()
        }
    }

    private fun createIndicatorSearchText(): TextView {
        return TextView(this).apply {
            text = getString(R.string.launcher_search_hint)
            gravity = Gravity.CENTER
            includeFontPadding = false
            setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search_18, 0, 0, 0)
            compoundDrawablePadding = dp(4)
            setTextColor(Color.WHITE)
            textSize = 12f
            layoutParams = android.widget.LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }

    private fun ensureDotsIndicatorFrame() {
        binding.workspace.pageIndicator.layoutParams = binding.workspace.pageIndicator.layoutParams.apply {
            width = dp(PAGE_INDICATOR_SEARCH_WIDTH_DP)
            height = dp(PAGE_INDICATOR_SEARCH_HEIGHT_DP)
        }
        binding.workspace.pageIndicator.setPadding(
            dp(PAGE_INDICATOR_DOT_PADDING_DP),
            0,
            dp(PAGE_INDICATOR_DOT_PADDING_DP),
            0
        )
        binding.workspace.pageIndicator.layoutTransition = null
    }

    private fun ensureIndicatorWheelView(): LauncherPageIndicatorWheelView {
        indicatorWheelView?.let { wheelView ->
            if (wheelView.parent === binding.workspace.pageIndicator) return wheelView
        }

        val wheelView = LauncherPageIndicatorWheelView(this).apply {
            layoutParams = android.widget.LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
        binding.workspace.pageIndicator.removeAllViews()
        binding.workspace.pageIndicator.addView(wheelView)
        indicatorWheelView = wheelView
        return wheelView
    }

    private fun ensureSearchIndicatorFrame() {
        binding.workspace.pageIndicator.layoutParams = binding.workspace.pageIndicator.layoutParams.apply {
            width = dp(PAGE_INDICATOR_SEARCH_WIDTH_DP)
            height = dp(PAGE_INDICATOR_SEARCH_HEIGHT_DP)
        }
        binding.workspace.pageIndicator.setPadding(dp(10), 0, dp(10), 0)
        indicatorWheelView = null
    }

    private fun homeIndicatorPageCount(): Int {
        return workspacePageAdapter.homePageCount()
    }

    private fun updateWorkspaceChromeForPage(position: Int) {
        val libraryPage = isLibraryPage(position)
        val widgetPage = isWidgetPage(position)
        binding.workspace.bottomControlSlot.visibility = if (libraryPage || widgetPage) View.GONE else View.VISIBLE
        binding.workspace.dockRecyclerView.visibility = if (libraryPage || widgetPage) View.GONE else View.VISIBLE
        if (libraryPage || widgetPage) {
            indicatorHandler.removeCallbacks(hideIndicatorRunnable)
            binding.workspace.pageIndicator.visibility = View.GONE
            binding.workspace.searchPill.visibility = View.GONE
        } else if (editingHome) {
            binding.workspace.searchPill.visibility = View.GONE
            showDotsInIndicator(workspacePageAdapter.homePagePositionForAdapterPosition(position), animate = false)
            binding.workspace.pageIndicator.visibility = View.VISIBLE
        } else if (indicatorMode == IndicatorMode.SEARCH) {
            showSearchControlInIndicator(animated = false)
        }
    }

    private fun updatePageIndicatorDotsForAdapterPosition(position: Int) {
        if (isHomePage(position)) {
            updatePageIndicatorDots(workspacePageAdapter.homePagePositionForAdapterPosition(position))
        }
    }

    private fun isLibraryPage(position: Int): Boolean {
        return workspacePageAdapter.itemCount > 0 && position == workspacePageAdapter.itemCount - 1
    }

    private fun isWidgetPage(position: Int): Boolean {
        return ::workspacePageAdapter.isInitialized && workspacePageAdapter.isWidgetPage(position)
    }

    private fun isHomePage(position: Int): Boolean {
        return ::workspacePageAdapter.isInitialized && workspacePageAdapter.isHomePage(position)
    }

    private fun currentHomePageIndex(): Int {
        return workspacePageAdapter.homePagePositionForAdapterPosition(
            binding.workspace.workspacePager.currentItem
        ).coerceIn(0, (workspacePageAdapter.homePageCount() - 1).coerceAtLeast(0))
    }

    private fun setHomeEditing(enabled: Boolean) {
        if (editingHome == enabled) return

        if (!enabled) {
            cancelActiveHomeDrags()
        }

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
            if (isHomePage(binding.workspace.workspacePager.currentItem)) {
                showDotsInIndicator(currentHomePageIndex(), animate = false)
            } else {
                binding.workspace.pageIndicator.visibility = View.GONE
            }
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
            if (isHomePage(binding.workspace.workspacePager.currentItem)) {
                showSearchControlInIndicator(animated = true)
            }
            workspacePageAdapter.submitItems(homeItems)
            dockAdapter.submitItems(dockItems)
        }
    }

    private fun cancelActiveHomeDrags() {
        homeEdgeSwitchHandler.removeCallbacks(homeEdgeSwitchRunnable)
        folderEdgeSwitchHandler.removeCallbacks(folderEdgeSwitchRunnable)

        if (homeEdgeDragActive) {
            hideHomeEdgeDragPreview(restoreWorkspace = true)
        }
        if (homeDockDragActive) {
            hideHomeDockDragPreview()
        }
        if (folderExitDragActive) {
            hideFolderExitDragPreview(restoreWorkspace = true)
        }

        resetFolderExitDragVisuals()
        hideFolderEdgeGlows()
        binding.workspace.workspacePager.isUserInputEnabled = true
        forceHideSelectedIconPreview()
    }

    private fun forceHideSelectedIconPreview() {
        binding.workspace.selectedIconPreview.animate().cancel()
        binding.workspace.selectedIconImage.setImageDrawable(null)
        binding.workspace.selectedIconLabel.text = ""
        binding.workspace.selectedIconLabel.alpha = 1f
        binding.workspace.selectedIconPreview.apply {
            clearAnimation()
            setLayerType(View.LAYER_TYPE_NONE, null)
            visibility = View.GONE
            alpha = 1f
            scaleX = 1f
            scaleY = 1f
            translationX = 0f
            translationY = 0f
            translationZ = 0f
            elevation = 0f
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

    private fun requestWeatherLocationPermission() {
        if (hasWeatherLocationPermission()) {
            updateWidgetWeatherPermissionState()
            return
        }
        weatherLocationPermissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
    }

    private fun updateWidgetWeatherPermissionState() {
        if (::workspacePageAdapter.isInitialized) {
            workspacePageAdapter.setWeatherLocationGranted(hasWeatherLocationPermission())
        }
    }

    private fun hasWeatherLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
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

    private fun applyLayoutAppearance() {
        IosLauncherIconTheme.setDarkMode(layoutDarkMode)
        applySettingsAppearance()
        applyLayoutSettingsAppearance()
        applyLiquidGlassSettingsAppearance()
        applyBlurSettingsAppearance()
        applyAnimationSettingsAppearance()
        applyWorkspaceAppearance()
        invalidateLauncherArtwork()
        tintLayoutSwitches()
        binding.darkModeSwitch.setOnCheckedChangeListener(null)
        binding.darkModeSwitch.isChecked = layoutDarkMode
        binding.darkModeSwitch.setOnCheckedChangeListener { _, checked ->
            presenter.onLayoutDarkModeChanged(checked)
        }
        binding.iphone8Switch.setOnCheckedChangeListener(null)
        binding.iphone8Switch.isChecked = layoutIphone8Style
        binding.iphone8Switch.setOnCheckedChangeListener { _, checked ->
            applyIphone8Style(checked, persist = true)
        }
    }

    private fun applySettingsAppearance() {
        val backgroundColor = themedColor(R.color.settings_background, R.color.dark_settings_background)
        val cardColor = themedColor(R.color.settings_card, R.color.dark_settings_card)
        val primaryTextColor = themedColor(R.color.launcher_text_primary, R.color.dark_settings_text_primary)
        val dividerColor = themedColor(R.color.settings_divider, R.color.dark_settings_divider)

        binding.settingsPanel.setBackgroundColor(backgroundColor)
        listOf(
            binding.settingsTopCard,
            binding.settingsMainCard,
            binding.settingsBottomCard
        ).forEach { card ->
            card.background = roundedBackground(cardColor, 10)
        }

        settingsRows().forEach { row ->
            row.rowTitle.setTextColor(primaryTextColor)
            row.rowDivider.setBackgroundColor(dividerColor)
        }
        binding.settingsDrawerPanel.setBackgroundColor(backgroundColor)
        applyLauncherRootBackground(state.launcherMode)
    }

    private fun applyLayoutSettingsAppearance() {
        val backgroundColor = themedColor(R.color.settings_background, R.color.dark_settings_background)
        val cardColor = themedColor(R.color.settings_card, R.color.dark_settings_card)
        val primaryTextColor = themedColor(R.color.launcher_text_primary, R.color.dark_settings_text_primary)
        val secondaryTextColor = themedColor(R.color.launcher_text_secondary, R.color.dark_settings_text_secondary)
        val dividerColor = themedColor(R.color.settings_divider, R.color.dark_settings_divider)

        binding.layoutSettingsPanel.setBackgroundColor(backgroundColor)
        binding.layoutSettingsToolbar.setBackgroundColor(cardColor)
        binding.layoutSettingsScroll.setBackgroundColor(backgroundColor)
        binding.layoutTopSpacer.setBackgroundColor(backgroundColor)
        binding.layoutOptionsCard.setBackgroundColor(cardColor)
        binding.iconSizePanel.setBackgroundColor(cardColor)
        binding.homeGridPanel.setBackgroundColor(cardColor)
        binding.layoutTitle.setTextColor(primaryTextColor)
        listOf(
            binding.darkModeTitle,
            binding.iphone8Title,
            binding.bottomSpacingTitle,
            binding.autoArrangeTitle,
            binding.hideNavigationTitle,
            binding.iconSizeHeader,
            binding.homeGridHeader,
            binding.grid5x4Label,
            binding.grid6x4Label
        ).forEach { textView ->
            textView.setTextColor(secondaryTextColor)
        }
        listOf(
            binding.layoutDivider1,
            binding.layoutDivider2,
            binding.layoutDivider3,
            binding.layoutDivider4
        ).forEach { divider ->
            divider.setBackgroundColor(dividerColor)
        }
        val gridIconColor = if (layoutDarkMode) 0xFF8A8A8E.toInt() else 0xFF8F8F8F.toInt()
        binding.grid5x4Icon.setTextColor(gridIconColor)
        binding.grid6x4Icon.setTextColor(gridIconColor)
        binding.iconSizeSeekBar.progressTintList = ColorStateList.valueOf(getColor(R.color.layout_ios_blue))
        binding.iconSizeSeekBar.progressBackgroundTintList =
            ColorStateList.valueOf(if (layoutDarkMode) 0xFF1C1C1E.toInt() else 0xFFC7C7CC.toInt())
        binding.iconSizeSeekBar.thumbTintList = ColorStateList.valueOf(cardColor)
        applyHomeLayoutSettingsUi()
    }

    private fun applyLiquidGlassSettingsAppearance() {
        val backgroundColor = themedColor(R.color.settings_background, R.color.dark_settings_background)
        val cardColor = themedColor(R.color.settings_card, R.color.dark_settings_card)
        val primaryTextColor = themedColor(R.color.launcher_text_primary, R.color.dark_settings_text_primary)

        binding.liquidGlassSettingsPanel.setBackgroundColor(backgroundColor)
        binding.liquidGlassSettingsToolbar.setBackgroundColor(cardColor)
        binding.liquidGlassContent.setBackgroundColor(backgroundColor)
        binding.liquidGlassTopSpacer.setBackgroundColor(backgroundColor)
        binding.liquidGlassOptionsCard.setBackgroundColor(cardColor)
        binding.liquidGlassTitle.setTextColor(primaryTextColor)
        binding.liquidGlassOptionTitle.setTextColor(primaryTextColor)
        binding.liquidGlassIconContainer.backgroundTintList =
            ColorStateList.valueOf(getColor(R.color.icon_liquid))
        binding.liquidGlassSwitch.setOnCheckedChangeListener(null)
        binding.liquidGlassSwitch.isChecked = layoutLiquidGlass
        binding.liquidGlassSwitch.setOnCheckedChangeListener { _, checked ->
            applyLiquidGlass(checked, persist = true)
        }
    }

    private fun applyBlurSettingsAppearance() {
        val backgroundColor = themedColor(R.color.settings_background, R.color.dark_settings_background)
        val cardColor = themedColor(R.color.settings_card, R.color.dark_settings_card)
        val primaryTextColor = themedColor(R.color.launcher_text_primary, R.color.dark_settings_text_primary)

        binding.blurSettingsPanel.setBackgroundColor(backgroundColor)
        binding.blurSettingsToolbar.setBackgroundColor(cardColor)
        binding.blurSettingsScroll.setBackgroundColor(backgroundColor)
        binding.blurSettingsContent.setBackgroundColor(backgroundColor)
        binding.blurTopSpacer.setBackgroundColor(backgroundColor)
        binding.blurOptionsCard.setBackgroundColor(cardColor)
        binding.blurTitle.setTextColor(primaryTextColor)
        listOf(
            binding.blurMasterRow,
            binding.blurFolderRow,
            binding.blurWidgetRow,
            binding.blurSearchRow
        ).forEach { row ->
            row.rowTitle.setTextColor(primaryTextColor)
            row.iconContainer.backgroundTintList = ColorStateList.valueOf(getColor(R.color.icon_blur))
        }
        applyBlurSettingsUi()
    }

    private fun applyAnimationSettingsAppearance() {
        val backgroundColor = themedColor(R.color.settings_background, R.color.dark_settings_background)
        val cardColor = themedColor(R.color.settings_card, R.color.dark_settings_card)
        val primaryTextColor = themedColor(R.color.launcher_text_primary, R.color.dark_settings_text_primary)
        val dividerColor = themedColor(R.color.settings_divider, R.color.dark_settings_divider)

        binding.animationSettingsPanel.setBackgroundColor(backgroundColor)
        binding.animationSettingsToolbar.setBackgroundColor(cardColor)
        binding.animationSettingsScroll.setBackgroundColor(backgroundColor)
        binding.animationSettingsContent.setBackgroundColor(backgroundColor)
        binding.animationTopSpacer.setBackgroundColor(backgroundColor)
        binding.animationOptionsCard.setBackgroundColor(cardColor)
        binding.animationTitle.setTextColor(primaryTextColor)
        listOf(
            binding.animationUnlockRow,
            binding.animationOpenCloseRow,
            binding.animationParallaxRow
        ).forEach { row ->
            row.rowTitle.setTextColor(primaryTextColor)
            row.rowDivider.setBackgroundColor(dividerColor)
        }
        applyAnimationSettingsUi()
    }

    private fun applyHomeIconSize(sizeDp: Int, persist: Boolean) {
        val boundedSize = sizeDp.coerceIn(MIN_HOME_ICON_SIZE_DP, MAX_HOME_ICON_SIZE_DP)
        homeIconSizeDp = boundedSize
        if (persist) {
            layoutPreferences.edit()
                .putInt(KEY_HOME_ICON_SIZE_DP, boundedSize)
                .apply()
        }
        applyHomeLayoutSettingsUi()
        applyResponsiveWorkspaceLayout()
    }

    private fun applyHomeGridRows(rows: Int, persist: Boolean) {
        val boundedRows = rows.takeIf { value -> value == HOME_GRID_ROWS_5 || value == HOME_GRID_ROWS_6 }
            ?: DEFAULT_HOME_GRID_ROWS
        if (homeGridRows == boundedRows) {
            applyHomeLayoutSettingsUi()
            applyResponsiveWorkspaceLayout()
            return
        }

        val wasLibraryPage = ::workspacePageAdapter.isInitialized &&
            isLibraryPage(binding.workspace.workspacePager.currentItem)
        homeGridRows = boundedRows
        if (persist) {
            layoutPreferences.edit()
                .putInt(KEY_HOME_GRID_ROWS, boundedRows)
                .apply()
        }
        applyHomeLayoutSettingsUi()
        applyResponsiveWorkspaceLayout()
        if (::workspacePageAdapter.isInitialized) {
            val currentPage = binding.workspace.workspacePager.currentItem
            val targetPage = when {
                wasLibraryPage -> workspacePageAdapter.itemCount - 1
                isWidgetPage(currentPage) -> currentPage
                else -> workspacePageAdapter.adapterPositionForHomePage(currentHomePageIndex())
            }
            binding.workspace.workspacePager.setCurrentItem(targetPage.coerceAtLeast(0), false)
            updateWorkspaceChromeForPage(binding.workspace.workspacePager.currentItem)
            updatePageIndicatorDotsForAdapterPosition(binding.workspace.workspacePager.currentItem)
        }
    }

    private fun applyHomeLayoutSettingsUi() {
        val previewSize = dp(homeIconSizeDp)
        binding.iconSizePreview.layoutParams = binding.iconSizePreview.layoutParams.apply {
            width = previewSize
            height = previewSize
        }
        if (binding.iconSizeSeekBar.progress != homeIconSizeDp - MIN_HOME_ICON_SIZE_DP) {
            binding.iconSizeSeekBar.progress = homeIconSizeDp - MIN_HOME_ICON_SIZE_DP
        }

        val selectedColor = getColor(R.color.layout_switch_green)
        val unselectedColor = if (layoutDarkMode) 0xFF8A8A8E.toInt() else 0xFF8F8F8F.toInt()
        binding.grid5x4Icon.setTextColor(if (homeGridRows == HOME_GRID_ROWS_5) selectedColor else unselectedColor)
        binding.grid5x4Label.setTextColor(if (homeGridRows == HOME_GRID_ROWS_5) selectedColor else unselectedColor)
        binding.grid6x4Icon.setTextColor(if (homeGridRows == HOME_GRID_ROWS_6) selectedColor else unselectedColor)
        binding.grid6x4Label.setTextColor(if (homeGridRows == HOME_GRID_ROWS_6) selectedColor else unselectedColor)
    }

    private fun applyResponsiveWorkspaceLayout() {
        if (!::binding.isInitialized) return

        val workspaceRoot = binding.workspace.root
        val rootHeight = workspaceRoot.height
        if (rootHeight <= 0) {
            workspaceRoot.post { applyResponsiveWorkspaceLayout() }
            return
        }

        val spec = LauncherResponsiveWorkspaceLayout.resolve(
            rootHeightPx = rootHeight,
            density = resources.displayMetrics.density,
            preferredRows = homeGridRows,
            preferredIconSizeDp = homeIconSizeDp,
            iphone8Style = layoutIphone8Style
        )
        val currentPage = binding.workspace.workspacePager.currentItem
        val wasLibraryPage = ::workspacePageAdapter.isInitialized && isLibraryPage(currentPage)
        val wasWidgetPage = ::workspacePageAdapter.isInitialized && isWidgetPage(currentPage)

        effectiveHomeGridRows = spec.effectiveRows
        effectiveHomeIconSizeDp = spec.effectiveIconSizeDp

        binding.workspace.homeContent.setPadding(
            binding.workspace.homeContent.paddingLeft,
            dp(spec.homeTopPaddingDp),
            binding.workspace.homeContent.paddingRight,
            dp(spec.homeBottomPaddingDp)
        )
        binding.workspace.bottomControlSlot.layoutParams =
            binding.workspace.bottomControlSlot.layoutParams.apply {
                height = dp(spec.bottomControlHeightDp)
                if (this is android.widget.LinearLayout.LayoutParams) {
                    topMargin = dp(spec.bottomControlTopMarginDp)
                    bottomMargin = dp(spec.bottomControlBottomMarginDp)
                }
            }
        updateDockSize(spec)

        if (::workspacePageAdapter.isInitialized) {
            workspacePageAdapter.setHomeGridRows(spec.effectiveRows)
            workspacePageAdapter.setIconSizeDp(spec.effectiveIconSizeDp)
            val targetPage = if (wasLibraryPage) {
                workspacePageAdapter.itemCount - 1
            } else if (wasWidgetPage) {
                currentPage
            } else {
                workspacePageAdapter.adapterPositionForHomePage(currentHomePageIndex())
            }.coerceAtLeast(0)
            if (binding.workspace.workspacePager.currentItem != targetPage) {
                binding.workspace.workspacePager.setCurrentItem(targetPage, false)
            }
            updateWorkspaceChromeForPage(binding.workspace.workspacePager.currentItem)
            updatePageIndicatorDotsForAdapterPosition(binding.workspace.workspacePager.currentItem)
        }
        if (::dockAdapter.isInitialized) {
            dockAdapter.setIconSizeDp(spec.effectiveIconSizeDp)
        }
    }

    private fun updateDockSize(spec: LauncherResponsiveWorkspaceSpec? = null) {
        if (!::binding.isInitialized) return
        binding.workspace.dockRecyclerView.layoutParams = binding.workspace.dockRecyclerView.layoutParams.apply {
            height = dp(
                spec?.dockHeightDp ?: (effectiveHomeIconSizeDp + if (layoutIphone8Style) {
                    DOCK_IPHONE8_VERTICAL_EXTRA_DP
                } else {
                    DOCK_VERTICAL_EXTRA_DP
                })
            )
            if (this is android.widget.LinearLayout.LayoutParams) {
                marginStart = 0
                marginEnd = 0
                bottomMargin = 0
            }
        }
        val horizontalPaddingDp = spec?.dockHorizontalPaddingDp ?: 14
        val verticalPaddingDp = spec?.dockVerticalPaddingDp ?: 10
        binding.workspace.dockRecyclerView.setPadding(
            dp(horizontalPaddingDp),
            dp(verticalPaddingDp),
            dp(horizontalPaddingDp),
            dp(verticalPaddingDp)
        )
    }

    private fun applyWorkspaceAppearance() {
        val dockColor = if (layoutDarkMode) 0x78404D5C else 0x6B3CA9E8
        val dockStroke = if (layoutDarkMode) 0x55FFFFFF else 0x66FFFFFF
        val folderColor = when {
            layoutLiquidGlass -> 0x52FFFFFF
            layoutDarkMode -> 0x5A42484B
            else -> 0x705F6663
        }
        val folderStroke = if (layoutLiquidGlass) 0x90FFFFFF.toInt() else null
        val pillColor = if (layoutDarkMode) 0xA8001520.toInt() else 0x9A001A24.toInt()
        val indicatorColor = if (layoutDarkMode) 0x66324B5C else 0x733B5B6A
        val searchTextColor = Color.WHITE

        binding.workspace.dockRecyclerView.background = roundedBackground(
            dockColor,
            38,
            dockStroke
        )
        binding.workspace.searchPill.background = roundedBackground(pillColor, 17)
        binding.workspace.searchPillText.setTextColor(searchTextColor)
        binding.workspace.searchPillIcon.imageTintList = ColorStateList.valueOf(searchTextColor)
        binding.workspace.pageIndicator.background = roundedBackground(indicatorColor, 16)
        binding.workspace.folderContentPanel.background = roundedBackground(
            color = folderColor,
            radiusDp = 34,
            strokeColor = folderStroke
        )
        binding.workspace.folderOverlay.setBackgroundColor(folderOverlayDimColor())
        binding.workspace.widgetSheet.setBackgroundColor(
            themedColor(R.color.settings_card, R.color.dark_settings_card)
        )
        if (::searchController.isInitialized) {
            searchController.setDarkMode(layoutDarkMode)
        }

        if (::workspacePageAdapter.isInitialized) {
            workspacePageAdapter.setDarkMode(layoutDarkMode)
            workspacePageAdapter.setLiquidGlassEnabled(layoutLiquidGlass)
        }
        if (::dockAdapter.isInitialized) {
            dockAdapter.setDarkMode(layoutDarkMode)
            dockAdapter.setLiquidGlassEnabled(layoutLiquidGlass)
        }
        if (::categoryDetailAdapter.isInitialized) {
            categoryDetailAdapter.setDarkMode(layoutDarkMode)
        }
        if (::folderContentAdapter.isInitialized) {
            folderContentAdapter.setDarkMode(layoutDarkMode)
            folderContentAdapter.setLiquidGlassEnabled(layoutLiquidGlass)
        }
        if (::workspacePageAdapter.isInitialized) {
            updatePageIndicatorDotsForAdapterPosition(binding.workspace.workspacePager.currentItem)
        }
    }

    private fun invalidateLauncherArtwork() {
        homeItems.flatMap { item -> item.containedApps() }
            .forEach { iconItem -> iconItem.icon.invalidateSelf() }
        binding.workspace.root.invalidate()
        binding.workspace.workspacePager.invalidate()
        binding.workspace.dockRecyclerView.invalidate()
    }

    private fun tintLayoutSwitches() {
        val uncheckedColor = getColor(R.color.layout_switch_orange)
        val checkedColor = getColor(R.color.layout_switch_green)
        val thumbTint = ColorStateList(
            arrayOf(intArrayOf(android.R.attr.state_checked), intArrayOf()),
            intArrayOf(checkedColor, uncheckedColor)
        )
        val trackTint = ColorStateList(
            arrayOf(intArrayOf(android.R.attr.state_checked), intArrayOf()),
            intArrayOf(0xFFFFFFFF.toInt(), 0xFFFFFFFF.toInt())
        )
        listOf(
            binding.darkModeSwitch,
            binding.iphone8Switch,
            binding.bottomSpacingSwitch,
            binding.autoArrangeSwitch,
            binding.liquidGlassSwitch,
            binding.blurMasterRow.rowSwitch,
            binding.blurFolderRow.rowSwitch,
            binding.blurWidgetRow.rowSwitch,
            binding.blurSearchRow.rowSwitch,
            binding.animationUnlockRow.rowSwitch,
            binding.animationOpenCloseRow.rowSwitch,
            binding.animationParallaxRow.rowSwitch
        ).forEach { switch ->
            switch.thumbTintList = thumbTint
            switch.trackTintList = trackTint
        }
    }

    private fun settingsRows(): List<ViewLauncherSettingRowBinding> {
        return listOf(
            binding.lockScreenRow,
            binding.controlCenterRow,
            binding.assistiveTouchRow,
            binding.layoutRow,
            binding.weatherRow,
            binding.liquidGlassRow,
            binding.blurEffectRow,
            binding.motionWallpaperRow,
            binding.wallpaperRow,
            binding.changeIconRow,
            binding.renameRow,
            binding.appLibraryRow,
            binding.hiddenAppsRow,
            binding.notificationsRow,
            binding.makeDefaultLauncherRow,
            binding.rateRow,
            binding.moreAppsRow
        )
    }

    private fun themedColor(lightColorRes: Int, darkColorRes: Int): Int {
        return getColor(if (layoutDarkMode) darkColorRes else lightColorRes)
    }

    private fun folderOverlayDimColor(): Int {
        return when {
            layoutLiquidGlass -> 0x10000000
            layoutDarkMode -> 0x44000000
            else -> FOLDER_OVERLAY_DIM_COLOR
        }
    }

    private fun roundedBackground(
        color: Int,
        radiusDp: Int,
        strokeColor: Int? = null,
        strokeWidthDp: Int = 1
    ): GradientDrawable {
        return GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(radiusDp).toFloat()
            setColor(color)
            strokeColor?.let { setStroke(dp(strokeWidthDp), it) }
        }
    }

    private fun obtainStyledForeground(): Drawable? {
        val attrs = obtainStyledAttributes(intArrayOf(android.R.attr.selectableItemBackground))
        return attrs.getDrawable(0).also {
            attrs.recycle()
        }
    }

    private fun applyLauncherRootBackground(showLauncherWorkspace: Boolean) {
        if (showLauncherWorkspace) {
            val customWallpaper = customWallpaperDrawable()
            if (customWallpaper != null) {
                binding.launcher.background = customWallpaper
            } else {
                binding.launcher.setBackgroundResource(R.drawable.bg_ios_wallpaper)
            }
        } else {
            binding.launcher.setBackgroundColor(
                themedColor(R.color.settings_background, R.color.dark_settings_background)
            )
        }
    }

    private fun customWallpaperDrawable(): Drawable? {
        val rawUri = layoutPreferences.getString(KEY_CUSTOM_WALLPAPER_URI, null) ?: return null
        val uri = runCatching { Uri.parse(rawUri) }.getOrNull() ?: return null
        return runCatching {
            contentResolver.openInputStream(uri)?.use { input ->
                Drawable.createFromStream(input, rawUri)
            }
        }.getOrNull()
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
        state.launcherMode = showLauncherWorkspace
        binding.settingsPanel.visibility = if (showLauncherWorkspace) View.GONE else View.VISIBLE
        binding.layoutSettingsPanel.visibility = View.GONE
        binding.liquidGlassSettingsPanel.visibility = View.GONE
        binding.blurSettingsPanel.visibility = View.GONE
        binding.animationSettingsPanel.visibility = View.GONE
        binding.settingsFab.visibility = if (showLauncherWorkspace) View.GONE else View.VISIBLE
        binding.workspace.root.visibility = if (showLauncherWorkspace) View.VISIBLE else View.GONE
        applyLauncherRootBackground(showLauncherWorkspace)
        if (showLauncherWorkspace && (forceAnimate || !lastLauncherMode)) {
            if (currentAnimationSettings().unlockEnabled) {
                binding.workspace.root.apply {
                    alpha = 0f
                    translationY = 28f
                    animate()
                        .alpha(1f)
                        .translationY(0f)
                        .setDuration(260L)
                        .setInterpolator(DecelerateInterpolator())
                        .start()
                }
            } else {
                binding.workspace.root.apply {
                    animate().cancel()
                    alpha = 1f
                    translationY = 0f
                }
            }
        }
        lastLauncherMode = showLauncherWorkspace
    }

    private fun updateLauncherContentDescription() {
        binding.launcher.contentDescription = getString(
            R.string.launcher_installed_apps_count_a11y,
            state.appCount
        )
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

    private data class FolderExitDragMetrics(
        val rootLeftOnScreen: Int,
        val rootTopOnScreen: Int,
        val rootWidth: Int,
        val rootHeight: Int,
        val previewWidth: Int,
        val previewHeight: Int,
        val pagerLeftInRoot: Float,
        val pagerTopInRoot: Float,
        val pagerWidth: Int,
        val pagerHeight: Int,
        val cellWidth: Float,
        val cellHeight: Float
    )

    private enum class FolderSource {
        HOME,
        DOCK
    }

    private enum class IndicatorMode {
        DOTS,
        SEARCH
    }

    private data class DockDropPreviewTarget(
        val left: Float,
        val top: Float
    )

    private companion object {
        const val DOCK_APP_COUNT = 4
        const val SEARCH_COLUMNS = 4
        const val SEARCH_ICON_CELL_HEIGHT_DP = 104
        const val FOLDER_ICON_CELL_HEIGHT_DP = 112
        const val FOLDER_ICON_SIZE_DP = 58
        const val PAGE_INDICATOR_VISIBLE_MS = 2000L
        const val PAGE_INDICATOR_SEARCH_WIDTH_DP = 104
        const val PAGE_INDICATOR_SEARCH_HEIGHT_DP = 34
        const val PAGE_INDICATOR_DOT_PADDING_DP = 4
        const val PULL_DOWN_SEARCH_THRESHOLD_DP = 54
        const val PULL_DOWN_HORIZONTAL_ESCAPE_DP = 28
        const val FOLDER_EXIT_SLOP_DP = 28
        const val FOLDER_EXIT_COLLAPSED_PANEL_SCALE = 0.16f
        const val DRAG_PREVIEW_WIDTH_DP = 94
        const val DRAG_PREVIEW_HEIGHT_DP = 118
        const val DRAG_PREVIEW_ICON_CENTER_Y_DP = 36
        const val DRAG_PREVIEW_ELEVATION_DP = 70
        const val HOME_DOCK_DROP_IN_MS = 170L
        const val HOME_DOCK_DROP_POP_MS = 95L
        const val HOME_DOCK_DROP_SHRINK_SCALE = 0.72f
        const val FOLDER_EXIT_PREVIEW_ELEVATION_DP = 88
        const val HOME_EDGE_SWITCH_ZONE_DP = LauncherHomePageEdgeDragPolicy.DEFAULT_EDGE_ZONE_DP
        const val HOME_EDGE_SWITCH_DELAY_MS = 420L
        const val HOME_EDGE_SWITCH_START_DELAY_MS = 45L
        const val HOME_EDGE_NEW_PAGE_SWITCH_START_DELAY_MS = 95L
        const val HOME_EDGE_PAGE_SWITCH_ANIMATION_MS = 360L
        const val HOME_EDGE_PAGE_SWITCH_SETTLE_MS = 80L
        const val FOLDER_EDGE_SWITCH_ZONE_DP = 30
        const val FOLDER_EDGE_SWITCH_DELAY_MS = 320L
        const val FOLDER_OVERLAY_DIM_COLOR = 0x22000000
        const val HOME_PAGE_COLUMNS = 4
        const val HOME_GRID_ROWS_5 = 5
        const val HOME_GRID_ROWS_6 = 6
        const val DEFAULT_HOME_GRID_ROWS = HOME_GRID_ROWS_6
        const val MIN_HOME_ICON_SIZE_DP = 52
        const val DEFAULT_HOME_ICON_SIZE_DP = 64
        const val MAX_HOME_ICON_SIZE_DP = 78
        const val HOME_HORIZONTAL_PADDING_DP = 18
        const val HOME_BOTTOM_PADDING_DP = 16
        const val DOCK_VERTICAL_EXTRA_DP = 28
        const val DOCK_IPHONE8_VERTICAL_EXTRA_DP = 58
        const val NO_PREVIEW_INDEX = -1
        const val EMPTY_LONG_PRESS_MS = 520L
        const val EMPTY_LONG_PRESS_SLOP_DP = 10
        const val DRAWER_OPEN_ANIMATION_MS = 220L
        const val DRAWER_CLOSE_ANIMATION_MS = 180L
        const val DRAWER_DIM_ANIMATION_MS = 160L
        const val APP_OPEN_PREVIEW_ANIMATION_MS = 95L
        const val LAYOUT_PREFERENCES_NAME = "launcher_layout_preferences"
        const val KEY_LAYOUT_DARK_MODE = "layout_dark_mode"
        const val KEY_LAYOUT_IPHONE8_STYLE = "layout_iphone8_style"
        const val KEY_LAYOUT_AUTO_ARRANGE = "layout_auto_arrange"
        const val KEY_LAYOUT_LIQUID_GLASS = "layout_liquid_glass"
        const val KEY_BLUR_EFFECT_ENABLED = "blur_effect_enabled"
        const val KEY_BLUR_FOLDER_ENABLED = "blur_folder_enabled"
        const val KEY_BLUR_WIDGET_ENABLED = "blur_widget_enabled"
        const val KEY_BLUR_SEARCH_ENABLED = "blur_search_enabled"
        const val KEY_ANIMATION_UNLOCK_ENABLED = "unlock_animation"
        const val KEY_ANIMATION_OPEN_CLOSE_ENABLED = "open_close_animation"
        const val KEY_ANIMATION_PARALLAX_ZOOM_ENABLED = "parallax_zoom_animations"
        const val KEY_CUSTOM_WALLPAPER_URI = "custom_wallpaper_uri"
        const val KEY_HOME_ICON_SIZE_DP = "home_icon_size_dp"
        const val KEY_HOME_GRID_ROWS = "home_grid_rows"
        const val KEY_HOME_LAYOUT_ITEMS = "home_layout_items"
        const val KEY_DEFAULT_LAUNCHER_WELCOME_SHOWN = "default_launcher_welcome_shown"
        const val DEFAULT_ANIMATION_UNLOCK_ENABLED = true
        const val DEFAULT_ANIMATION_OPEN_CLOSE_ENABLED = false
        const val DEFAULT_ANIMATION_PARALLAX_ZOOM_ENABLED = false
    }
}
