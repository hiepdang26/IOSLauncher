package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzaax {
    private final Handler zza;
    private final zzaay zzb;

    public zzaax(Handler handler, zzaay zzaayVar) {
        this.zza = zzaayVar == null ? null : handler;
        this.zzb = zzaayVar;
    }

    public final void zza(final String str, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaan
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzg(str, j, j2);
                }
            });
        }
    }

    public final void zzb(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaaw
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzh(str);
                }
            });
        }
    }

    public final void zzc(final zzhn zzhnVar) {
        zzhnVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaav
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzi(zzhnVar);
                }
            });
        }
    }

    public final void zzd(final int i, final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaap
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj(i, j);
                }
            });
        }
    }

    public final void zze(final zzhn zzhnVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaat
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzk(zzhnVar);
                }
            });
        }
    }

    public final void zzf(final zzaf zzafVar, final zzho zzhoVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaau
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzl(zzafVar, zzhoVar);
                }
            });
        }
    }

    public final /* synthetic */ void zzg(String str, long j, long j2) {
        int i = zzet.zza;
        this.zzb.zzp(str, j, j2);
    }

    public final /* synthetic */ void zzh(String str) {
        int i = zzet.zza;
        this.zzb.zzq(str);
    }

    public final /* synthetic */ void zzi(zzhn zzhnVar) {
        zzhnVar.zza();
        int i = zzet.zza;
        this.zzb.zzr(zzhnVar);
    }

    public final /* synthetic */ void zzj(int i, long j) {
        int i2 = zzet.zza;
        this.zzb.zzl(i, j);
    }

    public final /* synthetic */ void zzk(zzhn zzhnVar) {
        int i = zzet.zza;
        this.zzb.zzs(zzhnVar);
    }

    public final /* synthetic */ void zzl(zzaf zzafVar, zzho zzhoVar) {
        int i = zzet.zza;
        this.zzb.zzu(zzafVar, zzhoVar);
    }

    public final /* synthetic */ void zzm(Object obj, long j) {
        int i = zzet.zza;
        this.zzb.zzm(obj, j);
    }

    public final /* synthetic */ void zzn(long j, int i) {
        int i2 = zzet.zza;
        this.zzb.zzt(j, i);
    }

    public final /* synthetic */ void zzo(Exception exc) {
        int i = zzet.zza;
        this.zzb.zzo(exc);
    }

    public final /* synthetic */ void zzp(zzcp zzcpVar) {
        int i = zzet.zza;
        this.zzb.zzv(zzcpVar);
    }

    public final void zzq(final Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaaq
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzm(obj, jElapsedRealtime);
                }
            });
        }
    }

    public final void zzr(final long j, final int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaar
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzn(j, i);
                }
            });
        }
    }

    public final void zzs(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaas
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzo(exc);
                }
            });
        }
    }

    public final void zzt(final zzcp zzcpVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaao
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzp(zzcpVar);
                }
            });
        }
    }
}
