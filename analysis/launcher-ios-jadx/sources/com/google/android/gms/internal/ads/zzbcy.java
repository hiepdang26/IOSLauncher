package com.google.android.gms.internal.ads;

import defpackage.m92;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzbcy implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzbcy(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbcx zzb() {
        return new zzbcx((ScheduledExecutorService) this.zza.zzb(), (m92) this.zzb.zzb());
    }
}
