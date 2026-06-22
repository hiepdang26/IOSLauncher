package defpackage;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class kq1 implements LocationListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ oq1 b;

    public /* synthetic */ kq1(oq1 oq1Var, int i) {
        this.a = i;
        this.b = oq1Var;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        switch (this.a) {
            case 0:
                oq1 oq1Var = this.b;
                oq1Var.b.gotLocation(location, oq1Var.g);
                try {
                    oq1Var.a.removeUpdates(this);
                    oq1Var.a.removeUpdates(oq1Var.i);
                    break;
                } catch (SecurityException unused) {
                }
                lq1 lq1Var = oq1Var.f;
                if (lq1Var != null) {
                    oq1Var.e.removeCallbacks(lq1Var);
                    oq1Var.f = null;
                }
                break;
            default:
                oq1 oq1Var2 = this.b;
                oq1Var2.b.gotLocation(location, oq1Var2.g);
                try {
                    oq1Var2.a.removeUpdates(this);
                    oq1Var2.a.removeUpdates(oq1Var2.h);
                    break;
                } catch (SecurityException unused2) {
                }
                lq1 lq1Var2 = oq1Var2.f;
                if (lq1Var2 != null) {
                    oq1Var2.e.removeCallbacks(lq1Var2);
                    oq1Var2.f = null;
                }
                break;
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
        int i = this.a;
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
        int i = this.a;
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
        int i2 = this.a;
    }

    private final void a(String str) {
    }

    private final void b(String str) {
    }

    private final void c(String str) {
    }

    private final void d(String str) {
    }

    private final void e(String str, int i, Bundle bundle) {
    }

    private final void f(String str, int i, Bundle bundle) {
    }
}
