package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzcjn implements zzdtu {
    private final Context zza;
    private final zzbjw zzb;
    private final zzcif zzc;
    private final zzcjn zzd = this;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;
    private final zzhfl zzh;

    public /* synthetic */ zzcjn(zzcif zzcifVar, Context context, zzbjw zzbjwVar, zzcjm zzcjmVar) {
        this.zzc = zzcifVar;
        this.zza = context;
        this.zzb = zzbjwVar;
        zzhfc zzhfcVarZza = zzhfd.zza(this);
        this.zze = zzhfcVarZza;
        zzhfc zzhfcVarZza2 = zzhfd.zza(zzbjwVar);
        this.zzf = zzhfcVarZza2;
        zzdtq zzdtqVar = new zzdtq(zzhfcVarZza2);
        this.zzg = zzdtqVar;
        this.zzh = zzhfb.zzc(new zzdts(zzhfcVarZza, zzdtqVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final zzdtl zzb() {
        return new zzcjh(this.zzc, this.zzd, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final zzdtr zzd() {
        return (zzdtr) this.zzh.zzb();
    }
}
