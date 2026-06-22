package defpackage;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.appcompat.widget.ActivityChooserView;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public abstract class az1 {
    public static final dx a = new dx(9);
    public static final boolean[] b = new boolean[3];
    public static final byte[] c = new byte[0];
    public static Method d;
    public static boolean e;
    public static Method f;
    public static boolean g;

    public az1() {
        new ConcurrentHashMap();
    }

    public static int A(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.right;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.bottom;
        } else if (i == 66) {
            i2 = rect2.left;
            i3 = rect.right;
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i2 = rect2.top;
            i3 = rect.bottom;
        }
        return Math.max(0, i2 - i3);
    }

    public static int C(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static yo E(yo yoVar, yo yoVar2) {
        qg0.l(yoVar2, "context");
        return yoVar2 == sz.g ? yoVar : (yo) yoVar2.h(yoVar, new mk(1));
    }

    public static void F(ImageView imageView, ColorStateList colorStateList) {
        Drawable drawable;
        int i = Build.VERSION.SDK_INT;
        imageView.setImageTintList(colorStateList);
        if (i != 21 || (drawable = imageView.getDrawable()) == null || imageView.getImageTintList() == null) {
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(imageView.getDrawableState());
        }
        imageView.setImageDrawable(drawable);
    }

    public static boolean G(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return t1.r(drawable, i);
        }
        if (!e) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            e = true;
        }
        Method method = d;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i));
                return true;
            } catch (Exception unused2) {
                d = null;
            }
        }
        return false;
    }

    public static void H(View view, rr0 rr0Var) {
        ty tyVar = rr0Var.g.b;
        if (tyVar == null || !tyVar.a) {
            return;
        }
        float fE = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            WeakHashMap weakHashMap = qs1.a;
            fE += hs1.e((View) parent);
        }
        qr0 qr0Var = rr0Var.g;
        if (qr0Var.l != fE) {
            qr0Var.l = fE;
            rr0Var.n();
        }
    }

    public static void I(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void J(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void K(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }

    public static Drawable L(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 || (drawable instanceof zn1)) {
            return drawable;
        }
        h02 h02Var = new h02();
        h02Var.j = h02Var.b();
        h02Var.g(drawable);
        if (h02.n == null) {
            try {
                h02.n = Drawable.class.getDeclaredMethod("isProjected", null);
            } catch (Exception unused) {
            }
        }
        return h02Var;
    }

    public static String M(Context context) {
        try {
            return context.getResources().getResourcePackageName(u61.common_google_play_services_unknown_issue);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(int r8, android.graphics.Rect r9, android.graphics.Rect r10, android.graphics.Rect r11) {
        /*
            boolean r0 = b(r8, r9, r10)
            boolean r1 = b(r8, r9, r11)
            if (r1 != 0) goto L75
            if (r0 != 0) goto Le
            goto L75
        Le:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r2 = 33
            r3 = 66
            r4 = 17
            r5 = 1
            if (r8 == r4) goto L3c
            if (r8 == r2) goto L35
            if (r8 == r3) goto L2e
            if (r8 != r1) goto L28
            int r6 = r9.bottom
            int r7 = r11.top
            if (r6 > r7) goto L74
            goto L42
        L28:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r0)
            throw r8
        L2e:
            int r6 = r9.right
            int r7 = r11.left
            if (r6 > r7) goto L74
            goto L42
        L35:
            int r6 = r9.top
            int r7 = r11.bottom
            if (r6 < r7) goto L74
            goto L42
        L3c:
            int r6 = r9.left
            int r7 = r11.right
            if (r6 < r7) goto L74
        L42:
            if (r8 == r4) goto L74
            if (r8 != r3) goto L47
            goto L74
        L47:
            int r10 = A(r8, r9, r10)
            if (r8 == r4) goto L69
            if (r8 == r2) goto L64
            if (r8 == r3) goto L5f
            if (r8 != r1) goto L59
            int r8 = r11.bottom
            int r9 = r9.bottom
        L57:
            int r8 = r8 - r9
            goto L6e
        L59:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r0)
            throw r8
        L5f:
            int r8 = r11.right
            int r9 = r9.right
            goto L57
        L64:
            int r8 = r9.top
            int r9 = r11.top
            goto L57
        L69:
            int r8 = r9.left
            int r9 = r11.left
            goto L57
        L6e:
            int r8 = java.lang.Math.max(r5, r8)
            if (r10 >= r8) goto L75
        L74:
            return r5
        L75:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.az1.a(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean b(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static void c(kn knVar, qn0 qn0Var, jn jnVar) {
        jnVar.o = -1;
        jnVar.p = -1;
        in inVar = knVar.T[0];
        in inVar2 = in.h;
        in inVar3 = in.j;
        if (inVar != inVar2 && jnVar.T[0] == inVar3) {
            gm gmVar = jnVar.I;
            int i = gmVar.g;
            int iR = knVar.r();
            gm gmVar2 = jnVar.K;
            int i2 = iR - gmVar2.g;
            gmVar.i = qn0Var.k(gmVar);
            gmVar2.i = qn0Var.k(gmVar2);
            qn0Var.d(gmVar.i, i);
            qn0Var.d(gmVar2.i, i2);
            jnVar.o = 2;
            jnVar.Z = i;
            int i3 = i2 - i;
            jnVar.V = i3;
            int i4 = jnVar.c0;
            if (i3 < i4) {
                jnVar.V = i4;
            }
        }
        if (knVar.T[1] == inVar2 || jnVar.T[1] != inVar3) {
            return;
        }
        gm gmVar3 = jnVar.J;
        int i5 = gmVar3.g;
        int iL = knVar.l();
        gm gmVar4 = jnVar.L;
        int i6 = iL - gmVar4.g;
        gmVar3.i = qn0Var.k(gmVar3);
        gmVar4.i = qn0Var.k(gmVar4);
        qn0Var.d(gmVar3.i, i5);
        qn0Var.d(gmVar4.i, i6);
        if (jnVar.b0 > 0 || jnVar.h0 == 8) {
            gm gmVar5 = jnVar.M;
            gmVar5.i = qn0Var.k(gmVar5);
            qn0Var.d(gmVar5.i, jnVar.b0 + i5);
        }
        jnVar.p = 2;
        jnVar.a0 = i5;
        int i7 = i6 - i5;
        jnVar.W = i7;
        int i8 = jnVar.d0;
        if (i7 < i8) {
            jnVar.W = i8;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            d(((InsetDrawable) drawable).getDrawable());
            return;
        }
        if (drawable instanceof g02) {
            d(((h02) ((g02) drawable)).l);
            return;
        }
        if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
            return;
        }
        int childCount = drawableContainerState.getChildCount();
        for (int i = 0; i < childCount; i++) {
            Drawable child = drawableContainerState.getChild(i);
            if (child != null) {
                d(child);
            }
        }
    }

    public static pc e(oc ocVar, Drawable drawable, int i, int i2) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            if (i != Integer.MIN_VALUE || current.getIntrinsicWidth() > 0) {
                if (i2 != Integer.MIN_VALUE || current.getIntrinsicHeight() > 0) {
                    if (current.getIntrinsicWidth() > 0) {
                        i = current.getIntrinsicWidth();
                    }
                    if (current.getIntrinsicHeight() > 0) {
                        i2 = current.getIntrinsicHeight();
                    }
                    Lock lock = to1.b;
                    lock.lock();
                    Bitmap bitmapI = ocVar.i(i, i2, Bitmap.Config.ARGB_8888);
                    try {
                        Canvas canvas = new Canvas(bitmapI);
                        current.setBounds(0, 0, i, i2);
                        current.draw(canvas);
                        canvas.setBitmap(null);
                        lock.unlock();
                        bitmap = bitmapI;
                        z = true;
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                    current.toString();
                }
            } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                current.toString();
            }
            bitmap = null;
            z = true;
        }
        if (!z) {
            ocVar = a;
        }
        return pc.b(ocVar, bitmap);
    }

    public static bf1 f(int i) {
        return i != 0 ? i != 1 ? new rc1() : new rr() : new rc1();
    }

    public static final jc1 m(Context context, Class cls, String str) {
        qg0.l(context, "context");
        if (hk1.I(str)) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new jc1(context, cls, str);
    }

    public static final boolean n(int i, int i2) {
        return (i & i2) == i2;
    }

    public static InvocationHandler p() {
        ClassLoader classLoader;
        if (Build.VERSION.SDK_INT >= 28) {
            classLoader = a6.b();
        } else {
            try {
                Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", null);
                declaredMethod.setAccessible(true);
                classLoader = declaredMethod.invoke(null, null).getClass().getClassLoader();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4);
            }
        }
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, classLoader).getDeclaredMethod("createWebViewProviderFactory", null).invoke(null, null);
    }

    public static int r(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return t1.g(drawable);
        }
        if (!g) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", null);
                f = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            g = true;
        }
        Method method = f;
        if (method == null) {
            return 0;
        }
        try {
            return ((Integer) method.invoke(drawable, null)).intValue();
        } catch (Exception unused2) {
            f = null;
            return 0;
        }
    }

    public static final gg s(eo eoVar) {
        gg ggVar;
        gg ggVar2;
        if (!(eoVar instanceof yv)) {
            return new gg(1, eoVar);
        }
        yv yvVar = (yv) eoVar;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = yv.n;
            Object obj = atomicReferenceFieldUpdater.get(yvVar);
            wg1 wg1Var = np1.b;
            ggVar = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(yvVar, wg1Var);
                ggVar2 = null;
                break;
            }
            if (obj instanceof gg) {
                while (!atomicReferenceFieldUpdater.compareAndSet(yvVar, obj, wg1Var)) {
                    if (atomicReferenceFieldUpdater.get(yvVar) != obj) {
                        break;
                    }
                }
                ggVar2 = (gg) obj;
                break loop0;
            }
            if (obj != wg1Var && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (ggVar2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = gg.m;
            Object obj2 = atomicReferenceFieldUpdater2.get(ggVar2);
            if (!(obj2 instanceof sk) || ((sk) obj2).d == null) {
                gg.l.set(ggVar2, 536870911);
                atomicReferenceFieldUpdater2.set(ggVar2, n1.g);
                ggVar = ggVar2;
            } else {
                ggVar2.l();
            }
            if (ggVar != null) {
                return ggVar;
            }
        }
        return new gg(2, eoVar);
    }

    public static boolean u(Context context, Intent intent, String str) {
        PackageManager packageManager = context.getPackageManager();
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveInfoResolveActivity != null) {
            if (TextUtils.isEmpty(resolveInfoResolveActivity.activityInfo.permission)) {
                return true;
            }
            if (!TextUtils.isEmpty(str) && packageManager.checkPermission(resolveInfoResolveActivity.activityInfo.permission, str) == 0) {
                if (!ar1.i || TextUtils.isEmpty(AppOpsManager.permissionToOp(resolveInfoResolveActivity.activityInfo.permission))) {
                    return true;
                }
                try {
                    if (packageManager.getApplicationInfo(str, 0).targetSdkVersion >= 23) {
                        return true;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }
        return false;
    }

    public static boolean v(PackageManager packageManager, String str, int i) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, i);
            if (applicationInfo != null) {
                return applicationInfo.enabled;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean w(PackageManager packageManager, String str) {
        return v(packageManager, str, 8192);
    }

    public static boolean x(ApplicationInfo applicationInfo) {
        return ar1.f && (applicationInfo.flags & 1073741824) != 0;
    }

    public static boolean y(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                if (x(applicationInfo)) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean z(int i, Rect rect, Rect rect2) {
        if (i == 17) {
            int i2 = rect.right;
            int i3 = rect2.right;
            return (i2 > i3 || rect.left >= i3) && rect.left > rect2.left;
        }
        if (i == 33) {
            int i4 = rect.bottom;
            int i5 = rect2.bottom;
            return (i4 > i5 || rect.top >= i5) && rect.top > rect2.top;
        }
        if (i == 66) {
            int i6 = rect.left;
            int i7 = rect2.left;
            return (i6 < i7 || rect.right <= i7) && rect.right < rect2.right;
        }
        if (i != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i8 = rect.top;
        int i9 = rect2.top;
        return (i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom;
    }

    public abstract boolean B(String str);

    public abstract Object D(int i, Intent intent);

    public abstract Typeface g(Context context, j50 j50Var, Resources resources, int i);

    public abstract Typeface h(Context context, m50[] m50VarArr, int i);

    public Typeface i(Context context, List list, int i) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface j(Context context, InputStream inputStream) {
        File fileM = p02.m(context);
        if (fileM == null) {
            return null;
        }
        try {
            if (p02.g(fileM, inputStream)) {
                return Typeface.createFromFile(fileM.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileM.delete();
        }
    }

    public Typeface k(Context context, Resources resources, int i, String str, int i2) {
        File fileM = p02.m(context);
        if (fileM == null) {
            return null;
        }
        try {
            if (p02.f(fileM, resources, i)) {
                return Typeface.createFromFile(fileM.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileM.delete();
        }
    }

    public abstract Intent l(e6 e6Var, Intent intent);

    public void o(mz0 mz0Var) {
        List listSingletonList = Collections.singletonList(mz0Var);
        cz1 cz1Var = (cz1) this;
        if (listSingletonList.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        uy1 uy1Var = new uy1(cz1Var, listSingletonList);
        if (!uy1Var.l) {
            ((qm0) cz1Var.k).e(new k00(uy1Var));
        } else {
            ka0 ka0VarJ = ka0.j();
            TextUtils.join(", ", uy1Var.j);
            ka0VarJ.getClass();
        }
    }

    public m50 q(m50[] m50VarArr, int i) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        m50 m50Var = null;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (m50 m50Var2 : m50VarArr) {
            int iAbs = (Math.abs(m50Var2.c - i2) * 2) + (m50Var2.d == z ? 0 : 1);
            if (m50Var == null || i3 > iAbs) {
                m50Var = m50Var2;
                i3 = iAbs;
            }
        }
        return m50Var;
    }

    public mc1 t(e6 e6Var, Intent intent) {
        return null;
    }
}
