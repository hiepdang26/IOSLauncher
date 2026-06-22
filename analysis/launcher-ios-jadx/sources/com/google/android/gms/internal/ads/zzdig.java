package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class zzdig implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdig(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdek((Context) this.zza.zzb(), new HashSet(), ((zzcsl) this.zzb).zza());
    }
}
