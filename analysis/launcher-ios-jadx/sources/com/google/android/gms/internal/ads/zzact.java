package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzact implements zzadi {
    private final zzacv zza;
    private final long zzb;

    public zzact(zzacv zzacvVar, long j) {
        this.zza = zzacvVar;
        this.zzb = j;
    }

    private final zzadj zzb(long j, long j2) {
        return new zzadj((j * 1000000) / ((long) this.zza.zze), this.zzb + j2);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j) {
        zzdi.zzb(this.zza.zzk);
        zzacv zzacvVar = this.zza;
        zzacu zzacuVar = zzacvVar.zzk;
        long[] jArr = zzacuVar.zza;
        long[] jArr2 = zzacuVar.zzb;
        int iZzc = zzet.zzc(jArr, zzacvVar.zzb(j), true, false);
        zzadj zzadjVarZzb = zzb(iZzc == -1 ? 0L : jArr[iZzc], iZzc != -1 ? jArr2[iZzc] : 0L);
        if (zzadjVarZzb.zzb == j || iZzc == jArr.length - 1) {
            return new zzadg(zzadjVarZzb, zzadjVarZzb);
        }
        int i = iZzc + 1;
        return new zzadg(zzadjVarZzb, zzb(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}
