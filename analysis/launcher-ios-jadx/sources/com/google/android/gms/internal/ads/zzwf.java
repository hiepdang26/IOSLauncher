package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzwf implements zzug, zzuf {
    private final zzug zza;
    private final long zzb;
    private zzuf zzc;

    public zzwf(zzug zzugVar, long j) {
        this.zza = zzugVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zza(long j, zzlj zzljVar) {
        long j2 = this.zzb;
        return this.zza.zza(j - j2, zzljVar) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzb() {
        long jZzb = this.zza.zzb();
        if (jZzb == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzb + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzc() {
        long jZzc = this.zza.zzc();
        if (jZzc == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzc + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zzd() {
        long jZzd = this.zza.zzd();
        if (jZzd == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return jZzd + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zze(long j) {
        long j2 = this.zzb;
        return this.zza.zze(j - j2) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final /* bridge */ /* synthetic */ void zzf(zzvz zzvzVar) {
        zzuf zzufVar = this.zzc;
        zzufVar.getClass();
        zzufVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zzg(zzxv[] zzxvVarArr, boolean[] zArr, zzvx[] zzvxVarArr, boolean[] zArr2, long j) {
        zzvx[] zzvxVarArr2 = new zzvx[zzvxVarArr.length];
        int i = 0;
        while (true) {
            zzvx zzvxVarZzc = null;
            if (i >= zzvxVarArr.length) {
                break;
            }
            zzwe zzweVar = (zzwe) zzvxVarArr[i];
            if (zzweVar != null) {
                zzvxVarZzc = zzweVar.zzc();
            }
            zzvxVarArr2[i] = zzvxVarZzc;
            i++;
        }
        long jZzg = this.zza.zzg(zzxvVarArr, zArr, zzvxVarArr2, zArr2, j - this.zzb);
        for (int i2 = 0; i2 < zzvxVarArr.length; i2++) {
            zzvx zzvxVar = zzvxVarArr2[i2];
            if (zzvxVar == null) {
                zzvxVarArr[i2] = null;
            } else {
                zzvx zzvxVar2 = zzvxVarArr[i2];
                if (zzvxVar2 == null || ((zzwe) zzvxVar2).zzc() != zzvxVar) {
                    zzvxVarArr[i2] = new zzwe(zzvxVar, this.zzb);
                }
            }
        }
        return jZzg + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzuf
    public final void zzh(zzug zzugVar) {
        zzuf zzufVar = this.zzc;
        zzufVar.getClass();
        zzufVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final zzwi zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzj(long j, boolean z) {
        this.zza.zzj(j - this.zzb, false);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzk() {
        this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzl(zzuf zzufVar, long j) {
        this.zzc = zzufVar;
        this.zza.zzl(this, j - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final void zzm(long j) {
        this.zza.zzm(j - this.zzb);
    }

    public final zzug zzn() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzo(zzkf zzkfVar) {
        long j = zzkfVar.zza;
        long j2 = this.zzb;
        zzkd zzkdVarZza = zzkfVar.zza();
        zzkdVarZza.zze(j - j2);
        return this.zza.zzo(zzkdVarZza.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzp() {
        return this.zza.zzp();
    }
}
