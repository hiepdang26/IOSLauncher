package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaht {
    public final zzadc zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;
    public final int zze;
    public final long[] zzf;

    private zzaht(zzadc zzadcVar, long j, long j2, long[] jArr, int i, int i2) {
        this.zza = new zzadc(zzadcVar);
        this.zzb = j;
        this.zzc = j2;
        this.zzf = jArr;
        this.zzd = i;
        this.zze = i2;
    }

    public static zzaht zzb(zzadc zzadcVar, zzek zzekVar) {
        long[] jArr;
        int i;
        int i2;
        int iZzg = zzekVar.zzg();
        int iZzp = (iZzg & 1) != 0 ? zzekVar.zzp() : -1;
        long jZzu = (iZzg & 2) != 0 ? zzekVar.zzu() : -1L;
        if ((iZzg & 4) == 4) {
            jArr = new long[100];
            for (int i3 = 0; i3 < 100; i3++) {
                jArr[i3] = zzekVar.zzm();
            }
        } else {
            jArr = null;
        }
        long[] jArr2 = jArr;
        if ((iZzg & 8) != 0) {
            zzekVar.zzL(4);
        }
        if (zzekVar.zzb() >= 24) {
            zzekVar.zzL(21);
            int iZzo = zzekVar.zzo();
            i2 = iZzo & 4095;
            i = iZzo >> 12;
        } else {
            i = -1;
            i2 = -1;
        }
        return new zzaht(zzadcVar, iZzp, jZzu, jArr2, i, i2);
    }

    public final long zza() {
        long j = this.zzb;
        if (j == -1 || j == 0) {
            return -9223372036854775807L;
        }
        return zzet.zzs((j * ((long) r4.zzg)) - 1, this.zza.zzd);
    }
}
