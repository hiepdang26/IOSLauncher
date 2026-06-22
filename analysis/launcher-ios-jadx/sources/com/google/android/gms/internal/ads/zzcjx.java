package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.rc2;

/* JADX INFO: loaded from: classes.dex */
final class zzcjx implements zzfcr {
    private final zzcif zza;
    private final zzhfl zzb;
    private final zzhfl zzc;
    private final zzhfl zzd;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;
    private final zzhfl zzh;

    public /* synthetic */ zzcjx(zzcif zzcifVar, Context context, String str, rc2 rc2Var, zzcjw zzcjwVar) {
        this.zza = zzcifVar;
        zzhfc zzhfcVarZza = zzhfd.zza(context);
        this.zzb = zzhfcVarZza;
        zzhfc zzhfcVarZza2 = zzhfd.zza(rc2Var);
        this.zzc = zzhfcVarZza2;
        zzhfc zzhfcVarZza3 = zzhfd.zza(str);
        this.zzd = zzhfcVarZza3;
        zzhfl zzhflVarZzc = zzhfb.zzc(new zzeml(zzcifVar.zzM));
        this.zze = zzhflVarZzc;
        zzhfl zzhflVarZzc2 = zzhfb.zzc(new zzfdp(zzcifVar.zzaH));
        this.zzf = zzhflVarZzc2;
        zzhfl zzhflVarZzc3 = zzhfb.zzc(new zzfcp(zzhfcVarZza, zzcifVar.zzc, zzcifVar.zzO, zzhflVarZzc, zzhflVarZzc2, zzffi.zza()));
        this.zzg = zzhflVarZzc3;
        this.zzh = zzhfb.zzc(new zzemt(zzhfcVarZza, zzhfcVarZza2, zzhfcVarZza3, zzhflVarZzc3, zzhflVarZzc, zzhflVarZzc2, zzcifVar.zzl, zzcifVar.zzQ, zzcifVar.zzM));
    }

    @Override // com.google.android.gms.internal.ads.zzfcr
    public final zzems zza() {
        return (zzems) this.zzh.zzb();
    }
}
