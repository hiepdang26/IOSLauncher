package com.google.android.gms.internal.ads;

import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
final class zzegm implements zzgcf {
    final /* synthetic */ zzegn zza;

    public zzegm(zzegn zzegnVar) {
        this.zza = zzegnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        j92 j92VarZza = this.zza.zza.zzd().zza(th);
        this.zza.zzd.zzdB(j92VarZza);
        zzfgd.zzb(j92VarZza.g, th, "DelayedBannerAd.onFailure");
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* synthetic */ void zzb(Object obj) {
        ((zzcpk) obj).zzk();
    }
}
