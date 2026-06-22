package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzexn implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzexn(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar3;
        this.zzc = zzhfuVar4;
    }

    public static zzexl zza(String str, zzazy zzazyVar, zzbze zzbzeVar, ScheduledExecutorService scheduledExecutorService, zzgcu zzgcuVar) {
        return new zzexl(str, zzazyVar, zzbzeVar, scheduledExecutorService, zzgcuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        String strZza = ((zzeyr) this.zza).zza();
        zzazy zzazyVar = new zzazy();
        zzbze zzbzeVar = (zzbze) this.zzb.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzc.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzexl(strZza, zzazyVar, zzbzeVar, scheduledExecutorService, zzgcuVar);
    }
}
