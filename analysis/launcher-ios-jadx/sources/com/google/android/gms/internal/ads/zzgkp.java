package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
final class zzgkp extends ThreadLocal {
    public static final Cipher zza() {
        try {
            Cipher cipher = (Cipher) zzguz.zza.zza("AES/GCM-SIV/NoPadding");
            if (zzgkq.zze(cipher)) {
                return cipher;
            }
            return null;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // java.lang.ThreadLocal
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
