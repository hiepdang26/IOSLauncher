package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzhag {
    public static final /* synthetic */ int zza = 0;
    private static final zzhas zzb;

    static {
        int i = zzgzt.zza;
        zzb = new zzhau();
    }

    public static void zzA(int i, List list, zzhbh zzhbhVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzu(i, list, z);
    }

    public static void zzB(int i, List list, zzhbh zzhbhVar, zzhae zzhaeVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzgxe) zzhbhVar).zzv(i, list.get(i2), zzhaeVar);
        }
    }

    public static void zzC(int i, List list, zzhbh zzhbhVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzy(i, list, z);
    }

    public static void zzD(int i, List list, zzhbh zzhbhVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzA(i, list, z);
    }

    public static void zzE(int i, List list, zzhbh zzhbhVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzC(i, list, z);
    }

    public static void zzF(int i, List list, zzhbh zzhbhVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzE(i, list, z);
    }

    public static void zzG(int i, List list, zzhbh zzhbhVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzH(i, list);
    }

    public static void zzH(int i, List list, zzhbh zzhbhVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzJ(i, list, z);
    }

    public static void zzI(int i, List list, zzhbh zzhbhVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzL(i, list, z);
    }

    public static boolean zzJ(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int zza(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgxz)) {
            int iZzE = 0;
            while (i < size) {
                iZzE += zzgxd.zzE(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzE;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        int iZzE2 = 0;
        while (i < size) {
            iZzE2 += zzgxd.zzE(zzgxzVar.zzd(i));
            i++;
        }
        return iZzE2;
    }

    public static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgxd.zzD(i << 3) + 4) * size;
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzgxd.zzD(i << 3) + 8) * size;
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgxz)) {
            int iZzE = 0;
            while (i < size) {
                iZzE += zzgxd.zzE(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzE;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        int iZzE2 = 0;
        while (i < size) {
            iZzE2 += zzgxd.zzE(zzgxzVar.zzd(i));
            i++;
        }
        return iZzE2;
    }

    public static int zzg(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgyy)) {
            int iZzE = 0;
            while (i < size) {
                iZzE += zzgxd.zzE(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzE;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        int iZzE2 = 0;
        while (i < size) {
            iZzE2 += zzgxd.zzE(zzgyyVar.zza(i));
            i++;
        }
        return iZzE2;
    }

    public static int zzh(int i, Object obj, zzhae zzhaeVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzgyu)) {
            return zzgxd.zzA((zzgzj) obj, zzhaeVar) + zzgxd.zzD(i2);
        }
        int iZzD = zzgxd.zzD(i2);
        int iZza = ((zzgyu) obj).zza();
        return k31.h(iZza, iZza, iZzD);
    }

    public static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgxz)) {
            int iZzD = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzD += zzgxd.zzD((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZzD;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        int iZzD2 = 0;
        while (i < size) {
            int iZzd = zzgxzVar.zzd(i);
            iZzD2 += zzgxd.zzD((iZzd >> 31) ^ (iZzd + iZzd));
            i++;
        }
        return iZzD2;
    }

    public static int zzj(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgyy)) {
            int iZzE = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzE += zzgxd.zzE((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iZzE;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        int iZzE2 = 0;
        while (i < size) {
            long jZza = zzgyyVar.zza(i);
            iZzE2 += zzgxd.zzE((jZza >> 63) ^ (jZza + jZza));
            i++;
        }
        return iZzE2;
    }

    public static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgxz)) {
            int iZzD = 0;
            while (i < size) {
                iZzD += zzgxd.zzD(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzD;
        }
        zzgxz zzgxzVar = (zzgxz) list;
        int iZzD2 = 0;
        while (i < size) {
            iZzD2 += zzgxd.zzD(zzgxzVar.zzd(i));
            i++;
        }
        return iZzD2;
    }

    public static int zzl(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgyy)) {
            int iZzE = 0;
            while (i < size) {
                iZzE += zzgxd.zzE(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzE;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        int iZzE2 = 0;
        while (i < size) {
            iZzE2 += zzgxd.zzE(zzgyyVar.zza(i));
            i++;
        }
        return iZzE2;
    }

    public static zzhas zzm() {
        return zzb;
    }

    public static Object zzn(Object obj, int i, List list, zzgye zzgyeVar, Object obj2, zzhas zzhasVar) {
        if (zzgyeVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zzgyeVar.zza(iIntValue)) {
                    obj2 = zzo(obj, i, iIntValue, obj2, zzhasVar);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Integer num = (Integer) list.get(i3);
            int iIntValue2 = num.intValue();
            if (zzgyeVar.zza(iIntValue2)) {
                if (i3 != i2) {
                    list.set(i2, num);
                }
                i2++;
            } else {
                obj2 = zzo(obj, i, iIntValue2, obj2, zzhasVar);
            }
        }
        if (i2 != size) {
            list.subList(i2, size).clear();
        }
        return obj2;
    }

    public static Object zzo(Object obj, int i, int i2, Object obj2, zzhas zzhasVar) {
        if (obj2 == null) {
            obj2 = zzhasVar.zza(obj);
        }
        zzhasVar.zzh(obj2, i, i2);
        return obj2;
    }

    public static void zzp(zzgxj zzgxjVar, Object obj, Object obj2) {
        if (((zzgxu) obj2).zza.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    public static void zzq(zzhas zzhasVar, Object obj, Object obj2) {
        zzgxy zzgxyVar = (zzgxy) obj;
        zzhat zzhatVarZze = zzgxyVar.zzt;
        zzhat zzhatVar = ((zzgxy) obj2).zzt;
        if (!zzhat.zzc().equals(zzhatVar)) {
            if (zzhat.zzc().equals(zzhatVarZze)) {
                zzhatVarZze = zzhat.zze(zzhatVarZze, zzhatVar);
            } else {
                zzhatVarZze.zzd(zzhatVar);
            }
        }
        zzgxyVar.zzt = zzhatVarZze;
    }

    public static void zzr(int i, List list, zzhbh zzhbhVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzc(i, list, z);
    }

    public static void zzs(int i, List list, zzhbh zzhbhVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zze(i, list);
    }

    public static void zzt(int i, List list, zzhbh zzhbhVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzg(i, list, z);
    }

    public static void zzu(int i, List list, zzhbh zzhbhVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzj(i, list, z);
    }

    public static void zzv(int i, List list, zzhbh zzhbhVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzl(i, list, z);
    }

    public static void zzw(int i, List list, zzhbh zzhbhVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzn(i, list, z);
    }

    public static void zzx(int i, List list, zzhbh zzhbhVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzp(i, list, z);
    }

    public static void zzy(int i, List list, zzhbh zzhbhVar, zzhae zzhaeVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzgxe) zzhbhVar).zzq(i, list.get(i2), zzhaeVar);
        }
    }

    public static void zzz(int i, List list, zzhbh zzhbhVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzs(i, list, z);
    }
}
