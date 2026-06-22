package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgae {
    static {
        Math.log(2.0d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long zza(double r9, java.math.RoundingMode r11) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgae.zza(double, java.math.RoundingMode):long");
    }

    public static boolean zzb(double d) {
        if (!zzgaf.zza(d)) {
            return false;
        }
        if (d != 0.0d) {
            zzfuu.zzf(zzgaf.zza(d), "not a normal value");
            int exponent = Math.getExponent(d);
            long jDoubleToRawLongBits = Double.doubleToRawLongBits(d) & 4503599627370495L;
            if (52 - Long.numberOfTrailingZeros(exponent == -1023 ? jDoubleToRawLongBits + jDoubleToRawLongBits : jDoubleToRawLongBits | 4503599627370496L) > Math.getExponent(d)) {
                return false;
            }
        }
        return true;
    }
}
