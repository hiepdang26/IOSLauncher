package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdhm implements zzhfc {
    private final zzhfu zza;

    public zzdhm(zzhfu zzhfuVar) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = ((zzdhj) this.zza).zza().zze() != null ? Collections.singleton("banner") : Collections.EMPTY_SET;
        zzhfk.zzb(setSingleton);
        return setSingleton;
    }
}
