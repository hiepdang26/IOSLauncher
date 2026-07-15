package com.vhmsoft.launcherios26.features.launcher

import android.Manifest
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
import android.app.Dialog
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
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.graphics.Rect
import android.graphics.RenderEffect
import android.graphics.Shader
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.os.Process
import android.os.StrictMode
import android.os.SystemClock
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
import android.view.TouchDelegate
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
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.RadioButton
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.doOnPreDraw
import androidx.core.widget.NestedScrollView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.vhmsoft.launcherios26.BlissLauncher
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.core.Alarm
import com.vhmsoft.launcherios26.core.DeviceProfile
import com.vhmsoft.launcherios26.core.LauncherCustomIconPreferences
import com.vhmsoft.launcherios26.core.LauncherAppRenamePolicy
import com.vhmsoft.launcherios26.core.LauncherAppRenamePreferences
import com.vhmsoft.launcherios26.core.LauncherFolderTitlePolicy
import com.vhmsoft.launcherios26.core.LauncherHomeLayoutPreferences
import com.vhmsoft.launcherios26.core.LauncherHomeLayoutSettings
import com.vhmsoft.launcherios26.core.LauncherLiquidGlassDrawableFactory
import com.vhmsoft.launcherios26.core.LauncherLiquidGlassStylePolicy
import com.vhmsoft.launcherios26.core.LauncherRealtimeLiquidGlassPolicy
import com.vhmsoft.launcherios26.core.LauncherRenameUiPolicy
import com.vhmsoft.launcherios26.core.Preferences
import com.vhmsoft.launcherios26.core.Utilities
import com.vhmsoft.launcherios26.core.blur.BlurWallpaperProvider
import com.vhmsoft.launcherios26.core.broadcast.ManagedProfileBroadcastReceiver
import com.vhmsoft.launcherios26.core.broadcast.TimeChangeBroadcastReceiver
import com.vhmsoft.launcherios26.core.broadcast.WallpaperChangeReceiver
import com.vhmsoft.launcherios26.core.customviews.BlissDragShadowBuilder
import com.vhmsoft.launcherios26.core.customviews.BlissFrameLayout
import com.vhmsoft.launcherios26.core.customviews.BlissInput
import com.vhmsoft.launcherios26.core.customviews.BlurBackgroundView
import com.vhmsoft.launcherios26.core.customviews.DockGridLayout
import com.vhmsoft.launcherios26.core.customviews.DockStylePolicy
import com.vhmsoft.launcherios26.core.customviews.HorizontalPager
import com.vhmsoft.launcherios26.core.customviews.InsettableFrameLayout
import com.vhmsoft.launcherios26.core.customviews.InsettableRelativeLayout
import com.vhmsoft.launcherios26.core.customviews.LauncherRealtimeLiquidGlassLayout
import com.vhmsoft.launcherios26.core.customviews.PageIndicatorLinearLayout
import com.vhmsoft.launcherios26.core.customviews.RoundedWidgetView
import com.vhmsoft.launcherios26.core.customviews.SquareFrameLayout
import com.vhmsoft.launcherios26.core.customviews.SquareImageView
import com.vhmsoft.launcherios26.core.customviews.WidgetHost
import com.vhmsoft.launcherios26.core.database.model.ApplicationItem
import com.vhmsoft.launcherios26.core.database.model.CalendarIcon
import com.vhmsoft.launcherios26.core.database.model.FolderItem
import com.vhmsoft.launcherios26.core.database.model.LauncherItem
import com.vhmsoft.launcherios26.core.database.model.ShortcutItem
import com.vhmsoft.launcherios26.core.database.model.WidgetItem
import com.vhmsoft.launcherios26.core.events.AppAddEvent
import com.vhmsoft.launcherios26.core.events.AppChangeEvent
import com.vhmsoft.launcherios26.core.events.AppRemoveEvent
import com.vhmsoft.launcherios26.core.events.AppRenameEvent
import com.vhmsoft.launcherios26.core.events.AppWallpaperEvent
import com.vhmsoft.launcherios26.core.events.EventRelay
import com.vhmsoft.launcherios26.core.events.ShortcutAddEvent
import com.vhmsoft.launcherios26.core.executors.AppExecutors
import com.vhmsoft.launcherios26.core.utils.AppUtils
import com.vhmsoft.launcherios26.core.utils.Constants
import com.vhmsoft.launcherios26.core.utils.DepthManager
import com.vhmsoft.launcherios26.core.utils.GraphicsUtil
import com.vhmsoft.launcherios26.core.utils.UserHandle
import com.vhmsoft.launcherios26.core.utils.getActivityThemeRes
import com.vhmsoft.launcherios26.core.utils.isWorkspaceDarkText
import com.vhmsoft.launcherios26.core.wallpaper.Ios26DefaultWallpaperInstaller
import com.vhmsoft.launcherios26.core.wallpaper.WallpaperManagerCompat
import com.vhmsoft.launcherios26.data.repository.LauncherAppLibraryPreferencesRepository
import com.vhmsoft.launcherios26.data.repository.LauncherDockStylePreferencesRepository
import com.vhmsoft.launcherios26.data.repository.LauncherHiddenAppsPreferencesRepository
import com.vhmsoft.launcherios26.data.repository.LauncherHomeSettingsRepository
import com.vhmsoft.launcherios26.data.repository.LauncherLayoutRepository
import com.vhmsoft.launcherios26.data.repository.LauncherSystemRepository
import com.vhmsoft.launcherios26.data.repository.LauncherTodayWidgetPreferencesRepository
import com.vhmsoft.launcherios26.databinding.ActivityMainBinding
import com.vhmsoft.launcherios26.databinding.AppsPageBinding
import com.vhmsoft.launcherios26.databinding.AppViewBinding
import com.vhmsoft.launcherios26.databinding.LayoutSearchSuggestionBinding
import com.vhmsoft.launcherios26.databinding.LayoutUsedAppsBinding
import com.vhmsoft.launcherios26.databinding.WidgetsPageBinding
import com.vhmsoft.launcherios26.di.RepositoryProvider
import com.vhmsoft.launcherios26.features.shortcuts.DeepShortcutManager
import com.vhmsoft.launcherios26.features.shortcuts.ShortcutInfoCompat
import com.vhmsoft.launcherios26.features.shortcuts.ShortcutKey
import com.vhmsoft.launcherios26.features.suggestions.AutoCompleteAdapter
import com.vhmsoft.launcherios26.features.suggestions.SearchSuggestionUtil
import com.vhmsoft.launcherios26.features.suggestions.SuggestionProvider
import com.vhmsoft.launcherios26.features.suggestions.SuggestionsResult
import com.vhmsoft.launcherios26.features.launcher.workspace.LauncherPageIndicatorWheelView
import com.vhmsoft.launcherios26.features.launcher.workspace.LauncherPageIndicatorWindowPolicy
import com.vhmsoft.launcherios26.features.weather.DeviceStatusService
import com.vhmsoft.launcherios26.features.weather.HomeHourlyWeather
import com.vhmsoft.launcherios26.features.weather.HomeWeatherIconType
import com.vhmsoft.launcherios26.features.weather.HomeWeatherWidgetPolicy
import com.vhmsoft.launcherios26.features.weather.WeatherSourceListenerService
import com.vhmsoft.launcherios26.features.weather.WeatherSettingsPolicy
import com.vhmsoft.launcherios26.features.weather.WeatherUpdateService
import com.vhmsoft.launcherios26.features.weather.WeatherUtils
import com.vhmsoft.launcherios26.features.weather.openmeteo.DailyWeather
import com.vhmsoft.launcherios26.features.weather.openmeteo.OpenMeteoWeatherApi
import com.vhmsoft.launcherios26.features.weather.openmeteo.WeatherConditionMapper
import com.vhmsoft.launcherios26.features.weather.openmeteo.WeatherCoordinates
import com.vhmsoft.launcherios26.features.weather.openmeteo.WeatherForecast
import com.vhmsoft.launcherios26.features.weather.openmeteo.WeatherLocationProvider
import com.vhmsoft.launcherios26.features.weather.openmeteo.WeatherWidgetUiState
import com.vhmsoft.launcherios26.features.widgets.DefaultWidgets
import com.vhmsoft.launcherios26.features.widgets.WidgetManager
import com.vhmsoft.launcherios26.features.widgets.WidgetViewBuilder
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.io.IOException
import java.util.Calendar
import java.text.Collator
import java.util.IdentityHashMap
import java.util.Locale
import java.util.concurrent.Executors
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

open class LauncherActivity : AppCompatActivity(),
    AutoCompleteAdapter.OnSuggestionClickListener,
    OnSwipeDownListener,
    WallpaperManagerCompat.OnColorsChangedListener,
    LauncherContract.View {

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

    private data class PendingApplicationUninstall(
        val packageName: String,
        val userHandle: UserHandle
    )

    private data class PendingInstalledAppReveal(
        val packageName: String,
        val userHandle: UserHandle,
        val targetPagerPage: Int
    )

    private data class TodayWidgetProvider(
        val providerInfo: AppWidgetProviderInfo,
        val label: CharSequence,
        val icon: Drawable?,
        val preview: Drawable?,
        val sizeText: String,
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

    private data class HomeWidgetDragSpec(
        val type: String,
        val size: HomeWidgetPlacementPolicy.WidgetSize,
        val itemId: String,
        val sessionId: Long,
        val existingItemId: String? = null,
        val appWidgetId: Int? = null,
        val preview: Drawable? = null
    )

    private data class HomeWidgetDragCellState(
        val page: Int,
        val cell: Int
    )

    private data class HomeWidgetResolvedPlacement(
        val item: HomeWidgetPreferences.Item,
        val displacedCells: Map<BlissFrameLayout, Int>,
        val displacedWidgetCells: Map<String, Int>
    )

    companion object {
        private const val TAG = "LauncherActivity"
        private const val WIDGET_PAGE = 0
        const val REORDER_TIMEOUT = 350
        private const val EMPTY_LOCATION_DRAG = -999
        private const val REQUEST_TODAY_BIND_APPWIDGET = 721
        private const val REQUEST_TODAY_CREATE_APPWIDGET = 722
        private const val REQUEST_HOME_WIDGET_PHOTO_PICK = 723
        private const val REQUEST_HOME_BIND_APPWIDGET = 724
        private const val REQUEST_HOME_CREATE_APPWIDGET = 725
        private const val REQUEST_UNINSTALL_APP = 726
        private const val PAGE_INDICATOR_VISIBLE_MS = 2000L
        private const val PAGE_INDICATOR_SEARCH_WIDTH_DP = 104
        private const val PAGE_INDICATOR_SEARCH_HEIGHT_DP = 34
        private const val PAGE_INDICATOR_DOT_PADDING_DP = 4
        private const val HOME_GRID_PREVIEW_DOT_TAG = "home_grid_preview_dot"
        private const val FOLDER_UNNAMED_HINT_TEXT_SIZE_SP = 22f
        private const val APP_LIBRARY_TITLE = "Thư viện ứng dụng"
        private const val APP_LIBRARY_CATEGORY_PREFIX = "app_category_"
        private const val APP_LIBRARY_SETTINGS_ACTIVITY = "com.vhmsoft.launcherios26.ui.applibrary.AppLibraryActivity"
        private const val APP_LIBRARY_COLUMNS = 2
        private const val APP_LIBRARY_PREVIEW_SLOTS = 4
        private const val APP_LIBRARY_OVERFLOW_SLOTS = 4
        private const val APP_LIBRARY_DIALOG_COLUMNS = 4
        private const val APP_LIBRARY_FOLDER_COLOR = 0x705F6663
        private const val APP_LIBRARY_EMPTY_FOLDER_COLOR = 0x365F6663
        private const val TODAY_QUICK_WIDGET_ID_START = -1000
        private const val TODAY_WIDGET_SHEET_ANIMATION_MS = 170L
        private const val TODAY_WIDGET_DRAG_PREVIEW_THROTTLE_MS = 28L
        private const val TODAY_WIDGET_DRAG_PREVIEW_MIN_MOVE_DP = 4
        private const val TODAY_PHOTO_WIDGET_ID_PREFIX = "today_quick_photo_"
        private const val DRAG_EDGE_GLOW_FADE_MS = 110L
        private const val HOME_WIDGET_TYPE_WEATHER = "weather"
        private const val HOME_WIDGET_TYPE_BATTERY = "battery"
        private const val HOME_WIDGET_TYPE_PICTURE = "picture"
        private const val HOME_WIDGET_TYPE_SYSTEM = "system"
        private const val HOME_WIDGET_PICKER_TOP_CLEARANCE_DP = 88
        private const val HOME_WIDGET_PICKER_BOTTOM_OVERFLOW_DP = 0
        private const val HOME_WIDGET_DISPLACEMENT_PREVIEW_THROTTLE_MS = 48L
        private const val HOME_WIDGET_MOVE_DURATION_MS = 140L
        private const val HOME_WIDGET_REMOVE_TAG = "home_widget_remove"
        private const val HOME_WIDGET_DRAG_PREVIEW_TAG = "home_widget_drag_preview"
        private const val WEATHER_LOCATION_PERMISSION_REQUEST = 731
        private const val HIDDEN_APPS_PREF_SEPARATOR = "|"
        const val ACTION_LAUNCHER_RESUME = "com.vhmsoft.launcherios26.LauncherActivity.LAUNCHER_RESUME"

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
    private val mFolderHoverOpenAlarm = Alarm()
    private val mFolderPageScrollAlarm = Alarm()
    private val mFolderReorderAlarm = Alarm()
    private val launcherPresenter = LauncherPresenter()
    private val launcherHomeSettingsRepository: LauncherHomeSettingsRepository by lazy {
        RepositoryProvider.provideLauncherHomeSettingsRepository(this)
    }
    private val launcherLayoutRepository: LauncherLayoutRepository by lazy {
        RepositoryProvider.provideLauncherLayoutRepository(this)
    }
    private val launcherTodayWidgetPreferencesRepository: LauncherTodayWidgetPreferencesRepository by lazy {
        RepositoryProvider.provideLauncherTodayWidgetPreferencesRepository(this)
    }
    private val launcherHiddenAppsPreferencesRepository: LauncherHiddenAppsPreferencesRepository by lazy {
        RepositoryProvider.provideLauncherHiddenAppsPreferencesRepository(this)
    }
    private val launcherAppLibraryPreferencesRepository: LauncherAppLibraryPreferencesRepository by lazy {
        RepositoryProvider.provideLauncherAppLibraryPreferencesRepository(this)
    }
    private val launcherDockStylePreferencesRepository: LauncherDockStylePreferencesRepository by lazy {
        RepositoryProvider.provideLauncherDockStylePreferencesRepository(this)
    }
    private val launcherSystemRepository: LauncherSystemRepository by lazy {
        RepositoryProvider.provideLauncherSystemRepository(this)
    }
    private lateinit var mHorizontalPager: HorizontalPager
    private lateinit var mDock: DockGridLayout
    private lateinit var mIndicator: PageIndicatorLinearLayout
    private lateinit var editTopBar: View
    private lateinit var doneEditButton: View
    private lateinit var contextOverlay: View
    private lateinit var selectedIconPreview: View
    private lateinit var selectedIconImage: ImageView
    private lateinit var dragEdgeLeftGlow: View
    private lateinit var dragEdgeRightGlow: View
    private var launcherOptionsPopup: PopupWindow? = null
    private var homeWidgetOptionsPopup: PopupWindow? = null
    private var renameAppPanel: View? = null
    private var layoutSettingsPanel: View? = null
    private var hiddenAppsPanel: View? = null
    private var blurSettingsPanel: View? = null
    private var weatherSettingsPanel: View? = null
    private var weatherDetailPanel: View? = null
    private var photoWidgetCropPanel: View? = null
    private var pendingPhotoWidgetId: String? = null
    private var pendingApplicationUninstall: PendingApplicationUninstall? = null
    private var pendingInstalledAppReveal: PendingInstalledAppReveal? = null
    private var pendingPhotoWidgetSize: HomeWidgetPlacementPolicy.WidgetSize = HomeWidgetPlacementPolicy.WidgetSize.SMALL
    private var hiddenAppsChanged = false
    private val indicatorHandler = Handler(Looper.getMainLooper())
    private val hideIndicatorRunnable = Runnable { hidePageIndicator() }
    private val weatherRefreshHandler = Handler(Looper.getMainLooper())
    private val weatherRefreshRunnable = Runnable { refreshWeatherForecast(force = true) }
    private val weatherExecutor = Executors.newSingleThreadExecutor()
    private var weatherWidgetState: WeatherWidgetUiState = WeatherWidgetUiState.PermissionRequired
    private var latestWeatherForecast: WeatherForecast? = null
    private var latestWeatherRefreshUptime = 0L
    private var weatherLoadInFlight = false
    private var weatherRequestGeneration = 0
    private var openWeatherDetailAfterRefresh = false
    private var indicatorMode = IndicatorMode.SEARCH
    private var indicatorWheelView: LauncherPageIndicatorWheelView? = null
    private var lastAppliedIndicatorRealtimeMode: IndicatorMode? = null
    private var lastAppliedIndicatorRealtimeWidthPx = -1
    private var lastAppliedIndicatorRealtimeHeightPx = -1
    private lateinit var mFolderWindowContainer: ViewGroup
    private lateinit var mFolderAppsViewPager: ViewPager
    private lateinit var mFolderTitleInput: BlissInput
    private var folderTitleNormalTextSizeSp = 40f
    private var mSearchInput: BlissInput? = null
    private lateinit var mProgressBar: View
    private var currentPageNumber = 0
    private var pendingReloadPage: Int? = null
    private var maxDistanceForFolderCreation = 0f
    private var pages: MutableList<GridLayout> = ArrayList()
    private var dragDropEnabled = true
    private var movingApp: BlissFrameLayout? = null
    private var collidingApp: BlissFrameLayout? = null
    private var folderInterest = false
    private var folderHoverTarget: BlissFrameLayout? = null
    private var folderCreationPreviewTarget: BlissFrameLayout? = null
    private var folderOpenedByDragHover = false
    private var dragHasEnteredOpenFolder = false
    private var folderDragSession: FolderDragSession? = null
    private var folderPageScrollTarget = LauncherItem.INVALID_CELL
    private var folderReorderTargetPage = LauncherItem.INVALID_CELL
    private var folderReorderTargetCell = LauncherItem.INVALID_CELL
    private lateinit var wobbleAnimation: Animation
    private lateinit var wobbleReverseAnimation: Animation
    private lateinit var widgetDragWobbleAnimation: Animation
    private lateinit var widgetDragWobbleReverseAnimation: Animation
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
    private lateinit var binding: ActivityMainBinding
    private lateinit var mDeviceProfile: DeviceProfile
    private lateinit var launcherHomeLayoutSettings: LauncherHomeLayoutSettings
    private var customIconVersion = 0L
    private var mLongClickStartsDrag = true
    private var isDragging = false
    private var dragShadowBuilder: BlissDragShadowBuilder? = null
    private var allAppsDisplayed = false
    private var lastLauncherItems: List<LauncherItem> = emptyList()
    private var appliedHiddenAppIds: Set<String> = emptySet()
    private var forceRefreshSuggestedApps = false
    private var forceRenderOnNextAppsUpdate = false
    private var liquidGlassEnabled = false
    private var darkModeEnabled = false

    private var mSuggestedApps: List<ApplicationItem> = ArrayList()
    private lateinit var swipeSearchContainer: FrameLayout
    private var swipeSearchContentBinding: LayoutSearchSuggestionBinding? = null
    private lateinit var launcherSearchController: LauncherSearchController
    private lateinit var homeNavigationController: LauncherHomeNavigationController
    private lateinit var dockChromeController: LauncherDockChromeController
    private lateinit var workspaceChromeController: LauncherWorkspaceChromeController
    private lateinit var searchBackgroundBlocker: View
    private lateinit var workspace: InsettableRelativeLayout
    private lateinit var blurLayer: View
    private lateinit var darkBlurLayer: View

    private var activeFolder: FolderItem? = null
    private var activeFolderView: BlissFrameLayout? = null
    private var folderOpenGeneration = 0
    private var folderPanelLiquidGlassRefreshPosted = false

    private enum class FolderDragOrigin {
        FROM_HOME_TO_FOLDER,
        FROM_FOLDER_TO_HOME,
        WITHIN_FOLDER
    }

    private data class LayoutSettingsPalette(
        val backgroundColor: Int,
        val toolbarColor: Int,
        val rowColor: Int,
        val primaryTextColor: Int,
        val secondaryTextColor: Int,
        val dividerColor: Int,
        val sectionHeaderColor: Int,
        val selectedColor: Int,
        val unselectedColor: Int
    )

    private data class FolderDragSession(
        val folder: FolderItem,
        val folderView: BlissFrameLayout,
        val moving: BlissFrameLayout,
        val origin: FolderDragOrigin,
        val originParent: ViewGroup?,
        val originIndex: Int,
        val originContainer: Long,
        val originScreenId: Long,
        val originCell: Int,
        val originalFolderItems: List<LauncherItem>,
        val originalFolderCells: Map<String, Int>,
        val folderWasFromDock: Boolean,
        var previewAddedToFolder: Boolean = false,
        var lastPreviewCell: Int = LauncherItem.INVALID_CELL,
        var hasEnteredFolder: Boolean = false,
        var exitedToHome: Boolean = false
    )

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
    private var todayWidgetDragLayerScreenX = 0
    private var todayWidgetDragLayerScreenY = 0
    private var todayWidgetDragLastPreviewRawX = Float.NaN
    private var todayWidgetDragLastPreviewRawY = Float.NaN
    private var todayWidgetDragLastPreviewUptime = 0L
    private var todayWidgetDragPendingRawX = 0f
    private var todayWidgetDragPendingRawY = 0f
    private var todayWidgetDragPreviewFramePosted = false
    private var widgetPickerDialog: BottomSheetDialog? = null
    private var widgetPreviewOverlay: FrameLayout? = null
    private var pendingTodayWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
    private var pendingHomeSystemWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
    private var nextTodayQuickWidgetId = TODAY_QUICK_WIDGET_ID_START
    private val homeWidgetItems: MutableList<HomeWidgetPreferences.Item> = ArrayList()
    private var homeWidgetEntryCard: View? = null
    private var homeWidgetPickerOverlay: FrameLayout? = null
    private var homeWidgetPickerDialog: BottomSheetDialog? = null
    private var homeWidgetProviderDialog: BottomSheetDialog? = null
    private var homeWidgetPickerSheet: View? = null
    private var homeWidgetProviderSheet: View? = null
    private var homeWidgetDragSpec: HomeWidgetDragSpec? = null
    private var homeWidgetDragPreview: ImageView? = null
    private var homeWidgetDragDropped = false
    private var pendingHomeWidgetDropItem: HomeWidgetPreferences.Item? = null
    private var homeWidgetDragHost: View? = null
    private var homeWidgetDragOriginalAppCells: Map<BlissFrameLayout, HomeWidgetDragCellState> = emptyMap()
    private var homeWidgetDragPageAppCells: Map<Int, Map<BlissFrameLayout, Int>> = emptyMap()
    private var homeWidgetDragActiveDisplacedCells: Map<BlissFrameLayout, Int> = emptyMap()
    private var homeWidgetDragActiveDisplacedWidgetCells: Map<String, Int> = emptyMap()
    private var homeWidgetDragLastDropKey: String? = null
    private var homeWidgetDragPreviewKey: String? = null
    private var homeWidgetDragDockTop = Int.MAX_VALUE
    private var homeWidgetDragCachedGridPage = -1
    private var homeWidgetDragCachedGridLeft = 0
    private var homeWidgetDragCachedGridTop = 0
    private var homeWidgetDragRootLeft = 0
    private var homeWidgetDragRootTop = 0
    private var homeWidgetDragLastScrollAtMs = 0L
    private var homeWidgetDragSessionId = 0L
    private val homeWidgetDragSourceLocations = IdentityHashMap<View, Pair<Int, Int>>()
    private var homeWidgetDragPendingRawX = 0f
    private var homeWidgetDragPendingRawY = 0f
    private var homeWidgetDragPreviewFramePosted = false
    private var homeWidgetDragPendingPlacementRawX = 0f
    private var homeWidgetDragPendingPlacementRawY = 0f
    private var homeWidgetDragPlacementFramePosted = false
    private var homeWidgetDragReducedIconJiggle = false
    private var homeWidgetDragShadowBitmap: Bitmap? = null
    private var homeWidgetDragLastPlacementPreviewAtMs = 0L
    private var homeWidgetTouchDragActive = false
    private var homeWidgetTouchDragStartedFromPicker = false
    private var homeWidgetTouchLastRawX = 0f
    private var homeWidgetTouchLastRawY = 0f
    private var homeWidgetRemoveTouchHost: FrameLayout? = null
    private var homeWidgetEntryCardTargetTop = 0f

    private var widgetsPage: FrameLayout? = null
    private var widgetsPageBinding: WidgetsPageBinding? = null
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
    private var launcherResumedForInstalledAppReveal = false
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
        launcherHomeLayoutSettings = launcherHomeSettingsRepository.readHomeLayoutSettings()
        customIconVersion = LauncherCustomIconPreferences.version(this)
        BlissLauncher.getApplication(this).resetDeviceProfile()
        mDeviceProfile = BlissLauncher.getApplication(this).deviceProfile

        mAppWidgetManager = BlissLauncher.getApplication(this).appWidgetManager
        mAppWidgetHost = BlissLauncher.getApplication(this).appWidgetHost

        binding = ActivityMainBinding.inflate(layoutInflater)
        mLauncherView = binding.root
        setContentView(binding.root)
        launcherPresenter.attachView(this)
        setupViews()
        setupBackNavigation()
        Ios26DefaultWallpaperInstaller.applyIfNeededWhenDefaultLauncher(this)
        applyCustomWallpaperFromPreferences()
        applyLiquidGlassAppearance()

        val wm = getSystemService(WALLPAPER_SERVICE) as WallpaperManager
        wm.suggestDesiredDimensions(mDeviceProfile.widthPx, mDeviceProfile.heightPx)

        mProgressBar.visibility = VISIBLE

        createOrUpdateIconGrid()
        addDefaultWidgets()

        if (Utilities.ATLEAST_R) {
            mDepthManager = DepthManager(this)
        }

        if (isWorkspaceDarkText(this) && !LauncherHomeLayoutPreferences.isDarkModeEnabled(this)) {
            var flags = mLauncherView.systemUiVisibility
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            mLauncherView.systemUiVisibility = flags
        }
        val lightContext = ContextThemeWrapper(this, R.style.HomeScreenTheme)
        mLightLayoutInflater = layoutInflater.cloneInContext(lightContext)
        mInsetsController = WindowInsetsControllerCompat(window, mLauncherView)
        launcherPresenter.onLauncherResumed()
    }

    fun getRootView(): View = mLauncherView

    fun openWeatherSettingsPage() {
        if (!::mLauncherView.isInitialized) {
            return
        }
        hideWeatherDetailPage()
        showWeatherSettingsPage()
    }

    fun openBlurEffectSettingsPage() {
        if (!::mLauncherView.isInitialized) {
            return
        }
        showBlurEffectSettingsPanel()
    }

    private fun setupViews() {
        workspace = binding.workspace
        wallpaperChangeReceiver = WallpaperChangeReceiver(workspace)
        workspace.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                wallpaperChangeReceiver.setWindowToken(v.windowToken)
            }

            override fun onViewDetachedFromWindow(v: View) {
                wallpaperChangeReceiver.setWindowToken(null)
            }
        })
        mHorizontalPager = binding.pagesContainer
        blurLayer = binding.blurLayer
        blurLayer.alpha = 0f
        darkBlurLayer = binding.darkBlurLayer
        darkBlurLayer.alpha = 0f

        mDock = binding.dock
        dockChromeController = createDockChromeController()
        mIndicator = binding.pageIndicator
        workspaceChromeController = createWorkspaceChromeController()
        editTopBar = binding.editTopBar
        binding.editOptionsButton.setOnClickListener {
            showHomeWidgetEntryCard()
        }
        doneEditButton = binding.doneEditButton
        doneEditButton.setOnClickListener { handleWobbling(false) }
        contextOverlay = binding.contextOverlay
        selectedIconPreview = binding.selectedIconPreview
        selectedIconImage = binding.selectedIconImage
        dragEdgeLeftGlow = binding.dragEdgeLeft
        dragEdgeRightGlow = binding.dragEdgeRight
        contextOverlay.setOnClickListener {
            dismissHomeWidgetOptionsPopup()
            dismissLauncherOptionsPopup()
        }
        mIndicator.setOnClickListener { openSearchFromIndicator() }
        mFolderWindowContainer = binding.folderWindowContainer
        mFolderAppsViewPager = binding.folderApps
        FolderViewPagerScrollController.install(mFolderAppsViewPager)
        mFolderTitleInput = binding.folderTitle
        mProgressBar = binding.progressbar
        swipeSearchContainer = binding.swipeSearchContainer
        swipeSearchContentBinding = LayoutSearchSuggestionBinding.bind(swipeSearchContainer.getChildAt(0))
        launcherSearchController = LauncherSearchController(
            BlissSearchInputAdapter { requireSwipeSearchContentBinding().searchInput }
        )
        homeNavigationController = createHomeNavigationController()
        searchBackgroundBlocker = binding.searchBackgroundBlocker
        searchBackgroundBlocker.setOnClickListener { }
        maxDistanceForFolderCreation = (0.45f * mDeviceProfile.iconSizePx).toInt().toFloat()

        scrollCorner = mDeviceProfile.iconDrawablePaddingPx / 2

        wobbleAnimation = AnimationUtils.loadAnimation(this, R.anim.wobble)
        wobbleReverseAnimation = AnimationUtils.loadAnimation(this, R.anim.wobble_reverse)
        widgetDragWobbleAnimation = AnimationUtils.loadAnimation(this, R.anim.wobble_widget_drag)
        widgetDragWobbleReverseAnimation = AnimationUtils.loadAnimation(this, R.anim.wobble_widget_drag_reverse)
        workspace.setOnClickListener {
            if (swipeSearchContainer.visibility == VISIBLE) {
                hideSwipeSearchContainer()
            } else if (
                HomeWidgetEditStatePolicy.shouldHideEntryCardOnHomeTap(
                    editing = isWobbling,
                    entryCardVisible = homeWidgetEntryCard != null
                )
            ) {
                hideHomeWidgetEntryCard()
            } else if (
                HomeWidgetEditStatePolicy.shouldExitEditModeOnHomeTap(
                    editing = isWobbling,
                    entryCardVisible = homeWidgetEntryCard != null
                )
            ) {
                handleWobbling(false)
            }
        }
        liquidGlassEnabled = LauncherHomeLayoutPreferences.isLiquidGlassEnabled(this)
        darkModeEnabled = LauncherHomeLayoutPreferences.isDarkModeEnabled(this)
    }

    private fun requireSwipeSearchContentBinding(): LayoutSearchSuggestionBinding =
        swipeSearchContentBinding
            ?: LayoutSearchSuggestionBinding.bind(swipeSearchContainer.getChildAt(0)).also {
                swipeSearchContentBinding = it
            }

    private fun updateDragEdgeGlows(dragActive: Boolean) {
        if (!::dragEdgeLeftGlow.isInitialized || !::dragEdgeRightGlow.isInitialized) {
            return
        }

        val edgeState = LauncherDragEdgeGlowPolicy.resolve(dragActive)
        setDragEdgeGlowVisible(dragEdgeLeftGlow, edgeState.showLeft)
        setDragEdgeGlowVisible(dragEdgeRightGlow, edgeState.showRight)
    }

    private fun setDragEdgeGlowVisible(edge: View, visible: Boolean) {
        edge.animate().cancel()
        if (visible) {
            if (edge.visibility != VISIBLE) {
                edge.alpha = 0f
                edge.visibility = VISIBLE
            }
            edge.animate()
                .alpha(1f)
                .setDuration(DRAG_EDGE_GLOW_FADE_MS)
                .start()
        } else {
            edge.alpha = 0f
            edge.visibility = GONE
        }
    }

    private fun createOrUpdateIconGrid() {
        compositeDisposableBag.add(
            BlissLauncher.getApplication(this).appProvider.getAppsRepository()
                .getAppsRelay()
                .distinctUntilChanged { previousItems, nextItems ->
                    LauncherIconGridRefreshPolicy.shouldSuppressEquivalentIncomingItems(
                        previousItemIds = previousItems.map { item -> item.id },
                        nextItemIds = nextItems.map { item -> item.id },
                        forceRender = forceRenderOnNextAppsUpdate
                    )
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<List<LauncherItem>>() {
                    override fun onNext(launcherItems: List<LauncherItem>) {
                        if (LauncherIconGridRefreshPolicy.shouldRequestProviderReload(launcherItems.size)) {
                            BlissLauncher.getApplication(this@LauncherActivity).appProvider.reload(true)
                        } else if (LauncherIconGridRefreshPolicy.shouldRenderIncomingItems(
                                itemCount = launcherItems.size,
                                allAppsDisplayed = allAppsDisplayed,
                                forceRender = forceRenderOnNextAppsUpdate
                            )
                        ) {
                            forceRenderOnNextAppsUpdate = false
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
        launcherLayoutRepository.insertWidget(widgetItem)
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
            val calendarBinding = AppViewBinding.bind(blissIcon).iconCalendar
            val calendarIcon = CalendarIcon(
                calendarBinding.calendarMonthTextview,
                calendarBinding.calendarDateTextview
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
        launcherResumedForInstalledAppReveal = true

        launcherPresenter.onLauncherResumed()
        if (refreshHomeLayoutIfNeeded()) {
            return
        }
        refreshCustomIconsIfNeeded()
        refreshHiddenAppsIfNeeded()
        Ios26DefaultWallpaperInstaller.applyIfNeededWhenDefaultLauncher(this)
        applyCustomWallpaperFromPreferences()

        if (::mDock.isInitialized) {
            mDock.refreshStyle()
        }
        refreshLiquidGlassAppearanceIfNeeded()
        verifyPendingApplicationUninstall()

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
                    launcherLayoutRepository.insertWidget(widgetItem)
                    saveTodayWidgetOrder()
                }
                widgetView = widgetManager.dequeAddWidgetView()
            }
        }
        updateWidgetWeatherPermissionState(fetchIfNeeded = true)
        revealPendingInstalledAppIfReady()
    }

    private fun refreshCustomIconsIfNeeded() {
        val latestVersion = LauncherCustomIconPreferences.version(this)
        if (latestVersion == customIconVersion) {
            return
        }
        customIconVersion = latestVersion
        forceRenderOnNextAppsUpdate = true
        BlissLauncher.getApplication(this).appProvider.reload(true)
    }

    private fun refreshHiddenAppsIfNeeded() {
        if (!allAppsDisplayed || lastLauncherItems.isEmpty()) {
            return
        }

        val latestHiddenAppIds = readHiddenAppIds()
        if (latestHiddenAppIds == appliedHiddenAppIds) {
            return
        }

        appliedHiddenAppIds = latestHiddenAppIds
        forceReload()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        launcherPresenter.onWindowFocusChanged(hasFocus)
    }

    private fun refreshHomeLayoutIfNeeded(): Boolean {
        val latestSettings = launcherHomeSettingsRepository.readHomeLayoutSettings()
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
        val latestDarkModeEnabled = LauncherHomeLayoutPreferences.isDarkModeEnabled(this)
        liquidGlassEnabled = latestLiquidGlassEnabled
        darkModeEnabled = latestDarkModeEnabled
        applyLiquidGlassAppearance()
        refreshVisibleFolderPreviewIcons()
        refreshAppLibraryPage()
        refreshVisibleAppLibraryRealtimeLiquidGlass()
        if (
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPreviewRealtimeOnAppearanceApply(
                realtimeEnabled = shouldUseRealtimeLiquidGlass()
            )
        ) {
            refreshVisibleFolderPreviewRealtimeLiquidGlass()
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

    private fun refreshVisibleFolderPreviewRealtimeLiquidGlass() {
        if (::mHorizontalPager.isInitialized) {
            (mHorizontalPager.getChildAt(currentPageNumber) as? ViewGroup)?.let { page ->
                refreshRealtimeLiquidGlassDescendants(page)
            }
        }
        if (::mDock.isInitialized) {
            refreshRealtimeLiquidGlassDescendants(mDock)
        }
        if (::mFolderWindowContainer.isInitialized && isFolderWindowActive()) {
            refreshRealtimeLiquidGlassDescendants(mFolderWindowContainer)
        }
    }

    private fun refreshVisibleAppLibraryRealtimeLiquidGlass() {
        val page = appLibraryPage ?: return
        if (!shouldUseRealtimeLiquidGlass()) return
        refreshRealtimeLiquidGlassDescendants(page, realtimeEnabled = true)
        page.post {
            if (shouldUseRealtimeLiquidGlass()) {
                refreshRealtimeLiquidGlassDescendants(page, realtimeEnabled = true)
            }
        }
    }

    private fun applyLiquidGlassAppearance() {
        if (::mDock.isInitialized) {
            mDock.refreshStyle()
            applyDockRealtimeLiquidGlass()
        }
        if (::mIndicator.isInitialized) {
            indicatorMode = if (shouldKeepPageDotsVisibleForDockStyle()) {
                IndicatorMode.DOTS
            } else {
                IndicatorMode.SEARCH
            }
            refreshPageIndicator()
        }
        if (::mLauncherView.isInitialized) {
            applyFolderLiquidGlassAppearance(bindRealtime = isFolderWindowActive())
            setFolderBackgroundContentBlurEnabled(isFolderWindowActive())
        }
        applySwipeSearchChromeAppearance()
        if (::darkBlurLayer.isInitialized) {
            darkBlurLayer.alpha = darkBlurAlphaFor(blurLayer.alpha)
        }
    }

    private fun applySearchBlurAppearance() {
        if (::mIndicator.isInitialized) {
            applyIndicatorRealtimeLiquidGlass()
        }
        applySwipeSearchChromeAppearance()
        refreshAppLibraryPage()
    }

    private fun applySwipeSearchChromeAppearance(forceRealtimeRefresh: Boolean = false) {
        if (!::swipeSearchContainer.isInitialized) return

        val searchBinding = requireSwipeSearchContentBinding()
        val searchInputPanel = searchBinding.searchInput.parent as? View
        val searchPillStyle = LauncherLiquidGlassStylePolicy.searchField(
            enabled = false,
            darkMode = darkModeEnabled,
            liquidGlass = false
        )
        val searchGlassContainer = searchInputPanel?.parent as? LauncherRealtimeLiquidGlassLayout
        val searchRealtimeGlass = applyRealtimeLiquidGlass(
            container = searchGlassContainer,
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_PILL,
            style = searchPillStyle
        )
        searchInputPanel?.background = if (searchRealtimeGlass) {
            ColorDrawable(Color.TRANSPARENT)
        } else {
            roundedRectangle(searchPillStyle)
        }
        if (forceRealtimeRefresh) {
            searchGlassContainer?.refreshRealtimeLiquidGlass()
        }
        val suggestionsPanel = searchBinding.suggestionRecyclerView.parent as? View
        val suggestionsStyle = LauncherLiquidGlassStylePolicy.searchResultsPanel(
            enabled = false,
            darkMode = darkModeEnabled,
            liquidGlass = false
        )
        val suggestionsGlassContainer = suggestionsPanel?.parent as? LauncherRealtimeLiquidGlassLayout
        val suggestionsRealtimeGlass = applyRealtimeLiquidGlass(
            container = suggestionsGlassContainer,
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_RESULTS,
            style = suggestionsStyle
        )
        suggestionsPanel?.background = if (suggestionsRealtimeGlass) {
            ColorDrawable(Color.TRANSPARENT)
        } else {
            roundedRectangle(suggestionsStyle)
        }
        if (forceRealtimeRefresh) {
            suggestionsGlassContainer?.refreshRealtimeLiquidGlass()
        }
    }

    private fun refreshSwipeSearchRealtimeLiquidGlassOnOpen() {
        if (
            !LauncherRealtimeLiquidGlassPolicy.shouldRefreshSwipeSearchRealtimeOnOpen(
                realtimeEnabled = shouldUseRealtimeLiquidGlass(),
                searchVisible = swipeSearchContainer.visibility == VISIBLE && swipeSearchContainer.isShown
            )
        ) {
            return
        }
        applySwipeSearchChromeAppearance(forceRealtimeRefresh = true)
    }

    private fun applyFolderLiquidGlassAppearance(bindRealtime: Boolean) {
        if (!::mLauncherView.isInitialized) return
        if (::mFolderWindowContainer.isInitialized) {
            mFolderWindowContainer.background = ColorDrawable(
                LauncherLiquidGlassStylePolicy.folderBackdropOverlay(
                    darkMode = darkModeEnabled
                )
            )
        }

        val folderBlurEnabled = lightModeFolderBlurEnabled()
        val useLiquidGlassFolderStyle = liquidGlassEnabled
        val folderChromeEnabled = folderBlurEnabled || useLiquidGlassFolderStyle
        val folderStyle = LauncherLiquidGlassStylePolicy.folderPanel(
            enabled = folderChromeEnabled,
            darkMode = darkModeEnabled,
            liquidGlass = false
        )
        val folderGlass = binding.folderBgBlur
        val realtimeLiquidGlassEnabled = shouldUseRealtimeLiquidGlass() && useLiquidGlassFolderStyle
        val folderRealtimeGlass = if (bindRealtime) {
            applyRealtimeLiquidGlass(
                container = folderGlass,
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PANEL,
                style = folderStyle,
                realtimeEnabled = realtimeLiquidGlassEnabled
            )
        } else {
            folderGlass?.blurCornerRadius = dp(folderStyle.radiusDp).toFloat()
            folderGlass?.applyRealtimeLiquidGlass(
                enabled = false,
                source = realtimeLiquidGlassSource(),
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PANEL,
                profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
                    surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PANEL,
                    radiusDp = folderStyle.radiusDp,
                    darkMode = darkModeEnabled
                )
            )
            false
        }

        val folderBackground = binding.folderAppsBackground
        folderBackground.background = if (
            LauncherRealtimeLiquidGlassPolicy.shouldUseTransparentSurfaceBackground(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PANEL,
                realtimeLiquidGlassActive = folderRealtimeGlass
            )
        ) {
            ColorDrawable(Color.TRANSPARENT)
        } else {
            roundedRectangle(folderStyle)
        }
    }

    private fun darkBlurAlphaFor(blurAlpha: Float): Float =
        if (darkModeEnabled) blurAlpha.coerceIn(0f, 1f) else 0f

    private fun applyRealtimeLiquidGlass(
        container: LauncherRealtimeLiquidGlassLayout?,
        surface: LauncherRealtimeLiquidGlassPolicy.Surface,
        style: LauncherLiquidGlassStylePolicy.BackgroundStyle,
        realtimeEnabled: Boolean = shouldUseRealtimeLiquidGlass()
    ): Boolean {
        container?.applyRealtimeLiquidGlass(
            enabled = realtimeEnabled,
            source = realtimeLiquidGlassSource(),
            surface = surface,
            profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
                surface = surface,
                radiusDp = style.radiusDp,
                darkMode = darkModeEnabled
            )
        )
        return LauncherRealtimeLiquidGlassPolicy.shouldUseTransparentSurfaceBackground(
            surface = surface,
            realtimeLiquidGlassActive = container?.isRealtimeLiquidGlassActive() == true,
            realtimeEnabled = realtimeEnabled
        )
    }

    private fun applyDockRealtimeLiquidGlass() {
        if (!::mLauncherView.isInitialized || !::mDock.isInitialized) return
        val dockGlass = binding.dockLiquidGlassBackground
        val dockStyle = currentDockStyle()
        val dockBlurEnabled = dockBlurEnabled()
        val useRealtimeDock = DockStylePolicy.usesExternalRealtimeLiquidGlass(
            style = dockStyle,
            realtimeLiquidGlassAvailable = shouldUseRealtimeLiquidGlass(),
            dockBlurEnabled = dockBlurEnabled
        )
        val dockMaterialStyle = LauncherLiquidGlassStylePolicy.dockMaterial(
            enabled = dockBlurEnabled,
            darkMode = darkModeEnabled,
            liquidGlass = false
        )

        syncDockRealtimeGlassLayout(dockGlass)
        dockGlass.blurCornerRadius = dp(dockMaterialStyle.radiusDp).toFloat()
        val dockVisible = shouldShowDockForPage(currentPageNumber) && mDock.visibility == VISIBLE
        dockGlass.visibility = if (useRealtimeDock && dockVisible) VISIBLE else GONE
        dockGlass.translationY = mDock.translationY
        dockGlass.alpha = LauncherRealtimeLiquidGlassPolicy.realtimeDockGlassAlphaForAppearanceApply(
            realtimeDockEnabled = useRealtimeDock,
            dockVisible = dockVisible,
            dockAlpha = mDock.alpha
        )
        dockGlass.applyRealtimeLiquidGlass(
            enabled = useRealtimeDock,
            source = realtimeLiquidGlassSource(),
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
            profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                radiusDp = dockMaterialStyle.radiusDp,
                darkMode = darkModeEnabled
            )
        )
        mDock.setExternalRealtimeLiquidGlassEnabled(
            LauncherRealtimeLiquidGlassPolicy.shouldDisableFallbackDrawingForExternalGlass(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                realtimeLiquidGlassActive = dockGlass.isRealtimeLiquidGlassActive()
            )
        )
    }

    private fun syncDockRealtimeGlassLayout(dockGlass: LauncherRealtimeLiquidGlassLayout) {
        val dockLayoutParams = mDock.layoutParams
            as? InsettableRelativeLayout.LayoutParams ?: return
        val glassLayoutParams = dockGlass.layoutParams
            as? InsettableRelativeLayout.LayoutParams ?: return

        glassLayoutParams.width = dockLayoutParams.width
        glassLayoutParams.height = DockStylePolicy.realtimeGlassHeightPx(
            layoutHeightPx = dockLayoutParams.height,
            measuredHeightPx = mDock.height.takeIf { it > 0 } ?: mDock.measuredHeight,
            fallbackHeightPx = mDeviceProfile.hotseatCellHeightPx
        )
        glassLayoutParams.leftMargin = dockLayoutParams.leftMargin
        glassLayoutParams.rightMargin = dockLayoutParams.rightMargin
        glassLayoutParams.topMargin = dockLayoutParams.topMargin
        glassLayoutParams.bottomMargin = dockLayoutParams.bottomMargin
        dockGlass.layoutParams = glassLayoutParams
    }

    private fun currentDockStyle(): DockStylePolicy.Style {
        return DockStylePolicy.styleFor(
            iphone8StyleEnabled = launcherDockStylePreferencesRepository.isIphone8StyleEnabled(),
            liquidGlassEnabled = liquidGlassEnabled,
            darkModeEnabled = darkModeEnabled
        )
    }

    private fun shouldKeepPageDotsVisibleForDockStyle(): Boolean {
        return LauncherSearchEntryPolicy.shouldKeepPageDotsVisible(
            iphone8StyleEnabled = launcherDockStylePreferencesRepository.isIphone8StyleEnabled(),
            liquidGlassEnabled = liquidGlassEnabled
        )
    }

    private fun shouldUseRealtimeLiquidGlass(): Boolean =
        LauncherRealtimeLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(liquidGlassEnabled)

    private fun shouldUseRealtimeDockGlass(): Boolean {
        if (!::mLauncherView.isInitialized || !::mDock.isInitialized) return false
        val dockStyle = currentDockStyle()
        val dockBlurEnabled = dockBlurEnabled()
        return DockStylePolicy.usesExternalRealtimeLiquidGlass(
            style = dockStyle,
            realtimeLiquidGlassAvailable = shouldUseRealtimeLiquidGlass(),
            dockBlurEnabled = dockBlurEnabled
        )
    }

    private fun dockGlassBackground(): LauncherRealtimeLiquidGlassLayout? =
        if (::binding.isInitialized) {
            binding.dockLiquidGlassBackground
        } else {
            null
        }

    private fun createDockChromeController(): LauncherDockChromeController {
        return LauncherDockChromeController(
            dock = object : LauncherDockChromeController.DockSurface {
                override var visible: Boolean
                    get() = mDock.visibility == VISIBLE
                    set(value) {
                        mDock.visibility = if (value) VISIBLE else GONE
                    }

                override var alpha: Float
                    get() = mDock.alpha
                    set(value) {
                        mDock.alpha = value
                    }

                override var translationY: Float
                    get() = mDock.translationY
                    set(value) {
                        mDock.translationY = value
                    }

                override fun setExternalRealtimeLiquidGlassEnabled(enabled: Boolean) {
                    mDock.setExternalRealtimeLiquidGlassEnabled(enabled)
                }
            },
            glassProvider = { dockGlassSurface() },
            realtimeDockEnabled = { shouldUseRealtimeDockGlass() }
        )
    }

    private fun dockGlassSurface(): LauncherDockChromeController.DockGlassSurface? {
        val dockGlass = dockGlassBackground() ?: return null
        return object : LauncherDockChromeController.DockGlassSurface {
            override var visible: Boolean
                get() = dockGlass.visibility == VISIBLE
                set(value) {
                    dockGlass.visibility = if (value) VISIBLE else GONE
                }

            override var alpha: Float
                get() = dockGlass.alpha
                set(value) {
                    dockGlass.alpha = value
                }

            override var translationY: Float
                get() = dockGlass.translationY
                set(value) {
                    dockGlass.translationY = value
                }

            override fun isRealtimeLiquidGlassActive(): Boolean =
                dockGlass.isRealtimeLiquidGlassActive()

            override fun refreshRealtimeLiquidGlass() {
                dockGlass.refreshRealtimeLiquidGlass()
            }
        }
    }

    private fun createWorkspaceChromeController(): LauncherWorkspaceChromeController {
        return LauncherWorkspaceChromeController(
            object : LauncherWorkspaceChromeController.Actions {
                override fun hideHomeIndicatorForFolder() {
                    this@LauncherActivity.hideHomeIndicatorForFolder()
                }

                override fun removeIndicatorHideCallbacks() {
                    indicatorHandler.removeCallbacks(hideIndicatorRunnable)
                }

                override fun resetHomeIndicatorPosition() {
                    this@LauncherActivity.resetHomeIndicatorPosition()
                }

                override fun setDockChromeVisible(visible: Boolean) {
                    setDockChromeVisibility(visible)
                }

                override fun setIndicatorChromeVisible(visible: Boolean) {
                    setIndicatorChromeVisibility(visible)
                }

                override fun showDotsInIndicator(position: Int, animate: Boolean) {
                    this@LauncherActivity.showDotsInIndicator(position, animate)
                }

                override fun showSearchControlInIndicator(animated: Boolean) {
                    this@LauncherActivity.showSearchControlInIndicator(animated)
                }
            }
        )
    }

    private fun shouldShowDockForPage(
        page: Int,
        folderVisible: Boolean = isFolderWindowActive()
    ): Boolean =
        LauncherWorkspaceChromePolicy.shouldShowDockForPage(
            page = page,
            firstHomePage = 1,
            lastHomePage = pages.size,
            folderVisible = folderVisible
        )

    private fun setDockChromeVisibility(visible: Boolean) {
        if (!::mDock.isInitialized || !::dockChromeController.isInitialized) return
        dockChromeController.setVisibility(visible)
    }

    private fun syncDockChromeTransform() {
        if (!::mDock.isInitialized || !::dockChromeController.isInitialized) return
        dockChromeController.syncTransform()
    }

    private fun indicatorGlassBackground(): LauncherRealtimeLiquidGlassLayout? =
        if (::binding.isInitialized) {
            binding.pageIndicatorLiquidGlassBackground
        } else {
            null
        }

    private fun applyIndicatorRealtimeLiquidGlass(forceRefresh: Boolean = false) {
        if (!::mIndicator.isInitialized) return
        val indicatorStyle = indicatorBackgroundStyle()
        val indicatorGlass = indicatorGlassBackground()
        val useRealtimeIndicator = shouldUseRealtimeIndicatorGlass()
        val indicatorWidthPx = mIndicator.layoutParams?.width ?: mIndicator.width
        val indicatorHeightPx = mIndicator.layoutParams?.height ?: mIndicator.height
        val indicatorRealtimeStateChanged =
            lastAppliedIndicatorRealtimeMode != null &&
                (lastAppliedIndicatorRealtimeMode != indicatorMode ||
                    lastAppliedIndicatorRealtimeWidthPx != indicatorWidthPx ||
                    lastAppliedIndicatorRealtimeHeightPx != indicatorHeightPx)

        indicatorGlass?.let { glass ->
            syncIndicatorRealtimeGlassLayout(glass)
            glass.blurCornerRadius = dp(indicatorStyle.radiusDp).toFloat()
            val indicatorVisible = mIndicator.visibility == VISIBLE
            glass.alpha = LauncherRealtimeLiquidGlassPolicy.realtimeIndicatorGlassAlphaForChromeSync(
                realtimeIndicatorEnabled = useRealtimeIndicator,
                indicatorVisible = indicatorVisible,
                indicatorAlpha = mIndicator.alpha
            )
            glass.visibility = if (indicatorVisible && useRealtimeIndicator) VISIBLE else GONE
            glass.applyRealtimeLiquidGlass(
                enabled = useRealtimeIndicator,
                source = realtimeLiquidGlassSource(),
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.PAGE_INDICATOR,
                profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
                    surface = LauncherRealtimeLiquidGlassPolicy.Surface.PAGE_INDICATOR,
                    radiusDp = indicatorStyle.radiusDp,
                    darkMode = darkModeEnabled
                )
            )
            if (
                useRealtimeIndicator &&
                (forceRefresh || indicatorRealtimeStateChanged) &&
                glass.isRealtimeLiquidGlassActive()
            ) {
                glass.refreshRealtimeLiquidGlass()
            }
        }
        if (useRealtimeIndicator) {
            lastAppliedIndicatorRealtimeMode = indicatorMode
            lastAppliedIndicatorRealtimeWidthPx = indicatorWidthPx
            lastAppliedIndicatorRealtimeHeightPx = indicatorHeightPx
        } else {
            lastAppliedIndicatorRealtimeMode = null
            lastAppliedIndicatorRealtimeWidthPx = -1
            lastAppliedIndicatorRealtimeHeightPx = -1
        }

        updateIndicatorBackgroundForRealtimeState()
        syncIndicatorChromeTransform(refreshRealtime = false)
    }

    private fun updateIndicatorBackgroundForRealtimeState() {
        val indicatorStyle = indicatorBackgroundStyle()
        val indicatorRealtimeActive = indicatorGlassBackground()?.isRealtimeLiquidGlassActive() == true
        mIndicator.setFallbackBackground(roundedRectangle(indicatorStyle))
        mIndicator.setExternalRealtimeLiquidGlassEnabled(
            LauncherRealtimeLiquidGlassPolicy.shouldClearForegroundBackgroundForExternalGlass(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.PAGE_INDICATOR,
                realtimeLiquidGlassActive = indicatorRealtimeActive,
                realtimeEnabled = shouldUseRealtimeIndicatorGlass()
            )
        )
    }

    private fun syncIndicatorRealtimeGlassLayout(indicatorGlass: LauncherRealtimeLiquidGlassLayout) {
        val indicatorLayoutParams = mIndicator.layoutParams
            as? InsettableRelativeLayout.LayoutParams ?: return
        val glassLayoutParams = indicatorGlass.layoutParams
            as? InsettableRelativeLayout.LayoutParams ?: return

        glassLayoutParams.width = indicatorLayoutParams.width
        glassLayoutParams.height = indicatorLayoutParams.height
        glassLayoutParams.leftMargin = indicatorLayoutParams.leftMargin
        glassLayoutParams.rightMargin = indicatorLayoutParams.rightMargin
        glassLayoutParams.topMargin = indicatorLayoutParams.topMargin
        glassLayoutParams.bottomMargin = indicatorLayoutParams.bottomMargin
        indicatorGlass.layoutParams = glassLayoutParams
    }

    private fun setIndicatorChromeVisibility(visible: Boolean) {
        if (!::mIndicator.isInitialized) return
        mIndicator.visibility = if (visible) VISIBLE else GONE
        syncIndicatorChromeTransform(refreshRealtime = visible)
    }

    private fun syncIndicatorChromeTransform(refreshRealtime: Boolean = false) {
        if (!::mIndicator.isInitialized) return
        indicatorGlassBackground()?.let { indicatorGlass ->
            val useRealtimeIndicator = shouldUseRealtimeIndicatorGlass()
            val indicatorVisible = mIndicator.visibility == VISIBLE
            indicatorGlass.alpha = LauncherRealtimeLiquidGlassPolicy.realtimeIndicatorGlassAlphaForChromeSync(
                realtimeIndicatorEnabled = useRealtimeIndicator,
                indicatorVisible = indicatorVisible,
                indicatorAlpha = mIndicator.alpha
            )
            indicatorGlass.visibility =
                if (indicatorVisible && useRealtimeIndicator) VISIBLE else GONE
            indicatorGlass.translationX = mIndicator.translationX
            indicatorGlass.translationY = mIndicator.translationY
            indicatorGlass.scaleX = mIndicator.scaleX
            indicatorGlass.scaleY = mIndicator.scaleY
            if (
                LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnChromeSync(
                    realtimeEnabled = shouldUseRealtimeLiquidGlass(),
                    wasVisible = false,
                    nextVisible = refreshRealtime && indicatorGlass.visibility == VISIBLE
                )
            ) {
                indicatorGlass.refreshRealtimeLiquidGlass()
            }
            updateIndicatorBackgroundForRealtimeState()
        }
    }

    private fun dockBlurEnabled(): Boolean =
        LauncherHomeLayoutPreferences.isDockBlurEnabled(this)

    private fun lightModeFolderBlurEnabled(): Boolean =
        LauncherHomeLayoutPreferences.isFolderBlurEnabled(this) && !darkModeEnabled

    private fun lightModeSearchBlurEnabled(): Boolean =
        LauncherHomeLayoutPreferences.isSearchBlurEnabled(this) && !darkModeEnabled

    private fun shouldUseRealtimeIndicatorGlass(): Boolean =
        shouldUseRealtimeLiquidGlass()

    private fun styleDarkModeForLiquidGlass(): Boolean =
        darkModeEnabled

    private fun realtimeLiquidGlassSource(): ViewGroup? {
        if (!::mLauncherView.isInitialized) return null
        return if (::binding.isInitialized) {
            binding.liquidGlassSource
        } else if (::workspace.isInitialized) {
            workspace
        } else {
            mLauncherView as? ViewGroup
        }
    }

    private fun overlayBlurMasterEnabled(): Boolean =
        true

    private fun searchOverlayBlurAlpha(): Float =
        LauncherBlurEffectPolicy.overlayAlpha(
            masterEnabled = overlayBlurMasterEnabled(),
            targetEnabled = LauncherHomeLayoutPreferences.isSearchBlurEnabled(this),
            darkModeEnabled = darkModeEnabled,
            liquidGlassEnabled = liquidGlassEnabled
        )

    private fun folderOverlayBlurAlpha(): Float =
        LauncherBlurEffectPolicy.folderOverlayAlpha(
            masterEnabled = overlayBlurMasterEnabled(),
            folderEnabled = LauncherHomeLayoutPreferences.isFolderBlurEnabled(this),
            liquidGlassEnabled = liquidGlassEnabled,
            darkModeEnabled = darkModeEnabled
        )

    private fun folderBackgroundContentAlpha(): Float =
        LauncherBlurEffectPolicy.folderBackgroundContentAlpha(
            masterEnabled = overlayBlurMasterEnabled(),
            folderEnabled = LauncherHomeLayoutPreferences.isFolderBlurEnabled(this),
            liquidGlassEnabled = liquidGlassEnabled,
            darkModeEnabled = darkModeEnabled
        )

    private fun searchBackgroundContentAlpha(): Float =
        LauncherBlurEffectPolicy.searchBackgroundContentAlpha(
            masterEnabled = overlayBlurMasterEnabled(),
            searchEnabled = LauncherHomeLayoutPreferences.isSearchBlurEnabled(this)
        )

    private fun searchTouchBlockerAlpha(): Float =
        LauncherBlurEffectPolicy.searchTouchBlockerAlpha(
            masterEnabled = overlayBlurMasterEnabled(),
            searchEnabled = LauncherHomeLayoutPreferences.isSearchBlurEnabled(this),
            darkModeEnabled = darkModeEnabled,
            liquidGlassEnabled = liquidGlassEnabled
        )

    private fun setBlurLayersAlpha(alpha: Float) {
        val safeAlpha = alpha.coerceIn(0f, 1f)
        blurLayer.alpha = safeAlpha
        if (::darkBlurLayer.isInitialized) {
            darkBlurLayer.alpha = darkBlurAlphaFor(safeAlpha)
        }
    }

    private fun setFolderBackgroundContentBlurEnabled(enabled: Boolean) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            return
        }
        val effect = if (enabled) {
            val radius = dp(FolderOpenLayoutPolicy.LIQUID_GLASS_BACKGROUND_RENDER_BLUR_RADIUS_DP).toFloat()
            RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP)
        } else {
            null
        }
        if (::mHorizontalPager.isInitialized) {
            mHorizontalPager.setRenderEffect(effect)
        }
        if (::mDock.isInitialized) {
            mDock.setRenderEffect(effect)
        }
    }

    private fun applyLauncherSystemUi() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.isNavigationBarContrastEnforced = false
        }
        WindowInsetsControllerCompat(window, window.decorView).apply {
            hide(WindowInsetsCompat.Type.navigationBars())
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
        @Suppress("DEPRECATION")
        val appearanceFlags = if (isWorkspaceDarkText(this) && !LauncherHomeLayoutPreferences.isDarkModeEnabled(this)) {
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        } else {
            0
        }
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility =
            appearanceFlags or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }

    override fun refreshLauncherSystemUi() {
        applyLauncherSystemUi()
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
        val host = FrameLayout(this).apply {
            tag = entry.id
            clipChildren = false
            clipToPadding = false
            setOnLongClickListener { startTodayWidgetDrag(entry.id, this) }
        }
        val startDragListener = View.OnLongClickListener {
            startTodayWidgetDrag(entry.id, host)
        }
        host.setOnLongClickListener(startDragListener)
        host.addView(
            createTodayQuickWidgetView(entry.type, entry.id),
            FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        )
        host.addView(createTodayWidgetRemoveButton(entry.id))
        installTodayQuickWidgetClickAction(host, entry, startDragListener)
        return host
    }

    private fun installTodayQuickWidgetClickAction(
        root: View,
        entry: TodayQuickWidgetEntry,
        startDragListener: View.OnLongClickListener
    ) {
        val action = TodayWidgetQuickActionPolicy.actionForTypeName(entry.type.name)
        if (action == TodayWidgetQuickActionPolicy.Action.NONE) {
            return
        }
        val clickListener = View.OnClickListener {
            if (isTodayWidgetEditing || draggedTodayWidgetId != null) {
                return@OnClickListener
            }
            when (action) {
                TodayWidgetQuickActionPolicy.Action.OPEN_WEATHER -> handleWeatherWidgetClicked()
                TodayWidgetQuickActionPolicy.Action.OPEN_PHOTO -> handleTodayPhotoWidgetClicked(entry.id)
                TodayWidgetQuickActionPolicy.Action.NONE -> Unit
            }
        }
        fun attach(view: View) {
            if (view.tag == "today_widget_remove") {
                return
            }
            view.isClickable = true
            view.setOnClickListener(clickListener)
            view.isLongClickable = true
            view.setOnLongClickListener(startDragListener)
            if (view is ViewGroup) {
                for (index in 0 until view.childCount) {
                    attach(view.getChildAt(index))
                }
            }
        }
        attach(root)
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

    private fun createTodayQuickWidgetView(type: TodayQuickWidgetType, entryId: Int? = null): View {
        return when (type) {
            TodayQuickWidgetType.WEATHER -> createTodayWeatherWidget()
            TodayQuickWidgetType.BATTERY -> createTodayBatteryWidget()
            TodayQuickWidgetType.PICTURE -> createTodayPictureWidget(entryId?.let { todayPhotoWidgetId(it) })
            TodayQuickWidgetType.APP_GROUP -> createTodayAppGroupWidget()
            TodayQuickWidgetType.FAVORITES -> createTodayFavoritesWidget()
            TodayQuickWidgetType.CALENDAR -> createTodayCalendarWidget()
        }
    }

    private fun createTodayWeatherWidget(): View {
        return when (val state = weatherWidgetState) {
            WeatherWidgetUiState.PermissionRequired -> createWeatherStatusWidget(
                getString(R.string.launcher_widget_weather_permission)
            )
            WeatherWidgetUiState.NoNetwork -> createWeatherStatusWidget(
                getString(R.string.launcher_widget_weather_no_network)
            )
            WeatherWidgetUiState.Loading -> createWeatherStatusWidget(
                getString(R.string.launcher_widget_weather_loading)
            )
            is WeatherWidgetUiState.Forecast -> createWeatherForecastWidget(state.forecast)
        }
    }

    private fun createWeatherStatusWidget(message: String): View {
        return FrameLayout(this).apply {
            background = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(0xFF356799.toInt(), 0xFF7BA4DD.toInt())
            ).apply {
                cornerRadius = dp(18).toFloat()
            }
            addView(
                TextView(context).apply {
                    text = message
                    setTextColor(Color.WHITE)
                    textSize = 20f
                    gravity = Gravity.CENTER
                    includeFontPadding = false
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    Gravity.CENTER
                )
            )
        }
    }

    private fun createWeatherForecastWidget(forecast: WeatherForecast): View {
        val summary = HomeWeatherWidgetPolicy.homeSummary(forecast)
        return FrameLayout(this).apply {
            background = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(0xFF3E70A8.toInt(), 0xFF78A9E6.toInt())
            ).apply {
                cornerRadius = dp(22).toFloat()
            }
            addView(
                TextView(context).apply {
                    text = summary.locationName
                    setTextColor(Color.WHITE)
                    textSize = 16f
                    typeface = Typeface.DEFAULT_BOLD
                    includeFontPadding = false
                    maxLines = 1
                    ellipsize = TextUtils.TruncateAt.END
                },
                FrameLayout.LayoutParams(
                    dp(170),
                    dp(28),
                    Gravity.START or Gravity.TOP
                ).apply {
                    leftMargin = dp(16)
                    topMargin = dp(16)
                }
            )
            addView(
                TextView(context).apply {
                    text = getString(
                        R.string.launcher_widget_weather_temperature_format,
                        summary.currentTemperature
                    )
                    includeFontPadding = false
                    setTextColor(Color.WHITE)
                    textSize = 46f
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    dp(62),
                    Gravity.START or Gravity.TOP
                ).apply {
                    leftMargin = dp(16)
                    topMargin = dp(48)
                }
            )
            addView(
                LinearLayout(context).apply {
                    orientation = LinearLayout.VERTICAL
                    gravity = Gravity.END
                    addView(
                        weatherIconView(summary.conditionCode, dp(36)),
                        LinearLayout.LayoutParams(dp(42), dp(36)).apply {
                            bottomMargin = dp(4)
                        }
                    )
                    addView(
                        TextView(context).apply {
                            text = summary.condition
                            setTextColor(Color.WHITE)
                            textSize = 16f
                            typeface = Typeface.DEFAULT_BOLD
                            gravity = Gravity.END
                            includeFontPadding = false
                            maxLines = 1
                            ellipsize = TextUtils.TruncateAt.END
                        }
                    )
                    addView(
                        TextView(context).apply {
                            text = getString(
                                R.string.launcher_widget_weather_high_low_format,
                                summary.highTemperature,
                                summary.lowTemperature
                            )
                            setTextColor(Color.WHITE)
                            textSize = 14f
                            gravity = Gravity.END
                            includeFontPadding = false
                        }
                    )
                },
                FrameLayout.LayoutParams(
                    dp(150),
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.END or Gravity.TOP
                ).apply {
                    topMargin = dp(16)
                    rightMargin = dp(14)
                }
            )
            addView(
                LinearLayout(context).apply {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER
                    summary.hourly.forEach { item ->
                        addView(
                            createHomeWeatherHourlyColumn(item),
                            LinearLayout.LayoutParams(
                                0,
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                1f
                            )
                        )
                    }
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dp(64),
                    Gravity.START or Gravity.BOTTOM
                ).apply {
                    leftMargin = dp(12)
                    rightMargin = dp(12)
                    bottomMargin = dp(10)
                }
            )
        }
    }

    private fun createHomeWeatherHourlyColumn(item: HomeHourlyWeather): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            addView(
                TextView(context).apply {
                    text = item.label
                    setTextColor(Color.WHITE)
                    textSize = 13f
                    gravity = Gravity.CENTER
                    includeFontPadding = false
                    maxLines = 1
                },
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dp(17)
                )
            )
            addView(
                weatherIconView(item.conditionCode, dp(25)),
                LinearLayout.LayoutParams(dp(28), dp(25)).apply {
                    topMargin = dp(3)
                }
            )
            addView(
                TextView(context).apply {
                    text = getString(
                        R.string.launcher_widget_weather_temperature_format,
                        item.temperature
                    )
                    setTextColor(Color.WHITE)
                    textSize = 16f
                    gravity = Gravity.CENTER
                    includeFontPadding = false
                    maxLines = 1
                },
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dp(21)
                ).apply {
                    topMargin = dp(2)
                }
            )
        }
    }

    private fun weatherIconView(conditionCode: Int, iconSize: Int): ImageView {
        return ImageView(this).apply {
            setImageResource(homeWeatherIconRes(conditionCode))
            setColorFilter(Color.WHITE)
            scaleType = ImageView.ScaleType.FIT_CENTER
            adjustViewBounds = true
            minimumWidth = iconSize
            minimumHeight = iconSize
        }
    }

    private fun homeWeatherIconRes(conditionCode: Int): Int {
        return when (HomeWeatherWidgetPolicy.iconTypeFor(conditionCode)) {
            HomeWeatherIconType.CLEAR -> R.drawable.ic_weather_24
            HomeWeatherIconType.CLOUD -> R.drawable.ic_home_weather_cloud_24
            HomeWeatherIconType.RAIN -> R.drawable.ic_home_weather_rain_24
            HomeWeatherIconType.SNOW -> R.drawable.ic_home_weather_snow_24
            HomeWeatherIconType.STORM -> R.drawable.ic_home_weather_storm_24
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

    private fun createTodayPictureWidget(widgetId: String? = null): View {
        if (widgetId != null) {
            HomeWidgetPhotoStore.loadDrawable(this, widgetId)?.let { drawable ->
                return FrameLayout(this).apply {
                    background = roundedRectangle(Color.BLACK, 18)
                    clipToOutline = true
                    addView(
                        ImageView(context).apply {
                            setImageDrawable(drawable)
                            scaleType = ImageView.ScaleType.CENTER_CROP
                        },
                        FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                    )
                }
            }
        }
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

    private fun createHomePictureWidget(widgetId: String): View {
        val drawable = HomeWidgetPhotoStore.loadDrawable(this, widgetId) ?: return createTodayPictureWidget()
        return FrameLayout(this).apply {
            background = roundedRectangle(Color.BLACK, 18)
            clipToOutline = true
            addView(
                ImageView(context).apply {
                    setImageDrawable(drawable)
                    scaleType = ImageView.ScaleType.CENTER_CROP
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
        return SquareImageView(this).apply {
            iconContentScale = TodayWidgetAppIconRenderPolicy.iconContentScale
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
        val pageBinding = widgetsPageBinding ?: return
        pageBinding.widgetEditTopBar.visibility =
            if (isTodayWidgetEditing) VISIBLE else GONE
        pageBinding.editWidgetsButton.visibility =
            if (isTodayWidgetEditing) GONE else VISIBLE
        pageBinding.addTodayWidgetButton.setTextColor(Color.BLACK)
        pageBinding.doneTodayWidgetEditButton.setTextColor(Color.BLACK)
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
        todayWidgetDragLastPreviewRawX = Float.NaN
        todayWidgetDragLastPreviewRawY = Float.NaN
        todayWidgetDragLastPreviewUptime = 0L
        todayWidgetDragPreviewFramePosted = false
        applyTodayWidgetEditState()
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
            updateDragEdgeGlows(true)
            host.visibility = View.INVISIBLE
            val hostLocation = IntArray(2)
            host.getLocationOnScreen(hostLocation)
            updateTodayWidgetDragPreview(
                hostLocation[0] + host.width / 2f,
                hostLocation[1] + host.height / 2f
            )
            hideWidgetPageIndicator()
        } else {
            updateDragEdgeGlows(false)
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

        val dragLayer = widgetsPageBinding?.dragLayer ?: return
        val dragLayerLocation = IntArray(2)
        dragLayer.getLocationOnScreen(dragLayerLocation)
        todayWidgetDragLayerScreenX = dragLayerLocation[0]
        todayWidgetDragLayerScreenY = dragLayerLocation[1]
        val bitmap = Bitmap.createBitmap(host.width, host.height, Bitmap.Config.ARGB_8888)
        host.draw(Canvas(bitmap))
        todayWidgetDragPreview = ImageView(this).apply {
            setImageBitmap(bitmap)
            scaleType = ImageView.ScaleType.FIT_XY
            alpha = 0.96f
            elevation = dp(18).toFloat()
            visibility = View.INVISIBLE
            setLayerType(View.LAYER_TYPE_HARDWARE, null)
            isClickable = false
            isFocusable = false
        }
        dragLayer.addView(
            todayWidgetDragPreview,
            FrameLayout.LayoutParams(host.width, host.height)
        )
    }

    private fun updateTodayWidgetDragPreview(rawX: Float, rawY: Float) {
        if (todayWidgetDragPreview == null) {
            return
        }
        todayWidgetDragPendingRawX = rawX
        todayWidgetDragPendingRawY = rawY
        if (todayWidgetDragPreviewFramePosted) {
            return
        }
        todayWidgetDragPreviewFramePosted = true
        (widgetsPage ?: mLauncherView as? View)?.postOnAnimation {
            todayWidgetDragPreviewFramePosted = false
            applyTodayWidgetDragPreviewPosition(
                todayWidgetDragPendingRawX,
                todayWidgetDragPendingRawY
            )
        }
    }

    private fun applyTodayWidgetDragPreviewPosition(rawX: Float, rawY: Float) {
        val preview = todayWidgetDragPreview ?: return
        preview.visibility = VISIBLE
        preview.x = rawX - todayWidgetDragLayerScreenX - preview.width / 2f
        preview.y = rawY - todayWidgetDragLayerScreenY - preview.height / 2f
    }

    private fun removeTodayWidgetDragPreview() {
        todayWidgetDragPreview?.let { preview ->
            preview.animate().cancel()
            preview.clearAnimation()
            preview.setLayerType(View.LAYER_TYPE_NONE, null)
            (preview.parent as? ViewGroup)?.removeView(preview)
            val bitmap = (preview.drawable as? BitmapDrawable)?.bitmap
            preview.setImageDrawable(null)
            if (bitmap?.isRecycled == false) {
                bitmap.recycle()
            }
        }
        todayWidgetDragPreview = null
        todayWidgetDragLayerScreenX = 0
        todayWidgetDragLayerScreenY = 0
        todayWidgetDragLastPreviewRawX = Float.NaN
        todayWidgetDragLastPreviewRawY = Float.NaN
        todayWidgetDragLastPreviewUptime = 0L
        todayWidgetDragPendingRawX = 0f
        todayWidgetDragPendingRawY = 0f
        todayWidgetDragPreviewFramePosted = false
    }

    private fun handleTodayWidgetDragEvent(source: View, event: DragEvent): Boolean {
        val draggedId = draggedTodayWidgetId ?: return false
        val rawPoint = todayWidgetDragRawPoint(source, event)
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                updateDragEdgeGlows(true)
                return true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                updateDragEdgeGlows(true)
                updateTodayWidgetDragPreview(rawPoint.first, rawPoint.second)
                if (!shouldInspectTodayWidgetDragMove(rawPoint.first, rawPoint.second)) {
                    return true
                }
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
                updateDragEdgeGlows(false)
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
                updateDragEdgeGlows(false)
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

    private fun shouldInspectTodayWidgetDragMove(rawX: Float, rawY: Float): Boolean {
        val now = SystemClock.uptimeMillis()
        val shouldInspect = TodayWidgetDragUpdatePolicy.shouldInspectMove(
            lastRawX = todayWidgetDragLastPreviewRawX,
            lastRawY = todayWidgetDragLastPreviewRawY,
            rawX = rawX,
            rawY = rawY,
            lastUptimeMs = todayWidgetDragLastPreviewUptime,
            nowUptimeMs = now,
            minMovePx = dp(TODAY_WIDGET_DRAG_PREVIEW_MIN_MOVE_DP).toFloat(),
            minIntervalMs = TODAY_WIDGET_DRAG_PREVIEW_THROTTLE_MS
        )
        if (shouldInspect) {
            todayWidgetDragLastPreviewRawX = rawX
            todayWidgetDragLastPreviewRawY = rawY
            todayWidgetDragLastPreviewUptime = now
        }
        return shouldInspect
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
            launcherLayoutRepository.removeWidget(widgetId)
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
        launcherLayoutRepository.saveWidgetOrder(orderedNativeIds)
        saveTodayQuickWidgets()
    }

    private fun loadTodayQuickWidgets() {
        val storedWidgets = launcherTodayWidgetPreferencesRepository.getQuickWidgets()
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
        launcherTodayWidgetPreferencesRepository.getWidgetOrder()
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
        launcherTodayWidgetPreferencesRepository.saveQuickWidgets(quickWidgets, order)
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
        val expandedHeight = (resources.displayMetrics.heightPixels * 0.9f).toInt()
        val peekHeight = (resources.displayMetrics.heightPixels * 0.78f).toInt()

        val sheet = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(24), dp(10), dp(24), dp(34))
            background = roundedRectangle(0xF0F4F4F4.toInt(), 28)
            clipChildren = false
            clipToPadding = false
            isClickable = true
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                expandedHeight
            )
        }
        addSheetGrabber(sheet, expandTouchTarget = false)

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
        val searchBar = LinearLayout(this).apply {
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
        }
        sheet.addView(
            searchBar,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(50)
            ).apply {
                topMargin = dp(18)
                bottomMargin = dp(20)
            }
        )
        val scrollView = NestedScrollView(this).apply {
            isFillViewport = false
            isVerticalScrollBarEnabled = false
            clipChildren = false
            clipToPadding = false
        }
        val resultContainer = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            clipChildren = false
            clipToPadding = false
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

        val dialog = BottomSheetDialog(this).apply {
            setCancelable(true)
            setCanceledOnTouchOutside(true)
            setContentView(sheet)
            setOnDismissListener {
                if (widgetPickerDialog === this) {
                    widgetPickerDialog = null
                }
            }
        }
        widgetPickerDialog = dialog
        dialog.setOnShowListener {
            val bottomSheet = dialog.findViewById<FrameLayout>(
                com.google.android.material.R.id.design_bottom_sheet
            )
            bottomSheet?.setBackgroundColor(Color.TRANSPARENT)
            bottomSheet?.layoutParams = bottomSheet?.layoutParams?.apply {
                height = expandedHeight
            }
            bottomSheet?.requestLayout()

            BottomSheetBehavior.from(bottomSheet ?: return@setOnShowListener).apply {
                isDraggable = true
                isHideable = true
                skipCollapsed = false
                this.peekHeight = peekHeight
                state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
        dialog.show()
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
                clipChildren = false
                clipToPadding = false
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
                    LinearLayout.LayoutParams(0, homeWidgetPickerPreviewHeight(TodayWidgetLayoutPolicy.Span.HALF), 1f).apply {
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
            clipChildren = false
            clipToPadding = false
            isClickable = true
            setOnClickListener(addWidget)
        }
        val previewHeight = homeWidgetPickerPreviewHeight(type.span)
        val preview = FrameLayout(this).apply {
            clipChildren = false
            clipToPadding = false
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
                previewHeight
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
            clipChildren = false
            clipToPadding = false
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
                    topMargin = dp(12)
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
            TodayQuickWidgetType.WEATHER -> getString(R.string.today_widget_weather)
            TodayQuickWidgetType.BATTERY -> getString(R.string.today_widget_battery)
            TodayQuickWidgetType.PICTURE -> getString(R.string.today_widget_picture)
            TodayQuickWidgetType.APP_GROUP -> getString(R.string.today_widget_suggestions)
            TodayQuickWidgetType.FAVORITES -> getString(R.string.today_widget_favorites)
            TodayQuickWidgetType.CALENDAR -> getString(R.string.today_widget_calendar)
        }
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
            clipChildren = false
            clipToPadding = false
            isClickable = true
            setOnClickListener { showTodayWidgetPreview(provider) }
        }
        val previewHeight = homeWidgetPickerPreviewHeight(
            if (fullWidth) TodayWidgetLayoutPolicy.Span.FULL else TodayWidgetLayoutPolicy.Span.HALF
        )
        val preview = FrameLayout(this).apply {
            background = if (fullWidth) {
                roundedRectangle(Color.rgb(92, 158, 220), 16)
            } else {
                roundedRectangle(0xCCFFFFFF.toInt(), 16)
            }
            clipChildren = false
            clipToPadding = false
        }
        root.addView(
            preview,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                previewHeight
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
                label = launcherSystemRepository.loadWidgetProviderLabel(providerInfo),
                icon = providerInfo.loadIcon(this, density),
                preview = runCatching {
                    providerInfo.loadPreviewImage(this, density)
                }.getOrNull(),
                sizeText = HomeWidgetProviderPreviewPolicy.sizeText(
                    providerInfo.minWidth,
                    providerInfo.minHeight
                ),
                span = TodayWidgetLayoutPolicy.spanFor(providerInfo.minWidth, providerInfo.minHeight)
            )
        }.sortedWith { left, right ->
            collator.compare(left.label.toString(), right.label.toString())
        }
    }

    private fun showHomeWidgetEntryCard() {
        if (!isWobbling || homeWidgetEntryCard != null || !::workspace.isInitialized) {
            return
        }
        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            background = roundedRectangle(0xF7FFFFFF.toInt(), 20)
            elevation = dp(14).toFloat()
            isClickable = true
            isFocusable = true
            setOnClickListener { showHomeWidgetPicker() }
        }
        card.addView(
            LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                setPadding(dp(18), 0, dp(18), 0)
                addView(
                    TextView(context).apply {
                        text = getString(R.string.home_widget_add_entry)
                        setTextColor(Color.BLACK)
                        textSize = 18f
                        typeface = Typeface.DEFAULT_BOLD
                        gravity = Gravity.CENTER_VERTICAL
                    },
                    LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f)
                )
                addView(createHomeWidgetGridGlyph(), LinearLayout.LayoutParams(dp(34), dp(34)))
            },
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dp(48))
        )
        card.addView(
            View(this).apply { setBackgroundColor(0x12000000) },
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dp(1))
        )
        card.addView(
            View(this),
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f)
        )

        homeWidgetEntryCard = card
        val cardWidth = (resources.displayMetrics.widthPixels * 0.64f)
            .toInt()
            .coerceAtLeast(dp(260))
        homeWidgetEntryCardTargetTop = homeWidgetEntryCardTopMargin().toFloat()
        workspace.addView(
            card,
            InsettableRelativeLayout.LayoutParams(
                cardWidth,
                dp(92)
            ).apply {
                leftMargin = 0
                topMargin = 0
                addRule(RelativeLayout.ALIGN_PARENT_TOP)
            }
        )
        card.bringToFront()
        if (::editTopBar.isInitialized) {
            editTopBar.bringToFront()
        }
        card.alpha = 0f
        card.translationX = dp(18).toFloat()
        card.translationY = homeWidgetEntryCardTargetTop - dp(10)
        card.animate()
            .alpha(1f)
            .translationY(homeWidgetEntryCardTargetTop)
            .setDuration(160L)
            .setInterpolator(DecelerateInterpolator())
            .start()
    }

    private fun homeWidgetEntryCardTopMargin(): Int {
        val topBarHeight = if (::editTopBar.isInitialized && editTopBar.height > 0) {
            editTopBar.height
        } else {
            dp(78)
        }
        return topBarHeight + dp(10)
    }

    private fun createHomeWidgetGridGlyph(): View {
        return GridLayout(this).apply {
            rowCount = 2
            columnCount = 2
            repeat(4) {
                addView(
                    View(context).apply {
                        background = roundedRectangle(0xFF8E8E93.toInt(), 2)
                    },
                    GridLayout.LayoutParams().apply {
                        width = dp(14)
                        height = dp(14)
                        setMargins(dp(2), dp(2), dp(2), dp(2))
                    }
                )
            }
        }
    }

    private fun hideHomeWidgetEntryCard(immediate: Boolean = false) {
        val card = homeWidgetEntryCard ?: return
        homeWidgetEntryCard = null
        if (immediate) {
            card.animate().cancel()
            (card.parent as? ViewGroup)?.removeView(card)
            return
        }
        card.animate()
            .alpha(0f)
            .translationY(homeWidgetEntryCardTargetTop - dp(10))
            .setDuration(120L)
            .withEndAction {
                (card.parent as? ViewGroup)?.removeView(card)
            }
            .start()
    }

    private fun showHomeWidgetPicker() {
        dismissTodayWidgetPicker()
        dismissTodayWidgetPreview()
        dismissHomeWidgetProviderPreview()
        dismissHomeWidgetPicker()

        hideHomeWidgetEntryCard(immediate = true)
        val topClearance = homeWidgetPickerTopClearance()
        val bottomOverflow = homeWidgetPickerBottomOverflow()
        val expandedHeight = HomeWidgetProviderPreviewPolicy.pickerHeight(
            screenHeightPx = resources.displayMetrics.heightPixels,
            topClearancePx = topClearance,
            preferredHeightPx = resources.displayMetrics.heightPixels,
            bottomOverflowPx = bottomOverflow
        )
        val peekHeight = expandedHeight

        val sheet = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(24), dp(10), dp(24), dp(18))
            background = roundedRectangle(0xF4F4F4F4.toInt(), 28)
            clipChildren = true
            clipToPadding = true
            isClickable = true
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                expandedHeight
            )
        }
        applyHomeWidgetSheetInsets(sheet, bottomPaddingDp = 18)
        homeWidgetPickerSheet = sheet

        addSheetGrabber(sheet, expandTouchTarget = false)

        val searchInput = EditText(this).apply {
            hint = getString(R.string.today_widget_search_hint)
            setSingleLine(true)
            imeOptions = EditorInfo.IME_ACTION_SEARCH
            inputType = InputType.TYPE_CLASS_TEXT
            textSize = 22f
            setTextColor(Color.BLACK)
            setHintTextColor(0x7A000000)
            background = ColorDrawable(Color.TRANSPARENT)
            setPadding(dp(8), 0, dp(8), 0)
        }
        val searchBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = roundedRectangle(0x33000000, 14)
            elevation = dp(12).toFloat()
            translationZ = dp(12).toFloat()
            setPadding(dp(12), 0, dp(10), 0)
            addView(
                ImageView(context).apply {
                    setImageResource(R.drawable.ic_search_18)
                    setColorFilter(0x66000000)
                },
                LinearLayout.LayoutParams(dp(22), dp(22))
            )
            addView(
                searchInput,
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
            )
        }
        sheet.addView(
            searchBar,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(54)
            ).apply {
                topMargin = dp(22)
                bottomMargin = dp(22)
            }
        )

        val scrollView = NestedScrollView(this).apply {
            isFillViewport = false
            isVerticalScrollBarEnabled = false
            overScrollMode = View.OVER_SCROLL_NEVER
            clipChildren = true
            clipToPadding = true
        }
        val resultContainer = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            clipChildren = false
            clipToPadding = false
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

        renderHomeWidgetPickerContent(resultContainer, "")
        searchInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                renderHomeWidgetPickerContent(resultContainer, s?.toString().orEmpty())
            }

            override fun afterTextChanged(s: Editable?) = Unit
        })

        val dialog = BottomSheetDialog(this).apply {
            setCancelable(true)
            setCanceledOnTouchOutside(true)
            setContentView(sheet)
            setOnDismissListener {
                if (homeWidgetPickerDialog === this) {
                    homeWidgetPickerDialog = null
                    homeWidgetPickerSheet = null
                    if (isWobbling && !homeWidgetTouchDragActive && homeWidgetDragSpec == null) {
                        showHomeWidgetEntryCard()
                    }
                }
            }
        }
        homeWidgetPickerDialog = dialog
        dialog.setOnShowListener {
            dialog.window?.setDimAmount(0.52f)
            dialog.window?.decorView?.setOnDragListener { source, event ->
                handleHomeWidgetDragEvent(source, event)
            }
            val bottomSheet = dialog.findViewById<FrameLayout>(
                com.google.android.material.R.id.design_bottom_sheet
            )
            bottomSheet?.setBackgroundColor(Color.TRANSPARENT)
            bottomSheet?.fitsSystemWindows = false
            bottomSheet?.setPadding(0, 0, 0, 0)
            bottomSheet?.layoutParams = bottomSheet?.layoutParams?.apply {
                height = expandedHeight
            }
            bottomSheet?.requestLayout()
            homeWidgetPickerSheet = bottomSheet ?: sheet
            configureHomeWidgetBottomSheetWindow(dialog)

            BottomSheetBehavior.from(bottomSheet ?: return@setOnShowListener).apply {
                isFitToContents = false
                expandedOffset = topClearance
                isDraggable = true
                isHideable = true
                skipCollapsed = true
                this.peekHeight = peekHeight
                state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        dialog.show()
    }

    private fun homeWidgetPickerTopClearance(): Int {
        val rootLocation = IntArray(2)
        (mLauncherView as? View)?.getLocationOnScreen(rootLocation)
        val topBarBounds = Rect()
        val anchorBottom = if (::editTopBar.isInitialized && editTopBar.getGlobalVisibleRect(topBarBounds)) {
            topBarBounds.bottom
        } else {
            null
        }
        val fallback = dp(HOME_WIDGET_PICKER_TOP_CLEARANCE_DP)
        return HomeWidgetProviderPreviewPolicy.pickerTopClearance(
            anchorBottomOnScreenPx = anchorBottom,
            rootTopOnScreenPx = rootLocation[1],
            fallbackPx = fallback,
            marginPx = dp(18)
        )
    }

    private fun homeWidgetPickerBottomOverflow(): Int = dp(HOME_WIDGET_PICKER_BOTTOM_OVERFLOW_DP)

    private fun configureHomeWidgetBottomSheetWindow(dialog: BottomSheetDialog) {
        dialog.window?.let { window ->
            WindowCompat.setDecorFitsSystemWindows(window, false)
            window.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            window.navigationBarColor = Color.TRANSPARENT
        }
    }

    private fun applyHomeWidgetSheetInsets(sheet: View, bottomPaddingDp: Int) {
        val left = dp(24)
        val top = dp(10)
        val right = dp(24)
        val bottom = dp(bottomPaddingDp)
        ViewCompat.setOnApplyWindowInsetsListener(sheet) { view, insets ->
            val navigationBottom = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
            view.setPadding(left, top, right, bottom + navigationBottom)
            insets
        }
        ViewCompat.requestApplyInsets(sheet)
    }

    private fun renderHomeWidgetPickerContent(container: LinearLayout, query: String) {
        val normalizedQuery = Utilities.stripCaseAndAccents(query)
        container.removeAllViews()

        val quickWidgets = listOf(
            TodayQuickWidgetType.WEATHER,
            TodayQuickWidgetType.BATTERY,
            TodayQuickWidgetType.PICTURE
        ).filter {
            normalizedQuery.isBlank() ||
                Utilities.stripCaseAndAccents(todayQuickWidgetLabel(it)).contains(normalizedQuery)
        }

        if (TodayQuickWidgetType.WEATHER in quickWidgets) {
            container.addView(
                createHomeWidgetPickerCard(TodayQuickWidgetType.WEATHER),
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    bottomMargin = dp(18)
                }
            )
        }

        val smallWidgets = quickWidgets.filter { it != TodayQuickWidgetType.WEATHER }
        if (smallWidgets.isNotEmpty()) {
            val row = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER
                clipChildren = false
                clipToPadding = false
            }
            smallWidgets.forEach { type ->
                row.addView(
                    createHomeWidgetPickerCard(type),
                    LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f).apply {
                        setMargins(dp(6), 0, dp(6), dp(18))
                    }
                )
            }
            if (smallWidgets.size == 1) {
                row.addView(View(this), LinearLayout.LayoutParams(0, homeWidgetPickerPreviewHeight(TodayWidgetLayoutPolicy.Span.HALF), 1f))
            }
            container.addView(row)
        }

        val apps = homeWidgetPickerApps(normalizedQuery)
        val visibleApps = apps.take(
            HomeWidgetProviderPreviewPolicy.visibleAppCount(
                totalApps = apps.size,
                hasSearchQuery = normalizedQuery.isNotBlank()
            )
        )
        visibleApps.forEach { app ->
            container.addView(createHomeWidgetAppRow(app))
        }
    }

    private fun createHomeWidgetPickerCard(type: TodayQuickWidgetType): View {
        val startDragListener = View.OnLongClickListener { view ->
            startHomeWidgetPickerDrag(
                homeWidgetTypeForQuick(type),
                view,
                homeWidgetTouchLastRawX,
                homeWidgetTouchLastRawY
            )
        }
        val previewHeight = homeWidgetPickerPreviewHeight(type.span)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            clipChildren = false
            clipToPadding = false
            isClickable = true
            setOnLongClickListener(startDragListener)
        }
        root.addView(
            FrameLayout(this).apply {
                clipChildren = false
                clipToPadding = false
                elevation = dp(18).toFloat()
                translationZ = dp(18).toFloat()
                isLongClickable = true
                setOnLongClickListener(startDragListener)
                addView(
                    createTodayWidgetOptionPreview(type),
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                )
            },
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                previewHeight
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
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = dp(10)
            }
        )
        installHomeWidgetTouchDragTracking(root)
        return root
    }

    private fun homeWidgetPickerPreviewHeight(span: TodayWidgetLayoutPolicy.Span): Int {
        val contentWidth = (resources.displayMetrics.widthPixels - dp(48)).coerceAtLeast(1)
        return when (span) {
            TodayWidgetLayoutPolicy.Span.FULL -> HomeWidgetPickerPreviewPolicy.gridPreviewHeight(
                contentWidthPx = contentWidth,
                columns = 4,
                rows = 2,
                cardsInRow = 1,
                horizontalMarginsPx = dp(12),
                minimumHeightPx = dp(148)
            )
            TodayWidgetLayoutPolicy.Span.HALF -> HomeWidgetPickerPreviewPolicy.gridPreviewHeight(
                contentWidthPx = contentWidth,
                columns = 2,
                rows = 2,
                cardsInRow = 2,
                horizontalMarginsPx = dp(24),
                minimumHeightPx = dp(148)
            )
        }
    }

    private fun createHomeWidgetAppRow(app: ApplicationItem): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            isClickable = true
            isFocusable = true
            setOnClickListener { showHomeWidgetProviderPreview(app) }
            addView(
                LinearLayout(context).apply {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL
                    setPadding(dp(14), dp(8), 0, dp(8))
                    addView(
                        ImageView(context).apply {
                            setImageDrawable(app.icon)
                            scaleType = ImageView.ScaleType.FIT_CENTER
                        },
                        LinearLayout.LayoutParams(dp(50), dp(50)).apply {
                            rightMargin = dp(18)
                        }
                    )
                    addView(
                        TextView(context).apply {
                            text = app.title
                            setTextColor(Color.BLACK)
                            textSize = 17f
                            typeface = Typeface.create("sans-serif-medium", Typeface.NORMAL)
                            gravity = Gravity.CENTER_VERTICAL
                        },
                        LinearLayout.LayoutParams(0, dp(58), 1f)
                    )
                },
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            )
            addView(
                View(context).apply {
                    setBackgroundColor(0x1A000000)
                },
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dp(1)).apply {
                    leftMargin = dp(82)
                }
            )
        }
    }

    private fun showHomeWidgetProviderPreview(app: ApplicationItem) {
        val packageName = app.componentName?.packageName
        if (packageName.isNullOrBlank()) {
            Toast.makeText(this, R.string.home_widget_no_widgets_for_app, Toast.LENGTH_SHORT).show()
            return
        }
        val providers = homeWidgetProvidersForPackage(packageName)
        if (providers.isEmpty()) {
            Toast.makeText(this, R.string.home_widget_no_widgets_for_app, Toast.LENGTH_SHORT).show()
            return
        }

        dismissHomeWidgetProviderPreview()

        val topClearance = homeWidgetPickerTopClearance()
        val bottomOverflow = homeWidgetPickerBottomOverflow()
        val expandedHeight = HomeWidgetProviderPreviewPolicy.pickerHeight(
            screenHeightPx = resources.displayMetrics.heightPixels,
            topClearancePx = topClearance,
            preferredHeightPx = resources.displayMetrics.heightPixels,
            bottomOverflowPx = bottomOverflow
        )
        val sheet = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(24), dp(10), dp(24), dp(34))
            background = roundedRectangle(0xF4F4F4F4.toInt(), 28)
            clipChildren = false
            clipToPadding = false
            isClickable = true
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                expandedHeight
            )
        }
        applyHomeWidgetSheetInsets(sheet, bottomPaddingDp = 34)
        addSheetGrabber(sheet, expandTouchTarget = false)
        sheet.addView(
            View(this).apply { background = roundedRectangle(0x33000000, 4) },
            LinearLayout.LayoutParams(dp(60), dp(8)).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = dp(14)
            }
        )

        val title = TextView(this).apply {
            text = getString(R.string.home_widget_add_entry)
            gravity = Gravity.CENTER
            setTextColor(Color.BLACK)
            textSize = 26f
            typeface = Typeface.DEFAULT_BOLD
        }
        sheet.addView(
            title,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = dp(42)
            }
        )

        val subtitle = TextView(this).apply {
            gravity = Gravity.CENTER
            setTextColor(0x8A000000.toInt())
            textSize = 16f
            typeface = Typeface.DEFAULT_BOLD
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
        }
        sheet.addView(
            subtitle,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = dp(12)
            }
        )

        val previewScroll = HorizontalScrollView(this).apply {
            isHorizontalScrollBarEnabled = false
            overScrollMode = View.OVER_SCROLL_NEVER
            clipChildren = false
            clipToPadding = false
        }
        val previewRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            clipChildren = false
            clipToPadding = false
        }
        previewScroll.addView(
            previewRow,
            FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        )
        sheet.addView(
            previewScroll,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            ).apply {
                topMargin = dp(26)
            }
        )

        val pageWidth = (resources.displayMetrics.widthPixels - dp(48)).coerceAtLeast(dp(220))
        providers.forEach { provider ->
            previewRow.addView(
                createHomeWidgetProviderPreviewPage(provider),
                LinearLayout.LayoutParams(pageWidth, LinearLayout.LayoutParams.MATCH_PARENT).apply {
                    leftMargin = dp(4)
                    rightMargin = dp(4)
                }
            )
        }

        fun selectedIndex(): Int {
            val stride = pageWidth + dp(8)
            return ((previewScroll.scrollX + stride / 2) / stride).coerceIn(0, providers.lastIndex)
        }

        fun updateSubtitle() {
            val provider = providers[selectedIndex()]
            subtitle.text = getString(
                R.string.home_widget_provider_preview_subtitle,
                provider.label,
                provider.sizeText
            )
        }
        updateSubtitle()
        previewScroll.setOnScrollChangeListener { _, _, _, _, _ -> updateSubtitle() }

        val addButton = TextView(this).apply {
            text = getString(R.string.add_widget).uppercase()
            gravity = Gravity.CENTER
            setTextColor(Color.WHITE)
            textSize = 21f
            typeface = Typeface.DEFAULT_BOLD
            background = roundedRectangle(0xFF3897F5.toInt(), 16)
            isClickable = true
            isFocusable = true
            setOnClickListener {
                Toast.makeText(this@LauncherActivity, R.string.home_widget_added_hold_hint, Toast.LENGTH_SHORT).show()
            }
        }
        sheet.addView(
            addButton,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(64)
            ).apply {
                topMargin = dp(24)
            }
        )

        val dialog = BottomSheetDialog(this).apply {
            setCancelable(true)
            setCanceledOnTouchOutside(true)
            setContentView(sheet)
            setOnDismissListener {
                if (homeWidgetProviderDialog === this) {
                    homeWidgetProviderDialog = null
                    homeWidgetProviderSheet = null
                }
            }
        }
        homeWidgetProviderDialog = dialog
        homeWidgetProviderSheet = sheet
        dialog.setOnShowListener {
            dialog.window?.setDimAmount(0.52f)
            val bottomSheet = dialog.findViewById<FrameLayout>(
                com.google.android.material.R.id.design_bottom_sheet
            )
            bottomSheet?.setBackgroundColor(Color.TRANSPARENT)
            bottomSheet?.fitsSystemWindows = false
            bottomSheet?.setPadding(0, 0, 0, 0)
            bottomSheet?.layoutParams = bottomSheet?.layoutParams?.apply {
                height = expandedHeight
            }
            bottomSheet?.requestLayout()
            homeWidgetProviderSheet = bottomSheet ?: sheet
            configureHomeWidgetBottomSheetWindow(dialog)
            BottomSheetBehavior.from(bottomSheet ?: return@setOnShowListener).apply {
                isFitToContents = false
                expandedOffset = topClearance
                isDraggable = true
                isHideable = true
                skipCollapsed = true
                peekHeight = expandedHeight
                state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        dialog.show()
    }

    private fun createHomeWidgetProviderPreviewPage(provider: TodayWidgetProvider): View {
        val startDragListener = View.OnLongClickListener { view ->
            startHomeWidgetProviderDrag(
                provider = provider,
                source = view,
                rawX = homeWidgetTouchLastRawX,
                rawY = homeWidgetTouchLastRawY
            )
        }
        return FrameLayout(this).apply {
            background = roundedRectangle(0xFFE2E2E6.toInt(), 34)
            clipChildren = false
            clipToPadding = false
            isClickable = true
            isLongClickable = true
            setOnLongClickListener(startDragListener)
            val preview = provider.preview
            if (preview != null) {
                addView(
                    ImageView(context).apply {
                        setImageDrawable(freshDrawable(preview))
                        adjustViewBounds = true
                        scaleType = ImageView.ScaleType.FIT_CENTER
                        isLongClickable = true
                        setOnLongClickListener(startDragListener)
                    },
                    FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT
                    )
                )
            } else {
                addView(
                    LinearLayout(context).apply {
                        orientation = LinearLayout.VERTICAL
                        gravity = Gravity.CENTER
                        setPadding(dp(28), dp(28), dp(28), dp(28))
                        addView(
                            ImageView(context).apply {
                                setImageDrawable(freshDrawable(provider.icon))
                                scaleType = ImageView.ScaleType.FIT_CENTER
                                background = roundedRectangle(Color.WHITE, 24)
                                setPadding(dp(16), dp(16), dp(16), dp(16))
                                isLongClickable = true
                                setOnLongClickListener(startDragListener)
                            },
                            LinearLayout.LayoutParams(dp(104), dp(104))
                        )
                        addView(
                            TextView(context).apply {
                                text = provider.label
                                gravity = Gravity.CENTER
                                setTextColor(Color.BLACK)
                                textSize = 20f
                                typeface = Typeface.DEFAULT_BOLD
                                maxLines = 2
                                ellipsize = TextUtils.TruncateAt.END
                                isLongClickable = true
                                setOnLongClickListener(startDragListener)
                            },
                            LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                            ).apply {
                                topMargin = dp(18)
                            }
                        )
                    },
                    FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT
                    )
                )
            }
            installHomeWidgetTouchDragTracking(this)
        }
    }

    private fun homeWidgetProvidersForPackage(packageName: String): List<TodayWidgetProvider> {
        return todayWidgetProviders().filter { provider ->
            provider.providerInfo.provider.packageName == packageName
        }
    }

    private fun homeWidgetPickerApps(normalizedQuery: String): List<ApplicationItem> {
        val apps = if (appLibraryApps.isNotEmpty()) {
            appLibraryApps
        } else {
            fallbackSuggestedApps(80).filterIsInstance<ApplicationItem>()
        }
        return apps.filter {
            normalizedQuery.isBlank() ||
                Utilities.stripCaseAndAccents(it.title?.toString().orEmpty()).contains(normalizedQuery)
        }.sortedWith { left, right ->
            Collator.getInstance().compare(left.title?.toString().orEmpty(), right.title?.toString().orEmpty())
        }.take(80)
    }

    private fun loadHomeWidgets() {
        homeWidgetItems.clear()
        homeWidgetItems.addAll(HomeWidgetPreferences.read(this))
        normalizeHomeWidgetItems(saveIfChanged = true)
    }

    private fun saveHomeWidgets() {
        HomeWidgetPreferences.save(this, homeWidgetItems)
    }

    private fun renderHomeWidgets() {
        normalizeHomeWidgetItems(saveIfChanged = true)
        removeHomeWidgetViews()
        val sortedItems = homeWidgetItems.sortedWith(compareBy<HomeWidgetPreferences.Item> { it.page }.thenBy { it.cell })
        sortedItems.forEach { item ->
            val page = ensureHomePage(item.page)
            if (mHorizontalPager.indexOfChild(page) < 0) {
                addHomePageToPager(page)
            }
            val view = createHomeWidgetView(item)
            applyHomeWidgetLayoutParams(page, view, item)
            page.addView(view)
        }
        applyHomeWidgetEditState()
    }

    private fun normalizeHomeWidgetItems(saveIfChanged: Boolean) {
        val normalized = HomeWidgetMergePolicy.normalize(
            items = homeWidgetItems,
            columnsForPage = { pageIndex ->
                pages.getOrNull(pageIndex)?.columnCount ?: mDeviceProfile.numColumns
            },
            maxCellsForPage = { pageIndex ->
                pages.getOrNull(pageIndex)?.let { it.rowCount * it.columnCount }
                    ?: mDeviceProfile.maxAppsPerPage
            }
        )
        if (normalized == homeWidgetItems) {
            return
        }
        homeWidgetItems.clear()
        homeWidgetItems.addAll(normalized)
        if (saveIfChanged) {
            saveHomeWidgets()
        }
    }

    private fun removeHomeWidgetViews() {
        pages.forEach { page ->
            var index = page.childCount - 1
            while (index >= 0) {
                val child = page.getChildAt(index)
                if (child.tag is HomeWidgetPreferences.Item) {
                    page.removeViewAt(index)
                }
                index--
            }
        }
    }

    private fun applyHomeWidgetEditState() {
        val showRemoveButtons = HomeWidgetEditStatePolicy.shouldShowRemoveButton(
            editing = isWobbling,
            draggingWidget = homeWidgetDragSpec != null
        )
        if (
            HomeWidgetEditStatePolicy.shouldPurgeEditChrome(
                editing = isWobbling,
                draggingWidget = homeWidgetDragSpec != null
            )
        ) {
            clearAllHomeWidgetEditChrome()
        }
        pages.forEach { page ->
            var widgetIndex = 0
            for (index in 0 until page.childCount) {
                val host = page.getChildAt(index) as? FrameLayout ?: continue
                val item = host.tag as? HomeWidgetPreferences.Item
                if (item == null) {
                    continue
                }
                syncHomeWidgetRemoveButton(host)
                if (
                    HomeWidgetEditStatePolicy.shouldAnimateWidget(
                        editing = isWobbling,
                        draggingWidget = homeWidgetDragSpec != null
                    )
                ) {
                    if (host.animation == null) {
                        host.startAnimation(todayWidgetWobbleAnimation(widgetIndex % 2 != 0))
                    }
                } else {
                    host.clearAnimation()
                }
                widgetIndex++
            }
        }
    }

    private fun clearAllHomeWidgetEditChrome() {
        (mLauncherView as? ViewGroup)?.let { root ->
            removeHomeWidgetRemoveButtons(root)
            clearHomeWidgetAnimations(root)
        }
    }

    private fun forceStopHomeWidgetEditing() {
        homeWidgetDragSessionId = HomeWidgetDragSessionPolicy.nextSessionId(homeWidgetDragSessionId)
        if (HomeWidgetEditStatePolicy.shouldResetTransientTouchState(isWobbling)) {
            updateDragEdgeGlows(false)
            homeWidgetTouchDragActive = false
            homeWidgetTouchDragStartedFromPicker = false
            homeWidgetTouchLastRawX = 0f
            homeWidgetTouchLastRawY = 0f
            homeWidgetRemoveTouchHost = null
        }
        setHomeWidgetDragIconJiggleReduced(false)
        restoreHomeWidgetDragAppCells(animate = false)
        restoreHomeWidgetDragWidgetCells(animate = false)
        homeWidgetDragSpec = null
        homeWidgetDragDropped = false
        pendingHomeWidgetDropItem = null
        homeWidgetDragHost?.alpha = 1f
        homeWidgetDragHost?.visibility = VISIBLE
        homeWidgetDragHost = null
        clearHomeWidgetDragPreviewState()
        removeHomeWidgetDragPreview()
        dismissHomeWidgetPicker()
        dismissHomeWidgetProviderPreview()
        dismissHomeWidgetOptionsPopup()
        clearAllHomeWidgetEditChrome()
        renderHomeWidgets()
        clearAllHomeWidgetEditChrome()
    }

    private fun removeHomeWidgetRemoveButtons(parent: ViewGroup) {
        var index = parent.childCount - 1
        while (index >= 0) {
            val child = parent.getChildAt(index)
            if (child.tag == HOME_WIDGET_REMOVE_TAG) {
                parent.removeViewAt(index)
            } else if (child is ViewGroup) {
                removeHomeWidgetRemoveButtons(child)
            }
            index--
        }
    }

    private fun clearHomeWidgetAnimations(parent: ViewGroup) {
        for (index in 0 until parent.childCount) {
            val child = parent.getChildAt(index)
            if (child is FrameLayout && child.tag is HomeWidgetPreferences.Item) {
                child.clearAnimation()
            }
            if (child is ViewGroup) {
                clearHomeWidgetAnimations(child)
            }
        }
    }

    private fun syncHomeWidgetRemoveButton(host: FrameLayout) {
        val existingButton = host.findViewWithTag<View>(HOME_WIDGET_REMOVE_TAG)
        if (
            HomeWidgetEditStatePolicy.shouldShowRemoveButton(
                editing = isWobbling,
                draggingWidget = homeWidgetDragSpec != null
            )
        ) {
            val button = existingButton ?: createHomeWidgetRemoveButton(host).also { host.addView(it) }
            button.visibility = VISIBLE
            button.bringToFront()
            return
        }

        if (existingButton != null) {
            host.removeView(existingButton)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun installHomeWidgetTouchDragTracking(
        root: View,
        widgetType: String? = null
    ) {
        val listener = View.OnTouchListener { source, event ->
            homeWidgetTouchLastRawX = event.rawX
            homeWidgetTouchLastRawY = event.rawY
            if (handleHomeWidgetRemoveButtonFallbackTouch(source, event)) {
                return@OnTouchListener true
            }
            if (homeWidgetTouchDragActive) {
                handleHomeWidgetTouchDragMotion(source, event)
            } else {
                false
            }
        }
        attachHomeWidgetTouchDragTracking(root, listener, widgetType)
    }

    private fun attachHomeWidgetTouchDragTracking(
        view: View,
        listener: View.OnTouchListener,
        widgetType: String?
    ) {
        if (view.tag == HOME_WIDGET_REMOVE_TAG) {
            return
        }
        if (
            widgetType != null &&
            !HomeWidgetInteractionPolicy.shouldAttachLauncherTouchTracking(
                widgetType = widgetType,
                isProviderContent = view is RoundedWidgetView
            )
        ) {
            return
        }
        view.setOnTouchListener(listener)
        if (view is ViewGroup) {
            for (index in 0 until view.childCount) {
                attachHomeWidgetTouchDragTracking(view.getChildAt(index), listener, widgetType)
            }
        }
    }

    private fun handleHomeWidgetRemoveButtonFallbackTouch(source: View, event: MotionEvent): Boolean {
        val host = homeWidgetHostFor(source) ?: return false
        val removeButton = host.findViewWithTag<View>(HOME_WIDGET_REMOVE_TAG) ?: return false
        val hitRemoveButton = removeButton.visibility == VISIBLE &&
            removeButton.isShown &&
            rawPointInsideHomeWidgetRemoveTarget(host, event.rawX, event.rawY)
        val decision = HomeWidgetRemoveTouchPolicy.decide(
            action = homeWidgetRemoveTouchAction(event),
            editing = isWobbling,
            draggingWidget = homeWidgetDragSpec != null,
            hitRemoveButton = hitRemoveButton,
            trackingRemoveButton = homeWidgetRemoveTouchHost === host
        )
        if (!decision.consume) {
            return false
        }
        homeWidgetRemoveTouchHost = if (decision.trackRemoveButton) host else null
        removeButton.isPressed = decision.pressed
        requestDisallowHomeWidgetTouchIntercept(source, decision.trackRemoveButton)
        if (decision.remove) {
            removeHomeWidgetFromHost(host)
        }
        return true
    }

    private fun homeWidgetRemoveTouchAction(event: MotionEvent): HomeWidgetRemoveTouchPolicy.Action {
        return when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> HomeWidgetRemoveTouchPolicy.Action.DOWN
            MotionEvent.ACTION_MOVE -> HomeWidgetRemoveTouchPolicy.Action.MOVE
            MotionEvent.ACTION_UP -> HomeWidgetRemoveTouchPolicy.Action.UP
            MotionEvent.ACTION_CANCEL -> HomeWidgetRemoveTouchPolicy.Action.CANCEL
            else -> HomeWidgetRemoveTouchPolicy.Action.OTHER
        }
    }

    private fun homeWidgetHostFor(source: View): FrameLayout? {
        var current: View? = source
        while (current != null) {
            if (current is FrameLayout && current.tag is HomeWidgetPreferences.Item) {
                return current
            }
            current = current.parent as? View
        }
        return null
    }

    private fun rawPointInsideHomeWidgetRemoveTarget(host: View, rawX: Float, rawY: Float): Boolean {
        val removeButton = (host as? ViewGroup)?.findViewWithTag<View>(HOME_WIDGET_REMOVE_TAG)
        if (removeButton != null && removeButton.visibility == VISIBLE && removeButton.isShown) {
            val buttonLocation = IntArray(2)
            removeButton.getLocationOnScreen(buttonLocation)
            if (
                HomeWidgetRemoveHitPolicy.isInsideExpandedViewBounds(
                    rawX = rawX,
                    rawY = rawY,
                    viewLeft = buttonLocation[0],
                    viewTop = buttonLocation[1],
                    viewWidth = removeButton.width,
                    viewHeight = removeButton.height,
                    minTouchSizePx = dp(56)
                )
            ) {
                return true
            }
        }
        val location = IntArray(2)
        host.getLocationOnScreen(location)
        return HomeWidgetRemoveHitPolicy.isInsideExpandedCorner(
            rawX = rawX,
            rawY = rawY,
            hostLeft = location[0],
            hostTop = location[1],
            touchSizePx = dp(56)
        )
    }

    private fun createHomeWidgetView(item: HomeWidgetPreferences.Item): FrameLayout {
        lateinit var host: FrameLayout
        val startDragListener = View.OnLongClickListener {
            if (isWobbling) {
                startExistingHomeWidgetDrag(
                    item,
                    host,
                    homeWidgetTouchLastRawX,
                    homeWidgetTouchLastRawY
                )
            } else {
                showHomeWidgetOptionsPopup(item, host)
                true
            }
        }
        host = FrameLayout(this).apply {
            tag = item
            clipChildren = false
            clipToPadding = false
            isClickable = true
            isLongClickable = true
            setOnLongClickListener(startDragListener)
            val body = if (item.type == HOME_WIDGET_TYPE_SYSTEM) {
                createHomeSystemWidgetBody(item, startDragListener)
            } else {
                createHomeWidgetBody(item.type, startDragListener, item.id)
            }
            addView(
                body,
                FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
            )
            installHomeWidgetClickAction(this, item, startDragListener)
            installHomeWidgetTouchDragTracking(this, item.type)
        }
        return host
    }

    private fun installHomeWidgetClickAction(
        root: View,
        item: HomeWidgetPreferences.Item,
        startDragListener: View.OnLongClickListener?
    ) {
        if (item.type != HOME_WIDGET_TYPE_WEATHER && item.type != HOME_WIDGET_TYPE_PICTURE) {
            return
        }
        val clickListener = View.OnClickListener {
            if (isWobbling || homeWidgetDragSpec != null) {
                return@OnClickListener
            }
            when (item.type) {
                HOME_WIDGET_TYPE_WEATHER -> handleWeatherWidgetClicked()
                HOME_WIDGET_TYPE_PICTURE -> handlePhotoWidgetClicked(item)
            }
        }
        fun attach(view: View) {
            if (view.tag == HOME_WIDGET_REMOVE_TAG) {
                return
            }
            view.isClickable = true
            view.setOnClickListener(clickListener)
            if (startDragListener != null) {
                view.isLongClickable = true
                view.setOnLongClickListener(startDragListener)
            }
            if (view is ViewGroup) {
                for (index in 0 until view.childCount) {
                    attach(view.getChildAt(index))
                }
            }
        }
        attach(root)
    }

    private fun showHomeWidgetOptionsPopup(item: HomeWidgetPreferences.Item, anchor: View) {
        dismissLauncherOptionsPopup()
        dismissHomeWidgetOptionsPopup()

        val popupWidth = dp(276)
        val menu = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            background = roundedRectangle(0xD85F6663.toInt(), 14)
            setPadding(0, dp(2), 0, dp(2))
        }
        if (item.type == HOME_WIDGET_TYPE_WEATHER) {
            menu.addView(
                createHomeWidgetOptionRow(
                    title = getString(R.string.settings_weather),
                    iconRes = R.drawable.ic_weather_24,
                    destructive = false
                ) {
                    homeWidgetOptionsPopup?.dismiss()
                    showWeatherSettingsPage()
                }
            )
            menu.addView(createHomeWidgetOptionDivider())
        }
        menu.addView(
            createHomeWidgetOptionRow(
                title = getString(R.string.launcher_edit_options),
                iconRes = R.drawable.ic_add_widget_green_24dp,
                destructive = false
            ) {
                homeWidgetOptionsPopup?.dismiss()
                handleWobbling(true)
            }
        )
        menu.addView(createHomeWidgetOptionDivider())
        menu.addView(
            createHomeWidgetOptionRow(
                title = getString(R.string.app_option_edit_home),
                iconRes = R.drawable.ic_phone_home_20,
                destructive = false
            ) {
                homeWidgetOptionsPopup?.dismiss()
                handleWobbling(true)
            }
        )
        menu.addView(createHomeWidgetOptionDivider())
        menu.addView(
            createHomeWidgetOptionRow(
                title = getString(R.string.app_option_delete),
                iconRes = R.drawable.ic_delete_20,
                destructive = true
            ) {
                homeWidgetOptionsPopup?.dismiss()
                removeHomeWidgetFromHost(anchor, item.id)
            }
        )

        val popup = PopupWindow(menu, popupWidth, ViewGroup.LayoutParams.WRAP_CONTENT, true).apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            isOutsideTouchable = true
            elevation = dp(14).toFloat()
            setOnDismissListener {
                hideHomeWidgetOptionsOverlay()
                if (homeWidgetOptionsPopup === this) {
                    homeWidgetOptionsPopup = null
                }
            }
        }
        homeWidgetOptionsPopup = popup

        menu.measure(
            View.MeasureSpec.makeMeasureSpec(resources.displayMetrics.widthPixels, View.MeasureSpec.AT_MOST),
            View.MeasureSpec.makeMeasureSpec(resources.displayMetrics.heightPixels, View.MeasureSpec.AT_MOST)
        )
        showHomeWidgetOptionsOverlay()
        popup.showAtLocation(
            mLauncherView,
            Gravity.NO_GRAVITY,
            popupX(anchor, popupWidth),
            popupY(anchor, menu.measuredHeight)
        )
    }

    private fun createHomeWidgetOptionRow(
        title: String,
        iconRes: Int,
        destructive: Boolean,
        onClick: () -> Unit
    ): View {
        val textColor = if (destructive) 0xFFFF2D30.toInt() else Color.WHITE
        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(14), 0, dp(14), 0)
            isClickable = true
            isFocusable = true
            background = selectableItemBackground()
            setOnClickListener { onClick() }
            addView(
                ImageView(context).apply {
                    setImageResource(iconRes)
                    setColorFilter(textColor)
                    contentDescription = null
                },
                LinearLayout.LayoutParams(dp(22), dp(22))
            )
            addView(
                TextView(context).apply {
                    text = title
                    setTextColor(textColor)
                    textSize = 17f
                    includeFontPadding = false
                    gravity = Gravity.CENTER_VERTICAL or Gravity.END
                    typeface = Typeface.DEFAULT_BOLD
                },
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f).apply {
                    marginStart = dp(14)
                }
            )
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dp(48)
            )
        }
    }

    private fun createHomeWidgetOptionDivider(): View {
        return View(this).apply {
            setBackgroundColor(0x38FFFFFF)
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                1
            ).apply {
                leftMargin = dp(48)
            }
        }
    }

    private fun showHomeWidgetOptionsOverlay() {
        if (!::contextOverlay.isInitialized) {
            return
        }
        hideSelectedIconPreview()
        contextOverlay.animate().cancel()
        contextOverlay.alpha = 0f
        contextOverlay.visibility = VISIBLE
        contextOverlay.bringToFront()
        contextOverlay.animate().alpha(1f).setDuration(120L).start()
    }

    private fun hideHomeWidgetOptionsOverlay() {
        if (!::contextOverlay.isInitialized || contextOverlay.visibility != VISIBLE) {
            return
        }
        if (launcherOptionsPopup != null) {
            return
        }
        contextOverlay.animate().cancel()
        contextOverlay.animate()
            .alpha(0f)
            .setDuration(120L)
            .withEndAction {
                if (homeWidgetOptionsPopup == null && launcherOptionsPopup == null) {
                    contextOverlay.visibility = GONE
                    contextOverlay.alpha = 1f
                }
            }
            .start()
    }

    private fun forceHideContextOverlayImmediately() {
        if (!::contextOverlay.isInitialized) {
            return
        }
        contextOverlay.animate().cancel()
        contextOverlay.visibility = GONE
        contextOverlay.alpha = 1f
    }

    private fun dismissHomeWidgetOptionsPopup() {
        val popup = homeWidgetOptionsPopup
        if (popup != null) {
            homeWidgetOptionsPopup = null
            popup.dismiss()
        } else {
            hideHomeWidgetOptionsOverlay()
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun createHomeWidgetRemoveButton(host: FrameLayout): ImageView {
        val canRemoveWidget = {
            HomeWidgetEditStatePolicy.shouldShowRemoveButton(
                editing = isWobbling,
                draggingWidget = homeWidgetDragSpec != null
            )
        }
        var removalRequested = false
        fun removeCurrentWidget() {
            if (removalRequested) {
                return
            }
            if (canRemoveWidget()) {
                removalRequested = true
                host.isEnabled = false
                host.isClickable = false
                removeHomeWidgetFromHost(host)
            } else {
                clearAllHomeWidgetEditChrome()
            }
        }
        return ImageView(this).apply {
            tag = HOME_WIDGET_REMOVE_TAG
            setImageResource(R.drawable.remove_icon_72)
            visibility = VISIBLE
            elevation = dp(96).toFloat()
            translationZ = dp(96).toFloat()
            isClickable = true
            isFocusable = true
            scaleType = ImageView.ScaleType.CENTER_INSIDE
            setOnClickListener { removeCurrentWidget() }
            setOnLongClickListener { true }
            setOnTouchListener { view, event ->
                if (!canRemoveWidget()) {
                    view.isPressed = false
                    requestDisallowHomeWidgetTouchIntercept(view, false)
                    clearAllHomeWidgetEditChrome()
                    return@setOnTouchListener true
                }
                when (event.actionMasked) {
                    MotionEvent.ACTION_DOWN -> {
                        requestDisallowHomeWidgetTouchIntercept(view, true)
                        view.isPressed = false
                        removeCurrentWidget()
                        true
                    }
                    MotionEvent.ACTION_UP -> {
                        view.isPressed = false
                        requestDisallowHomeWidgetTouchIntercept(view, false)
                        true
                    }
                    MotionEvent.ACTION_CANCEL -> {
                        view.isPressed = false
                        requestDisallowHomeWidgetTouchIntercept(view, false)
                        true
                    }
                    else -> true
                }
            }
            layoutParams = FrameLayout.LayoutParams(dp(34), dp(34), Gravity.START or Gravity.TOP).apply {
                leftMargin = 0
                topMargin = 0
            }
        }
    }

    private fun cancelHomeWidgetDragStateForRemoval() {
        homeWidgetDragSessionId = HomeWidgetDragSessionPolicy.nextSessionId(homeWidgetDragSessionId)
        updateDragEdgeGlows(false)
        homeWidgetTouchDragActive = false
        homeWidgetTouchDragStartedFromPicker = false
        homeWidgetDragDropped = false
        pendingHomeWidgetDropItem = null
        homeWidgetRemoveTouchHost = null
        homeWidgetDragHost?.alpha = 1f
        homeWidgetDragHost?.visibility = VISIBLE
        homeWidgetDragHost = null
        homeWidgetDragSpec = null
        restoreHomeWidgetDragAppCells(animate = false)
        restoreHomeWidgetDragWidgetCells(animate = false)
        clearHomeWidgetDragPreviewState()
        removeHomeWidgetDragPreview()
        forceHideContextOverlayImmediately()
    }

    private fun removeHomeWidgetFromHost(host: View, fallbackWidgetId: String? = null) {
        val fallbackItem = homeWidgetVisualFallbackItem(host) ?: return
        val currentWidgetId = HomeWidgetRemovePolicy.resolveWidgetId(
            hostItem = host.tag as? HomeWidgetPreferences.Item,
            capturedWidgetId = fallbackWidgetId,
            fallbackItem = fallbackItem
        )
        removeHomeWidget(currentWidgetId, host, fallbackItem)
    }

    private fun removeHomeWidget(
        widgetId: String,
        host: View? = null,
        visualFallbackItem: HomeWidgetPreferences.Item? = null
    ) {
        cancelHomeWidgetDragStateForRemoval()
        clearAllHomeWidgetEditChrome()
        val fallbackItem = visualFallbackItem ?: host?.tag as? HomeWidgetPreferences.Item
        val removedWidgetIds = linkedSetOf(widgetId)
        fallbackItem?.id?.let { removedWidgetIds.add(it) }
        val appWidgetIdsByHomeWidgetId = homeWidgetItems
            .mapNotNull { item -> item.appWidgetId?.let { appWidgetId -> item.id to appWidgetId } }
            .toMap()
        val beforeWidgetIds = homeWidgetItems.map { it.id }.toSet()
        val hostToRemove = host ?: pages.firstNotNullOfOrNull { page ->
            (0 until page.childCount)
                .map { page.getChildAt(it) }
                .firstOrNull { (it.tag as? HomeWidgetPreferences.Item)?.id == widgetId }
        }
        forceDetachHomeWidgetHost(hostToRemove)
        val result = HomeWidgetRemovePolicy.remove(
            items = homeWidgetItems,
            widgetId = widgetId,
            fallbackItem = fallbackItem
        )
        homeWidgetItems.clear()
        homeWidgetItems.addAll(result.items)
        val validWidgetIds = homeWidgetItems.map { it.id }.toSet()
        removedWidgetIds.addAll(beforeWidgetIds - validWidgetIds)
        removedWidgetIds.mapNotNull { id -> appWidgetIdsByHomeWidgetId[id] }
            .forEach { appWidgetId -> mAppWidgetHost.deleteAppWidgetId(appWidgetId) }
        removeHomeWidgetViewsByIds(removedWidgetIds)
        removeStaleHomeWidgetViews(validWidgetIds, removedWidgetIds)
        if (!result.removed) {
            renderHomeWidgets()
            applyHomeWidgetEditState()
            invalidateHomeWidgetSurfaces()
            refreshPageIndicator()
            return
        }
        saveHomeWidgets()
        renderHomeWidgets()
        removeHomeWidgetViewsByIds(removedWidgetIds)
        removeStaleHomeWidgetViews(validWidgetIds, removedWidgetIds)
        invalidateHomeWidgetSurfaces()
        refreshPageIndicator()
    }

    private fun homeWidgetVisualFallbackItem(host: View): HomeWidgetPreferences.Item? {
        val tagItem = host.tag as? HomeWidgetPreferences.Item ?: return null
        val page = host.parent as? GridLayout
        val actualPage = page?.let { pages.indexOf(it) }?.takeIf { it >= 0 } ?: tagItem.page
        val actualCell = page?.let { homeWidgetCellForHostLayout(host, it) } ?: tagItem.cell
        return HomeWidgetHostFallbackPolicy.visualFallback(
            tagItem = tagItem,
            actualPage = actualPage,
            actualCell = actualCell
        )
    }

    private fun homeWidgetCellForHostLayout(host: View, page: GridLayout): Int {
        val params = host.layoutParams as? GridLayout.LayoutParams ?: return (host.tag as? HomeWidgetPreferences.Item)?.cell ?: 0
        val columns = page.columnCount.coerceAtLeast(1)
        val cellWidth = mDeviceProfile.cellWidthPx.coerceAtLeast(1)
        val cellHeight = homeCellHeightForPage(page).coerceAtLeast(1)
        val column = (params.leftMargin / cellWidth).coerceIn(0, columns - 1)
        val row = (params.topMargin / cellHeight).coerceAtLeast(0)
        return row * columns + column
    }

    private fun forceDetachHomeWidgetHost(host: View?) {
        host ?: return
        host.animate().cancel()
        host.clearAnimation()
        host.setLayerType(View.LAYER_TYPE_NONE, null)
        host.visibility = GONE
        host.alpha = 0f
        (host as? ViewGroup)?.let { removeHomeWidgetRemoveButtons(it) }
        val parent = host.parent as? ViewGroup
        parent?.removeView(host)
        parent?.requestLayout()
        parent?.invalidate()
        parent?.postInvalidateOnAnimation()
        invalidateHomeWidgetSurfaces()
    }

    private fun removeHomeWidgetViewsByIds(widgetIds: Set<String>) {
        if (widgetIds.isEmpty()) {
            return
        }
        pages.forEach { page ->
            var index = page.childCount - 1
            var changed = false
            while (index >= 0) {
                val child = page.getChildAt(index)
                val item = child.tag as? HomeWidgetPreferences.Item
                if (item != null && item.id in widgetIds) {
                    forceDetachHomeWidgetHost(child)
                    changed = true
                }
                index--
            }
            if (changed) {
                page.requestLayout()
                page.invalidate()
            }
        }
    }

    private fun removeStaleHomeWidgetViews(
        validWidgetIds: Set<String>,
        recentlyRemovedIds: Set<String>
    ) {
        pages.forEach { page ->
            var index = page.childCount - 1
            var changed = false
            while (index >= 0) {
                val child = page.getChildAt(index)
                val item = child.tag as? HomeWidgetPreferences.Item
                if (
                    HomeWidgetVisualCleanupPolicy.shouldRemoveHost(
                        hostId = item?.id,
                        validIds = validWidgetIds,
                        recentlyRemovedIds = recentlyRemovedIds
                    )
                ) {
                    forceDetachHomeWidgetHost(child)
                    changed = true
                }
                index--
            }
            if (changed) {
                page.requestLayout()
                page.invalidate()
                page.postInvalidateOnAnimation()
            }
        }
        removeHomeWidgetDragPreview()
    }

    private fun invalidateHomeWidgetSurfaces() {
        pages.forEach { page ->
            page.invalidate()
            page.postInvalidateOnAnimation()
        }
        if (::mHorizontalPager.isInitialized) {
            mHorizontalPager.invalidate()
            mHorizontalPager.postInvalidateOnAnimation()
        }
        (mLauncherView as? View)?.let { root ->
            root.invalidate()
            root.postInvalidateOnAnimation()
        }
    }

    private fun applyHomeWidgetLayoutParams(
        page: GridLayout,
        view: View,
        item: HomeWidgetPreferences.Item
    ) {
        val span = HomeWidgetPlacementPolicy.spanFor(item.size, page.columnCount)
        val cellHeightPx = homeCellHeightForPage(page)
        val manualLayout = LauncherHomeCellPolicy.manualLayoutForCell(
            cell = item.cell,
            columns = page.columnCount,
            cellWidth = mDeviceProfile.cellWidthPx,
            cellHeight = cellHeightPx
        )
        view.layoutParams = GridLayout.LayoutParams(
            GridLayout.spec(manualLayout.specRow),
            GridLayout.spec(manualLayout.specColumn)
        ).apply {
            width = mDeviceProfile.cellWidthPx * span.columns
            height = cellHeightPx * span.rows
            leftMargin = manualLayout.left
            topMargin = manualLayout.top
            setGravity(Gravity.START or Gravity.TOP)
        }
        view.setPadding(
            homeWidgetHorizontalInset(span),
            homeWidgetTopInset(),
            homeWidgetHorizontalInset(span),
            homeWidgetBottomInset()
        )
    }

    private fun createHomeWidgetBody(
        type: String,
        startDragListener: View.OnLongClickListener?,
        itemId: String? = null
    ): LinearLayout {
        return LinearLayout(this).apply {
            clipChildren = false
            clipToPadding = false
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            isLongClickable = startDragListener != null
            startDragListener?.let { setOnLongClickListener(it) }
            val tile = FrameLayout(context).apply {
                clipChildren = false
                clipToPadding = false
                isLongClickable = startDragListener != null
                startDragListener?.let { setOnLongClickListener(it) }
                addView(
                    createHomeWidgetContent(type, itemId).apply {
                        isLongClickable = startDragListener != null
                        startDragListener?.let { setOnLongClickListener(it) }
                    },
                    FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT
                    )
                )
            }
            addView(
                tile,
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    0,
                    1f
                )
            )
            addView(
                TextView(context).apply {
                    text = homeWidgetLabel(type)
                    setTextColor(Color.WHITE)
                    textSize = resources.getDimension(R.dimen.labelSize) / resources.displayMetrics.scaledDensity
                    typeface = Typeface.create("sans-serif-medium", Typeface.NORMAL)
                    includeFontPadding = false
                    gravity = Gravity.CENTER
                    maxLines = 1
                    ellipsize = TextUtils.TruncateAt.END
                    setShadowLayer(2f, 0f, 1f, 0x99000000.toInt())
                },
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    dp(22)
                ).apply {
                    topMargin = dp(5)
                }
            )
        }
    }

    private fun createHomeWidgetContent(type: String, itemId: String?): View {
        return if (type == HOME_WIDGET_TYPE_PICTURE && itemId != null) {
            createHomePictureWidget(itemId)
        } else {
            createTodayQuickWidgetView(homeQuickWidgetTypeForHomeType(type))
        }
    }

    private fun createHomeSystemWidgetBody(
        item: HomeWidgetPreferences.Item,
        startDragListener: View.OnLongClickListener?
    ): FrameLayout {
        return FrameLayout(this).apply {
            clipChildren = false
            clipToPadding = false
            isLongClickable = startDragListener != null
            startDragListener?.let { setOnLongClickListener(it) }
            val widgetContent = createHomeSystemWidgetContent(item).apply {
                isLongClickable = startDragListener != null
                startDragListener?.let { setOnLongClickListener(it) }
            }
            addView(
                widgetContent,
                FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
            )
        }
    }

    private fun createHomeSystemWidgetPreviewBody(preview: Drawable): FrameLayout {
        return FrameLayout(this).apply {
            background = roundedRectangle(0xFFE2E2E6.toInt(), 20)
            clipChildren = false
            clipToPadding = false
            addView(
                ImageView(context).apply {
                    setImageDrawable(freshDrawable(preview))
                    scaleType = ImageView.ScaleType.FIT_CENTER
                    adjustViewBounds = true
                },
                FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
            )
        }
    }

    private fun createHomeSystemWidgetContent(item: HomeWidgetPreferences.Item): View {
        val appWidgetId = item.appWidgetId
        if (appWidgetId != null) {
            val appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(appWidgetId)
            if (appWidgetInfo != null) {
                val hostView = mAppWidgetHost.createView(applicationContext, appWidgetId, appWidgetInfo) as RoundedWidgetView
                hostView.setAppWidget(appWidgetId, appWidgetInfo)
                hostView.setPadding(0, 0, 0, 0)
                hostView.layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
                hostView.post {
                    updateHomeSystemWidgetOptions(hostView, appWidgetInfo)
                }
                return hostView
            }
        }
        return createHomeSystemWidgetFallback(appWidgetId)
    }

    private fun updateHomeSystemWidgetOptions(
        widgetView: RoundedWidgetView,
        appWidgetInfo: AppWidgetProviderInfo
    ) {
        val density = resources.displayMetrics.density.coerceAtLeast(1f)
        val widthDp = widgetView.width
            .takeIf { it > 0 }
            ?.let { widthPx -> (widthPx / density).toInt() }
            ?: appWidgetInfo.minWidth
        val heightDp = widgetView.height
            .takeIf { it > 0 }
            ?.let { heightPx -> (heightPx / density).toInt() }
            ?: appWidgetInfo.minHeight
        val options = Bundle().apply {
            putInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH, widthDp.coerceAtLeast(1))
            putInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH, widthDp.coerceAtLeast(1))
            putInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT, heightDp.coerceAtLeast(1))
            putInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT, heightDp.coerceAtLeast(1))
            putBoolean(WidgetViewBuilder.WIDGET_OPTION_DARK_TEXT, isWorkspaceDarkText(this@LauncherActivity))
        }
        widgetView.updateAppWidgetOptions(options)
    }

    private fun createHomeSystemWidgetFallback(appWidgetId: Int?): View {
        val appWidgetInfo = appWidgetId?.let { id -> mAppWidgetManager.getAppWidgetInfo(id) }
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            background = roundedRectangle(0xE8FFFFFF.toInt(), 20)
            setPadding(dp(18), dp(18), dp(18), dp(18))
            addView(
                ImageView(context).apply {
                    setImageDrawable(runCatching {
                        appWidgetInfo?.loadIcon(context, resources.displayMetrics.densityDpi)
                    }.getOrNull())
                    scaleType = ImageView.ScaleType.FIT_CENTER
                },
                LinearLayout.LayoutParams(dp(56), dp(56))
            )
            addView(
                TextView(context).apply {
                    text = runCatching {
                        appWidgetInfo?.let { launcherSystemRepository.loadWidgetProviderLabel(it) }
                    }.getOrNull() ?: getString(R.string.home_widget_add_entry)
                    gravity = Gravity.CENTER
                    setTextColor(Color.BLACK)
                    textSize = 15f
                    typeface = Typeface.DEFAULT_BOLD
                    maxLines = 2
                    ellipsize = TextUtils.TruncateAt.END
                },
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    topMargin = dp(12)
                }
            )
        }
    }

    private fun homeWidgetLabel(type: String): String {
        return when (type) {
            HOME_WIDGET_TYPE_BATTERY -> getString(R.string.today_widget_battery)
            HOME_WIDGET_TYPE_PICTURE -> getString(R.string.today_widget_picture)
            HOME_WIDGET_TYPE_SYSTEM -> getString(R.string.home_widget_add_entry)
            else -> getString(R.string.today_widget_weather)
        }
    }

    private fun todayPhotoWidgetId(entryId: Int): String {
        return "$TODAY_PHOTO_WIDGET_ID_PREFIX$entryId"
    }

    private fun handleTodayPhotoWidgetClicked(entryId: Int) {
        handlePhotoWidgetClicked(
            widgetId = todayPhotoWidgetId(entryId),
            widgetSize = HomeWidgetPlacementPolicy.WidgetSize.SMALL
        )
    }

    private fun handlePhotoWidgetClicked(item: HomeWidgetPreferences.Item) {
        handlePhotoWidgetClicked(item.id, item.size)
    }

    private fun handlePhotoWidgetClicked(
        widgetId: String,
        widgetSize: HomeWidgetPlacementPolicy.WidgetSize
    ) {
        pendingPhotoWidgetId = widgetId
        pendingPhotoWidgetSize = widgetSize
        openHomeWidgetPhotoPicker()
    }

    private fun openHomeWidgetPhotoPicker() {
        val pickIntent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "image/*"
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        try {
            startActivityForResult(pickIntent, REQUEST_HOME_WIDGET_PHOTO_PICK)
        } catch (_: ActivityNotFoundException) {
            val fallbackIntent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            try {
                startActivityForResult(fallbackIntent, REQUEST_HOME_WIDGET_PHOTO_PICK)
            } catch (_: ActivityNotFoundException) {
                pendingPhotoWidgetId = null
                Toast.makeText(this, R.string.home_widget_photo_pick_failed, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showHomeWidgetPhotoCropPage(
        widgetId: String,
        widgetSize: HomeWidgetPlacementPolicy.WidgetSize,
        bitmap: Bitmap
    ) {
        hideHomeWidgetPhotoCropPage()
        val outputSize = HomeWidgetPhotoPolicy.outputSizeFor(widgetSize)
        val cropView = HomeWidgetPhotoCropView(this).apply {
            setBitmap(bitmap, outputSize)
        }
        val overlay = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            fitsSystemWindows = true
            setBackgroundColor(Color.WHITE)
            elevation = dp(60).toFloat()
            isClickable = true
            isFocusable = true
        }
        overlay.addView(createHomeWidgetPhotoCropToolbar(widgetId, cropView))
        overlay.addView(
            cropView,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        photoWidgetCropPanel = overlay
        (mLauncherView as? ViewGroup)?.addView(
            overlay,
            RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
    }

    private fun createHomeWidgetPhotoCropToolbar(
        widgetId: String,
        cropView: HomeWidgetPhotoCropView
    ): View {
        return FrameLayout(this).apply {
            setBackgroundColor(Color.WHITE)
            addView(
                LinearLayout(context).apply {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL

                    addView(
                        TextView(context).apply {
                            text = getString(R.string.home_widget_photo_crop_back)
                            setTextColor(0xFF007AFF.toInt())
                            textSize = 19f
                            gravity = Gravity.CENTER_VERTICAL or Gravity.START
                            includeFontPadding = false
                            maxLines = 2
                            setOnClickListener { hideHomeWidgetPhotoCropPage() }
                        },
                        LinearLayout.LayoutParams(
                            0,
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            1f
                        ).apply {
                            leftMargin = dp(12)
                        }
                    )

                    addView(
                        TextView(context).apply {
                            text = getString(R.string.home_widget_photo_crop_title)
                            setTextColor(Color.BLACK)
                            textSize = 21f
                            typeface = Typeface.DEFAULT_BOLD
                            gravity = Gravity.CENTER
                            includeFontPadding = false
                            maxLines = 1
                        },
                        LinearLayout.LayoutParams(
                            0,
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            1f
                        )
                    )

                    addView(
                        TextView(context).apply {
                            text = getString(R.string.dialog_ok)
                            setTextColor(0xFF007AFF.toInt())
                            textSize = 20f
                            typeface = Typeface.DEFAULT_BOLD
                            gravity = Gravity.CENTER_VERTICAL or Gravity.END
                            includeFontPadding = false
                            setOnClickListener {
                                saveHomeWidgetPhotoCrop(widgetId, cropView)
                            }
                        },
                        LinearLayout.LayoutParams(
                            0,
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            1f
                        ).apply {
                            rightMargin = dp(16)
                        }
                    )
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dp(HomeWidgetPhotoCropLayoutPolicy.TOOLBAR_CONTENT_HEIGHT_DP),
                    Gravity.BOTTOM
                )
            )
        }.also { toolbar ->
            toolbar.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dp(HomeWidgetPhotoCropLayoutPolicy.TOOLBAR_HEIGHT_DP)
            )
        }
    }

    private fun saveHomeWidgetPhotoCrop(widgetId: String, cropView: HomeWidgetPhotoCropView) {
        val cropped = cropView.croppedBitmap()
        if (cropped == null) {
            Toast.makeText(this, R.string.home_widget_photo_crop_failed, Toast.LENGTH_SHORT).show()
            return
        }
        runCatching {
            HomeWidgetPhotoStore.saveBitmap(this, widgetId, cropped)
        }.onSuccess {
            hideHomeWidgetPhotoCropPage()
            pendingPhotoWidgetId = null
            if (widgetId.startsWith(TODAY_PHOTO_WIDGET_ID_PREFIX)) {
                renderTodayWidgets()
            } else {
                renderHomeWidgets()
            }
        }.onFailure {
            Toast.makeText(this, R.string.home_widget_photo_crop_failed, Toast.LENGTH_SHORT).show()
        }
    }

    private fun hideHomeWidgetPhotoCropPage() {
        val panel = photoWidgetCropPanel ?: return
        photoWidgetCropPanel = null
        pendingPhotoWidgetId = null
        (panel.parent as? ViewGroup)?.removeView(panel)
    }

    private fun handleHomeWidgetPhotoResult(data: Intent?) {
        val widgetId = pendingPhotoWidgetId ?: return
        val uri = data?.data
        if (uri == null) {
            pendingPhotoWidgetId = null
            return
        }
        val bitmap = decodeHomeWidgetPhotoBitmap(uri)
        if (bitmap == null) {
            pendingPhotoWidgetId = null
            Toast.makeText(this, R.string.home_widget_photo_pick_failed, Toast.LENGTH_SHORT).show()
            return
        }
        showHomeWidgetPhotoCropPage(widgetId, pendingPhotoWidgetSize, bitmap)
    }

    private fun decodeHomeWidgetPhotoBitmap(uri: Uri): Bitmap? {
        return runCatching {
            val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
            contentResolver.openInputStream(uri)?.use { input ->
                BitmapFactory.decodeStream(input, null, bounds)
            }
            if (bounds.outWidth <= 0 || bounds.outHeight <= 0) {
                return@runCatching null
            }
            val options = BitmapFactory.Options().apply {
                inSampleSize = sampleSizeFor(bounds.outWidth, bounds.outHeight, 2400)
            }
            contentResolver.openInputStream(uri)?.use { input ->
                BitmapFactory.decodeStream(input, null, options)
            }
        }.getOrNull()
    }

    private fun sampleSizeFor(width: Int, height: Int, maxSide: Int): Int {
        var sampleSize = 1
        var halfWidth = width / 2
        var halfHeight = height / 2
        while (halfWidth / sampleSize >= maxSide || halfHeight / sampleSize >= maxSide) {
            sampleSize *= 2
        }
        return sampleSize.coerceAtLeast(1)
    }

    private fun requestWeatherLocationPermission() {
        if (hasWeatherLocationPermission()) {
            openWeatherDetailAfterRefresh = true
            refreshWeatherForecast(force = true)
        } else {
            openWeatherDetailAfterRefresh = true
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                WEATHER_LOCATION_PERMISSION_REQUEST
            )
        }
    }

    private fun handleWeatherWidgetClicked() {
        if (!hasWeatherLocationPermission()) {
            requestWeatherLocationPermission()
            return
        }
        latestWeatherForecast?.let { forecast ->
            showWeatherDetailPage(forecast)
            return
        }
        openWeatherDetailAfterRefresh = true
        refreshWeatherForecast(force = true)
    }

    private fun updateWidgetWeatherPermissionState(fetchIfNeeded: Boolean = true) {
        when {
            !hasWeatherLocationPermission() -> {
                latestWeatherForecast = null
                setWeatherWidgetState(WeatherWidgetUiState.PermissionRequired)
            }
            !hasUsableNetwork() -> {
                setWeatherWidgetState(WeatherWidgetUiState.NoNetwork)
            }
            latestWeatherForecast != null -> {
                if (fetchIfNeeded && isWeatherForecastStale()) {
                    refreshWeatherForecast(force = true)
                } else {
                    setWeatherWidgetState(WeatherWidgetUiState.Forecast(requireNotNull(latestWeatherForecast)))
                }
            }
            fetchIfNeeded -> refreshWeatherForecast(force = false)
            else -> setWeatherWidgetState(WeatherWidgetUiState.Loading)
        }
    }

    private fun refreshWeatherForecast(
        force: Boolean,
        showLoading: Boolean = true,
        restartInFlight: Boolean = false
    ) {
        if (restartInFlight) {
            weatherRequestGeneration += 1
            weatherLoadInFlight = false
        }
        val requestGeneration = weatherRequestGeneration
        if (!hasWeatherLocationPermission()) {
            setWeatherWidgetState(WeatherWidgetUiState.PermissionRequired)
            return
        }
        if (!hasUsableNetwork()) {
            openWeatherDetailAfterRefresh = false
            setWeatherWidgetState(WeatherWidgetUiState.NoNetwork)
            return
        }
        if (weatherLoadInFlight) {
            return
        }
        if (!force && latestWeatherForecast != null) {
            setWeatherWidgetState(WeatherWidgetUiState.Forecast(requireNotNull(latestWeatherForecast)))
            return
        }

        weatherLoadInFlight = true
        if (showLoading || latestWeatherForecast == null) {
            setWeatherWidgetState(WeatherWidgetUiState.Loading)
        }
        WeatherLocationProvider.currentCoordinates(this) { coordinates ->
            if (requestGeneration != weatherRequestGeneration) {
                return@currentCoordinates
            }
            if (coordinates == null) {
                weatherLoadInFlight = false
                openWeatherDetailAfterRefresh = false
                setWeatherWidgetState(WeatherWidgetUiState.PermissionRequired)
                Toast.makeText(this, R.string.weather_location_unavailable, Toast.LENGTH_SHORT).show()
            } else {
                fetchWeatherForecast(coordinates, requestGeneration)
            }
        }
    }

    private fun fetchWeatherForecast(
        coordinates: WeatherCoordinates,
        requestGeneration: Int
    ) {
        val appContext = applicationContext
        val requestedUnit = selectedWeatherTemperatureUnit()
        weatherExecutor.execute {
            try {
                val locationName = WeatherLocationProvider.locationName(appContext, coordinates)
                val forecast = OpenMeteoWeatherApi.fetchForecast(
                    coordinates = coordinates,
                    locationName = locationName,
                    temperatureUnit = requestedUnit
                )
                weatherRefreshHandler.post {
                    if (requestGeneration != weatherRequestGeneration) {
                        return@post
                    }
                    val displayForecast = WeatherSettingsPolicy.convertForecastTemperatureUnit(
                        forecast,
                        selectedWeatherTemperatureUnit()
                    )
                    weatherLoadInFlight = false
                    latestWeatherForecast = displayForecast
                    latestWeatherRefreshUptime = SystemClock.elapsedRealtime()
                    setWeatherWidgetState(WeatherWidgetUiState.Forecast(displayForecast))
                    scheduleNextWeatherRefresh()
                    if (weatherDetailPanel != null || openWeatherDetailAfterRefresh) {
                        openWeatherDetailAfterRefresh = false
                        showWeatherDetailPage(displayForecast)
                    }
                }
            } catch (_: IOException) {
                weatherRefreshHandler.post {
                    if (requestGeneration != weatherRequestGeneration) {
                        return@post
                    }
                    weatherLoadInFlight = false
                    openWeatherDetailAfterRefresh = false
                    setWeatherWidgetState(WeatherWidgetUiState.NoNetwork)
                }
            } catch (_: Exception) {
                weatherRefreshHandler.post {
                    if (requestGeneration != weatherRequestGeneration) {
                        return@post
                    }
                    weatherLoadInFlight = false
                    openWeatherDetailAfterRefresh = false
                    setWeatherWidgetState(WeatherWidgetUiState.NoNetwork)
                    Toast.makeText(this, R.string.weather_refresh_failed, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setWeatherWidgetState(state: WeatherWidgetUiState) {
        if (weatherWidgetState == state) {
            return
        }
        weatherWidgetState = state
        refreshWeatherWidgetSurfaces()
    }

    private fun refreshWeatherWidgetSurfaces() {
        if (::mHorizontalPager.isInitialized && pages.isNotEmpty()) {
            renderHomeWidgets()
        }
        if (::widgetContainer.isInitialized) {
            renderTodayWidgets()
        }
    }

    private fun isWeatherForecastStale(): Boolean {
        return latestWeatherRefreshUptime == 0L ||
            SystemClock.elapsedRealtime() - latestWeatherRefreshUptime >= weatherAutoRefreshIntervalMs()
    }

    private fun scheduleNextWeatherRefresh() {
        weatherRefreshHandler.removeCallbacks(weatherRefreshRunnable)
        weatherRefreshHandler.postDelayed(weatherRefreshRunnable, weatherAutoRefreshIntervalMs())
    }

    private fun weatherAutoRefreshIntervalMs(): Long {
        return selectedWeatherRefreshInterval().millis
    }

    private fun hasWeatherLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun hasUsableNetwork(): Boolean {
        val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
            ?: return false
        val network = manager.activeNetwork ?: return false
        val capabilities = manager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
            capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }

    private fun showWeatherSettingsPage() {
        hideWeatherSettingsPage()
        dismissHomeWidgetOptionsPopup()
        dismissLauncherOptionsPopup()
        forceHideContextOverlayImmediately()
        val backgroundColor = if (darkModeEnabled) Color.BLACK else 0xFFEDEDEF.toInt()
        val toolbarColor = if (darkModeEnabled) 0xFF1C1C1E.toInt() else backgroundColor
        val titleColor = if (darkModeEnabled) Color.WHITE else Color.BLACK
        val dividerColor = if (darkModeEnabled) 0xFF38383A.toInt() else 0xFFC7C7CC.toInt()
        val rowColor = if (darkModeEnabled) 0xFF1C1C1E.toInt() else 0xFFEDEDEF.toInt()

        val panel = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            fitsSystemWindows = true
            setBackgroundColor(backgroundColor)
            elevation = dp(80).toFloat()
            translationZ = dp(80).toFloat()
            isClickable = true
            isFocusable = true
        }
        panel.addView(
            createWeatherSettingsToolbar(toolbarColor, titleColor),
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(96))
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
        (mLauncherView as? ViewGroup)?.addView(
            panel,
            RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        panel.bringToFront()
    }

    private fun hideWeatherSettingsPage() {
        val panel = weatherSettingsPanel ?: return
        weatherSettingsPanel = null
        (panel.parent as? ViewGroup)?.removeView(panel)
    }

    private fun createWeatherSettingsToolbar(toolbarColor: Int, titleColor: Int): View {
        return FrameLayout(this).apply {
            setBackgroundColor(toolbarColor)
            addView(
                TextView(context).apply {
                    text = getString(R.string.layout_back_settings)
                    setTextColor(0xFF007AFF.toInt())
                    textSize = 20f
                    gravity = Gravity.CENTER_VERTICAL
                    includeFontPadding = false
                    setOnClickListener { hideWeatherSettingsPage() }
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
                    text = getString(R.string.settings_weather)
                    setTextColor(titleColor)
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
        }
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
            foreground = selectableItemBackground()
            setOnClickListener { onClick() }
            addView(
                FrameLayout(context).apply {
                    background = roundedRectangle(0xFFFFC400.toInt(), 7)
                    addView(
                        ImageView(context).apply {
                            setImageResource(R.drawable.ic_weather_24)
                            setColorFilter(Color.WHITE)
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
                            setTextColor(if (darkModeEnabled) Color.WHITE else 0xFF1C1C1E.toInt())
                            textSize = 18f
                            includeFontPadding = false
                        }
                    )
                    addView(
                        TextView(context).apply {
                            text = subtitle
                            setTextColor(if (darkModeEnabled) 0xFFAEAEB2.toInt() else 0xFF6D6D72.toInt())
                            textSize = 15f
                            includeFontPadding = false
                        }
                    )
                },
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
            )
        }.also { row ->
            installWeatherSettingsOptionClick(row, onClick)
            row.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(80))
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun installWeatherSettingsOptionClick(view: View, onClick: () -> Unit) {
        view.isClickable = true
        view.setOnClickListener { onClick() }
        view.setOnTouchListener { touchedView, event ->
            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN -> true
                MotionEvent.ACTION_UP -> {
                    touchedView.performClick()
                    true
                }
                MotionEvent.ACTION_CANCEL -> true
                else -> false
            }
        }
        if (view is ViewGroup) {
            for (index in 0 until view.childCount) {
                installWeatherSettingsOptionClick(view.getChildAt(index), onClick)
            }
        }
    }

    private fun selectedWeatherTemperatureUnit(): WeatherSettingsPolicy.TemperatureUnit {
        return WeatherSettingsPolicy.temperatureUnit(Preferences.useMetricUnits(this))
    }

    private fun selectedWeatherRefreshInterval(): WeatherSettingsPolicy.RefreshInterval {
        return WeatherSettingsPolicy.refreshInterval(Preferences.weatherRefreshIntervalValue(this))
    }

    private fun weatherTemperatureUnitLabel(unit: WeatherSettingsPolicy.TemperatureUnit): String {
        return when (unit) {
            WeatherSettingsPolicy.TemperatureUnit.CELSIUS ->
                getString(R.string.weather_settings_unit_celsius)
            WeatherSettingsPolicy.TemperatureUnit.FAHRENHEIT ->
                getString(R.string.weather_settings_unit_fahrenheit)
        }
    }

    private fun weatherRefreshIntervalLabel(interval: WeatherSettingsPolicy.RefreshInterval): String {
        return when (interval) {
            WeatherSettingsPolicy.RefreshInterval.HOURLY ->
                getString(R.string.weather_settings_auto_refresh_hourly)
            WeatherSettingsPolicy.RefreshInterval.EVERY_3_HOURS ->
                getString(R.string.weather_settings_auto_refresh_3_hours)
            WeatherSettingsPolicy.RefreshInterval.EVERY_6_HOURS ->
                getString(R.string.weather_settings_auto_refresh_6_hours)
            WeatherSettingsPolicy.RefreshInterval.EVERY_9_HOURS ->
                getString(R.string.weather_settings_auto_refresh_9_hours)
            WeatherSettingsPolicy.RefreshInterval.EVERY_12_HOURS ->
                getString(R.string.weather_settings_auto_refresh_12_hours)
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
                applyWeatherTemperatureUnitSelection(selectedUnit)
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
                applyWeatherRefreshIntervalSelection(selectedInterval)
            }
        )
    }

    private fun applyWeatherTemperatureUnitSelection(
        selectedUnit: WeatherSettingsPolicy.TemperatureUnit
    ) {
        val currentUnit = selectedWeatherTemperatureUnit()
        Preferences.setUseMetricUnits(this, selectedUnit.useMetric)
        latestWeatherRefreshUptime = 0L
        if (currentUnit != selectedUnit) {
            latestWeatherForecast = latestWeatherForecast?.let { forecast ->
                WeatherSettingsPolicy.convertForecastTemperatureUnit(forecast, selectedUnit)
            }
            latestWeatherForecast?.let { forecast ->
                setWeatherWidgetState(WeatherWidgetUiState.Forecast(forecast))
            }
            refreshWeatherForecast(
                force = true,
                showLoading = latestWeatherForecast == null,
                restartInFlight = true
            )
        }
        showWeatherSettingsPage()
    }

    private fun applyWeatherRefreshIntervalSelection(
        selectedInterval: WeatherSettingsPolicy.RefreshInterval
    ) {
        val currentInterval = selectedWeatherRefreshInterval()
        Preferences.setWeatherRefreshIntervalValue(this, selectedInterval.preferenceValue)
        scheduleNextWeatherRefresh()
        if (currentInterval != selectedInterval) {
            refreshWeatherForecast(
                force = true,
                showLoading = latestWeatherForecast == null,
                restartInFlight = true
            )
        }
        showWeatherSettingsPage()
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
            background = roundedRectangle(Color.WHITE, 22)
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
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
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
                background = selectableItemBackground()
                setOnClickListener { dialog.dismiss() }
            },
            LinearLayout.LayoutParams(dp(88), dp(52)).apply {
                gravity = Gravity.END
                topMargin = dp(16)
            }
        )

        dialog.setContentView(card)
        dialog.setOnShowListener {
            dialog.window?.let { window ->
                window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                window.setDimAmount(0.62f)
                window.setLayout(
                    (resources.displayMetrics.widthPixels * 0.86f).toInt(),
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        }
        dialog.show()
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
            background = selectableItemBackground()
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
            row.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dp(64)
            )
        }
    }

    private fun showWeatherDetailPage(forecast: WeatherForecast) {
        hideWeatherDetailPage()
        hideWeatherSettingsPage()
        val panel = FrameLayout(this).apply {
            fitsSystemWindows = true
            background = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(0xFF405A77.toInt(), 0xFF7F9AB5.toInt())
            )
            elevation = dp(60).toFloat()
            isClickable = true
            isFocusable = true
        }
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(dp(28), dp(116), dp(28), dp(42))
        }
        content.addView(createWeatherDetailHeader(forecast))
        content.addView(createWeatherHourlyCard(forecast))
        content.addView(createWeatherDailyCard(forecast))
        panel.addView(
            ScrollView(this).apply {
                overScrollMode = View.OVER_SCROLL_IF_CONTENT_SCROLLS
                addView(
                    content,
                    ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                )
            },
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        weatherDetailPanel = panel
        (mLauncherView as? ViewGroup)?.addView(
            panel,
            RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
    }

    private fun hideWeatherDetailPage() {
        val panel = weatherDetailPanel ?: return
        weatherDetailPanel = null
        (panel.parent as? ViewGroup)?.removeView(panel)
    }

    private fun createWeatherDetailHeader(forecast: WeatherForecast): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            addView(
                TextView(context).apply {
                    text = forecast.locationName
                    setTextColor(Color.WHITE)
                    textSize = 34f
                    includeFontPadding = false
                }
            )
            addView(
                TextView(context).apply {
                    text = getString(
                        R.string.launcher_widget_weather_temperature_format,
                        forecast.currentTemperatureC
                    )
                    setTextColor(Color.WHITE)
                    textSize = 86f
                    typeface = Typeface.DEFAULT_BOLD
                    includeFontPadding = false
                },
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    topMargin = dp(34)
                }
            )
            addView(
                TextView(context).apply {
                    text = forecast.condition
                    setTextColor(Color.WHITE)
                    textSize = 21f
                    typeface = Typeface.DEFAULT_BOLD
                    includeFontPadding = false
                }
            )
            addView(
                TextView(context).apply {
                    text = getString(
                        R.string.launcher_widget_weather_high_low_format,
                        forecast.highTemperatureC,
                        forecast.lowTemperatureC
                    )
                    setTextColor(Color.WHITE)
                    textSize = 20f
                    includeFontPadding = false
                },
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    topMargin = dp(6)
                    bottomMargin = dp(70)
                }
            )
        }
    }

    private fun createWeatherHourlyCard(forecast: WeatherForecast): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            background = roundedRectangle(0x99D9DEE6.toInt(), 20)
            setPadding(dp(18), dp(18), dp(18), dp(16))
            addView(
                TextView(context).apply {
                    text = getString(
                        R.string.weather_today_summary,
                        forecast.condition,
                        forecast.windDirectionDegrees,
                        forecast.windSpeedKmh,
                        forecast.highTemperatureC,
                        forecast.lowTemperatureC
                    )
                    setTextColor(Color.WHITE)
                    textSize = 18f
                    typeface = Typeface.DEFAULT_BOLD
                }
            )
            addView(
                View(context).apply { setBackgroundColor(0x55FFFFFF) },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1).apply {
                    topMargin = dp(18)
                    bottomMargin = dp(12)
                }
            )
            addView(
                HorizontalScrollView(context).apply {
                    isHorizontalScrollBarEnabled = false
                    addView(
                        LinearLayout(context).apply {
                            orientation = LinearLayout.HORIZONTAL
                            forecast.hourly.forEach { item ->
                                addView(
                                    createWeatherHourlyColumn(
                                        label = item.label,
                                        conditionCode = item.conditionCode,
                                        temperature = item.temperatureC
                                    )
                                )
                            }
                        }
                    )
                }
            )
        }.also { card ->
            card.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                bottomMargin = dp(26)
            }
        }
    }

    private fun createWeatherHourlyColumn(label: String, conditionCode: Int, temperature: Int): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            addView(
                TextView(context).apply {
                    text = label
                    setTextColor(Color.WHITE)
                    textSize = 16f
                    gravity = Gravity.CENTER
                }
            )
            addView(
                TextView(context).apply {
                    text = WeatherConditionMapper.glyphFor(conditionCode)
                    setTextColor(Color.WHITE)
                    textSize = 28f
                    gravity = Gravity.CENTER
                    includeFontPadding = false
                },
                LinearLayout.LayoutParams(dp(32), dp(32)).apply {
                    topMargin = dp(6)
                    bottomMargin = dp(4)
                }
            )
            addView(
                TextView(context).apply {
                    text = getString(R.string.launcher_widget_weather_temperature_format, temperature)
                    setTextColor(Color.WHITE)
                    textSize = 21f
                    gravity = Gravity.CENTER
                }
            )
        }.also { column ->
            column.layoutParams = LinearLayout.LayoutParams(dp(76), ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }

    private fun createWeatherDailyCard(forecast: WeatherForecast): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            background = roundedRectangle(0x99D9DEE6.toInt(), 20)
            setPadding(dp(22), dp(20), dp(22), dp(20))
            addView(
                LinearLayout(context).apply {
                    gravity = Gravity.CENTER_VERTICAL
                    addView(
                        ImageView(context).apply {
                            setImageResource(R.drawable.ic_grid_24)
                            setColorFilter(Color.WHITE)
                        },
                        LinearLayout.LayoutParams(dp(26), dp(26)).apply {
                            marginEnd = dp(16)
                        }
                    )
                    addView(
                        TextView(context).apply {
                            text = getString(R.string.weather_daily_forecast_title)
                            setTextColor(Color.WHITE)
                            textSize = 18f
                            typeface = Typeface.DEFAULT_BOLD
                            includeFontPadding = false
                        }
                    )
                }
            )
            forecast.daily.forEach { day ->
                addView(createWeatherDailyRow(day))
            }
        }.also { card ->
            card.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    private fun createWeatherDailyRow(day: DailyWeather): View {
        return LinearLayout(this).apply {
            gravity = Gravity.CENTER_VERTICAL
            setPadding(0, dp(14), 0, dp(10))
            addView(
                TextView(context).apply {
                    text = day.dayLabel
                    setTextColor(Color.WHITE)
                    textSize = 22f
                    typeface = Typeface.DEFAULT_BOLD
                },
                LinearLayout.LayoutParams(dp(54), ViewGroup.LayoutParams.WRAP_CONTENT)
            )
            addView(
                LinearLayout(context).apply {
                    orientation = LinearLayout.VERTICAL
                    gravity = Gravity.CENTER
                    addView(
                        TextView(context).apply {
                            text = WeatherConditionMapper.glyphFor(day.conditionCode)
                            setTextColor(Color.WHITE)
                            textSize = 30f
                            gravity = Gravity.CENTER
                            includeFontPadding = false
                        },
                        LinearLayout.LayoutParams(dp(34), dp(34))
                    )
                    addView(
                        TextView(context).apply {
                            text = "${day.precipitationProbability}%"
                            setTextColor(Color.WHITE)
                            textSize = 17f
                            gravity = Gravity.CENTER
                        }
                    )
                },
                LinearLayout.LayoutParams(dp(58), ViewGroup.LayoutParams.WRAP_CONTENT)
            )
            addView(
                TextView(context).apply {
                    text = getString(R.string.launcher_widget_weather_temperature_format, day.minTemperatureC)
                    setTextColor(Color.WHITE)
                    textSize = 22f
                    gravity = Gravity.END
                },
                LinearLayout.LayoutParams(dp(42), ViewGroup.LayoutParams.WRAP_CONTENT)
            )
            addView(
                createTemperatureRangeBar(day),
                LinearLayout.LayoutParams(0, dp(20), 1f).apply {
                    leftMargin = dp(8)
                    rightMargin = dp(8)
                }
            )
            addView(
                TextView(context).apply {
                    text = getString(R.string.launcher_widget_weather_temperature_format, day.maxTemperatureC)
                    setTextColor(Color.WHITE)
                    textSize = 22f
                },
                LinearLayout.LayoutParams(dp(44), ViewGroup.LayoutParams.WRAP_CONTENT)
            )
        }
    }

    private fun createTemperatureRangeBar(day: DailyWeather): View {
        val span = (day.maxTemperatureC - day.minTemperatureC).coerceAtLeast(1)
        val fillWidth = ((span.coerceAtMost(12) / 12f) * dp(96)).toInt().coerceAtLeast(dp(28))
        return FrameLayout(this).apply {
            addView(
                View(context).apply {
                    background = roundedRectangle(0x806D737B.toInt(), 3)
                },
                FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(5), Gravity.CENTER)
            )
            addView(
                View(context).apply {
                    background = GradientDrawable(
                        GradientDrawable.Orientation.LEFT_RIGHT,
                        intArrayOf(0xFFFFD426.toInt(), 0xFFFF8A00.toInt())
                    ).apply {
                        cornerRadius = dp(3).toFloat()
                    }
                },
                FrameLayout.LayoutParams(fillWidth, dp(5), Gravity.CENTER_VERTICAL or Gravity.START)
            )
        }
    }

    private fun homeWidgetHorizontalInset(span: HomeWidgetPlacementPolicy.Span): Int {
        return if (span.columns >= 4) dp(12) else dp(8)
    }

    private fun homeWidgetTopInset(): Int = dp(4)

    private fun homeWidgetBottomInset(): Int = dp(2)

    private fun homeWidgetOccupiedCellsForPage(pageIndex: Int, exceptId: String? = null): Set<Int> {
        if (pageIndex < 0) {
            return emptySet()
        }
        val columns = pages.getOrNull(pageIndex)?.columnCount ?: mDeviceProfile.numColumns
        val maxCells = pages.getOrNull(pageIndex)?.let { it.rowCount * it.columnCount }
            ?: mDeviceProfile.maxAppsPerPage
        val occupied = linkedSetOf<Int>()
        homeWidgetItems
            .filter { it.page == pageIndex && it.id != exceptId }
            .forEach { item ->
                val span = HomeWidgetPlacementPolicy.spanFor(item.size, columns)
                HomeWidgetPlacementPolicy.occupiedCellsFor(
                    anchorCell = item.cell,
                    span = span,
                    columns = columns,
                    maxCells = maxCells
                )?.let { occupied.addAll(it) }
        }
        return occupied
    }

    private fun homeWidgetOccupiedCellsForItems(
        page: GridLayout,
        items: List<HomeWidgetPreferences.Item>,
        displacedWidgetCells: Map<String, Int>
    ): Set<Int> {
        val occupied = linkedSetOf<Int>()
        val maxCells = page.rowCount * page.columnCount
        items.forEach { item ->
            val span = HomeWidgetPlacementPolicy.spanFor(item.size, page.columnCount)
            HomeWidgetPlacementPolicy.occupiedCellsFor(
                anchorCell = displacedWidgetCells[item.id] ?: item.cell,
                span = span,
                columns = page.columnCount,
                maxCells = maxCells
            )?.let { occupied.addAll(it) }
        }
        return occupied
    }

    private fun beginHomeWidgetTouchDrag(
        spec: HomeWidgetDragSpec,
        host: View?,
        rawX: Float,
        rawY: Float,
        startedFromPicker: Boolean
    ): Boolean {
        homeWidgetDragSessionId = spec.sessionId
        homeWidgetDragSpec = spec
        homeWidgetTouchDragActive = true
        homeWidgetTouchDragStartedFromPicker = startedFromPicker
        homeWidgetDragDropped = false
        pendingHomeWidgetDropItem = null
        homeWidgetDragHost = host
        homeWidgetDragOriginalAppCells = snapshotHomeWidgetDragAppCells()
        homeWidgetDragPageAppCells = snapshotHomeWidgetDragPageAppCells(homeWidgetDragOriginalAppCells)
        homeWidgetDragPreviewKey = null
        homeWidgetDragLastDropKey = null
        prepareHomeWidgetDragRuntimeCache()
        applyHomeWidgetEditState()
        setHomeWidgetDragIconJiggleReduced(true)
        removeHomeWidgetDragPreview()
        createHomeWidgetDragPreview(spec)
        scheduleHomeWidgetDragPreview(rawX, rawY)
        scheduleHomeWidgetDisplacementPreview(spec, rawX, rawY)
        updateDragEdgeGlows(true)
        host?.alpha = 0f
        hideHomeWidgetEntryCard()
        if (startedFromPicker) {
            hideHomeWidgetPickerDuringTouchDrag()
        }
        return true
    }

    private fun hideHomeWidgetPickerDuringTouchDrag() {
        homeWidgetPickerDialog?.window?.setDimAmount(0f)
        homeWidgetProviderDialog?.window?.setDimAmount(0f)
        homeWidgetPickerSheet?.animate()?.cancel()
        homeWidgetProviderSheet?.animate()?.cancel()
        homeWidgetPickerSheet?.alpha = 0f
        homeWidgetProviderSheet?.alpha = 0f
    }

    private fun restoreHomeWidgetPickerAfterTouchDragIfNeeded() {
        homeWidgetPickerSheet?.alpha = 1f
        homeWidgetProviderSheet?.alpha = 1f
    }

    private fun handleHomeWidgetTouchDragMotion(source: View, event: MotionEvent): Boolean {
        homeWidgetTouchLastRawX = event.rawX
        homeWidgetTouchLastRawY = event.rawY
        when (event.actionMasked) {
            MotionEvent.ACTION_MOVE -> {
                if (!HomeWidgetTouchDragPolicy.shouldHandleMove(homeWidgetTouchDragActive)) {
                    return false
                }
                requestDisallowHomeWidgetTouchIntercept(source, true)
                updateHomeWidgetTouchDrag(event.rawX, event.rawY)
                return true
            }
            MotionEvent.ACTION_UP -> {
                if (!HomeWidgetTouchDragPolicy.shouldHandleEnd(homeWidgetTouchDragActive)) {
                    return false
                }
                requestDisallowHomeWidgetTouchIntercept(source, false)
                finishHomeWidgetTouchDrag(event.rawX, event.rawY, cancelled = false)
                return true
            }
            MotionEvent.ACTION_CANCEL -> {
                if (!HomeWidgetTouchDragPolicy.shouldHandleEnd(homeWidgetTouchDragActive)) {
                    return false
                }
                requestDisallowHomeWidgetTouchIntercept(source, false)
                finishHomeWidgetTouchDrag(event.rawX, event.rawY, cancelled = true)
                return true
            }
        }
        return homeWidgetTouchDragActive
    }

    private fun requestDisallowHomeWidgetTouchIntercept(source: View, disallow: Boolean) {
        var parent = source.parent
        while (parent != null) {
            parent.requestDisallowInterceptTouchEvent(disallow)
            parent = (parent as? View)?.parent
        }
    }

    private fun updateHomeWidgetTouchDrag(rawX: Float, rawY: Float) {
        val spec = homeWidgetDragSpec ?: return
        scheduleHomeWidgetDragPreview(rawX, rawY)
        maybeScrollHomePagesForWidgetDrag(rawX)
        scheduleHomeWidgetDisplacementPreview(spec, rawX, rawY)
    }

    private fun scheduleHomeWidgetDragPreview(rawX: Float, rawY: Float) {
        homeWidgetDragPendingRawX = rawX
        homeWidgetDragPendingRawY = rawY
        if (homeWidgetDragPreviewFramePosted) {
            return
        }
        homeWidgetDragPreviewFramePosted = true
        (mLauncherView as? View)?.postOnAnimation {
            homeWidgetDragPreviewFramePosted = false
            if (homeWidgetDragSpec == null) {
                return@postOnAnimation
            }
            applyHomeWidgetDragPreviewPosition(
                homeWidgetDragPendingRawX,
                homeWidgetDragPendingRawY
            )
        }
    }

    private fun finishHomeWidgetTouchDrag(rawX: Float, rawY: Float, cancelled: Boolean) {
        val spec = homeWidgetDragSpec ?: return
        if (!homeWidgetTouchDragActive) {
            return
        }
        homeWidgetTouchDragActive = false
        updateDragEdgeGlows(false)
        setHomeWidgetDragIconJiggleReduced(false)
        applyHomeWidgetDragPreviewPosition(rawX, rawY)

        val draggedHost = homeWidgetDragHost
        val shouldRestoreEntryCard = spec.existingItemId == null && isWobbling
        val pendingItem = if (!cancelled) {
            homeWidgetDropItemFor(spec, rawX, rawY)
        } else {
            null
        }
        val placed = pendingItem?.let { placeHomeWidgetDropItem(it, spec) } == true
        if (!placed) {
            deleteUnplacedHomeSystemWidgetIfNeeded(spec)
            restoreHomeWidgetDragAppCells(animate = true)
            restoreHomeWidgetDragWidgetCells(animate = true)
            draggedHost?.alpha = 1f
            draggedHost?.visibility = VISIBLE
            restoreHomeWidgetPickerAfterTouchDragIfNeeded()
        }

        homeWidgetDragSpec = null
        homeWidgetDragDropped = false
        pendingHomeWidgetDropItem = null
        homeWidgetDragHost = null
        homeWidgetTouchDragStartedFromPicker = false
        clearHomeWidgetDragPreviewState()
        removeHomeWidgetDragPreview()
        dismissHomeWidgetPicker()
        dismissHomeWidgetProviderPreview()
        if (shouldRestoreEntryCard) {
            showHomeWidgetEntryCard()
        }
        applyHomeWidgetEditState()
    }

    private fun handleHomeWidgetDragEvent(source: View, event: DragEvent): Boolean {
        val spec = homeWidgetDragSpec ?: return false
        val rawPoint = homeWidgetDragRawPoint(source, event)
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                updateDragEdgeGlows(true)
                setHomeWidgetDragIconJiggleReduced(true)
                return true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                updateDragEdgeGlows(true)
                updateHomeWidgetDragPreview(rawPoint.first, rawPoint.second)
                maybeScrollHomePagesForWidgetDrag(rawPoint.first)
                scheduleHomeWidgetDisplacementPreview(spec, rawPoint.first, rawPoint.second)
                return true
            }
            DragEvent.ACTION_DROP -> {
                updateDragEdgeGlows(false)
                if (homeWidgetDragDropped) {
                    return true
                }
                applyHomeWidgetDragPreviewPosition(rawPoint.first, rawPoint.second)
                pendingHomeWidgetDropItem = homeWidgetDropItemFor(spec, rawPoint.first, rawPoint.second)
                homeWidgetDragDropped = pendingHomeWidgetDropItem != null
                return homeWidgetDragDropped
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                val pendingItem = pendingHomeWidgetDropItem
                val draggedHost = homeWidgetDragHost
                val shouldRestoreEntryCard = spec.existingItemId == null && isWobbling
                val endedSessionId = spec.sessionId
                updateDragEdgeGlows(false)
                setHomeWidgetDragIconJiggleReduced(false)
                homeWidgetDragSpec = null
                homeWidgetDragDropped = false
                pendingHomeWidgetDropItem = null
                homeWidgetDragHost = null
                Handler(Looper.getMainLooper()).post {
                    if (
                        !HomeWidgetDragSessionPolicy.shouldApplyDragEnd(
                            activeSessionId = homeWidgetDragSessionId,
                            endedSessionId = endedSessionId
                        )
                    ) {
                        draggedHost?.alpha = 1f
                        draggedHost?.visibility = VISIBLE
                        restoreHomeWidgetDragAppCells(animate = false)
                        restoreHomeWidgetDragWidgetCells(animate = false)
                        clearHomeWidgetDragPreviewState()
                        removeHomeWidgetDragPreview()
                        return@post
                    }
                    val placed = pendingItem?.let { placeHomeWidgetDropItem(it, spec) } == true
                    if (placed) {
                        launcherLayoutRepository.saveLayouts(pages, mDock)
                    } else {
                        deleteUnplacedHomeSystemWidgetIfNeeded(spec)
                        restoreHomeWidgetDragAppCells(animate = true)
                        restoreHomeWidgetDragWidgetCells(animate = true)
                        draggedHost?.alpha = 1f
                        draggedHost?.visibility = VISIBLE
                    }
                    clearHomeWidgetDragPreviewState()
                    removeHomeWidgetDragPreview()
                    dismissHomeWidgetPicker()
                    dismissHomeWidgetProviderPreview()
                    if (shouldRestoreEntryCard) {
                        showHomeWidgetEntryCard()
                    }
                    applyHomeWidgetEditState()
                }
                return true
            }
        }
        return true
    }

    private fun maybeScrollHomePagesForWidgetDrag(rawX: Float) {
        val now = SystemClock.uptimeMillis()
        if (now - homeWidgetDragLastScrollAtMs < 220L) {
            return
        }
        val localX = rawX - homeWidgetDragRootLeft
        val pageIndex = getCurrentAppsPageNumber()
        if (localX > resources.displayMetrics.widthPixels - 2 * scrollCorner) {
            if (pageIndex + 1 < pages.size) {
                mHorizontalPager.scrollRight(300)
                homeWidgetDragLastScrollAtMs = now
            }
        } else if (localX < 2 * scrollCorner && pageIndex > 0) {
            mHorizontalPager.scrollLeft(300)
            homeWidgetDragLastScrollAtMs = now
        }
    }

    private fun homeWidgetDropItemFor(
        spec: HomeWidgetDragSpec,
        rawX: Float,
        rawY: Float
    ): HomeWidgetPreferences.Item? {
        val resolved = resolveHomeWidgetPlacement(spec, rawX, rawY, showNoRoomToast = true)
            ?: return null
        commitHomeWidgetDisplacement(resolved)
        return resolved.item
    }

    private fun resolveHomeWidgetPlacement(
        spec: HomeWidgetDragSpec,
        rawX: Float,
        rawY: Float,
        showNoRoomToast: Boolean
    ): HomeWidgetResolvedPlacement? {
        val pageIndex = getCurrentAppsPageNumber()
        val page = pages.getOrNull(pageIndex)
        if (page == null || isAppLibraryPage(currentPageNumber)) {
            if (showNoRoomToast) {
                Toast.makeText(this, R.string.home_widget_no_room, Toast.LENGTH_SHORT).show()
            }
            return null
        }
        val dockBounds = Rect()
        if (::mDock.isInitialized && mDock.getGlobalVisibleRect(dockBounds) && rawY >= dockBounds.top) {
            if (showNoRoomToast) {
                Toast.makeText(this, R.string.home_widget_no_room, Toast.LENGTH_SHORT).show()
            }
            return null
        }

        val dropCell = dropCellForHomeGridRaw(page, rawX, rawY)
        return resolveHomeWidgetPlacementForCell(
            spec = spec,
            pageIndex = pageIndex,
            page = page,
            dropCell = dropCell,
            showNoRoomToast = showNoRoomToast
        )
    }

    private fun resolveHomeWidgetPlacementForCell(
        spec: HomeWidgetDragSpec,
        pageIndex: Int,
        page: GridLayout,
        dropCell: Int,
        showNoRoomToast: Boolean
    ): HomeWidgetResolvedPlacement? {
        val pageWidgets = homeWidgetItems.filter { it.page == pageIndex && it.id != spec.existingItemId }
        val placement = HomeWidgetPlacementPolicy.placementForCenteredDropCell(
            dropCell = dropCell,
            size = spec.size,
            columns = page.columnCount,
            maxCells = page.rowCount * page.columnCount,
            occupiedCells = emptySet()
        )
        if (placement == null) {
            if (showNoRoomToast) {
                Toast.makeText(this, R.string.home_widget_no_room, Toast.LENGTH_SHORT).show()
            }
            return null
        }

        val displacedWidgetCells = displacedHomeWidgetCellsForWidget(
            page = page,
            widgetItems = pageWidgets,
            draggedWidgetCells = placement.occupiedCells
        ) ?: run {
            if (showNoRoomToast) {
                Toast.makeText(this, R.string.home_widget_no_room, Toast.LENGTH_SHORT).show()
            }
            return null
        }

        val finalWidgetOccupiedCells = homeWidgetOccupiedCellsForItems(
            page = page,
            items = pageWidgets,
            displacedWidgetCells = displacedWidgetCells
        )
        if (!HomeWidgetDropValidationPolicy.canPlace(placement.occupiedCells, finalWidgetOccupiedCells)) {
            if (showNoRoomToast) {
                Toast.makeText(this, R.string.home_widget_no_room, Toast.LENGTH_SHORT).show()
            }
            return null
        }

        val widgetCellsBlockingApps = placement.occupiedCells + finalWidgetOccupiedCells

        val displacedCells = displacedHomeAppCellsForWidget(
            page = page,
            pageIndex = pageIndex,
            widgetCells = widgetCellsBlockingApps,
            widgetOccupiedCells = widgetCellsBlockingApps
        ) ?: run {
            if (showNoRoomToast) {
                Toast.makeText(this, R.string.home_widget_no_room, Toast.LENGTH_SHORT).show()
            }
            return null
        }

        return HomeWidgetResolvedPlacement(
            item = HomeWidgetPreferences.Item(
                id = spec.itemId,
                type = spec.type,
                size = spec.size,
                page = pageIndex,
                cell = placement.anchorCell,
                appWidgetId = spec.appWidgetId
            ),
            displacedCells = displacedCells,
            displacedWidgetCells = displacedWidgetCells
        )
    }

    private fun scheduleHomeWidgetDisplacementPreview(
        spec: HomeWidgetDragSpec,
        rawX: Float,
        rawY: Float
    ) {
        homeWidgetDragPendingPlacementRawX = rawX
        homeWidgetDragPendingPlacementRawY = rawY
        if (homeWidgetDragPlacementFramePosted) {
            return
        }
        homeWidgetDragPlacementFramePosted = true
        (mLauncherView as? View)?.postOnAnimation {
            homeWidgetDragPlacementFramePosted = false
            if (homeWidgetDragSpec !== spec) {
                return@postOnAnimation
            }
            previewHomeWidgetDisplacement(
                spec,
                homeWidgetDragPendingPlacementRawX,
                homeWidgetDragPendingPlacementRawY
            )
        }
    }

    private fun previewHomeWidgetDisplacement(
        spec: HomeWidgetDragSpec,
        rawX: Float,
        rawY: Float
    ) {
        val pageIndex = getCurrentAppsPageNumber()
        val page = pages.getOrNull(pageIndex)
        if (page == null || isAppLibraryPage(currentPageNumber) || isRawYInsideDock(rawY)) {
            if (HomeWidgetTouchDragPolicy.shouldRestoreDisplacementForInvalidPreview(outsideHome = true)) {
                restoreActiveHomeWidgetDisplacement()
            }
            return
        }

        val dropCell = dropCellForHomeGridRawCached(pageIndex, page, rawX, rawY)
        val dropKey = "$pageIndex:$dropCell"
        if (!HomeWidgetTouchDragPolicy.shouldPreviewPlacement(homeWidgetDragLastDropKey, dropKey)) {
            return
        }
        homeWidgetDragLastDropKey = dropKey

        val resolved = resolveHomeWidgetPlacementForCell(
            spec = spec,
            pageIndex = pageIndex,
            page = page,
            dropCell = dropCell,
            showNoRoomToast = false
        )
        if (resolved == null) {
            if (HomeWidgetTouchDragPolicy.shouldRestoreDisplacementForInvalidPreview(outsideHome = false)) {
                restoreActiveHomeWidgetDisplacement()
            }
            return
        }

        val key = homeWidgetPreviewKey(resolved)
        if (key == homeWidgetDragPreviewKey) {
            return
        }
        homeWidgetDragPreviewKey = key
        val now = SystemClock.uptimeMillis()
        val animate = HomeWidgetTouchDragPolicy.shouldAnimateDisplacement(
            nowMs = now,
            lastAnimationMs = homeWidgetDragLastPlacementPreviewAtMs,
            throttleMs = HOME_WIDGET_DISPLACEMENT_PREVIEW_THROTTLE_MS
        )
        homeWidgetDragLastPlacementPreviewAtMs = now
        applyHomeWidgetDisplacementPreview(resolved, animate = animate)
    }

    private fun isRawYInsideDock(rawY: Float): Boolean {
        return rawY >= homeWidgetDragDockTop
    }

    private fun restoreActiveHomeWidgetDisplacement() {
        if (homeWidgetDragActiveDisplacedCells.isNotEmpty()) {
            restoreHomeWidgetDragAppCells(animate = true)
        }
        if (homeWidgetDragActiveDisplacedWidgetCells.isNotEmpty()) {
            restoreHomeWidgetDragWidgetCells(animate = true)
        }
        homeWidgetDragPreviewKey = null
    }

    private fun displacedHomeAppCellsForWidget(
        page: GridLayout,
        pageIndex: Int,
        widgetCells: Set<Int>,
        widgetOccupiedCells: Set<Int>
    ): Map<BlissFrameLayout, Int>? {
        val maxCells = page.rowCount * page.columnCount
        val appCells = homeWidgetDragPageAppCells[pageIndex]
            ?: homePageApps(page).associateWith { app ->
                homeWidgetDragOriginalAppCells[app]
                    ?.takeIf { it.page == pageIndex }
                    ?.cell
                    ?: app.launcherItem.cell
            }
        return HomeWidgetDisplacementPolicy.displacedAppCells(
            appCells = appCells,
            widgetCells = widgetCells,
            reservedCells = widgetOccupiedCells,
            maxCells = maxCells
        )
    }

    private fun displacedHomeWidgetCellsForWidget(
        page: GridLayout,
        widgetItems: List<HomeWidgetPreferences.Item>,
        draggedWidgetCells: Set<Int>
    ): Map<String, Int>? {
        val blocks = widgetItems.map { item ->
            HomeWidgetDisplacementPolicy.WidgetBlock(
                id = item.id,
                anchorCell = item.cell,
                span = HomeWidgetPlacementPolicy.spanFor(item.size, page.columnCount)
            )
        }
        return HomeWidgetDisplacementPolicy.displacedWidgetCells(
            widgets = blocks,
            draggedWidgetCells = draggedWidgetCells,
            reservedCells = emptySet(),
            columns = page.columnCount,
            maxCells = page.rowCount * page.columnCount
        )
    }

    private fun applyHomeWidgetDisplacementPreview(
        resolved: HomeWidgetResolvedPlacement,
        animate: Boolean
    ) {
        val affectedWidgets = (
            homeWidgetDragActiveDisplacedWidgetCells.keys + resolved.displacedWidgetCells.keys
        ).toSet()
        affectedWidgets.forEach { itemId ->
            val host = findHomeWidgetHost(itemId) ?: return@forEach
            val item = host.tag as? HomeWidgetPreferences.Item ?: return@forEach
            val page = pages.getOrNull(item.page) ?: return@forEach
            if (host.parent !== page) {
                return@forEach
            }
            val targetCell = resolved.displacedWidgetCells[itemId] ?: item.cell
            val previousTargetCell = homeWidgetDragActiveDisplacedWidgetCells[itemId] ?: item.cell
            if (previousTargetCell == targetCell) {
                return@forEach
            }
            translateHomeWidgetForPreview(
                page = page,
                host = host,
                fromCell = item.cell,
                toCell = targetCell,
                animate = animate
            )
        }
        homeWidgetDragActiveDisplacedWidgetCells = resolved.displacedWidgetCells

        val affectedApps = (homeWidgetDragActiveDisplacedCells.keys + resolved.displacedCells.keys).toSet()
        affectedApps.forEach { app ->
            val originalState = homeWidgetDragOriginalAppCells[app] ?: return@forEach
            val page = pages.getOrNull(originalState.page) ?: return@forEach
            if (app.parent !== page) {
                return@forEach
            }
            val targetCell = resolved.displacedCells[app] ?: originalState.cell
            val previousTargetCell = homeWidgetDragActiveDisplacedCells[app] ?: originalState.cell
            if (previousTargetCell == targetCell) {
                return@forEach
            }
            translateHomeAppForWidgetPreview(
                page = page,
                app = app,
                fromCell = originalState.cell,
                toCell = targetCell,
                animate = HomeWidgetTouchDragPolicy.shouldAnimateDisplacedApp(
                    requestedAnimation = animate,
                    appIsWobbling = app.animation != null
                )
            )
        }
        homeWidgetDragActiveDisplacedCells = resolved.displacedCells
    }

    private fun findHomeWidgetHost(itemId: String): FrameLayout? {
        pages.forEach { page ->
            for (index in 0 until page.childCount) {
                val host = page.getChildAt(index) as? FrameLayout ?: continue
                val item = host.tag as? HomeWidgetPreferences.Item ?: continue
                if (item.id == itemId) {
                    return host
                }
            }
        }
        return null
    }

    private fun translateHomeAppForWidgetPreview(
        page: GridLayout,
        app: BlissFrameLayout,
        fromCell: Int,
        toCell: Int,
        animate: Boolean
    ) {
        val delta = homeCellTranslationDelta(page, fromCell, toCell)
        val appIsWobbling = app.animation != null
        if (HomeWidgetTouchDragPolicy.shouldCancelDisplacedAppAnimator(appIsWobbling)) {
            app.animate().cancel()
        }
        if (animate) {
            app.animate()
                .translationX(delta.first)
                .translationY(delta.second)
                .setDuration(HOME_WIDGET_MOVE_DURATION_MS)
                .setInterpolator(DecelerateInterpolator())
                .start()
        } else {
            app.translationX = delta.first
            app.translationY = delta.second
        }
    }

    private fun translateHomeWidgetForPreview(
        page: GridLayout,
        host: FrameLayout,
        fromCell: Int,
        toCell: Int,
        animate: Boolean
    ) {
        val delta = homeCellTranslationDelta(page, fromCell, toCell)
        host.animate().cancel()
        if (animate) {
            host.animate()
                .translationX(delta.first)
                .translationY(delta.second)
                .setDuration(HOME_WIDGET_MOVE_DURATION_MS)
                .setInterpolator(DecelerateInterpolator())
                .start()
        } else {
            host.translationX = delta.first
            host.translationY = delta.second
        }
    }

    private fun homeCellTranslationDelta(
        page: GridLayout,
        fromCell: Int,
        toCell: Int
    ): Pair<Float, Float> {
        val cellHeightPx = homeCellHeightForPage(page)
        val from = LauncherHomeCellPolicy.gridOffsetForCell(
            cell = fromCell,
            columns = page.columnCount,
            cellWidth = mDeviceProfile.cellWidthPx,
            cellHeight = cellHeightPx
        )
        val to = LauncherHomeCellPolicy.gridOffsetForCell(
            cell = toCell,
            columns = page.columnCount,
            cellWidth = mDeviceProfile.cellWidthPx,
            cellHeight = cellHeightPx
        )
        return Pair((to.left - from.left).toFloat(), (to.top - from.top).toFloat())
    }

    private fun commitHomeWidgetDisplacement(resolved: HomeWidgetResolvedPlacement) {
        val affectedWidgetIds = (
            homeWidgetDragActiveDisplacedWidgetCells.keys + resolved.displacedWidgetCells.keys
        ).toSet()
        val affectedApps = (homeWidgetDragActiveDisplacedCells.keys + resolved.displacedCells.keys).toSet()
        val affectedPages = linkedSetOf<GridLayout>()
        affectedWidgetIds.forEach { itemId ->
            val item = homeWidgetItems.firstOrNull { it.id == itemId } ?: return@forEach
            val page = pages.getOrNull(item.page) ?: return@forEach
            val host = findHomeWidgetHost(itemId)
            val targetCell = resolved.displacedWidgetCells[itemId] ?: item.cell
            host?.animate()?.cancel()
            host?.translationX = 0f
            host?.translationY = 0f
            if (item.cell != targetCell) {
                item.cell = targetCell
                if (host != null && host.parent === page) {
                    applyHomeWidgetLayoutParams(page, host, item)
                }
                affectedPages.add(page)
            }
        }
        affectedApps.forEach { app ->
            val originalState = homeWidgetDragOriginalAppCells[app] ?: return@forEach
            val page = pages.getOrNull(originalState.page) ?: return@forEach
            if (app.parent !== page) {
                return@forEach
            }
            val targetCell = resolved.displacedCells[app] ?: originalState.cell
            app.animate().cancel()
            app.translationX = 0f
            app.translationY = 0f
            if (app.launcherItem.cell != targetCell) {
                app.launcherItem.cell = targetCell
                applyHomeCellLayoutParams(page, app, targetCell, mDeviceProfile.cellWidthPx)
                affectedPages.add(page)
            }
        }
        homeWidgetDragActiveDisplacedCells = emptyMap()
        homeWidgetDragActiveDisplacedWidgetCells = emptyMap()
        affectedPages.forEach { it.requestLayout() }
    }

    private fun homeWidgetPreviewKey(resolved: HomeWidgetResolvedPlacement): String {
        val displacedKey = resolved.displacedCells.entries
            .sortedBy { it.key.launcherItem.id }
            .joinToString(separator = "|") { "${it.key.launcherItem.id}:${it.value}" }
        val displacedWidgetKey = resolved.displacedWidgetCells.entries
            .sortedBy { it.key }
            .joinToString(separator = "|") { "${it.key}:${it.value}" }
        return "${resolved.item.page}:${resolved.item.cell}:$displacedKey:$displacedWidgetKey"
    }

    private fun snapshotHomeWidgetDragAppCells(): Map<BlissFrameLayout, HomeWidgetDragCellState> {
        val result = linkedMapOf<BlissFrameLayout, HomeWidgetDragCellState>()
        pages.forEachIndexed { pageIndex, page ->
            homePageApps(page).forEach { app ->
                result[app] = HomeWidgetDragCellState(pageIndex, app.launcherItem.cell)
            }
        }
        return result
    }

    private fun snapshotHomeWidgetDragPageAppCells(
        snapshot: Map<BlissFrameLayout, HomeWidgetDragCellState>
    ): Map<Int, Map<BlissFrameLayout, Int>> {
        val result = linkedMapOf<Int, MutableMap<BlissFrameLayout, Int>>()
        snapshot.forEach { (app, state) ->
            result.getOrPut(state.page) { linkedMapOf() }[app] = state.cell
        }
        return result
    }

    private fun restoreHomeWidgetDragAppCells(animate: Boolean) {
        if (homeWidgetDragActiveDisplacedCells.isEmpty()) {
            return
        }
        val affectedApps = homeWidgetDragActiveDisplacedCells.keys
        affectedApps.forEach { app ->
            val appIsWobbling = app.animation != null
            if (HomeWidgetTouchDragPolicy.shouldCancelDisplacedAppAnimator(appIsWobbling)) {
                app.animate().cancel()
            }
            if (
                HomeWidgetTouchDragPolicy.shouldAnimateDisplacedApp(
                    requestedAnimation = animate,
                    appIsWobbling = appIsWobbling
                )
            ) {
                app.animate()
                    .translationX(0f)
                    .translationY(0f)
                    .setDuration(HOME_WIDGET_MOVE_DURATION_MS)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
            } else {
                app.translationX = 0f
                app.translationY = 0f
            }
        }
        homeWidgetDragActiveDisplacedCells = emptyMap()
    }

    private fun restoreHomeWidgetDragWidgetCells(animate: Boolean) {
        if (homeWidgetDragActiveDisplacedWidgetCells.isEmpty()) {
            return
        }
        val affectedWidgetIds = homeWidgetDragActiveDisplacedWidgetCells.keys.toList()
        affectedWidgetIds.forEach { itemId ->
            val host = findHomeWidgetHost(itemId) ?: return@forEach
            host.animate().cancel()
            if (animate) {
                host.animate()
                    .translationX(0f)
                    .translationY(0f)
                    .setDuration(HOME_WIDGET_MOVE_DURATION_MS)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
            } else {
                host.translationX = 0f
                host.translationY = 0f
            }
        }
        homeWidgetDragActiveDisplacedWidgetCells = emptyMap()
    }

    private fun clearHomeWidgetDragPreviewState() {
        homeWidgetDragOriginalAppCells = emptyMap()
        homeWidgetDragPageAppCells = emptyMap()
        homeWidgetDragActiveDisplacedCells = emptyMap()
        homeWidgetDragActiveDisplacedWidgetCells = emptyMap()
        homeWidgetDragLastDropKey = null
        homeWidgetDragPreviewKey = null
        homeWidgetDragDockTop = Int.MAX_VALUE
        homeWidgetDragCachedGridPage = -1
        homeWidgetDragCachedGridLeft = 0
        homeWidgetDragCachedGridTop = 0
        homeWidgetDragRootLeft = 0
        homeWidgetDragRootTop = 0
        homeWidgetDragLastScrollAtMs = 0L
        homeWidgetDragSourceLocations.clear()
        homeWidgetDragPendingRawX = 0f
        homeWidgetDragPendingRawY = 0f
        homeWidgetDragPreviewFramePosted = false
        homeWidgetDragPendingPlacementRawX = 0f
        homeWidgetDragPendingPlacementRawY = 0f
        homeWidgetDragPlacementFramePosted = false
        clearHomeWidgetDragShadowBitmap()
        homeWidgetDragLastPlacementPreviewAtMs = 0L
        homeWidgetTouchDragActive = false
        homeWidgetTouchDragStartedFromPicker = false
        homeWidgetTouchLastRawX = 0f
        homeWidgetTouchLastRawY = 0f
    }

    private fun prepareHomeWidgetDragRuntimeCache() {
        val dockBounds = Rect()
        homeWidgetDragDockTop = if (::mDock.isInitialized && mDock.getGlobalVisibleRect(dockBounds)) {
            dockBounds.top
        } else {
            Int.MAX_VALUE
        }
        homeWidgetDragCachedGridPage = -1
        homeWidgetDragCachedGridLeft = 0
        homeWidgetDragCachedGridTop = 0
        val rootLocation = IntArray(2)
        (mLauncherView as? ViewGroup)?.getLocationOnScreen(rootLocation)
        homeWidgetDragRootLeft = rootLocation[0]
        homeWidgetDragRootTop = rootLocation[1]
        homeWidgetDragLastScrollAtMs = 0L
        homeWidgetDragSourceLocations.clear()
        homeWidgetDragPendingRawX = 0f
        homeWidgetDragPendingRawY = 0f
        homeWidgetDragPreviewFramePosted = false
        homeWidgetDragPendingPlacementRawX = 0f
        homeWidgetDragPendingPlacementRawY = 0f
        homeWidgetDragPlacementFramePosted = false
        homeWidgetDragLastPlacementPreviewAtMs = 0L
    }

    private fun homeWidgetDragRawPoint(source: View, event: DragEvent): Pair<Float, Float> {
        val sourceLocation = homeWidgetDragSourceLocations[source] ?: run {
            val location = IntArray(2)
            source.getLocationOnScreen(location)
            Pair(location[0], location[1]).also { homeWidgetDragSourceLocations[source] = it }
        }
        return Pair(sourceLocation.first + event.x, sourceLocation.second + event.y)
    }

    private fun dropCellForHomeGridRawCached(
        pageIndex: Int,
        gridLayout: GridLayout,
        rawX: Float,
        rawY: Float
    ): Int {
        if (homeWidgetDragCachedGridPage != pageIndex) {
            val location = IntArray(2)
            gridLayout.getLocationOnScreen(location)
            homeWidgetDragCachedGridPage = pageIndex
            homeWidgetDragCachedGridLeft = location[0]
            homeWidgetDragCachedGridTop = location[1]
        }
        return LauncherHomeCellPolicy.dropCell(
            dropX = rawX,
            dropY = rawY,
            gridLeft = homeWidgetDragCachedGridLeft,
            gridTop = homeWidgetDragCachedGridTop,
            paddingLeft = gridLayout.paddingLeft,
            paddingTop = gridLayout.paddingTop,
            cellWidth = mDeviceProfile.cellWidthPx,
            cellHeight = homeCellHeightForPage(gridLayout),
            rows = gridLayout.rowCount,
            columns = gridLayout.columnCount
        )
    }

    private fun homePageApps(page: GridLayout): List<BlissFrameLayout> {
        val apps = ArrayList<BlissFrameLayout>()
        for (index in 0 until page.childCount) {
            val app = page.getChildAt(index) as? BlissFrameLayout ?: continue
            apps.add(app)
        }
        return apps
    }

    private fun homePageAppBounds(apps: Set<BlissFrameLayout>? = null): Map<BlissFrameLayout, Rect> {
        val bounds = linkedMapOf<BlissFrameLayout, Rect>()
        if (apps != null) {
            apps.forEach { app ->
                if (app.parent == null) {
                    return@forEach
                }
                val rect = Rect()
                if (app.getGlobalVisibleRect(rect)) {
                    bounds[app] = Rect(rect)
                }
            }
            return bounds
        }

        pages.forEach { page ->
            homePageApps(page).forEach { app ->
                val rect = Rect()
                if (app.getGlobalVisibleRect(rect)) {
                    bounds[app] = Rect(rect)
                }
            }
        }
        return bounds
    }

    private fun animateHomePageAppMoves(previousBounds: Map<BlissFrameLayout, Rect>) {
        if (previousBounds.isEmpty()) {
            return
        }
        mHorizontalPager.doOnPreDraw {
            previousBounds.forEach { (app, previous) ->
                val current = Rect()
                if (!app.getGlobalVisibleRect(current)) {
                    return@forEach
                }
                val dx = (previous.left - current.left).toFloat()
                val dy = (previous.top - current.top).toFloat()
                if (dx == 0f && dy == 0f) {
                    return@forEach
                }
                app.animate().cancel()
                app.translationX = dx
                app.translationY = dy
                app.animate()
                    .translationX(0f)
                    .translationY(0f)
                    .setDuration(HOME_WIDGET_MOVE_DURATION_MS)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
            }
        }
    }

    private fun canPlaceHomeWidgetItem(item: HomeWidgetPreferences.Item): Boolean {
        val page = pages.getOrNull(item.page) ?: return false
        val span = HomeWidgetPlacementPolicy.spanFor(item.size, page.columnCount)
        val candidateCells = HomeWidgetPlacementPolicy.occupiedCellsFor(
            anchorCell = item.cell,
            span = span,
            columns = page.columnCount,
            maxCells = page.rowCount * page.columnCount
        )
        val reservedWidgetCells = homeWidgetOccupiedCellsForPage(item.page, item.id)
        return HomeWidgetDropValidationPolicy.canPlace(candidateCells, reservedWidgetCells)
    }

    private fun upsertHomeWidgetItem(item: HomeWidgetPreferences.Item): Boolean {
        if (!canPlaceHomeWidgetItem(item)) {
            Toast.makeText(this, R.string.home_widget_no_room, Toast.LENGTH_SHORT).show()
            return false
        }
        val merged = HomeWidgetMergePolicy.upsert(homeWidgetItems, item)
        homeWidgetItems.clear()
        homeWidgetItems.addAll(merged)
        normalizeHomeWidgetItems(saveIfChanged = false)
        saveHomeWidgets()
        renderHomeWidgets()
        refreshPageIndicator()
        return true
    }

    private fun placeHomeWidgetDropItem(
        item: HomeWidgetPreferences.Item,
        spec: HomeWidgetDragSpec
    ): Boolean {
        val placed = upsertHomeWidgetItem(item)
        if (placed && spec.existingItemId == null && item.appWidgetId == pendingHomeSystemWidgetId) {
            pendingHomeSystemWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
        }
        return placed
    }

    private fun deleteUnplacedHomeSystemWidgetIfNeeded(spec: HomeWidgetDragSpec) {
        val appWidgetId = spec.appWidgetId ?: return
        if (spec.type != HOME_WIDGET_TYPE_SYSTEM || spec.existingItemId != null) {
            return
        }
        mAppWidgetHost.deleteAppWidgetId(appWidgetId)
        if (pendingHomeSystemWidgetId == appWidgetId) {
            pendingHomeSystemWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
        }
    }

    private fun dropCellForHomeGridRaw(gridLayout: GridLayout, rawX: Float, rawY: Float): Int {
        val location = IntArray(2)
        gridLayout.getLocationOnScreen(location)
        return LauncherHomeCellPolicy.dropCell(
            dropX = rawX,
            dropY = rawY,
            gridLeft = location[0],
            gridTop = location[1],
            paddingLeft = gridLayout.paddingLeft,
            paddingTop = gridLayout.paddingTop,
            cellWidth = mDeviceProfile.cellWidthPx,
            cellHeight = homeCellHeightForPage(gridLayout),
            rows = gridLayout.rowCount,
            columns = gridLayout.columnCount
        )
    }

    private fun homeWidgetTypeForQuick(type: TodayQuickWidgetType): String {
        return when (type) {
            TodayQuickWidgetType.WEATHER -> HOME_WIDGET_TYPE_WEATHER
            TodayQuickWidgetType.BATTERY -> HOME_WIDGET_TYPE_BATTERY
            TodayQuickWidgetType.PICTURE -> HOME_WIDGET_TYPE_PICTURE
            else -> HOME_WIDGET_TYPE_WEATHER
        }
    }

    private fun homeQuickWidgetTypeForHomeType(type: String): TodayQuickWidgetType {
        return when (type) {
            HOME_WIDGET_TYPE_BATTERY -> TodayQuickWidgetType.BATTERY
            HOME_WIDGET_TYPE_PICTURE -> TodayQuickWidgetType.PICTURE
            else -> TodayQuickWidgetType.WEATHER
        }
    }

    private fun homeWidgetSizeForType(type: String): HomeWidgetPlacementPolicy.WidgetSize {
        return when (type) {
            HOME_WIDGET_TYPE_BATTERY,
            HOME_WIDGET_TYPE_PICTURE -> HomeWidgetPlacementPolicy.WidgetSize.SMALL
            else -> HomeWidgetPlacementPolicy.WidgetSize.FULL_WIDTH
        }
    }

    private fun dismissHomeWidgetPicker() {
        val dialog = homeWidgetPickerDialog
        homeWidgetPickerDialog = null
        homeWidgetPickerSheet = null
        dialog?.setOnDismissListener(null)
        if (dialog?.isShowing == true) {
            dialog.dismiss()
        }
        homeWidgetPickerOverlay?.let { overlay ->
            (overlay.parent as? ViewGroup)?.removeView(overlay)
        }
        homeWidgetPickerOverlay = null
    }

    private fun dismissHomeWidgetProviderPreview() {
        val dialog = homeWidgetProviderDialog
        homeWidgetProviderDialog = null
        homeWidgetProviderSheet = null
        dialog?.setOnDismissListener(null)
        if (dialog?.isShowing == true) {
            dialog.dismiss()
        }
    }

    private fun homeWidgetDragStartPoint(source: View, rawX: Float, rawY: Float): Pair<Float, Float> {
        val location = IntArray(2)
        source.getLocationOnScreen(location)
        val point = HomeWidgetInteractionPolicy.dragStartPoint(
            rawX = rawX,
            rawY = rawY,
            sourceBounds = HomeWidgetInteractionPolicy.Bounds(
                left = location[0],
                top = location[1],
                right = location[0] + source.width,
                bottom = location[1] + source.height
            )
        )
        return point.x to point.y
    }

    private fun startExistingHomeWidgetDrag(
        item: HomeWidgetPreferences.Item,
        host: View,
        rawX: Float = homeWidgetTouchLastRawX,
        rawY: Float = homeWidgetTouchLastRawY
    ): Boolean {
        if (!isWobbling) {
            handleWobbling(true)
            return true
        }
        val latestItem = homeWidgetItems.firstOrNull { it.id == item.id } ?: item
        val sessionId = HomeWidgetDragSessionPolicy.nextSessionId(homeWidgetDragSessionId)
        val startPoint = homeWidgetDragStartPoint(host, rawX, rawY)
        return beginHomeWidgetTouchDrag(
            spec = HomeWidgetDragSpec(
                type = latestItem.type,
                size = latestItem.size,
                itemId = latestItem.id,
                sessionId = sessionId,
                existingItemId = latestItem.id,
                appWidgetId = latestItem.appWidgetId
            ),
            host = host,
            rawX = startPoint.first,
            rawY = startPoint.second,
            startedFromPicker = false
        )
    }

    private fun startHomeWidgetPickerDrag(
        type: String,
        source: View,
        rawX: Float = homeWidgetTouchLastRawX,
        rawY: Float = homeWidgetTouchLastRawY
    ): Boolean {
        val size = homeWidgetSizeForType(type)
        val sessionId = HomeWidgetDragSessionPolicy.nextSessionId(homeWidgetDragSessionId)
        val startPoint = homeWidgetDragStartPoint(source, rawX, rawY)
        return beginHomeWidgetTouchDrag(
            spec = HomeWidgetDragSpec(
                type = type,
                size = size,
                itemId = createHomeWidgetId(),
                sessionId = sessionId
            ),
            host = null,
            rawX = startPoint.first,
            rawY = startPoint.second,
            startedFromPicker = true
        )
    }

    private fun startHomeWidgetProviderDrag(
        provider: TodayWidgetProvider,
        source: View,
        rawX: Float = homeWidgetTouchLastRawX,
        rawY: Float = homeWidgetTouchLastRawY
    ): Boolean {
        val appWidgetId = mAppWidgetHost.allocateAppWidgetId()
        pendingHomeSystemWidgetId = appWidgetId
        return try {
            if (!mAppWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId, provider.providerInfo.provider)) {
                mAppWidgetHost.deleteAppWidgetId(appWidgetId)
                pendingHomeSystemWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
                Toast.makeText(this, R.string.toast_failed, Toast.LENGTH_SHORT).show()
                return true
            }
            val sessionId = HomeWidgetDragSessionPolicy.nextSessionId(homeWidgetDragSessionId)
            val startPoint = homeWidgetDragStartPoint(source, rawX, rawY)
            beginHomeWidgetTouchDrag(
                spec = HomeWidgetDragSpec(
                    type = HOME_WIDGET_TYPE_SYSTEM,
                    size = HomeWidgetProviderPreviewPolicy.homeWidgetSize(
                        provider.providerInfo.minWidth,
                        provider.providerInfo.minHeight
                    ),
                    itemId = createHomeWidgetId(),
                    sessionId = sessionId,
                    appWidgetId = appWidgetId,
                    preview = provider.preview ?: provider.icon
                ),
                host = null,
                rawX = startPoint.first,
                rawY = startPoint.second,
                startedFromPicker = true
            )
        } catch (e: IllegalArgumentException) {
            mAppWidgetHost.deleteAppWidgetId(appWidgetId)
            pendingHomeSystemWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
            Toast.makeText(this, R.string.toast_failed, Toast.LENGTH_SHORT).show()
            true
        }
    }

    private fun createHomeWidgetId(): String =
        "home_widget_${SystemClock.uptimeMillis()}_${homeWidgetItems.size}"

    private fun createHomeWidgetDragShadowBuilder(
        type: String,
        size: HomeWidgetPlacementPolicy.WidgetSize,
        source: View
    ): View.DragShadowBuilder {
        clearHomeWidgetDragShadowBitmap()
        val bitmap = renderHomeWidgetDragBitmap(type, size) ?: return InvisibleTodayWidgetDragShadowBuilder(source)
        homeWidgetDragShadowBitmap = bitmap
        return BitmapTodayWidgetDragShadowBuilder(source, bitmap)
    }

    private fun renderHomeWidgetDragBitmap(
        type: String,
        size: HomeWidgetPlacementPolicy.WidgetSize,
        appWidgetId: Int? = null,
        preview: Drawable? = null
    ): Bitmap? {
        val page = pages.getOrNull(getCurrentAppsPageNumber()) ?: pages.firstOrNull() ?: return null
        val span = HomeWidgetPlacementPolicy.spanFor(size, page.columnCount)
        val width = mDeviceProfile.cellWidthPx * span.columns
        val height = homeCellHeightForPage(page) * span.rows
        if (width <= 0 || height <= 0) {
            return null
        }
        val content = FrameLayout(this).apply {
            setPadding(
                homeWidgetHorizontalInset(span),
                homeWidgetTopInset(),
                homeWidgetHorizontalInset(span),
                homeWidgetBottomInset()
            )
            val widgetBody = if (type == HOME_WIDGET_TYPE_SYSTEM) {
                preview?.let { createHomeSystemWidgetPreviewBody(it) } ?: createHomeSystemWidgetBody(
                    HomeWidgetPreferences.Item(
                        id = "preview",
                        type = HOME_WIDGET_TYPE_SYSTEM,
                        size = size,
                        page = 0,
                        cell = 0,
                        appWidgetId = appWidgetId
                    ),
                    null
                )
            } else {
                createHomeWidgetBody(type, null)
            }
            addView(
                widgetBody,
                FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
            )
        }
        val widthSpec = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY)
        val heightSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)
        content.measure(widthSpec, heightSpec)
        content.layout(0, 0, width, height)
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        content.draw(Canvas(bitmap))
        return bitmap
    }

    private fun createHomeWidgetDragPreview(spec: HomeWidgetDragSpec) {
        removeHomeWidgetDragPreview()
        val bitmap = renderHomeWidgetDragBitmap(spec.type, spec.size, spec.appWidgetId, spec.preview) ?: return
        homeWidgetDragPreview = ImageView(this).apply {
            tag = HOME_WIDGET_DRAG_PREVIEW_TAG
            setImageBitmap(bitmap)
            scaleType = ImageView.ScaleType.FIT_XY
            alpha = 0.96f
            elevation = dp(26).toFloat()
            visibility = View.INVISIBLE
            setLayerType(View.LAYER_TYPE_HARDWARE, null)
            isClickable = false
            isFocusable = false
        }
        (mLauncherView as? ViewGroup)?.addView(
            homeWidgetDragPreview,
            ViewGroup.LayoutParams(bitmap.width, bitmap.height)
        )
    }

    private fun updateHomeWidgetDragPreview(rawX: Float, rawY: Float) {
        if (homeWidgetDragPreview == null) {
            return
        }
        scheduleHomeWidgetDragPreview(rawX, rawY)
    }

    private fun applyHomeWidgetDragPreviewPosition(rawX: Float, rawY: Float) {
        val preview = homeWidgetDragPreview ?: return
        preview.visibility = VISIBLE
        preview.translationX = rawX - homeWidgetDragRootLeft - preview.width / 2f
        preview.translationY = rawY - homeWidgetDragRootTop - preview.height / 2f
    }

    private fun removeHomeWidgetDragPreview() {
        homeWidgetDragPreview?.let { preview ->
            detachHomeWidgetDragPreview(preview)
        }
        homeWidgetDragPreview = null
        (mLauncherView as? ViewGroup)?.let { removeHomeWidgetDragPreviewArtifacts(it) }
    }

    private fun removeHomeWidgetDragPreviewArtifacts(parent: ViewGroup) {
        var index = parent.childCount - 1
        while (index >= 0) {
            val child = parent.getChildAt(index)
            if (child.tag == HOME_WIDGET_DRAG_PREVIEW_TAG) {
                detachHomeWidgetDragPreview(child)
            } else if (child is ViewGroup) {
                removeHomeWidgetDragPreviewArtifacts(child)
            }
            index--
        }
    }

    private fun detachHomeWidgetDragPreview(preview: View) {
        preview.animate().cancel()
        preview.clearAnimation()
        preview.setLayerType(View.LAYER_TYPE_NONE, null)
        if (preview is ImageView) {
            val bitmap = (preview.drawable as? BitmapDrawable)?.bitmap
            preview.setImageDrawable(null)
            if (bitmap?.isRecycled == false) {
                bitmap.recycle()
            }
        }
        (preview.parent as? ViewGroup)?.let { parent ->
            parent.removeView(preview)
            parent.invalidate()
            parent.postInvalidateOnAnimation()
        }
    }

    private fun clearHomeWidgetDragShadowBitmap() {
        homeWidgetDragShadowBitmap?.recycle()
        homeWidgetDragShadowBitmap = null
    }

    private fun addSheetGrabber(sheet: LinearLayout, expandTouchTarget: Boolean = true): View {
        val grabber = View(this).apply {
            background = roundedRectangle(0x33000000, 2)
        }
        sheet.addView(
            grabber,
            LinearLayout.LayoutParams(dp(42), dp(4)).apply {
                gravity = Gravity.CENTER_HORIZONTAL
            }
        )
        if (expandTouchTarget) {
            expandSheetGrabberTouchTarget(grabber)
        }
        return grabber
    }

    private fun expandSheetGrabberTouchTarget(grabber: View) {
        grabber.post {
            val sheet = grabber.parent as? View ?: return@post
            val hitRect = Rect()
            grabber.getHitRect(hitRect)
            hitRect.left = 0
            hitRect.right = sheet.width
            hitRect.top -= dp(14)
            hitRect.bottom += dp(18)
            sheet.touchDelegate = TouchDelegate(hitRect, grabber)
        }
    }

    private fun dismissTodayWidgetPicker() {
        val dialog = widgetPickerDialog ?: return
        widgetPickerDialog = null
        dialog.setOnDismissListener(null)
        if (dialog.isShowing) {
            dialog.dismiss()
        }
    }

    private fun dismissTodayWidgetPreview() {
        widgetPreviewOverlay?.let { overlay ->
            (overlay.parent as? ViewGroup)?.removeView(overlay)
        }
        widgetPreviewOverlay = null
    }

    private fun addHomeWidgetFromProvider(providerInfo: AppWidgetProviderInfo) {
        dismissHomeWidgetProviderPreview()
        dismissHomeWidgetPicker()

        val appWidgetId = mAppWidgetHost.allocateAppWidgetId()
        pendingHomeSystemWidgetId = appWidgetId

        try {
            if (mAppWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId, providerInfo.provider)) {
                handleHomeSystemWidgetBound(appWidgetId)
            } else {
                val permissionIntent = Intent(AppWidgetManager.ACTION_APPWIDGET_BIND).apply {
                    putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
                    putExtra(AppWidgetManager.EXTRA_APPWIDGET_PROVIDER, providerInfo.provider)
                    putExtra(AppWidgetManager.EXTRA_APPWIDGET_PROVIDER_PROFILE, providerInfo.profile)
                }
                startActivityForResult(permissionIntent, REQUEST_HOME_BIND_APPWIDGET)
            }
        } catch (e: IllegalArgumentException) {
            mAppWidgetHost.deleteAppWidgetId(appWidgetId)
            pendingHomeSystemWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
            Toast.makeText(this, R.string.toast_failed, Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleHomeSystemWidgetBound(appWidgetId: Int) {
        val appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(appWidgetId)
        if (appWidgetInfo == null) {
            mAppWidgetHost.deleteAppWidgetId(appWidgetId)
            pendingHomeSystemWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
            return
        }

        if (appWidgetInfo.configure != null) {
            startHomeSystemWidgetConfigureActivitySafely(appWidgetId)
        } else {
            createHomeSystemWidget(appWidgetId)
        }
    }

    private fun startHomeSystemWidgetConfigureActivitySafely(appWidgetId: Int) {
        try {
            mAppWidgetHost.startAppWidgetConfigureActivityForResult(
                this,
                appWidgetId,
                0,
                REQUEST_HOME_CREATE_APPWIDGET,
                null
            )
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, R.string.activity_not_found, Toast.LENGTH_SHORT).show()
            createHomeSystemWidget(appWidgetId)
        }
    }

    private fun createHomeSystemWidget(appWidgetId: Int) {
        val appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(appWidgetId)
        if (appWidgetInfo == null) {
            mAppWidgetHost.deleteAppWidgetId(appWidgetId)
            pendingHomeSystemWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
            return
        }

        val spec = HomeWidgetDragSpec(
            type = HOME_WIDGET_TYPE_SYSTEM,
            size = HomeWidgetProviderPreviewPolicy.homeWidgetSize(
                appWidgetInfo.minWidth,
                appWidgetInfo.minHeight
            ),
            itemId = createHomeWidgetId(),
            sessionId = HomeWidgetDragSessionPolicy.nextSessionId(homeWidgetDragSessionId),
            appWidgetId = appWidgetId
        )
        val placed = placeHomeWidgetInFirstAvailableCell(spec)
        if (!placed) {
            mAppWidgetHost.deleteAppWidgetId(appWidgetId)
            pendingHomeSystemWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
            return
        }

        pendingHomeSystemWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
        handleWobbling(true)
        Toast.makeText(this, R.string.home_widget_added_hold_hint, Toast.LENGTH_SHORT).show()
    }

    private fun placeHomeWidgetInFirstAvailableCell(spec: HomeWidgetDragSpec): Boolean {
        val pageIndex = getCurrentAppsPageNumber().coerceIn(0, (pages.size - 1).coerceAtLeast(0))
        val page = pages.getOrNull(pageIndex) ?: return false
        val maxCells = page.rowCount * page.columnCount
        for (cell in 0 until maxCells) {
            val resolved = resolveHomeWidgetPlacementForCell(
                spec = spec,
                pageIndex = pageIndex,
                page = page,
                dropCell = cell,
                showNoRoomToast = false
            ) ?: continue
            commitHomeWidgetDisplacement(resolved)
            return upsertHomeWidgetItem(resolved.item)
        }

        Toast.makeText(this, R.string.home_widget_no_room, Toast.LENGTH_SHORT).show()
        return false
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
        launcherLayoutRepository.insertWidget(widgetItem)
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
        launcherResumedForInstalledAppReveal = false
        dismissTodayWidgetPicker()
        dismissTodayWidgetPreview()
        dismissHomeWidgetProviderPreview()
        hideAppLibrarySearchOverlay(animated = false)
        hideAppLibraryDetailOverlay(animated = false)
        hideRenameAppPicker()
        dismissLauncherOptionsPopup()
        hideWeatherSettingsPage()
        hideWeatherDetailPage()
        if (widgetsPage != null) {
            hideWidgetResizeContainer()
        }
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        launcherPresenter.detachView()
        timeChangedReceiver?.let { TimeChangeBroadcastReceiver.unregister(this, it) }
        managedProfileReceiver?.let { ManagedProfileBroadcastReceiver.unregister(this, it) }
        weatherRefreshHandler.removeCallbacks(weatherRefreshRunnable)
        weatherExecutor.shutdownNow()
        compositeDisposableBag.dispose()
        events?.unsubscribe()
        swipeSearchContentBinding = null
        widgetsPageBinding = null
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
        moveTo = -1
        updateOrAddApp(appAddEvent.packageName, appAddEvent.userHandle)
        launcherLayoutRepository.saveLayouts(pages, mDock)
        if (moveTo != -1) {
            val targetPage = moveTo
            pendingInstalledAppReveal = PendingInstalledAppReveal(
                packageName = appAddEvent.packageName,
                userHandle = appAddEvent.userHandle,
                targetPagerPage = targetPage
            )
            mHorizontalPager.setCurrentPage(targetPage)
            moveTo = -1
            revealPendingInstalledAppIfReady()
        }
    }

    private fun revealPendingInstalledAppIfReady() {
        val pending = pendingInstalledAppReveal ?: return
        if (
            !LauncherInstalledAppRevealPolicy.shouldReveal(
                launcherResumed = launcherResumedForInstalledAppReveal,
                targetPagerPage = pending.targetPagerPage,
                homePageCount = pages.size
            )
        ) {
            return
        }

        if (::mHorizontalPager.isInitialized) {
            mHorizontalPager.setCurrentPage(pending.targetPagerPage)
        }
        val iconView = findInstalledAppRevealView(pending)
        if (iconView == null) {
            pendingInstalledAppReveal = null
            return
        }

        pendingInstalledAppReveal = null
        prepareInstalledAppRevealAnimation(iconView)
    }

    private fun findInstalledAppRevealView(pending: PendingInstalledAppReveal): BlissFrameLayout? {
        val targetHomePage = pending.targetPagerPage - 1
        pages.getOrNull(targetHomePage)
            ?.let { page -> findApplicationViewInGrid(page, pending.packageName, pending.userHandle) }
            ?.let { return it }

        for (page in pages) {
            findApplicationViewInGrid(page, pending.packageName, pending.userHandle)?.let { return it }
        }
        return null
    }

    private fun findApplicationViewInGrid(
        grid: GridLayout,
        packageName: String,
        userHandle: UserHandle
    ): BlissFrameLayout? {
        for (index in 0 until grid.childCount) {
            val appView = grid.getChildAt(index) as? BlissFrameLayout ?: continue
            val item = getAppDetails(appView) as? ApplicationItem ?: continue
            if (
                item.packageName.equals(packageName, ignoreCase = true) &&
                (item.user ?: UserHandle()).isSameUser(userHandle)
            ) {
                return appView
            }
        }
        return null
    }

    private fun prepareInstalledAppRevealAnimation(iconView: BlissFrameLayout) {
        iconView.animate().cancel()
        iconView.clearAnimation()
        iconView.alpha = 0f
        iconView.scaleX = LauncherInstalledAppRevealPolicy.INITIAL_SCALE
        iconView.scaleY = LauncherInstalledAppRevealPolicy.INITIAL_SCALE
        iconView.doOnPreDraw {
            startInstalledAppRevealAnimation(iconView)
        }
        iconView.invalidate()
    }

    private fun startInstalledAppRevealAnimation(iconView: BlissFrameLayout) {
        iconView.pivotX = iconView.width / 2f
        iconView.pivotY = iconView.height / 2f

        val alpha = ObjectAnimator.ofFloat(iconView, View.ALPHA, 0f, 1f).apply {
            duration = LauncherInstalledAppRevealPolicy.ALPHA_DURATION_MS
            interpolator = LinearInterpolator()
        }
        val scaleX = ObjectAnimator.ofFloat(
            iconView,
            View.SCALE_X,
            LauncherInstalledAppRevealPolicy.INITIAL_SCALE,
            LauncherInstalledAppRevealPolicy.PEAK_SCALE,
            LauncherInstalledAppRevealPolicy.SETTLE_SCALE,
            LauncherInstalledAppRevealPolicy.FINAL_SCALE
        ).apply {
            duration = LauncherInstalledAppRevealPolicy.REVEAL_DURATION_MS
            interpolator = DecelerateInterpolator()
        }
        val scaleY = ObjectAnimator.ofFloat(
            iconView,
            View.SCALE_Y,
            LauncherInstalledAppRevealPolicy.INITIAL_SCALE,
            LauncherInstalledAppRevealPolicy.PEAK_SCALE,
            LauncherInstalledAppRevealPolicy.SETTLE_SCALE,
            LauncherInstalledAppRevealPolicy.FINAL_SCALE
        ).apply {
            duration = LauncherInstalledAppRevealPolicy.REVEAL_DURATION_MS
            interpolator = DecelerateInterpolator()
        }

        AnimatorSet().apply {
            playTogether(alpha, scaleX, scaleY)
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationCancel(animation: Animator) {
                    resetInstalledAppRevealView(iconView)
                }

                override fun onAnimationEnd(animation: Animator) {
                    resetInstalledAppRevealView(iconView)
                }
            })
            start()
        }
    }

    private fun resetInstalledAppRevealView(iconView: BlissFrameLayout) {
        iconView.alpha = 1f
        iconView.scaleX = 1f
        iconView.scaleY = 1f
    }

    fun onAppRemoveEvent(appRemoveEvent: AppRemoveEvent) {
        forceRefreshSuggestedApps = true
        if (!completePendingApplicationUninstallIfMatches(appRemoveEvent.packageName, appRemoveEvent.userHandle)) {
            removePackageFromLauncher(appRemoveEvent.packageName, appRemoveEvent.userHandle)
        }
        launcherLayoutRepository.saveLayouts(pages, mDock)
        rebindAllWidgets()
    }

    fun onAppChangeEvent(appChangeEvent: AppChangeEvent) {
        updateOrAddApp(appChangeEvent.packageName, appChangeEvent.userHandle)
        launcherLayoutRepository.saveLayouts(pages, mDock)
    }

    fun onAppRenameEvent(appRenameEvent: AppRenameEvent) {
        applyRenamedTitleToLauncher(appRenameEvent.appKeys, appRenameEvent.updatedTitle)
        launcherLayoutRepository.saveLayouts(pages, mDock)
        refreshAppLibraryPage()
    }

    fun onAppWallpaperEvent(appWallpaperEvent: AppWallpaperEvent) {
        LauncherHomeLayoutPreferences.setCustomWallpaperUri(this, appWallpaperEvent.wallpaperUri)
        applyCustomWallpaper(appWallpaperEvent.wallpaperUri)
    }

    private fun applyCustomWallpaperFromPreferences() {
        applyCustomWallpaper(LauncherHomeLayoutPreferences.customWallpaperUri(this))
    }

    private fun applyCustomWallpaper(rawUri: String?) {
        if (!::workspace.isInitialized || !::blurLayer.isInitialized) return

        val wallpaper = customWallpaperBitmap(rawUri)
        if (wallpaper != null) {
            workspace.background = customWallpaperDrawable(wallpaper)
            setRealtimeLiquidGlassSourceWallpaper(
                if (
                    LauncherRealtimeLiquidGlassPolicy.shouldMirrorCustomWallpaperToSource(
                        customWallpaperAvailable = true
                    )
                ) {
                    customWallpaperDrawable(wallpaper)
                } else {
                    null
                }
            )
            blurLayer.visibility = VISIBLE
            setBlurLayersAlpha(0f)
        } else {
            if (
                LauncherRealtimeLiquidGlassPolicy.shouldUseDefaultWallpaperSourceFallback(
                    customWallpaperAvailable = false
                )
            ) {
                workspace.background = defaultWallpaperDrawable()
                setRealtimeLiquidGlassSourceWallpaper(defaultWallpaperDrawable())
            } else {
                workspace.background = null
                setRealtimeLiquidGlassSourceWallpaper(null)
            }
            blurLayer.visibility = VISIBLE
        }
    }

    private fun customWallpaperDrawable(bitmap: Bitmap): Drawable =
        BitmapDrawable(resources, bitmap).apply {
            gravity = Gravity.FILL
        }

    private fun setRealtimeLiquidGlassSourceWallpaper(drawable: Drawable?) {
        val source = realtimeLiquidGlassSource()
        source?.background = null
        val wallpaperView = realtimeLiquidGlassWallpaperView()
        wallpaperView?.setImageDrawable(drawable)
        wallpaperView?.visibility = if (drawable != null) VISIBLE else GONE
        source?.invalidate()
    }

    private fun realtimeLiquidGlassWallpaperView(): ImageView? =
        if (::binding.isInitialized) {
            binding.liquidGlassWallpaper
        } else {
            null
        }

    private fun defaultWallpaperDrawable(): Drawable? =
        ContextCompat.getDrawable(this, R.drawable.ios26_sky_home_screen_light)
            ?.constantState
            ?.newDrawable(resources)
            ?.apply {
                if (this is BitmapDrawable) {
                    gravity = Gravity.FILL
                }
            }

    private fun customWallpaperBitmap(rawUri: String?): Bitmap? {
        if (rawUri.isNullOrBlank()) return null
        val uri = runCatching { Uri.parse(rawUri) }.getOrNull() ?: return null
        val source = runCatching {
            contentResolver.openInputStream(uri)?.use { input -> BitmapFactory.decodeStream(input) }
        }.getOrNull() ?: return null
        val targetWidth = resources.displayMetrics.widthPixels.coerceAtLeast(1)
        val targetHeight = resources.displayMetrics.heightPixels.coerceAtLeast(1)
        return centerCropBitmap(source, targetWidth, targetHeight)
    }

    private fun centerCropBitmap(source: Bitmap, targetWidth: Int, targetHeight: Int): Bitmap {
        if (source.width <= 0 || source.height <= 0) return source
        val scale = max(
            targetWidth.toFloat() / source.width.toFloat(),
            targetHeight.toFloat() / source.height.toFloat()
        )
        val scaledWidth = (source.width * scale).toInt().coerceAtLeast(targetWidth)
        val scaledHeight = (source.height * scale).toInt().coerceAtLeast(targetHeight)
        val scaled = Bitmap.createScaledBitmap(source, scaledWidth, scaledHeight, true)
        val left = ((scaled.width - targetWidth) / 2).coerceAtLeast(0)
        val top = ((scaled.height - targetHeight) / 2).coerceAtLeast(0)
        return Bitmap.createBitmap(scaled, left, top, targetWidth, targetHeight)
    }

    fun onShortcutAddEvent(shortcutAddEvent: ShortcutAddEvent) {
        moveTo = -1
        updateOrAddShortcut(shortcutAddEvent.shortcutItem)
        launcherLayoutRepository.saveLayouts(pages, mDock)
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
        val placement = findHomePlacementForNewItem()

        val page = if (placement.page < pages.size) {
            pages[placement.page]
        } else {
            preparePage().also { newPage ->
                pages.add(newPage)
                addHomePageToPager(newPage)
            }
        }
        if (placement.page >= pages.size - 1) {
            refreshPageIndicator()
        }

        launcherItem.screenId = placement.page.toLong()
        launcherItem.cell = placement.cell
        launcherItem.container = Constants.CONTAINER_DESKTOP.toLong()
        addAppToGrid(page, view)
        moveTo = placement.page + 1
    }

    private fun findHomePlacementForNewItem(): LauncherHomeCellPolicy.PageCell {
        return LauncherHomeCellPolicy.newItemPlacement(
            preferredPage = preferredHomePageForNewItem(),
            existingPageCount = pages.size,
            occupiedCellsByPage = occupiedHomeCellsByPage(),
            maxCells = mDeviceProfile.maxAppsPerPage
        )
    }

    private fun preferredHomePageForNewItem(): Int {
        if (pages.isEmpty()) {
            return 0
        }
        return getCurrentAppsPageNumber().coerceIn(0, pages.size - 1)
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
                            refreshOpenFolderLiquidGlassIfNeeded()
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
                val viewGroup = gridLayout.getChildAt(j) as? BlissFrameLayout ?: continue
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
                val child = grid.getChildAt(childIndex)
                val appView = child as? BlissFrameLayout
                if (appView == null) {
                    childIndex++
                    continue
                }
                val launcherItem = getAppDetails(appView)
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
        launcherLayoutRepository.removeLauncherPackage(packageName)
        launcherLayoutRepository.saveLayouts(pages, mDock)
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

    private fun removeFolderView(folder: FolderItem, folderView: BlissFrameLayout) {
        folderView.clearAnimation()
        removeUninstallIcon(folderView)
        (folderView.parent as? ViewGroup)?.removeView(folderView)
        launcherLayoutRepository.removeLauncherItem(folder.id)
    }

    private fun replaceFolderWithRemainingItem(
        folder: FolderItem,
        folderView: BlissFrameLayout,
        remainingItem: LauncherItem,
        folderWasFromDock: Boolean,
        shouldWobble: Boolean = false
    ): BlissFrameLayout? {
        val parent = folderView.parent as? ViewGroup ?: return null
        val index = parent.indexOfChild(folderView)
        val fromDock = folderWasFromDock || parent === mDock
        val pageIndex = (parent as? GridLayout)
            ?.let { pages.indexOf(it) }
            ?.takeIf { it >= 0 }
            ?: getCurrentAppsPageNumber()

        remainingItem.container = if (fromDock) {
            Constants.CONTAINER_HOTSEAT.toLong()
        } else {
            Constants.CONTAINER_DESKTOP.toLong()
        }
        remainingItem.screenId = if (fromDock) -1 else pageIndex.toLong()
        remainingItem.cell = if (fromDock) {
            index.takeIf { it != LauncherItem.INVALID_CELL } ?: folder.cell
        } else {
            folder.cell.takeIf { it != LauncherItem.INVALID_CELL } ?: index
        }

        val replacementView = prepareLauncherItem(remainingItem)
        folderView.clearAnimation()
        removeUninstallIcon(folderView)
        parent.removeView(folderView)
        if (parent === mDock) {
            addAppToDock(replacementView, index)
        } else if (parent is GridLayout) {
            addAppToGrid(parent, replacementView, index)
            relayoutHomePageCells(parent)
        }
        if (shouldWobble) {
            makeAppWobble(replacementView, true, parent.indexOfChild(replacementView))
        }
        launcherLayoutRepository.removeLauncherItem(folder.id)
        return replacementView
    }

    private fun collapseFolderToRemainingItem(
        folder: FolderItem,
        folderView: BlissFrameLayout,
        folderWasFromDock: Boolean,
        shouldWobble: Boolean = false
    ): BlissFrameLayout? {
        val items = mutableFolderItems(folder)
        val remainingItem = items.firstOrNull() ?: return null
        items.remove(remainingItem)
        mFolderAppsViewPager.adapter?.notifyDataSetChanged()
        return replaceFolderWithRemainingItem(
            folder = folder,
            folderView = folderView,
            remainingItem = remainingItem,
            folderWasFromDock = folderWasFromDock,
            shouldWobble = shouldWobble
        )
    }

    private fun updateFolder() {
        mFolderAppsViewPager.adapter?.notifyDataSetChanged()
        val folder = activeFolder ?: return
        val folderView = activeFolderView ?: return
        val items = folder.items!!
        when (FolderDragSessionPolicy.folderResultAfterRemovingItem(items.size)) {
            FolderDragSessionPolicy.FolderResultAfterRemovingItem.REMOVE_FOLDER -> {
                removeFolderView(folder, folderView)
                hideFolderWindowContainer()
            }
            FolderDragSessionPolicy.FolderResultAfterRemovingItem.REPLACE_WITH_REMAINING_ITEM -> {
                collapseFolderToRemainingItem(folder, folderView, folderFromDock)
                hideFolderWindowContainer()
            }
            FolderDragSessionPolicy.FolderResultAfterRemovingItem.KEEP_FOLDER -> {
                updateIcon(folderView, folder, GraphicsUtil(this).generateFolderIcon(this, folder), folderFromDock)
                hideFolderWindowContainer()
            }
        }
    }

    private fun updateFolderInGrid(grid: GridLayout, folderItem: FolderItem, folderIndex: Int) {
        if (folderIndex !in 0 until grid.childCount) {
            return
        }
        when (FolderDragSessionPolicy.folderResultAfterRemovingItem(folderItem.items!!.size)) {
            FolderDragSessionPolicy.FolderResultAfterRemovingItem.REMOVE_FOLDER -> {
                grid.removeViewAt(folderIndex)
                launcherLayoutRepository.removeLauncherItem(folderItem.id)
            }
            FolderDragSessionPolicy.FolderResultAfterRemovingItem.REPLACE_WITH_REMAINING_ITEM -> {
                val folderView = grid.getChildAt(folderIndex) as? BlissFrameLayout
                if (folderView == null) {
                    grid.removeViewAt(folderIndex)
                    launcherLayoutRepository.removeLauncherItem(folderItem.id)
                    return
                }
                collapseFolderToRemainingItem(folderItem, folderView, grid is DockGridLayout)
            }
            FolderDragSessionPolicy.FolderResultAfterRemovingItem.KEEP_FOLDER -> {
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
                            refreshOpenFolderLiquidGlassIfNeeded()
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
                val viewGroup = gridLayout.getChildAt(j) as? BlissFrameLayout ?: continue
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
        lastLauncherItems = launcherItems
        appliedHiddenAppIds = readHiddenAppIds()
        mProgressBar.visibility = GONE
        if (isWobbling) {
            handleWobbling(false)
        }
        createUI(visibleLauncherItemsForHome(launcherItems))
        isUiDone = true
        createPageChangeListener()
        createFolderTitleListener()
        createDragListener()
        createWidgetsPage()
        createIndicator()
        restorePendingReloadPageIfNeeded()
        createOrUpdateBadgeCount()
        allAppsDisplayed = true
        if (events == null) {
            subscribeToEvents()
        }
        revealPendingInstalledAppIfReady()
    }

    private fun restorePendingReloadPageIfNeeded() {
        val requestedPage = pendingReloadPage ?: return
        pendingReloadPage = null
        val restoredPage = LauncherReloadPagePolicy.restoredPage(
            requestedPage = requestedPage,
            homePageCount = pages.size,
            hasAppLibraryPage = appLibraryPage != null
        )
        currentPageNumber = restoredPage
        mHorizontalPager.setCurrentPage(restoredPage)
        updateWorkspaceChromeForPage(restoredPage)
        if (restoredPage == WIDGET_PAGE) {
            hideWidgetPageIndicator()
        } else if (isHomePage(restoredPage)) {
            refreshPageIndicator()
        }
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
                val viewGroup = gridLayout.getChildAt(j) as? BlissFrameLayout ?: continue
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
        mFolderTitleInput.isFocusable = true
        mFolderTitleInput.isFocusableInTouchMode = true
        mFolderTitleInput.setOnFocusChangeListener { v, hasFocus ->
            applyFolderTitleInputState(hasFocus)
            if (!hasFocus) {
                updateFolderTitle()
                hideKeyboard(v)
            } else {
                mFolderTitleInput.setSelection(mFolderTitleInput.text?.length ?: 0)
            }
            mFolderTitleInput.isCursorVisible = hasFocus
        }
        mFolderTitleInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                updateFolderTitle()
                mFolderTitleInput.clearFocus()
                hideKeyboard(mFolderTitleInput)
                return@setOnEditorActionListener true
            }
            false
        }
        mFolderTitleInput.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP &&
                LauncherFolderTitlePolicy.shouldHandleTitleTap(mFolderTitleInput.hasFocus())
            ) {
                focusFolderTitleInput(moveCursorToEnd = true)
                return@setOnTouchListener true
            }
            false
        }
        mFolderTitleInput.setOnClickListener {
            focusFolderTitleInput(moveCursorToEnd = !mFolderTitleInput.hasFocus())
        }
        mFolderWindowContainer.setOnClickListener { returnToHomeScreen() }
    }

    private fun focusFolderTitleInput(moveCursorToEnd: Boolean) {
        val wasFocused = mFolderTitleInput.hasFocus()
        mFolderTitleInput.isFocusable = true
        mFolderTitleInput.isFocusableInTouchMode = true
        mFolderTitleInput.requestFocus()
        applyFolderTitleInputState(true)
        mFolderTitleInput.isCursorVisible = true
        if (moveCursorToEnd || !wasFocused) {
            mFolderTitleInput.setSelection(mFolderTitleInput.text?.length ?: 0)
        }
        showKeyboard(mFolderTitleInput)
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
        val updatedTitle = LauncherFolderTitlePolicy.storedTitle(mFolderTitleInput.text?.toString())
        val folder = activeFolder ?: return
        val folderView = activeFolderView ?: return
        folder.title = updatedTitle
        val tags = folderView.tag as List<*>
        (tags[1] as TextView).text = LauncherFolderTitlePolicy.homeTitle(
            rawTitle = updatedTitle,
            defaultFolderName = getString(R.string.folder_default_name)
        )
        val editableTitle = LauncherFolderTitlePolicy.editableText(updatedTitle)
        if (mFolderTitleInput.text?.toString() != editableTitle) {
            mFolderTitleInput.setText(editableTitle)
            mFolderTitleInput.setSelection(editableTitle.length)
        }
        applyFolderTitleInputState(mFolderTitleInput.hasFocus())
        mFolderTitleInput.isCursorVisible = false
        launcherLayoutRepository.saveLayouts(pages, mDock)
    }

    private fun bindFolderTitleInput(folder: FolderItem) {
        val editableTitle = LauncherFolderTitlePolicy.editableText(folder.title?.toString())
        mFolderTitleInput.setHintTextColor(Color.argb(150, 255, 255, 255))
        mFolderTitleInput.setTextColor(Color.argb(234, 255, 255, 255))
        mFolderTitleInput.setTypeface(Typeface.create("sans-serif-light", Typeface.NORMAL))
        mFolderTitleInput.setText(editableTitle)
        mFolderTitleInput.setSelection(editableTitle.length)
        applyFolderTitleInputState(false)
    }

    private fun applyFolderTitleInputState(hasFocus: Boolean) {
        val rawTitle = mFolderTitleInput.text?.toString()
        mFolderTitleInput.hint = LauncherFolderTitlePolicy.inputHint(
            rawTitle = rawTitle,
            hasFocus = hasFocus,
            unnamedHint = getString(R.string.folder_unnamed_hint)
        )
        mFolderTitleInput.setTextSize(
            TypedValue.COMPLEX_UNIT_SP,
            LauncherFolderTitlePolicy.inputTextSizeSp(
                rawTitle = rawTitle,
                hasFocus = hasFocus,
                normalSizeSp = folderTitleNormalTextSizeSp,
                hintSizeSp = FOLDER_UNNAMED_HINT_TEXT_SIZE_SP
            )
        )
    }

    private fun createPageChangeListener() {
        val navbarAnimator = createNavbarColorAnimator()

        mHorizontalPager.addOnScrollListener(object : HorizontalPager.OnScrollListener {
            var isViewScrolling = true

            override fun onScroll(scrollX: Int) {
                isViewScrolling = true
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
                mIndicator.translationY = LauncherSearchEntryPolicy.indicatorTranslationYForDockSlide(dockTranslationY)
                syncDockChromeTransform()
                syncIndicatorChromeTransform()

                if (scrollX >= 0 && scrollX < mDeviceProfile.availableWidthPx) {
                    val fraction = (mDeviceProfile.availableWidthPx - scrollX).toFloat() /
                        mDeviceProfile.availableWidthPx
                    setBlurLayersAlpha(fraction)
                }
                dragDropEnabled = false
            }

            override fun onViewScrollFinished(currentPage: Int) {
                val wasViewScrolling = isViewScrolling
                val pageChanged = currentPageNumber != currentPage
                isViewScrolling = false

                setBlurLayersAlpha(if (currentPage == 0 || mFolderWindowContainer.visibility == VISIBLE) 1f else 0f)

                if (pageChanged) {
                    val prevPage = currentPageNumber
                    currentPageNumber = currentPage
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
                if (currentPage == WIDGET_PAGE) {
                    hideWidgetPageIndicator()
                }
                if (
                    LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnSettledPage(
                        realtimeEnabled = shouldUseRealtimeLiquidGlass(),
                        wasScrolling = wasViewScrolling,
                        pageChanged = pageChanged
                    )
                ) {
                    refreshCurrentPageRealtimeLiquidGlass(
                        wasScrolling = wasViewScrolling,
                        pageChanged = pageChanged
                    )
                }
            }
        })
    }

    private fun refreshCurrentPageRealtimeLiquidGlass(
        wasScrolling: Boolean = true,
        pageChanged: Boolean = true
    ) {
        val realtimeEnabled = shouldUseRealtimeLiquidGlass()
        if (!realtimeEnabled || !::mHorizontalPager.isInitialized) {
            return
        }
        (mHorizontalPager.getChildAt(currentPageNumber) as? ViewGroup)?.let { page ->
            refreshRealtimeLiquidGlassDescendants(page)
        }
        postRefreshCurrentPageRealtimeLiquidGlass(currentPageNumber)
        if (
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeSurfaceOnSettledPage(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                realtimeEnabled = realtimeEnabled,
                wasScrolling = wasScrolling,
                pageChanged = pageChanged
            )
        ) {
            dockGlassBackground()?.refreshRealtimeLiquidGlass()
        }
        if (
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeSurfaceOnSettledPage(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.PAGE_INDICATOR,
                realtimeEnabled = realtimeEnabled,
                wasScrolling = wasScrolling,
                pageChanged = pageChanged
            )
        ) {
            indicatorGlassBackground()?.refreshRealtimeLiquidGlass()
        }
        if (isFolderWindowActive()) {
            refreshRealtimeLiquidGlassDescendants(mFolderWindowContainer)
        }
    }

    private fun postRefreshCurrentPageRealtimeLiquidGlass(pageNumber: Int) {
        mHorizontalPager.post {
            if (!shouldUseRealtimeLiquidGlass() || pageNumber != currentPageNumber) {
                return@post
            }
            (mHorizontalPager.getChildAt(pageNumber) as? ViewGroup)?.let { page ->
                refreshRealtimeLiquidGlassDescendants(page, realtimeEnabled = true)
            }
            if (isFolderWindowActive()) {
                refreshRealtimeLiquidGlassDescendants(mFolderWindowContainer, realtimeEnabled = true)
            }
        }
    }

    private fun refreshRealtimeLiquidGlassDescendants(
        viewGroup: ViewGroup,
        realtimeEnabled: Boolean = shouldUseRealtimeLiquidGlass()
    ) {
        for (index in 0 until viewGroup.childCount) {
            val child = viewGroup.getChildAt(index)
            if (
                child is SquareFrameLayout &&
                LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPreviewHostOnPageRestore(
                    realtimeEnabled = realtimeEnabled,
                    folderPreviewRealtimeEnabled = child.hasRealtimeLiquidGlassFolderPreview()
                )
            ) {
                child.refreshRealtimeLiquidGlassFolderPreview()
            }
            if (
                child is LauncherRealtimeLiquidGlassLayout &&
                LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeDescendant(
                    realtimeEnabled = realtimeEnabled,
                    descendantShown = child.isShown
                )
            ) {
                child.refreshRealtimeLiquidGlass()
            }
            if (child is ViewGroup) {
                refreshRealtimeLiquidGlassDescendants(child, realtimeEnabled)
            }
        }
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
        val suggestedAppsBinding = bindSuggestedAppsView(viewGroup) ?: return
        if (!SuggestedAppsViewPolicy.hasRequiredViews(
                suggestedAppsBinding.openUsageAccessSettings,
                suggestedAppsBinding.suggestedAppGrid
            )
        ) {
            return
        }
        val openUsageAccessSettings = suggestedAppsBinding.openUsageAccessSettings
        val suggestedAppsGrid = suggestedAppsBinding.suggestedAppGrid

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

    private fun bindSuggestedAppsView(viewGroup: ViewGroup): LayoutUsedAppsBinding? =
        runCatching { LayoutUsedAppsBinding.bind(viewGroup) }.getOrNull()

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
        loadHomeWidgets()
        val preferredNewItemPage = preferredHomePageForNewItem()

        pages = ArrayList()

        var hotseatCell = 0

        var workspaceScreen = preparePage()
        pages.add(workspaceScreen)

        mHorizontalPager.removeAllViews()
        mDock.removeAllViews()
        appLibraryPage = null
        var assignedNewLauncherItem = false

        for (launcherItem in launcherItems) {
            val appView = prepareLauncherItem(launcherItem)
            val isNewDesktopApp = isUnplacedLauncherApp(launcherItem)
            if (launcherItem.container == Constants.CONTAINER_HOTSEAT.toLong()) {
                addAppToDock(appView, launcherItem.cell)
                if (launcherItem.cell == -1) {
                    launcherItem.cell = hotseatCell
                    hotseatCell++
                } else {
                    hotseatCell = launcherItem.cell
                }
            } else if (launcherItem.container == Constants.CONTAINER_DESKTOP.toLong() || isNewDesktopApp) {
                if (isNewDesktopApp) {
                    launcherItem.container = Constants.CONTAINER_DESKTOP.toLong()
                    assignedNewLauncherItem = true
                }
                if (autoArrangeApps) {
                    var nextCell = (0 until mDeviceProfile.maxAppsPerPage)
                        .firstOrNull { it !in occupiedHomeCells(workspaceScreen) }
                    if (nextCell == null ||
                        (!isNewDesktopApp && launcherItem.screenId > pages.size - 1)
                    ) {
                        workspaceScreen = preparePage()
                        pages.add(workspaceScreen)
                        nextCell = (0 until mDeviceProfile.maxAppsPerPage)
                            .firstOrNull { it !in occupiedHomeCells(workspaceScreen) }
                    }
                    launcherItem.screenId = (pages.size - 1).toLong()
                    launcherItem.cell = nextCell ?: workspaceScreen.childCount
                } else {
                    val placement = if (isNewDesktopApp) {
                        LauncherHomeCellPolicy.newItemPlacement(
                            preferredPage = preferredNewItemPage,
                            existingPageCount = pages.size,
                            occupiedCellsByPage = occupiedHomeCellsByPage(),
                            maxCells = mDeviceProfile.maxAppsPerPage
                        )
                    } else {
                        val pageIndex = launcherItem.screenId.toInt().coerceAtLeast(0)
                        LauncherHomeCellPolicy.resolvePageCell(
                            preferredPage = pageIndex,
                            preferredCell = launcherItem.cell,
                            occupiedCellsByPage = occupiedHomeCellsByPage(),
                            maxCells = mDeviceProfile.maxAppsPerPage
                        )
                    }
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
        renderHomeWidgets()
        updateWidgetWeatherPermissionState(fetchIfNeeded = true)
        appLibraryApps = collectAppLibraryApps(launcherItems)
        createAppLibraryPage()
        currentPageNumber = 0

        mHorizontalPager.setUiCreated(true)
        mDock.isEnabled = true
        setUpSwipeSearchContainer()
        if (assignedNewLauncherItem) {
            launcherLayoutRepository.saveLayouts(pages, mDock)
        }
    }

    private fun isUnplacedLauncherApp(launcherItem: LauncherItem): Boolean {
        return launcherItem.itemType == Constants.ITEM_TYPE_APPLICATION &&
            launcherItem.container != Constants.CONTAINER_DESKTOP.toLong() &&
            launcherItem.container != Constants.CONTAINER_HOTSEAT.toLong()
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
        val grid = AppsPageBinding.inflate(layoutInflater).root
        grid.rowCount = mDeviceProfile.numRows
        grid.columnCount = mDeviceProfile.numColumns
        grid.layoutTransition = getDefaultLayoutTransition()
        applyHomePageGridPadding(grid, isWobbling)

        grid.setOnClickListener {
            if (
                HomeWidgetEditStatePolicy.shouldHideEntryCardOnHomeTap(
                    editing = isWobbling,
                    entryCardVisible = homeWidgetEntryCard != null
                )
            ) {
                hideHomeWidgetEntryCard()
            } else if (
                HomeWidgetEditStatePolicy.shouldExitEditModeOnHomeTap(
                    editing = isWobbling,
                    entryCardVisible = homeWidgetEntryCard != null
                )
            ) {
                handleWobbling(false)
            } else if (!isWobbling) {
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
        val pageBinding = WidgetsPageBinding.inflate(layoutInflater, mHorizontalPager, false)
        widgetsPageBinding = pageBinding
        widgetsPage = pageBinding.root
        val page = pageBinding.root
        page.clipChildren = false
        page.clipToPadding = false
        widgetContainer = pageBinding.widgetContainer
        val todayWidgetDragListener = View.OnDragListener { source, event ->
            handleTodayWidgetDragEvent(source, event)
        }
        pageBinding.dragLayer.apply {
            clipChildren = false
            clipToPadding = false
            setOnDragListener(todayWidgetDragListener)
        }
        pageBinding.widgetsScrollContainer.apply {
            clipChildren = false
            clipToPadding = false
        }
        loadTodayQuickWidgets()
        renderTodayWidgets()
        mHorizontalPager.addView(page, 0)
        page.setOnDragListener(todayWidgetDragListener)
        val scrollView = pageBinding.widgetsScrollContainer
        scrollView.setOnTouchListener { _, _ ->
            if (pageBinding.widgetResizerContainer.visibility == VISIBLE) {
                hideWidgetResizeContainer()
            }
            false
        }
        currentPageNumber = 1
        mHorizontalPager.setCurrentPage(currentPageNumber)

        widgetContainer.setOnDragListener(todayWidgetDragListener)

        pageBinding.editWidgetsButton.setOnClickListener {
            setTodayWidgetEditing(true)
        }
        pageBinding.addTodayWidgetButton.setOnClickListener {
            showTodayWidgetPicker()
        }
        pageBinding.doneTodayWidgetEditButton.setOnClickListener {
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
        val realtimeGlassEnabled = shouldUseRealtimeLiquidGlass()
        val searchStyle = LauncherLiquidGlassStylePolicy.searchField(
            enabled = realtimeGlassEnabled,
            darkMode = styleDarkModeForLiquidGlass(),
            liquidGlass = realtimeGlassEnabled
        )
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            background = roundedRectangle(searchStyle)
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
        }
        return glassContainer(
            style = searchStyle,
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.APP_LIBRARY_SEARCH,
            content = content
        ).apply {
            isClickable = true
            isFocusable = true
            setOnClickListener { showAppLibrarySearchOverlay() }
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

    private fun glassContainer(
        style: LauncherLiquidGlassStylePolicy.BackgroundStyle,
        surface: LauncherRealtimeLiquidGlassPolicy.Surface,
        content: View
    ): FrameLayout {
        val realtimeGlassEnabled = shouldUseRealtimeLiquidGlass()
        val container = if (liquidGlassEnabled || darkModeEnabled) {
            LauncherRealtimeLiquidGlassLayout(this).apply {
                blurCornerRadius = dp(style.radiusDp).toFloat()
                applyRealtimeLiquidGlass(
                    enabled = realtimeGlassEnabled,
                    source = realtimeLiquidGlassSource(),
                    surface = surface,
                    profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
                        surface = surface,
                        radiusDp = style.radiusDp,
                        darkMode = styleDarkModeForLiquidGlass()
                    )
                )
            }
        } else {
            FrameLayout(this)
        }
        if (container is LauncherRealtimeLiquidGlassLayout && realtimeGlassEnabled) {
            container.background = if (
                LauncherRealtimeLiquidGlassPolicy.shouldUseStableMaterialBehindRealtimeGlass(
                    surface = surface,
                    realtimeEnabled = true
                )
            ) {
                roundedRectangle(style)
            } else {
                null
            }
            content.background = if (
                LauncherRealtimeLiquidGlassPolicy.shouldUseTransparentSurfaceBackground(
                    surface = surface,
                    realtimeLiquidGlassActive = container.isRealtimeLiquidGlassActive(),
                    realtimeEnabled = true
                )
            ) {
                ColorDrawable(Color.TRANSPARENT)
            } else {
                roundedRectangle(style)
            }
        }
        container.clipToOutline = true
        container.addView(
            content,
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        return container
    }

    private fun createAppLibraryGroupView(group: AppLibraryGroup<ApplicationItem>): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            setPadding(dp(0), 0, dp(0), 0)

            val realtimeGlassEnabled = shouldUseRealtimeLiquidGlass()
            val folderStyle = LauncherLiquidGlassStylePolicy.appLibraryFolder(
                enabled = realtimeGlassEnabled,
                empty = group.apps.isEmpty(),
                darkMode = styleDarkModeForLiquidGlass(),
                liquidGlass = realtimeGlassEnabled
            )
            val cardContent = FrameLayout(context).apply {
                background = roundedRectangle(folderStyle)
                addView(
                    createAppLibraryPreviewGrid(group),
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                )
            }
            val folderCard = glassContainer(
                style = folderStyle,
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
                content = cardContent
            ).apply {
                clipToOutline = true
                isClickable = group.apps.isNotEmpty()
                isFocusable = group.apps.isNotEmpty()
                if (group.apps.isNotEmpty()) {
                    setOnClickListener { showAppLibraryCategory(group) }
                }
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

    private fun createAppLibraryIconView(
        app: ApplicationItem?,
        onClick: ((View, ApplicationItem) -> Unit)? = null
    ): ImageView {
        return SquareImageView(this).apply {
            iconContentScale = AppLibraryIconRenderPolicy.iconContentScale
            visibility = if (app == null) View.INVISIBLE else VISIBLE
            setImageDrawable(app?.icon)
            contentDescription = app?.title?.toString()
            scaleType = ImageView.ScaleType.FIT_CENTER
            if (app != null && onClick != null) {
                isClickable = true
                isFocusable = true
                setOnClickListener { view -> onClick(view, app) }
            }
        }
    }

    private fun createAppLibraryPreviewIcon(app: ApplicationItem?): View {
        return createAppLibraryIconView(app) { view, clickedApp ->
            startActivitySafely(applicationContext, clickedApp, view)
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
                                createAppLibraryIconView(app) { view, clickedApp ->
                                    startActivitySafely(applicationContext, clickedApp, view)
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

    private fun addDarkModeOverlayIfNeeded(parent: FrameLayout) {
        if (!darkModeEnabled) {
            return
        }
        parent.addView(
            View(this).apply {
                setBackgroundColor(0x33000000)
            },
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
    }

    private fun showAppLibraryCategory(group: AppLibraryGroup<ApplicationItem>) {
        if (group.apps.isEmpty()) return
        hideAppLibrarySearchOverlay(animated = false)
        hideAppLibraryDetailOverlay(animated = false)
        appLibraryPage?.visibility = AppLibrarySearchVisibilityPolicy.detailPageVisibility(detailVisible = true)
        mHorizontalPager.visibility = AppLibrarySearchVisibilityPolicy.detailPageVisibility(detailVisible = true)

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
        addDarkModeOverlayIfNeeded(overlay)

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
                createAppLibraryIconView(app),
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
            appLibraryPage?.visibility = AppLibrarySearchVisibilityPolicy.detailPageVisibility(detailVisible = false)
            mHorizontalPager.visibility = AppLibrarySearchVisibilityPolicy.detailPageVisibility(detailVisible = false)
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
        appLibraryPage?.visibility = AppLibrarySearchVisibilityPolicy.pageVisibility(searchVisible = true)
        mHorizontalPager.visibility = AppLibrarySearchVisibilityPolicy.pageVisibility(searchVisible = true)

        val overlay = FrameLayout(this).apply {
            alpha = 0f
            isClickable = true
            isFocusable = true
            setBackgroundColor(AppLibrarySearchVisibilityPolicy.overlayBackgroundColor())
        }
        appLibrarySearchOverlay = overlay

        overlay.addView(
            BlurBackgroundView(this, null),
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        addDarkModeOverlayIfNeeded(overlay)

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

    private fun createAppLibrarySearchField(): View {
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

        val realtimeGlassEnabled = shouldUseRealtimeLiquidGlass()
        val fieldStyle = LauncherLiquidGlassStylePolicy.searchField(
            enabled = realtimeGlassEnabled,
            darkMode = styleDarkModeForLiquidGlass(),
            liquidGlass = realtimeGlassEnabled
        )
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = roundedRectangle(fieldStyle)
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
        return glassContainer(
            style = fieldStyle,
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.APP_LIBRARY_SEARCH,
            content = content
        )
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
                createAppLibraryIconView(app),
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
            appLibraryPage?.visibility = AppLibrarySearchVisibilityPolicy.pageVisibility(searchVisible = false)
            mHorizontalPager.visibility = AppLibrarySearchVisibilityPolicy.pageVisibility(searchVisible = false)
            refreshAppLibraryRealtimeAfterSearchDismiss()
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

    private fun refreshAppLibraryRealtimeAfterSearchDismiss() {
        val page = appLibraryPage ?: return
        if (
            !LauncherRealtimeLiquidGlassPolicy.shouldRefreshAppLibraryRealtimeOnSearchDismiss(
                realtimeEnabled = shouldUseRealtimeLiquidGlass(),
                pageVisible = page.visibility == VISIBLE && mHorizontalPager.visibility == VISIBLE
            )
        ) {
            return
        }
        refreshRealtimeLiquidGlassDescendants(page, realtimeEnabled = true)
        page.post {
            if (
                LauncherRealtimeLiquidGlassPolicy.shouldRefreshAppLibraryRealtimeOnSearchDismiss(
                    realtimeEnabled = shouldUseRealtimeLiquidGlass(),
                    pageVisible = page.visibility == VISIBLE && mHorizontalPager.visibility == VISIBLE
                )
            ) {
                refreshRealtimeLiquidGlassDescendants(page, realtimeEnabled = true)
            }
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
        return launcherAppLibraryPreferencesRepository.getAllPreferences()
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

    private fun roundedRectangle(style: LauncherLiquidGlassStylePolicy.BackgroundStyle): Drawable =
        LauncherLiquidGlassDrawableFactory.create(this, style)

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

    private fun selectableItemBackground(): Drawable? {
        val typedValue = TypedValue()
        return if (theme.resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true)) {
            getDrawable(typedValue.resourceId)
        } else {
            null
        }
    }

    private fun readHiddenAppIds(): Set<String> {
        val currentHiddenIds = hiddenValuesFromPreferenceValue(
            launcherHiddenAppsPreferencesRepository.getHiddenIdsValue()
        )
        val legacyHiddenIds = hiddenValuesFromPreferenceValue(
            launcherHiddenAppsPreferencesRepository.getLegacyHiddenIdsValue()
        )
        return currentHiddenIds + legacyHiddenIds
    }

    private fun hiddenValuesFromPreferenceValue(value: Any?): Set<String> {
        return when (value) {
            is String -> value.split(HIDDEN_APPS_PREF_SEPARATOR)
                .map { hiddenKey -> hiddenKey.trim() }
                .filter { hiddenKey -> hiddenKey.isNotEmpty() }
                .toSet()
            is Set<*> -> value.mapNotNull { hiddenKey -> hiddenKey as? String }
                .map { hiddenKey -> hiddenKey.trim() }
                .filter { hiddenKey -> hiddenKey.isNotEmpty() }
                .toSet()
            else -> emptySet()
        }
    }

    private fun saveHiddenAppIds(ids: Set<String>) {
        launcherHiddenAppsPreferencesRepository.saveHiddenIdsValue(
            ids.joinToString(HIDDEN_APPS_PREF_SEPARATOR)
        )
        launcherHiddenAppsPreferencesRepository.clearLegacyHiddenIds()
    }

    private fun setAppHidden(app: ApplicationItem, hidden: Boolean): Boolean {
        val hiddenIds = LinkedHashSet(readHiddenAppIds())
        val hiddenKey = HiddenAppsPolicy.hiddenKeyFor(app)
        val changed = if (hidden) {
            hiddenIds.add(hiddenKey)
        } else {
            hiddenIds.remove(hiddenKey)
        }
        if (!changed) {
            return false
        }
        saveHiddenAppIds(hiddenIds)
        hiddenAppsChanged = true
        return true
    }

    private fun hideLauncherAppFromHome(app: ApplicationItem) {
        if (setAppHidden(app, hidden = true)) {
            pendingReloadPage = currentPageNumber
            hiddenAppsChanged = false
            forceReload()
        }
    }

    private fun visibleLauncherItemsForHome(launcherItems: List<LauncherItem>): List<LauncherItem> {
        val hiddenIds = readHiddenAppIds()
        val graphicsUtil = GraphicsUtil(this)
        return LauncherVisibleHomeItemsPolicy.visibleItems(
            launcherItems = launcherItems,
            hiddenAppIds = hiddenIds
        ) { folder ->
            runCatching { folder.icon = graphicsUtil.generateFolderIcon(this, folder) }
        }
    }

    private fun showHiddenAppsPanel() {
        hideHiddenAppsPanel(reloadIfChanged = false)
        dismissLauncherOptionsPopup()

        val allApps = if (lastLauncherItems.isNotEmpty()) {
            HiddenAppsPolicy.uniqueAppsFromLauncherItems(lastLauncherItems)
        } else {
            appLibraryApps
        }
        if (allApps.isEmpty()) {
            Toast.makeText(this, R.string.settings_no_apps_found, Toast.LENGTH_SHORT).show()
            return
        }

        val backgroundColor = if (darkModeEnabled) Color.BLACK else LauncherRenameUiPolicy.PAGE_BACKGROUND_COLOR
        val toolbarColor = if (darkModeEnabled) 0xFF1C1C1E.toInt() else LauncherRenameUiPolicy.TOOLBAR_COLOR
        val rowColor = if (darkModeEnabled) 0xFF1C1C1E.toInt() else backgroundColor
        val primaryTextColor = if (darkModeEnabled) Color.WHITE else LauncherRenameUiPolicy.PRIMARY_TEXT_COLOR
        val secondaryTextColor = if (darkModeEnabled) 0xFFEAEAEE.toInt() else LauncherRenameUiPolicy.SECONDARY_TEXT_COLOR
        val sectionTextColor = if (darkModeEnabled) 0xFF8E8E93.toInt() else LauncherRenameUiPolicy.SECTION_HEADER_COLOR
        val dividerColor = if (darkModeEnabled) 0xFF38383A.toInt() else LauncherRenameUiPolicy.DIVIDER_COLOR

        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(backgroundColor)
            layoutTransition = LayoutTransition().apply {
                enableTransitionType(LayoutTransition.CHANGING)
            }
        }

        fun renderSections() {
            renderHiddenAppsSections(
                content = content,
                apps = allApps,
                rowColor = rowColor,
                primaryTextColor = primaryTextColor,
                secondaryTextColor = secondaryTextColor,
                sectionTextColor = sectionTextColor,
                dividerColor = dividerColor,
                onChanged = { renderSections() }
            )
        }

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
                        setTextColor(LauncherRenameUiPolicy.ACCENT_COLOR)
                        textSize = 20f
                        gravity = Gravity.CENTER_VERTICAL
                        includeFontPadding = false
                        setOnClickListener { hideHiddenAppsPanel() }
                    },
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        dp(LauncherRenameUiPolicy.TOOLBAR_ROW_HEIGHT_DP),
                        Gravity.START or Gravity.BOTTOM
                    ).apply {
                        leftMargin = dp(14)
                    }
                )
                addView(
                    TextView(context).apply {
                        text = getString(R.string.hidden_apps_title)
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
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(LauncherRenameUiPolicy.TOOLBAR_HEIGHT_DP))
        )
        panel.addView(
            View(this).apply { setBackgroundColor(dividerColor) },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
        )
        panel.addView(
            ScrollView(this).apply {
                overScrollMode = View.OVER_SCROLL_IF_CONTENT_SCROLLS
                setBackgroundColor(backgroundColor)
                addView(
                    content,
                    ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                )
            },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
        )

        hiddenAppsPanel = panel
        (mLauncherView as? ViewGroup)?.addView(
            panel,
            RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        renderSections()
    }

    private fun renderHiddenAppsSections(
        content: LinearLayout,
        apps: List<ApplicationItem>,
        rowColor: Int,
        primaryTextColor: Int,
        secondaryTextColor: Int,
        sectionTextColor: Int,
        dividerColor: Int,
        onChanged: () -> Unit
    ) {
        val sections = HiddenAppsPolicy.sections(apps, readHiddenAppIds())
        content.removeAllViews()
        content.addView(createHiddenAppsSectionHeader(getString(R.string.hidden_apps_section_hidden), sectionTextColor))
        val hiddenContainer = createHiddenAppsRowsContainer(rowColor)
        sections.hidden.forEach { app ->
            hiddenContainer.addView(
                createHiddenAppsRow(
                    app = app,
                    hidden = true,
                    rowColor = rowColor,
                    primaryTextColor = primaryTextColor,
                    secondaryTextColor = secondaryTextColor,
                    dividerColor = dividerColor,
                    onChanged = onChanged
                )
            )
        }
        content.addView(hiddenContainer)

        content.addView(createHiddenAppsSectionHeader(getString(R.string.hidden_apps_section_apps), sectionTextColor))
        val visibleContainer = createHiddenAppsRowsContainer(rowColor)
        sections.visible.forEach { app ->
            visibleContainer.addView(
                createHiddenAppsRow(
                    app = app,
                    hidden = false,
                    rowColor = rowColor,
                    primaryTextColor = primaryTextColor,
                    secondaryTextColor = secondaryTextColor,
                    dividerColor = dividerColor,
                    onChanged = onChanged
                )
            )
        }
        content.addView(visibleContainer)
    }

    private fun createHiddenAppsRowsContainer(rowColor: Int): LinearLayout =
        LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(rowColor)
            layoutTransition = LayoutTransition().apply {
                enableTransitionType(LayoutTransition.CHANGING)
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
        }.also { header ->
            header.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(50))
        }
    }

    private fun createHiddenAppsRow(
        app: ApplicationItem,
        hidden: Boolean,
        rowColor: Int,
        primaryTextColor: Int,
        secondaryTextColor: Int,
        dividerColor: Int,
        onChanged: () -> Unit
    ): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(rowColor)
            addView(
                LinearLayout(context).apply {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL
                    setPadding(dp(24), 0, dp(24), 0)

                    addView(
                        createHiddenAppsToggleButton(hidden).apply {
                            setOnClickListener {
                                setAppHidden(app, hidden = !hidden)
                                animate()
                                    .scaleX(0.78f)
                                    .scaleY(0.78f)
                                    .setDuration(70L)
                                    .withEndAction {
                                        animate()
                                            .scaleX(1f)
                                            .scaleY(1f)
                                            .setDuration(110L)
                                            .withEndAction { onChanged() }
                                            .start()
                                    }
                                    .start()
                            }
                        },
                        LinearLayout.LayoutParams(dp(32), dp(32))
                    )

                    addView(
                        ImageView(context).apply {
                            setImageDrawable(app.icon)
                            scaleType = ImageView.ScaleType.FIT_CENTER
                            clipToOutline = true
                        },
                        LinearLayout.LayoutParams(dp(44), dp(44)).apply {
                            leftMargin = dp(18)
                        }
                    )

                    addView(
                        TextView(context).apply {
                            text = app.title
                            setTextColor(if (hidden) primaryTextColor else secondaryTextColor)
                            textSize = 18f
                            maxLines = 1
                            ellipsize = TextUtils.TruncateAt.END
                            includeFontPadding = false
                            gravity = Gravity.CENTER_VERTICAL
                        },
                        LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f).apply {
                            leftMargin = dp(18)
                        }
                    )
                },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(64))
            )
            addView(
                View(context).apply { setBackgroundColor(dividerColor) },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1).apply {
                    leftMargin = dp(110)
                }
            )
        }
    }

    private fun createHiddenAppsToggleButton(hidden: Boolean): TextView {
        return TextView(this).apply {
            text = if (hidden) "\u2212" else "+"
            setTextColor(Color.WHITE)
            textSize = 30f
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
            includeFontPadding = false
            background = roundedRectangle(
                color = if (hidden) 0xFFFF453A.toInt() else 0xFF34C759.toInt(),
                radiusDp = 16
            )
            isClickable = true
            isFocusable = true
        }
    }

    private fun hideHiddenAppsPanel(reloadIfChanged: Boolean = true) {
        val panel = hiddenAppsPanel ?: return
        hiddenAppsPanel = null
        (panel.parent as? ViewGroup)?.removeView(panel)
        if (reloadIfChanged && hiddenAppsChanged) {
            hiddenAppsChanged = false
            forceReload()
        }
    }

    private fun rebindWidgetHost() {
        val widgetIds = mAppWidgetHost.appWidgetIds
        compositeDisposableBag.add(
            launcherLayoutRepository.getWidgets(widgetIds)
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
        } else if (requestCode == REQUEST_HOME_BIND_APPWIDGET) {
            val appWidgetId = data?.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, pendingHomeSystemWidgetId)
                ?: pendingHomeSystemWidgetId
            if (resultCode == RESULT_OK && appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                handleHomeSystemWidgetBound(appWidgetId)
            } else if (appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                mAppWidgetHost.deleteAppWidgetId(appWidgetId)
                pendingHomeSystemWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
            }
        } else if (requestCode == REQUEST_HOME_CREATE_APPWIDGET) {
            val appWidgetId = data?.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, pendingHomeSystemWidgetId)
                ?: pendingHomeSystemWidgetId
            if (resultCode == RESULT_OK && appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                createHomeSystemWidget(appWidgetId)
            } else if (appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                mAppWidgetHost.deleteAppWidgetId(appWidgetId)
                pendingHomeSystemWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
            }
        } else if (requestCode == REQUEST_HOME_WIDGET_PHOTO_PICK) {
            if (resultCode == RESULT_OK) {
                handleHomeWidgetPhotoResult(data)
            } else {
                pendingPhotoWidgetId = null
            }
        } else if (requestCode == REQUEST_UNINSTALL_APP) {
            handleApplicationUninstallResult(resultCode)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode != WEATHER_LOCATION_PERMISSION_REQUEST) {
            return
        }
        if (grantResults.firstOrNull() == PackageManager.PERMISSION_GRANTED) {
            openWeatherDetailAfterRefresh = true
            refreshWeatherForecast(force = true)
        } else {
            openWeatherDetailAfterRefresh = false
            setWeatherWidgetState(WeatherWidgetUiState.PermissionRequired)
            Toast.makeText(this, R.string.toast_permission_denied, Toast.LENGTH_SHORT).show()
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
                val blissFrameLayout = gridLayout.getChildAt(i) as? BlissFrameLayout ?: continue
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
        launcherSearchController.selectSuggestion(suggestion) { query ->
            runSearch(query)
        }
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
        if (pages.contains(page)) {
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
        AppViewBinding.bind(view).appLabel.visibility = VISIBLE
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
        AppViewBinding.bind(view).appLabel.visibility = VISIBLE
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
        val pageIndex = pages.indexOf(page)
        val compactCells = LauncherHomeCellPolicy.shouldCompactCells(
            autoArrangeEnabled = isAutoRearrangeAppsEnabled(),
            forceCompact = compact
        )
        var compactCursor = 0
        for (index in 0 until page.childCount) {
            val child = page.getChildAt(index)
            val homeWidgetItem = child.tag as? HomeWidgetPreferences.Item
            if (homeWidgetItem != null) {
                val placement = HomeWidgetPlacementPolicy.placementForDropCell(
                    dropCell = homeWidgetItem.cell,
                    size = homeWidgetItem.size,
                    columns = page.columnCount,
                    maxCells = mDeviceProfile.maxAppsPerPage,
                    occupiedCells = occupiedCells
                )
                if (placement != null) {
                    homeWidgetItem.cell = placement.anchorCell
                    occupiedCells.addAll(placement.occupiedCells)
                    applyHomeWidgetLayoutParams(page, child, homeWidgetItem)
                }
                continue
            }

            val appChild = child as? BlissFrameLayout ?: continue
            val cell = if (compactCells) {
                val nextCell = (compactCursor until mDeviceProfile.maxAppsPerPage)
                    .firstOrNull { it !in occupiedCells }
                    ?: LauncherItem.INVALID_CELL
                compactCursor = nextCell + 1
                nextCell
            } else {
                LauncherHomeCellPolicy.resolveCell(
                    preferredCell = appChild.launcherItem.cell,
                    requestedIndex = LauncherItem.INVALID_CELL,
                    occupiedCells = occupiedCells,
                    maxCells = mDeviceProfile.maxAppsPerPage
                )
            }
            if (cell == LauncherItem.INVALID_CELL) {
                continue
            }
            occupiedCells.add(cell)
            applyHomeCellLayoutParams(page, appChild, cell, mDeviceProfile.cellWidthPx)
        }
        page.requestLayout()
    }

    private fun occupiedHomeCells(
        page: GridLayout,
        except: BlissFrameLayout? = null,
        exceptHomeWidgetId: String? = null
    ): Set<Int> {
        val occupiedCells = mutableSetOf<Int>()
        val maxCells = mDeviceProfile.maxAppsPerPage
        val pageIndex = pages.indexOf(page)
        occupiedCells.addAll(homeWidgetOccupiedCellsForPage(pageIndex, exceptHomeWidgetId))
        for (index in 0 until page.childCount) {
            val child = page.getChildAt(index)
            if (child === except || child.tag is HomeWidgetPreferences.Item) {
                continue
            }
            val appChild = child as? BlissFrameLayout ?: continue
            val cell = appChild.launcherItem.cell
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
        return pages.indices.associateWith { index ->
            occupiedHomeCells(pages[index]) + homeWidgetOccupiedCellsForPage(index)
        }
    }

    private fun isAutoRearrangeAppsEnabled(): Boolean {
        return LauncherHomeLayoutPreferences.isAutoRearrangeAppsEnabled(this)
    }

    private fun addAppToDock(view: BlissFrameLayout, index: Int) {
        AppViewBinding.bind(view).appLabel.visibility = GONE
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
        val iconBinding = AppViewBinding.inflate(layoutInflater)
        val iconView = iconBinding.root
        iconView.launcherItem = launcherItem
        val icon = iconBinding.appIcon
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
                        val dragStarted = icon.startDragAndDrop(null, dragShadowBuilder, iconView, 0)
                        if (dragStarted) {
                            updateDragEdgeGlows(true)
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
                        } else {
                            updateDragEdgeGlows(false)
                            movingApp = null
                            dragShadowBuilder = null
                        }
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
            when (LauncherEditModeEntryPolicy.tapAction(launcherItem.itemType, isWobbling)) {
                LauncherEditModeEntryPolicy.TapAction.IGNORE -> Unit
                LauncherEditModeEntryPolicy.TapAction.LAUNCH_ITEM -> {
                    startActivitySafely(applicationContext, launcherItem, view)
                }
                LauncherEditModeEntryPolicy.TapAction.OPEN_FOLDER -> {
                    folderFromDock = !((iconView.parent as View).parent is HorizontalPager)
                    displayFolder(launcherItem as FolderItem, iconView)
                }
            }
        }

        return iconView
    }

    private fun showLauncherOptionsPopup(launcherItem: LauncherItem, iconView: BlissFrameLayout, anchor: View) {
        dismissLauncherOptionsPopup()

        val appShortcuts = queryLauncherAppShortcuts(launcherItem)
        val canHideApp = launcherItem is ApplicationItem
        val menu = createLauncherOptionsMenu(
            launcherItem = launcherItem,
            iconView = iconView,
            anchor = anchor,
            appShortcuts = appShortcuts,
            canHideApp = canHideApp
        )
        val popupWidth = dp(LauncherAppOptionsMenuPolicy.POPUP_WIDTH_DP)
        val selectedIconBounds = launcherOptionsSelectedIconBounds(anchor)
        val availableHeight = launcherOptionsAvailableHeight(selectedIconBounds)
        val popupHeight = LauncherAppOptionsMenuPolicy.popupHeightPx(
            rowCount = appShortcuts.size + LauncherAppOptionsMenuPolicy.systemOptions(canHideApp).size,
            rowHeightPx = dp(LauncherAppOptionsMenuPolicy.ROW_HEIGHT_DP),
            verticalPaddingPx = dp(LauncherAppOptionsMenuPolicy.VERTICAL_PADDING_DP),
            dividerHeightPx = LauncherAppOptionsMenuPolicy.DIVIDER_HEIGHT_PX,
            availableHeightPx = availableHeight
        )
        val popupContent = ScrollView(this).apply {
            isFillViewport = false
            overScrollMode = View.OVER_SCROLL_IF_CONTENT_SCROLLS
            isVerticalScrollBarEnabled = LauncherAppOptionsMenuPolicy.shouldScroll(
                rowCount = appShortcuts.size + LauncherAppOptionsMenuPolicy.systemOptions(canHideApp).size,
                rowHeightPx = dp(LauncherAppOptionsMenuPolicy.ROW_HEIGHT_DP),
                verticalPaddingPx = dp(LauncherAppOptionsMenuPolicy.VERTICAL_PADDING_DP),
                dividerHeightPx = LauncherAppOptionsMenuPolicy.DIVIDER_HEIGHT_PX,
                availableHeightPx = availableHeight
            )
            background = launcherOptionsPopupBackground()
            clipToOutline = true
            addView(
                menu,
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )
        }
        val popup = PopupWindow(popupContent, popupWidth, popupHeight, true).apply {
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

        popupContent.measure(
            View.MeasureSpec.makeMeasureSpec(resources.displayMetrics.widthPixels, View.MeasureSpec.AT_MOST),
            View.MeasureSpec.makeMeasureSpec(popupHeight, View.MeasureSpec.EXACTLY)
        )
        showLauncherOptionsOverlay(launcherItem, anchor)
        popup.showAtLocation(
            mLauncherView,
            Gravity.NO_GRAVITY,
            popupX(anchor, popupWidth),
            launcherOptionsPopupY(anchor, selectedIconBounds, popupHeight)
        )
    }

    private fun queryLauncherAppShortcuts(launcherItem: LauncherItem): List<ShortcutInfoCompat> {
        val applicationItem = launcherItem as? ApplicationItem ?: return emptyList()
        val component = applicationItem.componentName ?: applicationItem.getTargetComponent() ?: return emptyList()
        val user = applicationItem.user?.getRealHandle() ?: Process.myUserHandle()
        val shortcutManager = DeepShortcutManager.getInstance(this)
        if (!shortcutManager.hasHostPermission()) {
            return emptyList()
        }
        return shortcutManager.queryForShortcutsContainer(component, null, user)
            .asSequence()
            .filter { it.isEnabled }
            .sortedWith(
                compareBy<ShortcutInfoCompat> { it.rank }
                    .thenBy { launcherShortcutLabel(it).lowercase(Locale.getDefault()) }
            )
            .toList()
    }

    private fun createLauncherOptionsMenu(
        launcherItem: LauncherItem,
        iconView: BlissFrameLayout,
        anchor: View,
        appShortcuts: List<ShortcutInfoCompat>,
        canHideApp: Boolean
    ): LinearLayout {
        val rows = ArrayList<View>()
        appShortcuts.forEach { shortcut ->
            rows.add(
                createLauncherShortcutRow(shortcut) {
                    launcherOptionsPopup?.dismiss()
                    startLauncherAppShortcut(shortcut, anchor)
                }
            )
        }
        LauncherAppOptionsMenuPolicy.systemOptions(canHideApp).forEach { option ->
            rows.add(
                createLauncherSystemOptionRow(option) {
                    handleLauncherSystemOption(option, launcherItem, iconView)
                }
            )
        }

        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(0, dp(2), 0, dp(2))
            rows.forEachIndexed { index, row ->
                addView(row)
                if (index < rows.lastIndex) {
                    addView(createLauncherOptionDivider())
                }
            }
        }
    }

    private fun createLauncherShortcutRow(shortcut: ShortcutInfoCompat, onClick: () -> Unit): View {
        val icon = DeepShortcutManager.getInstance(this)
            .getShortcutIconDrawable(shortcut, resources.displayMetrics.densityDpi)
        return createLauncherOptionRow(
            title = launcherShortcutLabel(shortcut),
            trailingView = if (icon != null) {
                createLauncherOptionIcon(drawable = icon, tintColor = null)
            } else {
                createLauncherShortcutFallbackBadge(launcherShortcutLabel(shortcut))
            },
            destructive = false,
            onClick = onClick
        )
    }

    private fun createLauncherSystemOptionRow(
        option: LauncherAppOptionsMenuPolicy.SystemOption,
        onClick: () -> Unit
    ): View {
        val destructive = option == LauncherAppOptionsMenuPolicy.SystemOption.DELETE
        val iconRes = when (option) {
            LauncherAppOptionsMenuPolicy.SystemOption.APP_INFO -> R.drawable.ic_info_20
            LauncherAppOptionsMenuPolicy.SystemOption.HIDE_APP -> R.drawable.ic_eye_off_20
            LauncherAppOptionsMenuPolicy.SystemOption.EDIT_HOME -> R.drawable.ic_phone_home_20
            LauncherAppOptionsMenuPolicy.SystemOption.DELETE -> R.drawable.ic_delete_20
        }
        val text = when (option) {
            LauncherAppOptionsMenuPolicy.SystemOption.APP_INFO -> getString(R.string.app_option_info)
            LauncherAppOptionsMenuPolicy.SystemOption.HIDE_APP -> getString(R.string.app_option_hide)
            LauncherAppOptionsMenuPolicy.SystemOption.EDIT_HOME -> getString(R.string.app_option_edit_home)
            LauncherAppOptionsMenuPolicy.SystemOption.DELETE -> getString(R.string.app_option_delete)
        }
        return createLauncherOptionRow(
            title = text,
            trailingView = createLauncherOptionIcon(
                drawable = ContextCompat.getDrawable(this, iconRes),
                tintColor = if (destructive) 0xFFFF3B30.toInt() else launcherOptionsTextColor(false)
            ),
            destructive = destructive,
            onClick = onClick
        )
    }

    private fun createLauncherOptionRow(
        title: CharSequence,
        trailingView: View,
        destructive: Boolean,
        onClick: () -> Unit
    ): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(
                dp(LauncherAppOptionsMenuPolicy.ROW_HORIZONTAL_PADDING_DP),
                0,
                dp(LauncherAppOptionsMenuPolicy.ROW_HORIZONTAL_PADDING_DP),
                0
            )
            isClickable = true
            isFocusable = true
            background = selectableItemBackground()
            setOnClickListener { onClick() }
            addView(
                TextView(context).apply {
                    text = title
                    setTextColor(launcherOptionsTextColor(destructive))
                    textSize = LauncherAppOptionsMenuPolicy.TITLE_TEXT_SIZE_SP
                    includeFontPadding = false
                    gravity = Gravity.CENTER_VERTICAL
                    maxLines = 1
                    ellipsize = TextUtils.TruncateAt.END
                    typeface = Typeface.DEFAULT
                },
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
            )
            addView(
                trailingView,
                LinearLayout.LayoutParams(
                    dp(LauncherAppOptionsMenuPolicy.TRAILING_ICON_SIZE_DP),
                    dp(LauncherAppOptionsMenuPolicy.TRAILING_ICON_SIZE_DP)
                ).apply {
                    marginStart = dp(10)
                }
            )
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dp(LauncherAppOptionsMenuPolicy.ROW_HEIGHT_DP)
            )
        }
    }

    private fun createLauncherOptionIcon(drawable: Drawable?, tintColor: Int?): ImageView =
        ImageView(this).apply {
            setImageDrawable(drawable?.mutate())
            scaleType = ImageView.ScaleType.CENTER_INSIDE
            contentDescription = null
            tintColor?.let { setColorFilter(it) }
        }

    private fun createLauncherShortcutFallbackBadge(label: CharSequence): TextView {
        val colors = intArrayOf(
            0xFF7CB342.toInt(),
            0xFF0097A7.toInt(),
            0xFFFF7043.toInt(),
            0xFF1E88E5.toInt(),
            0xFF00897B.toInt(),
            0xFFF57C00.toInt()
        )
        val color = colors[(label.toString().hashCode() ushr 1) % colors.size]
        return TextView(this).apply {
            text = label.firstOrNull()?.uppercaseChar()?.toString().orEmpty()
            setTextColor(Color.WHITE)
            textSize = 11f
            includeFontPadding = false
            gravity = Gravity.CENTER
            background = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(color)
            }
        }
    }

    private fun createLauncherOptionDivider(): View =
        View(this).apply {
            setBackgroundColor(launcherOptionsDividerColor())
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                LauncherAppOptionsMenuPolicy.DIVIDER_HEIGHT_PX
            )
        }

    private fun handleLauncherSystemOption(
        option: LauncherAppOptionsMenuPolicy.SystemOption,
        launcherItem: LauncherItem,
        iconView: BlissFrameLayout
    ) {
        launcherOptionsPopup?.dismiss()
        when (option) {
            LauncherAppOptionsMenuPolicy.SystemOption.APP_INFO -> openLauncherItemInfo(launcherItem)
            LauncherAppOptionsMenuPolicy.SystemOption.HIDE_APP -> {
                if (launcherItem is ApplicationItem) {
                    hideLauncherAppFromHome(launcherItem)
                }
            }
            LauncherAppOptionsMenuPolicy.SystemOption.EDIT_HOME -> {
                if (LauncherEditModeEntryPolicy.shouldEnterEditMode(editHomeClicked = true)) {
                    handleWobbling(true)
                }
            }
            LauncherAppOptionsMenuPolicy.SystemOption.DELETE -> {
                if (canShowUninstallOption(launcherItem)) {
                    uninstallLauncherItem(launcherItem, iconView)
                } else {
                    handleWobbling(true)
                }
            }
        }
    }

    private fun startLauncherAppShortcut(shortcut: ShortcutInfoCompat, anchor: View) {
        val manager = DeepShortcutManager.getInstance(this)
        manager.startShortcut(shortcut.`package`, shortcut.id, getViewBounds(anchor), null, shortcut.userHandle)
        if (!manager.wasLastCallSuccess()) {
            Toast.makeText(this, getString(R.string.activity_not_found), Toast.LENGTH_SHORT).show()
        }
    }

    private fun launcherShortcutLabel(shortcut: ShortcutInfoCompat): String =
        shortcut.shortLabel?.toString()
            ?: shortcut.longLabel?.toString()
            ?: shortcut.id

    private fun launcherOptionsAvailableHeight(selectedIconBounds: Rect): Int {
        val screenHeight = resources.displayMetrics.heightPixels
        return LauncherAppOptionsMenuPolicy.availableHeightPx(
            selectedIconTopPx = selectedIconBounds.top,
            selectedIconBottomPx = selectedIconBounds.bottom,
            screenHeightPx = screenHeight,
            marginPx = dp(LauncherAppOptionsMenuPolicy.SCREEN_EDGE_MARGIN_DP),
            gapPx = dp(LauncherAppOptionsMenuPolicy.ANCHOR_GAP_DP),
            minimumHeightPx = dp(LauncherAppOptionsMenuPolicy.ROW_HEIGHT_DP * 3)
        )
    }

    private fun launcherOptionsPopupY(
        anchor: View,
        selectedIconBounds: Rect,
        popupHeight: Int
    ): Int {
        val anchorLocation = IntArray(2)
        anchor.getLocationOnScreen(anchorLocation)
        val screenHeight = resources.displayMetrics.heightPixels
        return LauncherAppOptionsMenuPolicy.popupY(
            anchorTopPx = anchorLocation[1],
            anchorHeightPx = anchor.height,
            selectedIconTopPx = selectedIconBounds.top,
            selectedIconBottomPx = selectedIconBounds.bottom,
            popupHeightPx = popupHeight,
            screenHeightPx = screenHeight,
            marginPx = dp(LauncherAppOptionsMenuPolicy.SCREEN_EDGE_MARGIN_DP),
            gapPx = dp(LauncherAppOptionsMenuPolicy.ANCHOR_GAP_DP)
        )
    }

    private fun launcherOptionsPreviewHeight(): Int =
        if (::selectedIconPreview.isInitialized && selectedIconPreview.height > 0) {
            selectedIconPreview.height
        } else {
            dp(94)
        }

    private fun launcherOptionsSelectedIconBounds(anchor: View): Rect {
        val previewTop = launcherOptionsPreviewTop(anchor)
        val previewHeight = launcherOptionsPreviewHeight()
        val plate = binding.selectedIconPlate
        val plateTop = if (plate.top > 0) {
            plate.top
        } else {
            selectedIconPreview.paddingTop
        }
        val plateHeight = if (plate.height > 0) {
            plate.height
        } else {
            plate.layoutParams?.height?.takeIf { it > 0 } ?: dp(68)
        }
        val pivotY = previewHeight / 2f
        val scale = LauncherAppOptionsMenuPolicy.SELECTED_ICON_PREVIEW_OPEN_SCALE
        val visualTop = previewTop + floor(pivotY + (plateTop - pivotY) * scale).toInt()
        val visualBottom = previewTop + ceil(pivotY + (plateTop + plateHeight - pivotY) * scale).toInt()
        return Rect(0, visualTop, 0, visualBottom)
    }

    private fun launcherOptionsPreviewTop(anchor: View): Int {
        val anchorLocation = IntArray(2)
        val rootLocation = IntArray(2)
        anchor.getLocationOnScreen(anchorLocation)
        mLauncherView.getLocationOnScreen(rootLocation)

        val previewHeight = launcherOptionsPreviewHeight()
        val rootHeight = if (mLauncherView.height > 0) {
            mLauncherView.height
        } else {
            resources.displayMetrics.heightPixels
        }
        val topMargin = dp(12)
        val top = anchorLocation[1] - rootLocation[1] - dp(2)
        val maxTop = max(topMargin, rootHeight - previewHeight - topMargin)
        return rootLocation[1] + max(topMargin, min(top, maxTop))
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

    private fun launcherOptionsPopupBackground(): Drawable =
        roundedRectangle(
            if (darkModeEnabled) 0xF02C2C2E.toInt() else 0xDDF4F1E8.toInt(),
            LauncherAppOptionsMenuPolicy.CORNER_RADIUS_DP
        )

    private fun launcherOptionsTextColor(destructive: Boolean): Int =
        when {
            destructive -> 0xFFFF3B30.toInt()
            darkModeEnabled -> Color.WHITE
            else -> Color.BLACK
        }

    private fun launcherOptionsDividerColor(): Int =
        if (darkModeEnabled) 0xFF48484A.toInt() else 0x22000000

    private fun layoutSettingsPalette(darkMode: Boolean): LayoutSettingsPalette {
        return if (darkMode) {
            LayoutSettingsPalette(
                backgroundColor = Color.BLACK,
                toolbarColor = 0xFF1C1C1E.toInt(),
                rowColor = 0xFF2C2C2E.toInt(),
                primaryTextColor = Color.WHITE,
                secondaryTextColor = 0xFFEAEAEE.toInt(),
                dividerColor = 0xFF48484A.toInt(),
                sectionHeaderColor = 0xFF8E8E93.toInt(),
                selectedColor = 0xFF34C759.toInt(),
                unselectedColor = 0xFF8E8E93.toInt()
            )
        } else {
            LayoutSettingsPalette(
                backgroundColor = 0xFFF2F2F7.toInt(),
                toolbarColor = Color.WHITE,
                rowColor = Color.WHITE,
                primaryTextColor = Color.BLACK,
                secondaryTextColor = 0xFF6D737D.toInt(),
                dividerColor = 0xFFE5E5EA.toInt(),
                sectionHeaderColor = 0xFF737780.toInt(),
                selectedColor = 0xFF34C759.toInt(),
                unselectedColor = 0xFF8E8E93.toInt()
            )
        }
    }

    private fun showBlurEffectSettingsPanel() {
        hideBlurEffectSettingsPanel()
        dismissLauncherOptionsPopup()

        val palette = layoutSettingsPalette(darkModeEnabled)
        val panel = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(palette.backgroundColor)
            elevation = dp(42).toFloat()
            isClickable = true
            isFocusable = true
        }

        panel.addView(
            FrameLayout(this).apply {
                setBackgroundColor(palette.toolbarColor)
                addView(
                    TextView(context).apply {
                        text = getString(R.string.layout_back_settings)
                        setTextColor(0xFF007AFF.toInt())
                        textSize = 20f
                        gravity = Gravity.CENTER_VERTICAL
                        includeFontPadding = false
                        setOnClickListener { hideBlurEffectSettingsPanel() }
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
                        text = getString(R.string.settings_blur_effect)
                        setTextColor(palette.primaryTextColor)
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
            View(this).apply { setBackgroundColor(palette.dividerColor) },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
        )

        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(palette.backgroundColor)
        }
        content.addView(
            createBlurSettingsSwitchRow(
                title = getString(R.string.settings_blur_dock),
                checked = LauncherHomeLayoutPreferences.isDockBlurEnabled(this),
                textColor = palette.secondaryTextColor,
                rowColor = palette.rowColor,
                dividerColor = palette.dividerColor
            ) { enabled ->
                saveBlurSetting(LauncherBlurSettingsRefreshPolicy.Target.DOCK, enabled)
            }
        )
        content.addView(
            createBlurSettingsSwitchRow(
                title = getString(R.string.settings_blur_folder),
                checked = LauncherHomeLayoutPreferences.isFolderBlurEnabled(this),
                textColor = palette.secondaryTextColor,
                rowColor = palette.rowColor,
                dividerColor = palette.dividerColor
            ) { enabled ->
                saveBlurSetting(LauncherBlurSettingsRefreshPolicy.Target.FOLDER, enabled)
            }
        )
        content.addView(
            createBlurSettingsSwitchRow(
                title = getString(R.string.settings_blur_widget),
                checked = LauncherHomeLayoutPreferences.isWidgetBlurEnabled(this),
                textColor = palette.secondaryTextColor,
                rowColor = palette.rowColor,
                dividerColor = palette.dividerColor
            ) { enabled ->
                saveBlurSetting(LauncherBlurSettingsRefreshPolicy.Target.WIDGET, enabled)
            }
        )
        content.addView(
            createBlurSettingsSwitchRow(
                title = getString(R.string.settings_blur_search),
                checked = LauncherHomeLayoutPreferences.isSearchBlurEnabled(this),
                textColor = palette.secondaryTextColor,
                rowColor = palette.rowColor,
                dividerColor = palette.dividerColor
            ) { enabled ->
                saveBlurSetting(LauncherBlurSettingsRefreshPolicy.Target.SEARCH, enabled)
            }
        )

        panel.addView(
            ScrollView(this).apply {
                isFillViewport = true
                overScrollMode = View.OVER_SCROLL_NEVER
                setBackgroundColor(palette.backgroundColor)
                addView(
                    content,
                    ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                )
            },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
        )

        blurSettingsPanel = panel
        (mLauncherView as? ViewGroup)?.addView(
            panel,
            RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun createBlurSettingsSwitchRow(
        title: String,
        checked: Boolean,
        textColor: Int,
        rowColor: Int,
        dividerColor: Int,
        onCheckedChanged: (Boolean) -> Unit
    ): View {
        lateinit var switchView: Switch
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(rowColor)
            addView(
                LinearLayout(context).apply {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL
                    isClickable = true
                    isFocusable = true
                    setPadding(dp(24), 0, dp(36), 0)
                    setOnClickListener { switchView.isChecked = !switchView.isChecked }

                    addView(
                        ImageView(context).apply {
                            background = roundedRectangle(0xFF2F8FF7.toInt(), 9)
                            setImageResource(R.drawable.ic_grid_24)
                            setColorFilter(Color.WHITE)
                            setPadding(dp(8), dp(8), dp(8), dp(8))
                            contentDescription = null
                        },
                        LinearLayout.LayoutParams(dp(50), dp(50))
                    )
                    addView(
                        TextView(context).apply {
                            text = title
                            setTextColor(textColor)
                            textSize = 20f
                            includeFontPadding = false
                        },
                        LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply {
                            marginStart = dp(28)
                        }
                    )

                    switchView = Switch(context).apply {
                        isChecked = checked
                        setOnCheckedChangeListener { _, isChecked -> onCheckedChanged(isChecked) }
                    }
                    addView(
                        switchView,
                        LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    )
                },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(96))
            )
            addView(
                View(context).apply { setBackgroundColor(dividerColor) },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
            )
        }
    }

    private fun saveBlurSetting(
        target: LauncherBlurSettingsRefreshPolicy.Target,
        enabled: Boolean
    ) {
        if (enabled == currentBlurSetting(target)) return

        setBlurSetting(target, enabled)
        applyBlurSettingRefresh(LauncherBlurSettingsRefreshPolicy.actionsFor(target))
    }

    private fun currentBlurSetting(target: LauncherBlurSettingsRefreshPolicy.Target): Boolean =
        when (target) {
            LauncherBlurSettingsRefreshPolicy.Target.DOCK ->
                LauncherHomeLayoutPreferences.isDockBlurEnabled(this)
            LauncherBlurSettingsRefreshPolicy.Target.FOLDER ->
                LauncherHomeLayoutPreferences.isFolderBlurEnabled(this)
            LauncherBlurSettingsRefreshPolicy.Target.WIDGET ->
                LauncherHomeLayoutPreferences.isWidgetBlurEnabled(this)
            LauncherBlurSettingsRefreshPolicy.Target.SEARCH ->
                LauncherHomeLayoutPreferences.isSearchBlurEnabled(this)
        }

    private fun setBlurSetting(
        target: LauncherBlurSettingsRefreshPolicy.Target,
        enabled: Boolean
    ) {
        when (target) {
            LauncherBlurSettingsRefreshPolicy.Target.DOCK ->
                LauncherHomeLayoutPreferences.setDockBlur(this, enabled)
            LauncherBlurSettingsRefreshPolicy.Target.FOLDER ->
                LauncherHomeLayoutPreferences.setFolderBlur(this, enabled)
            LauncherBlurSettingsRefreshPolicy.Target.WIDGET ->
                LauncherHomeLayoutPreferences.setWidgetBlur(this, enabled)
            LauncherBlurSettingsRefreshPolicy.Target.SEARCH ->
                LauncherHomeLayoutPreferences.setSearchBlur(this, enabled)
        }
    }

    private fun applyBlurSettingRefresh(actions: LauncherBlurSettingsRefreshPolicy.RefreshActions) {
        if (actions.refreshDock && ::mDock.isInitialized) {
            mDock.refreshStyle()
            applyDockRealtimeLiquidGlass()
        }
        if (actions.refreshFolderPreviews) {
            refreshVisibleFolderPreviewIcons()
        }
        if (actions.refreshFolderChrome && ::mLauncherView.isInitialized) {
            applyFolderLiquidGlassAppearance(bindRealtime = isFolderWindowActive())
        }
        if (actions.refreshWidgets) {
            renderHomeWidgets()
            rebindAllWidgets()
        }
        if (actions.refreshSearchChrome) {
            applySearchBlurAppearance()
        }
    }

    private fun hideBlurEffectSettingsPanel() {
        val panel = blurSettingsPanel ?: return
        blurSettingsPanel = null
        (panel.parent as? ViewGroup)?.removeView(panel)
    }

    private fun showLayoutSettingsPanel() {
        hideLayoutSettingsPanel()
        dismissLauncherOptionsPopup()

        val settings = LauncherHomeLayoutPreferences.read(this)
        val palette = layoutSettingsPalette(settings.darkMode)

        val panel = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(palette.backgroundColor)
            elevation = dp(42).toFloat()
            isClickable = true
            isFocusable = true
        }

        panel.addView(
            FrameLayout(this).apply {
                setBackgroundColor(palette.toolbarColor)
                addView(
                    TextView(context).apply {
                        text = getString(R.string.layout_back_settings)
                        setTextColor(0xFF007AFF.toInt())
                        textSize = 20f
                        gravity = Gravity.CENTER_VERTICAL
                        includeFontPadding = false
                        setOnClickListener { hideLayoutSettingsPanel() }
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
                        text = getString(R.string.settings_layout)
                        setTextColor(palette.primaryTextColor)
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
            View(this).apply { setBackgroundColor(palette.dividerColor) },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
        )

        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(palette.backgroundColor)
        }
        content.addView(
            createLayoutSwitchRow(
                title = getString(R.string.layout_dark_mode),
                checked = settings.darkMode,
                textColor = palette.secondaryTextColor,
                rowColor = palette.rowColor,
                dividerColor = palette.dividerColor
            ) { enabled ->
                saveDarkModeSetting(enabled)
            }
        )
        content.addView(
            createLayoutSwitchRow(
                title = getString(R.string.layout_iphone8_style),
                checked = launcherDockStylePreferencesRepository.isIphone8StyleEnabled(),
                textColor = palette.secondaryTextColor,
                rowColor = palette.rowColor,
                dividerColor = palette.dividerColor
            ) { enabled ->
                saveIphone8StyleSetting(enabled)
            }
        )
        content.addView(
            createLayoutSwitchRow(
                title = getString(R.string.auto_rearrange_apps),
                checked = settings.autoArrangeApps,
                textColor = palette.secondaryTextColor,
                rowColor = palette.rowColor,
                dividerColor = palette.dividerColor
            ) { enabled ->
                saveAutoArrangeSetting(enabled)
            }
        )
        content.addView(
            createLayoutStaticRow(
                title = getString(R.string.layout_hide_navigation),
                textColor = palette.secondaryTextColor,
                rowColor = palette.rowColor,
                dividerColor = palette.dividerColor
            )
        )

        content.addView(createLayoutSectionHeader(getString(R.string.layout_icon_size), palette.sectionHeaderColor))
        content.addView(
            createIconSizeSection(
                currentIconSizeDp = settings.iconSizeDp,
                selectedColor = 0xFF007AFF.toInt(),
                rowColor = palette.rowColor,
                dividerColor = palette.dividerColor
            )
        )

        content.addView(createLayoutSectionHeader(getString(R.string.layout_home_screen_grid), palette.sectionHeaderColor))
        content.addView(
            createHomeGridSection(
                currentRows = settings.rows,
                rowColor = palette.rowColor,
                selectedColor = palette.selectedColor,
                unselectedColor = palette.unselectedColor
            )
        )

        panel.addView(
            ScrollView(this).apply {
                isFillViewport = true
                overScrollMode = View.OVER_SCROLL_NEVER
                setBackgroundColor(palette.backgroundColor)
                addView(
                    content,
                    ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                )
            },
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
        )

        layoutSettingsPanel = panel
        (mLauncherView as? ViewGroup)?.addView(
            panel,
            RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun createLayoutSwitchRow(
        title: String,
        checked: Boolean,
        textColor: Int,
        rowColor: Int,
        dividerColor: Int,
        onCheckedChanged: (Boolean) -> Unit
    ): View {
        lateinit var switchView: Switch
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(rowColor)
            addView(
                LinearLayout(context).apply {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL
                    isClickable = true
                    isFocusable = true
                    setPadding(dp(24), 0, dp(48), 0)
                    setOnClickListener { switchView.isChecked = !switchView.isChecked }

                    addView(
                        TextView(context).apply {
                            text = title
                            setTextColor(textColor)
                            textSize = 17f
                            includeFontPadding = false
                        },
                        LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
                    )

                    switchView = Switch(context).apply {
                        isChecked = checked
                        setOnCheckedChangeListener { _, isChecked -> onCheckedChanged(isChecked) }
                    }
                    addView(
                        switchView,
                        LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    )
                },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(72))
            )
            addView(
                View(context).apply { setBackgroundColor(dividerColor) },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
            )
        }
    }

    private fun createLayoutStaticRow(title: String, textColor: Int, rowColor: Int, dividerColor: Int): View {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(rowColor)
            addView(
                TextView(context).apply {
                    text = title
                    setTextColor(textColor)
                    textSize = 17f
                    gravity = Gravity.CENTER_VERTICAL
                    includeFontPadding = false
                    setPadding(dp(24), 0, dp(24), 0)
                },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(72))
            )
            addView(
                View(context).apply { setBackgroundColor(dividerColor) },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
            )
        }
    }

    private fun createLayoutSectionHeader(title: String, textColor: Int): View {
        return TextView(this).apply {
            text = title
            setTextColor(textColor)
            textSize = 12f
            gravity = Gravity.BOTTOM or Gravity.START
            includeFontPadding = false
            setPadding(dp(24), 0, dp(24), dp(9))
        }.also { header ->
            header.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(40))
        }
    }

    private fun createIconSizeSection(
        currentIconSizeDp: Int,
        selectedColor: Int,
        rowColor: Int,
        dividerColor: Int
    ): View {
        val preview = ImageView(this).apply {
            background = roundedRectangle(0xFF34C759.toInt(), 13)
            setImageResource(android.R.drawable.sym_action_call)
            setColorFilter(Color.WHITE)
            scaleType = ImageView.ScaleType.CENTER
            setPadding(dp(14), dp(14), dp(14), dp(14))
        }
        fun updatePreview(iconSizeDp: Int) {
            val previewSize = dp(iconSizeDp)
            preview.layoutParams = preview.layoutParams.apply {
                width = previewSize
                height = previewSize
            }
        }

        val seekBar = SeekBar(this).apply {
            max = LauncherHomeLayoutPreferences.ICON_SIZE_SLIDER_MAX
            progress = LauncherHomeLayoutPreferences.iconSizeToSliderProgress(currentIconSizeDp)
            setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        updatePreview(LauncherHomeLayoutPreferences.sliderProgressToIconSize(progress))
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    val iconSizeDp = LauncherHomeLayoutPreferences.sliderProgressToIconSize(progress)
                    saveHomeIconSizeSetting(iconSizeDp)
                }
            })
            progressDrawable?.setTint(selectedColor)
            thumb?.setTint(Color.WHITE)
        }

        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setBackgroundColor(rowColor)
            setPadding(0, dp(18), 0, dp(24))
            addView(
                preview,
                LinearLayout.LayoutParams(dp(currentIconSizeDp), dp(currentIconSizeDp))
            )
            addView(
                seekBar,
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(42)).apply {
                    leftMargin = dp(64)
                    rightMargin = dp(64)
                    topMargin = dp(28)
                }
            )
            addView(
                View(context).apply { setBackgroundColor(dividerColor) },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
            )
        }
    }

    private fun createHomeGridSection(
        currentRows: Int,
        rowColor: Int,
        selectedColor: Int,
        unselectedColor: Int
    ): View {
        val grid5Option = createHomeGridOption(
            rows = LauncherHomeLayoutPreferences.HOME_GRID_ROWS_5,
            label = getString(R.string.layout_grid_5x4)
        )
        val grid6Option = createHomeGridOption(
            rows = LauncherHomeLayoutPreferences.HOME_GRID_ROWS_6,
            label = getString(R.string.layout_grid_6x4)
        )

        fun updateGridSelection(selectedRows: Int) {
            tintHomeGridOption(grid5Option, selectedRows == LauncherHomeLayoutPreferences.HOME_GRID_ROWS_5, selectedColor, unselectedColor)
            tintHomeGridOption(grid6Option, selectedRows == LauncherHomeLayoutPreferences.HOME_GRID_ROWS_6, selectedColor, unselectedColor)
        }

        grid5Option.setOnClickListener {
            updateGridSelection(LauncherHomeLayoutPreferences.HOME_GRID_ROWS_5)
            saveHomeGridRowsSetting(LauncherHomeLayoutPreferences.HOME_GRID_ROWS_5)
        }
        grid6Option.setOnClickListener {
            updateGridSelection(LauncherHomeLayoutPreferences.HOME_GRID_ROWS_6)
            saveHomeGridRowsSetting(LauncherHomeLayoutPreferences.HOME_GRID_ROWS_6)
        }
        updateGridSelection(currentRows)

        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            setBackgroundColor(rowColor)
            setPadding(dp(48), dp(24), dp(48), dp(30))
            addView(
                grid5Option,
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
            )
            addView(
                grid6Option,
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
            )
        }
    }

    private fun createHomeGridOption(rows: Int, label: String): LinearLayout {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            isClickable = true
            isFocusable = true
            addView(createHomeGridPreview(rows))
            addView(
                TextView(context).apply {
                    text = label
                    textSize = 16f
                    gravity = Gravity.CENTER
                    includeFontPadding = false
                },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                    topMargin = dp(8)
                }
            )
        }
    }

    private fun createHomeGridPreview(rows: Int): GridLayout {
        val spec = LayoutGridPreviewPolicy.previewSpec(rows)
        return GridLayout(this).apply {
            rowCount = spec.rows
            columnCount = spec.columns
            clipChildren = false
            clipToPadding = false
            repeat(spec.cellCount) { index ->
                addView(
                    View(context).apply {
                        tag = HOME_GRID_PREVIEW_DOT_TAG
                    },
                    GridLayout.LayoutParams(
                        GridLayout.spec(index / spec.columns),
                        GridLayout.spec(index % spec.columns)
                    ).apply {
                        width = dp(7)
                        height = dp(7)
                        setMargins(dp(1), dp(1), dp(1), dp(1))
                    }
                )
            }
        }
    }

    private fun tintHomeGridOption(option: LinearLayout, selected: Boolean, selectedColor: Int, unselectedColor: Int) {
        val color = if (selected) selectedColor else unselectedColor
        tintHomeGridOptionView(option, color)
    }

    private fun tintHomeGridOptionView(view: View, color: Int) {
        when {
            view.tag == HOME_GRID_PREVIEW_DOT_TAG -> {
                view.background = roundedRectangle(color, 1)
            }

            view is TextView -> {
                view.setTextColor(color)
            }

            view is ViewGroup -> {
                for (index in 0 until view.childCount) {
                    tintHomeGridOptionView(view.getChildAt(index), color)
                }
            }
        }
    }

    private fun saveHomeIconSizeSetting(iconSizeDp: Int) {
        val resolvedIconSize = LauncherHomeLayoutPreferences.resolve(
            iconSizeDp = iconSizeDp,
            rows = launcherHomeLayoutSettings.rows,
            autoArrangeApps = launcherHomeLayoutSettings.autoArrangeApps
        ).iconSizeDp
        if (resolvedIconSize == launcherHomeLayoutSettings.iconSizeDp) return

        launcherHomeSettingsRepository.saveHomeIconSizeDp(resolvedIconSize)
        recreateForHomeLayoutSettingsChange()
    }

    private fun saveHomeGridRowsSetting(rows: Int) {
        val resolvedRows = LauncherHomeLayoutPreferences.resolve(
            iconSizeDp = launcherHomeLayoutSettings.iconSizeDp,
            rows = rows,
            autoArrangeApps = launcherHomeLayoutSettings.autoArrangeApps
        ).rows
        if (resolvedRows == launcherHomeLayoutSettings.rows) return

        launcherHomeSettingsRepository.saveHomeGridRows(resolvedRows)
        recreateForHomeLayoutSettingsChange()
    }

    private fun saveAutoArrangeSetting(enabled: Boolean) {
        if (enabled == launcherHomeLayoutSettings.autoArrangeApps) return

        launcherHomeSettingsRepository.setAutoRearrangeApps(enabled)
        recreateForHomeLayoutSettingsChange()
    }

    private fun saveDarkModeSetting(enabled: Boolean) {
        if (enabled == launcherHomeLayoutSettings.darkMode) return

        launcherHomeSettingsRepository.setDarkMode(enabled)
        darkModeEnabled = enabled
        launcherHomeLayoutSettings = launcherHomeLayoutSettings.copy(darkMode = enabled)
        applyLauncherSystemUi()
        applyLiquidGlassAppearance()
        refreshVisibleFolderPreviewIcons()
        refreshAppLibraryPage()
        if (layoutSettingsPanel != null) {
            showLayoutSettingsPanel()
        }
    }

    private fun saveIphone8StyleSetting(enabled: Boolean) {
        launcherDockStylePreferencesRepository.setIphone8StyleEnabled(enabled)
        if (::mDock.isInitialized) {
            mDock.refreshStyle()
            applyDockRealtimeLiquidGlass()
        }
        if (::mIndicator.isInitialized) {
            indicatorMode = if (shouldKeepPageDotsVisibleForDockStyle()) {
                IndicatorMode.DOTS
            } else {
                IndicatorMode.SEARCH
            }
            refreshPageIndicator()
        }
    }

    private fun recreateForHomeLayoutSettingsChange() {
        hideLayoutSettingsPanel()
        launcherHomeLayoutSettings = launcherHomeSettingsRepository.readHomeLayoutSettings()
        BlissLauncher.getApplication(this).resetDeviceProfile()
        recreate()
    }

    private fun hideLayoutSettingsPanel() {
        val panel = layoutSettingsPanel ?: return
        layoutSettingsPanel = null
        (panel.parent as? ViewGroup)?.removeView(panel)
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

        val backgroundColor = if (darkModeEnabled) Color.BLACK else LauncherRenameUiPolicy.PAGE_BACKGROUND_COLOR
        val toolbarColor = if (darkModeEnabled) 0xFF1C1C1E.toInt() else LauncherRenameUiPolicy.TOOLBAR_COLOR
        val rowColor = if (darkModeEnabled) 0xFF1C1C1E.toInt() else backgroundColor
        val primaryTextColor = if (darkModeEnabled) Color.WHITE else LauncherRenameUiPolicy.PRIMARY_TEXT_COLOR
        val secondaryTextColor = if (darkModeEnabled) 0xFFEAEAEE.toInt() else LauncherRenameUiPolicy.SECONDARY_TEXT_COLOR
        val dividerColor = if (darkModeEnabled) 0xFF38383A.toInt() else LauncherRenameUiPolicy.DIVIDER_COLOR

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
                        setTextColor(LauncherRenameUiPolicy.ACCENT_COLOR)
                        textSize = 20f
                        gravity = Gravity.CENTER_VERTICAL
                        includeFontPadding = false
                        setOnClickListener { hideRenameAppPicker() }
                    },
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        dp(LauncherRenameUiPolicy.TOOLBAR_ROW_HEIGHT_DP),
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
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(LauncherRenameUiPolicy.TOOLBAR_HEIGHT_DP))
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
                            addView(createRenameAppRow(app, secondaryTextColor, dividerColor, rowColor))
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
                    setPadding(
                        dp(LauncherRenameUiPolicy.LIST_START_PADDING_DP),
                        0,
                        dp(LauncherRenameUiPolicy.LIST_END_PADDING_DP),
                        0
                    )
                    setOnClickListener { showRenameAppDialog(app) }

                    addView(
                        ImageView(context).apply {
                            setImageDrawable(app.icon)
                            contentDescription = app.title?.toString()
                            scaleType = ImageView.ScaleType.FIT_CENTER
                        },
                        LinearLayout.LayoutParams(
                            dp(LauncherRenameUiPolicy.LIST_ICON_SIZE_DP),
                            dp(LauncherRenameUiPolicy.LIST_ICON_SIZE_DP)
                        )
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
                            marginStart = dp(LauncherRenameUiPolicy.LIST_TEXT_MARGIN_START_DP)
                        }
                    )
                },
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dp(LauncherRenameUiPolicy.LIST_ROW_HEIGHT_DP)
                )
            )
            addView(
                View(context).apply { setBackgroundColor(dividerColor) },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1).apply {
                    leftMargin = dp(LauncherRenameUiPolicy.LIST_DIVIDER_MARGIN_START_DP)
                    rightMargin = dp(LauncherRenameUiPolicy.LIST_DIVIDER_MARGIN_END_DP)
                }
            )
        }
    }

    private fun showRenameAppDialog(app: ApplicationItem) {
        val currentTitle = app.title?.toString().orEmpty()
        val dialog = Dialog(this)
        val dialogBackgroundColor = if (darkModeEnabled) 0xFF2C2C2E.toInt() else Color.WHITE
        val dialogInputColor = if (darkModeEnabled) 0xFF1C1C1E.toInt() else Color.WHITE
        val dialogTitleColor = if (darkModeEnabled) 0xFFEAEAEE.toInt() else 0xFF777777.toInt()
        val dialogInputTextColor = if (darkModeEnabled) Color.WHITE else LauncherRenameUiPolicy.SECONDARY_TEXT_COLOR
        val dialogHintColor = if (darkModeEnabled) 0xFF8E8E93.toInt() else 0xFF9CA3AF.toInt()
        val dialogInputStrokeColor = if (darkModeEnabled) 0xFF48484A.toInt() else 0xFFD1D1D6.toInt()
        val input = EditText(this).apply {
            setSingleLine(false)
            hint = getString(R.string.settings_rename_hint)
            setText(currentTitle)
            selectAll()
            textSize = 18f
            setTextColor(dialogInputTextColor)
            setHintTextColor(dialogHintColor)
            gravity = Gravity.TOP or Gravity.START
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
            imeOptions = EditorInfo.IME_ACTION_DONE
            background = roundedRectangle(
                color = dialogInputColor,
                radiusDp = 6,
                strokeColor = dialogInputStrokeColor,
                strokeWidthDp = 1
            )
            setPadding(dp(18), dp(20), dp(18), dp(8))
        }

        fun submitRename() {
            val updatedTitle = LauncherAppRenamePolicy.submittedTitle(
                input = input.text?.toString().orEmpty(),
                currentTitle = currentTitle
            )
            dialog.dismiss()
            renameApplication(app, updatedTitle)
        }

        input.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                submitRename()
                true
            } else {
                false
            }
        }

        val container = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            background = roundedRectangle(dialogBackgroundColor, LauncherRenameUiPolicy.DIALOG_CORNER_RADIUS_DP)
            setPadding(
                dp(LauncherRenameUiPolicy.DIALOG_HORIZONTAL_PADDING_DP),
                dp(LauncherRenameUiPolicy.DIALOG_TOP_PADDING_DP),
                dp(LauncherRenameUiPolicy.DIALOG_HORIZONTAL_PADDING_DP),
                0
            )
            addView(
                TextView(context).apply {
                    text = getString(R.string.settings_rename)
                    setTextColor(dialogTitleColor)
                    textSize = 20f
                    typeface = Typeface.DEFAULT_BOLD
                    gravity = Gravity.START
                    includeFontPadding = false
                },
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            )
            addView(
                input,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dp(LauncherRenameUiPolicy.DIALOG_INPUT_HEIGHT_DP)
                ).apply {
                    topMargin = dp(28)
                }
            )
            addView(
                LinearLayout(context).apply {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER

                    fun createAction(label: String, onClick: () -> Unit): TextView {
                        return TextView(context).apply {
                            text = label
                            setTextColor(LauncherRenameUiPolicy.DIALOG_ACTION_COLOR)
                            textSize = 16f
                            typeface = Typeface.DEFAULT_BOLD
                            gravity = Gravity.CENTER
                            includeFontPadding = false
                            isClickable = true
                            isFocusable = true
                            setOnClickListener { onClick() }
                        }
                    }

                    addView(
                        createAction(getString(R.string.dialog_cancel)) { dialog.dismiss() },
                        LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
                    )
                    addView(
                        createAction(getString(R.string.dialog_ok)) { submitRename() },
                        LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
                    )
                },
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dp(LauncherRenameUiPolicy.DIALOG_BUTTON_HEIGHT_DP)
                ).apply {
                    topMargin = dp(22)
                }
            )
        }

        dialog.setContentView(container)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setOnShowListener {
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.setLayout(
                (resources.displayMetrics.widthPixels * LauncherRenameUiPolicy.DIALOG_WIDTH_PERCENT).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.window?.setSoftInputMode(android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
            input.requestFocus()
            (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
                ?.showSoftInput(input, InputMethodManager.SHOW_IMPLICIT)
            }
        dialog.show()
    }

    private fun renameApplication(app: ApplicationItem, updatedTitle: String) {
        val appKeys = renameKeysFor(app)
        LauncherAppRenamePreferences.save(this, appKeys, updatedTitle)
        applyRenamedTitleToLauncher(appKeys, updatedTitle)
        launcherLayoutRepository.saveLayouts(pages, mDock)
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
                val appView = page.getChildAt(i) as? BlissFrameLayout ?: continue
                collect(getAppDetails(appView))
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
                    AppViewBinding.bind(appView).appLabel.text = updatedTitle
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
        setLauncherOptionsBackgroundBlurEnabled(true)
        contextOverlay.alpha = 0f
        contextOverlay.visibility = VISIBLE
        contextOverlay.bringToFront()
        contextOverlay.animate().alpha(1f).setDuration(120L).start()

        showSelectedIconPreview(launcherItem, anchor)
    }

    private fun hideLauncherOptionsOverlay() {
        hideSelectedIconPreview()
        if (!::contextOverlay.isInitialized || contextOverlay.visibility != VISIBLE) {
            setLauncherOptionsBackgroundBlurEnabled(false)
            return
        }
        contextOverlay.animate().cancel()
        contextOverlay.animate()
            .alpha(0f)
            .setDuration(120L)
            .withEndAction {
                contextOverlay.visibility = GONE
                contextOverlay.alpha = 1f
                setLauncherOptionsBackgroundBlurEnabled(false)
            }
            .start()
    }

    private fun setLauncherOptionsBackgroundBlurEnabled(enabled: Boolean) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            return
        }
        val effect = if (enabled) {
            val radius = dp(22).toFloat()
            RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP)
        } else {
            null
        }
        if (::mHorizontalPager.isInitialized) {
            mHorizontalPager.setRenderEffect(effect)
        }
        if (::mDock.isInitialized) {
            mDock.setRenderEffect(effect)
        }
        if (::mIndicator.isInitialized) {
            mIndicator.setRenderEffect(effect)
        }
        if (!enabled) {
            setFolderBackgroundContentBlurEnabled(isFolderWindowActive())
        }
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
            if (LauncherUninstallConfirmationPolicy.shouldRequestSystemUninstall(
                    isApplication = true,
                    canUninstall = canShowUninstallOption(launcherItem)
                )
            ) {
                val componentName = launcherItem.getTargetComponent()
                if (componentName == null) {
                    Toast.makeText(this, getString(R.string.toast_cannot_uninstall), Toast.LENGTH_SHORT).show()
                    return
                }
                requestApplicationUninstall(componentName, launcherItem)
            } else {
                Toast.makeText(this, getString(R.string.toast_cannot_uninstall), Toast.LENGTH_SHORT).show()
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

    private fun requestApplicationUninstall(componentName: ComponentName, launcherItem: LauncherItem) {
        val packageUri = Uri.fromParts("package", componentName.packageName, null)
        val userHandle = launcherItem.user ?: UserHandle()
        fun Intent.withLauncherItemUser(): Intent = apply {
            putExtra(Intent.EXTRA_RETURN_RESULT, true)
            putExtra(Intent.EXTRA_USER, userHandle.getRealHandle())
        }
        val intent = Intent(Intent.ACTION_DELETE, packageUri).withLauncherItemUser()
        pendingApplicationUninstall = PendingApplicationUninstall(componentName.packageName, userHandle)
        val requestStarted = runCatching {
            startActivityForResult(intent, REQUEST_UNINSTALL_APP)
        }.onFailure {
            val fallbackIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageUri)
            runCatching { startActivity(fallbackIntent) }
                .onFailure {
                    pendingApplicationUninstall = null
                    Toast.makeText(this, getString(R.string.toast_cannot_uninstall), Toast.LENGTH_SHORT).show()
                }
        }.isSuccess

        if (LauncherUninstallConfirmationPolicy.shouldRemoveFromHomeAfterUninstallRequest(requestStarted)) {
            removeLauncherPackageFromHome(componentName.packageName, userHandle)
        }
    }

    private fun removeLauncherPackageFromHome(packageName: String, userHandle: UserHandle) {
        removePackageFromLauncher(packageName, userHandle)
    }

    private fun handleApplicationUninstallResult(resultCode: Int) {
        val pending = pendingApplicationUninstall ?: return
        val packageRemoved = !isLauncherPackageAvailable(pending.packageName, pending.userHandle)
        if (
            packageRemoved ||
            LauncherUninstallConfirmationPolicy.shouldRemoveFromHomeAfterUninstallResult(resultCode == RESULT_OK)
        ) {
            completePendingApplicationUninstall(pending)
        } else {
            pendingApplicationUninstall = null
        }
    }

    private fun verifyPendingApplicationUninstall() {
        val pending = pendingApplicationUninstall ?: return
        if (!isLauncherPackageAvailable(pending.packageName, pending.userHandle)) {
            completePendingApplicationUninstall(pending)
        }
    }

    private fun completePendingApplicationUninstallIfMatches(
        packageName: String,
        userHandle: UserHandle
    ): Boolean {
        val pending = pendingApplicationUninstall ?: return false
        if (pending.packageName != packageName || !pending.userHandle.isSameUser(userHandle)) {
            return false
        }
        completePendingApplicationUninstall(pending)
        return true
    }

    private fun completePendingApplicationUninstall(pending: PendingApplicationUninstall) {
        removeLauncherPackageFromHome(pending.packageName, pending.userHandle)
        pendingApplicationUninstall = null
        Toast.makeText(this, getString(R.string.toast_uninstall_success), Toast.LENGTH_SHORT).show()
    }

    private fun isLauncherPackageAvailable(packageName: String, userHandle: UserHandle): Boolean =
        runCatching {
            launcherSystemRepository.isLauncherPackageAvailable(packageName, userHandle.getRealHandle())
        }.getOrDefault(true)

    fun prepareSuggestedApp(launcherItem: LauncherItem): BlissFrameLayout {
        val appBinding = AppViewBinding.inflate(layoutInflater)
        val view = appBinding.root
        view.launcherItem = launcherItem
        val icon = appBinding.appIcon

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
                if (
                    LauncherSelfLaunchPolicy.shouldOpenLauncherMenu(
                        itemPackageName = applicationItem.packageName,
                        targetPackageName = intent.component?.packageName,
                        launcherPackageName = packageName
                    )
                ) {
                    openLauncherMenu(context)
                    return
                }
                if (user == null || user == Process.myUserHandle()) {
                    context.startActivity(intent)
                } else {
                    launcherSystemRepository.startMainActivity(
                        intent.component,
                        user,
                        intent.sourceBounds
                    )
                }
            }
        }
    }

    private fun openLauncherMenu(context: Context) {
        val menuIntent = Intent().setClassName(
            packageName,
            LauncherSelfLaunchPolicy.MENU_ACTIVITY_CLASS
        )
        if (context !is Activity) {
            menuIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(menuIntent)
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

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (
            HomeWidgetInteractionPolicy.shouldCaptureGlobalDragMotion(
                active = homeWidgetTouchDragActive,
                action = homeWidgetGlobalTouchAction(event)
            )
        ) {
            return handleHomeWidgetTouchDragMotion(mLauncherView, event)
        }
        if (handleHomeWidgetRemoveButtonGlobalTouch(event)) {
            return true
        }
        return super.dispatchTouchEvent(event)
    }

    private fun homeWidgetGlobalTouchAction(event: MotionEvent): HomeWidgetInteractionPolicy.TouchAction {
        return when (event.actionMasked) {
            MotionEvent.ACTION_MOVE -> HomeWidgetInteractionPolicy.TouchAction.MOVE
            MotionEvent.ACTION_UP -> HomeWidgetInteractionPolicy.TouchAction.UP
            MotionEvent.ACTION_CANCEL -> HomeWidgetInteractionPolicy.TouchAction.CANCEL
            else -> HomeWidgetInteractionPolicy.TouchAction.OTHER
        }
    }

    private fun handleHomeWidgetRemoveButtonGlobalTouch(event: MotionEvent): Boolean {
        val trackedHost = homeWidgetRemoveTouchHost
        val hitHost = findHomeWidgetRemoveHostAtRawPoint(event.rawX, event.rawY)
        val targetHost = trackedHost ?: hitHost
        val hitRemoveButton = targetHost != null && targetHost === hitHost
        val decision = HomeWidgetRemoveTouchPolicy.decide(
            action = homeWidgetRemoveTouchAction(event),
            editing = isWobbling,
            draggingWidget = homeWidgetDragSpec != null,
            hitRemoveButton = hitRemoveButton,
            trackingRemoveButton = trackedHost != null
        )
        if (!decision.consume) {
            return false
        }
        homeWidgetRemoveTouchHost = if (decision.trackRemoveButton) targetHost else null
        val removeButton = targetHost?.findViewWithTag<View>(HOME_WIDGET_REMOVE_TAG)
        removeButton?.isPressed = decision.pressed
        if (decision.remove && targetHost != null) {
            removeHomeWidgetFromHost(targetHost)
        }
        return true
    }

    private fun findHomeWidgetRemoveHostAtRawPoint(rawX: Float, rawY: Float): FrameLayout? {
        pages.asReversed().forEach { page ->
            for (index in page.childCount - 1 downTo 0) {
                val host = page.getChildAt(index) as? FrameLayout ?: continue
                if (host.tag !is HomeWidgetPreferences.Item) {
                    continue
                }
                val removeButton = host.findViewWithTag<View>(HOME_WIDGET_REMOVE_TAG) ?: continue
                if (
                    removeButton.visibility == VISIBLE &&
                    removeButton.isShown &&
                    rawPointInsideHomeWidgetRemoveTarget(host, rawX, rawY)
                ) {
                    return host
                }
            }
        }
        return null
    }

    private fun handleWobbling(shouldPlay: Boolean) {
        if (shouldPlay) {
            dismissHomeWidgetOptionsPopup()
            dismissLauncherOptionsPopup()
            forceHideContextOverlayImmediately()
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
            refreshOpenFolderLiquidGlassIfNeeded()
        }

        for (page in pages) {
            applyHomePageGridPadding(page, shouldPlay)
            relayoutHomePageCells(page)
            toggleWobbleAnimation(page, shouldPlay)
        }
        applyHomeWidgetEditState()
        toggleWobbleAnimation(mDock, shouldPlay)
        setEditTopBarVisible(shouldPlay)
        if (shouldPlay) {
            hideHomeWidgetEntryCard()
        } else {
            hideHomeWidgetEntryCard()
            forceStopHomeWidgetEditing()
        }

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
            val blissFrameLayout = gridLayout.getChildAt(i) as? BlissFrameLayout ?: continue
            makeAppWobble(blissFrameLayout, shouldPlayAnimation, i)
        }
    }

    private fun setHomeWidgetDragIconJiggleReduced(reduced: Boolean) {
        if (homeWidgetDragReducedIconJiggle == reduced) {
            return
        }
        homeWidgetDragReducedIconJiggle = reduced
        if (!isWobbling) {
            return
        }
        pages.forEach { page ->
            restartWobbleAnimation(page)
        }
        if (::mDock.isInitialized) {
            restartWobbleAnimation(mDock)
        }
    }

    private fun restartWobbleAnimation(gridLayout: GridLayout) {
        for (i in 0 until gridLayout.childCount) {
            val blissFrameLayout = gridLayout.getChildAt(i) as? BlissFrameLayout ?: continue
            blissFrameLayout.clearAnimation()
            makeAppWobble(blissFrameLayout, true, i)
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
                val removeView = blissFrameLayout.findViewById<View?>(R.id.uninstall_app)
                if (removeView == null && !uninstallDisabled) {
                    Handler(Looper.getMainLooper()).post { addUninstallIcon(blissFrameLayout) }
                }

                val forwardWobble = if (homeWidgetDragReducedIconJiggle) {
                    widgetDragWobbleAnimation
                } else {
                    wobbleAnimation
                }
                val reverseWobble = if (homeWidgetDragReducedIconJiggle) {
                    widgetDragWobbleReverseAnimation
                } else {
                    wobbleReverseAnimation
                }
                if (i % 2 == 0) {
                    blissFrameLayout.startAnimation(forwardWobble)
                } else {
                    blissFrameLayout.startAnimation(reverseWobble)
                }
            }
        } else {
            blissFrameLayout.clearAnimation()
            Handler(Looper.getMainLooper()).post { removeUninstallIcon(blissFrameLayout) }
        }
    }

    private fun removeUninstallIcon(blissFrameLayout: BlissFrameLayout?) {
        val removeView = blissFrameLayout?.findViewById<View?>(R.id.uninstall_app)
        if (removeView != null) {
            (removeView.parent as ViewGroup).removeView(removeView)
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

        val appIcon = AppViewBinding.bind(blissFrameLayout).appIcon
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

        val badgeStyle = LauncherLiquidGlassStylePolicy.removeBadge(
            enabled = false,
            darkMode = darkModeEnabled,
            liquidGlass = false
        )
        val badgeOuter = FrameLayout(this).apply {
            id = R.id.uninstall_app
            setPadding(leftPadding, topPadding, rightPadding, bottomPadding)
            isClickable = true
            isFocusable = true
            setOnClickListener { uninstallLauncherItem(launcherItem, blissFrameLayout) }
        }
        val badgeSurface = LauncherRealtimeLiquidGlassLayout(this).apply {
            blurCornerRadius = dp(badgeStyle.radiusDp).toFloat()
            background = roundedRectangle(badgeStyle)
            applyRealtimeLiquidGlass(
                enabled = LauncherRealtimeLiquidGlassPolicy.shouldUseRealtimeRemoveBadge(
                    realtimeEnabled = shouldUseRealtimeLiquidGlass()
                ),
                source = realtimeLiquidGlassSource(),
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.REMOVE_BADGE,
                profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
                    surface = LauncherRealtimeLiquidGlassPolicy.Surface.REMOVE_BADGE,
                    radiusDp = badgeStyle.radiusDp,
                    darkMode = darkModeEnabled
                )
            )
        }
        badgeSurface.addView(
            ImageView(this).apply {
                setImageResource(R.drawable.ic_minus_18)
                setColorFilter(0xFF5A5A5F.toInt())
                scaleType = ImageView.ScaleType.CENTER
                contentDescription = null
            },
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        badgeOuter.addView(
            badgeSurface,
            FrameLayout.LayoutParams(size, size)
        )
        val layoutParams = FrameLayout.LayoutParams(size + 2 * rightPadding, size + 2 * topPadding)
        layoutParams.gravity = Gravity.START or Gravity.TOP
        blissFrameLayout.addView(badgeOuter, layoutParams)
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
        launcherLayoutRepository.removeLauncherItem(shortcutItem.id)
        if (mFolderWindowContainer.visibility == VISIBLE) {
            val folder = activeFolder ?: return
            val folderView = activeFolderView ?: return
            folder.items!!.remove(shortcutItem)
            mFolderAppsViewPager.adapter?.notifyDataSetChanged()
            blissFrameLayout.clearAnimation()
            (blissFrameLayout.parent as ViewGroup).removeView(blissFrameLayout)
            when (FolderDragSessionPolicy.folderResultAfterRemovingItem(folder.items!!.size)) {
                FolderDragSessionPolicy.FolderResultAfterRemovingItem.REMOVE_FOLDER -> {
                    removeFolderView(folder, folderView)
                    hideFolderWindowContainer()
                }
                FolderDragSessionPolicy.FolderResultAfterRemovingItem.REPLACE_WITH_REMAINING_ITEM -> {
                    collapseFolderToRemainingItem(folder, folderView, folderFromDock)
                    hideFolderWindowContainer()
                }
                FolderDragSessionPolicy.FolderResultAfterRemovingItem.KEEP_FOLDER -> {
                    updateIcon(folderView, folder, GraphicsUtil(this).generateFolderIcon(this, folder), folderFromDock)
                    hideFolderWindowContainer()
                }
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
                if (homeWidgetDragSpec != null) {
                    return handleHomeWidgetDragEvent(view, dragEvent)
                }
                val moving = movingApp
                val shadow = dragShadowBuilder
                if (dragEvent.action == DragEvent.ACTION_DRAG_STARTED) {
                    isDragging = true
                    updateDragEdgeGlows(true)
                    mWobblingCountDownTimer?.cancel()
                    resetFolderHoverDragState()
                    moving?.let { beginExistingFolderItemDragSessionIfNeeded(it) }
                } else if (dragEvent.action == DragEvent.ACTION_DRAG_LOCATION) {
                    if (moving == null || shadow == null) return true
                    updateDragEdgeGlows(true)
                    cX = dragEvent.x - shadow.xOffset
                    cY = mDock.y + dragEvent.y - shadow.yOffset

                    if (mFolderWindowContainer.visibility == VISIBLE) {
                        handleFolderDragLocation(cX, cY)
                        return true
                    }

                    if (getAppDetails(moving).container != Constants.CONTAINER_DESKTOP.toLong() &&
                        getAppDetails(moving).container != Constants.CONTAINER_HOTSEAT.toLong()
                    ) {
                        return true
                    }

                    if (!dragDropEnabled) {
                        return true
                    }

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
                            cancelFolderHoverOpen()
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
                                scheduleFolderHoverOpenIfNeeded(collidingApp, fromDock = true)
                            } else {
                                cancelFolderHoverOpen()
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
                    updateDragEdgeGlows(false)
                    if (moving == null || shadow == null) return true
                    cancelFolderHoverOpen()
                    cleanupDockReorder(true)
                    cleanupReorder(true)
                    cleanupFolderReorder(true)
                    cX = dragEvent.x - shadow.xOffset
                    cY = mDock.y + dragEvent.y - shadow.yOffset
                    val activeSession = folderDragSession
                    if (activeSession != null && mFolderWindowContainer.visibility == VISIBLE) {
                        if (isPointInsideOpenFolderPanel(cX, cY)) {
                            previewFolderDrop(activeSession, mFolderAppsViewPager.currentItem, folderDropCellForCurrentPage(cX, cY))
                            commitFolderDropInside(activeSession)
                            moving.visibility = VISIBLE
                        } else {
                            handleFolderDragExitToHome(activeSession, cX, cY)
                            if (mDock.childCount < mDeviceProfile.numColumns || moving.parent === mDock) {
                                (moving.parent as? ViewGroup)?.removeView(moving)
                                addAppToDock(moving, getIndex(mDock, cX, cY))
                } else if (dragEvent.action == DragEvent.ACTION_DRAG_ENDED) {
                    updateDragEdgeGlows(false)
                    return true
                }
                            moving.visibility = VISIBLE
                            makeAppWobble(moving, true, mDock.indexOfChild(moving))
                            commitFolderDropOutside(activeSession)
                        }
                        return true
                    }

                    if (mFolderWindowContainer.visibility != VISIBLE) {
                        val exitedSession = folderDragSession?.takeIf { it.exitedToHome }
                        if (exitedSession != null) {
                            if (mDock.childCount < mDeviceProfile.numColumns || moving.parent === mDock) {
                                (moving.parent as? ViewGroup)?.removeView(moving)
                                addAppToDock(moving, getIndex(mDock, cX, cY))
                            }
                            moving.visibility = VISIBLE
                            makeAppWobble(moving, true, mDock.indexOfChild(moving))
                            commitFolderDropOutside(exitedSession)
                            return true
                        }

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
                            val fromDock = !((collidingApp?.parent as? View)?.parent is HorizontalPager)
                            if (shouldAnimateFolderDrop()) {
                                createOrUpdateFolderWithDropArc(fromDock, cX, cY)
                            } else if (fromDock) {
                                createOrUpdateFolder(true)
                            } else {
                                createOrUpdateFolder(false)
                            }
                            folderInterest = false
                        }
                    } else {
                        if (!isPointInsideOpenFolderPanel(cX, cY)) {
                            if (isMovingExternalToOpenFolder(moving)) {
                                hideFolderWindowContainer()
                                folderOpenedByDragHover = false
                                dragHasEnteredOpenFolder = false
                                restoreExternalMovingView(moving)
                            } else {
                                removeAppFromFolder()
                            }
                        } else if (commitExternalDropIntoOpenFolder(moving)) {
                            moving.visibility = VISIBLE
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
                if (homeWidgetDragSpec != null) {
                    return handleHomeWidgetDragEvent(view, dragEvent)
                }
                val moving = movingApp
                val shadow = dragShadowBuilder
                if (dragEvent.action == DragEvent.ACTION_DRAG_STARTED) {
                    isDragging = true
                    updateDragEdgeGlows(true)
                    mWobblingCountDownTimer?.cancel()
                    resetFolderHoverDragState()
                    moving?.let { beginExistingFolderItemDragSessionIfNeeded(it) }
                } else if (dragEvent.action == DragEvent.ACTION_DRAG_LOCATION) {
                    if (moving == null || shadow == null) return true
                    updateDragEdgeGlows(true)
                    cX = dragEvent.x - shadow.xOffset
                    cY = mHorizontalPager.y + dragEvent.y - shadow.yOffset

                    if (mFolderWindowContainer.visibility == VISIBLE) {
                        handleFolderDragLocation(cX, cY)
                        return true
                    }

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
                                cancelFolderHoverOpen()
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
                                    scheduleFolderHoverOpenIfNeeded(collidingApp, fromDock = false)
                                } else {
                                    cancelFolderHoverOpen()
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
                    updateDragEdgeGlows(false)
                    if (moving == null || shadow == null) return true
                    cancelFolderHoverOpen()
                    cleanupReorder(true)
                    cleanupDockReorder(true)
                    cleanupFolderReorder(true)
                    cX = dragEvent.x - shadow.xOffset
                    cY = mHorizontalPager.y + dragEvent.y - shadow.yOffset
                    val activeSession = folderDragSession
                    if (activeSession != null && mFolderWindowContainer.visibility == VISIBLE) {
                        if (isPointInsideOpenFolderPanel(cX, cY)) {
                            previewFolderDrop(activeSession, mFolderAppsViewPager.currentItem, folderDropCellForCurrentPage(cX, cY))
                            commitFolderDropInside(activeSession)
                            moving.visibility = VISIBLE
                        } else {
                            handleFolderDragExitToHome(activeSession, cX, cY)
                            val gridLayout = pages[getCurrentAppsPageNumber()]
                            commitDroppedAppToPage(gridLayout, moving, cX, cY)
                            moving.visibility = VISIBLE
                            makeAppWobble(moving, true, gridLayout.indexOfChild(moving))
                            commitFolderDropOutside(activeSession)
                        }
                        return true
                    }

                    if (mFolderWindowContainer.visibility != VISIBLE) {
                        val gridLayout = pages[getCurrentAppsPageNumber()]
                        val exitedSession = folderDragSession?.takeIf { it.exitedToHome }
                        if (exitedSession != null) {
                            commitDroppedAppToPage(gridLayout, moving, cX, cY)
                            moving.visibility = VISIBLE
                            makeAppWobble(moving, true, gridLayout.indexOfChild(moving))
                            commitFolderDropOutside(exitedSession)
                            return true
                        }

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
                            val fromDock = !((collidingApp?.parent as? View)?.parent is HorizontalPager)
                            if (shouldAnimateFolderDrop()) {
                                createOrUpdateFolderWithDropArc(fromDock, cX, cY)
                            } else if (fromDock) {
                                createOrUpdateFolder(true)
                            } else {
                                createOrUpdateFolder(false)
                            }
                            folderInterest = false
                        }
                    } else {
                        if (!isPointInsideOpenFolderPanel(cX, cY)) {
                            if (isMovingExternalToOpenFolder(moving)) {
                                hideFolderWindowContainer()
                                folderOpenedByDragHover = false
                                dragHasEnteredOpenFolder = false
                                restoreExternalMovingView(moving)
                            } else {
                                removeAppFromFolder()
                            }
                        } else if (commitExternalDropIntoOpenFolder(moving)) {
                            moving.visibility = VISIBLE
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
                    updateDragEdgeGlows(false)
                    if (moving == null) return true
                    if (isDragging) {
                        isDragging = false
                    }

                    cleanupReorder(true)
                    cleanupDockReorder(true)
                    cleanupFolderReorder(true)
                    cancelFolderHoverOpen()

                    if (!dragEvent.result) {
                        if (folderDragSession != null) {
                            cancelFolderDragSession(restoreOriginal = true)
                            if (mFolderWindowContainer.visibility == VISIBLE && folderOpenedByDragHover) {
                                hideFolderWindowContainer(saveLayout = false)
                            }
                        } else if (mFolderWindowContainer.visibility == VISIBLE && isMovingExternalToOpenFolder(moving)) {
                            hideFolderWindowContainer()
                            restoreExternalMovingView(moving)
                            folderOpenedByDragHover = false
                            dragHasEnteredOpenFolder = false
                        } else if (mFolderWindowContainer.visibility == VISIBLE) {
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
                        resetFolderHoverDragState()
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
                    launcherLayoutRepository.saveLayouts(pages, mDock)
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

    private fun scheduleFolderHoverOpenIfNeeded(target: BlissFrameLayout?, fromDock: Boolean) {
        val moving = movingApp ?: return
        val hoverTarget = target ?: return
        val targetItem = hoverTarget.launcherItem
        val canOpenFolder = FolderHoverOpenPolicy.canScheduleOpen(
            folderInterest = folderInterest,
            movingItemType = moving.launcherItem.itemType,
            targetItemType = targetItem.itemType,
            folderAlreadyOpen = mFolderWindowContainer.visibility == VISIBLE
        )
        val canPreviewFolderCreation = FolderHoverOpenPolicy.canScheduleCreationPreview(
            folderInterest = folderInterest,
            movingItemType = moving.launcherItem.itemType,
            targetItemType = targetItem.itemType,
            folderAlreadyOpen = mFolderWindowContainer.visibility == VISIBLE,
            previewAlreadyShownForTarget = folderCreationPreviewTarget === hoverTarget
        )
        if (!canOpenFolder && !canPreviewFolderCreation) {
            cancelFolderHoverOpen()
            return
        }

        if (folderHoverTarget === hoverTarget && mFolderHoverOpenAlarm.alarmPending()) {
            return
        }

        cancelFolderHoverOpen()
        folderHoverTarget = hoverTarget
        mFolderHoverOpenAlarm.setOnAlarmListener(FolderHoverOpenAlarmListener(hoverTarget, fromDock))
        mFolderHoverOpenAlarm.setAlarm(FolderHoverOpenPolicy.OPEN_DELAY_MS)
    }

    private fun cancelFolderHoverOpen() {
        mFolderHoverOpenAlarm.cancelAlarm()
        folderHoverTarget = null
    }

    private fun resetFolderHoverDragState(closeOpenFolder: Boolean = false) {
        cancelFolderHoverOpen()
        folderCreationPreviewTarget = null
        if (closeOpenFolder && folderOpenedByDragHover && mFolderWindowContainer.visibility == VISIBLE) {
            hideFolderWindowContainer()
        }
        folderOpenedByDragHover = false
        dragHasEnteredOpenFolder = false
    }

    private fun handleOpenFolderDragLocation(x: Float, y: Float) {
        if (!folderOpenedByDragHover) {
            return
        }

        if (isPointInsideOpenFolderPanel(x, y)) {
            dragHasEnteredOpenFolder = true
            return
        }

        val panelBounds = folderPanelBoundsOnScreen()
        if (FolderDragSessionPolicy.shouldExitHoverOpenedFolder(
                x = x,
                y = y,
                left = panelBounds.left,
                top = panelBounds.top,
                right = panelBounds.right,
                bottom = panelBounds.bottom,
                thresholdPx = dp(48),
                hasEnteredOpenFolder = dragHasEnteredOpenFolder
            )
        ) {
            hideFolderWindowContainer()
            folderOpenedByDragHover = false
            dragHasEnteredOpenFolder = false
        }
    }

    private fun isPointInsideOpenFolder(x: Float, y: Float): Boolean {
        return isPointInsideBounds(folderBoundsOnScreen(), x, y)
    }

    private fun isPointInsideOpenFolderPanel(x: Float, y: Float): Boolean {
        return isPointInsideBounds(folderPanelBoundsOnScreen(), x, y)
    }

    private fun isPointInsideBounds(bounds: Rect, x: Float, y: Float): Boolean {
        return bounds.left < bounds.right &&
            bounds.top < bounds.bottom &&
            x >= bounds.left &&
            x < bounds.right &&
            y >= bounds.top &&
            y < bounds.bottom
    }

    private fun isMovingExternalToOpenFolder(moving: BlissFrameLayout): Boolean {
        val folder = activeFolder ?: return false
        return FolderHoverOpenPolicy.isExternalDropIntoOpenFolder(getAppDetails(moving), folder)
    }

    private fun commitExternalDropIntoOpenFolder(moving: BlissFrameLayout): Boolean {
        val folder = activeFolder ?: return false
        val folderView = activeFolderView ?: return false
        if (!FolderHoverOpenPolicy.isExternalDropIntoOpenFolder(getAppDetails(moving), folder)) {
            return false
        }

        val folderId = folder.id.toLongOrNull() ?: return false
        val app = getAppDetails(moving)
        (moving.parent as? ViewGroup)?.removeView(moving)
        app.container = folderId
        app.screenId = -1
        app.cell = folder.items!!.size
        folder.items!!.add(app)
        updateIcon(folderView, folder, GraphicsUtil(this).generateFolderIcon(this, folder), folderFromDock)
        folderView.applyBadge(checkHasApp(folder, mAppsWithNotifications), !folderFromDock)
        refreshOpenFolderAdapter(folder)
        launcherLayoutRepository.saveLayouts(pages, mDock)
        folderOpenedByDragHover = false
        dragHasEnteredOpenFolder = false
        return true
    }

    private fun restoreExternalMovingView(moving: BlissFrameLayout) {
        moving.visibility = VISIBLE
        val parent = moving.parent as? ViewGroup ?: return
        val fromDock = parent === mDock
        makeAppWobble(moving, true, parent.indexOfChild(moving))
        if (!fromDock && parent is GridLayout) {
            relayoutHomePageCells(parent)
        }
    }

    private fun refreshOpenFolderAdapter(folder: FolderItem) {
        mFolderAppsViewPager.adapter = FolderAppsPagerAdapter(this, folder.items!!)
        binding.indicator.setViewPager(mFolderAppsViewPager)
        if (isWobbling) {
            mFolderAppsViewPager.post {
                for (i in 0 until mFolderAppsViewPager.childCount) {
                    (mFolderAppsViewPager.getChildAt(i) as? GridLayout)?.let { page ->
                        toggleWobbleAnimation(page, true)
                    }
                }
            }
        }
        refreshOpenFolderLiquidGlassIfNeeded()
    }

    private fun mutableFolderItems(folder: FolderItem): MutableList<LauncherItem> {
        val items = folder.items
        if (items != null) {
            return items
        }
        val newItems = ArrayList<LauncherItem>()
        folder.items = newItems
        return newItems
    }

    private fun folderItemKey(item: LauncherItem): String =
        item.id.ifBlank { System.identityHashCode(item).toString() }

    private fun beginFolderDragSession(
        folder: FolderItem,
        folderView: BlissFrameLayout,
        moving: BlissFrameLayout,
        origin: FolderDragOrigin
    ): FolderDragSession {
        folderDragSession?.let { existing ->
            if (existing.folder === folder && existing.moving === moving) {
                existing.exitedToHome = false
                existing.hasEnteredFolder = false
                existing.previewAddedToFolder = mutableFolderItems(folder).contains(moving.launcherItem)
                existing.lastPreviewCell = LauncherItem.INVALID_CELL
            }
            return existing
        }
        val originParent = moving.parent as? ViewGroup
        val items = mutableFolderItems(folder)
        val session = FolderDragSession(
            folder = folder,
            folderView = folderView,
            moving = moving,
            origin = origin,
            originParent = originParent,
            originIndex = originParent?.indexOfChild(moving) ?: LauncherItem.INVALID_CELL,
            originContainer = moving.launcherItem.container,
            originScreenId = moving.launcherItem.screenId,
            originCell = moving.launcherItem.cell,
            originalFolderItems = items.toList(),
            originalFolderCells = items.associate { folderItemKey(it) to it.cell },
            folderWasFromDock = folderFromDock
        )
        folderDragSession = session
        if (origin == FolderDragOrigin.WITHIN_FOLDER) {
            originParent?.removeView(moving)
            originParent?.requestLayout()
        }
        return session
    }

    private fun beginExistingFolderItemDragSessionIfNeeded(moving: BlissFrameLayout) {
        if (folderDragSession != null || mFolderWindowContainer.visibility != VISIBLE) {
            return
        }
        val folder = activeFolder ?: return
        val folderView = activeFolderView ?: return
        val folderId = folder.id.toLongOrNull() ?: return
        if (moving.launcherItem.container == folderId) {
            beginFolderDragSession(folder, folderView, moving, FolderDragOrigin.WITHIN_FOLDER)
        }
    }

    private fun resetFolderItemsToOriginal(session: FolderDragSession) {
        val folderId = session.folder.id.toLongOrNull()
        val items = mutableFolderItems(session.folder)
        items.clear()
        session.originalFolderItems.forEachIndexed { index, item ->
            item.container = folderId ?: item.container
            item.screenId = -1
            item.cell = session.originalFolderCells[folderItemKey(item)] ?: index
            items.add(item)
        }
    }

    private fun restoreMovingToOrigin(session: FolderDragSession) {
        val moving = session.moving
        moving.launcherItem.container = session.originContainer
        moving.launcherItem.screenId = session.originScreenId
        moving.launcherItem.cell = session.originCell
        (moving.parent as? ViewGroup)?.removeView(moving)
        val originParent = session.originParent
        if (session.origin == FolderDragOrigin.FROM_HOME_TO_FOLDER && originParent != null) {
            if (originParent === mDock) {
                addAppToDock(moving, session.originIndex)
            } else if (originParent is GridLayout && pages.contains(originParent)) {
                addAppToGrid(originParent, moving, session.originIndex)
                relayoutHomePageCells(originParent)
            }
        }
        moving.visibility = VISIBLE
    }

    private fun cancelFolderDragSession(restoreOriginal: Boolean) {
        val session = folderDragSession ?: return
        cleanupFolderReorder(true)
        cancelFolderPageScroll()
        if (restoreOriginal) {
            resetFolderItemsToOriginal(session)
            restoreMovingToOrigin(session)
            refreshFolderViewAfterItemsChanged(session)
        }
        folderDragSession = null
    }

    private fun finishFolderDragSession() {
        cleanupFolderReorder(true)
        cancelFolderPageScroll()
        folderPageScrollTarget = LauncherItem.INVALID_CELL
        folderDragSession = null
    }

    private fun refreshFolderViewAfterItemsChanged(session: FolderDragSession) {
        if (session.folder.items?.isNotEmpty() == true) {
            updateIcon(
                session.folderView,
                session.folder,
                GraphicsUtil(this).generateFolderIcon(this, session.folder),
                session.folderWasFromDock
            )
            session.folderView.applyBadge(checkHasApp(session.folder, mAppsWithNotifications), !session.folderWasFromDock)
        }
        refreshOpenFolderAdapter(session.folder)
    }

    private fun normalizeFolderItemOrder(folder: FolderItem) {
        val items = mutableFolderItems(folder)
        val orderedItems = items
            .mapIndexed { index, item -> index to item }
            .sortedWith(
                compareBy<Pair<Int, LauncherItem>> { (_, item) ->
                    item.cell.takeIf { it >= 0 } ?: Int.MAX_VALUE
                }.thenBy { (index, _) -> index }
            )
            .map { it.second }
        items.clear()
        orderedItems.forEachIndexed { index, item ->
            item.container = folder.id.toLongOrNull() ?: item.container
            item.screenId = -1
            item.cell = index
            items.add(item)
        }
    }

    private fun folderBoundsOnScreen(): Rect {
        val topLeft = IntArray(2)
        mFolderAppsViewPager.getLocationOnScreen(topLeft)
        return Rect(
            topLeft[0],
            topLeft[1],
            topLeft[0] + mFolderAppsViewPager.width,
            topLeft[1] + mFolderAppsViewPager.height
        )
    }

    private fun folderPanelBoundsOnScreen(): Rect {
        val folderBackground = binding.folderAppsBackground
        val topLeft = IntArray(2)
        folderBackground.getLocationOnScreen(topLeft)
        val bounds = Rect(
            topLeft[0],
            topLeft[1],
            topLeft[0] + folderBackground.width,
            topLeft[1] + folderBackground.height
        )
        return if (bounds.left < bounds.right && bounds.top < bounds.bottom) {
            bounds
        } else {
            folderBoundsOnScreen()
        }
    }

    private fun currentFolderGrid(): GridLayout? {
        val currentPage = mFolderAppsViewPager.currentItem
        return folderGridForPage(currentPage)
    }

    private fun folderGridForPage(pageIndex: Int): GridLayout? {
        for (index in 0 until mFolderAppsViewPager.childCount) {
            val child = mFolderAppsViewPager.getChildAt(index)
            if (child is GridLayout && child.tag == pageIndex) {
                return child
            }
        }
        return mFolderAppsViewPager.getChildAt(pageIndex) as? GridLayout
    }

    private fun applyFolderCellLayoutParams(
        view: BlissFrameLayout,
        absoluteCell: Int,
        metrics: FolderOpenLayoutPolicy.Metrics
    ) {
        val cellInPage = FolderDragSessionPolicy.cellInPage(absoluteCell)
        val layoutParams = GridLayout.LayoutParams(
            GridLayout.spec(cellInPage / FolderDragSessionPolicy.FOLDER_COLUMNS),
            GridLayout.spec(cellInPage % FolderDragSessionPolicy.FOLDER_COLUMNS)
        )
        layoutParams.height = metrics.cellHeight
        layoutParams.width = metrics.cellWidth
        AppViewBinding.bind(view).appLabel.visibility = VISIBLE
        view.layoutParams = layoutParams
    }

    private fun relayoutOpenFolderPageCells(session: FolderDragSession, pageIndex: Int): Boolean {
        val grid = folderGridForPage(pageIndex) ?: return false
        val metrics = folderOpenMetrics()
        var needsAdapterRefresh = false
        for (index in grid.childCount - 1 downTo 0) {
            val child = grid.getChildAt(index) as? BlissFrameLayout ?: continue
            val item = child.launcherItem
            val absoluteCell = item.cell.takeIf { it >= 0 } ?: index
            if (FolderDragSessionPolicy.pageForCell(absoluteCell) != pageIndex) {
                needsAdapterRefresh = true
            } else if (!FolderDragSessionPolicy.shouldRenderFolderItem(
                    itemIsMoving = item === session.moving.launcherItem,
                    folderDragActive = folderDragSession === session
                )
            ) {
                grid.removeView(child)
            } else {
                child.visibility = VISIBLE
                applyFolderCellLayoutParams(child, absoluteCell, metrics)
            }
        }
        grid.requestLayout()
        return !needsAdapterRefresh
    }

    private fun folderDropCellForCurrentPage(x: Float, y: Float): Int {
        val grid = currentFolderGrid()
        val bounds = folderBoundsOnScreen()
        val metrics = folderOpenMetrics()
        val localX = (x - bounds.left - (grid?.paddingLeft ?: 0)).coerceAtLeast(0f)
        val localY = (y - bounds.top - (grid?.paddingTop ?: 0)).coerceAtLeast(0f)
        val column = (localX / metrics.cellWidth).toInt()
            .coerceIn(0, FolderDragSessionPolicy.FOLDER_COLUMNS - 1)
        val row = (localY / metrics.cellHeight).toInt()
            .coerceIn(0, FolderDragSessionPolicy.FOLDER_ROWS - 1)
        return row * FolderDragSessionPolicy.FOLDER_COLUMNS + column
    }

    private fun folderOccupiedCells(folder: FolderItem, except: LauncherItem? = null): Set<Int> {
        val occupiedCells = mutableSetOf<Int>()
        mutableFolderItems(folder).forEachIndexed { index, item ->
            if (item === except) {
                return@forEachIndexed
            }
            val cell = item.cell.takeIf { it >= 0 } ?: index
            occupiedCells.add(cell)
        }
        return occupiedCells
    }

    private fun ensureFolderPageForCell(session: FolderDragSession, absoluteCell: Int) {
        val targetPage = FolderDragSessionPolicy.pageForCell(absoluteCell)
        val adapterCount = mFolderAppsViewPager.adapter?.count ?: 0
        if (targetPage >= adapterCount) {
            refreshOpenFolderAdapter(session.folder)
        }
        if (mFolderAppsViewPager.currentItem != targetPage) {
            mFolderAppsViewPager.currentItem = targetPage
        }
    }

    private fun ensureMovingInFolderPreview(session: FolderDragSession, absoluteCell: Int) {
        val folderId = session.folder.id.toLongOrNull() ?: return
        val movingItem = session.moving.launcherItem
        val folderItems = mutableFolderItems(session.folder)
        if (session.origin == FolderDragOrigin.FROM_HOME_TO_FOLDER && !session.previewAddedToFolder) {
            (session.moving.parent as? ViewGroup)?.removeView(session.moving)
            movingItem.container = folderId
            movingItem.screenId = -1
            movingItem.cell = absoluteCell
            if (!folderItems.contains(movingItem)) {
                folderItems.add(movingItem)
            }
            session.previewAddedToFolder = true
        } else if (session.origin == FolderDragOrigin.WITHIN_FOLDER && !folderItems.contains(movingItem)) {
            (session.moving.parent as? ViewGroup)?.removeView(session.moving)
            movingItem.container = folderId
            movingItem.screenId = -1
            movingItem.cell = absoluteCell
            folderItems.add(movingItem)
            session.previewAddedToFolder = true
        }
    }

    private fun previewFolderDrop(session: FolderDragSession, targetPage: Int, targetCell: Int) {
        val movingItem = session.moving.launcherItem
        val absoluteCell = FolderDragSessionPolicy.absoluteCell(targetPage, targetCell)
        if (session.lastPreviewCell == absoluteCell && session.hasEnteredFolder) {
            return
        }

        val oldPageCount = mFolderAppsViewPager.adapter?.count ?: 1
        val oldMovingPage = movingItem.cell
            .takeIf { it >= 0 }
            ?.let { FolderDragSessionPolicy.pageForCell(it) }
            ?: targetPage
        val wasInFolder = mutableFolderItems(session.folder).contains(movingItem)
        ensureMovingInFolderPreview(session, absoluteCell)
        val occupiedCells = folderOccupiedCells(session.folder, except = movingItem)
        val maxCells = maxOf(
            (mFolderAppsViewPager.adapter?.count ?: 1) * FolderDragSessionPolicy.ITEMS_PER_PAGE,
            (occupiedCells.maxOrNull() ?: -1) + 2,
            absoluteCell + 1
        )
        val preview = FolderDragSessionPolicy.collisionPreview(
            movingCell = movingItem.cell.takeIf { it >= 0 },
            targetCell = absoluteCell,
            occupiedCells = occupiedCells,
            maxCells = maxCells
        )

        preview.displacedCells.forEach { (fromCell, toCell) ->
            mutableFolderItems(session.folder)
                .firstOrNull { it !== movingItem && it.cell == fromCell }
                ?.cell = toCell
        }
        movingItem.container = session.folder.id.toLongOrNull() ?: movingItem.container
        movingItem.screenId = -1
        movingItem.cell = preview.movingCell
        session.lastPreviewCell = preview.movingCell
        session.hasEnteredFolder = true
        val targetPage = FolderDragSessionPolicy.pageForCell(preview.movingCell)
        val newPageCount = maxOf(
            oldPageCount,
            (mutableFolderItems(session.folder).maxOfOrNull { it.cell } ?: 0)
                .let { FolderDragSessionPolicy.pageForCell(it.coerceAtLeast(0)) + 1 }
        )
        val displacedAcrossPages = preview.displacedCells.any { (fromCell, toCell) ->
            FolderDragSessionPolicy.pageForCell(fromCell) != FolderDragSessionPolicy.pageForCell(toCell)
        }
        val shouldRefreshAdapter = !wasInFolder ||
            newPageCount > oldPageCount ||
            oldMovingPage != targetPage ||
            displacedAcrossPages ||
            !relayoutOpenFolderPageCells(session, targetPage)
        if (shouldRefreshAdapter) {
            refreshOpenFolderAdapter(session.folder)
        }
        if (mFolderAppsViewPager.currentItem != targetPage) {
            mFolderAppsViewPager.setCurrentItem(targetPage, true)
        }
    }

    private fun scheduleFolderPageScrollIfNeeded(targetPage: Int) {
        if (folderPageScrollTarget == targetPage && mFolderPageScrollAlarm.alarmPending()) {
            return
        }
        cancelFolderPageScroll()
        folderPageScrollTarget = targetPage
        mFolderPageScrollAlarm.setOnAlarmListener(FolderPageScrollAlarmListener(targetPage))
        mFolderPageScrollAlarm.setAlarm(300)
    }

    private fun cancelFolderPageScroll() {
        mFolderPageScrollAlarm.cancelAlarm()
        folderPageScrollTarget = LauncherItem.INVALID_CELL
    }

    private fun cleanupFolderReorder(cancelAlarm: Boolean) {
        if (cancelAlarm) {
            mFolderReorderAlarm.cancelAlarm()
        }
        folderReorderTargetPage = LauncherItem.INVALID_CELL
        folderReorderTargetCell = LauncherItem.INVALID_CELL
    }

    private fun scheduleFolderReorderIfNeeded(
        session: FolderDragSession,
        targetPage: Int,
        targetCell: Int
    ) {
        if (folderReorderTargetPage == targetPage &&
            folderReorderTargetCell == targetCell &&
            mFolderReorderAlarm.alarmPending()
        ) {
            return
        }
        cleanupFolderReorder(true)
        folderReorderTargetPage = targetPage
        folderReorderTargetCell = targetCell
        mFolderReorderAlarm.setOnAlarmListener(FolderReorderAlarmListener(session, targetPage, targetCell))
        mFolderReorderAlarm.setAlarm(REORDER_TIMEOUT.toLong())
    }

    private fun reopenFolderForActiveDrag(session: FolderDragSession) {
        currentAnimator?.cancel()
        folderFromDock = session.folderWasFromDock
        folderOpenedByDragHover = true
        dragHasEnteredOpenFolder = false
        session.exitedToHome = false
        session.hasEnteredFolder = false
        session.previewAddedToFolder = mutableFolderItems(session.folder).contains(session.moving.launcherItem)
        session.lastPreviewCell = LauncherItem.INVALID_CELL
        displayFolder(session.folder, session.folderView)
    }

    private fun handleFolderDragLocation(x: Float, y: Float) {
        val session = folderDragSession ?: return
        val panelBounds = folderPanelBoundsOnScreen()
        val isInsidePanel = isPointInsideBounds(panelBounds, x, y)
        if (session.exitedToHome && isInsidePanel) {
            reopenFolderForActiveDrag(session)
        }
        if (isInsidePanel) {
            dragHasEnteredOpenFolder = true
        }
        val canExitFolder = session.origin != FolderDragOrigin.FROM_HOME_TO_FOLDER ||
            !folderOpenedByDragHover ||
            dragHasEnteredOpenFolder
        val shouldExit = FolderDragSessionPolicy.shouldExitHoverOpenedFolder(
            x = x,
            y = y,
            left = panelBounds.left,
            top = panelBounds.top,
            right = panelBounds.right,
            bottom = panelBounds.bottom,
            thresholdPx = dp(48),
            hasEnteredOpenFolder = canExitFolder
        )
        if (shouldExit) {
            handleFolderDragExitToHome(session, x, y)
            return
        }
        if (!isPointInsideOpenFolder(x, y)) {
            cancelFolderPageScroll()
            cleanupFolderReorder(true)
            return
        }

        val bounds = folderBoundsOnScreen()
        val currentPage = mFolderAppsViewPager.currentItem
        val pageCount = maxOf(1, mFolderAppsViewPager.adapter?.count ?: 1)
        val canCreateNextPage = mutableFolderItems(session.folder).size >=
            (currentPage + 1) * FolderDragSessionPolicy.ITEMS_PER_PAGE
        val edgeTargetPage = FolderDragSessionPolicy.edgeTargetPage(
            x = x - bounds.left,
            width = bounds.width(),
            currentPage = currentPage,
            pageCount = if (canCreateNextPage) pageCount + 1 else pageCount,
            edgeSizePx = dp(48)
        )
        if (edgeTargetPage != currentPage) {
            scheduleFolderPageScrollIfNeeded(edgeTargetPage)
        } else {
            cancelFolderPageScroll()
        }

        val initialPlacement = if (!session.hasEnteredFolder) {
            FolderDragSessionPolicy.firstAvailablePlacement(
                occupiedCells = folderOccupiedCells(session.folder, except = session.moving.launcherItem),
                startPage = currentPage
            )
        } else {
            FolderDragSessionPolicy.FolderPlacement(currentPage, folderDropCellForCurrentPage(x, y))
        }
        scheduleFolderReorderIfNeeded(session, initialPlacement.page, initialPlacement.cell)
    }

    private fun handleFolderDragExitToHome(session: FolderDragSession, x: Float, y: Float) {
        if (session.exitedToHome) {
            return
        }
        cleanupFolderReorder(true)
        cancelFolderPageScroll()
        val movingItem = session.moving.launcherItem

        if (session.origin == FolderDragOrigin.FROM_HOME_TO_FOLDER) {
            resetFolderItemsToOriginal(session)
            movingItem.container = session.originContainer
            movingItem.screenId = session.originScreenId
            movingItem.cell = session.originCell
            if (session.moving.parent == null) {
                session.originParent?.let { parent ->
                    if (parent === mDock) {
                        addAppToDock(session.moving, session.originIndex)
                    } else if (parent is GridLayout) {
                        addAppToGrid(parent, session.moving, session.originIndex)
                        relayoutHomePageCells(parent)
                    }
                }
            }
        } else {
            mutableFolderItems(session.folder).remove(movingItem)
            attachFolderDragMovingToHome(session, x, y)
        }
        refreshFolderViewAfterItemsChanged(session)

        session.previewAddedToFolder = false
        session.hasEnteredFolder = false
        session.lastPreviewCell = LauncherItem.INVALID_CELL
        session.moving.visibility = View.INVISIBLE
        session.exitedToHome = true
        folderOpenedByDragHover = false
        dragHasEnteredOpenFolder = false
        hideFolderWindowContainer(saveLayout = false)
    }

    private fun attachFolderDragMovingToHome(session: FolderDragSession, x: Float, y: Float) {
        val page = pages.getOrNull(getCurrentAppsPageNumber()) ?: return
        val moving = session.moving
        (moving.parent as? ViewGroup)?.removeView(moving)
        moving.launcherItem.container = Constants.CONTAINER_DESKTOP.toLong()
        moving.launcherItem.screenId = getCurrentAppsPageNumber().toLong()
        moving.launcherItem.cell = dropCellForHomeGrid(page, x, y)
        if (page.childCount < mDeviceProfile.maxAppsPerPage) {
            addAppToGrid(page, moving, getIndex(page, x, y))
            relayoutHomePageCells(page)
        }
    }

    private fun commitFolderDropInside(session: FolderDragSession) {
        normalizeFolderItemOrder(session.folder)
        finishFolderDragSession()
        refreshFolderViewAfterItemsChanged(session)
        launcherLayoutRepository.saveLayouts(pages, mDock)
        folderOpenedByDragHover = false
        dragHasEnteredOpenFolder = false
    }

    private fun commitFolderDropOutside(session: FolderDragSession) {
        if (session.origin == FolderDragOrigin.FROM_HOME_TO_FOLDER) {
            resetFolderItemsToOriginal(session)
            refreshFolderViewAfterItemsChanged(session)
            finishFolderDragSession()
            launcherLayoutRepository.saveLayouts(pages, mDock)
            return
        }
        normalizeFolderItemOrder(session.folder)
        finalizeFolderAfterItemRemoved(session)
        finishFolderDragSession()
    }

    private fun finalizeFolderAfterItemRemoved(session: FolderDragSession) {
        val folder = session.folder
        val folderView = session.folderView
        val items = mutableFolderItems(folder)
        val folderFromDock = session.folderWasFromDock

        when (FolderDragSessionPolicy.folderResultAfterRemovingItem(items.size)) {
            FolderDragSessionPolicy.FolderResultAfterRemovingItem.REMOVE_FOLDER -> {
                removeFolderView(folder, folderView)
            }

            FolderDragSessionPolicy.FolderResultAfterRemovingItem.REPLACE_WITH_REMAINING_ITEM -> {
                val remainingItem = items.removeAt(0)
                replaceFolderWithRemainingItem(folder, folderView, remainingItem, folderFromDock)
            }

            FolderDragSessionPolicy.FolderResultAfterRemovingItem.KEEP_FOLDER -> {
                updateIcon(folderView, folder, GraphicsUtil(this).generateFolderIcon(this, folder), folderFromDock)
                folderView.applyBadge(checkHasApp(folder, mAppsWithNotifications), !folderFromDock)
            }
        }
        launcherLayoutRepository.saveLayouts(pages, mDock)
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

            when (FolderDragSessionPolicy.folderResultAfterRemovingItem(folder.items!!.size)) {
                FolderDragSessionPolicy.FolderResultAfterRemovingItem.REMOVE_FOLDER -> {
                    removeFolderView(folder, folderView)
                }
                FolderDragSessionPolicy.FolderResultAfterRemovingItem.REPLACE_WITH_REMAINING_ITEM -> {
                    collapseFolderToRemainingItem(folder, folderView, folderFromDock, shouldWobble = true)
                }
                FolderDragSessionPolicy.FolderResultAfterRemovingItem.KEEP_FOLDER -> {
                    updateIcon(folderView, folder, GraphicsUtil(this).generateFolderIcon(this, folder), folderFromDock)
                    folderView.applyBadge(checkHasApp(folder, mAppsWithNotifications), !folderFromDock)
                }
            }
            if (moving.parent != null) {
                (moving.parent as ViewGroup).removeView(moving)
            }
            val current = getCurrentAppsPageNumber()
            addAppToGrid(pages[current], moving)
            makeAppWobble(moving, true, pages[current].childCount - 1)

            hideFolderWindowContainer()
            moving.visibility = VISIBLE
        }
    }

    private fun discardCollidingApp() {
        val app = collidingApp
        cancelFolderHoverOpen()
        if (app != null) {
            makeAppCold(app, !((app.parent as View).parent is HorizontalPager))
            collidingApp = null
            folderInterest = false
        }
    }

    private fun createOrUpdateFolder(fromDock: Boolean): BlissFrameLayout? {
        val colliding = collidingApp ?: return null
        val moving = movingApp ?: return null
        var folderViewForAnimation: BlissFrameLayout? = null
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
            updateIcon(colliding, app1, GraphicsUtil(this).generateFolderIcon(this, folderItem), fromDock)
            colliding.applyBadge(checkHasApp(folderItem, mAppsWithNotifications), !fromDock)
            makeAppWobble(colliding, true, index)
            folderViewForAnimation = colliding
        } else {
            val folder = FolderItem()
            folder.title = ""
            folder.id = System.currentTimeMillis().toString()
            folder.container = if (fromDock) {
                Constants.CONTAINER_HOTSEAT.toLong()
            } else {
                Constants.CONTAINER_DESKTOP.toLong()
            }
            folder.screenId = if (fromDock) {
                -1
            } else {
                currentPageNumber.toLong()
            }
            folder.cell = if (fromDock) {
                index
            } else {
                LauncherHomeCellPolicy.folderCreationCell(
                    targetCell = app1.cell,
                    targetIndex = index,
                    maxCells = mDeviceProfile.maxAppsPerPage
                )
            }
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
            folderViewForAnimation = folderView
            animateCreatedFolderIcon(folderView)
            makeAppWobble(folderView, true, index)
        }

        if (moving.parent != null) {
            (moving.parent as ViewGroup).removeView(moving)
        }

        makeAppCold(colliding, fromDock)
        makeAppCold(moving, fromDock)
        return folderViewForAnimation
    }

    private fun createOrUpdateFolderWithDropArc(fromDock: Boolean, startLeft: Float, startTop: Float) {
        val moving = movingApp ?: return
        val targetCell = folderDropTargetCell()
        val draggedDrawable = freshDrawable(moving.launcherItem.icon)
        val folderView = createOrUpdateFolder(fromDock)
        if (folderView == null || draggedDrawable == null) {
            return
        }
        folderView.post {
            animateDraggedIconIntoFolder(
                drawable = draggedDrawable,
                startLeft = startLeft,
                startTop = startTop,
                folderView = folderView,
                targetCell = targetCell
            )
        }
    }

    private fun shouldAnimateFolderDrop(): Boolean {
        val targetItem = collidingApp?.launcherItem ?: return false
        val movingItem = movingApp?.launcherItem ?: return false
        return movingItem.itemType != Constants.ITEM_TYPE_FOLDER &&
            (
                targetItem.itemType == Constants.ITEM_TYPE_APPLICATION ||
                    targetItem.itemType == Constants.ITEM_TYPE_FOLDER
                )
    }

    private fun folderDropTargetCell(): Int {
        val targetItem = collidingApp?.launcherItem
        return if (targetItem is FolderItem) {
            targetItem.items?.size ?: 0
        } else {
            1
        }
    }

    private fun animateDraggedIconIntoFolder(
        drawable: Drawable,
        startLeft: Float,
        startTop: Float,
        folderView: BlissFrameLayout,
        targetCell: Int
    ) {
        val root = mLauncherView as? ViewGroup ?: return
        val iconSize = mDeviceProfile.iconSizePx
        val target = folderDropArcTarget(folderView, targetCell) ?: return
        val endSize = target.size.coerceAtLeast(1)

        val snapshot = ImageView(this).apply {
            setImageDrawable(drawable)
            scaleType = ImageView.ScaleType.FIT_CENTER
            pivotX = iconSize / 2f
            pivotY = iconSize / 2f
            x = startLeft
            y = startTop
            elevation = dp(48).toFloat()
        }
        root.addView(snapshot, RelativeLayout.LayoutParams(iconSize, iconSize))
        snapshot.bringToFront()

        val startX = startLeft
        val startY = startTop
        val endX = target.snapshotLeft
        val endY = target.snapshotTop
        val control = FolderHoverOpenPolicy.dropArcControlPoint(startX, startY, endX, endY)
        val endScale = endSize.toFloat() / iconSize.toFloat()

        ValueAnimator.ofFloat(0f, 1f).apply {
            duration = FolderHoverOpenPolicy.DROP_ARC_ANIMATION_MS
            interpolator = DecelerateInterpolator()
            addUpdateListener { animator ->
                val t = animator.animatedValue as Float
                val inverse = 1f - t
                snapshot.x = inverse * inverse * startX + 2f * inverse * t * control.x + t * t * endX
                snapshot.y = inverse * inverse * startY + 2f * inverse * t * control.y + t * t * endY
                val scale = 1f + (endScale - 1f) * t
                snapshot.scaleX = scale
                snapshot.scaleY = scale
                snapshot.alpha = 1f - 0.08f * t
            }
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    (snapshot.parent as? ViewGroup)?.removeView(snapshot)
                    animateCreatedFolderIcon(folderView)
                }

                override fun onAnimationCancel(animation: Animator) {
                    (snapshot.parent as? ViewGroup)?.removeView(snapshot)
                }
            })
            start()
        }
    }

    private data class FolderDropArcTarget(
        val snapshotLeft: Float,
        val snapshotTop: Float,
        val size: Int
    )

    private fun folderDropArcTarget(folderView: BlissFrameLayout, targetCell: Int): FolderDropArcTarget? {
        val icon = AppViewBinding.bind(folderView).appIcon
        val rootRect = Rect()
        val iconRect = Rect()
        mLauncherView.getGlobalVisibleRect(rootRect)
        icon.getGlobalVisibleRect(iconRect)
        iconRect.offset(-rootRect.left, -rootRect.top)
        val snapshotTarget = FolderHoverOpenPolicy.dropArcSnapshotTargetTopLeft(
            iconLeft = iconRect.left.toFloat(),
            iconTop = iconRect.top.toFloat(),
            iconSize = iconRect.width(),
            cell = targetCell
        )
        val bounds = FolderHoverOpenPolicy.folderPreviewCellBounds(
            iconLeft = iconRect.left.toFloat(),
            iconTop = iconRect.top.toFloat(),
            iconSize = iconRect.width(),
            cell = targetCell
        )
        return FolderDropArcTarget(
            snapshotLeft = snapshotTarget.x,
            snapshotTop = snapshotTarget.y,
            size = bounds.width.toInt()
        )
    }

    private fun updateIcon(appView: BlissFrameLayout, app: LauncherItem, drawable: Drawable?, folderFromDock: Boolean) {
        app.icon = drawable
        if (app is FolderItem) {
            appView.refreshFolderPreviewBackground()
        }
        val tags = appView.tag as List<*>
        val iv = tags[0] as SquareImageView
        iv.setImageDrawable(drawable)
    }

    private fun makeAppHot(app: View?) {
        if (app == null) {
            return
        }
        if (
            folderCreationPreviewTarget === app ||
            (app.scaleX >= FolderHoverOpenPolicy.HOT_SCALE && app.scaleY >= FolderHoverOpenPolicy.HOT_SCALE)
        ) {
            return
        }
        app.animate().cancel()
        app.animate()
            .scaleX(FolderHoverOpenPolicy.HOT_SCALE)
            .scaleY(FolderHoverOpenPolicy.HOT_SCALE)
            .setDuration(FolderHoverOpenPolicy.HOT_ANIMATION_MS)
            .setInterpolator(DecelerateInterpolator())
            .start()
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
        app.animate().cancel()
        app.animate()
            .scaleX(1.0f)
            .scaleY(1.0f)
            .alpha(1f)
            .setDuration(FolderHoverOpenPolicy.COLD_ANIMATION_MS)
            .setInterpolator(DecelerateInterpolator())
            .start()
        if (folderCreationPreviewTarget === app) {
            folderCreationPreviewTarget = null
        }
        collidingApp = null
    }

    private fun previewFolderCreationTarget(target: BlissFrameLayout) {
        folderCreationPreviewTarget = target
        target.animate().cancel()
        val expandX = ObjectAnimator.ofFloat(target, View.SCALE_X, target.scaleX, FolderHoverOpenPolicy.PREVIEW_SCALE)
        val expandY = ObjectAnimator.ofFloat(target, View.SCALE_Y, target.scaleY, FolderHoverOpenPolicy.PREVIEW_SCALE)
        val settleX = ObjectAnimator.ofFloat(target, View.SCALE_X, FolderHoverOpenPolicy.PREVIEW_SCALE, FolderHoverOpenPolicy.HOT_SCALE)
        val settleY = ObjectAnimator.ofFloat(target, View.SCALE_Y, FolderHoverOpenPolicy.PREVIEW_SCALE, FolderHoverOpenPolicy.HOT_SCALE)
        AnimatorSet().apply {
            play(expandX).with(expandY)
            play(settleX).with(settleY).after(expandX)
            duration = FolderHoverOpenPolicy.PREVIEW_ANIMATION_MS
            interpolator = DecelerateInterpolator()
            start()
        }
    }

    private fun freshDrawable(drawable: Drawable?): Drawable? {
        return drawable?.constantState?.newDrawable(resources)?.mutate() ?: drawable
    }

    private fun animateCreatedFolderIcon(folderView: BlissFrameLayout) {
        folderView.animate().cancel()
        folderView.alpha = 0.35f
        folderView.scaleX = 0.82f
        folderView.scaleY = 0.82f
        folderView.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(FolderHoverOpenPolicy.PREVIEW_ANIMATION_MS)
            .setInterpolator(DecelerateInterpolator())
            .start()
    }

    private fun getAppDetails(app: View?): LauncherItem =
        (app as? BlissFrameLayout)?.launcherItem ?: error("Expected BlissFrameLayout")

    private fun checkIfFolderInterest(view: ViewGroup, index: Int, x: Float, y: Float): Boolean {
        val v = AppViewBinding.bind(view.getChildAt(index)).appIcon
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
            val v = runCatching { AppViewBinding.bind(page.getChildAt(i)).appIcon }.getOrNull() ?: continue
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

    private fun getFolderLayoutTransition(): LayoutTransition {
        return getDefaultLayoutTransition().apply {
            enableTransitionType(LayoutTransition.CHANGING)
            setStartDelay(LayoutTransition.CHANGING, 0)
        }
    }

    private fun createIndicator() {
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        indicatorWheelView = null
        if (shouldKeepPageDotsVisibleForDockStyle()) {
            indicatorMode = IndicatorMode.DOTS
            showDotsInIndicator(homePagePositionForPagerPage(currentPageNumber), false)
        } else {
            indicatorMode = IndicatorMode.SEARCH
            showSearchControlInIndicator(false)
        }
        updateWorkspaceChromeForPage(currentPageNumber)
    }

    private fun refreshPageIndicator() {
        if (currentPageNumber == WIDGET_PAGE) {
            hideWidgetPageIndicator()
            return
        }

        if (isHomePage(currentPageNumber)) {
            if (isWobbling || indicatorMode == IndicatorMode.DOTS || shouldKeepPageDotsVisibleForDockStyle()) {
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
        resetHomeIndicatorPosition()
        mIndicator.isClickable = false
        mIndicator.alpha = 0f
        setIndicatorChromeVisibility(false)
    }

    private fun isSwipeSearchActive(): Boolean =
        ::swipeSearchContainer.isInitialized && swipeSearchContainer.visibility == VISIBLE

    private fun hideHomeIndicatorForSearch() {
        if (!::mIndicator.isInitialized) {
            return
        }
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        resetHomeIndicatorPosition()
        mIndicator.isClickable = false
        mIndicator.alpha = 0f
        setIndicatorChromeVisibility(false)
    }

    private fun isFolderWindowActive(): Boolean =
        ::mFolderWindowContainer.isInitialized && mFolderWindowContainer.visibility == VISIBLE

    private fun hideHomeIndicatorForFolder() {
        if (!::mIndicator.isInitialized) {
            return
        }
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        resetHomeIndicatorPosition()
        mIndicator.isClickable = false
        mIndicator.alpha = 0f
        setIndicatorChromeVisibility(false)
    }

    private fun resetHomeIndicatorPosition() {
        if (!::mIndicator.isInitialized) {
            return
        }

        mIndicator.animate().cancel()
        mIndicator.clearAnimation()
        mIndicator.translationX = 0f
        mIndicator.translationY = 0f
        mIndicator.scaleX = 1f
        mIndicator.scaleY = 1f
        syncIndicatorChromeTransform()
    }

    private fun showPageIndicator(page: Int) {
        if (isSwipeSearchActive()) {
            hideHomeIndicatorForSearch()
            return
        }
        if (!isHomePage(page)) {
            hideWidgetPageIndicator()
            return
        }

        if (homeIndicatorPageCount() <= 1) {
            if (shouldKeepPageDotsVisibleForDockStyle()) {
                showDotsInIndicator(homePagePositionForPagerPage(page), false)
            } else {
                showSearchControlInIndicator(false)
            }
            return
        }

        showDotsInIndicator(homePagePositionForPagerPage(page), true)
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        if (!isWobbling) {
            indicatorHandler.postDelayed(hideIndicatorRunnable, PAGE_INDICATOR_VISIBLE_MS)
        }
    }

    private fun hidePageIndicator() {
        if (isSwipeSearchActive()) {
            hideHomeIndicatorForSearch()
            return
        }
        if (isWobbling) {
            return
        }
        if (shouldKeepPageDotsVisibleForDockStyle() && isHomePage(currentPageNumber)) {
            showDotsInIndicator(homePagePositionForPagerPage(currentPageNumber), false)
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
        if (isSwipeSearchActive()) {
            hideHomeIndicatorForSearch()
            return
        }
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
        val toPage = fromPage + 1
        if (!LauncherSearchEntryPolicy.shouldShowIndicatorDuringPageScroll(
                fromPage = fromPage,
                toPage = toPage,
                firstHomePage = 1,
                lastHomePage = pages.size,
                appLibraryPage = pages.size + 1
            )
        ) {
            hideWidgetPageIndicator()
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
        if (isSwipeSearchActive()) {
            hideHomeIndicatorForSearch()
            return
        }
        if (isFolderWindowActive()) {
            setDockChromeVisibility(false)
            hideHomeIndicatorForFolder()
            return
        }
        if (homeIndicatorPageCount() <= 1) {
            mIndicator.removeAllViews()
            setIndicatorChromeVisibility(false)
            return
        }
        val shouldRebuildFrame = LauncherSearchEntryPolicy.shouldRebuildDotsIndicatorFrame(
            indicatorModeIsDots = indicatorMode == IndicatorMode.DOTS,
            wheelAttached = indicatorWheelView?.parent === mIndicator,
            indicatorVisible = mIndicator.visibility == VISIBLE
        )
        if (shouldRebuildFrame) {
            indicatorMode = IndicatorMode.DOTS
            ensureDotsIndicatorFrame()
            ensureIndicatorWheelView()
            resetHomeIndicatorPosition()
            mIndicator.isClickable = true
            mIndicator.alpha = 1f
            setIndicatorChromeVisibility(true)
        } else {
            mIndicator.isClickable = true
            mIndicator.alpha = 1f
            syncIndicatorChromeTransform(refreshRealtime = false)
        }
    }

    private fun showSearchControlInIndicator(animated: Boolean) {
        if (isSwipeSearchActive()) {
            hideHomeIndicatorForSearch()
            return
        }
        if (isFolderWindowActive()) {
            hideHomeIndicatorForFolder()
            return
        }
        if (!isHomePage(currentPageNumber) || isWobbling) {
            return
        }
        if (shouldKeepPageDotsVisibleForDockStyle()) {
            showDotsInIndicator(homePagePositionForPagerPage(currentPageNumber), false)
            return
        }

        indicatorMode = IndicatorMode.SEARCH
        ensureSearchIndicatorFrame()
        indicatorHandler.removeCallbacks(hideIndicatorRunnable)
        resetHomeIndicatorPosition()
        mIndicator.isClickable = true
        mIndicator.alpha = 1f
        setIndicatorChromeVisibility(true)
        mIndicator.removeAllViews()
        mIndicator.addView(createIndicatorSearchControl())
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

    private fun createIndicatorSearchControl(): View {
        val spec = LauncherIndicatorSearchPillPolicy.visualSpec()
        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            isClickable = true
            isFocusable = true
            setOnClickListener { openSearchFromIndicator() }

            addView(
                ImageView(context).apply {
                    setImageResource(R.drawable.ic_search_18)
                    setColorFilter(Color.WHITE)
                },
                LinearLayout.LayoutParams(dp(spec.iconSizeDp), dp(spec.iconSizeDp))
            )

            addView(
                TextView(context).apply {
                    text = getString(R.string.launcher_search_hint)
                    includeFontPadding = false
                    setTextColor(Color.WHITE)
                    textSize = spec.textSizeSp
                    typeface = Typeface.create("sans-serif-medium", Typeface.NORMAL)
                },
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    marginStart = dp(spec.iconTextGapDp)
                }
            )
        }
    }

    private fun indicatorBackgroundStyle(): LauncherLiquidGlassStylePolicy.BackgroundStyle =
        if (indicatorMode == IndicatorMode.SEARCH) {
            LauncherLiquidGlassStylePolicy.searchIndicator(
                enabled = lightModeSearchBlurEnabled(),
                darkMode = darkModeEnabled,
                liquidGlass = false
            )
        } else {
            LauncherLiquidGlassStylePolicy.pageIndicator(
                enabled = lightModeSearchBlurEnabled(),
                darkMode = darkModeEnabled,
                liquidGlass = false
            )
        }

    private fun applyIndicatorBackgroundForCurrentMode(forceRealtimeRefresh: Boolean = false) {
        applyIndicatorRealtimeLiquidGlass(forceRefresh = forceRealtimeRefresh)
    }

    private fun updateIndicatorFrame(widthDp: Int, heightDp: Int): Boolean {
        val layoutParams = mIndicator.layoutParams
        val widthPx = dp(widthDp)
        val heightPx = dp(heightDp)
        val frameChanged = layoutParams.width != widthPx || layoutParams.height != heightPx
        layoutParams.width = widthPx
        layoutParams.height = heightPx
        mIndicator.layoutParams = layoutParams
        indicatorGlassBackground()?.let(::syncIndicatorRealtimeGlassLayout)
        syncIndicatorChromeTransform()
        return frameChanged
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
        val frameChanged = updateIndicatorFrame(
            LauncherPageIndicatorWindowPolicy.frameWidthDp(homeIndicatorPageCount()),
            PAGE_INDICATOR_SEARCH_HEIGHT_DP
        )
        applyIndicatorBackgroundForCurrentMode(forceRealtimeRefresh = frameChanged)
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
        wheelView.isClickable = true
        wheelView.setOnClickListener { openSearchFromIndicator() }
        mIndicator.removeAllViews()
        mIndicator.addView(wheelView)
        indicatorWheelView = wheelView
        return wheelView
    }

    private fun ensureSearchIndicatorFrame() {
        val spec = LauncherIndicatorSearchPillPolicy.visualSpec()
        val frameChanged = updateIndicatorFrame(spec.widthDp, spec.heightDp)
        applyIndicatorBackgroundForCurrentMode(forceRealtimeRefresh = frameChanged)
        mIndicator.setPadding(0, 0, 0, 0)
        indicatorWheelView = null
    }

    private fun homeIndicatorPageCount(): Int = pages.size

    private fun updateWorkspaceChromeForPage(page: Int) {
        workspaceChromeController.updateForPage(workspaceChromeState(page))
    }

    private fun workspaceChromeState(page: Int): LauncherWorkspaceChromeController.WorkspaceChromeState {
        return LauncherWorkspaceChromeController.WorkspaceChromeState(
            folderActive = isFolderWindowActive(),
            appLibraryPage = isAppLibraryPage(page),
            homePage = isHomePage(page),
            showDockForPage = shouldShowDockForPage(page),
            editing = isWobbling,
            keepDotsVisible = shouldKeepPageDotsVisibleForDockStyle(),
            indicatorMode = workspaceChromeIndicatorMode(),
            homePagePosition = homePagePositionForPagerPage(page)
        )
    }

    private fun workspaceChromeIndicatorMode(): LauncherWorkspaceChromeController.IndicatorMode {
        return when (indicatorMode) {
            IndicatorMode.DOTS -> LauncherWorkspaceChromeController.IndicatorMode.DOTS
            IndicatorMode.SEARCH -> LauncherWorkspaceChromeController.IndicatorMode.SEARCH
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

    private fun setupBackNavigation() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (handleLauncherBackPressed()) {
                    return
                }
                isEnabled = false
                try {
                    onBackPressedDispatcher.onBackPressed()
                } finally {
                    isEnabled = true
                }
            }
        })
    }

    private fun handleLauncherBackPressed(): Boolean {
        if (photoWidgetCropPanel != null) {
            hideHomeWidgetPhotoCropPage()
            return true
        }
        if (weatherDetailPanel != null) {
            hideWeatherDetailPage()
            return true
        }
        if (weatherSettingsPanel != null) {
            hideWeatherSettingsPage()
            return true
        }
        if (blurSettingsPanel != null) {
            hideBlurEffectSettingsPanel()
            return true
        }
        if (isFolderWindowActive() || currentPageNumber != 1 || isSwipeSearchActive()) {
            returnToHomeScreen()
            return true
        }
        return false
    }

    private fun displayFolder(app: FolderItem, v: BlissFrameLayout) {
        currentAnimator?.cancel()
        forceHideSwipeSearchForFolder()
        hideHomeIndicatorForFolder()

        val openGeneration = ++folderOpenGeneration
        val deferContentBinding = FolderOpenPerformancePolicy.shouldDeferContentBinding(
            openedByDragHover = folderOpenedByDragHover
        )
        val deferRealtimeGlassBinding = FolderOpenPerformancePolicy.shouldDeferRealtimeGlassBinding(
            openedByDragHover = folderOpenedByDragHover,
            liquidGlassEnabled = liquidGlassEnabled
        )

        activeFolder = app
        activeFolderView = v
        val folderMetrics = folderOpenMetrics()
        applyFolderOpenMetrics(folderMetrics)
        applyFolderLiquidGlassAppearance(bindRealtime = false)
        bindFolderTitleInput(app)
        mFolderTitleInput.isCursorVisible = false
        prepareFolderContentForOpen(deferContentBinding)

        startBounds = Rect()
        finalBounds = Rect()
        val globalOffset = Point()

        v.getGlobalVisibleRect(startBounds)
        binding.workspace.getGlobalVisibleRect(finalBounds, globalOffset)
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

        val targetBlurAlpha = folderOverlayBlurAlpha()
        val backgroundContentAlpha = folderBackgroundContentAlpha()
        val backgroundContentScale = if (liquidGlassEnabled) {
            FolderOpenLayoutPolicy.LIQUID_GLASS_BACKGROUND_SCALE
        } else {
            1f
        }
        val set = AnimatorSet()
        set.play(ObjectAnimator.ofFloat(mFolderWindowContainer, View.X, startBounds.left.toFloat(), finalBounds.left.toFloat()))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.Y, startBounds.top.toFloat(), finalBounds.top.toFloat()))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.SCALE_X, startScale, 1f))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.SCALE_Y, startScale, 1f))
            .with(ObjectAnimator.ofFloat(blurLayer, View.ALPHA, targetBlurAlpha))
            .with(ObjectAnimator.ofFloat(darkBlurLayer, View.ALPHA, darkBlurAlphaFor(targetBlurAlpha)))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.ALPHA, backgroundContentAlpha))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.SCALE_X, backgroundContentScale))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.SCALE_Y, backgroundContentScale))
            .with(ObjectAnimator.ofFloat(mIndicator, View.ALPHA, 0f))
            .with(ObjectAnimator.ofFloat(mDock, View.ALPHA, backgroundContentAlpha))
            .with(ObjectAnimator.ofFloat(mDock, View.SCALE_X, backgroundContentScale))
            .with(ObjectAnimator.ofFloat(mDock, View.SCALE_Y, backgroundContentScale))
        set.duration = FolderOpenPerformancePolicy.OPEN_ANIMATION_DURATION_MS
        set.interpolator = DecelerateInterpolator()
        var openAnimationCanceled = false
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                mFolderWindowContainer.visibility = VISIBLE
                mFolderWindowContainer.bringToFront()
                mFolderWindowContainer.pivotX = 0f
                mFolderWindowContainer.pivotY = 0f
                setDockChromeVisibility(false)
                hideHomeIndicatorForFolder()
                setFolderBackgroundContentBlurEnabled(true)
                if (!deferRealtimeGlassBinding) {
                    refreshOpenFolderLiquidGlassIfNeeded()
                }
            }

            override fun onAnimationEnd(animation: Animator) {
                if (openAnimationCanceled) {
                    return
                }
                currentAnimator = null
                setBlurLayersAlpha(targetBlurAlpha)
                mHorizontalPager.alpha = backgroundContentAlpha
                mHorizontalPager.scaleX = backgroundContentScale
                mHorizontalPager.scaleY = backgroundContentScale
                setDockChromeVisibility(false)
                hideHomeIndicatorForFolder()
                mDock.alpha = backgroundContentAlpha
                mDock.scaleX = backgroundContentScale
                mDock.scaleY = backgroundContentScale
                if (deferContentBinding) {
                    bindFolderContent(app, fadeIn = true)
                }
                if (deferRealtimeGlassBinding) {
                    scheduleDeferredFolderRealtimeGlass(app, openGeneration)
                }
                refreshOpenFolderLiquidGlassIfNeeded(immediate = true)
            }

            override fun onAnimationCancel(animation: Animator) {
                openAnimationCanceled = true
                currentAnimator = null
                mFolderWindowContainer.visibility = GONE
                setBlurLayersAlpha(0f)
                mHorizontalPager.alpha = 1f
                mHorizontalPager.scaleX = 1f
                mHorizontalPager.scaleY = 1f
                mIndicator.alpha = 1f
                setIndicatorChromeVisibility(true)
                mDock.alpha = 1f
                mDock.scaleX = 1f
                mDock.scaleY = 1f
                setFolderBackgroundContentBlurEnabled(false)
                setDockChromeVisibility(shouldShowDockForPage(currentPageNumber, folderVisible = false))
            }
        })
        set.start()
        currentAnimator = set
        startScaleFinal = startScale

        if (!deferContentBinding) {
            bindFolderContent(app, fadeIn = false)
        }
    }

    private fun prepareFolderContentForOpen(deferContentBinding: Boolean) {
        val folderIndicator = binding.indicator
        mFolderAppsViewPager.animate().cancel()
        folderIndicator.animate().cancel()
        if (deferContentBinding) {
            mFolderAppsViewPager.adapter = null
            mFolderAppsViewPager.alpha = 0f
            folderIndicator.alpha = 0f
        } else {
            mFolderAppsViewPager.alpha = 1f
            folderIndicator.alpha = 1f
        }
    }

    private fun bindFolderContent(app: FolderItem, fadeIn: Boolean) {
        if (activeFolder !== app || mFolderWindowContainer.visibility != VISIBLE) {
            return
        }
        val folderIndicator = binding.indicator
        mFolderAppsViewPager.animate().cancel()
        folderIndicator.animate().cancel()
        mFolderAppsViewPager.adapter = FolderAppsPagerAdapter(this, app.items.orEmpty())
        folderIndicator.setViewPager(mFolderAppsViewPager)
        refreshOpenFolderLiquidGlassIfNeeded()
        if (!fadeIn) {
            mFolderAppsViewPager.alpha = 1f
            folderIndicator.alpha = 1f
            return
        }
        mFolderAppsViewPager.alpha = 0f
        folderIndicator.alpha = 0f
        mFolderAppsViewPager.animate()
            .alpha(1f)
            .setDuration(FolderOpenPerformancePolicy.CONTENT_FADE_IN_DURATION_MS)
            .start()
        folderIndicator.animate()
            .alpha(1f)
            .setDuration(FolderOpenPerformancePolicy.CONTENT_FADE_IN_DURATION_MS)
            .start()
    }

    private fun scheduleDeferredFolderRealtimeGlass(app: FolderItem, openGeneration: Int) {
        mFolderWindowContainer.postDelayed(
            {
                if (
                    folderOpenGeneration == openGeneration &&
                    activeFolder === app &&
                    mFolderWindowContainer.visibility == VISIBLE
                ) {
                    refreshOpenFolderLiquidGlassIfNeeded(immediate = true)
                }
            },
            FolderOpenPerformancePolicy.REALTIME_GLASS_BIND_DELAY_MS
        )
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
        val folderBlur = binding.folderBgBlur
        folderBlur.layoutParams = folderBlur.layoutParams.apply {
            width = metrics.panelWidth
            height = metrics.panelHeight
        }

        val folderBackground = binding.folderAppsBackground
        folderBackground.layoutParams = folderBackground.layoutParams.apply {
            width = metrics.panelWidth
            height = metrics.panelHeight
        }

        mFolderAppsViewPager.layoutParams = mFolderAppsViewPager.layoutParams.apply {
            width = metrics.panelWidth
            height = metrics.gridHeight
        }

        val folderIndicator = binding.indicator
        folderIndicator.layoutParams = folderIndicator.layoutParams.apply {
            width = metrics.panelWidth
            height = metrics.indicatorHeight
        }

        (mFolderTitleInput.layoutParams as? RelativeLayout.LayoutParams)?.let { titleParams ->
            titleParams.bottomMargin = metrics.titleBottomGap
            mFolderTitleInput.layoutParams = titleParams
        }
        folderTitleNormalTextSizeSp = metrics.titleTextSizeSp
        mFolderTitleInput.setTextSize(TypedValue.COMPLEX_UNIT_SP, metrics.titleTextSizeSp)
        mFolderTitleInput.setTextColor(Color.argb(234, 255, 255, 255))
        mFolderTitleInput.setTypeface(Typeface.create("sans-serif-light", Typeface.NORMAL))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mFolderTitleInput.letterSpacing = 0f
        }
    }

    private fun forceHideSwipeSearchForFolder() {
        if (!::swipeSearchContainer.isInitialized) {
            return
        }
        swipeSearchContainer.animate().cancel()
        swipeSearchContainer.visibility = GONE
        swipeSearchContainer.translationY = mDeviceProfile.availableHeightPx.toFloat()
        searchBackgroundBlocker.animate().cancel()
        searchBackgroundBlocker.visibility = GONE
        searchBackgroundBlocker.alpha = 0f
        launcherSearchController.resetQuery()
        launcherSearchController.disposeSearchObserver(SearchObserverAdapter { searchDisposableObserver })
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

    private fun hideFolderWindowContainer(saveLayout: Boolean = true) {
        folderOpenGeneration++
        if (saveLayout) {
            updateFolderTitle()
            launcherLayoutRepository.saveLayouts(pages, mDock)
        }
        mFolderTitleInput.clearFocus()
        folderFromDock = false
        currentAnimator?.cancel()

        val set = AnimatorSet()
        set.play(ObjectAnimator.ofFloat(mFolderWindowContainer, View.X, startBounds.left.toFloat()))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.Y, startBounds.top.toFloat()))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.SCALE_X, startScaleFinal))
            .with(ObjectAnimator.ofFloat(mFolderWindowContainer, View.SCALE_Y, startScaleFinal))
            .with(ObjectAnimator.ofFloat(blurLayer, View.ALPHA, 0f))
            .with(ObjectAnimator.ofFloat(darkBlurLayer, View.ALPHA, 0f))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.SCALE_X, 1f))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.SCALE_Y, 1f))
            .with(ObjectAnimator.ofFloat(mIndicator, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mDock, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mDock, View.SCALE_X, 1f))
            .with(ObjectAnimator.ofFloat(mDock, View.SCALE_Y, 1f))
        set.duration = 300
        set.interpolator = DecelerateInterpolator()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                mHorizontalPager.visibility = VISIBLE
                setDockChromeVisibility(shouldShowDockForPage(currentPageNumber, folderVisible = false))
                setIndicatorChromeVisibility(true)
                setFolderBackgroundContentBlurEnabled(true)
            }

            override fun onAnimationEnd(animation: Animator) {
                mFolderWindowContainer.visibility = GONE
                currentAnimator = null
                setBlurLayersAlpha(0f)
                mHorizontalPager.alpha = 1f
                mHorizontalPager.scaleX = 1f
                mHorizontalPager.scaleY = 1f
                mIndicator.alpha = 1f
                mDock.alpha = 1f
                mDock.scaleX = 1f
                mDock.scaleY = 1f
                setFolderBackgroundContentBlurEnabled(false)
                syncDockChromeTransform()
                syncIndicatorChromeTransform()
            }

            override fun onAnimationCancel(animation: Animator) {
                mFolderWindowContainer.visibility = GONE
                currentAnimator = null
                setBlurLayersAlpha(0f)
                mHorizontalPager.alpha = 1f
                mHorizontalPager.scaleX = 1f
                mHorizontalPager.scaleY = 1f
                mIndicator.alpha = 1f
                mDock.alpha = 1f
                mDock.scaleX = 1f
                mDock.scaleY = 1f
                setFolderBackgroundContentBlurEnabled(false)
                syncDockChromeTransform()
                syncIndicatorChromeTransform()
            }
        })
        set.start()
        currentAnimator = set
    }

    private fun refreshFolderPanelRealtimeLiquidGlassIfVisible() {
        if (
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPanelRealtimeOnOpenVisible(
                realtimeEnabled = shouldUseRealtimeLiquidGlass(),
                folderVisible = mFolderWindowContainer.visibility == VISIBLE
            )
        ) {
            binding.folderBgBlur.refreshRealtimeLiquidGlass()
        }
    }

    private fun refreshOpenFolderLiquidGlassIfNeeded(immediate: Boolean = false) {
        if (
            !LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPanelRealtimeAfterContentChange(
                realtimeEnabled = shouldUseRealtimeLiquidGlass(),
                folderVisible = ::mFolderWindowContainer.isInitialized &&
                    mFolderWindowContainer.visibility == VISIBLE
            )
        ) {
            return
        }

        fun refreshNow() {
            if (
                !LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPanelRealtimeAfterContentChange(
                    realtimeEnabled = shouldUseRealtimeLiquidGlass(),
                    folderVisible = mFolderWindowContainer.visibility == VISIBLE
                )
            ) {
                return
            }
            applyFolderLiquidGlassAppearance(bindRealtime = true)
            refreshFolderPanelRealtimeLiquidGlassIfVisible()
        }

        if (immediate) {
            refreshNow()
            return
        }
        if (folderPanelLiquidGlassRefreshPosted) {
            return
        }
        folderPanelLiquidGlassRefreshPosted = true
        binding.folderBgBlur.post {
            folderPanelLiquidGlassRefreshPosted = false
            refreshNow()
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        refreshHiddenAppsIfNeeded()
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
            mDock.alpha = 1f
            setDockChromeVisibility(true)
            syncDockChromeTransform()
            mIndicator.alpha = 1f
            setIndicatorChromeVisibility(true)
            mHorizontalPager.snapToPage(1)
        }
    }

    private fun returnToHomeScreen() {
        homeNavigationController.returnToHome(homeNavigationState())
    }

    private fun homeNavigationState(): LauncherHomeNavigationController.ReturnHomeState {
        val folderVisible = mFolderWindowContainer.visibility == VISIBLE
        return LauncherHomeNavigationController.ReturnHomeState(
            hiddenAppsPanelVisible = hiddenAppsPanel != null,
            layoutSettingsPanelVisible = layoutSettingsPanel != null,
            blurSettingsPanelVisible = blurSettingsPanel != null,
            renameAppPanelVisible = renameAppPanel != null,
            widgetPreviewVisible = widgetPreviewOverlay != null,
            widgetPickerShowing = widgetPickerDialog?.isShowing == true,
            appLibrarySearchOverlayVisible = appLibrarySearchOverlay != null,
            appLibraryDetailOverlayVisible = appLibraryDetailOverlay != null,
            homeWidgetOptionsVisible = homeWidgetOptionsPopup != null,
            launcherOptionsVisible = launcherOptionsPopup != null ||
                (::contextOverlay.isInitialized && contextOverlay.visibility == VISIBLE),
            activeWidgetResizing = activeRoundedWidgetView != null &&
                activeRoundedWidgetView?.isWidgetActivated() == true,
            swipeSearchVisible = swipeSearchContainer.visibility == VISIBLE,
            returnHomeAction = homeNavigationReturnAction(folderVisible)
        )
    }

    private fun homeNavigationReturnAction(
        folderVisible: Boolean
    ): LauncherHomeNavigationController.ReturnHomeAction {
        return when (
            LauncherEditModeEntryPolicy.returnHomeAction(
                isEditing = isWobbling,
                todayWidgetEditing = isTodayWidgetEditing,
                folderVisible = folderVisible
            )
        ) {
            LauncherEditModeEntryPolicy.ReturnHomeAction.CLOSE_FOLDER ->
                LauncherHomeNavigationController.ReturnHomeAction.CLOSE_FOLDER
            LauncherEditModeEntryPolicy.ReturnHomeAction.EXIT_EDIT_MODE ->
                LauncherHomeNavigationController.ReturnHomeAction.EXIT_EDIT_MODE
            LauncherEditModeEntryPolicy.ReturnHomeAction.EXIT_TODAY_WIDGET_EDIT ->
                LauncherHomeNavigationController.ReturnHomeAction.EXIT_TODAY_WIDGET_EDIT
            LauncherEditModeEntryPolicy.ReturnHomeAction.NONE ->
                LauncherHomeNavigationController.ReturnHomeAction.NONE
        }
    }

    private fun createHomeNavigationController(): LauncherHomeNavigationController {
        return LauncherHomeNavigationController(
            object : LauncherHomeNavigationController.Actions {
                override fun hideHiddenAppsPanel() {
                    this@LauncherActivity.hideHiddenAppsPanel()
                }

                override fun hideLayoutSettingsPanel() {
                    this@LauncherActivity.hideLayoutSettingsPanel()
                }

                override fun hideBlurEffectSettingsPanel() {
                    this@LauncherActivity.hideBlurEffectSettingsPanel()
                }

                override fun hideRenameAppPicker() {
                    this@LauncherActivity.hideRenameAppPicker()
                }

                override fun dismissTodayWidgetPreview() {
                    this@LauncherActivity.dismissTodayWidgetPreview()
                }

                override fun dismissTodayWidgetPicker() {
                    this@LauncherActivity.dismissTodayWidgetPicker()
                }

                override fun hideAppLibrarySearchOverlay() {
                    this@LauncherActivity.hideAppLibrarySearchOverlay(animated = true)
                }

                override fun hideAppLibraryDetailOverlay() {
                    this@LauncherActivity.hideAppLibraryDetailOverlay(animated = true)
                }

                override fun dismissHomeWidgetOptionsPopup() {
                    this@LauncherActivity.dismissHomeWidgetOptionsPopup()
                }

                override fun dismissLauncherOptionsPopup() {
                    this@LauncherActivity.dismissLauncherOptionsPopup()
                }

                override fun hideWidgetResizeContainer() {
                    this@LauncherActivity.hideWidgetResizeContainer()
                }

                override fun clearSearchQuery() {
                    launcherSearchController.clearQuery()
                }

                override fun hideSwipeSearchContainer() {
                    this@LauncherActivity.hideSwipeSearchContainer()
                }

                override fun hideFolderWindowContainer() {
                    this@LauncherActivity.hideFolderWindowContainer()
                }

                override fun exitEditMode() {
                    handleWobbling(false)
                }

                override fun exitTodayWidgetEdit() {
                    setTodayWidgetEditing(false)
                }
            }
        )
    }

    private fun showSwipeSearchContainer() {
        currentAnimator?.cancel()
        if (swipeSearchContainer.visibility != VISIBLE) {
            swipeSearchContainer.translationY = -searchContainerHeightForOffscreenStart().toFloat()
        }
        val targetBlurAlpha = searchOverlayBlurAlpha()
        val backgroundContentAlpha = searchBackgroundContentAlpha()
        val blockerAlpha = searchTouchBlockerAlpha()
        val animationDuration = LauncherSearchEntryPolicy.searchOpenAnimationDurationMs(blurLayer.alpha)
        val set = AnimatorSet()
        set.play(ObjectAnimator.ofFloat(swipeSearchContainer, View.TRANSLATION_Y, 0f))
            .with(ObjectAnimator.ofFloat(searchBackgroundBlocker, View.ALPHA, blockerAlpha))
            .with(ObjectAnimator.ofFloat(blurLayer, View.ALPHA, targetBlurAlpha))
            .with(ObjectAnimator.ofFloat(darkBlurLayer, View.ALPHA, darkBlurAlphaFor(targetBlurAlpha)))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.ALPHA, backgroundContentAlpha))
            .with(ObjectAnimator.ofFloat(mDock, View.ALPHA, backgroundContentAlpha))
        set.duration = animationDuration
        set.interpolator = LinearInterpolator()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                searchBackgroundBlocker.visibility = VISIBLE
                searchBackgroundBlocker.bringToFront()
                swipeSearchContainer.visibility = VISIBLE
                swipeSearchContainer.bringToFront()
                if (LauncherSearchEntryPolicy.shouldHideIndicatorWhileSearchIsActive()) {
                    hideHomeIndicatorForSearch()
                }
            }

            override fun onAnimationCancel(animation: Animator) {
                super.onAnimationCancel(animation)
                currentAnimator = null
                swipeSearchContainer.visibility = GONE
                searchBackgroundBlocker.visibility = GONE
                searchBackgroundBlocker.alpha = 0f
                setBlurLayersAlpha(0f)
                mHorizontalPager.visibility = VISIBLE
                setDockChromeVisibility(shouldShowDockForPage(currentPageNumber))
                setIndicatorChromeVisibility(true)
                syncDockChromeTransform()
            }

            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                currentAnimator = null

                setBlurLayersAlpha(targetBlurAlpha)
                searchBackgroundBlocker.visibility = VISIBLE
                searchBackgroundBlocker.alpha = blockerAlpha
                mHorizontalPager.visibility = if (backgroundContentAlpha > 0f) VISIBLE else GONE
                setIndicatorChromeVisibility(false)
                mHorizontalPager.alpha = backgroundContentAlpha
                mDock.alpha = backgroundContentAlpha
                setDockChromeVisibility(false)
                syncDockChromeTransform()
                refreshSwipeSearchRealtimeLiquidGlassOnOpen()

                val searchBinding = requireSwipeSearchContentBinding()
                val searchEditText = searchBinding.searchInput
                val clearSuggestions = searchBinding.clearSuggestionImageView
                val suggestedAppsRoot = SuggestedAppsViewPolicy.suggestedAppsRootForSearchTextObserver(
                    swipeSearchContainer = swipeSearchContainer,
                    usedAppsLayoutRoot = searchBinding.usedAppsLayout.root
                )
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
                            searchBinding.suggestionRecyclerView.adapter!!,
                            suggestedAppsRoot
                        )
                    )
                focusSearchInput(searchEditText)
                refreshSuggestedApps(suggestedAppsRoot, true)
            }
        })
        set.start()
        currentAnimator = set
    }

    private fun searchContainerHeightForOffscreenStart(): Int {
        swipeSearchContainer.height.takeIf { it > 0 }?.let { return it }
        val width = swipeSearchContainer.width.takeIf { it > 0 }
            ?: mDeviceProfile.availableWidthPx
        swipeSearchContainer.measure(
            View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        )
        return swipeSearchContainer.measuredHeight
            .takeIf { it > 0 }
            ?: mDeviceProfile.availableHeightPx
    }

    private fun setUpSwipeSearchContainer() {
        val searchBinding = requireSwipeSearchContentBinding()
        val searchEditText = searchBinding.searchInput
        mSearchInput = searchEditText
        val clearSuggestions = searchBinding.clearSuggestionImageView
        searchBinding.searchCancelButton.setOnClickListener {
            hideSwipeSearchContainer()
        }
        clearSuggestions.setOnClickListener {
            launcherSearchController.clearQueryAndFocus {
                focusSearchInput(searchEditText)
            }
        }

        val suggestionRecyclerView = searchBinding.suggestionRecyclerView
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
                launcherSearchController.submitCurrentQuery(
                    hideKeyboard = { hideKeyboard(searchEditText) },
                    runSearch = { query -> runSearch(query) }
                )
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
        val targetBlurAlpha = searchOverlayBlurAlpha()
        val backgroundContentAlpha = searchBackgroundContentAlpha()
        val blockerAlpha = searchTouchBlockerAlpha()
        val set = AnimatorSet()
        set.play(ObjectAnimator.ofFloat(swipeSearchContainer, View.TRANSLATION_Y, -swipeSearchContainer.height.toFloat()))
            .with(ObjectAnimator.ofFloat(searchBackgroundBlocker, View.ALPHA, 0f))
            .with(ObjectAnimator.ofFloat(mHorizontalPager, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mIndicator, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(mDock, View.ALPHA, 1f))
            .with(ObjectAnimator.ofFloat(blurLayer, View.ALPHA, 0f))
            .with(ObjectAnimator.ofFloat(darkBlurLayer, View.ALPHA, 0f))
        set.duration = 300
        set.interpolator = LinearInterpolator()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                searchBackgroundBlocker.visibility = VISIBLE
                mHorizontalPager.visibility = VISIBLE
                setDockChromeVisibility(shouldShowDockForPage(currentPageNumber))
                setIndicatorChromeVisibility(true)
                syncDockChromeTransform()
            }

            override fun onAnimationCancel(animation: Animator) {
                super.onAnimationCancel(animation)
                currentAnimator = null
                swipeSearchContainer.visibility = VISIBLE
                searchBackgroundBlocker.visibility = VISIBLE
                searchBackgroundBlocker.alpha = blockerAlpha
                setBlurLayersAlpha(targetBlurAlpha)
                mHorizontalPager.visibility = if (backgroundContentAlpha > 0f) VISIBLE else GONE
                setIndicatorChromeVisibility(false)
                mHorizontalPager.alpha = backgroundContentAlpha
                mDock.alpha = backgroundContentAlpha
                setDockChromeVisibility(false)
                syncDockChromeTransform()
            }

            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                currentAnimator = null
                swipeSearchContainer.visibility = GONE
                searchBackgroundBlocker.visibility = GONE
                searchBackgroundBlocker.alpha = 0f
                setBlurLayersAlpha(0f)
                launcherSearchController.disposeSearchObserver(SearchObserverAdapter { searchDisposableObserver })
                launcherSearchController.resetQuery()
                setDockChromeVisibility(shouldShowDockForPage(currentPageNumber))
                syncDockChromeTransform()
            }
        })
        set.start()
        currentAnimator = set
    }

    override fun onSwipeStart() {
        swipeSearchContainer.translationY = BlissLauncher.getApplication(this).deviceProfile.availableHeightPx.toFloat()
        swipeSearchContainer.visibility = GONE
        searchBackgroundBlocker.visibility = GONE
        searchBackgroundBlocker.alpha = 0f
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
        searchBackgroundBlocker.visibility = VISIBLE
        val translateBy = position * 1.25f
        if (translateBy <= swipeSearchContainer.height) {
            swipeSearchContainer.translationY = -swipeSearchContainer.height + translateBy
            val deltaAlpha = 1f - translateBy / swipeSearchContainer.height
            val progress = 1f - deltaAlpha
            val targetBackgroundAlpha = searchBackgroundContentAlpha()
            val backgroundAlpha = deltaAlpha + (progress * targetBackgroundAlpha)
            mHorizontalPager.alpha = backgroundAlpha
            if (LauncherSearchEntryPolicy.shouldHideIndicatorWhileSearchIsActive()) {
                hideHomeIndicatorForSearch()
            } else {
                mIndicator.alpha = deltaAlpha
                syncIndicatorChromeTransform()
            }
            mDock.alpha = backgroundAlpha
            searchBackgroundBlocker.alpha = progress * searchTouchBlockerAlpha()
            setBlurLayersAlpha(progress * searchOverlayBlurAlpha())
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
        val pageBinding = widgetsPageBinding ?: return
        val widgetResizeContainer = pageBinding.widgetResizerContainer
        if (widgetResizeContainer.visibility != VISIBLE) {
            activeRoundedWidgetView = roundedWidgetView

            val seekBar = pageBinding.widgetResizerSeekbar
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
                launcherLayoutRepository.saveWidgetHeight(widgetView.appWidgetId, seekBar.progress)
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
        val pageBinding = widgetsPageBinding ?: return
        val widgetResizeContainer = pageBinding.widgetResizerContainer
        if (widgetResizeContainer.visibility == VISIBLE) {
            currentAnimator?.cancel()
            val set = AnimatorSet()
            set.play(ObjectAnimator.ofFloat(widgetResizeContainer, View.TRANSLATION_Y, Utilities.pxFromDp(48, this)))
            set.duration = 200
            set.interpolator = LinearInterpolator()
            set.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator) {
                    super.onAnimationStart(animation)
                    pageBinding.widgetResizerSeekbar.setOnSeekBarChangeListener(null)
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
            val viewGroup = AppsPageBinding.inflate(LayoutInflater.from(mContext), container, false).root
            viewGroup.rowCount = 3
            viewGroup.columnCount = 3
            viewGroup.tag = position
            viewGroup.layoutTransition = getFolderLayoutTransition()
            viewGroup.setPadding(0, 0, 0, 0)
            val sortedItems = mFolderAppItems
                .mapIndexed { index, item -> index to item }
                .sortedWith(
                    compareBy<Pair<Int, LauncherItem>> { (_, item) ->
                        item.cell.takeIf { it >= 0 } ?: Int.MAX_VALUE
                    }.thenBy { (index, _) -> index }
                )
            sortedItems.forEachIndexed { sortedIndex, (_, appItem) ->
                val absoluteCell = appItem.cell.takeIf { it >= 0 } ?: sortedIndex
                if (FolderDragSessionPolicy.pageForCell(absoluteCell) != position) {
                    return@forEachIndexed
                }
                val movingItem = folderDragSession?.moving?.launcherItem
                if (!FolderDragSessionPolicy.shouldRenderFolderItem(
                        itemIsMoving = movingItem === appItem,
                        folderDragActive = folderDragSession != null
                    )
                ) {
                    return@forEachIndexed
                }
                val appView = prepareLauncherItem(appItem)
                val cellInPage = FolderDragSessionPolicy.cellInPage(absoluteCell)
                val iconLayoutParams = GridLayout.LayoutParams(
                    GridLayout.spec(cellInPage / FolderDragSessionPolicy.FOLDER_COLUMNS),
                    GridLayout.spec(cellInPage % FolderDragSessionPolicy.FOLDER_COLUMNS)
                )
                iconLayoutParams.height = folderMetrics.cellHeight
                iconLayoutParams.width = folderMetrics.cellWidth
                AppViewBinding.bind(appView).appLabel.visibility = VISIBLE
                appView.layoutParams = iconLayoutParams
                viewGroup.addView(appView)
            }
            if (isWobbling) {
                toggleWobbleAnimation(viewGroup, true)
            }
            container.addView(viewGroup)
            return viewGroup
        }

        override fun getCount(): Int {
            val itemCountPages = ceil(
                mFolderAppItems.size.toFloat() / FolderDragSessionPolicy.ITEMS_PER_PAGE
            ).toInt()
            val maxCellPage = mFolderAppItems
                .map { it.cell }
                .filter { it >= 0 }
                .maxOrNull()
                ?.let { FolderDragSessionPolicy.pageForCell(it) + 1 }
                ?: 0
            return maxOf(1, itemCountPages, maxCellPage)
        }

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

    private inner class FolderReorderAlarmListener(
        private val session: FolderDragSession,
        private val targetPage: Int,
        private val targetCell: Int
    ) : Alarm.OnAlarmListener {
        override fun onAlarm(alarm: Alarm) {
            if (folderDragSession !== session) {
                return
            }
            previewFolderDrop(session, targetPage, targetCell)
            folderReorderTargetPage = LauncherItem.INVALID_CELL
            folderReorderTargetCell = LauncherItem.INVALID_CELL
        }
    }

    inner class FolderPageScrollAlarmListener(private val targetPage: Int) : Alarm.OnAlarmListener {
        override fun onAlarm(alarm: Alarm) {
            val session = folderDragSession ?: return
            val pageCount = mFolderAppsViewPager.adapter?.count ?: 1
            cleanupFolderReorder(true)
            if (FolderDragSessionPolicy.shouldPreviewDropDuringPageScroll(targetPage, pageCount)) {
                previewFolderDrop(session, targetPage, 0)
            } else if (mFolderAppsViewPager.currentItem != targetPage) {
                mFolderAppsViewPager.setCurrentItem(targetPage, true)
            }
            folderPageScrollTarget = LauncherItem.INVALID_CELL
        }
    }

    inner class FolderHoverOpenAlarmListener(
        private val target: BlissFrameLayout,
        private val fromDock: Boolean
    ) : Alarm.OnAlarmListener {
        override fun onAlarm(alarm: Alarm) {
            val moving = movingApp ?: return
            val targetItem = target.launcherItem
            if (collidingApp !== target) {
                return
            }
            val canOpenFolder = FolderHoverOpenPolicy.canScheduleOpen(
                folderInterest = folderInterest,
                movingItemType = moving.launcherItem.itemType,
                targetItemType = targetItem.itemType,
                folderAlreadyOpen = mFolderWindowContainer.visibility == VISIBLE
            )
            val canPreviewFolderCreation = FolderHoverOpenPolicy.canScheduleCreationPreview(
                folderInterest = folderInterest,
                movingItemType = moving.launcherItem.itemType,
                targetItemType = targetItem.itemType,
                folderAlreadyOpen = mFolderWindowContainer.visibility == VISIBLE,
                previewAlreadyShownForTarget = folderCreationPreviewTarget === target
            )
            if (!canOpenFolder && !canPreviewFolderCreation) {
                return
            }

            if (canPreviewFolderCreation) {
                cleanupReorder(true)
                cleanupDockReorder(true)
                previewFolderCreationTarget(target)
                cancelFolderHoverOpen()
                return
            }

            cleanupReorder(true)
            cleanupDockReorder(true)
            target.scaleX = 1f
            target.scaleY = 1f
            folderFromDock = fromDock
            folderOpenedByDragHover = true
            dragHasEnteredOpenFolder = false
            val folderItem = targetItem as FolderItem
            displayFolder(folderItem, target)
            beginFolderDragSession(folderItem, target, moving, FolderDragOrigin.FROM_HOME_TO_FOLDER)
            cancelFolderHoverOpen()
            folderInterest = false
        }
    }
}
