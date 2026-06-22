package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
final class zzahs implements zzahr {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;

    private zzahs(long[] jArr, long[] jArr2, long j, long j2, int i) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
    }

    public static zzahs zzb(long j, long j2, zzadc zzadcVar, zzek zzekVar) {
        int iZzm;
        zzekVar.zzL(10);
        int iZzg = zzekVar.zzg();
        if (iZzg <= 0) {
            return null;
        }
        int i = zzadcVar.zzd;
        long jZzt = zzet.zzt(iZzg, ((long) (i >= 32000 ? 1152 : 576)) * 1000000, i, RoundingMode.FLOOR);
        int iZzq = zzekVar.zzq();
        int iZzq2 = zzekVar.zzq();
        int iZzq3 = zzekVar.zzq();
        zzekVar.zzL(2);
        long j3 = j2 + ((long) zzadcVar.zzc);
        long[] jArr = new long[iZzq];
        long[] jArr2 = new long[iZzq];
        long j4 = j2;
        int i2 = 0;
        while (i2 < iZzq) {
            long j5 = jZzt;
            jArr[i2] = (((long) i2) * j5) / ((long) iZzq);
            jArr2[i2] = Math.max(j4, j3);
            if (iZzq3 == 1) {
                iZzm = zzekVar.zzm();
            } else if (iZzq3 == 2) {
                iZzm = zzekVar.zzq();
            } else if (iZzq3 == 3) {
                iZzm = zzekVar.zzo();
            } else {
                if (iZzq3 != 4) {
                    return null;
                }
                iZzm = zzekVar.zzp();
            }
            j4 += ((long) iZzm) * ((long) iZzq2);
            i2++;
            iZzq = iZzq;
            jZzt = j5;
        }
        long j6 = jZzt;
        if (j != -1 && j != j4) {
            zzea.zzf("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j4);
        }
        return new zzahs(jArr, jArr2, j6, j4, zzadcVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahr
    public final int zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzahr
    public final long zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzahr
    public final long zze(long j) {
        return this.zza[zzet.zzc(this.zzb, j, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j) {
        long[] jArr = this.zza;
        int iZzc = zzet.zzc(jArr, j, true, true);
        zzadj zzadjVar = new zzadj(jArr[iZzc], this.zzb[iZzc]);
        if (zzadjVar.zzb < j) {
            long[] jArr2 = this.zza;
            if (iZzc != jArr2.length - 1) {
                int i = iZzc + 1;
                return new zzadg(zzadjVar, new zzadj(jArr2[i], this.zzb[i]));
            }
        }
        return new zzadg(zzadjVar, zzadjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}
