package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgjb {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzgvrVarZzb = zzgoa.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zzgvrVarZzb;
        zzc = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgix
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgnq zza(zzgen zzgenVar) {
                return zzgjb.zzd((zzgfp) zzgenVar);
            }
        }, zzgfp.class, zzgnm.class);
        zzd = zzgmp.zzb(new zzgmn() { // from class: com.google.android.gms.internal.ads.zzgiy
            @Override // com.google.android.gms.internal.ads.zzgmn
            public final zzgen zza(zzgnq zzgnqVar) {
                return zzgjb.zzb((zzgnm) zzgnqVar);
            }
        }, zzgvrVarZzb, zzgnm.class);
        zze = zzglg.zzb(new zzgle() { // from class: com.google.android.gms.internal.ads.zzgiz
            @Override // com.google.android.gms.internal.ads.zzgle
            public final zzgnq zza(zzgdy zzgdyVar, zzger zzgerVar) {
                return zzgjb.zzc((zzgff) zzgdyVar, zzgerVar);
            }
        }, zzgff.class, zzgnl.class);
        zzf = zzglc.zzb(new zzgla() { // from class: com.google.android.gms.internal.ads.zzgja
            @Override // com.google.android.gms.internal.ads.zzgla
            public final zzgdy zza(zzgnq zzgnqVar, zzger zzgerVar) {
                return zzgjb.zza((zzgnl) zzgnqVar, zzgerVar);
            }
        }, zzgvrVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzgff zza(zzgnl zzgnlVar, zzger zzgerVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
        try {
            zzgqu zzgquVarZze = zzgqu.zze(zzgnlVar.zze(), zzgxi.zza());
            if (zzgquVarZze.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzgquVarZze.zzf().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
            }
            if (zzgquVarZze.zzg().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
            }
            zzgfl zzgflVarZzf = zzgfp.zzf();
            zzgflVarZzf.zza(zzgquVarZze.zzf().zzg().zzd());
            zzgflVarZzf.zzc(zzgquVarZze.zzg().zzh().zzd());
            zzgflVarZzf.zzd(zzgquVarZze.zzf().zzf().zza());
            zzgflVarZzf.zze(zzgquVarZze.zzg().zzg().zza());
            zzgflVarZzf.zzb(zzf(zzgquVarZze.zzg().zzg().zzc()));
            zzgflVarZzf.zzf(zzg(zzgnlVar.zzc()));
            zzgfp zzgfpVarZzg = zzgflVarZzf.zzg();
            zzgfd zzgfdVarZza = zzgff.zza();
            zzgfdVarZza.zzd(zzgfpVarZzg);
            zzgfdVarZza.zza(zzgvs.zzb(zzgquVarZze.zzf().zzg().zzA(), zzgerVar));
            zzgfdVarZza.zzb(zzgvs.zzb(zzgquVarZze.zzg().zzh().zzA(), zzgerVar));
            zzgfdVarZza.zzc(zzgnlVar.zzf());
            return zzgfdVarZza.zze();
        } catch (zzgyn unused) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
        }
    }

    public static /* synthetic */ zzgfp zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            zzgqx zzgqxVarZzd = zzgqx.zzd(zzgnmVar.zzc().zzh(), zzgxi.zza());
            if (zzgqxVarZzd.zzf().zzc() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgfl zzgflVarZzf = zzgfp.zzf();
            zzgflVarZzf.zza(zzgqxVarZzd.zze().zza());
            zzgflVarZzf.zzc(zzgqxVarZzd.zzf().zza());
            zzgflVarZzf.zzd(zzgqxVarZzd.zze().zzf().zza());
            zzgflVarZzf.zze(zzgqxVarZzd.zzf().zzh().zza());
            zzgflVarZzf.zzb(zzf(zzgqxVarZzd.zzf().zzh().zzc()));
            zzgflVarZzf.zzf(zzg(zzgnmVar.zzc().zzg()));
            return zzgflVarZzf.zzg();
        } catch (zzgyn e) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzgff zzgffVar, zzger zzgerVar) {
        zzgqt zzgqtVarZzc = zzgqu.zzc();
        zzgqz zzgqzVarZzc = zzgra.zzc();
        zzgrf zzgrfVarZzc = zzgrg.zzc();
        zzgrfVarZzc.zza(zzgffVar.zzb().zzd());
        zzgqzVarZzc.zzb((zzgrg) zzgrfVarZzc.zzbr());
        byte[] bArrZzd = zzgffVar.zzd().zzd(zzgerVar);
        zzgqzVarZzc.zza(zzgwm.zzv(bArrZzd, 0, bArrZzd.length));
        zzgqtVarZzc.zza((zzgra) zzgqzVarZzc.zzbr());
        zzgsk zzgskVarZzc = zzgsl.zzc();
        zzgskVarZzc.zzb(zzh(zzgffVar.zzb()));
        byte[] bArrZzd2 = zzgffVar.zze().zzd(zzgerVar);
        zzgskVarZzc.zza(zzgwm.zzv(bArrZzd2, 0, bArrZzd2.length));
        zzgqtVarZzc.zzb((zzgsl) zzgskVarZzc.zzbr());
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", ((zzgqu) zzgqtVarZzc.zzbr()).zzaN(), zzgsu.SYMMETRIC, zzi(zzgffVar.zzb().zzh()), zzgffVar.zzf());
    }

    public static /* synthetic */ zzgnm zzd(zzgfp zzgfpVar) {
        zzgsy zzgsyVarZza = zzgsz.zza();
        zzgsyVarZza.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzgqw zzgqwVarZza = zzgqx.zza();
        zzgrc zzgrcVarZzc = zzgrd.zzc();
        zzgrf zzgrfVarZzc = zzgrg.zzc();
        zzgrfVarZzc.zza(zzgfpVar.zzd());
        zzgrcVarZzc.zzb((zzgrg) zzgrfVarZzc.zzbr());
        zzgrcVarZzc.zza(zzgfpVar.zzb());
        zzgqwVarZza.zza((zzgrd) zzgrcVarZzc.zzbr());
        zzgsn zzgsnVarZzd = zzgso.zzd();
        zzgsnVarZzd.zzb(zzh(zzgfpVar));
        zzgsnVarZzd.zza(zzgfpVar.zzc());
        zzgqwVarZza.zzb((zzgso) zzgsnVarZzd.zzbr());
        zzgsyVarZza.zzc(((zzgqx) zzgqwVarZza.zzbr()).zzaN());
        zzgsyVarZza.zza(zzi(zzgfpVar.zzh()));
        return zzgnm.zzb((zzgsz) zzgsyVarZza.zzbr());
    }

    public static void zze(zzgmk zzgmkVar) {
        zzgmkVar.zzi(zzc);
        zzgmkVar.zzh(zzd);
        zzgmkVar.zzg(zze);
        zzgmkVar.zzf(zzf);
    }

    private static zzgfm zzf(zzgsi zzgsiVar) throws GeneralSecurityException {
        int iOrdinal = zzgsiVar.ordinal();
        if (iOrdinal == 1) {
            return zzgfm.zza;
        }
        if (iOrdinal == 2) {
            return zzgfm.zzd;
        }
        if (iOrdinal == 3) {
            return zzgfm.zzc;
        }
        if (iOrdinal == 4) {
            return zzgfm.zze;
        }
        if (iOrdinal == 5) {
            return zzgfm.zzb;
        }
        throw new GeneralSecurityException(k31.k(zzgsiVar.zza(), "Unable to parse HashType: "));
    }

    private static zzgfn zzg(zzgtz zzgtzVar) throws GeneralSecurityException {
        int iOrdinal = zzgtzVar.ordinal();
        if (iOrdinal == 1) {
            return zzgfn.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzgfn.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(k31.k(zzgtzVar.zza(), "Unable to parse OutputPrefixType: "));
            }
        }
        return zzgfn.zzb;
    }

    private static zzgsr zzh(zzgfp zzgfpVar) throws GeneralSecurityException {
        zzgsi zzgsiVar;
        zzgsq zzgsqVarZzd = zzgsr.zzd();
        zzgsqVarZzd.zzb(zzgfpVar.zze());
        zzgfm zzgfmVarZzg = zzgfpVar.zzg();
        if (zzgfm.zza.equals(zzgfmVarZzg)) {
            zzgsiVar = zzgsi.SHA1;
        } else if (zzgfm.zzb.equals(zzgfmVarZzg)) {
            zzgsiVar = zzgsi.SHA224;
        } else if (zzgfm.zzc.equals(zzgfmVarZzg)) {
            zzgsiVar = zzgsi.SHA256;
        } else if (zzgfm.zzd.equals(zzgfmVarZzg)) {
            zzgsiVar = zzgsi.SHA384;
        } else {
            if (!zzgfm.zze.equals(zzgfmVarZzg)) {
                throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(zzgfmVarZzg)));
            }
            zzgsiVar = zzgsi.SHA512;
        }
        zzgsqVarZzd.zza(zzgsiVar);
        return (zzgsr) zzgsqVarZzd.zzbr();
    }

    private static zzgtz zzi(zzgfn zzgfnVar) throws GeneralSecurityException {
        if (zzgfn.zza.equals(zzgfnVar)) {
            return zzgtz.TINK;
        }
        if (zzgfn.zzb.equals(zzgfnVar)) {
            return zzgtz.CRUNCHY;
        }
        if (zzgfn.zzc.equals(zzgfnVar)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzgfnVar)));
    }
}
