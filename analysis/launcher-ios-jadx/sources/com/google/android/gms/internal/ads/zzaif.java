package com.google.android.gms.internal.ads;

import android.util.Pair;
import defpackage.k31;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class zzaif {
    private static final byte[] zza;

    static {
        int i = zzet.zza;
        zza = "OpusHead".getBytes(zzfuj.zzc);
    }

    public static zzbk zza(zzahv zzahvVar) {
        zzex zzexVar;
        zzahw zzahwVarZzb = zzahvVar.zzb(1751411826);
        zzahw zzahwVarZzb2 = zzahvVar.zzb(1801812339);
        zzahw zzahwVarZzb3 = zzahvVar.zzb(1768715124);
        if (zzahwVarZzb != null && zzahwVarZzb2 != null && zzahwVarZzb3 != null && zzg(zzahwVarZzb.zza) == 1835299937) {
            zzek zzekVar = zzahwVarZzb2.zza;
            zzekVar.zzK(12);
            int iZzg = zzekVar.zzg();
            String[] strArr = new String[iZzg];
            for (int i = 0; i < iZzg; i++) {
                int iZzg2 = zzekVar.zzg();
                zzekVar.zzL(4);
                strArr[i] = zzekVar.zzA(iZzg2 - 8, zzfuj.zzc);
            }
            zzek zzekVar2 = zzahwVarZzb3.zza;
            zzekVar2.zzK(8);
            ArrayList arrayList = new ArrayList();
            while (zzekVar2.zzb() > 8) {
                int iZzg3 = zzekVar2.zzg() + zzekVar2.zzd();
                int iZzg4 = zzekVar2.zzg() - 1;
                if (iZzg4 < 0 || iZzg4 >= iZzg) {
                    k31.n(iZzg4, "Skipped metadata with unknown key index: ", "AtomParsers");
                } else {
                    String str = strArr[iZzg4];
                    while (true) {
                        int iZzd = zzekVar2.zzd();
                        if (iZzd >= iZzg3) {
                            zzexVar = null;
                            break;
                        }
                        int iZzg5 = zzekVar2.zzg();
                        if (zzekVar2.zzg() == 1684108385) {
                            int iZzg6 = zzekVar2.zzg();
                            int iZzg7 = zzekVar2.zzg();
                            int i2 = iZzg5 - 16;
                            byte[] bArr = new byte[i2];
                            zzekVar2.zzG(bArr, 0, i2);
                            zzexVar = new zzex(str, bArr, iZzg7, iZzg6);
                            break;
                        }
                        zzekVar2.zzK(iZzd + iZzg5);
                    }
                    if (zzexVar != null) {
                        arrayList.add(zzexVar);
                    }
                }
                zzekVar2.zzK(iZzg3);
            }
            if (!arrayList.isEmpty()) {
                return new zzbk(arrayList);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzbk zzb(com.google.android.gms.internal.ads.zzahw r14) {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaif.zzb(com.google.android.gms.internal.ads.zzahw):com.google.android.gms.internal.ads.zzbk");
    }

    public static zzfd zzc(zzek zzekVar) {
        long jZzt;
        long jZzt2;
        zzekVar.zzK(8);
        if (zzahx.zze(zzekVar.zzg()) == 0) {
            jZzt = zzekVar.zzu();
            jZzt2 = zzekVar.zzu();
        } else {
            jZzt = zzekVar.zzt();
            jZzt2 = zzekVar.zzt();
        }
        return new zzfd(jZzt, jZzt2, zzekVar.zzu());
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e0, code lost:
    
        r6 = -9223372036854775807L;
     */
    /* JADX WARN: Removed duplicated region for block: B:315:0x065b  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0758  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0765  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x076b  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x076e  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0776  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x077f  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x07b1  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x07b3  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x09c8  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x09ca  */
    /* JADX WARN: Removed duplicated region for block: B:526:0x0b3f  */
    /* JADX WARN: Removed duplicated region for block: B:527:0x0b43  */
    /* JADX WARN: Removed duplicated region for block: B:530:0x0b76  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x0ba0  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x0bab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List zzd(com.google.android.gms.internal.ads.zzahv r61, com.google.android.gms.internal.ads.zzacy r62, long r63, com.google.android.gms.internal.ads.zzy r65, boolean r66, boolean r67, com.google.android.gms.internal.ads.zzful r68) {
        /*
            Method dump skipped, instruction units count: 2997
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaif.zzd(com.google.android.gms.internal.ads.zzahv, com.google.android.gms.internal.ads.zzacy, long, com.google.android.gms.internal.ads.zzy, boolean, boolean, com.google.android.gms.internal.ads.zzful):java.util.List");
    }

    public static void zze(zzek zzekVar) {
        int iZzd = zzekVar.zzd();
        zzekVar.zzL(4);
        if (zzekVar.zzg() != 1751411826) {
            iZzd += 4;
        }
        zzekVar.zzK(iZzd);
    }

    private static int zzf(zzek zzekVar) {
        int iZzm = zzekVar.zzm();
        int i = iZzm & 127;
        while ((iZzm & 128) == 128) {
            iZzm = zzekVar.zzm();
            i = (i << 7) | (iZzm & 127);
        }
        return i;
    }

    private static int zzg(zzek zzekVar) {
        zzekVar.zzK(16);
        return zzekVar.zzg();
    }

    private static Pair zzh(zzek zzekVar, int i, int i2) throws zzbo {
        Integer num;
        zzaix zzaixVar;
        Pair pairCreate;
        int i3;
        int i4;
        Integer num2;
        boolean z;
        int iZzd = zzekVar.zzd();
        while (iZzd - i < i2) {
            zzekVar.zzK(iZzd);
            int iZzg = zzekVar.zzg();
            zzaco.zzb(iZzg > 0, "childAtomSize must be positive");
            if (zzekVar.zzg() == 1936289382) {
                int i5 = iZzd + 8;
                int i6 = -1;
                Integer numValueOf = null;
                String strZzA = null;
                int i7 = 0;
                while (i5 - iZzd < iZzg) {
                    zzekVar.zzK(i5);
                    int iZzg2 = zzekVar.zzg();
                    int iZzg3 = zzekVar.zzg();
                    if (iZzg3 == 1718775137) {
                        numValueOf = Integer.valueOf(zzekVar.zzg());
                    } else if (iZzg3 == 1935894637) {
                        zzekVar.zzL(4);
                        strZzA = zzekVar.zzA(4, zzfuj.zzc);
                    } else if (iZzg3 == 1935894633) {
                        i6 = i5;
                        i7 = iZzg2;
                    }
                    i5 += iZzg2;
                }
                byte[] bArr = null;
                if ("cenc".equals(strZzA) || "cbc1".equals(strZzA) || "cens".equals(strZzA) || "cbcs".equals(strZzA)) {
                    zzaco.zzb(numValueOf != null, "frma atom is mandatory");
                    zzaco.zzb(i6 != -1, "schi atom is mandatory");
                    int i8 = i6 + 8;
                    while (true) {
                        if (i8 - i6 >= i7) {
                            num = numValueOf;
                            zzaixVar = null;
                            break;
                        }
                        zzekVar.zzK(i8);
                        int iZzg4 = zzekVar.zzg();
                        if (zzekVar.zzg() == 1952804451) {
                            int iZze = zzahx.zze(zzekVar.zzg());
                            zzekVar.zzL(1);
                            if (iZze == 0) {
                                zzekVar.zzL(1);
                                i4 = 0;
                                i3 = 0;
                            } else {
                                int iZzm = zzekVar.zzm();
                                i3 = iZzm & 15;
                                i4 = (iZzm & 240) >> 4;
                            }
                            if (zzekVar.zzm() == 1) {
                                num2 = numValueOf;
                                z = true;
                            } else {
                                num2 = numValueOf;
                                z = false;
                            }
                            int iZzm2 = zzekVar.zzm();
                            byte[] bArr2 = new byte[16];
                            zzekVar.zzG(bArr2, 0, 16);
                            if (z && iZzm2 == 0) {
                                int iZzm3 = zzekVar.zzm();
                                byte[] bArr3 = new byte[iZzm3];
                                zzekVar.zzG(bArr3, 0, iZzm3);
                                bArr = bArr3;
                            }
                            num = num2;
                            zzaixVar = new zzaix(z, strZzA, iZzm2, bArr2, i4, i3, bArr);
                        } else {
                            i8 += iZzg4;
                        }
                    }
                    zzaco.zzb(zzaixVar != null, "tenc atom is mandatory");
                    int i9 = zzet.zza;
                    pairCreate = Pair.create(num, zzaixVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            iZzd += iZzg;
        }
        return null;
    }

    private static zzbk zzi(zzek zzekVar) {
        short sZzD = zzekVar.zzD();
        zzekVar.zzL(2);
        String strZzA = zzekVar.zzA(sZzD, zzfuj.zzc);
        int iMax = Math.max(strZzA.lastIndexOf(43), strZzA.lastIndexOf(45));
        try {
            return new zzbk(-9223372036854775807L, new zzfa(Float.parseFloat(strZzA.substring(0, iMax)), Float.parseFloat(strZzA.substring(iMax, strZzA.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static zzahz zzj(zzek zzekVar, int i) {
        zzekVar.zzK(i + 12);
        zzekVar.zzL(1);
        zzf(zzekVar);
        zzekVar.zzL(2);
        int iZzm = zzekVar.zzm();
        if ((iZzm & 128) != 0) {
            zzekVar.zzL(2);
        }
        if ((iZzm & 64) != 0) {
            zzekVar.zzL(zzekVar.zzm());
        }
        if ((iZzm & 32) != 0) {
            zzekVar.zzL(2);
        }
        zzekVar.zzL(1);
        zzf(zzekVar);
        String strZzd = zzbn.zzd(zzekVar.zzm());
        if ("audio/mpeg".equals(strZzd) || "audio/vnd.dts".equals(strZzd) || "audio/vnd.dts.hd".equals(strZzd)) {
            return new zzahz(strZzd, null, -1L, -1L);
        }
        zzekVar.zzL(4);
        long jZzu = zzekVar.zzu();
        long jZzu2 = zzekVar.zzu();
        zzekVar.zzL(1);
        int iZzf = zzf(zzekVar);
        long j = jZzu2;
        byte[] bArr = new byte[iZzf];
        zzekVar.zzG(bArr, 0, iZzf);
        if (j <= 0) {
            j = -1;
        }
        return new zzahz(strZzd, bArr, j, jZzu > 0 ? jZzu : -1L);
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0339  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.internal.ads.zzaiz zzk(com.google.android.gms.internal.ads.zzaiw r38, com.google.android.gms.internal.ads.zzahv r39, com.google.android.gms.internal.ads.zzacy r40) throws com.google.android.gms.internal.ads.zzbo {
        /*
            Method dump skipped, instruction units count: 1424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaif.zzk(com.google.android.gms.internal.ads.zzaiw, com.google.android.gms.internal.ads.zzahv, com.google.android.gms.internal.ads.zzacy):com.google.android.gms.internal.ads.zzaiz");
    }

    private static ByteBuffer zzl() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzm(com.google.android.gms.internal.ads.zzek r27, int r28, int r29, int r30, int r31, java.lang.String r32, boolean r33, com.google.android.gms.internal.ads.zzy r34, com.google.android.gms.internal.ads.zzaib r35, int r36) throws com.google.android.gms.internal.ads.zzbo {
        /*
            Method dump skipped, instruction units count: 1314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaif.zzm(com.google.android.gms.internal.ads.zzek, int, int, int, int, java.lang.String, boolean, com.google.android.gms.internal.ads.zzy, com.google.android.gms.internal.ads.zzaib, int):void");
    }
}
