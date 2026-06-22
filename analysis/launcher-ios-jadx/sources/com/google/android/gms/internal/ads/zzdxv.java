package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.or1;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxv implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;
    private final zzhfu zzf;
    private final zzhfu zzg;

    public zzdxv(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5, zzhfu zzhfuVar6, zzhfu zzhfuVar7, zzhfu zzhfuVar8) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar4;
        this.zze = zzhfuVar6;
        this.zzf = zzhfuVar7;
        this.zzg = zzhfuVar8;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdxu zzb() {
        zzcgj zzcgjVar = (zzcgj) this.zza.zzb();
        Context contextZza = ((zzcgp) this.zzb).zza();
        or1 or1VarZza = ((zzchc) this.zzc).zza();
        zzffg zzffgVarZza = ((zzcwh) this.zzd).zza();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzdxu(zzcgjVar, contextZza, or1VarZza, zzffgVarZza, zzgcuVar, (String) this.zze.zzb(), (zzfkf) this.zzf.zzb(), (zzdsf) this.zzg.zzb());
    }
}
