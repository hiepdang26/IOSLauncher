package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzehf implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzehf(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzehe zzb() {
        return new zzehe((Context) this.zza.zzb(), (zzdgp) this.zzb.zzb());
    }
}
