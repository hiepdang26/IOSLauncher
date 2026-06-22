package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzeiv implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;
    private final zzhfu zzf;
    private final zzhfu zzg;
    private final zzhfu zzh;
    private final zzhfu zzi;
    private final zzhfu zzj;
    private final zzhfu zzk;
    private final zzhfu zzl;

    public zzeiv(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5, zzhfu zzhfuVar6, zzhfu zzhfuVar7, zzhfu zzhfuVar8, zzhfu zzhfuVar9, zzhfu zzhfuVar10, zzhfu zzhfuVar11, zzhfu zzhfuVar12, zzhfu zzhfuVar13) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar4;
        this.zze = zzhfuVar5;
        this.zzf = zzhfuVar6;
        this.zzg = zzhfuVar7;
        this.zzh = zzhfuVar9;
        this.zzi = zzhfuVar10;
        this.zzj = zzhfuVar11;
        this.zzk = zzhfuVar12;
        this.zzl = zzhfuVar13;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeiu zzb() {
        Context contextZza = ((zzcgp) this.zza).zza();
        zzfjl zzfjlVar = (zzfjl) this.zzb.zzb();
        zzein zzeinVar = (zzein) this.zzc.zzb();
        zzcws zzcwsVar = (zzcws) this.zzd.zzb();
        zzflh zzflhVar = (zzflh) this.zze.zzb();
        zzfll zzfllVar = (zzfll) this.zzf.zzb();
        zzcrx zzcrxVar = (zzcrx) this.zzg.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzeiu(contextZza, zzfjlVar, zzeinVar, zzcwsVar, zzflhVar, zzfllVar, zzcrxVar, zzgcuVar, (ScheduledExecutorService) this.zzh.zzb(), (zzeey) this.zzi.zzb(), (zzfkf) this.zzj.zzb(), ((zzehz) this.zzk).zzb(), (zzdsf) this.zzl.zzb());
    }
}
