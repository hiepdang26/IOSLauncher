package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.nj;
import defpackage.za2;

/* JADX INFO: loaded from: classes.dex */
final class zzbxv extends zzbyb {
    private final nj zzb;
    private final zzhfl zzc;
    private final zzhfl zzd;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;
    private final zzhfl zzh;
    private final zzhfl zzi;
    private final zzhfl zzj;

    public /* synthetic */ zzbxv(Context context, nj njVar, za2 za2Var, zzbya zzbyaVar, zzbxu zzbxuVar) {
        this.zzb = njVar;
        zzhfc zzhfcVarZza = zzhfd.zza(context);
        this.zzc = zzhfcVarZza;
        zzhfc zzhfcVarZza2 = zzhfd.zza(za2Var);
        this.zzd = zzhfcVarZza2;
        this.zze = zzhfb.zzc(new zzbxn(zzhfcVarZza, zzhfcVarZza2));
        zzhfc zzhfcVarZza3 = zzhfd.zza(njVar);
        this.zzf = zzhfcVarZza3;
        zzhfc zzhfcVarZza4 = zzhfd.zza(zzbyaVar);
        this.zzg = zzhfcVarZza4;
        zzhfl zzhflVarZzc = zzhfb.zzc(new zzbxp(zzhfcVarZza3, zzhfcVarZza2, zzhfcVarZza4));
        this.zzh = zzhflVarZzc;
        zzbxr zzbxrVar = new zzbxr(zzhfcVarZza3, zzhflVarZzc);
        this.zzi = zzbxrVar;
        this.zzj = zzhfb.zzc(new zzbyg(zzhfcVarZza, zzbxrVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbyb
    public final zzbxm zza() {
        return (zzbxm) this.zze.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbyb
    public final zzbxq zzb() {
        return new zzbxq(this.zzb, (zzbxo) this.zzh.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzbyb
    public final zzbyf zzc() {
        return (zzbyf) this.zzj.zzb();
    }
}
