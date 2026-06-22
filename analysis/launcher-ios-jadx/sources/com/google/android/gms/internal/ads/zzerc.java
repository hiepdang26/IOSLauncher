package com.google.android.gms.internal.ads;

import defpackage.n42;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzerc implements zzhfc {
    private final zzhfu zza;

    public zzerc(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        zzfxw zzfxwVarZzn;
        zzeqi zzeqiVarZza = zzeqk.zza();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zza.zzb();
        if (((Boolean) n42.d.c.zza(zzbbw.zzdG)).booleanValue()) {
            zzfxwVarZzn = zzfxw.zzo(new zzetw(zzeqiVarZza, ((Integer) r3.c.zza(zzbbw.zzdH)).intValue(), scheduledExecutorService));
        } else {
            zzfxwVarZzn = zzfxw.zzn();
        }
        zzhfk.zzb(zzfxwVarZzn);
        return zzfxwVarZzn;
    }
}
