package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgii {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzgvrVarZzb = zzgoa.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzb = zzgvrVarZzb;
        zzc = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgie
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgnq zza(zzgen zzgenVar) {
                return zzgii.zzd((zzgid) zzgenVar);
            }
        }, zzgid.class, zzgnm.class);
        zzd = zzgmp.zzb(new zzgmn() { // from class: com.google.android.gms.internal.ads.zzgif
            @Override // com.google.android.gms.internal.ads.zzgmn
            public final zzgen zza(zzgnq zzgnqVar) {
                return zzgii.zzb((zzgnm) zzgnqVar);
            }
        }, zzgvrVarZzb, zzgnm.class);
        zze = zzglg.zzb(new zzgle() { // from class: com.google.android.gms.internal.ads.zzgig
            @Override // com.google.android.gms.internal.ads.zzgle
            public final zzgnq zza(zzgdy zzgdyVar, zzger zzgerVar) {
                return zzgii.zzc((zzghx) zzgdyVar, zzgerVar);
            }
        }, zzghx.class, zzgnl.class);
        zzf = zzglc.zzb(new zzgla() { // from class: com.google.android.gms.internal.ads.zzgih
            @Override // com.google.android.gms.internal.ads.zzgla
            public final zzgdy zza(zzgnq zzgnqVar, zzger zzgerVar) {
                return zzgii.zza((zzgnl) zzgnqVar, zzgerVar);
            }
        }, zzgvrVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzghx zza(zzgnl zzgnlVar, zzger zzgerVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
        try {
            zzgtv zzgtvVarZze = zzgtv.zze(zzgnlVar.zze(), zzgxi.zza());
            if (zzgtvVarZze.zza() == 0) {
                return zzghx.zza(zzf(zzgtvVarZze.zzf(), zzgnlVar.zzc()), zzgnlVar.zzf());
            }
            throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got ".concat(String.valueOf(zzgtvVarZze)));
        } catch (zzgyn e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
        }
    }

    public static /* synthetic */ zzgid zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            return zzf(zzgty.zzf(zzgnmVar.zzc().zzh(), zzgxi.zza()), zzgnmVar.zzc().zzg());
        } catch (zzgyn e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzghx zzghxVar, zzger zzgerVar) {
        zzgtu zzgtuVarZzc = zzgtv.zzc();
        zzgtuVarZzc.zza(zzg(zzghxVar.zzb()));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", ((zzgtv) zzgtuVarZzc.zzbr()).zzaN(), zzgsu.REMOTE, zzh(zzghxVar.zzb().zzc()), zzghxVar.zzd());
    }

    public static /* synthetic */ zzgnm zzd(zzgid zzgidVar) {
        zzgsy zzgsyVarZza = zzgsz.zza();
        zzgsyVarZza.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzgsyVarZza.zzc(zzg(zzgidVar).zzaN());
        zzgsyVarZza.zza(zzh(zzgidVar.zzc()));
        return zzgnm.zzb((zzgsz) zzgsyVarZza.zzbr());
    }

    public static void zze(zzgmk zzgmkVar) {
        zzgmkVar.zzi(zzc);
        zzgmkVar.zzh(zzd);
        zzgmkVar.zzg(zze);
        zzgmkVar.zzf(zzf);
    }

    private static zzgid zzf(zzgty zzgtyVar, zzgtz zzgtzVar) throws GeneralSecurityException {
        zzgia zzgiaVar;
        zzgib zzgibVar;
        zzgsy zzgsyVarZza = zzgsz.zza();
        zzgsyVarZza.zzb(zzgtyVar.zza().zzi());
        zzgsyVarZza.zzc(zzgtyVar.zza().zzh());
        zzgsyVarZza.zza(zzgtz.RAW);
        zzgen zzgenVarZza = zzget.zza(((zzgsz) zzgsyVarZza.zzbr()).zzaV());
        if (zzgenVarZza instanceof zzggo) {
            zzgiaVar = zzgia.zza;
        } else if (zzgenVarZza instanceof zzghh) {
            zzgiaVar = zzgia.zzc;
        } else if (zzgenVarZza instanceof zzgiw) {
            zzgiaVar = zzgia.zzb;
        } else if (zzgenVarZza instanceof zzgfp) {
            zzgiaVar = zzgia.zzd;
        } else if (zzgenVarZza instanceof zzggb) {
            zzgiaVar = zzgia.zze;
        } else {
            if (!(zzgenVarZza instanceof zzghb)) {
                throw new GeneralSecurityException("Unsupported DEK parameters when parsing ".concat(zzgenVarZza.toString()));
            }
            zzgiaVar = zzgia.zzf;
        }
        zzghz zzghzVar = new zzghz(null);
        int iOrdinal = zzgtzVar.ordinal();
        if (iOrdinal == 1) {
            zzgibVar = zzgib.zza;
        } else {
            if (iOrdinal != 3) {
                throw new GeneralSecurityException(k31.k(zzgtzVar.zza(), "Unable to parse OutputPrefixType: "));
            }
            zzgibVar = zzgib.zzb;
        }
        zzghzVar.zzd(zzgibVar);
        zzghzVar.zzc(zzgtyVar.zzg());
        zzghzVar.zza((zzgex) zzgenVarZza);
        zzghzVar.zzb(zzgiaVar);
        return zzghzVar.zze();
    }

    private static zzgty zzg(zzgid zzgidVar) throws GeneralSecurityException {
        try {
            zzgsz zzgszVarZzf = zzgsz.zzf(zzget.zzb(zzgidVar.zzb()), zzgxi.zza());
            zzgtx zzgtxVarZzc = zzgty.zzc();
            zzgtxVarZzc.zzb(zzgidVar.zzd());
            zzgtxVarZzc.zza(zzgszVarZzf);
            return (zzgty) zzgtxVarZzc.zzbr();
        } catch (zzgyn e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    private static zzgtz zzh(zzgib zzgibVar) throws GeneralSecurityException {
        if (zzgib.zza.equals(zzgibVar)) {
            return zzgtz.TINK;
        }
        if (zzgib.zzb.equals(zzgibVar)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzgibVar)));
    }
}
