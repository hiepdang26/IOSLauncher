package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzevw implements zzhfc {
    private final zzhfu zza;

    public zzevw(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzevu zzb() {
        Context contextZza = ((zzcgp) this.zza).zza();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzevu(contextZza, zzgcuVar);
    }
}
