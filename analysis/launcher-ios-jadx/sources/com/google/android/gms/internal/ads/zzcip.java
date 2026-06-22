package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzcip implements zzezm {
    private final zzcif zza;
    private final zzhfl zzb;
    private final zzhfl zzc;
    private final zzhfl zzd;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;

    public /* synthetic */ zzcip(zzcif zzcifVar, Context context, String str, zzcio zzcioVar) {
        this.zza = zzcifVar;
        zzhfc zzhfcVarZza = zzhfd.zza(context);
        this.zzb = zzhfcVarZza;
        zzhfc zzhfcVarZza2 = zzhfd.zza(str);
        this.zzc = zzhfcVarZza2;
        zzfce zzfceVar = new zzfce(zzhfcVarZza, zzcifVar.zzaH, zzcifVar.zzaI);
        this.zzd = zzfceVar;
        zzhfl zzhflVarZzc = zzhfb.zzc(new zzfak(zzcifVar.zzaH));
        this.zze = zzhflVarZzc;
        zzhfl zzhflVarZzc2 = zzhfb.zzc(new zzfam(zzhfcVarZza, zzcifVar.zzc, zzcifVar.zzO, zzfceVar, zzhflVarZzc, zzffi.zza(), zzcifVar.zzl));
        this.zzf = zzhflVarZzc2;
        this.zzg = zzhfb.zzc(new zzfas(zzcifVar.zzO, zzhfcVarZza, zzhfcVarZza2, zzhflVarZzc2, zzhflVarZzc, zzcifVar.zzl, zzcifVar.zzM));
    }

    @Override // com.google.android.gms.internal.ads.zzezm
    public final zzfar zza() {
        return (zzfar) this.zzg.zzb();
    }
}
