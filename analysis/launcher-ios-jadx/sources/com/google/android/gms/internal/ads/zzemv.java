package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.k92;
import defpackage.tb2;
import defpackage.u82;

/* JADX INFO: loaded from: classes.dex */
public final class zzemv {
    private final zzena zza;
    private final String zzb;
    private u82 zzc;

    public zzemv(zzena zzenaVar, String str) {
        this.zza = zzenaVar;
        this.zzb = str;
    }

    public final synchronized String zza() {
        u82 u82Var;
        try {
            u82Var = this.zzc;
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
            return null;
        }
        return u82Var != null ? u82Var.zzg() : null;
    }

    public final synchronized String zzb() {
        u82 u82Var;
        try {
            u82Var = this.zzc;
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
            return null;
        }
        return u82Var != null ? u82Var.zzg() : null;
    }

    public final synchronized void zzd(tb2 tb2Var, int i) {
        this.zzc = null;
        zzenb zzenbVar = new zzenb(i);
        zzemu zzemuVar = new zzemu(this);
        this.zza.zzb(tb2Var, this.zzb, zzenbVar, zzemuVar);
    }

    public final synchronized boolean zze() {
        return this.zza.zza();
    }
}
