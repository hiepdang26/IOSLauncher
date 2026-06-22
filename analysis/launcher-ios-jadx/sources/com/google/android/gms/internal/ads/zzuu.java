package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzuu implements zzxv {
    private final zzxv zza;
    private final zzcd zzb;

    public zzuu(zzxv zzxvVar, zzcd zzcdVar) {
        this.zza = zzxvVar;
        this.zzb = zzcdVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzuu)) {
            return false;
        }
        zzuu zzuuVar = (zzuu) obj;
        return this.zza.equals(zzuuVar.zza) && this.zzb.equals(zzuuVar.zzb);
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() + 527;
        return this.zza.hashCode() + (iHashCode * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final int zza(int i) {
        return this.zza.zza(i);
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final int zzb(int i) {
        return this.zza.zzb(i);
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final int zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzaf zzd(int i) {
        return this.zzb.zzb(this.zza.zza(i));
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzcd zze() {
        return this.zzb;
    }
}
