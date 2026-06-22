package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class zzpd {
    private final Handler zza;
    private final zzpe zzb;

    public zzpd(Handler handler, zzpe zzpeVar) {
        this.zza = zzpeVar == null ? null : handler;
        this.zzb = zzpeVar;
    }

    public final void zza(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzox
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj(exc);
                }
            });
        }
    }

    public final void zzb(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoy
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzk(exc);
                }
            });
        }
    }

    public final void zzc(final zzpf zzpfVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzov
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzl(zzpfVar);
                }
            });
        }
    }

    public final void zzd(final zzpf zzpfVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzow
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzm(zzpfVar);
                }
            });
        }
    }

    public final void zze(final String str, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpb
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzn(str, j, j2);
                }
            });
        }
    }

    public final void zzf(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpc
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzo(str);
                }
            });
        }
    }

    public final void zzg(final zzhn zzhnVar) {
        zzhnVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzos
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzp(zzhnVar);
                }
            });
        }
    }

    public final void zzh(final zzhn zzhnVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzor
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzq(zzhnVar);
                }
            });
        }
    }

    public final void zzi(final zzaf zzafVar, final zzho zzhoVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoz
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzr(zzafVar, zzhoVar);
                }
            });
        }
    }

    public final /* synthetic */ void zzj(Exception exc) {
        int i = zzet.zza;
        this.zzb.zza(exc);
    }

    public final /* synthetic */ void zzk(Exception exc) {
        int i = zzet.zza;
        this.zzb.zzh(exc);
    }

    public final /* synthetic */ void zzl(zzpf zzpfVar) {
        int i = zzet.zza;
        this.zzb.zzi(zzpfVar);
    }

    public final /* synthetic */ void zzm(zzpf zzpfVar) {
        int i = zzet.zza;
        this.zzb.zzj(zzpfVar);
    }

    public final /* synthetic */ void zzn(String str, long j, long j2) {
        int i = zzet.zza;
        this.zzb.zzb(str, j, j2);
    }

    public final /* synthetic */ void zzo(String str) {
        int i = zzet.zza;
        this.zzb.zzc(str);
    }

    public final /* synthetic */ void zzp(zzhn zzhnVar) {
        zzhnVar.zza();
        int i = zzet.zza;
        this.zzb.zzd(zzhnVar);
    }

    public final /* synthetic */ void zzq(zzhn zzhnVar) {
        int i = zzet.zza;
        this.zzb.zze(zzhnVar);
    }

    public final /* synthetic */ void zzr(zzaf zzafVar, zzho zzhoVar) {
        int i = zzet.zza;
        this.zzb.zzf(zzafVar, zzhoVar);
    }

    public final /* synthetic */ void zzs(long j) {
        int i = zzet.zza;
        this.zzb.zzg(j);
    }

    public final /* synthetic */ void zzt(boolean z) {
        int i = zzet.zza;
        this.zzb.zzn(z);
    }

    public final /* synthetic */ void zzu(int i, long j, long j2) {
        int i2 = zzet.zza;
        this.zzb.zzk(i, j, j2);
    }

    public final void zzv(final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzot
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzs(j);
                }
            });
        }
    }

    public final void zzw(final boolean z) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpa
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzt(z);
                }
            });
        }
    }

    public final void zzx(final int i, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzou
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzu(i, j, j2);
                }
            });
        }
    }
}
