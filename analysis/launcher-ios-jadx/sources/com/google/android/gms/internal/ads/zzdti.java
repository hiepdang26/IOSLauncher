package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import defpackage.b22;
import defpackage.hd2;
import defpackage.j92;
import defpackage.k92;
import defpackage.u6;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzdti implements u6, zzczo, b22, zzcwq, zzcxk, zzcxl, zzcye, zzcwt, zzfjm {
    private final List zza;
    private final zzdsw zzb;
    private long zzc;

    public zzdti(zzdsw zzdswVar, zzcgj zzcgjVar) {
        this.zzb = zzdswVar;
        this.zza = Collections.singletonList(zzcgjVar);
    }

    private final void zzg(Class cls, String str, Object... objArr) {
        this.zzb.zza(this.zza, "Event-".concat(cls.getSimpleName()), str, objArr);
    }

    @Override // defpackage.b22
    public final void onAdClicked() {
        zzg(b22.class, "onAdClicked", new Object[0]);
    }

    @Override // defpackage.u6
    public final void onAppEvent(String str, String str2) {
        zzg(u6.class, "onAppEvent", str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zza() {
        zzg(zzcwq.class, "onAdClosed", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzb() {
        zzg(zzcwq.class, "onAdLeftApplication", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzc() {
        zzg(zzcwq.class, "onAdOpened", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzd(zzfjf zzfjfVar, String str) {
        zzg(zzfje.class, "onTaskSucceeded", str);
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdB(j92 j92Var) {
        zzg(zzcwt.class, "onAdFailedToLoad", Integer.valueOf(j92Var.g), j92Var.h, j92Var.i);
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdC(zzfjf zzfjfVar, String str) {
        zzg(zzfje.class, "onTaskCreated", str);
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdD(zzfjf zzfjfVar, String str, Throwable th) {
        zzg(zzfje.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdE(zzfjf zzfjfVar, String str) {
        zzg(zzfje.class, "onTaskStarted", str);
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdj(Context context) {
        zzg(zzcxl.class, "onDestroy", context);
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdl(Context context) {
        zzg(zzcxl.class, "onPause", context);
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdm(Context context) {
        zzg(zzcxl.class, "onResume", context);
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdn(zzbvb zzbvbVar) {
        hd2.B.j.getClass();
        this.zzc = SystemClock.elapsedRealtime();
        zzg(zzczo.class, "onAdRequest", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdo(zzfex zzfexVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzds(zzbvn zzbvnVar, String str, String str2) {
        zzg(zzcwq.class, "onRewarded", zzbvnVar, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zze() {
        zzg(zzcwq.class, "onRewardedVideoCompleted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzf() {
        zzg(zzcwq.class, "onRewardedVideoStarted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final void zzr() {
        zzg(zzcxk.class, "onAdImpression", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final void zzs() {
        hd2.B.j.getClass();
        k92.a("Ad Request Latency : " + (SystemClock.elapsedRealtime() - this.zzc));
        zzg(zzcye.class, "onAdLoaded", new Object[0]);
    }
}
