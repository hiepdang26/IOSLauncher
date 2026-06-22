package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfhm implements zzgcf {
    final /* synthetic */ zzfhp zza;
    final /* synthetic */ zzfhq zzb;

    public zzfhm(zzfhq zzfhqVar, zzfhp zzfhpVar) {
        this.zza = zzfhpVar;
        this.zzb = zzfhqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zze = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zzb) {
            try {
                this.zzb.zze = null;
                this.zzb.zzd.addFirst(this.zza);
                zzfhq zzfhqVar = this.zzb;
                if (zzfhqVar.zzf == 1) {
                    zzfhqVar.zzh();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
