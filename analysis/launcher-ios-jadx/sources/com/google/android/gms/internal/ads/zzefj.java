package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzefj implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzefj(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context context = (Context) this.zza.zzb();
        zzcoy zzcoyVar = (zzcoy) this.zzb.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzefi(context, zzcoyVar, zzgcuVar);
    }
}
