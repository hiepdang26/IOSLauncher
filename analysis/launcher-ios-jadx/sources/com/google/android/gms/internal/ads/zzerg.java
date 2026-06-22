package com.google.android.gms.internal.ads;

import defpackage.n42;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzerg implements zzhfc {
    private final zzhfu zza;

    public zzerg(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        return new zzetw(zzesg.zza(), ((Integer) n42.d.c.zza(zzbbw.zzlm)).intValue(), (ScheduledExecutorService) this.zza.zzb());
    }
}
