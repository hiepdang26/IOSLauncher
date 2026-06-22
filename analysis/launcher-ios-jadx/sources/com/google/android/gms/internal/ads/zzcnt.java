package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcnt implements zzgcf {
    final /* synthetic */ String zza;
    final /* synthetic */ zzcnu zzb;

    public zzcnt(zzcnu zzcnuVar, String str) {
        this.zza = str;
        this.zzb = zzcnuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        zzcnu zzcnuVar = this.zzb;
        zzcnuVar.zzh.zza(zzcnuVar.zzg.zzd(zzcnuVar.zze, zzcnuVar.zzf, false, this.zza, null, zzcnuVar.zzu()));
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcnu zzcnuVar = this.zzb;
        zzcnuVar.zzh.zza(zzcnuVar.zzg.zzd(zzcnuVar.zze, zzcnuVar.zzf, false, this.zza, (String) obj, zzcnuVar.zzu()));
    }
}
