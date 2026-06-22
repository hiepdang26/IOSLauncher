package com.google.android.gms.internal.ads;

import defpackage.n42;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdqv implements zzhfc {
    private final zzhfu zza;

    public zzdqv(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        Set setSingleton = ((Boolean) n42.d.c.zza(zzbbw.zzet)).booleanValue() ? Collections.singleton(new zzdei(((zzdro) this.zza).zzb(), zzgcuVar)) : Collections.EMPTY_SET;
        zzhfk.zzb(setSingleton);
        return setSingleton;
    }
}
