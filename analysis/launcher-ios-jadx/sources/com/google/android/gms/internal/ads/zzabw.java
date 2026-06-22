package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzabw implements zzadi {
    public final int zza;
    public final int[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    public final long[] zze;
    private final long zzf;

    public zzabw(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzb = iArr;
        this.zzc = jArr;
        this.zzd = jArr2;
        this.zze = jArr3;
        int length = iArr.length;
        this.zza = length;
        if (length <= 0) {
            this.zzf = 0L;
        } else {
            int i = length - 1;
            this.zzf = jArr2[i] + jArr3[i];
        }
    }

    public final String toString() {
        long[] jArr = this.zzd;
        long[] jArr2 = this.zze;
        long[] jArr3 = this.zzc;
        String string = Arrays.toString(this.zzb);
        String string2 = Arrays.toString(jArr3);
        String string3 = Arrays.toString(jArr2);
        String string4 = Arrays.toString(jArr);
        StringBuilder sb = new StringBuilder("ChunkIndex(length=");
        sb.append(this.zza);
        sb.append(", sizes=");
        sb.append(string);
        sb.append(", offsets=");
        sb.append(string2);
        sb.append(", timeUs=");
        sb.append(string3);
        sb.append(", durationsUs=");
        return uo.k(sb, string4, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j) {
        long[] jArr = this.zze;
        int iZzc = zzet.zzc(jArr, j, true, true);
        zzadj zzadjVar = new zzadj(jArr[iZzc], this.zzc[iZzc]);
        if (zzadjVar.zzb >= j || iZzc == this.zza - 1) {
            return new zzadg(zzadjVar, zzadjVar);
        }
        int i = iZzc + 1;
        return new zzadg(zzadjVar, new zzadj(this.zze[i], this.zzc[i]));
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}
