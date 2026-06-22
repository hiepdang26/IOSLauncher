package defpackage;

import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.luutinhit.launcher6.LauncherProvider;
import com.luutinhit.launcher6.t;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class jk0 {
    public static WeakReference h = new WeakReference(null);
    public static Context i;
    public static jk0 j;
    public final rl0 a;
    public final oe0 b;
    public final gx1 c;
    public boolean d;
    public final xg0 e;
    public dk0 f;
    public t g;

    public jk0() {
        Context context = i;
        if (context == null) {
            throw new IllegalStateException("LauncherAppState inited before app context set");
        }
        xg0 xg0Var = new xg0(context);
        this.e = xg0Var;
        oe0 oe0Var = new oe0(i, xg0Var);
        this.b = oe0Var;
        this.c = new gx1(i, oe0Var);
        String string = i.getString(w61.app_filter_class);
        if (!TextUtils.isEmpty(string)) {
            try {
                if (Class.forName(string).newInstance() != null) {
                    throw new ClassCastException();
                }
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            }
        }
        rl0 rl0Var = new rl0(this, this.b);
        this.a = rl0Var;
        qg0.t(i).a(rl0Var);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        intentFilter.addAction("android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED");
        intentFilter.addAction("android.intent.action.MANAGED_PROFILE_ADDED");
        intentFilter.addAction("android.intent.action.MANAGED_PROFILE_REMOVED");
        intentFilter.addAction("android.intent.action.MANAGED_PROFILE_AVAILABLE");
        intentFilter.addAction("android.intent.action.MANAGED_PROFILE_UNAVAILABLE");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_HIDDEN_APPS_IN_WORKSPACE");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_RELOAD_ICON");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_UPDATE_LABEL");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_UPDATE_CATEGORY");
        boolean z = ar1.j;
        if (z) {
            i.registerReceiver(rl0Var, intentFilter, 2);
        } else {
            i.registerReceiver(rl0Var, intentFilter);
        }
        iy.n(i).i();
        ql qlVar = new ql(i);
        Context context2 = qlVar.a;
        if (z) {
            context2.registerReceiver(qlVar, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"), 2);
        } else {
            context2.registerReceiver(qlVar, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
        IntentFilter intentFilter2 = new IntentFilter("android.intent.action.WALLPAPER_CHANGED");
        intentFilter2.addAction("com.luutinhit.launcherios.MY_ACTION_WALLPAPER_CHANGED");
        if (z) {
            i.registerReceiver(new rv1(0), intentFilter2, 2);
        } else {
            i.registerReceiver(new rv1(0), intentFilter2);
        }
    }

    public static jk0 a() {
        if (j == null) {
            j = new jk0();
        }
        return j;
    }

    public static LauncherProvider c() {
        return (LauncherProvider) h.get();
    }

    public final xg0 b() {
        return this.e;
    }

    public final rl0 d(t tVar) {
        if (c() == null && tVar != null) {
            try {
                ContentProviderClient contentProviderClientAcquireContentProviderClient = tVar.getContentResolver().acquireContentProviderClient("com.luutinhit.launcherios.settings");
                if (contentProviderClientAcquireContentProviderClient != null) {
                    try {
                        ContentProvider localContentProvider = contentProviderClientAcquireContentProviderClient.getLocalContentProvider();
                        if (localContentProvider instanceof LauncherProvider) {
                            h = new WeakReference((LauncherProvider) localContentProvider);
                        }
                    } finally {
                    }
                }
                if (contentProviderClientAcquireContentProviderClient != null) {
                    uo.q(contentProviderClientAcquireContentProviderClient);
                }
            } catch (Throwable unused) {
            }
        }
        LauncherProvider launcherProviderC = c();
        launcherProviderC.g = tVar;
        launcherProviderC.h.k = tVar;
        rl0 rl0Var = this.a;
        rl0Var.getClass();
        Objects.toString(tVar);
        synchronized (rl0Var.i) {
            rl0Var.B();
            rl0Var.q = new WeakReference(tVar);
        }
        this.f = (tVar == null || !ar1.m) ? null : new dk0(tVar);
        return this.a;
    }
}
