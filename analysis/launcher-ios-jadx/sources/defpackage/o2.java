package defpackage;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class o2 extends va {
    public u2[] getAdSizes() {
        return this.g.g;
    }

    public u6 getAppEventListener() {
        return this.g.h;
    }

    public ur1 getVideoController() {
        return this.g.c;
    }

    public zr1 getVideoOptions() {
        return this.g.j;
    }

    public void setAdSizes(u2... u2VarArr) {
        if (u2VarArr == null || u2VarArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.g.d(u2VarArr);
    }

    public void setAppEventListener(u6 u6Var) {
        this.g.e(u6Var);
    }

    public void setManualImpressionsEnabled(boolean z) {
        o92 o92Var = this.g;
        o92Var.m = z;
        try {
            v52 v52Var = o92Var.i;
            if (v52Var != null) {
                v52Var.zzN(z);
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public void setVideoOptions(zr1 zr1Var) {
        o92 o92Var = this.g;
        o92Var.j = zr1Var;
        try {
            v52 v52Var = o92Var.i;
            if (v52Var != null) {
                v52Var.zzU(zr1Var == null ? null : new ta2(zr1Var));
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }
}
