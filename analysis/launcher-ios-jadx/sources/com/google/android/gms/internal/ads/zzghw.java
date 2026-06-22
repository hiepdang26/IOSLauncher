package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
final class zzghw {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzgvrVarZzb = zzgoa.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzb = zzgvrVarZzb;
        zzc = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzghs
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgnq zza(zzgen zzgenVar) {
                return zzghw.zzd((zzghr) zzgenVar);
            }
        }, zzghr.class, zzgnm.class);
        zzd = zzgmp.zzb(new zzgmn() { // from class: com.google.android.gms.internal.ads.zzght
            @Override // com.google.android.gms.internal.ads.zzgmn
            public final zzgen zza(zzgnq zzgnqVar) {
                return zzghw.zzb((zzgnm) zzgnqVar);
            }
        }, zzgvrVarZzb, zzgnm.class);
        zze = zzglg.zzb(new zzgle() { // from class: com.google.android.gms.internal.ads.zzghu
            @Override // com.google.android.gms.internal.ads.zzgle
            public final zzgnq zza(zzgdy zzgdyVar, zzger zzgerVar) {
                return zzghw.zzc((zzghp) zzgdyVar, zzgerVar);
            }
        }, zzghp.class, zzgnl.class);
        zzf = zzglc.zzb(new zzgla() { // from class: com.google.android.gms.internal.ads.zzghv
            @Override // com.google.android.gms.internal.ads.zzgla
            public final zzgdy zza(zzgnq zzgnqVar, zzger zzgerVar) {
                return zzghw.zza((zzgnl) zzgnqVar, zzgerVar);
            }
        }, zzgvrVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzghp zza(zzgnl zzgnlVar, zzger zzgerVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        }
        try {
            zzgtp zzgtpVarZze = zzgtp.zze(zzgnlVar.zze(), zzgxi.zza());
            if (zzgtpVarZze.zza() == 0) {
                return zzghp.zza(zzghr.zzc(zzgtpVarZze.zzf().zzf(), zzf(zzgnlVar.zzc())), zzgnlVar.zzf());
            }
            throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got ".concat(String.valueOf(zzgtpVarZze)));
        } catch (zzgyn e) {
            throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
        }
    }

    public static /* synthetic */ zzghr zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            return zzghr.zzc(zzgts.zze(zzgnmVar.zzc().zzh(), zzgxi.zza()).zzf(), zzf(zzgnmVar.zzc().zzg()));
        } catch (zzgyn e) {
            throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzghp zzghpVar, zzger zzgerVar) {
        zzgto zzgtoVarZzc = zzgtp.zzc();
        zzgtr zzgtrVarZza = zzgts.zza();
        zzgtrVarZza.zza(zzghpVar.zzb().zzd());
        zzgtoVarZzc.zza((zzgts) zzgtrVarZza.zzbr());
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", ((zzgtp) zzgtoVarZzc.zzbr()).zzaN(), zzgsu.REMOTE, zzg(zzghpVar.zzb().zzb()), zzghpVar.zzd());
    }

    public static /* synthetic */ zzgnm zzd(zzghr zzghrVar) {
        zzgsy zzgsyVarZza = zzgsz.zza();
        zzgsyVarZza.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzgtr zzgtrVarZza = zzgts.zza();
        zzgtrVarZza.zza(zzghrVar.zzd());
        zzgsyVarZza.zzc(((zzgts) zzgtrVarZza.zzbr()).zzaN());
        zzgsyVarZza.zza(zzg(zzghrVar.zzb()));
        return zzgnm.zzb((zzgsz) zzgsyVarZza.zzbr());
    }

    public static void zze(zzgmk zzgmkVar) {
        zzgmkVar.zzi(zzc);
        zzgmkVar.zzh(zzd);
        zzgmkVar.zzg(zze);
        zzgmkVar.zzf(zzf);
    }

    private static zzghq zzf(zzgtz zzgtzVar) throws GeneralSecurityException {
        int iOrdinal = zzgtzVar.ordinal();
        if (iOrdinal == 1) {
            return zzghq.zza;
        }
        if (iOrdinal == 3) {
            return zzghq.zzb;
        }
        throw new GeneralSecurityException(k31.k(zzgtzVar.zza(), "Unable to parse OutputPrefixType: "));
    }

    private static zzgtz zzg(zzghq zzghqVar) throws GeneralSecurityException {
        if (zzghq.zza.equals(zzghqVar)) {
            return zzgtz.TINK;
        }
        if (zzghq.zzb.equals(zzghqVar)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzghqVar.toString()));
    }
}
