package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzgiu {
    public static final /* synthetic */ int zza = 0;
    private static final zzgmx zzb = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgir
        @Override // com.google.android.gms.internal.ads.zzgmv
        public final Object zza(zzgdy zzgdyVar) {
            zzgiq zzgiqVar = (zzgiq) zzgdyVar;
            int i = zzgiu.zza;
            return zzgkj.zzc() ? zzgkj.zzb(zzgiqVar) : zzgvq.zzb(zzgiqVar);
        }
    }, zzgiq.class, zzgdo.class);
    private static final zzgdz zzc = zzglh.zzd("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzgdo.class, zzgsu.SYMMETRIC, zzguf.zzg());
    private static final zzgmb zzd = new zzgmb() { // from class: com.google.android.gms.internal.ads.zzgis
    };
    private static final zzglz zze = new zzglz() { // from class: com.google.android.gms.internal.ads.zzgit
        @Override // com.google.android.gms.internal.ads.zzglz
        public final zzgdy zza(zzgen zzgenVar, Integer num) {
            int i = zzgiu.zza;
            return zzgiq.zza(((zzgiw) zzgenVar).zzb(), zzgvs.zzc(32), num);
        }
    };

    public static void zza(boolean z) {
        if (!zzgkr.zza(1)) {
            throw new GeneralSecurityException("Registering XChaCha20Poly1305 is not supported in FIPS mode");
        }
        int i = zzgko.zza;
        zzgko.zze(zzgmk.zzc());
        zzgmh.zza().zze(zzb);
        zzgmg zzgmgVarZzb = zzgmg.zzb();
        HashMap map = new HashMap();
        map.put("XCHACHA20_POLY1305", zzgiw.zzc(zzgiv.zza));
        map.put("XCHACHA20_POLY1305_RAW", zzgiw.zzc(zzgiv.zzc));
        zzgmgVarZzb.zzd(Collections.unmodifiableMap(map));
        zzgma.zzb().zzc(zze, zzgiw.class);
        zzgmc.zza().zzb(zzd, zzgiw.class);
        zzgky.zzc().zzd(zzc, true);
    }
}
