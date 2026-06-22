package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfkc implements zzgcf {
    final /* synthetic */ zzfkf zza;
    final /* synthetic */ zzfju zzb;
    final /* synthetic */ boolean zzc;

    public zzfkc(zzfkf zzfkfVar, zzfju zzfjuVar, boolean z) {
        this.zza = zzfkfVar;
        this.zzb = zzfjuVar;
        this.zzc = z;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        zzfju zzfjuVar = this.zzb;
        if (zzfjuVar.zzk()) {
            zzfkf zzfkfVar = this.zza;
            zzfjuVar.zzh(th);
            zzfjuVar.zzg(false);
            zzfkfVar.zza(zzfjuVar);
            if (this.zzc) {
                this.zza.zzh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(Object obj) {
        zzfju zzfjuVar = this.zzb;
        zzfjuVar.zzg(true);
        this.zza.zza(zzfjuVar);
        if (this.zzc) {
            this.zza.zzh();
        }
    }
}
