package com.google.android.gms.internal.ads;

import defpackage.n42;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzequ implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzequ(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        return new zzetw(((zzeoh) this.zza).zzb(), ((Integer) n42.d.c.zza(zzbbw.zzlt)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
