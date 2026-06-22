package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
final class zzgjr extends ThreadLocal {
    public static final Cipher zza() {
        try {
            Cipher cipher = (Cipher) zzguz.zza.zza("ChaCha20-Poly1305");
            if (zzgjs.zzf(cipher)) {
                return cipher;
            }
            return null;
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    @Override // java.lang.ThreadLocal
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
