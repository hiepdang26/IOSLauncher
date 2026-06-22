package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzebj implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;

    public zzebj(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5, zzhfu zzhfuVar6, zzhfu zzhfuVar7) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar5;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzexh, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzexf, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* synthetic */ Object zzb() {
        Context contextZza = ((zzcgp) this.zza).zza();
        zzhfu zzhfuVar = this.zzc;
        ?? Zzb = this.zzb.zzb();
        ?? Zzb2 = zzhfuVar.zzb();
        zzebn zzebnVar = new zzebn();
        zzebq zzebqVarZzb = ((zzebr) this.zzd).zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzebi(contextZza, Zzb, Zzb2, zzebnVar, zzebqVarZzb, zzgcuVar, new zzbvj());
    }
}
