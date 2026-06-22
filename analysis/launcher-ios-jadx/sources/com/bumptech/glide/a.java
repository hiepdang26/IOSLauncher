package com.bumptech.glide;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserView;
import defpackage.ay;
import defpackage.cq0;
import defpackage.ct0;
import defpackage.d00;
import defpackage.dq0;
import defpackage.e6;
import defpackage.e9;
import defpackage.h60;
import defpackage.iq0;
import defpackage.iy;
import defpackage.jl1;
import defpackage.mc1;
import defpackage.n90;
import defpackage.nx0;
import defpackage.o90;
import defpackage.oc;
import defpackage.p1;
import defpackage.qg0;
import defpackage.r90;
import defpackage.s90;
import defpackage.sa1;
import defpackage.uo;
import defpackage.uv;
import defpackage.va1;
import defpackage.vq1;
import defpackage.w50;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ComponentCallbacks2 {
    public static volatile a n;
    public static volatile boolean o;
    public final oc g;
    public final iq0 h;
    public final o90 i;
    public final cq0 j;
    public final va1 k;
    public final jl1 l;
    public final ArrayList m = new ArrayList();

    public a(Context context, d00 d00Var, iq0 iq0Var, oc ocVar, cq0 cq0Var, va1 va1Var, jl1 jl1Var, int i, iy iyVar, e9 e9Var, List list, List list2, qg0 qg0Var, nx0 nx0Var) {
        this.g = ocVar;
        this.j = cq0Var;
        this.h = iq0Var;
        this.k = va1Var;
        this.l = jl1Var;
        this.i = new o90(context, cq0Var, new uv(this, list2, qg0Var), new iy(), iyVar, e9Var, list, d00Var, nx0Var, i);
    }

    public static a a(Context context) {
        GeneratedAppGlideModule generatedAppGlideModule;
        if (n == null) {
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                Log.isLoggable("Glide", 5);
                generatedAppGlideModule = null;
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e);
            } catch (InstantiationException e2) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e2);
            } catch (NoSuchMethodException e3) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e3);
            } catch (InvocationTargetException e4) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e4);
            }
            synchronized (a.class) {
                if (n == null) {
                    if (o) {
                        throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
                    }
                    o = true;
                    try {
                        c(context, generatedAppGlideModule);
                        o = false;
                    } catch (Throwable th) {
                        o = false;
                        throw th;
                    }
                }
            }
        }
        return n;
    }

    public static va1 b(Context context) {
        n90.h(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v2, types: [ua1] */
    public static void c(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        int i = 1;
        e9 e9Var = new e9(0);
        mc1 mc1Var = new mc1(14);
        iy iyVar = new iy();
        Context applicationContext = context.getApplicationContext();
        List list = Collections.EMPTY_LIST;
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.z();
        }
        Log.isLoggable("ManifestParser", 3);
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            try {
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    context = null;
                    Log.isLoggable("ManifestParser", 3);
                } else {
                    if (Log.isLoggable("ManifestParser", 2)) {
                        Objects.toString(applicationInfo.metaData);
                    }
                    for (String str : applicationInfo.metaData.keySet()) {
                        if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                            qg0.B(str);
                            throw null;
                        }
                    }
                    context = null;
                    Log.isLoggable("ManifestParser", 3);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.isLoggable("ManifestParser", 6);
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            context = null;
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.V().isEmpty()) {
            generatedAppGlideModule.V();
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                throw uo.c(it);
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                throw uo.c(it2);
            }
        }
        ?? W = generatedAppGlideModule != null ? generatedAppGlideModule.W() : context;
        Iterator it3 = arrayList.iterator();
        if (it3.hasNext()) {
            throw uo.c(it3);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.c();
        }
        p1 p1Var = new p1(i);
        if (s90.i == 0) {
            s90.i = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        int i2 = s90.i;
        if (TextUtils.isEmpty("source")) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: source");
        }
        s90 s90Var = new s90(new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new r90(p1Var, "source", false)));
        int i3 = s90.i;
        p1 p1Var2 = new p1(i);
        if (TextUtils.isEmpty("disk-cache")) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: disk-cache");
        }
        s90 s90Var2 = new s90(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new r90(p1Var2, "disk-cache", true)));
        if (s90.i == 0) {
            s90.i = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        int i4 = s90.i >= 4 ? 2 : 1;
        p1 p1Var3 = new p1(i);
        if (TextUtils.isEmpty("animation")) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: animation");
        }
        s90 s90Var3 = new s90(new ThreadPoolExecutor(i4, i4, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new r90(p1Var3, "animation", true)));
        ct0 ct0Var = new ct0(applicationContext);
        ay ayVar = new ay();
        Context context2 = ct0Var.a;
        ActivityManager activityManager = ct0Var.b;
        int i5 = activityManager.isLowRamDevice() ? 2097152 : 4194304;
        ayVar.c = i5;
        int iRound = Math.round(activityManager.getMemoryClass() * 1048576 * (activityManager.isLowRamDevice() ? 0.33f : 0.4f));
        DisplayMetrics displayMetrics = (DisplayMetrics) ct0Var.c.h;
        float f = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
        float f2 = ct0Var.d;
        int iRound2 = Math.round(f * f2);
        int iRound3 = Math.round(f * 2.0f);
        int i6 = iRound - i5;
        if (iRound3 + iRound2 <= i6) {
            ayVar.b = iRound3;
            ayVar.a = iRound2;
        } else {
            float f3 = i6 / (f2 + 2.0f);
            ayVar.b = Math.round(2.0f * f3);
            ayVar.a = Math.round(f3 * f2);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Formatter.formatFileSize(context2, ayVar.b);
            Formatter.formatFileSize(context2, ayVar.a);
            Formatter.formatFileSize(context2, i5);
            Formatter.formatFileSize(context2, iRound);
            activityManager.getMemoryClass();
            activityManager.isLowRamDevice();
        }
        jl1 jl1Var = new jl1(13);
        int i7 = ayVar.a;
        oc dq0Var = i7 > 0 ? new dq0(i7) : new jl1(9);
        cq0 cq0Var = new cq0(ayVar.c);
        iq0 iq0Var = new iq0(ayVar.b);
        a aVar = new a(applicationContext, new d00(iq0Var, new nx0(applicationContext), s90Var2, s90Var, new s90(new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, s90.h, TimeUnit.MILLISECONDS, new SynchronousQueue(), new r90(new p1(1), "source-unlimited", false))), s90Var3), iq0Var, dq0Var, cq0Var, new va1(W), jl1Var, 4, iyVar, e9Var, Collections.EMPTY_LIST, arrayList, generatedAppGlideModule, new nx0(mc1Var));
        applicationContext.registerComponentCallbacks(aVar);
        n = aVar;
    }

    public static sa1 e(Context context) {
        return b(context).d(context);
    }

    public static sa1 f(View view) {
        View view2;
        va1 va1VarB = b(view.getContext());
        va1VarB.getClass();
        char[] cArr = vq1.a;
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            return va1VarB.d(view.getContext().getApplicationContext());
        }
        n90.h(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activityA = va1.a(view.getContext());
        if (activityA == null) {
            return va1VarB.d(view.getContext().getApplicationContext());
        }
        if (!(activityA instanceof e6)) {
            return va1VarB.d(view.getContext().getApplicationContext());
        }
        e6 e6Var = (e6) activityA;
        e9 e9Var = va1VarB.i;
        e9Var.clear();
        va1.b(e6Var.o().c.t(), e9Var);
        View viewFindViewById = e6Var.findViewById(R.id.content);
        w50 w50Var = null;
        while (!view.equals(viewFindViewById) && (w50Var = (w50) e9Var.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        e9Var.clear();
        if (w50Var == null) {
            return va1VarB.c(e6Var);
        }
        n90.h(w50Var.p(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            return va1VarB.d(w50Var.p().getApplicationContext());
        }
        if (w50Var.d() != null) {
            va1VarB.j.q(w50Var.d());
        }
        h60 h60VarO = w50Var.o();
        Context contextP = w50Var.p();
        return va1VarB.k.a(contextP, a(contextP.getApplicationContext()), w50Var.T, h60VarO, (w50Var.z == null || !w50Var.r || w50Var.F || (view2 = w50Var.L) == null || view2.getWindowToken() == null || w50Var.L.getVisibility() != 0) ? false : true);
    }

    public final void d(sa1 sa1Var) {
        synchronized (this.m) {
            try {
                if (!this.m.contains(sa1Var)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.m.remove(sa1Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        vq1.a();
        this.h.e(0L);
        this.g.r();
        this.j.a();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        vq1.a();
        synchronized (this.m) {
            try {
                ArrayList arrayList = this.m;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((sa1) obj).getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.h.f(i);
        this.g.o(i);
        this.j.i(i);
    }
}
