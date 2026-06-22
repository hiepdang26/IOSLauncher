package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzeod implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzeod(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        do0 do0Var = (do0) this.zza.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzeoc(do0Var, zzgcuVar, (ScheduledExecutorService) this.zzb.zzb());
    }
}
