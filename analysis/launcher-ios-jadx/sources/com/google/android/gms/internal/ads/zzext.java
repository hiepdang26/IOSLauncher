package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzext implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;

    public zzext(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5, zzhfu zzhfuVar6, zzhfu zzhfuVar7) {
        this.zza = zzhfuVar2;
        this.zzb = zzhfuVar3;
        this.zzc = zzhfuVar4;
        this.zzd = zzhfuVar5;
        this.zze = zzhfuVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbyv zzbyvVar = new zzbyv();
        int iIntValue = ((zzeys) this.zza).zzb().intValue();
        Context contextZza = ((zzcgp) this.zzb).zza();
        zzbze zzbzeVar = (zzbze) this.zzc.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzd.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzexr(zzbyvVar, iIntValue, contextZza, zzbzeVar, scheduledExecutorService, zzgcuVar, ((zzeyr) this.zze).zza());
    }
}
