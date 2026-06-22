package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzeuf implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzeuf(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar3;
        this.zzc = zzhfuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeud zzb() {
        Context contextZza = ((zzcgp) this.zza).zza();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzeud(contextZza, zzgcuVar, ((zzcwh) this.zzb).zza(), ((zzchc) this.zzc).zza());
    }
}
