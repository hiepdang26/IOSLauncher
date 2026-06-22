package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzemr implements zzemz {
    final /* synthetic */ zzems zza;

    public zzemr(zzems zzemsVar) {
        this.zza = zzemsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzj = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdfo zzdfoVar = (zzdfo) obj;
        synchronized (this.zza) {
            this.zza.zzj = zzdfoVar;
            this.zza.zzj.zzk();
        }
    }
}
