package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzuc extends zzcc {
    private final zzbc zzb;

    public zzuc(zzbc zzbcVar) {
        this.zzb = zzbcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zza(Object obj) {
        return obj == zzub.zzc ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzb() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzc() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final zzca zzd(int i, zzca zzcaVar, boolean z) {
        zzcaVar.zzl(z ? 0 : null, z ? zzub.zzc : null, 0, -9223372036854775807L, 0L, zzb.zza, true);
        return zzcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final zzcb zze(int i, zzcb zzcbVar, long j) {
        zzcbVar.zza(zzcb.zza, this.zzb, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
        zzcbVar.zzk = true;
        return zzcbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final Object zzf(int i) {
        return zzub.zzc;
    }
}
