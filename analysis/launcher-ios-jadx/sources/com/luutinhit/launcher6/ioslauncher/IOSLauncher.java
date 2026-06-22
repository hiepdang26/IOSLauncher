package com.luutinhit.launcher6.ioslauncher;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import androidx.constraintlayout.motion.widget.Key;
import androidx.profileinstaller.ProfileVerifier;
import com.luutinhit.launcher6.Hotseat;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcherios.MainActivity;
import com.luutinhit.launcherios.activity.RatingActivity;
import defpackage.ar1;
import defpackage.bd;
import defpackage.be;
import defpackage.be0;
import defpackage.bo1;
import defpackage.c71;
import defpackage.ce0;
import defpackage.de0;
import defpackage.ge0;
import defpackage.ik0;
import defpackage.m61;
import defpackage.na1;
import defpackage.ng1;
import defpackage.o1;
import defpackage.p3;
import defpackage.q61;
import defpackage.r00;
import defpackage.t3;
import defpackage.u3;
import defpackage.v51;
import defpackage.wc;
import defpackage.yu;
import defpackage.za1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class IOSLauncher extends t {
    private static final int MIN_FLING_VELOCITY = 250;
    private static final int MIN_SNAP_VELOCITY = 1500;
    private static final String TAG = "IOSLauncher";
    private u3 mDialogWarningWallpaper;
    private InputMethodManager mInputMethodManager;
    private PowerManager mPowerManager;
    private za1 mRequestSetDefaultLauncher;
    private bo1 mTinyDB;
    WallpaperManager mWallpaperManager;
    private int mCountOpenControlView = 0;
    private int mNumberShowRateDialog = 8;
    private boolean mHasPrepareOpenAnimation = false;
    private boolean mBeginDragLeftPage = false;
    private boolean mBeginDragLibraryPage = false;
    private int mMinFlingVelocity = MIN_FLING_VELOCITY;
    private int mMinSnapVelocity = MIN_SNAP_VELOCITY;
    private final Runnable mRestorePosition = new o1(this, 25);

    /* JADX INFO: Access modifiers changed from: private */
    public void checkHideNavigation() {
        if (this.isHideNavigation) {
            try {
                final View decorView = getWindow().getDecorView();
                decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: ee0
                    @Override // android.view.View.OnSystemUiVisibilityChangeListener
                    public final void onSystemUiVisibilityChange(int i) {
                        this.a.lambda$checkHideNavigation$1(decorView, i);
                    }
                });
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    private int getDurationWithVelocity(float f, float f2) {
        int iRound;
        if (Math.abs(f) >= this.mMinFlingVelocity) {
            iRound = Math.round(Math.abs(f2 / Math.max(this.mMinSnapVelocity, Math.abs(f))) * 1000.0f) * 6;
        } else {
            iRound = 268;
        }
        return Math.max(iRound, 136);
    }

    private File getFileWallpaperFromStorage() {
        try {
            File file = new File(new ContextWrapper(this).getDir("image", 0), "wallpaper");
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    private void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = this.mInputMethodManager;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void hideNavigationNow() {
        try {
            View decorView = getWindow().getDecorView();
            decorView.postDelayed(new wc(this, decorView, 9), 500L);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMyLauncherDefault() {
        try {
            PackageManager packageManager = getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            return packageManager.resolveActivity(intent, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST).activityInfo.packageName.equals(getPackageName());
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkHideNavigation$0(int i, View view) {
        int i2;
        if ((i & 4) == 0) {
            try {
                if (ar1.n) {
                    i2 = 4866;
                } else {
                    requestWindowFeature(1);
                    getWindow().setFlags(1024, 1024);
                    i2 = 1799;
                }
                view.setSystemUiVisibility(i2);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkHideNavigation$1(View view, int i) {
        view.postDelayed(new yu(this, i, view, 1), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideNavigationNow$2(View view) {
        int i;
        try {
            if (ar1.n) {
                i = 4866;
            } else {
                requestWindowFeature(1);
                getWindow().setFlags(1024, 1024);
                i = 1799;
            }
            view.setSystemUiVisibility(i);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resumeNormalHomeState$6() {
        try {
            if (getDragLayer() != null) {
                getDragLayer().setScaleX(1.0f);
                getDragLayer().setScaleY(1.0f);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveToInternalStorage$11(String str, Bitmap bitmap) throws Throwable {
        File dir;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                dir = getDir("image", 0);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (Exception e2) {
            e = e2;
        }
        if (!dir.exists() && !dir.mkdirs()) {
            dir.getAbsolutePath();
            bitmap.recycle();
            return;
        }
        File file = new File(dir, str);
        if (file.exists() && !file.delete()) {
            file.getAbsolutePath();
        }
        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
            fileOutputStream2.flush();
            try {
                fileOutputStream2.close();
            } catch (IOException e3) {
                e = e3;
                e.getMessage();
            }
        } catch (IOException e4) {
            fileOutputStream = fileOutputStream2;
            e = e4;
            e.getMessage();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    e = e5;
                    e.getMessage();
                }
            }
        } catch (Exception e6) {
            fileOutputStream = fileOutputStream2;
            e = e6;
            e.getMessage();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e7) {
                    e = e7;
                    e.getMessage();
                }
            }
        } catch (Throwable th2) {
            fileOutputStream = fileOutputStream2;
            th = th2;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e8) {
                    e8.getMessage();
                }
            }
            bitmap.recycle();
            throw th;
        }
        bitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setWallpaperFromBitmap$10(Bitmap bitmap) {
        try {
            this.mWallpaperManager.suggestDesiredDimensions(this.screenWidth, this.screenHeight);
            if (ar1.f) {
                this.mWallpaperManager.setBitmap(bitmap, new Rect(0, 0, this.screenWidth, this.screenHeight), true, 1);
            } else {
                this.mWallpaperManager.setBitmap(bitmap);
            }
            if (ar1.j) {
                this.mWallpaperManager.getWallpaperId(1);
                this.mTinyDB.f(this.mWallpaperManager.getWallpaperId(1), "wallpaper_id");
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAppsLibrarySettingsGuide$9(u3 u3Var, View view) {
        u3Var.dismiss();
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$showSuggestWallpaperChangeDialog$3(View view) {
        this.mTinyDB.a.edit().putBoolean("not_show_suggest_blur_effect_dialog", true).apply();
        u3 u3Var = this.mDialogWarningWallpaper;
        if (u3Var == null || !u3Var.isShowing()) {
            return;
        }
        this.mDialogWarningWallpaper.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSuggestWallpaperChangeDialog$4(View view) {
        u3 u3Var = this.mDialogWarningWallpaper;
        if (u3Var == null || !u3Var.isShowing()) {
            return;
        }
        this.mDialogWarningWallpaper.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSuggestWallpaperChangeDialog$5(View view) {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        u3 u3Var = this.mDialogWarningWallpaper;
        if (u3Var == null || !u3Var.isShowing()) {
            return;
        }
        this.mDialogWarningWallpaper.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPlayOpenAnimation$7() {
        this.mHasPrepareOpenAnimation = false;
        playOpenAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeNormalHomeState() {
        getDragLayer().postDelayed(new de0(this, 1), 889L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveToInternalStorage(String str, Bitmap bitmap) {
        Bitmap bitmapCopy;
        if (bitmap == null || bitmap.isRecycled() || (bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false)) == null) {
            return;
        }
        new Thread(new bd(this, str, bitmapCopy, 6)).start();
    }

    private void setDefaultWallpaperFromResource() {
        na1 na1Var = (na1) ((na1) com.bumptech.glide.a.e(getApplicationContext()).l().Q(Integer.valueOf(q61.wallpaper_default_1)).c()).p(this.screenWidth, this.screenHeight);
        na1Var.K(new ge0(this, 1), na1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrRestoreWallpaper() {
        File fileWallpaperFromStorage = getFileWallpaperFromStorage();
        if (fileWallpaperFromStorage != null) {
            setWallpaperFromFile(fileWallpaperFromStorage);
        } else {
            setDefaultWallpaperFromResource();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWallpaperFromBitmap(Bitmap bitmap) {
        new Thread(new wc(this, bitmap, 10)).start();
    }

    private void setWallpaperFromFile(File file) {
        na1 na1Var = (na1) ((na1) com.bumptech.glide.a.e(getApplicationContext()).l().P(file).c()).p(this.screenWidth, this.screenHeight);
        na1Var.K(new ge0(this, 0), na1Var);
    }

    private void showAppsLibrarySettingsGuide() {
        View viewInflate = LayoutInflater.from(this).inflate(m61.dialog_apps_library_settings, (ViewGroup) null);
        Button button = (Button) viewInflate.findViewById(v51.dialog_set_default_button_negative);
        Button button2 = (Button) viewInflate.findViewById(v51.dialog_set_default_button_positive);
        t3 t3Var = new t3((Context) this, c71.Rounded_AppCompat_Dialog);
        ((p3) t3Var.h).t = viewInflate;
        u3 u3VarD = t3Var.d();
        button.setOnClickListener(new be0(u3VarD, 0));
        button2.setOnClickListener(new ce0(this, u3VarD, 0));
        u3VarD.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSuggestWallpaperChangeDialog() {
        if (this.mTinyDB.a.getBoolean("not_show_suggest_blur_effect_dialog", false)) {
            return;
        }
        try {
            View viewInflate = getLayoutInflater().inflate(m61.dialog_suggest_blur_effect, (ViewGroup) null);
            t3 t3Var = new t3((Context) this, c71.Rounded_AppCompat_Dialog);
            p3 p3Var = (p3) t3Var.h;
            p3Var.t = viewInflate;
            p3Var.m = false;
            this.mDialogWarningWallpaper = t3Var.d();
            final int i = 0;
            viewInflate.findViewById(v51.dialog_blur_effect_button_never).setOnClickListener(new View.OnClickListener(this) { // from class: fe0
                public final /* synthetic */ IOSLauncher h;

                {
                    this.h = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            this.h.lambda$showSuggestWallpaperChangeDialog$3(view);
                            break;
                        case 1:
                            this.h.lambda$showSuggestWallpaperChangeDialog$4(view);
                            break;
                        default:
                            this.h.lambda$showSuggestWallpaperChangeDialog$5(view);
                            break;
                    }
                }
            });
            final int i2 = 1;
            viewInflate.findViewById(v51.dialog_blur_effect_button_negative).setOnClickListener(new View.OnClickListener(this) { // from class: fe0
                public final /* synthetic */ IOSLauncher h;

                {
                    this.h = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            this.h.lambda$showSuggestWallpaperChangeDialog$3(view);
                            break;
                        case 1:
                            this.h.lambda$showSuggestWallpaperChangeDialog$4(view);
                            break;
                        default:
                            this.h.lambda$showSuggestWallpaperChangeDialog$5(view);
                            break;
                    }
                }
            });
            final int i3 = 2;
            viewInflate.findViewById(v51.dialog_blur_effect_button_positive).setOnClickListener(new View.OnClickListener(this) { // from class: fe0
                public final /* synthetic */ IOSLauncher h;

                {
                    this.h = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i3) {
                        case 0:
                            this.h.lambda$showSuggestWallpaperChangeDialog$3(view);
                            break;
                        case 1:
                            this.h.lambda$showSuggestWallpaperChangeDialog$4(view);
                            break;
                        default:
                            this.h.lambda$showSuggestWallpaperChangeDialog$5(view);
                            break;
                    }
                }
            });
            if (this.mDialogWarningWallpaper.getWindow() != null) {
                this.mDialogWarningWallpaper.getWindow().setDimAmount(0.2f);
            }
            this.mDialogWarningWallpaper.show();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRatingActivity() {
        try {
            Intent intent = new Intent(this, (Class<?>) RatingActivity.class);
            intent.setFlags(268435456);
            startActivity(intent);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zoomInLauncherView() {
        r00.b().e("OPEN_ANIM");
        ObjectAnimator objectAnimatorD = ik0.d(getDragLayer(), PropertyValuesHolder.ofFloat(Key.SCALE_X, 0.95f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 0.95f));
        objectAnimatorD.setStartDelay(0L);
        objectAnimatorD.setDuration(238L);
        objectAnimatorD.setInterpolator(new DecelerateInterpolator(0.8f));
        objectAnimatorD.start();
        objectAnimatorD.addListener(new be(this, 10));
    }

    @Override // com.luutinhit.launcher6.t, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (ar1.m) {
            getWindow().setExitTransition(null);
            getWindow().setEnterTransition(null);
            getWindow().setAllowReturnTransitionOverlap(false);
            getWindow().setAllowEnterTransitionOverlap(false);
            getWindow().setTransitionBackgroundFadeDuration(0L);
        }
        setLauncherCallbacks(new a(this));
        super.onCreate(bundle);
        this.mPowerManager = (PowerManager) getSystemService("power");
        this.mInputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (this.isHideNavigation) {
            hideNavigationNow();
        }
        float f = getResources().getDisplayMetrics().density;
        this.mMinFlingVelocity = (int) (250.0f * f);
        this.mMinSnapVelocity = (int) (f * 1500.0f);
    }

    @Override // com.luutinhit.launcher6.t, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            checkHideNavigation();
        }
    }

    @Override // com.luutinhit.launcher6.t
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void playOpenAnimation() {
        try {
            Hotseat hotseat = getHotseat();
            hotseat.animate().withLayer().translationY(0.0f).setInterpolator(new OvershootInterpolator(0.8f)).setDuration(866L).setListener(new be(hotseat, 9)).start();
            ArrayList<ng1> allShortcutAndWidgetContainers = getWorkspace().getAllShortcutAndWidgetContainers();
            int size = allShortcutAndWidgetContainers.size();
            int i = 0;
            while (i < size) {
                ng1 ng1Var = allShortcutAndWidgetContainers.get(i);
                i++;
                ng1 ng1Var2 = ng1Var;
                try {
                    if (ng1Var2.r) {
                        ng1Var2.f();
                    }
                } catch (Throwable unused) {
                    Iterator it = ng1Var2.y.keySet().iterator();
                    while (it.hasNext()) {
                        ((View) it.next()).setTranslationY(0.0f);
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            runOnUiThread(this.mRestorePosition);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void prepareOpenAnimation(boolean r4) {
        /*
            r3 = this;
            boolean r0 = defpackage.ar1.m     // Catch: java.lang.Throwable -> Ld
            if (r0 == 0) goto Lf
            android.os.PowerManager r0 = r3.mPowerManager     // Catch: java.lang.Throwable -> Ld
            boolean r0 = r0.isInteractive()     // Catch: java.lang.Throwable -> Ld
            if (r0 != 0) goto L18
            goto L1a
        Ld:
            r4 = move-exception
            goto L52
        Lf:
            android.os.PowerManager r0 = r3.mPowerManager     // Catch: java.lang.Throwable -> Ld
            boolean r0 = r0.isScreenOn()     // Catch: java.lang.Throwable -> Ld
            if (r0 != 0) goto L18
            goto L1a
        L18:
            if (r4 == 0) goto L55
        L1a:
            int r4 = r3.getCurrentWorkspaceScreen()     // Catch: java.lang.Throwable -> Ld
            if (r4 <= 0) goto L55
            com.luutinhit.launcher6.Workspace r0 = r3.getWorkspace()     // Catch: java.lang.Throwable -> Ld
            if (r0 == 0) goto L55
            com.luutinhit.launcher6.Workspace r0 = r3.getWorkspace()     // Catch: java.lang.Throwable -> Ld
            int r0 = r0.getPageCount()     // Catch: java.lang.Throwable -> Ld
            if (r4 >= r0) goto L55
            com.luutinhit.launcher6.Workspace r4 = r3.getWorkspace()     // Catch: java.lang.Throwable -> Ld
            com.luutinhit.launcher6.CellLayout r4 = r4.getCurrentCellLayout()     // Catch: java.lang.Throwable -> Ld
            ng1 r4 = r4.getShortcutsAndWidgets()     // Catch: java.lang.Throwable -> Ld
            r4.g()     // Catch: java.lang.Throwable -> Ld
            com.luutinhit.launcher6.Hotseat r4 = r3.getHotseat()     // Catch: java.lang.Throwable -> Ld
            r0 = 1
            r4.l = r0     // Catch: java.lang.Throwable -> Ld
            int r1 = r4.p     // Catch: java.lang.Throwable -> Ld
            int r2 = r4.q     // Catch: java.lang.Throwable -> Ld
            int r1 = r1 - r2
            float r1 = (float) r1     // Catch: java.lang.Throwable -> Ld
            r4.setTranslationY(r1)     // Catch: java.lang.Throwable -> Ld
            r3.mHasPrepareOpenAnimation = r0     // Catch: java.lang.Throwable -> Ld
            return
        L52:
            r4.getMessage()
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.ioslauncher.IOSLauncher.prepareOpenAnimation(boolean):void");
    }

    public void startPlayOpenAnimation() {
        if (this.mHasPrepareOpenAnimation) {
            if (ar1.m ? this.mPowerManager.isInteractive() : this.mPowerManager.isScreenOn()) {
                this.mHasPrepareOpenAnimation = false;
                playOpenAnimation();
            } else {
                getDragLayer().postDelayed(new de0(this, 0), 136L);
            }
            getDragLayer().removeCallbacks(this.mRestorePosition);
            getDragLayer().postOnAnimationDelayed(this.mRestorePosition, 1688L);
        }
    }
}
