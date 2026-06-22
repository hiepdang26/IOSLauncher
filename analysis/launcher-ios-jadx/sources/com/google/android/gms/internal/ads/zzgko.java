package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgko {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzgvrVarZzb = zzgoa.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zzgvrVarZzb;
        zzc = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgkk
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgnq zza(zzgen zzgenVar) {
                return zzgko.zzd((zzgiw) zzgenVar);
            }
        }, zzgiw.class, zzgnm.class);
        zzd = zzgmp.zzb(new zzgmn() { // from class: com.google.android.gms.internal.ads.zzgkl
            @Override // com.google.android.gms.internal.ads.zzgmn
            public final zzgen zza(zzgnq zzgnqVar) {
                return zzgko.zzb((zzgnm) zzgnqVar);
            }
        }, zzgvrVarZzb, zzgnm.class);
        zze = zzglg.zzb(new zzgle() { // from class: com.google.android.gms.internal.ads.zzgkm
            @Override // com.google.android.gms.internal.ads.zzgle
            public final zzgnq zza(zzgdy zzgdyVar, zzger zzgerVar) {
                return zzgko.zzc((zzgiq) zzgdyVar, zzgerVar);
            }
        }, zzgiq.class, zzgnl.class);
        zzf = zzglc.zzb(new zzgla() { // from class: com.google.android.gms.internal.ads.zzgkn
            @Override // com.google.android.gms.internal.ads.zzgla
            public final zzgdy zza(zzgnq zzgnqVar, zzger zzgerVar) {
                return zzgko.zza((zzgnl) zzgnqVar, zzgerVar);
            }
        }, zzgvrVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzgiq zza(zzgnl zzgnlVar, zzger zzgerVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzguf zzgufVarZze = zzguf.zze(zzgnlVar.zze(), zzgxi.zza());
            if (zzgufVarZze.zza() == 0) {
                return zzgiq.zza(zzf(zzgnlVar.zzc()), zzgvs.zzb(zzgufVarZze.zzf().zzA(), zzgerVar), zzgnlVar.zzf());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzgyn unused) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
        }
    }

    public static /* synthetic */ zzgiw zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            if (zzgui.zze(zzgnmVar.zzc().zzh(), zzgxi.zza()).zza() == 0) {
                return zzgiw.zzc(zzf(zzgnmVar.zzc().zzg()));
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzgyn e) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzgiq zzgiqVar, zzger zzgerVar) {
        zzgue zzgueVarZzc = zzguf.zzc();
        byte[] bArrZzd = zzgiqVar.zzd().zzd(zzgerVar);
        zzgueVarZzc.zza(zzgwm.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzguf) zzgueVarZzc.zzbr()).zzaN(), zzgsu.SYMMETRIC, zzg(zzgiqVar.zzb().zzb()), zzgiqVar.zze());
    }

    public static /* synthetic */ zzgnm zzd(zzgiw zzgiwVar) {
        zzgsy zzgsyVarZza = zzgsz.zza();
        zzgsyVarZza.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzgsyVarZza.zzc(zzgui.zzd().zzaN());
        zzgsyVarZza.zza(zzg(zzgiwVar.zzb()));
        return zzgnm.zzb((zzgsz) zzgsyVarZza.zzbr());
    }

    public static void zze(zzgmk zzgmkVar) {
        zzgmkVar.zzi(zzc);
        zzgmkVar.zzh(zzd);
        zzgmkVar.zzg(zze);
        zzgmkVar.zzf(zzf);
    }

    private static zzgiv zzf(zzgtz zzgtzVar) throws GeneralSecurityException {
        int iOrdinal = zzgtzVar.ordinal();
        if (iOrdinal == 1) {
            return zzgiv.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzgiv.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(k31.k(zzgtzVar.zza(), "Unable to parse OutputPrefixType: "));
            }
        }
        return zzgiv.zzb;
    }

    private static zzgtz zzg(zzgiv zzgivVar) throws GeneralSecurityException {
        if (zzgiv.zza.equals(zzgivVar)) {
            return zzgtz.TINK;
        }
        if (zzgiv.zzb.equals(zzgivVar)) {
            return zzgtz.CRUNCHY;
        }
        if (zzgiv.zzc.equals(zzgivVar)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgivVar.toString()));
    }
}
