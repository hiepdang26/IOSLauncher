package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class zzali {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzek zzc = new zzek();
    private final StringBuilder zzd = new StringBuilder();

    public static String zza(zzek zzekVar, StringBuilder sb) {
        zzc(zzekVar);
        if (zzekVar.zzb() == 0) {
            return null;
        }
        String strZzd = zzd(zzekVar, sb);
        if (!"".equals(strZzd)) {
            return strZzd;
        }
        char cZzm = (char) zzekVar.zzm();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cZzm);
        return sb2.toString();
    }

    public static void zzc(zzek zzekVar) {
        while (true) {
            for (boolean z = true; zzekVar.zzb() > 0 && z; z = false) {
                char c = (char) zzekVar.zzM()[zzekVar.zzd()];
                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                    zzekVar.zzL(1);
                } else {
                    int iZzd = zzekVar.zzd();
                    int iZze = zzekVar.zze();
                    byte[] bArrZzM = zzekVar.zzM();
                    if (iZzd + 2 <= iZze) {
                        int i = iZzd + 1;
                        if (bArrZzM[iZzd] == 47) {
                            int i2 = iZzd + 2;
                            if (bArrZzM[i] == 42) {
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (i3 >= iZze) {
                                        break;
                                    }
                                    if (((char) bArrZzM[i2]) == '*' && ((char) bArrZzM[i3]) == '/') {
                                        iZze = i2 + 2;
                                        i2 = iZze;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                zzekVar.zzL(iZze - zzekVar.zzd());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    private static String zzd(zzek zzekVar, StringBuilder sb) {
        boolean z;
        char c;
        sb.setLength(0);
        int iZzd = zzekVar.zzd();
        int iZze = zzekVar.zze();
        loop0: while (true) {
            while (iZzd < iZze && !z) {
                c = (char) zzekVar.zzM()[iZzd];
                z = (c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_');
            }
            sb.append(c);
            iZzd++;
        }
        zzekVar.zzL(iZzd - zzekVar.zzd());
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:169:0x0315, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List zzb(com.google.android.gms.internal.ads.zzek r18) {
        /*
            Method dump skipped, instruction units count: 790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzali.zzb(com.google.android.gms.internal.ads.zzek):java.util.List");
    }
}
