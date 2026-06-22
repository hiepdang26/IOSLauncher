package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import defpackage.hd2;

/* JADX INFO: loaded from: classes.dex */
final class zzdul implements zzgcf {
    final /* synthetic */ zzdun zza;

    public zzdul(zzdun zzdunVar) {
        this.zza = zzdunVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        synchronized (this) {
            this.zza.zzc = true;
            zzdun zzdunVar = this.zza;
            hd2.B.j.getClass();
            zzdunVar.zzv("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (SystemClock.elapsedRealtime() - this.zza.zzd));
            this.zza.zze.zzd(new Exception());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(Object obj) {
        final String str = (String) obj;
        synchronized (this) {
            this.zza.zzc = true;
            zzdun zzdunVar = this.zza;
            hd2.B.j.getClass();
            zzdunVar.zzv("com.google.android.gms.ads.MobileAds", true, "", (int) (SystemClock.elapsedRealtime() - this.zza.zzd));
            this.zza.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduk
                @Override // java.lang.Runnable
                public final void run() {
                    zzdun.zzj(this.zza.zza, str);
                }
            });
        }
    }
}
