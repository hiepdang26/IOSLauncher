package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzghk {
    public static final /* synthetic */ int zza = 0;
    private static final zzgmx zzb = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzghi
        @Override // com.google.android.gms.internal.ads.zzgmv
        public final Object zza(zzgdy zzgdyVar) throws GeneralSecurityException {
            zzghp zzghpVar = (zzghp) zzgdyVar;
            int i = zzghk.zza;
            zzgek zzgekVarZza = zzgel.zza(zzghpVar.zzb().zzd());
            zzghpVar.zzb();
            return zzgkh.zzc(zzgekVarZza.zzb(), zzghpVar.zzc());
        }
    }, zzghp.class, zzgdo.class);
    private static final zzgdz zzc = zzglh.zzd("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzgdo.class, zzgsu.REMOTE, zzgtp.zzg());
    private static final zzglz zzd = new zzglz() { // from class: com.google.android.gms.internal.ads.zzghj
        @Override // com.google.android.gms.internal.ads.zzglz
        public final zzgdy zza(zzgen zzgenVar, Integer num) {
            return zzghp.zza((zzghr) zzgenVar, num);
        }
    };

    public static void zza(boolean z) {
        if (!zzgkr.zza(1)) {
            throw new GeneralSecurityException("Registering KMS AEAD is not supported in FIPS mode");
        }
        int i = zzghw.zza;
        zzghw.zze(zzgmk.zzc());
        zzgmh.zza().zze(zzb);
        zzgma.zzb().zzc(zzd, zzghr.class);
        zzgky.zzc().zzd(zzc, true);
    }
}
