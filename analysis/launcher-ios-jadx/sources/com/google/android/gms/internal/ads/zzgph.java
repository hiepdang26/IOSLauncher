package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgph {
    static {
        int i = zzguc.zza;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() {
        zzgpn.zzd();
        zzgor.zzd();
        zzgpa.zza(true);
        if (zzgks.zzb()) {
            return;
        }
        zzgoi.zzd(true);
    }
}
