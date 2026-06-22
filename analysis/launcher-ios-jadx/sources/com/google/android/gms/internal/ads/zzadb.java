package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzadb implements zzadi {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final boolean zzd;

    public zzadb(long[] jArr, long[] jArr2, long j) {
        int length = jArr.length;
        int length2 = jArr2.length;
        zzdi.zzd(length == length2);
        boolean z = length2 > 0;
        this.zzd = z;
        if (!z || jArr2[0] <= 0) {
            this.zza = jArr;
            this.zzb = jArr2;
        } else {
            int i = length2 + 1;
            long[] jArr3 = new long[i];
            this.zza = jArr3;
            long[] jArr4 = new long[i];
            this.zzb = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length2);
            System.arraycopy(jArr2, 0, jArr4, 1, length2);
        }
        this.zzc = j;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j) {
        if (!this.zzd) {
            zzadj zzadjVar = zzadj.zza;
            return new zzadg(zzadjVar, zzadjVar);
        }
        int iZzc = zzet.zzc(this.zzb, j, true, true);
        zzadj zzadjVar2 = new zzadj(this.zzb[iZzc], this.zza[iZzc]);
        if (zzadjVar2.zzb != j) {
            long[] jArr = this.zzb;
            if (iZzc != jArr.length - 1) {
                int i = iZzc + 1;
                return new zzadg(zzadjVar2, new zzadj(jArr[i], this.zza[i]));
            }
        }
        return new zzadg(zzadjVar2, zzadjVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return this.zzd;
    }
}
