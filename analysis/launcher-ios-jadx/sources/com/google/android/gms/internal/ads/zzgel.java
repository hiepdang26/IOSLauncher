package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzgel {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzgek zza(String str) throws GeneralSecurityException {
        for (zzgek zzgekVar : zza) {
            if (zzgekVar.zza()) {
                return zzgekVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
