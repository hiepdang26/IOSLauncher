package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdsz implements zzhfc {
    private final zzhfu zza;

    public zzdsz(zzdsy zzdsyVar, zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdti zzdtiVar = (zzdti) this.zza.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        Set setZza = zzdsy.zza(zzdtiVar, zzgcuVar);
        zzhfk.zzb(setZza);
        return setZza;
    }
}
