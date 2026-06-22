package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
final class zzgwu extends zzgww {
    private final ByteBuffer zze;
    private final long zzf;
    private long zzg;
    private long zzh;
    private final long zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    public /* synthetic */ zzgwu(ByteBuffer byteBuffer, boolean z, zzgwt zzgwtVar) {
        super(null);
        this.zzl = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zze = byteBuffer;
        long jZze = zzhaz.zze(byteBuffer);
        this.zzf = jZze;
        this.zzg = ((long) byteBuffer.limit()) + jZze;
        long jPosition = jZze + ((long) byteBuffer.position());
        this.zzh = jPosition;
        this.zzi = jPosition;
    }

    private final int zzC() {
        return (int) (this.zzg - this.zzh);
    }

    private final void zzI() {
        long j = this.zzg + ((long) this.zzj);
        this.zzg = j;
        int i = (int) (j - this.zzi);
        int i2 = this.zzl;
        if (i <= i2) {
            this.zzj = 0;
            return;
        }
        int i3 = i - i2;
        this.zzj = i3;
        this.zzg = j - ((long) i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final boolean zzA() {
        return this.zzh == this.zzg;
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
        return (int) (this.zzh - this.zzi);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzd(int i) throws zzgyn {
        if (i < 0) {
            throw zzgyn.zzf();
        }
        int iZzc = i + zzc();
        int i2 = this.zzl;
        if (iZzc > i2) {
            throw zzgyn.zzi();
        }
        this.zzl = iZzc;
        zzI();
        return i2;
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
        long j = this.zzh;
        if (this.zzg - j < 4) {
            throw zzgyn.zzi();
        }
        this.zzh = 4 + j;
        int iZza = zzhaz.zza(j) & 255;
        int iZza2 = zzhaz.zza(1 + j) & 255;
        int iZza3 = zzhaz.zza(2 + j) & 255;
        return ((zzhaz.zza(j + 3) & 255) << 24) | (iZza2 << 8) | iZza | (iZza3 << 16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0089, code lost:
    
        if (com.google.android.gms.internal.ads.zzhaz.zza(r3) >= 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzi() {
        /*
            r10 = this;
            long r0 = r10.zzh
            long r2 = r10.zzg
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 != 0) goto La
            goto L92
        La:
            r2 = 1
            long r2 = r2 + r0
            byte r4 = com.google.android.gms.internal.ads.zzhaz.zza(r0)
            if (r4 < 0) goto L16
            r10.zzh = r2
            return r4
        L16:
            long r5 = r10.zzg
            long r5 = r5 - r2
            r7 = 9
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 < 0) goto L92
            r5 = 2
            long r5 = r5 + r0
            byte r2 = com.google.android.gms.internal.ads.zzhaz.zza(r2)
            int r2 = r2 << 7
            r2 = r2 ^ r4
            if (r2 >= 0) goto L2e
            r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L8f
        L2e:
            r3 = 3
            long r3 = r3 + r0
            byte r5 = com.google.android.gms.internal.ads.zzhaz.zza(r5)
            int r5 = r5 << 14
            r2 = r2 ^ r5
            if (r2 < 0) goto L3e
            r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
        L3c:
            r5 = r3
            goto L8f
        L3e:
            r5 = 4
            long r5 = r5 + r0
            byte r3 = com.google.android.gms.internal.ads.zzhaz.zza(r3)
            int r3 = r3 << 21
            r2 = r2 ^ r3
            if (r2 >= 0) goto L4f
            r0 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L8f
        L4f:
            r3 = 5
            long r3 = r3 + r0
            byte r5 = com.google.android.gms.internal.ads.zzhaz.zza(r5)
            int r6 = r5 << 28
            r2 = r2 ^ r6
            r6 = 266354560(0xfe03f80, float:2.2112565E-29)
            r2 = r2 ^ r6
            if (r5 >= 0) goto L8d
            r5 = 6
            long r5 = r5 + r0
            byte r3 = com.google.android.gms.internal.ads.zzhaz.zza(r3)
            if (r3 >= 0) goto L8b
            r3 = 7
            long r3 = r3 + r0
            byte r5 = com.google.android.gms.internal.ads.zzhaz.zza(r5)
            if (r5 >= 0) goto L8d
            r5 = 8
            long r5 = r5 + r0
            byte r3 = com.google.android.gms.internal.ads.zzhaz.zza(r3)
            if (r3 >= 0) goto L8b
            long r3 = r0 + r7
            byte r5 = com.google.android.gms.internal.ads.zzhaz.zza(r5)
            if (r5 >= 0) goto L8d
            r5 = 10
            long r5 = r5 + r0
            byte r0 = com.google.android.gms.internal.ads.zzhaz.zza(r3)
            if (r0 < 0) goto L92
        L8b:
            r0 = r2
            goto L8f
        L8d:
            r0 = r2
            goto L3c
        L8f:
            r10.zzh = r5
            return r0
        L92:
            long r0 = r10.zzr()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgwu.zzi():int");
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
            this.zzk = 0;
            return 0;
        }
        int iZzi = zzi();
        this.zzk = iZzi;
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
        long j = this.zzh;
        if (this.zzg - j < 8) {
            throw zzgyn.zzi();
        }
        this.zzh = 8 + j;
        long jZza = zzhaz.zza(j);
        long jZza2 = zzhaz.zza(1 + j);
        long jZza3 = zzhaz.zza(2 + j);
        long jZza4 = zzhaz.zza(3 + j);
        long jZza5 = zzhaz.zza(4 + j);
        return ((((long) zzhaz.zza(j + 7)) & 255) << 56) | (jZza & 255) | ((jZza2 & 255) << 8) | ((jZza3 & 255) << 16) | ((jZza4 & 255) << 24) | ((jZza5 & 255) << 32) | ((zzhaz.zza(5 + j) & 255) << 40) | ((((long) zzhaz.zza(6 + j)) & 255) << 48);
    }

    public final long zzq() {
        long j;
        long j2;
        int i;
        long j3 = this.zzh;
        if (this.zzg != j3) {
            long j4 = 1 + j3;
            byte bZza = zzhaz.zza(j3);
            if (bZza >= 0) {
                this.zzh = j4;
                return bZza;
            }
            if (this.zzg - j4 >= 9) {
                long j5 = 2 + j3;
                int iZza = (zzhaz.zza(j4) << 7) ^ bZza;
                if (iZza >= 0) {
                    long j6 = 3 + j3;
                    int iZza2 = iZza ^ (zzhaz.zza(j5) << 14);
                    if (iZza2 >= 0) {
                        j = iZza2 ^ 16256;
                    } else {
                        j5 = 4 + j3;
                        int iZza3 = iZza2 ^ (zzhaz.zza(j6) << 21);
                        if (iZza3 < 0) {
                            i = (-2080896) ^ iZza3;
                        } else {
                            j6 = 5 + j3;
                            long jZza = (((long) zzhaz.zza(j5)) << 28) ^ ((long) iZza3);
                            if (jZza < 0) {
                                long j7 = 6 + j3;
                                long jZza2 = (((long) zzhaz.zza(j6)) << 35) ^ jZza;
                                if (jZza2 >= 0) {
                                    long j8 = 7 + j3;
                                    long jZza3 = jZza2 ^ (((long) zzhaz.zza(j7)) << 42);
                                    if (jZza3 >= 0) {
                                        j = 4363953127296L ^ jZza3;
                                        j5 = j8;
                                    } else {
                                        j7 = 8 + j3;
                                        jZza2 = jZza3 ^ (((long) zzhaz.zza(j8)) << 49);
                                        if (jZza2 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            j5 = j3 + 9;
                                            long jZza4 = (jZza2 ^ (((long) zzhaz.zza(j7)) << 56)) ^ 71499008037633920L;
                                            if (jZza4 < 0) {
                                                long j9 = j3 + 10;
                                                if (zzhaz.zza(j5) >= 0) {
                                                    j5 = j9;
                                                }
                                            }
                                            j = jZza4;
                                        }
                                    }
                                    this.zzh = j5;
                                    return j;
                                }
                                j2 = -34093383808L;
                                j = j2 ^ jZza2;
                                j5 = j7;
                                this.zzh = j5;
                                return j;
                            }
                            j = 266354560 ^ jZza;
                        }
                    }
                    j5 = j6;
                    this.zzh = j5;
                    return j;
                }
                i = iZza ^ (-128);
                j = i;
                this.zzh = j5;
                return j;
            }
        }
        return zzr();
    }

    public final long zzr() throws zzgyn {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            long j2 = this.zzh;
            if (j2 == this.zzg) {
                throw zzgyn.zzi();
            }
            this.zzh = 1 + j2;
            byte bZza = zzhaz.zza(j2);
            j |= ((long) (bZza & 127)) << i;
            if ((bZza & 128) == 0) {
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
        if (iZzi <= 0 || iZzi > zzC()) {
            if (iZzi == 0) {
                return zzgwm.zzb;
            }
            if (iZzi < 0) {
                throw zzgyn.zzf();
            }
            throw zzgyn.zzi();
        }
        byte[] bArr = new byte[iZzi];
        long j = iZzi;
        zzhaz.zzo(this.zzh, bArr, 0L, j);
        this.zzh += j;
        return new zzgwk(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final String zzw() throws zzgyn {
        int iZzi = zzi();
        if (iZzi <= 0 || iZzi > zzC()) {
            if (iZzi == 0) {
                return "";
            }
            if (iZzi < 0) {
                throw zzgyn.zzf();
            }
            throw zzgyn.zzi();
        }
        byte[] bArr = new byte[iZzi];
        long j = iZzi;
        zzhaz.zzo(this.zzh, bArr, 0L, j);
        String str = new String(bArr, zzgyl.zza);
        this.zzh += j;
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final String zzx() throws zzgyn {
        int iZzi = zzi();
        if (iZzi > 0 && iZzi <= zzC()) {
            String strZzg = zzhbe.zzg(this.zze, (int) (this.zzh - this.zzf), iZzi);
            this.zzh += (long) iZzi;
            return strZzg;
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
        if (this.zzk != i) {
            throw zzgyn.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final void zzz(int i) {
        this.zzl = i;
        zzI();
    }
}
