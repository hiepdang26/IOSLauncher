package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdte implements zzhfc {
    private final zzhfu zza;

    public zzdte(zzdsy zzdsyVar, zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdti zzdtiVar = (zzdti) this.zza.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        Set setZzf = zzdsy.zzf(zzdtiVar, zzgcuVar);
        zzhfk.zzb(setZzf);
        return setZzf;
    }
}
