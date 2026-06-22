package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.b22;
import defpackage.nj;
import defpackage.tb2;
import defpackage.us;

/* JADX INFO: loaded from: classes.dex */
public final class zzcto implements zzcye, b22, zzczo, zzcxk, zzcwq, zzdca {
    private final nj zza;
    private final zzbyx zzb;

    public zzcto(nj njVar, zzbyx zzbyxVar) {
        this.zza = njVar;
        this.zzb = zzbyxVar;
    }

    @Override // defpackage.b22
    public final void onAdClicked() {
        this.zzb.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zza() {
        this.zzb.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzc() {
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdn(zzbvb zzbvbVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdo(zzfex zzfexVar) {
        nj njVar = this.zza;
        zzbyx zzbyxVar = this.zzb;
        ((us) njVar).getClass();
        zzbyxVar.zzk(SystemClock.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzds(zzbvn zzbvnVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzf() {
    }

    public final String zzg() {
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzdca
    public final void zzh() {
    }

    @Override // com.google.android.gms.internal.ads.zzdca
    public final void zzi(zzbbc.zzb zzbVar) {
        this.zzb.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzdca
    public final void zzj(zzbbc.zzb zzbVar) {
    }

    public final void zzk(tb2 tb2Var) {
        this.zzb.zzj(tb2Var);
    }

    @Override // com.google.android.gms.internal.ads.zzdca
    public final void zzl(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzdca
    public final void zzm(zzbbc.zzb zzbVar) {
        this.zzb.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzdca
    public final void zzn(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final void zzr() {
        this.zzb.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final void zzs() {
        this.zzb.zzh(true);
    }
}
