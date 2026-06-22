package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzgoi {
    private static final zzglz zza = new zzglz() { // from class: com.google.android.gms.internal.ads.zzgof
        @Override // com.google.android.gms.internal.ads.zzglz
        public final zzgdy zza(zzgen zzgenVar, Integer num) {
            return zzgoi.zzb((zzgon) zzgenVar, num);
        }
    };
    private static final zzgmx zzb = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgog
        @Override // com.google.android.gms.internal.ads.zzgmv
        public final Object zza(zzgdy zzgdyVar) {
            return zzgoi.zzc((zzgoe) zzgdyVar);
        }
    }, zzgoe.class, zzgoo.class);
    private static final zzgmx zzc = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgoh
        @Override // com.google.android.gms.internal.ads.zzgmv
        public final Object zza(zzgdy zzgdyVar) {
            return zzgoi.zza((zzgoe) zzgdyVar);
        }
    }, zzgoe.class, zzgem.class);
    private static final zzgdz zzd = zzglh.zzd("type.googleapis.com/google.crypto.tink.AesCmacKey", zzgem.class, zzgsu.SYMMETRIC, zzgql.zzh());

    public static /* synthetic */ zzgem zza(zzgoe zzgoeVar) throws GeneralSecurityException {
        zze(zzgoeVar.zzb());
        return zzgvo.zza(zzgoeVar);
    }

    public static /* synthetic */ zzgoe zzb(zzgon zzgonVar, Integer num) throws GeneralSecurityException {
        zze(zzgonVar);
        zzgoc zzgocVar = new zzgoc(null);
        zzgocVar.zzc(zzgonVar);
        zzgocVar.zza(zzgvs.zzc(zzgonVar.zzc()));
        zzgocVar.zzb(num);
        return zzgocVar.zzd();
    }

    public static /* synthetic */ zzgoo zzc(zzgoe zzgoeVar) throws GeneralSecurityException {
        zze(zzgoeVar.zzb());
        return new zzgqa(zzgoeVar);
    }

    public static void zzd(boolean z) throws GeneralSecurityException {
        if (!zzgkr.zza(1)) {
            throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
        }
        int i = zzgpy.zza;
        zzgpy.zze(zzgmk.zzc());
        zzgma.zzb().zzc(zza, zzgon.class);
        zzgmh.zza().zze(zzb);
        zzgmh.zza().zze(zzc);
        zzgmg zzgmgVarZzb = zzgmg.zzb();
        HashMap map = new HashMap();
        zzgon zzgonVar = zzgpt.zzc;
        map.put("AES_CMAC", zzgonVar);
        map.put("AES256_CMAC", zzgonVar);
        zzgok zzgokVar = new zzgok(null);
        zzgokVar.zza(32);
        zzgokVar.zzb(16);
        zzgokVar.zzc(zzgol.zzd);
        map.put("AES256_CMAC_RAW", zzgokVar.zzd());
        zzgmgVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgky.zzc().zzd(zzd, true);
    }

    private static void zze(zzgon zzgonVar) throws GeneralSecurityException {
        if (zzgonVar.zzc() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
