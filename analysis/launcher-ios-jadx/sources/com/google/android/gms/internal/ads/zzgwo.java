package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzgwo extends zzgww {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final int zzi;
    private int zzj;
    private int zzk;

    public /* synthetic */ zzgwo(byte[] bArr, int i, int i2, boolean z, zzgwn zzgwnVar) {
        super(null);
        this.zzk = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zze = bArr;
        this.zzf = i2 + i;
        this.zzh = i;
        this.zzi = i;
    }

    private final void zzC() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = i - this.zzi;
        int i3 = this.zzk;
        if (i2 <= i3) {
            this.zzg = 0;
            return;
        }
        int i4 = i2 - i3;
        this.zzg = i4;
        this.zzf = i - i4;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final boolean zzA() {
        return this.zzh == this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final boolean zzB() {
        return zzq() != 0;
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
        return this.zzh - this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzd(int i) {
        if (i < 0) {
            throw zzgyn.zzf();
        }
        int i2 = (this.zzh - this.zzi) + i;
        if (i2 < 0) {
            throw zzgyn.zzg();
        }
        int i3 = this.zzk;
        if (i2 > i3) {
            throw zzgyn.zzi();
        }
        this.zzk = i2;
        zzC();
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
        int i = this.zzh;
        if (this.zzf - i < 4) {
            throw zzgyn.zzi();
        }
        byte[] bArr = this.zze;
        this.zzh = i + 4;
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public final int zzi() {
        int i;
        int i2 = this.zzh;
        int i3 = this.zzf;
        if (i3 != i2) {
            byte[] bArr = this.zze;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzh = i4;
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
                this.zzh = i5;
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
        int i = this.zzh;
        if (this.zzf - i < 8) {
            throw zzgyn.zzi();
        }
        byte[] bArr = this.zze;
        this.zzh = i + 8;
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
            int r0 = r13.zzh
            int r1 = r13.zzf
            if (r1 != r0) goto L8
            goto Lbf
        L8:
            byte[] r2 = r13.zze
            int r3 = r0 + 1
            r4 = r2[r0]
            if (r4 < 0) goto L14
            r13.zzh = r3
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
            r13.zzh = r1
            return r2
        Lbf:
            long r0 = r13.zzr()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgwo.zzq():long");
    }

    public final long zzr() throws zzgyn {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            int i2 = this.zzh;
            if (i2 == this.zzf) {
                throw zzgyn.zzi();
            }
            byte[] bArr = this.zze;
            this.zzh = i2 + 1;
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
    public final zzgwm zzv() throws zzgyn {
        int iZzi = zzi();
        if (iZzi > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZzi <= i - i2) {
                zzgwm zzgwmVarZzv = zzgwm.zzv(this.zze, i2, iZzi);
                this.zzh += iZzi;
                return zzgwmVarZzv;
            }
        }
        if (iZzi == 0) {
            return zzgwm.zzb;
        }
        if (iZzi > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (iZzi <= i3 - i4) {
                int i5 = iZzi + i4;
                this.zzh = i5;
                return new zzgwk(Arrays.copyOfRange(this.zze, i4, i5));
            }
        }
        if (iZzi <= 0) {
            throw zzgyn.zzf();
        }
        throw zzgyn.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final String zzw() throws zzgyn {
        int iZzi = zzi();
        if (iZzi > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZzi <= i - i2) {
                String str = new String(this.zze, i2, iZzi, zzgyl.zza);
                this.zzh += iZzi;
                return str;
            }
        }
        if (iZzi == 0) {
            return "";
        }
        if (iZzi < 0) {
            throw zzgyn.zzf();
        }
        throw zzgyn.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final String zzx() throws zzgyn {
        int iZzi = zzi();
        if (iZzi > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZzi <= i - i2) {
                String strZzh = zzhbe.zzh(this.zze, i2, iZzi);
                this.zzh += iZzi;
                return strZzh;
            }
        }
        if (iZzi == 0) {
            return "";
        }
        if (iZzi <= 0) {
            throw zzgyn.zzf();
        }
        throw zzgyn.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final void zzy(int i) throws zzgyn {
        if (this.zzj != i) {
            throw zzgyn.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final void zzz(int i) {
        this.zzk = i;
        zzC();
    }
}
