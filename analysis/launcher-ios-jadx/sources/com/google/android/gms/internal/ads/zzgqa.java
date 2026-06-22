package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgqa implements zzgoo {
    public zzgqa(zzgoe zzgoeVar) throws GeneralSecurityException {
        if (!zzgkr.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
    }
}
