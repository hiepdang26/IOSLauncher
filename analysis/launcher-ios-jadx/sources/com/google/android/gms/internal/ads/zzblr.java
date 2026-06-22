package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import defpackage.a70;
import defpackage.d32;
import defpackage.db2;
import defpackage.e92;
import defpackage.gy0;
import defpackage.k2;
import defpackage.k92;
import defpackage.lc2;
import defpackage.q2;
import defpackage.q42;
import defpackage.qa2;
import defpackage.rc2;
import defpackage.s32;
import defpackage.u6;
import defpackage.u82;
import defpackage.v52;
import defpackage.wb1;
import defpackage.x32;
import defpackage.xo0;
import defpackage.zy0;

/* JADX INFO: loaded from: classes.dex */
public final class zzblr extends q2 {
    private final Context zza;
    private final lc2 zzb;
    private final v52 zzc;
    private final String zzd;
    private final zzboi zze;
    private final long zzf;
    private u6 zzg;
    private a70 zzh;
    private zy0 zzi;

    public zzblr(Context context, String str) {
        zzboi zzboiVar = new zzboi();
        this.zze = zzboiVar;
        this.zzf = System.currentTimeMillis();
        this.zza = context;
        this.zzd = str;
        this.zzb = lc2.a;
        s32 s32Var = x32.f.b;
        rc2 rc2Var = new rc2();
        s32Var.getClass();
        this.zzc = (v52) new d32(s32Var, context, rc2Var, str, zzboiVar).d(context, false);
    }

    public final String getAdUnitId() {
        return this.zzd;
    }

    public final u6 getAppEventListener() {
        return this.zzg;
    }

    public final a70 getFullScreenContentCallback() {
        return this.zzh;
    }

    public final zy0 getOnPaidEventListener() {
        return null;
    }

    @Override // defpackage.og0
    public final wb1 getResponseInfo() {
        u82 u82VarZzk = null;
        try {
            v52 v52Var = this.zzc;
            if (v52Var != null) {
                u82VarZzk = v52Var.zzk();
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
        return new wb1(u82VarZzk);
    }

    public final void setAppEventListener(u6 u6Var) {
        try {
            this.zzg = u6Var;
            v52 v52Var = this.zzc;
            if (v52Var != null) {
                v52Var.zzG(u6Var != null ? new zzayk(u6Var) : null);
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.og0
    public final void setFullScreenContentCallback(a70 a70Var) {
        try {
            this.zzh = a70Var;
            v52 v52Var = this.zzc;
            if (v52Var != null) {
                v52Var.zzJ(new q42(a70Var));
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.og0
    public final void setImmersiveMode(boolean z) {
        try {
            v52 v52Var = this.zzc;
            if (v52Var != null) {
                v52Var.zzL(z);
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(zy0 zy0Var) {
        try {
            v52 v52Var = this.zzc;
            if (v52Var != null) {
                v52Var.zzP(new qa2());
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.og0
    public final void show(Activity activity) {
        if (activity == null) {
            k92.h("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            v52 v52Var = this.zzc;
            if (v52Var != null) {
                v52Var.zzW(new gy0(activity));
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void zza(e92 e92Var, k2 k2Var) {
        try {
            v52 v52Var = this.zzc;
            if (v52Var != null) {
                e92Var.k = this.zzf;
                lc2 lc2Var = this.zzb;
                Context context = this.zza;
                lc2Var.getClass();
                v52Var.zzy(lc2.a(context, e92Var), new db2(k2Var, this));
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
            k2Var.onAdFailedToLoad(new xo0(0, "Internal Error.", "com.google.android.gms.ads", null, null));
        }
    }
}
