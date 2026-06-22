package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import defpackage.n42;
import defpackage.or1;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvv implements zzhfc {
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

    public zzcvv(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5, zzhfu zzhfuVar6, zzhfu zzhfuVar7, zzhfu zzhfuVar8, zzhfu zzhfuVar9, zzhfu zzhfuVar10, zzhfu zzhfuVar11, zzhfu zzhfuVar12) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar4;
        this.zze = zzhfuVar6;
        this.zzf = zzhfuVar7;
        this.zzg = zzhfuVar8;
        this.zzh = zzhfuVar9;
        this.zzi = zzhfuVar10;
        this.zzj = zzhfuVar11;
        this.zzk = zzhfuVar12;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcvu zzb() {
        zzfjl zzfjlVar = (zzfjl) this.zza.zzb();
        or1 or1VarZza = ((zzchc) this.zzb).zza();
        ApplicationInfo applicationInfoZzb = ((zzdwy) this.zzc).zzb();
        String strZzb = ((zzdxd) this.zzd).zzb();
        zzbbn zzbbnVar = zzbbw.zza;
        return new zzcvu(zzfjlVar, or1VarZza, applicationInfoZzb, strZzb, n42.d.a.zza(), (PackageInfo) this.zze.zzb(), zzhfb.zza(zzhfn.zza(this.zzf)), ((zzcgn) this.zzg).zzb(), (String) this.zzh.zzb(), ((zzevs) this.zzi).zzb(), ((zzcwh) this.zzj).zza(), (zzdcc) this.zzk.zzb());
    }
}
