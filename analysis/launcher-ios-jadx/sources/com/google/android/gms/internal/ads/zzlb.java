package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzlb extends zztw {
    private final zzcb zzc;

    public zzlb(zzlc zzlcVar, zzcc zzccVar) {
        super(zzccVar);
        this.zzc = new zzcb();
    }

    @Override // com.google.android.gms.internal.ads.zztw, com.google.android.gms.internal.ads.zzcc
    public final zzca zzd(int i, zzca zzcaVar, boolean z) {
        zzca zzcaVarZzd = this.zzb.zzd(i, zzcaVar, z);
        if (this.zzb.zze(zzcaVarZzd.zzc, this.zzc, 0L).zzb()) {
            zzcaVarZzd.zzl(zzcaVar.zza, zzcaVar.zzb, zzcaVar.zzc, zzcaVar.zzd, 0L, zzb.zza, true);
            return zzcaVarZzd;
        }
        zzcaVarZzd.zzf = true;
        return zzcaVarZzd;
    }
}
