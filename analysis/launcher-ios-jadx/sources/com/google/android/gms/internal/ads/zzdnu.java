package com.google.android.gms.internal.ads;

import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
final class zzdnu implements zzgcf {
    final /* synthetic */ zzfel zza;
    final /* synthetic */ zzfeo zzb;
    final /* synthetic */ zzcni zzc;
    final /* synthetic */ zzdoa zzd;

    public zzdnu(zzdoa zzdoaVar, zzfel zzfelVar, zzfeo zzfeoVar, zzcni zzcniVar) {
        this.zza = zzfelVar;
        this.zzb = zzfeoVar;
        this.zzc = zzcniVar;
        this.zzd = zzdoaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(Object obj) {
        zzcej zzcejVar = (zzcej) obj;
        zzcejVar.zzW(this.zza, this.zzb);
        zzcgb zzcgbVarZzN = zzcejVar.zzN();
        if (!((Boolean) n42.d.c.zza(zzbbw.zzjk)).booleanValue() || zzcgbVarZzN == null) {
            return;
        }
        zzcni zzcniVar = this.zzc;
        zzdoa zzdoaVar = this.zzd;
        zzcgbVarZzN.zzI(zzcniVar, zzdoaVar.zzi, zzdoaVar.zzj);
        zzcni zzcniVar2 = this.zzc;
        zzdoa zzdoaVar2 = this.zzd;
        zzcgbVarZzN.zzK(zzcniVar2, zzdoaVar2.zzi, zzdoaVar2.zzd);
    }
}
