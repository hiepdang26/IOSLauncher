package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzadc {
    public int zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;

    public zzadc() {
    }

    public final boolean zza(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (!zzadd.zzm(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return false;
        }
        int i6 = i4 - 1;
        this.zza = i2;
        this.zzb = zzadd.zza[3 - i3];
        int i7 = zzadd.zzb[i5];
        this.zzd = i7;
        if (i2 == 2) {
            i7 /= 2;
            this.zzd = i7;
        } else if (i2 == 0) {
            i7 /= 4;
            this.zzd = i7;
        }
        int i8 = (i >>> 9) & 1;
        this.zzg = zzadd.zzl(i2, i3);
        if (i3 == 3) {
            int i9 = i2 == 3 ? zzadd.zzc[i6] : zzadd.zzd[i6];
            this.zzf = i9;
            this.zzc = (((i9 * 12) / i7) + i8) * 4;
        } else {
            if (i2 == 3) {
                int i10 = i3 == 2 ? zzadd.zze[i6] : zzadd.zzf[i6];
                this.zzf = i10;
                this.zzc = ((i10 * 144) / i7) + i8;
            } else {
                int i11 = zzadd.zzg[i6];
                this.zzf = i11;
                this.zzc = (((i3 == 1 ? 72 : 144) * i11) / i7) + i8;
            }
        }
        this.zze = ((i >> 6) & 3) == 3 ? 1 : 2;
        return true;
    }

    public zzadc(zzadc zzadcVar) {
        this.zza = zzadcVar.zza;
        this.zzb = zzadcVar.zzb;
        this.zzc = zzadcVar.zzc;
        this.zzd = zzadcVar.zzd;
        this.zze = zzadcVar.zze;
        this.zzf = zzadcVar.zzf;
        this.zzg = zzadcVar.zzg;
    }
}
