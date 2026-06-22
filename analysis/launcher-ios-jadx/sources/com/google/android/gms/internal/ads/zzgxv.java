package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzgxv implements zzgxm {
    final int zza;
    final zzhbf zzb;
    final boolean zzc;
    final boolean zzd;

    public zzgxv(zzgyd zzgydVar, int i, zzhbf zzhbfVar, boolean z, boolean z2) {
        this.zza = i;
        this.zzb = zzhbfVar;
        this.zzc = z;
        this.zzd = z2;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.zza - ((zzgxv) obj).zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgxm
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgxm
    public final zzhbf zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgxm
    public final zzhbg zzc() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgxm
    public final boolean zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxm
    public final boolean zze() {
        return this.zzc;
    }
}
