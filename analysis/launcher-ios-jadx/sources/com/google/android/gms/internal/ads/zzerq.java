package com.google.android.gms.internal.ads;

import defpackage.n42;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzerq implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzerq(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        return new zzetw(((zzevf) this.zza).zzb(), ((Integer) n42.d.c.zza(zzbbw.zzlf)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
