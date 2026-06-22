package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.ActivityChooserView;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbbc;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public abstract class e42 {
    public static ClassLoader a;
    public static Thread b;
    public static Method e;
    public static boolean f;
    public static final wg1 c = new wg1("CLOSED_EMPTY", 1);
    public static final Object d = new Object();
    public static final gq g = new gq();

    /* JADX WARN: Removed duplicated region for block: B:190:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0675 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x069c  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x06a5  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x06ac  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x06c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:436:0x06dc A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(defpackage.kn r40, defpackage.qn0 r41, java.util.ArrayList r42, int r43) {
        /*
            Method dump skipped, instruction units count: 1771
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e42.a(kn, qn0, java.util.ArrayList, int):void");
    }

    public static td1 b(Callable callable) {
        try {
            Object objCall = callable.call();
            z71.m(objCall, "Scheduler Callable result can't be null");
            return (td1) objCall;
        } catch (Throwable th) {
            throw a10.a(th);
        }
    }

    public static eo d(eo eoVar) {
        eo eoVarIntercepted;
        qg0.l(eoVar, "<this>");
        go goVar = eoVar instanceof go ? (go) eoVar : null;
        return (goVar == null || (eoVarIntercepted = goVar.intercepted()) == null) ? eoVar : eoVarIntercepted;
    }

    public static boolean e() {
        try {
            return Class.forName("android.os.Looper").getDeclaredMethod("getMainLooper", null).invoke(null, null) != null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static boolean f(Context context) {
        return !ar1.i || np1.d(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static boolean g(Context context) {
        return !ar1.j || np1.d(context, "android.permission.READ_MEDIA_IMAGES") == 0;
    }

    public static boolean h(Context context) {
        if (ar1.i) {
            return np1.d(context, "android.permission.READ_EXTERNAL_STORAGE") == 0 && np1.d(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        }
        return true;
    }

    public static boolean i(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x009c A[Catch: RuntimeException -> 0x00a2, TRY_LEAVE, TryCatch #1 {RuntimeException -> 0x00a2, blocks: (B:59:0x0096, B:61:0x009c), top: B:72:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.tu j(android.content.Context r4, defpackage.w50 r5, boolean r6, boolean r7) {
        /*
            v50 r0 = r5.O
            r1 = 0
            if (r0 != 0) goto L7
            r2 = 0
            goto L9
        L7:
            int r2 = r0.f
        L9:
            if (r7 == 0) goto L1a
            if (r6 == 0) goto L14
            if (r0 != 0) goto L11
        Lf:
            r7 = 0
            goto L27
        L11:
            int r7 = r0.d
            goto L27
        L14:
            if (r0 != 0) goto L17
            goto Lf
        L17:
            int r7 = r0.e
            goto L27
        L1a:
            if (r6 == 0) goto L22
            if (r0 != 0) goto L1f
            goto Lf
        L1f:
            int r7 = r0.b
            goto L27
        L22:
            if (r0 != 0) goto L25
            goto Lf
        L25:
            int r7 = r0.c
        L27:
            r5.P(r1, r1, r1, r1)
            android.view.ViewGroup r0 = r5.K
            r1 = 0
            if (r0 == 0) goto L3e
            int r3 = defpackage.b61.visible_removing_fragment_view_tag
            java.lang.Object r0 = r0.getTag(r3)
            if (r0 == 0) goto L3e
            android.view.ViewGroup r0 = r5.K
            int r3 = defpackage.b61.visible_removing_fragment_view_tag
            r0.setTag(r3, r1)
        L3e:
            android.view.ViewGroup r5 = r5.K
            if (r5 == 0) goto L4a
            android.animation.LayoutTransition r5 = r5.getLayoutTransition()
            if (r5 == 0) goto L4a
            goto Lb2
        L4a:
            if (r7 != 0) goto L76
            if (r2 == 0) goto L76
            r5 = 4097(0x1001, float:5.741E-42)
            if (r2 == r5) goto L6e
            r5 = 4099(0x1003, float:5.744E-42)
            if (r2 == r5) goto L66
            r5 = 8194(0x2002, float:1.1482E-41)
            if (r2 == r5) goto L5d
            r5 = -1
            r7 = -1
            goto L76
        L5d:
            if (r6 == 0) goto L63
            int r5 = defpackage.i41.fragment_close_enter
        L61:
            r7 = r5
            goto L76
        L63:
            int r5 = defpackage.i41.fragment_close_exit
            goto L61
        L66:
            if (r6 == 0) goto L6b
            int r5 = defpackage.i41.fragment_fade_enter
            goto L61
        L6b:
            int r5 = defpackage.i41.fragment_fade_exit
            goto L61
        L6e:
            if (r6 == 0) goto L73
            int r5 = defpackage.i41.fragment_open_enter
            goto L61
        L73:
            int r5 = defpackage.i41.fragment_open_exit
            goto L61
        L76:
            if (r7 == 0) goto Lb2
            android.content.res.Resources r5 = r4.getResources()
            java.lang.String r5 = r5.getResourceTypeName(r7)
            java.lang.String r6 = "anim"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L96
            android.view.animation.Animation r6 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)     // Catch: android.content.res.Resources.NotFoundException -> L94 java.lang.RuntimeException -> L96
            if (r6 == 0) goto Lb2
            tu r0 = new tu     // Catch: android.content.res.Resources.NotFoundException -> L94 java.lang.RuntimeException -> L96
            r0.<init>(r6)     // Catch: android.content.res.Resources.NotFoundException -> L94 java.lang.RuntimeException -> L96
            return r0
        L94:
            r4 = move-exception
            throw r4
        L96:
            android.animation.Animator r6 = android.animation.AnimatorInflater.loadAnimator(r4, r7)     // Catch: java.lang.RuntimeException -> La2
            if (r6 == 0) goto Lb2
            tu r0 = new tu     // Catch: java.lang.RuntimeException -> La2
            r0.<init>(r6)     // Catch: java.lang.RuntimeException -> La2
            return r0
        La2:
            r6 = move-exception
            if (r5 != 0) goto Lb1
            android.view.animation.Animation r4 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)
            if (r4 == 0) goto Lb2
            tu r5 = new tu
            r5.<init>(r4)
            return r5
        Lb1:
            throw r6
        Lb2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e42.j(android.content.Context, w50, boolean, boolean):tu");
    }

    public static Typeface k(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE || configuration.fontWeightAdjustment == 0) {
            return null;
        }
        int weight = configuration.fontWeightAdjustment + typeface.getWeight();
        if (weight < 1) {
            weight = 1;
        } else if (weight > 1000) {
            weight = zzbbc.zzq.zzf;
        }
        return Typeface.create(typeface, weight, typeface.isItalic());
    }

    public static final yo l(gp gpVar, yo yoVar) {
        yo yoVarK;
        yo yoVarC = gpVar.c();
        Boolean bool = Boolean.FALSE;
        zo zoVar = zo.i;
        boolean zBooleanValue = ((Boolean) yoVarC.h(bool, zoVar)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) yoVar.h(bool, zoVar)).booleanValue();
        if (zBooleanValue || zBooleanValue2) {
            sz szVar = sz.g;
            yo yoVar2 = (yo) yoVarC.h(szVar, new zo(2, 5));
            Object objH = yoVar;
            if (zBooleanValue2) {
                objH = yoVar.h(szVar, zo.h);
            }
            yoVarK = yoVar2.k((yo) objH);
        } else {
            yoVarK = yoVarC.k(yoVar);
        }
        xt xtVar = aw.a;
        return (yoVarK == xtVar || yoVarK.n(iy.g) != null) ? yoVarK : yoVarK.k(xtVar);
    }

    public static void m(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!(th instanceof sy0) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof gl)) {
            th = new qj("The exception could not be delivered to the consumer because it has already canceled/disposed the flow or the exception has nowhere to go to begin with. Further reading: https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0#error-handling | " + th, th);
        }
        th.printStackTrace();
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }

    public static void n(Activity activity) {
        if (ar1.i) {
            if (activity.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")) {
                np1.E(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 68);
            } else {
                r(activity, "android.permission.ACCESS_FINE_LOCATION");
            }
        }
    }

    public static void o(Activity activity) {
        if (ar1.j) {
            if (activity.shouldShowRequestPermissionRationale("android.permission.READ_MEDIA_IMAGES")) {
                np1.E(activity, new String[]{"android.permission.READ_MEDIA_IMAGES"}, 68);
            } else {
                r(activity, "android.permission.READ_MEDIA_IMAGES");
            }
        }
    }

    public static void p(Activity activity) {
        if (ar1.i) {
            if (activity.shouldShowRequestPermissionRationale("android.permission.READ_EXTERNAL_STORAGE")) {
                np1.E(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 68);
            } else {
                r(activity, "android.permission.READ_EXTERNAL_STORAGE");
            }
        }
    }

    public static void r(Activity activity, String str) {
        try {
            Toast.makeText(activity, activity.getString(w61.grant, str), 1).show();
            activity.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:com.luutinhit.launcherios")));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long s(java.lang.String r23, long r24, long r26, long r28) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e42.s(java.lang.String, long, long, long):long");
    }

    public static int t(int i, int i2, String str) {
        return (int) s(str, i, 1, (i2 & 8) != 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : 2097150);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [go, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [ip] */
    /* JADX WARN: Type inference failed for: r1v2, types: [ip] */
    public static final void u(go goVar, yo yoVar) {
        if (uo.r(goVar) && yoVar.n(wp1.g) != null) {
            do {
                goVar = goVar.getCallerFrame();
            } while (goVar != 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0093 A[Catch: all -> 0x008f, PHI: r1
  0x0093: PHI (r1v4 java.lang.Thread) = (r1v3 java.lang.Thread), (r1v14 java.lang.Thread) binds: [B:7:0x000a, B:47:0x008c] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #6 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000c, B:46:0x008a, B:61:0x00a2, B:12:0x001f, B:52:0x0092, B:53:0x0093, B:64:0x00a6, B:65:0x00a7, B:54:0x0094, B:60:0x00a1, B:59:0x009e, B:13:0x0020, B:15:0x002d, B:25:0x0046, B:26:0x004d, B:28:0x0058, B:34:0x006d, B:35:0x0074, B:43:0x0085, B:44:0x0088, B:18:0x003c), top: B:80:0x0003, inners: #2, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized java.lang.ClassLoader v() {
        /*
            java.lang.Class<e42> r0 = defpackage.e42.class
            monitor-enter(r0)
            java.lang.ClassLoader r1 = defpackage.e42.a     // Catch: java.lang.Throwable -> L8f
            if (r1 != 0) goto La7
            java.lang.Thread r1 = defpackage.e42.b     // Catch: java.lang.Throwable -> L8f
            r2 = 0
            if (r1 != 0) goto L93
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L8f
            java.lang.Thread r1 = r1.getThread()     // Catch: java.lang.Throwable -> L8f
            java.lang.ThreadGroup r1 = r1.getThreadGroup()     // Catch: java.lang.Throwable -> L8f
            if (r1 != 0) goto L1d
            r1 = r2
            goto L8a
        L1d:
            java.lang.Class<java.lang.Void> r3 = java.lang.Void.class
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L8f
            int r4 = r1.activeGroupCount()     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L41
            java.lang.ThreadGroup[] r5 = new java.lang.ThreadGroup[r4]     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L41
            r1.enumerate(r5)     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L41
            r6 = 0
            r7 = 0
        L2b:
            if (r7 >= r4) goto L43
            r8 = r5[r7]     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L41
            java.lang.String r9 = "dynamiteLoader"
            java.lang.String r10 = r8.getName()     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L41
            boolean r9 = r9.equals(r10)     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L41
            if (r9 == 0) goto L3c
            goto L44
        L3c:
            int r7 = r7 + 1
            goto L2b
        L3f:
            r1 = move-exception
            goto L91
        L41:
            r1 = move-exception
            goto L83
        L43:
            r8 = r2
        L44:
            if (r8 != 0) goto L4d
            java.lang.ThreadGroup r8 = new java.lang.ThreadGroup     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L41
            java.lang.String r4 = "dynamiteLoader"
            r8.<init>(r1, r4)     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L41
        L4d:
            int r1 = r8.activeCount()     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L41
            java.lang.Thread[] r4 = new java.lang.Thread[r1]     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L41
            r8.enumerate(r4)     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L41
        L56:
            if (r6 >= r1) goto L6a
            r5 = r4[r6]     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L41
            java.lang.String r7 = "GmsDynamite"
            java.lang.String r9 = r5.getName()     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L41
            boolean r7 = r7.equals(r9)     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L41
            if (r7 == 0) goto L67
            goto L6b
        L67:
            int r6 = r6 + 1
            goto L56
        L6a:
            r5 = r2
        L6b:
            if (r5 != 0) goto L88
            o9 r1 = new o9     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L81
            java.lang.String r4 = "GmsDynamite"
            r1.<init>(r8, r4)     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L81
            r1.setContextClassLoader(r2)     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L7c
            r1.start()     // Catch: java.lang.Throwable -> L3f java.lang.SecurityException -> L7c
            r5 = r1
            goto L88
        L7c:
            r4 = move-exception
            r5 = r1
            goto L85
        L7f:
            r4 = r1
            goto L85
        L81:
            r1 = move-exception
            goto L7f
        L83:
            r4 = r1
            r5 = r2
        L85:
            r4.getMessage()     // Catch: java.lang.Throwable -> L3f
        L88:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3f
            r1 = r5
        L8a:
            defpackage.e42.b = r1     // Catch: java.lang.Throwable -> L8f
            if (r1 != 0) goto L93
            goto La2
        L8f:
            r1 = move-exception
            goto Lab
        L91:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3f
            throw r1     // Catch: java.lang.Throwable -> L8f
        L93:
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L8f
            java.lang.Thread r3 = defpackage.e42.b     // Catch: java.lang.Throwable -> L9b java.lang.SecurityException -> L9d
            java.lang.ClassLoader r2 = r3.getContextClassLoader()     // Catch: java.lang.Throwable -> L9b java.lang.SecurityException -> L9d
            goto La1
        L9b:
            r2 = move-exception
            goto La5
        L9d:
            r3 = move-exception
            r3.getMessage()     // Catch: java.lang.Throwable -> L9b
        La1:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L9b
        La2:
            defpackage.e42.a = r2     // Catch: java.lang.Throwable -> L8f
            goto La7
        La5:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L9b
            throw r2     // Catch: java.lang.Throwable -> L8f
        La7:
            java.lang.ClassLoader r1 = defpackage.e42.a     // Catch: java.lang.Throwable -> L8f
            monitor-exit(r0)
            return r1
        Lab:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8f
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e42.v():java.lang.ClassLoader");
    }

    public static Object w(Context context, String str, jc2 jc2Var) throws nc2 {
        try {
            return jc2Var.zza(x(context).b(str));
        } catch (Exception e2) {
            throw new nc2(e2);
        }
    }

    public static dy x(Context context) throws nc2 {
        try {
            return dy.c(context, dy.b, ModuleDescriptor.MODULE_ID);
        } catch (Exception e2) {
            throw new nc2(e2);
        }
    }

    public abstract float c(ViewGroup viewGroup);

    public abstract void q(ViewGroup viewGroup, float f2);
}
