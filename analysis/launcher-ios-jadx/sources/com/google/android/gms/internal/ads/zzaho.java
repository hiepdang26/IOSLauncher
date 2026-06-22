package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
final class zzaho implements zzahr {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzaho(long[] jArr, long[] jArr2, long j) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j == -9223372036854775807L ? zzet.zzr(jArr2[jArr2.length - 1]) : j;
    }

    public static zzaho zzb(long j, zzagi zzagiVar, long j2) {
        int length = zzagiVar.zzd.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += (long) (zzagiVar.zzb + zzagiVar.zzd[i3]);
            j3 += (long) (zzagiVar.zzc + zzagiVar.zze[i3]);
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new zzaho(jArr, jArr2, j2);
    }

    private static Pair zzf(long j, long[] jArr, long[] jArr2) {
        int iZzc = zzet.zzc(jArr, j, true, true);
        long j2 = jArr[iZzc];
        long j3 = jArr2[iZzc];
        int i = iZzc + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((jArr[i] == j2 ? 0.0d : (j - j2) / (r6 - j2)) * (jArr2[i] - j3))) + j3));
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahr
    public final int zzc() {
        return -2147483647;
    }

    @Override // com.google.android.gms.internal.ads.zzahr
    public final long zzd() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzahr
    public final long zze(long j) {
        return zzet.zzr(((Long) zzf(j, this.zza, this.zzb).second).longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j) {
        Pair pairZzf = zzf(zzet.zzu(Math.max(0L, Math.min(j, this.zzc))), this.zzb, this.zza);
        zzadj zzadjVar = new zzadj(zzet.zzr(((Long) pairZzf.first).longValue()), ((Long) pairZzf.second).longValue());
        return new zzadg(zzadjVar, zzadjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}
