package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgjq {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzgvrVarZzb = zzgoa.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zzgvrVarZzb;
        zzc = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgjm
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgnq zza(zzgen zzgenVar) {
                return zzgjq.zzd((zzghb) zzgenVar);
            }
        }, zzghb.class, zzgnm.class);
        zzd = zzgmp.zzb(new zzgmn() { // from class: com.google.android.gms.internal.ads.zzgjn
            @Override // com.google.android.gms.internal.ads.zzgmn
            public final zzgen zza(zzgnq zzgnqVar) {
                return zzgjq.zzb((zzgnm) zzgnqVar);
            }
        }, zzgvrVarZzb, zzgnm.class);
        zze = zzglg.zzb(new zzgle() { // from class: com.google.android.gms.internal.ads.zzgjo
            @Override // com.google.android.gms.internal.ads.zzgle
            public final zzgnq zza(zzgdy zzgdyVar, zzger zzgerVar) {
                return zzgjq.zzc((zzggs) zzgdyVar, zzgerVar);
            }
        }, zzggs.class, zzgnl.class);
        zzf = zzglc.zzb(new zzgla() { // from class: com.google.android.gms.internal.ads.zzgjp
            @Override // com.google.android.gms.internal.ads.zzgla
            public final zzgdy zza(zzgnq zzgnqVar, zzger zzgerVar) {
                return zzgjq.zza((zzgnl) zzgnqVar, zzgerVar);
            }
        }, zzgvrVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzggs zza(zzgnl zzgnlVar, zzger zzgerVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
        try {
            zzgry zzgryVarZze = zzgry.zze(zzgnlVar.zze(), zzgxi.zza());
            if (zzgryVarZze.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzggy zzggyVarZzc = zzghb.zzc();
            zzggyVarZzc.zza(zzgryVarZze.zzf().zzd());
            zzggyVarZzc.zzb(zzf(zzgnlVar.zzc()));
            zzghb zzghbVarZzc = zzggyVarZzc.zzc();
            zzggq zzggqVarZza = zzggs.zza();
            zzggqVarZza.zzc(zzghbVarZzc);
            zzggqVarZza.zzb(zzgvs.zzb(zzgryVarZze.zzf().zzA(), zzgerVar));
            zzggqVarZza.zza(zzgnlVar.zzf());
            return zzggqVarZza.zzd();
        } catch (zzgyn unused) {
            throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
        }
    }

    public static /* synthetic */ zzghb zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            zzgsb zzgsbVarZzf = zzgsb.zzf(zzgnmVar.zzc().zzh(), zzgxi.zza());
            if (zzgsbVarZzf.zzc() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzggy zzggyVarZzc = zzghb.zzc();
            zzggyVarZzc.zza(zzgsbVarZzf.zza());
            zzggyVarZzc.zzb(zzf(zzgnmVar.zzc().zzg()));
            return zzggyVarZzc.zzc();
        } catch (zzgyn e) {
            throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzggs zzggsVar, zzger zzgerVar) {
        zzgrx zzgrxVarZzc = zzgry.zzc();
        byte[] bArrZzd = zzggsVar.zzd().zzd(zzgerVar);
        zzgrxVarZzc.zza(zzgwm.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzgry) zzgrxVarZzc.zzbr()).zzaN(), zzgsu.SYMMETRIC, zzg(zzggsVar.zzb().zzd()), zzggsVar.zze());
    }

    public static /* synthetic */ zzgnm zzd(zzghb zzghbVar) {
        zzgsy zzgsyVarZza = zzgsz.zza();
        zzgsyVarZza.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzgsa zzgsaVarZzd = zzgsb.zzd();
        zzgsaVarZzd.zza(zzghbVar.zzb());
        zzgsyVarZza.zzc(((zzgsb) zzgsaVarZzd.zzbr()).zzaN());
        zzgsyVarZza.zza(zzg(zzghbVar.zzd()));
        return zzgnm.zzb((zzgsz) zzgsyVarZza.zzbr());
    }

    public static void zze(zzgmk zzgmkVar) {
        zzgmkVar.zzi(zzc);
        zzgmkVar.zzh(zzd);
        zzgmkVar.zzg(zze);
        zzgmkVar.zzf(zzf);
    }

    private static zzggz zzf(zzgtz zzgtzVar) throws GeneralSecurityException {
        int iOrdinal = zzgtzVar.ordinal();
        if (iOrdinal == 1) {
            return zzggz.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzggz.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(k31.k(zzgtzVar.zza(), "Unable to parse OutputPrefixType: "));
            }
        }
        return zzggz.zzb;
    }

    private static zzgtz zzg(zzggz zzggzVar) throws GeneralSecurityException {
        if (zzggz.zza.equals(zzggzVar)) {
            return zzgtz.TINK;
        }
        if (zzggz.zzb.equals(zzggzVar)) {
            return zzgtz.CRUNCHY;
        }
        if (zzggz.zzc.equals(zzggzVar)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzggzVar)));
    }
}
