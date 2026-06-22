package com.google.android.gms.internal.ads;

import defpackage.k31;
import defpackage.uo;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzek {
    private static final char[] zza = {'\r', '\n'};
    private static final char[] zzb = {'\n'};
    private static final zzfxw zzc = zzfxw.zzr(zzfuj.zza, zzfuj.zzc, zzfuj.zzf, zzfuj.zzd, zzfuj.zze);
    private byte[] zzd;
    private int zze;
    private int zzf;

    public zzek(byte[] bArr, int i) {
        this.zzd = bArr;
        this.zzf = i;
    }

    private final char zzN(Charset charset, char[] cArr) {
        int iZzO = zzO(charset);
        if (iZzO != 0) {
            int i = iZzO >> 16;
            for (char c : cArr) {
                char c2 = (char) i;
                if (c == c2) {
                    this.zze += (char) iZzO;
                    return c2;
                }
            }
        }
        return (char) 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzO(java.nio.charset.Charset r5) {
        /*
            r4 = this;
            java.nio.charset.Charset r0 = com.google.android.gms.internal.ads.zzfuj.zzc
            boolean r0 = r5.equals(r0)
            r1 = 1
            if (r0 != 0) goto L11
            java.nio.charset.Charset r0 = com.google.android.gms.internal.ads.zzfuj.zza
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L25
        L11:
            int r0 = r4.zzf
            int r2 = r4.zze
            int r0 = r0 - r2
            if (r0 <= 0) goto L25
            byte[] r5 = r4.zzd
            r5 = r5[r2]
            r5 = r5 & 255(0xff, float:3.57E-43)
            long r2 = (long) r5
            char r5 = com.google.android.gms.internal.ads.zzgam.zza(r2)
            byte r5 = (byte) r5
            goto L67
        L25:
            java.nio.charset.Charset r0 = com.google.android.gms.internal.ads.zzfuj.zzf
            boolean r0 = r5.equals(r0)
            r2 = 2
            if (r0 != 0) goto L36
            java.nio.charset.Charset r0 = com.google.android.gms.internal.ads.zzfuj.zzd
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L4b
        L36:
            int r0 = r4.zzf
            int r3 = r4.zze
            int r0 = r0 - r3
            if (r0 < r2) goto L4b
            byte[] r5 = r4.zzd
            r0 = r5[r3]
            int r3 = r3 + r1
            r5 = r5[r3]
            char r5 = com.google.android.gms.internal.ads.zzgam.zzb(r0, r5)
        L48:
            byte r5 = (byte) r5
            r1 = 2
            goto L67
        L4b:
            java.nio.charset.Charset r0 = com.google.android.gms.internal.ads.zzfuj.zze
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L70
            int r5 = r4.zzf
            int r0 = r4.zze
            int r5 = r5 - r0
            if (r5 < r2) goto L70
            byte[] r5 = r4.zzd
            int r1 = r0 + 1
            r1 = r5[r1]
            r5 = r5[r0]
            char r5 = com.google.android.gms.internal.ads.zzgam.zzb(r1, r5)
            goto L48
        L67:
            long r2 = (long) r5
            char r5 = com.google.android.gms.internal.ads.zzgam.zza(r2)
            int r5 = r5 << 16
            int r5 = r5 + r1
            return r5
        L70:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzek.zzO(java.nio.charset.Charset):int");
    }

    public final String zzA(int i, Charset charset) {
        byte[] bArr = this.zzd;
        int i2 = this.zze;
        String str = new String(bArr, i2, i, charset);
        this.zze = i2 + i;
        return str;
    }

    public final Charset zzB() {
        int i = this.zzf;
        int i2 = this.zze;
        int i3 = i - i2;
        if (i3 >= 3) {
            byte[] bArr = this.zzd;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.zze = i2 + 3;
                return zzfuj.zzc;
            }
        }
        if (i3 < 2) {
            return null;
        }
        byte[] bArr2 = this.zzd;
        byte b = bArr2[i2];
        if (b == -2) {
            if (bArr2[i2 + 1] != -1) {
                return null;
            }
            this.zze = i2 + 2;
            return zzfuj.zzd;
        }
        if (b != -1 || bArr2[i2 + 1] != -2) {
            return null;
        }
        this.zze = i2 + 2;
        return zzfuj.zze;
    }

    public final short zzC() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        this.zze = i + 2;
        return (short) (((bArr[i2] & 255) << 8) | i3);
    }

    public final short zzD() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        this.zze = i + 2;
        return (short) ((bArr[i2] & 255) | (i3 << 8));
    }

    public final void zzE(int i) {
        byte[] bArr = this.zzd;
        if (i > bArr.length) {
            this.zzd = Arrays.copyOf(bArr, i);
        }
    }

    public final void zzF(zzej zzejVar, int i) {
        zzG(zzejVar.zza, 0, i);
        zzejVar.zzl(0);
    }

    public final void zzG(byte[] bArr, int i, int i2) {
        System.arraycopy(this.zzd, this.zze, bArr, i, i2);
        this.zze += i2;
    }

    public final void zzH(int i) {
        byte[] bArr = this.zzd;
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        zzI(bArr, i);
    }

    public final void zzI(byte[] bArr, int i) {
        this.zzd = bArr;
        this.zzf = i;
        this.zze = 0;
    }

    public final void zzJ(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zzd.length) {
            z = true;
        }
        zzdi.zzd(z);
        this.zzf = i;
    }

    public final void zzK(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zzf) {
            z = true;
        }
        zzdi.zzd(z);
        this.zze = i;
    }

    public final void zzL(int i) {
        zzK(this.zze + i);
    }

    public final byte[] zzM() {
        return this.zzd;
    }

    public final char zza(Charset charset) {
        zzdi.zze(zzc.contains(charset), "Unsupported charset: ".concat(String.valueOf(charset)));
        return (char) (zzO(charset) >> 16);
    }

    public final int zzb() {
        return this.zzf - this.zze;
    }

    public final int zzc() {
        return this.zzd.length;
    }

    public final int zzd() {
        return this.zze;
    }

    public final int zze() {
        return this.zzf;
    }

    public final int zzf() {
        return this.zzd[this.zze] & 255;
    }

    public final int zzg() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.zze = i4;
        int i5 = bArr[i2] & 255;
        int i6 = i + 3;
        this.zze = i6;
        int i7 = bArr[i4] & 255;
        this.zze = i + 4;
        return (bArr[i6] & 255) | (i3 << 24) | (i5 << 16) | (i7 << 8);
    }

    public final int zzh() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.zze = i4;
        int i5 = bArr[i2] & 255;
        this.zze = i + 3;
        return (bArr[i4] & 255) | ((i3 << 24) >> 8) | (i5 << 8);
    }

    public final int zzi() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.zze = i4;
        int i5 = bArr[i2] & 255;
        int i6 = i + 3;
        this.zze = i6;
        int i7 = bArr[i4] & 255;
        this.zze = i + 4;
        return ((bArr[i6] & 255) << 24) | (i5 << 8) | i3 | (i7 << 16);
    }

    public final int zzj() {
        int iZzi = zzi();
        if (iZzi >= 0) {
            return iZzi;
        }
        throw new IllegalStateException(k31.k(iZzi, "Top bit not zero: "));
    }

    public final int zzk() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        this.zze = i + 2;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    public final int zzl() {
        return (zzm() << 21) | (zzm() << 14) | (zzm() << 7) | zzm();
    }

    public final int zzm() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        this.zze = i + 1;
        return bArr[i] & 255;
    }

    public final int zzn() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        this.zze = i + 2;
        int i4 = bArr[i2] & 255;
        this.zze = i + 4;
        return i4 | (i3 << 8);
    }

    public final int zzo() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.zze = i4;
        int i5 = bArr[i2] & 255;
        this.zze = i + 3;
        return (bArr[i4] & 255) | (i3 << 16) | (i5 << 8);
    }

    public final int zzp() {
        int iZzg = zzg();
        if (iZzg >= 0) {
            return iZzg;
        }
        throw new IllegalStateException(k31.k(iZzg, "Top bit not zero: "));
    }

    public final int zzq() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        this.zze = i + 2;
        return (bArr[i2] & 255) | (i3 << 8);
    }

    public final long zzr() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        long j = bArr[i];
        int i3 = i + 2;
        this.zze = i3;
        long j2 = bArr[i2];
        int i4 = i + 3;
        this.zze = i4;
        long j3 = bArr[i3];
        int i5 = i + 4;
        this.zze = i5;
        long j4 = bArr[i4];
        int i6 = i + 5;
        this.zze = i6;
        long j5 = bArr[i5];
        int i7 = i + 6;
        this.zze = i7;
        long j6 = bArr[i6];
        int i8 = i + 7;
        this.zze = i8;
        long j7 = bArr[i7];
        this.zze = i + 8;
        return ((((long) bArr[i8]) & 255) << 56) | (255 & j) | ((j2 & 255) << 8) | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((j5 & 255) << 32) | ((j6 & 255) << 40) | ((j7 & 255) << 48);
    }

    public final long zzs() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        long j = bArr[i];
        int i3 = i + 2;
        this.zze = i3;
        long j2 = bArr[i2];
        int i4 = i + 3;
        this.zze = i4;
        long j3 = bArr[i3];
        this.zze = i + 4;
        return ((((long) bArr[i4]) & 255) << 24) | (j & 255) | ((j2 & 255) << 8) | ((j3 & 255) << 16);
    }

    public final long zzt() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        long j = bArr[i];
        int i3 = i + 2;
        this.zze = i3;
        long j2 = bArr[i2];
        int i4 = i + 3;
        this.zze = i4;
        long j3 = bArr[i3];
        int i5 = i + 4;
        this.zze = i5;
        long j4 = bArr[i4];
        int i6 = i + 5;
        this.zze = i6;
        long j5 = bArr[i5];
        int i7 = i + 6;
        this.zze = i7;
        long j6 = bArr[i6];
        int i8 = i + 7;
        this.zze = i8;
        long j7 = bArr[i7];
        this.zze = i + 8;
        return (((long) bArr[i8]) & 255) | ((j & 255) << 56) | ((j2 & 255) << 48) | ((j3 & 255) << 40) | ((j4 & 255) << 32) | ((j5 & 255) << 24) | ((j6 & 255) << 16) | ((j7 & 255) << 8);
    }

    public final long zzu() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        long j = bArr[i];
        int i3 = i + 2;
        this.zze = i3;
        long j2 = bArr[i2];
        int i4 = i + 3;
        this.zze = i4;
        long j3 = bArr[i3];
        this.zze = i + 4;
        return (((long) bArr[i4]) & 255) | ((j & 255) << 24) | ((j2 & 255) << 16) | ((j3 & 255) << 8);
    }

    public final long zzv() {
        long jZzt = zzt();
        if (jZzt >= 0) {
            return jZzt;
        }
        throw new IllegalStateException(uo.f("Top bit not zero: ", jZzt));
    }

    public final long zzw() {
        int i;
        int i2;
        long j = this.zzd[this.zze];
        int i3 = 7;
        while (true) {
            i = 0;
            if (i3 < 0) {
                break;
            }
            int i4 = 1 << i3;
            if ((((long) i4) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= (long) (i4 - 1);
                i = 7 - i3;
            } else if (i3 == 7) {
                i = 1;
            }
        }
        if (i == 0) {
            throw new NumberFormatException(uo.f("Invalid UTF-8 sequence first byte: ", j));
        }
        for (i2 = 1; i2 < i; i2++) {
            byte b = this.zzd[this.zze + i2];
            if ((b & 192) != 128) {
                throw new NumberFormatException(uo.f("Invalid UTF-8 sequence continuation byte: ", j));
            }
            j = (j << 6) | ((long) (b & 63));
        }
        this.zze += i;
        return j;
    }

    public final String zzx(char c) {
        int i = this.zzf;
        int i2 = this.zze;
        if (i - i2 == 0) {
            return null;
        }
        while (i2 < this.zzf && this.zzd[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.zzd;
        int i3 = this.zze;
        String strZzB = zzet.zzB(bArr, i3, i2 - i3);
        this.zze = i2;
        if (i2 < this.zzf) {
            this.zze = i2 + 1;
        }
        return strZzB;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zzy(java.nio.charset.Charset r5) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzek.zzy(java.nio.charset.Charset):java.lang.String");
    }

    public final String zzz(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.zze;
        int i3 = (i2 + i) - 1;
        String strZzB = zzet.zzB(this.zzd, i2, (i3 >= this.zzf || this.zzd[i3] != 0) ? i : i - 1);
        this.zze += i;
        return strZzB;
    }

    public zzek() {
        this.zzd = zzet.zzf;
    }

    public zzek(int i) {
        this.zzd = new byte[i];
        this.zzf = i;
    }

    public zzek(byte[] bArr) {
        this.zzd = bArr;
        this.zzf = bArr.length;
    }
}
