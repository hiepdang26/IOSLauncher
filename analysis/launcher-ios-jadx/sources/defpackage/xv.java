package defpackage;

import android.os.Handler;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class xv implements pv {
    public final long g;
    public final Object h;
    public final Object i;
    public final Object j;
    public Object k;

    public xv(ow1 ow1Var, q11 q11Var) {
        qg0.l(ow1Var, "runnableScheduler");
        long millis = TimeUnit.MINUTES.toMillis(90L);
        this.h = ow1Var;
        this.i = q11Var;
        this.g = millis;
        this.j = new Object();
        this.k = new LinkedHashMap();
    }

    public void a(bj1 bj1Var) {
        Runnable runnable;
        qg0.l(bj1Var, "token");
        synchronized (this.j) {
            runnable = (Runnable) ((LinkedHashMap) this.k).remove(bj1Var);
        }
        if (runnable != null) {
            ((Handler) ((ow1) this.h).h).removeCallbacks(runnable);
        }
    }

    public synchronized wv b() {
        try {
            if (((wv) this.k) == null) {
                this.k = wv.A((File) this.i, this.g);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (wv) this.k;
    }

    public void c(bj1 bj1Var) {
        wc wcVar = new wc(this, bj1Var, 19);
        synchronized (this.j) {
        }
        ow1 ow1Var = (ow1) this.h;
        ((Handler) ow1Var.h).postDelayed(wcVar, this.g);
    }

    @Override // defpackage.pv
    public File e(bj0 bj0Var) {
        String strJ = ((tu) this.h).j(bj0Var);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Objects.toString(bj0Var);
        }
        try {
            nx0 nx0VarR = b().r(strJ);
            if (nx0VarR != null) {
                return ((File[]) nx0VarR.h)[0];
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
            return null;
        }
    }

    @Override // defpackage.pv
    public void i(bj0 bj0Var, wb2 wb2Var) {
        rv rvVarA;
        wv wvVarB;
        boolean z;
        String strJ = ((tu) this.h).j(bj0Var);
        q11 q11Var = (q11) this.j;
        synchronized (q11Var) {
            try {
                rvVarA = (rv) ((HashMap) q11Var.h).get(strJ);
                if (rvVarA == null) {
                    rvVarA = ((we) q11Var.i).a();
                    ((HashMap) q11Var.h).put(strJ, rvVarA);
                }
                rvVarA.b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        rvVarA.a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Objects.toString(bj0Var);
            }
            try {
                wvVarB = b();
            } catch (IOException unused) {
                Log.isLoggable("DiskLruCacheWrapper", 5);
            }
            if (wvVarB.r(strJ) != null) {
                return;
            }
            uv uvVarK = wvVarB.k(strJ);
            if (uvVarK == null) {
                throw new IllegalStateException("Had two simultaneous puts for: ".concat(strJ));
            }
            try {
                if (((zz) wb2Var.h).f(wb2Var.i, uvVarK.d(), (g01) wb2Var.j)) {
                    wv.a((wv) uvVarK.j, uvVarK, true);
                    uvVarK.h = true;
                }
                if (!z) {
                    try {
                        uvVarK.c();
                    } catch (IOException unused2) {
                    }
                }
            } finally {
                if (!uvVarK.h) {
                    try {
                        uvVarK.c();
                    } catch (IOException unused3) {
                    }
                }
            }
        } finally {
            ((q11) this.j).L(strJ);
        }
    }

    public xv(File file) {
        this.j = new q11(8);
        this.i = file;
        this.g = 262144000L;
        this.h = new tu(7);
    }
}
