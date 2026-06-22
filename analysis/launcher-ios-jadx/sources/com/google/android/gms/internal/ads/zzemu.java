package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzemu implements zzemz {
    final /* synthetic */ zzemv zza;

    public zzemu(zzemv zzemvVar) {
        this.zza = zzemvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final void zza() {
        synchronized (this.zza) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            this.zza.zzc = ((zzcru) obj).zzm();
            ((zzcru) obj).zzk();
        }
    }
}
