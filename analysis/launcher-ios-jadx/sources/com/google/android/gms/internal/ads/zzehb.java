package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.or1;

/* JADX INFO: loaded from: classes.dex */
public final class zzehb implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzehb(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context context = (Context) this.zza.zzb();
        or1 or1VarZza = ((zzchc) this.zzb).zza();
        zzdgp zzdgpVar = (zzdgp) this.zzc.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzeha(context, or1VarZza, zzdgpVar, zzgcuVar);
    }
}
