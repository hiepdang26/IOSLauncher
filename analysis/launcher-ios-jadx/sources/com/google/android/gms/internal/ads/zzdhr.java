package com.google.android.gms.internal.ads;

import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzdhr implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;
    private final zzhfu zzf;

    public zzdhr(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5, zzhfu zzhfuVar6) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar4;
        this.zze = zzhfuVar5;
        this.zzf = zzhfuVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        zzcgj zzcgjVar = (zzcgj) this.zza.zzb();
        zzcvy zzcvyVarZza = ((zzcwi) this.zzb).zza();
        zzdck zzdckVarZza = ((zzdde) this.zzc).zza();
        zzdhg zzdhgVarZza = ((zzdhi) this.zzd).zza();
        zzczj zzczjVarZzb = ((zzcpj) this.zze).zzb();
        zzein zzeinVar = (zzein) this.zzf.zzb();
        zzcqk zzcqkVarZze = zzcgjVar.zze();
        zzcqkVarZze.zzi(zzcvyVarZza.zzj());
        zzcqkVarZze.zzf(zzdckVarZza);
        zzcqkVarZze.zzd(zzdhgVarZza);
        zzcqkVarZze.zze(new zzekt(null));
        zzcqkVarZze.zzg(new zzcrm(zzczjVarZzb, null));
        zzcqkVarZze.zzc(new zzcph(null));
        if (((Boolean) n42.d.c.zza(zzbbw.zzdl)).booleanValue()) {
            zzcqkVarZze.zzj(zzeiw.zzb(zzeinVar));
        }
        zzcrx zzcrxVarZzc = zzcqkVarZze.zzh().zzc();
        zzhfk.zzb(zzcrxVarZzc);
        return zzcrxVarZzc;
    }
}
