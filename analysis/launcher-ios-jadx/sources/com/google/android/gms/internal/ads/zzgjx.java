package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgjx {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzgvrVarZzb = zzgoa.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzb = zzgvrVarZzb;
        zzc = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgjt
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgnq zza(zzgen zzgenVar) {
                return zzgjx.zzd((zzghh) zzgenVar);
            }
        }, zzghh.class, zzgnm.class);
        zzd = zzgmp.zzb(new zzgmn() { // from class: com.google.android.gms.internal.ads.zzgju
            @Override // com.google.android.gms.internal.ads.zzgmn
            public final zzgen zza(zzgnq zzgnqVar) {
                return zzgjx.zzb((zzgnm) zzgnqVar);
            }
        }, zzgvrVarZzb, zzgnm.class);
        zze = zzglg.zzb(new zzgle() { // from class: com.google.android.gms.internal.ads.zzgjv
            @Override // com.google.android.gms.internal.ads.zzgle
            public final zzgnq zza(zzgdy zzgdyVar, zzger zzgerVar) {
                return zzgjx.zzc((zzghc) zzgdyVar, zzgerVar);
            }
        }, zzghc.class, zzgnl.class);
        zzf = zzglc.zzb(new zzgla() { // from class: com.google.android.gms.internal.ads.zzgjw
            @Override // com.google.android.gms.internal.ads.zzgla
            public final zzgdy zza(zzgnq zzgnqVar, zzger zzgerVar) {
                return zzgjx.zza((zzgnl) zzgnqVar, zzgerVar);
            }
        }, zzgvrVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzghc zza(zzgnl zzgnlVar, zzger zzgerVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzgse zzgseVarZze = zzgse.zze(zzgnlVar.zze(), zzgxi.zza());
            if (zzgseVarZze.zza() == 0) {
                return zzghc.zza(zzf(zzgnlVar.zzc()), zzgvs.zzb(zzgseVarZze.zzf().zzA(), zzgerVar), zzgnlVar.zzf());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzgyn unused) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
        }
    }

    public static /* synthetic */ zzghh zzb(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            zzgsh.zzd(zzgnmVar.zzc().zzh(), zzgxi.zza());
            return zzghh.zzc(zzf(zzgnmVar.zzc().zzg()));
        } catch (zzgyn e) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgnl zzc(zzghc zzghcVar, zzger zzgerVar) {
        zzgsd zzgsdVarZzc = zzgse.zzc();
        byte[] bArrZzd = zzghcVar.zzd().zzd(zzgerVar);
        zzgsdVarZzc.zza(zzgwm.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zzgse) zzgsdVarZzc.zzbr()).zzaN(), zzgsu.SYMMETRIC, zzg(zzghcVar.zzb().zzb()), zzghcVar.zze());
    }

    public static /* synthetic */ zzgnm zzd(zzghh zzghhVar) {
        zzgsy zzgsyVarZza = zzgsz.zza();
        zzgsyVarZza.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzgsyVarZza.zzc(zzgsh.zzc().zzaN());
        zzgsyVarZza.zza(zzg(zzghhVar.zzb()));
        return zzgnm.zzb((zzgsz) zzgsyVarZza.zzbr());
    }

    public static void zze(zzgmk zzgmkVar) {
        zzgmkVar.zzi(zzc);
        zzgmkVar.zzh(zzd);
        zzgmkVar.zzg(zze);
        zzgmkVar.zzf(zzf);
    }

    private static zzghg zzf(zzgtz zzgtzVar) throws GeneralSecurityException {
        int iOrdinal = zzgtzVar.ordinal();
        if (iOrdinal == 1) {
            return zzghg.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzghg.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(k31.k(zzgtzVar.zza(), "Unable to parse OutputPrefixType: "));
            }
        }
        return zzghg.zzb;
    }

    private static zzgtz zzg(zzghg zzghgVar) throws GeneralSecurityException {
        if (zzghg.zza.equals(zzghgVar)) {
            return zzgtz.TINK;
        }
        if (zzghg.zzb.equals(zzghgVar)) {
            return zzgtz.CRUNCHY;
        }
        if (zzghg.zzc.equals(zzghgVar)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzghgVar.toString()));
    }
}
