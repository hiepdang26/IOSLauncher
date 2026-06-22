package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class q6 extends g6 implements et0, LayoutInflater.Factory2 {
    public static final ug1 e0 = new ug1(0);
    public static final int[] f0 = {R.attr.windowBackground};
    public static final boolean g0 = !"robolectric".equals(Build.FINGERPRINT);
    public static final boolean h0 = true;
    public TextView A;
    public View B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public p6[] K;
    public p6 L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public Configuration Q;
    public final int R;
    public int S;
    public boolean T;
    public boolean U;
    public l6 V;
    public l6 W;
    public boolean X;
    public int Y;
    public boolean a0;
    public Rect b0;
    public Rect c0;
    public t6 d0;
    public final Object i;
    public final Context j;
    public Window k;
    public k6 l;
    public final Object m;
    public ux1 n;
    public tk1 o;
    public CharSequence p;
    public DecorContentParent q;
    public ow1 r;
    public fz1 s;
    public j1 t;
    public ActionBarContextView u;
    public PopupWindow v;
    public h6 w;
    public boolean y;
    public ViewGroup z;
    public zt1 x = null;
    public final h6 Z = new h6(this, 0);

    public q6(Context context, Window window, f6 f6Var, Object obj) {
        e6 e6Var = null;
        this.R = -100;
        this.j = context;
        this.m = f6Var;
        this.i = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof e6)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        } else {
                            context = ((ContextWrapper) context).getBaseContext();
                        }
                    } else {
                        e6Var = (e6) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (e6Var != null) {
                this.R = ((q6) e6Var.n()).R;
            }
        }
        if (this.R == -100) {
            ug1 ug1Var = e0;
            Integer num = (Integer) ug1Var.get(this.i.getClass().getName());
            if (num != null) {
                this.R = num.intValue();
                ug1Var.remove(this.i.getClass().getName());
            }
        }
        if (window != null) {
            i(window);
        }
        AppCompatDrawableManager.preload();
    }

    public static Configuration m(Context context, int i, Configuration configuration) {
        int i2 = i != 1 ? i != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    @Override // defpackage.g6
    public final void a() {
        if (this.n != null) {
            t();
            this.n.getClass();
            u(0);
        }
    }

    @Override // defpackage.g6
    public final void b() {
        String strR;
        this.N = true;
        h(false);
        q();
        Object obj = this.i;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    strR = hg0.r(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
                strR = null;
            }
            if (strR != null) {
                ux1 ux1Var = this.n;
                if (ux1Var == null) {
                    this.a0 = true;
                } else {
                    ux1Var.H(true);
                }
            }
            synchronized (g6.h) {
                g6.d(this);
                g6.g.add(new WeakReference(this));
            }
        }
        this.Q = new Configuration(this.j.getResources().getConfiguration());
        this.O = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // defpackage.g6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.i
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = defpackage.g6.h
            monitor-enter(r0)
            defpackage.g6.d(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.X
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.k
            android.view.View r0 = r0.getDecorView()
            h6 r1 = r3.Z
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.P = r0
            int r0 = r3.R
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.i
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            ug1 r0 = defpackage.q6.e0
            java.lang.Object r1 = r3.i
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.R
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            ug1 r0 = defpackage.q6.e0
            java.lang.Object r1 = r3.i
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            l6 r0 = r3.V
            if (r0 == 0) goto L63
            r0.c()
        L63:
            l6 r0 = r3.W
            if (r0 == 0) goto L6a
            r0.c()
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q6.c():void");
    }

    @Override // defpackage.g6
    public final boolean e(int i) {
        if (i == 8) {
            i = 108;
        } else if (i == 9) {
            i = 109;
        }
        if (this.I && i == 108) {
            return false;
        }
        if (this.E && i == 1) {
            this.E = false;
        }
        if (i == 1) {
            z();
            this.I = true;
            return true;
        }
        if (i == 2) {
            z();
            this.C = true;
            return true;
        }
        if (i == 5) {
            z();
            this.D = true;
            return true;
        }
        if (i == 10) {
            z();
            this.G = true;
            return true;
        }
        if (i == 108) {
            z();
            this.E = true;
            return true;
        }
        if (i != 109) {
            return this.k.requestFeature(i);
        }
        z();
        this.F = true;
        return true;
    }

    @Override // defpackage.g6
    public final void f(int i) {
        p();
        ViewGroup viewGroup = (ViewGroup) this.z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.j).inflate(i, viewGroup);
        this.l.g.onContentChanged();
    }

    @Override // defpackage.g6
    public final void g(CharSequence charSequence) {
        this.p = charSequence;
        DecorContentParent decorContentParent = this.q;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        ux1 ux1Var = this.n;
        if (ux1Var != null) {
            ux1Var.z.setWindowTitle(charSequence);
            return;
        }
        TextView textView = this.A;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean h(boolean z) {
        boolean z2;
        Object obj;
        boolean z3 = false;
        if (this.P) {
            return false;
        }
        int i = this.R;
        if (i == -100) {
            i = -100;
        }
        Context context = this.j;
        Map map = null;
        obj = null;
        obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Configuration configurationM = m(context, v(context, i), null);
        boolean z4 = this.U;
        Object obj4 = this.i;
        boolean z5 = true;
        if (z4 || !(obj4 instanceof Activity)) {
            this.U = true;
            z2 = this.T;
        } else {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                z2 = false;
            } else {
                try {
                    int i2 = Build.VERSION.SDK_INT;
                    ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, obj4.getClass()), i2 >= 29 ? 269221888 : i2 >= 24 ? 786432 : 0);
                    this.T = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
                } catch (PackageManager.NameNotFoundException unused) {
                    this.T = false;
                }
                this.U = true;
                z2 = this.T;
            }
        }
        Configuration configuration = this.Q;
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int i3 = configuration.uiMode & 48;
        int i4 = configurationM.uiMode & 48;
        if (i3 != i4 && z && !z2 && this.N && ((g0 || this.O) && (obj4 instanceof Activity))) {
            Activity activity = (Activity) obj4;
            if (!activity.isChild()) {
                if (Build.VERSION.SDK_INT >= 28) {
                    activity.recreate();
                } else {
                    new Handler(activity.getMainLooper()).post(new r1(activity, 0));
                }
                z3 = true;
            }
        }
        if (z3 || i3 == i4) {
            z5 = z3;
        } else {
            Resources resources = context.getResources();
            Configuration configuration2 = new Configuration(resources.getConfiguration());
            configuration2.uiMode = i4 | (resources.getConfiguration().uiMode & (-49));
            resources.updateConfiguration(configuration2, null);
            int i5 = Build.VERSION.SDK_INT;
            if (i5 < 26 && i5 < 28) {
                if (i5 >= 24) {
                    if (!bf1.t) {
                        try {
                            Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                            bf1.s = declaredField;
                            declaredField.setAccessible(true);
                        } catch (NoSuchFieldException unused2) {
                        }
                        bf1.t = true;
                    }
                    Field field = bf1.s;
                    if (field != null) {
                        try {
                            obj = field.get(resources);
                        } catch (IllegalAccessException unused3) {
                            obj = null;
                        }
                        if (obj != null) {
                            if (!bf1.n) {
                                try {
                                    Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                                    bf1.m = declaredField2;
                                    declaredField2.setAccessible(true);
                                } catch (NoSuchFieldException unused4) {
                                }
                                bf1.n = true;
                            }
                            Field field2 = bf1.m;
                            if (field2 != null) {
                                try {
                                    obj2 = field2.get(obj);
                                } catch (IllegalAccessException unused5) {
                                }
                            }
                            if (obj2 != null) {
                                bf1.d(obj2);
                            }
                        }
                    }
                } else if (i5 >= 23) {
                    if (!bf1.n) {
                        try {
                            Field declaredField3 = Resources.class.getDeclaredField("mDrawableCache");
                            bf1.m = declaredField3;
                            declaredField3.setAccessible(true);
                        } catch (NoSuchFieldException unused6) {
                        }
                        bf1.n = true;
                    }
                    Field field3 = bf1.m;
                    if (field3 != null) {
                        try {
                            obj3 = field3.get(resources);
                        } catch (IllegalAccessException unused7) {
                        }
                    }
                    if (obj3 != null) {
                        bf1.d(obj3);
                    }
                } else {
                    if (!bf1.n) {
                        try {
                            Field declaredField4 = Resources.class.getDeclaredField("mDrawableCache");
                            bf1.m = declaredField4;
                            declaredField4.setAccessible(true);
                        } catch (NoSuchFieldException unused8) {
                        }
                        bf1.n = true;
                    }
                    Field field4 = bf1.m;
                    if (field4 != null) {
                        try {
                            map = (Map) field4.get(resources);
                        } catch (IllegalAccessException unused9) {
                        }
                        if (map != null) {
                            map.clear();
                        }
                    }
                }
            }
            int i6 = this.S;
            if (i6 != 0) {
                context.setTheme(i6);
                if (Build.VERSION.SDK_INT >= 23) {
                    context.getTheme().applyStyle(this.S, true);
                }
            }
            if (z2 && (obj4 instanceof Activity)) {
                Activity activity2 = (Activity) obj4;
                if (activity2 instanceof en0) {
                    if (((en0) activity2).l().c.compareTo(vm0.i) >= 0) {
                        activity2.onConfigurationChanged(configuration2);
                    }
                } else if (this.O && !this.P) {
                    activity2.onConfigurationChanged(configuration2);
                }
            }
        }
        if (z5 && (obj4 instanceof e6)) {
        }
        if (i == 0) {
            r(context).i();
        } else {
            l6 l6Var = this.V;
            if (l6Var != null) {
                l6Var.c();
            }
        }
        if (i == 3) {
            if (this.W == null) {
                this.W = new l6(this, context);
            }
            this.W.i();
        } else {
            l6 l6Var2 = this.W;
            if (l6Var2 != null) {
                l6Var2.c();
            }
        }
        return z5;
    }

    public final void i(Window window) {
        if (this.k != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof k6) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        k6 k6Var = new k6(this, callback);
        this.l = k6Var;
        window.setCallback(k6Var);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.j, (AttributeSet) null, f0);
        Drawable drawableIfKnown = tintTypedArrayObtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            window.setBackgroundDrawable(drawableIfKnown);
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        this.k = window;
    }

    public final void j(int i, p6 p6Var, gt0 gt0Var) {
        if (gt0Var == null) {
            if (p6Var == null && i >= 0) {
                p6[] p6VarArr = this.K;
                if (i < p6VarArr.length) {
                    p6Var = p6VarArr[i];
                }
            }
            if (p6Var != null) {
                gt0Var = p6Var.h;
            }
        }
        if ((p6Var == null || p6Var.m) && !this.P) {
            this.l.g.onPanelClosed(i, gt0Var);
        }
    }

    public final void k(gt0 gt0Var) {
        if (this.J) {
            return;
        }
        this.J = true;
        this.q.dismissPopups();
        Window.Callback callback = this.k.getCallback();
        if (callback != null && !this.P) {
            callback.onPanelClosed(108, gt0Var);
        }
        this.J = false;
    }

    public final void l(p6 p6Var, boolean z) {
        o6 o6Var;
        DecorContentParent decorContentParent;
        if (z && p6Var.a == 0 && (decorContentParent = this.q) != null && decorContentParent.isOverflowMenuShowing()) {
            k(p6Var.h);
            return;
        }
        WindowManager windowManager = (WindowManager) this.j.getSystemService("window");
        if (windowManager != null && p6Var.m && (o6Var = p6Var.e) != null) {
            windowManager.removeView(o6Var);
            if (z) {
                j(p6Var.a, p6Var, null);
            }
        }
        p6Var.k = false;
        p6Var.l = false;
        p6Var.m = false;
        p6Var.f = null;
        p6Var.n = true;
        if (this.L == p6Var) {
            this.L = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0116 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q6.n(android.view.KeyEvent):boolean");
    }

    public final void o(int i) {
        p6 p6VarS = s(i);
        if (p6VarS.h != null) {
            Bundle bundle = new Bundle();
            p6VarS.h.t(bundle);
            if (bundle.size() > 0) {
                p6VarS.p = bundle;
            }
            p6VarS.h.w();
            p6VarS.h.clear();
        }
        p6VarS.o = true;
        p6VarS.n = true;
        if ((i == 108 || i == 0) && this.q != null) {
            p6 p6VarS2 = s(0);
            p6VarS2.k = false;
            y(p6VarS2, null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onCreateView(android.view.View r18, java.lang.String r19, android.content.Context r20, android.util.AttributeSet r21) {
        /*
            Method dump skipped, instruction units count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q6.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    @Override // defpackage.et0
    public final boolean onMenuItemSelected(gt0 gt0Var, MenuItem menuItem) {
        p6 p6Var;
        Window.Callback callback = this.k.getCallback();
        if (callback != null && !this.P) {
            gt0 gt0VarK = gt0Var.k();
            p6[] p6VarArr = this.K;
            int length = p6VarArr != null ? p6VarArr.length : 0;
            int i = 0;
            while (true) {
                if (i < length) {
                    p6Var = p6VarArr[i];
                    if (p6Var != null && p6Var.h == gt0VarK) {
                        break;
                    }
                    i++;
                } else {
                    p6Var = null;
                    break;
                }
            }
            if (p6Var != null) {
                return callback.onMenuItemSelected(p6Var.a, menuItem);
            }
        }
        return false;
    }

    @Override // defpackage.et0
    public final void onMenuModeChange(gt0 gt0Var) {
        DecorContentParent decorContentParent = this.q;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (ViewConfiguration.get(this.j).hasPermanentMenuKey() && !this.q.isOverflowMenuShowPending())) {
            p6 p6VarS = s(0);
            p6VarS.n = true;
            l(p6VarS, false);
            w(p6VarS, null);
            return;
        }
        Window.Callback callback = this.k.getCallback();
        if (this.q.isOverflowMenuShowing()) {
            this.q.hideOverflowMenu();
            if (this.P) {
                return;
            }
            callback.onPanelClosed(108, s(0).h);
            return;
        }
        if (callback == null || this.P) {
            return;
        }
        if (this.X && (1 & this.Y) != 0) {
            View decorView = this.k.getDecorView();
            h6 h6Var = this.Z;
            decorView.removeCallbacks(h6Var);
            h6Var.run();
        }
        p6 p6VarS2 = s(0);
        gt0 gt0Var2 = p6VarS2.h;
        if (gt0Var2 == null || p6VarS2.o || !callback.onPreparePanel(0, p6VarS2.g, gt0Var2)) {
            return;
        }
        callback.onMenuOpened(108, p6VarS2.h);
        this.q.showOverflowMenu();
    }

    public final void p() {
        ViewGroup viewGroup;
        if (this.y) {
            return;
        }
        int[] iArr = q71.AppCompatTheme;
        Context context = this.j;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(q71.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(q71.AppCompatTheme_windowNoTitle, false)) {
            e(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(q71.AppCompatTheme_windowActionBar, false)) {
            e(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(q71.AppCompatTheme_windowActionBarOverlay, false)) {
            e(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(q71.AppCompatTheme_windowActionModeOverlay, false)) {
            e(10);
        }
        this.H = typedArrayObtainStyledAttributes.getBoolean(q71.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        q();
        this.k.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.I) {
            viewGroup = this.G ? (ViewGroup) layoutInflaterFrom.inflate(n61.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(n61.abc_screen_simple, (ViewGroup) null);
        } else if (this.H) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(n61.abc_dialog_title_material, (ViewGroup) null);
            this.F = false;
            this.E = false;
        } else if (this.E) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(r41.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new co(context, typedValue.resourceId) : context).inflate(n61.abc_screen_toolbar, (ViewGroup) null);
            DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(w51.decor_content_parent);
            this.q = decorContentParent;
            decorContentParent.setWindowCallback(this.k.getCallback());
            if (this.F) {
                this.q.initFeature(109);
            }
            if (this.C) {
                this.q.initFeature(2);
            }
            if (this.D) {
                this.q.initFeature(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.E + ", windowActionBarOverlay: " + this.F + ", android:windowIsFloating: " + this.H + ", windowActionModeOverlay: " + this.G + ", windowNoTitle: " + this.I + " }");
        }
        nx0 nx0Var = new nx0(this, 3);
        WeakHashMap weakHashMap = qs1.a;
        hs1.m(viewGroup, nx0Var);
        if (this.q == null) {
            this.A = (TextView) viewGroup.findViewById(w51.title);
        }
        ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(w51.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.k.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.k.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new i6(this));
        this.z = viewGroup;
        Object obj = this.i;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.p;
        if (!TextUtils.isEmpty(title)) {
            DecorContentParent decorContentParent2 = this.q;
            if (decorContentParent2 != null) {
                decorContentParent2.setWindowTitle(title);
            } else {
                ux1 ux1Var = this.n;
                if (ux1Var != null) {
                    ux1Var.z.setWindowTitle(title);
                } else {
                    TextView textView = this.A;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.z.findViewById(R.id.content);
        View decorView = this.k.getDecorView();
        contentFrameLayout2.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(q71.AppCompatTheme);
        typedArrayObtainStyledAttributes2.getValue(q71.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(q71.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(q71.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes2.getValue(q71.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(q71.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes2.getValue(q71.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(q71.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes2.getValue(q71.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(q71.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes2.getValue(q71.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.y = true;
        p6 p6VarS = s(0);
        if (this.P || p6VarS.h != null) {
            return;
        }
        u(108);
    }

    public final void q() {
        if (this.k == null) {
            Object obj = this.i;
            if (obj instanceof Activity) {
                i(((Activity) obj).getWindow());
            }
        }
        if (this.k == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final n6 r(Context context) {
        if (this.V == null) {
            if (wb2.l == null) {
                Context applicationContext = context.getApplicationContext();
                wb2.l = new wb2(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.V = new l6(this, wb2.l);
        }
        return this.V;
    }

    public final p6 s(int i) {
        p6[] p6VarArr = this.K;
        if (p6VarArr == null || p6VarArr.length <= i) {
            p6[] p6VarArr2 = new p6[i + 1];
            if (p6VarArr != null) {
                System.arraycopy(p6VarArr, 0, p6VarArr2, 0, p6VarArr.length);
            }
            this.K = p6VarArr2;
            p6VarArr = p6VarArr2;
        }
        p6 p6Var = p6VarArr[i];
        if (p6Var != null) {
            return p6Var;
        }
        p6 p6Var2 = new p6();
        p6Var2.a = i;
        p6Var2.n = false;
        p6VarArr[i] = p6Var2;
        return p6Var2;
    }

    public final void t() {
        p();
        if (this.E && this.n == null) {
            Object obj = this.i;
            if (obj instanceof Activity) {
                this.n = new ux1(this.F, (Activity) obj);
            } else if (obj instanceof Dialog) {
                this.n = new ux1((Dialog) obj);
            }
            ux1 ux1Var = this.n;
            if (ux1Var != null) {
                ux1Var.H(this.a0);
            }
        }
    }

    public final void u(int i) {
        this.Y = (1 << i) | this.Y;
        if (this.X) {
            return;
        }
        View decorView = this.k.getDecorView();
        h6 h6Var = this.Z;
        WeakHashMap weakHashMap = qs1.a;
        decorView.postOnAnimation(h6Var);
        this.X = true;
    }

    public final int v(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                        }
                        if (this.W == null) {
                            this.W = new l6(this, context);
                        }
                        return this.W.f();
                    }
                } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return r(context).f();
                }
            }
            return i;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0171, code lost:
    
        if (r15.m.getCount() > 0) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(defpackage.p6 r14, android.view.KeyEvent r15) {
        /*
            Method dump skipped, instruction units count: 463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q6.w(p6, android.view.KeyEvent):void");
    }

    public final boolean x(p6 p6Var, int i, KeyEvent keyEvent) {
        gt0 gt0Var;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((p6Var.k || y(p6Var, keyEvent)) && (gt0Var = p6Var.h) != null) {
            return gt0Var.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean y(defpackage.p6 r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instruction units count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q6.y(p6, android.view.KeyEvent):boolean");
    }

    public final void z() {
        if (this.y) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
