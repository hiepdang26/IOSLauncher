package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzoq {
    public static final zzoq zza = new zzoo().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    public /* synthetic */ zzoq(zzoo zzooVar, zzop zzopVar) {
        this.zzb = zzooVar.zza;
        this.zzc = zzooVar.zzb;
        this.zzd = zzooVar.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzoq.class == obj.getClass()) {
            zzoq zzoqVar = (zzoq) obj;
            if (this.zzb == zzoqVar.zzb && this.zzc == zzoqVar.zzc && this.zzd == zzoqVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        return (z2 ? 1 : 0) + (z2 ? 1 : 0) + ((z ? 1 : 0) << 2) + (this.zzd ? 1 : 0);
    }
}
