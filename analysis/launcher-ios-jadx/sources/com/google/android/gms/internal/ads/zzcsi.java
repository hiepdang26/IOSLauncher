package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcsi implements zzgcf {
    final /* synthetic */ zzgcf zza;
    final /* synthetic */ zzcsj zzb;

    public zzcsi(zzcsj zzcsjVar, zzgcf zzgcfVar) {
        this.zza = zzgcfVar;
        this.zzb = zzcsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsd
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
        this.zza.zza(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsd
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
        this.zza.zzb((zzcru) obj);
    }
}
