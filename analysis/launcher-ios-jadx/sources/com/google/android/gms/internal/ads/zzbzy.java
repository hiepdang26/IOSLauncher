package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzbzy implements zzgcf {
    final /* synthetic */ zzcaa zza;

    public zzbzy(zzcaa zzcaaVar) {
        this.zza = zzcaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        this.zza.zzb.set(-1);
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(Object obj) {
        this.zza.zzb.set(1);
    }
}
