package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import defpackage.a70;
import defpackage.c7;
import defpackage.gy0;
import defpackage.k92;
import defpackage.qa2;
import defpackage.u82;
import defpackage.wb1;
import defpackage.zy0;

/* JADX INFO: loaded from: classes.dex */
public final class zzazl extends c7 {
    a70 zza;
    private final zzazp zzb;
    private final String zzc;
    private final zzazm zzd = new zzazm();
    private zy0 zze;

    public zzazl(zzazp zzazpVar, String str) {
        this.zzb = zzazpVar;
        this.zzc = str;
    }

    public final String getAdUnitId() {
        return this.zzc;
    }

    public final a70 getFullScreenContentCallback() {
        return this.zza;
    }

    public final zy0 getOnPaidEventListener() {
        return null;
    }

    @Override // defpackage.c7
    public final wb1 getResponseInfo() {
        u82 u82VarZzf;
        try {
            u82VarZzf = this.zzb.zzf();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
            u82VarZzf = null;
        }
        return new wb1(u82VarZzf);
    }

    public final void setFullScreenContentCallback(a70 a70Var) {
        this.zza = a70Var;
        this.zzd.zzg(a70Var);
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzb.zzg(z);
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(zy0 zy0Var) {
        try {
            this.zzb.zzh(new qa2());
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.c7
    public final void show(Activity activity) {
        try {
            this.zzb.zzi(new gy0(activity), this.zzd);
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }
}
