package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;

/* JADX INFO: loaded from: classes.dex */
public final class hx0 extends fn {
    public final ConnectivityManager f;
    public final gx0 g;

    public hx0(Context context, qm0 qm0Var) {
        super(context, qm0Var);
        Object systemService = this.b.getSystemService("connectivity");
        qg0.i(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f = (ConnectivityManager) systemService;
        this.g = new gx0(this, 0);
    }

    @Override // defpackage.fn
    public final Object a() {
        return ix0.a(this.f);
    }

    @Override // defpackage.fn
    public final void c() {
        try {
            ka0 ka0VarJ = ka0.j();
            int i = ix0.a;
            ka0VarJ.getClass();
            bx0.a(this.f, this.g);
        } catch (IllegalArgumentException unused) {
            ka0 ka0VarJ2 = ka0.j();
            int i2 = ix0.a;
            ka0VarJ2.getClass();
        } catch (SecurityException unused2) {
            ka0 ka0VarJ3 = ka0.j();
            int i3 = ix0.a;
            ka0VarJ3.getClass();
        }
    }

    @Override // defpackage.fn
    public final void d() {
        try {
            ka0 ka0VarJ = ka0.j();
            int i = ix0.a;
            ka0VarJ.getClass();
            zw0.c(this.f, this.g);
        } catch (IllegalArgumentException unused) {
            ka0 ka0VarJ2 = ka0.j();
            int i2 = ix0.a;
            ka0VarJ2.getClass();
        } catch (SecurityException unused2) {
            ka0 ka0VarJ3 = ka0.j();
            int i3 = ix0.a;
            ka0VarJ3.getClass();
        }
    }
}
