package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdll implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdll(zzdle zzdleVar, zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdei(((zzdol) this.zza).zzb(), (Executor) this.zzb.zzb());
    }
}
