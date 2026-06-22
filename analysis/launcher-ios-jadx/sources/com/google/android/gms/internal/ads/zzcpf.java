package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import defpackage.gy0;
import defpackage.he0;
import defpackage.hg0;
import defpackage.k92;
import defpackage.m82;
import defpackage.n42;
import defpackage.u82;
import defpackage.v52;

/* JADX INFO: loaded from: classes.dex */
public final class zzcpf extends zzazo {
    private final zzcpe zza;
    private final v52 zzb;
    private final zzfaj zzc;
    private boolean zzd = ((Boolean) n42.d.c.zza(zzbbw.zzay)).booleanValue();
    private final zzdsk zze;

    public zzcpf(zzcpe zzcpeVar, v52 v52Var, zzfaj zzfajVar, zzdsk zzdskVar) {
        this.zza = zzcpeVar;
        this.zzb = v52Var;
        this.zzc = zzfajVar;
        this.zze = zzdskVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final v52 zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final u82 zzf() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzgc)).booleanValue()) {
            return this.zza.zzm();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final void zzg(boolean z) {
        this.zzd = z;
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final void zzh(m82 m82Var) {
        hg0.g("setOnPaidEventListener must be called on the main UI thread.");
        if (this.zzc != null) {
            try {
                if (!m82Var.zzf()) {
                    this.zze.zze();
                }
            } catch (RemoteException unused) {
                k92.j(3);
            }
            this.zzc.zzn(m82Var);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final void zzi(he0 he0Var, zzazw zzazwVar) {
        try {
            this.zzc.zzp(zzazwVar);
            this.zza.zzd((Activity) gy0.r(he0Var), zzazwVar, this.zzd);
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }
}
