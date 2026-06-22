package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzezg implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;

    public zzezg(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5, zzhfu zzhfuVar6, zzhfu zzhfuVar7) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar6;
        this.zze = zzhfuVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbze zzbzeVar = (zzbze) this.zza.zzb();
        boolean zBooleanValue = ((zzeyu) this.zzb).zzb().booleanValue();
        boolean zBooleanValue2 = ((zzeyv) this.zzc).zzb().booleanValue();
        zzbyt zzbytVar = new zzbyt();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzeze(zzbzeVar, zBooleanValue, zBooleanValue2, zzbytVar, zzgcuVar, ((zzeyr) this.zzd).zza(), (ScheduledExecutorService) this.zze.zzb());
    }
}
