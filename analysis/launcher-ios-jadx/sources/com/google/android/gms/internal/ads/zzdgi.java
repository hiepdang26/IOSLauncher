package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdgi implements zzhfc {
    private final zzdfs zza;
    private final zzhfu zzb;

    public zzdgi(zzdfs zzdfsVar, zzhfu zzhfuVar) {
        this.zza = zzdfsVar;
        this.zzb = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        return this.zza.zzd((Executor) this.zzb.zzb());
    }
}
