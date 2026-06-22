package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdyn implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdyn(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdym zzb() {
        Map mapZzd = ((zzhfj) this.zza).zzd();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzdym(mapZzd, zzgcuVar, ((zzczn) this.zzb).zzb());
    }
}
