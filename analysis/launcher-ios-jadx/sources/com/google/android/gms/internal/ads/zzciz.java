package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.or1;
import defpackage.rc2;

/* JADX INFO: loaded from: classes.dex */
final class zzciz implements zzfba {
    private final Context zza;
    private final rc2 zzb;
    private final String zzc;
    private final zzcif zzd;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;
    private final zzhfl zzh;
    private final zzhfl zzi;
    private final zzhfl zzj;

    public /* synthetic */ zzciz(zzcif zzcifVar, Context context, String str, rc2 rc2Var, zzciy zzciyVar) {
        this.zzd = zzcifVar;
        this.zza = context;
        this.zzb = rc2Var;
        this.zzc = str;
        zzhfc zzhfcVarZza = zzhfd.zza(context);
        this.zze = zzhfcVarZza;
        zzhfc zzhfcVarZza2 = zzhfd.zza(rc2Var);
        this.zzf = zzhfcVarZza2;
        zzhfl zzhflVarZzc = zzhfb.zzc(new zzeml(zzcifVar.zzM));
        this.zzg = zzhflVarZzc;
        zzhfl zzhflVarZzc2 = zzhfb.zzc(zzemq.zza());
        this.zzh = zzhflVarZzc2;
        zzhfl zzhflVarZzc3 = zzhfb.zzc(zzdbr.zza());
        this.zzi = zzhflVarZzc3;
        this.zzj = zzhfb.zzc(new zzfay(zzhfcVarZza, zzcifVar.zzc, zzhfcVarZza2, zzcifVar.zzO, zzhflVarZzc, zzhflVarZzc2, zzffi.zza(), zzhflVarZzc3));
    }

    @Override // com.google.android.gms.internal.ads.zzfba
    public final zzelq zza() {
        zzfax zzfaxVar = (zzfax) this.zzj.zzb();
        zzemk zzemkVar = (zzemk) this.zzg.zzb();
        or1 or1VarZze = this.zzd.zza.zze();
        zzhfk.zzb(or1VarZze);
        return new zzelq(this.zza, this.zzb, this.zzc, zzfaxVar, zzemkVar, or1VarZze, (zzdsk) this.zzd.zzM.zzb());
    }
}
