package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzhat {
    private static final zzhat zza = new zzhat(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhat(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzhat zzc() {
        return zza;
    }

    public static zzhat zze(zzhat zzhatVar, zzhat zzhatVar2) {
        int i = zzhatVar.zzb + zzhatVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzhatVar.zzc, i);
        System.arraycopy(zzhatVar2.zzc, 0, iArrCopyOf, zzhatVar.zzb, zzhatVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzhatVar.zzd, i);
        System.arraycopy(zzhatVar2.zzd, 0, objArrCopyOf, zzhatVar.zzb, zzhatVar2.zzb);
        return new zzhat(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzhat zzf() {
        return new zzhat();
    }

    private final void zzn(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhat)) {
            return false;
        }
        zzhat zzhatVar = (zzhat) obj;
        int i = this.zzb;
        if (i == zzhatVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhatVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzhatVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int zza() {
        int iZzD;
        int iZzE;
        int iZzD2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzD3 = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 == 1) {
                    ((Long) this.zzd[i2]).getClass();
                    iZzD2 = zzgxd.zzD(i4 << 3) + 8;
                } else if (i5 == 2) {
                    int i6 = i4 << 3;
                    zzgwm zzgwmVar = (zzgwm) this.zzd[i2];
                    int iZzD4 = zzgxd.zzD(i6);
                    int iZzd = zzgwmVar.zzd();
                    iZzD3 = zzgxd.zzD(iZzd) + iZzd + iZzD4 + iZzD3;
                } else if (i5 == 3) {
                    int iZzD5 = zzgxd.zzD(i4 << 3);
                    iZzD = iZzD5 + iZzD5;
                    iZzE = ((zzhat) this.zzd[i2]).zza();
                } else {
                    if (i5 != 5) {
                        throw new IllegalStateException(zzgyn.zza());
                    }
                    ((Integer) this.zzd[i2]).getClass();
                    iZzD2 = zzgxd.zzD(i4 << 3) + 4;
                }
                iZzD3 = iZzD2 + iZzD3;
            } else {
                int i7 = i4 << 3;
                long jLongValue = ((Long) this.zzd[i2]).longValue();
                iZzD = zzgxd.zzD(i7);
                iZzE = zzgxd.zzE(jLongValue);
            }
            iZzD3 = iZzE + iZzD + iZzD3;
        }
        this.zze = iZzD3;
        return iZzD3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iH = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzgwm zzgwmVar = (zzgwm) this.zzd[i2];
            int iZzD = zzgxd.zzD(8);
            int iZzD2 = zzgxd.zzD(i3) + zzgxd.zzD(16);
            int iZzD3 = zzgxd.zzD(24);
            int iZzd = zzgwmVar.zzd();
            iH += iZzD + iZzD + iZzD2 + k31.h(iZzd, iZzd, iZzD3);
        }
        this.zze = iH;
        return iH;
    }

    public final zzhat zzd(zzhat zzhatVar) {
        if (zzhatVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzhatVar.zzb;
        zzn(i);
        System.arraycopy(zzhatVar.zzc, 0, this.zzc, this.zzb, zzhatVar.zzb);
        System.arraycopy(zzhatVar.zzd, 0, this.zzd, this.zzb, zzhatVar.zzb);
        this.zzb = i;
        return this;
    }

    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzgzl.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzj(int i, Object obj) {
        zzg();
        zzn(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzhbh zzhbhVar) {
        for (int i = 0; i < this.zzb; i++) {
            zzhbhVar.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzhbh zzhbhVar) {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzhbhVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzhbhVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzhbhVar.zzd(i4, (zzgwm) obj);
                } else if (i3 == 3) {
                    zzhbhVar.zzF(i4);
                    ((zzhat) obj).zzl(zzhbhVar);
                    zzhbhVar.zzh(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(zzgyn.zza());
                    }
                    zzhbhVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final boolean zzm(int i, zzgww zzgwwVar) throws zzgym {
        int iZzl;
        zzg();
        int i2 = i & 7;
        if (i2 == 0) {
            zzj(i, Long.valueOf(zzgwwVar.zzo()));
            return true;
        }
        if (i2 == 1) {
            zzj(i, Long.valueOf(zzgwwVar.zzn()));
            return true;
        }
        if (i2 == 2) {
            zzj(i, zzgwwVar.zzv());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzgyn.zza();
            }
            zzj(i, Integer.valueOf(zzgwwVar.zzf()));
            return true;
        }
        zzhat zzhatVar = new zzhat();
        do {
            iZzl = zzgwwVar.zzl();
            if (iZzl == 0) {
                break;
            }
        } while (zzhatVar.zzm(iZzl, zzgwwVar));
        zzgwwVar.zzy(4 | ((i >>> 3) << 3));
        zzj(i, zzhatVar);
        return true;
    }

    private zzhat() {
        this(0, new int[8], new Object[8], true);
    }
}
