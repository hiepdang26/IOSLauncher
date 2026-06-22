package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzehw implements zzgcf {
    final /* synthetic */ zzfel zza;
    final /* synthetic */ zzehx zzb;

    public zzehw(zzehx zzehxVar, zzfel zzfelVar) {
        this.zza = zzfelVar;
        this.zzb = zzehxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            try {
                this.zzb.zzh.zzb(th, this.zza);
                zzfel zzfelVarZza = this.zzb.zzh.zza();
                if (this.zza.zzav) {
                    while (zzfelVarZza != null) {
                        this.zzb.zze(zzfelVarZza);
                        zzfelVarZza = this.zzb.zzh.zza();
                    }
                } else if (zzfelVarZza != null) {
                    this.zzb.zze(zzfelVarZza);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeio zzeioVar = (zzeio) obj;
        synchronized (this.zzb) {
            try {
                this.zzb.zzh.zzc(zzeioVar, this.zza);
                zzfel zzfelVarZza = this.zzb.zzh.zza();
                if (zzfelVarZza != null) {
                    this.zzb.zze(zzfelVarZza);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
