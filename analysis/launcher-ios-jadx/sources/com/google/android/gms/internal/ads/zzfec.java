package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import defpackage.cd2;
import defpackage.gy0;
import defpackage.hd2;
import defpackage.he0;
import defpackage.hg0;
import defpackage.j82;
import defpackage.k92;
import defpackage.m82;
import defpackage.n42;
import defpackage.or1;
import defpackage.tb2;
import defpackage.u82;

/* JADX INFO: loaded from: classes.dex */
public final class zzfec extends zzbwf {
    private final zzfdy zza;
    private final zzfdo zzb;
    private final String zzc;
    private final zzfey zzd;
    private final Context zze;
    private final or1 zzf;
    private final zzauo zzg;
    private final zzdsk zzh;
    private zzdop zzi;
    private boolean zzj = ((Boolean) n42.d.c.zza(zzbbw.zzav)).booleanValue();

    public zzfec(String str, zzfdy zzfdyVar, Context context, zzfdo zzfdoVar, zzfey zzfeyVar, or1 or1Var, zzauo zzauoVar, zzdsk zzdskVar) {
        this.zzc = str;
        this.zza = zzfdyVar;
        this.zzb = zzfdoVar;
        this.zzd = zzfeyVar;
        this.zze = context;
        this.zzf = or1Var;
        this.zzg = zzauoVar;
        this.zzh = zzdskVar;
    }

    private final synchronized void zzu(tb2 tb2Var, zzbwn zzbwnVar, int i) {
        try {
            boolean z = false;
            if (((Boolean) zzbdq.zzk.zze()).booleanValue()) {
                if (((Boolean) n42.d.c.zza(zzbbw.zzkl)).booleanValue()) {
                    z = true;
                }
            }
            if (this.zzf.i < ((Integer) n42.d.c.zza(zzbbw.zzkm)).intValue() || !z) {
                hg0.g("#008 Must be called on the main UI thread.");
            }
            this.zzb.zzk(zzbwnVar);
            cd2 cd2Var = hd2.B.c;
            if (cd2.f(this.zze) && tb2Var.y == null) {
                k92.e("Failed to load the ad because app ID is missing.");
                this.zzb.zzdB(zzfgi.zzd(4, null, null));
                return;
            }
            if (this.zzi != null) {
                return;
            }
            zzfdq zzfdqVar = new zzfdq(null);
            this.zza.zzj(i);
            this.zza.zzb(tb2Var, this.zzc, zzfdqVar, new zzfeb(this));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final Bundle zzb() {
        hg0.g("#008 Must be called on the main UI thread.");
        zzdop zzdopVar = this.zzi;
        return zzdopVar != null ? zzdopVar.zza() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final u82 zzc() {
        zzdop zzdopVar;
        if (((Boolean) n42.d.c.zza(zzbbw.zzgc)).booleanValue() && (zzdopVar = this.zzi) != null) {
            return zzdopVar.zzm();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final zzbwd zzd() {
        hg0.g("#008 Must be called on the main UI thread.");
        zzdop zzdopVar = this.zzi;
        if (zzdopVar != null) {
            return zzdopVar.zzc();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final synchronized String zze() {
        zzdop zzdopVar = this.zzi;
        if (zzdopVar == null || zzdopVar.zzm() == null) {
            return null;
        }
        return zzdopVar.zzm().zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final synchronized void zzf(tb2 tb2Var, zzbwn zzbwnVar) {
        zzu(tb2Var, zzbwnVar, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final synchronized void zzg(tb2 tb2Var, zzbwn zzbwnVar) {
        zzu(tb2Var, zzbwnVar, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final synchronized void zzh(boolean z) {
        hg0.g("setImmersiveMode must be called on the main UI thread.");
        this.zzj = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzi(j82 j82Var) {
        if (j82Var == null) {
            this.zzb.zzg(null);
        } else {
            this.zzb.zzg(new zzfea(this, j82Var));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzj(m82 m82Var) {
        hg0.g("setOnPaidEventListener must be called on the main UI thread.");
        try {
            if (!m82Var.zzf()) {
                this.zzh.zze();
            }
        } catch (RemoteException unused) {
            k92.j(3);
        }
        this.zzb.zzi(m82Var);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzk(zzbwj zzbwjVar) {
        hg0.g("#008 Must be called on the main UI thread.");
        this.zzb.zzj(zzbwjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final synchronized void zzl(zzbwu zzbwuVar) {
        hg0.g("#008 Must be called on the main UI thread.");
        zzfey zzfeyVar = this.zzd;
        zzfeyVar.zza = zzbwuVar.zza;
        zzfeyVar.zzb = zzbwuVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final synchronized void zzm(he0 he0Var) {
        zzn(he0Var, this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final synchronized void zzn(he0 he0Var, boolean z) {
        hg0.g("#008 Must be called on the main UI thread.");
        if (this.zzi == null) {
            k92.h("Rewarded can not be shown before loaded");
            this.zzb.zzq(zzfgi.zzd(9, null, null));
            return;
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzct)).booleanValue()) {
            this.zzg.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzi.zzh(z, (Activity) gy0.r(he0Var));
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final boolean zzo() {
        hg0.g("#008 Must be called on the main UI thread.");
        zzdop zzdopVar = this.zzi;
        return (zzdopVar == null || zzdopVar.zzf()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzp(zzbwo zzbwoVar) {
        hg0.g("#008 Must be called on the main UI thread.");
        this.zzb.zzo(zzbwoVar);
    }
}
