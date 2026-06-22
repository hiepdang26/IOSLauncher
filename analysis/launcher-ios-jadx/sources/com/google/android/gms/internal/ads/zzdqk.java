package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.or1;

/* JADX INFO: loaded from: classes.dex */
public final class zzdqk implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;

    public zzdqk(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar4;
        this.zze = zzhfuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = ((zzcgp) this.zza).zza();
        final String strZzb = ((zzdxd) this.zzb).zzb();
        or1 or1VarZza = ((zzchc) this.zzc).zza();
        final zzbbc.zza.EnumC0000zza enumC0000zza = (zzbbc.zza.EnumC0000zza) this.zzd.zzb();
        final String str = (String) this.zze.zzb();
        zzbav zzbavVar = new zzbav(new zzbbb(contextZza));
        zzbbc.zzar.zza zzaVarZzd = zzbbc.zzar.zzd();
        zzaVarZzd.zzg(or1VarZza.h);
        zzaVarZzd.zzi(or1VarZza.i);
        zzaVarZzd.zzh(true != or1VarZza.j ? 2 : 0);
        final zzbbc.zzar zzarVarZzbr = zzaVarZzd.zzbr();
        zzbavVar.zzb(new zzbau() { // from class: com.google.android.gms.internal.ads.zzdqj
            @Override // com.google.android.gms.internal.ads.zzbau
            public final void zza(zzbbc.zzt.zza zzaVar) {
                zzbbc.zza.zzb zzbVarZzbM = zzaVar.zze().zzbM();
                zzbVarZzbM.zzH(enumC0000zza);
                zzaVar.zzG(zzbVarZzbM);
                zzbbc.zzm.zza zzaVarZzbM = zzaVar.zzg().zzbM();
                zzaVarZzbM.zzm(strZzb);
                zzaVarZzbM.zzw(zzarVarZzbr);
                zzaVar.zzK(zzaVarZzbM);
                zzaVar.zzO(str);
            }
        });
        return zzbavVar;
    }
}
