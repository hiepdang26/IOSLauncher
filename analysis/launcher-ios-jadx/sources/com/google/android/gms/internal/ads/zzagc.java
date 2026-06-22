package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzagc {
    public static final zzaga zza = new Object() { // from class: com.google.android.gms.internal.ads.zzaga
    };

    /* JADX WARN: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.google.android.gms.internal.ads.zzbk zza(byte[] r11, int r12, com.google.android.gms.internal.ads.zzaga r13, com.google.android.gms.internal.ads.zzafe r14) {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagc.zza(byte[], int, com.google.android.gms.internal.ads.zzaga, com.google.android.gms.internal.ads.zzafe):com.google.android.gms.internal.ads.zzbk");
    }

    private static int zzb(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int zzc(byte[] bArr, int i, int i2) {
        int iZzd = zzd(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iZzd;
        }
        while (true) {
            int length = bArr.length;
            if (iZzd >= length - 1) {
                return length;
            }
            int i3 = iZzd + 1;
            if ((iZzd - i) % 2 == 0 && bArr[i3] == 0) {
                return iZzd;
            }
            iZzd = zzd(bArr, i3);
        }
    }

    private static int zzd(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    private static int zze(zzek zzekVar, int i) {
        byte[] bArrZzM = zzekVar.zzM();
        int iZzd = zzekVar.zzd();
        int i2 = iZzd;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iZzd + i) {
                return i;
            }
            if ((bArrZzM[i2] & 255) == 255 && bArrZzM[i3] == 0) {
                System.arraycopy(bArrZzM, i2 + 2, bArrZzM, i3, (i - (i2 - iZzd)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    private static zzfxr zzf(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return zzfxr.zzn("");
        }
        zzfxo zzfxoVar = new zzfxo();
        int iZzc = zzc(bArr, i2, i);
        while (i2 < iZzc) {
            zzfxoVar.zzf(new String(bArr, i2, iZzc - i2, zzi(i)));
            i2 = zzb(i) + iZzc;
            iZzc = zzc(bArr, i2, i);
        }
        zzfxr zzfxrVarZzi = zzfxoVar.zzi();
        return zzfxrVarZzi.isEmpty() ? zzfxr.zzn("") : zzfxrVarZzi;
    }

    private static String zzg(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }

    private static String zzh(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static Charset zzi(int i) {
        return i != 1 ? i != 2 ? i != 3 ? zzfuj.zzb : zzfuj.zzc : zzfuj.zzd : zzfuj.zzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0008, B:7:0x0015, B:20:0x0040, B:23:0x004a, B:25:0x006c, B:29:0x0072, B:41:0x008e, B:42:0x0090, B:45:0x0096, B:48:0x00a0, B:31:0x007c, B:35:0x0083, B:10:0x0025), top: B:54:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008e A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0008, B:7:0x0015, B:20:0x0040, B:23:0x004a, B:25:0x006c, B:29:0x0072, B:41:0x008e, B:42:0x0090, B:45:0x0096, B:48:0x00a0, B:31:0x007c, B:35:0x0083, B:10:0x0025), top: B:54:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean zzj(com.google.android.gms.internal.ads.zzek r21, int r22, int r23, boolean r24) {
        /*
            r1 = r21
            r0 = r22
            int r2 = r1.zzd()
        L8:
            int r3 = r1.zzb()     // Catch: java.lang.Throwable -> L22
            r4 = 1
            r5 = r23
            if (r3 < r5) goto La6
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L25
            int r7 = r1.zzg()     // Catch: java.lang.Throwable -> L22
            long r8 = r1.zzu()     // Catch: java.lang.Throwable -> L22
            int r10 = r1.zzq()     // Catch: java.lang.Throwable -> L22
            goto L2f
        L22:
            r0 = move-exception
            goto Laa
        L25:
            int r7 = r1.zzo()     // Catch: java.lang.Throwable -> L22
            int r8 = r1.zzo()     // Catch: java.lang.Throwable -> L22
            long r8 = (long) r8     // Catch: java.lang.Throwable -> L22
            r10 = 0
        L2f:
            r11 = 0
            if (r7 != 0) goto L3b
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3b
            if (r10 != 0) goto L3b
            goto La6
        L3b:
            r7 = 4
            if (r0 != r7) goto L6a
            if (r24 != 0) goto L6a
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L4a
        L48:
            r4 = 0
            goto La6
        L4a:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            r17 = 16
            long r17 = r8 >> r17
            r19 = 24
            long r8 = r8 >> r19
            long r15 = r15 & r11
            long r11 = r17 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 14
            long r11 = r11 << r15
            long r11 = r11 | r13
            r13 = 21
            long r8 = r8 << r13
            long r8 = r8 | r11
        L6a:
            if (r0 != r7) goto L7a
            r3 = r10 & 64
            if (r3 == 0) goto L71
            goto L72
        L71:
            r4 = 0
        L72:
            r3 = r10 & 1
            r20 = r4
            r4 = r3
            r3 = r20
            goto L8c
        L7a:
            if (r0 != r3) goto L8a
            r3 = r10 & 32
            if (r3 == 0) goto L82
            r3 = 1
            goto L83
        L82:
            r3 = 0
        L83:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L88
            goto L8c
        L88:
            r4 = 0
            goto L8c
        L8a:
            r3 = 0
            goto L88
        L8c:
            if (r4 == 0) goto L90
            int r3 = r3 + 4
        L90:
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L22
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L96
            goto L48
        L96:
            int r3 = r1.zzb()     // Catch: java.lang.Throwable -> L22
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L22
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto La0
            goto L48
        La0:
            int r3 = (int) r8     // Catch: java.lang.Throwable -> L22
            r1.zzL(r3)     // Catch: java.lang.Throwable -> L22
            goto L8
        La6:
            r1.zzK(r2)
            return r4
        Laa:
            r1.zzK(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagc.zzj(com.google.android.gms.internal.ads.zzek, int, int, boolean):boolean");
    }

    private static byte[] zzk(byte[] bArr, int i, int i2) {
        return i2 <= i ? zzet.zzf : Arrays.copyOfRange(bArr, i, i2);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02a7 A[Catch: all -> 0x013e, Exception -> 0x0265, OutOfMemoryError -> 0x026a, TryCatch #6 {all -> 0x013e, blocks: (B:82:0x0110, B:92:0x014c, B:95:0x0153, B:107:0x0186, B:110:0x01b8, B:118:0x01e4, B:131:0x021b, B:133:0x0232, B:157:0x0295, B:159:0x02a7, B:166:0x02e7, B:168:0x02fd, B:163:0x02c9, B:165:0x02e1, B:184:0x032b, B:191:0x036e, B:194:0x03a3, B:197:0x03b4, B:198:0x03bc, B:200:0x03c2, B:202:0x03c9, B:203:0x03cd, B:211:0x03ee, B:215:0x0419, B:217:0x0424, B:218:0x045a, B:219:0x0467, B:221:0x046d, B:223:0x0474, B:224:0x0478, B:228:0x048d, B:236:0x04a0, B:238:0x04ca, B:239:0x04d9, B:240:0x04e4), top: B:253:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02c9 A[Catch: all -> 0x013e, Exception -> 0x0265, OutOfMemoryError -> 0x026a, TryCatch #6 {all -> 0x013e, blocks: (B:82:0x0110, B:92:0x014c, B:95:0x0153, B:107:0x0186, B:110:0x01b8, B:118:0x01e4, B:131:0x021b, B:133:0x0232, B:157:0x0295, B:159:0x02a7, B:166:0x02e7, B:168:0x02fd, B:163:0x02c9, B:165:0x02e1, B:184:0x032b, B:191:0x036e, B:194:0x03a3, B:197:0x03b4, B:198:0x03bc, B:200:0x03c2, B:202:0x03c9, B:203:0x03cd, B:211:0x03ee, B:215:0x0419, B:217:0x0424, B:218:0x045a, B:219:0x0467, B:221:0x046d, B:223:0x0474, B:224:0x0478, B:228:0x048d, B:236:0x04a0, B:238:0x04ca, B:239:0x04d9, B:240:0x04e4), top: B:253:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0504  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.internal.ads.zzagd zzl(int r33, com.google.android.gms.internal.ads.zzek r34, boolean r35, int r36, com.google.android.gms.internal.ads.zzaga r37) {
        /*
            Method dump skipped, instruction units count: 1333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagc.zzl(int, com.google.android.gms.internal.ads.zzek, boolean, int, com.google.android.gms.internal.ads.zzaga):com.google.android.gms.internal.ads.zzagd");
    }
}
