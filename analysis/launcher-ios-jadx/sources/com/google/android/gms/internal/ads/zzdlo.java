package com.google.android.gms.internal.ads;

import defpackage.l52;
import defpackage.nj;

/* JADX INFO: loaded from: classes.dex */
public final class zzdlo implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdlo(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        l52 l52Var = (l52) this.zza.zzb();
        nj njVar = (nj) this.zzb.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzdln(l52Var, njVar, zzgcuVar);
    }
}
