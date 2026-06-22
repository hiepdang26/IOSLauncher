package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzetu implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzetu(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar2;
        this.zzb = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzets zzb() {
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzets(zzgcuVar, ((zzcgp) this.zza).zza(), (Set) this.zzb.zzb());
    }
}
