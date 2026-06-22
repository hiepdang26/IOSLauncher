package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgjl {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzgvrVarZzb = zzgoa.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zzgvrVarZzb;
        zzc = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgjh
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgnq zza(zzgen zzgenVar) {
                return zzgjl.zzd((zzggo) zzgenVar);
            }
        }, zzggo.class, zzgnm.class);
        zzd = zzgmp.zzb(new zzgmn() { // from class: com.google.android.gms.internal.ads.zzgji
            @Override // com.google.android.gms.internal.ads.zzgmn
            public final zzgen zza(zzgnq zzgnqVar) {
                return zzgjl.zzb((zzgnm) zzgnqVar);
            }
        }, zzgvrVarZzb, zzgnm.class);
        zze = zzglg.zzb(new zzgle() { // from class: com.google.android.gms.internal.ads.zzgjj
            @Override // com.google.android.gms.internal.ads.zzgle
            public final zzgnq zza(zzgdy zzgdyVar, zzger zzgerVar) {
                return zzgjl.zzc((zzggf) zzgdyVar, zzgerVar);
            }
        }, zzggf.class, zzgnl.class);
        zzf = zzglc.zzb(new zzgla() { // from class: com.google.android.gms.internal.ads.zzgjk
            @Override // com.google.android.gms.internal.ads.zzgla
            public final zzgdy zza(zzgnq zzgnqVar, zzger zzgerVar) {
                return zzgjl.zza((zzgnl) zzgnqVar, zzgerVar);
            }
        }, zzgvrVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzggf zza(zzgnl zzgnlVar, zzger zzgerVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
        try {
            zzgrs zzgrsVarZze = zzgrs.zze(zzgnlVar.zze(), zzgxi.zza());
            if (zzgrsVarZze.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzggl zzgglVarZzc = zzggo.zzc();
            zzgglVarZzc.zzb(zzgrsVarZze.zzf().zzd());
            zzgglVarZzc.zza(12);
            zzgglVarZzc.zzc(16);
            zzgglVarZzc.zzd(zzf(zzgnlVar.zzc()));
            zzggo zzggoVarZze = zzgglVarZzc.zze();
            zzggd zzggdVarZza = zzggf.zza();
            zzggdVarZza.zzc(zzggoVarZze);
            zzggdVarZza.zzb(zzgvs.zzb(zzgrsVarZze.zzf().zzA(), zzgerVar));
            zzggdVarZza.zza(zzgnlVar.zzf());
            return zzggdVarZza.zzd();
        } catch (zzgyn unused) {
            throw new GeneralSecurityException("Parsing AesGcmKey failed");
        }
    }

    public static /* synthetic */ zzggo zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            zzgrv zzgrvVarZzf = zzgrv.zzf(zzgnmVar.zzc().zzh(), zzgxi.zza());
            if (zzgrvVarZzf.zzc() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzggl zzgglVarZzc = zzggo.zzc();
            zzgglVarZzc.zzb(zzgrvVarZzf.zza());
            zzgglVarZzc.zza(12);
            zzgglVarZzc.zzc(16);
            zzgglVarZzc.zzd(zzf(zzgnmVar.zzc().zzg()));
            return zzgglVarZzc.zze();
        } catch (zzgyn e) {
            throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzggf zzggfVar, zzger zzgerVar) {
        zzgrr zzgrrVarZzc = zzgrs.zzc();
        byte[] bArrZzd = zzggfVar.zzd().zzd(zzgerVar);
        zzgrrVarZzc.zza(zzgwm.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", ((zzgrs) zzgrrVarZzc.zzbr()).zzaN(), zzgsu.SYMMETRIC, zzg(zzggfVar.zzb().zzd()), zzggfVar.zze());
    }

    public static /* synthetic */ zzgnm zzd(zzggo zzggoVar) {
        zzgsy zzgsyVarZza = zzgsz.zza();
        zzgsyVarZza.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzgru zzgruVarZzd = zzgrv.zzd();
        zzgruVarZzd.zza(zzggoVar.zzb());
        zzgsyVarZza.zzc(((zzgrv) zzgruVarZzd.zzbr()).zzaN());
        zzgsyVarZza.zza(zzg(zzggoVar.zzd()));
        return zzgnm.zzb((zzgsz) zzgsyVarZza.zzbr());
    }

    public static void zze(zzgmk zzgmkVar) {
        zzgmkVar.zzi(zzc);
        zzgmkVar.zzh(zzd);
        zzgmkVar.zzg(zze);
        zzgmkVar.zzf(zzf);
    }

    private static zzggm zzf(zzgtz zzgtzVar) throws GeneralSecurityException {
        int iOrdinal = zzgtzVar.ordinal();
        if (iOrdinal == 1) {
            return zzggm.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzggm.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(k31.k(zzgtzVar.zza(), "Unable to parse OutputPrefixType: "));
            }
        }
        return zzggm.zzb;
    }

    private static zzgtz zzg(zzggm zzggmVar) throws GeneralSecurityException {
        if (zzggm.zza.equals(zzggmVar)) {
            return zzgtz.TINK;
        }
        if (zzggm.zzb.equals(zzggmVar)) {
            return zzgtz.CRUNCHY;
        }
        if (zzggm.zzc.equals(zzggmVar)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzggmVar)));
    }
}
