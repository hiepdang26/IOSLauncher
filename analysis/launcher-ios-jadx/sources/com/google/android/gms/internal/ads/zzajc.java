package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
final class zzajc implements zzadi {
    final /* synthetic */ zzajd zza;

    public /* synthetic */ zzajc(zzajd zzajdVar, zzajb zzajbVar) {
        this.zza = zzajdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        zzajd zzajdVar = this.zza;
        return zzajdVar.zzd.zzf(zzajdVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j) {
        zzajd zzajdVar = this.zza;
        long jZzg = zzajdVar.zzd.zzg(j);
        long j2 = zzajdVar.zzb;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(jZzg);
        zzajd zzajdVar2 = this.zza;
        long jLongValue = bigIntegerValueOf.multiply(BigInteger.valueOf(zzajdVar2.zzc - zzajdVar2.zzb)).divide(BigInteger.valueOf(this.zza.zzf)).longValue() + j2;
        zzadj zzadjVar = new zzadj(j, Math.max(this.zza.zzb, Math.min(jLongValue - 30000, r2.zzc - 1)));
        return new zzadg(zzadjVar, zzadjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}
