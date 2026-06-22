package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzckb implements zzfef {
    private final zzcif zza;
    private final zzhfl zzb;
    private final zzhfl zzc;
    private final zzhfl zzd;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;
    private final zzhfl zzh;
    private final zzhfl zzi;

    public /* synthetic */ zzckb(zzcif zzcifVar, Context context, String str, zzcka zzckaVar) {
        this.zza = zzcifVar;
        zzhfc zzhfcVarZza = zzhfd.zza(context);
        this.zzb = zzhfcVarZza;
        zzfcf zzfcfVar = new zzfcf(zzhfcVarZza, zzcifVar.zzaH, zzcifVar.zzaI);
        this.zzc = zzfcfVar;
        zzhfl zzhflVarZzc = zzhfb.zzc(new zzfdp(zzcifVar.zzaH));
        this.zzd = zzhflVarZzc;
        zzhfl zzhflVarZzc2 = zzhfb.zzc(zzffd.zza());
        this.zze = zzhflVarZzc2;
        zzhfl zzhflVarZzc3 = zzhfb.zzc(new zzfdz(zzhfcVarZza, zzcifVar.zzc, zzcifVar.zzO, zzfcfVar, zzhflVarZzc, zzffi.zza(), zzhflVarZzc2));
        this.zzf = zzhflVarZzc3;
        this.zzg = zzhfb.zzc(new zzfej(zzhflVarZzc3, zzhflVarZzc, zzhflVarZzc2));
        zzhfc zzhfcVarZzc = zzhfd.zzc(str);
        this.zzh = zzhfcVarZzc;
        this.zzi = zzhfb.zzc(new zzfed(zzhfcVarZzc, zzhflVarZzc3, zzhfcVarZza, zzhflVarZzc, zzhflVarZzc2, zzcifVar.zzl, zzcifVar.zzQ, zzcifVar.zzM));
    }

    @Override // com.google.android.gms.internal.ads.zzfef
    public final zzfec zza() {
        return (zzfec) this.zzi.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzfef
    public final zzfei zzb() {
        return (zzfei) this.zzg.zzb();
    }
}
