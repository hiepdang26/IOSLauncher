package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzejf implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzejf(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeje zzb() {
        return new zzeje((Context) this.zza.zzb(), (zzdou) this.zzb.zzb());
    }
}
