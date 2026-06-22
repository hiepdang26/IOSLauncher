package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzgwb {
    public static int zza(byte[] bArr, int i, zzgwa zzgwaVar) throws zzgyn {
        int iZzh = zzh(bArr, i, zzgwaVar);
        int i2 = zzgwaVar.zza;
        if (i2 < 0) {
            throw zzgyn.zzf();
        }
        if (i2 > bArr.length - iZzh) {
            throw zzgyn.zzi();
        }
        if (i2 == 0) {
            zzgwaVar.zzc = zzgwm.zzb;
            return iZzh;
        }
        zzgwaVar.zzc = zzgwm.zzv(bArr, iZzh, i2);
        return iZzh + i2;
    }

    public static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public static int zzc(zzhae zzhaeVar, byte[] bArr, int i, int i2, int i3, zzgwa zzgwaVar) {
        Object objZze = zzhaeVar.zze();
        int iZzl = zzl(objZze, zzhaeVar, bArr, i, i2, i3, zzgwaVar);
        zzhaeVar.zzf(objZze);
        zzgwaVar.zzc = objZze;
        return iZzl;
    }

    public static int zzd(zzhae zzhaeVar, byte[] bArr, int i, int i2, zzgwa zzgwaVar) throws zzgyn {
        Object objZze = zzhaeVar.zze();
        int iZzm = zzm(objZze, zzhaeVar, bArr, i, i2, zzgwaVar);
        zzhaeVar.zzf(objZze);
        zzgwaVar.zzc = objZze;
        return iZzm;
    }

    public static int zze(zzhae zzhaeVar, int i, byte[] bArr, int i2, int i3, zzgyk zzgykVar, zzgwa zzgwaVar) throws zzgyn {
        int iZzd = zzd(zzhaeVar, bArr, i2, i3, zzgwaVar);
        zzgykVar.add(zzgwaVar.zzc);
        while (iZzd < i3) {
            int iZzh = zzh(bArr, iZzd, zzgwaVar);
            if (i != zzgwaVar.zza) {
                break;
            }
            iZzd = zzd(zzhaeVar, bArr, iZzh, i3, zzgwaVar);
            zzgykVar.add(zzgwaVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i, zzgyk zzgykVar, zzgwa zzgwaVar) throws zzgyn {
        zzgxz zzgxzVar = (zzgxz) zzgykVar;
        int iZzh = zzh(bArr, i, zzgwaVar);
        int i2 = zzgwaVar.zza + iZzh;
        while (iZzh < i2) {
            iZzh = zzh(bArr, iZzh, zzgwaVar);
            zzgxzVar.zzi(zzgwaVar.zza);
        }
        if (iZzh == i2) {
            return iZzh;
        }
        throw zzgyn.zzi();
    }

    public static int zzg(int i, byte[] bArr, int i2, int i3, zzhat zzhatVar, zzgwa zzgwaVar) throws zzgyn {
        if ((i >>> 3) == 0) {
            throw zzgyn.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzk = zzk(bArr, i2, zzgwaVar);
            zzhatVar.zzj(i, Long.valueOf(zzgwaVar.zzb));
            return iZzk;
        }
        if (i4 == 1) {
            zzhatVar.zzj(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzh = zzh(bArr, i2, zzgwaVar);
            int i5 = zzgwaVar.zza;
            if (i5 < 0) {
                throw zzgyn.zzf();
            }
            if (i5 > bArr.length - iZzh) {
                throw zzgyn.zzi();
            }
            if (i5 == 0) {
                zzhatVar.zzj(i, zzgwm.zzb);
            } else {
                zzhatVar.zzj(i, zzgwm.zzv(bArr, iZzh, i5));
            }
            return iZzh + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzgyn.zzc();
            }
            zzhatVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzhat zzhatVarZzf = zzhat.zzf();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzh2 = zzh(bArr, i2, zzgwaVar);
            i7 = zzgwaVar.zza;
            if (i7 == i6) {
                i2 = iZzh2;
                break;
            }
            i2 = zzg(i7, bArr, iZzh2, i3, zzhatVarZzf, zzgwaVar);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzgyn.zzg();
        }
        zzhatVar.zzj(i, zzhatVarZzf);
        return i2;
    }

    public static int zzh(byte[] bArr, int i, zzgwa zzgwaVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzgwaVar);
        }
        zzgwaVar.zza = b;
        return i2;
    }

    public static int zzi(int i, byte[] bArr, int i2, zzgwa zzgwaVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzgwaVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzgwaVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgwaVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgwaVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzgwaVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zzj(int i, byte[] bArr, int i2, int i3, zzgyk zzgykVar, zzgwa zzgwaVar) {
        zzgxz zzgxzVar = (zzgxz) zzgykVar;
        int iZzh = zzh(bArr, i2, zzgwaVar);
        zzgxzVar.zzi(zzgwaVar.zza);
        while (iZzh < i3) {
            int iZzh2 = zzh(bArr, iZzh, zzgwaVar);
            if (i != zzgwaVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzgwaVar);
            zzgxzVar.zzi(zzgwaVar.zza);
        }
        return iZzh;
    }

    public static int zzk(byte[] bArr, int i, zzgwa zzgwaVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzgwaVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        zzgwaVar.zzb = j2;
        return i3;
    }

    public static int zzl(Object obj, zzhae zzhaeVar, byte[] bArr, int i, int i2, int i3, zzgwa zzgwaVar) {
        int iZzc = ((zzgzm) zzhaeVar).zzc(obj, bArr, i, i2, i3, zzgwaVar);
        zzgwaVar.zzc = obj;
        return iZzc;
    }

    public static int zzm(Object obj, zzhae zzhaeVar, byte[] bArr, int i, int i2, zzgwa zzgwaVar) throws zzgyn {
        int iZzi = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzi = zzi(i3, bArr, iZzi, zzgwaVar);
            i3 = zzgwaVar.zza;
        }
        int i4 = iZzi;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzgyn.zzi();
        }
        int i5 = i4 + i3;
        zzhaeVar.zzi(obj, bArr, i4, i5, zzgwaVar);
        zzgwaVar.zzc = obj;
        return i5;
    }

    public static long zzn(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
