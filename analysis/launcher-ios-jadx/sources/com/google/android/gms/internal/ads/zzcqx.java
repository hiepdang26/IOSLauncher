package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzcqx implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzcqx(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcqw zzb() {
        return new zzcqw(((zzcqg) this.zza).zza(), (Executor) this.zzb.zzb());
    }
}
