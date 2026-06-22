package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.internal.ads.zzbbc;
import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzgzm<T> implements zzhae<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhaz.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgzj zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzhas zzm;
    private final zzgxj zzn;

    private zzgzm(int[] iArr, Object[] objArr, int i, int i2, zzgzj zzgzjVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzgzp zzgzpVar, zzgyw zzgywVar, zzhas zzhasVar, zzgxj zzgxjVar, zzgze zzgzeVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzgzjVar instanceof zzgxy;
        boolean z2 = false;
        if (zzgxjVar != null && (zzgzjVar instanceof zzgxu)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i4;
        this.zzl = i5;
        this.zzm = zzhasVar;
        this.zzn = zzgxjVar;
        this.zzg = zzgzjVar;
    }

    private final Object zzA(Object obj, int i) {
        zzhae zzhaeVarZzx = zzx(i);
        int iZzu = zzu(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzhaeVarZzx.zze();
        }
        Object object = zzb.getObject(obj, iZzu);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzhaeVarZzx.zze();
        if (object != null) {
            zzhaeVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzB(Object obj, int i, int i2) {
        zzhae zzhaeVarZzx = zzx(i2);
        if (!zzR(obj, i, i2)) {
            return zzhaeVarZzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i2) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzhaeVarZzx.zze();
        if (object != null) {
            zzhaeVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzE(Object obj, Object obj2, int i) {
        if (zzN(obj2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzhae zzhaeVarZzx = zzx(i);
            if (!zzN(obj, i)) {
                if (zzQ(object)) {
                    Object objZze = zzhaeVarZzx.zze();
                    zzhaeVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzH(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzhaeVarZzx.zze();
                zzhaeVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzhaeVarZzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzR(obj2, i2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzhae zzhaeVarZzx = zzx(i);
            if (!zzR(obj, i2, i)) {
                if (zzQ(object)) {
                    Object objZze = zzhaeVarZzx.zze();
                    zzhaeVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzI(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzhaeVarZzx.zze();
                zzhaeVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzhaeVarZzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i, zzgzw zzgzwVar) {
        long j = i & 1048575;
        if (zzM(i)) {
            zzhaz.zzv(obj, j, zzgzwVar.zzs());
        } else if (this.zzi) {
            zzhaz.zzv(obj, j, zzgzwVar.zzr());
        } else {
            zzhaz.zzv(obj, j, zzgzwVar.zzp());
        }
    }

    private final void zzH(Object obj, int i) {
        int iZzr = zzr(i);
        long j = 1048575 & iZzr;
        if (j == 1048575) {
            return;
        }
        zzhaz.zzt(obj, j, (1 << (iZzr >>> 20)) | zzhaz.zzd(obj, j));
    }

    private final void zzI(Object obj, int i, int i2) {
        zzhaz.zzt(obj, zzr(i2) & 1048575, i);
    }

    private final void zzJ(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzu(i) & 1048575, obj2);
        zzH(obj, i);
    }

    private final void zzK(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzu(i2) & 1048575, obj2);
        zzI(obj, i, i2);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzN(obj, i) == zzN(obj2, i);
    }

    private static boolean zzM(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int iZzr = zzr(i);
        long j = iZzr & 1048575;
        if (j != 1048575) {
            return (zzhaz.zzd(obj, j) & (1 << (iZzr >>> 20))) != 0;
        }
        int iZzu = zzu(i);
        long j2 = iZzu & 1048575;
        switch (zzt(iZzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzhaz.zzb(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhaz.zzc(obj, j2)) != 0;
            case 2:
                return zzhaz.zzf(obj, j2) != 0;
            case 3:
                return zzhaz.zzf(obj, j2) != 0;
            case 4:
                return zzhaz.zzd(obj, j2) != 0;
            case 5:
                return zzhaz.zzf(obj, j2) != 0;
            case 6:
                return zzhaz.zzd(obj, j2) != 0;
            case 7:
                return zzhaz.zzz(obj, j2);
            case 8:
                Object objZzh = zzhaz.zzh(obj, j2);
                if (objZzh instanceof String) {
                    return !((String) objZzh).isEmpty();
                }
                if (objZzh instanceof zzgwm) {
                    return !zzgwm.zzb.equals(objZzh);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhaz.zzh(obj, j2) != null;
            case 10:
                return !zzgwm.zzb.equals(zzhaz.zzh(obj, j2));
            case 11:
                return zzhaz.zzd(obj, j2) != 0;
            case 12:
                return zzhaz.zzd(obj, j2) != 0;
            case 13:
                return zzhaz.zzd(obj, j2) != 0;
            case 14:
                return zzhaz.zzf(obj, j2) != 0;
            case 15:
                return zzhaz.zzd(obj, j2) != 0;
            case 16:
                return zzhaz.zzf(obj, j2) != 0;
            case 17:
                return zzhaz.zzh(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzN(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzP(Object obj, int i, zzhae zzhaeVar) {
        return zzhaeVar.zzl(zzhaz.zzh(obj, i & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgxy) {
            return ((zzgxy) obj).zzcf();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzhaz.zzd(obj, (long) (zzr(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzhaz.zzh(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zzhbh zzhbhVar) {
        if (obj instanceof String) {
            zzhbhVar.zzG(i, (String) obj);
        } else {
            zzhbhVar.zzd(i, (zzgwm) obj);
        }
    }

    public static zzhat zzd(Object obj) {
        zzgxy zzgxyVar = (zzgxy) obj;
        zzhat zzhatVar = zzgxyVar.zzt;
        if (zzhatVar != zzhat.zzc()) {
            return zzhatVar;
        }
        zzhat zzhatVarZzf = zzhat.zzf();
        zzgxyVar.zzt = zzhatVarZzf;
        return zzhatVarZzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzgzm zzm(java.lang.Class r32, com.google.android.gms.internal.ads.zzgzg r33, com.google.android.gms.internal.ads.zzgzp r34, com.google.android.gms.internal.ads.zzgyw r35, com.google.android.gms.internal.ads.zzhas r36, com.google.android.gms.internal.ads.zzgxj r37, com.google.android.gms.internal.ads.zzgze r38) {
        /*
            Method dump skipped, instruction units count: 1054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzm.zzm(java.lang.Class, com.google.android.gms.internal.ads.zzgzg, com.google.android.gms.internal.ads.zzgzp, com.google.android.gms.internal.ads.zzgyw, com.google.android.gms.internal.ads.zzhas, com.google.android.gms.internal.ads.zzgxj, com.google.android.gms.internal.ads.zzgze):com.google.android.gms.internal.ads.zzgzm");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzhaz.zzh(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzhaz.zzh(obj, j)).floatValue();
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzhaz.zzh(obj, j)).intValue();
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzs(i, 0);
    }

    private final int zzr(int i) {
        return this.zzc[i + 2];
    }

    private final int zzs(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzt(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzu(int i) {
        return this.zzc[i + 1];
    }

    private static long zzv(Object obj, long j) {
        return ((Long) zzhaz.zzh(obj, j)).longValue();
    }

    private final zzgye zzw(int i) {
        int i2 = i / 3;
        return (zzgye) this.zzd[i2 + i2 + 1];
    }

    private final zzhae zzx(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzhae zzhaeVar = (zzhae) objArr[i3];
        if (zzhaeVar != null) {
            return zzhaeVar;
        }
        zzhae zzhaeVarZzb = zzgzt.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzhaeVarZzb;
        return zzhaeVarZzb;
    }

    private final Object zzy(Object obj, int i, Object obj2, zzhas zzhasVar, Object obj3) {
        int i2 = this.zzc[i];
        Object objZzh = zzhaz.zzh(obj, zzu(i) & 1048575);
        if (objZzh == null || zzw(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0213  */
    @Override // com.google.android.gms.internal.ads.zzhae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 2082
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzm.zza(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int i2;
        int iFloatToIntBits;
        int i3;
        int iZzd;
        int i4;
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzc.length; i6 += 3) {
            int iZzu = zzu(i6);
            int[] iArr = this.zzc;
            int i7 = 1048575 & iZzu;
            int iZzt = zzt(iZzu);
            int i8 = iArr[i6];
            long j = i7;
            int iHashCode = 37;
            switch (iZzt) {
                case 0:
                    i = i5 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzhaz.zzb(obj, j));
                    byte[] bArr = zzgyl.zzb;
                    i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 1:
                    i2 = i5 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzhaz.zzc(obj, j));
                    i5 = iFloatToIntBits + i2;
                    break;
                case 2:
                    i = i5 * 53;
                    jDoubleToLongBits = zzhaz.zzf(obj, j);
                    byte[] bArr2 = zzgyl.zzb;
                    i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 3:
                    i = i5 * 53;
                    jDoubleToLongBits = zzhaz.zzf(obj, j);
                    byte[] bArr3 = zzgyl.zzb;
                    i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 4:
                    i3 = i5 * 53;
                    iZzd = zzhaz.zzd(obj, j);
                    i5 = i3 + iZzd;
                    break;
                case 5:
                    i = i5 * 53;
                    jDoubleToLongBits = zzhaz.zzf(obj, j);
                    byte[] bArr4 = zzgyl.zzb;
                    i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 6:
                    i3 = i5 * 53;
                    iZzd = zzhaz.zzd(obj, j);
                    i5 = i3 + iZzd;
                    break;
                case 7:
                    i2 = i5 * 53;
                    iFloatToIntBits = zzgyl.zza(zzhaz.zzz(obj, j));
                    i5 = iFloatToIntBits + i2;
                    break;
                case 8:
                    i2 = i5 * 53;
                    iFloatToIntBits = ((String) zzhaz.zzh(obj, j)).hashCode();
                    i5 = iFloatToIntBits + i2;
                    break;
                case 9:
                    i4 = i5 * 53;
                    Object objZzh = zzhaz.zzh(obj, j);
                    if (objZzh != null) {
                        iHashCode = objZzh.hashCode();
                    }
                    i5 = i4 + iHashCode;
                    break;
                case 10:
                    i2 = i5 * 53;
                    iFloatToIntBits = zzhaz.zzh(obj, j).hashCode();
                    i5 = iFloatToIntBits + i2;
                    break;
                case 11:
                    i3 = i5 * 53;
                    iZzd = zzhaz.zzd(obj, j);
                    i5 = i3 + iZzd;
                    break;
                case 12:
                    i3 = i5 * 53;
                    iZzd = zzhaz.zzd(obj, j);
                    i5 = i3 + iZzd;
                    break;
                case 13:
                    i3 = i5 * 53;
                    iZzd = zzhaz.zzd(obj, j);
                    i5 = i3 + iZzd;
                    break;
                case 14:
                    i = i5 * 53;
                    jDoubleToLongBits = zzhaz.zzf(obj, j);
                    byte[] bArr5 = zzgyl.zzb;
                    i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 15:
                    i3 = i5 * 53;
                    iZzd = zzhaz.zzd(obj, j);
                    i5 = i3 + iZzd;
                    break;
                case 16:
                    i = i5 * 53;
                    jDoubleToLongBits = zzhaz.zzf(obj, j);
                    byte[] bArr6 = zzgyl.zzb;
                    i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 17:
                    i4 = i5 * 53;
                    Object objZzh2 = zzhaz.zzh(obj, j);
                    if (objZzh2 != null) {
                        iHashCode = objZzh2.hashCode();
                    }
                    i5 = i4 + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case zzbbc.zzt.zzm /* 21 */:
                case 22:
                case 23:
                case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i5 * 53;
                    iFloatToIntBits = zzhaz.zzh(obj, j).hashCode();
                    i5 = iFloatToIntBits + i2;
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    i2 = i5 * 53;
                    iFloatToIntBits = zzhaz.zzh(obj, j).hashCode();
                    i5 = iFloatToIntBits + i2;
                    break;
                case 51:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzn(obj, j));
                        byte[] bArr7 = zzgyl.zzb;
                        i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 52:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzo(obj, j));
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 53:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr8 = zzgyl.zzb;
                        i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 54:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr9 = zzgyl.zzb;
                        i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 55:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        iZzd = zzp(obj, j);
                        i5 = i3 + iZzd;
                    }
                    break;
                case 56:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr10 = zzgyl.zzb;
                        i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 57:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        iZzd = zzp(obj, j);
                        i5 = i3 + iZzd;
                    }
                    break;
                case 58:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = zzgyl.zza(zzS(obj, j));
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 59:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = ((String) zzhaz.zzh(obj, j)).hashCode();
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 60:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = zzhaz.zzh(obj, j).hashCode();
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 61:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = zzhaz.zzh(obj, j).hashCode();
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 62:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        iZzd = zzp(obj, j);
                        i5 = i3 + iZzd;
                    }
                    break;
                case 63:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        iZzd = zzp(obj, j);
                        i5 = i3 + iZzd;
                    }
                    break;
                case 64:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        iZzd = zzp(obj, j);
                        i5 = i3 + iZzd;
                    }
                    break;
                case 65:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr11 = zzgyl.zzb;
                        i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 66:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        iZzd = zzp(obj, j);
                        i5 = i3 + iZzd;
                    }
                    break;
                case 67:
                    if (zzR(obj, i8, i6)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr12 = zzgyl.zzb;
                        i5 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 68:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = zzhaz.zzh(obj, j).hashCode();
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
            }
        }
        int iHashCode2 = ((zzgxy) obj).zzt.hashCode() + (i5 * 53);
        return this.zzh ? (iHashCode2 * 53) + ((zzgxu) obj).zza.zza.hashCode() : iHashCode2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:504:0x0cc1, code lost:
    
        if (r14 == 1048575) goto L506;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:0x0cc3, code lost:
    
        r21.putInt(r8, r14, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:506:0x0cc9, code lost:
    
        r11 = r0.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:508:0x0cce, code lost:
    
        if (r11 >= r0.zzl) goto L610;
     */
    /* JADX WARN: Code restructure failed: missing block: B:509:0x0cd0, code lost:
    
        r0.zzy(r8, r0.zzj[r11], null, r0.zzm, r33);
        r11 = r11 + 1;
        r0 = r32;
        r8 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:510:0x0ce6, code lost:
    
        if (r10 != 0) goto L515;
     */
    /* JADX WARN: Code restructure failed: missing block: B:511:0x0ce8, code lost:
    
        if (r7 != r6) goto L513;
     */
    /* JADX WARN: Code restructure failed: missing block: B:514:0x0cef, code lost:
    
        throw com.google.android.gms.internal.ads.zzgyn.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:515:0x0cf0, code lost:
    
        if (r7 > r6) goto L518;
     */
    /* JADX WARN: Code restructure failed: missing block: B:516:0x0cf2, code lost:
    
        if (r9 != r10) goto L518;
     */
    /* JADX WARN: Code restructure failed: missing block: B:517:0x0cf4, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:519:0x0cf9, code lost:
    
        throw com.google.android.gms.internal.ads.zzgyn.zzg();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0c90  */
    /* JADX WARN: Removed duplicated region for block: B:557:0x097b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:560:0x0c3c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:594:0x098c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:600:0x0c4e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzc(java.lang.Object r33, byte[] r34, int r35, int r36, int r37, com.google.android.gms.internal.ads.zzgwa r38) {
        /*
            Method dump skipped, instruction units count: 3466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzm.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzgwa):int");
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final Object zze() {
        return ((zzgxy) this.zzg).zzbj();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    @Override // com.google.android.gms.internal.ads.zzhae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzf(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzm.zzf(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzu = zzu(i);
            int i2 = 1048575 & iZzu;
            int[] iArr = this.zzc;
            int iZzt = zzt(iZzu);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzt) {
                case 0:
                    if (zzN(obj2, i)) {
                        zzhaz.zzr(obj, j, zzhaz.zzb(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 1:
                    if (zzN(obj2, i)) {
                        zzhaz.zzs(obj, j, zzhaz.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 2:
                    if (zzN(obj2, i)) {
                        zzhaz.zzu(obj, j, zzhaz.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 3:
                    if (zzN(obj2, i)) {
                        zzhaz.zzu(obj, j, zzhaz.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 4:
                    if (zzN(obj2, i)) {
                        zzhaz.zzt(obj, j, zzhaz.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 5:
                    if (zzN(obj2, i)) {
                        zzhaz.zzu(obj, j, zzhaz.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 6:
                    if (zzN(obj2, i)) {
                        zzhaz.zzt(obj, j, zzhaz.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 7:
                    if (zzN(obj2, i)) {
                        zzhaz.zzp(obj, j, zzhaz.zzz(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 8:
                    if (zzN(obj2, i)) {
                        zzhaz.zzv(obj, j, zzhaz.zzh(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 9:
                    zzE(obj, obj2, i);
                    break;
                case 10:
                    if (zzN(obj2, i)) {
                        zzhaz.zzv(obj, j, zzhaz.zzh(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 11:
                    if (zzN(obj2, i)) {
                        zzhaz.zzt(obj, j, zzhaz.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 12:
                    if (zzN(obj2, i)) {
                        zzhaz.zzt(obj, j, zzhaz.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 13:
                    if (zzN(obj2, i)) {
                        zzhaz.zzt(obj, j, zzhaz.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 14:
                    if (zzN(obj2, i)) {
                        zzhaz.zzu(obj, j, zzhaz.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 15:
                    if (zzN(obj2, i)) {
                        zzhaz.zzt(obj, j, zzhaz.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 16:
                    if (zzN(obj2, i)) {
                        zzhaz.zzu(obj, j, zzhaz.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 17:
                    zzE(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case zzbbc.zzt.zzm /* 21 */:
                case 22:
                case 23:
                case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzgyk zzgykVarZzf = (zzgyk) zzhaz.zzh(obj, j);
                    zzgyk zzgykVar = (zzgyk) zzhaz.zzh(obj2, j);
                    int size = zzgykVarZzf.size();
                    int size2 = zzgykVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzgykVarZzf.zzc()) {
                            zzgykVarZzf = zzgykVarZzf.zzf(size2 + size);
                        }
                        zzgykVarZzf.addAll(zzgykVar);
                    }
                    if (size > 0) {
                        zzgykVar = zzgykVarZzf;
                    }
                    zzhaz.zzv(obj, j, zzgykVar);
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    int i4 = zzhag.zza;
                    zzhaz.zzv(obj, j, zzgze.zzb(zzhaz.zzh(obj, j), zzhaz.zzh(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzR(obj2, i3, i)) {
                        zzhaz.zzv(obj, j, zzhaz.zzh(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case 60:
                    zzF(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzR(obj2, i3, i)) {
                        zzhaz.zzv(obj, j, zzhaz.zzh(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case 68:
                    zzF(obj, obj2, i);
                    break;
            }
        }
        zzhag.zzq(this.zzm, obj, obj2);
        if (this.zzh) {
            zzhag.zzp(this.zzn, obj, obj2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
    
        r2 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0618 A[LOOP:3: B:203:0x0614->B:205:0x0618, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0627  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x05e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x05ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:320:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:321:? A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh(java.lang.Object r11, com.google.android.gms.internal.ads.zzgzw r12, com.google.android.gms.internal.ads.zzgxi r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzm.zzh(java.lang.Object, com.google.android.gms.internal.ads.zzgzw, com.google.android.gms.internal.ads.zzgxi):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgwa zzgwaVar) {
        zzc(obj, bArr, i, i2, 0, zzgwaVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.ads.zzhae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzj(java.lang.Object r21, com.google.android.gms.internal.ads.zzhbh r22) {
        /*
            Method dump skipped, instruction units count: 1438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzm.zzj(java.lang.Object, com.google.android.gms.internal.ads.zzhbh):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final boolean zzk(Object obj, Object obj2) {
        boolean zZzJ;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzu = zzu(i);
            long j = iZzu & 1048575;
            switch (zzt(iZzu)) {
                case 0:
                    if (!zzL(obj, obj2, i) || Double.doubleToLongBits(zzhaz.zzb(obj, j)) != Double.doubleToLongBits(zzhaz.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i) || Float.floatToIntBits(zzhaz.zzc(obj, j)) != Float.floatToIntBits(zzhaz.zzc(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i) || zzhaz.zzf(obj, j) != zzhaz.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i) || zzhaz.zzf(obj, j) != zzhaz.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i) || zzhaz.zzd(obj, j) != zzhaz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i) || zzhaz.zzf(obj, j) != zzhaz.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i) || zzhaz.zzd(obj, j) != zzhaz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i) || zzhaz.zzz(obj, j) != zzhaz.zzz(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i) || !zzhag.zzJ(zzhaz.zzh(obj, j), zzhaz.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i) || !zzhag.zzJ(zzhaz.zzh(obj, j), zzhaz.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i) || !zzhag.zzJ(zzhaz.zzh(obj, j), zzhaz.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i) || zzhaz.zzd(obj, j) != zzhaz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i) || zzhaz.zzd(obj, j) != zzhaz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i) || zzhaz.zzd(obj, j) != zzhaz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i) || zzhaz.zzf(obj, j) != zzhaz.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i) || zzhaz.zzd(obj, j) != zzhaz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i) || zzhaz.zzf(obj, j) != zzhaz.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i) || !zzhag.zzJ(zzhaz.zzh(obj, j), zzhaz.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case zzbbc.zzt.zzm /* 21 */:
                case 22:
                case 23:
                case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzJ = zzhag.zzJ(zzhaz.zzh(obj, j), zzhaz.zzh(obj2, j));
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    zZzJ = zzhag.zzJ(zzhaz.zzh(obj, j), zzhaz.zzh(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzr = zzr(i) & 1048575;
                    if (zzhaz.zzd(obj, jZzr) != zzhaz.zzd(obj2, jZzr) || !zzhag.zzJ(zzhaz.zzh(obj, j), zzhaz.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zZzJ) {
                return false;
            }
        }
        if (!((zzgxy) obj).zzt.equals(((zzgxy) obj2).zzt)) {
            return false;
        }
        if (this.zzh) {
            return ((zzgxu) obj).zza.equals(((zzgxu) obj2).zza);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008f  */
    @Override // com.google.android.gms.internal.ads.zzhae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzl(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzm.zzl(java.lang.Object):boolean");
    }
}
