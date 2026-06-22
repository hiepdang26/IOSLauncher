package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxl implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzdxl(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar4;
        this.zzc = zzhfuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdxk zzb() {
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zza.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        zzgcu zzgcuVar2 = zzbzo.zzb;
        zzhfk.zzb(zzgcuVar2);
        return new zzdxk(scheduledExecutorService, zzgcuVar, zzgcuVar2, ((zzdyd) this.zzb).zzb(), zzhfb.zza(zzhfn.zza(this.zzc)));
    }
}
