package com.cloudx.ios17.features.launcher

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.WallpaperManager
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProviderInfo
import android.content.BroadcastReceiver
import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.ComponentName
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.ActivityInfo.CONFIG_ORIENTATION
import android.content.pm.ActivityInfo.CONFIG_SCREEN_SIZE
import android.content.pm.LauncherApps
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.graphics.Rect
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.os.Process
import android.os.StrictMode
import android.os.UserManager
import android.provider.Settings
import android.text.Editable
import android.text.InputType
import android.text.TextUtils
import android.text.TextWatcher
import android.util.TypedValue
import android.view.ContextThemeWrapper
import android.view.DragEvent
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.doOnPreDraw
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.cloudx.ios17.BlissLauncher
import com.cloudx.ios17.R
import com.cloudx.ios17.core.Alarm
import com.cloudx.ios17.core.DeviceProfile
import com.cloudx.ios17.core.LauncherAppRenamePolicy
import com.cloudx.ios17.core.LauncherAppRenamePreferences
import com.cloudx.ios17.core.LauncherHomeLayoutPreferences
import com.cloudx.ios17.core.LauncherHomeLayoutSettings
import com.cloudx.ios17.core.LauncherLiquidGlassStylePolicy
import com.cloudx.ios17.core.Preferences
import com.cloudx.ios17.core.Utilities
import com.cloudx.ios17.core.blur.BlurWallpaperProvider
import com.cloudx.ios17.core.broadcast.ManagedProfileBroadcastReceiver
import com.cloudx.ios17.core.broadcast.TimeChangeBroadcastReceiver
import com.cloudx.ios17.core.broadcast.WallpaperChangeReceiver
import com.cloudx.ios17.core.customviews.BlissDragShadowBuilder
import com.cloudx.ios17.core.customviews.BlissFrameLayout
import com.cloudx.ios17.core.customviews.BlissInput
import com.cloudx.ios17.core.customviews.BlurBackgroundView
import com.cloudx.ios17.core.customviews.DockGridLayout
import com.cloudx.ios17.core.customviews.HorizontalPager
import com.cloudx.ios17.core.customviews.InsettableFrameLayout
import com.cloudx.ios17.core.customviews.InsettableRelativeLayout
import com.cloudx.ios17.core.customviews.PageIndicatorLinearLayout
import com.cloudx.ios17.core.customviews.RoundedWidgetView
import com.cloudx.ios17.core.customviews.SquareFrameLayout
import com.cloudx.ios17.core.customviews.SquareImageView
import com.cloudx.ios17.core.customviews.WidgetHost
import com.cloudx.ios17.core.database.DatabaseManager
import com.cloudx.ios17.core.database.model.ApplicationItem
import com.cloudx.ios17.core.database.model.CalendarIcon
import com.cloudx.ios17.core.database.model.FolderItem
import com.cloudx.ios17.core.database.model.LauncherItem
import com.cloudx.ios17.core.database.model.ShortcutItem
import com.cloudx.ios17.core.database.model.WidgetItem
import com.cloudx.ios17.core.events.AppAddEvent
import com.cloudx.ios17.core.events.AppChangeEvent
import com.cloudx.ios17.core.events.AppRemoveEvent
import com.cloudx.ios17.core.events.EventRelay
import com.cloudx.ios17.core.events.ShortcutAddEvent
import com.cloudx.ios17.core.executors.AppExecutors
import com.cloudx.ios17.core.utils.AppUtils
import com.cloudx.ios17.core.utils.Constants
import com.cloudx.ios17.core.utils.DepthManager
import com.cloudx.ios17.core.utils.GraphicsUtil
import com.cloudx.ios17.core.utils.UserHandle
import com.cloudx.ios17.core.utils.getActivityThemeRes
import com.cloudx.ios17.core.utils.isWorkspaceDarkText
import com.cloudx.ios17.core.wallpaper.WallpaperManagerCompat
import com.cloudx.ios17.features.shortcuts.DeepShortcutManager
import com.cloudx.ios17.features.shortcuts.ShortcutKey
import com.cloudx.ios17.features.suggestions.AutoCompleteAdapter
import com.cloudx.ios17.features.suggestions.SearchSuggestionUtil
import com.cloudx.ios17.features.suggestions.SuggestionProvider
import com.cloudx.ios17.features.suggestions.SuggestionsResult
import com.cloudx.ios17.features.launcher.workspace.LauncherPageIndicatorWheelView
import com.cloudx.ios17.features.launcher.workspace.LauncherPageIndicatorWindowPolicy
import com.cloudx.ios17.features.weather.DeviceStatusService
import com.cloudx.ios17.features.weather.WeatherPreferences
import com.cloudx.ios17.features.weather.WeatherSourceListenerService
import com.cloudx.ios17.features.weather.WeatherUpdateService
import com.cloudx.ios17.features.weather.WeatherUtils
import com.cloudx.ios17.features.widgets.DefaultWidgets
import com.cloudx.ios17.features.widgets.WidgetManager
import com.cloudx.ios17.features.widgets.WidgetViewBuilder
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.Calendar
import java.text.Collator
import java.util.Locale
import java.util.concurrent.TimeUnit
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.hypot
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt
import me.relex.circleindicator.CircleIndicator
import timber.log.Timber

class LauncherActivity : AppCompatActivity(),
    AutoCompleteAdapter.OnSuggestionClickListener,
    OnSwipeDownListener,
    WallpaperManagerCompat.OnColorsChangedListener {

    private enum class IndicatorMode {
        DOTS,
        SEARCH
    }

    private data class TodayWidgetEntry(
        val widgetItem: WidgetItem,
        val widgetInfo: AppWidgetProviderInfo,
        val widgetView: RoundedWidgetView,
        val span: TodayWidgetLayoutPolicy.Span
    )

    private data class TodayQuickWidgetEntry(
        val id: Int,
        val type: TodayQuickWidgetType
    )

    private data class TodayRenderItem(
        val id: Int,
        val span: TodayWidgetLayoutPolicy.Span,
        val quickEntry: TodayQuickWidgetEntry? = null,
        val widgetEntry: TodayWidgetEntry? = null
    )

    private data class TodayWidgetProvider(
        val providerInfo: AppWidgetProviderInfo,
        val label: CharSequence,
        val icon: Drawable?,
        val span: TodayWidgetLayoutPolicy.Span
    )

    private enum class TodayQuickWidgetType(
        val span: TodayWidgetLayoutPolicy.Span
    ) {
        WEATHER(TodayWidgetLayoutPolicy.Span.FULL),
        BATTERY(TodayWidgetLayoutPolicy.Span.HALF),
        PICTURE(TodayWidgetLayoutPolicy.Span.HALF),
        APP_GROUP(TodayWidgetLayoutPolicy.Span.FULL),
        FAVORITES(TodayWidgetLayoutPolicy.Span.FULL),
        CALENDAR(TodayWidgetLayoutPolicy.Span.HALF)
    }

    companion object {
        private const val TAG = "LauncherActivity"
        private const val WIDGET_PAGE = 0
        const val REORDER_TIMEOUT = 350
        private const val EMPTY_LOCATION_DRAG = -999
        private const val REQUEST_TODAY_BIND_APPWIDGET = 721
        private const val REQUEST_TODAY_CREATE_APPWIDGET = 722
        private const val PAGE_INDICATOR_VISIBLE_MS = 2000L
        private const val PAGE_INDICATOR_SEARCH_WIDTH_DP = 104
        private const val PAGE_INDICATOR_SEARCH_HEIGHT_DP = 34
        private const val PAGE_INDICATOR_DOT_PADDING_DP = 4
        private const val APP_LIBRARY_TITLE = "Thư viện ứng dụng"
        private const val APP_LIBRARY_PREF_NAME = "ios_launcher_preferences"
        private const val APP_LIBRARY_CATEGORY_PREFIX = "app_category_"
        private const val APP_LIBRARY_SETTINGS_ACTIVITY = "com.vhmsoft.launcherios26.ui.applibrary.AppLibraryActivity"
        private const val APP_LIBRARY_COLUMNS = 2
        private const val APP_LIBRARY_PREVIEW_SLOTS = 4
        private const val APP_LIBRARY_OVERFLOW_SLOTS = 4
        private const val APP_LIBRARY_DIALOG_COLUMNS = 4
        private const val APP_LIBRARY_FOLDER_COLOR = 0x705F6663
        private const val APP_LIBRARY_EMPTY_FOLDER_COLOR = 0x365F6663
        private const val TODAY_WIDGET_PREF_NAME = "ios_launcher_today_widgets"
        private const val TODAY_WIDGET_PREF_QUICK = "quick_widgets"
        private const val TODAY_WIDGET_PREF_ORDER = "widget_order"
        private const val TODAY_QUICK_WIDGET_ID_START = -1000
        private const val TODAY_WIDGET_SHEET_ANIMATION_MS = 170L
        const val ACTION_LAUNCHER_RESUME = "com.cloudx.ios17.LauncherActivity.LAUNCHER_RESUME"

        @JvmField
        var longPressed = false

        @JvmStatic
        fun getLauncher(context: Context): LauncherActivity {
            if (context is LauncherActivity) {
                return context
            }
            return (context as ContextWrapper).baseContext as LauncherActivity
        }
    }

    private val mReorderAlarm = Alarm()
    private val mDockReorderAlarm = Alarm()
    private lateinit var mHorizontalPager: HorizontalPager
    private lateinit var mDock: DockGridLayout
    private lateinit var mIndicator: PageIndicatorLinearLayout
    private lateinit var editTopBar: View
    private lateinit var doneEditButton: View
    private lateinit var contextOverlay: View
    private lateinit var selectedIconPreview: View
    private lateinit var selectedIconImage: ImageView
    private var launcherOptionsPopup: PopupWindow? = null
    private var renameAppPanel: View? = null
    private val indicatorHandler = Handler(Looper.getMainLooper())
    private val hideIndicatorRunnable = Runnable { hidePageIndicator() }
    private var indicatorMode = IndicatorMode.SEARCH
    private var indicatorWheelView: LauncherPageIndicatorWheelView? = null
    private lateinit var mFolderWindowContainer: ViewGroup
    private lateinit var mFolderAppsViewPager: ViewPager
    private lateinit var mFolderTitleInput: BlissInput
    private var mSearchInput: BlissInput? = null
    private lateinit var mProgressBar: View
    private var currentPageNumber = 0
    private var maxDistanceForFolderCreation = 0f
    private var pages: MutableList<GridLayout> = ArrayList()
    private var dragDropEnabled = true
    private var movingApp: BlissFrameLayout? = null
    private var collidingApp: BlissFrameLayout? = null
    private var folderInterest = false
    private lateinit var wobbleAnimation: Animation
    private lateinit var wobbleReverseAnimation: Animation
    private var scrollCorner = 0
    private var parentPage = -99
    private var dragStartHomePage = -1
    private var dragStartHomeCell = LauncherItem.INVALID_CELL
    private var folderFromDock = false
    private var isWobbling = false
    private var mCompositeDisposable: CompositeDisposable? = null
    private var mWobblingCountDownTimer: CountDownTimer? = null
    private val mCalendarIcons: MutableList<BlissFrameLayout> = ArrayList()
    private var timeChangedReceiver: TimeChangeBroadcastReceiver? = null
    private var isUiDone = false
    private var mAppsWithNotifications: Set<String> = HashSet()

    private lateinit var mLauncherView: View
    private lateinit var mDeviceProfile: DeviceProfile
    private lateinit var launcherHomeLayoutSettings: LauncherHomeLayoutSettings
    private var mLongClickStartsDrag = true
    private var isDragging = false
    private var dragShadowBuilder: BlissDragShadowBuilder? = null
    private var allAppsDisplayed = false
    private var forceRefreshSuggestedApps = false
    private var liquidGlassEnabled = false

    private var mSuggestedApps: List<ApplicationItem> = ArrayList()
    private lateinit var swipeSearchContainer: FrameLayout
    private lateinit var workspace: InsettableRelativeLayout
    private lateinit var blurLayer: View

    private var activeFolder: FolderItem? = null
    private var activeFolderView: BlissFrameLayout? = null

    private lateinit var mAppWidgetManager: AppWidgetManager
    private lateinit var mAppWidgetHost: WidgetHost
    private lateinit var widgetContainer: LinearLayout
    private val todayWidgetEntries: MutableList<TodayWidgetEntry> = ArrayList()
    private val todayQuickWidgetEntries: MutableList<TodayQuickWidgetEntry> = ArrayList()
    private val todayWidgetHosts: MutableMap<Int, View> = HashMap()
    private val todayWidgetVisualOrder: MutableList<Int> = ArrayList()
    private var isTodayWidgetEditing = false
    private var draggedTodayWidgetId: Int? = null
    private var todayWidgetDragOriginalOrder: List<Int> = emptyList()
    private var todayWidgetDragPreview: ImageView? = null
    private var todayWidgetDragDropped = false
    private var widgetPickerOverlay: FrameLayout? = null
    private var widgetPreviewOverlay: FrameLayout? = null
    private var pendingTodayWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
    private var nextTodayQuickWidgetId = TODAY_QUICK_WIDGET_ID_START

    private var widgetsPage: FrameLayout? = null
    private var appLibraryPage: ScrollView? = null
    private var appLibraryApps: List<ApplicationItem> = emptyList()
    private var appLibrarySearchOverlay: FrameLayout? = null
    private var appLibrarySearchInput: EditText? = null
    private var appLibrarySearchResultsContainer: LinearLayout? = null
    private var appLibrarySearchQuery = ""
    private var appLibrarySearchSectionFilter: String? = null
    private var appLibraryDetailOverlay: FrameLayout? = null
    private var searchDisposableObserver: SearchInputDisposableObserver? = null
    private var currentAnimator: AnimatorSet? = null
    private lateinit var startBounds: Rect
    private lateinit var finalBounds: Rect
    private var startScaleFinal = 0f
    private var showSwipeSearch = false
    private var activeRoundedWidgetView: RoundedWidgetView? = null

    private var events: EventRelay? = null
    private var managedProfileReceiver: ManagedProfileBroadcastReceiver? = null

    private var moveTo = 0
    private lateinit var oldConfig: Configuration
    private lateinit var wallpaperChangeReceiver: WallpaperChangeReceiver
    private var mDetector: GestureDetectorCompat? = null

    private var mDepthManager: DepthManager? = null

    private var mThemeRes = R.style.HomeScreenTheme
    private lateinit var mLightLayoutInflater: LayoutInflater

    private lateinit var mInsetsController: WindowInsetsControllerCompat

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareBroadcastReceivers()

        WallpaperManagerCompat.getInstance(this).addOnChangeListener(this)
        val themeRes = getActivityThemeRes(this)
        if (themeRes != mThemeRes) {
            mThemeRes = themeRes
            setTheme(themeRes)
        }

        oldConfig = Configuration(resources.configuration)
        launcherHomeLayoutSettings = LauncherHomeLayoutPreferences.read(this)
        BlissLauncher.getApplication(this).resetDeviceProfile()
        mDeviceProfile = BlissLauncher.getApplication(this).deviceProfile

        mAppWidgetManager = BlissLauncher.getApplication(this).appWidgetManager
        mAppWidgetHost = BlissLauncher.getApplication(this).appWidgetHost

        mLauncherView = LayoutInflater.from(this).inflate(R.layout.activity_main, null)
        setContentView(mLauncherView)
        setupViews()

        val wm = getSystemService(WALLPAPER_SERVICE) as WallpaperManager
        wm.suggestDesiredDimensions(mDeviceProfile.widthPx, mDeviceProfile.heightPx)

        mProgressBar.visibility = VISIBLE

        createOrUpdateIconGrid()
        addDefaultWidgets()

        if (Utilities.ATLEAST_R) {
            mDepthManager = DepthManager(this)
        }

        if (isWorkspaceDarkText(this)) {
            var flags = mLauncherView.systemUiVisibility
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            mLauncherView.systemUiVisibility = flags
        }
        val lightContext = ContextThemeWrapper(this, R.style.HomeScreenTheme)
        mLightLayoutInflater = layoutInflater.cloneInContext(lightContext)
        mInsetsController = WindowInsetsControllerCompat(window, mLauncherView)
        applyLauncherSystemUi()
    }

    fun getRootView(): View = mLauncherView

    private fun setupViews() {
        workspace = mLauncherView.findViewById(R.id.workspace)
        wallpaperChangeReceiver = WallpaperChangeReceiver(workspace)
        workspace.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                wallpaperChangeReceiver.setWindowToken(v.windowToken)
            }

            override fun onViewDetachedFromWindow(v: View) {
                wallpaperChangeReceiver.setWindowToken(null)
            }
        })
        mHorizontalPager = mLauncherView.findViewById(R.id.pages_container)
        blurLayer = mLauncherView.findViewById(R.id.blur_layer)
        blurLayer.alpha = 0f

        mDock = mLauncherView.findViewById(R.id.dock)
        mIndicator = mLauncherView.findViewById(R.id.page_indicator)
        editTopBar = mLauncherView.findViewById(R.id.edit_top_bar)
        doneEditButton = mLauncherView.findViewById(R.id.done_edit_button)
        doneEditButton.setOnClickListener { handleWobbling(false) }
        contextOverlay = mLauncherView.findViewById(R.id.context_overlay)
        selectedIconPreview = mLauncherView.findViewById(R.id.selected_icon_preview)
        selectedIconImage = mLauncherView.findViewById(R.id.selected_icon_image)
        contextOverlay.setOnClickListener { dismissLauncherOptionsPopup() }
        mIndicator.setOnClickListener { openSearchFromIndicator() }
        mFolderWindowContainer = mLauncherView.findViewById(R.id.folder_window_container)
        mFolderAppsViewPager = mLauncherView.findViewById(R.id.folder_apps)
        mFolderTitleInput = mLauncherView.findViewById(R.id.folder_title)
        mProgressBar = mLauncherView.findViewById(R.id.progressbar)
        swipeSearchContainer = mLauncherView.findViewById(R.id.swipe_search_container)
        maxDistanceForFolderCreation = (0.45f * mDeviceProfile.iconSizePx).toInt().toFloat()

        scrollCorner = mDeviceProfile.iconDrawablePaddingPx / 2

        wobbleAnimation = AnimationUtils.loadAnimation(this, R.anim.wobble)
        wobbleReverseAnimation = AnimationUtils.loadAnimation(this, R.anim.wobble_reverse)
        workspace.setOnClickListener {
            if (swipeSearchContainer.visibility == VISIBLE) {
                hideSwipeSearchContainer()
            }
        }
        liquidGlassEnabled = LauncherHomeLayoutPreferences.isLiquidGlassEnabled(this)
        applyLiquidGlassAppearance()
    }

    private fun createOrUpdateIconGrid() {
        compositeDisposableBag.add(
            BlissLauncher.getApplication(this).appProvider.getAppsRepository()
                .getAppsRelay()
                .distinctUntilChanged()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<List<LauncherItem>>() {
                    override fun onNext(launcherItems: List<LauncherItem>) {
                        if (launcherItems.isEmpty()) {
                            BlissLauncher.getApplication(this@LauncherActivity).appProvider.reload(true)
                        } else if (!allAppsDisplayed) {
                            showApps(launcherItems)
                        }
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                    override fun onComplete() = Unit
                })
        )
    }

    private fun addDefaultWidgets() {
        val widgetIds = mAppWidgetHost.appWidgetIds
        val existingProviders = HashSet<ComponentName>()
        for (widgetId in widgetIds) {
            val info = mAppWidgetManager.getAppWidgetInfo(widgetId) ?: continue
            existingProviders.add(info.provider)
        }

        if (!Preferences.getAddedEcloudWidget(this)) {
            val provider = DefaultWidgets.ecloudWidget
            if (existingProviders.contains(provider) || allocateAndBindWidget(provider)) {
                Preferences.setAddedEcloudWidget(this)
            }
        }

        if (!Preferences.getAddedPrivacyWidget(this)) {
            val provider = DefaultWidgets.privacyWidget
            if (existingProviders.contains(provider) || allocateAndBindWidget(provider)) {
                Preferences.setAddedPrivacyWidget(this)
            }
        }

        if (!Preferences.getAddedWeatherWidget(this)) {
            val provider = DefaultWidgets.weatherWidget
            if (existingProviders.contains(provider) || allocateAndBindWidget(provider)) {
                Preferences.setAddedWeatherWidget(this)
            }
        }
    }

    private fun allocateAndBindWidget(provider: ComponentName): Boolean {
        val appWidgetId = mAppWidgetHost.allocateAppWidgetId()
        if (!mAppWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId, provider)) {
            mAppWidgetHost.deleteAppWidgetId(appWidgetId)
            return false
        }
        val widgetItem = WidgetItem(appWidgetId)
        widgetItem.order = 0
        DatabaseManager.getManager(this).insertWidget(widgetItem)
        return true
    }

    private fun prepareBroadcastReceivers() {
        timeChangedReceiver = TimeChangeBroadcastReceiver.register(this)
        managedProfileReceiver = ManagedProfileBroadcastReceiver.register(this)
    }

    private val compositeDisposableBag: CompositeDisposable
        get() {
            if (mCompositeDisposable == null || mCompositeDisposable!!.isDisposed) {
                mCompositeDisposable = CompositeDisposable()
            }
            return mCompositeDisposable!!
        }

    fun getCompositeDisposable(): CompositeDisposable = compositeDisposableBag

    fun updateAllCalendarIcons(calendar: Calendar) {
        for (blissIcon in mCalendarIcons) {
            val calendarIcon = CalendarIcon(
                blissIcon.findViewById(R.id.calendar_month_textview),
                blissIcon.findViewById(R.id.calendar_date_textview)
            )
            updateCalendarIcon(calendarIcon, calendar)
        }
    }

    private fun updateCalendarIcon(calendarIcon: CalendarIcon, calendar: Calendar) {
        calendarIcon.monthTextView.text = Utilities.convertMonthToString()
        calendarIcon.dayTextView.text = calendar.get(Calendar.DAY_OF_MONTH).toString()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

        applyLauncherSystemUi()
        if (refreshHomeLayoutIfNeeded()) {
            return
        }

        if (::mDock.isInitialized) {
            mDock.refreshStyle()
        }
        refreshLiquidGlassAppearanceIfNeeded()

        mDepthManager?.updateDepth()

        widgetsPage?.let {
            refreshSuggestedApps(it, forceRefreshSuggestedApps)
        }
        refreshAppLibraryPage()

        LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(ACTION_LAUNCHER_RESUME))

        if (::widgetContainer.isInitialized) {
            val widgetManager = WidgetManager.getInstance()
            var id = widgetManager.dequeRemoveId()
            while (id != null) {
                removeTodayWidgetFromPage(id, deleteHost = false)
                id = widgetManager.dequeRemoveId()
            }

            var widgetView = widgetManager.dequeAddWidgetView()
            while (widgetView != null) {
                val queuedWidgetView = widgetView ?: break
                val createdWidgetView = WidgetViewBuilder.create(this, queuedWidgetView)
                if (createdWidgetView != null) {
                    val widgetItem = WidgetItem(createdWidgetView.appWidgetId)
                    widgetItem.order = nextTodayWidgetOrder()
                    addWidgetToContainer(createdWidgetView, widgetItem)
                    DatabaseManager.getManager(this).insertWidget(widgetItem)
                    saveTodayWidgetOrder()
                }
                widgetView = widgetManager.dequeAddWidgetView()
            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            applyLauncherSystemUi()
        }
    }

    private fun refreshHomeLayoutIfNeeded(): Boolean {
        val latestSettings = LauncherHomeLayoutPreferences.read(this)
        if (latestSettings == launcherHomeLayoutSettings) {
            return false
        }

        launcherHomeLayoutSettings = latestSettings
        BlissLauncher.getApplication(this).resetDeviceProfile()
        recreate()
        return true
    }

    private fun refreshLiquidGlassAppearanceIfNeeded() {
        val latestLiquidGlassEnabled = LauncherHomeLayoutPreferences.isLiquidGlassEnabled(this)
        val liquidGlassChanged = latestLiquidGlassEnabled != liquidGlassEnabled
        liquidGlassEnabled = latestLiquidGlassEnabled
        applyLiquidGlassAppearance()
        if (liquidGlassChanged) {
            refreshVisibleFolderPreviewIcons()
        }
    }

    private fun refreshVisibleFolderPreviewIcons() {
        val graphicsUtil = GraphicsUtil(this)
        fun refreshFolderIcon(view: View?, fromDock: Boolean) {
            val folderView = view as? BlissFrameLayout ?: return
            val folderItem = folderView.launcherItem as? FolderItem ?: return
            updateIcon(
                folderView,
                folderItem,
                graphicsUtil.generateFolderIcon(this, folderItem),
                fromDock
            )
        }

        if (::mDock.isInitialized) {
            for (i in 0 until mDock.childCount) {
                refreshFolderIcon(mDock.getChildAt(i), fromDock = true)
            }
        }
        pages.forEach { page ->
            for (i in 0 until page.childCount) {
                refreshFolderIcon(page.getChildAt(i), fromDock = false)
            }
        }
    }

    private fun applyLiquidGlassAppearance() {
        if (::mDock.isInitialized) {
            mDock.refreshStyle()
        }
        if (::mIndicator.isInitialized) {
            mIndicator.background = roundedRectangle(
                LauncherLiquidGlassStylePolicy.pageIndicator(liquidGlassEnabled)
            )
        }
        if (::mLauncherView.isInitialized) {
            val folderBackground = mLauncherView.findViewById<View>(R.id.folder_apps_background)
            folderBackground?.background =
                roundedRectangle(LauncherLiquidGlassStylePolicy.folderPanel(liquidGlassEnabled))
        }
        if (::swipeSearchContainer.isInitialized) {
            val searchInput = swipeSearchContainer.findViewById<BlissInput>(R.id.search_input)
            (searchInput?.parent as? View)?.background =
                roundedRectangle(LauncherLiquidGlassStylePolicy.searchPill(liquidGlassEnabled))
        }
    }

    private fun applyLauncherSystemUi() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.navigationBarColor = Color.TRANSPARENT
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.isNavigationBarContrastEnforced = false
        }
        WindowInsetsControllerCompat(window, window.decorView).apply {
            hide(WindowInsetsCompat.Type.navigationBars())
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
        @Suppress("DEPRECATION")
        val appearanceFlags = window.decorView.systemUiVisibility and
            (View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility =
            appearanceFlags or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }

    private fun addWidgetToContainer(widgetView: RoundedWidgetView, widgetItem: WidgetItem = WidgetItem(widgetView.appWidgetId)) {
        val widgetInfo = widgetView.appWidgetInfo ?: return
        val span = TodayWidgetLayoutPolicy.spanFor(widgetInfo.minWidth, widgetInfo.minHeight)
        todayWidgetEntries.removeAll { it.widgetItem.id == widgetItem.id }
        todayWidgetEntries.add(TodayWidgetEntry(widgetItem, widgetInfo, widgetView, span))
        if (!todayWidgetVisualOrder.contains(widgetItem.id)) {
            todayWidgetVisualOrder.add(widgetItem.id)
        }
        renderTodayWidgets()
    }

    private fun renderTodayWidgets() {
        if (!::widgetContainer.isInitialized) {
            return
        }

        widgetContainer.removeAllViews()
        widgetContainer.clipChildren = false
        widgetContainer.clipToPadding = false
        todayWidgetHosts.clear()

        val renderItems = orderedTodayRenderItems()
        val entriesById = renderItems.associateBy { it.id }
        val rows = TodayWidgetLayoutPolicy.packRows(
            renderItems.map { TodayWidgetLayoutPolicy.Item(it.id, it.span) }
        )

        for (row in rows) {
            val rowLayout = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER
                clipChildren = false
                clipToPadding = false
            }
            rowLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            for (id in row.ids) {
                val entry = entriesById[id] ?: continue
                val host = when {
                    entry.quickEntry != null -> createTodayQuickWidgetHost(entry.quickEntry)
                    entry.widgetEntry != null -> createTodayWidgetHost(entry.widgetEntry)
                    else -> null
                } ?: continue
                if (id == draggedTodayWidgetId) {
                    host.visibility = View.INVISIBLE
                }
                val params = if (row.span == TodayWidgetLayoutPolicy.Span.FULL) {
                    LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        todayRenderItemHeight(entry)
                    )
                } else {
                    LinearLayout.LayoutParams(0, todayWidgetSquareSize(), 1f)
                }
                val margin = dp(6)
                params.setMargins(margin, margin, margin, margin)
                rowLayout.addView(host, params)
                todayWidgetHosts[id] = host
            }

            if (row.span == TodayWidgetLayoutPolicy.Span.HALF && row.ids.size == 1) {
                rowLayout.addView(View(this), LinearLayout.LayoutParams(0, todayWidgetSquareSize(), 1f))
            }

            widgetContainer.addView(rowLayout)
        }

        applyTodayWidgetEditState()
    }

    private fun orderedTodayRenderItems(): List<TodayRenderItem> {
        val unordered = linkedMapOf<Int, TodayRenderItem>()
        todayQuickWidgetEntries.forEach { entry ->
            unordered[entry.id] = TodayRenderItem(
                id = entry.id,
                span = entry.type.span,
                quickEntry = entry
            )
        }
        todayWidgetEntries.forEach { entry ->
            unordered[entry.widgetItem.id] = TodayRenderItem(
                id = entry.widgetItem.id,
                span = entry.span,
                widgetEntry = entry
            )
        }

        val ordered = mutableListOf<TodayRenderItem>()
        todayWidgetVisualOrder.forEach { id ->
            unordered.remove(id)?.let { ordered.add(it) }
        }
        ordered.addAll(unordered.values)

        todayWidgetVisualOrder.clear()
        todayWidgetVisualOrder.addAll(ordered.map { it.id })
        return ordered
    }

    private fun createTodayWidgetHost(entry: TodayWidgetEntry): FrameLayout {
        val host = FrameLayout(this).apply {
            tag = entry.widgetItem.id
            clipChildren = false
            clipToPadding = false
            setOnLongClickListener { startTodayWidgetDrag(entry.widgetItem.id, this) }
        }

        (entry.widgetView.parent as? ViewGroup)?.removeView(entry.widgetView)
        entry.widgetView.clearAnimation()
        entry.widgetView.setOnLongClickListener {
            startTodayWidgetDrag(entry.widgetItem.id, host)
        }

        host.addView(
            entry.widgetView,
            FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        )

        host.addView(createTodayWidgetRemoveButton(entry.widgetItem.id))

        return host
    }

    private fun createTodayQuickWidgetHost(entry: TodayQuickWidgetEntry): FrameLayout {
        return FrameLayout(this).apply {
            tag = entry.id
            clipChildren = false
            clipToPadding = false
            setOnLongClickListener { startTodayWidgetDrag(entry.id, this) }
            addView(
                createTodayQuickWidgetView(entry.type),
                FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
            )
            addView(createTodayWidgetRemoveButton(entry.id))
        }
    }

    private fun createTodayWidgetRemoveButton(widgetId: Int): TextView {
        return TextView(this).apply {
            tag = "today_widget_remove"
            text = "\u2212"
            gravity = Gravity.CENTER
            typeface = Typeface.DEFAULT_BOLD
            textSize = 17f
            setTextColor(Color.BLACK)
            background = roundedRectangle(0xEEF2F5F8.toInt(), 14)
            elevation = dp(4).toFloat()
            visibility = if (isTodayWidgetEditing) VISIBLE else GONE
            setOnClickListener { removeTodayWidgetFromPage(widgetId, deleteHost = true) }
            layoutParams = FrameLayout.LayoutParams(dp(28), dp(28), Gravity.START or Gravity.TOP).apply {
                leftMargin = -dp(13)
                topMargin = -dp(13)
            }
        }
    }

    private fun todayRenderItemHeight(item: TodayRenderItem): Int {
        item.widgetEntry?.let { return todayWidgetHeight(it) }
        return when (item.quickEntry?.type) {
            TodayQuickWidgetType.WEATHER -> dp(184)
            TodayQuickWidgetType.APP_GROUP -> dp(190)
            TodayQuickWidgetType.FAVORITES -> dp(172)
            TodayQuickWidgetType.BATTERY,
            TodayQuickWidgetType.PICTURE,
            TodayQuickWidgetType.CALENDAR,
            null -> todayWidgetSquareSize()
        }
    }

    private fun createTodayQuickWidgetView(type: TodayQuickWidgetType): View {
        return when (type) {
            TodayQuickWidgetType.WEATHER -> createTodayWeatherWidget()
            TodayQuickWidgetType.BATTERY -> createTodayBatteryWidget()
            TodayQuickWidgetType.PICTURE -> createTodayPictureWidget()
            TodayQuickWidgetType.APP_GROUP -> createTodayAppGroupWidget()
            TodayQuickWidgetType.FAVORITES -> createTodayFavoritesWidget()
            TodayQuickWidgetType.CALENDAR -> createTodayCalendarWidget()
        }
    }

    private fun createTodayWeatherWidget(): View {
        return FrameLayout(this).apply {
            background = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(0xFF07081B.toInt(), 0xFF253655.toInt())
            ).apply {
                cornerRadius = dp(18).toFloat()
            }
            addView(
                TextView(context).apply {
                    text = getString(R.string.today_widget_weather_location)
                    setTextColor(Color.WHITE)
                    textSize = 15f
                    typeface = Typeface.DEFAULT_BOLD
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.START or Gravity.TOP
                ).apply {
                    leftMargin = dp(18)
                    topMargin = dp(16)
                }
            )
            addView(
                TextView(context).apply {
                    text = "38\u00b0"
                    includeFontPadding = false
                    setTextColor(Color.WHITE)
                    textSize = 48f
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.START or Gravity.TOP
                ).apply {
                    leftMargin = dp(18)
                    topMargin = dp(54)
                }
            )
            addView(
                TextView(context).apply {
                    text = "\u2601"
                    includeFontPadding = false
                    setTextColor(Color.WHITE)
                    textSize = 42f
                    gravity = Gravity.CENTER
                },
                FrameLayout.LayoutParams(dp(62), dp(54), Gravity.END or Gravity.TOP).apply {
                    topMargin = dp(18)
                    rightMargin = dp(18)
                }
            )
            addView(
                LinearLayout(context).apply {
                    orientation = LinearLayout.VERTICAL
                    gravity = Gravity.END
                    addView(
                        TextView(context).apply {
                            text = getString(R.string.today_widget_weather_condition)
                            setTextColor(Color.WHITE)
                            textSize = 15f
                            typeface = Typeface.DEFAULT_BOLD
                            gravity = Gravity.END
                        }
                    )
                    addView(
                        TextView(context).apply {
                            text = getString(R.string.today_widget_weather_high_low)
                            setTextColor(Color.WHITE)
                            textSize = 13f
                            gravity = Gravity.END
                        }
                    )
                },
                FrameLayout.LayoutParams(
                    dp(150),
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.END or Gravity.CENTER_VERTICAL
                ).apply {
                    rightMargin = dp(18)
                }
            )
        }
    }

    private fun createTodayBatteryWidget(): View {
        return FrameLayout(this).apply {
            background = roundedRectangle(Color.BLACK, 18)
            addView(
                FrameLayout(context).apply {
                    background = GradientDrawable().apply {
                        shape = GradientDrawable.OVAL
                        setColor(Color.TRANSPARENT)
                        setStroke(dp(6), 0xFF00E321.toInt())
                    }
                    addView(
                        ImageView(context).apply {
                            setImageResource(R.drawable.ic_phone_home_20)
                            setColorFilter(Color.WHITE)
                        },
                        FrameLayout.LayoutParams(dp(38), dp(38), Gravity.CENTER)
                    )
                },
                FrameLayout.LayoutParams(dp(74), dp(74), Gravity.START or Gravity.TOP).apply {
                    leftMargin = dp(18)
                    topMargin = dp(16)
                }
            )
            addView(
                TextView(context).apply {
                    text = "${todayBatteryPercentage()}%"
                    includeFontPadding = false
                    setTextColor(Color.WHITE)
                    textSize = 36f
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.START or Gravity.BOTTOM
                ).apply {
                    leftMargin = dp(12)
                    bottomMargin = dp(24)
                }
            )
        }
    }

    private fun createTodayPictureWidget(): View {
        return FrameLayout(this).apply {
            background = GradientDrawable(
                GradientDrawable.Orientation.BL_TR,
                intArrayOf(0xFF455E8A.toInt(), 0xFFFFA126.toInt(), 0xFFFFE07A.toInt())
            ).apply {
                cornerRadius = dp(18).toFloat()
            }
            addView(
                TextView(context).apply {
                    text = "PHOTO"
                    gravity = Gravity.TOP or Gravity.START
                    setTextColor(0xEEFFFFFF.toInt())
                    textSize = 18f
                    typeface = Typeface.DEFAULT_BOLD
                    setPadding(dp(14), dp(12), 0, 0)
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }
    }

    private fun createTodayAppGroupWidget(): View {
        val apps = availableTodayWidgetApps(8)
        return LinearLayout(this).apply {
            background = roundedRectangle(0x88D8DEE2.toInt(), 20)
            clipChildren = false
            clipToPadding = false
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(dp(18), dp(18), dp(18), dp(18))
            repeat(2) { rowIndex ->
                addView(
                    LinearLayout(context).apply {
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.HORIZONTAL
                        repeat(4) { columnIndex ->
                            val app = apps.getOrNull(rowIndex * 4 + columnIndex)
                            addView(
                                FrameLayout(context).apply {
                                    addView(createTodayWidgetAppIcon(app), FrameLayout.LayoutParams(dp(62), dp(62), Gravity.CENTER))
                                },
                                LinearLayout.LayoutParams(0, dp(72), 1f)
                            )
                        }
                    },
                    LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        0,
                        1f
                    )
                )
            }
        }
    }

    private fun createTodayFavoritesWidget(): View {
        val names = listOf("Anna", "Eden", "Justin", "Armando")
        val colors = listOf(0xFFC9F0D1.toInt(), 0xFFF6C3D7.toInt(), 0xFFC7E3F8.toInt(), 0xFFF9C1BF.toInt())
        return LinearLayout(this).apply {
            background = roundedRectangle(0x8FAAB6C2.toInt(), 20)
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            setPadding(dp(14), dp(18), dp(14), dp(10))
            names.forEachIndexed { index, name ->
                addView(
                    LinearLayout(context).apply {
                        orientation = LinearLayout.VERTICAL
                        gravity = Gravity.CENTER
                        addView(
                            TextView(context).apply {
                                text = name.take(1)
                                gravity = Gravity.CENTER
                                textSize = 26f
                                typeface = Typeface.DEFAULT_BOLD
                                setTextColor(0xFF263238.toInt())
                                background = GradientDrawable().apply {
                                    shape = GradientDrawable.OVAL
                                    setColor(colors[index])
                                }
                            },
                            LinearLayout.LayoutParams(dp(58), dp(58))
                        )
                        addView(
                            TextView(context).apply {
                                text = name
                                setTextColor(Color.BLACK)
                                textSize = 13f
                                typeface = Typeface.DEFAULT_BOLD
                                gravity = Gravity.CENTER
                                maxLines = 1
                                ellipsize = TextUtils.TruncateAt.END
                            },
                            LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            ).apply {
                                topMargin = dp(10)
                            }
                        )
                    },
                    LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
                )
            }
        }
    }

    private fun createTodayCalendarWidget(): View {
        val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH).toString()
        return LinearLayout(this).apply {
            background = roundedRectangle(Color.WHITE, 18)
            orientation = LinearLayout.VERTICAL
            setPadding(dp(16), dp(14), dp(14), dp(12))
            addView(
                TextView(context).apply {
                    text = "THURSDAY"
                    setTextColor(0xFFB54752.toInt())
                    textSize = 13f
                    typeface = Typeface.DEFAULT_BOLD
                }
            )
            addView(
                TextView(context).apply {
                    text = day
                    includeFontPadding = false
                    setTextColor(Color.BLACK)
                    textSize = 48f
                }
            )
            addView(
                TextView(context).apply {
                    text = "No more events"
                    setTextColor(0xFF9E9E9E.toInt())
                    textSize = 13f
                    maxLines = 2
                }
            )
        }
    }

    private fun createTodayWidgetAppIcon(app: ApplicationItem?): ImageView {
        return ImageView(this).apply {
            setImageDrawable(app?.icon)
            visibility = if (app == null) View.INVISIBLE else VISIBLE
            contentDescription = app?.title
            scaleType = ImageView.ScaleType.FIT_CENTER
            if (app != null) {
                isClickable = true
                isFocusable = true
                setOnClickListener { startActivitySafely(this@LauncherActivity, app, it) }
            }
        }
    }

    private fun availableTodayWidgetApps(limit: Int): List<ApplicationItem> {
        val source = if (mSuggestedApps.isNotEmpty()) {
            mSuggestedApps
        } else {
            appLibraryApps
        }
        return source
            .filterIsInstance<ApplicationItem>()
            .distinctBy { it.id }
            .take(limit)
    }

    private fun todayBatteryPercentage(): Int {
        val status = registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED)) ?: return 100
        val level = status.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = status.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        if (level < 0 || scale <= 0) {
            return 100
        }
        return (level * 100 / scale).coerceIn(0, 100)
    }

    private fun todayWidgetHeight(entry: TodayWidgetEntry): Int {
        if (entry.span == TodayWidgetLayoutPolicy.Span.HALF) {
            return FrameLayout.LayoutParams.MATCH_PARENT
        }

        val currentHeight = entry.widgetView.layoutParams?.height ?: ViewGroup.LayoutParams.WRAP_CONTENT
        if (currentHeight > 0) {
            return currentHeight
        }

        val providerHeight = entry.widgetInfo.minHeight
        return if (providerHeight > 0) {
            providerHeight.coerceIn(dp(104), dp(184))
        } else {
            dp(150)
        }
    }

    private fun todayWidgetSquareSize(): Int {
        val availableWidth = resources.displayMetrics.widthPixels - dp(60)
        return max(dp(148), min(dp(182), availableWidth / 2 - dp(12)))
    }

    private fun showResizeContainerIfAvailable(widgetView: RoundedWidgetView) {
        val widgetProviderInfo = widgetView.appWidgetInfo
        if ((widgetProviderInfo.resizeMode and AppWidgetProviderInfo.RESIZE_VERTICAL) ==
            AppWidgetProviderInfo.RESIZE_VERTICAL
        ) {
            showWidgetResizeContainer(widgetView)
        } else {
            Timber.tag(TAG).i(getString(R.string.widget_is_not_resizable))
        }
    }

    private fun setTodayWidgetEditing(editing: Boolean) {
        isTodayWidgetEditing = editing
        applyTodayWidgetEditState()
    }

    private fun applyTodayWidgetEditState() {
        val page = widgetsPage ?: return
        page.findViewById<View?>(R.id.widget_edit_top_bar)?.visibility =
            if (isTodayWidgetEditing) VISIBLE else GONE
        page.findViewById<View?>(R.id.edit_widgets_button)?.visibility =
            if (isTodayWidgetEditing) GONE else VISIBLE
        page.findViewById<TextView?>(R.id.add_today_widget_button)?.setTextColor(Color.BLACK)
        page.findViewById<TextView?>(R.id.done_today_widget_edit_button)?.setTextColor(Color.BLACK)
        hideWidgetPageIndicator()

        todayWidgetHosts.values.forEachIndexed { index, host ->
            host.findViewWithTag<View>("today_widget_remove")?.visibility =
                if (isTodayWidgetEditing) VISIBLE else GONE
            val shouldWobble = isTodayWidgetEditing && draggedTodayWidgetId == null
            if (shouldWobble) {
                if (host.animation == null) {
                    host.startAnimation(todayWidgetWobbleAnimation(index % 2 != 0))
                }
            } else {
                host.clearAnimation()
            }
        }
    }

    private fun todayWidgetWobbleAnimation(reverse: Boolean): Animation {
        return AnimationUtils.loadAnimation(
            this,
            if (reverse) R.anim.today_widget_wobble_reverse else R.anim.today_widget_wobble
        )
    }

    private fun startTodayWidgetDrag(widgetId: Int, host: View): Boolean {
        if (!isTodayWidgetEditing) {
            setTodayWidgetEditing(true)
            return true
        }

        draggedTodayWidgetId = widgetId
        todayWidgetDragDropped = false
        todayWidgetDragOriginalOrder = orderedTodayRenderItems().map { it.id }
        createTodayWidgetDragPreview(host)
        val data = ClipData.newPlainText("today_widget", widgetId.toString())
        val shadowBuilder = InvisibleTodayWidgetDragShadowBuilder(host)
        val started = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            host.startDragAndDrop(data, shadowBuilder, widgetId, 0)
        } else {
            @Suppress("DEPRECATION")
            host.startDrag(data, shadowBuilder, widgetId, 0)
        }
        if (started) {
            host.visibility = View.INVISIBLE
            val hostLocation = IntArray(2)
            host.getLocationOnScreen(hostLocation)
            updateTodayWidgetDragPreview(
                hostLocation[0] + host.width / 2f,
                hostLocation[1] + host.height / 2f
            )
            hideWidgetPageIndicator()
        } else {
            draggedTodayWidgetId = null
            todayWidgetDragOriginalOrder = emptyList()
            removeTodayWidgetDragPreview()
        }
        return started
    }

    private fun createTodayWidgetDragPreview(host: View) {
        removeTodayWidgetDragPreview()
        if (host.width <= 0 || host.height <= 0) {
            return
        }

        val dragLayer = widgetsPage?.findViewById<FrameLayout>(R.id.drag_layer) ?: return
        val bitmap = Bitmap.createBitmap(host.width, host.height, Bitmap.Config.ARGB_8888)
        host.draw(Canvas(bitmap))
        todayWidgetDragPreview = ImageView(this).apply {
            setImageBitmap(bitmap)
            scaleType = ImageView.ScaleType.FIT_XY
            alpha = 0.96f
            elevation = dp(18).toFloat()
            isClickable = false
            isFocusable = false
        }
        dragLayer.addView(
            todayWidgetDragPreview,
            FrameLayout.LayoutParams(host.width, host.height)
        )
    }

    private fun updateTodayWidgetDragPreview(rawX: Float, rawY: Float) {
        val preview = todayWidgetDragPreview ?: return
        val dragLayer = widgetsPage?.findViewById<FrameLayout>(R.id.drag_layer) ?: return
        val dragLayerLocation = IntArray(2)
        dragLayer.getLocationOnScreen(dragLayerLocation)
        preview.x = rawX - dragLayerLocation[0] - preview.width / 2f
        preview.y = rawY - dragLayerLocation[1] - preview.height / 2f
    }

    private fun removeTodayWidgetDragPreview() {
        todayWidgetDragPreview?.let { preview ->
            (preview.parent as? ViewGroup)?.removeView(preview)
            (preview.drawable as? android.graphics.drawable.BitmapDrawable)?.bitmap?.recycle()
        }
        todayWidgetDragPreview = null
    }

    private fun handleTodayWidgetDragEvent(source: View, event: DragEvent): Boolean {
        val draggedId = draggedTodayWidgetId ?: return false
        val rawPoint = todayWidgetDragRawPoint(source, event)
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> return true
            DragEvent.ACTION_DRAG_LOCATION -> {
                updateTodayWidgetDragPreview(rawPoint.first, rawPoint.second)
                val targetIndex = findTodayWidgetDropIndex(
                    rawPoint.first,
                    rawPoint.second,
                    draggedId
                )
                val currentIds = orderedTodayRenderItems().map { it.id }
                val previewOrder = TodayWidgetLayoutPolicy.previewOrder(currentIds, draggedId, targetIndex)
                if (previewOrder != todayWidgetVisualOrder) {
                    applyTodayWidgetVisualOrder(
                        previewOrder,
                        render = true,
                        animateMoves = true,
                        skipAnimatedId = draggedId
                    )
                    updateTodayWidgetDragPreview(rawPoint.first, rawPoint.second)
                }
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                val shouldRestoreOrder = !todayWidgetDragDropped && todayWidgetDragOriginalOrder.isNotEmpty()
                val endedDraggedId = draggedId
                draggedTodayWidgetId = null
                todayWidgetDragDropped = false
                removeTodayWidgetDragPreview()
                if (shouldRestoreOrder) {
                    applyTodayWidgetVisualOrder(
                        todayWidgetDragOriginalOrder,
                        render = true,
                        animateMoves = true,
                        skipAnimatedId = endedDraggedId
                    )
                } else {
                    todayWidgetHosts[draggedId]?.apply {
                        alpha = 1f
                        visibility = VISIBLE
                    }
                }
                todayWidgetDragOriginalOrder = emptyList()
                hideWidgetPageIndicator()
            }
            DragEvent.ACTION_DROP -> {
                todayWidgetDragDropped = true
                updateTodayWidgetDragPreview(rawPoint.first, rawPoint.second)
                val targetIndex = findTodayWidgetDropIndex(
                    rawPoint.first,
                    rawPoint.second,
                    draggedId
                )
                val currentIds = orderedTodayRenderItems().map { it.id }
                val reorderedIds = TodayWidgetLayoutPolicy.previewOrder(currentIds, draggedId, targetIndex)
                draggedTodayWidgetId = null
                todayWidgetDragOriginalOrder = emptyList()
                removeTodayWidgetDragPreview()
                applyTodayWidgetFinalOrder(
                    reorderedIds,
                    animateMoves = true,
                    skipAnimatedId = draggedId
                )
            }
        }
        return true
    }

    private fun todayWidgetDragRawPoint(source: View, event: DragEvent): Pair<Float, Float> {
        val sourceLocation = IntArray(2)
        source.getLocationOnScreen(sourceLocation)
        return Pair(sourceLocation[0] + event.x, sourceLocation[1] + event.y)
    }

    private fun applyTodayWidgetVisualOrder(
        ids: List<Int>,
        render: Boolean,
        animateMoves: Boolean = false,
        skipAnimatedId: Int? = null
    ) {
        val previousBounds = if (render && animateMoves) {
            todayWidgetHostBounds()
        } else {
            emptyMap()
        }
        todayWidgetVisualOrder.clear()
        todayWidgetVisualOrder.addAll(ids)
        if (render) {
            renderTodayWidgets()
            if (animateMoves) {
                animateTodayWidgetHostMoves(previousBounds, skipAnimatedId)
            }
        }
    }

    private fun applyTodayWidgetFinalOrder(
        ids: List<Int>,
        animateMoves: Boolean = false,
        skipAnimatedId: Int? = null
    ) {
        val previousBounds = if (animateMoves) {
            todayWidgetHostBounds()
        } else {
            emptyMap()
        }
        applyTodayWidgetVisualOrder(ids, render = false)

        val entriesById = todayWidgetEntries.associateBy { it.widgetItem.id }
        val quickEntriesById = todayQuickWidgetEntries.associateBy { it.id }
        todayWidgetEntries.clear()
        ids.mapNotNullTo(todayWidgetEntries) { entriesById[it] }
        todayQuickWidgetEntries.clear()
        ids.mapNotNullTo(todayQuickWidgetEntries) { quickEntriesById[it] }
        todayWidgetEntries.forEachIndexed { index, entry -> entry.widgetItem.order = index }
        saveTodayWidgetOrder()
        renderTodayWidgets()
        if (animateMoves) {
            animateTodayWidgetHostMoves(previousBounds, skipAnimatedId)
        }
    }

    private fun todayWidgetHostBounds(): Map<Int, Rect> {
        if (!::widgetContainer.isInitialized) {
            return emptyMap()
        }
        return todayWidgetHosts.mapNotNull { (id, host) ->
            val bounds = Rect()
            if (host.getGlobalVisibleRect(bounds)) {
                id to Rect(bounds)
            } else {
                null
            }
        }.toMap()
    }

    private fun animateTodayWidgetHostMoves(previousBounds: Map<Int, Rect>, skipAnimatedId: Int?) {
        if (previousBounds.isEmpty() || !::widgetContainer.isInitialized) {
            return
        }

        widgetContainer.doOnPreDraw {
            todayWidgetHosts.forEach { (id, host) ->
                if (id == skipAnimatedId) {
                    return@forEach
                }
                val previous = previousBounds[id] ?: return@forEach
                val current = Rect()
                if (!host.getGlobalVisibleRect(current)) {
                    return@forEach
                }
                val translation = TodayWidgetDragAnimationPolicy.startTranslation(
                    previousLeft = previous.left,
                    previousTop = previous.top,
                    currentLeft = current.left,
                    currentTop = current.top
                )
                if (translation.x == 0f && translation.y == 0f) {
                    return@forEach
                }
                host.animate().cancel()
                host.translationX = translation.x
                host.translationY = translation.y
                host.animate()
                    .translationX(0f)
                    .translationY(0f)
                    .setDuration(TodayWidgetDragAnimationPolicy.MOVE_DURATION_MS)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
            }
        }
    }

    private fun findTodayWidgetDropIndex(rawX: Float, rawY: Float, draggedId: Int): Int {
        val remainingIds = orderedTodayRenderItems().map { it.id }.filter { it != draggedId }
        for ((index, id) in remainingIds.withIndex()) {
            val host = todayWidgetHosts[id] ?: continue
            val bounds = Rect()
            if (!host.getGlobalVisibleRect(bounds)) {
                continue
            }
            if (rawY < bounds.centerY() || (rawY <= bounds.bottom && rawX < bounds.centerX())) {
                return index
            }
        }
        return remainingIds.size
    }

    private fun removeTodayWidgetFromPage(widgetId: Int, deleteHost: Boolean) {
        if (widgetId < 0) {
            todayQuickWidgetEntries.removeAll { it.id == widgetId }
        } else if (deleteHost) {
            mAppWidgetHost.deleteAppWidgetId(widgetId)
            DatabaseManager.getManager(this).removeWidget(widgetId)
        }
        todayWidgetEntries.removeAll { it.widgetItem.id == widgetId }
        todayWidgetVisualOrder.remove(widgetId)
        renderTodayWidgets()
        saveTodayWidgetOrder()
    }

    private fun nextTodayWidgetOrder(): Int {
        return (todayWidgetEntries.maxOfOrNull { it.widgetItem.order } ?: -1) + 1
    }

    private fun saveTodayWidgetOrder() {
        val nativeIds = todayWidgetVisualOrder.filter { id ->
            todayWidgetEntries.any { entry -> entry.widgetItem.id == id }
        }
        val orderedNativeIds = if (nativeIds.isEmpty()) {
            todayWidgetEntries.map { it.widgetItem.id }
        } else {
            nativeIds
        }
        DatabaseManager.getManager(this).saveWidgetOrder(orderedNativeIds)
        saveTodayQuickWidgets()
    }

    private fun loadTodayQuickWidgets() {
        val preferences = getSharedPreferences(TODAY_WIDGET_PREF_NAME, Context.MODE_PRIVATE)
        val storedWidgets = preferences.getString(TODAY_WIDGET_PREF_QUICK, null)
        todayQuickWidgetEntries.clear()

        if (storedWidgets == null) {
            listOf(
                TodayQuickWidgetType.WEATHER,
                TodayQuickWidgetType.BATTERY,
                TodayQuickWidgetType.APP_GROUP,
                TodayQuickWidgetType.PICTURE
            ).forEachIndexed { index, type ->
                todayQuickWidgetEntries.add(TodayQuickWidgetEntry(TODAY_QUICK_WIDGET_ID_START - index, type))
            }
        } else if (storedWidgets.isNotBlank()) {
            storedWidgets.split(",")
                .mapNotNull { encoded ->
                    val parts = encoded.split(":")
                    val id = parts.getOrNull(0)?.toIntOrNull() ?: return@mapNotNull null
                    val type = parts.getOrNull(1)?.let {
                        runCatching { TodayQuickWidgetType.valueOf(it) }.getOrNull()
                    } ?: return@mapNotNull null
                    TodayQuickWidgetEntry(id, type)
                }
                .let { todayQuickWidgetEntries.addAll(it) }
        }

        nextTodayQuickWidgetId = (todayQuickWidgetEntries.minOfOrNull { it.id } ?: TODAY_QUICK_WIDGET_ID_START) - 1

        todayWidgetVisualOrder.clear()
        preferences.getString(TODAY_WIDGET_PREF_ORDER, null)
            ?.split(",")
            ?.mapNotNull { it.toIntOrNull() }
            ?.let { todayWidgetVisualOrder.addAll(it) }
        if (todayWidgetVisualOrder.isEmpty()) {
            todayWidgetVisualOrder.addAll(todayQuickWidgetEntries.map { it.id })
        }
    }

    private fun saveTodayQuickWidgets() {
        val quickWidgets = todayQuickWidgetEntries.joinToString(",") { entry ->
            "${entry.id}:${entry.type.name}"
        }
        val order = todayWidgetVisualOrder.joinToString(",")
        getSharedPreferences(TODAY_WIDGET_PREF_NAME, Context.MODE_PRIVATE)
            .edit()
            .putString(TODAY_WIDGET_PREF_QUICK, quickWidgets)
            .putString(TODAY_WIDGET_PREF_ORDER, order)
            .apply()
    }

    private fun addTodayQuickWidget(type: TodayQuickWidgetType) {
        val entry = TodayQuickWidgetEntry(nextTodayQuickWidgetId--, type)
        todayQuickWidgetEntries.add(entry)
        todayWidgetVisualOrder.add(entry.id)
        saveTodayWidgetOrder()
        renderTodayWidgets()
        setTodayWidgetEditing(true)
    }

    private fun showTodayWidgetPicker() {
        dismissTodayWidgetPreview()
        dismissTodayWidgetPicker()

        val options = todayWidgetSheetOptions()

        val content = findViewById<ViewGroup>(android.R.id.content)
        val overlay = FrameLayout(this).apply {
            setBackgroundColor(0x88000000.toInt())
            isClickable = true
            setOnClickListener { dismissTodayWidgetPicker() }
        }
        widgetPickerOverlay = overlay

        val sheet = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(24), dp(10), dp(24), dp(20))
            background = roundedRectangle(0xF0F4F4F4.toInt(), 28)
            isClickable = true
        }
        overlay.addView(
            sheet,
            FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                (resources.displayMetrics.heightPixels * 0.78f).toInt(),
                Gravity.BOTTOM
            )
        )
        val grabber = addSheetGrabber(sheet)
        setupTodayWidgetSheetDrag(overlay, sheet, grabber)

        val searchInput = EditText(this).apply {
            hint = getString(R.string.today_widget_search_hint)
            setSingleLine(true)
            imeOptions = EditorInfo.IME_ACTION_SEARCH
            inputType = InputType.TYPE_CLASS_TEXT
            textSize = 18f
            setTextColor(Color.WHITE)
            setHintTextColor(0xCCFFFFFF.toInt())
            background = ColorDrawable(Color.TRANSPARENT)
            setPadding(dp(8), 0, dp(8), 0)
        }
        sheet.addView(
            LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                background = roundedRectangle(0x66A0A0A0, 14)
                setPadding(dp(12), 0, dp(10), 0)
                addView(
                    ImageView(context).apply {
                        setImageResource(R.drawable.ic_search_18)
                        setColorFilter(Color.WHITE)
                    },
                    LinearLayout.LayoutParams(dp(18), dp(18))
                )
                addView(
                    searchInput,
                    LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
                )
            },
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(50)
            ).apply {
                topMargin = dp(18)
                bottomMargin = dp(20)
            }
        )

        val scrollView = ScrollView(this).apply {
            isFillViewport = false
            isVerticalScrollBarEnabled = false
        }
        val resultContainer = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }
        scrollView.addView(
            resultContainer,
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )
        sheet.addView(
            scrollView,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        renderTodayWidgetPickerItems(resultContainer, options, "")
        searchInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                renderTodayWidgetPickerItems(resultContainer, options, s?.toString().orEmpty())
            }

            override fun afterTextChanged(s: Editable?) = Unit
        })

        content.addView(
            overlay,
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        animateTodayWidgetSheetIn(overlay, sheet)
    }

    private fun renderTodayWidgetPickerItems(
        container: LinearLayout,
        options: List<TodayQuickWidgetType>,
        query: String
    ) {
        val normalizedQuery = Utilities.stripCaseAndAccents(query)
        val filteredOptions = options.filter {
            normalizedQuery.isBlank() ||
                Utilities.stripCaseAndAccents(todayQuickWidgetLabel(it)).contains(normalizedQuery)
        }
        val indexedOptions = filteredOptions.mapIndexed { index, option -> index to option }.toMap()
        val rows = TodayWidgetLayoutPolicy.packRows(
            filteredOptions.mapIndexed { index, option ->
                TodayWidgetLayoutPolicy.Item(index, option.span)
            }
        )

        container.removeAllViews()
        for (row in rows) {
            val rowLayout = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER
            }
            container.addView(
                rowLayout,
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )

            for (id in row.ids) {
                val option = indexedOptions[id] ?: continue
                val card = createTodayWidgetOptionCard(option, row.span == TodayWidgetLayoutPolicy.Span.FULL)
                val params = if (row.span == TodayWidgetLayoutPolicy.Span.FULL) {
                    LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                } else {
                    LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
                }
                params.setMargins(dp(6), 0, dp(6), dp(16))
                rowLayout.addView(card, params)
            }

            if (row.span == TodayWidgetLayoutPolicy.Span.HALF && row.ids.size == 1) {
                rowLayout.addView(
                    View(this),
                    LinearLayout.LayoutParams(0, dp(178), 1f).apply {
                        setMargins(dp(6), 0, dp(6), dp(16))
                    }
                )
            }
        }
    }

    private fun todayWidgetSheetOptions(): List<TodayQuickWidgetType> {
        return listOf(
            TodayQuickWidgetType.BATTERY,
            TodayQuickWidgetType.PICTURE,
            TodayQuickWidgetType.APP_GROUP,
            TodayQuickWidgetType.FAVORITES,
            TodayQuickWidgetType.CALENDAR,
            TodayQuickWidgetType.WEATHER
        )
    }

    private fun createTodayWidgetOptionCard(type: TodayQuickWidgetType, fullWidth: Boolean): View {
        val addWidget = View.OnClickListener {
            addTodayQuickWidget(type)
            dismissTodayWidgetPicker()
        }
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            isClickable = true
            setOnClickListener(addWidget)
        }
        val preview = FrameLayout(this).apply {
            clipToOutline = true
            isClickable = true
            setOnClickListener(addWidget)
            addView(
                createTodayWidgetOptionPreview(type),
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }
        root.addView(
            preview,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                if (fullWidth) dp(170) else dp(112)
            )
        )

        root.addView(
            TextView(this).apply {
                text = todayQuickWidgetLabel(type)
                maxLines = 1
                ellipsize = TextUtils.TruncateAt.END
                gravity = Gravity.CENTER
                setTextColor(Color.BLACK)
                textSize = 15f
                typeface = Typeface.DEFAULT_BOLD
            },
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = dp(6)
            }
        )
        return root
    }

    private fun createTodayWidgetOptionPreview(type: TodayQuickWidgetType): View {
        return when (type) {
            TodayQuickWidgetType.BATTERY -> createTodayBatterySheetPreview()
            TodayQuickWidgetType.APP_GROUP -> createTodayAppGroupSheetPreview()
            else -> createTodayQuickWidgetView(type)
        }
    }

    private fun createTodayBatterySheetPreview(): View {
        return FrameLayout(this).apply {
            background = roundedRectangle(0xFF9E9E9E.toInt(), 18)
            addView(
                TextView(context).apply {
                    text = "${todayBatteryPercentage()}%"
                    includeFontPadding = false
                    setTextColor(Color.WHITE)
                    textSize = 48f
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.START or Gravity.BOTTOM
                ).apply {
                    leftMargin = dp(16)
                    bottomMargin = dp(18)
                }
            )
            addView(
                FrameLayout(context).apply {
                    background = GradientDrawable().apply {
                        shape = GradientDrawable.OVAL
                        setColor(Color.TRANSPARENT)
                        setStroke(dp(4), 0xFF00E321.toInt())
                    }
                },
                FrameLayout.LayoutParams(dp(54), dp(54), Gravity.TOP or Gravity.CENTER_HORIZONTAL).apply {
                    topMargin = -dp(18)
                }
            )
        }
    }

    private fun createTodayAppGroupSheetPreview(): View {
        val apps = availableTodayWidgetApps(8)
        return LinearLayout(this).apply {
            background = roundedRectangle(0xEE20202F.toInt(), 18)
            clipChildren = false
            clipToPadding = false
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(dp(16), dp(16), dp(16), dp(16))
            repeat(2) { rowIndex ->
                addView(
                    LinearLayout(context).apply {
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.HORIZONTAL
                        repeat(4) { columnIndex ->
                            val app = apps.getOrNull(rowIndex * 4 + columnIndex)
                            addView(
                                FrameLayout(context).apply {
                                    addView(createTodayWidgetAppIcon(app), FrameLayout.LayoutParams(dp(54), dp(54), Gravity.CENTER))
                                },
                                LinearLayout.LayoutParams(0, dp(62), 1f)
                            )
                        }
                    },
                    LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        0,
                        1f
                    )
                )
            }
        }
    }

    private fun todayQuickWidgetLabel(type: TodayQuickWidgetType): String {
        return when (type) {
            TodayQuickWidgetType.WEATHER -> getString(R.string.weather)
            TodayQuickWidgetType.BATTERY -> getString(R.string.today_widget_battery)
            TodayQuickWidgetType.PICTURE -> getString(R.string.today_widget_picture)
            TodayQuickWidgetType.APP_GROUP -> getString(R.string.today_widget_suggestions)
            TodayQuickWidgetType.FAVORITES -> getString(R.string.today_widget_favorites)
            TodayQuickWidgetType.CALENDAR -> getString(R.string.today_widget_calendar)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupTodayWidgetSheetDrag(overlay: FrameLayout, sheet: View, dragHandle: View) {
        var startRawY = 0f
        var startTranslationY = 0f
        val touchListener = View.OnTouchListener { _, event ->
            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    sheet.animate().cancel()
                    startRawY = event.rawY
                    startTranslationY = sheet.translationY
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    val maxTranslation = (sheet.height.takeIf { it > 0 } ?: resources.displayMetrics.heightPixels) * 0.7f
                    sheet.translationY = TodayWidgetSheetPolicy.dragTranslation(
                        startTranslation = startTranslationY,
                        deltaY = event.rawY - startRawY,
                        minTranslation = -dp(156).toFloat(),
                        maxTranslation = maxTranslation
                    )
                    true
                }
                MotionEvent.ACTION_UP,
                MotionEvent.ACTION_CANCEL -> {
                    when (TodayWidgetSheetPolicy.snapTarget(sheet.translationY, sheet.height.toFloat())) {
                        TodayWidgetSheetPolicy.SnapTarget.EXPANDED -> {
                            sheet.animate()
                                .translationY(-dp(156).toFloat())
                                .setDuration(TODAY_WIDGET_SHEET_ANIMATION_MS)
                                .setInterpolator(DecelerateInterpolator())
                                .start()
                        }
                        TodayWidgetSheetPolicy.SnapTarget.RESTING -> {
                            sheet.animate()
                                .translationY(0f)
                                .setDuration(TODAY_WIDGET_SHEET_ANIMATION_MS)
                                .setInterpolator(DecelerateInterpolator())
                                .start()
                        }
                        TodayWidgetSheetPolicy.SnapTarget.DISMISS -> dismissTodayWidgetPicker()
                    }
                    true
                }
                else -> false
            }
        }
        dragHandle.setOnTouchListener(touchListener)
        overlay.setOnClickListener { dismissTodayWidgetPicker() }
    }

    private fun animateTodayWidgetSheetIn(overlay: View, sheet: View) {
        overlay.alpha = 0f
        sheet.post {
            sheet.translationY = sheet.height.toFloat()
            overlay.animate()
                .alpha(1f)
                .setDuration(140L)
                .start()
            sheet.animate()
                .translationY(0f)
                .setDuration(220L)
                .setInterpolator(DecelerateInterpolator())
                .start()
        }
    }

    private fun createTodayWidgetProviderCard(provider: TodayWidgetProvider, fullWidth: Boolean): View {
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            isClickable = true
            setOnClickListener { showTodayWidgetPreview(provider) }
        }
        val preview = FrameLayout(this).apply {
            background = if (fullWidth) {
                roundedRectangle(Color.rgb(92, 158, 220), 16)
            } else {
                roundedRectangle(0xCCFFFFFF.toInt(), 16)
            }
            clipToOutline = true
        }
        root.addView(
            preview,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                if (fullWidth) dp(112) else dp(148)
            )
        )

        val icon = ImageView(this).apply {
            setImageDrawable(provider.icon)
            scaleType = ImageView.ScaleType.CENTER_INSIDE
        }
        val iconSize = if (fullWidth) dp(54) else dp(64)
        val iconParams = FrameLayout.LayoutParams(iconSize, iconSize, Gravity.CENTER)
        preview.addView(icon, iconParams)

        val title = TextView(this).apply {
            text = provider.label
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
            gravity = Gravity.CENTER
            setTextColor(Color.BLACK)
            textSize = 14f
        }
        root.addView(
            title,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = dp(6)
            }
        )
        return root
    }

    private fun showTodayWidgetPreview(provider: TodayWidgetProvider) {
        dismissTodayWidgetPicker()
        dismissTodayWidgetPreview()

        val content = findViewById<ViewGroup>(android.R.id.content)
        val overlay = FrameLayout(this).apply {
            setBackgroundColor(0x99000000.toInt())
            isClickable = true
            setOnClickListener { dismissTodayWidgetPreview() }
        }
        widgetPreviewOverlay = overlay

        val sheet = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(dp(32), dp(10), dp(32), dp(28))
            background = roundedRectangle(0xF4F4F4F4.toInt(), 28)
            isClickable = true
        }
        overlay.addView(
            sheet,
            FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                (resources.displayMetrics.heightPixels * 0.82f).toInt(),
                Gravity.BOTTOM
            )
        )

        addSheetGrabber(sheet)

        val title = TextView(this).apply {
            text = "Th\u00eam ti\u1ec7n \u00edch"
            setTextColor(Color.WHITE)
            textSize = 17f
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }
        sheet.addView(
            title,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = dp(28)
                bottomMargin = dp(70)
            }
        )

        val preview = createTodayWidgetLargePreview(provider)
        val previewSize = if (provider.span == TodayWidgetLayoutPolicy.Span.FULL) {
            LinearLayout.LayoutParams.MATCH_PARENT to dp(170)
        } else {
            dp(280) to dp(280)
        }
        sheet.addView(
            preview,
            LinearLayout.LayoutParams(previewSize.first, previewSize.second).apply {
                bottomMargin = dp(12)
            }
        )

        val label = TextView(this).apply {
            text = provider.label
            setTextColor(Color.BLACK)
            textSize = 16f
            gravity = Gravity.CENTER
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
        }
        sheet.addView(
            label,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        sheet.addView(
            View(this),
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        val addButton = TextView(this).apply {
            text = "TH\u00caM TI\u1ec6N \u00cdCH"
            gravity = Gravity.CENTER
            typeface = Typeface.DEFAULT_BOLD
            textSize = 15f
            setTextColor(Color.WHITE)
            background = roundedRectangle(Color.rgb(49, 145, 250), 13)
            isClickable = true
            setOnClickListener { addTodayWidgetFromProvider(provider.providerInfo) }
        }
        sheet.addView(
            addButton,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(54)
            )
        )

        content.addView(
            overlay,
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
    }

    private fun createTodayWidgetLargePreview(provider: TodayWidgetProvider): View {
        val preview = FrameLayout(this).apply {
            background = if (provider.span == TodayWidgetLayoutPolicy.Span.FULL) {
                roundedRectangle(Color.rgb(92, 158, 220), 28)
            } else {
                roundedRectangle(0xFFB2B2B2.toInt(), 28)
            }
        }
        val icon = ImageView(this).apply {
            setImageDrawable(provider.icon)
            scaleType = ImageView.ScaleType.CENTER_INSIDE
        }
        preview.addView(
            icon,
            FrameLayout.LayoutParams(dp(104), dp(104), Gravity.CENTER)
        )
        return preview
    }

    private fun todayWidgetProviders(): List<TodayWidgetProvider> {
        val installed = mAppWidgetManager.installedProviders ?: return emptyList()
        val density = resources.displayMetrics.densityDpi
        val collator = Collator.getInstance()
        return installed.map { providerInfo ->
            TodayWidgetProvider(
                providerInfo = providerInfo,
                label = providerInfo.loadLabel(packageManager),
                icon = providerInfo.loadIcon(this, density),
                span = TodayWidgetLayoutPolicy.spanFor(providerInfo.minWidth, providerInfo.minHeight)
            )
        }.sortedWith { left, right ->
            collator.compare(left.label.toString(), right.label.toString())
        }
    }

    private fun addSheetGrabber(sheet: LinearLayout): View {
        val grabber = View(this).apply {
            background = roundedRectangle(0x33000000, 2)
        }
        sheet.addView(
            grabber,
            LinearLayout.LayoutParams(dp(42), dp(4)).apply {
                gravity = Gravity.CENTER_HORIZONTAL
            }
        )
        return grabber
    }

    private fun dismissTodayWidgetPicker() {
        widgetPickerOverlay?.let { overlay ->
            (overlay.parent as? ViewGroup)?.removeView(overlay)
        }
        widgetPickerOverlay = null
    }

    private fun dismissTodayWidgetPreview() {
        widgetPreviewOverlay?.let { overlay ->
            (overlay.parent as? ViewGroup)?.removeView(overlay)
        }
        widgetPreviewOverlay = null
    }

    private fun addTodayWidgetFromProvider(providerInfo: AppWidgetProviderInfo) {
        dismissTodayWidgetPreview()
        dismissTodayWidgetPicker()

        val appWidgetId = mAppWidgetHost.allocateAppWidgetId()
        pendingTodayWidgetId = appWidgetId

        try {
            if (mAppWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId, providerInfo.provider)) {
                handleTodayWidgetBound(appWidgetId)
            } else {
                val permissionIntent = Intent(AppWidgetManager.ACTION_APPWIDGET_BIND).apply {
                    putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
                    putExtra(AppWidgetManager.EXTRA_APPWIDGET_PROVIDER, providerInfo.provider)
                    putExtra(AppWidgetManager.EXTRA_APPWIDGET_PROVIDER_PROFILE, providerInfo.profile)
                }
                startActivityForResult(permissionIntent, REQUEST_TODAY_BIND_APPWIDGET)
            }
        } catch (e: IllegalArgumentException) {
            mAppWidgetHost.deleteAppWidgetId(appWidgetId)
            pendingTodayWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
            Toast.makeText(this, R.string.toast_failed, Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleTodayWidgetBound(appWidgetId: Int) {
        val appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(appWidgetId)
        if (appWidgetInfo != null && appWidgetInfo.configure != null) {
            startTodayWidgetConfigureActivitySafely(appWidgetId)
        } else {
            createTodayWidget(appWidgetId)
        }
    }

    private fun createTodayWidget(appWidgetId: Int) {
        val appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(appWidgetId)
        if (appWidgetInfo == null) {
            mAppWidgetHost.deleteAppWidgetId(appWidgetId)
            return
        }

        val hostView = mAppWidgetHost.createView(applicationContext, appWidgetId, appWidgetInfo) as RoundedWidgetView
        hostView.setAppWidget(appWidgetId, appWidgetInfo)
        val widgetView = WidgetViewBuilder.create(this, hostView)
        if (widgetView == null) {
            mAppWidgetHost.deleteAppWidgetId(appWidgetId)
            return
        }

        val widgetItem = WidgetItem(appWidgetId)
        widgetItem.order = nextTodayWidgetOrder()
        addWidgetToContainer(widgetView, widgetItem)
        DatabaseManager.getManager(this).insertWidget(widgetItem)
        saveTodayWidgetOrder()
        setTodayWidgetEditing(true)
        pendingTodayWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
    }

    private fun startTodayWidgetConfigureActivitySafely(appWidgetId: Int) {
        try {
            mAppWidgetHost.startAppWidgetConfigureActivityForResult(
                this,
                appWidgetId,
                0,
                REQUEST_TODAY_CREATE_APPWIDGET,
                null
            )
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, R.string.activity_not_found, Toast.LENGTH_SHORT).show()
            createTodayWidget(appWidgetId)
        }
    }

    override fun onPause() {
        super.onPause()
        dismissTodayWidgetPicker()
        dismissTodayWidgetPreview()
        hideAppLibrarySearchOverlay(animated = false)
        hideAppLibraryDetailOverlay(animated = false)
        hideRenameAppPicker()
        dismissLauncherOptionsPopup()
        if (widgetsPage != null) {
            hideWidgetResizeContainer()
        }
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        timeChangedReceiver?.let { TimeChangeBroadcastReceiver.unregister(this, it) }
        managedProfileReceiver?.let { ManagedProfileBroadcastReceiver.unregister(this, it) }
        compositeDisposableBag.dispose()
        events?.unsubscribe()
        BlissLauncher.getApplication(this).appProvider.clear()
        WallpaperManagerCompat.getInstance(this).removeOnChangeListener(this)
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        val diff = newConfig.diff(oldConfig)
        if ((diff and (CONFIG_ORIENTATION or CONFIG_SCREEN_SIZE)) != 0) {
            recreate()
        }
        oldConfig.setTo(newConfig)
        super.onConfigurationChanged(newConfig)
    }

    fun onAppAddEvent(appAddEvent: AppAddEvent) {
        updateOrAddApp(appAddEvent.packageName, appAddEvent.userHandle)
        if (moveTo != -1) {
            mHorizontalPager.setCurrentPage(moveTo)
            moveTo = -1
        }
    }

    fun onAppRemoveEvent(appRemoveEvent: AppRemoveEvent) {
        forceRefreshSuggestedApps = true
        removePackageFromLauncher(appRemoveEvent.packageName, appRemoveEvent.userHandle)
        DatabaseManager.getManager(this).saveLayouts(pages, mDock)
        rebindAllWidgets()
    }

    fun onAppChangeEvent(appChangeEvent: AppChangeEvent) {
        updateOrAddApp(appChangeEvent.packageName, appChangeEvent.userHandle)
        DatabaseManager.getManager(this).saveLayouts(pages, mDock)
    }

    fun onShortcutAddEvent(shortcutAddEvent: ShortcutAddEvent) {
        moveTo = -1
        updateOrAddShortcut(shortcutAddEvent.shortcutItem)
        DatabaseManager.getManager(this).saveLayouts(pages, mDock)
        Toast.makeText(this, getString(R.string.toast_shortcut_added), Toast.LENGTH_SHORT).show()
        if (moveTo != -1) {
            mHorizontalPager.setCurrentPage(moveTo)
            moveTo = -1
        }
    }

    private fun addLauncherItem(launcherItem: LauncherItem?) {
        if (pages.isEmpty() || launcherItem == null) {
            return
        }

        val view = prepareLauncherItem(launcherItem)
        val current = findHomePageForNewItem()

        if (current == pages.size) {
            val page = preparePage()
            pages.add(page)
            addHomePageToPager(page)
            refreshPageIndicator()
        }

        val page = pages[current]
        launcherItem.screenId = current.toLong()
        launcherItem.cell = if (isAutoRearrangeAppsEnabled()) {
            LauncherHomeCellPolicy.compactCell(page.childCount)
        } else {
            LauncherHomeCellPolicy.nextAppendCell(
                occupiedCells = occupiedHomeCells(page),
                maxCells = mDeviceProfile.maxAppsPerPage
            ) ?: 0
        }
        launcherItem.container = Constants.CONTAINER_DESKTOP.toLong()
        addAppToGrid(page, view)
        moveTo = current + 1
    }

    private fun findHomePageForNewItem(): Int {
        if (isAutoRearrangeAppsEnabled()) {
            for (index in pages.indices) {
                if (pages[index].childCount < mDeviceProfile.maxAppsPerPage) {
                    return index
                }
            }
            return pages.size
        }

        for (index in pages.indices) {
            val nextCell = LauncherHomeCellPolicy.nextAppendCell(
                occupiedCells = occupiedHomeCells(pages[index]),
                maxCells = mDeviceProfile.maxAppsPerPage
            )
            if (nextCell != null) {
                return index
            }
        }
        return pages.size
    }

    private fun updateOrAddShortcut(shortcutItem: ShortcutItem) {
        if (mFolderWindowContainer.visibility == VISIBLE) {
            for (i in 0 until mFolderAppsViewPager.childCount) {
                val gridLayout = mFolderAppsViewPager.getChildAt(i) as GridLayout
                for (j in 0 until gridLayout.childCount) {
                    val viewGroup = gridLayout.getChildAt(j) as BlissFrameLayout
                    val existingItem = getAppDetails(viewGroup)
                    if (existingItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
                        val existingShortcutItem = existingItem as ShortcutItem
                        if (existingShortcutItem.id.equals(shortcutItem.id, ignoreCase = true)) {
                            val blissFrameLayout = prepareLauncherItem(shortcutItem)
                            val iconLayoutParams = GridLayout.LayoutParams()
                            iconLayoutParams.height = mDeviceProfile.cellHeightPx
                            iconLayoutParams.width = mDeviceProfile.cellWidthPx
                            gridLayout.removeViewAt(j)
                            gridLayout.addView(blissFrameLayout, j, iconLayoutParams)
                            return
                        }
                    }
                }
            }
        }

        for (i in 0 until mDock.childCount) {
            val viewGroup = mDock.getChildAt(i) as BlissFrameLayout
            val launcherItem = getAppDetails(viewGroup)
            if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                val folderItem = launcherItem as FolderItem
                val items = folderItem.items!!
                for (k in items.indices) {
                    if (items[k].itemType == Constants.ITEM_TYPE_SHORTCUT) {
                        val existingShortcutItem = items[k] as ShortcutItem
                        if (existingShortcutItem.id.equals(shortcutItem.id, ignoreCase = true)) {
                            items[k] = shortcutItem
                            folderItem.icon = GraphicsUtil(this).generateFolderIcon(this, folderItem)
                            val blissFrameLayout = prepareLauncherItem(launcherItem)
                            mDock.removeViewAt(i)
                            addAppToDock(blissFrameLayout, i)
                            return
                        }
                    }
                }
            } else if (launcherItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
                val existingShortcutItem = launcherItem as ShortcutItem
                if (existingShortcutItem.id.equals(shortcutItem.id, ignoreCase = true)) {
                    val blissFrameLayout = prepareLauncherItem(shortcutItem)
                    mDock.removeViewAt(i)
                    addAppToDock(blissFrameLayout, i)
                    return
                }
            }
        }

        for (i in pages.indices) {
            val gridLayout = pages[i]
            for (j in 0 until gridLayout.childCount) {
                val viewGroup = gridLayout.getChildAt(j) as BlissFrameLayout
                val launcherItem = getAppDetails(viewGroup)
                if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                    val folderItem = launcherItem as FolderItem
                    val items = folderItem.items!!
                    for (k in items.indices) {
                        if (items[k].itemType == Constants.ITEM_TYPE_SHORTCUT) {
                            val existingShortcutItem = items[k] as ShortcutItem
                            if (existingShortcutItem.id.equals(shortcutItem.id, ignoreCase = true)) {
                                items[k] = shortcutItem
                                folderItem.icon = GraphicsUtil(this).generateFolderIcon(this, folderItem)
                                val blissFrameLayout = prepareLauncherItem(launcherItem)
                                gridLayout.removeViewAt(j)
                                addAppToGrid(gridLayout, blissFrameLayout, j)
                                moveTo = i + 1
                                return
                            }
                        }
                    }
                } else if (launcherItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
                    val existingShortcutItem = launcherItem as ShortcutItem
                    if (existingShortcutItem.id.equals(shortcutItem.id, ignoreCase = true)) {
                        val blissFrameLayout = prepareLauncherItem(shortcutItem)
                        gridLayout.removeViewAt(j)
                        addAppToGrid(gridLayout, blissFrameLayout, j)
                        moveTo = i + 1
                        return
                    }
                }
            }
        }

        addLauncherItem(shortcutItem)
    }

    private fun removePackageFromLauncher(packageName: String, userHandle: UserHandle) {
        handleWobbling(false)
        if (mFolderWindowContainer.visibility == VISIBLE) {
            activeFolder?.items?.let {
                if (removePackageItems(it, packageName, userHandle)) {
                    updateFolder()
                }
            }
        }

        var j = 0
        while (j < mDock.childCount) {
            val appItem = getAppDetails(mDock.getChildAt(j))
            when (appItem.itemType) {
                Constants.ITEM_TYPE_FOLDER -> {
                    val folderItem = appItem as FolderItem
                    removePackageItems(folderItem.items!!, packageName, userHandle)
                    updateFolderInGrid(mDock, folderItem, j)
                    j++
                }
                Constants.ITEM_TYPE_APPLICATION, Constants.ITEM_TYPE_SHORTCUT -> {
                    if (shouldRemoveForPackage(appItem, packageName, userHandle)) {
                        mDock.removeViewAt(j)
                    } else {
                        j++
                    }
                }
                else -> j++
            }
        }

        var i = 0
        while (i < pages.size) {
            val grid = getGridFromPage(pages[i])
            var childIndex = 0
            while (childIndex < grid.childCount) {
                val launcherItem = getAppDetails(grid.getChildAt(childIndex))
                when (launcherItem.itemType) {
                    Constants.ITEM_TYPE_FOLDER -> {
                        val folderItem = launcherItem as FolderItem
                        removePackageItems(folderItem.items!!, packageName, userHandle)
                        updateFolderInGrid(grid, folderItem, childIndex)
                        childIndex++
                    }
                    Constants.ITEM_TYPE_APPLICATION, Constants.ITEM_TYPE_SHORTCUT -> {
                        if (shouldRemoveForPackage(launcherItem, packageName, userHandle)) {
                            grid.removeViewAt(childIndex)
                            if (removeEmptyPage(i, grid)) {
                                i--
                                break
                            }
                        } else {
                            childIndex++
                        }
                    }
                    else -> childIndex++
                }
            }
            i++
        }
    }

    private fun shouldRemoveForPackage(item: LauncherItem, packageName: String, userHandle: UserHandle): Boolean {
        return when (item.itemType) {
            Constants.ITEM_TYPE_APPLICATION -> {
                val app = item as ApplicationItem
                app.packageName.equals(packageName, ignoreCase = true) && app.user!!.isSameUser(userHandle)
            }
            Constants.ITEM_TYPE_SHORTCUT -> {
                val shortcutItem = item as ShortcutItem
                shortcutItem.packageName.equals(packageName, ignoreCase = true)
            }
            else -> false
        }
    }

    private fun removePackageItems(
        items: MutableList<LauncherItem>,
        packageName: String,
        userHandle: UserHandle
    ): Boolean = items.removeAll { shouldRemoveForPackage(it, packageName, userHandle) }

    private fun removeEmptyPage(pageIndex: Int, grid: GridLayout): Boolean {
        if (grid.childCount != 0) {
            return false
        }
        pages.removeAt(pageIndex)
        mHorizontalPager.removeViewAt(pageIndex + 1)
        if (pageIndex == pages.size) {
            mHorizontalPager.scrollLeft(100)
        }
        refreshPageIndicator()
        return true
    }

    private fun updateFolder() {
        mFolderAppsViewPager.adapter?.notifyDataSetChanged()
        val folder = activeFolder ?: return
        val folderView = activeFolderView ?: return
        val items = folder.items!!
        when (items.size) {
            0 -> {
                (folderView.parent as? ViewGroup)?.removeView(folderView)
                hideFolderWindowContainer()
            }
            1 -> {
                val item = items[0]
                items.remove(item)
                mFolderAppsViewPager.adapter?.notifyDataSetChanged()
                val view = prepareLauncherItem(item)

                if (folderFromDock) {
                    addAppToDock(view, mDock.indexOfChild(folderView))
                } else {
                    val gridLayout = pages[getCurrentAppsPageNumber()]
                    addAppToGrid(gridLayout, view, gridLayout.indexOfChild(folderView))
                }

                (folderView.parent as? ViewGroup)?.removeView(folderView)
                hideFolderWindowContainer()
            }
            else -> {
                updateIcon(folderView, folder, GraphicsUtil(this).generateFolderIcon(this, folder), folderFromDock)
                hideFolderWindowContainer()
            }
        }
    }

    private fun updateFolderInGrid(grid: GridLayout, folderItem: FolderItem, folderIndex: Int) {
        if (folderItem.items!!.isEmpty()) {
            grid.removeViewAt(folderIndex)
        } else {
            folderItem.icon = GraphicsUtil(this).generateFolderIcon(this, folderItem)
            val blissFrameLayout = prepareLauncherItem(folderItem)
            grid.removeViewAt(folderIndex)
            if (grid is DockGridLayout) {
                addAppToDock(blissFrameLayout, folderIndex)
            } else {
                addAppToGrid(grid, blissFrameLayout, folderIndex)
            }
        }
    }

    private fun updateOrAddApp(packageName: String, userHandle: UserHandle) {
        handleWobbling(false)
        val updatedAppItem = AppUtils.createAppItem(this, packageName, userHandle)
        if (updatedAppItem == null) {
            removePackageFromLauncher(packageName, userHandle)
            return
        }

        if (mFolderWindowContainer.visibility == VISIBLE) {
            for (i in 0 until mFolderAppsViewPager.childCount) {
                val gridLayout = mFolderAppsViewPager.getChildAt(i) as GridLayout
                for (j in 0 until gridLayout.childCount) {
                    val viewGroup = gridLayout.getChildAt(j) as BlissFrameLayout
                    val existingItem = getAppDetails(viewGroup)
                    if (existingItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
                        val existingAppItem = existingItem as ApplicationItem
                        if (existingAppItem.packageName.equals(packageName, ignoreCase = true) &&
                            existingAppItem.user!!.isSameUser(userHandle)
                        ) {
                            val blissFrameLayout = prepareLauncherItem(updatedAppItem)
                            val iconLayoutParams = GridLayout.LayoutParams()
                            iconLayoutParams.height = mDeviceProfile.cellHeightPx
                            iconLayoutParams.width = mDeviceProfile.cellWidthPx
                            gridLayout.removeViewAt(j)
                            gridLayout.addView(blissFrameLayout, j, iconLayoutParams)
                            return
                        }
                    }
                }
            }
        }

        for (i in 0 until mDock.childCount) {
            val viewGroup = mDock.getChildAt(i) as BlissFrameLayout
            val existingAppItem = getAppDetails(viewGroup)
            if (existingAppItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                val folderItem = existingAppItem as FolderItem
                val items = folderItem.items!!
                for (k in items.indices) {
                    if (items[k].itemType == Constants.ITEM_TYPE_APPLICATION) {
                        val applicationItem = items[k] as ApplicationItem
                        if (applicationItem.packageName.equals(packageName, ignoreCase = true) &&
                            applicationItem.user!!.isSameUser(userHandle)
                        ) {
                            items[k] = updatedAppItem
                            folderItem.icon = GraphicsUtil(this).generateFolderIcon(this, folderItem)
                            val blissFrameLayout = prepareLauncherItem(existingAppItem)
                            mDock.removeViewAt(i)
                            addAppToDock(blissFrameLayout, i)
                            return
                        }
                    }
                }
            } else if (existingAppItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
                val applicationItem = existingAppItem as ApplicationItem
                if (applicationItem.packageName.equals(packageName, ignoreCase = true) &&
                    applicationItem.user!!.isSameUser(userHandle)
                ) {
                    val blissFrameLayout = prepareLauncherItem(updatedAppItem)
                    mDock.removeViewAt(i)
                    addAppToDock(blissFrameLayout, i)
                    return
                }
            }
        }

        for (i in pages.indices) {
            val gridLayout = pages[i]
            for (j in 0 until gridLayout.childCount) {
                val viewGroup = gridLayout.getChildAt(j) as BlissFrameLayout
                val existingAppItem = getAppDetails(viewGroup)
                if (existingAppItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                    val folderItem = existingAppItem as FolderItem
                    val items = folderItem.items!!
                    for (k in items.indices) {
                        if (items[k].itemType == Constants.ITEM_TYPE_APPLICATION) {
                            val applicationItem = items[k] as ApplicationItem
                            if (applicationItem.packageName.equals(packageName, ignoreCase = true) &&
                                applicationItem.user!!.isSameUser(userHandle)
                            ) {
                                items[k] = updatedAppItem
                                folderItem.icon = GraphicsUtil(this).generateFolderIcon(this, folderItem)
                                val blissFrameLayout = prepareLauncherItem(existingAppItem)
                                gridLayout.removeViewAt(j)
                                addAppToGrid(gridLayout, blissFrameLayout, j)
                                moveTo = i + 1
                                return
                            }
                        }
                    }
                } else if (existingAppItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
                    val applicationItem = existingAppItem as ApplicationItem
                    if (applicationItem.packageName.equals(packageName, ignoreCase = true) &&
                        applicationItem.user!!.isSameUser(userHandle)
                    ) {
                        val blissFrameLayout = prepareLauncherItem(updatedAppItem)
                        gridLayout.removeViewAt(j)
                        addAppToGrid(gridLayout, blissFrameLayout, j)
                        moveTo = i + 1
                        return
                    }
                }
            }
        }

        addLauncherItem(updatedAppItem)
    }

    fun showApps(launcherItems: List<LauncherItem>) {
        mProgressBar.visibility = GONE
        if (isWobbling) {
            handleWobbling(false)
        }
        createUI(launcherItems)
        isUiDone = true
        createPageChangeListener()
        createFolderTitleListener()
        createDragListener()
        createWidgetsPage()
        createIndicator()
        createOrUpdateBadgeCount()
        allAppsDisplayed = true
        subscribeToEvents()
    }

    private fun subscribeToEvents() {
        events = EventRelay.getInstance()
        events?.subscribe(EventsObserverImpl(this))
    }

    private fun createOrUpdateBadgeCount() {
        mAppsWithNotifications = emptySet()
        updateBadges(mAppsWithNotifications)
    }

    private fun updateBadges(appsWithNotifications: Set<String>) {
        if (mFolderWindowContainer.visibility == VISIBLE) {
            for (i in 0 until mFolderAppsViewPager.childCount) {
                val gridLayout = mFolderAppsViewPager.getChildAt(i) as GridLayout
                for (j in 0 until gridLayout.childCount) {
                    val viewGroup = gridLayout.getChildAt(j) as BlissFrameLayout
                    val appItem = getAppDetails(viewGroup)
                    if (appItem.itemType != Constants.ITEM_TYPE_SHORTCUT) {
                        updateBadgeToApp(viewGroup, appItem, appsWithNotifications, true)
                    }
                }
            }
        }
        for (gridLayout in pages) {
            for (j in 0 until gridLayout.childCount) {
                val viewGroup = gridLayout.getChildAt(j) as BlissFrameLayout
                val appItem = getAppDetails(viewGroup)
                if (appItem.itemType != Constants.ITEM_TYPE_SHORTCUT) {
                    updateBadgeToApp(viewGroup, appItem, appsWithNotifications, true)
                }
            }
        }

        for (i in 0 until mDock.childCount) {
            val viewGroup = mDock.getChildAt(i) as BlissFrameLayout
            val appItem = getAppDetails(viewGroup)
            if (appItem.itemType != Constants.ITEM_TYPE_SHORTCUT) {
                updateBadgeToApp(viewGroup, appItem, appsWithNotifications, false)
            }
        }
    }

    private fun updateBadgeToApp(
        viewGroup: BlissFrameLayout,
        appItem: LauncherItem,
        appsWithNotifications: Set<String>,
        withText: Boolean
    ) {
        if (appItem.itemType == Constants.ITEM_TYPE_FOLDER) {
            viewGroup.applyBadge(checkHasApp(appItem as FolderItem, appsWithNotifications), withText)
        } else {
            val applicationItem = appItem as ApplicationItem
            viewGroup.applyBadge(appsWithNotifications.contains(applicationItem.packageName), withText)
        }
    }

    private fun checkHasApp(appItem: FolderItem, packages: Set<String>): Boolean {
        for (item in appItem.items!!) {
            if (item.itemType == Constants.ITEM_TYPE_APPLICATION) {
                val applicationItem = item as ApplicationItem
                if (packages.contains(applicationItem.packageName)) {
                    return true
                }
            }
        }
        return false
    }

    private fun createFolderTitleListener() {
        mFolderTitleInput.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(v)
            }
            mFolderTitleInput.isCursorVisible = true
        }
        mFolderTitleInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                updateFolderTitle()
            }
            false
        }
        mFolderTitleInput.setOnClickListener { mFolderTitleInput.isCursorVisible = true }
        mFolderWindowContainer.setOnClickListener { returnToHomeScreen() }
    }

    fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun showKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        view.post {
            inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    private fun updateFolderTitle() {
        val updatedTitle = mFolderTitleInput.text.toString()
        val folder = activeFolder ?: return
        val folderView = activeFolderView ?: return
        folder.title = updatedTitle
        val tags = folderView.tag as List<*>
        (tags[1] as TextView).text = updatedTitle
        mFolderTitleInput.setText(updatedTitle)
        mFolderTitleInput.isCursorVisible = false
    }

    private fun createPageChangeListener() {
        val navbarAnimator = createNavbarColorAnimator()

        mHorizontalPager.addOnScrollListener(object : HorizontalPager.OnScrollListener {
            var isViewScrolling = true

            override fun onScroll(scrollX: Int) {
                updatePageIndicatorScroll(scrollX)

                var progress = scrollX.toFloat() / mDeviceProfile.availableWidthPx
                if (progress >= 0.999f) {
                    progress = 1f
                }
                if (progress <= 0.001f) {
                    progress = 0f
                }
                val dockHeight = mDock.height + mIndicator.height
                val dockTranslationY = (1 - progress) * dockHeight
                mDock.translationY = dockTranslationY
                mIndicator.translationY = dockTranslationY

                if (scrollX >= 0 && scrollX < mDeviceProfile.availableWidthPx) {
                    val fraction = (mDeviceProfile.availableWidthPx - scrollX).toFloat() /
                        mDeviceProfile.availableWidthPx
                    blurLayer.alpha = fraction
                }
                if (isViewScrolling) {
                    dragDropEnabled = false
                }
            }

            override fun onViewScrollFinished(page: Int) {
                isViewScrolling = false

                blurLayer.alpha = if (page == 0 || mFolderWindowContainer.visibility == VISIBLE) 1f else 0f

                if (currentPageNumber != page) {
                    val prevPage = currentPageNumber
                    currentPageNumber = page
                    navbarAnimator.cancel()
                    if (currentPageNumber == WIDGET_PAGE) {
                        navbarAnimator.start()
                        widgetsPage?.let { refreshSuggestedApps(it, forceRefreshSuggestedApps) }
                        mInsetsController.hide(WindowInsetsCompat.Type.statusBars())
                    } else if (prevPage == WIDGET_PAGE && currentPageNumber == 1) {
                        mInsetsController.show(WindowInsetsCompat.Type.statusBars())
                        navbarAnimator.reverse()
                    } else {
                        mInsetsController.show(WindowInsetsCompat.Type.statusBars())
                    }

                    dragDropEnabled = true
                    updateWorkspaceChromeForPage(currentPageNumber)
                    showPageIndicator(currentPageNumber)
                }
                if (page == WIDGET_PAGE) {
                    hideWidgetPageIndicator()
                }
            }
        })
    }

    private fun createNavbarColorAnimator(): ValueAnimator {
        val navColor = window.navigationBarColor
        val colorAnimation = ValueAnimator.ofObject(
            ArgbEvaluator(),
            navColor,
            ColorUtils.setAlphaComponent(navColor, 160)
        )

        colorAnimation.duration = 400
        colorAnimation.interpolator = LinearInterpolator()
        colorAnimation.addUpdateListener { animator ->
            window.navigationBarColor = animator.animatedValue as Int
        }

        return colorAnimation
    }

    fun refreshSuggestedApps(viewGroup: ViewGroup, forceRefresh: Boolean) {
        val openUsageAccessSettingsTv = viewGroup.findViewById<TextView?>(R.id.openUsageAccessSettings)
        val suggestedAppsGridLayout = viewGroup.findViewById<GridLayout?>(R.id.suggestedAppGrid)
        if (!SuggestedAppsViewPolicy.hasRequiredViews(openUsageAccessSettingsTv, suggestedAppsGridLayout)) {
            return
        }
        val openUsageAccessSettings = openUsageAccessSettingsTv ?: return
        val suggestedAppsGrid = suggestedAppsGridLayout ?: return

        val suggestedApps = fallbackSuggestedApps(LauncherSearchResultPolicy.EMPTY_QUERY_SUGGESTION_LIMIT)

        if (suggestedApps.isEmpty()) {
            openUsageAccessSettings.visibility = VISIBLE
            suggestedAppsGrid.visibility = GONE
            mSuggestedApps = ArrayList()
            return
        }

        openUsageAccessSettings.visibility = GONE
        suggestedAppsGrid.visibility = VISIBLE

        if (!forceRefresh && suggestedApps == mSuggestedApps) {
            return
        }

        suggestedAppsGrid.removeAllViews()
        suggestedAppsGrid.columnCount = LauncherSearchResultPolicy.GRID_COLUMNS
        suggestedAppsGrid.rowCount = LauncherSearchResultPolicy.rowCountFor(suggestedApps.size)
        suggestedApps.map { prepareSuggestedApp(it) }.forEach { addAppToGrid(suggestedAppsGrid, it) }
        mSuggestedApps = suggestedApps
        forceRefreshSuggestedApps = false
    }

    private fun fallbackSuggestedApps(limit: Int): List<ApplicationItem> {
        val apps = LinkedHashMap<String, ApplicationItem>()

        fun addLauncherItem(item: LauncherItem) {
            when (item.itemType) {
                Constants.ITEM_TYPE_APPLICATION -> apps.putIfAbsent(item.id, item as ApplicationItem)
                Constants.ITEM_TYPE_FOLDER -> (item as FolderItem).items.orEmpty().forEach { addLauncherItem(it) }
            }
        }

        if (::mDock.isInitialized) {
            for (i in 0 until mDock.childCount) {
                (mDock.getChildAt(i) as? BlissFrameLayout)?.launcherItem?.let(::addLauncherItem)
            }
        }

        pages.forEach { page ->
            for (i in 0 until page.childCount) {
                (page.getChildAt(i) as? BlissFrameLayout)?.launcherItem?.let(::addLauncherItem)
            }
        }

        return apps.values.take(limit)
    }

    private fun createUI(launcherItems: List<LauncherItem>) {
        mHorizontalPager.setUiCreated(false)
        mDock.isEnabled = false
        val autoArrangeApps = isAutoRearrangeAppsEnabled()

        pages = ArrayList()

        var hotseatCell = 0

        var workspaceScreen = preparePage()
        pages.add(workspaceScreen)

        mHorizontalPager.removeAllViews()
        mDock.removeAllViews()
        appLibraryPage = null

        for (launcherItem in launcherItems) {
            val appView = prepareLauncherItem(launcherItem)
            if (launcherItem.container == Constants.CONTAINER_HOTSEAT.toLong()) {
                addAppToDock(appView, launcherItem.cell)
                if (launcherItem.cell == -1) {
                    launcherItem.cell = hotseatCell
                    hotseatCell++
                } else {
                    hotseatCell = launcherItem.cell
                }
            } else if (launcherItem.container == Constants.CONTAINER_DESKTOP.toLong()) {
                if (autoArrangeApps) {
                    if (workspaceScreen.childCount >= mDeviceProfile.maxAppsPerPage ||
                        launcherItem.screenId > pages.size - 1
                    ) {
                        workspaceScreen = preparePage()
                        pages.add(workspaceScreen)
                    }
                    launcherItem.screenId = (pages.size - 1).toLong()
                    launcherItem.cell = workspaceScreen.childCount
                } else {
                    val pageIndex = launcherItem.screenId.toInt().coerceAtLeast(0)
                    val placement = LauncherHomeCellPolicy.resolvePageCell(
                        preferredPage = pageIndex,
                        preferredCell = launcherItem.cell,
                        occupiedCellsByPage = occupiedHomeCellsByPage(),
                        maxCells = mDeviceProfile.maxAppsPerPage
                    )
                    workspaceScreen = ensureHomePage(placement.page)
                    launcherItem.screenId = placement.page.toLong()
                    launcherItem.cell = placement.cell
                }
                addAppToGrid(workspaceScreen, appView)
            }
        }

        for (page in pages) {
            relayoutHomePageCells(page)
            mHorizontalPager.addView(page)
        }
        appLibraryApps = collectAppLibraryApps(launcherItems)
        createAppLibraryPage()
        currentPageNumber = 0

        mHorizontalPager.setUiCreated(true)
        mDock.isEnabled = true
        setUpSwipeSearchContainer()
    }

    private fun ensureHomePage(pageIndex: Int): GridLayout {
        val safePageIndex = pageIndex.coerceAtLeast(0)
        while (pages.size <= safePageIndex) {
            pages.add(preparePage())
        }
        return pages[safePageIndex]
    }

    private fun addHomePageToPager(page: GridLayout) {
        val libraryPage = appLibraryPage
        val libraryIndex = if (libraryPage != null) {
            mHorizontalPager.indexOfChild(libraryPage)
        } else {
            -1
        }
        if (libraryIndex >= 0) {
            mHorizontalPager.addView(page, libraryIndex)
        } else {
            mHorizontalPager.addView(page)
        }
    }

    @SuppressLint("InflateParams")
    private fun preparePage(): GridLayout {
        val grid = layoutInflater.inflate(R.layout.apps_page, null) as GridLayout
        grid.rowCount = mDeviceProfile.numRows
        grid.columnCount = mDeviceProfile.numColumns
        grid.layoutTransition = getDefaultLayoutTransition()
        applyHomePageGridPadding(grid, isWobbling)

        grid.setOnClickListener {
            if (!isWobbling) {
                dismissLauncherOptionsPopup()
            }
        }
        grid.setOnLongClickListener { handleEmptyHomeAreaLongPress() }

        return grid
    }

    private fun applyHomePageGridPadding(grid: GridLayout, editing: Boolean) {
        grid.setPadding(
            mDeviceProfile.iconDrawablePaddingPx / 2,
            dp(LauncherHomeLayoutPreferences.homePageTopPaddingDp(editing)),
            mDeviceProfile.iconDrawablePaddingPx / 2,
            0
        )
    }

    private fun handleEmptyHomeAreaLongPress(): Boolean {
        val searchVisible = ::swipeSearchContainer.isInitialized && swipeSearchContainer.visibility == VISIBLE
        val folderVisible = ::mFolderWindowContainer.isInitialized && mFolderWindowContainer.visibility == VISIBLE
        if (!LauncherEditModeEntryPolicy.shouldEnterEditModeFromEmptyAreaLongPress(
                isEditing = isWobbling,
                searchVisible = searchVisible,
                folderVisible = folderVisible
            )
        ) {
            return false
        }

        handleWobbling(true)
        return true
    }

    private fun createWidgetsPage() {
        widgetsPage = layoutInflater.inflate(R.layout.widgets_page, mHorizontalPager, false) as FrameLayout
        val page = widgetsPage ?: return
        page.clipChildren = false
        page.clipToPadding = false
        widgetContainer = page.findViewById(R.id.widget_container)
        val todayWidgetDragListener = View.OnDragListener { source, event ->
            handleTodayWidgetDragEvent(source, event)
        }
        page.findViewById<ViewGroup?>(R.id.drag_layer)?.apply {
            clipChildren = false
            clipToPadding = false
            setOnDragListener(todayWidgetDragListener)
        }
        page.findViewById<ViewGroup?>(R.id.widgets_scroll_container)?.apply {
            clipChildren = false
            clipToPadding = false
        }
        loadTodayQuickWidgets()
        renderTodayWidgets()
        mHorizontalPager.addView(page, 0)
        page.setOnDragListener(todayWidgetDragListener)
        val scrollView = page.findViewById<ScrollView>(R.id.widgets_scroll_container)
        scrollView.setOnTouchListener { _, _ ->
            if (page.findViewById<View>(R.id.widget_resizer_container).visibility == VISIBLE) {
                hideWidgetResizeContainer()
            }
            false
        }
        currentPageNumber = 1
        mHorizontalPager.setCurrentPage(currentPageNumber)

        widgetContainer.setOnDragListener(todayWidgetDragListener)

        page.findViewById<View?>(R.id.edit_widgets_button)?.setOnClickListener {
            setTodayWidgetEditing(true)
        }
        page.findViewById<View?>(R.id.add_today_widget_button)?.setOnClickListener {
            showTodayWidgetPicker()
        }
        page.findViewById<View?>(R.id.done_today_widget_edit_button)?.setOnClickListener {
            setTodayWidgetEditing(false)
        }

        if (WeatherUtils.isWeatherServiceAvailable(this)) {
            startService(Intent(this, WeatherSourceListenerService::class.java))
            startService(Intent(this, DeviceStatusService::class.java))
        }

        if (Preferences.useCustomWeatherLocation(this)) {
            startService(
                Intent(this, WeatherUpdateService::class.java)
                    .setAction(WeatherUpdateService.ACTION_FORCE_UPDATE)
            )
        }

        rebindWidgetHost()
    }

    private fun createAppLibraryPage() {
        val page = ScrollView(this).apply {
            isFillViewport = true
            overScrollMode = View.OVER_SCROLL_NEVER
            clipToPadding = false
        }
        appLibraryPage = page
        bindAppLibraryPage(page)
        mHorizontalPager.addView(page)
    }

    private fun refreshAppLibraryPage() {
        appLibraryPage?.let { page -> bindAppLibraryPage(page) }
    }

    private fun bindAppLibraryPage(page: ScrollView) {
        page.removeAllViews()
        val groups = AppLibraryCategoryPolicy.buildGroups(
            apps = appLibraryApps,
            savedCategories = readSavedAppCategories(),
            appInfo = { app -> app.toAppLibraryPolicyApp() }
        )
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            clipToPadding = false
            setPadding(dp(32), dp(46), dp(32), dp(28))
        }
        content.addView(createAppLibrarySearchPill())
        groups.chunked(APP_LIBRARY_COLUMNS).forEach { rowGroups ->
            content.addView(createAppLibraryRow(rowGroups))
        }
        page.addView(
            content,
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )
    }

    private fun createAppLibrarySearchPill(): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            background = roundedRectangle(LauncherLiquidGlassStylePolicy.searchPill(liquidGlassEnabled))
            isClickable = true
            isFocusable = true
            setOnClickListener { showAppLibrarySearchOverlay() }
            addView(
                ImageView(context).apply {
                    setImageResource(R.drawable.ic_search_18)
                    setColorFilter(Color.WHITE)
                    contentDescription = null
                },
                LinearLayout.LayoutParams(dp(18), dp(18))
            )
            addView(
                TextView(context).apply {
                    text = APP_LIBRARY_TITLE
                    setTextColor(Color.WHITE)
                    textSize = 17f
                    gravity = Gravity.CENTER
                },
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    marginStart = dp(7)
                }
            )
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dp(44)
            ).apply {
                bottomMargin = dp(14)
            }
        }
    }

    private fun createAppLibraryRow(groups: List<AppLibraryGroup<ApplicationItem>>): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            groups.forEachIndexed { index, group ->
                addView(
                    createAppLibraryGroupView(group),
                    LinearLayout.LayoutParams(0, dp(196), 1f).apply {
                        marginStart = if (index == 0) 0 else dp(10)
                        marginEnd = if (index == 0) dp(10) else 0
                    }
                )
            }
            if (groups.size < APP_LIBRARY_COLUMNS) {
                addView(
                    View(context),
                    LinearLayout.LayoutParams(0, dp(196), 1f).apply {
                        marginStart = dp(10)
                    }
                )
            }
        }
    }

    private fun createAppLibraryGroupView(group: AppLibraryGroup<ApplicationItem>): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            setPadding(dp(0), 0, dp(0), 0)

            val folderCard = FrameLayout(context).apply {
                background = roundedRectangle(
                    LauncherLiquidGlassStylePolicy.appLibraryFolder(
                        enabled = liquidGlassEnabled,
                        empty = group.apps.isEmpty()
                    )
                )
                clipToOutline = true
                isClickable = group.apps.isNotEmpty()
                isFocusable = group.apps.isNotEmpty()
                if (group.apps.isNotEmpty()) {
                    setOnClickListener { showAppLibraryCategory(group) }
                }
                addView(
                    createAppLibraryPreviewGrid(group),
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                )
            }
            addView(
                folderCard,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dp(166)
                )
            )
            addView(
                TextView(context).apply {
                    text = group.category.displayName
                    setTextColor(Color.WHITE)
                    setShadowLayer(3f, 0f, 1f, 0xA0000000.toInt())
                    textSize = 14f
                    gravity = Gravity.CENTER
                    maxLines = 1
                    ellipsize = TextUtils.TruncateAt.END
                },
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dp(24)
                )
            )
        }
    }

    private fun createAppLibraryPreviewGrid(group: AppLibraryGroup<ApplicationItem>): View {
        return GridLayout(this).apply {
            rowCount = 2
            columnCount = 2
            setPadding(dp(12), dp(12), dp(12), dp(12))
            repeat(APP_LIBRARY_PREVIEW_SLOTS) { slot ->
                addView(createAppLibraryPreviewSlot(group, slot), appLibraryPreviewLayoutParams())
            }
        }
    }

    private fun createAppLibraryPreviewSlot(
        group: AppLibraryGroup<ApplicationItem>,
        slot: Int
    ): View {
        return FrameLayout(this).apply {
            addView(
                when (AppLibraryPreviewPolicy.previewSlotContent(group.apps.size, slot)) {
                    AppLibraryPreviewPolicy.SlotContent.OVERFLOW_CLUSTER -> {
                        createAppLibraryOverflowPreview(AppLibraryPreviewPolicy.overflowPreviewApps(group.apps))
                    }

                    AppLibraryPreviewPolicy.SlotContent.LARGE_ICON -> {
                        createAppLibraryPreviewIcon(group.apps.getOrNull(slot))
                    }
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }
    }

    private fun createAppLibraryPreviewIcon(app: ApplicationItem?): View {
        return ImageView(this).apply {
            visibility = if (app == null) View.INVISIBLE else VISIBLE
            setImageDrawable(app?.icon)
            contentDescription = app?.title?.toString()
            scaleType = ImageView.ScaleType.FIT_CENTER
            if (app != null) {
                isClickable = true
                isFocusable = true
                setOnClickListener { view -> startActivitySafely(applicationContext, app, view) }
            }
        }
    }

    private fun createAppLibraryOverflowPreview(apps: List<ApplicationItem>): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            repeat(2) { row ->
                addView(
                    LinearLayout(context).apply {
                        orientation = LinearLayout.HORIZONTAL
                        repeat(2) { column ->
                            val app = apps.getOrNull(row * 2 + column)
                            addView(
                                ImageView(context).apply {
                                    visibility = if (app == null) View.INVISIBLE else VISIBLE
                                    setImageDrawable(app?.icon)
                                    contentDescription = app?.title?.toString()
                                    scaleType = ImageView.ScaleType.FIT_CENTER
                                    if (app != null) {
                                        isClickable = true
                                        isFocusable = true
                                        setOnClickListener { view -> startActivitySafely(applicationContext, app, view) }
                                    }
                                },
                                appLibraryOverflowLayoutParams()
                            )
                        }
                    },
                    LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        0,
                        1f
                    )
                )
            }
        }
    }

    private fun showAppLibraryCategory(group: AppLibraryGroup<ApplicationItem>) {
        if (group.apps.isEmpty()) return
        hideAppLibrarySearchOverlay(animated = false)
        hideAppLibraryDetailOverlay(animated = false)

        val overlay = FrameLayout(this).apply {
            alpha = 0f
            isClickable = true
            isFocusable = true
            setOnClickListener { hideAppLibraryDetailOverlay(animated = true) }
        }
        appLibraryDetailOverlay = overlay

        overlay.addView(
            BlurBackgroundView(this, null),
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )

        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(18), dp(286), dp(18), dp(28))
            isClickable = true
            isFocusable = true
        }
        content.addView(
            TextView(this).apply {
                text = group.category.displayName
                setTextColor(Color.WHITE)
                textSize = 28f
                gravity = Gravity.START
            },
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                bottomMargin = dp(12)
            }
        )
        content.addView(createAppLibraryDetailGrid(group.apps))

        overlay.addView(
            content,
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.TOP
            )
        )

        (mLauncherView as ViewGroup).addView(
            overlay,
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        overlay.animate()
            .alpha(1f)
            .setDuration(160L)
            .start()
    }

    private fun createAppLibraryDetailGrid(apps: List<ApplicationItem>): View {
        return GridLayout(this).apply {
            columnCount = APP_LIBRARY_DIALOG_COLUMNS
            apps.forEach { app ->
                addView(createAppLibraryDetailAppView(app), appLibraryDetailAppLayoutParams())
            }
        }
    }

    private fun createAppLibraryDetailAppView(app: ApplicationItem): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            isClickable = true
            isFocusable = true
            setOnClickListener { view ->
                startActivitySafely(applicationContext, app, view)
                hideAppLibraryDetailOverlay(animated = false)
            }
            addView(
                ImageView(context).apply {
                    setImageDrawable(app.icon)
                    contentDescription = app.title?.toString()
                    scaleType = ImageView.ScaleType.FIT_CENTER
                },
                LinearLayout.LayoutParams(dp(64), dp(64))
            )
            addView(
                TextView(context).apply {
                    text = app.title?.toString().orEmpty()
                    setTextColor(Color.WHITE)
                    setShadowLayer(3f, 0f, 1f, 0xA0000000.toInt())
                    textSize = 13f
                    gravity = Gravity.CENTER
                    maxLines = 1
                    ellipsize = TextUtils.TruncateAt.END
                },
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )
        }
    }

    private fun appLibraryDetailAppLayoutParams(): GridLayout.LayoutParams {
        return GridLayout.LayoutParams().apply {
            width = ((mDeviceProfile.availableWidthPx - dp(36)) / APP_LIBRARY_DIALOG_COLUMNS)
                .coerceAtLeast(dp(72))
            height = dp(96)
            setMargins(0, 0, 0, dp(4))
        }
    }

    private fun hideAppLibraryDetailOverlay(animated: Boolean) {
        val overlay = appLibraryDetailOverlay ?: return
        appLibraryDetailOverlay = null
        overlay.animate().cancel()
        val removeOverlay = {
            (overlay.parent as? ViewGroup)?.removeView(overlay)
            Unit
        }
        if (animated) {
            overlay.animate()
                .alpha(0f)
                .setDuration(140L)
                .withEndAction { removeOverlay() }
                .start()
        } else {
            removeOverlay()
        }
    }

    private fun appLibraryPreviewLayoutParams(): GridLayout.LayoutParams {
        return GridLayout.LayoutParams(
            GridLayout.spec(GridLayout.UNDEFINED, 1f),
            GridLayout.spec(GridLayout.UNDEFINED, 1f)
        ).apply {
            width = 0
            height = 0
            setMargins(dp(5), dp(5), dp(5), dp(5))
        }
    }

    private fun appLibraryOverflowLayoutParams(): LinearLayout.LayoutParams {
        return LinearLayout.LayoutParams(
            0,
            ViewGroup.LayoutParams.MATCH_PARENT,
            1f
        ).apply {
            setMargins(dp(1), dp(1), dp(1), dp(1))
        }
    }

    private fun showAppLibrarySearchOverlay() {
        if (appLibrarySearchOverlay != null) return
        hideAppLibraryDetailOverlay(animated = false)
        dismissLauncherOptionsPopup()
        appLibrarySearchQuery = ""
        appLibrarySearchSectionFilter = null

        val overlay = FrameLayout(this).apply {
            alpha = 0f
            isClickable = true
            isFocusable = true
        }
        appLibrarySearchOverlay = overlay

        overlay.addView(
            BlurBackgroundView(this, null),
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )

        val topRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(36), 0, dp(28), 0)
        }
        val searchField = createAppLibrarySearchField()
        val cancelButton = TextView(this).apply {
            text = "Hủy"
            setTextColor(Color.WHITE)
            textSize = 16f
            gravity = Gravity.CENTER
            isClickable = true
            isFocusable = true
            setOnClickListener { hideAppLibrarySearchOverlay(animated = true) }
        }
        topRow.addView(
            searchField,
            LinearLayout.LayoutParams(0, dp(44), 1f)
        )
        topRow.addView(
            cancelButton,
            LinearLayout.LayoutParams(dp(58), dp(44)).apply {
                marginStart = dp(14)
            }
        )
        overlay.addView(
            topRow,
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dp(44),
                Gravity.TOP
            ).apply {
                topMargin = dp(84)
            }
        )

        val resultsContainer = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            clipToPadding = false
            setPadding(0, 0, dp(34), dp(28))
        }
        appLibrarySearchResultsContainer = resultsContainer
        overlay.addView(
            ScrollView(this).apply {
                overScrollMode = View.OVER_SCROLL_NEVER
                clipToPadding = false
                addView(
                    resultsContainer,
                    ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                )
            },
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            ).apply {
                topMargin = dp(146)
            }
        )
        overlay.addView(
            createAppLibrarySearchIndex(),
            FrameLayout.LayoutParams(
                dp(30),
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.END or Gravity.TOP
            ).apply {
                topMargin = dp(136)
                rightMargin = dp(4)
            }
        )

        (mLauncherView as ViewGroup).addView(
            overlay,
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        renderAppLibrarySearchResults()
        overlay.animate().alpha(1f).setDuration(150L).start()
        searchField.post {
            searchField.pivotX = searchField.width.toFloat()
            searchField.translationX = dp(48).toFloat()
            searchField.scaleX = 1.12f
            searchField.animate()
                .translationX(0f)
                .scaleX(1f)
                .setDuration(220L)
                .setInterpolator(DecelerateInterpolator())
                .start()
        }
        appLibrarySearchInput?.postDelayed({
            appLibrarySearchInput?.requestFocus()
            appLibrarySearchInput?.let { showKeyboard(it) }
        }, 180L)
    }

    private fun createAppLibrarySearchField(): LinearLayout {
        val editText = EditText(this).apply {
            hint = APP_LIBRARY_TITLE
            setTextColor(Color.WHITE)
            setHintTextColor(0xCCFFFFFF.toInt())
            textSize = 16f
            setSingleLine(true)
            inputType = InputType.TYPE_CLASS_TEXT
            imeOptions = EditorInfo.IME_ACTION_SEARCH
            background = null
            setPadding(0, 0, 0, 0)
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    appLibrarySearchQuery = s?.toString().orEmpty()
                    appLibrarySearchSectionFilter = null
                    renderAppLibrarySearchResults()
                }

                override fun afterTextChanged(s: Editable?) = Unit
            })
        }
        appLibrarySearchInput = editText

        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = roundedRectangle(LauncherLiquidGlassStylePolicy.searchField(liquidGlassEnabled))
            setPadding(dp(10), 0, dp(12), 0)
            addView(
                ImageView(context).apply {
                    setImageResource(R.drawable.ic_search_18)
                    setColorFilter(Color.WHITE)
                    contentDescription = null
                },
                LinearLayout.LayoutParams(dp(18), dp(18))
            )
            addView(
                editText,
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f).apply {
                    marginStart = dp(7)
                }
            )
        }
    }

    private fun createAppLibrarySearchIndex(): LinearLayout {
        val policyApps = appLibraryApps.map { app -> app.toAppLibraryPolicyApp() }
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            AppLibrarySearchPolicy.indexLabels(policyApps).forEach { label ->
                addView(
                    TextView(context).apply {
                        text = label
                        setTextColor(Color.WHITE)
                        textSize = 11f
                        gravity = Gravity.CENTER
                        isClickable = true
                        isFocusable = true
                        setOnClickListener {
                            appLibrarySearchSectionFilter = label
                            renderAppLibrarySearchResults()
                        }
                    },
                    LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        dp(13)
                    )
                )
            }
        }
    }

    private fun renderAppLibrarySearchResults() {
        val container = appLibrarySearchResultsContainer ?: return
        container.removeAllViews()
        val appById = appLibraryApps.associateBy { app -> app.id }
        val sections = AppLibrarySearchPolicy.sections(
            apps = appLibraryApps.map { app -> app.toAppLibraryPolicyApp() },
            query = appLibrarySearchQuery,
            sectionFilter = appLibrarySearchSectionFilter
        )
        val showSectionHeaders = appLibrarySearchQuery.isBlank()

        sections.forEach { section ->
            if (showSectionHeaders) {
                container.addView(createAppLibrarySearchSectionHeader(section.label))
            }
            section.apps.forEach { appInfo ->
                appById[appInfo.id]?.let { app ->
                    container.addView(createAppLibrarySearchResultRow(app))
                    container.addView(createAppLibrarySearchDivider())
                }
            }
        }
    }

    private fun createAppLibrarySearchSectionHeader(label: String): View {
        return TextView(this).apply {
            text = label
            setTextColor(Color.WHITE)
            textSize = 18f
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(36), dp(8), 0, 0)
            typeface = android.graphics.Typeface.DEFAULT_BOLD
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dp(44)
            )
        }
    }

    private fun createAppLibrarySearchResultRow(app: ApplicationItem): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(38), dp(7), dp(28), dp(7))
            isClickable = true
            isFocusable = true
            setOnClickListener { view ->
                startActivitySafely(applicationContext, app, view)
                hideAppLibrarySearchOverlay(animated = false)
            }
            addView(
                ImageView(context).apply {
                    setImageDrawable(app.icon)
                    contentDescription = app.title?.toString()
                    scaleType = ImageView.ScaleType.FIT_CENTER
                },
                LinearLayout.LayoutParams(dp(54), dp(54))
            )
            addView(
                TextView(context).apply {
                    text = app.title?.toString().orEmpty()
                    setTextColor(Color.WHITE)
                    textSize = 15f
                    maxLines = 1
                    ellipsize = TextUtils.TruncateAt.END
                },
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply {
                    marginStart = dp(12)
                }
            )
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dp(72)
            )
        }
    }

    private fun createAppLibrarySearchDivider(): View {
        return View(this).apply {
            setBackgroundColor(0x33FFFFFF)
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                1
            ).apply {
                marginStart = dp(108)
                marginEnd = dp(34)
            }
        }
    }

    private fun hideAppLibrarySearchOverlay(animated: Boolean) {
        val overlay = appLibrarySearchOverlay ?: return
        appLibrarySearchOverlay = null
        val input = appLibrarySearchInput
        if (input != null) {
            hideKeyboard(input)
        }
        appLibrarySearchInput = null
        appLibrarySearchResultsContainer = null
        appLibrarySearchQuery = ""
        appLibrarySearchSectionFilter = null
        overlay.animate().cancel()
        val removeOverlay = {
            (overlay.parent as? ViewGroup)?.removeView(overlay)
            Unit
        }
        if (animated) {
            overlay.animate()
                .alpha(0f)
                .setDuration(140L)
                .withEndAction { removeOverlay() }
                .start()
        } else {
            removeOverlay()
        }
    }

    private fun collectAppLibraryApps(items: List<LauncherItem>): List<ApplicationItem> {
        val appsById = linkedMapOf<String, ApplicationItem>()
        fun collect(item: LauncherItem) {
            when (item.itemType) {
                Constants.ITEM_TYPE_APPLICATION -> appsById[item.id] = item as ApplicationItem
                Constants.ITEM_TYPE_FOLDER -> (item as FolderItem).items.orEmpty().forEach(::collect)
            }
        }
        items.forEach(::collect)
        return appsById.values.toList()
    }

    private fun readSavedAppCategories(): Map<String, String> {
        val preferences = getSharedPreferences(APP_LIBRARY_PREF_NAME, Context.MODE_PRIVATE)
        return preferences.all
            .mapNotNull { (key, value) ->
                if (!key.startsWith(APP_LIBRARY_CATEGORY_PREFIX)) return@mapNotNull null
                val category = value as? String ?: return@mapNotNull null
                key.removePrefix(APP_LIBRARY_CATEGORY_PREFIX) to category
            }
            .toMap()
    }

    private fun ApplicationItem.toAppLibraryPolicyApp(): AppLibraryCategoryPolicy.App {
        return AppLibraryCategoryPolicy.App(
            id = id,
            title = title?.toString().orEmpty(),
            packageName = packageName
        )
    }

    private fun openAppLibrarySettings() {
        val intent = Intent().setClassName(
            packageName,
            APP_LIBRARY_SETTINGS_ACTIVITY
        )
        runCatching { startActivity(intent) }
            .onFailure {
                Toast.makeText(this, APP_LIBRARY_TITLE, Toast.LENGTH_SHORT).show()
            }
    }

    private fun roundedRectangle(style: LauncherLiquidGlassStylePolicy.BackgroundStyle): GradientDrawable {
        return roundedRectangle(
            color = style.color,
            radiusDp = style.radiusDp,
            strokeColor = style.strokeColor,
            strokeWidthDp = style.strokeWidthDp
        )
    }

    private fun roundedRectangle(
        color: Int,
        radiusDp: Int,
        strokeColor: Int? = null,
        strokeWidthDp: Int = 1
    ): GradientDrawable {
        return GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(radiusDp).toFloat()
            setColor(color)
            if (strokeColor != null) {
                setStroke(dp(strokeWidthDp), strokeColor)
            }
        }
    }

    private fun rebindWidgetHost() {
        val widgetIds = mAppWidgetHost.appWidgetIds
        compositeDisposableBag.add(
            DatabaseManager.getManager(this).getWidgets(widgetIds)
                .subscribeOn(Schedulers.from(AppExecutors.getInstance().diskIO()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::bindWidgets)
        )
    }

    fun rebindAllWidgets() {
        if (widgetsPage != null) {
            todayWidgetEntries.clear()
            widgetContainer.removeAllViews()
            rebindWidgetHost()
        }
    }

    private fun bindWidgets(widgets: List<WidgetItem>) {
        todayWidgetEntries.clear()
        widgetContainer.removeAllViews()
        for (widget in widgets) {
            val appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(widget.id) ?: continue

            val hostView = mAppWidgetHost.createView(applicationContext, widget.id, appWidgetInfo) as RoundedWidgetView
            hostView.setAppWidget(widget.id, appWidgetInfo)

            val widgetView = WidgetViewBuilder.create(this, hostView) ?: continue
            if (widget.height != 0) {
                val minHeight = hostView.appWidgetInfo.minResizeHeight
                val maxHeight = mDeviceProfile.availableHeightPx * 3 / 4
                val normalisedDifference = (maxHeight - minHeight) / 100
                widgetView.layoutParams.height = minHeight + (normalisedDifference * widget.height)
            }
            addWidgetToContainer(widgetView, widget)
        }
        renderTodayWidgets()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_TODAY_BIND_APPWIDGET) {
            val appWidgetId = data?.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, pendingTodayWidgetId)
                ?: pendingTodayWidgetId
            if (resultCode == RESULT_OK && appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                handleTodayWidgetBound(appWidgetId)
            } else if (appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                mAppWidgetHost.deleteAppWidgetId(appWidgetId)
                pendingTodayWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
            }
        } else if (requestCode == REQUEST_TODAY_CREATE_APPWIDGET) {
            val appWidgetId = data?.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, pendingTodayWidgetId)
                ?: pendingTodayWidgetId
            if (resultCode == RESULT_OK && appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                createTodayWidget(appWidgetId)
            } else if (appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                mAppWidgetHost.deleteAppWidgetId(appWidgetId)
                pendingTodayWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun searchForQuery(charSequence: CharSequence): ObservableSource<SuggestionsResult> {
        val launcherItems = searchForLauncherItems(charSequence.toString()).subscribeOn(Schedulers.io())
        val networkItems = searchForNetworkItems(charSequence).subscribeOn(Schedulers.io())
        return launcherItems.mergeWith(networkItems)
    }

    private fun searchForLauncherItems(charSequence: CharSequence): Observable<SuggestionsResult> {
        val query = Utilities.stripCaseAndAccents(charSequence.toString())
        val suggestionsResult = SuggestionsResult(query)
        val launcherItems = mutableListOf<LauncherItem>()
        pages.forEach { gridLayout ->
            for (i in 0 until gridLayout.childCount) {
                val blissFrameLayout = gridLayout.getChildAt(i) as BlissFrameLayout
                val launcherItem = blissFrameLayout.launcherItem
                if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                    val folderItem = launcherItem as FolderItem
                    for (item in folderItem.items!!) {
                        if (Utilities.stripCaseAndAccents(item.title.toString()).contains(query)) {
                            launcherItems.add(item)
                        }
                    }
                } else if (Utilities.stripCaseAndAccents(launcherItem.title.toString()).contains(query)) {
                    launcherItems.add(launcherItem)
                }
            }
        }

        for (i in 0 until mDock.childCount) {
            val blissFrameLayout = mDock.getChildAt(i) as BlissFrameLayout
            val launcherItem = blissFrameLayout.launcherItem
            if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                val folderItem = launcherItem as FolderItem
                for (item in folderItem.items!!) {
                    if (Utilities.stripCaseAndAccents(item.title.toString()).contains(query)) {
                        launcherItems.add(item)
                    }
                }
            } else if (Utilities.stripCaseAndAccents(launcherItem.title.toString()).contains(query)) {
                launcherItems.add(launcherItem)
            }
        }

        launcherItems.sortBy { it.title.toString().lowercase(Locale.getDefault()).indexOf(query) }

        suggestionsResult.setLauncherItems(if (launcherItems.size > LauncherSearchResultPolicy.QUERY_RESULT_LIMIT) {
            launcherItems.subList(0, LauncherSearchResultPolicy.QUERY_RESULT_LIMIT)
        } else {
            launcherItems
        })
        return Observable.just(suggestionsResult).onErrorReturn {
            suggestionsResult.setLauncherItems(ArrayList())
            suggestionsResult
        }
    }

    private fun searchForNetworkItems(charSequence: CharSequence): Observable<SuggestionsResult> {
        val query = charSequence.toString().lowercase(Locale.getDefault()).trim()
        val suggestionProvider = SearchSuggestionUtil().getSuggestionProvider(this)
        return suggestionProvider.query(query).toObservable()
    }

    override fun onClick(suggestion: String) {
        mSearchInput?.setText(suggestion)
        runSearch(suggestion)
        mSearchInput?.clearFocus()
        mSearchInput?.setText("")
    }

    private fun runSearch(query: String) {
        val intent = Intent(Intent.ACTION_VIEW, SearchSuggestionUtil().getUriForQuery(this, query))
        startActivity(intent)
    }

    private fun getCurrentAppsPageNumber(): Int {
        return currentPageNumber - 1
    }

    fun addAppToGrid(page: GridLayout, view: BlissFrameLayout) {
        addAppToGrid(page, view, EMPTY_LOCATION_DRAG)
    }

    private fun addAppToGrid(page: GridLayout, view: BlissFrameLayout, index: Int) {
        addAppToGrid(page, view, index, mDeviceProfile.cellWidthPx)
    }

    private fun addAppToGrid(page: GridLayout, view: BlissFrameLayout, index: Int, cellWidthPx: Int) {
        if (pages.contains(page) && !isAutoRearrangeAppsEnabled()) {
            val cell = LauncherHomeCellPolicy.resolveCell(
                preferredCell = view.launcherItem.cell,
                requestedIndex = index,
                occupiedCells = occupiedHomeCells(page, except = view),
                maxCells = mDeviceProfile.maxAppsPerPage
            )
            addAppToGridAtCell(page, view, cell, cellWidthPx)
            return
        }

        val rowSpec = GridLayout.spec(GridLayout.UNDEFINED)
        val colSpec = GridLayout.spec(GridLayout.UNDEFINED)
        val iconLayoutParams = GridLayout.LayoutParams(rowSpec, colSpec)
        iconLayoutParams.height = mDeviceProfile.cellHeightPx
        iconLayoutParams.width = cellWidthPx
        view.findViewById<View>(R.id.app_label).visibility = VISIBLE
        view.layoutParams = iconLayoutParams
        view.setWithText(true)
        val shouldAppend = index == EMPTY_LOCATION_DRAG || index == LauncherItem.INVALID_CELL || index > page.childCount
        if (pages.contains(page)) {
            view.launcherItem.cell = LauncherHomeCellPolicy.compactCell(if (shouldAppend) page.childCount else index)
        }
        if (shouldAppend) {
            page.addView(view)
        } else {
            page.addView(view, index)
        }
    }

    private fun addAppToGridAtCell(
        page: GridLayout,
        view: BlissFrameLayout,
        cell: Int,
        cellWidthPx: Int
    ) {
        applyHomeCellLayoutParams(page, view, cell, cellWidthPx)
        page.addView(view)
    }

    private fun applyHomeCellLayoutParams(
        page: GridLayout,
        view: BlissFrameLayout,
        cell: Int,
        cellWidthPx: Int
    ) {
        val cellHeightPx = homeCellHeightForPage(page)
        val manualLayout = LauncherHomeCellPolicy.manualLayoutForCell(
            cell = cell,
            columns = page.columnCount,
            cellWidth = cellWidthPx,
            cellHeight = cellHeightPx
        )
        val iconLayoutParams = GridLayout.LayoutParams(
            GridLayout.spec(manualLayout.specRow),
            GridLayout.spec(manualLayout.specColumn)
        )
        iconLayoutParams.height = cellHeightPx
        iconLayoutParams.width = cellWidthPx
        iconLayoutParams.leftMargin = manualLayout.left
        iconLayoutParams.topMargin = manualLayout.top
        iconLayoutParams.setGravity(Gravity.START or Gravity.TOP)
        view.findViewById<View>(R.id.app_label).visibility = VISIBLE
        view.layoutParams = iconLayoutParams
        view.launcherItem.cell = cell
        view.setWithText(true)
    }

    private fun homeCellHeightForPage(page: GridLayout): Int {
        return LauncherHomeCellPolicy.cellHeightForPage(
            workspaceHeight = mDeviceProfile.workspaceHeight,
            normalTopPadding = dp(LauncherHomeLayoutPreferences.HOME_PAGE_TOP_PADDING_DP),
            currentTopPadding = page.paddingTop,
            rows = page.rowCount,
            maxCellHeight = mDeviceProfile.cellHeightPx
        )
    }

    private fun relayoutHomePageCells(page: GridLayout, compact: Boolean = false) {
        val occupiedCells = mutableSetOf<Int>()
        val compactedCells = if (LauncherHomeCellPolicy.shouldCompactCells(
                autoArrangeEnabled = isAutoRearrangeAppsEnabled(),
                forceCompact = compact
            )
        ) {
            LauncherHomeCellPolicy.compactCells(page.childCount, mDeviceProfile.maxAppsPerPage)
        } else {
            emptyList()
        }
        for (index in 0 until page.childCount) {
            val child = page.getChildAt(index) as? BlissFrameLayout ?: continue
            val cell = compactedCells.getOrNull(index)
                ?: LauncherHomeCellPolicy.resolveCell(
                    preferredCell = child.launcherItem.cell,
                    requestedIndex = LauncherItem.INVALID_CELL,
                    occupiedCells = occupiedCells,
                    maxCells = mDeviceProfile.maxAppsPerPage
                )
            occupiedCells.add(cell)
            applyHomeCellLayoutParams(page, child, cell, mDeviceProfile.cellWidthPx)
        }
        page.requestLayout()
    }

    private fun occupiedHomeCells(page: GridLayout, except: BlissFrameLayout? = null): Set<Int> {
        val occupiedCells = mutableSetOf<Int>()
        val maxCells = mDeviceProfile.maxAppsPerPage
        for (index in 0 until page.childCount) {
            val child = page.getChildAt(index) as? BlissFrameLayout ?: continue
            if (child === except) {
                continue
            }
            val cell = child.launcherItem.cell
            if (cell in 0 until maxCells) {
                occupiedCells.add(cell)
            }
        }
        return occupiedCells
    }

    private fun findHomeCellOccupant(
        page: GridLayout,
        cell: Int,
        except: BlissFrameLayout? = null
    ): BlissFrameLayout? {
        for (index in 0 until page.childCount) {
            val child = page.getChildAt(index) as? BlissFrameLayout ?: continue
            if (child === except) {
                continue
            }
            if (child.launcherItem.cell == cell) {
                return child
            }
        }
        return null
    }

    private fun occupiedHomeCellsByPage(): Map<Int, Set<Int>> {
        return pages.indices.associateWith { index -> occupiedHomeCells(pages[index]) }
    }

    private fun isAutoRearrangeAppsEnabled(): Boolean {
        return LauncherHomeLayoutPreferences.isAutoRearrangeAppsEnabled(this)
    }

    private fun addAppToDock(view: BlissFrameLayout, index: Int) {
        view.findViewById<View>(R.id.app_label).visibility = GONE
        val rowSpec = GridLayout.spec(GridLayout.UNDEFINED)
        val colSpec = GridLayout.spec(GridLayout.UNDEFINED)
        val iconLayoutParams = GridLayout.LayoutParams(rowSpec, colSpec)
        iconLayoutParams.height = mDeviceProfile.hotseatCellHeightPx
        iconLayoutParams.width = mDeviceProfile.hotseatCellWidthPx
        iconLayoutParams.setGravity(Gravity.CENTER)
        view.layoutParams = iconLayoutParams
        view.setWithText(false)
        if (index == LauncherItem.INVALID_CELL || index == EMPTY_LOCATION_DRAG || index > mDock.childCount) {
            mDock.addView(view)
        } else {
            mDock.addView(view, index)
        }
        mDock.refreshStyle()
    }

    @SuppressLint("InflateParams", "ClickableViewAccessibility")
    private fun prepareLauncherItem(launcherItem: LauncherItem): BlissFrameLayout {
        val iconView = layoutInflater.inflate(R.layout.app_view, null) as BlissFrameLayout
        iconView.launcherItem = launcherItem
        val icon = iconView.findViewById<SquareFrameLayout>(R.id.app_icon)
        if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
            iconView.applyBadge(
                checkHasApp(launcherItem as FolderItem, mAppsWithNotifications),
                launcherItem.container != Constants.CONTAINER_HOTSEAT.toLong()
            )
        } else if (launcherItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
            val applicationItem = launcherItem as ApplicationItem
            if (applicationItem.appType == ApplicationItem.TYPE_CALENDAR) {
                mCalendarIcons.add(iconView)
            }
            iconView.applyBadge(
                mAppsWithNotifications.contains(applicationItem.packageName),
                launcherItem.container != Constants.CONTAINER_HOTSEAT.toLong()
            )
        }

        icon.setOnLongClickListener { view ->
            view.isHapticFeedbackEnabled = true
            when (LauncherEditModeEntryPolicy.longPressAction(isWobbling)) {
                LauncherEditModeEntryPolicy.LongPressAction.SHOW_OPTIONS -> {
                    showLauncherOptionsPopup(launcherItem, iconView, view)
                }

                LauncherEditModeEntryPolicy.LongPressAction.START_DRAG -> {
                    longPressed = true
                }
            }
            true
        }

        icon.setOnTouchListener(object : View.OnTouchListener {
            private var iconPressedAt = 0L

            override fun onTouch(view: View, event: MotionEvent): Boolean {
                if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                    if (!mLongClickStartsDrag) {
                        iconPressedAt = System.currentTimeMillis()
                    }
                } else if (event.actionMasked == MotionEvent.ACTION_MOVE) {
                    if (longPressed || (!mLongClickStartsDrag && System.currentTimeMillis() - iconPressedAt > 150)) {
                        longPressed = false
                        movingApp = iconView
                        dragShadowBuilder = BlissDragShadowBuilder(
                            icon,
                            if (event.x < 0) 0f else event.x,
                            if (event.y < 0) 0f else event.y
                        )
                        icon.startDragAndDrop(null, dragShadowBuilder, iconView, 0)
                        parentPage = if ((iconView.parent as View).parent is HorizontalPager) {
                            getCurrentAppsPageNumber()
                        } else {
                            -99
                        }
                        dragStartHomePage = parentPage.takeIf { it >= 0 } ?: -1
                        dragStartHomeCell = iconView.launcherItem.cell
                        iconView.clearAnimation()
                        movingApp?.visibility = View.INVISIBLE
                        dragDropEnabled = true
                    }
                } else if (event.action == MotionEvent.ACTION_UP) {
                    Handler(Looper.getMainLooper()).post {
                        if (movingApp != null && movingApp?.visibility != VISIBLE) {
                            movingApp?.visibility = VISIBLE
                            movingApp?.invalidate()
                        }
                    }
                    return false
                }
                return false
            }
        })

        icon.setOnClickListener { view ->
            if (isWobbling) {
                return@setOnClickListener
            }

            if (launcherItem.itemType != Constants.ITEM_TYPE_FOLDER) {
                startActivitySafely(applicationContext, launcherItem, view)
            } else {
                folderFromDock = !((iconView.parent as View).parent is HorizontalPager)
                displayFolder(launcherItem as FolderItem, iconView)
            }
        }

        return iconView
    }

    private fun showLauncherOptionsPopup(launcherItem: LauncherItem, iconView: BlissFrameLayout, anchor: View) {
        dismissLauncherOptionsPopup()

        val menu = layoutInflater.inflate(R.layout.popup_launcher_app_options, null)
        val popup = PopupWindow(menu, dp(262), ViewGroup.LayoutParams.WRAP_CONTENT, true).apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            isOutsideTouchable = true
            elevation = dp(12).toFloat()
            setOnDismissListener {
                hideLauncherOptionsOverlay()
                if (launcherOptionsPopup === this) {
                    launcherOptionsPopup = null
                }
            }
        }
        launcherOptionsPopup = popup

        menu.findViewById<View>(R.id.appInfoButton)?.setOnClickListener {
            popup.dismiss()
            openLauncherItemInfo(launcherItem)
        }
        menu.findViewById<View>(R.id.renameButton)?.setOnClickListener {
            popup.dismiss()
            showRenameAppPicker()
        }
        menu.findViewById<View>(R.id.hideButton)?.setOnClickListener {
            popup.dismiss()
        }
        menu.findViewById<View>(R.id.editHomeButton)?.setOnClickListener {
            popup.dismiss()
            if (LauncherEditModeEntryPolicy.shouldEnterEditMode(editHomeClicked = true)) {
                handleWobbling(true)
            }
        }
        menu.findViewById<View>(R.id.deleteButton)?.setOnClickListener {
            popup.dismiss()
            if (canShowUninstallOption(launcherItem)) {
                uninstallLauncherItem(launcherItem, iconView)
            } else {
                handleWobbling(true)
            }
        }

        menu.measure(
            View.MeasureSpec.makeMeasureSpec(resources.displayMetrics.widthPixels, View.MeasureSpec.AT_MOST),
            View.MeasureSpec.makeMeasureSpec(resources.displayMetrics.heightPixels, View.MeasureSpec.AT_MOST)
        )
        showLauncherOptionsOverlay(launcherItem, anchor)
        popup.showAtLocation(
            mLauncherView,
            Gravity.NO_GRAVITY,
            popupX(anchor, dp(262)),
            popupY(anchor, menu.measuredHeight)
        )
    }

    private fun dismissLauncherOptionsPopup() {
        val popup = launcherOptionsPopup
        if (popup != null) {
            launcherOptionsPopup = null
            popup.dismiss()
        } else if (::contextOverlay.isInitialized) {
            hideLauncherOptionsOverlay()
        }
    }

    private fun showRenameAppPicker() {
        val apps = renamePickerApps()
        if (apps.isEmpty()) {
            Toast.makeText(this, R.string.settings_no_apps_found, Toast.LENGTH_SHORT).show()
            return
        }
        showRenameAppPicker(apps)
    }

    private fun showRenameAppPicker(apps: List<ApplicationItem>) {
        hideRenameAppPicker()

        val backgroundColor = 0xFFF2F2F7.toInt()
        val toolbarColor = Color.WHITE
        val primaryTextColor = Color.BLACK
        val secondaryTextColor = 0xFF5E6675.toInt()
        val dividerColor = 0xFFE5E5EA.toInt()

        val panel = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(backgroundColor)
            elevation = dp(42).toFloat()
            isClickable = true
            isFocusable = true
        }

        panel.addView(
            FrameLayout(this).apply {
                setBackgroundColor(toolbarColor)
                addView(
                    TextView(context).apply {
                        text = getString(R.string.layout_back_settings)
                        setTextColor(0xFF007AFF.toInt())
                        textSize = 25f
                        gravity = Gravity.CENTER_VERTICAL
                        includeFontPadding = false
                        setOnClickListener { hideRenameAppPicker() }
                    },
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        dp(56),
                        Gravity.START or Gravity.BOTTOM
                    ).apply {
                        leftMargin = dp(14)
                    }
                )
                addView(
                    TextView(context).apply {
                        text = getString(R.string.settings_rename)
                        setTextColor(primaryTextColor)
                        textSize = 20f
                        typeface = Typeface.DEFAULT_BOLD
                        gravity = Gravity.CENTER
                        includeFontPadding = false
                    },
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        dp(56),
                        Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM
                    )
                )
            },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(112))
        )

        panel.addView(
            View(this).apply { setBackgroundColor(dividerColor) },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
        )

        panel.addView(
            ScrollView(this).apply {
                isFillViewport = true
                overScrollMode = View.OVER_SCROLL_NEVER
                setBackgroundColor(backgroundColor)
                addView(
                    LinearLayout(context).apply {
                        orientation = LinearLayout.VERTICAL
                        apps.forEach { app ->
                            addView(createRenameAppRow(app, secondaryTextColor, dividerColor, backgroundColor))
                        }
                    },
                    ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                )
            },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
        )

        renameAppPanel = panel
        (mLauncherView as? ViewGroup)?.addView(
            panel,
            RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
    }

    private fun createRenameAppRow(
        app: ApplicationItem,
        textColor: Int,
        dividerColor: Int,
        backgroundColor: Int
    ): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(backgroundColor)
            addView(
                LinearLayout(context).apply {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL
                    isClickable = true
                    isFocusable = true
                    setPadding(dp(18), 0, dp(14), 0)
                    setOnClickListener { showRenameAppDialog(app) }

                    addView(
                        ImageView(context).apply {
                            setImageDrawable(app.icon)
                            contentDescription = app.title?.toString()
                            scaleType = ImageView.ScaleType.FIT_CENTER
                        },
                        LinearLayout.LayoutParams(dp(58), dp(58))
                    )

                    addView(
                        TextView(context).apply {
                            text = app.title?.toString().orEmpty()
                            setTextColor(textColor)
                            textSize = 18f
                            maxLines = 1
                            ellipsize = TextUtils.TruncateAt.END
                            includeFontPadding = false
                        },
                        LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply {
                            marginStart = dp(14)
                        }
                    )
                },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(82))
            )
            addView(
                View(context).apply { setBackgroundColor(dividerColor) },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1).apply {
                    leftMargin = dp(92)
                }
            )
        }
    }

    private fun showRenameAppDialog(app: ApplicationItem) {
        val currentTitle = app.title?.toString().orEmpty()
        val input = EditText(this).apply {
            setSingleLine(true)
            hint = getString(R.string.settings_rename_hint)
            setText(currentTitle)
            selectAll()
            textSize = 18f
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
            .setNegativeButton(R.string.dialog_cancel, null)
            .setPositiveButton(R.string.dialog_ok) { _, _ ->
                val updatedTitle = LauncherAppRenamePolicy.submittedTitle(
                    input = input.text?.toString().orEmpty(),
                    currentTitle = currentTitle
                )
                renameApplication(app, updatedTitle)
            }
            .show()
    }

    private fun renameApplication(app: ApplicationItem, updatedTitle: String) {
        val appKeys = renameKeysFor(app)
        LauncherAppRenamePreferences.save(this, appKeys, updatedTitle)
        applyRenamedTitleToLauncher(appKeys, updatedTitle)
        DatabaseManager.getManager(this).saveLayouts(pages, mDock)
        refreshAppLibraryPage()
        hideRenameAppPicker()
        Toast.makeText(this, getString(R.string.settings_rename_done, updatedTitle), Toast.LENGTH_SHORT).show()
    }

    private fun hideRenameAppPicker() {
        val panel = renameAppPanel ?: return
        renameAppPanel = null
        (panel.parent as? ViewGroup)?.removeView(panel)
    }

    private fun renamePickerApps(): List<ApplicationItem> {
        val appsById = linkedMapOf<String, ApplicationItem>()

        fun collect(item: LauncherItem) {
            when (item.itemType) {
                Constants.ITEM_TYPE_APPLICATION -> appsById[item.id] = item as ApplicationItem
                Constants.ITEM_TYPE_FOLDER -> (item as FolderItem).items.orEmpty().forEach(::collect)
            }
        }

        appLibraryApps.forEach { app -> appsById[app.id] = app }
        for (i in 0 until mDock.childCount) {
            collect(getAppDetails(mDock.getChildAt(i) as BlissFrameLayout))
        }
        pages.forEach { page ->
            for (i in 0 until page.childCount) {
                collect(getAppDetails(page.getChildAt(i) as BlissFrameLayout))
            }
        }

        return appsById.values.sortedWith { left, right ->
            Collator.getInstance().compare(left.title?.toString().orEmpty(), right.title?.toString().orEmpty())
        }
    }

    private fun renameKeysFor(app: ApplicationItem): List<String> {
        return LauncherAppRenamePolicy.appKeys(
            appId = app.id,
            componentName = app.componentName?.flattenToString(),
            packageName = app.packageName
        )
    }

    private fun applyRenamedTitleToLauncher(appKeys: List<String>, updatedTitle: String) {
        appLibraryApps.forEach { app ->
            if (LauncherAppRenamePolicy.matchesApp(appKeys, renameKeysFor(app))) {
                app.title = updatedTitle
            }
        }
        mSuggestedApps.forEach { app ->
            if (LauncherAppRenamePolicy.matchesApp(appKeys, renameKeysFor(app))) {
                app.title = updatedTitle
            }
        }

        fun updateItem(item: LauncherItem) {
            when (item.itemType) {
                Constants.ITEM_TYPE_APPLICATION -> {
                    if (LauncherAppRenamePolicy.matchesApp(appKeys, renameKeysFor(item as ApplicationItem))) {
                        item.title = updatedTitle
                    }
                }
                Constants.ITEM_TYPE_FOLDER -> (item as FolderItem).items.orEmpty().forEach(::updateItem)
            }
        }

        fun updateContainer(container: ViewGroup) {
            for (i in 0 until container.childCount) {
                val appView = container.getChildAt(i) as? BlissFrameLayout ?: continue
                val item = getAppDetails(appView)
                updateItem(item)
                if (
                    item.itemType == Constants.ITEM_TYPE_APPLICATION &&
                    LauncherAppRenamePolicy.matchesApp(appKeys, renameKeysFor(item as ApplicationItem))
                ) {
                    appView.findViewById<TextView>(R.id.app_label)?.text = updatedTitle
                }
            }
        }

        updateContainer(mDock)
        pages.forEach(::updateContainer)
        if (mFolderWindowContainer.visibility == VISIBLE) {
            for (i in 0 until mFolderAppsViewPager.childCount) {
                (mFolderAppsViewPager.getChildAt(i) as? ViewGroup)?.let(::updateContainer)
            }
        }
    }

    private fun showLauncherOptionsOverlay(launcherItem: LauncherItem, anchor: View) {
        contextOverlay.animate().cancel()
        contextOverlay.alpha = 0f
        contextOverlay.visibility = VISIBLE
        contextOverlay.bringToFront()
        contextOverlay.animate().alpha(1f).setDuration(120L).start()

        showSelectedIconPreview(launcherItem, anchor)
    }

    private fun hideLauncherOptionsOverlay() {
        hideSelectedIconPreview()
        if (!::contextOverlay.isInitialized || contextOverlay.visibility != VISIBLE) {
            return
        }
        contextOverlay.animate().cancel()
        contextOverlay.animate()
            .alpha(0f)
            .setDuration(120L)
            .withEndAction {
                contextOverlay.visibility = GONE
                contextOverlay.alpha = 1f
            }
            .start()
    }

    private fun showSelectedIconPreview(launcherItem: LauncherItem, anchor: View) {
        selectedIconImage.setImageDrawable(launcherItem.icon)

        val anchorLocation = IntArray(2)
        val rootLocation = IntArray(2)
        anchor.getLocationOnScreen(anchorLocation)
        mLauncherView.getLocationOnScreen(rootLocation)

        val previewWidth = if (selectedIconPreview.width > 0) selectedIconPreview.width else dp(94)
        val previewHeight = if (selectedIconPreview.height > 0) selectedIconPreview.height else dp(94)
        val rootWidth = if (mLauncherView.width > 0) mLauncherView.width else resources.displayMetrics.widthPixels
        val rootHeight = if (mLauncherView.height > 0) mLauncherView.height else resources.displayMetrics.heightPixels
        val minMargin = dp(4)
        val topMargin = dp(12)
        val left = anchorLocation[0] - rootLocation[0] + anchor.width / 2 - previewWidth / 2
        val top = anchorLocation[1] - rootLocation[1] - dp(2)
        val maxLeft = max(minMargin, rootWidth - previewWidth - minMargin)
        val maxTop = max(topMargin, rootHeight - previewHeight - topMargin)

        selectedIconPreview.x = max(minMargin, min(left, maxLeft)).toFloat()
        selectedIconPreview.y = max(topMargin, min(top, maxTop)).toFloat()
        selectedIconPreview.bringToFront()
        selectedIconPreview.animate().cancel()
        selectedIconPreview.alpha = 0f
        selectedIconPreview.scaleX = 1.03f
        selectedIconPreview.scaleY = 1.03f
        selectedIconPreview.visibility = VISIBLE
        selectedIconPreview.animate()
            .alpha(1f)
            .scaleX(1.08f)
            .scaleY(1.08f)
            .setDuration(120L)
            .start()
    }

    private fun hideSelectedIconPreview() {
        if (!::selectedIconPreview.isInitialized || selectedIconPreview.visibility != VISIBLE) {
            return
        }
        selectedIconPreview.animate().cancel()
        selectedIconPreview.animate()
            .alpha(0f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(110L)
            .withEndAction {
                selectedIconPreview.visibility = GONE
                selectedIconPreview.alpha = 1f
                selectedIconImage.setImageDrawable(null)
            }
            .start()
    }

    private fun popupX(anchor: View, popupWidth: Int): Int {
        val anchorLocation = IntArray(2)
        anchor.getLocationOnScreen(anchorLocation)
        val screenWidth = resources.displayMetrics.widthPixels
        val margin = dp(16)
        return max(margin, min(anchorLocation[0], screenWidth - popupWidth - margin))
    }

    private fun popupY(anchor: View, popupHeight: Int): Int {
        val anchorLocation = IntArray(2)
        anchor.getLocationOnScreen(anchorLocation)
        val screenHeight = resources.displayMetrics.heightPixels
        val margin = dp(16)
        val desiredY = anchorLocation[1] + anchor.height + dp(8)
        return if (desiredY + popupHeight > screenHeight - margin) {
            max(margin, anchorLocation[1] - popupHeight - dp(8))
        } else {
            desiredY
        }
    }

    private fun openLauncherItemInfo(launcherItem: LauncherItem) {
        val packageName = launcherItem.getTargetComponent()?.packageName
            ?: when (launcherItem.itemType) {
                Constants.ITEM_TYPE_APPLICATION -> (launcherItem as ApplicationItem).packageName
                Constants.ITEM_TYPE_SHORTCUT -> (launcherItem as ShortcutItem).packageName
                else -> null
            }

        if (packageName == null) {
            Toast.makeText(this, getString(R.string.activity_not_found), Toast.LENGTH_SHORT).show()
            return
        }

        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            .setData(Uri.parse("package:$packageName"))
        startActivity(intent)
    }

    private fun canShowUninstallOption(launcherItem: LauncherItem): Boolean {
        if (launcherItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
            return true
        }
        if (launcherItem.itemType != Constants.ITEM_TYPE_APPLICATION) {
            return false
        }
        val applicationItem = launcherItem as ApplicationItem
        return applicationItem.isSystemApp == ApplicationItem.FLAG_SYSTEM_UNKNOWN ||
            (applicationItem.isSystemApp and ApplicationItem.FLAG_SYSTEM_NO) != 0
    }

    private fun uninstallLauncherItem(launcherItem: LauncherItem, blissFrameLayout: BlissFrameLayout) {
        if (launcherItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
            val componentName = launcherItem.getTargetComponent()
            if (componentName == null) {
                Toast.makeText(this, getString(R.string.toast_cannot_uninstall), Toast.LENGTH_SHORT).show()
            } else {
                val packageUri = Uri.fromParts("package", componentName.packageName, componentName.className)
                val intent = Intent(Intent.ACTION_UNINSTALL_PACKAGE, packageUri)
                    .putExtra(Intent.EXTRA_USER, launcherItem.user!!.getRealHandle())
                startActivity(intent)
            }
        } else if (launcherItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
            val dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogCustom))
                .setTitle(launcherItem.title)
                .setMessage(R.string.uninstall_shortcut_dialog)
                .setPositiveButton(R.string.ok) { _, _ ->
                    val shortcut = launcherItem as ShortcutItem
                    if (shortcut.packageName != null) {
                        DeepShortcutManager.getInstance(this).unpinShortcut(ShortcutKey.fromItem(shortcut))
                        if (DeepShortcutManager.getInstance(this).wasLastCallSuccess()) {
                            deleteShortcutFromProvider(shortcut.id)
                            removeShortcutView(shortcut, blissFrameLayout)
                        }
                    } else {
                        deleteShortcutFromProvider(shortcut.id)
                        removeShortcutView(shortcut, blissFrameLayout)
                    }
                }
                .setNegativeButton(R.string.cancel, null)
                .setIcon(launcherItem.icon)
                .create()
            dialog.setOnShowListener {
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(resources.getColor(R.color.color_blue))
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(resources.getColor(R.color.color_blue))
            }
            dialog.show()
        }
    }

    fun prepareSuggestedApp(launcherItem: LauncherItem): BlissFrameLayout {
        val view = layoutInflater.inflate(R.layout.app_view, null) as BlissFrameLayout
        view.launcherItem = launcherItem
        val icon = view.findViewById<SquareFrameLayout>(R.id.app_icon)

        if (launcherItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
            view.applyBadge(mAppsWithNotifications.contains((launcherItem as ApplicationItem).packageName), true)
        }
        icon.setOnClickListener { startActivitySafely(this, launcherItem, it) }
        return view
    }

    private fun startActivitySafely(context: Context, launcherItem: LauncherItem, v: View?) {
        val intent = launcherItem.getIntent() ?: return
        val user = launcherItem.user?.getRealHandle()

        if (v != null) {
            intent.sourceBounds = getViewBounds(v)
        }

        if (launcherItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
            startShortcutIntentSafely(context, intent, launcherItem)
        } else {
            val applicationItem = launcherItem as ApplicationItem
            if (applicationItem.isDisabled) {
                Toast.makeText(this, getString(R.string.toast_package_unavailable), Toast.LENGTH_SHORT).show()
            } else {
                if (user == null || user == Process.myUserHandle()) {
                    context.startActivity(intent)
                } else {
                    (getSystemService(LAUNCHER_APPS_SERVICE) as LauncherApps).startMainActivity(
                        intent.component,
                        user,
                        intent.sourceBounds,
                        null
                    )
                }
            }
        }
    }

    private fun startShortcutIntentSafely(context: Context, intent: Intent, appItem: LauncherItem) {
        try {
            val oldPolicy = StrictMode.getVmPolicy()
            try {
                StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build())

                if (appItem.itemType == Constants.ITEM_TYPE_SHORTCUT) {
                    if (Utilities.ATLEAST_OREO) {
                        val packageName = intent.`package` ?: return
                        DeepShortcutManager.getInstance(context).startShortcut(
                            packageName,
                            appItem.id,
                            intent.sourceBounds,
                            null,
                            Process.myUserHandle()
                        )
                    } else {
                        context.startActivity(intent)
                    }
                } else {
                    context.startActivity(intent)
                }
            } finally {
                StrictMode.setVmPolicy(oldPolicy)
            }
        } catch (e: SecurityException) {
            throw e
        }
    }

    private fun getViewBounds(v: View): Rect {
        val pos = IntArray(2)
        v.getLocationOnScreen(pos)
        return Rect(pos[0], pos[1], pos[0] + v.width, pos[1] + v.height)
    }

    private fun handleWobbling(shouldPlay: Boolean) {
        if (shouldPlay) {
            dismissLauncherOptionsPopup()
        }
        if (mWobblingCountDownTimer != null && !shouldPlay) {
            mWobblingCountDownTimer?.cancel()
        }
        isWobbling = shouldPlay
        mLongClickStartsDrag = !shouldPlay
        longPressed = false

        if (mFolderWindowContainer.visibility == VISIBLE) {
            for (i in 0 until mFolderAppsViewPager.childCount) {
                toggleWobbleAnimation(mFolderAppsViewPager.getChildAt(i) as GridLayout, shouldPlay)
            }
        }

        for (page in pages) {
            applyHomePageGridPadding(page, shouldPlay)
            relayoutHomePageCells(page)
            toggleWobbleAnimation(page, shouldPlay)
        }
        toggleWobbleAnimation(mDock, shouldPlay)
        setEditTopBarVisible(shouldPlay)

        if (shouldPlay) {
            showDotsInIndicator(homePagePositionForPagerPage(currentPageNumber), false)
        } else {
            indicatorMode = IndicatorMode.SEARCH
            updateWorkspaceChromeForPage(currentPageNumber)
        }
    }

    private fun setEditTopBarVisible(visible: Boolean) {
        if (!::editTopBar.isInitialized) {
            return
        }
        editTopBar.animate().cancel()
        if (visible) {
            editTopBar.alpha = 0f
            editTopBar.translationY = -dp(12).toFloat()
            editTopBar.visibility = VISIBLE
            editTopBar.bringToFront()
            editTopBar.animate()
                .alpha(1f)
                .translationY(0f)
                .setDuration(160L)
                .start()
        } else if (editTopBar.visibility == VISIBLE) {
            editTopBar.animate()
                .alpha(0f)
                .translationY(-dp(12).toFloat())
                .setDuration(130L)
                .withEndAction {
                    editTopBar.visibility = GONE
                    editTopBar.alpha = 1f
                    editTopBar.translationY = 0f
                }
                .start()
        }
    }

    private fun toggleWobbleAnimation(gridLayout: GridLayout, shouldPlayAnimation: Boolean) {
        for (i in 0 until gridLayout.childCount) {
            val blissFrameLayout = gridLayout.getChildAt(i) as BlissFrameLayout
            makeAppWobble(blissFrameLayout, shouldPlayAnimation, i)
        }
    }

    private fun makeAppWobble(blissFrameLayout: BlissFrameLayout?, shouldPlayAnimation: Boolean, i: Int) {
        if (blissFrameLayout == null) {
            return
        }
        val userManager = getSystemService(Context.USER_SERVICE) as UserManager
        val restrictions = userManager.userRestrictions
        val uninstallDisabled = restrictions.getBoolean(UserManager.DISALLOW_APPS_CONTROL, false) ||
            restrictions.getBoolean(UserManager.DISALLOW_UNINSTALL_APPS, false)
        if (shouldPlayAnimation) {
            if (blissFrameLayout.animation == null) {
                val imageView = blissFrameLayout.findViewById<ImageView?>(R.id.uninstall_app)
                if (imageView == null && !uninstallDisabled) {
                    Handler(Looper.getMainLooper()).post { addUninstallIcon(blissFrameLayout) }
                }

                if (i % 2 == 0) {
                    blissFrameLayout.startAnimation(wobbleAnimation)
                } else {
                    blissFrameLayout.startAnimation(wobbleReverseAnimation)
                }
            }
        } else {
            blissFrameLayout.clearAnimation()
            Handler(Looper.getMainLooper()).post { removeUninstallIcon(blissFrameLayout) }
        }
    }

    private fun removeUninstallIcon(blissFrameLayout: BlissFrameLayout?) {
        val imageView = blissFrameLayout?.findViewById<ImageView?>(R.id.uninstall_app)
        if (imageView != null) {
            (imageView.parent as ViewGroup).removeView(imageView)
        }
    }

    private fun addUninstallIcon(blissFrameLayout: BlissFrameLayout) {
        val launcherItem = getAppDetails(blissFrameLayout)
        if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
            return
        }

        if (launcherItem.itemType == Constants.ITEM_TYPE_APPLICATION) {
            val applicationItem = launcherItem as ApplicationItem
            if (applicationItem.isSystemApp != ApplicationItem.FLAG_SYSTEM_UNKNOWN) {
                if ((applicationItem.isSystemApp and ApplicationItem.FLAG_SYSTEM_NO) == 0) {
                    return
                }
            }
        }

        val appIcon = blissFrameLayout.findViewById<SquareFrameLayout>(R.id.app_icon)
        val size = mDeviceProfile.uninstallIconSizePx
        val topPadding = if (appIcon.top - mDeviceProfile.uninstallIconSizePx / 2 +
            mDeviceProfile.uninstallIconPadding > 0
        ) {
            appIcon.top - mDeviceProfile.uninstallIconSizePx / 2 + mDeviceProfile.uninstallIconPadding
        } else {
            0
        }
        val bottomPadding = topPadding
        val rightPadding = if (appIcon.left - mDeviceProfile.uninstallIconSizePx / 2 +
            mDeviceProfile.uninstallIconPadding > 0
        ) {
            appIcon.left - mDeviceProfile.uninstallIconSizePx / 2 + mDeviceProfile.uninstallIconPadding
        } else {
            0
        }
        val leftPadding = rightPadding

        val imageView = ImageView(this)
        imageView.id = R.id.uninstall_app
        imageView.setImageResource(R.drawable.remove_icon_72)
        imageView.setPadding(leftPadding, topPadding, rightPadding, bottomPadding)

        imageView.setOnClickListener { uninstallLauncherItem(launcherItem, blissFrameLayout) }
        val layoutParams = FrameLayout.LayoutParams(size + 2 * rightPadding, size + 2 * topPadding)
        layoutParams.gravity = Gravity.END or Gravity.TOP
        blissFrameLayout.addView(imageView, layoutParams)
    }

    private fun deleteShortcutFromProvider(id: String) {
        val count = contentResolver.delete(
            Uri.parse("content://foundation.e.pwaplayer.provider/pwa"),
            null,
            arrayOf(id)
        )
        Timber.tag("LauncherActivity").d("Items deleted from pwa provider: $count")
    }

    private fun removeShortcutView(shortcutItem: ShortcutItem, blissFrameLayout: BlissFrameLayout) {
        DatabaseManager.getManager(this).removeLauncherItem(shortcutItem.id)
        if (mFolderWindowContainer.visibility == VISIBLE) {
            val folder = activeFolder ?: return
            val folderView = activeFolderView ?: return
            folder.items!!.remove(shortcutItem)
            mFolderAppsViewPager.adapter?.notifyDataSetChanged()
            blissFrameLayout.clearAnimation()
            (blissFrameLayout.parent as ViewGroup).removeView(blissFrameLayout)
            if (folder.items!!.isEmpty()) {
                (folderView.parent as ViewGroup).removeView(folderView)
                hideFolderWindowContainer()
            } else if (folder.items!!.size == 1) {
                val item = folder.items!![0]
                folder.items!!.remove(item)
                mFolderAppsViewPager.adapter?.notifyDataSetChanged()
                val view = prepareLauncherItem(item)

                if (folderFromDock) {
                    addAppToDock(view, mDock.indexOfChild(folderView))
                } else {
                    val gridLayout = pages[getCurrentAppsPageNumber()]
                    addAppToGrid(gridLayout, view, gridLayout.indexOfChild(folderView))
                }
                folderView.clearAnimation()
                (folderView.parent as ViewGroup).removeView(folderView)
                hideFolderWindowContainer()
            } else {
                updateIcon(folderView, folder, GraphicsUtil(this).generateFolderIcon(this, folder), folderFromDock)
                hideFolderWindowContainer()
            }
        } else {
            blissFrameLayout.clearAnimation()
            (blissFrameLayout.parent as ViewGroup).removeView(blissFrameLayout)
        }
    }

    private fun createDragListener() {
        mDock.setOnDragListener(object : View.OnDragListener {
            var cX = 0f
            var cY = 0f
            private var latestFolderInterest = false

            override fun onDrag(view: View, dragEvent: DragEvent): Boolean {
                val moving = movingApp
                val shadow = dragShadowBuilder
                if (dragEvent.action == DragEvent.ACTION_DRAG_STARTED) {
                    isDragging = true
                    mWobblingCountDownTimer?.cancel()
                } else if (dragEvent.action == DragEvent.ACTION_DRAG_LOCATION) {
                    if (moving == null || shadow == null) return true
                    if (getAppDetails(moving).container != Constants.CONTAINER_DESKTOP.toLong() &&
                        getAppDetails(moving).container != Constants.CONTAINER_HOTSEAT.toLong()
                    ) {
                        return true
                    }

                    if (!dragDropEnabled) {
                        return true
                    }

                    cX = dragEvent.x - shadow.xOffset
                    cY = mDock.y + dragEvent.y - shadow.yOffset

                    val index = getIndex(mDock, cX, cY)

                    if (index == mDock.indexOfChild(moving)) {
                        discardCollidingApp()
                        return true
                    }

                    if (index == EMPTY_LOCATION_DRAG) {
                        discardCollidingApp()
                    } else {
                        val latestCollidingApp = mDock.getChildAt(index) as BlissFrameLayout
                        if (collidingApp !== latestCollidingApp) {
                            collidingApp?.let { makeAppCold(it, !((it.parent as View).parent is HorizontalPager)) }
                            collidingApp = latestCollidingApp
                            folderInterest = false
                        }

                        val movingLauncherItem = moving.launcherItem
                        if (movingLauncherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                            folderInterest = false
                        } else {
                            latestFolderInterest = checkIfFolderInterest(mDock, index, cX, cY)
                            if (latestFolderInterest != folderInterest) {
                                folderInterest = latestFolderInterest
                            }
                            if (folderInterest) {
                                cleanupDockReorder(true)
                                cleanupReorder(true)
                                makeAppHot(collidingApp)
                            } else {
                                collidingApp?.let { makeAppCold(it, !((it.parent as View).parent is HorizontalPager)) }
                            }
                        }
                    }

                    if (!folderInterest && !mDockReorderAlarm.alarmPending()) {
                        val dockReorderAlarmListener = DockReorderAlarmListener(index)
                        mDockReorderAlarm.setOnAlarmListener(dockReorderAlarmListener)
                        mDockReorderAlarm.setAlarm(REORDER_TIMEOUT.toLong())
                    }
                    return true
                } else if (dragEvent.action == DragEvent.ACTION_DROP) {
                    if (moving == null || shadow == null) return true
                    cleanupDockReorder(true)
                    cleanupReorder(true)
                    if (mFolderWindowContainer.visibility != VISIBLE) {
                        if (!folderInterest) {
                            if (moving.parent == null) {
                                if (mDock.childCount >= mDeviceProfile.numColumns) {
                                    Toast.makeText(
                                        this@LauncherActivity,
                                        getString(R.string.toast_dock_full),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    addAppToDock(moving, EMPTY_LOCATION_DRAG)
                                }
                            }
                            moving.visibility = VISIBLE
                            makeAppWobble(moving, true, mDock.indexOfChild(moving))
                        } else {
                            if ((collidingApp?.parent as? View)?.parent is HorizontalPager) {
                                createOrUpdateFolder(false)
                            } else {
                                createOrUpdateFolder(true)
                            }
                            folderInterest = false
                        }
                    } else {
                        cX = dragEvent.x - shadow.xOffset
                        cY = mDock.y + dragEvent.y - shadow.yOffset
                        val topLeftCorner = IntArray(2)
                        mFolderAppsViewPager.getLocationOnScreen(topLeftCorner)
                        val left = topLeftCorner[0]
                        val top = topLeftCorner[1]
                        val right = left + mFolderAppsViewPager.width
                        val bottom = top + mFolderAppsViewPager.height

                        if (!(left < right && top < bottom && cX >= left && cX < right && cY >= top && cY < bottom)) {
                            removeAppFromFolder()
                        } else {
                            moving.visibility = VISIBLE
                            val currentItem = mFolderAppsViewPager.currentItem
                            makeAppWobble(
                                moving,
                                true,
                                (mFolderAppsViewPager.getChildAt(currentItem) as GridLayout).indexOfChild(moving)
                            )
                        }
                    }
                    return true
                }

                return true
            }
        })

        mHorizontalPager.setOnDragListener(object : View.OnDragListener {
            var cY = 0f
            var cX = 0f
            private var latestFolderInterest = false

            override fun onDrag(view: View, dragEvent: DragEvent): Boolean {
                val moving = movingApp
                val shadow = dragShadowBuilder
                if (dragEvent.action == DragEvent.ACTION_DRAG_STARTED) {
                    isDragging = true
                    mWobblingCountDownTimer?.cancel()
                } else if (dragEvent.action == DragEvent.ACTION_DRAG_LOCATION) {
                    if (moving == null || shadow == null) return true
                    cX = dragEvent.x - shadow.xOffset
                    cY = mHorizontalPager.y + dragEvent.y - shadow.yOffset

                    if (getAppDetails(moving).container != Constants.CONTAINER_DESKTOP.toLong() &&
                        getAppDetails(moving).container != Constants.CONTAINER_HOTSEAT.toLong()
                    ) {
                        return true
                    }

                    if (!dragDropEnabled) {
                        return true
                    }

                    val page = pages[getCurrentAppsPageNumber()]

                    if (cX - mDeviceProfile.iconSizePx / 10 > mDeviceProfile.availableWidthPx - 2 * scrollCorner) {
                        if (getCurrentAppsPageNumber() + 1 < pages.size) {
                            mHorizontalPager.scrollRight(300)
                        } else if (getCurrentAppsPageNumber() + 1 == pages.size &&
                            getGridFromPage(page).childCount > 1
                        ) {
                            val layout = preparePage()
                            pages.add(layout)
                            addHomePageToPager(layout)
                            refreshPageIndicator()
                        }
                    } else if (cX + mDeviceProfile.iconSizePx / 10 < 2 * scrollCorner) {
                        if (getCurrentAppsPageNumber() == 0) {
                            return true
                        }
                        if (getCurrentAppsPageNumber() - 1 >= 0) {
                            mHorizontalPager.scrollLeft(300)
                        } else if (getCurrentAppsPageNumber() + 1 == pages.size - 2 &&
                            getGridFromPage(pages[pages.size - 1]).childCount <= 0
                        ) {
                            mHorizontalPager.removeViewAt(pages.size)
                            pages.removeAt(pages.size - 1)
                            refreshPageIndicator()
                        }
                    } else {
                        val index = getIndex(page, cX, cY)
                        if (index == getGridFromPage(page).indexOfChild(moving)) {
                            discardCollidingApp()
                            return true
                        }

                        if (index == EMPTY_LOCATION_DRAG) {
                            discardCollidingApp()
                        } else {
                            val latestCollidingApp = getGridFromPage(page).getChildAt(index)
                            if (collidingApp !== latestCollidingApp) {
                                collidingApp?.let { makeAppCold(it, !((it.parent as View).parent is HorizontalPager)) }
                                collidingApp = latestCollidingApp as BlissFrameLayout
                                folderInterest = false
                            }

                            if (getAppDetails(moving).itemType == Constants.ITEM_TYPE_FOLDER) {
                                folderInterest = false
                            } else {
                                latestFolderInterest = checkIfFolderInterest(
                                    getGridFromPage(pages[getCurrentAppsPageNumber()]),
                                    index,
                                    cX,
                                    cY
                                )

                                if (latestFolderInterest != folderInterest) {
                                    folderInterest = latestFolderInterest
                                }
                                if (folderInterest) {
                                    cleanupReorder(true)
                                    cleanupDockReorder(true)
                                    makeAppHot(collidingApp)
                                } else {
                                    collidingApp?.let { makeAppCold(it, !((it.parent as View).parent is HorizontalPager)) }
                                }
                            }
                        }

                        if (!folderInterest && !mReorderAlarm.alarmPending()) {
                            val targetCell = dropCellForHomeGrid(page, cX, cY)
                                .takeUnless { isAutoRearrangeAppsEnabled() }
                            val reorderAlarmListener = ReorderAlarmListener(
                                page,
                                moving.parent as ViewGroup,
                                index,
                                targetCell
                            )
                            mReorderAlarm.setOnAlarmListener(reorderAlarmListener)
                            mReorderAlarm.setAlarm(REORDER_TIMEOUT.toLong())
                        }
                    }
                } else if (dragEvent.action == DragEvent.ACTION_DROP) {
                    if (moving == null || shadow == null) return true
                    cleanupReorder(true)
                    cleanupDockReorder(true)
                    if (mFolderWindowContainer.visibility != VISIBLE) {
                        cX = dragEvent.x - shadow.xOffset
                        cY = mHorizontalPager.y + dragEvent.y - shadow.yOffset
                        val gridLayout = pages[getCurrentAppsPageNumber()]
                        if (!folderInterest) {
                            if (LauncherDropCommitPolicy.shouldAttachToTargetPage(
                                    movingHasParent = moving.parent != null,
                                    movingParentIsTargetPage = moving.parent === gridLayout
                                )
                            ) {
                                commitDroppedAppToPage(gridLayout, moving, cX, cY)
                            }

                            moving.visibility = VISIBLE
                            makeAppWobble(moving, true, gridLayout.indexOfChild(moving))
                        } else {
                            if ((collidingApp?.parent as? View)?.parent is HorizontalPager) {
                                createOrUpdateFolder(false)
                            } else {
                                createOrUpdateFolder(true)
                            }
                            folderInterest = false
                        }
                    } else {
                        cX = dragEvent.x - shadow.xOffset
                        cY = mHorizontalPager.y + dragEvent.y - shadow.yOffset

                        val topLeftCorner = IntArray(2)
                        mFolderAppsViewPager.getLocationOnScreen(topLeftCorner)
                        val left = topLeftCorner[0]
                        val top = topLeftCorner[1]
                        val right = left + mFolderAppsViewPager.width
                        val bottom = top + mFolderAppsViewPager.height

                        if (!(left < right && top < bottom && cX >= left && cX < right && cY >= top && cY < bottom)) {
                            removeAppFromFolder()
                        } else {
                            moving.visibility = VISIBLE
                            val currentItem = mFolderAppsViewPager.currentItem
                            val gridLayout = mFolderAppsViewPager.getChildAt(currentItem) as? GridLayout
                            if (gridLayout != null) {
                                makeAppWobble(moving, true, gridLayout.indexOfChild(moving))
                            }
                        }
                    }
                } else if (dragEvent.action == DragEvent.ACTION_DRAG_ENDED) {
                    if (moving == null) return true
                    if (isDragging) {
                        isDragging = false
                    }

                    cleanupReorder(true)
                    cleanupDockReorder(true)

                    if (!dragEvent.result) {
                        if (mFolderWindowContainer.visibility == VISIBLE) {
                            val currentItem = mFolderAppsViewPager.currentItem
                            makeAppWobble(
                                moving,
                                true,
                                (mFolderAppsViewPager.getChildAt(currentItem) as GridLayout).indexOfChild(moving)
                            )
                        } else if ((moving.parent as View).parent is HorizontalPager) {
                            val gridLayout = pages[getCurrentAppsPageNumber()]
                            makeAppWobble(moving, true, gridLayout.indexOfChild(moving))
                        } else {
                            makeAppWobble(moving, true, mDock.indexOfChild(moving))
                        }
                    }

                    Handler(Looper.getMainLooper()).post {
                        moving.visibility = VISIBLE
                        movingApp = null
                        dragStartHomePage = -1
                        dragStartHomeCell = LauncherItem.INVALID_CELL
                    }

                    mWobblingCountDownTimer?.cancel()
                    mLongClickStartsDrag = false
                    mWobblingCountDownTimer = object : CountDownTimer(25000, 1000) {
                        override fun onTick(millisUntilFinished: Long) = Unit

                        override fun onFinish() {
                            if (isWobbling) {
                                handleWobbling(false)
                            }
                        }
                    }.start()

                    var i = 0
                    while (i < pages.size) {
                        if (pages[i].childCount <= 0) {
                            pages.removeAt(i)
                            mHorizontalPager.removeViewAt(i + 1)
                            if (i == pages.size) {
                                mHorizontalPager.scrollLeft(100)
                            }
                            refreshPageIndicator()
                            i--
                        }
                        i++
                    }
                    DatabaseManager.getManager(this@LauncherActivity).saveLayouts(pages, mDock)
                }

                return true
            }
        })
    }

    private fun commitDroppedAppToPage(gridLayout: GridLayout, moving: BlissFrameLayout, dropX: Float, dropY: Float) {
        if (moving.parent !== gridLayout && gridLayout.childCount >= mDeviceProfile.maxAppsPerPage) {
            return
        }

        val targetCell = dropCellForHomeGrid(gridLayout, dropX, dropY)
            .takeUnless { isAutoRearrangeAppsEnabled() }
        if (targetCell != null) {
            swapOccupiedHomeCellIfNeeded(gridLayout, moving, targetCell)
        }
        (moving.parent as? ViewGroup)?.removeView(moving)
        if (targetCell != null) {
            moving.launcherItem.cell = targetCell
        }
        val requestedIndex = getIndex(gridLayout, dropX, dropY)
        val targetIndex = LauncherDropCommitPolicy.targetInsertIndex(requestedIndex, gridLayout.childCount)
        addAppToGrid(gridLayout, moving, targetIndex)
        relayoutHomePageCells(gridLayout)
        parentPage = getCurrentAppsPageNumber()
    }

    private fun swapOccupiedHomeCellIfNeeded(
        gridLayout: GridLayout,
        moving: BlissFrameLayout,
        targetCell: Int
    ) {
        val displacedApp = findHomeCellOccupant(gridLayout, targetCell, except = moving) ?: return
        val movingOriginalCell = if (dragStartHomePage == getCurrentAppsPageNumber()) {
            dragStartHomeCell
        } else {
            LauncherItem.INVALID_CELL
        }
        val displacedCell = LauncherHomeCellPolicy.displacedCellForCollision(
            movingOriginalCell = movingOriginalCell,
            targetCell = targetCell,
            occupiedCells = occupiedHomeCells(gridLayout, except = moving),
            maxCells = mDeviceProfile.maxAppsPerPage
        )
        displacedApp.launcherItem.cell = displacedCell
        applyHomeCellLayoutParams(gridLayout, displacedApp, displacedCell, mDeviceProfile.cellWidthPx)
    }

    private fun previewDroppedAppToPage(
        gridLayout: GridLayout,
        moving: BlissFrameLayout,
        targetCell: Int
    ) {
        val movingCurrentCell = moving.launcherItem.cell
        (moving.parent as? ViewGroup)?.removeView(moving)
        if (gridLayout.childCount >= mDeviceProfile.maxAppsPerPage) {
            return
        }

        val preview = LauncherHomeCellPolicy.collisionPreview(
            movingCurrentCell = movingCurrentCell,
            targetCell = targetCell,
            occupiedCells = occupiedHomeCells(gridLayout, except = moving),
            maxCells = mDeviceProfile.maxAppsPerPage
        )
        val displacedCell = preview.displacedCell
        if (displacedCell != null) {
            findHomeCellOccupant(gridLayout, preview.movingCell, except = moving)?.let { displacedApp ->
                applyHomeCellLayoutParams(
                    gridLayout,
                    displacedApp,
                    displacedCell,
                    mDeviceProfile.cellWidthPx
                )
            }
        }
        addAppToGridAtCell(gridLayout, moving, preview.movingCell, mDeviceProfile.cellWidthPx)
        relayoutHomePageCells(gridLayout)
        parentPage = getCurrentAppsPageNumber()
    }

    private fun dropCellForHomeGrid(gridLayout: GridLayout, dropX: Float, dropY: Float): Int {
        val gridLeft = gridLayout.left - mHorizontalPager.scrollX
        val gridTop = mHorizontalPager.y.toInt() + gridLayout.top
        return LauncherHomeCellPolicy.dropCell(
            dropX = dropX,
            dropY = dropY,
            gridLeft = gridLeft,
            gridTop = gridTop,
            paddingLeft = gridLayout.paddingLeft,
            paddingTop = gridLayout.paddingTop,
            cellWidth = mDeviceProfile.cellWidthPx,
            cellHeight = homeCellHeightForPage(gridLayout),
            rows = gridLayout.rowCount,
            columns = gridLayout.columnCount
        )
    }

    private fun cleanupDockReorder(cancelAlarm: Boolean) {
        if (cancelAlarm) {
            mDockReorderAlarm.cancelAlarm()
        }
    }

    private fun cleanupReorder(cancelAlarm: Boolean) {
        if (cancelAlarm) {
            mReorderAlarm.cancelAlarm()
        }
    }

    private fun removeAppFromFolder() {
        val moving = movingApp ?: return
        val folder = activeFolder ?: return
        val folderView = activeFolderView ?: return
        if (pages[getCurrentAppsPageNumber()].childCount >= mDeviceProfile.maxAppsPerPage) {
            Toast.makeText(this, getString(R.string.toast_no_room), Toast.LENGTH_SHORT).show()
            moving.visibility = VISIBLE
            val currentItem = mFolderAppsViewPager.currentItem
            makeAppWobble(
                moving,
                true,
                (mFolderAppsViewPager.getChildAt(currentItem) as GridLayout).indexOfChild(moving)
            )
        } else {
            val app = getAppDetails(moving)
            folder.items!!.remove(app)
            mFolderAppsViewPager.adapter?.notifyDataSetChanged()
            app.container = if (folderFromDock) Constants.CONTAINER_HOTSEAT.toLong() else Constants.CONTAINER_DESKTOP.toLong()
            app.screenId = if (folderFromDock) -1 else currentPageNumber.toLong()

            if (folder.items!!.isEmpty()) {
                val view = prepareLauncherItem(app)
                if (folderFromDock) {
                    val index = mDock.indexOfChild(folderView)
                    removeUninstallIcon(folderView)
                    mDock.removeView(folderView)
                    addAppToDock(view, index)
                    makeAppWobble(view, true, index)
                } else {
                    val gridLayout = pages[getCurrentAppsPageNumber()]
                    val index = gridLayout.indexOfChild(folderView)
                    folderView.clearAnimation()
                    removeUninstallIcon(folderView)
                    gridLayout.removeView(folderView)
                    addAppToGrid(gridLayout, view, index)
                    makeAppWobble(view, true, index)
                }
                DatabaseManager.getManager(this).removeLauncherItem(folder.id)
            } else {
                if (folder.items!!.size == 1) {
                    val item = folder.items!![0]
                    folder.items!!.remove(item)
                    mFolderAppsViewPager.adapter?.notifyDataSetChanged()
                    item.container = if (folderFromDock) Constants.CONTAINER_HOTSEAT.toLong() else Constants.CONTAINER_DESKTOP.toLong()
                    item.screenId = if (folderFromDock) -1 else currentPageNumber.toLong()
                    val view = prepareLauncherItem(item)
                    if (folderFromDock) {
                        val index = mDock.indexOfChild(folderView)
                        folderView.clearAnimation()
                        removeUninstallIcon(folderView)
                        mDock.removeView(folderView)
                        addAppToDock(view, index)
                        makeAppWobble(view, true, index)
                    } else {
                        val gridLayout = pages[getCurrentAppsPageNumber()]
                        val index = gridLayout.indexOfChild(folderView)
                        folderView.clearAnimation()
                        removeUninstallIcon(folderView)
                        gridLayout.removeView(folderView)
                        addAppToGrid(gridLayout, view, index)
                        makeAppWobble(view, true, index)
                    }
                    DatabaseManager.getManager(this).removeLauncherItem(folder.id)
                } else {
                    updateIcon(folderView, folder, GraphicsUtil(this).generateFolderIcon(this, folder), folderFromDock)
                    folderView.applyBadge(checkHasApp(folder, mAppsWithNotifications), !folderFromDock)
                }
                if (moving.parent != null) {
                    (moving.parent as ViewGroup).removeView(moving)
                }
                val current = getCurrentAppsPageNumber()
                addAppToGrid(pages[current], moving)
                makeAppWobble(moving, true, pages[current].childCount - 1)
            }

            hideFolderWindowContainer()
            moving.visibility = VISIBLE
        }
    }

    private fun discardCollidingApp() {
        val app = collidingApp
        if (app != null) {
            makeAppCold(app, !((app.parent as View).parent is HorizontalPager))
            collidingApp = null
            folderInterest = false
        }
    }

    private fun createOrUpdateFolder(fromDock: Boolean) {
        val colliding = collidingApp ?: return
        val moving = movingApp ?: return
        colliding.clearAnimation()

        val index = if (fromDock) {
            mDock.indexOfChild(colliding)
        } else {
            getGridFromPage(pages[getCurrentAppsPageNumber()]).indexOfChild(colliding)
        }

        val app1 = getAppDetails(colliding)
        val app2 = getAppDetails(moving)

        if (app1.itemType == Constants.ITEM_TYPE_FOLDER) {
            val folderItem = app1 as FolderItem
            app2.container = folderItem.id.toLong()
            app2.screenId = -1
            app2.cell = folderItem.items!!.size
            folderItem.items!!.add(app2)
            updateIcon(colliding, app1, GraphicsUtil(this).generateFolderIcon(this, folderItem), folderFromDock)
            colliding.applyBadge(checkHasApp(folderItem, mAppsWithNotifications), !fromDock)
            makeAppWobble(colliding, true, index)
        } else {
            val folder = FolderItem()
            folder.title = getString(R.string.untitled)
            folder.id = System.currentTimeMillis().toString()
            folder.items = ArrayList()
            app1.container = folder.id.toLong()
            app2.container = folder.id.toLong()
            app1.screenId = -1
            app2.screenId = -1
            app1.cell = folder.items!!.size
            folder.items!!.add(app1)
            app2.cell = folder.items!!.size
            folder.items!!.add(app2)
            val folderIcon = GraphicsUtil(this).generateFolderIcon(this, app1.icon!!, app2.icon!!)
            folder.icon = folderIcon
            val folderView = prepareLauncherItem(folder)
            makeAppWobble(colliding, false, index)
            (colliding.parent as ViewGroup).removeView(colliding)
            if (fromDock) {
                addAppToDock(folderView, index)
            } else {
                addAppToGrid(pages[getCurrentAppsPageNumber()], folderView, index)
            }
            makeAppWobble(folderView, true, index)
        }

        if (moving.parent != null) {
            (moving.parent as ViewGroup).removeView(moving)
        }

        makeAppCold(colliding, fromDock)
        makeAppCold(moving, fromDock)
    }

    private fun updateIcon(appView: BlissFrameLayout, app: LauncherItem, drawable: Drawable?, folderFromDock: Boolean) {
        app.icon = drawable
        val tags = appView.tag as List<*>
        val iv = tags[0] as SquareImageView
        iv.setImageDrawable(drawable)
    }

    private fun makeAppHot(app: View?) {
        if (app == null) {
            return
        }
        app.scaleX = 1.2f
        app.scaleY = 1.2f
    }

    @Synchronized
    private fun makeAppCold(app: View?, fromDock: Boolean) {
        if (app == null) {
            return
        }

        val views = app.tag as List<*>
        if (!fromDock) {
            (views[1] as View).visibility = VISIBLE
        } else {
            (views[1] as View).visibility = GONE
        }
        app.scaleX = 1.0f
        app.scaleY = 1.0f
        collidingApp = null
    }

    private fun getAppDetails(app: View?): LauncherItem =
        (app as? BlissFrameLayout)?.launcherItem ?: error("Expected BlissFrameLayout")

    private fun checkIfFolderInterest(view: ViewGroup, index: Int, x: Float, y: Float): Boolean {
        val v = view.getChildAt(index).findViewById<View>(R.id.app_icon)
        val r = Rect()
        v.getGlobalVisibleRect(r)
        val vx = r.left + (r.right - r.left) / 2f
        val vy = r.top + (r.bottom - r.top) / 2f
        val distance = getDistance(x, y, vx, vy)
        return distance < maxDistanceForFolderCreation
    }

    private fun getGridFromPage(page: ViewGroup): GridLayout = page as GridLayout

    private fun getDistance(x1: Float, y1: Float, x2: Float, y2: Float): Double =
        sqrt((x2 - x1).toDouble().pow(2.0) + (y2 - y1).toDouble().pow(2.0))

    private fun getIndex(page: ViewGroup, x: Float, y: Float): Int {
        var minDistance = Float.MAX_VALUE
        var index = EMPTY_LOCATION_DRAG

        for (i in 0 until page.childCount) {
            val v = page.getChildAt(i).findViewById<View>(R.id.app_icon)
            val r = Rect()
            v.getGlobalVisibleRect(r)
            val r2 = Rect(
                (x - mDeviceProfile.iconSizePx / 2).toInt(),
                (y - mDeviceProfile.iconSizePx / 2).toInt(),
                (x + mDeviceProfile.iconSizePx / 2).toInt(),
                (y + mDeviceProfile.iconSizePx / 2).toInt()
            )
            if (Rect.intersects(r, r2)) {
                val vx = r.left + (r.right - r.left) / 2f
                val vy = r.top + (r.bottom - r.top) / 2f
                val distance = hypot(vx - x, vy - y)
                if (minDistance > distance) {
                    minDistance = distance
                    index = i
                }
            }
        }
        return index
    }

    private fun getDefaultLayoutTransition(): LayoutTransition {
        val transition = LayoutTransition()
        transition.disableTransitionType(LayoutTransition.APPEARING)
        transition.disableTransitionType(LayoutTransition.DISAPPEARING)
        transition.setStartDelay(LayoutTransition.CHANGE_APPEARING, 0)
        transition.setStartDelay(LayoutTransition.CHANGE_DISAPPEARING, 0)
        transition.addTransitionListener(object : LayoutTransition.TransitionListener {
            override fun startTransition(layoutTransition: LayoutTransition, viewGroup: ViewGroup, view: View, i: Int) {
                dragDropEnabled = false
            }

            override fun endTransition(layoutTransition: LayoutTransition, viewGroup: ViewGroup, view: View, i: Int) {
                dragDropEnabled = true
            }
        })
        return transition
    }

    private fun createIndicator() {
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        indicatorWheelView = null
        showSearchControlInIndicator(false)
        updateWorkspaceChromeForPage(currentPageNumber)
    }

    private fun refreshPageIndicator() {
        if (currentPageNumber == WIDGET_PAGE) {
            hideWidgetPageIndicator()
            return
        }

        if (isHomePage(currentPageNumber)) {
            if (isWobbling || indicatorMode == IndicatorMode.DOTS) {
                showDotsInIndicator(homePagePositionForPagerPage(currentPageNumber), false)
            } else {
                showSearchControlInIndicator(false)
            }
        } else {
            updateWorkspaceChromeForPage(currentPageNumber)
        }
    }

    private fun hideWidgetPageIndicator() {
        if (!::mIndicator.isInitialized) {
            return
        }

        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        mIndicator.animate().cancel()
        mIndicator.isClickable = false
        mIndicator.alpha = 0f
        mIndicator.visibility = GONE
    }

    private fun showPageIndicator(page: Int) {
        if (!isHomePage(page)) {
            hideWidgetPageIndicator()
            return
        }

        if (homeIndicatorPageCount() <= 1) {
            showSearchControlInIndicator(false)
            return
        }

        showDotsInIndicator(homePagePositionForPagerPage(page), true)
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        if (!isWobbling) {
            indicatorHandler.postDelayed(hideIndicatorRunnable, PAGE_INDICATOR_VISIBLE_MS)
        }
    }

    private fun hidePageIndicator() {
        if (isWobbling) {
            return
        }
        showSearchControlInIndicator(true)
    }

    private fun updatePageIndicatorDots(selectedPosition: Int) {
        if (indicatorMode != IndicatorMode.DOTS && !isWobbling) {
            return
        }

        val pageCount = homeIndicatorPageCount()
        if (pageCount <= 1) {
            return
        }

        val selectedPage = max(0, min(selectedPosition, pageCount - 1))
        ensureIndicatorWheelView().setMarkers(
            LauncherPageIndicatorWindowPolicy.markers(
                pageCount,
                selectedPage,
                LauncherPageIndicatorWindowPolicy.DEFAULT_MAX_VISIBLE_MARKERS
            ),
            false
        )
    }

    private fun showDotsInIndicator(position: Int, animate: Boolean) {
        showDotsIndicatorFrame()
        updatePageIndicatorDots(position)
        if (animate) {
            mIndicator.animate()
                .alpha(1f)
                .setDuration(120L)
                .setInterpolator(DecelerateInterpolator())
                .start()
        }
    }

    private fun updatePageIndicatorScroll(scrollX: Int) {
        if (pages.isEmpty()) {
            return
        }
        val pageWidth = max(1, mHorizontalPager.getPageWidth())
        val pagerPosition = scrollX / pageWidth.toFloat()
        if (pagerPosition < 1f) {
            hideWidgetPageIndicator()
            return
        }
        val fromPage = floor(pagerPosition).toInt()
        if (!isHomePage(fromPage) && !isHomePage(fromPage + 1)) {
            return
        }

        val pageCount = homeIndicatorPageCount()
        if (pageCount <= 1) {
            return
        }

        val homePagePosition = max(0f, min(pagerPosition - 1f, pageCount - 1f))
        showDotsIndicatorFrame()
        ensureIndicatorWheelView().setScrollPosition(pageCount, homePagePosition)
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        if (!isWobbling) {
            indicatorHandler.postDelayed(hideIndicatorRunnable, PAGE_INDICATOR_VISIBLE_MS)
        }
    }

    private fun showDotsIndicatorFrame() {
        indicatorMode = IndicatorMode.DOTS
        ensureDotsIndicatorFrame()
        ensureIndicatorWheelView()
        if (homeIndicatorPageCount() <= 1) {
            mIndicator.removeAllViews()
            mIndicator.visibility = GONE
            return
        }
        mIndicator.animate().cancel()
        mIndicator.isClickable = false
        mIndicator.alpha = 1f
        mIndicator.visibility = VISIBLE
    }

    private fun showSearchControlInIndicator(animated: Boolean) {
        if (!isHomePage(currentPageNumber) || isWobbling) {
            return
        }

        indicatorMode = IndicatorMode.SEARCH
        ensureSearchIndicatorFrame()
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        mIndicator.animate().cancel()
        mIndicator.isClickable = true
        mIndicator.alpha = 1f
        mIndicator.visibility = VISIBLE
        mIndicator.removeAllViews()
        mIndicator.addView(createIndicatorSearchText())
        if (animated) {
            val child = mIndicator.getChildAt(0)
            if (child != null) {
                child.alpha = 0f
                child.animate()
                    .alpha(1f)
                    .setDuration(150L)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
            }
        }
    }

    private fun createIndicatorSearchText(): TextView {
        val searchText = TextView(this)
        searchText.text = getString(R.string.launcher_search_hint)
        searchText.gravity = Gravity.CENTER
        searchText.includeFontPadding = false
        searchText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search_18, 0, 0, 0)
        searchText.compoundDrawablePadding = dp(4)
        searchText.setTextColor(Color.WHITE)
        searchText.textSize = 12f
        searchText.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        searchText.isClickable = true
        searchText.isFocusable = true
        searchText.setOnClickListener { openSearchFromIndicator() }
        return searchText
    }

    private fun openSearchFromIndicator() {
        if (!::swipeSearchContainer.isInitialized) {
            return
        }
        when (
            LauncherSearchEntryPolicy.indicatorTapAction(
                indicatorShowsSearch = indicatorMode == IndicatorMode.SEARCH,
                searchVisible = swipeSearchContainer.visibility == VISIBLE,
                editing = isWobbling
            )
        ) {
            LauncherSearchEntryPolicy.IndicatorTapAction.OPEN_SEARCH -> showSwipeSearchContainer()
            LauncherSearchEntryPolicy.IndicatorTapAction.IGNORE -> Unit
        }
    }

    private fun ensureDotsIndicatorFrame() {
        val layoutParams = mIndicator.layoutParams
        layoutParams.width = dp(PAGE_INDICATOR_SEARCH_WIDTH_DP)
        layoutParams.height = dp(PAGE_INDICATOR_SEARCH_HEIGHT_DP)
        mIndicator.layoutParams = layoutParams
        mIndicator.setPadding(dp(PAGE_INDICATOR_DOT_PADDING_DP), 0, dp(PAGE_INDICATOR_DOT_PADDING_DP), 0)
        mIndicator.layoutTransition = null
    }

    private fun ensureIndicatorWheelView(): LauncherPageIndicatorWheelView {
        val existing = indicatorWheelView
        if (existing != null && existing.parent === mIndicator) {
            return existing
        }

        val wheelView = LauncherPageIndicatorWheelView(this)
        wheelView.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        mIndicator.removeAllViews()
        mIndicator.addView(wheelView)
        indicatorWheelView = wheelView
        return wheelView
    }

    private fun ensureSearchIndicatorFrame() {
        val layoutParams = mIndicator.layoutParams
        layoutParams.width = dp(PAGE_INDICATOR_SEARCH_WIDTH_DP)
        layoutParams.height = dp(PAGE_INDICATOR_SEARCH_HEIGHT_DP)
        mIndicator.layoutParams = layoutParams
        mIndicator.setPadding(dp(10), 0, dp(10), 0)
        indicatorWheelView = null
    }

    private fun homeIndicatorPageCount(): Int = pages.size

    private fun updateWorkspaceChromeForPage(page: Int) {
        if (isAppLibraryPage(page)) {
            indicatorHandler.removeCallbacks(hideIndicatorRunnable)
            mDock.visibility = GONE
            mIndicator.visibility = GONE
        } else {
            mDock.visibility = VISIBLE
        }

        if (!isHomePage(page)) {
            indicatorHandler.removeCallbacks(hideIndicatorRunnable)
            mIndicator.visibility = GONE
        } else if (isWobbling) {
            showDotsInIndicator(homePagePositionForPagerPage(page), false)
            mIndicator.visibility = VISIBLE
        } else if (indicatorMode == IndicatorMode.SEARCH) {
            showSearchControlInIndicator(false)
        }
    }

    private fun isHomePage(page: Int): Boolean = page >= 1 && page <= pages.size

    private fun isAppLibraryPage(page: Int): Boolean = appLibraryPage != null && page == pages.size + 1

    private fun homePagePositionForPagerPage(page: Int): Int {
        val lastPage = max(0, homeIndicatorPageCount() - 1)
        return max(0, min(page - 1, lastPage))
    }

    private fun dp(value: Int): Int {
        return Utilities.pxFromDp(value.toFloat(), resources.displayMetrics)
    }

    override fun onBackPressed() {
        returnToHomeScreen()
    }

    private fun displayFolder(app: FolderItem, v: BlissFrameLayout) {
        currentAnimator?.cancel()
        forceHideSwipeSearchForFolder()

        activeFolder = app
        activeFolderView = v
        val folderMetrics = folderOpenMetrics()
        applyFolderOpenMetrics(folderMetrics)
        applyLiquidGlassAppearance()

        startBounds = Rect()
        finalBounds = Rect()
        val globalOffset = Point()

        v.getGlobalVisibleRect(startBounds)
        findViewById<View>(R.id.workspace).getGlobalVisibleRect(finalBounds, globalOffset)
        startBounds.offset(-globalOffset.x, -globalOffset.y)
        finalBounds.offset(-globalOffset.x, -globalOffset.y)

        val startScale: Float
        if (finalBounds.width().toFloat() / finalBounds.height() >
            startBounds.width().toFloat() / startBounds.height()
        ) {
            startScale = startBounds.height().toFloat() / finalBounds.height()
            val startWidth = startScale * finalBounds.width()
            val deltaWidth = ((startWidth - startBounds.width()) / 2).toInt()
            startBounds.left -= deltaWidth
            startBounds.right += deltaWidth
        } else {
            startScale = startBounds.width().toFloat() / finalBounds.width()
            val startHeight = startScale * finalBounds.height()
            val deltaHeight = ((startHeight - startBounds.height()) / 2).toInt()
            startBounds.top -= deltaHeight
            startBounds.bottom += deltaHeight
        }

        val set = AnimatorSet()
        set.play(ObjectAnimator.ofFloat(mFolderWindowContainer, View.X, startBounds.left.toFloat(), finalBounds.left.toFloat()))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.Y, startBounds.top.toFloat(), finalBounds.top.toFloat()))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.SCALE_X, startScale, 1f))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.SCALE_Y, startScale, 1f))
            .with(ObjectAnimator.ofFloat(blurLayer, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.ALPHA, FolderOpenLayoutPolicy.BACKGROUND_CONTENT_ALPHA))
            .with(ObjectAnimator.ofFloat(mIndicator, View.ALPHA, 0f))
            .with(ObjectAnimator.ofFloat(mDock, View.ALPHA, FolderOpenLayoutPolicy.BACKGROUND_CONTENT_ALPHA))
        set.duration = 300
        set.interpolator = LinearInterpolator()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                mFolderWindowContainer.visibility = VISIBLE
                mFolderWindowContainer.bringToFront()
                mFolderWindowContainer.pivotX = 0f
                mFolderWindowContainer.pivotY = 0f
            }

            override fun onAnimationEnd(animation: Animator) {
                currentAnimator = null
                blurLayer.alpha = 1f
                mHorizontalPager.alpha = FolderOpenLayoutPolicy.BACKGROUND_CONTENT_ALPHA
                mIndicator.alpha = 0f
                mDock.alpha = FolderOpenLayoutPolicy.BACKGROUND_CONTENT_ALPHA
            }

            override fun onAnimationCancel(animation: Animator) {
                currentAnimator = null
                mFolderWindowContainer.visibility = GONE
                blurLayer.alpha = 0f
                mHorizontalPager.alpha = 1f
                mIndicator.alpha = 1f
                mDock.alpha = 1f
            }
        })
        set.start()
        currentAnimator = set
        startScaleFinal = startScale

        mFolderTitleInput.setText(app.title)
        mFolderTitleInput.isCursorVisible = false

        mFolderAppsViewPager.adapter = FolderAppsPagerAdapter(this, app.items!!)
        (mLauncherView.findViewById<View>(R.id.indicator) as CircleIndicator).setViewPager(mFolderAppsViewPager)
    }

    private fun folderOpenMetrics(): FolderOpenLayoutPolicy.Metrics =
        FolderOpenLayoutPolicy.metrics(
            availableWidth = mDeviceProfile.availableWidthPx,
            availableHeight = mDeviceProfile.availableHeightPx,
            homeCellHeight = mDeviceProfile.cellHeightPx,
            iconSize = mDeviceProfile.iconSizePx,
            density = resources.displayMetrics.density
        )

    private fun applyFolderOpenMetrics(metrics: FolderOpenLayoutPolicy.Metrics) {
        val folderBlur = mLauncherView.findViewById<View>(R.id.folder_bg_blur)
        folderBlur.layoutParams = folderBlur.layoutParams.apply {
            width = metrics.panelWidth
            height = metrics.panelHeight
        }

        val folderBackground = mLauncherView.findViewById<View>(R.id.folder_apps_background)
        folderBackground.layoutParams = folderBackground.layoutParams.apply {
            width = metrics.panelWidth
            height = metrics.panelHeight
        }

        mFolderAppsViewPager.layoutParams = mFolderAppsViewPager.layoutParams.apply {
            width = metrics.panelWidth
            height = metrics.gridHeight
        }

        val folderIndicator = mLauncherView.findViewById<View>(R.id.indicator)
        folderIndicator.layoutParams = folderIndicator.layoutParams.apply {
            width = metrics.panelWidth
            height = metrics.indicatorHeight
        }

        (mFolderTitleInput.layoutParams as? RelativeLayout.LayoutParams)?.let { titleParams ->
            titleParams.bottomMargin = metrics.titleBottomGap
            mFolderTitleInput.layoutParams = titleParams
        }
        mFolderTitleInput.setTextSize(TypedValue.COMPLEX_UNIT_SP, metrics.titleTextSizeSp)
        mFolderTitleInput.setTextColor(Color.argb(215, 255, 255, 255))
        mFolderTitleInput.setTypeface(Typeface.DEFAULT, Typeface.NORMAL)
    }

    private fun forceHideSwipeSearchForFolder() {
        if (!::swipeSearchContainer.isInitialized) {
            return
        }
        swipeSearchContainer.animate().cancel()
        swipeSearchContainer.visibility = GONE
        swipeSearchContainer.translationY = mDeviceProfile.availableHeightPx.toFloat()
        swipeSearchContainer.findViewById<BlissInput>(R.id.search_input).setText("")
        swipeSearchContainer.findViewById<View>(R.id.search_input).clearFocus()
        if (searchDisposableObserver?.isDisposed == false) {
            searchDisposableObserver?.dispose()
        }
        showSwipeSearch = false
    }

    private fun getLauncherView(): Bitmap {
        val view = window.decorView.rootView
        view.isDrawingCacheEnabled = true
        view.buildDrawingCache(true)
        val bitmap = Bitmap.createBitmap(view.drawingCache)
        view.isDrawingCacheEnabled = false
        return bitmap
    }

    private fun hideFolderWindowContainer() {
        DatabaseManager.getManager(this@LauncherActivity).saveLayouts(pages, mDock)
        mFolderTitleInput.clearFocus()
        folderFromDock = false
        currentAnimator?.cancel()

        val set = AnimatorSet()
        set.play(ObjectAnimator.ofFloat(mFolderWindowContainer, View.X, startBounds.left.toFloat()))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.Y, startBounds.top.toFloat()))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.SCALE_X, startScaleFinal))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.SCALE_Y, startScaleFinal))
            .with(ObjectAnimator.ofFloat(blurLayer, View.ALPHA, 0f))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mIndicator, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mDock, View.ALPHA, 1f))
        set.duration = 300
        set.interpolator = LinearInterpolator()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                mHorizontalPager.visibility = VISIBLE
                mDock.visibility = VISIBLE
                mIndicator.visibility = VISIBLE
            }

            override fun onAnimationEnd(animation: Animator) {
                mFolderWindowContainer.visibility = GONE
                currentAnimator = null
                blurLayer.alpha = 0f
                mHorizontalPager.alpha = 1f
                mIndicator.alpha = 1f
                mDock.alpha = 1f
            }

            override fun onAnimationCancel(animation: Animator) {
                mFolderWindowContainer.visibility = GONE
                currentAnimator = null
                blurLayer.alpha = 0f
                mHorizontalPager.alpha = 1f
                mIndicator.alpha = 1f
                mDock.alpha = 1f
            }
        })
        set.start()
        currentAnimator = set
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val alreadyOnHome = hasWindowFocus() &&
            intent.flags and Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT != Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT

        val shouldMoveToDefaultScreen = alreadyOnHome &&
            swipeSearchContainer.visibility != VISIBLE &&
            !isWobbling &&
            mFolderWindowContainer.visibility != VISIBLE &&
            (activeRoundedWidgetView == null || activeRoundedWidgetView?.isWidgetActivated() != true)

        if (alreadyOnHome) {
            returnToHomeScreen()
        }

        if (shouldMoveToDefaultScreen) {
            mHorizontalPager.visibility = VISIBLE
            mHorizontalPager.alpha = 1f
            mDock.visibility = VISIBLE
            mDock.alpha = 1f
            mIndicator.visibility = VISIBLE
            mIndicator.alpha = 1f
            mHorizontalPager.snapToPage(1)
        }
    }

    private fun returnToHomeScreen() {
        if (renameAppPanel != null) {
            hideRenameAppPicker()
            return
        }

        if (widgetPreviewOverlay != null) {
            dismissTodayWidgetPreview()
            return
        }

        if (widgetPickerOverlay != null) {
            dismissTodayWidgetPicker()
            return
        }

        if (appLibrarySearchOverlay != null) {
            hideAppLibrarySearchOverlay(animated = true)
            return
        }

        if (appLibraryDetailOverlay != null) {
            hideAppLibraryDetailOverlay(animated = true)
            return
        }

        if (launcherOptionsPopup != null || (::contextOverlay.isInitialized && contextOverlay.visibility == VISIBLE)) {
            dismissLauncherOptionsPopup()
            return
        }

        if (activeRoundedWidgetView != null && activeRoundedWidgetView?.isWidgetActivated() == true) {
            hideWidgetResizeContainer()
        }

        mSearchInput?.setText("")

        if (swipeSearchContainer.visibility == VISIBLE) {
            hideSwipeSearchContainer()
        }

        if (isWobbling) {
            handleWobbling(false)
        } else if (isTodayWidgetEditing) {
            setTodayWidgetEditing(false)
        } else if (mFolderWindowContainer.visibility == VISIBLE) {
            hideFolderWindowContainer()
        }
    }

    private fun showSwipeSearchContainer() {
        currentAnimator?.cancel()
        val animationDuration = (blurLayer.alpha * 300).toInt()
        val set = AnimatorSet()
        set.play(ObjectAnimator.ofFloat(swipeSearchContainer, View.TRANSLATION_Y, 0f))
            .with(ObjectAnimator.ofFloat(blurLayer, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.ALPHA, 0f))
            .with(ObjectAnimator.ofFloat(mIndicator, View.ALPHA, 0f))
            .with(ObjectAnimator.ofFloat(mDock, View.ALPHA, 0f))
        set.duration = animationDuration.toLong()
        set.interpolator = LinearInterpolator()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                swipeSearchContainer.visibility = VISIBLE
                swipeSearchContainer.bringToFront()
            }

            override fun onAnimationCancel(animation: Animator) {
                super.onAnimationCancel(animation)
                currentAnimator = null
                swipeSearchContainer.visibility = GONE
                blurLayer.alpha = 0f
                mHorizontalPager.visibility = VISIBLE
                mDock.visibility = VISIBLE
                mIndicator.visibility = VISIBLE
            }

            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                currentAnimator = null

                blurLayer.alpha = 1f
                mHorizontalPager.visibility = GONE
                mDock.visibility = GONE
                mIndicator.visibility = GONE

                val searchEditText = swipeSearchContainer.findViewById<BlissInput>(R.id.search_input)
                val clearSuggestions = swipeSearchContainer.findViewById<ImageView>(R.id.clearSuggestionImageView)
                searchDisposableObserver = searchEditText.textChanges()
                    .debounce(300, TimeUnit.MILLISECONDS)
                    .map { it.toString() }
                    .distinctUntilChanged()
                    .switchMap { charSequence ->
                        if (charSequence.isNotEmpty()) {
                            this@LauncherActivity.runOnUiThread { clearSuggestions.visibility = VISIBLE }
                            this@LauncherActivity.searchForQuery(charSequence)
                        } else {
                            this@LauncherActivity.runOnUiThread { clearSuggestions.visibility = GONE }
                            Observable.just(SuggestionsResult(charSequence))
                        }
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(
                        SearchInputDisposableObserver(
                            this@LauncherActivity,
                            swipeSearchContainer.findViewById<RecyclerView>(R.id.suggestionRecyclerView).adapter!!,
                            swipeSearchContainer
                        )
                    )
                focusSearchInput(searchEditText)
                refreshSuggestedApps(swipeSearchContainer, true)
            }
        })
        set.start()
        currentAnimator = set
    }

    private fun setUpSwipeSearchContainer() {
        val searchEditText = swipeSearchContainer.findViewById<BlissInput>(R.id.search_input)
        mSearchInput = searchEditText
        val clearSuggestions = swipeSearchContainer.findViewById<ImageView>(R.id.clearSuggestionImageView)
        clearSuggestions.setOnClickListener {
            searchEditText.setText("")
            focusSearchInput(searchEditText)
        }

        val suggestionRecyclerView = swipeSearchContainer.findViewById<RecyclerView>(R.id.suggestionRecyclerView)
        val networkSuggestionAdapter = AutoCompleteAdapter(this)
        suggestionRecyclerView.adapter = networkSuggestionAdapter
        suggestionRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        searchEditText.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(v)
            } else {
                showKeyboard(v)
            }
        }
        searchEditText.clearFocus()

        searchEditText.setOnEditorActionListener { _, action, _ ->
            if (action == EditorInfo.IME_ACTION_SEARCH) {
                hideKeyboard(searchEditText)
                runSearch(searchEditText.text.toString())
                searchEditText.setText("")
                searchEditText.clearFocus()
                true
            } else {
                false
            }
        }
        applyLiquidGlassAppearance()
    }

    private fun focusSearchInput(searchEditText: BlissInput) {
        if (!LauncherSearchEntryPolicy.shouldFocusInputWhenOpened()) {
            return
        }
        searchEditText.isFocusableInTouchMode = true
        searchEditText.requestFocus()
        searchEditText.post {
            searchEditText.requestFocus()
            showKeyboard(searchEditText)
        }
    }

    private fun hideSwipeSearchContainer() {
        currentAnimator?.cancel()
        val set = AnimatorSet()
        set.play(ObjectAnimator.ofFloat(swipeSearchContainer, View.TRANSLATION_Y, -swipeSearchContainer.height.toFloat()))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mIndicator, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mDock, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(blurLayer, View.ALPHA, 0f))
        set.duration = 300
        set.interpolator = LinearInterpolator()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                mHorizontalPager.visibility = VISIBLE
                mDock.visibility = VISIBLE
                mIndicator.visibility = VISIBLE
            }

            override fun onAnimationCancel(animation: Animator) {
                super.onAnimationCancel(animation)
                currentAnimator = null
                swipeSearchContainer.visibility = VISIBLE
                blurLayer.alpha = 1f
                mHorizontalPager.visibility = GONE
                mDock.visibility = GONE
                mIndicator.visibility = GONE
            }

            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                currentAnimator = null
                swipeSearchContainer.visibility = GONE
                blurLayer.alpha = 0f
                if (searchDisposableObserver != null && searchDisposableObserver?.isDisposed == false) {
                    searchDisposableObserver?.dispose()
                }
                swipeSearchContainer.findViewById<BlissInput>(R.id.search_input).setText("")
                swipeSearchContainer.findViewById<View>(R.id.search_input).clearFocus()
            }
        })
        set.start()
        currentAnimator = set
    }

    override fun onSwipeStart() {
        swipeSearchContainer.translationY = BlissLauncher.getApplication(this).deviceProfile.availableHeightPx.toFloat()
        swipeSearchContainer.visibility = GONE
        showSwipeSearch = false
    }

    override fun canStartSwipeDown(): Boolean {
        return LauncherSearchEntryPolicy.canStartSwipeDownSearch(
            currentPage = currentPageNumber,
            rightmostPage = mHorizontalPager.childCount - 1
        )
    }

    override fun onSwipe(position: Int) {
        if ((longPressed && !mLongClickStartsDrag) || (!longPressed && isWobbling)) {
            return
        }
        swipeSearchContainer.visibility = VISIBLE
        val translateBy = position * 1.25f
        if (translateBy <= swipeSearchContainer.height) {
            swipeSearchContainer.translationY = -swipeSearchContainer.height + translateBy
            val deltaAlpha = 1f - translateBy / swipeSearchContainer.height
            mHorizontalPager.alpha = deltaAlpha
            mIndicator.alpha = deltaAlpha
            mDock.alpha = deltaAlpha
            blurLayer.alpha = 1 - deltaAlpha
        }

        showSwipeSearch = translateBy >= swipeSearchContainer.height / 2
    }

    override fun onSwipeFinish() {
        if (showSwipeSearch) {
            showSwipeSearchContainer()
        } else {
            hideSwipeSearchContainer()
        }
    }

    fun showWidgetResizeContainer(roundedWidgetView: RoundedWidgetView) {
        val page = widgetsPage ?: return
        val widgetResizeContainer = page.findViewById<RelativeLayout>(R.id.widget_resizer_container)
        if (widgetResizeContainer.visibility != VISIBLE) {
            activeRoundedWidgetView = roundedWidgetView

            val seekBar = widgetResizeContainer.findViewById<SeekBar>(R.id.widget_resizer_seekbar)
            currentAnimator?.cancel()

            seekBar.setOnTouchListener { v, _ ->
                v.parent.requestDisallowInterceptTouchEvent(true)
                false
            }

            val set = AnimatorSet()
            set.play(ObjectAnimator.ofFloat(widgetResizeContainer, View.TRANSLATION_Y, Utilities.pxFromDp(48, this), 0f))
            set.duration = 200
            set.interpolator = LinearInterpolator()
            set.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator) {
                    super.onAnimationStart(animation)
                    widgetResizeContainer.visibility = VISIBLE
                }

                override fun onAnimationCancel(animation: Animator) {
                    super.onAnimationCancel(animation)
                    currentAnimator = null
                    widgetResizeContainer.visibility = GONE
                    roundedWidgetView.removeBorder()
                }

                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    currentAnimator = null
                    prepareWidgetResizeSeekBar(seekBar)
                    roundedWidgetView.addBorder()
                }
            })
            set.start()
            currentAnimator = set
        }
    }

    private fun prepareWidgetResizeSeekBar(seekBar: SeekBar) {
        val activeView = activeRoundedWidgetView ?: return
        val minHeight = activeView.appWidgetInfo.minResizeHeight
        val maxHeight = mDeviceProfile.availableHeightPx * 3 / 4
        val normalisedDifference = (maxHeight - minHeight) / 100
        val defaultHeight = activeView.height
        val currentProgress = (defaultHeight - minHeight) * 100 / (maxHeight - minHeight)

        seekBar.max = 100
        seekBar.progress = currentProgress
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val widgetView = activeRoundedWidgetView ?: return
                val newHeight = minHeight + normalisedDifference * progress
                updateTodayWidgetHeight(widgetView, newHeight)

                val newOps = Bundle()
                newOps.putInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH, mDeviceProfile.maxWidgetWidth)
                newOps.putInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH, mDeviceProfile.maxWidgetWidth)
                newOps.putInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT, newHeight)
                newOps.putInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT, newHeight)
                widgetView.updateAppWidgetOptions(newOps)
                widgetView.requestLayout()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) = Unit

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                val widgetView = activeRoundedWidgetView ?: return
                DatabaseManager.getManager(this@LauncherActivity)
                    .saveWidgetHeight(widgetView.appWidgetId, seekBar.progress)
            }
        })
    }

    private fun updateTodayWidgetHeight(widgetView: RoundedWidgetView, newHeight: Int) {
        widgetView.layoutParams = widgetView.layoutParams.apply {
            height = newHeight
        }
        val parent = widgetView.parent as? View
        parent?.let {
            it.layoutParams = it.layoutParams.apply {
                height = ViewGroup.LayoutParams.WRAP_CONTENT
            }
        }
    }

    fun hideWidgetResizeContainer() {
        val page = widgetsPage ?: return
        val widgetResizeContainer = page.findViewById<RelativeLayout>(R.id.widget_resizer_container)
        if (widgetResizeContainer.visibility == VISIBLE) {
            currentAnimator?.cancel()
            val set = AnimatorSet()
            set.play(ObjectAnimator.ofFloat(widgetResizeContainer, View.TRANSLATION_Y, Utilities.pxFromDp(48, this)))
            set.duration = 200
            set.interpolator = LinearInterpolator()
            set.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator) {
                    super.onAnimationStart(animation)
                    page.findViewById<SeekBar>(R.id.widget_resizer_seekbar).setOnSeekBarChangeListener(null)
                }

                override fun onAnimationCancel(animation: Animator) {
                    super.onAnimationCancel(animation)
                    currentAnimator = null
                    widgetResizeContainer.visibility = VISIBLE
                }

                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    currentAnimator = null
                    widgetResizeContainer.visibility = GONE
                    activeRoundedWidgetView?.removeBorder()
                }
            })
            set.start()
            currentAnimator = set
        }
    }

    fun forceReload() {
        if (mFolderWindowContainer.visibility == VISIBLE) {
            returnToHomeScreen()
        }

        allAppsDisplayed = false
        BlissLauncher.getApplication(this).appProvider.getAppsRepository()
            .updateAppsRelay(emptyList())
    }

    override fun onColorsChanged() {
        updateTheme()
    }

    private fun updateTheme() {
        if (mThemeRes != getActivityThemeRes(this)) {
            recreate()
        }
    }

    inner class FolderAppsPagerAdapter(
        private val mContext: Context,
        private val mFolderAppItems: List<LauncherItem>
    ) : PagerAdapter() {
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val folderMetrics = folderOpenMetrics()
            val viewGroup = LayoutInflater.from(mContext).inflate(R.layout.apps_page, container, false) as GridLayout
            viewGroup.rowCount = 3
            viewGroup.columnCount = 3
            viewGroup.setPadding(0, 0, 0, 0)
            var i = 0
            while (9 * position + i < mFolderAppItems.size && i < 9) {
                val appItem = mFolderAppItems[9 * position + i]
                val appView = prepareLauncherItem(appItem)
                val iconLayoutParams = GridLayout.LayoutParams()
                iconLayoutParams.height = folderMetrics.cellHeight
                iconLayoutParams.width = folderMetrics.cellWidth
                appView.findViewById<View>(R.id.app_label).visibility = VISIBLE
                appView.layoutParams = iconLayoutParams
                viewGroup.addView(appView)
                i++
            }
            container.addView(viewGroup)
            return viewGroup
        }

        override fun getCount(): Int = ceil(mFolderAppItems.size.toFloat() / 9).toInt()

        override fun isViewFromObject(view: View, `object`: Any): Boolean = view === `object`

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }
    }

    inner class ReorderAlarmListener(
        private val mPage: GridLayout,
        private val mParent: ViewGroup,
        private val mIndex: Int,
        private val targetCell: Int? = null
    ) : Alarm.OnAlarmListener {
        override fun onAlarm(alarm: Alarm) {
            val moving = movingApp ?: return
            val gridLayout = pages[getCurrentAppsPageNumber()]
            if (moving.parent != null &&
                (parentPage == getCurrentAppsPageNumber() || gridLayout.childCount < mDeviceProfile.maxAppsPerPage)
            ) {
                if (targetCell != null && !isAutoRearrangeAppsEnabled()) {
                    previewDroppedAppToPage(gridLayout, moving, targetCell)
                    return
                }
                (moving.parent as ViewGroup).removeView(moving)
                if (gridLayout.childCount < mDeviceProfile.maxAppsPerPage) {
                    targetCell?.let { moving.launcherItem.cell = it }
                    addAppToGrid(gridLayout, moving, mIndex)
                    relayoutHomePageCells(gridLayout)
                    parentPage = getCurrentAppsPageNumber()
                }
            }
        }
    }

    inner class DockReorderAlarmListener(private val mIndex: Int) : Alarm.OnAlarmListener {
        override fun onAlarm(alarm: Alarm) {
            val moving = movingApp ?: return
            if (mDock.childCount < mDeviceProfile.numColumns || parentPage == -99) {
                if (moving.parent != null) {
                    (moving.parent as ViewGroup).removeView(moving)
                }
                parentPage = -99
                addAppToDock(moving, mIndex)
            }
        }
    }
}
