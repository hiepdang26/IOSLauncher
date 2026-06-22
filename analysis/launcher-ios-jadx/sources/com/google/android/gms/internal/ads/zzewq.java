package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzewq implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;

    public zzewq(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5, zzhfu zzhfuVar6, zzhfu zzhfuVar7) {
        this.zza = zzhfuVar2;
        this.zzb = zzhfuVar3;
        this.zzc = zzhfuVar5;
        this.zzd = zzhfuVar6;
        this.zze = zzhfuVar7;
    }

    public static zzewo zza(zzbyv zzbyvVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        return new zzewo(zzbyvVar, context, scheduledExecutorService, executor, i, z, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbyv zzbyvVar = new zzbyv();
        Context contextZza = ((zzcgp) this.zza).zza();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzb.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzewo(zzbyvVar, contextZza, scheduledExecutorService, zzgcuVar, ((zzeys) this.zzc).zzb().intValue(), ((zzeyt) this.zzd).zzb().booleanValue(), ((zzeyv) this.zze).zzb().booleanValue());
    }
}
