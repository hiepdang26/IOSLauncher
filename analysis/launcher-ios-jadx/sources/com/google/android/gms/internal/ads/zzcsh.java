package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcsh implements zzgcf {
    final /* synthetic */ zzgcf zza;
    final /* synthetic */ zzcsj zzb;

    public zzcsh(zzcsj zzcsjVar, zzgcf zzgcfVar) {
        this.zza = zzgcfVar;
        this.zzb = zzcsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        this.zza.zza(th);
        zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsd
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcsj.zzb(this.zzb, ((zzcsc) obj).zza, this.zza);
    }
}
