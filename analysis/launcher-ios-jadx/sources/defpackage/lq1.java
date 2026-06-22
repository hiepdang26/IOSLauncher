package defpackage;

import android.location.Location;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public final class lq1 extends TimerTask {
    public final /* synthetic */ oq1 g;

    public lq1(oq1 oq1Var) {
        this.g = oq1Var;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Location lastKnownLocation;
        Location lastKnownLocation2;
        oq1 oq1Var = this.g;
        try {
            oq1Var.a.removeUpdates(oq1Var.h);
            oq1Var.a.removeUpdates(oq1Var.i);
        } catch (SecurityException unused) {
        }
        boolean z = oq1Var.c;
        nq1 nq1Var = nq1.g;
        if (z) {
            try {
                lastKnownLocation = oq1Var.a.getLastKnownLocation("gps");
            } catch (SecurityException unused2) {
                oq1Var.g = nq1Var;
                lastKnownLocation = null;
            }
        } else {
            lastKnownLocation = null;
        }
        if (oq1Var.d) {
            try {
                lastKnownLocation2 = oq1Var.a.getLastKnownLocation("network");
            } catch (SecurityException unused3) {
                oq1Var.g = nq1Var;
                lastKnownLocation2 = null;
            }
        } else {
            lastKnownLocation2 = null;
        }
        if (lastKnownLocation != null && lastKnownLocation2 != null) {
            if (lastKnownLocation.getTime() > lastKnownLocation2.getTime()) {
                oq1Var.b.gotLocation(lastKnownLocation, oq1Var.g);
                return;
            } else {
                oq1Var.b.gotLocation(lastKnownLocation2, oq1Var.g);
                return;
            }
        }
        if (lastKnownLocation != null) {
            oq1Var.b.gotLocation(lastKnownLocation, oq1Var.g);
        } else {
            if (lastKnownLocation2 != null) {
                oq1Var.b.gotLocation(lastKnownLocation2, oq1Var.g);
                return;
            }
            nq1 nq1Var2 = nq1.i;
            oq1Var.g = nq1Var2;
            oq1Var.b.gotLocation(null, nq1Var2);
        }
    }
}
