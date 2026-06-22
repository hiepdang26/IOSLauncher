package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzbyg implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzbyg(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzbyf((Context) this.zza.zzb(), ((zzbxr) this.zzb).zzb());
    }
}
