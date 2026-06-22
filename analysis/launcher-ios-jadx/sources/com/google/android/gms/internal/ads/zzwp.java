package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzwp extends zzwr {
    public zzwp(zzcd zzcdVar, int[] iArr, int i, zzyj zzyjVar, long j, long j2, long j3, int i2, int i3, float f, float f2, List list, zzdj zzdjVar) {
        super(zzcdVar, iArr, 0);
        zzfxr.zzk(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ zzfxr zzf(zzxu[] zzxuVarArr) {
        int i;
        long[][] jArr;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            i = 1;
            if (i2 >= 2) {
                break;
            }
            zzxu zzxuVar = zzxuVarArr[i2];
            if (zzxuVar == null || zzxuVar.zzb.length <= 1) {
                arrayList.add(null);
            } else {
                zzfxo zzfxoVar = new zzfxo();
                zzfxoVar.zzf(new zzwn(0L, 0L));
                arrayList.add(zzfxoVar);
            }
            i2++;
        }
        long[][] jArr2 = new long[2][];
        for (int i3 = 0; i3 < 2; i3++) {
            zzxu zzxuVar2 = zzxuVarArr[i3];
            if (zzxuVar2 == null) {
                jArr2[i3] = new long[0];
            } else {
                jArr2[i3] = new long[zzxuVar2.zzb.length];
                int i4 = 0;
                while (true) {
                    int[] iArr = zzxuVar2.zzb;
                    if (i4 >= iArr.length) {
                        break;
                    }
                    long j = zzxuVar2.zza.zzb(iArr[i4]).zzi;
                    long[] jArr3 = jArr2[i3];
                    if (j == -1) {
                        j = 0;
                    }
                    jArr3[i4] = j;
                    i4++;
                }
                Arrays.sort(jArr2[i3]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr4 = new long[2];
        for (int i5 = 0; i5 < 2; i5++) {
            long[] jArr5 = jArr2[i5];
            jArr4[i5] = jArr5.length == 0 ? 0L : jArr5[0];
        }
        zzg(arrayList, jArr4);
        zzfyc zzfycVarZza = zzfyx.zzc(zzfzc.zzc()).zzb(2).zza();
        int i6 = 0;
        while (i6 < 2) {
            int length = jArr2[i6].length;
            if (length <= i) {
                jArr = jArr2;
            } else {
                double[] dArr = new double[length];
                int i7 = 0;
                while (true) {
                    long[] jArr6 = jArr2[i6];
                    double dLog = 0.0d;
                    if (i7 >= jArr6.length) {
                        break;
                    }
                    long[][] jArr7 = jArr2;
                    long j2 = jArr6[i7];
                    if (j2 != -1) {
                        dLog = Math.log(j2);
                    }
                    dArr[i7] = dLog;
                    i7++;
                    jArr2 = jArr7;
                }
                jArr = jArr2;
                int i8 = length - 1;
                double d = dArr[i8] - dArr[0];
                int i9 = 0;
                while (i9 < i8) {
                    double d2 = dArr[i9];
                    i9++;
                    zzfycVarZza.zzq(Double.valueOf(d == 0.0d ? 1.0d : (((d2 + dArr[i9]) * 0.5d) - dArr[0]) / d), Integer.valueOf(i6));
                }
            }
            i6++;
            jArr2 = jArr;
            i = 1;
        }
        long[][] jArr8 = jArr2;
        zzfxr zzfxrVarZzk = zzfxr.zzk(zzfycVarZza.zzr());
        for (int i10 = 0; i10 < zzfxrVarZzk.size(); i10++) {
            int iIntValue = ((Integer) zzfxrVarZzk.get(i10)).intValue();
            int i11 = iArr2[iIntValue] + 1;
            iArr2[iIntValue] = i11;
            jArr4[iIntValue] = jArr8[iIntValue][i11];
            zzg(arrayList, jArr4);
        }
        for (int i12 = 0; i12 < 2; i12++) {
            if (arrayList.get(i12) != null) {
                long j3 = jArr4[i12];
                jArr4[i12] = j3 + j3;
            }
        }
        zzg(arrayList, jArr4);
        zzfxo zzfxoVar2 = new zzfxo();
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            zzfxo zzfxoVar3 = (zzfxo) arrayList.get(i13);
            zzfxoVar2.zzf(zzfxoVar3 == null ? zzfxr.zzm() : zzfxoVar3.zzi());
        }
        return zzfxoVar2.zzi();
    }

    private static void zzg(List list, long[] jArr) {
        long j = 0;
        for (int i = 0; i < 2; i++) {
            j += jArr[i];
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzfxo zzfxoVar = (zzfxo) list.get(i2);
            if (zzfxoVar != null) {
                zzfxoVar.zzf(new zzwn(j, jArr[i2]));
            }
        }
    }
}
