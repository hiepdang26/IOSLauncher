package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzca {
    public Object zza;
    public Object zzb;
    public int zzc;
    public long zzd;
    public long zze;
    public boolean zzf;
    private zzb zzg = zzb.zza;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzca.class.equals(obj.getClass())) {
            zzca zzcaVar = (zzca) obj;
            if (zzet.zzG(this.zza, zzcaVar.zza) && zzet.zzG(this.zzb, zzcaVar.zzb) && this.zzc == zzcaVar.zzc && this.zzd == zzcaVar.zzd && this.zzf == zzcaVar.zzf && zzet.zzG(this.zzg, zzcaVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.zza;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.zzb;
        int iHashCode2 = ((((iHashCode + 217) * 31) + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.zzc;
        long j = this.zzd;
        return this.zzg.hashCode() + (((((iHashCode2 * 31) + ((int) (j ^ (j >>> 32)))) * 961) + (this.zzf ? 1 : 0)) * 31);
    }

    public final int zza(int i) {
        return this.zzg.zza(i).zzb;
    }

    public final int zzb() {
        int i = this.zzg.zzb;
        return 0;
    }

    public final int zzc(long j) {
        return -1;
    }

    public final int zzd(long j) {
        this.zzg.zzb(-1);
        return -1;
    }

    public final int zze(int i) {
        return this.zzg.zza(i).zza(-1);
    }

    public final int zzf(int i, int i2) {
        return this.zzg.zza(i).zza(i2);
    }

    public final int zzg() {
        int i = this.zzg.zzd;
        return 0;
    }

    public final long zzh(int i, int i2) {
        zza zzaVarZza = this.zzg.zza(i);
        if (zzaVarZza.zzb != -1) {
            return zzaVarZza.zzf[i2];
        }
        return -9223372036854775807L;
    }

    public final long zzi(int i) {
        long j = this.zzg.zza(i).zza;
        return 0L;
    }

    public final long zzj() {
        long j = this.zzg.zzc;
        return 0L;
    }

    public final long zzk(int i) {
        long j = this.zzg.zza(i).zzg;
        return 0L;
    }

    public final zzca zzl(Object obj, Object obj2, int i, long j, long j2, zzb zzbVar, boolean z) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = i;
        this.zzd = j;
        this.zze = 0L;
        this.zzg = zzbVar;
        this.zzf = z;
        return this;
    }

    public final boolean zzm(int i) {
        zzb();
        if (i != -1) {
            return false;
        }
        this.zzg.zzb(-1);
        return false;
    }

    public final boolean zzn(int i) {
        boolean z = this.zzg.zza(i).zzh;
        return false;
    }
}
