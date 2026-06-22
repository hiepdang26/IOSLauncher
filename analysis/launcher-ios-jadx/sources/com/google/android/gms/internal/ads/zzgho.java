package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgho {
    public static final /* synthetic */ int zza = 0;
    private static final zzgdz zzb = zzglh.zzd("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzgdo.class, zzgsu.SYMMETRIC, zzgtv.zzg());
    private static final zzglz zzc = new zzglz() { // from class: com.google.android.gms.internal.ads.zzghm
        @Override // com.google.android.gms.internal.ads.zzglz
        public final zzgdy zza(zzgen zzgenVar, Integer num) {
            return zzghx.zza((zzgid) zzgenVar, num);
        }
    };
    private static final zzgmx zzd = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzghn
        @Override // com.google.android.gms.internal.ads.zzgmv
        public final Object zza(zzgdy zzgdyVar) throws GeneralSecurityException {
            zzghx zzghxVar = (zzghx) zzgdyVar;
            int i = zzgho.zza;
            String strZzd = zzghxVar.zzb().zzd();
            zzgex zzgexVarZzb = zzghxVar.zzb().zzb();
            zzgdo zzgdoVarZzb = zzgel.zza(strZzd).zzb();
            int i2 = zzghl.zza;
            try {
                return zzgkh.zzc(new zzghl(zzgsz.zzf(zzget.zzb(zzgexVarZzb), zzgxi.zza()), zzgdoVarZzb), zzghxVar.zzc());
            } catch (zzgyn e) {
                throw new GeneralSecurityException(e);
            }
        }
    }, zzghx.class, zzgdo.class);

    public static void zza(boolean z) {
        if (!zzgkr.zza(1)) {
            throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
        }
        int i = zzgii.zza;
        zzgii.zze(zzgmk.zzc());
        zzgma.zzb().zzc(zzc, zzgid.class);
        zzgmh.zza().zze(zzd);
        zzgky.zzc().zzd(zzb, true);
    }
}
