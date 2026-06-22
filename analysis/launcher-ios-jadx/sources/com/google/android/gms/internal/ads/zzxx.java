package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzxx {
    private final int[] zza;
    private final zzwi[] zzb;
    private final int[] zzc;
    private final int[][][] zzd;
    private final zzwi zze;

    public zzxx(String[] strArr, int[] iArr, zzwi[] zzwiVarArr, int[] iArr2, int[][][] iArr3, zzwi zzwiVar) {
        this.zza = iArr;
        this.zzb = zzwiVarArr;
        this.zzd = iArr3;
        this.zzc = iArr2;
        this.zze = zzwiVar;
    }

    public final int zza(int i, int i2, boolean z) {
        int i3 = this.zzb[i].zzb(i2).zza;
        int[] iArr = new int[i3];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            if ((this.zzd[i][i2][i6] & 7) == 4) {
                iArr[i5] = i6;
                i5++;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, i5);
        String str = null;
        boolean z2 = false;
        int i7 = 0;
        int iMin = 16;
        while (i4 < iArrCopyOf.length) {
            String str2 = this.zzb[i].zzb(i2).zzb(iArrCopyOf[i4]).zzm;
            int i8 = i7 + 1;
            if (i7 == 0) {
                str = str2;
            } else {
                z2 |= !zzet.zzG(str, str2);
            }
            iMin = Math.min(iMin, this.zzd[i][i2][i4] & 24);
            i4++;
            i7 = i8;
        }
        return z2 ? Math.min(iMin, this.zzc[i]) : iMin;
    }

    public final int zzb(int i, int i2, int i3) {
        return this.zzd[i][i2][i3];
    }

    public final int zzc(int i) {
        return this.zza[i];
    }

    public final zzwi zzd(int i) {
        return this.zzb[i];
    }

    public final zzwi zze() {
        return this.zze;
    }
}
