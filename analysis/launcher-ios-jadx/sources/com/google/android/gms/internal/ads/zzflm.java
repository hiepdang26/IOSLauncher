package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.tc2;

/* JADX INFO: loaded from: classes.dex */
public final class zzflm implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzflm(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar3;
        this.zzc = zzhfuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = ((zzcgp) this.zza).zza();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzfll(contextZza, zzgcuVar, (tc2) this.zzb.zzb(), (zzfki) this.zzc.zzb());
    }
}
