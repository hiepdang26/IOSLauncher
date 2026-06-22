package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaiv {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static zzadm zza(zzacl zzaclVar) {
        return zzc(zzaclVar, true, false);
    }

    public static zzadm zzb(zzacl zzaclVar, boolean z) {
        return zzc(zzaclVar, false, z);
    }

    private static zzadm zzc(zzacl zzaclVar, boolean z, boolean z2) {
        zzadm zzadmVar;
        long j;
        long jZzt;
        int i;
        int[] iArr;
        long jZzd = zzaclVar.zzd();
        long j2 = 4096;
        long j3 = -1;
        int i2 = (jZzd > (-1L) ? 1 : (jZzd == (-1L) ? 0 : -1));
        if (i2 != 0 && jZzd <= 4096) {
            j2 = jZzd;
        }
        zzek zzekVar = new zzek(64);
        int i3 = (int) j2;
        boolean z3 = false;
        int i4 = 0;
        boolean z4 = false;
        while (i4 < i3) {
            zzekVar.zzH(8);
            boolean z5 = true;
            if (!zzaclVar.zzm(zzekVar.zzM(), 0, 8, true)) {
                break;
            }
            long jZzu = zzekVar.zzu();
            int iZzg = zzekVar.zzg();
            if (jZzu == 1) {
                j = j3;
                zzaclVar.zzh(zzekVar.zzM(), 8, 8);
                i = 16;
                zzekVar.zzJ(16);
                jZzt = zzekVar.zzt();
            } else {
                j = j3;
                if (jZzu == 0) {
                    long jZzd2 = zzaclVar.zzd();
                    if (jZzd2 != j) {
                        jZzu = (jZzd2 - zzaclVar.zze()) + 8;
                    }
                }
                jZzt = jZzu;
                i = 8;
            }
            zzadmVar = null;
            int i5 = i2;
            long j4 = i;
            if (jZzt < j4) {
                return new zzaig(iZzg, jZzt, i);
            }
            i4 += i;
            if (iZzg == 1836019574) {
                i3 += (int) jZzt;
                if (i5 != 0 && i3 > jZzd) {
                    i3 = (int) jZzd;
                }
                i2 = i5;
                j3 = j;
            } else {
                if (iZzg == 1836019558 || iZzg == 1836475768) {
                    z3 = true;
                    break;
                }
                z4 |= !(iZzg != 1835295092);
                long j5 = jZzd;
                if ((((long) i4) + jZzt) - j4 >= i3) {
                    break;
                }
                int i6 = (int) (jZzt - j4);
                i4 += i6;
                if (iZzg == 1718909296) {
                    if (i6 < 8) {
                        return new zzaig(1718909296, i6, 8);
                    }
                    zzekVar.zzH(i6);
                    zzaclVar.zzh(zzekVar.zzM(), 0, i6);
                    int iZzg2 = zzekVar.zzg();
                    boolean zZzd = zzd(iZzg2, z2) | z4;
                    zzekVar.zzL(4);
                    int iZzb = zzekVar.zzb() / 4;
                    if (!zZzd && iZzb > 0) {
                        iArr = new int[iZzb];
                        int i7 = 0;
                        while (true) {
                            if (i7 >= iZzb) {
                                z5 = zZzd;
                                break;
                            }
                            int iZzg3 = zzekVar.zzg();
                            iArr[i7] = iZzg3;
                            if (zzd(iZzg3, z2)) {
                                break;
                            }
                            i7++;
                        }
                    } else {
                        z5 = zZzd;
                        iArr = null;
                    }
                    if (!z5) {
                        return new zzaja(iZzg2, iArr);
                    }
                    z4 = z5;
                } else if (i6 != 0) {
                    zzaclVar.zzg(i6);
                }
                i2 = i5;
                j3 = j;
                jZzd = j5;
            }
        }
        zzadmVar = null;
        return !z4 ? zzair.zza : z != z3 ? z3 ? zzaim.zza : zzaim.zzb : zzadmVar;
    }

    private static boolean zzd(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579) {
            if (z) {
                return true;
            }
            i = 1751476579;
        }
        int[] iArr = zza;
        for (int i2 = 0; i2 < 29; i2++) {
            if (iArr[i2] == i) {
                return true;
            }
        }
        return false;
    }
}
