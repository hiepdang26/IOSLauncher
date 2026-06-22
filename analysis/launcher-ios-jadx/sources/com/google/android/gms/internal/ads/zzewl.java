package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.za2;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzewl implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;
    private final zzhfu zzf;

    public zzewl(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5, zzhfu zzhfuVar6, zzhfu zzhfuVar7) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar4;
        this.zzd = zzhfuVar5;
        this.zze = zzhfuVar6;
        this.zzf = zzhfuVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        za2 za2VarZzb = ((zzcgn) this.zza).zzb();
        Context contextZza = ((zzcgp) this.zzb).zza();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzewi(za2VarZzb, contextZza, zzgcuVar, (ScheduledExecutorService) this.zzc.zzb(), ((zzees) this.zzd).zzb(), ((zzcwh) this.zze).zza(), ((zzchc) this.zzf).zza());
    }
}
