package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgeb {
    public static final zzgen zza(zzgen zzgenVar) {
        return zzgenVar != null ? zzgenVar : zzget.zza(zzb(null).zzaV());
    }

    public static final zzgsz zzb(zzgen zzgenVar) {
        try {
            return ((zzgnm) zzgmk.zzc().zze(null, zzgnm.class)).zzc();
        } catch (GeneralSecurityException e) {
            throw new zzgnz("Parsing parameters failed in getProto(). You probably want to call some Tink register function for ".concat("null"), e);
        }
    }
}
