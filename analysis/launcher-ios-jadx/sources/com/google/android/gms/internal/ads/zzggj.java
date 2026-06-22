package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzggj {
    public static final /* synthetic */ int zza = 0;
    private static final zzgmx zzb = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzggg
        @Override // com.google.android.gms.internal.ads.zzgmv
        public final Object zza(zzgdy zzgdyVar) {
            return zzguo.zzb((zzggf) zzgdyVar);
        }
    }, zzggf.class, zzgdo.class);
    private static final zzgdz zzc = zzglh.zzd("type.googleapis.com/google.crypto.tink.AesGcmKey", zzgdo.class, zzgsu.SYMMETRIC, zzgrs.zzg());
    private static final zzgmb zzd = new zzgmb() { // from class: com.google.android.gms.internal.ads.zzggh
    };
    private static final zzglz zze = new zzglz() { // from class: com.google.android.gms.internal.ads.zzggi
        @Override // com.google.android.gms.internal.ads.zzglz
        public final zzgdy zza(zzgen zzgenVar, Integer num) throws GeneralSecurityException {
            zzggo zzggoVar = (zzggo) zzgenVar;
            int i = zzggj.zza;
            if (zzggoVar.zzb() == 24) {
                throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
            }
            zzggd zzggdVar = new zzggd(null);
            zzggdVar.zzc(zzggoVar);
            zzggdVar.zza(num);
            zzggdVar.zzb(zzgvs.zzc(zzggoVar.zzb()));
            return zzggdVar.zzd();
        }
    };
    private static final int zzf = 2;

    public static void zza(boolean z) {
        int i = zzf;
        if (!zzgkr.zza(i)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        int i2 = zzgjl.zza;
        zzgjl.zze(zzgmk.zzc());
        zzgmh.zza().zze(zzb);
        zzgmg zzgmgVarZzb = zzgmg.zzb();
        HashMap map = new HashMap();
        map.put("AES128_GCM", zzgip.zza);
        zzggl zzgglVar = new zzggl(null);
        zzgglVar.zza(12);
        zzgglVar.zzb(16);
        zzgglVar.zzc(16);
        zzggm zzggmVar = zzggm.zzc;
        zzgglVar.zzd(zzggmVar);
        map.put("AES128_GCM_RAW", zzgglVar.zze());
        map.put("AES256_GCM", zzgip.zzb);
        zzggl zzgglVar2 = new zzggl(null);
        zzgglVar2.zza(12);
        zzgglVar2.zzb(32);
        zzgglVar2.zzc(16);
        zzgglVar2.zzd(zzggmVar);
        map.put("AES256_GCM_RAW", zzgglVar2.zze());
        zzgmgVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgmc.zza().zzb(zzd, zzggo.class);
        zzgma.zzb().zzc(zze, zzggo.class);
        zzgky.zzc().zzf(zzc, i, true);
    }
}
