package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzelp implements zzemz {
    final /* synthetic */ zzelq zza;

    public zzelp(zzelq zzelqVar) {
        this.zza = zzelqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcpk zzcpkVar = (zzcpk) obj;
        synchronized (this.zza) {
            try {
                zzelq zzelqVar = this.zza;
                if (zzelqVar.zzi != null) {
                    zzelqVar.zzi.zzb();
                }
                this.zza.zzi = zzcpkVar;
                this.zza.zzi.zzk();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
