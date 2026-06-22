package defpackage;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class oq1 {
    public LocationManager a;
    public mq1 b;
    public lq1 f;
    public boolean c = false;
    public boolean d = false;
    public final Handler e = new Handler(Looper.getMainLooper());
    public nq1 g = null;
    public final kq1 h = new kq1(this, 0);
    public final kq1 i = new kq1(this, 1);

    public final void a(Context context, mq1 mq1Var) {
        nq1 nq1Var = nq1.h;
        this.b = mq1Var;
        if (this.a == null) {
            this.a = (LocationManager) context.getSystemService("location");
        }
        try {
            this.c = this.a.isProviderEnabled("gps");
        } catch (Throwable unused) {
            this.g = nq1Var;
        }
        try {
            this.d = this.a.isProviderEnabled("network") || hs0.o(context);
        } catch (Throwable unused2) {
            this.g = nq1Var;
        }
        boolean z = this.c;
        if (!z && !this.d) {
            mq1Var.gotLocation(null, this.g);
            return;
        }
        nq1 nq1Var2 = nq1.g;
        if (z) {
            try {
                this.a.requestLocationUpdates("gps", 0L, 0.0f, this.h);
            } catch (Throwable unused3) {
                this.g = nq1Var2;
            }
        }
        if (this.d) {
            try {
                this.a.requestLocationUpdates("network", 0L, 0.0f, this.i);
            } catch (Throwable unused4) {
                this.g = nq1Var2;
            }
        }
        nq1 nq1Var3 = this.g;
        if (nq1Var3 != null) {
            this.b.gotLocation(null, nq1Var3);
            return;
        }
        lq1 lq1Var = new lq1(this);
        this.f = lq1Var;
        this.e.postDelayed(lq1Var, 20000L);
    }
}
