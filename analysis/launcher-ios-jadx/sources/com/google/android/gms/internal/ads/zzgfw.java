package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzgfw {
    public static final /* synthetic */ int zza = 0;
    private static final zzgmx zzb = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgfu
        @Override // com.google.android.gms.internal.ads.zzgmv
        public final Object zza(zzgdy zzgdyVar) {
            return zzgun.zzb((zzgft) zzgdyVar);
        }
    }, zzgft.class, zzgdo.class);
    private static final zzgdz zzc = zzglh.zzd("type.googleapis.com/google.crypto.tink.AesEaxKey", zzgdo.class, zzgsu.SYMMETRIC, zzgrj.zzh());
    private static final zzglz zzd = new zzglz() { // from class: com.google.android.gms.internal.ads.zzgfv
        @Override // com.google.android.gms.internal.ads.zzglz
        public final zzgdy zza(zzgen zzgenVar, Integer num) throws GeneralSecurityException {
            zzggb zzggbVar = (zzggb) zzgenVar;
            int i = zzgfw.zza;
            if (zzggbVar.zzc() == 24) {
                throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
            }
            zzgfr zzgfrVar = new zzgfr(null);
            zzgfrVar.zzc(zzggbVar);
            zzgfrVar.zza(num);
            zzgfrVar.zzb(zzgvs.zzc(zzggbVar.zzc()));
            return zzgfrVar.zzd();
        }
    };

    public static void zza(boolean z) {
        if (!zzgkr.zza(1)) {
            throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
        }
        int i = zzgjg.zza;
        zzgjg.zze(zzgmk.zzc());
        zzgmh.zza().zze(zzb);
        zzgmg zzgmgVarZzb = zzgmg.zzb();
        HashMap map = new HashMap();
        map.put("AES128_EAX", zzgip.zzc);
        zzgfy zzgfyVar = new zzgfy(null);
        zzgfyVar.zza(16);
        zzgfyVar.zzb(16);
        zzgfyVar.zzc(16);
        zzgfz zzgfzVar = zzgfz.zzc;
        zzgfyVar.zzd(zzgfzVar);
        map.put("AES128_EAX_RAW", zzgfyVar.zze());
        map.put("AES256_EAX", zzgip.zzd);
        zzgfy zzgfyVar2 = new zzgfy(null);
        zzgfyVar2.zza(16);
        zzgfyVar2.zzb(32);
        zzgfyVar2.zzc(16);
        zzgfyVar2.zzd(zzgfzVar);
        map.put("AES256_EAX_RAW", zzgfyVar2.zze());
        zzgmgVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgma.zzb().zzc(zzd, zzggb.class);
        zzgky.zzc().zzd(zzc, true);
    }
}
