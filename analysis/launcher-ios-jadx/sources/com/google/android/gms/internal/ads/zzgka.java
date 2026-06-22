package com.google.android.gms.internal.ads;

import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
public final class zzgka {
    public static final /* synthetic */ int zza = 0;
    private static final ThreadLocal zzb = new zzgjz();

    public static Cipher zza() {
        return (Cipher) zzb.get();
    }
}
