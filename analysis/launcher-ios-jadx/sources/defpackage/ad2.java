package defpackage;

import android.content.Context;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class ad2 extends aa0 {
    public final HashMap d = new HashMap();
    public final Context e;
    public volatile t12 f;
    public final bm g;
    public final long h;
    public final long i;

    public ad2(Context context, Looper looper) {
        h8 h8Var = new h8(this, 6);
        this.e = context.getApplicationContext();
        t12 t12Var = new t12(looper, h8Var);
        Looper.getMainLooper();
        this.f = t12Var;
        this.g = bm.a();
        this.h = 5000L;
        this.i = 300000L;
    }

    @Override // defpackage.aa0
    public final boolean d(kc2 kc2Var, g92 g92Var, String str, Executor executor) {
        boolean z;
        synchronized (this.d) {
            try {
                oc2 oc2Var = (oc2) this.d.get(kc2Var);
                if (executor == null) {
                    executor = null;
                }
                if (oc2Var == null) {
                    oc2Var = new oc2(this, kc2Var);
                    oc2Var.a.put(g92Var, g92Var);
                    oc2Var.a(str, executor);
                    this.d.put(kc2Var, oc2Var);
                } else {
                    this.f.removeMessages(0, kc2Var);
                    if (oc2Var.a.containsKey(g92Var)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(kc2Var.toString()));
                    }
                    oc2Var.a.put(g92Var, g92Var);
                    int i = oc2Var.b;
                    if (i == 1) {
                        g92Var.onServiceConnected(oc2Var.f, oc2Var.d);
                    } else if (i == 2) {
                        oc2Var.a(str, executor);
                    }
                }
                z = oc2Var.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
