package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzhau extends zzhas {
    @Override // com.google.android.gms.internal.ads.zzhas
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        zzgxy zzgxyVar = (zzgxy) obj;
        zzhat zzhatVar = zzgxyVar.zzt;
        if (zzhatVar != zzhat.zzc()) {
            return zzhatVar;
        }
        zzhat zzhatVarZzf = zzhat.zzf();
        zzgxyVar.zzt = zzhatVarZzf;
        return zzhatVarZzf;
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public final /* synthetic */ Object zzb() {
        return zzhat.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public final /* synthetic */ Object zzc(Object obj) {
        ((zzhat) obj).zzh();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i, int i2) {
        ((zzhat) obj).zzj((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public final /* bridge */ /* synthetic */ void zze(Object obj, int i, long j) {
        ((zzhat) obj).zzj((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, Object obj2) {
        ((zzhat) obj).zzj((i << 3) | 3, obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public final /* bridge */ /* synthetic */ void zzg(Object obj, int i, zzgwm zzgwmVar) {
        ((zzhat) obj).zzj((i << 3) | 2, zzgwmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public final /* bridge */ /* synthetic */ void zzh(Object obj, int i, long j) {
        ((zzhat) obj).zzj(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public final void zzi(Object obj) {
        ((zzgxy) obj).zzt.zzh();
    }
}
