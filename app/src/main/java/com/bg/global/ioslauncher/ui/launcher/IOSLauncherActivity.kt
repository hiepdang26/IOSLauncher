package com.bg.global.ioslauncher.ui.launcher

import android.app.role.RoleManager
import android.app.Dialog
import android.content.Context
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.RenderEffect
import android.graphics.Shader
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import android.widget.PopupWindow
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bg.global.ioslauncher.R
import com.bg.global.ioslauncher.data.model.LauncherApp
import com.bg.global.ioslauncher.data.model.LauncherAppCategory
import com.bg.global.ioslauncher.databinding.ActivityIosLauncherBinding
import com.bg.global.ioslauncher.databinding.PopupLauncherAppOptionsBinding
import com.bg.global.ioslauncher.di.RepositoryProvider
import com.bg.global.ioslauncher.ui.applibrary.AppLibraryActivity
import com.bg.global.ioslauncher.ui.launcher.workspace.AppLibraryGroupUiModel
import com.bg.global.ioslauncher.ui.launcher.workspace.AppLibrarySearchAdapter
import com.bg.global.ioslauncher.ui.launcher.workspace.LauncherDockAdapter
import com.bg.global.ioslauncher.ui.launcher.workspace.LauncherIconAdapter
import com.bg.global.ioslauncher.ui.launcher.workspace.LauncherIconUiModel
import com.bg.global.ioslauncher.ui.launcher.workspace.LauncherPageAdapter
import com.bg.global.ioslauncher.ui.launcher.workspace.WidgetAppAdapter
import kotlin.math.abs

class IOSLauncherActivity : AppCompatActivity(), IOSLauncherContract.View {
    private lateinit var binding: ActivityIosLauncherBinding
    private lateinit var presenter: IOSLauncherPresenter
    private lateinit var workspacePageAdapter: LauncherPageAdapter
    private lateinit var dockAdapter: LauncherDockAdapter
    private lateinit var searchAdapter: LauncherIconAdapter
    private lateinit var categoryDetailAdapter: LauncherIconAdapter
    private lateinit var librarySearchAdapter: AppLibrarySearchAdapter
    private lateinit var widgetAppAdapter: WidgetAppAdapter
    private val state = LauncherUiState()
    private val indicatorHandler = Handler(Looper.getMainLooper())
    private val hideIndicatorRunnable = Runnable { hidePageIndicator() }
    private var allLauncherApps: List<LauncherIconUiModel> = emptyList()
    private var librarySearchSectionPositions: Map<String, Int> = emptyMap()
    private var appOptionsPopup: PopupWindow? = null
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
    private var widgetSheetDownY = 0f
    private var lastLauncherMode = false
    private var editingHome = false
    private var forceSettingsPanel = false
    private var skipNextResumeReload = true
    private var waitingForLauncherSelection = false
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
        binding.appLibraryRow.root.setOnClickListener {
            startActivity(Intent(this, AppLibraryActivity::class.java))
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
        appOptionsPopup?.dismiss()
        presenter.detachView()
        super.onDestroy()
    }

    override fun showLoading(isLoading: Boolean) {
        state.loading.set(isLoading)
    }

    override fun showLauncherApps(apps: List<LauncherIconUiModel>) {
        allLauncherApps = apps
        state.appCount.set(apps.size)
        workspacePageAdapter.submitApps(apps)
        workspacePageAdapter.submitLibraryGroups(buildLibraryGroups(apps))
        dockAdapter.submitApps(apps.take(DOCK_APP_COUNT))
        widgetAppAdapter.submitApps(apps)
        updateWorkspaceChromeForPage(binding.workspace.workspacePager.currentItem)
        updatePageIndicatorDots(binding.workspace.workspacePager.currentItem)
        updateSearchResults(binding.workspace.searchEditText.text?.toString().orEmpty())
        updateLibrarySearchResults(binding.workspace.librarySearchEditText.text?.toString().orEmpty())
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
        appOptionsPopup?.dismiss()
        forceSettingsPanel = true
        if (editingHome) {
            setHomeEditing(false)
        }
        hideEditWidgetPrompt()
        hideWidgetSheet()
        hideCategoryDetail()
        hideLibrarySearchOverlay()
        hideSearchOverlay()
        updateLauncherMode()
        applyLauncherSystemUi()
    }

    private fun installSystemInsetHandling() {
        binding.launcher.fitsSystemWindows = false
        ViewCompat.setOnApplyWindowInsetsListener(binding.launcher) { view, insets ->
            view.setPadding(0, 0, 0, 0)
            insets
        }
        ViewCompat.setOnApplyWindowInsetsListener(binding.workspace.root) { view, insets ->
            view.setPadding(0, 0, 0, 0)
            insets
        }
        ViewCompat.requestApplyInsets(binding.launcher)
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
            onLibrarySearchClicked = { showLibrarySearchOverlay() },
            onLibraryGroupClicked = { group -> showCategoryDetail(group) }
        )
        dockAdapter = LauncherDockAdapter(
            onIconClicked = { item -> presenter.onOpenAppOptionClicked(item.app) },
            onRemoveClicked = { item -> showRemoveAppDialog(item.app) }
        )
        searchAdapter = LauncherIconAdapter(
            onIconClicked = { item -> presenter.onOpenAppOptionClicked(item.app) },
            onIconLongClicked = { item, anchor ->
                hideSearchOverlay(clearQuery = false)
                showAnchoredAppOptions(item, anchor)
                true
            }
        )
        categoryDetailAdapter = LauncherIconAdapter(
            onIconClicked = { item -> presenter.onOpenAppOptionClicked(item.app) },
            onIconLongClicked = { item, anchor ->
                hideCategoryDetail()
                showAnchoredAppOptions(item, anchor)
                true
            }
        )
        librarySearchAdapter = AppLibrarySearchAdapter(
            onAppClicked = { item -> presenter.onOpenAppOptionClicked(item.app) }
        )
        widgetAppAdapter = WidgetAppAdapter()

        binding.workspace.workspacePager.apply {
            adapter = workspacePageAdapter
            offscreenPageLimit = 1
            clipChildren = true
            clipToPadding = true
            setPageTransformer(null)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    updateWorkspaceChromeForPage(position)
                    showPageIndicator(position)
                }
            })
        }
        binding.workspace.searchPill.setOnClickListener {
            showSearchOverlay()
        }
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
            appOptionsPopup?.dismiss()
        }
        binding.workspace.cancelSearchButton.setOnClickListener {
            hideSearchOverlay()
        }
        binding.workspace.cancelLibrarySearchButton.setOnClickListener {
            hideLibrarySearchOverlay()
        }
        binding.workspace.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                updateSearchResults(s?.toString().orEmpty())
            }

            override fun afterTextChanged(s: Editable?) = Unit
        })
        binding.workspace.librarySearchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                updateLibrarySearchResults(s?.toString().orEmpty())
            }

            override fun afterTextChanged(s: Editable?) = Unit
        })

        binding.workspace.dockRecyclerView.apply {
            layoutManager = GridLayoutManager(this@IOSLauncherActivity, DOCK_APP_COUNT)
            adapter = dockAdapter
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator().apply {
                addDuration = 140L
                moveDuration = 160L
            }
        }
        binding.workspace.searchResultsRecyclerView.apply {
            layoutManager = GridLayoutManager(this@IOSLauncherActivity, SEARCH_COLUMNS)
            adapter = searchAdapter
            itemAnimator = null
            setHasFixedSize(true)
            post {
                searchAdapter.setItemHeight(dp(SEARCH_ICON_CELL_HEIGHT_DP))
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
        binding.workspace.librarySearchRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@IOSLauncherActivity)
            adapter = librarySearchAdapter
            itemAnimator = null
            setHasFixedSize(true)
        }
        binding.workspace.widgetAppsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@IOSLauncherActivity)
            adapter = widgetAppAdapter
            itemAnimator = null
            overScrollMode = View.OVER_SCROLL_NEVER
            setHasFixedSize(true)
        }
    }

    private fun buildLibraryGroups(apps: List<LauncherIconUiModel>): List<AppLibraryGroupUiModel> {
        val appsByCategory = apps.groupBy { item -> item.category }
        return listOf(
            AppLibraryGroupUiModel(
                category = LauncherAppCategory.RECENT,
                apps = apps.take(RECENT_LIBRARY_APP_COUNT)
            )
        ) + LauncherAppCategory.selectableEntries.map { category ->
            AppLibraryGroupUiModel(
                category = category,
                apps = appsByCategory[category].orEmpty()
            )
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
            binding.workspace.widgetSheetOverlay.visibility != View.VISIBLE &&
            binding.workspace.contextOverlay.visibility != View.VISIBLE &&
            appOptionsPopup == null &&
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
        if (isLibraryPage(binding.workspace.workspacePager.currentItem)) return false
        if (binding.workspace.contextOverlay.visibility == View.VISIBLE || appOptionsPopup != null) return false

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
            val dotSize = if (selected) dp(7) else dp(6)
            val dot = View(this).apply {
                alpha = if (selected) 1f else 0.58f
                background = GradientDrawable().apply {
                    shape = GradientDrawable.OVAL
                    setColor(Color.WHITE)
                }
                layoutParams = android.widget.LinearLayout.LayoutParams(dotSize, dotSize).apply {
                    marginStart = dp(4)
                    marginEnd = dp(4)
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
        appOptionsPopup?.dismiss()
        workspacePageAdapter.setEditing(enabled)
        dockAdapter.setEditing(enabled)

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
        if (binding.workspace.editWidgetPrompt.visibility == View.VISIBLE) {
            hideEditWidgetPrompt()
        } else {
            showEditWidgetPrompt()
        }
    }

    private fun showEditWidgetPrompt() {
        binding.workspace.editWidgetPrompt.apply {
            animate().cancel()
            alpha = 0f
            scaleX = 0.96f
            scaleY = 0.96f
            translationY = -dp(8).toFloat()
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f)
                .translationY(0f)
                .setDuration(160L)
                .start()
        }
    }

    private fun hideEditWidgetPrompt() {
        if (binding.workspace.editWidgetPrompt.visibility != View.VISIBLE) return

        binding.workspace.editWidgetPrompt.animate()
            .alpha(0f)
            .scaleX(0.96f)
            .scaleY(0.96f)
            .translationY(-dp(8).toFloat())
            .setDuration(120L)
            .withEndAction {
                binding.workspace.editWidgetPrompt.visibility = View.GONE
                binding.workspace.editWidgetPrompt.translationY = 0f
                binding.workspace.editWidgetPrompt.scaleX = 1f
                binding.workspace.editWidgetPrompt.scaleY = 1f
            }
            .start()
    }

    private fun showWidgetSheet() {
        binding.workspace.widgetSheetOverlay.apply {
            animate().cancel()
            alpha = 0f
            visibility = View.VISIBLE
        }
        binding.workspace.widgetSheet.post {
            binding.workspace.widgetSheet.translationY = binding.workspace.widgetSheet.height.toFloat()
            binding.workspace.widgetSheetOverlay.animate()
                .alpha(1f)
                .setDuration(140L)
                .start()
            binding.workspace.widgetSheet.animate()
                .translationY(0f)
                .setDuration(240L)
                .start()
        }
    }

    private fun hideWidgetSheet() {
        if (binding.workspace.widgetSheetOverlay.visibility != View.VISIBLE) return

        binding.workspace.widgetSheet.animate()
            .translationY(binding.workspace.widgetSheet.height.toFloat())
            .setDuration(180L)
            .start()
        binding.workspace.widgetSheetOverlay.animate()
            .alpha(0f)
            .setStartDelay(60L)
            .setDuration(140L)
            .withEndAction {
                binding.workspace.widgetSheetOverlay.visibility = View.GONE
                binding.workspace.widgetSheetOverlay.alpha = 1f
                binding.workspace.widgetSheet.translationY = 0f
                applyLauncherSystemUi()
            }
            .start()
    }

    private fun handleWidgetSheetDrag(event: MotionEvent): Boolean {
        return when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                widgetSheetDownY = event.rawY
                binding.workspace.widgetSheet.animate().cancel()
                true
            }

            MotionEvent.ACTION_MOVE -> {
                val dy = (event.rawY - widgetSheetDownY).coerceAtLeast(0f)
                binding.workspace.widgetSheet.translationY = dy * 0.72f
                true
            }

            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> {
                val dy = event.rawY - widgetSheetDownY
                if (dy > dp(WIDGET_SHEET_DISMISS_DRAG_DP)) {
                    hideWidgetSheet()
                } else {
                    binding.workspace.widgetSheet.animate()
                        .translationY(0f)
                        .setDuration(140L)
                        .start()
                }
                true
            }

            else -> true
        }
    }

    private fun showRemoveAppDialog(app: LauncherApp) {
        val dialog = Dialog(this)
        val content = android.widget.LinearLayout(this).apply {
            orientation = android.widget.LinearLayout.VERTICAL
            setPadding(dp(24), dp(22), dp(24), dp(16))
            background = getDrawable(R.drawable.bg_remove_app_dialog)
        }
        val title = android.widget.TextView(this).apply {
            text = app.label
            setTextColor(Color.BLACK)
            textSize = 20f
            setTypeface(typeface, android.graphics.Typeface.BOLD)
        }
        val message = android.widget.TextView(this).apply {
            text = "Bạn có muốn gỡ cài đặt ứng dụng này không?"
            setTextColor(Color.rgb(34, 48, 56))
            textSize = 14f
            setPadding(0, dp(14), 0, dp(24))
        }
        val actions = android.widget.LinearLayout(this).apply {
            gravity = Gravity.END
            orientation = android.widget.LinearLayout.HORIZONTAL
        }
        val cancel = android.widget.TextView(this).apply {
            text = "HỦY"
            setTextColor(Color.rgb(0, 96, 128))
            textSize = 14f
            gravity = Gravity.CENTER
            setPadding(dp(20), dp(12), dp(20), dp(12))
            setOnClickListener { dialog.dismiss() }
        }
        val ok = android.widget.TextView(this).apply {
            text = "OK"
            setTextColor(Color.rgb(0, 96, 128))
            textSize = 14f
            gravity = Gravity.CENTER
            setPadding(dp(20), dp(12), dp(20), dp(12))
            setOnClickListener {
                dialog.dismiss()
                requestUninstall(app)
            }
        }

        actions.addView(cancel)
        actions.addView(ok)
        content.addView(title)
        content.addView(message)
        content.addView(actions)

        dialog.setContentView(content)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setOnShowListener {
            dialog.window?.apply {
                setGravity(Gravity.BOTTOM)
                setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }
        dialog.show()
    }

    private fun requestUninstall(app: LauncherApp) {
        val packageUri = Uri.fromParts("package", app.packageName, null)
        val uninstallIntent = Intent(Intent.ACTION_DELETE, packageUri)
        runCatching {
            startActivity(uninstallIntent)
        }.onFailure {
            val fallbackIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageUri)
            runCatching { startActivity(fallbackIntent) }.onFailure {
                showError(getString(R.string.launcher_default_prompt_failed))
            }
        }
    }

    private fun showSearchOverlay() {
        appOptionsPopup?.dismiss()
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        binding.workspace.pageIndicator.visibility = View.GONE
        binding.workspace.searchPill.visibility = View.GONE
        binding.workspace.searchEditText.setText("")
        updateSearchResults("")
        applyHomeBlur()

        binding.workspace.searchOverlay.apply {
            animate().cancel()
            alpha = 0f
            visibility = View.VISIBLE
            animate().alpha(1f).setDuration(160L).start()
        }
        binding.workspace.searchEditText.requestFocus()
        showKeyboard(binding.workspace.searchEditText)
    }

    private fun hideSearchOverlay(clearQuery: Boolean = true) {
        if (clearQuery) {
            binding.workspace.searchEditText.text?.clear()
        }
        hideKeyboard(binding.workspace.searchEditText)

        if (binding.workspace.searchOverlay.visibility != View.VISIBLE) {
            binding.workspace.searchPill.visibility = View.VISIBLE
            return
        }

        binding.workspace.searchOverlay.animate()
            .alpha(0f)
            .setDuration(140L)
            .withEndAction {
                binding.workspace.searchOverlay.visibility = View.GONE
                binding.workspace.searchPill.apply {
                    alpha = 0f
                    visibility = View.VISIBLE
                    animate().alpha(1f).setDuration(140L).start()
                }
                if (binding.workspace.contextOverlay.visibility != View.VISIBLE) {
                    clearHomeBlur()
                }
            }
            .start()
    }

    private fun updateSearchResults(query: String) {
        if (!::searchAdapter.isInitialized) return

        val locale = java.util.Locale.getDefault()
        val normalizedQuery = query.trim().lowercase(locale)
        val results = if (normalizedQuery.isEmpty()) {
            allLauncherApps.take(SEARCH_SUGGESTION_COUNT)
        } else {
            allLauncherApps
                .filter { item ->
                    item.label.lowercase(locale).contains(normalizedQuery) ||
                        item.app.packageName.lowercase(locale).contains(normalizedQuery)
                }
                .take(SEARCH_RESULT_LIMIT)
        }
        searchAdapter.submitApps(results)
    }

    private fun showLibrarySearchOverlay() {
        if (binding.workspace.librarySearchOverlay.visibility == View.VISIBLE) return

        appOptionsPopup?.dismiss()
        hideCategoryDetail()
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        binding.workspace.pageIndicator.visibility = View.GONE
        binding.workspace.librarySearchEditText.setText("")
        updateLibrarySearchResults("")

        binding.workspace.librarySearchOverlay.apply {
            animate().cancel()
            alpha = 0f
            visibility = View.VISIBLE
        }
        binding.workspace.librarySearchField.apply {
            animate().cancel()
            alpha = 0f
            translationX = dp(LIBRARY_SEARCH_ENTER_X_DP).toFloat()
            scaleX = 0.96f
        }
        binding.workspace.cancelLibrarySearchButton.apply {
            animate().cancel()
            alpha = 0f
            translationX = dp(14).toFloat()
        }
        binding.workspace.librarySearchRecyclerView.apply {
            animate().cancel()
            alpha = 0f
            translationY = dp(10).toFloat()
        }
        binding.workspace.librarySearchIndex.alpha = 0f

        binding.workspace.librarySearchOverlay.animate()
            .alpha(1f)
            .setDuration(120L)
            .start()
        binding.workspace.librarySearchField.animate()
            .alpha(1f)
            .translationX(0f)
            .scaleX(1f)
            .setDuration(220L)
            .start()
        binding.workspace.cancelLibrarySearchButton.animate()
            .alpha(1f)
            .translationX(0f)
            .setStartDelay(45L)
            .setDuration(180L)
            .start()
        binding.workspace.librarySearchRecyclerView.animate()
            .alpha(1f)
            .translationY(0f)
            .setStartDelay(70L)
            .setDuration(190L)
            .start()
        binding.workspace.librarySearchIndex.animate()
            .alpha(1f)
            .setStartDelay(110L)
            .setDuration(160L)
            .start()

        binding.workspace.librarySearchEditText.requestFocus()
        showKeyboard(binding.workspace.librarySearchEditText)
    }

    private fun hideLibrarySearchOverlay() {
        if (binding.workspace.librarySearchOverlay.visibility != View.VISIBLE) return

        hideKeyboard(binding.workspace.librarySearchEditText)
        binding.workspace.librarySearchEditText.text?.clear()
        binding.workspace.librarySearchField.animate()
            .alpha(0f)
            .translationX(dp(LIBRARY_SEARCH_ENTER_X_DP).toFloat())
            .scaleX(1.03f)
            .setDuration(160L)
            .start()
        binding.workspace.cancelLibrarySearchButton.animate()
            .alpha(0f)
            .translationX(dp(12).toFloat())
            .setDuration(120L)
            .start()
        binding.workspace.librarySearchRecyclerView.animate()
            .alpha(0f)
            .translationY(dp(8).toFloat())
            .setDuration(130L)
            .start()
        binding.workspace.librarySearchIndex.animate()
            .alpha(0f)
            .setDuration(100L)
            .start()
        binding.workspace.librarySearchOverlay.animate()
            .alpha(0f)
            .setStartDelay(70L)
            .setDuration(130L)
            .withEndAction {
                binding.workspace.librarySearchOverlay.visibility = View.GONE
                binding.workspace.librarySearchOverlay.alpha = 1f
                binding.workspace.librarySearchField.apply {
                    alpha = 1f
                    translationX = 0f
                    scaleX = 1f
                }
                binding.workspace.cancelLibrarySearchButton.apply {
                    alpha = 1f
                    translationX = 0f
                }
                binding.workspace.librarySearchRecyclerView.apply {
                    alpha = 1f
                    translationY = 0f
                }
                binding.workspace.librarySearchIndex.alpha = 1f
                applyLauncherSystemUi()
            }
            .start()
    }

    private fun updateLibrarySearchResults(query: String) {
        if (!::librarySearchAdapter.isInitialized) return

        val locale = java.util.Locale.getDefault()
        val normalizedQuery = query.trim().lowercase(locale)
        val results = if (normalizedQuery.isEmpty()) {
            allLauncherApps
        } else {
            allLauncherApps.filter { item ->
                item.label.lowercase(locale).contains(normalizedQuery) ||
                    item.app.packageName.lowercase(locale).contains(normalizedQuery)
            }
        }
        librarySearchSectionPositions = librarySearchAdapter.submitApps(results)
        renderLibrarySearchIndex(librarySearchSectionPositions.keys.toList())
    }

    private fun renderLibrarySearchIndex(sectionLabels: List<String>) {
        binding.workspace.librarySearchIndex.removeAllViews()
        if (sectionLabels.isEmpty()) return

        val availableLabels = sectionLabels.toSet()
        val indexLabels = sectionLabels
            .filter { label -> label.firstOrNull()?.isDigit() == true }
            .sorted() + ('A'..'Z').map { letter -> letter.toString() } +
            sectionLabels.filter { label -> label == "#" }

        indexLabels.distinct().forEach { label ->
            val indexText = android.widget.TextView(this).apply {
                text = label
                setTextColor(Color.WHITE)
                alpha = if (label in availableLabels) 1f else 0.48f
                gravity = Gravity.CENTER
                includeFontPadding = false
                setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, 10f)
                layoutParams = android.widget.LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dp(14)
                )
                setOnClickListener {
                    if (label in availableLabels) {
                        librarySearchAdapter.positionForSection(label)?.let { position ->
                            binding.workspace.librarySearchRecyclerView.smoothScrollToPosition(position)
                        }
                    }
                }
            }
            binding.workspace.librarySearchIndex.addView(indexText)
        }
    }

    private fun showCategoryDetail(group: AppLibraryGroupUiModel) {
        if (group.apps.isEmpty()) return

        appOptionsPopup?.dismiss()
        hideKeyboard(binding.workspace.searchEditText)
        binding.workspace.categoryDetailTitle.text = group.title
        categoryDetailAdapter.submitApps(group.apps)
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        binding.workspace.pageIndicator.visibility = View.GONE

        binding.workspace.categoryDetailOverlay.apply {
            animate().cancel()
            alpha = 0f
            translationY = dp(18).toFloat()
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .translationY(0f)
                .setDuration(180L)
                .start()
        }
        applyLauncherSystemUi()
    }

    private fun hideCategoryDetail() {
        if (binding.workspace.categoryDetailOverlay.visibility != View.VISIBLE) return

        binding.workspace.categoryDetailOverlay.animate()
            .alpha(0f)
            .translationY(dp(18).toFloat())
            .setDuration(150L)
            .withEndAction {
                binding.workspace.categoryDetailOverlay.visibility = View.GONE
                binding.workspace.categoryDetailOverlay.translationY = 0f
                categoryDetailAdapter.submitApps(emptyList())
                applyLauncherSystemUi()
            }
            .start()
    }

    private fun showSelectedIconPreview(item: LauncherIconUiModel, anchor: View) {
        if (anchor === binding.workspace.root) return

        binding.workspace.selectedIconImage.setImageDrawable(item.icon)
        binding.workspace.selectedIconLabel.text = item.label

        val anchorLocation = IntArray(2)
        val rootLocation = IntArray(2)
        anchor.getLocationOnScreen(anchorLocation)
        binding.workspace.root.getLocationOnScreen(rootLocation)

        val previewWidth = if (binding.workspace.selectedIconPreview.width > 0) {
            binding.workspace.selectedIconPreview.width
        } else {
            dp(94)
        }
        val previewHeight = if (binding.workspace.selectedIconPreview.height > 0) {
            binding.workspace.selectedIconPreview.height
        } else {
            dp(118)
        }
        val rootWidth = binding.workspace.root.width.takeIf { it > 0 } ?: resources.displayMetrics.widthPixels
        val rootHeight = binding.workspace.root.height.takeIf { it > 0 } ?: resources.displayMetrics.heightPixels
        val left = (anchorLocation[0] - rootLocation[0] + anchor.width / 2 - previewWidth / 2)
            .coerceIn(dp(4), rootWidth - previewWidth - dp(4))
        val top = (anchorLocation[1] - rootLocation[1] - dp(2))
            .coerceIn(dp(12), rootHeight - previewHeight - dp(12))

        binding.workspace.selectedIconPreview.layoutParams =
            (binding.workspace.selectedIconPreview.layoutParams as android.widget.FrameLayout.LayoutParams).apply {
                leftMargin = left
                topMargin = top
            }
        binding.workspace.selectedIconPreview.apply {
            animate().cancel()
            alpha = 0f
            scaleX = 1.03f
            scaleY = 1.03f
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .scaleX(1.08f)
                .scaleY(1.08f)
                .setDuration(120L)
                .start()
        }
    }

    private fun hideSelectedIconPreview() {
        binding.workspace.selectedIconPreview.animate()
            .alpha(0f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(110L)
            .withEndAction {
                binding.workspace.selectedIconPreview.visibility = View.GONE
            }
            .start()
    }

    private fun applyHomeBlur() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            binding.workspace.homeContent.setRenderEffect(
                RenderEffect.createBlurEffect(18f, 18f, Shader.TileMode.CLAMP)
            )
        } else {
            binding.workspace.homeContent.alpha = 0.45f
        }
    }

    private fun clearHomeBlur() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            binding.workspace.homeContent.setRenderEffect(null)
        } else {
            binding.workspace.homeContent.alpha = 1f
        }
    }

    private fun showKeyboard(view: View) {
        view.postDelayed({
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }, 120L)
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        view.clearFocus()
    }

    private fun applyLauncherSystemUi() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.isStatusBarContrastEnforced = false
            window.isNavigationBarContrastEnforced = false
        }
        WindowInsetsControllerCompat(window, window.decorView).apply {
            hide(WindowInsetsCompat.Type.navigationBars())
            systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            isAppearanceLightStatusBars = false
            isAppearanceLightNavigationBars = false
        }
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }

    override fun showAppOptions(item: LauncherIconUiModel) {
        showAnchoredAppOptions(item, binding.workspace.root)
    }

    private fun showAnchoredAppOptions(item: LauncherIconUiModel, anchor: android.view.View) {
        appOptionsPopup?.dismiss()
        val optionBinding = PopupLauncherAppOptionsBinding.inflate(LayoutInflater.from(this))
        optionBinding.item = item
        val popup = PopupWindow(
            optionBinding.root,
            resources.getDimensionPixelSize(R.dimen.app_option_popup_width),
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        ).apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            isOutsideTouchable = true
            elevation = resources.getDimension(R.dimen.app_option_popup_elevation)
            setOnDismissListener {
                hideContextOverlay()
                if (appOptionsPopup === this) {
                    appOptionsPopup = null
                }
            }
        }

        optionBinding.appInfoButton.setOnClickListener {
            popup.dismiss()
            presenter.onAppInfoOptionClicked(item.app)
        }
        optionBinding.hideButton.setOnClickListener {
            popup.dismiss()
            presenter.onHideAppOptionClicked(item.app)
        }
        optionBinding.editHomeButton.setOnClickListener {
            popup.dismiss()
            setHomeEditing(true)
        }
        optionBinding.deleteButton.setOnClickListener {
            popup.dismiss()
            showRemoveAppDialog(item.app)
        }
        optionBinding.executePendingBindings()
        appOptionsPopup = popup

        optionBinding.root.measure(
            View.MeasureSpec.makeMeasureSpec(resources.displayMetrics.widthPixels, View.MeasureSpec.AT_MOST),
            View.MeasureSpec.makeMeasureSpec(resources.displayMetrics.heightPixels, View.MeasureSpec.AT_MOST)
        )

        showContextOverlay()
        showSelectedIconPreview(item, anchor)
        val anchorLocation = IntArray(2)
        val rootLocation = IntArray(2)
        anchor.getLocationOnScreen(anchorLocation)
        binding.workspace.root.getLocationOnScreen(rootLocation)

        val popupWidth = resources.getDimensionPixelSize(R.dimen.app_option_popup_width)
        val popupHeight = optionBinding.root.measuredHeight
        val screenWidth = resources.displayMetrics.widthPixels
        val screenHeight = resources.displayMetrics.heightPixels
        val margin = dp(16)
        val desiredX = anchorLocation[0]
        val desiredY = anchorLocation[1] + anchor.height + dp(8)
        val x = desiredX.coerceIn(margin, screenWidth - popupWidth - margin)
        val y = if (desiredY + popupHeight > screenHeight - margin) {
            (anchorLocation[1] - popupHeight - dp(8)).coerceAtLeast(margin)
        } else {
            desiredY
        }
        popup.showAtLocation(binding.workspace.root, Gravity.NO_GRAVITY, x, y)
    }

    private fun showContextOverlay() {
        binding.workspace.contextOverlay.apply {
            alpha = 0f
            visibility = View.VISIBLE
            animate().alpha(1f).setDuration(120L).start()
        }
        applyHomeBlur()
    }

    private fun hideContextOverlay() {
        hideSelectedIconPreview()
        binding.workspace.contextOverlay.animate()
            .alpha(0f)
            .setDuration(120L)
            .withEndAction {
                binding.workspace.contextOverlay.visibility = View.GONE
                if (binding.workspace.searchOverlay.visibility != View.VISIBLE) {
                    clearHomeBlur()
                }
            }
            .start()
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

    private companion object {
        const val DOCK_APP_COUNT = 4
        const val SEARCH_COLUMNS = 4
        const val SEARCH_ICON_CELL_HEIGHT_DP = 104
        const val SEARCH_SUGGESTION_COUNT = 8
        const val SEARCH_RESULT_LIMIT = 40
        const val RECENT_LIBRARY_APP_COUNT = 4
        const val PAGE_INDICATOR_VISIBLE_MS = 2500L
        const val PULL_DOWN_SEARCH_THRESHOLD_DP = 54
        const val PULL_DOWN_HORIZONTAL_ESCAPE_DP = 28
        const val LIBRARY_SEARCH_ENTER_X_DP = 34
        const val EMPTY_LONG_PRESS_MS = 520L
        const val EMPTY_LONG_PRESS_SLOP_DP = 10
        const val WIDGET_SHEET_DISMISS_DRAG_DP = 86
    }
}
