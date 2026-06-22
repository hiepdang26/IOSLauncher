package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzfh {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        zzdi.zzf(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            zzf(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            zzf(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            zzf(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b = bArr[i5];
            if ((b & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                    zzf(zArr);
                    return i6;
                }
                i5 = i6;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    public static int zzb(byte[] bArr, int i) {
        int i2;
        synchronized (zzc) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    try {
                        if (i3 >= i - 2) {
                            i3 = i;
                            break;
                        }
                        int i5 = i3 + 1;
                        if (bArr[i3] == 0 && bArr[i5] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3 = i5;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i4) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = zzd[i8] - i6;
                System.arraycopy(bArr, i6, bArr, i7, i9);
                int i10 = i7 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i7 = i10 + 2;
                bArr[i11] = 0;
                i6 += i9 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i7, i2 - i7);
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzfe zzc(byte[] r34, int r35, int r36) {
        /*
            Method dump skipped, instruction units count: 838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfh.zzc(byte[], int, int):com.google.android.gms.internal.ads.zzfe");
    }

    public static zzff zzd(byte[] bArr, int i, int i2) {
        zzfi zzfiVar = new zzfi(bArr, 4, i2);
        int iZzc = zzfiVar.zzc();
        int iZzc2 = zzfiVar.zzc();
        zzfiVar.zzd();
        return new zzff(iZzc, iZzc2, zzfiVar.zzf());
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzfg zze(byte[] r26, int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 485
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfh.zze(byte[], int, int):com.google.android.gms.internal.ads.zzfg");
    }

    public static void zzf(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
