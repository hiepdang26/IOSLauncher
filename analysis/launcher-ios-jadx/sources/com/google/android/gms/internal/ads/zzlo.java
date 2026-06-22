package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzlo {
    public final long zza;
    public final zzcc zzb;
    public final int zzc;
    public final zzui zzd;
    public final long zze;
    public final zzcc zzf;
    public final int zzg;
    public final zzui zzh;
    public final long zzi;
    public final long zzj;

    public zzlo(long j, zzcc zzccVar, int i, zzui zzuiVar, long j2, zzcc zzccVar2, int i2, zzui zzuiVar2, long j3, long j4) {
        this.zza = j;
        this.zzb = zzccVar;
        this.zzc = i;
        this.zzd = zzuiVar;
        this.zze = j2;
        this.zzf = zzccVar2;
        this.zzg = i2;
        this.zzh = zzuiVar2;
        this.zzi = j3;
        this.zzj = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlo.class == obj.getClass()) {
            zzlo zzloVar = (zzlo) obj;
            if (this.zza == zzloVar.zza && this.zzc == zzloVar.zzc && this.zze == zzloVar.zze && this.zzg == zzloVar.zzg && this.zzi == zzloVar.zzi && this.zzj == zzloVar.zzj && zzfur.zza(this.zzb, zzloVar.zzb) && zzfur.zza(this.zzd, zzloVar.zzd) && zzfur.zza(this.zzf, zzloVar.zzf) && zzfur.zza(this.zzh, zzloVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj)});
    }
}
