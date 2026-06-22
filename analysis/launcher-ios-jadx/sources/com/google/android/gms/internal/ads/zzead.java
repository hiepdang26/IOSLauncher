package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzead implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzead(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeac zzb() {
        return new zzeac(((zzcgp) this.zza).zza(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
