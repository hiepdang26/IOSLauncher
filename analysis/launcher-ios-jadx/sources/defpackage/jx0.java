package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

/* JADX INFO: loaded from: classes.dex */
public final class jx0 extends yd {
    public final ConnectivityManager g;

    public jx0(Context context, qm0 qm0Var) {
        super(context, qm0Var);
        Object systemService = this.b.getSystemService("connectivity");
        qg0.i(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.g = (ConnectivityManager) systemService;
    }

    @Override // defpackage.fn
    public final Object a() {
        return ix0.a(this.g);
    }

    @Override // defpackage.yd
    public final IntentFilter e() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    @Override // defpackage.yd
    public final void f(Intent intent) {
        if (qg0.d(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
            ka0 ka0VarJ = ka0.j();
            int i = ix0.a;
            ka0VarJ.getClass();
            b(ix0.a(this.g));
        }
    }
}
