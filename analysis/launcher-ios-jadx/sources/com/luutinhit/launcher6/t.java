package com.luutinhit.launcher6;

import android.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcelable;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.method.TextKeyListener;
import android.util.Log;
import android.util.Pair;
import android.util.Property;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Advanceable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.motion.widget.Key;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.editscreen.SlidingUpCustomizeColorIconStyle;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.launcher6.widget.view.SlidingUpWidgetsCellAppStyle;
import com.luutinhit.launcherios.MainActivity;
import com.luutinhit.launcherios.notification.NotificationListener;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import defpackage.a30;
import defpackage.ae0;
import defpackage.ag0;
import defpackage.ak0;
import defpackage.ar1;
import defpackage.az1;
import defpackage.b02;
import defpackage.b30;
import defpackage.be;
import defpackage.bl0;
import defpackage.bo1;
import defpackage.bx1;
import defpackage.c11;
import defpackage.c70;
import defpackage.ce0;
import defpackage.co1;
import defpackage.cx;
import defpackage.d02;
import defpackage.dl0;
import defpackage.ek0;
import defpackage.fd;
import defpackage.fg0;
import defpackage.g61;
import defpackage.g7;
import defpackage.gg0;
import defpackage.h8;
import defpackage.hl0;
import defpackage.hs;
import defpackage.hz0;
import defpackage.i31;
import defpackage.ik0;
import defpackage.iw1;
import defpackage.iz0;
import defpackage.j41;
import defpackage.jk0;
import defpackage.jq1;
import defpackage.k40;
import defpackage.kj0;
import defpackage.kj1;
import defpackage.l8;
import defpackage.lk0;
import defpackage.ly;
import defpackage.m6;
import defpackage.m61;
import defpackage.m7;
import defpackage.mj0;
import defpackage.mw;
import defpackage.mx1;
import defpackage.my;
import defpackage.n40;
import defpackage.ng;
import defpackage.ng1;
import defpackage.np1;
import defpackage.nx;
import defpackage.oe0;
import defpackage.og1;
import defpackage.oj0;
import defpackage.ox;
import defpackage.p40;
import defpackage.pb;
import defpackage.pj0;
import defpackage.pk0;
import defpackage.pw;
import defpackage.pw1;
import defpackage.px1;
import defpackage.qg0;
import defpackage.qh0;
import defpackage.qj0;
import defpackage.qk0;
import defpackage.qq;
import defpackage.qx1;
import defpackage.qy;
import defpackage.r00;
import defpackage.r7;
import defpackage.rh1;
import defpackage.rj0;
import defpackage.rk0;
import defpackage.rl0;
import defpackage.sj0;
import defpackage.t41;
import defpackage.tl0;
import defpackage.tx0;
import defpackage.u11;
import defpackage.u7;
import defpackage.uj0;
import defpackage.um;
import defpackage.v21;
import defpackage.v51;
import defpackage.v6;
import defpackage.vj0;
import defpackage.w1;
import defpackage.w11;
import defpackage.w40;
import defpackage.w61;
import defpackage.wc;
import defpackage.we1;
import defpackage.wp0;
import defpackage.wq;
import defpackage.x11;
import defpackage.x7;
import defpackage.xj0;
import defpackage.xu;
import defpackage.xw;
import defpackage.xz1;
import defpackage.y30;
import defpackage.yj0;
import defpackage.yk0;
import defpackage.z30;
import defpackage.za1;
import defpackage.zc;
import defpackage.zg;
import defpackage.zj0;
import defpackage.zl0;
import defpackage.zq;
import defpackage.zw;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class t extends Activity implements View.OnClickListener, View.OnLongClickListener, hl0, View.OnTouchListener, c11, tl0, we1, y30, SharedPreferences.OnSharedPreferenceChangeListener, ly {
    static final String ACTION_FIRST_LOAD_COMPLETE = "com.luutinhit.launcher6.action.FIRST_LOAD_COMPLETE";
    private static final int ACTIVITY_START_DELAY = 1000;
    static final int APPWIDGET_HOST_ID = 1024;
    private static final float BOUNCE_ANIMATION_TENSION = 1.3f;
    static final boolean DEBUG_DUMP_LOG = false;
    static final boolean DEBUG_RESUME_TIME = false;
    static final boolean DEBUG_STRICT_MODE = false;
    static final boolean DEBUG_WIDGETS = true;
    private static final boolean DISABLE_SYNCHRONOUS_BINDING_CURRENT_PAGE = false;
    static final String DUMP_STATE_PROPERTY = "launcher_dump_state";
    static final boolean ENABLE_DEBUG_INTENTS = false;
    public static final int EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT = 300;
    public static final String EXTRA_WALLPAPER_OFFSET = "com.luutinhit.launcher6.WALLPAPER_OFFSET";
    static final String FIRST_LOAD_COMPLETE = "launcher.first_load_complete";
    static final String FIRST_RUN_ACTIVITY_DISPLAYED = "launcher.first_run_activity_displayed";
    static final String INTENT_EXTRA_IGNORE_LAUNCH_ANIMATION = "com.luutinhit.launcher6.intent.extra.shortcut.INGORE_LAUNCH_ANIMATION";
    static final String INTRO_SCREEN_DISMISSED = "launcher.intro_screen_dismissed";
    static int NEW_APPS_ANIMATION_DELAY = 500;
    private static int NEW_APPS_ANIMATION_INACTIVE_TIMEOUT_SECONDS = 5;
    private static int NEW_APPS_PAGE_MOVE_DELAY = 500;
    private static final int ON_ACTIVITY_RESULT_ANIMATION_DELAY = 500;
    static final boolean PROFILE_STARTUP = false;
    private static final String QSB_WIDGET_ID = "qsb_widget_id";
    private static final String QSB_WIDGET_PROVIDER = "qsb_widget_provider";
    private static final int REQUEST_BIND_APPWIDGET = 11;
    private static final int REQUEST_CREATE_APPWIDGET = 5;
    private static final int REQUEST_CREATE_SHORTCUT = 1;
    private static final int REQUEST_PERMISSION_CALL_PHONE = 13;
    private static final int REQUEST_PICK_APPWIDGET = 9;
    private static final int REQUEST_PICK_WALLPAPER = 10;
    private static final int REQUEST_RECONFIGURE_APPWIDGET = 12;
    private static final String RUNTIME_STATE = "launcher.state";
    private static final String RUNTIME_STATE_CURRENT_SCREEN = "launcher.current_screen";
    private static final String RUNTIME_STATE_PENDING_ADD_CELL_X = "launcher.add_cell_x";
    private static final String RUNTIME_STATE_PENDING_ADD_CELL_Y = "launcher.add_cell_y";
    private static final String RUNTIME_STATE_PENDING_ADD_COMPONENT = "launcher.add_component";
    private static final String RUNTIME_STATE_PENDING_ADD_CONTAINER = "launcher.add_container";
    private static final String RUNTIME_STATE_PENDING_ADD_SCREEN = "launcher.add_screen";
    private static final String RUNTIME_STATE_PENDING_ADD_SPAN_X = "launcher.add_span_x";
    private static final String RUNTIME_STATE_PENDING_ADD_SPAN_Y = "launcher.add_span_y";
    private static final String RUNTIME_STATE_PENDING_ADD_WIDGET_ID = "launcher.add_widget_id";
    private static final String RUNTIME_STATE_PENDING_ADD_WIDGET_INFO = "launcher.add_widget_info";
    static final int SCREEN_COUNT = 5;
    static final String TAG = "Launcher";
    public static final String USER_HAS_MIGRATED = "launcher.user_migrated_from_old_data";
    private static zj0 sPendingAddItem;
    public l8 appsLibraryLayout;
    public boolean isDarkMode;
    public boolean isHideNavigation;
    public wq leftPage;
    private AppCompatButton mAddWidgets;
    private AppCompatButton mAddWidgetsDone;
    private lk0 mAppWidgetHost;
    private m7 mAppWidgetManager;
    private long mAutoAdvanceSentTime;
    private BlurScreenLayout mBlurBackgroundView;
    public BlurWallpaperBackground mBlurWallpaperBackground;
    private fd mBlurWallpaperProvider;
    private bl0 mClings;
    private SlidingUpCustomizeColorIconStyle mCustomizeColorApp;
    private zq mDeleteDialog;
    public xu mDeviceProfile;
    private mw mDragController;
    DragLayer mDragLayer;
    private my mEditMenu;
    private ae0 mEditWidgetLabelDialog;
    private BlurScreenLayout mFloatingBackgroundView;
    private z30 mFloatingMenu;
    FocusIndicatorView mFocusHandler;
    private Bitmap mFolderIconBitmap;
    private Canvas mFolderIconCanvas;
    ImageView mFolderIconImageView;
    private View.OnTouchListener mHapticFeedbackTouchListener;
    private Hotseat mHotseat;
    private oe0 mIconCache;
    private LayoutInflater mInflater;
    private boolean mIsSafeModeEnabled;
    private yk0 mLauncherCallbacks;
    private LauncherRootView mLauncherView;
    private rl0 mModel;
    private boolean mMoveToDefaultScreenFromNewIntent;
    private tx0 mNotificationChangedListener;
    private boolean mOnResumeNeedsLoad;
    private ViewGroup mOverviewPanel;
    private View mPageIndicators;
    private rk0 mPendingAddWidgetInfo;
    private AppWidgetHostView mQsb;
    private boolean mRestoring;
    private Bundle mSavedState;
    private SearchViewLayout mSearchView;
    private SharedPreferences mSharedPrefs;
    zl0 mStateTransitionAnimation;
    private kj1 mStats;
    private bo1 mTinyDB;
    ArrayList<v6> mTmpAppsList;
    private Handler mUiHandler;
    private Vibrator mVibrator;
    private boolean mWaitingForResult;
    private BubbleTextView mWaitingForResume;
    public View mWeightWatcher;
    public SlidingUpWidgetsCellAppStyle mWidgetsAppStyle;
    private View mWidgetsButton;
    qx1 mWidgetsModel;
    WidgetsContainerView mWidgetsView;
    private Handler mWorkerHandler;
    Workspace mWorkspace;
    public hz0 pullDetector;
    public int screenHeight;
    public int screenWidth;
    private static wp0 sFolders = new wp0();
    static final ArrayList<String> sDumpLogs = new ArrayList<>();
    static Date sDateStamp = new Date();
    static DateFormat sDateFormat = DateFormat.getDateTimeInstance(3, 3);
    protected static HashMap<String, qq> sCustomAppWidgets = new HashMap<>();
    ak0 mState = ak0.h;
    private final BroadcastReceiver mCloseSystemDialogsReceiver = new m6(this, 2);
    private final int MSG_NOTIFICATION_CLEAR_ALL = 0;
    private final int MSG_NOTIFICATION_FULL_REFRESH = 1;
    private final int MSG_SAVE_HISTORY_BACKGROUND = 3;
    private final Handler.Callback mWorkerCallback = new h8(this, 2);
    private Handler.Callback mUiCallback = new l(this, 1);
    private boolean mIsListening = false;
    u11 mPendingAddInfo = new u11();
    private int mPendingAddWidgetId = -1;
    private int[] mTmpAddItemCellCoordinates = new int[2];
    private boolean mAutoAdvanceRunning = false;
    private ak0 mOnResumeState = ak0.g;
    private SpannableStringBuilder mDefaultKeySsb = null;
    boolean mWorkspaceLoading = DEBUG_WIDGETS;
    private boolean mPaused = DEBUG_WIDGETS;
    private ArrayList<Runnable> mBindOnResumeCallbacks = new ArrayList<>();
    private ArrayList<Runnable> mOnResumeCallbacks = new ArrayList<>();
    boolean mUserPresent = DEBUG_WIDGETS;
    private boolean mVisible = false;
    private boolean mHasFocus = false;
    private boolean mAttached = false;
    private final int ADVANCE_MSG = 1;
    private final int SCREEN_OFF = 2;
    private final int mAdvanceInterval = 20000;
    private final int mAdvanceStagger = 250;
    private long mAutoAdvanceTimeLeft = -1;
    HashMap<View, AppWidgetProviderInfo> mWidgetsToAdvance = new HashMap<>();
    private final int mRestoreScreenOrientationDelay = ON_ACTIVITY_RESULT_ANIMATION_DELAY;
    private final ArrayList<Integer> mSynchronouslyBoundPages = new ArrayList<>();
    private Rect mRectForFolderAnimation = new Rect();
    private boolean mIsShaking = false;
    public boolean showingFloatingMenu = false;
    public boolean showingEditMenu = false;
    public boolean autoRearrange = false;
    public boolean isUseLiquidGlass = false;
    public boolean isRuntimeRenderSupport = false;
    public boolean isRenderEffectSupport = false;
    public boolean isRTL = false;
    public boolean isUnlockAnim = DEBUG_WIDGETS;
    public boolean isOpenCloseAnim = DEBUG_WIDGETS;
    public boolean isShowAppsLibraryGuide = DEBUG_WIDGETS;
    HashMap<View, ObjectAnimator> mDeleteAnimators = new HashMap<>();
    Runnable mBuildLayersRunnable = new m(this, 3);
    private boolean mRotationEnabled = false;
    private Runnable mUpdateOrientationRunnable = new oj0(this, 5);
    public int mIconTextColor = -1;
    private final BroadcastReceiver mReceiver = new i(this);
    final Handler mHandler = new Handler(new l(this, 0));
    private final Runnable mBindAllApplicationsRunnable = new m(this, 2);
    private final Runnable mBindWidgetModelRunnable = new m(this, 4);
    private final co1 mTinyDBChange = new co1();

    public static /* synthetic */ void a(t tVar) {
        tVar.mCustomizeColorApp.requestFocus();
        tVar.mCustomizeColorApp.setVisibility(0);
        tVar.mCustomizeColorApp.setPanelState(rh1.g);
    }

    public static void addDumpLog(String str, String str2, Exception exc, boolean z) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0015 A[Catch: all -> 0x0009, TRY_LEAVE, TryCatch #0 {all -> 0x0009, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x0006, B:13:0x0015, B:8:0x000b, B:10:0x000f), top: B:18:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void b(com.luutinhit.launcher6.t r1, defpackage.qh0 r2, android.util.Pair r3) {
        /*
            boolean r0 = r2 instanceof defpackage.og1     // Catch: java.lang.Throwable -> L9
            if (r0 == 0) goto Lb
            og1 r2 = (defpackage.og1) r2     // Catch: java.lang.Throwable -> L9
        L6:
            jq1 r2 = r2.w     // Catch: java.lang.Throwable -> L9
            goto L13
        L9:
            r2 = move-exception
            goto L25
        Lb:
            boolean r0 = r2 instanceof defpackage.v6     // Catch: java.lang.Throwable -> L9
            if (r0 == 0) goto L12
            v6 r2 = (defpackage.v6) r2     // Catch: java.lang.Throwable -> L9
            goto L6
        L12:
            r2 = 0
        L13:
            if (r2 == 0) goto L28
            java.lang.Object r0 = r3.first     // Catch: java.lang.Throwable -> L9
            android.content.ComponentName r0 = (android.content.ComponentName) r0     // Catch: java.lang.Throwable -> L9
            java.lang.Object r3 = r3.second     // Catch: java.lang.Throwable -> L9
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L9
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L9
            r1.startApplicationUninstallActivity(r0, r3, r2)     // Catch: java.lang.Throwable -> L9
            goto L28
        L25:
            r2.getMessage()
        L28:
            zq r1 = r1.mDeleteDialog
            r1.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.t.b(com.luutinhit.launcher6.t, qh0, android.util.Pair):void");
    }

    public static /* synthetic */ void c(t tVar, Pair pair) {
        try {
            ArrayList arrayListD = tVar.mTinyDB.d("list_hidden_apps");
            String strFlattenToString = ((ComponentName) pair.first).flattenToString();
            if (!arrayListD.contains(strFlattenToString)) {
                arrayListD.add(strFlattenToString);
                tVar.mTinyDB.i("list_hidden_apps", arrayListD);
            }
            Intent intent = new Intent("com.luutinhit.launcherios.ACTION_HIDDEN_APPS_IN_WORKSPACE");
            intent.putExtra("HIDDEN_APPS_UPDATED", new String[0]);
            intent.putExtra("HIDDEN_APPS_REMOVED", (String[]) arrayListD.toArray(new String[0]));
            tVar.sendBroadcast(intent);
        } catch (Throwable th) {
            th.getMessage();
        }
        tVar.mDeleteDialog.a();
    }

    public static /* synthetic */ void d(t tVar) {
        tVar.mCustomizeColorApp.clearFocus();
        tVar.mCustomizeColorApp.setVisibility(8);
        tVar.mCustomizeColorApp.setPanelStateInternal(rh1.h);
        tVar.mCustomizeColorApp.f();
    }

    public static void dumpDebugLogsToConsole() {
    }

    public static Pair<ComponentName, Integer> getAppInfoFlags(Object obj) {
        Objects.toString(obj);
        if (obj instanceof v6) {
            v6 v6Var = (v6) obj;
            return Pair.create(v6Var.A, Integer.valueOf(v6Var.C));
        }
        if (!(obj instanceof og1)) {
            return null;
        }
        og1 og1Var = (og1) obj;
        ComponentName componentNameG = og1Var.g();
        if (og1Var.h != 0 || componentNameG == null) {
            return null;
        }
        return Pair.create(componentNameG, Integer.valueOf(og1Var.G));
    }

    public static qq getCustomAppWidget(String str) {
        if (sCustomAppWidgets.get(str) == null) {
            return null;
        }
        throw new ClassCastException();
    }

    public static HashMap<String, qq> getCustomAppWidgets() {
        return sCustomAppWidgets;
    }

    public static List<View> getFolderContents(View view) {
        Objects.toString(view);
        return view instanceof FolderIcon ? ((FolderIcon) view).getFolder().getItemsInReadingOrder() : Collections.EMPTY_LIST;
    }

    public static void m(t tVar, String str) {
        if (str == null) {
            tVar.getClass();
            return;
        }
        if (tVar.mModel != null) {
            ArrayList arrayList = rl0.C;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                qh0 qh0Var = (qh0) obj;
                if (qh0Var != null && (qh0Var instanceof og1)) {
                    og1 og1Var = (og1) qh0Var;
                    if (og1Var.g() != null && og1Var.g().getPackageName().equals(str)) {
                        og1Var.s++;
                    } else if (str.equals("com.android.server.telecom") && og1Var.g() != null && (og1Var.g().toString().toLowerCase().contains("dialer") || og1Var.g().toString().toLowerCase().contains("dialtacts"))) {
                        og1Var.s++;
                    }
                } else if (qh0Var instanceof w40) {
                    ArrayList arrayList2 = ((w40) qh0Var).x;
                    int size2 = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj2 = arrayList2.get(i2);
                        i2++;
                        og1 og1Var2 = (og1) obj2;
                        if (og1Var2.g() != null && og1Var2.g().getPackageName().equals(str)) {
                            og1Var2.s++;
                            qh0Var.s++;
                        } else if (str.equals("com.android.server.telecom") && og1Var2.g() != null && (og1Var2.g().toString().toLowerCase().contains("dialer") || og1Var2.g().toString().toLowerCase().contains("dialtacts"))) {
                            og1Var2.s++;
                            qh0Var.s++;
                        }
                    }
                }
            }
        }
    }

    public static zj0 r(int i, Intent intent, int i2, qh0 qh0Var) {
        Objects.toString(intent);
        Objects.toString(qh0Var);
        zj0 zj0Var = new zj0();
        zj0Var.a = i;
        zj0Var.b = intent;
        zj0Var.c = qh0Var.i;
        zj0Var.d = qh0Var.j;
        zj0Var.e = qh0Var.k;
        zj0Var.f = qh0Var.l;
        zj0Var.g = i2;
        return zj0Var;
    }

    public void addAppWidgetFromDropImpl(int i, qh0 qh0Var, AppWidgetHostView appWidgetHostView, rk0 rk0Var) {
        addAppWidgetImpl(i, qh0Var, appWidgetHostView, rk0Var, 0);
    }

    public void addAppWidgetImpl(int i, qh0 qh0Var, AppWidgetHostView appWidgetHostView, rk0 rk0Var, int i2) {
        if (((AppWidgetProviderInfo) rk0Var).configure != null) {
            this.mPendingAddWidgetInfo = rk0Var;
            this.mPendingAddWidgetId = i;
            this.mAppWidgetManager.l(rk0Var, i, this, this.mAppWidgetHost, 5);
        } else {
            oj0 oj0Var = new oj0(this, 0);
            completeAddAppWidget(i, qh0Var.i, qh0Var.j, appWidgetHostView, rk0Var);
            this.mWorkspace.W0(DEBUG_WIDGETS, oj0Var, i2, false);
        }
    }

    public FolderIcon addFolder(CellLayout cellLayout, long j, long j2, int i, int i2) {
        Objects.toString(cellLayout);
        w40 w40Var = new w40();
        w40Var.u = getText(w61.folder_name);
        rl0.b(this, w40Var, j, j2, i, i2);
        sFolders.put(w40Var.g, w40Var);
        FolderIcon folderIconJ = FolderIcon.j(m61.folder_icon, this, cellLayout, w40Var, this.mIconCache);
        Workspace workspace = this.mWorkspace;
        boolean zIsWorkspaceLocked = isWorkspaceLocked();
        workspace.getClass();
        Objects.toString(folderIconJ);
        workspace.j0(folderIconJ, j, j2, i, i2, 1, 1, zIsWorkspaceLocked, false);
        this.mWorkspace.F0(folderIconJ).getShortcutsAndWidgets().e(folderIconJ);
        return folderIconJ;
    }

    public void addOnResumeCallback(Runnable runnable) {
        Objects.toString(runnable);
        this.mOnResumeCallbacks.add(runnable);
    }

    public void addPendingItem(u11 u11Var, long j, long j2, int[] iArr, int i, int i2) {
        Parcelable parcelable;
        Objects.toString(u11Var);
        int i3 = u11Var.h;
        if (i3 == 1) {
            ComponentName componentName = u11Var.x;
            Objects.toString(componentName);
            s();
            u11 u11Var2 = this.mPendingAddInfo;
            u11Var2.i = j;
            u11Var2.j = j2;
            u11Var2.x = componentName;
            if (iArr != null) {
                u11Var2.k = iArr[0];
                u11Var2.l = iArr[1];
            }
            Intent intent = new Intent("android.intent.action.CREATE_SHORTCUT");
            intent.setComponent(componentName);
            Rect rect = ar1.a;
            try {
                startActivityForResult(intent, 1);
                return;
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(this, w61.activity_not_found, 0).show();
                return;
            } catch (SecurityException unused2) {
                Toast.makeText(this, w61.activity_not_found, 0).show();
                Objects.toString(intent);
                return;
            }
        }
        if (i3 != 4 && i3 != 5) {
            throw new IllegalStateException("Unknown item type: " + u11Var.h);
        }
        int[] iArr2 = {i, i2};
        w11 w11Var = (w11) u11Var;
        s();
        u11 u11Var3 = this.mPendingAddInfo;
        w11Var.i = j;
        u11Var3.i = j;
        w11Var.j = j2;
        u11Var3.j = j2;
        u11Var3.o = w11Var.o;
        u11Var3.p = w11Var.p;
        if (iArr != null) {
            u11Var3.k = iArr[0];
            u11Var3.l = iArr[1];
        }
        u11Var3.m = iArr2[0];
        u11Var3.n = iArr2[1];
        AppWidgetHostView appWidgetHostView = w11Var.A;
        rk0 rk0Var = w11Var.z;
        if (appWidgetHostView != null) {
            getDragLayer().removeView(appWidgetHostView);
            addAppWidgetFromDropImpl(appWidgetHostView.getAppWidgetId(), w11Var, appWidgetHostView, rk0Var);
            w11Var.A = null;
            return;
        }
        int iAllocateAppWidgetId = getAppWidgetHost().allocateAppWidgetId();
        if (this.mAppWidgetManager.a(iAllocateAppWidgetId, rk0Var, w11Var.B)) {
            addAppWidgetFromDropImpl(iAllocateAppWidgetId, w11Var, null, rk0Var);
            return;
        }
        this.mPendingAddWidgetInfo = rk0Var;
        Intent intent2 = new Intent("android.appwidget.action.APPWIDGET_BIND");
        intent2.putExtra("appWidgetId", iAllocateAppWidgetId);
        intent2.putExtra("appWidgetProvider", w11Var.x);
        jq1 jq1VarH = this.mAppWidgetManager.h(this.mPendingAddWidgetInfo);
        jq1VarH.getClass();
        if (ar1.m && (parcelable = jq1VarH.a) != null) {
            intent2.putExtra("appWidgetProviderProfile", parcelable);
        }
        startActivityForResult(intent2, 11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addToCustomContentPage(View view, xj0 xj0Var, String str, int i) {
        Objects.toString(view);
        Objects.toString(xj0Var);
        Workspace workspace = this.mWorkspace;
        workspace.getClass();
        long j = i == 0 ? -301L : -302L;
        if (workspace.E0(j) < 0) {
            throw new RuntimeException("Expected custom content screen to exist");
        }
        CellLayout cellLayoutH0 = workspace.H0(j);
        zg zgVar = new zg(0, 0, cellLayoutH0.getCountX(), cellLayoutH0.getCountY());
        zgVar.j = false;
        zgVar.i = DEBUG_WIDGETS;
        if (view instanceof fg0) {
            ((fg0) view).setInsets(workspace.n0);
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        cellLayoutH0.removeAllViews();
        view.setFocusable(DEBUG_WIDGETS);
        view.setOnKeyListener(new c70(0));
        view.setOnFocusChangeListener(workspace.S0.mFocusHandler.getHideIndicatorOnFocusListener());
        cellLayoutH0.a(view, 0, 0, zgVar, DEBUG_WIDGETS);
        if (i != 0) {
            workspace.K0 = xj0Var;
        } else {
            workspace.O0 = str;
            workspace.J0 = xj0Var;
        }
    }

    public void bindAddScreens(ArrayList<Long> arrayList) {
        Objects.toString(arrayList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Workspace workspace = this.mWorkspace;
            long jLongValue = arrayList.get(i).longValue();
            ArrayList arrayList2 = workspace.A0;
            int iIndexOf = arrayList2.contains(-302L) ? arrayList2.indexOf(-302L) : arrayList2.indexOf(-201L);
            if (iIndexOf < 0) {
                iIndexOf = arrayList2.size();
            }
            workspace.K0(iIndexOf, jLongValue);
        }
    }

    @Override // defpackage.hl0
    public void bindAllApplications(ArrayList<v6> arrayList) {
        Objects.toString(arrayList);
        if (waitUntilResume(this.mBindAllApplicationsRunnable, DEBUG_WIDGETS)) {
            this.mTmpAppsList = arrayList;
            return;
        }
        rl0 rl0Var = this.mModel;
        if (rl0Var != null) {
            rl0Var.a(this, arrayList);
        }
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            IOSLauncher iOSLauncher = ((com.luutinhit.launcher6.ioslauncher.a) yk0Var).a;
            l8 l8Var = iOSLauncher.appsLibraryLayout;
            if (l8Var != null) {
                l8Var.setApps(arrayList);
            }
            if (iOSLauncher.getSearchView() != null) {
                iOSLauncher.getSearchView().z(arrayList);
            }
        }
    }

    @Override // defpackage.hl0
    public void bindAppInfosRemoved(ArrayList<v6> arrayList) {
        l8 l8Var;
        ArrayList arrayList2;
        Objects.toString(arrayList);
        if (y(new uj0(this, arrayList, 2)) || (l8Var = this.appsLibraryLayout) == null || (arrayList2 = l8Var.l) == null || arrayList2.size() != 10) {
            return;
        }
        Objects.toString(arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            v6 v6Var = arrayList.get(i);
            i++;
            v6 v6Var2 = v6Var;
            if (v6Var2 != null) {
                boolean zContains = ((x7) arrayList2.get(0)).b.contains(v6Var2);
                u7 u7Var = l8Var.j;
                if (zContains) {
                    ((x7) arrayList2.get(0)).b.remove(v6Var2);
                    u7Var.g(0);
                }
                int iN = l8Var.n(v6Var2);
                if (iN >= 0) {
                    if (arrayList2.get(iN) != null) {
                        ((x7) arrayList2.get(iN)).b.remove(v6Var2);
                        u7Var.g(iN);
                    }
                } else if (arrayList2.get(0) != null && arrayList2.get(9) != null) {
                    ((x7) arrayList2.get(9)).b.remove(v6Var2);
                    u7Var.g(9);
                }
            }
        }
    }

    @Override // defpackage.hl0
    public void bindAppWidget(qk0 qk0Var) {
        AppWidgetHostView appWidgetHostViewCreateView;
        if (qk0Var == null || y(new wc(this, qk0Var, 13))) {
            return;
        }
        try {
            if (this.mIsSafeModeEnabled) {
                x11 x11Var = new x11(this, qk0Var, DEBUG_WIDGETS);
                x11Var.e(this.mIconCache);
                qk0Var.C = x11Var;
                x11Var.updateAppWidget(null);
                qk0Var.C.setOnClickListener(this);
                n(qk0Var, null, false);
                this.mWorkspace.requestLayout();
                return;
            }
            qk0Var.toString();
            boolean zF = qk0Var.f(2);
            boolean zF2 = qk0Var.f(1);
            ComponentName componentName = qk0Var.y;
            rk0 rk0VarB = zF ? null : zF2 ? this.mAppWidgetManager.b(componentName, qk0Var.w) : this.mAppWidgetManager.g(qk0Var.x);
            int i = qk0Var.z;
            if (!zF && i != 0) {
                if (rk0VarB == null) {
                    Objects.toString(componentName);
                    rl0.e(this, qk0Var);
                    return;
                }
                if (zF2) {
                    w11 w11Var = new w11(this, rk0VarB);
                    w11Var.m = qk0Var.m;
                    w11Var.n = qk0Var.n;
                    w11Var.o = qk0Var.o;
                    w11Var.p = qk0Var.p;
                    Bundle bundleA = bx1.a(this, w11Var);
                    int iAllocateAppWidgetId = this.mAppWidgetHost.allocateAppWidgetId();
                    if (!this.mAppWidgetManager.a(iAllocateAppWidgetId, rk0VarB, bundleA)) {
                        this.mAppWidgetHost.deleteAppWidgetId(iAllocateAppWidgetId);
                        Objects.toString(componentName);
                        rl0.e(this, qk0Var);
                        return;
                    } else {
                        qk0Var.x = iAllocateAppWidgetId;
                        qk0Var.z = ((AppWidgetProviderInfo) rk0VarB).configure == null ? 0 : 4;
                        rl0.E(this, qk0Var);
                    }
                } else if (qk0Var.f(4) && ((AppWidgetProviderInfo) rk0VarB).configure == null) {
                    qk0Var.z = 0;
                    rl0.E(this, qk0Var);
                }
            }
            if (qk0Var.z == 0 && rk0VarB != null) {
                lk0 lk0Var = this.mAppWidgetHost;
                if (lk0Var != null && (appWidgetHostViewCreateView = lk0Var.createView(this, qk0Var.x, rk0VarB)) != null) {
                    qk0Var.C = appWidgetHostViewCreateView;
                    qk0Var.o = rk0VarB.i;
                    qk0Var.p = rk0VarB.j;
                    n(qk0Var, rk0VarB, false);
                    return;
                }
                return;
            }
            x11 x11Var2 = new x11(this, qk0Var, this.mIsSafeModeEnabled);
            x11Var2.e(this.mIconCache);
            qk0Var.C = x11Var2;
            x11Var2.updateAppWidget(null);
            qk0Var.C.setOnClickListener(this);
            n(qk0Var, null, false);
            this.mWorkspace.requestLayout();
        } catch (Throwable unused) {
        }
    }

    @Override // defpackage.hl0
    public void bindAppsAdded(ArrayList<Long> arrayList, ArrayList<qh0> arrayList2, ArrayList<qh0> arrayList3, ArrayList<v6> arrayList4) {
        l8 l8Var;
        ArrayList arrayList5;
        Objects.toString(arrayList);
        Objects.toString(arrayList2);
        Objects.toString(arrayList3);
        Objects.toString(arrayList4);
        if (y(new sj0(this, arrayList, arrayList2, arrayList3, arrayList4, 0))) {
            return;
        }
        if (arrayList != null) {
            bindAddScreens(arrayList);
        }
        int i = 0;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            bindItems(arrayList2, 0, arrayList2.size(), false);
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            bindItems(arrayList3, 0, arrayList3.size(), DEBUG_WIDGETS);
        }
        this.mWorkspace.W0(false, null, 0, false);
        if (arrayList4 == null || (l8Var = this.appsLibraryLayout) == null || (arrayList5 = l8Var.l) == null) {
            return;
        }
        try {
            if (arrayList5.size() == 10) {
                int size = arrayList4.size();
                while (i < size) {
                    v6 v6Var = arrayList4.get(i);
                    i++;
                    v6 v6Var2 = v6Var;
                    arrayList4.toString();
                    if (v6Var2 != null) {
                        int iN = l8Var.n(v6Var2);
                        u7 u7Var = l8Var.j;
                        if (iN >= 0) {
                            if (arrayList5.get(iN) != null && !((x7) arrayList5.get(iN)).b.contains(v6Var2)) {
                                ((x7) arrayList5.get(iN)).b.add(v6Var2);
                                u7Var.g(iN);
                            }
                        } else if (arrayList5.get(9) != null && !((x7) arrayList5.get(9)).b.contains(v6Var2)) {
                            ((x7) arrayList5.get(9)).b.add(v6Var2);
                            u7Var.g(9);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // defpackage.hl0
    public void bindAppsUpdated(ArrayList<v6> arrayList) {
        Objects.toString(arrayList);
        y(new uj0(this, arrayList, 0));
    }

    @Override // defpackage.hl0
    public void bindFolders(wp0 wp0Var) {
        Objects.toString(wp0Var);
        if (y(new w1(this, wp0Var, 23, false))) {
            return;
        }
        sFolders = wp0Var.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    @Override // defpackage.hl0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void bindItems(java.util.ArrayList<defpackage.qh0> r27, int r28, int r29, boolean r30) {
        /*
            Method dump skipped, instruction units count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.t.bindItems(java.util.ArrayList, int, int, boolean):void");
    }

    @Override // defpackage.hl0
    public void bindRestoreItemsChange(HashSet<qh0> hashSet) {
        Objects.toString(hashSet);
        if (y(new w1(this, hashSet, 24, false))) {
            return;
        }
        Workspace workspace = this.mWorkspace;
        workspace.getClass();
        Objects.toString(hashSet);
        workspace.O0(DEBUG_WIDGETS, new pw1(hashSet));
    }

    @Override // defpackage.hl0
    public void bindScreens(ArrayList<Long> arrayList) {
        Objects.toString(arrayList);
        bindAddScreens(arrayList);
        if (arrayList.size() == 0) {
            this.mWorkspace.i0();
        }
        if (hasCustomContentToLeft()) {
            this.mWorkspace.r0(0);
            this.mWorkspace.r0(1);
            populateCustomContentContainer();
        }
    }

    @Override // defpackage.hl0
    public void bindShortcutsChanged(ArrayList<og1> arrayList, ArrayList<og1> arrayList2, jq1 jq1Var) {
        Objects.toString(arrayList);
        Objects.toString(arrayList2);
        Objects.toString(jq1Var);
        if (y(new vj0(this, arrayList, arrayList2, jq1Var, 0))) {
            return;
        }
        if (!arrayList.isEmpty()) {
            Workspace workspace = this.mWorkspace;
            workspace.getClass();
            Objects.toString(arrayList);
            workspace.O0(DEBUG_WIDGETS, new v21(workspace, new HashSet(arrayList)));
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            og1 og1Var = arrayList2.get(i);
            i++;
            hashSet.add(og1Var.g());
        }
        this.mWorkspace.X0(hashSet, jq1Var);
        this.mDragController.j(new HashSet(), hashSet);
    }

    @Override // defpackage.hl0
    public void bindShortcutsHidden(ArrayList<og1> arrayList, ArrayList<og1> arrayList2, jq1 jq1Var) {
        Objects.toString(arrayList);
        Objects.toString(arrayList2);
        Objects.toString(jq1Var);
        if (y(new vj0(this, arrayList, arrayList2, jq1Var, 1))) {
            return;
        }
        if (!arrayList2.isEmpty()) {
            HashSet hashSet = new HashSet();
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                og1 og1Var = arrayList2.get(i);
                i++;
                og1 og1Var2 = og1Var;
                Objects.toString(og1Var2);
                hashSet.add(og1Var2.g());
                rl0.e(this, og1Var2);
            }
            this.mWorkspace.X0(hashSet, jq1Var);
            this.mDragController.j(new HashSet(), hashSet);
            if (this.autoRearrange) {
                rearrangeApps(false);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        int size2 = arrayList.size();
        int i2 = 0;
        while (i2 < size2) {
            int i3 = i2 + 1;
            og1 og1Var3 = arrayList.get(i2);
            int[] iArr = new int[2];
            Workspace workspace = getWorkspace();
            ArrayList<Long> screenOrder = workspace.getScreenOrder();
            int currentPage = workspace.getCurrentPage();
            long jLongValue = screenOrder.get(currentPage).longValue();
            boolean zO = ((CellLayout) workspace.getChildAt(currentPage)).o(iArr, og1Var3.m, og1Var3.n);
            boolean zI0 = workspace.I0();
            screenOrder.size();
            for (int i4 = zI0; !zO && i4 < screenOrder.size(); i4++) {
                jLongValue = screenOrder.get(i4).longValue();
                zO = ((CellLayout) workspace.getChildAt(i4)).o(iArr, og1Var3.m, og1Var3.n);
            }
            if (jLongValue == -201) {
                jLongValue = workspace.q0();
                zO = workspace.H0(jLongValue).o(iArr, og1Var3.m, og1Var3.n);
            }
            if (!zO) {
                workspace.i0();
                jLongValue = workspace.q0();
                workspace.H0(jLongValue).o(iArr, og1Var3.m, og1Var3.n);
            }
            rl0.c(this, og1Var3, -100L, jLongValue, iArr[0], iArr[1]);
            ArrayList<qh0> arrayList3 = new ArrayList<>();
            arrayList3.add(og1Var3);
            bindItems(arrayList3, 0, arrayList3.size(), DEBUG_WIDGETS);
            i2 = i3;
        }
    }

    @Override // defpackage.hl0
    public void bindWidgetsModel(qx1 qx1Var) {
        if (waitUntilResume(this.mBindWidgetModelRunnable, DEBUG_WIDGETS)) {
            this.mWidgetsModel = qx1Var;
            return;
        }
        WidgetsContainerView widgetsContainerView = this.mWidgetsView;
        if (widgetsContainerView == null || qx1Var == null) {
            return;
        }
        px1 px1Var = widgetsContainerView.U;
        try {
            widgetsContainerView.b0 = qx1Var;
            px1Var.l = qx1Var;
            px1Var.s = new boolean[qx1Var.b.size()];
            px1Var.f();
        } catch (Throwable th) {
            th.getMessage();
        }
        this.mWidgetsModel = null;
    }

    @Override // defpackage.hl0
    public void bindWidgetsRestored(ArrayList<qk0> arrayList) {
        AppWidgetProviderInfo appWidgetInfo;
        Objects.toString(arrayList);
        if (y(new uj0(this, arrayList, 1))) {
            return;
        }
        Workspace workspace = this.mWorkspace;
        workspace.getClass();
        if (arrayList.isEmpty()) {
            return;
        }
        t tVar = workspace.S0;
        b02 b02Var = new b02(workspace, arrayList, tVar.getAppWidgetHost());
        int i = 0;
        qk0 qk0Var = arrayList.get(0);
        if (qk0Var.f(1)) {
            appWidgetInfo = m7.f(tVar).b(qk0Var.y, qk0Var.w);
        } else {
            m7 m7VarF = m7.f(tVar);
            appWidgetInfo = m7VarF.a.getAppWidgetInfo(qk0Var.x);
        }
        if (appWidgetInfo != null) {
            b02Var.run();
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            qk0 qk0Var2 = arrayList.get(i);
            i++;
            qk0 qk0Var3 = qk0Var2;
            AppWidgetHostView appWidgetHostView = qk0Var3.C;
            if (appWidgetHostView instanceof x11) {
                qk0Var3.A = 100;
                ((x11) appWidgetHostView).d();
            }
        }
    }

    @Override // defpackage.hl0
    public void bindWorkspaceComponentsRemoved(HashSet<String> hashSet, HashSet<ComponentName> hashSet2, jq1 jq1Var) {
        Objects.toString(hashSet);
        Objects.toString(hashSet2);
        Objects.toString(jq1Var);
        if (y(new ng(this, hashSet, hashSet2, jq1Var, 1))) {
            return;
        }
        if (!hashSet.isEmpty()) {
            this.mWorkspace.Y0(hashSet, jq1Var);
        }
        if (!hashSet2.isEmpty()) {
            this.mWorkspace.X0(hashSet2, jq1Var);
        }
        this.mDragController.j(hashSet, hashSet2);
    }

    public void cancelShakingAnimation() {
        if (this.mIsShaking) {
            int i = 0;
            this.mIsShaking = false;
            if (this.mWorkspace != null) {
                this.mAddWidgets.setVisibility(8);
                this.mAddWidgetsDone.setVisibility(8);
                if (this.mWorkspace.getOpenFolder() != null) {
                    this.mWorkspace.getOpenFolder().y();
                }
                ArrayList<ng1> allShortcutAndWidgetContainers = this.mWorkspace.getAllShortcutAndWidgetContainers();
                int size = allShortcutAndWidgetContainers.size();
                while (i < size) {
                    ng1 ng1Var = allShortcutAndWidgetContainers.get(i);
                    i++;
                    ng1Var.a();
                }
                this.mWorkspace.postOnAnimationDelayed(new kj0(this, 1), 568L);
                this.mWorkspace.getPageIndicator().f();
            }
        }
    }

    public void changeWallpaperVisiblity(boolean z) {
        int i = z ? 1048576 : 0;
        if (i != (getWindow().getAttributes().flags & 1048576)) {
            getWindow().setFlags(i, 1048576);
        }
    }

    public void clearBadgeCount() {
        rl0 rl0Var = this.mModel;
        if (rl0Var != null) {
            rl0Var.getClass();
            ArrayList arrayList = rl0.C;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                qh0 qh0Var = (qh0) obj;
                if (qh0Var instanceof og1) {
                    ((og1) qh0Var).s = 0;
                } else if (qh0Var instanceof w40) {
                    w40 w40Var = (w40) qh0Var;
                    ArrayList arrayList2 = w40Var.x;
                    int size2 = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj2 = arrayList2.get(i2);
                        i2++;
                        ((og1) obj2).s = 0;
                    }
                    w40Var.s = 0;
                }
            }
        }
    }

    public void closeCustomizeColorAppStyle() {
        SlidingUpCustomizeColorIconStyle slidingUpCustomizeColorIconStyle = this.mCustomizeColorApp;
        if (slidingUpCustomizeColorIconStyle != null) {
            slidingUpCustomizeColorIconStyle.postOnAnimation(new kj0(this, 0));
        }
    }

    public void closeEditMenu() {
        my myVar = this.mEditMenu;
        if (myVar == null || !this.showingEditMenu) {
            return;
        }
        this.showingEditMenu = false;
        myVar.b();
    }

    public void closeFloatingMenu() {
        if (this.mFloatingMenu == null || !this.showingFloatingMenu) {
            return;
        }
        this.showingFloatingMenu = false;
        this.mFloatingBackgroundView.d(DEBUG_WIDGETS);
        this.mFloatingMenu.d();
    }

    public void closeFolder() {
        closeFolder(DEBUG_WIDGETS);
    }

    public void closeSystemDialogs() {
        getWindow().closeAllPanels();
        t(false);
    }

    public void closeWidgetView(final boolean z) {
        WidgetsContainerView widgetsContainerView;
        if (isWidgetsViewVisible() && (widgetsContainerView = this.mWidgetsView) != null) {
            widgetsContainerView.postOnAnimation(new Runnable() { // from class: com.luutinhit.launcher6.e
                @Override // java.lang.Runnable
                public final void run() {
                    t tVar = this.g;
                    tVar.mWidgetsView.clearFocus();
                    WidgetsContainerView widgetsContainerView2 = tVar.mWidgetsView;
                    SlidingUpWidgetsCellAppStyle slidingUpWidgetsCellAppStyle = widgetsContainerView2.P.mWidgetsAppStyle;
                    if (slidingUpWidgetsCellAppStyle != null) {
                        slidingUpWidgetsCellAppStyle.postOnAnimation(new mx1(widgetsContainerView2, 1));
                    }
                    tVar.mWidgetsView.setVisibility(8);
                    tVar.mWidgetsView.setPanelStateInternal(rh1.h);
                    tVar.mWidgetsView.f();
                    if (z) {
                        tVar.onShakingAllApps();
                    }
                }
            });
        }
        this.mState = ak0.h;
        getWorkspace().setState(d02.h);
    }

    public void closeWidgetViewWithAnimation() {
        this.mWidgetsView.setPanelState(rh1.h);
    }

    public void completeAddAppWidget(int i, long j, long j2, AppWidgetHostView appWidgetHostView, rk0 rk0Var) {
        u11 u11Var = this.mPendingAddInfo;
        rk0 rk0VarG = rk0Var == null ? this.mAppWidgetManager.g(i) : rk0Var;
        rk0VarG.getClass();
        qk0 qk0Var = new qk0(i, ((AppWidgetProviderInfo) rk0VarG).provider);
        qk0Var.m = u11Var.m;
        qk0Var.n = u11Var.n;
        qk0Var.o = u11Var.o;
        qk0Var.p = u11Var.p;
        qk0Var.w = this.mAppWidgetManager.h(rk0VarG);
        rl0.b(this, qk0Var, j, j2, u11Var.k, u11Var.l);
        if (!this.mRestoring) {
            if (appWidgetHostView == null) {
                lk0 lk0Var = this.mAppWidgetHost;
                lk0Var.getClass();
                qk0Var.C = lk0Var.createView(this, i, rk0VarG);
            } else {
                qk0Var.C = appWidgetHostView;
            }
            qk0Var.C.setVisibility(0);
            n(qk0Var, rk0VarG, isWorkspaceLocked());
        }
        s();
    }

    public void completeTwoStageWidgetDrop(int i, int i2) {
        s sVar;
        AppWidgetHostView appWidgetHostView;
        int i3;
        CellLayout cellLayoutH0 = this.mWorkspace.H0(this.mPendingAddInfo.j);
        if (cellLayoutH0 != null && i == -1) {
            lk0 lk0Var = this.mAppWidgetHost;
            rk0 rk0Var = this.mPendingAddWidgetInfo;
            lk0Var.getClass();
            rk0Var.getClass();
            AppWidgetHostView appWidgetHostViewCreateView = lk0Var.createView(this, i2, rk0Var);
            appWidgetHostView = appWidgetHostViewCreateView;
            sVar = new s(i2, i, appWidgetHostViewCreateView, this);
            i3 = 3;
        } else if (cellLayoutH0 == null || i == 0) {
            this.mAppWidgetHost.deleteAppWidgetId(i2);
            sVar = null;
            appWidgetHostView = null;
            i3 = 4;
        } else {
            sVar = null;
            appWidgetHostView = null;
            i3 = 0;
        }
        if (cellLayoutH0 != null && this.mDragLayer.getAnimatedView() != null) {
            this.mWorkspace.l0(this.mPendingAddInfo, cellLayoutH0, (zw) this.mDragLayer.getAnimatedView(), sVar, i3, appWidgetHostView);
        } else if (sVar != null) {
            sVar.run();
        }
    }

    public qh0 createAppDragInfo(Intent intent) {
        UserHandle userHandle;
        Objects.toString(intent);
        return createAppDragInfo(intent, (!ar1.m || (userHandle = (UserHandle) intent.getParcelableExtra("android.intent.extra.USER")) == null) ? null : jq1.a(userHandle));
    }

    public FastBitmapDrawable createIconDrawable(Bitmap bitmap) {
        Objects.toString(bitmap);
        FastBitmapDrawable fastBitmapDrawable = new FastBitmapDrawable(this, bitmap);
        fastBitmapDrawable.setFilterBitmap(DEBUG_WIDGETS);
        resizeIconDrawable(fastBitmapDrawable);
        return fastBitmapDrawable;
    }

    public View createShortcut(og1 og1Var) {
        Objects.toString(og1Var);
        Workspace workspace = this.mWorkspace;
        return createShortcut((ViewGroup) workspace.getChildAt(workspace.getCurrentPage()), og1Var);
    }

    public qh0 createShortcutDragInfo(Intent intent, CharSequence charSequence, Bitmap bitmap) {
        Objects.toString(intent);
        Objects.toString(charSequence);
        Objects.toString(bitmap);
        jq1 jq1VarB = jq1.b();
        og1 og1Var = new og1();
        og1Var.x = intent;
        og1Var.u = ar1.B(charSequence);
        og1Var.v = charSequence;
        og1Var.C = bitmap;
        og1Var.w = jq1VarB;
        return og1Var;
    }

    public void dismissIntroScreen() {
        SharedPreferences.Editor editorEdit = this.mSharedPrefs.edit();
        editorEdit.putBoolean(INTRO_SCREEN_DISMISSED, DEBUG_WIDGETS);
        editorEdit.apply();
        if (showFirstRunActivity()) {
            this.mWorkspace.postDelayed(new m(this, 5), 1000L);
        } else {
            this.mDragLayer.dismissOverlayView();
            showFirstRunClings();
        }
        changeWallpaperVisiblity(DEBUG_WIDGETS);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Objects.toString(keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 3) {
                if (keyCode == 25) {
                    Rect rect = ar1.a;
                    if (Log.isLoggable(DUMP_STATE_PROPERTY, 2)) {
                        dumpState();
                    }
                }
            }
            return DEBUG_WIDGETS;
        }
        if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 3) {
            return DEBUG_WIDGETS;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Objects.toString(accessibilityEvent);
        boolean zDispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        List<CharSequence> text = accessibilityEvent.getText();
        text.clear();
        ak0 ak0Var = this.mState;
        if (ak0Var == ak0.i) {
            text.add(getString(w61.all_apps_button_label));
            return zDispatchPopulateAccessibilityEvent;
        }
        if (ak0Var == ak0.k) {
            text.add(getString(w61.widget_button_text));
            return zDispatchPopulateAccessibilityEvent;
        }
        Workspace workspace = this.mWorkspace;
        if (workspace != null) {
            text.add(workspace.getCurrentPageDescription());
            return zDispatchPopulateAccessibilityEvent;
        }
        text.add(getString(w61.all_apps_home_button_label));
        return zDispatchPopulateAccessibilityEvent;
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Objects.toString(fileDescriptor);
        Objects.toString(printWriter);
        super.dump(str, fileDescriptor, printWriter, strArr);
        synchronized (sDumpLogs) {
            try {
                printWriter.println(" ");
                printWriter.println("Debug logs: ");
                int i = 0;
                while (true) {
                    ArrayList<String> arrayList = sDumpLogs;
                    if (i >= arrayList.size()) {
                        break;
                    }
                    printWriter.println("  " + arrayList.get(i));
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
    }

    public void dumpState() {
        toString();
        Objects.toString(this.mSavedState);
        sFolders.size();
        rl0 rl0Var = this.mModel;
        Objects.toString(rl0Var.q);
        v6.f((ArrayList) rl0Var.r.g);
        v6.f((ArrayList) rl0Var.r.h);
        v6.f((ArrayList) rl0Var.r.i);
        v6.f((ArrayList) rl0Var.r.j);
        u uVar = rl0Var.k;
        if (uVar != null) {
            synchronized (rl0.A) {
                Objects.toString(uVar.g);
                rl0.C.size();
            }
        }
    }

    public void enterSpringLoadedDragMode() {
        ak0 ak0Var;
        ak0 ak0Var2;
        this.mState.name();
        ak0 ak0Var3 = this.mState;
        if (ak0Var3 == ak0.h || ak0Var3 == (ak0Var = ak0.j) || ak0Var3 == (ak0Var2 = ak0.l)) {
            return;
        }
        this.mStateTransitionAnimation.b(ak0Var3, this.mWorkspace.getState(), d02.j, null);
        if (!isAppsViewVisible()) {
            ak0Var = ak0Var2;
        }
        this.mState = ak0Var;
    }

    public void exitSpringLoadedDragMode() {
        ak0 ak0Var = this.mState;
        if (ak0Var == ak0.j) {
            showAppsView(DEBUG_WIDGETS, false, false, false);
        } else if (ak0Var == ak0.l) {
            showWidgetsView(DEBUG_WIDGETS, false);
        }
    }

    public void exitSpringLoadedDragModeDelayed(boolean z, int i, Runnable runnable) {
        Objects.toString(runnable);
        ak0 ak0Var = this.mState;
        if (ak0Var == ak0.j || ak0Var == ak0.l) {
            this.mHandler.postDelayed(new p(this, z, runnable), i);
        }
    }

    @Override // defpackage.hl0
    public void finishBindingItems() {
        ArrayList arrayList;
        if (y(new oj0(this, 2))) {
            return;
        }
        if (this.mSavedState != null) {
            if (!this.mWorkspace.hasFocus()) {
                this.mWorkspace.getCurrentPage();
                Workspace workspace = this.mWorkspace;
                workspace.getChildAt(workspace.getCurrentPage()).requestFocus();
            }
            this.mSavedState = null;
        }
        Workspace workspace2 = this.mWorkspace;
        int childCount = workspace2.getChildCount();
        int i = 0;
        while (true) {
            arrayList = workspace2.C1;
            if (i >= childCount) {
                break;
            }
            if (!arrayList.contains(Integer.valueOf(i))) {
                workspace2.a1(i);
            }
            i++;
        }
        arrayList.clear();
        workspace2.B1 = null;
        boolean zIsWorkspaceLocked = isWorkspaceLocked();
        this.mWorkspaceLoading = false;
        if (zIsWorkspaceLocked != isWorkspaceLocked()) {
            onWorkspaceLockedChanged();
        }
        if (!this.mSharedPrefs.getBoolean(FIRST_LOAD_COMPLETE, false)) {
            sendBroadcast(new Intent(ACTION_FIRST_LOAD_COMPLETE), getResources().getString(w61.receive_first_load_broadcast_permission));
            SharedPreferences.Editor editorEdit = this.mSharedPrefs.edit();
            editorEdit.putBoolean(FIRST_LOAD_COMPLETE, DEBUG_WIDGETS);
            editorEdit.apply();
        }
        zj0 zj0Var = sPendingAddItem;
        if (zj0Var != null) {
            this.mWorkspace.post(new r(this, o(zj0Var)));
            sPendingAddItem = null;
        }
        if (ar1.p) {
            NotificationListener.j = this.mNotificationChangedListener;
        }
        InstallShortcutReceiver.b = false;
        InstallShortcutReceiver.c(this);
    }

    public lk0 getAppWidgetHost() {
        return this.mAppWidgetHost;
    }

    public BlurScreenLayout getBlurBackground() {
        return this.mBlurBackgroundView;
    }

    public Bitmap getBlurGlassWallpaper() {
        fd blurWallpaperProvider = getBlurWallpaperProvider();
        Bitmap bitmap = blurWallpaperProvider.f;
        if (bitmap == null) {
            bitmap = blurWallpaperProvider.e;
        }
        if (bitmap == null) {
            return getBlurWallpaperProvider().g;
        }
        bitmap.toString();
        return bitmap;
    }

    public fd getBlurWallpaperProvider() {
        return this.mBlurWallpaperProvider;
    }

    public CellLayout getCellLayout(long j, long j2) {
        if (j != -101) {
            return this.mWorkspace.H0(j2);
        }
        Hotseat hotseat = this.mHotseat;
        if (hotseat != null) {
            return hotseat.getLayout();
        }
        return null;
    }

    @Override // defpackage.hl0
    public int getCurrentWorkspaceScreen() {
        Workspace workspace = this.mWorkspace;
        if (workspace != null) {
            return workspace.getCurrentPage();
        }
        return 2;
    }

    public xu getDeviceProfile() {
        return this.mDeviceProfile;
    }

    public mw getDragController() {
        return this.mDragController;
    }

    public DragLayer getDragLayer() {
        return this.mDragLayer;
    }

    public my getEditMenu() {
        return this.mEditMenu;
    }

    public Intent getFirstRunActivity() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
        return null;
    }

    public z30 getFloatingMenu() {
        return this.mFloatingMenu;
    }

    public View.OnTouchListener getHapticFeedbackTouchListener() {
        if (this.mHapticFeedbackTouchListener == null) {
            this.mHapticFeedbackTouchListener = new pb(1);
        }
        return this.mHapticFeedbackTouchListener;
    }

    public Hotseat getHotseat() {
        return this.mHotseat;
    }

    public oe0 getIconCache() {
        return this.mIconCache;
    }

    public LayoutInflater getInflater() {
        return this.mInflater;
    }

    public View getIntroScreen() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
        return null;
    }

    public yk0 getLauncherCallbacks() {
        return this.mLauncherCallbacks;
    }

    public LauncherRootView getLauncherView() {
        return this.mLauncherView;
    }

    public rl0 getModel() {
        return this.mModel;
    }

    public ViewGroup getOverviewPanel() {
        return this.mOverviewPanel;
    }

    public Rect getSearchBarBounds() {
        xu xuVar = this.mDeviceProfile;
        ar1.v(getResources());
        return xuVar.c();
    }

    public int getSearchBarHeight() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
        return 0;
    }

    public SearchViewLayout getSearchView() {
        return this.mSearchView;
    }

    public SharedPreferences getSharedPrefs() {
        return this.mSharedPrefs;
    }

    public zl0 getStateTransitionAnimation() {
        return this.mStateTransitionAnimation;
    }

    public kj1 getStats() {
        return this.mStats;
    }

    public bo1 getTinyDB() {
        return this.mTinyDB;
    }

    public int getTopOffsetForCustomContent() {
        return this.mWorkspace.getPaddingTop();
    }

    public int getViewIdForItem(qh0 qh0Var) {
        Objects.toString(qh0Var);
        return (int) qh0Var.g;
    }

    public View getWidgetsButton() {
        return this.mWidgetsButton;
    }

    public WidgetsContainerView getWidgetsView() {
        return this.mWidgetsView;
    }

    public Workspace getWorkspace() {
        return this.mWorkspace;
    }

    public boolean hasCustomContentToLeft() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var == null) {
            return false;
        }
        yk0Var.getClass();
        return DEBUG_WIDGETS;
    }

    public boolean hasDismissableIntroScreen() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
        return false;
    }

    public boolean hasFirstRunActivity() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
        return false;
    }

    public boolean hasRunFirstRunActivity() {
        return this.mSharedPrefs.getBoolean(FIRST_RUN_ACTIVITY_DISPLAYED, false);
    }

    public boolean hasSettings() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var == null) {
            return getResources().getBoolean(t41.allow_rotation) ^ DEBUG_WIDGETS;
        }
        yk0Var.getClass();
        return DEBUG_WIDGETS;
    }

    public void hideAppsLibrary() {
        if (this.appsLibraryLayout != null) {
            ObjectAnimator objectAnimatorD = ik0.d(this.appsLibraryLayout, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f), PropertyValuesHolder.ofFloat(Key.SCALE_X, 0.9f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 0.9f));
            objectAnimatorD.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
            objectAnimatorD.addListener(new be(this, 11));
            objectAnimatorD.setDuration(268L);
            this.appsLibraryLayout.setLayerType(2, null);
            objectAnimatorD.start();
        }
    }

    public void hideWorkspaceSearchAndHotseat() {
        Workspace workspace = this.mWorkspace;
        if (workspace != null) {
            workspace.setAlpha(0.0f);
        }
        Hotseat hotseat = this.mHotseat;
        if (hotseat != null) {
            hotseat.setAlpha(0.0f);
        }
        View view = this.mPageIndicators;
        if (view != null) {
            view.setAlpha(0.0f);
        }
    }

    public void invalidateHasCustomContentToLeft() {
        Workspace workspace = this.mWorkspace;
        if (workspace == null || workspace.getScreenOrder().isEmpty()) {
            return;
        }
        if (!this.mWorkspace.I0() && hasCustomContentToLeft()) {
            this.mWorkspace.r0(0);
            populateCustomContentContainer();
        } else {
            if (!this.mWorkspace.I0() || hasCustomContentToLeft()) {
                return;
            }
            this.mWorkspace.V0(0);
        }
    }

    @Override // defpackage.hl0
    public boolean isAllAppsButtonRank(int i) {
        Hotseat hotseat = this.mHotseat;
        if (hotseat == null || this.mDeviceProfile.a.b || i != hotseat.m) {
            return false;
        }
        return DEBUG_WIDGETS;
    }

    public boolean isAllAppsVisible() {
        return isAppsViewVisible();
    }

    public boolean isAppsViewVisible() {
        ak0 ak0Var = this.mState;
        ak0 ak0Var2 = ak0.i;
        if (ak0Var == ak0Var2 || this.mOnResumeState == ak0Var2) {
            return DEBUG_WIDGETS;
        }
        return false;
    }

    public boolean isDraggingEnabled() {
        return isWorkspaceLoading() ^ DEBUG_WIDGETS;
    }

    public boolean isHotseatLayout(View view) {
        Objects.toString(view);
        Hotseat hotseat = this.mHotseat;
        if (hotseat == null || view == null || !(view instanceof CellLayout) || view != hotseat.getLayout()) {
            return false;
        }
        return DEBUG_WIDGETS;
    }

    public boolean isLauncherPreinstalled() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
            return false;
        }
        try {
            if ((getPackageManager().getApplicationInfo(getComponentName().getPackageName(), 0).flags & 1) != 0) {
                return DEBUG_WIDGETS;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isOnCustomContent() {
        if (this.mWorkspace.M0() || this.mHotseat.getTranslationX() != 0.0f) {
            return DEBUG_WIDGETS;
        }
        return false;
    }

    public boolean isOpeningAppsLibrary() {
        Workspace workspace = this.mWorkspace;
        if (workspace == null || !workspace.M0()) {
            return false;
        }
        return DEBUG_WIDGETS;
    }

    public boolean isOpeningEditMenu() {
        DragLayer dragLayer = this.mDragLayer;
        if (dragLayer == null || !dragLayer.isOpenEditMenu()) {
            return false;
        }
        return DEBUG_WIDGETS;
    }

    public boolean isOpeningFloatingMenu() {
        DragLayer dragLayer = this.mDragLayer;
        if (dragLayer == null || !dragLayer.isOpenFloatingMenu()) {
            return false;
        }
        return DEBUG_WIDGETS;
    }

    public boolean isOpeningFolder() {
        Workspace workspace = this.mWorkspace;
        if ((workspace != null ? workspace.getOpenFolder() : null) != null) {
            return DEBUG_WIDGETS;
        }
        return false;
    }

    public boolean isOpeningLeftPage() {
        Workspace workspace = this.mWorkspace;
        if (workspace == null || !workspace.M0()) {
            return false;
        }
        return DEBUG_WIDGETS;
    }

    public boolean isOpeningSearchView() {
        SearchViewLayout searchViewLayout = this.mSearchView;
        if (searchViewLayout == null) {
            return false;
        }
        if (searchViewLayout.y() || this.mSearchView.x()) {
            return DEBUG_WIDGETS;
        }
        return false;
    }

    public boolean isShaking() {
        return this.mIsShaking;
    }

    public boolean isWidgetsViewVisible() {
        ak0 ak0Var = this.mState;
        ak0 ak0Var2 = ak0.k;
        if (ak0Var == ak0Var2 || this.mOnResumeState == ak0Var2 || this.mWidgetsView.getVisibility() == 0) {
            return DEBUG_WIDGETS;
        }
        return false;
    }

    public boolean isWorkspaceLoading() {
        return this.mWorkspaceLoading;
    }

    public boolean isWorkspaceLocked() {
        if (this.mWorkspaceLoading || this.mWaitingForResult) {
            return DEBUG_WIDGETS;
        }
        return false;
    }

    public boolean launcherCallbacksProvidesSearch() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var == null) {
            return false;
        }
        yk0Var.getClass();
        return false;
    }

    public void lockAllApps() {
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void lockScreenOrientation() {
        /*
            r7 = this;
            boolean r0 = r7.mRotationEnabled
            if (r0 == 0) goto L4d
            boolean r0 = defpackage.ar1.p
            if (r0 == 0) goto Le
            r0 = 14
            r7.setRequestedOrientation(r0)
            return
        Le:
            android.content.res.Resources r0 = r7.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.orientation
            android.view.WindowManager r1 = r7.getWindowManager()
            android.view.Display r1 = r1.getDefaultDisplay()
            int r2 = r1.getRotation()
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L34
            if (r2 == r3) goto L31
            if (r2 == r4) goto L34
            r5 = 3
            if (r2 == r5) goto L31
        L2f:
            r0 = 2
            goto L34
        L31:
            if (r0 != r4) goto L2f
            r0 = 1
        L34:
            r2 = 0
            r5 = 9
            r6 = 8
            int[] r5 = new int[]{r3, r2, r5, r6}
            if (r0 != r4) goto L40
            goto L41
        L40:
            r3 = 0
        L41:
            int r0 = r1.getRotation()
            int r0 = r0 + r3
            int r0 = r0 % 4
            r0 = r5[r0]
            r7.setRequestedOrientation(r0)
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.t.lockScreenOrientation():void");
    }

    public void moveToCustomContentScreen(boolean z) {
        closeFolder();
        Workspace workspace = this.mWorkspace;
        if (workspace.I0()) {
            int iE0 = workspace.E0(-301L);
            if (z) {
                workspace.Z(iE0);
            } else {
                workspace.setCurrentPage(iE0);
            }
            View childAt = workspace.getChildAt(iE0);
            if (childAt != null) {
                childAt.requestFocus();
            }
        }
        workspace.S0.getDragLayer().clearAllResizeFrames();
    }

    public void moveWorkspaceToDefaultScreen() {
        this.mWorkspace.post(new c(this, 1));
    }

    public final void n(qk0 qk0Var, rk0 rk0Var, boolean z) {
        int i;
        qk0Var.C.setTag(qk0Var);
        if (!qk0Var.B) {
            r7.d(qk0Var.m, qk0Var.n, qk0Var.C, this);
            qk0Var.B = DEBUG_WIDGETS;
        }
        qk0Var.C.setFocusable(DEBUG_WIDGETS);
        qk0Var.C.setOnFocusChangeListener(this.mFocusHandler);
        Workspace workspace = this.mWorkspace;
        AppWidgetHostView appWidgetHostView = qk0Var.C;
        long j = qk0Var.i;
        long j2 = qk0Var.j;
        int i2 = qk0Var.k;
        int i3 = qk0Var.l;
        int i4 = qk0Var.m;
        int i5 = qk0Var.n;
        workspace.getClass();
        Objects.toString(appWidgetHostView);
        workspace.j0(appWidgetHostView, j, j2, i2, i3, i4, i5, z, false);
        if (qk0Var.x == -100) {
            return;
        }
        AppWidgetHostView appWidgetHostView2 = qk0Var.C;
        if (rk0Var == null || (i = ((AppWidgetProviderInfo) rk0Var).autoAdvanceViewId) == -1) {
            return;
        }
        KeyEvent.Callback callbackFindViewById = appWidgetHostView2.findViewById(i);
        if (callbackFindViewById instanceof Advanceable) {
            this.mWidgetsToAdvance.put(appWidgetHostView2, rk0Var);
            ((Advanceable) callbackFindViewById).fyiWillBeAdvancedByHostKThx();
            updateAutoAdvanceState();
        }
    }

    @Override // defpackage.hl0
    public void notifyWidgetProvidersChanged() {
        Workspace workspace = this.mWorkspace;
        if (workspace == null || !workspace.getState().g) {
            return;
        }
        rl0 rl0Var = this.mModel;
        boolean z = this.mWidgetsView.U.c() == 0 ? DEBUG_WIDGETS : false;
        rl0Var.getClass();
        rl0.y(new dl0(rl0Var, z, this));
    }

    public final long o(zj0 zj0Var) {
        ComponentName componentName;
        boolean zO;
        Objects.toString(zj0Var);
        long jQ0 = zj0Var.d;
        if (zj0Var.c == -100 && this.mWorkspace.H0(jQ0) == null) {
            this.mWorkspace.i0();
            jQ0 = this.mWorkspace.q0();
        }
        long j = jQ0;
        int i = zj0Var.a;
        if (i == 1) {
            Intent intent = zj0Var.b;
            long j2 = zj0Var.c;
            int i2 = zj0Var.e;
            int i3 = zj0Var.f;
            Objects.toString(intent);
            int[] iArr = this.mTmpAddItemCellCoordinates;
            this.mPendingAddInfo.getClass();
            CellLayout cellLayout = getCellLayout(j2, j);
            gg0 gg0VarA = InstallShortcutReceiver.a(this, intent);
            og1 og1VarB = gg0VarA == null ? null : gg0VarA.b();
            if (og1VarB != null && (componentName = this.mPendingAddInfo.x) != null) {
                if (az1.u(this, og1VarB.x, componentName.getPackageName())) {
                    View viewCreateShortcut = createShortcut(og1VarB);
                    boolean z = getWorkspace().getCurrentCellLayout().I.b(i2, i3) == null ? DEBUG_WIDGETS : false;
                    if (i2 < 0 || i3 < 0 || !z) {
                        zO = cellLayout.o(iArr, 1, 1);
                    } else {
                        iArr[0] = i2;
                        iArr[1] = i3;
                        if (!this.mWorkspace.t0(viewCreateShortcut, j2, cellLayout, iArr, 0.0f, DEBUG_WIDGETS, null, null)) {
                            nx nxVar = new nx();
                            nxVar.g = og1VarB;
                            boolean zK0 = this.mWorkspace.k0(viewCreateShortcut, cellLayout, iArr, 0.0f, nxVar, DEBUG_WIDGETS);
                            cellLayout = cellLayout;
                            iArr = iArr;
                            if (!zK0) {
                                zO = DEBUG_WIDGETS;
                            }
                        }
                    }
                    if (zO) {
                        rl0.b(this, og1VarB, j2, j, iArr[0], iArr[1]);
                        if (!this.mRestoring) {
                            Workspace workspace = this.mWorkspace;
                            int i4 = iArr[0];
                            int i5 = iArr[1];
                            boolean zIsWorkspaceLocked = isWorkspaceLocked();
                            workspace.getClass();
                            Objects.toString(viewCreateShortcut);
                            workspace.j0(viewCreateShortcut, j2, j, i4, i5, 1, 1, zIsWorkspaceLocked, false);
                            j = j;
                        }
                    } else {
                        showOutOfSpaceMessage(isHotseatLayout(cellLayout));
                    }
                } else {
                    og1VarB.x.toUri(0);
                }
            }
        } else if (i == 5) {
            completeAddAppWidget(zj0Var.g, zj0Var.c, j, null, null);
        } else if (i == 12) {
            int i6 = zj0Var.g;
            Workspace workspace2 = this.mWorkspace;
            workspace2.getClass();
            pk0 pk0Var = (pk0) workspace2.B0(new cx(i6));
            if (pk0Var != null && (pk0Var instanceof x11)) {
                qk0 qk0Var = (qk0) pk0Var.getTag();
                qk0Var.z = 0;
                this.mWorkspace.T0();
                rl0.E(this, qk0Var);
            }
        }
        s();
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x013c  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r16, int r17, android.content.Intent r18) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.t.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // defpackage.hl0
    public void onAllAppsChanged(ArrayList<v6> arrayList) {
        this.mSearchView.z(arrayList);
    }

    @Override // defpackage.tl0
    public void onAppWidgetHostReset() {
        lk0 lk0Var = this.mAppWidgetHost;
        if (lk0Var != null) {
            lk0Var.startListening();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_SET_BACKGROUND");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_HIDDEN_APPS_IN_WORKSPACE");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_RELOAD_WIDGET");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_FORCE_RELOAD_LAUNCHER");
        intentFilter.addAction("com.luutinhit.SCREEN_UNLOCK");
        if (ar1.j) {
            registerReceiver(this.mReceiver, intentFilter, 2);
        } else {
            registerReceiver(this.mReceiver, intentFilter);
        }
        View decorView = getWindow().getDecorView();
        if (b30.l != null) {
            decorView.getViewTreeObserver().removeOnDrawListener(b30.l);
        }
        a30 a30Var = new a30();
        System.currentTimeMillis();
        b30.l = a30Var;
        decorView.getViewTreeObserver().addOnDrawListener(b30.l);
        b30.n = DEBUG_WIDGETS;
        this.mAttached = DEBUG_WIDGETS;
        this.mVisible = DEBUG_WIDGETS;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        l8 l8Var;
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null && (l8Var = ((com.luutinhit.launcher6.ioslauncher.a) yk0Var).a.appsLibraryLayout) != null) {
            l8Var.l();
        }
        mw mwVar = this.mDragController;
        if (mwVar.f) {
            mwVar.a();
            return;
        }
        if (this.mBlurBackgroundView.getBackground() != null) {
            this.mBlurBackgroundView.d(false);
        }
        if (this.mFloatingBackgroundView.getBackground() != null) {
            this.mFloatingBackgroundView.d(DEBUG_WIDGETS);
        }
        SearchViewLayout searchViewLayout = this.mSearchView;
        if (searchViewLayout != null && searchViewLayout.x()) {
            this.mSearchView.n();
        }
        if (isOpeningFloatingMenu()) {
            closeFloatingMenu();
        }
        if (isOpeningEditMenu()) {
            closeEditMenu();
        }
        if (isAppsViewVisible()) {
            showWorkspace(DEBUG_WIDGETS);
            return;
        }
        if (isWidgetsViewVisible()) {
            closeWidgetViewWithAnimation();
            return;
        }
        if (isOpeningEditMenu()) {
            closeEditMenu();
            return;
        }
        if (this.mWorkspace.L0()) {
            showWorkspace(DEBUG_WIDGETS);
            return;
        }
        if (this.mWorkspace.getOpenFolder() != null) {
            Folder openFolder = this.mWorkspace.getOpenFolder();
            if (openFolder.P) {
                openFolder.B();
                return;
            } else {
                closeFolder();
                return;
            }
        }
        this.mWorkspace.S0.getDragLayer().clearAllResizeFrames();
        Workspace workspace = this.mWorkspace;
        if (!workspace.U && workspace.K == 0) {
            workspace.Z(workspace.o);
        }
        cancelShakingAnimation();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Objects.toString(view);
        Objects.toString(view);
        if (view != null) {
            Object tag = view.getTag();
            Objects.toString(tag);
            if (tag == null && this.mIsShaking) {
                cancelShakingAnimation();
                return;
            }
            if (tag == null && this.mWorkspace.L0()) {
                showWorkspace(DEBUG_WIDGETS);
                return;
            }
            if (tag != null) {
                if (this.mIsShaking && (((z = tag instanceof og1)) || (tag instanceof v6))) {
                    view.clearAnimation();
                    Pair<ComponentName, Integer> appInfoFlags = getAppInfoFlags(tag);
                    if (appInfoFlags == null && z) {
                        og1 og1Var = (og1) tag;
                        if (og1Var.h == 1) {
                            removeItem(view, og1Var, DEBUG_WIDGETS);
                            return;
                        }
                        return;
                    }
                    if (appInfoFlags != null) {
                        if ((((Integer) appInfoFlags.second).intValue() & 1) == 0) {
                            showDeleteOrUninstallDialog(DEBUG_WIDGETS, tag, appInfoFlags);
                            return;
                        }
                        if (z) {
                            startApplicationUninstallActivity((ComponentName) appInfoFlags.first, ((Integer) appInfoFlags.second).intValue(), ((og1) tag).w);
                            return;
                        } else if (tag instanceof v6) {
                            startApplicationUninstallActivity((ComponentName) appInfoFlags.first, ((Integer) appInfoFlags.second).intValue(), ((v6) tag).w);
                            return;
                        } else {
                            q((qk0) tag);
                            return;
                        }
                    }
                    return;
                }
                if (view.getWindowToken() == null) {
                    return;
                }
                this.mWorkspace.getClass();
                if (view instanceof Workspace) {
                    if (this.mWorkspace.L0()) {
                        showWorkspace(DEBUG_WIDGETS);
                        return;
                    }
                    return;
                }
                if ((view instanceof CellLayout) && this.mWorkspace.L0()) {
                    showWorkspace(this.mWorkspace.indexOfChild(view), DEBUG_WIDGETS);
                }
                if (tag instanceof og1) {
                    onClickAppShortcut(view);
                    return;
                }
                if (tag instanceof w40) {
                    if (view instanceof FolderIcon) {
                        onClickFolderIcon(view);
                    }
                } else if (tag instanceof v6) {
                    startAppShortcutOrInfoActivity(view);
                } else if ((tag instanceof qk0) && (view instanceof x11)) {
                    onClickPendingWidget((x11) view);
                }
            }
        }
    }

    public void onClickAddWidgetButton(View view) {
        openEditMenu(view);
    }

    public void onClickAllAppsButton(View view) {
        Objects.toString(view);
        if (isAppsViewVisible()) {
            return;
        }
        showAppsView(DEBUG_WIDGETS, false, DEBUG_WIDGETS, false);
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
    }

    public void onClickAppShortcut(View view) {
        Objects.toString(view);
        Object tag = view.getTag();
        if (!(tag instanceof og1)) {
            throw new IllegalArgumentException("Input must be a Shortcut");
        }
        og1 og1Var = (og1) tag;
        int i = og1Var.D;
        if (i != 0 && (i & 4) == 0 && (i & 8) == 0) {
            int i2 = w61.activity_not_available;
            if ((i & 1) != 0) {
                i2 = w61.safemode_shortcut_error;
            }
            Toast.makeText(this, i2, 0).show();
            return;
        }
        if ((view instanceof BubbleTextView) && og1Var.h(3) && !og1Var.h(4)) {
            v(og1Var.g().getPackageName(), new rj0(this, view));
        } else {
            startAppShortcutOrInfoActivity(view);
        }
    }

    public void onClickFolderIcon(View view) {
        Objects.toString(view);
        if ((view instanceof FolderIcon) && getWorkspace().getTranslationY() == 0.0f) {
            if (this.mIsShaking) {
                view.clearAnimation();
            }
            FolderIcon folderIcon = (FolderIcon) view;
            w40 folderInfo = folderIcon.getFolderInfo();
            Workspace workspace = this.mWorkspace;
            workspace.getClass();
            Objects.toString(folderInfo);
            Folder folder = (Folder) workspace.B0(new xz1(folderInfo));
            int i = 0;
            if (folderInfo.y && folder == null) {
                folderInfo.y = false;
            }
            if (!folderInfo.y && !folderIcon.getFolder().Q) {
                closeFolder();
                openFolder(folderIcon);
                return;
            }
            if (folder != null) {
                Workspace workspace2 = this.mWorkspace;
                workspace2.getClass();
                ViewParent parent = folder.getParent();
                int childCount = workspace2.getChildCount();
                while (true) {
                    if (i >= childCount) {
                        i = -1;
                        break;
                    } else if (parent == workspace2.getChildAt(i)) {
                        break;
                    } else {
                        i++;
                    }
                }
                closeFolder(folder, DEBUG_WIDGETS);
                if (i != this.mWorkspace.getCurrentPage()) {
                    closeFolder();
                    openFolder(folderIcon);
                }
            }
        }
    }

    public void onClickPendingWidget(x11 x11Var) {
        if (this.mIsSafeModeEnabled) {
            Toast.makeText(this, w61.safemode_widget_error, 0).show();
            return;
        }
        qk0 qk0Var = (qk0) x11Var.getTag();
        int i = x11Var.F.z;
        if ((i & 2) != 0 || (i & 4) == 0) {
            int i2 = qk0Var.A;
            ComponentName componentName = qk0Var.y;
            if (i2 >= 0) {
                startActivitySafely(x11Var, rl0.m(componentName.getPackageName()), qk0Var);
                return;
            } else {
                String packageName = componentName.getPackageName();
                v(packageName, new qj0(this, x11Var, packageName, qk0Var, 0));
                return;
            }
        }
        int i3 = qk0Var.x;
        rk0 rk0VarG = this.mAppWidgetManager.g(i3);
        if (rk0VarG != null) {
            this.mPendingAddWidgetInfo = rk0VarG;
            this.mPendingAddInfo.a(qk0Var);
            this.mPendingAddWidgetId = i3;
            m7.f(this).l(rk0VarG, qk0Var.x, this, this.mAppWidgetHost, 12);
        }
    }

    public void onClickSettingsButton(View view) {
        Objects.toString(view);
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var == null) {
            startActivity(new Intent(this, (Class<?>) SettingsActivity.class));
            return;
        }
        com.luutinhit.launcher6.ioslauncher.a aVar = (com.luutinhit.launcher6.ioslauncher.a) yk0Var;
        aVar.getClass();
        IOSLauncher iOSLauncher = aVar.a;
        iOSLauncher.startActivity(new Intent(iOSLauncher, (Class<?>) MainActivity.class));
    }

    @Override // defpackage.ly
    public void onCloseEditMenu() {
        this.showingEditMenu = false;
    }

    @Override // defpackage.y30
    public void onCloseFloatingMenu(View view) {
        this.showingFloatingMenu = false;
        if (view instanceof BubbleTextView) {
            ((BubbleTextView) view).w();
        } else if (view instanceof pk0) {
            ((pk0) view).a();
        }
        this.mFloatingBackgroundView.d(DEBUG_WIDGETS);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d9  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r20) {
        /*
            Method dump skipped, instruction units count: 1934
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.t.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        AlertDialog alertDialog;
        super.onDestroy();
        Handler handler = this.mHandler;
        boolean z = DEBUG_WIDGETS;
        handler.removeMessages(1);
        this.mHandler.removeMessages(0);
        this.mWorkspace.removeCallbacks(this.mBuildLayersRunnable);
        jk0 jk0VarA = jk0.a();
        rl0 rl0Var = this.mModel;
        rl0Var.getClass();
        Objects.toString(this);
        WeakReference weakReference = rl0Var.q;
        if (weakReference == null || weakReference.get() != this) {
            z = false;
        }
        if (z) {
            rl0 rl0Var2 = this.mModel;
            synchronized (rl0Var2.i) {
                try {
                    u uVar = rl0Var2.k;
                    if (uVar != null) {
                        uVar.k();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            jk0VarA.d(null);
        }
        try {
            this.mAppWidgetHost.stopListening();
        } catch (NullPointerException unused) {
        }
        this.mIsListening = false;
        this.mAppWidgetHost = null;
        this.mWidgetsToAdvance.clear();
        TextKeyListener.getInstance().release();
        unregisterReceiver(this.mCloseSystemDialogsReceiver);
        this.mDragLayer.clearAllResizeFrames();
        ((ViewGroup) this.mWorkspace.getParent()).removeAllViews();
        this.mWorkspace.U0();
        this.mWorkspace = null;
        this.mDragController = null;
        WeakHashMap weakHashMap = ik0.a;
        WeakHashMap weakHashMap2 = ik0.a;
        for (Animator animator : new HashSet(weakHashMap2.keySet())) {
            if (animator.isRunning()) {
                animator.cancel();
            }
            weakHashMap2.remove(animator);
        }
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            IOSLauncher iOSLauncher = ((com.luutinhit.launcher6.ioslauncher.a) yk0Var).a;
            if (iOSLauncher.mRequestSetDefaultLauncher != null && (alertDialog = iOSLauncher.mRequestSetDefaultLauncher.b) != null && alertDialog.isShowing()) {
                za1 za1Var = iOSLauncher.mRequestSetDefaultLauncher;
                AlertDialog alertDialog2 = za1Var.b;
                if (alertDialog2 != null && alertDialog2.isShowing()) {
                    za1Var.b.dismiss();
                }
                za1Var.b = null;
            }
            if (iOSLauncher.mDialogWarningWallpaper != null && iOSLauncher.mDialogWarningWallpaper.isShowing()) {
                iOSLauncher.mDialogWarningWallpaper.dismiss();
            }
        }
        this.mTinyDB.a.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mVisible = false;
        if (this.mAttached) {
            unregisterReceiver(this.mReceiver);
            this.mAttached = false;
        }
        updateAutoAdvanceState();
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
    }

    public void onDragStarted(View view) {
        Objects.toString(view);
        if (isOnCustomContent()) {
            moveWorkspaceToDefaultScreen();
        }
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
    }

    public void onInteractionBegin() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
    }

    public void onInteractionEnd() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            IOSLauncher iOSLauncher = ((com.luutinhit.launcher6.ioslauncher.a) yk0Var).a;
            if (iOSLauncher.autoRearrange) {
                iOSLauncher.rearrangeApps(DEBUG_WIDGETS);
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        SpannableStringBuilder spannableStringBuilder;
        Objects.toString(keyEvent);
        int unicodeChar = keyEvent.getUnicodeChar();
        boolean zOnKeyDown = super.onKeyDown(i, keyEvent);
        return (zOnKeyDown || ((InputMethodManager) getSystemService("input_method")).isFullscreenMode() || !((unicodeChar <= 0 || Character.isWhitespace(unicodeChar)) ? false : DEBUG_WIDGETS) || !TextKeyListener.getInstance().onKeyDown(this.mWorkspace, this.mDefaultKeySsb, i, keyEvent) || (spannableStringBuilder = this.mDefaultKeySsb) == null || spannableStringBuilder.length() <= 0) ? (i == 82 && keyEvent.isLongPress()) ? DEBUG_WIDGETS : zOnKeyDown : onSearchRequested();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        Objects.toString(keyEvent);
        if (i != 82) {
            return super.onKeyUp(i, keyEvent);
        }
        if (!isOnCustomContent() && !this.mDragController.f) {
            closeFolder();
            this.mWorkspace.S0.getDragLayer().clearAllResizeFrames();
            if (this.mState == ak0.h && !this.mWorkspace.L0()) {
                this.mWorkspace.getClass();
                this.mOverviewPanel.requestFocus();
                showOverviewMode(DEBUG_WIDGETS, DEBUG_WIDGETS);
            }
        }
        return DEBUG_WIDGETS;
    }

    @Override // defpackage.tl0
    public void onLauncherProviderChange() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00d4  */
    @Override // android.view.View.OnLongClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onLongClick(android.view.View r7) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.t.onLongClick(android.view.View):boolean");
    }

    public void onLongClickAllAppsButton(View view) {
        Objects.toString(view);
        if (isAppsViewVisible()) {
            return;
        }
        showAppsView(DEBUG_WIDGETS, false, DEBUG_WIDGETS, DEBUG_WIDGETS);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        l8 l8Var;
        WidgetsContainerView widgetsContainerView;
        Objects.toString(intent);
        super.onNewIntent(intent);
        Folder openFolder = this.mWorkspace.getOpenFolder();
        boolean z = (!this.mHasFocus || (intent.getFlags() & 4194304) == 4194304) ? false : DEBUG_WIDGETS;
        boolean zEquals = "android.intent.action.MAIN".equals(intent.getAction());
        ak0 ak0Var = ak0.h;
        if (zEquals) {
            closeSystemDialogs();
            Workspace workspace = this.mWorkspace;
            if (workspace == null) {
                return;
            }
            workspace.S0.getDragLayer().clearAllResizeFrames();
            closeFolder(z);
            exitSpringLoadedDragMode();
            SearchViewLayout searchViewLayout = this.mSearchView;
            if (searchViewLayout != null && searchViewLayout.x()) {
                this.mSearchView.n();
            }
            if (isOpeningFloatingMenu()) {
                closeFloatingMenu();
            }
            if (isOpeningEditMenu()) {
                closeEditMenu();
            }
            if (z) {
                showWorkspace(DEBUG_WIDGETS);
            } else {
                this.mOnResumeState = ak0Var;
            }
            View viewPeekDecorView = getWindow().peekDecorView();
            if (viewPeekDecorView != null && viewPeekDecorView.getWindowToken() != null) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(viewPeekDecorView.getWindowToken(), 0);
            }
            if (!z && (widgetsContainerView = this.mWidgetsView) != null) {
                widgetsContainerView.T.l0(0);
            }
            yk0 yk0Var = this.mLauncherCallbacks;
            if (yk0Var != null && (l8Var = ((com.luutinhit.launcher6.ioslauncher.a) yk0Var).a.appsLibraryLayout) != null) {
                l8Var.l();
            }
        }
        if (!zEquals || this.mIsShaking) {
            cancelShakingAnimation();
            return;
        }
        if (z && this.mState == ak0Var) {
            Workspace workspace2 = this.mWorkspace;
            if (workspace2.K == 0 && openFolder == null) {
                this.mMoveToDefaultScreenFromNewIntent = DEBUG_WIDGETS;
                workspace2.post(new m(this, 0));
            }
        }
    }

    @Override // defpackage.hl0
    public void onPageBoundSynchronously(int i) {
        this.mSynchronouslyBoundPages.add(Integer.valueOf(i));
    }

    @Override // defpackage.c11
    public void onPageSwitch(View view, int i) {
        Objects.toString(view);
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        InstallShortcutReceiver.b = DEBUG_WIDGETS;
        super.onPause();
        this.mPaused = DEBUG_WIDGETS;
        this.mDragController.a();
        this.mDragController.w = -1L;
        if (this.mWorkspace.getCustomContentCallbacks() != null) {
            this.mWorkspace.getCustomContentCallbacks().l();
        }
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Objects.toString(bundle);
        super.onPostCreate(bundle);
        this.mAppWidgetHost = new lk0(this);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        Objects.toString(menu);
        super.onPrepareOptionsMenu(menu);
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
        return false;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        zj0 zj0Var;
        View viewB;
        if (i == 13 && (zj0Var = sPendingAddItem) != null && zj0Var.a == 13) {
            CellLayout cellLayout = getCellLayout(zj0Var.c, zj0Var.d);
            if (cellLayout != null) {
                zj0 zj0Var2 = sPendingAddItem;
                viewB = cellLayout.I.b(zj0Var2.e, zj0Var2.f);
            } else {
                viewB = null;
            }
            Intent intent = sPendingAddItem.b;
            sPendingAddItem = null;
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, getString(w61.msg_no_phone_permission, getString(w61.app_name)), 0).show();
            } else {
                startActivitySafely(viewB, intent, null);
            }
        }
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Objects.toString(bundle);
        try {
            super.onRestoreInstanceState(bundle);
            ArrayList<Integer> arrayList = this.mSynchronouslyBoundPages;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Integer num = arrayList.get(i);
                i++;
                this.mWorkspace.a1(num.intValue());
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        View.OnClickListener pageIndicatorClickListener;
        int i;
        int i2 = 3;
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            com.luutinhit.launcher6.ioslauncher.a aVar = (com.luutinhit.launcher6.ioslauncher.a) yk0Var;
            if (ar1.f) {
                IOSLauncher iOSLauncher = aVar.a;
                if (iOSLauncher.isOpenCloseAnim) {
                    zl0 stateTransitionAnimation = iOSLauncher.getStateTransitionAnimation();
                    int[] iArr = stateTransitionAnimation.c;
                    try {
                        ObjectAnimator objectAnimator = stateTransitionAnimation.d;
                        if ((objectAnimator == null || (!objectAnimator.isRunning() && !stateTransitionAnimation.d.isStarted())) && stateTransitionAnimation.b != null && (i = iArr[0]) != 0 && iArr[1] != 0) {
                            PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat((Property<?, Float>) View.X, i);
                            PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.Y, iArr[1]);
                            PropertyValuesHolder propertyValuesHolderOfFloat3 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 1.0f);
                            PropertyValuesHolder propertyValuesHolderOfFloat4 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 1.0f);
                            PropertyValuesHolder propertyValuesHolderOfFloat5 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, 0.0f, 1.0f);
                            ObjectAnimator objectAnimator2 = stateTransitionAnimation.d;
                            if (objectAnimator2 == null || !objectAnimator2.isRunning()) {
                                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(stateTransitionAnimation.b, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2, propertyValuesHolderOfFloat3, propertyValuesHolderOfFloat4, propertyValuesHolderOfFloat5);
                                stateTransitionAnimation.d = objectAnimatorOfPropertyValuesHolder;
                                objectAnimatorOfPropertyValuesHolder.setDuration(386L);
                                stateTransitionAnimation.d.setInterpolator(new DecelerateInterpolator(1.5f));
                                stateTransitionAnimation.d.addListener(new be(stateTransitionAnimation, 13));
                            }
                            r00.b().e("CLOSE_ANIM");
                            stateTransitionAnimation.d.start();
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
            }
        }
        super.onResume();
        ak0 ak0Var = this.mOnResumeState;
        if (ak0Var == ak0.h) {
            showWorkspace(false);
        } else if (ak0Var == ak0.i) {
            showAppsView(false, false, (this.mWaitingForResume != null ? DEBUG_WIDGETS : false) ^ DEBUG_WIDGETS, false);
        }
        this.mOnResumeState = ak0.g;
        this.mPaused = false;
        if (this.mRestoring || this.mOnResumeNeedsLoad) {
            boolean zIsWorkspaceLocked = isWorkspaceLocked();
            this.mWorkspaceLoading = DEBUG_WIDGETS;
            if (zIsWorkspaceLocked != isWorkspaceLocked()) {
                onWorkspaceLockedChanged();
            }
            this.mBindOnResumeCallbacks.clear();
            this.mModel.A(-1001, 0);
            this.mRestoring = false;
            this.mOnResumeNeedsLoad = false;
        }
        if (this.mBindOnResumeCallbacks.size() > 0) {
            for (int i3 = 0; i3 < this.mBindOnResumeCallbacks.size(); i3++) {
                this.mBindOnResumeCallbacks.get(i3).run();
            }
            this.mBindOnResumeCallbacks.clear();
        }
        if (this.mOnResumeCallbacks.size() > 0) {
            for (int i4 = 0; i4 < this.mOnResumeCallbacks.size(); i4++) {
                this.mOnResumeCallbacks.get(i4).run();
            }
            this.mOnResumeCallbacks.clear();
        }
        BubbleTextView bubbleTextView = this.mWaitingForResume;
        if (bubbleTextView != null) {
            bubbleTextView.setStayPressed(false);
        }
        if (!isWorkspaceLoading()) {
            getWorkspace().T0();
        }
        if (this.leftPage != null && isOpeningLeftPage()) {
            this.mWorkspace.getCustomContentCallbacks().h(DEBUG_WIDGETS);
        }
        if (this.mWorkspace.getCustomContentCallbacks() != null && !this.mMoveToDefaultScreenFromNewIntent && this.mWorkspace.M0()) {
            this.mWorkspace.getCustomContentCallbacks().h(DEBUG_WIDGETS);
        }
        this.mMoveToDefaultScreenFromNewIntent = false;
        updateInteraction(d02.h, this.mWorkspace.getState());
        Workspace workspace = this.mWorkspace;
        if (workspace.getPageIndicator() != null && (pageIndicatorClickListener = workspace.getPageIndicatorClickListener()) != null) {
            workspace.getPageIndicator().setOnClickListener(pageIndicatorClickListener);
        }
        jk0 jk0VarA = jk0.a();
        boolean z = jk0VarA.d;
        jk0VarA.d = false;
        if (z) {
            new qy(workspace, i2).executeOnExecutor(ar1.q, new Void[0]);
        }
        workspace.u0.getWallpaperInfo();
        if (!isWorkspaceLoading()) {
            InstallShortcutReceiver.b = false;
            InstallShortcutReceiver.c(this);
        }
        yk0 yk0Var2 = this.mLauncherCallbacks;
        if (yk0Var2 != null) {
            ((com.luutinhit.launcher6.ioslauncher.a) yk0Var2).b();
        }
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        rl0 rl0Var = this.mModel;
        rl0Var.getClass();
        Objects.toString(this);
        WeakReference weakReference = rl0Var.q;
        if (weakReference != null && weakReference.get() == this) {
            rl0 rl0Var2 = this.mModel;
            synchronized (rl0Var2.i) {
                try {
                    u uVar = rl0Var2.k;
                    if (uVar != null) {
                        uVar.k();
                    }
                } finally {
                }
            }
        }
        return Boolean.TRUE;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2;
        Objects.toString(bundle);
        if (isWorkspaceLoading() && (bundle2 = this.mSavedState) != null) {
            bundle.putAll(bundle2);
            return;
        }
        if (this.mWorkspace.getChildCount() > 0) {
            bundle.putInt(RUNTIME_STATE_CURRENT_SCREEN, this.mWorkspace.getCurrentPageOffsetFromCustomContent());
        }
        super.onSaveInstanceState(bundle);
        bundle.putInt(RUNTIME_STATE, this.mState.ordinal());
        closeFolder(false);
        u11 u11Var = this.mPendingAddInfo;
        long j = u11Var.i;
        if (j != -1 && u11Var.j > -1 && this.mWaitingForResult) {
            bundle.putLong(RUNTIME_STATE_PENDING_ADD_CONTAINER, j);
            bundle.putLong(RUNTIME_STATE_PENDING_ADD_SCREEN, this.mPendingAddInfo.j);
            bundle.putInt(RUNTIME_STATE_PENDING_ADD_CELL_X, this.mPendingAddInfo.k);
            bundle.putInt(RUNTIME_STATE_PENDING_ADD_CELL_Y, this.mPendingAddInfo.l);
            bundle.putInt(RUNTIME_STATE_PENDING_ADD_SPAN_X, this.mPendingAddInfo.m);
            bundle.putInt(RUNTIME_STATE_PENDING_ADD_SPAN_Y, this.mPendingAddInfo.n);
            bundle.putParcelable(RUNTIME_STATE_PENDING_ADD_COMPONENT, this.mPendingAddInfo.x);
            bundle.putParcelable(RUNTIME_STATE_PENDING_ADD_WIDGET_INFO, this.mPendingAddWidgetInfo);
            bundle.putInt(RUNTIME_STATE_PENDING_ADD_WIDGET_ID, this.mPendingAddWidgetId);
        }
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        startSearch(null, false, null, DEBUG_WIDGETS);
        return DEBUG_WIDGETS;
    }

    @Override // defpackage.we1
    public void onSearchViewAlphaChanged(float f) {
        if (this.mWorkspace != null) {
            this.mWorkspace.setTranslationY(f * this.screenHeight * 0.1f);
        }
    }

    @Override // defpackage.we1
    public void onSearchViewClosed() {
        this.mBlurBackgroundView.d(false);
    }

    @Override // defpackage.we1
    public void onSearchViewOpened() {
    }

    @Override // defpackage.tl0
    public void onSettingsChanged(String str, boolean z) {
        if ("pref_allowRotation".equals(str)) {
            this.mRotationEnabled = z;
            if (waitUntilResume(this.mUpdateOrientationRunnable, DEBUG_WIDGETS)) {
                return;
            }
            this.mUpdateOrientationRunnable.run();
        }
    }

    @Override // defpackage.y30
    public void onShakingAllApps() {
        if (this.mIsShaking) {
            return;
        }
        this.mIsShaking = DEBUG_WIDGETS;
        if (this.mWorkspace != null) {
            if (isOpeningFolder()) {
                this.mWorkspace.getOpenFolder().G();
            }
            int i = 0;
            this.mAddWidgets.setVisibility(0);
            this.mAddWidgetsDone.setVisibility(0);
            ArrayList<ng1> allShortcutAndWidgetContainers = this.mWorkspace.getAllShortcutAndWidgetContainers();
            int size = allShortcutAndWidgetContainers.size();
            while (i < size) {
                ng1 ng1Var = allShortcutAndWidgetContainers.get(i);
                i++;
                ng1Var.k();
            }
            this.mWorkspace.getPageIndicator().b();
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            switch (str) {
                case "unlock_animation":
                    this.isUnlockAnim = sharedPreferences.getBoolean(str, DEBUG_WIDGETS);
                    break;
                case "dark_mode":
                    boolean z = sharedPreferences.getBoolean(str, false);
                    this.isDarkMode = z;
                    this.appsLibraryLayout.setDarkMode(z);
                    this.leftPage.setDarkMode(this.isDarkMode);
                    this.mWidgetsView.setDarkMode(this.isDarkMode);
                    this.mWorkspace.getClass();
                    this.mWidgetsView.setDarkMode(this.isDarkMode);
                    this.mWidgetsAppStyle.setDarkMode(this.isDarkMode);
                    co1 co1Var = this.mTinyDBChange;
                    boolean z2 = this.isDarkMode;
                    Iterator it = co1Var.a.iterator();
                    while (it.hasNext()) {
                        iz0 iz0Var = (iz0) ((WeakReference) it.next()).get();
                        if (iz0Var != null) {
                            iz0Var.a(z2);
                        } else {
                            it.remove();
                        }
                    }
                    break;
                case "app_library_dialog_guide":
                    this.isShowAppsLibraryGuide = sharedPreferences.getBoolean(str, false);
                    break;
                case "open_close_animation":
                    this.isOpenCloseAnim = sharedPreferences.getBoolean(str, DEBUG_WIDGETS);
                    break;
                case "iphone_8_style":
                    this.mHotseat.requestLayout();
                    break;
                case "hide_navigation":
                    this.isHideNavigation = sharedPreferences.getBoolean(str, false);
                    break;
                case "auto_rearrange":
                    boolean z3 = sharedPreferences.getBoolean(str, false);
                    this.autoRearrange = z3;
                    if (z3) {
                        rearrangeApps(DEBUG_WIDGETS);
                        break;
                    }
                    break;
            }
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        lk0 lk0Var;
        super.onStart();
        b30.n = DEBUG_WIDGETS;
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            IOSLauncher iOSLauncher = ((com.luutinhit.launcher6.ioslauncher.a) yk0Var).a;
            if (!iOSLauncher.isMyLauncherDefault() && !iOSLauncher.isFinishing()) {
                iOSLauncher.mRequestSetDefaultLauncher.a();
            }
            iOSLauncher.startPlayOpenAnimation();
        }
        if (!this.mIsListening && (lk0Var = this.mAppWidgetHost) != null) {
            try {
                lk0Var.startListening();
                this.mIsListening = DEBUG_WIDGETS;
            } catch (Throwable unused) {
            }
        }
        if (!ar1.p || isWorkspaceLoading()) {
            return;
        }
        NotificationListener.j = this.mNotificationChangedListener;
    }

    @Override // android.app.Activity
    public void onStop() {
        AlertDialog alertDialog;
        super.onStop();
        b30.n = false;
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            IOSLauncher iOSLauncher = ((com.luutinhit.launcher6.ioslauncher.a) yk0Var).a;
            iOSLauncher.getDragLayer().setScaleX(1.0f);
            iOSLauncher.getDragLayer().setScaleY(1.0f);
            iOSLauncher.prepareOpenAnimation(false);
            if (iOSLauncher.mRequestSetDefaultLauncher != null && (alertDialog = iOSLauncher.mRequestSetDefaultLauncher.b) != null && alertDialog.isShowing()) {
                za1 za1Var = iOSLauncher.mRequestSetDefaultLauncher;
                AlertDialog alertDialog2 = za1Var.b;
                if (alertDialog2 != null && alertDialog2.isShowing()) {
                    za1Var.b.dismiss();
                }
                za1Var.b = null;
            }
            if (iOSLauncher.mDialogWarningWallpaper != null && iOSLauncher.mDialogWarningWallpaper.isShowing()) {
                iOSLauncher.mDialogWarningWallpaper.dismiss();
            }
        }
        SearchViewLayout searchViewLayout = this.mSearchView;
        if (searchViewLayout != null && searchViewLayout.x()) {
            this.mSearchView.n();
        }
        if (isOpeningFloatingMenu()) {
            closeFloatingMenu();
        }
        if (isOpeningEditMenu()) {
            closeEditMenu();
        }
        closeWidgetView(false);
        closeCustomizeColorAppStyle();
        cancelShakingAnimation();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Objects.toString(view);
        Objects.toString(motionEvent);
        return false;
    }

    public void onTouchIcon(BubbleTextView bubbleTextView, MotionEvent motionEvent) {
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if ((action == 1 || action == 3) && !isOpeningFloatingMenu()) {
                bubbleTextView.w();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (i >= 20) {
            SQLiteDatabase.releaseMemory();
        }
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.mHasFocus = z;
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
    }

    public void onWindowVisibilityChanged(int i) {
        this.mVisible = i == 0 ? DEBUG_WIDGETS : false;
        updateAutoAdvanceState();
        if (this.mVisible) {
            if (!this.mWorkspaceLoading) {
                this.mWorkspace.getViewTreeObserver().addOnDrawListener(new k(this));
            }
            SpannableStringBuilder spannableStringBuilder = this.mDefaultKeySsb;
            if (spannableStringBuilder != null) {
                spannableStringBuilder.clear();
                this.mDefaultKeySsb.clearSpans();
                Selection.setSelection(this.mDefaultKeySsb, 0);
            }
        }
    }

    public void onWorkspaceLockedChanged() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            yk0Var.getClass();
        }
    }

    public void openCustomizeColorAppStyle() {
        Objects.toString(this.mCustomizeColorApp);
        this.mCustomizeColorApp.post(new kj0(this, 2));
    }

    public void openEditMenu(View view) {
        my myVar;
        if (this.mSearchView.x() || (myVar = this.mEditMenu) == null) {
            return;
        }
        this.showingEditMenu = DEBUG_WIDGETS;
        myVar.x.getDragLayer().post(new wc(myVar, view, 5));
    }

    public void openFloatingMenu(View view) {
        z30 z30Var;
        if (this.mSearchView.x() || (z30Var = this.mFloatingMenu) == null) {
            return;
        }
        this.showingFloatingMenu = DEBUG_WIDGETS;
        if (view instanceof BubbleTextView) {
            z30Var.x.getDragLayer().post(new w1(z30Var, (BubbleTextView) view, 18, false));
            this.mDragLayer.addView(this.mFloatingBackgroundView, new pw(-1, -1));
            this.mDragLayer.postOnAnimation(new wc(this, (BubbleTextView) view, 11));
        } else if (view instanceof pk0) {
            z30Var.x.getDragLayer().post(new w1(z30Var, (pk0) view, 17, false));
            this.mDragLayer.addView(this.mFloatingBackgroundView, new pw(-1, -1));
            this.mDragLayer.postOnAnimation(new wc(this, (pk0) view, 12));
        }
    }

    public void openFolder(FolderIcon folderIcon) {
        String str;
        float f;
        char c;
        char c2;
        k40 k40Var;
        int i;
        int i2 = 3;
        Objects.toString(folderIcon);
        Folder folder = folderIcon.getFolder();
        Workspace workspace = this.mWorkspace;
        Folder openFolder = workspace != null ? workspace.getOpenFolder() : null;
        if (openFolder != null && openFolder != folder) {
            closeFolder();
        }
        folder.p.y = DEBUG_WIDGETS;
        ((zg) folderIcon.getLayoutParams()).j = false;
        if (folder.getParent() == null) {
            this.mDragLayer.addView(folder);
            this.mDragController.l.add(folder);
        } else {
            folder.toString();
            Objects.toString(folder.getParent());
        }
        if (folder.getParent() instanceof DragLayer) {
            folder.r.l0();
            if (folder.J) {
                str = Key.ALPHA;
                f = 0.0f;
            } else {
                str = Key.ALPHA;
                FolderPagedView folderPagedView = folder.r;
                int iH0 = folderPagedView.h0(0);
                f = 0.0f;
                folderPagedView.b0(iH0, folderPagedView.E(iH0) - folderPagedView.getUnboundedScrollX(), 750, DEBUG_WIDGETS, null);
            }
            t tVar = folder.n;
            if (tVar != null && tVar.isShaking()) {
                folder.G();
            }
            folder.K = false;
            if (folder.getParent() instanceof DragLayer) {
                folder.setScaleX(f);
                folder.setScaleY(f);
                folder.setAlpha(f);
                folder.C = 0;
            }
            folder.x();
            c = 0;
            ObjectAnimator objectAnimatorD = ik0.d(folder, PropertyValuesHolder.ofFloat(str, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f));
            objectAnimatorD.setDuration(folder.l);
            folder.b0 = new n40(folder, objectAnimatorD);
            boolean z = ar1.m;
            if (z) {
                c2 = 1;
                objectAnimatorD.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.1f, 1.0f));
            } else {
                c2 = 1;
            }
            if (z) {
                folder.setLayerType(2, null);
                k40Var = new k40(folder, i2);
                i = 4;
            } else {
                folder.s.setLayerType(2, null);
                i = 4;
                k40Var = new k40(folder, i);
            }
            objectAnimatorD.addListener(new um(folder, k40Var, i2));
            if (folder.r.getPageCount() <= 1 || (folder.p.r & i) != 0) {
                folder.y.setTranslationX(f);
                folder.r.setMarkerScale(1.0f);
            } else {
                folder.r.setMarkerScale(f);
                objectAnimatorD.addListener(new zc(folder, folder.J ^ DEBUG_WIDGETS, i2));
            }
            objectAnimatorD.start();
            mw mwVar = folder.o;
            if (mwVar.f) {
                int[] iArr = mwVar.v;
                int i3 = iArr[0];
                int i4 = iArr[c2];
                int[] iArr2 = mwVar.d;
                ox oxVarG = mwVar.g(iArr2, i3, i4);
                nx nxVar = mwVar.k;
                nxVar.a = iArr2[0];
                nxVar.b = iArr2[c2];
                mwVar.c(oxVarG);
            }
            FolderPagedView folderPagedView2 = folder.r;
            folderPagedView2.n0(folderPagedView2.getNextPage());
        } else {
            str = Key.ALPHA;
            f = 0.0f;
            c = 0;
        }
        Objects.toString(folderIcon);
        if (((w40) folderIcon.getTag()).i == -101) {
            CellLayout cellLayout = (CellLayout) folderIcon.getParent().getParent();
            zg zgVar = (zg) folderIcon.getLayoutParams();
            int i5 = zgVar.a;
            int i6 = zgVar.b;
            int[] iArr3 = cellLayout.x;
            iArr3[c] = i5;
            iArr3[1] = i6;
            cellLayout.invalidate();
        }
        p(folderIcon);
        folderIcon.setVisibility(4);
        float[] fArr = new float[1];
        fArr[c] = f;
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, fArr);
        float[] fArr2 = new float[1];
        fArr2[c] = 2.0f;
        PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat(Key.SCALE_X, fArr2);
        float[] fArr3 = new float[1];
        fArr3[c] = 2.0f;
        PropertyValuesHolder propertyValuesHolderOfFloat3 = PropertyValuesHolder.ofFloat(Key.SCALE_Y, fArr3);
        ImageView imageView = this.mFolderIconImageView;
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[c] = propertyValuesHolderOfFloat2;
        propertyValuesHolderArr[1] = propertyValuesHolderOfFloat3;
        ObjectAnimator objectAnimatorD2 = ik0.d(imageView, propertyValuesHolderArr);
        ImageView imageView2 = this.mFolderIconImageView;
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[1];
        propertyValuesHolderArr2[c] = propertyValuesHolderOfFloat;
        ObjectAnimator objectAnimatorD3 = ik0.d(imageView2, propertyValuesHolderArr2);
        if (ar1.m) {
            objectAnimatorD2.setInterpolator(new PathInterpolator(0.755f, 0.05f, 0.855f, 0.06f));
            objectAnimatorD3.setInterpolator(new PathInterpolator(0.26f, 0.55f, 0.46f, 0.86f));
        }
        objectAnimatorD3.setDuration(getResources().getInteger(g61.config_growAndFadeOutFolderIcon));
        objectAnimatorD2.setDuration(getResources().getInteger(g61.config_growAndFadeOutFolderIcon));
        objectAnimatorD3.start();
        objectAnimatorD2.start();
        BlurScreenLayout blurScreenLayout = this.mBlurBackgroundView;
        if (blurScreenLayout != null) {
            try {
                blurScreenLayout.m.obtainMessage(2, null).sendToTarget();
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        folder.sendAccessibilityEvent(32);
        getDragLayer().sendAccessibilityEvent(2048);
    }

    public void openWidgetView(boolean z, boolean z2) {
        if (z2) {
            this.mWidgetsView.T.l0(0);
        }
        ak0 ak0Var = ak0.k;
        ak0 ak0Var2 = this.mState;
        if (ak0Var2 == ak0.h || ak0Var2 == ak0.j || ak0Var2 == ak0.l) {
            getWorkspace().setState(d02.k);
            if (this.mWidgetsView.U.c() <= 0) {
                notifyWidgetProvidersChanged();
            }
            this.mWidgetsView.postOnAnimation(new m(this, 1));
            this.mState = ak0Var;
            this.mUserPresent = false;
            updateAutoAdvanceState();
            closeFolder();
            getWindow().getDecorView().sendAccessibilityEvent(32);
        }
    }

    public boolean overrideWallpaperDimensions() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var == null) {
            return DEBUG_WIDGETS;
        }
        yk0Var.getClass();
        return false;
    }

    public final void p(FolderIcon folderIcon) {
        Objects.toString(folderIcon);
        int measuredWidth = folderIcon.getMeasuredWidth();
        int measuredHeight = folderIcon.getMeasuredHeight();
        if (this.mFolderIconImageView == null) {
            this.mFolderIconImageView = new ImageView(this);
        }
        Bitmap bitmap = this.mFolderIconBitmap;
        if (bitmap == null || bitmap.getWidth() != measuredWidth || this.mFolderIconBitmap.getHeight() != measuredHeight) {
            this.mFolderIconBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            this.mFolderIconCanvas = new Canvas(this.mFolderIconBitmap);
        }
        pw pwVar = this.mFolderIconImageView.getLayoutParams() instanceof pw ? (pw) this.mFolderIconImageView.getLayoutParams() : new pw(measuredWidth, measuredHeight);
        float descendantRectRelativeToSelf = this.mDragLayer.getDescendantRectRelativeToSelf(folderIcon, this.mRectForFolderAnimation);
        pwVar.d = DEBUG_WIDGETS;
        Rect rect = this.mRectForFolderAnimation;
        pwVar.b = rect.left;
        pwVar.c = rect.top;
        ((FrameLayout.LayoutParams) pwVar).width = (int) (measuredWidth * descendantRectRelativeToSelf);
        ((FrameLayout.LayoutParams) pwVar).height = (int) (descendantRectRelativeToSelf * measuredHeight);
        this.mFolderIconCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        folderIcon.draw(this.mFolderIconCanvas);
        this.mFolderIconImageView.setImageBitmap(this.mFolderIconBitmap);
        if (folderIcon.getFolder() != null) {
            this.mFolderIconImageView.setPivotX(folderIcon.getFolder().getPivotXForIconAnimation());
            this.mFolderIconImageView.setPivotY(folderIcon.getFolder().getPivotYForIconAnimation());
        }
        if (this.mDragLayer.indexOfChild(this.mFolderIconImageView) != -1) {
            this.mDragLayer.removeView(this.mFolderIconImageView);
        }
        this.mDragLayer.addView(this.mFolderIconImageView, pwVar);
        if (folderIcon.getFolder() != null) {
            folderIcon.getFolder().bringToFront();
        }
    }

    public void populateCustomContentContainer() {
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            IOSLauncher iOSLauncher = ((com.luutinhit.launcher6.ioslauncher.a) yk0Var).a;
            wq wqVar = new wq(iOSLauncher);
            iOSLauncher.leftPage = wqVar;
            iOSLauncher.addToCustomContentPage(wqVar, wqVar.getCallBack(), "custom_content", 0);
            l8 l8Var = new l8(iOSLauncher);
            iOSLauncher.appsLibraryLayout = l8Var;
            iOSLauncher.addToCustomContentPage(l8Var, l8Var.getCallBack(), "apps_library", 1);
        }
    }

    public final void q(qk0 qk0Var) {
        Objects.toString(qk0Var);
        lk0 appWidgetHost = getAppWidgetHost();
        if (appWidgetHost != null && qk0Var.x != -100 && (qk0Var.z & 1) == 0) {
            new pj0(appWidgetHost, qk0Var).executeOnExecutor(ar1.q, new Void[0]);
        }
        rl0.e(this, qk0Var);
    }

    public void rearrangeApps(boolean z) {
        Workspace workspace = this.mWorkspace;
        if (workspace == null || !workspace.isAttachedToWindow()) {
            return;
        }
        workspace.postOnAnimationDelayed(new p40(workspace, z, 2), 100L);
    }

    public boolean removeItem(View view, qh0 qh0Var, boolean z) {
        Objects.toString(view);
        Objects.toString(qh0Var);
        if (qh0Var instanceof og1) {
            w40 w40Var = (w40) sFolders.get(qh0Var.i);
            if (w40Var != null) {
                w40Var.g((og1) qh0Var);
            } else {
                this.mWorkspace.Z0(view);
            }
            if (!z) {
                return DEBUG_WIDGETS;
            }
            rl0.e(this, qh0Var);
            return DEBUG_WIDGETS;
        }
        if (qh0Var instanceof w40) {
            w40 w40Var2 = (w40) qh0Var;
            Objects.toString(w40Var2);
            sFolders.remove(w40Var2.g);
            this.mWorkspace.Z0(view);
            if (!z) {
                return DEBUG_WIDGETS;
            }
            HandlerThread handlerThread = rl0.w;
            Objects.toString(this);
            Objects.toString(w40Var2);
            rl0.y(new w1(getContentResolver(), w40Var2, 28));
            return DEBUG_WIDGETS;
        }
        if (!(qh0Var instanceof qk0)) {
            return false;
        }
        qk0 qk0Var = (qk0) qh0Var;
        this.mWorkspace.Z0(view);
        AppWidgetHostView appWidgetHostView = qk0Var.C;
        if (this.mWidgetsToAdvance.containsKey(appWidgetHostView)) {
            this.mWidgetsToAdvance.remove(appWidgetHostView);
            updateAutoAdvanceState();
        }
        qk0Var.C = null;
        if (!z) {
            return DEBUG_WIDGETS;
        }
        q(qk0Var);
        return DEBUG_WIDGETS;
    }

    public void removeOnTinyDBChangeListener(iz0 iz0Var) {
        Iterator it = this.mTinyDBChange.a.iterator();
        while (it.hasNext()) {
            iz0 iz0Var2 = (iz0) ((WeakReference) it.next()).get();
            if (iz0Var2 == null || iz0Var2 == iz0Var) {
                it.remove();
            }
        }
    }

    public Drawable resizeIconDrawable(Drawable drawable) {
        Objects.toString(drawable);
        int i = this.mDeviceProfile.D;
        drawable.setBounds(0, 0, i, i);
        return drawable;
    }

    public final void s() {
        u11 u11Var = this.mPendingAddInfo;
        u11Var.i = -1L;
        u11Var.j = -1L;
        u11Var.l = -1;
        u11Var.k = -1;
        u11Var.n = -1;
        u11Var.m = -1;
        u11Var.p = 1;
        u11Var.o = 1;
        u11Var.x = null;
    }

    public void sendAdvanceMessage(long j) {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), j);
        this.mAutoAdvanceSentTime = System.currentTimeMillis();
    }

    public boolean setLauncherCallbacks(yk0 yk0Var) {
        Objects.toString(yk0Var);
        this.mLauncherCallbacks = yk0Var;
        yk0Var.getClass();
        return DEBUG_WIDGETS;
    }

    public void setLauncherOverlay(yj0 yj0Var) {
        Objects.toString(yj0Var);
        if (yj0Var != null) {
            yj0Var.a();
        }
        this.mWorkspace.setLauncherOverlay(yj0Var);
    }

    @Override // defpackage.hl0
    public boolean setLoadOnResume() {
        if (!this.mPaused) {
            return false;
        }
        this.mOnResumeNeedsLoad = DEBUG_WIDGETS;
        return DEBUG_WIDGETS;
    }

    public void setOnTinyDBChangeListener(iz0 iz0Var) {
        this.mTinyDBChange.a.add(new WeakReference(iz0Var));
    }

    public void setOrientation() {
        if (this.mRotationEnabled) {
            unlockScreenOrientation(DEBUG_WIDGETS);
        } else {
            setRequestedOrientation(5);
        }
    }

    public void setShaking(boolean z) {
        this.mIsShaking = z;
    }

    public void showAppsLibrary() {
        if (this.appsLibraryLayout != null) {
            ObjectAnimator objectAnimatorD = ik0.d(this.appsLibraryLayout, PropertyValuesHolder.ofFloat(Key.ALPHA, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f));
            objectAnimatorD.setDuration(268L);
            objectAnimatorD.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
            objectAnimatorD.start();
        }
    }

    public void showAppsView(boolean z, boolean z2, boolean z3, boolean z4) {
        u(ak0.i);
    }

    public void showBlurWallpaperBackground(float f) {
        BlurWallpaperBackground blurWallpaperBackground = this.mBlurWallpaperBackground;
        if (blurWallpaperBackground != null) {
            blurWallpaperBackground.setAlpha(f);
        }
    }

    public void showDeleteOrUninstallDialog(boolean z, Object obj, Pair<ComponentName, Integer> pair) {
        if (obj instanceof qh0) {
            if (this.mDeleteDialog == null) {
                final zq zqVar = new zq(this);
                zqVar.setClickable(DEBUG_WIDGETS);
                zqVar.setFocusable(DEBUG_WIDGETS);
                zqVar.setBackgroundColor(1711276032);
                zqVar.q = this.isDarkMode;
                LayoutInflater.from(this).inflate(m61.dialog_content_view, zqVar, DEBUG_WIDGETS);
                zqVar.k = (LinearLayoutRound) zqVar.findViewById(v51.dialog_root);
                zqVar.l = (TextView) zqVar.findViewById(v51.tvTitle);
                zqVar.m = (TextView) zqVar.findViewById(v51.tvMessage);
                zqVar.n = (AppCompatButton) zqVar.findViewById(v51.btnAction1);
                zqVar.o = (AppCompatButton) zqVar.findViewById(v51.btnAction2);
                zqVar.p = (AppCompatButton) zqVar.findViewById(v51.btnCancel);
                zqVar.l.setTextColor(zqVar.q ? -1 : -16777216);
                zqVar.m.setTextColor(zqVar.q ? -1 : -16777216);
                zqVar.k.setDarkModeBackgroundColor(zqVar.q ? -872415232 : -858401323);
                final int i = 1;
                zqVar.setOnClickListener(new View.OnClickListener() { // from class: xq
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i) {
                            case 0:
                                zqVar.a();
                                break;
                            default:
                                zqVar.a();
                                break;
                        }
                    }
                });
                this.mDeleteDialog = zqVar;
            }
            final zq zqVar2 = this.mDeleteDialog;
            zqVar2.l.setText(getString(w61.delete_target_label) + " \"" + ((Object) ((qh0) obj).u) + "\"?");
            zqVar2.m.setText(w61.remove_app_message);
            int i2 = w61.delete_target_label;
            ce0 ce0Var = new ce0(this, pair, 1);
            zqVar2.n.setText(i2);
            zqVar2.n.setOnClickListener(new g7(ce0Var, 3));
            zqVar2.p.setText(zqVar2.getContext().getString(R.string.cancel));
            final int i3 = 0;
            zqVar2.p.setOnClickListener(new View.OnClickListener() { // from class: xq
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i3) {
                        case 0:
                            zqVar2.a();
                            break;
                        default:
                            zqVar2.a();
                            break;
                    }
                }
            });
            if (z) {
                AppCompatButton appCompatButton = this.mDeleteDialog.o;
                if (appCompatButton != null) {
                    appCompatButton.setVisibility(8);
                }
            } else {
                zq zqVar3 = this.mDeleteDialog;
                int i4 = w61.delete_target_uninstall_label;
                mj0 mj0Var = new mj0(this, (qh0) obj, pair);
                zqVar3.o.setText(i4);
                zqVar3.o.setOnClickListener(new g7(mj0Var, 4));
            }
            if (this.mDeleteDialog.getParent() != null) {
                this.mDeleteDialog.bringToFront();
                this.mDeleteDialog.animate().alpha(1.0f).setDuration(150L).start();
                return;
            }
            zq zqVar4 = this.mDeleteDialog;
            DragLayer dragLayer = this.mDragLayer;
            if (zqVar4.getParent() != null) {
                return;
            }
            zqVar4.setAlpha(0.0f);
            ag0 ag0Var = new ag0(-1, -1);
            ((FrameLayout.LayoutParams) ag0Var).gravity = 17;
            dragLayer.addView(zqVar4, ag0Var);
            zqVar4.animate().withLayer().alpha(1.0f).setDuration(236L).start();
            zqVar4.k.setScaleX(1.5f);
            zqVar4.k.setScaleY(1.5f);
            zqVar4.k.animate().withLayer().scaleX(1.0f).scaleY(1.0f).setDuration(286L).setInterpolator(new DecelerateInterpolator(1.36f)).start();
        }
    }

    public boolean showFirstRunActivity() {
        Intent firstRunActivity;
        if (ActivityManager.isRunningInTestHarness() || this.mSharedPrefs.getBoolean(FIRST_RUN_ACTIVITY_DISPLAYED, false) || !hasFirstRunActivity() || (firstRunActivity = getFirstRunActivity()) == null) {
            return false;
        }
        startActivity(firstRunActivity);
        SharedPreferences.Editor editorEdit = this.mSharedPrefs.edit();
        editorEdit.putBoolean(FIRST_RUN_ACTIVITY_DISPLAYED, DEBUG_WIDGETS);
        editorEdit.apply();
        return DEBUG_WIDGETS;
    }

    public void showFirstRunClings() {
        bl0 bl0Var = new bl0(this);
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (ActivityManager.isRunningInTestHarness() || ((AccessibilityManager) getSystemService("accessibility")).isTouchExplorationEnabled()) {
            return;
        }
        if ((ar1.p && ((UserManager) getSystemService("user")).getUserRestrictions().getBoolean("no_modify_accounts", false)) || Settings.Secure.getInt(getContentResolver(), "skip_first_use_hints", 0) == 1 || sharedPrefs.getBoolean("cling_gel.workspace.dismissed", false) || sharedPrefs.getBoolean("cling_gel.migration.dismissed", false)) {
            return;
        }
        this.mClings = bl0Var;
        rl0 rl0Var = this.mModel;
        rl0Var.getClass();
        Objects.toString(this);
        if (!rl0Var.g || isLauncherPreinstalled()) {
            bl0Var.b(DEBUG_WIDGETS);
            return;
        }
        bl0Var.i = DEBUG_WIDGETS;
        hideWorkspaceSearchAndHotseat();
        View viewInflate = bl0Var.h.inflate(m61.migration_cling, (ViewGroup) findViewById(v51.launcher));
        viewInflate.findViewById(v51.cling_dismiss_migration_copy_apps).setOnClickListener(bl0Var);
        viewInflate.findViewById(v51.cling_dismiss_migration_use_default).setOnClickListener(bl0Var);
    }

    public void showFolderBlurBackground(float f) {
        BlurScreenLayout blurScreenLayout = this.mBlurBackgroundView;
        if (blurScreenLayout != null) {
            try {
                if (f == 0.0f) {
                    blurScreenLayout.o = null;
                    blurScreenLayout.setBackground(null);
                } else {
                    if (blurScreenLayout.getBackground() != null) {
                        blurScreenLayout.setAlpha(f);
                        return;
                    }
                    blurScreenLayout.setAlpha(f);
                    Handler handler = blurScreenLayout.m;
                    if (handler.hasMessages(2)) {
                        return;
                    }
                    handler.obtainMessage(2).sendToTarget();
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public void showIntroScreen() {
        View introScreen = getIntroScreen();
        changeWallpaperVisiblity(false);
        if (introScreen != null) {
            this.mDragLayer.showOverlayView(introScreen);
        }
    }

    public void showOutOfSpaceMessage(boolean z) {
        Toast.makeText(this, getString(z ? w61.hotseat_out_of_space : w61.out_of_space), 0).show();
    }

    public void showOverviewMode(boolean z) {
        if (this.mIsShaking) {
            cancelShakingAnimation();
        } else {
            onShakingAllApps();
        }
    }

    public void showPopupToChangeLabel(int i, CharSequence charSequence) {
        ae0 ae0Var = this.mEditWidgetLabelDialog;
        if (ae0Var != null) {
            ae0Var.l = i;
            AppCompatEditText appCompatEditText = ae0Var.k;
            appCompatEditText.setHint(charSequence);
            appCompatEditText.requestFocus();
            ae0Var.show();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(ae0Var.getWindow().getAttributes());
            layoutParams.width = (ae0Var.j.screenWidth * 3) / 4;
            ae0Var.getWindow().setAttributes(layoutParams);
        }
    }

    public void showWidgetsView(boolean z, boolean z2) {
        if (z2) {
            this.mWidgetsView.T.l0(0);
        }
        u(ak0.k);
        this.mWidgetsView.post(new c(this, 0));
    }

    public boolean showWorkspace(boolean z) {
        return showWorkspace(-1, z, null);
    }

    public void showWorkspaceSearchAndHotseat() {
        Workspace workspace = this.mWorkspace;
        if (workspace != null) {
            workspace.setAlpha(1.0f);
        }
        Hotseat hotseat = this.mHotseat;
        if (hotseat != null) {
            hotseat.setAlpha(1.0f);
        }
        View view = this.mPageIndicators;
        if (view != null) {
            view.setAlpha(1.0f);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        try {
            Objects.toString(intent);
            if (i >= 0) {
                t(DEBUG_WIDGETS);
            }
            super.startActivityForResult(intent, i);
        } catch (Throwable unused) {
            Toast.makeText(this, getString(w61.activity_not_found), 1).show();
        }
    }

    public boolean startActivitySafely(final View view, final Intent intent, final Object obj) {
        Objects.toString(view);
        Objects.toString(intent);
        Objects.toString(obj);
        if (intent == null) {
            return false;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (!this.mIsSafeModeEnabled || ar1.w(this, intent)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: lj0
                @Override // java.lang.Runnable
                public final void run() {
                    AtomicBoolean atomicBoolean2 = atomicBoolean;
                    View view2 = view;
                    Intent intent2 = intent;
                    Object obj2 = obj;
                    t tVar = this.g;
                    try {
                        atomicBoolean2.set(tVar.x(view2, intent2, obj2));
                    } catch (ActivityNotFoundException unused) {
                        Toast.makeText(tVar, w61.activity_not_found, 0).show();
                        Objects.toString(obj2);
                        Objects.toString(intent2);
                    }
                }
            });
            return atomicBoolean.get();
        }
        Toast.makeText(this, w61.safemode_shortcut_error, 0).show();
        return false;
    }

    public void startAppShortcutOrInfoActivity(View view) {
        Intent intent;
        og1 og1Var;
        Objects.toString(view);
        yk0 yk0Var = this.mLauncherCallbacks;
        if (yk0Var != null) {
            IOSLauncher iOSLauncher = ((com.luutinhit.launcher6.ioslauncher.a) yk0Var).a;
            if (iOSLauncher.isOpenCloseAnim) {
                iOSLauncher.zoomInLauncherView();
            }
        }
        Object tag = view.getTag();
        if (tag instanceof og1) {
            og1Var = (og1) tag;
            intent = og1Var.x;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            intent.setSourceBounds(new Rect(i, iArr[1], view.getWidth() + i, view.getHeight() + iArr[1]));
        } else {
            if (!(tag instanceof v6)) {
                throw new IllegalArgumentException("Input must be a Shortcut or AppInfo");
            }
            intent = ((v6) tag).x;
            og1Var = null;
        }
        boolean zStartActivitySafely = startActivitySafely(view, intent, tag);
        kj1 kj1Var = this.mStats;
        kj1Var.getClass();
        Intent intent2 = new Intent(intent);
        intent2.setSourceBounds(null);
        Intent intentPutExtra = new Intent("com.luutinhit.launcher6.action.LAUNCH").putExtra("intent", intent2.toUri(0));
        if (og1Var != null) {
            intentPutExtra.putExtra("container", og1Var.i).putExtra("screen", og1Var.j).putExtra("cellX", og1Var.k).putExtra("cellY", og1Var.l);
        }
        Bundle bundle = new Bundle();
        bundle.putString("container", "homescreen");
        bundle.putInt("container_page", 0);
        bundle.putInt("sub_container_page", 0);
        np1.D(view, bundle);
        intentPutExtra.putExtra("source", bundle);
        t tVar = kj1Var.a;
        for (String str : tVar.getResources().getStringArray(j41.launch_broadcast_targets)) {
            intentPutExtra.setPackage(str);
            tVar.sendBroadcast(intentPutExtra, kj1Var.b);
        }
        if (zStartActivitySafely && (view instanceof BubbleTextView)) {
            this.mWaitingForResume = (BubbleTextView) view;
            this.mWorkerHandler.obtainMessage(3, view).sendToTarget();
        }
    }

    public void startApplicationDetailsActivity(ComponentName componentName, jq1 jq1Var) {
        Objects.toString(componentName);
        Objects.toString(jq1Var);
        try {
            qg0.t(this).L(componentName, jq1Var);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, w61.activity_not_found, 0).show();
        } catch (SecurityException unused2) {
            Toast.makeText(this, w61.activity_not_found, 0).show();
        }
    }

    public boolean startApplicationUninstallActivity(ComponentName componentName, int i, jq1 jq1Var) {
        UserHandle userHandle;
        Objects.toString(componentName);
        Objects.toString(jq1Var);
        if ((i & 1) == 0) {
            Toast.makeText(this, w61.uninstall_system_app_text, 0).show();
            return false;
        }
        Intent intent = new Intent("android.intent.action.DELETE", Uri.fromParts("package", componentName.getPackageName(), componentName.getClassName()));
        intent.setFlags(276824064);
        if (jq1Var != null && ar1.m && (userHandle = jq1Var.a) != null) {
            intent.putExtra("android.intent.extra.USER", userHandle);
        }
        startActivity(intent);
        return DEBUG_WIDGETS;
    }

    @Override // defpackage.hl0
    public void startBinding() {
        boolean zIsWorkspaceLocked = isWorkspaceLocked();
        this.mWorkspaceLoading = DEBUG_WIDGETS;
        if (zIsWorkspaceLocked != isWorkspaceLocked()) {
            onWorkspaceLockedChanged();
        }
        this.mBindOnResumeCallbacks.clear();
        Workspace workspace = this.mWorkspace;
        workspace.getClass();
        workspace.O0(false, new iw1(workspace));
        this.mWorkspace.U0();
        this.mWidgetsToAdvance.clear();
    }

    public void startDrag(View view, qh0 qh0Var, xw xwVar) {
        Objects.toString(view);
        Objects.toString(qh0Var);
        Objects.toString(xwVar);
        view.setTag(qh0Var);
        Workspace workspace = this.mWorkspace;
        workspace.getClass();
        Objects.toString(view);
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (view instanceof BubbleTextView) {
            BubbleTextView bubbleTextView = (BubbleTextView) view;
            Objects.toString(bubbleTextView);
            Drawable icon = bubbleTextView.getIcon();
            Objects.toString(icon);
            Rect rect = new Rect();
            icon.copyBounds(rect);
            if (rect.width() == 0 || rect.height() == 0) {
                rect.set(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
            } else {
                rect.offsetTo(0, 0);
            }
            if (icon instanceof i31) {
                int i = -((i31) icon).f;
                rect.inset(i, i);
            }
            measuredWidth = rect.width();
            measuredHeight = rect.height();
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, config);
        Canvas canvas = workspace.v1;
        canvas.setBitmap(bitmapCreateBitmap);
        Workspace.u0(view, canvas, 0);
        canvas.setBitmap(null);
        Workspace workspace2 = this.mWorkspace;
        workspace2.getClass();
        Objects.toString(view);
        Objects.toString(xwVar);
        int i2 = workspace2.F0.D;
        t tVar = workspace2.S0;
        tVar.onDragStarted(view);
        AtomicInteger atomicInteger = new AtomicInteger(2);
        Bitmap bitmapS0 = workspace2.s0(view, atomicInteger);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i2, i2, config);
        Paint paint = new Paint();
        paint.setFilterBitmap(DEBUG_WIDGETS);
        Canvas canvas2 = workspace2.v1;
        canvas2.setBitmap(bitmapCreateBitmap2);
        canvas2.drawBitmap(bitmapS0, new Rect(0, 0, bitmapS0.getWidth(), bitmapS0.getHeight()), new Rect(0, 0, i2, i2), paint);
        canvas2.setBitmap(null);
        float width = bitmapS0.getWidth();
        float locationInDragLayer = tVar.getDragLayer().getLocationInDragLayer(view, workspace2.j1) * (width / i2);
        int iRound = Math.round(r9[0] - ((width - (view.getWidth() * locationInDragLayer)) / 2.0f));
        int iRound2 = Math.round(r9[1]);
        Point point = new Point((-atomicInteger.get()) / 2, atomicInteger.get() / 2);
        Rect rect2 = new Rect(0, 0, i2, i2);
        if (view.getTag() != null && (view.getTag() instanceof qh0)) {
            workspace2.U0.l(bitmapCreateBitmap2, iRound, iRound2, xwVar, view.getTag(), 0, point, rect2, locationInDragLayer, false).setIntrinsicIconScaleFactor(xwVar.getIntrinsicIconScaleFactor());
            bitmapS0.recycle();
        } else {
            throw new IllegalStateException("Drag started with a view that has no tag set. This will cause a crash (issue 11627249) down the line. View: " + view + "  tag: " + view.getTag());
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Objects.toString(intentSender);
        Objects.toString(intent);
        Objects.toString(bundle);
        if (i >= 0) {
            t(DEBUG_WIDGETS);
        }
        try {
            super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } catch (IntentSender.SendIntentException unused) {
            throw new ActivityNotFoundException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
    
        if (r0.isSetWallpaperAllowed() != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean startWallpaperPicker(android.view.View r4) {
        /*
            r3 = this;
            boolean r0 = defpackage.ar1.f     // Catch: java.lang.Throwable -> L4a
            if (r0 == 0) goto L13
            java.lang.Object r0 = defpackage.np.k(r3)     // Catch: java.lang.Throwable -> L4a
            android.app.WallpaperManager r0 = (android.app.WallpaperManager) r0     // Catch: java.lang.Throwable -> L4a
            java.util.Objects.requireNonNull(r0)     // Catch: java.lang.Throwable -> L4a
            boolean r0 = defpackage.ep0.y(r0)     // Catch: java.lang.Throwable -> L4a
            if (r0 == 0) goto L4a
        L13:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.intent.action.SET_WALLPAPER"
            r0.<init>(r1)
            com.luutinhit.launcher6.Workspace r1 = r3.getWorkspace()
            float r1 = r1.getWallpaperOffsetForCenterPage()
            java.lang.String r2 = "com.luutinhit.launcher6.WALLPAPER_OFFSET"
            android.content.Intent r0 = r0.putExtra(r2, r1)
            r1 = 32768(0x8000, float:4.5918E-41)
            r0.addFlags(r1)
            int r1 = defpackage.w61.wallpaper_picker_package
            java.lang.String r1 = r3.getString(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L3e
            r0.setPackage(r1)
            goto L44
        L3e:
            java.lang.String r1 = "com.luutinhit.launcher6.intent.extra.shortcut.INGORE_LAUNCH_ANIMATION"
            r2 = 1
            r0.putExtra(r1, r2)
        L44:
            r1 = 0
            boolean r4 = r3.startActivitySafely(r4, r0, r1)
            return r4
        L4a:
            int r4 = defpackage.w61.msg_disabled_by_admin
            r0 = 0
            android.widget.Toast r4 = android.widget.Toast.makeText(r3, r4, r0)
            r4.show()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.t.startWallpaperPicker(android.view.View):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0429  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator startWorkspaceStateChangeAnimation(defpackage.d02 r36, int r37, boolean r38, java.util.HashMap<android.view.View, java.lang.Integer> r39) {
        /*
            Method dump skipped, instruction units count: 1094
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.t.startWorkspaceStateChangeAnimation(d02, int, boolean, java.util.HashMap):android.animation.Animator");
    }

    public final void t(boolean z) {
        boolean zIsWorkspaceLocked = isWorkspaceLocked();
        this.mWaitingForResult = z;
        if (zIsWorkspaceLocked != isWorkspaceLocked()) {
            onWorkspaceLockedChanged();
        }
    }

    public final void u(ak0 ak0Var) {
        Objects.toString(ak0Var);
        ak0 ak0Var2 = this.mState;
        if (ak0Var2 == ak0.h || ak0Var2 == ak0.j || ak0Var2 == ak0.l) {
            ak0 ak0Var3 = ak0.i;
            ak0 ak0Var4 = ak0.k;
            if (ak0Var == ak0Var3 || ak0Var == ak0Var4) {
                if (ak0Var == ak0Var4) {
                    zl0 zl0Var = this.mStateTransitionAnimation;
                    d02 state = this.mWorkspace.getState();
                    zl0Var.getClass();
                    Objects.toString(state);
                    zl0Var.a.openWidgetView(DEBUG_WIDGETS, DEBUG_WIDGETS);
                }
                this.mState = ak0Var;
                this.mUserPresent = false;
                updateAutoAdvanceState();
                closeFolder();
                getWindow().getDecorView().sendAccessibilityEvent(32);
            }
        }
    }

    public void unlockAllApps() {
    }

    public void unlockScreenOrientation(boolean z) {
        if (this.mRotationEnabled) {
            if (z) {
                setRequestedOrientation(-1);
            } else {
                this.mHandler.postDelayed(new oj0(this, 3), 500L);
            }
        }
    }

    public void updateAutoAdvanceState() {
        boolean z = (this.mVisible && this.mUserPresent && !this.mWidgetsToAdvance.isEmpty()) ? DEBUG_WIDGETS : false;
        if (z != this.mAutoAdvanceRunning) {
            this.mAutoAdvanceRunning = z;
            if (z) {
                long j = this.mAutoAdvanceTimeLeft;
                sendAdvanceMessage(j != -1 ? j : 20000L);
            } else {
                if (!this.mWidgetsToAdvance.isEmpty()) {
                    this.mAutoAdvanceTimeLeft = Math.max(0L, 20000 - (System.currentTimeMillis() - this.mAutoAdvanceSentTime));
                }
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(0);
            }
        }
    }

    public void updateIconBadges(List<String> list) {
        Objects.toString(list);
        w1 w1Var = new w1(this, list, 21, false);
        if (waitUntilResume(w1Var, DEBUG_WIDGETS)) {
            return;
        }
        w1Var.run();
    }

    public void updateIconTextColor(int i) {
        ArrayList<CellLayout> workspaceAndHotseatCellLayouts;
        if (this.mIconTextColor != i) {
            this.mIconTextColor = i;
            bo1 bo1Var = this.mTinyDB;
            if (bo1Var != null) {
                bo1Var.f(i, "icon_text_color");
            }
            Workspace workspace = this.mWorkspace;
            if (workspace != null && (workspaceAndHotseatCellLayouts = workspace.getWorkspaceAndHotseatCellLayouts()) != null) {
                int size = workspaceAndHotseatCellLayouts.size();
                int i2 = 0;
                while (i2 < size) {
                    CellLayout cellLayout = workspaceAndHotseatCellLayouts.get(i2);
                    i2++;
                    CellLayout cellLayout2 = cellLayout;
                    if (cellLayout2 != null) {
                        cellLayout2.getShortcutsAndWidgets().setIconTextColor(i);
                    }
                }
            }
            if (ar1.i) {
                int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
                getWindow().getDecorView().setSystemUiVisibility(i == -1 ? systemUiVisibility & (-8193) : systemUiVisibility | 8192);
            }
        }
    }

    public void updateInteraction(d02 d02Var, d02 d02Var2) {
        Objects.toString(d02Var);
        Objects.toString(d02Var2);
        d02 d02Var3 = d02.h;
        boolean z = d02Var != d02Var3 ? DEBUG_WIDGETS : false;
        if (d02Var2 != d02Var3) {
            onInteractionBegin();
        } else if (z) {
            onInteractionEnd();
        }
    }

    public void updateOverlayBounds(Rect rect) {
        Objects.toString(rect);
        this.mWidgetsView.setSearchBarBounds(rect);
    }

    public boolean useVerticalBarLayout() {
        this.mDeviceProfile.getClass();
        return false;
    }

    public final void v(String str, DialogInterface.OnClickListener onClickListener) {
        Objects.toString(onClickListener);
        new AlertDialog.Builder(this).setTitle(w61.abandoned_promises_title).setMessage(w61.abandoned_promise_explanation).setPositiveButton(w61.abandoned_search, onClickListener).setNeutralButton(w61.abandoned_clean_this, new n(this, str)).create().show();
    }

    public void vibrate() {
        try {
            new Thread(new oj0(this, 4)).start();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void w(ViewGroup viewGroup) {
        BlurScreenLayout blurScreenLayout = this.mFloatingBackgroundView;
        if (blurScreenLayout != null) {
            try {
                blurScreenLayout.m.obtainMessage(2, viewGroup).sendToTarget();
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public boolean waitUntilResume(Runnable runnable, boolean z) {
        Objects.toString(runnable);
        if (!this.mPaused) {
            return false;
        }
        if (z) {
            while (this.mBindOnResumeCallbacks.remove(runnable)) {
            }
        }
        this.mBindOnResumeCallbacks.add(runnable);
        return DEBUG_WIDGETS;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1 A[Catch: all -> 0x001e, TryCatch #1 {all -> 0x001e, blocks: (B:4:0x0014, B:9:0x0022, B:11:0x0031, B:14:0x003f, B:16:0x0043, B:18:0x004f, B:20:0x0058, B:22:0x007e, B:25:0x008f, B:35:0x00c1, B:26:0x009b, B:27:0x00a0, B:29:0x00a4, B:30:0x00b1, B:32:0x00b5, B:37:0x00c7, B:40:0x00d2, B:42:0x00de, B:46:0x011c, B:56:0x0132, B:58:0x0136, B:59:0x0139, B:43:0x00e2, B:45:0x0110, B:50:0x0122, B:52:0x0128, B:55:0x012f), top: B:75:0x0014, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x(android.view.View r11, android.content.Intent r12, java.lang.Object r13) {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.t.x(android.view.View, android.content.Intent, java.lang.Object):boolean");
    }

    public final boolean y(Runnable runnable) {
        Objects.toString(runnable);
        return waitUntilResume(runnable, false);
    }

    public static void addDumpLog(String str, String str2, boolean z) {
        addDumpLog(str, str2, null, z);
    }

    public void closeFolder(boolean z) {
        if (this.mBlurBackgroundView.getBackground() != null) {
            this.mBlurBackgroundView.d(false);
        }
        Workspace workspace = this.mWorkspace;
        Folder openFolder = workspace != null ? workspace.getOpenFolder() : null;
        if (openFolder != null) {
            if (openFolder.P) {
                openFolder.B();
            }
            closeFolder(openFolder, z);
        }
    }

    public boolean showWorkspace(boolean z, Runnable runnable) {
        Objects.toString(runnable);
        return showWorkspace(-1, z, runnable);
    }

    public View createShortcut(ViewGroup viewGroup, og1 og1Var) {
        Objects.toString(viewGroup);
        Objects.toString(og1Var);
        BubbleTextView bubbleTextView = (BubbleTextView) this.mInflater.inflate(m61.app_icon, viewGroup, false);
        bubbleTextView.o(og1Var, this.mIconCache, false);
        bubbleTextView.setOnClickListener(this);
        bubbleTextView.setOnFocusChangeListener(this.mFocusHandler);
        bubbleTextView.setLongPressTimeout(1369);
        bubbleTextView.setTextColor(this.mIconTextColor);
        return bubbleTextView;
    }

    public void showOverviewMode(boolean z, boolean z2) {
        oj0 oj0Var = z2 ? new oj0(this, 1) : null;
        this.mWorkspace.setVisibility(0);
        this.mStateTransitionAnimation.b(this.mState, this.mWorkspace.getState(), d02.l, oj0Var);
        this.mState = ak0.h;
    }

    public boolean showWorkspace(int i, boolean z) {
        return showWorkspace(i, z, null);
    }

    public FastBitmapDrawable createIconDrawable(Bitmap bitmap, int i, boolean z) {
        Objects.toString(bitmap);
        FastBitmapDrawable fastBitmapDrawable = new FastBitmapDrawable(this, bitmap, i, z);
        fastBitmapDrawable.setFilterBitmap(DEBUG_WIDGETS);
        resizeIconDrawable(fastBitmapDrawable);
        return fastBitmapDrawable;
    }

    public boolean showWorkspace(int i, boolean z, Runnable runnable) {
        Objects.toString(runnable);
        ak0 ak0Var = this.mState;
        ak0 ak0Var2 = ak0.h;
        d02 d02Var = d02.h;
        boolean z2 = (ak0Var == ak0Var2 && this.mWorkspace.getState() == d02Var) ? false : DEBUG_WIDGETS;
        if (z2) {
            this.mWorkspace.setVisibility(0);
            this.mStateTransitionAnimation.b(this.mState, this.mWorkspace.getState(), d02Var, runnable);
        }
        this.mState = ak0Var2;
        this.mUserPresent = DEBUG_WIDGETS;
        updateAutoAdvanceState();
        if (z2) {
            getWindow().getDecorView().sendAccessibilityEvent(32);
        }
        return z2;
    }

    public qh0 createAppDragInfo(Intent intent, jq1 jq1Var) {
        Objects.toString(intent);
        Objects.toString(jq1Var);
        if (jq1Var == null) {
            jq1Var = jq1.b();
        }
        ek0 ek0VarF = qg0.t(this).F(intent, jq1Var);
        if (ek0VarF == null) {
            return null;
        }
        return new v6(this, ek0VarF, jq1Var, this.mIconCache);
    }

    public void closeFolder(Folder folder, boolean z) {
        char c;
        Objects.toString(folder);
        folder.getInfo().y = false;
        if (((ViewGroup) folder.getParent().getParent()) != null) {
            Workspace workspace = this.mWorkspace;
            w40 w40Var = folder.p;
            workspace.getClass();
            Objects.toString(w40Var);
            FolderIcon folderIcon = (FolderIcon) workspace.B0(new hs(w40Var));
            Objects.toString(folderIcon);
            if (folderIcon == null) {
                c = 0;
            } else {
                PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(Key.ALPHA, 1.0f);
                PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f);
                PropertyValuesHolder propertyValuesHolderOfFloat3 = PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f);
                CellLayout cellLayout = (CellLayout) folderIcon.getParent().getParent();
                c = 0;
                this.mDragLayer.removeView(this.mFolderIconImageView);
                p(folderIcon);
                ObjectAnimator objectAnimatorD = ik0.d(this.mFolderIconImageView, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2, propertyValuesHolderOfFloat3);
                objectAnimatorD.setDuration(getResources().getInteger(g61.config_shrinkAndFadeInFolderIcon));
                objectAnimatorD.addListener(new o(this, cellLayout, folderIcon));
                if (ar1.m) {
                    objectAnimatorD.setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f));
                }
                objectAnimatorD.start();
                if (!z) {
                    objectAnimatorD.end();
                }
            }
            if (folderIcon != null) {
                ((zg) folderIcon.getLayoutParams()).j = DEBUG_WIDGETS;
            }
        } else {
            c = 0;
        }
        if (z) {
            if (folder.getParent() instanceof DragLayer) {
                folder.y();
                float[] fArr = new float[1];
                fArr[c] = 0.0f;
                PropertyValuesHolder propertyValuesHolderOfFloat4 = PropertyValuesHolder.ofFloat(Key.ALPHA, fArr);
                float[] fArr2 = new float[1];
                fArr2[c] = 0.3f;
                PropertyValuesHolder propertyValuesHolderOfFloat5 = PropertyValuesHolder.ofFloat(Key.SCALE_X, fArr2);
                float[] fArr3 = new float[1];
                fArr3[c] = 0.3f;
                PropertyValuesHolder propertyValuesHolderOfFloat6 = PropertyValuesHolder.ofFloat(Key.SCALE_Y, fArr3);
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[3];
                propertyValuesHolderArr[c] = propertyValuesHolderOfFloat4;
                propertyValuesHolderArr[1] = propertyValuesHolderOfFloat5;
                propertyValuesHolderArr[2] = propertyValuesHolderOfFloat6;
                ObjectAnimator objectAnimatorD2 = ik0.d(folder, propertyValuesHolderArr);
                if (ar1.m) {
                    objectAnimatorD2.setInterpolator(new PathInterpolator(0.33f, 0.89f, 0.55f, 1.0f));
                }
                objectAnimatorD2.addListener(new be(folder, 7));
                objectAnimatorD2.setDuration(folder.getResources().getInteger(g61.config_folderCollapseDuration));
                folder.setLayerType(2, null);
                objectAnimatorD2.start();
            }
        } else {
            folder.z(false);
        }
        getDragLayer().sendAccessibilityEvent(32);
    }
}
