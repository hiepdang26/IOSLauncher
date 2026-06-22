package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
final class zzaod implements zzadi {
    private final zzaoa zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzaod(zzaoa zzaoaVar, int i, long j, long j2) {
        this.zza = zzaoaVar;
        this.zzb = i;
        this.zzc = j;
        long j3 = (j2 - j) / ((long) zzaoaVar.zzd);
        this.zzd = j3;
        this.zze = zzb(j3);
    }

    private final long zzb(long j) {
        return zzet.zzt(j * ((long) this.zzb), 1000000L, this.zza.zzc, RoundingMode.FLOOR);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j) {
        long jMax = Math.max(0L, Math.min((((long) this.zza.zzc) * j) / (((long) this.zzb) * 1000000), this.zzd - 1));
        long j2 = ((long) this.zza.zzd) * jMax;
        long jZzb = zzb(jMax);
        zzadj zzadjVar = new zzadj(jZzb, this.zzc + j2);
        if (jZzb >= j || jMax == this.zzd - 1) {
            return new zzadg(zzadjVar, zzadjVar);
        }
        long j3 = jMax + 1;
        return new zzadg(zzadjVar, new zzadj(zzb(j3), (j3 * ((long) this.zza.zzd)) + this.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}
