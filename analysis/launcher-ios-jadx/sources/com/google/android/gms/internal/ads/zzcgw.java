package com.google.android.gms.internal.ads;

import defpackage.n42;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgw implements zzhfc {
    private final zzhfu zza;

    public zzcgw(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        zzdup zzdupVar = (zzdup) this.zza.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        Set setSingleton = ((Boolean) n42.d.c.zza(zzbbw.zzbt)).booleanValue() ? Collections.singleton(new zzdei(zzdupVar, zzgcuVar)) : Collections.EMPTY_SET;
        zzhfk.zzb(setSingleton);
        return setSingleton;
    }
}
