package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfon extends zzfoj {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    public /* synthetic */ zzfon(String str, boolean z, boolean z2, zzfom zzfomVar) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfoj) {
            zzfoj zzfojVar = (zzfoj) obj;
            if (this.zza.equals(zzfojVar.zzb()) && this.zzb == zzfojVar.zzd() && this.zzc == zzfojVar.zzc()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ (true != this.zzc ? 1237 : 1231);
    }

    public final String toString() {
        return "AdShield2Options{clientVersion=" + this.zza + ", shouldGetAdvertisingId=" + this.zzb + ", isGooglePlayServicesAvailable=" + this.zzc + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfoj
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfoj
    public final boolean zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfoj
    public final boolean zzd() {
        return this.zzb;
    }
}
