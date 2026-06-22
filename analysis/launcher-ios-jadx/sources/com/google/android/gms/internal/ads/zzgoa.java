package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgoa {
    static {
        Charset.forName("UTF-8");
    }

    public static final zzgvr zza(String str) throws GeneralSecurityException {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '!' || cCharAt > '~') {
                throw new GeneralSecurityException("Not a printable ASCII character: " + cCharAt);
            }
            bArr[i] = (byte) cCharAt;
        }
        return zzgvr.zzb(bArr);
    }

    public static final zzgvr zzb(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '!' || cCharAt > '~') {
                throw new zzgnz("Not a printable ASCII character: " + cCharAt);
            }
            bArr[i] = (byte) cCharAt;
        }
        return zzgvr.zzb(bArr);
    }

    public static boolean zzc(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr2[i] != bArr[i]) {
                return false;
            }
        }
        return true;
    }
}
