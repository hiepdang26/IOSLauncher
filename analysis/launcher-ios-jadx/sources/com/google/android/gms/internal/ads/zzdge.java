package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdge implements zzhfc {
    private final zzhfu zza;

    public zzdge(zzdfs zzdfsVar, zzhfu zzhfuVar) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = Collections.singleton(new zzdei((zzcvn) this.zza.zzb(), zzbzo.zzf));
        zzhfk.zzb(setSingleton);
        return setSingleton;
    }
}
