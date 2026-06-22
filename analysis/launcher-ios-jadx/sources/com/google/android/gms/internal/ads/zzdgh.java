package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdgh implements zzhfc {
    private final zzhfu zza;

    public zzdgh(zzhfu zzhfuVar) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = Collections.singleton(new zzdei((zzdha) this.zza.zzb(), zzbzo.zzf));
        zzhfk.zzb(setSingleton);
        return setSingleton;
    }
}
