package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfja implements zzgcf {
    final /* synthetic */ zzfiq zza;
    final /* synthetic */ zzfjc zzb;

    public zzfja(zzfjc zzfjcVar, zzfiq zzfiqVar) {
        this.zza = zzfiqVar;
        this.zzb = zzfjcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        this.zzb.zza.zzd.zzb(this.zza, th);
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(Object obj) {
        this.zzb.zza.zzd.zzd(this.zza);
    }
}
