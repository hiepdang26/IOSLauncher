package com.google.android.gms.internal.ads;

import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
public final class zzdtp {
    private final zzbjw zza;

    public zzdtp(zzbjw zzbjwVar) {
        this.zza = zzbjwVar;
    }

    private final void zzs(zzdto zzdtoVar) {
        String strZza = zzdto.zza(zzdtoVar);
        k92.g("Dispatching AFMA event on publisher webview: ".concat(strZza));
        this.zza.zzb(strZza);
    }

    public final void zza() {
        zzs(new zzdto("initialize", null));
    }

    public final void zzb(long j) {
        zzdto zzdtoVar = new zzdto("interstitial", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onAdClicked";
        this.zza.zzb(zzdto.zza(zzdtoVar));
    }

    public final void zzc(long j) {
        zzdto zzdtoVar = new zzdto("interstitial", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onAdClosed";
        zzs(zzdtoVar);
    }

    public final void zzd(long j, int i) {
        zzdto zzdtoVar = new zzdto("interstitial", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onAdFailedToLoad";
        zzdtoVar.zzd = Integer.valueOf(i);
        zzs(zzdtoVar);
    }

    public final void zze(long j) {
        zzdto zzdtoVar = new zzdto("interstitial", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onAdLoaded";
        zzs(zzdtoVar);
    }

    public final void zzf(long j) {
        zzdto zzdtoVar = new zzdto("interstitial", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdtoVar);
    }

    public final void zzg(long j) {
        zzdto zzdtoVar = new zzdto("interstitial", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onAdOpened";
        zzs(zzdtoVar);
    }

    public final void zzh(long j) {
        zzdto zzdtoVar = new zzdto("creation", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "nativeObjectCreated";
        zzs(zzdtoVar);
    }

    public final void zzi(long j) {
        zzdto zzdtoVar = new zzdto("creation", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "nativeObjectNotCreated";
        zzs(zzdtoVar);
    }

    public final void zzj(long j) {
        zzdto zzdtoVar = new zzdto("rewarded", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onAdClicked";
        zzs(zzdtoVar);
    }

    public final void zzk(long j) {
        zzdto zzdtoVar = new zzdto("rewarded", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onRewardedAdClosed";
        zzs(zzdtoVar);
    }

    public final void zzl(long j, zzbwd zzbwdVar) {
        zzdto zzdtoVar = new zzdto("rewarded", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onUserEarnedReward";
        zzdtoVar.zze = zzbwdVar.zzf();
        zzdtoVar.zzf = Integer.valueOf(zzbwdVar.zze());
        zzs(zzdtoVar);
    }

    public final void zzm(long j, int i) {
        zzdto zzdtoVar = new zzdto("rewarded", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onRewardedAdFailedToLoad";
        zzdtoVar.zzd = Integer.valueOf(i);
        zzs(zzdtoVar);
    }

    public final void zzn(long j, int i) {
        zzdto zzdtoVar = new zzdto("rewarded", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onRewardedAdFailedToShow";
        zzdtoVar.zzd = Integer.valueOf(i);
        zzs(zzdtoVar);
    }

    public final void zzo(long j) {
        zzdto zzdtoVar = new zzdto("rewarded", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onAdImpression";
        zzs(zzdtoVar);
    }

    public final void zzp(long j) {
        zzdto zzdtoVar = new zzdto("rewarded", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onRewardedAdLoaded";
        zzs(zzdtoVar);
    }

    public final void zzq(long j) {
        zzdto zzdtoVar = new zzdto("rewarded", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdtoVar);
    }

    public final void zzr(long j) {
        zzdto zzdtoVar = new zzdto("rewarded", null);
        zzdtoVar.zza = Long.valueOf(j);
        zzdtoVar.zzc = "onRewardedAdOpened";
        zzs(zzdtoVar);
    }
}
