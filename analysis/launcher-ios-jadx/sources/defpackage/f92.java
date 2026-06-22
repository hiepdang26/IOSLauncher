package defpackage;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class f92 extends j2 {
    public final Object g = new Object();
    public j2 h;
    public final /* synthetic */ o92 i;

    public f92(o92 o92Var) {
        this.i = o92Var;
    }

    @Override // defpackage.j2
    public final void onAdClicked() {
        synchronized (this.g) {
            try {
                j2 j2Var = this.h;
                if (j2Var != null) {
                    j2Var.onAdClicked();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.j2
    public final void onAdClosed() {
        synchronized (this.g) {
            try {
                j2 j2Var = this.h;
                if (j2Var != null) {
                    j2Var.onAdClosed();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.j2
    public final void onAdFailedToLoad(xo0 xo0Var) {
        o92 o92Var = this.i;
        ur1 ur1Var = o92Var.c;
        v52 v52Var = o92Var.i;
        x82 x82VarZzl = null;
        if (v52Var != null) {
            try {
                x82VarZzl = v52Var.zzl();
            } catch (RemoteException e) {
                k92.i("#007 Could not call remote method.", e);
            }
        }
        ur1Var.a(x82VarZzl);
        synchronized (this.g) {
            try {
                j2 j2Var = this.h;
                if (j2Var != null) {
                    j2Var.onAdFailedToLoad(xo0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.j2
    public final void onAdImpression() {
        synchronized (this.g) {
            try {
                j2 j2Var = this.h;
                if (j2Var != null) {
                    j2Var.onAdImpression();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.j2
    public final void onAdLoaded() {
        o92 o92Var = this.i;
        ur1 ur1Var = o92Var.c;
        v52 v52Var = o92Var.i;
        x82 x82VarZzl = null;
        if (v52Var != null) {
            try {
                x82VarZzl = v52Var.zzl();
            } catch (RemoteException e) {
                k92.i("#007 Could not call remote method.", e);
            }
        }
        ur1Var.a(x82VarZzl);
        synchronized (this.g) {
            try {
                j2 j2Var = this.h;
                if (j2Var != null) {
                    j2Var.onAdLoaded();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.j2
    public final void onAdOpened() {
        synchronized (this.g) {
            try {
                j2 j2Var = this.h;
                if (j2Var != null) {
                    j2Var.onAdOpened();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
