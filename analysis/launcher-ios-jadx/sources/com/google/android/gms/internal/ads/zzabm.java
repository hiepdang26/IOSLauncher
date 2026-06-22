package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbc;

/* JADX INFO: loaded from: classes.dex */
public final class zzabm {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {2002, 2000, 1920, 1601, 1600, 1001, zzbbc.zzq.zzf, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX WARN: Removed duplicated region for block: B:44:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzabl zza(com.google.android.gms.internal.ads.zzej r11) {
        /*
            r0 = 16
            int r1 = r11.zzd(r0)
            int r0 = r11.zzd(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r11.zzd(r0)
            r2 = 7
            goto L19
        L18:
            r2 = 4
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r8 = r0
            r0 = 2
            int r1 = r11.zzd(r0)
            r2 = 0
            r4 = 3
            if (r1 != r4) goto L39
            r1 = 0
        L2c:
            int r5 = r11.zzd(r0)
            int r5 = r5 + r1
            boolean r1 = r11.zzp()
            if (r1 != 0) goto L3b
            int r1 = r5 + 3
        L39:
            r5 = r1
            goto L40
        L3b:
            int r5 = r5 + 1
            int r1 = r5 << 2
            goto L2c
        L40:
            r1 = 10
            int r1 = r11.zzd(r1)
            boolean r6 = r11.zzp()
            if (r6 == 0) goto L55
            int r6 = r11.zzd(r4)
            if (r6 <= 0) goto L55
            r11.zzn(r0)
        L55:
            boolean r6 = r11.zzp()
            r7 = 48000(0xbb80, float:6.7262E-41)
            r9 = 44100(0xac44, float:6.1797E-41)
            r10 = 1
            if (r10 == r6) goto L65
            r7 = 44100(0xac44, float:6.1797E-41)
        L65:
            r6 = 48000(0xbb80, float:6.7262E-41)
            int r11 = r11.zzd(r3)
            if (r7 != r9) goto L78
            r9 = 13
            if (r11 != r9) goto L78
            int[] r11 = com.google.android.gms.internal.ads.zzabm.zzb
            r2 = r11[r9]
        L76:
            r9 = r2
            goto La5
        L78:
            if (r7 != r6) goto La4
            r6 = 14
            if (r11 >= r6) goto La4
            int[] r2 = com.google.android.gms.internal.ads.zzabm.zzb
            r2 = r2[r11]
            int r1 = r1 % 5
            r6 = 8
            if (r1 == r10) goto L9f
            r9 = 11
            if (r1 == r0) goto L9a
            if (r1 == r4) goto L9f
            if (r1 == r3) goto L91
            goto L76
        L91:
            if (r11 == r4) goto L97
            if (r11 == r6) goto L97
            if (r11 != r9) goto L76
        L97:
            int r2 = r2 + 1
            goto L76
        L9a:
            if (r11 == r6) goto L97
            if (r11 != r9) goto L76
            goto L97
        L9f:
            if (r11 == r4) goto L97
            if (r11 != r6) goto L76
            goto L97
        La4:
            r9 = 0
        La5:
            com.google.android.gms.internal.ads.zzabl r4 = new com.google.android.gms.internal.ads.zzabl
            r6 = 2
            r10 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabm.zza(com.google.android.gms.internal.ads.zzej):com.google.android.gms.internal.ads.zzabl");
    }

    public static void zzb(int i, zzek zzekVar) {
        zzekVar.zzH(7);
        byte[] bArrZzM = zzekVar.zzM();
        bArrZzM[0] = -84;
        bArrZzM[1] = 64;
        bArrZzM[2] = -1;
        bArrZzM[3] = -1;
        bArrZzM[4] = (byte) ((i >> 16) & 255);
        bArrZzM[5] = (byte) ((i >> 8) & 255);
        bArrZzM[6] = (byte) (i & 255);
    }
}
