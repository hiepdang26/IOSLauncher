package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzki {
    public final zzui zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;

    public zzki(zzui zzuiVar, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = true;
        zzdi.zzd(!z4 || z2);
        if (z3 && !z2) {
            z5 = false;
        }
        zzdi.zzd(z5);
        this.zza = zzuiVar;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = j4;
        this.zzf = false;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzki.class == obj.getClass()) {
            zzki zzkiVar = (zzki) obj;
            if (this.zzb == zzkiVar.zzb && this.zzc == zzkiVar.zzc && this.zzd == zzkiVar.zzd && this.zze == zzkiVar.zze && this.zzg == zzkiVar.zzg && this.zzh == zzkiVar.zzh && this.zzi == zzkiVar.zzi && zzet.zzG(this.zza, zzkiVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() + 527;
        long j = this.zze;
        long j2 = this.zzd;
        return (((((((((((((iHashCode * 31) + ((int) this.zzb)) * 31) + ((int) this.zzc)) * 31) + ((int) j2)) * 31) + ((int) j)) * 961) + (this.zzg ? 1 : 0)) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0);
    }

    public final zzki zza(long j) {
        return j == this.zzc ? this : new zzki(this.zza, this.zzb, j, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }

    public final zzki zzb(long j) {
        return j == this.zzb ? this : new zzki(this.zza, j, this.zzc, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }
}
