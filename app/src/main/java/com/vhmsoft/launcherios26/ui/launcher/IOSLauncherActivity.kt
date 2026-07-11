package com.vhmsoft.launcherios26.ui.launcher

import android.app.Dialog
import android.app.SearchManager
import android.app.WallpaperManager
import android.app.role.RoleManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ImageDecoder
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.graphics.Shader
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.ScrollView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.lifecycle.lifecycleScope
import com.vhmsoft.launcherios26.BlissLauncher
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.core.LauncherAppRenamePolicy
import com.vhmsoft.launcherios26.core.LauncherAppRenamePreferences
import com.vhmsoft.launcherios26.core.LauncherCustomIconStore
import com.vhmsoft.launcherios26.core.LauncherHomeLayoutPreferences
import com.vhmsoft.launcherios26.core.events.AppRenameEvent
import com.vhmsoft.launcherios26.core.events.AppWallpaperEvent
import com.vhmsoft.launcherios26.core.events.EventRelay
import com.vhmsoft.launcherios26.core.wallpaper.Ios26DefaultWallpaperInstaller
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.repository.LauncherRepository
import com.vhmsoft.launcherios26.databinding.ActivityIosLauncherBinding
import com.vhmsoft.launcherios26.databinding.DialogFeatureDownloadBinding
import com.vhmsoft.launcherios26.databinding.DialogRatingPromptBinding
import com.vhmsoft.launcherios26.databinding.ViewLauncherBlurSwitchRowBinding
import com.vhmsoft.launcherios26.databinding.ViewLauncherPlainSwitchRowBinding
import com.vhmsoft.launcherios26.databinding.ViewLauncherSettingRowBinding
import com.vhmsoft.launcherios26.di.RepositoryProvider
import com.vhmsoft.launcherios26.ui.applibrary.AppLibraryActivity
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherAnimationSettings
import com.vhmsoft.launcherios26.ui.launcher.controller.LauncherBlurSettings
import com.vhmsoft.launcherios26.ui.launcher.icon.IconCropView
import com.vhmsoft.launcherios26.ui.launcher.icon.IosLauncherIconTheme
import com.vhmsoft.launcherios26.ui.settings.feature.LauncherExternalFeature
import com.vhmsoft.launcherios26.ui.settings.feature.LauncherExternalFeatureCatalog
import com.vhmsoft.launcherios26.ui.settings.feature.LauncherExternalFeatureCode
import com.vhmsoft.launcherios26.weather.WeatherSettingsPolicy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class IOSLauncherActivity : AppCompatActivity(), IOSLauncherContract.View {
    private lateinit var binding: ActivityIosLauncherBinding
    private lateinit var presenter: IOSLauncherPresenter
    private lateinit var launcherRepository: LauncherRepository

    private val layoutPreferences by lazy {
        getSharedPreferences(LauncherHomeLayoutPreferences.LAYOUT_PREFERENCES_NAME, MODE_PRIVATE)
    }

    private var layoutDarkMode = false
    private var layoutIphone8Style = false
    private var layoutAutoArrange = false
    private var layoutLiquidGlass = false
    private var homeIconSizeDp = DEFAULT_HOME_ICON_SIZE_DP
    private var homeGridRows = DEFAULT_HOME_GRID_ROWS
    private var waitingForLauncherSelection = false
    private var renameAppPickerOverlay: View? = null
    private var renameAppPickerLoadToken: Any? = null
    private var changeIconPanel: View? = null
    private var changeIconPickerLoadToken: Any? = null
    private var iconCropPanel: View? = null
    private var pendingIconChangeApp: LauncherApp? = null
    private var wallpaperPickerPanel: View? = null
    private var wallpaperPreviewPanel: View? = null
    private var weatherSettingsPanel: View? = null
    private var hiddenAppsSettingsPanel: View? = null
    private var hiddenAppsSettingsLoadJob: Job? = null
    private var hiddenAppsSettingsChanged = false

    private val appLibraryLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        notifyLauncherDataChanged()
    }

    private val customIconImageLauncher = registerForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri ->
        val app = pendingIconChangeApp
        pendingIconChangeApp = null
        if (uri == null || app == null || !::launcherRepository.isInitialized) return@registerForActivityResult

        takePersistableReadPermission(uri)
        val bitmap = decodeBitmapFromUri(uri)
        if (bitmap == null) {
            showError(getString(R.string.settings_change_icon_choose_image))
            return@registerForActivityResult
        }
        showCustomIconCropPage(app, bitmap)
    }

    private val wallpaperImageLauncher = registerForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri ->
        if (uri == null) return@registerForActivityResult

        takePersistableReadPermission(uri)
        val bitmap = decodeBitmapFromUri(uri)
        if (bitmap == null) {
            showError(getString(R.string.settings_change_icon_image_failed))
            return@registerForActivityResult
        }
        showWallpaperPreviewPage(uri, bitmap)
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityIosLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launcherRepository = RepositoryProvider.provideLauncherRepository(applicationContext)
        presenter = IOSLauncherPresenter(launcherRepository)
        presenter.attachView(this)

        readLayoutPreferences()
        setupSettingsRows()
        setupLayoutSettingsPage()
        setupLiquidGlassSettingsPage()
        setupBlurEffectSettingsPage()
        setupAnimationSettingsPage()
        setupSettingsDrawer()
        installBackHandling()
        installSystemInsetHandling()
        applyLayoutAppearance()
        updateSettingsFabVisibility()
    }

    override fun onResume() {
        super.onResume()
        applyLauncherSystemUi()
        if (waitingForLauncherSelection && isCurrentDefaultLauncher()) {
            handleDefaultLauncherSelectionReturn(showNotSelectedToast = false)
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            applyLauncherSystemUi()
        }
    }

    override fun onDestroy() {
        hiddenAppsSettingsLoadJob?.cancel()
        presenter.detachView()
        super.onDestroy()
    }

    private fun readLayoutPreferences() {
        layoutDarkMode = layoutPreferences.getBoolean(KEY_LAYOUT_DARK_MODE, false)
        layoutIphone8Style = layoutPreferences.getBoolean(KEY_LAYOUT_IPHONE8_STYLE, false)
        layoutAutoArrange = layoutPreferences.getBoolean(KEY_LAYOUT_AUTO_ARRANGE, false)
        layoutLiquidGlass = layoutPreferences.getBoolean(KEY_LAYOUT_LIQUID_GLASS, false)
        homeIconSizeDp = readMigratedHomeIconSize()
        homeGridRows = layoutPreferences.getInt(KEY_HOME_GRID_ROWS, DEFAULT_HOME_GRID_ROWS)
            .takeIf { rows -> rows == HOME_GRID_ROWS_5 || rows == HOME_GRID_ROWS_6 }
            ?: DEFAULT_HOME_GRID_ROWS
        IosLauncherIconTheme.setDarkMode(layoutDarkMode)
    }

    override fun showLoading(isLoading: Boolean) = Unit

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setupSettingsRows() {
        binding.settingsSocialBar.bringToFront()
        binding.likeButton.setOnClickListener { presenter.onRateClicked() }
        binding.mailButton.setOnClickListener { presenter.onMailClicked() }
        binding.shareButton.setOnClickListener { presenter.onShareClicked() }
        binding.settingsMenuButton.setOnClickListener { presenter.onSettingsMenuClicked() }
        binding.settingsFab.setOnClickListener { presenter.onRateClicked() }

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
        bindSettingsRow(
            row = binding.weatherRow,
            titleRes = R.string.settings_weather,
            iconRes = R.drawable.ic_weather_24,
            iconColorRes = R.color.icon_weather,
            showDivider = true,
            onClick = { showWeatherSettingsPage() }
        )
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
            onClick = { showWallpaperPickerPage() }
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
            onClick = { showHiddenAppsSettingsPage() }
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
        applySettingsMenuLayout()
        applyIos17LauncherMenuScope()
    }

    private fun applyIos17LauncherMenuScope() {
        val visibility = if (LauncherShellModePolicy.shouldShowFullOptionsMenu()) View.VISIBLE else View.GONE
        binding.settingsTopCard.visibility = visibility
        binding.settingsBottomCard.visibility = visibility
        binding.settingsSocialBar.visibility = visibility
        binding.settingsMenuButton.visibility = visibility
        listOf(
            binding.weatherRow.root,
            binding.blurEffectRow.root,
            binding.motionWallpaperRow.root,
            binding.changeIconRow.root,
            binding.hiddenAppsRow.root
        ).forEach { row ->
            row.visibility = visibility
        }
        updateSettingsFabVisibility()
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

    private fun applySettingsMenuLayout() {
        binding.headerScene.layoutParams = binding.headerScene.layoutParams.apply {
            height = dp(LauncherSettingsMenuLayoutPolicy.HEADER_HEIGHT_DP)
        }
        val mainCardParams = binding.settingsMainCard.layoutParams as? LinearLayout.LayoutParams
        mainCardParams?.topMargin = dp(LauncherSettingsMenuLayoutPolicy.CARD_VERTICAL_GAP_DP)
        val bottomCardParams = binding.settingsBottomCard.layoutParams as? LinearLayout.LayoutParams
        bottomCardParams?.topMargin = dp(LauncherSettingsMenuLayoutPolicy.CARD_VERTICAL_GAP_DP)

        settingsRows().forEach(::applySettingsRowLayout)

        val fabParams = binding.settingsFab.layoutParams as? FrameLayout.LayoutParams
        if (fabParams != null) {
            fabParams.width = dp(LauncherSettingsMenuLayoutPolicy.FEATURED_STAR_SIZE_DP)
            fabParams.height = dp(LauncherSettingsMenuLayoutPolicy.FEATURED_STAR_SIZE_DP)
            fabParams.topMargin = dp(LauncherSettingsMenuLayoutPolicy.FEATURED_STAR_TOP_MARGIN_DP)
            fabParams.marginEnd = dp(LauncherSettingsMenuLayoutPolicy.FEATURED_STAR_END_MARGIN_DP)
            binding.settingsFab.layoutParams = fabParams
        }
        val starIcon = binding.settingsFab.getChildAt(0)
        starIcon?.layoutParams = starIcon?.layoutParams?.apply {
            width = dp(LauncherSettingsMenuLayoutPolicy.FEATURED_STAR_ICON_SIZE_DP)
            height = dp(LauncherSettingsMenuLayoutPolicy.FEATURED_STAR_ICON_SIZE_DP)
        }
    }

    private fun applySettingsRowLayout(row: ViewLauncherSettingRowBinding) {
        row.root.layoutParams = row.root.layoutParams?.apply {
            height = dp(LauncherSettingsMenuLayoutPolicy.ROW_HEIGHT_DP)
        }
        val content = row.root.getChildAt(0) as? LinearLayout
        content?.layoutParams = content?.layoutParams?.apply {
            height = dp(LauncherSettingsMenuLayoutPolicy.ROW_CONTENT_HEIGHT_DP)
        }
        content?.setPadding(
            dp(LauncherSettingsMenuLayoutPolicy.ROW_HORIZONTAL_PADDING_DP),
            0,
            dp(LauncherSettingsMenuLayoutPolicy.ROW_HORIZONTAL_PADDING_DP),
            0
        )
        row.iconContainer.layoutParams = row.iconContainer.layoutParams?.apply {
            width = dp(LauncherSettingsMenuLayoutPolicy.ICON_CONTAINER_SIZE_DP)
            height = dp(LauncherSettingsMenuLayoutPolicy.ICON_CONTAINER_SIZE_DP)
        }
        row.rowIcon.layoutParams = row.rowIcon.layoutParams?.apply {
            width = dp(LauncherSettingsMenuLayoutPolicy.ICON_SIZE_DP)
            height = dp(LauncherSettingsMenuLayoutPolicy.ICON_SIZE_DP)
        }
        (row.rowTitle.layoutParams as? LinearLayout.LayoutParams)?.let { params ->
            params.marginStart = dp(LauncherSettingsMenuLayoutPolicy.TITLE_START_MARGIN_DP)
            row.rowTitle.layoutParams = params
        }
        row.rowTitle.textSize = LauncherSettingsMenuLayoutPolicy.TITLE_TEXT_SIZE_SP
        row.rowTitle.typeface = if (LauncherSettingsMenuLayoutPolicy.TITLE_BOLD) {
            Typeface.DEFAULT_BOLD
        } else {
            Typeface.DEFAULT
        }
        val chevron = content?.getChildAt(2)
        chevron?.layoutParams = chevron?.layoutParams?.apply {
            width = dp(LauncherSettingsMenuLayoutPolicy.CHEVRON_SIZE_DP)
            height = dp(LauncherSettingsMenuLayoutPolicy.CHEVRON_SIZE_DP)
        }
        (row.rowDivider.layoutParams as? LinearLayout.LayoutParams)?.let { params ->
            params.marginStart = dp(LauncherSettingsMenuLayoutPolicy.DIVIDER_START_MARGIN_DP)
            row.rowDivider.layoutParams = params
        }
    }

    private fun setupLayoutSettingsPage() {
        binding.layoutBackButton.setOnClickListener { hideLayoutSettingsPage() }
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
        binding.iconSizeSeekBar.max = LauncherHomeIconSizePolicy.ICON_SIZE_SLIDER_MAX
        binding.iconSizeSeekBar.progress = LauncherHomeIconSizePolicy.iconSizeToSliderProgress(homeIconSizeDp)
        binding.iconSizeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    applyHomeIconSize(
                        LauncherHomeIconSizePolicy.sliderProgressToIconSize(progress),
                        persist = true
                    )
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit

            override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit
        })
        binding.grid5x4Option.setOnClickListener { applyHomeGridRows(HOME_GRID_ROWS_5, persist = true) }
        binding.grid6x4Option.setOnClickListener { applyHomeGridRows(HOME_GRID_ROWS_6, persist = true) }
        applyHomeLayoutSettingsUi()
        tintLayoutSwitches()
    }

    private fun setupLiquidGlassSettingsPage() {
        binding.liquidGlassBackButton.setOnClickListener { hideLiquidGlassSettingsPage() }
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
        binding.blurBackButton.setOnClickListener { hideBlurEffectSettingsPage() }
        applyBlurSettingsUi()
        applyBlurSettingsAppearance()
    }

    private fun setupAnimationSettingsPage() {
        binding.animationBackButton.setOnClickListener { hideAnimationSettingsPage() }
        applyAnimationSettingsUi()
        applyAnimationSettingsAppearance()
    }

    private fun setupSettingsDrawer() {
        binding.settingsDrawerDim.setOnClickListener { hideSettingsDrawer() }
        binding.settingsDrawerPanel.setOnClickListener {
            // Consume drawer panel taps so only the dimmed area closes it.
        }
        binding.drawerReloadRow.setOnClickListener {
            hideSettingsDrawer()
            notifyLauncherDataChanged()
            showError(getString(R.string.drawer_reload_done))
        }
        binding.drawerPrivacyRow.setOnClickListener { showDrawerComingSoon(R.string.drawer_privacy_policy) }
        binding.drawerGuideRow.setOnClickListener { showDrawerComingSoon(R.string.drawer_user_guide) }
        binding.drawerWebsiteRow.setOnClickListener { showDrawerComingSoon(R.string.drawer_website) }
        binding.drawerAboutRow.setOnClickListener { showDrawerComingSoon(R.string.drawer_about_us) }
    }

    private fun installBackHandling() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                when {
                    wallpaperPreviewPanel != null -> hideWallpaperPreviewPage()
                    wallpaperPickerPanel != null -> hideWallpaperPickerPage()
                    iconCropPanel != null -> hideCustomIconCropPage()
                    changeIconPanel != null -> hideChangeIconPage()
                    hiddenAppsSettingsPanel != null -> hideHiddenAppsSettingsPage()
                    renameAppPickerOverlay != null -> hideRenameAppPicker()
                    weatherSettingsPanel != null -> hideWeatherSettingsPage()
                    binding.layoutSettingsPanel.visibility == View.VISIBLE -> hideLayoutSettingsPage()
                    binding.liquidGlassSettingsPanel.visibility == View.VISIBLE -> hideLiquidGlassSettingsPage()
                    binding.blurSettingsPanel.visibility == View.VISIBLE -> hideBlurEffectSettingsPage()
                    binding.animationSettingsPanel.visibility == View.VISIBLE -> hideAnimationSettingsPage()
                    binding.settingsDrawerOverlay.visibility == View.VISIBLE -> hideSettingsDrawer()
                    else -> {
                        isEnabled = false
                        onBackPressedDispatcher.onBackPressed()
                    }
                }
            }
        })
    }

    private fun installSystemInsetHandling() {
        binding.root.fitsSystemWindows = true
        binding.settingsPanel.fitsSystemWindows = true
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
        updateSettingsFabVisibility()
    }

    private fun hideSettingsDrawer() {
        val overlay = binding.settingsDrawerOverlay
        if (overlay.visibility != View.VISIBLE) return

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
                updateSettingsFabVisibility()
            }
            .start()
    }

    private fun showDrawerComingSoon(titleRes: Int) {
        hideSettingsDrawer()
        showError(getString(R.string.app_option_coming_soon, getString(titleRes)))
    }

    override fun showExternalFeatureDownloadPrompt(featureCode: LauncherExternalFeatureCode) {
        showFeatureDownloadDialog(LauncherExternalFeatureCatalog.requireFeature(featureCode))
    }

    private fun showFeatureDownloadDialog(feature: LauncherExternalFeature) {
        val targetPackageName = getString(feature.packageNameRes)
        val dialog = Dialog(this)
        val dialogBinding = DialogFeatureDownloadBinding.inflate(layoutInflater)
        dialogBinding.downloadMessage.setText(feature.messageRes)
        dialogBinding.downloadPreview.setImageResource(feature.previewDrawableRes)
        dialogBinding.cancelButton.setOnClickListener { dialog.dismiss() }
        dialogBinding.okButton.setOnClickListener {
            dialog.dismiss()
            openExternalPackage(targetPackageName)
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

    override fun showRatingPrompt() {
        showRatingDialog()
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
            imageView.setOnClickListener { updateStars(index + 1) }
        }
        dialogBinding.ratingLaterButton.setOnClickListener { dialog.dismiss() }
        dialogBinding.ratingNoButton.setOnClickListener { dialog.dismiss() }
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

    override fun shareLauncherApp() {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_app_subject))
            putExtra(Intent.EXTRA_TEXT, launcherShareText())
        }
        startShareActivity(Intent.createChooser(shareIntent, getString(R.string.share_app_chooser_title)))
    }

    override fun shareLauncherAppByMail() {
        val mailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_app_subject))
            putExtra(Intent.EXTRA_TEXT, launcherShareText())
        }
        startShareActivity(Intent.createChooser(mailIntent, getString(R.string.share_mail_chooser_title)))
    }

    private fun launcherShareText(): String {
        return getString(R.string.share_app_text, packageName)
    }

    private fun startShareActivity(intent: Intent) {
        runCatching { startActivity(intent) }
            .onFailure { showError(getString(R.string.share_no_app_found)) }
    }

    override fun openAppLibrarySettings() {
        runCatching {
            appLibraryLauncher.launch(Intent(this, AppLibraryActivity::class.java))
        }.onFailure {
            showError(getString(R.string.launcher_open_app_failed, getString(R.string.settings_app_library)))
        }
    }

    override fun showLayoutSettingsPage() {
        showBoundSettingsPanel(binding.layoutSettingsPanel)
    }

    private fun showLiquidGlassSettingsPage() {
        showBoundSettingsPanel(binding.liquidGlassSettingsPanel)
    }

    private fun showBlurEffectSettingsPage() {
        applyBlurSettingsUi()
        showBoundSettingsPanel(binding.blurSettingsPanel)
    }

    private fun showAnimationSettingsPage() {
        applyAnimationSettingsUi()
        showBoundSettingsPanel(binding.animationSettingsPanel)
    }

    private fun showBoundSettingsPanel(panel: View) {
        panel.apply {
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
        applyLauncherSystemUi()
        updateSettingsFabVisibility()
    }

    private fun hideLayoutSettingsPage() {
        hideBoundSettingsPanel(binding.layoutSettingsPanel)
    }

    private fun hideLiquidGlassSettingsPage() {
        hideBoundSettingsPanel(binding.liquidGlassSettingsPanel)
    }

    private fun hideBlurEffectSettingsPage() {
        hideBoundSettingsPanel(binding.blurSettingsPanel)
    }

    private fun hideAnimationSettingsPage() {
        hideBoundSettingsPanel(binding.animationSettingsPanel)
    }

    private fun hideBoundSettingsPanel(panel: View) {
        if (panel.visibility != View.VISIBLE) return

        panel.animate()
            .alpha(0f)
            .translationX(dp(28).toFloat())
            .setDuration(150L)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction {
                panel.visibility = View.GONE
                panel.alpha = 1f
                panel.translationX = 0f
                applyLauncherSystemUi()
                updateSettingsFabVisibility()
            }
            .start()
    }

    override fun applyLayoutDarkMode(enabled: Boolean) {
        val changed = layoutDarkMode != enabled
        layoutDarkMode = enabled
        IosLauncherIconTheme.setDarkMode(enabled)
        if (changed) {
            layoutPreferences.edit()
                .putBoolean(KEY_LAYOUT_DARK_MODE, enabled)
                .apply()
            notifyLauncherDataChanged()
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
            notifyLauncherDataChanged()
        }
        binding.iphone8Switch.setOnCheckedChangeListener(null)
        binding.iphone8Switch.isChecked = enabled
        binding.iphone8Switch.setOnCheckedChangeListener { _, checked ->
            applyIphone8Style(checked, persist = true)
        }
        applyHomeLayoutSettingsUi()
    }

    private fun applyAutoArrange(enabled: Boolean, persist: Boolean) {
        val changed = layoutAutoArrange != enabled
        layoutAutoArrange = enabled
        if (persist && changed) {
            layoutPreferences.edit()
                .putBoolean(KEY_LAYOUT_AUTO_ARRANGE, enabled)
                .apply()
            notifyLauncherDataChanged()
        }
        binding.autoArrangeSwitch.setOnCheckedChangeListener(null)
        binding.autoArrangeSwitch.isChecked = enabled
        binding.autoArrangeSwitch.setOnCheckedChangeListener { _, checked ->
            applyAutoArrange(checked, persist = true)
        }
    }

    private fun applyLiquidGlass(enabled: Boolean, persist: Boolean) {
        val changed = layoutLiquidGlass != enabled
        layoutLiquidGlass = enabled
        if (persist && changed) {
            layoutPreferences.edit()
                .putBoolean(KEY_LAYOUT_LIQUID_GLASS, enabled)
                .apply()
            notifyLauncherDataChanged()
        }
        binding.liquidGlassSwitch.setOnCheckedChangeListener(null)
        binding.liquidGlassSwitch.isChecked = enabled
        binding.liquidGlassSwitch.setOnCheckedChangeListener { _, checked ->
            applyLiquidGlass(checked, persist = true)
        }
        applyLiquidGlassSettingsAppearance()
    }

    private fun currentBlurSettings(): LauncherBlurSettings {
        return LauncherBlurSettings(
            dockEnabled = layoutPreferences.getBoolean(KEY_BLUR_DOCK_ENABLED, true),
            folderEnabled = layoutPreferences.getBoolean(KEY_BLUR_FOLDER_ENABLED, true),
            widgetEnabled = layoutPreferences.getBoolean(KEY_BLUR_WIDGET_ENABLED, true),
            searchEnabled = layoutPreferences.getBoolean(KEY_BLUR_SEARCH_ENABLED, true)
        )
    }

    private fun applyBlurSettings(settings: LauncherBlurSettings, persist: Boolean) {
        if (persist) {
            layoutPreferences.edit()
                .putBoolean(KEY_BLUR_EFFECT_ENABLED, true)
                .putBoolean(KEY_BLUR_DOCK_ENABLED, settings.dockEnabled)
                .putBoolean(KEY_BLUR_FOLDER_ENABLED, settings.folderEnabled)
                .putBoolean(KEY_BLUR_WIDGET_ENABLED, settings.widgetEnabled)
                .putBoolean(KEY_BLUR_SEARCH_ENABLED, settings.searchEnabled)
                .apply()
            notifyLauncherDataChanged()
        }
        applyBlurSettingsUi()
    }

    private fun applyBlurSettingsUi() {
        val settings = currentBlurSettings()
        bindBlurSwitchRow(
            row = binding.blurMasterRow,
            titleRes = R.string.settings_blur_master,
            checked = settings.dockEnabled,
            enabled = true
        ) { checked ->
            applyBlurSettings(settings.copy(dockEnabled = checked), persist = true)
        }
        bindBlurSwitchRow(
            row = binding.blurFolderRow,
            titleRes = R.string.settings_blur_folder,
            checked = settings.folderEnabled,
            enabled = true
        ) { checked ->
            applyBlurSettings(currentBlurSettings().copy(folderEnabled = checked), persist = true)
        }
        bindBlurSwitchRow(
            row = binding.blurWidgetRow,
            titleRes = R.string.settings_blur_widget,
            checked = settings.widgetEnabled,
            enabled = true
        ) { checked ->
            applyBlurSettings(currentBlurSettings().copy(widgetEnabled = checked), persist = true)
        }
        bindBlurSwitchRow(
            row = binding.blurSearchRow,
            titleRes = R.string.settings_blur_search,
            checked = settings.searchEnabled,
            enabled = true
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
        row.rowSwitch.setOnCheckedChangeListener { _, isChecked -> onCheckedChanged(isChecked) }
        row.root.alpha = if (enabled) 1f else 0.45f
        row.root.isClickable = enabled
        row.root.isFocusable = enabled
        row.root.setOnClickListener(if (enabled) {
            View.OnClickListener { row.rowSwitch.isChecked = !row.rowSwitch.isChecked }
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
            notifyLauncherDataChanged()
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
        row.rowSwitch.setOnCheckedChangeListener { _, isChecked -> onCheckedChanged(isChecked) }
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

    private fun applyHomeIconSize(sizeDp: Int, persist: Boolean) {
        val boundedSize = sizeDp.coerceIn(MIN_HOME_ICON_SIZE_DP, MAX_HOME_ICON_SIZE_DP)
        homeIconSizeDp = boundedSize
        if (persist) {
            layoutPreferences.edit()
                .putInt(KEY_HOME_ICON_SIZE_DP, boundedSize)
                .putBoolean(KEY_HOME_ICON_SIZE_COMPACT_MIGRATION_APPLIED, true)
                .putBoolean(KEY_HOME_ICON_SIZE_DEFAULT_56_MIGRATION_APPLIED, true)
                .putBoolean(KEY_HOME_ICON_SIZE_DEFAULT_60_MIGRATION_APPLIED, true)
                .putBoolean(KEY_HOME_ICON_SIZE_DEFAULT_58_MIGRATION_APPLIED, true)
                .apply()
            notifyLauncherDataChanged()
        }
        applyHomeLayoutSettingsUi()
    }

    private fun readMigratedHomeIconSize(): Int {
        val rawIconSizeDp = layoutPreferences.getInt(KEY_HOME_ICON_SIZE_DP, DEFAULT_HOME_ICON_SIZE_DP)
        val migrationApplied = layoutPreferences.getBoolean(KEY_HOME_ICON_SIZE_COMPACT_MIGRATION_APPLIED, false)
        val default56MigrationApplied =
            layoutPreferences.getBoolean(KEY_HOME_ICON_SIZE_DEFAULT_56_MIGRATION_APPLIED, false)
        val default60MigrationApplied =
            layoutPreferences.getBoolean(KEY_HOME_ICON_SIZE_DEFAULT_60_MIGRATION_APPLIED, false)
        val default58MigrationApplied =
            layoutPreferences.getBoolean(KEY_HOME_ICON_SIZE_DEFAULT_58_MIGRATION_APPLIED, false)
        val migratedIconSizeDp = LauncherHomeIconSizePolicy.migrateStoredIconSizeDp(
            iconSizeDp = rawIconSizeDp,
            migrationApplied = migrationApplied,
            default56MigrationApplied = default56MigrationApplied,
            default60MigrationApplied = default60MigrationApplied,
            default58MigrationApplied = default58MigrationApplied
        )
        if (!migrationApplied ||
            !default56MigrationApplied ||
            !default60MigrationApplied ||
            !default58MigrationApplied
        ) {
            layoutPreferences.edit()
                .putInt(KEY_HOME_ICON_SIZE_DP, migratedIconSizeDp)
                .putBoolean(KEY_HOME_ICON_SIZE_COMPACT_MIGRATION_APPLIED, true)
                .putBoolean(KEY_HOME_ICON_SIZE_DEFAULT_56_MIGRATION_APPLIED, true)
                .putBoolean(KEY_HOME_ICON_SIZE_DEFAULT_60_MIGRATION_APPLIED, true)
                .putBoolean(KEY_HOME_ICON_SIZE_DEFAULT_58_MIGRATION_APPLIED, true)
                .apply()
        }
        return migratedIconSizeDp
    }

    private fun applyHomeGridRows(rows: Int, persist: Boolean) {
        val boundedRows = rows.takeIf { value -> value == HOME_GRID_ROWS_5 || value == HOME_GRID_ROWS_6 }
            ?: DEFAULT_HOME_GRID_ROWS
        homeGridRows = boundedRows
        if (persist) {
            layoutPreferences.edit()
                .putInt(KEY_HOME_GRID_ROWS, boundedRows)
                .apply()
            notifyLauncherDataChanged()
        }
        applyHomeLayoutSettingsUi()
    }

    private fun applyHomeLayoutSettingsUi() {
        val previewSize = dp(homeIconSizeDp)
        binding.iconSizePreview.layoutParams = binding.iconSizePreview.layoutParams.apply {
            width = previewSize
            height = previewSize
        }
        val iconSizeProgress = LauncherHomeIconSizePolicy.iconSizeToSliderProgress(homeIconSizeDp)
        if (binding.iconSizeSeekBar.progress != iconSizeProgress) {
            binding.iconSizeSeekBar.progress = iconSizeProgress
        }

        val gridIconColor = layoutGridPreviewColor()
        val gridLabelColor = themedColor(R.color.launcher_text_secondary, R.color.dark_settings_text_secondary)
        binding.grid5x4Icon.setPreview(LauncherLayoutGridPreviewPolicy.rows5x4, gridIconColor)
        binding.grid6x4Icon.setPreview(LauncherLayoutGridPreviewPolicy.rows6x4, gridIconColor)
        binding.grid5x4Label.setTextColor(gridLabelColor)
        binding.grid6x4Label.setTextColor(gridLabelColor)
    }

    private fun showWallpaperPickerPage() {
        hideWallpaperPickerPage()

        val overlay = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(LauncherRenamePickerUiPolicy.pageBackgroundColor)
            isClickable = true
            isFocusable = true
        }

        overlay.addView(createWallpaperPickerToolbar())
        overlay.addView(
            createWallpaperPickerGrid(),
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
        )

        binding.root.addView(
            overlay,
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        )
        wallpaperPickerPanel = overlay
        updateSettingsFabVisibility()
    }

    private fun createWallpaperPickerToolbar(): View {
        return createSettingsPageToolbar(
            title = getString(R.string.settings_wallpaper),
            onBack = { hideWallpaperPickerPage() }
        )
    }

    private fun createWallpaperPickerGrid(): View {
        val columns = LauncherWallpaperPickerUiPolicy.gridColumns
        val gap = dp(LauncherWallpaperPickerUiPolicy.gridGapDp)
        val sidePadding = dp(LauncherWallpaperPickerUiPolicy.gridHorizontalPaddingDp)
        val tileWidth = ((resources.displayMetrics.widthPixels - sidePadding * 2 - gap * (columns - 1)) / columns)
            .coerceAtLeast(dp(72))
        val tileHeight = (tileWidth * LauncherWallpaperPickerUiPolicy.tileAspectRatio).toInt()
        val grid = GridLayout(this).apply {
            columnCount = columns
            setPadding(sidePadding, dp(14), sidePadding, dp(24))
            setBackgroundColor(LauncherRenamePickerUiPolicy.pageBackgroundColor)
        }

        grid.addView(createWallpaperPlusTile(), wallpaperTileLayoutParams(0, tileWidth, tileHeight, gap))
        repeat(PRESET_WALLPAPER_COUNT) { index ->
            grid.addView(
                createPresetWallpaperTile(index, tileWidth, tileHeight),
                wallpaperTileLayoutParams(index + 1, tileWidth, tileHeight, gap)
            )
        }

        return ScrollView(this).apply {
            isFillViewport = true
            setBackgroundColor(LauncherRenamePickerUiPolicy.pageBackgroundColor)
            addView(grid, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        }
    }

    private fun wallpaperTileLayoutParams(index: Int, width: Int, height: Int, gap: Int): GridLayout.LayoutParams {
        val column = index % LauncherWallpaperPickerUiPolicy.gridColumns
        return GridLayout.LayoutParams().apply {
            this.width = width
            this.height = height
            setMargins(0, 0, if (column == LauncherWallpaperPickerUiPolicy.gridColumns - 1) 0 else gap, gap)
        }
    }

    private fun createWallpaperPlusTile(): View {
        return TextView(this).apply {
            text = "+"
            textSize = LauncherWallpaperPickerUiPolicy.plusTextSizeSp
            setTextColor(0xFFD1D1D6.toInt())
            gravity = Gravity.CENTER
            includeFontPadding = false
            setBackgroundColor(Color.WHITE)
            setOnClickListener { wallpaperImageLauncher.launch(arrayOf("image/*")) }
        }
    }

    private fun createPresetWallpaperTile(index: Int, width: Int, height: Int): View {
        val thumbnail = createPresetWallpaperBitmap(index, width, height)
        return ImageView(this).apply {
            scaleType = ImageView.ScaleType.CENTER_CROP
            setImageBitmap(thumbnail)
            setOnClickListener {
                val preview = createPresetWallpaperBitmap(
                    index,
                    resources.displayMetrics.widthPixels.coerceAtLeast(1),
                    resources.displayMetrics.heightPixels.coerceAtLeast(1)
                )
                val uri = saveWallpaperBitmapToInternalFile(preview)
                if (uri == null) {
                    showError(getString(R.string.settings_change_icon_image_failed))
                } else {
                    showWallpaperPreviewPage(uri, preview)
                }
            }
        }
    }

    private fun createPresetWallpaperBitmap(index: Int, width: Int, height: Int): Bitmap {
        val palettes = arrayOf(
            intArrayOf(0xFFE8FAFF.toInt(), 0xFF00B6DA.toInt(), 0xFF2E5DAA.toInt(), 0xFFA7F1E5.toInt()),
            intArrayOf(0xFFEFA1C0.toInt(), 0xFF3E189B.toInt(), 0xFF061033.toInt(), 0xFFF8E1DE.toInt()),
            intArrayOf(0xFF7B1B1D.toInt(), 0xFF061A24.toInt(), 0xFFB9F3FF.toInt(), 0xFF1C0E1B.toInt()),
            intArrayOf(0xFFFFC46A.toInt(), 0xFF003958.toInt(), 0xFFF9F3D0.toInt(), 0xFF67A95E.toInt()),
            intArrayOf(0xFF4E3200.toInt(), 0xFF02121B.toInt(), 0xFFFFFFCF.toInt(), 0xFF081E2A.toInt()),
            intArrayOf(0xFF58D8FF.toInt(), 0xFF001A73.toInt(), 0xFFFFFFFF.toInt(), 0xFF69B2FF.toInt()),
            intArrayOf(0xFF003825.toInt(), 0xFF011229.toInt(), 0xFF97FFF2.toInt(), 0xFF0F3D32.toInt()),
            intArrayOf(0xFF6A1C2B.toInt(), 0xFF150B39.toInt(), 0xFFFFBDE1.toInt(), 0xFF3C1834.toInt()),
            intArrayOf(0xFF473A2C.toInt(), 0xFF111111.toInt(), 0xFFB5A899.toInt(), 0xFF26201A.toInt()),
            intArrayOf(0xFFBB003E.toInt(), 0xFFFF5D00.toInt(), 0xFFFFC956.toInt(), 0xFF3B0028.toInt()),
            intArrayOf(0xFFE8E8E8.toInt(), 0xFF777777.toInt(), 0xFFFFFFFF.toInt(), 0xFFBDBDBD.toInt())
        )
        val colors = palettes[index % palettes.size]
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            shader = LinearGradient(0f, 0f, width.toFloat(), height.toFloat(), colors[0], colors[1], Shader.TileMode.CLAMP)
        }
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)

        paint.shader = null
        paint.color = colors[2]
        canvas.drawOval(RectF(width * 0.42f, -height * 0.12f, width * 1.28f, height * 0.7f), paint)

        paint.color = colors[3]
        val ribbon = Path().apply {
            moveTo(width * 0.0f, height * 0.58f)
            cubicTo(width * 0.28f, height * 0.42f, width * 0.43f, height * 0.78f, width * 0.66f, height * 0.54f)
            cubicTo(width * 0.82f, height * 0.38f, width * 0.95f, height * 0.45f, width.toFloat(), height * 0.40f)
            lineTo(width.toFloat(), height.toFloat())
            lineTo(0f, height.toFloat())
            close()
        }
        canvas.drawPath(ribbon, paint)

        paint.color = 0x55FFFFFF
        canvas.drawOval(RectF(-width * 0.18f, height * 0.03f, width * 0.55f, height * 0.4f), paint)
        return bitmap
    }

    private fun showWallpaperPreviewPage(uri: Uri, bitmap: Bitmap) {
        hideWallpaperPreviewPage()

        val overlay = FrameLayout(this).apply {
            setBackgroundColor(Color.BLACK)
            isClickable = true
            isFocusable = true
        }

        overlay.addView(
            ImageView(this).apply {
                setImageBitmap(bitmap)
                scaleType = ImageView.ScaleType.CENTER_CROP
            },
            FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        )

        overlay.addView(
            TextView(this).apply {
                text = getString(R.string.settings_wallpaper_preview)
                setTextColor(Color.WHITE)
                textSize = LauncherWallpaperPickerUiPolicy.previewTitleTextSizeSp
                typeface = Typeface.DEFAULT_BOLD
                gravity = Gravity.CENTER
                includeFontPadding = false
            },
            FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dp(42), Gravity.TOP or Gravity.CENTER_HORIZONTAL).apply {
                topMargin = dp(82)
            }
        )

        overlay.addView(
            TextView(this).apply {
                text = getString(android.R.string.ok)
                setTextColor(Color.BLACK)
                textSize = 18f
                gravity = Gravity.CENTER
                includeFontPadding = false
                background = roundedBackground(0xFF8E8E93.toInt(), LauncherWallpaperPickerUiPolicy.previewOkSizeDp / 2)
                setOnClickListener { commitCustomWallpaper(uri) }
            },
            FrameLayout.LayoutParams(
                dp(LauncherWallpaperPickerUiPolicy.previewOkSizeDp),
                dp(LauncherWallpaperPickerUiPolicy.previewOkSizeDp),
                Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
            ).apply {
                bottomMargin = dp(70)
            }
        )

        binding.root.addView(
            overlay,
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        )
        wallpaperPreviewPanel = overlay
        updateSettingsFabVisibility()
    }

    private fun commitCustomWallpaper(uri: Uri) {
        val rawUri = uri.toString()
        layoutPreferences.edit()
            .putString(KEY_CUSTOM_WALLPAPER_URI, rawUri)
            .apply()
        EventRelay.getInstance().push(AppWallpaperEvent(rawUri))
        notifyLauncherDataChanged()
        hideWallpaperPreviewPage()
        hideWallpaperPickerPage()
        showError(getString(R.string.settings_wallpaper_applied))
    }

    private fun saveWallpaperBitmapToInternalFile(bitmap: Bitmap): Uri? {
        return runCatching {
            val directory = File(filesDir, WALLPAPER_PRESET_DIRECTORY).apply { mkdirs() }
            val file = File(directory, WALLPAPER_PRESET_FILE_NAME)
            file.outputStream().use { output ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, output)
            }
            Uri.fromFile(file)
        }.getOrNull()
    }

    private fun hideWallpaperPreviewPage() {
        val panel = wallpaperPreviewPanel ?: return
        wallpaperPreviewPanel = null
        (panel.parent as? ViewGroup)?.removeView(panel)
        updateSettingsFabVisibility()
    }

    private fun hideWallpaperPickerPage() {
        hideWallpaperPreviewPage()
        val panel = wallpaperPickerPanel ?: return
        wallpaperPickerPanel = null
        (panel.parent as? ViewGroup)?.removeView(panel)
        updateSettingsFabVisibility()
    }

    private fun showRenameAppPicker() {
        if (!::launcherRepository.isInitialized) return

        val loadToken = Any()
        val list = createRenamePickerListContainer()
        showRenameAppPickerPage(createRenamePickerScroll(list), loadToken)

        lifecycleScope.launch {
            val apps = runCatching {
                withContext(Dispatchers.IO) {
                    launcherRepository.getAllInstalledApps()
                        .filterNot { app -> app.packageName == packageName }
                        .sortedBy { app -> app.label.lowercase() }
                }
            }.getOrElse { error ->
                if (isRenamePickerLoadActive(loadToken)) {
                    hideRenameAppPicker()
                    showError(error.message ?: getString(R.string.settings_no_apps_found))
                }
                return@launch
            }
            if (!isRenamePickerLoadActive(loadToken)) return@launch

            if (apps.isEmpty()) {
                hideRenameAppPicker()
                showError(getString(R.string.settings_no_apps_found))
                return@launch
            }

            populateRenamePickerList(list, apps)
            loadRenamePickerIcons(apps, loadToken)
        }
    }

    private fun showRenameAppPickerPage(content: View, loadToken: Any) {
        hideRenameAppPicker()
        renameAppPickerLoadToken = loadToken

        val overlay = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(LauncherRenamePickerUiPolicy.pageBackgroundColor)
            isClickable = true
            isFocusable = true
        }

        overlay.addView(createRenamePickerToolbar())
        overlay.addView(content, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f))

        binding.root.addView(
            overlay,
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        )
        renameAppPickerOverlay = overlay
        updateSettingsFabVisibility()
    }

    private fun createRenamePickerToolbar(): View {
        return createSettingsPageToolbar(
            title = getString(R.string.settings_rename),
            onBack = { hideRenameAppPicker() }
        )
    }

    private fun createRenamePickerListContainer(): LinearLayout {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(LauncherRenamePickerUiPolicy.toolbarColor)
        }
    }

    private fun createRenamePickerScroll(list: LinearLayout): View {
        return ScrollView(this).apply {
            isFillViewport = true
            addView(list, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        }
    }

    private fun populateRenamePickerList(list: LinearLayout, apps: List<LauncherApp>) {
        list.removeAllViews()
        apps.forEach { app ->
            list.addView(createRenamePickerRow(app = app, icon = null))
        }
    }

    private suspend fun loadRenamePickerIcons(apps: List<LauncherApp>, loadToken: Any) {
        apps.forEach { app ->
            if (!isRenamePickerLoadActive(loadToken)) return
            val icon = withContext(Dispatchers.IO) {
                runCatching { launcherRepository.getAppIcon(app) }.getOrNull()
            }
            icon?.let { loadedIcon -> updateRenamePickerIcon(app, loadedIcon, loadToken) }
        }
    }

    private fun createRenamePickerRow(app: LauncherApp, icon: Drawable?): View {
        val container = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(LauncherRenamePickerUiPolicy.toolbarColor)
        }
        val row = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(
                dp(LauncherRenamePickerUiPolicy.startPaddingDp),
                0,
                dp(LauncherRenamePickerUiPolicy.endPaddingDp),
                0
            )
            setOnClickListener { showRenameAppDialog(app) }
        }
        row.addView(
            ImageView(this).apply {
                tag = renamePickerIconTag(app.iconKey)
                icon?.let { setImageDrawable(it) }
                scaleType = ImageView.ScaleType.FIT_CENTER
                contentDescription = app.label
            },
            LinearLayout.LayoutParams(dp(LauncherRenamePickerUiPolicy.iconSizeDp), dp(LauncherRenamePickerUiPolicy.iconSizeDp))
        )
        row.addView(
            TextView(this).apply {
                tag = renamePickerLabelTag(app.iconKey)
                text = app.label
                setTextColor(LauncherRenamePickerUiPolicy.secondaryTextColor)
                textSize = LauncherRenamePickerUiPolicy.appTextSizeSp
                gravity = Gravity.CENTER_VERTICAL
                includeFontPadding = false
            },
            LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f).apply {
                marginStart = dp(LauncherRenamePickerUiPolicy.textMarginStartDp)
            }
        )
        container.addView(row, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(LauncherRenamePickerUiPolicy.rowHeightDp)))
        container.addView(
            View(this).apply { setBackgroundColor(LauncherRenamePickerUiPolicy.dividerColor) },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1).apply {
                marginStart = dp(
                    LauncherRenamePickerUiPolicy.startPaddingDp +
                        LauncherRenamePickerUiPolicy.iconSizeDp +
                        LauncherRenamePickerUiPolicy.textMarginStartDp +
                        LauncherRenamePickerUiPolicy.dividerMarginStartDp
                )
                marginEnd = dp(LauncherRenamePickerUiPolicy.dividerMarginEndDp)
            }
        )
        return container
    }

    private fun hideRenameAppPicker() {
        val overlay = renameAppPickerOverlay
        renameAppPickerOverlay = null
        renameAppPickerLoadToken = null
        (overlay?.parent as? ViewGroup)?.removeView(overlay)
        updateSettingsFabVisibility()
    }

    private fun updateRenamePickerLabel(app: LauncherApp, title: String) {
        renameAppPickerOverlay
            ?.findViewWithTag<TextView>(renamePickerLabelTag(app.iconKey))
            ?.text = title
    }

    private fun updateRenamePickerIcon(app: LauncherApp, icon: Drawable, loadToken: Any) {
        if (!isRenamePickerLoadActive(loadToken)) return
        renameAppPickerOverlay
            ?.findViewWithTag<ImageView>(renamePickerIconTag(app.iconKey))
            ?.setImageDrawable(icon)
    }

    private fun isRenamePickerLoadActive(loadToken: Any): Boolean {
        return renameAppPickerLoadToken === loadToken && renameAppPickerOverlay != null
    }

    private fun renamePickerLabelTag(iconKey: String): String = "rename_picker_label_$iconKey"

    private fun renamePickerIconTag(iconKey: String): String = "rename_picker_icon_$iconKey"

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
                val updatedTitle = LauncherAppRenamePolicy.submittedTitle(
                    input = input.text?.toString().orEmpty(),
                    currentTitle = app.label
                )
                LauncherAppRenamePreferences.save(
                    context = this,
                    appKeys = LauncherIos17MenuBridgePolicy.renameKeys(app),
                    title = updatedTitle
                )
                launcherRepository.saveCustomLabel(app, updatedTitle)
                dispatchIos17LauncherRename(app, updatedTitle)
                notifyLauncherDataChanged()
                updateRenamePickerLabel(app, updatedTitle)
                showError(getString(R.string.settings_rename_done, updatedTitle))
            }
            .setNeutralButton(R.string.dialog_reset) { _, _ ->
                LauncherAppRenamePreferences.save(
                    context = this,
                    appKeys = LauncherIos17MenuBridgePolicy.renameKeys(app),
                    title = ""
                )
                launcherRepository.saveCustomLabel(app, "")
                lifecycleScope.launch {
                    val restoredTitle = withContext(Dispatchers.IO) {
                        launcherRepository.getAllInstalledApps()
                            .firstOrNull { launcherApp -> launcherApp.iconKey == app.iconKey }
                            ?.label
                            ?: app.label
                    }
                    dispatchIos17LauncherRename(app, restoredTitle)
                    notifyLauncherDataChanged()
                    showRenameAppPicker()
                }
            }
            .setNegativeButton(R.string.dialog_cancel, null)
            .show()
    }

    private fun dispatchIos17LauncherRename(app: LauncherApp, updatedTitle: String) {
        EventRelay.getInstance().push(
            AppRenameEvent(
                appKeys = LauncherIos17MenuBridgePolicy.renameKeys(app),
                updatedTitle = updatedTitle
            )
        )
    }

    private fun showChangeIconAppPicker() {
        if (!::launcherRepository.isInitialized) return

        val loadToken = Any()
        val list = createChangeIconListContainer()
        showChangeIconPickerPage(createChangeIconScroll(list), loadToken)

        lifecycleScope.launch {
            val apps = runCatching {
                withContext(Dispatchers.IO) {
                    launcherRepository.getAllInstalledApps()
                        .filterNot { app -> app.packageName == packageName }
                        .sortedBy { app -> app.label.lowercase() }
                }
            }.getOrElse { error ->
                if (isChangeIconPickerLoadActive(loadToken)) {
                    hideChangeIconPage()
                    showError(error.message ?: getString(R.string.settings_no_apps_found))
                }
                return@launch
            }
            if (!isChangeIconPickerLoadActive(loadToken)) return@launch

            if (apps.isEmpty()) {
                hideChangeIconPage()
                showError(getString(R.string.settings_no_apps_found))
                return@launch
            }

            populateChangeIconPickerList(list, apps)
            loadChangeIconPickerIcons(apps, loadToken)
        }
    }

    private fun showChangeIconPickerPage(content: View, loadToken: Any) {
        hideChangeIconPage()
        changeIconPickerLoadToken = loadToken

        val overlay = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(LauncherRenamePickerUiPolicy.pageBackgroundColor)
            isClickable = true
            isFocusable = true
        }

        overlay.addView(createChangeIconToolbar())
        overlay.addView(content, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f))

        binding.root.addView(
            overlay,
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        )
        changeIconPanel = overlay
        updateSettingsFabVisibility()
    }

    private fun createChangeIconToolbar(): View {
        return createSettingsPageToolbar(
            title = getString(R.string.settings_change_icon),
            onBack = { hideChangeIconPage() }
        )
    }

    private fun createChangeIconListContainer(): LinearLayout {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(LauncherRenamePickerUiPolicy.toolbarColor)
        }
    }

    private fun createChangeIconScroll(list: LinearLayout): View {
        return ScrollView(this).apply {
            isFillViewport = true
            addView(list, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        }
    }

    private fun populateChangeIconPickerList(list: LinearLayout, apps: List<LauncherApp>) {
        list.removeAllViews()
        apps.forEach { app ->
            list.addView(createChangeIconRow(ChangeIconPickerItem(app = app, icon = null)))
        }
    }

    private suspend fun loadChangeIconPickerIcons(apps: List<LauncherApp>, loadToken: Any) {
        apps.forEach { app ->
            if (!isChangeIconPickerLoadActive(loadToken)) return
            val icon = withContext(Dispatchers.IO) {
                runCatching { launcherRepository.getAppIcon(app) }.getOrNull()
            }
            icon?.let { loadedIcon -> updateChangeIconPickerIcon(app, loadedIcon, loadToken) }
        }
    }

    private fun createChangeIconRow(item: ChangeIconPickerItem): View {
        val container = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(LauncherRenamePickerUiPolicy.toolbarColor)
        }
        val row = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(
                dp(LauncherRenamePickerUiPolicy.startPaddingDp),
                0,
                dp(LauncherRenamePickerUiPolicy.endPaddingDp),
                0
            )
        }
        row.addView(
            ImageView(this).apply {
                tag = changeIconPickerIconTag(item.app.iconKey)
                item.icon?.let { icon -> setImageDrawable(icon) }
                scaleType = ImageView.ScaleType.FIT_CENTER
                contentDescription = item.app.label
            },
            LinearLayout.LayoutParams(dp(LauncherRenamePickerUiPolicy.iconSizeDp), dp(LauncherRenamePickerUiPolicy.iconSizeDp))
        )
        row.addView(
            TextView(this).apply {
                text = item.app.label
                setTextColor(LauncherRenamePickerUiPolicy.secondaryTextColor)
                textSize = LauncherRenamePickerUiPolicy.appTextSizeSp
                gravity = Gravity.CENTER_VERTICAL
                includeFontPadding = false
            },
            LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f).apply {
                marginStart = dp(LauncherRenamePickerUiPolicy.textMarginStartDp)
            }
        )
        row.addView(
            createIconActionButton(
                iconRes = R.drawable.ic_refresh_32,
                contentDescription = getString(R.string.settings_change_icon_reset),
                onClick = { resetCustomIcon(item.app) }
            ),
            LinearLayout.LayoutParams(dp(58), dp(58))
        )
        row.addView(
            createIconActionButton(
                iconRes = R.drawable.ic_icon_change_24,
                contentDescription = getString(R.string.settings_change_icon),
                onClick = { showChangeIconChoiceDialog(item.app) }
            ),
            LinearLayout.LayoutParams(dp(58), dp(58)).apply {
                marginStart = dp(12)
            }
        )
        container.addView(row, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(LauncherRenamePickerUiPolicy.rowHeightDp)))
        container.addView(
            View(this).apply { setBackgroundColor(LauncherRenamePickerUiPolicy.dividerColor) },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1).apply {
                marginStart = dp(
                    LauncherRenamePickerUiPolicy.startPaddingDp +
                        LauncherRenamePickerUiPolicy.iconSizeDp +
                        LauncherRenamePickerUiPolicy.textMarginStartDp +
                        LauncherRenamePickerUiPolicy.dividerMarginStartDp
                )
                marginEnd = dp(LauncherRenamePickerUiPolicy.dividerMarginEndDp)
            }
        )
        return container
    }

    private fun createIconActionButton(
        iconRes: Int,
        contentDescription: String,
        onClick: () -> Unit
    ): ImageButton {
        return ImageButton(this).apply {
            setImageResource(iconRes)
            this.contentDescription = contentDescription
            background = ColorDrawable(Color.TRANSPARENT)
            setColorFilter(LauncherRenamePickerUiPolicy.secondaryTextColor)
            scaleType = ImageView.ScaleType.CENTER
            setPadding(dp(12), dp(12), dp(12), dp(12))
            setOnClickListener { onClick() }
        }
    }

    private fun hideChangeIconPage() {
        val overlay = changeIconPanel ?: return
        changeIconPickerLoadToken = null
        (overlay.parent as? ViewGroup)?.removeView(overlay)
        changeIconPanel = null
        updateSettingsFabVisibility()
    }

    private fun updateChangeIconPickerIcon(app: LauncherApp, icon: Drawable, loadToken: Any) {
        if (!isChangeIconPickerLoadActive(loadToken)) return
        changeIconPanel
            ?.findViewWithTag<ImageView>(changeIconPickerIconTag(app.iconKey))
            ?.setImageDrawable(icon)
    }

    private fun isChangeIconPickerLoadActive(loadToken: Any): Boolean {
        return changeIconPickerLoadToken === loadToken && changeIconPanel != null
    }

    private fun changeIconPickerIconTag(iconKey: String): String = "change_icon_picker_icon_$iconKey"

    override fun showChangeIconDialog(app: LauncherApp) {
        showChangeIconChoiceDialog(app)
    }

    private fun showChangeIconChoiceDialog(targetApp: LauncherApp) {
        if (!::launcherRepository.isInitialized) return

        lifecycleScope.launch {
            val items = runCatching {
                withContext(Dispatchers.IO) {
                    launcherRepository.getAllInstalledApps()
                        .filterNot { app -> app.packageName == packageName }
                        .sortedBy { app -> app.label.lowercase() }
                        .map { app ->
                            ChangeIconPickerItem(app = app, icon = launcherRepository.getAppIcon(app))
                        }
                }
            }.getOrElse { error ->
                showError(error.message ?: getString(R.string.settings_no_apps_found))
                return@launch
            }
            if (items.isEmpty()) {
                showError(getString(R.string.settings_no_apps_found))
                return@launch
            }
            showChangeIconChoiceDialog(targetApp, items)
        }
    }

    private fun showChangeIconChoiceDialog(targetApp: LauncherApp, items: List<ChangeIconPickerItem>) {
        val dialog = Dialog(this)
        val screenWidth = resources.displayMetrics.widthPixels
        val screenHeight = resources.displayMetrics.heightPixels
        val dialogWidth = screenWidth - dp(64)
        val cellSize = dialogWidth / 3

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            background = roundedBackground(Color.WHITE, 28)
            clipToOutline = false
        }
        val grid = GridLayout(this).apply {
            columnCount = 3
            rowCount = (items.size + 2) / 3
        }
        items.forEach { item ->
            val icon = item.icon ?: return@forEach
            grid.addView(
                ImageView(this).apply {
                    setImageDrawable(icon)
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    contentDescription = item.app.label
                    setOnClickListener {
                        LauncherCustomIconStore.saveDrawable(
                            context = this@IOSLauncherActivity,
                            appKeys = LauncherIos17MenuBridgePolicy.iconKeys(targetApp),
                            drawable = icon,
                            sizePx = dp(160)
                        )
                        dialog.dismiss()
                        onCustomIconChanged(targetApp)
                        showError(getString(R.string.settings_change_icon_done, targetApp.label))
                    }
                },
                GridLayout.LayoutParams().apply {
                    width = cellSize
                    height = cellSize
                }
            )
        }

        root.addView(
            ScrollView(this).apply {
                addView(grid, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
        )
        root.addView(
            LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                setPadding(dp(18), 0, dp(18), 0)
                addView(
                    TextView(context).apply {
                        text = getString(R.string.dialog_cancel)
                        setTextColor(0xFF00897B.toInt())
                        textSize = 18f
                        typeface = Typeface.DEFAULT_BOLD
                        gravity = Gravity.CENTER_VERTICAL
                        setOnClickListener { dialog.dismiss() }
                    },
                    LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
                )
                addView(
                    TextView(context).apply {
                        text = getString(R.string.settings_change_icon_my_photo)
                        setTextColor(0xFF00897B.toInt())
                        textSize = 18f
                        typeface = Typeface.DEFAULT_BOLD
                        gravity = Gravity.CENTER_VERTICAL or Gravity.END
                        setOnClickListener {
                            dialog.dismiss()
                            pendingIconChangeApp = targetApp
                            customIconImageLauncher.launch(arrayOf("image/*"))
                        }
                    },
                    LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
                )
            },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(76))
        )

        dialog.setContentView(root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setLayout(dialogWidth, (screenHeight * 0.78f).toInt())
    }

    private fun resetCustomIcon(app: LauncherApp) {
        LauncherCustomIconStore.reset(
            context = this,
            appKeys = LauncherIos17MenuBridgePolicy.iconKeys(app)
        )
        onCustomIconChanged(app)
        showError(getString(R.string.settings_change_icon_reset_done, app.label))
    }

    private fun onCustomIconChanged(app: LauncherApp) {
        notifyLauncherDataChanged()
        if (changeIconPanel != null && iconCropPanel == null) {
            showChangeIconAppPicker()
        }
    }

    private fun showCustomIconCropPage(app: LauncherApp, bitmap: Bitmap) {
        hideCustomIconCropPage()

        val cropView = IconCropView(this).apply {
            setBackgroundColor(Color.BLACK)
            setBitmap(bitmap)
        }
        val overlay = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.WHITE)
            isClickable = true
            isFocusable = true
        }

        overlay.addView(createCustomIconCropToolbar(app, cropView))
        overlay.addView(cropView, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f))

        binding.root.addView(
            overlay,
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        )
        iconCropPanel = overlay
        updateSettingsFabVisibility()
    }

    private fun createCustomIconCropToolbar(app: LauncherApp, cropView: IconCropView): View {
        return FrameLayout(this).apply {
            setBackgroundColor(Color.WHITE)
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dp(LauncherRenamePickerUiPolicy.toolbarHeightDp)
            )

            val row = FrameLayout(context).apply { setBackgroundColor(Color.WHITE) }
            addView(
                row,
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dp(LauncherRenamePickerUiPolicy.toolbarRowHeightDp),
                    Gravity.BOTTOM
                )
            )

            row.addView(
                TextView(context).apply {
                    text = "\u2039 ${getString(R.string.settings_change_icon)}"
                    setTextColor(LauncherRenamePickerUiPolicy.accentColor)
                    textSize = 20f
                    gravity = Gravity.CENTER_VERTICAL
                    includeFontPadding = false
                    setOnClickListener { hideCustomIconCropPage() }
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    Gravity.START or Gravity.CENTER_VERTICAL
                ).apply {
                    leftMargin = dp(12)
                }
            )

            row.addView(
                TextView(context).apply {
                    text = getString(R.string.settings_change_icon_crop_title)
                    setTextColor(Color.BLACK)
                    textSize = 22f
                    typeface = Typeface.DEFAULT_BOLD
                    gravity = Gravity.CENTER
                    includeFontPadding = false
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    Gravity.CENTER
                )
            )

            row.addView(
                TextView(context).apply {
                    text = getString(R.string.dialog_ok)
                    setTextColor(LauncherRenamePickerUiPolicy.accentColor)
                    textSize = 20f
                    typeface = Typeface.DEFAULT_BOLD
                    gravity = Gravity.CENTER_VERTICAL
                    includeFontPadding = false
                    setOnClickListener {
                        val cropped = cropView.croppedBitmap(dp(180))
                        if (cropped == null) {
                            showError(getString(R.string.settings_change_icon_image_failed))
                            return@setOnClickListener
                        }
                        LauncherCustomIconStore.saveBitmap(
                            context = this@IOSLauncherActivity,
                            appKeys = LauncherIos17MenuBridgePolicy.iconKeys(app),
                            bitmap = cropped
                        )
                        hideCustomIconCropPage()
                        onCustomIconChanged(app)
                        showError(getString(R.string.settings_change_icon_done, app.label))
                    }
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    Gravity.END or Gravity.CENTER_VERTICAL
                ).apply {
                    rightMargin = dp(16)
                }
            )
        }
    }

    private fun hideCustomIconCropPage() {
        val overlay = iconCropPanel ?: return
        (overlay.parent as? ViewGroup)?.removeView(overlay)
        iconCropPanel = null
        updateSettingsFabVisibility()
    }

    private fun decodeBitmapFromUri(uri: Uri): Bitmap? {
        return runCatching {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val source = ImageDecoder.createSource(contentResolver, uri)
                ImageDecoder.decodeBitmap(source) { decoder, _, _ ->
                    decoder.allocator = ImageDecoder.ALLOCATOR_SOFTWARE
                }
            } else {
                @Suppress("DEPRECATION")
                contentResolver.openInputStream(uri)?.use { input ->
                    BitmapFactory.decodeStream(input)
                }
            }
        }.getOrNull()
    }

    override fun showHideAppDialog(app: LauncherApp) {
        showHiddenAppsSettingsPage()
    }

    private fun showHiddenAppsSettingsPage() {
        if (!::launcherRepository.isInitialized) return
        hiddenAppsSettingsLoadJob?.cancel()
        hideHiddenAppsSettingsPage(reloadIfChanged = false)

        val backgroundColor = if (layoutDarkMode) Color.BLACK else 0xFFF2F2F7.toInt()
        val toolbarColor = if (layoutDarkMode) 0xFF1C1C1E.toInt() else Color.WHITE
        val rowColor = if (layoutDarkMode) 0xFF1C1C1E.toInt() else backgroundColor
        val primaryTextColor = if (layoutDarkMode) Color.WHITE else Color.BLACK
        val secondaryTextColor = if (layoutDarkMode) 0xFFEAEAEE.toInt() else 0xFF5E6675.toInt()
        val sectionTextColor = 0xFF8E8E93.toInt()
        val dividerColor = if (layoutDarkMode) 0xFF38383A.toInt() else 0xFFE5E5EA.toInt()

        val content = LinearLayout(this@IOSLauncherActivity).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(backgroundColor)
            if (LauncherHiddenAppsSettingsPolicy.showsPageBeforeLoadingApps) {
                addView(createHiddenAppsLoadingRow(secondaryTextColor))
            }
        }

        val panel = LinearLayout(this@IOSLauncherActivity).apply {
            orientation = LinearLayout.VERTICAL
            fitsSystemWindows = true
            setBackgroundColor(backgroundColor)
            elevation = dp(48).toFloat()
            isClickable = true
            isFocusable = true
        }

        panel.addView(
            createSettingsPageToolbar(
                title = getString(R.string.settings_hidden_apps),
                toolbarColor = toolbarColor,
                titleColor = primaryTextColor,
                onBack = { hideHiddenAppsSettingsPage() }
            )
        )
        panel.addView(
            View(this@IOSLauncherActivity).apply { setBackgroundColor(dividerColor) },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
        )
        panel.addView(
            ScrollView(this@IOSLauncherActivity).apply {
                overScrollMode = View.OVER_SCROLL_IF_CONTENT_SCROLLS
                setBackgroundColor(backgroundColor)
                addView(content, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
        )

        hiddenAppsSettingsPanel = panel
        binding.root.addView(
            panel,
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        )
        updateSettingsFabVisibility()

        hiddenAppsSettingsLoadJob = lifecycleScope.launch {
            val apps = runCatching {
                withContext(Dispatchers.IO) {
                    launcherRepository.getAllInstalledApps()
                        .filterNot { app -> app.packageName == packageName }
                }
            }.getOrElse { error ->
                if (hiddenAppsSettingsPanel === panel) {
                    content.removeAllViews()
                    showError(error.message ?: getString(R.string.settings_no_apps_found))
                }
                return@launch
            }

            if (hiddenAppsSettingsPanel !== panel) return@launch
            if (apps.isEmpty()) {
                content.removeAllViews()
                showError(getString(R.string.settings_no_apps_found))
                return@launch
            }

            var iconsByKey: Map<String, Drawable> = emptyMap()

            fun renderSections() {
                renderHiddenAppsSettingsSections(
                    content = content,
                    apps = apps,
                    iconsByKey = iconsByKey,
                    rowColor = rowColor,
                    primaryTextColor = primaryTextColor,
                    secondaryTextColor = secondaryTextColor,
                    sectionTextColor = sectionTextColor,
                    dividerColor = dividerColor,
                    onToggle = { appToToggle, hidden ->
                        launcherRepository.setAppHidden(appToToggle, hidden = !hidden)
                        hiddenAppsSettingsChanged = true
                        renderSections()
                    }
                )
            }

            renderSections()

            iconsByKey = withContext(Dispatchers.IO) {
                apps.mapNotNull { app ->
                    runCatching { launcherRepository.getAppIcon(app) }
                        .getOrNull()
                        ?.let { icon -> app.iconKey to icon }
                }.toMap()
            }

            if (hiddenAppsSettingsPanel === panel) {
                renderSections()
            }
        }
    }

    private fun renderHiddenAppsSettingsSections(
        content: LinearLayout,
        apps: List<LauncherApp>,
        iconsByKey: Map<String, Drawable>,
        rowColor: Int,
        primaryTextColor: Int,
        secondaryTextColor: Int,
        sectionTextColor: Int,
        dividerColor: Int,
        onToggle: (LauncherApp, Boolean) -> Unit
    ) {
        val sections = LauncherHiddenAppsSettingsPolicy.sections(
            apps = apps,
            hiddenIconKeys = launcherRepository.getHiddenIconKeys()
        )
        content.removeAllViews()
        content.addView(createHiddenAppsSectionHeader(getString(R.string.hidden_apps_section_hidden), sectionTextColor))
        val hiddenContainer = createHiddenAppsRowsContainer(rowColor)
        sections.hidden.forEach { app ->
            hiddenContainer.addView(
                createHiddenAppsSettingsRow(
                    app = app,
                    icon = iconsByKey[app.iconKey],
                    hidden = true,
                    rowColor = rowColor,
                    textColor = primaryTextColor,
                    dividerColor = dividerColor,
                    onToggle = onToggle
                )
            )
        }
        content.addView(hiddenContainer)

        content.addView(createHiddenAppsSectionHeader(getString(R.string.hidden_apps_section_apps), sectionTextColor))
        val visibleContainer = createHiddenAppsRowsContainer(rowColor)
        sections.visible.forEach { app ->
            visibleContainer.addView(
                createHiddenAppsSettingsRow(
                    app = app,
                    icon = iconsByKey[app.iconKey],
                    hidden = false,
                    rowColor = rowColor,
                    textColor = secondaryTextColor,
                    dividerColor = dividerColor,
                    onToggle = onToggle
                )
            )
        }
        content.addView(visibleContainer)
    }

    private fun createHiddenAppsLoadingRow(textColor: Int): View {
        return TextView(this).apply {
            text = getString(R.string.settings_hidden_apps_loading)
            setTextColor(textColor)
            textSize = 17f
            gravity = Gravity.CENTER
            includeFontPadding = false
            layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(96))
        }
    }

    private fun createHiddenAppsRowsContainer(rowColor: Int): LinearLayout {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(rowColor)
        }
    }

    private fun createHiddenAppsSectionHeader(title: String, textColor: Int): View {
        return TextView(this).apply {
            text = title
            setTextColor(textColor)
            textSize = 15f
            gravity = Gravity.BOTTOM or Gravity.START
            includeFontPadding = false
            setPadding(dp(24), 0, dp(24), dp(8))
            layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(50))
        }
    }

    private fun createHiddenAppsSettingsRow(
        app: LauncherApp,
        icon: Drawable?,
        hidden: Boolean,
        rowColor: Int,
        textColor: Int,
        dividerColor: Int,
        onToggle: (LauncherApp, Boolean) -> Unit
    ): View {
        val row = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(rowColor)
        }
        val appRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(24), 0, dp(24), 0)
        }

        appRow.addView(
            createHiddenAppsToggleButton(hidden).apply {
                setOnClickListener {
                    row.animate()
                        .translationY(if (hidden) dp(24).toFloat() else -dp(24).toFloat())
                        .alpha(0f)
                        .setDuration(130L)
                        .withEndAction { onToggle(app, hidden) }
                        .start()
                }
            },
            LinearLayout.LayoutParams(dp(32), dp(32))
        )

        appRow.addView(
            ImageView(this).apply {
                icon?.let { setImageDrawable(it) }
                scaleType = ImageView.ScaleType.FIT_CENTER
            },
            LinearLayout.LayoutParams(dp(44), dp(44)).apply {
                leftMargin = dp(18)
            }
        )

        appRow.addView(
            TextView(this).apply {
                text = app.label
                setTextColor(textColor)
                textSize = 18f
                maxLines = 1
                ellipsize = TextUtils.TruncateAt.END
                gravity = Gravity.CENTER_VERTICAL
                includeFontPadding = false
            },
            LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f).apply {
                leftMargin = dp(18)
            }
        )

        row.addView(appRow, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(64)))
        row.addView(
            View(this).apply { setBackgroundColor(dividerColor) },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1).apply {
                leftMargin = dp(110)
            }
        )
        return row
    }

    private fun createHiddenAppsToggleButton(hidden: Boolean): TextView {
        return TextView(this).apply {
            text = if (hidden) "\u2212" else "+"
            setTextColor(Color.WHITE)
            textSize = 30f
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
            includeFontPadding = false
            background = roundedBackground(
                color = if (hidden) 0xFFFF453A.toInt() else 0xFF34C759.toInt(),
                radiusDp = 16
            )
            isClickable = true
            isFocusable = true
        }
    }

    private fun hideHiddenAppsSettingsPage(reloadIfChanged: Boolean = true) {
        hiddenAppsSettingsLoadJob?.cancel()
        hiddenAppsSettingsLoadJob = null
        val panel = hiddenAppsSettingsPanel ?: return
        hiddenAppsSettingsPanel = null
        (panel.parent as? ViewGroup)?.removeView(panel)
        if (reloadIfChanged && hiddenAppsSettingsChanged) {
            hiddenAppsSettingsChanged = false
            notifyLauncherDataChanged()
            showError(getString(R.string.settings_hidden_apps_done))
        }
        updateSettingsFabVisibility()
    }

    private fun showWeatherSettingsPage() {
        hideWeatherSettingsPage()
        val backgroundColor = if (layoutDarkMode) Color.BLACK else 0xFFEDEDEF.toInt()
        val toolbarColor = if (layoutDarkMode) 0xFF1C1C1E.toInt() else Color.WHITE
        val titleColor = if (layoutDarkMode) Color.WHITE else Color.BLACK
        val dividerColor = if (layoutDarkMode) 0xFF38383A.toInt() else 0xFFC7C7CC.toInt()
        val rowColor = if (layoutDarkMode) 0xFF1C1C1E.toInt() else 0xFFEDEDEF.toInt()

        val panel = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            fitsSystemWindows = true
            setBackgroundColor(backgroundColor)
            elevation = dp(48).toFloat()
            isClickable = true
            isFocusable = true
        }
        panel.addView(
            createSettingsPageToolbar(
                title = getString(R.string.settings_weather),
                toolbarColor = toolbarColor,
                titleColor = titleColor,
                onBack = { hideWeatherSettingsPage() }
            )
        )
        panel.addView(
            View(this).apply { setBackgroundColor(dividerColor) },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
        )
        panel.addView(
            createWeatherSettingsOptionRow(
                title = getString(R.string.weather_settings_unit),
                subtitle = weatherTemperatureUnitLabel(selectedWeatherTemperatureUnit()),
                rowColor = rowColor,
                onClick = { showWeatherUnitDialog() }
            )
        )
        panel.addView(
            createWeatherSettingsOptionRow(
                title = getString(R.string.weather_settings_auto_refresh),
                subtitle = weatherRefreshIntervalLabel(selectedWeatherRefreshInterval()),
                rowColor = rowColor,
                onClick = { showWeatherRefreshIntervalDialog() }
            )
        )

        weatherSettingsPanel = panel
        binding.root.addView(
            panel,
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        )
        updateSettingsFabVisibility()
    }

    private fun hideWeatherSettingsPage() {
        val panel = weatherSettingsPanel ?: return
        (panel.parent as? ViewGroup)?.removeView(panel)
        weatherSettingsPanel = null
        updateSettingsFabVisibility()
    }

    private fun createWeatherSettingsOptionRow(
        title: String,
        subtitle: String,
        rowColor: Int,
        onClick: () -> Unit
    ): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setBackgroundColor(rowColor)
            setPadding(dp(20), 0, dp(18), 0)
            isClickable = true
            isFocusable = true
            foreground = obtainStyledForeground()
            setOnClickListener { onClick() }
            addView(
                FrameLayout(context).apply {
                    background = roundedBackground(getColor(R.color.icon_weather), 7)
                    addView(
                        ImageView(context).apply {
                            setImageResource(R.drawable.ic_weather_24)
                            imageTintList = ColorStateList.valueOf(Color.WHITE)
                        },
                        FrameLayout.LayoutParams(dp(22), dp(22), Gravity.CENTER)
                    )
                },
                LinearLayout.LayoutParams(dp(34), dp(34)).apply {
                    marginEnd = dp(24)
                }
            )
            addView(
                LinearLayout(context).apply {
                    orientation = LinearLayout.VERTICAL
                    gravity = Gravity.CENTER_VERTICAL
                    addView(
                        TextView(context).apply {
                            text = title
                            setTextColor(if (layoutDarkMode) Color.WHITE else 0xFF1C1C1E.toInt())
                            textSize = 18f
                            includeFontPadding = false
                        }
                    )
                    addView(
                        TextView(context).apply {
                            text = subtitle
                            setTextColor(if (layoutDarkMode) 0xFFAEAEB2.toInt() else 0xFF6D6D72.toInt())
                            textSize = 15f
                            includeFontPadding = false
                        }
                    )
                },
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
            )
        }.also { row ->
            row.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(80))
        }
    }

    private fun selectedWeatherTemperatureUnit(): WeatherSettingsPolicy.TemperatureUnit {
        return WeatherSettingsPolicy.temperatureUnit(
            layoutPreferences.getBoolean(KEY_WEATHER_USE_METRIC, true)
        )
    }

    private fun selectedWeatherRefreshInterval(): WeatherSettingsPolicy.RefreshInterval {
        return WeatherSettingsPolicy.refreshInterval(
            layoutPreferences.getString(
                KEY_WEATHER_REFRESH_INTERVAL,
                WeatherSettingsPolicy.RefreshInterval.HOURLY.preferenceValue
            )
        )
    }

    private fun weatherTemperatureUnitLabel(unit: WeatherSettingsPolicy.TemperatureUnit): String {
        return when (unit) {
            WeatherSettingsPolicy.TemperatureUnit.CELSIUS -> getString(R.string.weather_settings_unit_celsius)
            WeatherSettingsPolicy.TemperatureUnit.FAHRENHEIT -> getString(R.string.weather_settings_unit_fahrenheit)
        }
    }

    private fun weatherRefreshIntervalLabel(interval: WeatherSettingsPolicy.RefreshInterval): String {
        return when (interval) {
            WeatherSettingsPolicy.RefreshInterval.HOURLY -> getString(R.string.weather_settings_auto_refresh_hourly)
            WeatherSettingsPolicy.RefreshInterval.EVERY_3_HOURS -> getString(R.string.weather_settings_auto_refresh_3_hours)
            WeatherSettingsPolicy.RefreshInterval.EVERY_6_HOURS -> getString(R.string.weather_settings_auto_refresh_6_hours)
            WeatherSettingsPolicy.RefreshInterval.EVERY_9_HOURS -> getString(R.string.weather_settings_auto_refresh_9_hours)
            WeatherSettingsPolicy.RefreshInterval.EVERY_12_HOURS -> getString(R.string.weather_settings_auto_refresh_12_hours)
        }
    }

    private fun showWeatherUnitDialog() {
        val options = listOf(
            WeatherSettingsPolicy.TemperatureUnit.CELSIUS,
            WeatherSettingsPolicy.TemperatureUnit.FAHRENHEIT
        )
        showWeatherChoiceDialog(
            title = getString(R.string.weather_settings_unit),
            options = options,
            selected = selectedWeatherTemperatureUnit(),
            labelFor = { weatherTemperatureUnitLabel(it) },
            onSelected = { selectedUnit ->
                layoutPreferences.edit()
                    .putBoolean(KEY_WEATHER_USE_METRIC, selectedUnit.useMetric)
                    .apply()
                notifyLauncherDataChanged()
                showWeatherSettingsPage()
            }
        )
    }

    private fun showWeatherRefreshIntervalDialog() {
        val options = listOf(
            WeatherSettingsPolicy.RefreshInterval.HOURLY,
            WeatherSettingsPolicy.RefreshInterval.EVERY_3_HOURS,
            WeatherSettingsPolicy.RefreshInterval.EVERY_6_HOURS,
            WeatherSettingsPolicy.RefreshInterval.EVERY_9_HOURS,
            WeatherSettingsPolicy.RefreshInterval.EVERY_12_HOURS
        )
        showWeatherChoiceDialog(
            title = getString(R.string.weather_settings_auto_refresh),
            options = options,
            selected = selectedWeatherRefreshInterval(),
            labelFor = { weatherRefreshIntervalLabel(it) },
            onSelected = { selectedInterval ->
                layoutPreferences.edit()
                    .putString(KEY_WEATHER_REFRESH_INTERVAL, selectedInterval.preferenceValue)
                    .apply()
                notifyLauncherDataChanged()
                showWeatherSettingsPage()
            }
        )
    }

    private fun <T> showWeatherChoiceDialog(
        title: String,
        options: List<T>,
        selected: T,
        labelFor: (T) -> String,
        onSelected: (T) -> Unit
    ) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE)

        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            background = roundedBackground(Color.WHITE, 22)
            setPadding(dp(28), dp(26), dp(28), dp(18))
        }
        card.addView(
            TextView(this).apply {
                text = title
                setTextColor(Color.BLACK)
                textSize = 24f
                typeface = Typeface.DEFAULT_BOLD
                includeFontPadding = false
            },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                bottomMargin = dp(18)
            }
        )

        options.forEach { option ->
            card.addView(
                createWeatherChoiceRow(
                    label = labelFor(option),
                    checked = option == selected
                ) {
                    dialog.dismiss()
                    onSelected(option)
                }
            )
        }

        card.addView(
            TextView(this).apply {
                text = getString(R.string.dialog_cancel)
                setTextColor(0xFF009688.toInt())
                textSize = 16f
                typeface = Typeface.DEFAULT_BOLD
                gravity = Gravity.CENTER
                isClickable = true
                isFocusable = true
                foreground = obtainStyledForeground()
                setOnClickListener { dialog.dismiss() }
            },
            LinearLayout.LayoutParams(dp(88), dp(52)).apply {
                gravity = Gravity.END
                topMargin = dp(16)
            }
        )

        dialog.setContentView(card)
        dialog.show()
        dialog.window?.let { window ->
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window.setDimAmount(0.62f)
            window.setLayout((resources.displayMetrics.widthPixels * 0.86f).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }

    private fun createWeatherChoiceRow(
        label: String,
        checked: Boolean,
        onClick: () -> Unit
    ): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            isClickable = true
            isFocusable = true
            foreground = obtainStyledForeground()
            setOnClickListener { onClick() }
            addView(
                RadioButton(context).apply {
                    isChecked = checked
                    isClickable = false
                    isFocusable = false
                },
                LinearLayout.LayoutParams(dp(54), dp(54)).apply {
                    marginEnd = dp(26)
                }
            )
            addView(
                TextView(context).apply {
                    text = label
                    setTextColor(0xFF2C2C2E.toInt())
                    textSize = 21f
                    includeFontPadding = false
                    gravity = Gravity.CENTER_VERTICAL
                },
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
            )
        }.also { row ->
            row.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(64))
        }
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
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
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
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
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
        content.addView(buttonRow, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(56)))

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
            Ios26DefaultWallpaperInstaller.applyWhenDefaultLauncherSelected(this)
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
        val shouldRequestHomeRoleFirst = LauncherDefaultSelectionPolicy.shouldRequestHomeRoleBeforeSettings(
            sdkInt = Build.VERSION.SDK_INT
        )
        if (
            shouldRequestHomeRoleFirst &&
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q &&
            requestHomeRole()
        ) {
            return
        }
        if (openHomeSettings()) {
            return
        }
        if (
            !shouldRequestHomeRoleFirst &&
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q &&
            requestHomeRole()
        ) {
            return
        }

        waitingForLauncherSelection = false
        showError(getString(R.string.launcher_default_prompt_failed))
    }

    override fun openCopiedIos17Launcher() {
        prepareCopiedIos17LauncherIcons()
        val intent = Intent(Intent.ACTION_MAIN).apply {
            component = ComponentName(
                packageName,
                "com.vhmsoft.launcherios26.features.launcher.LauncherActivity"
            )
            addCategory(Intent.CATEGORY_HOME)
            addCategory(Intent.CATEGORY_DEFAULT)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
        }
        runCatching { startActivity(intent) }.onFailure {
            showError(getString(R.string.launcher_default_prompt_failed))
        }
    }

    private fun prepareCopiedIos17LauncherIcons() {
        notifyLauncherDataChanged()
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
            Ios26DefaultWallpaperInstaller.applyWhenDefaultLauncherSelected(this)
            openCopiedIos17Launcher()
        } else if (showNotSelectedToast) {
            Toast.makeText(this, R.string.launcher_default_not_selected, Toast.LENGTH_SHORT).show()
        }
    }

    override fun showAlreadyDefaultLauncher() {
        Toast.makeText(this, R.string.launcher_default_already, Toast.LENGTH_SHORT).show()
    }

    override fun openApp(app: LauncherApp) {
        if (app.packageName == packageName) {
            return
        }

        val launchIntent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
            component = ComponentName(app.packageName, app.className)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
        }
        runCatching {
            startActivity(launchIntent)
        }.onFailure {
            showError(getString(R.string.launcher_open_app_failed, app.label))
        }
    }

    override fun openAppInfo(app: LauncherApp) {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = Uri.fromParts("package", app.packageName, null)
        }
        runCatching { startActivity(intent) }
            .onFailure { showError(getString(R.string.launcher_open_app_failed, app.label)) }
    }

    private fun openNotificationAccessSettings() {
        runCatching {
            startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
        }.onFailure {
            showError(getString(R.string.settings_notification_access_failed))
        }
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

    private fun takePersistableReadPermission(uri: Uri) {
        runCatching {
            contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
    }

    private fun notifyLauncherDataChanged() {
        if (::presenter.isInitialized) {
            presenter.clearIconCache()
        }
        runCatching {
            BlissLauncher.getApplication(applicationContext).appProvider.reload(true)
        }
    }

    private fun applyLayoutAppearance() {
        IosLauncherIconTheme.setDarkMode(layoutDarkMode)
        applySettingsAppearance()
        applyLayoutSettingsAppearance()
        applyLiquidGlassSettingsAppearance()
        applyBlurSettingsAppearance()
        applyAnimationSettingsAppearance()
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
        applyLauncherSystemUi()
    }

    private fun applySettingsAppearance() {
        val backgroundColor = themedColor(R.color.settings_background, R.color.dark_settings_background)
        val cardColor = themedColor(R.color.settings_card, R.color.dark_settings_card)
        val primaryTextColor = themedColor(R.color.launcher_text_primary, R.color.dark_settings_text_primary)
        val dividerColor = themedColor(R.color.settings_divider, R.color.dark_settings_divider)

        binding.settingsPanel.setBackgroundColor(backgroundColor)
        binding.launcher.setBackgroundColor(backgroundColor)
        listOf(binding.settingsTopCard, binding.settingsMainCard, binding.settingsBottomCard).forEach { card ->
            card.background = roundedBackground(cardColor, LauncherSettingsMenuLayoutPolicy.CARD_RADIUS_DP)
        }

        settingsRows().forEach { row ->
            row.rowTitle.setTextColor(primaryTextColor)
            row.rowDivider.setBackgroundColor(dividerColor)
        }
        applySettingsMenuLayout()
        binding.settingsDrawerPanel.setBackgroundColor(backgroundColor)
    }

    private fun applyLayoutSettingsAppearance() {
        val backgroundColor = themedColor(R.color.settings_background, R.color.dark_settings_background)
        val cardColor = themedColor(R.color.settings_card, R.color.dark_settings_card)
        val primaryTextColor = themedColor(R.color.launcher_text_primary, R.color.dark_settings_text_primary)
        val secondaryTextColor = themedColor(R.color.launcher_text_secondary, R.color.dark_settings_text_secondary)
        val dividerColor = themedColor(R.color.settings_divider, R.color.dark_settings_divider)

        binding.layoutSettingsPanel.setBackgroundColor(backgroundColor)
        applySettingsPageHeader(
            toolbar = binding.layoutSettingsToolbar,
            backButton = binding.layoutBackButton,
            titleView = binding.layoutTitle,
            toolbarColor = cardColor,
            titleColor = primaryTextColor
        )
        binding.layoutSettingsScroll.setBackgroundColor(backgroundColor)
        binding.layoutTopSpacer.setBackgroundColor(backgroundColor)
        setFixedHeight(binding.layoutTopSpacer, LauncherSettingsPageHeaderPolicy.contentTopSpacerDp)
        binding.layoutOptionsCard.setBackgroundColor(cardColor)
        binding.iconSizePanel.setBackgroundColor(cardColor)
        binding.homeGridPanel.setBackgroundColor(cardColor)
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
        val gridIconColor = layoutGridPreviewColor()
        binding.grid5x4Icon.setPreview(LauncherLayoutGridPreviewPolicy.rows5x4, gridIconColor)
        binding.grid6x4Icon.setPreview(LauncherLayoutGridPreviewPolicy.rows6x4, gridIconColor)
        binding.iconSizeSeekBar.progressTintList = ColorStateList.valueOf(getColor(R.color.layout_ios_blue))
        binding.iconSizeSeekBar.progressBackgroundTintList =
            ColorStateList.valueOf(if (layoutDarkMode) 0xFF3A3A3C.toInt() else 0xFFC7C7CC.toInt())
        binding.iconSizeSeekBar.thumbTintList = null
        binding.iconSizeSeekBar.thumb = seekBarThumbDrawable(cardColor)
        applyHomeLayoutSettingsUi()
    }

    private fun applyLiquidGlassSettingsAppearance() {
        val backgroundColor = themedColor(R.color.settings_background, R.color.dark_settings_background)
        val cardColor = themedColor(R.color.settings_card, R.color.dark_settings_card)
        val primaryTextColor = themedColor(R.color.launcher_text_primary, R.color.dark_settings_text_primary)

        binding.liquidGlassSettingsPanel.setBackgroundColor(backgroundColor)
        applySettingsPageHeader(
            toolbar = binding.liquidGlassSettingsToolbar,
            backButton = binding.liquidGlassBackButton,
            titleView = binding.liquidGlassTitle,
            toolbarColor = cardColor,
            titleColor = primaryTextColor
        )
        binding.liquidGlassContent.setBackgroundColor(backgroundColor)
        binding.liquidGlassTopSpacer.setBackgroundColor(backgroundColor)
        setFixedHeight(binding.liquidGlassTopSpacer, LauncherSettingsPageHeaderPolicy.contentTopSpacerDp)
        binding.liquidGlassOptionsCard.setBackgroundColor(cardColor)
        binding.liquidGlassOptionTitle.setTextColor(primaryTextColor)
        binding.liquidGlassIconContainer.backgroundTintList = ColorStateList.valueOf(getColor(R.color.icon_liquid))
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
        applySettingsPageHeader(
            toolbar = binding.blurSettingsToolbar,
            backButton = binding.blurBackButton,
            titleView = binding.blurTitle,
            toolbarColor = cardColor,
            titleColor = primaryTextColor
        )
        binding.blurSettingsScroll.setBackgroundColor(backgroundColor)
        binding.blurSettingsContent.setBackgroundColor(backgroundColor)
        binding.blurTopSpacer.setBackgroundColor(backgroundColor)
        setFixedHeight(binding.blurTopSpacer, LauncherSettingsPageHeaderPolicy.contentTopSpacerDp)
        binding.blurOptionsCard.setBackgroundColor(cardColor)
        listOf(binding.blurMasterRow, binding.blurFolderRow, binding.blurWidgetRow, binding.blurSearchRow).forEach { row ->
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
        applySettingsPageHeader(
            toolbar = binding.animationSettingsToolbar,
            backButton = binding.animationBackButton,
            titleView = binding.animationTitle,
            toolbarColor = cardColor,
            titleColor = primaryTextColor
        )
        binding.animationSettingsScroll.setBackgroundColor(backgroundColor)
        binding.animationSettingsContent.setBackgroundColor(backgroundColor)
        binding.animationTopSpacer.setBackgroundColor(backgroundColor)
        setFixedHeight(binding.animationTopSpacer, LauncherSettingsPageHeaderPolicy.contentTopSpacerDp)
        binding.animationOptionsCard.setBackgroundColor(cardColor)
        listOf(binding.animationUnlockRow, binding.animationOpenCloseRow, binding.animationParallaxRow).forEach { row ->
            row.rowTitle.setTextColor(primaryTextColor)
            row.rowDivider.setBackgroundColor(dividerColor)
        }
        applyAnimationSettingsUi()
    }

    private fun applySettingsPageHeader(
        toolbar: FrameLayout,
        backButton: TextView,
        titleView: TextView,
        toolbarColor: Int,
        titleColor: Int
    ) {
        toolbar.setBackgroundColor(toolbarColor)
        toolbar.setPadding(0, 0, 0, 0)
        toolbar.layoutParams = (toolbar.layoutParams ?: ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            dp(LauncherSettingsPageHeaderPolicy.toolbarHeightDp)
        )).apply {
            height = dp(LauncherSettingsPageHeaderPolicy.toolbarHeightDp)
        }

        backButton.apply {
            text = getString(R.string.layout_back_settings)
            setTextColor(LauncherRenamePickerUiPolicy.accentColor)
            textSize = LauncherSettingsPageHeaderPolicy.backTextSizeSp
            gravity = Gravity.CENTER_VERTICAL
            includeFontPadding = false
        }
        backButton.layoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            dp(LauncherSettingsPageHeaderPolicy.toolbarRowHeightDp),
            Gravity.START or Gravity.BOTTOM
        ).apply {
            leftMargin = dp(LauncherSettingsPageHeaderPolicy.backStartMarginDp)
        }

        titleView.apply {
            setTextColor(titleColor)
            textSize = LauncherSettingsPageHeaderPolicy.titleTextSizeSp
            typeface = if (LauncherSettingsPageHeaderPolicy.titleIsBold) Typeface.DEFAULT_BOLD else Typeface.DEFAULT
            gravity = Gravity.CENTER
            includeFontPadding = false
        }
        titleView.layoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            dp(LauncherSettingsPageHeaderPolicy.toolbarRowHeightDp),
            Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM
        )
    }

    private fun createSettingsPageToolbar(
        title: CharSequence,
        toolbarColor: Int = LauncherRenamePickerUiPolicy.toolbarColor,
        titleColor: Int = LauncherRenamePickerUiPolicy.primaryTextColor,
        onBack: () -> Unit
    ): View {
        val toolbar = FrameLayout(this)
        val backButton = TextView(this).apply {
            isClickable = true
            isFocusable = true
            foreground = obtainStyledForeground()
            setOnClickListener { onBack() }
        }
        val titleView = TextView(this).apply {
            text = title
        }
        toolbar.addView(backButton)
        toolbar.addView(titleView)
        applySettingsPageHeader(
            toolbar = toolbar,
            backButton = backButton,
            titleView = titleView,
            toolbarColor = toolbarColor,
            titleColor = titleColor
        )
        toolbar.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            dp(LauncherSettingsPageHeaderPolicy.toolbarHeightDp)
        )
        return toolbar
    }

    private fun tintLayoutSwitches() {
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
        ).forEach(::applyIosSwitchStyle)
    }

    private fun applyIosSwitchStyle(switch: SwitchCompat) {
        val checkedState = intArrayOf(android.R.attr.state_checked)
        val defaultState = intArrayOf()
        switch.showText = false
        switch.splitTrack = false
        switch.minWidth = dp(LauncherSettingsSwitchStylePolicy.switchViewWidthDp)
        switch.minimumWidth = dp(LauncherSettingsSwitchStylePolicy.switchViewWidthDp)
        switch.thumbTintList = null
        switch.trackTintList = null
        switch.thumbDrawable = StateListDrawable().apply {
            addState(
                checkedState,
                switchThumbDrawable(LauncherSettingsSwitchStylePolicy.CHECKED_THUMB_COLOR)
            )
            addState(
                defaultState,
                switchThumbDrawable(LauncherSettingsSwitchStylePolicy.UNCHECKED_THUMB_COLOR)
            )
        }
        switch.trackDrawable = StateListDrawable().apply {
            addState(
                checkedState,
                switchTrackDrawable(
                    color = LauncherSettingsSwitchStylePolicy.CHECKED_TRACK_COLOR,
                    strokeColor = LauncherSettingsSwitchStylePolicy.CHECKED_TRACK_STROKE_COLOR
                )
            )
            addState(
                defaultState,
                switchTrackDrawable(
                    color = LauncherSettingsSwitchStylePolicy.UNCHECKED_TRACK_COLOR,
                    strokeColor = LauncherSettingsSwitchStylePolicy.UNCHECKED_TRACK_STROKE_COLOR
                )
            )
        }
    }

    private fun layoutGridPreviewColor(): Int =
        if (layoutDarkMode) {
            LauncherLayoutGridPreviewPolicy.darkCellColor
        } else {
            LauncherLayoutGridPreviewPolicy.lightCellColor
        }

    private fun switchTrackDrawable(color: Int, strokeColor: Int): Drawable =
        GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(LauncherSettingsSwitchStylePolicy.trackHeightDp / 2).toFloat()
            setColor(color)
            setStroke(dp(LauncherSettingsSwitchStylePolicy.strokeWidthDp), strokeColor)
            setSize(
                dp(LauncherSettingsSwitchStylePolicy.trackWidthDp),
                dp(LauncherSettingsSwitchStylePolicy.trackHeightDp)
            )
        }

    private fun switchThumbDrawable(color: Int): Drawable =
        GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setColor(color)
            setStroke(
                dp(LauncherSettingsSwitchStylePolicy.strokeWidthDp),
                LauncherSettingsSwitchStylePolicy.THUMB_STROKE_COLOR
            )
            setSize(
                dp(LauncherSettingsSwitchStylePolicy.thumbSizeDp),
                dp(LauncherSettingsSwitchStylePolicy.thumbSizeDp)
            )
        }

    private fun seekBarThumbDrawable(color: Int): Drawable =
        GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setColor(color)
            setStroke(dp(1), if (layoutDarkMode) 0xFF5A5A5F.toInt() else 0xFFC7C7CC.toInt())
            setSize(dp(22), dp(22))
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

    private fun setFixedHeight(view: View, heightDp: Int) {
        view.layoutParams = view.layoutParams.apply {
            height = dp(heightDp)
        }
    }

    private fun updateSettingsFabVisibility() {
        val overlayOpen = binding.layoutSettingsPanel.visibility == View.VISIBLE ||
            binding.liquidGlassSettingsPanel.visibility == View.VISIBLE ||
            binding.blurSettingsPanel.visibility == View.VISIBLE ||
            binding.animationSettingsPanel.visibility == View.VISIBLE ||
            binding.settingsDrawerOverlay.visibility == View.VISIBLE ||
            renameAppPickerOverlay != null ||
            changeIconPanel != null ||
            iconCropPanel != null ||
            wallpaperPickerPanel != null ||
            wallpaperPreviewPanel != null ||
            weatherSettingsPanel != null ||
            hiddenAppsSettingsPanel != null
        binding.settingsFab.visibility = if (
            LauncherSettingsMenuLayoutPolicy.SHOW_FEATURED_STAR &&
            LauncherShellModePolicy.shouldShowFullOptionsMenu() &&
            !overlayOpen
        ) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun applyLauncherSystemUi() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decor = window.decorView
            decor.systemUiVisibility = if (layoutDarkMode) {
                0
            } else {
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
        window.statusBarColor = if (
            LauncherSettingsPageHeaderPolicy.usesToolbarColorForStatusBar &&
            isBoundSettingsPageVisible()
        ) {
            themedColor(R.color.settings_card, R.color.dark_settings_card)
        } else {
            Color.TRANSPARENT
        }
        window.navigationBarColor = themedColor(R.color.settings_background, R.color.dark_settings_background)
    }

    private fun isBoundSettingsPageVisible(): Boolean {
        if (!::binding.isInitialized) return false
        return binding.layoutSettingsPanel.visibility == View.VISIBLE ||
            binding.liquidGlassSettingsPanel.visibility == View.VISIBLE ||
            binding.blurSettingsPanel.visibility == View.VISIBLE ||
            binding.animationSettingsPanel.visibility == View.VISIBLE
    }

    private fun themedColor(lightColorRes: Int, darkColorRes: Int): Int {
        return getColor(if (layoutDarkMode) darkColorRes else lightColorRes)
    }

    private fun roundedBackground(color: Int, radiusDp: Int): GradientDrawable {
        return GradientDrawable().apply {
            setColor(color)
            cornerRadius = dp(radiusDp).toFloat()
        }
    }

    private fun obtainStyledForeground(): Drawable? {
        val attrs = obtainStyledAttributes(intArrayOf(android.R.attr.selectableItemBackground))
        return attrs.getDrawable(0).also {
            attrs.recycle()
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

    private fun requestHomeRole(): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) return false
        val roleManager = getSystemService(RoleManager::class.java) ?: return false
        if (!roleManager.isRoleAvailable(RoleManager.ROLE_HOME)) return false
        if (roleManager.isRoleHeld(RoleManager.ROLE_HOME)) return false
        return runCatching {
            waitingForLauncherSelection = true
            homeRoleLauncher.launch(roleManager.createRequestRoleIntent(RoleManager.ROLE_HOME))
            true
        }.getOrElse {
            waitingForLauncherSelection = false
            false
        }
    }

    private fun dp(value: Int): Int {
        return (value * resources.displayMetrics.density + 0.5f).toInt()
    }

    private companion object {
        const val HOME_GRID_ROWS_5 = LauncherHomeLayoutPreferences.HOME_GRID_ROWS_5
        const val HOME_GRID_ROWS_6 = LauncherHomeLayoutPreferences.HOME_GRID_ROWS_6
        const val DEFAULT_HOME_GRID_ROWS = LauncherHomeLayoutPreferences.DEFAULT_HOME_GRID_ROWS
        const val MIN_HOME_ICON_SIZE_DP = LauncherHomeIconSizePolicy.MIN_HOME_ICON_SIZE_DP
        const val DEFAULT_HOME_ICON_SIZE_DP = LauncherHomeIconSizePolicy.DEFAULT_HOME_ICON_SIZE_DP
        const val MAX_HOME_ICON_SIZE_DP = LauncherHomeIconSizePolicy.MAX_HOME_ICON_SIZE_DP
        const val KEY_HOME_ICON_SIZE_COMPACT_MIGRATION_APPLIED =
            LauncherHomeIconSizePolicy.KEY_HOME_ICON_SIZE_COMPACT_MIGRATION_APPLIED
        const val KEY_HOME_ICON_SIZE_DEFAULT_56_MIGRATION_APPLIED =
            LauncherHomeIconSizePolicy.KEY_HOME_ICON_SIZE_DEFAULT_56_MIGRATION_APPLIED
        const val KEY_HOME_ICON_SIZE_DEFAULT_60_MIGRATION_APPLIED =
            LauncherHomeIconSizePolicy.KEY_HOME_ICON_SIZE_DEFAULT_60_MIGRATION_APPLIED
        const val KEY_HOME_ICON_SIZE_DEFAULT_58_MIGRATION_APPLIED =
            LauncherHomeIconSizePolicy.KEY_HOME_ICON_SIZE_DEFAULT_58_MIGRATION_APPLIED
        const val DRAWER_OPEN_ANIMATION_MS = 220L
        const val DRAWER_CLOSE_ANIMATION_MS = 180L
        const val DRAWER_DIM_ANIMATION_MS = 160L
        const val PRESET_WALLPAPER_COUNT = 11
        const val WALLPAPER_PRESET_DIRECTORY = "wallpapers"
        const val WALLPAPER_PRESET_FILE_NAME = "selected_wallpaper.png"
        const val KEY_LAYOUT_DARK_MODE = LauncherHomeLayoutPreferences.KEY_LAYOUT_DARK_MODE
        const val KEY_LAYOUT_IPHONE8_STYLE = "layout_iphone8_style"
        const val KEY_LAYOUT_AUTO_ARRANGE = LauncherHomeLayoutPreferences.KEY_LAYOUT_AUTO_REARRANGE_APPS
        const val KEY_LAYOUT_LIQUID_GLASS = LauncherHomeLayoutPreferences.KEY_LAYOUT_LIQUID_GLASS
        const val KEY_BLUR_EFFECT_ENABLED = LauncherHomeLayoutPreferences.KEY_BLUR_EFFECT_ENABLED
        const val KEY_BLUR_DOCK_ENABLED = LauncherHomeLayoutPreferences.KEY_BLUR_DOCK_ENABLED
        const val KEY_BLUR_FOLDER_ENABLED = LauncherHomeLayoutPreferences.KEY_BLUR_FOLDER_ENABLED
        const val KEY_BLUR_WIDGET_ENABLED = LauncherHomeLayoutPreferences.KEY_BLUR_WIDGET_ENABLED
        const val KEY_BLUR_SEARCH_ENABLED = LauncherHomeLayoutPreferences.KEY_BLUR_SEARCH_ENABLED
        const val KEY_ANIMATION_UNLOCK_ENABLED = "unlock_animation"
        const val KEY_ANIMATION_OPEN_CLOSE_ENABLED = "open_close_animation"
        const val KEY_ANIMATION_PARALLAX_ZOOM_ENABLED = "parallax_zoom_animations"
        const val KEY_CUSTOM_WALLPAPER_URI = LauncherHomeLayoutPreferences.KEY_CUSTOM_WALLPAPER_URI
        const val KEY_HOME_ICON_SIZE_DP = LauncherHomeLayoutPreferences.KEY_HOME_ICON_SIZE_DP
        const val KEY_HOME_GRID_ROWS = LauncherHomeLayoutPreferences.KEY_HOME_GRID_ROWS
        const val KEY_WEATHER_USE_METRIC = "weather_use_metric"
        const val KEY_WEATHER_REFRESH_INTERVAL = "weather_refresh_interval"
        const val DEFAULT_ANIMATION_UNLOCK_ENABLED = true
        const val DEFAULT_ANIMATION_OPEN_CLOSE_ENABLED = false
        const val DEFAULT_ANIMATION_PARALLAX_ZOOM_ENABLED = false
    }
}
