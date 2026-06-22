package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgjg {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzgvrVarZzb = zzgoa.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zzgvrVarZzb;
        zzc = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgjc
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgnq zza(zzgen zzgenVar) {
                return zzgjg.zzd((zzggb) zzgenVar);
            }
        }, zzggb.class, zzgnm.class);
        zzd = zzgmp.zzb(new zzgmn() { // from class: com.google.android.gms.internal.ads.zzgjd
            @Override // com.google.android.gms.internal.ads.zzgmn
            public final zzgen zza(zzgnq zzgnqVar) {
                return zzgjg.zzb((zzgnm) zzgnqVar);
            }
        }, zzgvrVarZzb, zzgnm.class);
        zze = zzglg.zzb(new zzgle() { // from class: com.google.android.gms.internal.ads.zzgje
            @Override // com.google.android.gms.internal.ads.zzgle
            public final zzgnq zza(zzgdy zzgdyVar, zzger zzgerVar) {
                return zzgjg.zzc((zzgft) zzgdyVar, zzgerVar);
            }
        }, zzgft.class, zzgnl.class);
        zzf = zzglc.zzb(new zzgla() { // from class: com.google.android.gms.internal.ads.zzgjf
            @Override // com.google.android.gms.internal.ads.zzgla
            public final zzgdy zza(zzgnq zzgnqVar, zzger zzgerVar) {
                return zzgjg.zza((zzgnl) zzgnqVar, zzgerVar);
            }
        }, zzgvrVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzgft zza(zzgnl zzgnlVar, zzger zzgerVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
        try {
            zzgrj zzgrjVarZze = zzgrj.zze(zzgnlVar.zze(), zzgxi.zza());
            if (zzgrjVarZze.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgfy zzgfyVarZzd = zzggb.zzd();
            zzgfyVarZzd.zzb(zzgrjVarZze.zzg().zzd());
            zzgfyVarZzd.zza(zzgrjVarZze.zzf().zza());
            zzgfyVarZzd.zzc(16);
            zzgfyVarZzd.zzd(zzf(zzgnlVar.zzc()));
            zzggb zzggbVarZze = zzgfyVarZzd.zze();
            zzgfr zzgfrVarZza = zzgft.zza();
            zzgfrVarZza.zzc(zzggbVarZze);
            zzgfrVarZza.zzb(zzgvs.zzb(zzgrjVarZze.zzg().zzA(), zzgerVar));
            zzgfrVarZza.zza(zzgnlVar.zzf());
            return zzgfrVarZza.zzd();
        } catch (zzgyn unused) {
            throw new GeneralSecurityException("Parsing AesEaxcKey failed");
        }
    }

    public static /* synthetic */ zzggb zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            zzgrm zzgrmVarZze = zzgrm.zze(zzgnmVar.zzc().zzh(), zzgxi.zza());
            zzgfy zzgfyVarZzd = zzggb.zzd();
            zzgfyVarZzd.zzb(zzgrmVarZze.zza());
            zzgfyVarZzd.zza(zzgrmVarZze.zzf().zza());
            zzgfyVarZzd.zzc(16);
            zzgfyVarZzd.zzd(zzf(zzgnmVar.zzc().zzg()));
            return zzgfyVarZzd.zze();
        } catch (zzgyn e) {
            throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzgft zzgftVar, zzger zzgerVar) {
        zzgri zzgriVarZzc = zzgrj.zzc();
        zzgriVarZzc.zzb(zzg(zzgftVar.zzb()));
        byte[] bArrZzd = zzgftVar.zzd().zzd(zzgerVar);
        zzgriVarZzc.zza(zzgwm.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzgrj) zzgriVarZzc.zzbr()).zzaN(), zzgsu.SYMMETRIC, zzh(zzgftVar.zzb().zze()), zzgftVar.zze());
    }

    public static /* synthetic */ zzgnm zzd(zzggb zzggbVar) {
        zzgsy zzgsyVarZza = zzgsz.zza();
        zzgsyVarZza.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzgrl zzgrlVarZzc = zzgrm.zzc();
        zzgrlVarZzc.zzb(zzg(zzggbVar));
        zzgrlVarZzc.zza(zzggbVar.zzc());
        zzgsyVarZza.zzc(((zzgrm) zzgrlVarZzc.zzbr()).zzaN());
        zzgsyVarZza.zza(zzh(zzggbVar.zze()));
        return zzgnm.zzb((zzgsz) zzgsyVarZza.zzbr());
    }

    public static void zze(zzgmk zzgmkVar) {
        zzgmkVar.zzi(zzc);
        zzgmkVar.zzh(zzd);
        zzgmkVar.zzg(zze);
        zzgmkVar.zzf(zzf);
    }

    private static zzgfz zzf(zzgtz zzgtzVar) throws GeneralSecurityException {
        int iOrdinal = zzgtzVar.ordinal();
        if (iOrdinal == 1) {
            return zzgfz.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzgfz.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(k31.k(zzgtzVar.zza(), "Unable to parse OutputPrefixType: "));
            }
        }
        return zzgfz.zzb;
    }

    private static zzgrp zzg(zzggb zzggbVar) {
        zzgro zzgroVarZzc = zzgrp.zzc();
        zzgroVarZzc.zza(zzggbVar.zzb());
        return (zzgrp) zzgroVarZzc.zzbr();
    }

    private static zzgtz zzh(zzgfz zzgfzVar) throws GeneralSecurityException {
        if (zzgfz.zza.equals(zzgfzVar)) {
            return zzgtz.TINK;
        }
        if (zzgfz.zzb.equals(zzgfzVar)) {
            return zzgtz.CRUNCHY;
        }
        if (zzgfz.zzc.equals(zzgfzVar)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzgfzVar)));
    }
}
