package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class zzgky {
    private static final Logger zza = Logger.getLogger(zzgky.class.getName());
    private static final zzgky zzb = new zzgky();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    public static zzgky zzc() {
        return zzb;
    }

    private final synchronized zzgdz zzg(String str) {
        if (!this.zzc.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzgdz) this.zzc.get(str);
    }

    private final synchronized void zzh(zzgdz zzgdzVar, boolean z, boolean z2) {
        try {
            String str = ((zzglh) zzgdzVar).zza;
            if (this.zzd.containsKey(str) && !((Boolean) this.zzd.get(str)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
            }
            zzgdz zzgdzVar2 = (zzgdz) this.zzc.get(str);
            if (zzgdzVar2 != null && !zzgdzVar2.getClass().equals(zzgdzVar.getClass())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type ".concat(str));
                throw new GeneralSecurityException("typeUrl (" + str + ") is already registered with " + zzgdzVar2.getClass().getName() + ", cannot be re-registered with " + zzgdzVar.getClass().getName());
            }
            this.zzc.putIfAbsent(str, zzgdzVar);
            this.zzd.put(str, Boolean.TRUE);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final zzgdz zza(String str, Class cls) throws GeneralSecurityException {
        zzgdz zzgdzVarZzg = zzg(str);
        if (zzgdzVarZzg.zzb().equals(cls)) {
            return zzgdzVarZzg;
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + String.valueOf(zzgdzVarZzg.getClass()) + ", which only supports: " + zzgdzVarZzg.zzb().toString());
    }

    public final zzgdz zzb(String str) {
        return zzg(str);
    }

    public final synchronized void zzd(zzgdz zzgdzVar, boolean z) {
        zzf(zzgdzVar, 1, true);
    }

    public final boolean zze(String str) {
        return ((Boolean) this.zzd.get(str)).booleanValue();
    }

    public final synchronized void zzf(zzgdz zzgdzVar, int i, boolean z) {
        if (!zzgkr.zza(i)) {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
        zzh(zzgdzVar, false, true);
    }
}
