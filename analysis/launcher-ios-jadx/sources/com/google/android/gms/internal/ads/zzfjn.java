package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzfjn implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzfjn(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar2;
        this.zzb = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzfjl(zzgcuVar, (ScheduledExecutorService) this.zza.zzb(), ((zzfjo) this.zzb).zzb());
    }
}
