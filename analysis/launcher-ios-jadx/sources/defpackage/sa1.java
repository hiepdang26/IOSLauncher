package defpackage;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import com.bumptech.glide.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class sa1 implements ComponentCallbacks2, cn0 {
    public static final xa1 q = (xa1) ((xa1) new xa1().e(Bitmap.class)).k();
    public final a g;
    public final Context h;
    public final wm0 i;
    public final hh1 j;
    public final wa1 k;
    public final nm1 l;
    public final fl0 m;
    public final dm n;
    public final CopyOnWriteArrayList o;
    public xa1 p;

    static {
    }

    public sa1(a aVar, wm0 wm0Var, wa1 wa1Var, Context context) {
        hh1 hh1Var = new hh1(1);
        jl1 jl1Var = aVar.l;
        this.l = new nm1();
        fl0 fl0Var = new fl0(this, 10);
        this.m = fl0Var;
        this.g = aVar;
        this.i = wm0Var;
        this.k = wa1Var;
        this.j = hh1Var;
        this.h = context;
        Context applicationContext = context.getApplicationContext();
        ra1 ra1Var = new ra1(this, hh1Var);
        jl1Var.getClass();
        boolean z = np1.d(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0;
        Log.isLoggable("ConnectivityMonitor", 3);
        dm vsVar = z ? new vs(applicationContext, ra1Var) : new dy0();
        this.n = vsVar;
        synchronized (aVar.m) {
            if (aVar.m.contains(this)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            aVar.m.add(this);
        }
        char[] cArr = vq1.a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            wm0Var.h(this);
        } else {
            vq1.f().post(fl0Var);
        }
        wm0Var.h(vsVar);
        this.o = new CopyOnWriteArrayList(aVar.i.e);
        v(aVar.i.a());
    }

    @Override // defpackage.cn0
    public final synchronized void b() {
        this.l.b();
        t();
    }

    @Override // defpackage.cn0
    public final synchronized void j() {
        u();
        this.l.j();
    }

    public na1 k(Class cls) {
        return new na1(this.g, this, cls, this.h);
    }

    public na1 l() {
        return k(Bitmap.class).a(q);
    }

    public na1 m() {
        return k(Drawable.class);
    }

    public final void n(lm1 lm1Var) {
        if (lm1Var == null) {
            return;
        }
        boolean zW = w(lm1Var);
        ha1 ha1VarH = lm1Var.h();
        if (zW) {
            return;
        }
        a aVar = this.g;
        synchronized (aVar.m) {
            try {
                ArrayList arrayList = aVar.m;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (((sa1) obj).w(lm1Var)) {
                        return;
                    }
                }
                if (ha1VarH != null) {
                    lm1Var.c(null);
                    ha1VarH.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void o() {
        try {
            ArrayList arrayListE = vq1.e(this.l.g);
            int size = arrayListE.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListE.get(i);
                i++;
                n((lm1) obj);
            }
            this.l.g.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.cn0
    public final synchronized void onDestroy() {
        this.l.onDestroy();
        o();
        hh1 hh1Var = this.j;
        ArrayList arrayListE = vq1.e((Set) hh1Var.d);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            hh1Var.a((ha1) obj);
        }
        ((HashSet) hh1Var.b).clear();
        this.i.g(this);
        this.i.g(this.n);
        vq1.f().removeCallbacks(this.m);
        this.g.d(this);
    }

    public na1 p(Bitmap bitmap) {
        return m().N(bitmap);
    }

    public na1 q(Uri uri) {
        return m().O(uri);
    }

    public na1 r(Integer num) {
        return m().Q(num);
    }

    public na1 s(String str) {
        return m().R(str);
    }

    public final synchronized void t() {
        hh1 hh1Var = this.j;
        hh1Var.c = true;
        ArrayList arrayListE = vq1.e((Set) hh1Var.d);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ha1 ha1Var = (ha1) obj;
            if (ha1Var.isRunning()) {
                ha1Var.j();
                ((HashSet) hh1Var.b).add(ha1Var);
            }
        }
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.j + ", treeNode=" + this.k + "}";
    }

    public final synchronized void u() {
        hh1 hh1Var = this.j;
        int i = 0;
        hh1Var.c = false;
        ArrayList arrayListE = vq1.e((Set) hh1Var.d);
        int size = arrayListE.size();
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ha1 ha1Var = (ha1) obj;
            if (!ha1Var.l() && !ha1Var.isRunning()) {
                ha1Var.k();
            }
        }
        ((HashSet) hh1Var.b).clear();
    }

    public synchronized void v(xa1 xa1Var) {
        this.p = (xa1) ((xa1) xa1Var.clone()).b();
    }

    public final synchronized boolean w(lm1 lm1Var) {
        ha1 ha1VarH = lm1Var.h();
        if (ha1VarH == null) {
            return true;
        }
        if (!this.j.a(ha1VarH)) {
            return false;
        }
        this.l.g.remove(lm1Var);
        lm1Var.c(null);
        return true;
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
    }
}
