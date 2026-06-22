package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.MotionScene;
import java.io.EOFException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzacr {
    public static int zza(zzek zzekVar, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return zzekVar.zzm() + 1;
            case 7:
                return zzekVar.zzq() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return MotionScene.Transition.TransitionOnClick.JUMP_TO_END << (i - 8);
            default:
                return -1;
        }
    }

    public static long zzb(zzacl zzaclVar, zzacv zzacvVar) throws zzbo, EOFException, InterruptedIOException {
        zzaclVar.zzj();
        zzaby zzabyVar = (zzaby) zzaclVar;
        zzabyVar.zzl(1, false);
        byte[] bArr = new byte[1];
        zzabyVar.zzm(bArr, 0, 1, false);
        int i = bArr[0] & 1;
        boolean z = 1 == i;
        zzabyVar.zzl(2, false);
        int i2 = 1 != i ? 6 : 7;
        zzek zzekVar = new zzek(i2);
        zzekVar.zzJ(zzaco.zza(zzaclVar, zzekVar.zzM(), 0, i2));
        zzaclVar.zzj();
        zzacq zzacqVar = new zzacq();
        if (zzd(zzekVar, zzacvVar, z, zzacqVar)) {
            return zzacqVar.zza;
        }
        throw zzbo.zza(null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zzc(com.google.android.gms.internal.ads.zzek r23, com.google.android.gms.internal.ads.zzacv r24, int r25, com.google.android.gms.internal.ads.zzacq r26) {
        /*
            r0 = r23
            r1 = r24
            int r2 = r0.zzd()
            long r3 = r0.zzu()
            r5 = 16
            long r5 = r3 >>> r5
            r7 = r25
            long r7 = (long) r7
            r9 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 == 0) goto L19
            return r9
        L19:
            r7 = 1
            long r5 = r5 & r7
            r10 = 1
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 != 0) goto L23
            r5 = 1
            goto L24
        L23:
            r5 = 0
        L24:
            r6 = 12
            long r11 = r3 >> r6
            r13 = 8
            long r13 = r3 >> r13
            r15 = 4
            long r15 = r3 >> r15
            long r17 = r3 >> r10
            long r3 = r3 & r7
            r19 = 15
            r21 = r7
            long r7 = r15 & r19
            int r8 = (int) r7
            r7 = 7
            r15 = -1
            if (r8 > r7) goto L43
            int r7 = r1.zzg
            int r7 = r7 + r15
            if (r8 != r7) goto Laf
            goto L4c
        L43:
            r7 = 10
            if (r8 > r7) goto Laf
            int r7 = r1.zzg
            r8 = 2
            if (r7 != r8) goto Laf
        L4c:
            r7 = 7
            long r7 = r17 & r7
            int r8 = (int) r7
            if (r8 != 0) goto L54
            goto L58
        L54:
            int r7 = r1.zzi
            if (r8 != r7) goto Laf
        L58:
            int r7 = (r3 > r21 ? 1 : (r3 == r21 ? 0 : -1))
            if (r7 == 0) goto Laf
            r3 = r26
            boolean r3 = zzd(r0, r1, r5, r3)
            if (r3 == 0) goto Laf
            long r3 = r11 & r19
            int r4 = (int) r3
            int r3 = zza(r0, r4)
            if (r3 == r15) goto Laf
            int r4 = r1.zzb
            if (r3 > r4) goto Laf
            long r3 = r13 & r19
            int r5 = r1.zze
            int r4 = (int) r3
            if (r4 != 0) goto L79
            goto L9b
        L79:
            r3 = 11
            if (r4 > r3) goto L82
            int r1 = r1.zzf
            if (r4 == r1) goto L9b
            goto Laf
        L82:
            if (r4 != r6) goto L8d
            int r1 = r0.zzm()
            int r1 = r1 * 1000
            if (r1 != r5) goto Laf
            goto L9b
        L8d:
            r1 = 14
            if (r4 > r1) goto Laf
            int r3 = r0.zzq()
            if (r4 != r1) goto L99
            int r3 = r3 * 10
        L99:
            if (r3 != r5) goto Laf
        L9b:
            int r1 = r0.zzm()
            int r3 = r0.zzd()
            byte[] r0 = r0.zzM()
            int r3 = r3 + r15
            int r0 = com.google.android.gms.internal.ads.zzet.zzf(r0, r2, r3, r9)
            if (r1 != r0) goto Laf
            return r10
        Laf:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacr.zzc(com.google.android.gms.internal.ads.zzek, com.google.android.gms.internal.ads.zzacv, int, com.google.android.gms.internal.ads.zzacq):boolean");
    }

    private static boolean zzd(zzek zzekVar, zzacv zzacvVar, boolean z, zzacq zzacqVar) {
        try {
            long jZzw = zzekVar.zzw();
            if (!z) {
                jZzw *= (long) zzacvVar.zzb;
            }
            zzacqVar.zza = jZzw;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
