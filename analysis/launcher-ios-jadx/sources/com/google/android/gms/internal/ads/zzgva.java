package com.google.android.gms.internal.ads;

import java.security.Provider;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
public final class zzgva implements zzgvh {
    @Override // com.google.android.gms.internal.ads.zzgvh
    public final /* bridge */ /* synthetic */ Object zza(String str, Provider provider) {
        return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
    }
}
