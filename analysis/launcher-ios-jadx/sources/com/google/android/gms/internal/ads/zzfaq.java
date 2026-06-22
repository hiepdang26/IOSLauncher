package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfaq implements zzemz {
    final /* synthetic */ zzfar zza;

    public zzfaq(zzfar zzfarVar) {
        this.zza = zzfarVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcpe zzcpeVar = (zzcpe) obj;
        synchronized (this.zza) {
            try {
                zzcpe zzcpeVar2 = this.zza.zza;
                if (zzcpeVar2 != null) {
                    zzcpeVar2.zzb();
                }
                zzfar zzfarVar = this.zza;
                zzfarVar.zza = zzcpeVar;
                zzcpeVar.zzc(zzfarVar);
                zzfar zzfarVar2 = this.zza;
                zzfarVar2.zzg.zzk(new zzcpf(zzcpeVar, zzfarVar2, zzfarVar2.zzg, zzfarVar2.zzi));
                zzcpeVar.zzk();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
