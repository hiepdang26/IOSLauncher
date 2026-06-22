package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaue implements zzfpk {
    final /* synthetic */ zzfoh zza;

    public zzaue(zzfoh zzfohVar) {
        this.zza = zzfohVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfpk
    public final void zza(int i, long j) {
        this.zza.zzd(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzfpk
    public final void zzb(int i, long j, String str) {
        this.zza.zze(i, System.currentTimeMillis() - j, str);
    }
}
