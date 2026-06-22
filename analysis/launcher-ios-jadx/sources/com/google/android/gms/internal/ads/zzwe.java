package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzwe implements zzvx {
    private final zzvx zza;
    private final long zzb;

    public zzwe(zzvx zzvxVar, long j) {
        this.zza = zzvxVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final int zza(zzjz zzjzVar, zzhd zzhdVar, int i) {
        int iZza = this.zza.zza(zzjzVar, zzhdVar, i);
        if (iZza != -4) {
            return iZza;
        }
        zzhdVar.zze += this.zzb;
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final int zzb(long j) {
        return this.zza.zzb(j - this.zzb);
    }

    public final zzvx zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final void zzd() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final boolean zze() {
        return this.zza.zze();
    }
}
