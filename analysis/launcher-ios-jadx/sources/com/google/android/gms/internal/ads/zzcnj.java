package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.za2;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzcnj implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;
    private final zzhfu zzf;

    public zzcnj(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5, zzhfu zzhfuVar6, zzhfu zzhfuVar7) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar4;
        this.zze = zzhfuVar6;
        this.zzf = zzhfuVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = ((zzcgp) this.zza).zza();
        za2 za2VarZzb = ((zzcgn) this.zzb).zzb();
        zzeep zzeepVar = (zzeep) this.zzc.zzb();
        zzdpq zzdpqVar = (zzdpq) this.zzd.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzcni(contextZza, za2VarZzb, zzeepVar, zzdpqVar, zzgcuVar, (zzgcu) this.zze.zzb(), (ScheduledExecutorService) this.zzf.zzb());
    }
}
