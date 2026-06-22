package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.motion.widget.MotionScene;
import defpackage.uo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzgws extends zzgww {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    public /* synthetic */ zzgws(InputStream inputStream, int i, zzgwr zzgwrVar) {
        super(null);
        this.zzl = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        byte[] bArr = zzgyl.zzb;
        this.zze = inputStream;
        this.zzf = new byte[MotionScene.Transition.TransitionOnClick.JUMP_TO_START];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List zzI(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, MotionScene.Transition.TransitionOnClick.JUMP_TO_START);
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                int i3 = this.zze.read(bArr, i2, iMin - i2);
                if (i3 == -1) {
                    throw zzgyn.zzi();
                }
                this.zzk += i3;
                i2 += i3;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzJ() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = this.zzk + i;
        int i3 = this.zzl;
        if (i2 <= i3) {
            this.zzh = 0;
            return;
        }
        int i4 = i2 - i3;
        this.zzh = i4;
        this.zzg = i - i4;
    }

    private final void zzK(int i) throws zzgyn {
        if (zzL(i)) {
            return;
        }
        if (i <= (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - this.zzk) - this.zzi) {
            throw zzgyn.zzi();
        }
        throw zzgyn.zzh();
    }

    private final boolean zzL(int i) throws IOException {
        int i2 = this.zzi;
        int i3 = i2 + i;
        int i4 = this.zzg;
        if (i3 <= i4) {
            throw new IllegalStateException(uo.d(i, "refillBuffer() called when ", " bytes were already available in buffer"));
        }
        int i5 = this.zzk;
        if (i > (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i5) - i2 || i5 + i2 + i > this.zzl) {
            return false;
        }
        if (i2 > 0) {
            if (i4 > i2) {
                byte[] bArr = this.zzf;
                System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
            }
            i5 = this.zzk + i2;
            this.zzk = i5;
            i4 = this.zzg - i2;
            this.zzg = i4;
            this.zzi = 0;
        }
        try {
            int i6 = this.zze.read(this.zzf, i4, Math.min(4096 - i4, (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i5) - i4));
            if (i6 == 0 || i6 < -1 || i6 > 4096) {
                throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + i6 + "\nThe InputStream implementation is buggy.");
            }
            if (i6 <= 0) {
                return false;
            }
            this.zzg += i6;
            zzJ();
            if (this.zzg >= i) {
                return true;
            }
            return zzL(i);
        } catch (zzgyn e) {
            e.zzj();
            throw e;
        }
    }

    private final byte[] zzM(int i, boolean z) throws IOException {
        byte[] bArrZzN = zzN(i);
        if (bArrZzN != null) {
            return bArrZzN;
        }
        int i2 = this.zzi;
        int i3 = this.zzg;
        int i4 = i3 - i2;
        this.zzk += i3;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzI = zzI(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, i2, bArr, 0, i4);
        for (byte[] bArr2 : listZzI) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        }
        return bArr;
    }

    private final byte[] zzN(int i) throws IOException {
        if (i == 0) {
            return zzgyl.zzb;
        }
        int i2 = this.zzk;
        int i3 = this.zzi;
        int i4 = i2 + i3 + i;
        if ((-2147483647) + i4 > 0) {
            throw zzgyn.zzh();
        }
        int i5 = this.zzl;
        if (i4 > i5) {
            zzC((i5 - i2) - i3);
            throw zzgyn.zzi();
        }
        int i6 = this.zzg - i3;
        int i7 = i - i6;
        if (i7 >= 4096) {
            try {
                if (i7 > this.zze.available()) {
                    return null;
                }
            } catch (zzgyn e) {
                e.zzj();
                throw e;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, this.zzi, bArr, 0, i6);
        this.zzk += this.zzg;
        this.zzi = 0;
        this.zzg = 0;
        while (i6 < i) {
            try {
                int i8 = this.zze.read(bArr, i6, i - i6);
                if (i8 == -1) {
                    throw zzgyn.zzi();
                }
                this.zzk += i8;
                i6 += i8;
            } catch (zzgyn e2) {
                e2.zzj();
                throw e2;
            }
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final boolean zzA() {
        return this.zzi == this.zzg && !zzL(1);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final boolean zzB() {
        return zzq() != 0;
    }

    public final void zzC(int i) throws zzgyn {
        int i2 = this.zzg;
        int i3 = this.zzi;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.zzi = i3 + i;
            return;
        }
        if (i < 0) {
            throw zzgyn.zzf();
        }
        int i5 = this.zzk;
        int i6 = i5 + i3;
        int i7 = this.zzl;
        if (i6 + i > i7) {
            zzC((i7 - i5) - i3);
            throw zzgyn.zzi();
        }
        this.zzk = i6;
        this.zzg = 0;
        this.zzi = 0;
        while (i4 < i) {
            try {
                long j = i - i4;
                try {
                    long jSkip = this.zze.skip(j);
                    if (jSkip < 0 || jSkip > j) {
                        throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i4 += (int) jSkip;
                    }
                } catch (zzgyn e) {
                    e.zzj();
                    throw e;
                }
            } catch (Throwable th) {
                this.zzk += i4;
                zzJ();
                throw th;
            }
        }
        this.zzk += i4;
        zzJ();
        if (i4 >= i) {
            return;
        }
        int i8 = this.zzg;
        int i9 = i8 - this.zzi;
        this.zzi = i8;
        zzK(1);
        while (true) {
            int i10 = i - i9;
            int i11 = this.zzg;
            if (i10 <= i11) {
                this.zzi = i10;
                return;
            } else {
                i9 += i11;
                this.zzi = i11;
                zzK(1);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final double zza() {
        return Double.longBitsToDouble(zzp());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final float zzb() {
        return Float.intBitsToFloat(zzh());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzc() {
        return this.zzk + this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzd(int i) throws zzgyn {
        if (i < 0) {
            throw zzgyn.zzf();
        }
        int i2 = this.zzk + this.zzi + i;
        if (i2 < 0) {
            throw zzgyn.zzg();
        }
        int i3 = this.zzl;
        if (i2 > i3) {
            throw zzgyn.zzi();
        }
        this.zzl = i2;
        zzJ();
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zze() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzf() {
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzg() {
        return zzi();
    }

    public final int zzh() throws zzgyn {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            zzK(4);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public final int zzi() {
        int i;
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (i3 != i2) {
            byte[] bArr = this.zzf;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzi = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.zzi = i5;
                return i;
            }
        }
        return (int) zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzj() {
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzk() {
        return zzgww.zzD(zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzl() throws zzgyn {
        if (zzA()) {
            this.zzj = 0;
            return 0;
        }
        int iZzi = zzi();
        this.zzj = iZzi;
        if ((iZzi >>> 3) != 0) {
            return iZzi;
        }
        throw zzgyn.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzm() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzn() {
        return zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzo() {
        return zzq();
    }

    public final long zzp() throws zzgyn {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            zzK(8);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        long j = bArr[i];
        long j2 = (((long) bArr[i + 1]) & 255) << 8;
        long j3 = bArr[i + 2];
        long j4 = bArr[i + 3];
        return ((((long) bArr[i + 6]) & 255) << 48) | (j & 255) | j2 | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b7, code lost:
    
        if (r2[r5] >= 0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zzq() {
        /*
            r13 = this;
            int r0 = r13.zzi
            int r1 = r13.zzg
            if (r1 != r0) goto L8
            goto Lbf
        L8:
            byte[] r2 = r13.zzf
            int r3 = r0 + 1
            r4 = r2[r0]
            if (r4 < 0) goto L14
            r13.zzi = r3
            long r0 = (long) r4
            return r0
        L14:
            int r1 = r1 - r3
            r5 = 9
            if (r1 < r5) goto Lbf
            int r1 = r0 + 2
            r3 = r2[r3]
            int r3 = r3 << 7
            r3 = r3 ^ r4
            if (r3 >= 0) goto L27
            r0 = r3 ^ (-128(0xffffffffffffff80, float:NaN))
            long r2 = (long) r0
            goto Lbc
        L27:
            int r4 = r0 + 3
            r1 = r2[r1]
            int r1 = r1 << 14
            r1 = r1 ^ r3
            if (r1 < 0) goto L36
            r0 = r1 ^ 16256(0x3f80, float:2.278E-41)
            long r2 = (long) r0
        L33:
            r1 = r4
            goto Lbc
        L36:
            int r3 = r0 + 4
            r4 = r2[r4]
            int r4 = r4 << 21
            r1 = r1 ^ r4
            if (r1 >= 0) goto L49
            r0 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            long r0 = (long) r0
            r11 = r0
            r1 = r3
            r2 = r11
            goto Lbc
        L49:
            int r4 = r0 + 5
            r3 = r2[r3]
            long r5 = (long) r3
            long r7 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r5 = r5 ^ r7
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 < 0) goto L5f
            r0 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r2 = r5 ^ r0
            goto L33
        L5f:
            int r1 = r0 + 6
            r3 = r2[r4]
            long r3 = (long) r3
            r9 = 35
            long r3 = r3 << r9
            long r3 = r3 ^ r5
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 >= 0) goto L74
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L71:
            long r3 = r3 ^ r5
        L72:
            r2 = r3
            goto Lbc
        L74:
            int r5 = r0 + 7
            r1 = r2[r1]
            long r9 = (long) r1
            r1 = 42
            long r9 = r9 << r1
            long r3 = r3 ^ r9
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 < 0) goto L8a
            r0 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            long r0 = r0 ^ r3
            r2 = r0
        L88:
            r1 = r5
            goto Lbc
        L8a:
            int r1 = r0 + 8
            r5 = r2[r5]
            long r5 = (long) r5
            r9 = 49
            long r5 = r5 << r9
            long r3 = r3 ^ r5
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 >= 0) goto L9d
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L71
        L9d:
            int r5 = r0 + 9
            r1 = r2[r1]
            long r9 = (long) r1
            r1 = 56
            long r9 = r9 << r1
            long r3 = r3 ^ r9
            r9 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r9
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto Lba
            int r1 = r0 + 10
            r0 = r2[r5]
            long r5 = (long) r0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 < 0) goto Lbf
            goto L72
        Lba:
            r2 = r3
            goto L88
        Lbc:
            r13.zzi = r1
            return r2
        Lbf:
            long r0 = r13.zzr()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgws.zzq():long");
    }

    public final long zzr() throws zzgyn {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.zzi == this.zzg) {
                zzK(1);
            }
            byte[] bArr = this.zzf;
            int i2 = this.zzi;
            this.zzi = i2 + 1;
            byte b = bArr[i2];
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw zzgyn.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzs() {
        return zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzt() {
        return zzgww.zzF(zzq());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzu() {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final zzgwm zzv() throws IOException {
        int iZzi = zzi();
        int i = this.zzg;
        int i2 = this.zzi;
        if (iZzi <= i - i2 && iZzi > 0) {
            zzgwm zzgwmVarZzv = zzgwm.zzv(this.zzf, i2, iZzi);
            this.zzi += iZzi;
            return zzgwmVarZzv;
        }
        if (iZzi == 0) {
            return zzgwm.zzb;
        }
        if (iZzi < 0) {
            throw zzgyn.zzf();
        }
        byte[] bArrZzN = zzN(iZzi);
        if (bArrZzN != null) {
            return zzgwm.zzv(bArrZzN, 0, bArrZzN.length);
        }
        int i3 = this.zzi;
        int i4 = this.zzg;
        int i5 = i4 - i3;
        this.zzk += i4;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzI = zzI(iZzi - i5);
        byte[] bArr = new byte[iZzi];
        System.arraycopy(this.zzf, i3, bArr, 0, i5);
        for (byte[] bArr2 : listZzI) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i5 += length;
        }
        return new zzgwk(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final String zzw() throws zzgyn {
        int iZzi = zzi();
        if (iZzi > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (iZzi <= i - i2) {
                String str = new String(this.zzf, i2, iZzi, zzgyl.zza);
                this.zzi += iZzi;
                return str;
            }
        }
        if (iZzi == 0) {
            return "";
        }
        if (iZzi < 0) {
            throw zzgyn.zzf();
        }
        if (iZzi > this.zzg) {
            return new String(zzM(iZzi, false), zzgyl.zza);
        }
        zzK(iZzi);
        String str2 = new String(this.zzf, this.zzi, iZzi, zzgyl.zza);
        this.zzi += iZzi;
        return str2;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final String zzx() throws IOException {
        byte[] bArrZzM;
        int iZzi = zzi();
        int i = this.zzi;
        int i2 = this.zzg;
        if (iZzi <= i2 - i && iZzi > 0) {
            bArrZzM = this.zzf;
            this.zzi = i + iZzi;
        } else {
            if (iZzi == 0) {
                return "";
            }
            if (iZzi < 0) {
                throw zzgyn.zzf();
            }
            i = 0;
            if (iZzi <= i2) {
                zzK(iZzi);
                bArrZzM = this.zzf;
                this.zzi = iZzi;
            } else {
                bArrZzM = zzM(iZzi, false);
            }
        }
        return zzhbe.zzh(bArrZzM, i, iZzi);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final void zzy(int i) throws zzgyn {
        if (this.zzj != i) {
            throw zzgyn.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final void zzz(int i) {
        this.zzl = i;
        zzJ();
    }
}
