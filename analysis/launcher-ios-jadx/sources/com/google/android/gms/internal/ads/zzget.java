package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzget {
    public static zzgen zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzgsz zzgszVarZzf = zzgsz.zzf(bArr, zzgxi.zza());
            zzgmk zzgmkVarZzc = zzgmk.zzc();
            zzgnm zzgnmVarZza = zzgnm.zza(zzgszVarZzf);
            return !zzgmkVarZzc.zzk(zzgnmVarZza) ? new zzglk(zzgnmVarZza) : zzgmkVarZzc.zzb(zzgnmVarZza);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }

    public static byte[] zzb(zzgen zzgenVar) {
        return ((zzgnm) zzgmk.zzc().zze(zzgenVar, zzgnm.class)).zzc().zzaV();
    }
}
