package defpackage;

import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.luutinhit.launcher6.ExtendedEditText;
import com.luutinhit.launcher6.LauncherRootView;
import com.luutinhit.launcher6.appslibrary.AppsLibraryItemFull;
import com.luutinhit.launcher6.appslibrary.IndexBarView;
import com.luutinhit.launcher6.editscreen.CustomViewRound;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.recyclerviewbouncy.BouncyRecyclerView;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class l8 extends MotionLayout implements MotionLayout.TransitionListener, se1, ed {
    public final t g;
    public final BouncyRecyclerView h;
    public final BouncyRecyclerView i;
    public final u7 j;
    public final IndexBarView k;
    public final ArrayList l;
    public final FrameLayout m;
    public final RealTimeBlurView n;
    public final CustomViewRound o;
    public final h90 p;
    public final ExtendedEditText q;
    public boolean r;
    public final int s;
    public q8 t;
    public final wb2 u;
    public final InputMethodManager v;
    public final PathInterpolator w;
    public final Handler x;
    public final ow1 y;

    public l8(IOSLauncher iOSLauncher) {
        super(iOSLauncher, null, 0);
        this.l = new ArrayList();
        this.r = false;
        this.w = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
        this.x = new Handler(Looper.getMainLooper(), new h8(this, 0));
        this.y = new ow1(this, 4);
        j8 j8Var = new j8(this, 0);
        LayoutInflater.from(iOSLauncher).inflate(m61.apps_libray_layout, (ViewGroup) this, true);
        this.g = iOSLauncher;
        setX(0.0f);
        setY(0.0f);
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        setPadding(0, 0, 0, 0);
        int i = this.g.getDeviceProfile().C;
        this.s = i;
        CustomViewRound customViewRound = (CustomViewRound) findViewById(v51.search_box_apps_library);
        this.o = customViewRound;
        BouncyRecyclerView bouncyRecyclerView = (BouncyRecyclerView) findViewById(v51.list_apps_library);
        this.h = bouncyRecyclerView;
        this.j = new u7(0);
        FrameLayout frameLayout = (FrameLayout) findViewById(v51.layout_list_apps_library);
        this.m = frameLayout;
        RealTimeBlurView realTimeBlurView = (RealTimeBlurView) findViewById(v51.realtime_blur_search_box);
        this.n = realTimeBlurView;
        ExtendedEditText extendedEditText = (ExtendedEditText) findViewById(v51.et_search);
        this.q = extendedEditText;
        BouncyRecyclerView bouncyRecyclerView2 = (BouncyRecyclerView) findViewById(v51.apps_library_search_view);
        this.i = bouncyRecyclerView2;
        this.k = (IndexBarView) findViewById(v51.index_bar_view);
        bouncyRecyclerView.setLayoutManager(new GridLayoutManager(2));
        Resources resources = getResources();
        ta0 ta0Var = new ta0();
        ta0Var.i = resources;
        ta0Var.h = (i * 3) / 2;
        bouncyRecyclerView.k(ta0Var);
        bouncyRecyclerView2.setLayoutManager(new LinearLayoutManager(1));
        frameLayout.setX(0.0f);
        frameLayout.setY(0.0f);
        frameLayout.setTranslationX(0.0f);
        frameLayout.setTranslationY(0.0f);
        frameLayout.setPadding(0, 0, 0, 0);
        nm nmVar = (nm) frameLayout.getLayoutParams();
        t tVar = this.g;
        ((ViewGroup.MarginLayoutParams) nmVar).height = tVar.screenHeight;
        int i2 = i * 2;
        nm nmVar2 = (nm) customViewRound.getLayoutParams();
        xu xuVar = tVar.mDeviceProfile;
        int i3 = ((xuVar.i + xuVar.I) - xuVar.D) - xuVar.F;
        nmVar2.setMargins(i2, i3, i2, 0);
        customViewRound.setLayoutParams(nmVar2);
        int i4 = i3 + ((ViewGroup.MarginLayoutParams) nmVar2).height + i2;
        int paddingBottom = bouncyRecyclerView.getPaddingBottom();
        bouncyRecyclerView.setPadding(i2, i4, i2, paddingBottom);
        bouncyRecyclerView2.setPadding(i2, i4, i2, paddingBottom);
        ((ViewGroup.MarginLayoutParams) ((nm) realTimeBlurView.getLayoutParams())).height = i4 - 8;
        if (tVar.isUseLiquidGlass && tVar.isRuntimeRenderSupport && this.p == null) {
            setLayerType(2, null);
            h90 h90Var = new h90(tVar, false);
            this.p = h90Var;
            h90Var.setLayerType(2, null);
            this.p.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 81));
            this.p.setCornerRadiusPercent(0.5f);
            customViewRound.m = false;
            customViewRound.addView(this.p, 0);
        }
        setDarkMode(this.g.isDarkMode);
        if (ar1.m) {
            extendedEditText.setShowSoftInputOnFocus(false);
        } else {
            extendedEditText.setTextIsSelectable(true);
        }
        extendedEditText.setOnTouchListener(new g8(this, 0));
        customViewRound.setOnClickListener(new g7(this, 2));
        extendedEditText.addTextChangedListener(j8Var);
        setTransitionListener(this);
        this.u = new wb2(iOSLauncher, 2);
        this.v = (InputMethodManager) iOSLauncher.getSystemService("input_method");
        realTimeBlurView.setBlurredView(frameLayout);
        bouncyRecyclerView.setOnOverScrollListener(new o5(this, 1));
        t tVar2 = this.g;
        if (tVar2.isUseLiquidGlass) {
            tVar2.getBlurWallpaperProvider().b(this);
            o();
        }
    }

    @Override // defpackage.ed
    public final void a() {
        post(new r1(this, 3));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        BouncyRecyclerView bouncyRecyclerView;
        Objects.toString(keyEvent);
        if (keyEvent == null || keyEvent.getKeyCode() != 4 || (bouncyRecyclerView = this.i) == null || bouncyRecyclerView.getVisibility() != 0) {
            return super.dispatchKeyEventPreIme(keyEvent);
        }
        transitionToStart();
        return true;
    }

    public xj0 getCallBack() {
        return this.y;
    }

    @Override // defpackage.se1
    public final void h(View view) {
        try {
            this.g.startAppShortcutOrInfoActivity(view);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void l() {
        e8 e8Var;
        t tVar = this.g;
        if (tVar == null || tVar.getLauncherView() == null || (e8Var = (e8) tVar.getLauncherView().findViewById(v51.apps_library_folder_expand)) == null) {
            return;
        }
        t tVar2 = e8Var.k;
        tVar2.appsLibraryLayout.setAlpha(1.0f);
        tVar2.appsLibraryLayout.setScaleX(1.0f);
        tVar2.appsLibraryLayout.setScaleY(1.0f);
        LauncherRootView launcherRootView = (LauncherRootView) e8Var.getParent();
        if (launcherRootView != null) {
            launcherRootView.removeView(e8Var);
        }
    }

    public final int n(v6 v6Var) {
        int iG;
        int iG2;
        int iG3;
        int iG4;
        int iG5;
        int iG6;
        int iG7;
        t tVar = this.g;
        ComponentName componentName = v6Var.A;
        ApplicationInfo applicationInfo = v6Var.B;
        if (applicationInfo != null) {
            boolean z = false;
            try {
                iG7 = tVar.getIconCache().g(componentName);
                if (iG7 == 0 && (!ar1.d ? (applicationInfo.flags & 33554432) == 33554432 : applicationInfo.category == 0)) {
                    iG7 = 1;
                }
            } catch (Throwable unused) {
            }
            boolean z2 = iG7 == 1;
            if (z2) {
                tVar.getModel().v(1, componentName.flattenToString());
                return 1;
            }
            try {
                iG6 = tVar.getIconCache().g(componentName);
                if (iG6 == 0 && ar1.d) {
                    if (applicationInfo.category == 1) {
                        iG6 = 2;
                    }
                }
            } catch (Throwable unused2) {
            }
            boolean z3 = iG6 == 2;
            if (z3) {
                tVar.getModel().v(2, componentName.flattenToString());
                return 2;
            }
            try {
                iG5 = tVar.getIconCache().g(componentName);
                if (iG5 == 0 && ar1.d) {
                    if (applicationInfo.category == 2) {
                        iG5 = 3;
                    }
                }
            } catch (Throwable unused3) {
            }
            boolean z4 = iG5 == 3;
            if (z4) {
                tVar.getModel().v(3, componentName.flattenToString());
                return 3;
            }
            try {
                iG4 = tVar.getIconCache().g(componentName);
                if (iG4 == 0 && ar1.d) {
                    if (applicationInfo.category == 3) {
                        iG4 = 4;
                    }
                }
            } catch (Throwable unused4) {
            }
            boolean z5 = iG4 == 4;
            if (z5) {
                tVar.getModel().v(4, componentName.flattenToString());
                return 4;
            }
            try {
                iG3 = tVar.getIconCache().g(componentName);
                if (iG3 == 0 && ar1.d) {
                    if (applicationInfo.category == 4) {
                        iG3 = 5;
                    }
                }
            } catch (Throwable unused5) {
            }
            boolean z6 = iG3 == 5;
            if (z6) {
                tVar.getModel().v(5, componentName.flattenToString());
                return 5;
            }
            try {
                iG2 = tVar.getIconCache().g(componentName);
                if (iG2 == 0 && ar1.d) {
                    if (applicationInfo.category == 5) {
                        iG2 = 6;
                    }
                }
            } catch (Throwable unused6) {
            }
            boolean z7 = iG2 == 6;
            if (z7) {
                tVar.getModel().v(6, componentName.flattenToString());
                return 6;
            }
            try {
                iG = tVar.getIconCache().g(componentName);
                if (iG == 0 && ar1.d) {
                    if (applicationInfo.category == 6) {
                        iG = 7;
                    }
                }
            } catch (Throwable unused7) {
            }
            boolean z8 = iG == 7;
            if (z8) {
                tVar.getModel().v(7, componentName.flattenToString());
                return 7;
            }
            try {
                int iG8 = tVar.getIconCache().g(componentName);
                if (iG8 == 0 && ar1.d) {
                    if (applicationInfo.category == 7) {
                        iG8 = 8;
                    }
                }
                if (iG8 == 8) {
                    z = true;
                }
            } catch (Throwable unused8) {
            }
            if (z) {
                tVar.getModel().v(8, componentName.flattenToString());
                return 8;
            }
            tVar.getModel().v(9, componentName.flattenToString());
        }
        return 9;
    }

    public final void o() {
        t tVar = this.g;
        if (tVar.isUseLiquidGlass) {
            if (!tVar.isRuntimeRenderSupport) {
                c90 c90VarC = c90.c(tVar);
                Bitmap bitmap = tVar.getBlurWallpaperProvider().e;
                c90VarC.getClass();
                if (bitmap != null && !bitmap.isRecycled()) {
                    c90VarC.e(new a90(c90VarC, bitmap, 1));
                }
                c90.c(tVar).f(l51.lib);
                return;
            }
            int i = 0;
            while (true) {
                BouncyRecyclerView bouncyRecyclerView = this.h;
                if (i >= bouncyRecyclerView.getChildCount()) {
                    break;
                }
                AppsLibraryItemFull appsLibraryItemFull = (AppsLibraryItemFull) bouncyRecyclerView.getChildAt(i);
                Bitmap bitmap2 = tVar.getBlurWallpaperProvider().e;
                h90 h90Var = appsLibraryItemFull.p;
                if (h90Var != null) {
                    h90Var.setFullBitmap(bitmap2);
                }
                i++;
            }
            h90 h90Var2 = this.p;
            if (h90Var2 != null) {
                h90Var2.setFullBitmap(tVar.getBlurWallpaperProvider().e);
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            loadLayoutDescription(r71.apps_library_layout_scene);
            en constraintSet = getConstraintSet(v51.apps_library_end);
            xu xuVar = this.g.mDeviceProfile;
            int i = ((xuVar.i + xuVar.I) - xuVar.D) - xuVar.F;
            int i2 = this.s * 2;
            constraintSet.s(v51.search_box_apps_library, 3, i);
            constraintSet.s(v51.search_box_apps_library, 6, i2);
            constraintSet.s(v51.search_box_apps_library, 7, i2);
            updateState(v51.apps_library_end, constraintSet);
        } catch (Throwable unused) {
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) throws Throwable {
        super.onLayout(z, i, i2, i3, i4);
        h90 h90Var = this.p;
        if (h90Var != null) {
            h90Var.g();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public final void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f) {
        int i3 = v51.apps_library_start;
        BouncyRecyclerView bouncyRecyclerView = this.i;
        BouncyRecyclerView bouncyRecyclerView2 = this.h;
        if (i2 == i3) {
            bouncyRecyclerView2.setAlpha(f);
            bouncyRecyclerView.setAlpha(1.0f - f);
        } else if (i2 == v51.apps_library_end) {
            bouncyRecyclerView2.setAlpha(1.0f - f);
            bouncyRecyclerView.setAlpha(f);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public final void onTransitionCompleted(MotionLayout motionLayout, int i) {
        int i2 = v51.apps_library_end;
        InputMethodManager inputMethodManager = this.v;
        ExtendedEditText extendedEditText = this.q;
        if (i == i2) {
            this.r = true;
            extendedEditText.requestFocus();
            if (extendedEditText != null) {
                extendedEditText.requestFocus();
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(extendedEditText, 0);
                    return;
                }
                return;
            }
            return;
        }
        if (i == v51.apps_library_start) {
            this.k.setVisibility(8);
            BouncyRecyclerView bouncyRecyclerView = this.i;
            bouncyRecyclerView.setVisibility(8);
            bouncyRecyclerView.setAlpha(0.0f);
            this.r = false;
            extendedEditText.setText("");
            extendedEditText.clearFocus();
            if (extendedEditText == null || inputMethodManager == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(extendedEditText.getWindowToken(), 0);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public final void onTransitionStarted(MotionLayout motionLayout, int i, int i2) {
        if (i2 == v51.apps_library_end) {
            this.i.setVisibility(0);
            this.k.setVisibility(0);
        }
    }

    public void setApps(ArrayList<v6> arrayList) {
        try {
            new ur0(new f8(this, arrayList, 0)).B(ee1.a).z(new vr0(new fz1(this, 3), x4.a(), 0));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            hg0.C(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public void setDarkMode(boolean z) {
        this.o.setDarkModeTransparentBackground(z);
    }

    @Override // defpackage.ed
    public final void g() {
    }

    public void setUseTransparency(boolean z) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public final void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f) {
    }
}
