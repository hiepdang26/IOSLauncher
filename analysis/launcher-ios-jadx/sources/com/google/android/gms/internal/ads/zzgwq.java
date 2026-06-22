package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzgwq extends zzgww {
    private final Iterable zze;
    private final Iterator zzf;
    private ByteBuffer zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;

    public /* synthetic */ zzgwq(Iterable iterable, int i, boolean z, zzgwp zzgwpVar) {
        super(null);
        this.zzj = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zzh = i;
        this.zze = iterable;
        this.zzf = iterable.iterator();
        this.zzl = 0;
        if (i != 0) {
            zzM();
            return;
        }
        this.zzg = zzgyl.zzc;
        this.zzm = 0L;
        this.zzn = 0L;
        this.zzo = 0L;
    }

    private final int zzI() {
        return (int) ((((long) (this.zzh - this.zzl)) - this.zzm) + this.zzn);
    }

    private final void zzJ() throws zzgyn {
        if (!this.zzf.hasNext()) {
            throw zzgyn.zzi();
        }
        zzM();
    }

    private final void zzK(byte[] bArr, int i, int i2) throws zzgyn {
        if (i2 > zzI()) {
            if (i2 > 0) {
                throw zzgyn.zzi();
            }
            return;
        }
        int i3 = i2;
        while (i3 > 0) {
            if (this.zzo - this.zzm == 0) {
                zzJ();
            }
            int iMin = Math.min(i3, (int) (this.zzo - this.zzm));
            long j = iMin;
            zzhaz.zzo(this.zzm, bArr, i2 - i3, j);
            i3 -= iMin;
            this.zzm += j;
        }
    }

    private final void zzL() {
        int i = this.zzh + this.zzi;
        this.zzh = i;
        int i2 = this.zzj;
        if (i <= i2) {
            this.zzi = 0;
            return;
        }
        int i3 = i - i2;
        this.zzi = i3;
        this.zzh = i - i3;
    }

    private final void zzM() {
        ByteBuffer byteBuffer = (ByteBuffer) this.zzf.next();
        this.zzg = byteBuffer;
        this.zzl += (int) (this.zzm - this.zzn);
        long jPosition = byteBuffer.position();
        this.zzm = jPosition;
        this.zzn = jPosition;
        this.zzo = this.zzg.limit();
        long jZze = zzhaz.zze(this.zzg);
        this.zzm += jZze;
        this.zzn += jZze;
        this.zzo += jZze;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final boolean zzA() {
        return (((long) this.zzl) + this.zzm) - this.zzn == ((long) this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final boolean zzB() {
        return zzr() != 0;
    }

    public final long zzC() throws zzgyn {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzh = zzh();
            j |= ((long) (bZzh & 127)) << i;
            if ((bZzh & 128) == 0) {
                return j;
            }
        }
        throw zzgyn.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final double zza() {
        return Double.longBitsToDouble(zzq());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final float zzb() {
        return Float.intBitsToFloat(zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzc() {
        return (int) ((((long) this.zzl) + this.zzm) - this.zzn);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzd(int i) throws zzgyn {
        if (i < 0) {
            throw zzgyn.zzf();
        }
        int iZzc = i + zzc();
        int i2 = this.zzj;
        if (iZzc > i2) {
            throw zzgyn.zzi();
        }
        this.zzj = iZzc;
        zzL();
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zze() {
        return zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzf() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzg() {
        return zzp();
    }

    public final byte zzh() throws zzgyn {
        if (this.zzo - this.zzm == 0) {
            zzJ();
        }
        long j = this.zzm;
        this.zzm = 1 + j;
        return zzhaz.zza(j);
    }

    public final int zzi() {
        long j = this.zzo;
        long j2 = this.zzm;
        if (j - j2 < 4) {
            int iZzh = zzh() & 255;
            int iZzh2 = (zzh() & 255) << 8;
            return iZzh | iZzh2 | ((zzh() & 255) << 16) | ((zzh() & 255) << 24);
        }
        this.zzm = 4 + j2;
        int iZza = zzhaz.zza(j2) & 255;
        int iZza2 = (zzhaz.zza(1 + j2) & 255) << 8;
        return iZza | iZza2 | ((zzhaz.zza(2 + j2) & 255) << 16) | ((zzhaz.zza(j2 + 3) & 255) << 24);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzj() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzk() {
        return zzgww.zzD(zzp());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzl() throws zzgyn {
        if (zzA()) {
            this.zzk = 0;
            return 0;
        }
        int iZzp = zzp();
        this.zzk = iZzp;
        if ((iZzp >>> 3) != 0) {
            return iZzp;
        }
        throw zzgyn.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzm() {
        return zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzn() {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzo() {
        return zzr();
    }

    public final int zzp() {
        int i;
        long j = this.zzm;
        if (this.zzo != j) {
            long j2 = j + 1;
            byte bZza = zzhaz.zza(j);
            if (bZza >= 0) {
                this.zzm++;
                return bZza;
            }
            if (this.zzo - this.zzm >= 10) {
                long j3 = 2 + j;
                int iZza = (zzhaz.zza(j2) << 7) ^ bZza;
                if (iZza < 0) {
                    i = iZza ^ (-128);
                } else {
                    long j4 = 3 + j;
                    int iZza2 = (zzhaz.zza(j3) << 14) ^ iZza;
                    if (iZza2 >= 0) {
                        i = iZza2 ^ 16256;
                    } else {
                        long j5 = 4 + j;
                        int iZza3 = iZza2 ^ (zzhaz.zza(j4) << 21);
                        if (iZza3 < 0) {
                            i = (-2080896) ^ iZza3;
                        } else {
                            j4 = 5 + j;
                            byte bZza2 = zzhaz.zza(j5);
                            int i2 = (iZza3 ^ (bZza2 << 28)) ^ 266354560;
                            if (bZza2 < 0) {
                                j5 = 6 + j;
                                if (zzhaz.zza(j4) < 0) {
                                    j4 = 7 + j;
                                    if (zzhaz.zza(j5) < 0) {
                                        j5 = 8 + j;
                                        if (zzhaz.zza(j4) < 0) {
                                            j4 = 9 + j;
                                            if (zzhaz.zza(j5) < 0) {
                                                long j6 = j + 10;
                                                if (zzhaz.zza(j4) >= 0) {
                                                    i = i2;
                                                    j3 = j6;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i2;
                            }
                            i = i2;
                        }
                        j3 = j5;
                    }
                    j3 = j4;
                }
                this.zzm = j3;
                return i;
            }
        }
        return (int) zzC();
    }

    public final long zzq() {
        long j = this.zzo;
        long j2 = this.zzm;
        if (j - j2 < 8) {
            long jZzh = ((long) zzh()) & 255;
            long jZzh2 = (((long) zzh()) & 255) << 8;
            long jZzh3 = (((long) zzh()) & 255) << 16;
            long jZzh4 = (((long) zzh()) & 255) << 24;
            long jZzh5 = (((long) zzh()) & 255) << 32;
            long jZzh6 = (((long) zzh()) & 255) << 40;
            return jZzh | jZzh2 | jZzh3 | jZzh4 | jZzh5 | jZzh6 | ((((long) zzh()) & 255) << 48) | ((((long) zzh()) & 255) << 56);
        }
        this.zzm = 8 + j2;
        long jZza = ((long) zzhaz.zza(j2)) & 255;
        long jZza2 = (((long) zzhaz.zza(1 + j2)) & 255) << 8;
        long jZza3 = (((long) zzhaz.zza(j2 + 2)) & 255) << 16;
        long jZza4 = (((long) zzhaz.zza(3 + j2)) & 255) << 24;
        long jZza5 = (((long) zzhaz.zza(j2 + 4)) & 255) << 32;
        long jZza6 = (((long) zzhaz.zza(j2 + 5)) & 255) << 40;
        return ((((long) zzhaz.zza(j2 + 6)) & 255) << 48) | jZza3 | jZza | jZza2 | jZza4 | jZza5 | jZza6 | ((((long) zzhaz.zza(j2 + 7)) & 255) << 56);
    }

    public final long zzr() {
        long j;
        long j2;
        long j3 = this.zzm;
        if (this.zzo != j3) {
            long j4 = j3 + 1;
            byte bZza = zzhaz.zza(j3);
            if (bZza >= 0) {
                this.zzm++;
                return bZza;
            }
            if (this.zzo - this.zzm >= 10) {
                long j5 = 2 + j3;
                int iZza = (zzhaz.zza(j4) << 7) ^ bZza;
                if (iZza < 0) {
                    j = iZza ^ (-128);
                } else {
                    long j6 = 3 + j3;
                    int iZza2 = (zzhaz.zza(j5) << 14) ^ iZza;
                    if (iZza2 >= 0) {
                        j = iZza2 ^ 16256;
                    } else {
                        long j7 = 4 + j3;
                        int iZza3 = iZza2 ^ (zzhaz.zza(j6) << 21);
                        if (iZza3 < 0) {
                            j = (-2080896) ^ iZza3;
                            j5 = j7;
                        } else {
                            j6 = 5 + j3;
                            long jZza = (((long) zzhaz.zza(j7)) << 28) ^ ((long) iZza3);
                            if (jZza >= 0) {
                                j = 266354560 ^ jZza;
                            } else {
                                long j8 = 6 + j3;
                                long jZza2 = jZza ^ (((long) zzhaz.zza(j6)) << 35);
                                if (jZza2 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    long j9 = 7 + j3;
                                    long jZza3 = jZza2 ^ (((long) zzhaz.zza(j8)) << 42);
                                    if (jZza3 >= 0) {
                                        j = 4363953127296L ^ jZza3;
                                    } else {
                                        j8 = 8 + j3;
                                        jZza2 = jZza3 ^ (((long) zzhaz.zza(j9)) << 49);
                                        if (jZza2 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            j9 = 9 + j3;
                                            long jZza4 = (jZza2 ^ (((long) zzhaz.zza(j8)) << 56)) ^ 71499008037633920L;
                                            if (jZza4 < 0) {
                                                long j10 = j3 + 10;
                                                if (zzhaz.zza(j9) >= 0) {
                                                    j5 = j10;
                                                    j = jZza4;
                                                }
                                            } else {
                                                j = jZza4;
                                            }
                                        }
                                    }
                                    j5 = j9;
                                }
                                j = j2 ^ jZza2;
                                j5 = j8;
                            }
                        }
                    }
                    j5 = j6;
                }
                this.zzm = j5;
                return j;
            }
        }
        return zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzs() {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzt() {
        return zzgww.zzF(zzr());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzu() {
        return zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final zzgwm zzv() throws zzgyn {
        int iZzp = zzp();
        if (iZzp > 0) {
            long j = this.zzo;
            long j2 = this.zzm;
            long j3 = iZzp;
            if (j3 <= j - j2) {
                byte[] bArr = new byte[iZzp];
                zzhaz.zzo(j2, bArr, 0L, j3);
                this.zzm += j3;
                return new zzgwk(bArr);
            }
        }
        if (iZzp > 0 && iZzp <= zzI()) {
            byte[] bArr2 = new byte[iZzp];
            zzK(bArr2, 0, iZzp);
            return new zzgwk(bArr2);
        }
        if (iZzp == 0) {
            return zzgwm.zzb;
        }
        if (iZzp < 0) {
            throw zzgyn.zzf();
        }
        throw zzgyn.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final String zzw() throws zzgyn {
        int iZzp = zzp();
        if (iZzp > 0) {
            long j = this.zzo;
            long j2 = this.zzm;
            long j3 = iZzp;
            if (j3 <= j - j2) {
                byte[] bArr = new byte[iZzp];
                zzhaz.zzo(j2, bArr, 0L, j3);
                String str = new String(bArr, zzgyl.zza);
                this.zzm += j3;
                return str;
            }
        }
        if (iZzp > 0 && iZzp <= zzI()) {
            byte[] bArr2 = new byte[iZzp];
            zzK(bArr2, 0, iZzp);
            return new String(bArr2, zzgyl.zza);
        }
        if (iZzp == 0) {
            return "";
        }
        if (iZzp < 0) {
            throw zzgyn.zzf();
        }
        throw zzgyn.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final String zzx() throws zzgyn {
        int iZzp = zzp();
        if (iZzp > 0) {
            long j = this.zzo;
            long j2 = this.zzm;
            long j3 = iZzp;
            if (j3 <= j - j2) {
                String strZzg = zzhbe.zzg(this.zzg, (int) (j2 - this.zzn), iZzp);
                this.zzm += j3;
                return strZzg;
            }
        }
        if (iZzp >= 0 && iZzp <= zzI()) {
            byte[] bArr = new byte[iZzp];
            zzK(bArr, 0, iZzp);
            return zzhbe.zzh(bArr, 0, iZzp);
        }
        if (iZzp == 0) {
            return "";
        }
        if (iZzp <= 0) {
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
        this.zzj = i;
        zzL();
    }
}
