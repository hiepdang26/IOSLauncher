package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzvg implements zzvx {
    final /* synthetic */ zzvj zza;
    private final int zzb;

    public zzvg(zzvj zzvjVar, int i) {
        this.zza = zzvjVar;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final int zza(zzjz zzjzVar, zzhd zzhdVar, int i) {
        return this.zza.zzf(this.zzb, zzjzVar, zzhdVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final int zzb(long j) {
        return this.zza.zzh(this.zzb, j);
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final void zzd() {
        this.zza.zzI(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final boolean zze() {
        return this.zza.zzP(this.zzb);
    }
}
