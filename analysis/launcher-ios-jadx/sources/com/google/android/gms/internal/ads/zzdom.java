package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdom implements zzbjo {
    private final zzcxx zza;
    private final zzbvz zzb;
    private final String zzc;
    private final String zzd;

    public zzdom(zzcxx zzcxxVar, zzfel zzfelVar) {
        this.zza = zzcxxVar;
        this.zzb = zzfelVar.zzl;
        this.zzc = zzfelVar.zzj;
        this.zzd = zzfelVar.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzbjo
    public final void zza(zzbvz zzbvzVar) {
        int i;
        String str;
        zzbvz zzbvzVar2 = this.zzb;
        if (zzbvzVar2 != null) {
            zzbvzVar = zzbvzVar2;
        }
        if (zzbvzVar != null) {
            str = zzbvzVar.zza;
            i = zzbvzVar.zzb;
        } else {
            i = 1;
            str = "";
        }
        this.zza.zzd(new zzbvk(str, i), this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbjo
    public final void zzb() {
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzbjo
    public final void zzc() {
        this.zza.zzf();
    }
}
