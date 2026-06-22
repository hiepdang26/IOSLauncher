package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgpy {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzgvrVarZzb = zzgoa.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zzgvrVarZzb;
        zzc = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgpu
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgnq zza(zzgen zzgenVar) {
                return zzgpy.zzb((zzgon) zzgenVar);
            }
        }, zzgon.class, zzgnm.class);
        zzd = zzgmp.zzb(new zzgmn() { // from class: com.google.android.gms.internal.ads.zzgpv
            @Override // com.google.android.gms.internal.ads.zzgmn
            public final zzgen zza(zzgnq zzgnqVar) {
                return zzgpy.zzd((zzgnm) zzgnqVar);
            }
        }, zzgvrVarZzb, zzgnm.class);
        zze = zzglg.zzb(new zzgle() { // from class: com.google.android.gms.internal.ads.zzgpw
            @Override // com.google.android.gms.internal.ads.zzgle
            public final zzgnq zza(zzgdy zzgdyVar, zzger zzgerVar) {
                return zzgpy.zza((zzgoe) zzgdyVar, zzgerVar);
            }
        }, zzgoe.class, zzgnl.class);
        zzf = zzglc.zzb(new zzgla() { // from class: com.google.android.gms.internal.ads.zzgpx
            @Override // com.google.android.gms.internal.ads.zzgla
            public final zzgdy zza(zzgnq zzgnqVar, zzger zzgerVar) {
                return zzgpy.zzc((zzgnl) zzgnqVar, zzgerVar);
            }
        }, zzgvrVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzgnl zza(zzgoe zzgoeVar, zzger zzgerVar) {
        zzgqk zzgqkVarZzc = zzgql.zzc();
        zzgqkVarZzc.zzb(zzg(zzgoeVar.zzb()));
        byte[] bArrZzd = zzgoeVar.zzd().zzd(zzgerVar);
        zzgqkVarZzc.zza(zzgwm.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zzgql) zzgqkVarZzc.zzbr()).zzaN(), zzgsu.SYMMETRIC, zzh(zzgoeVar.zzb().zzf()), zzgoeVar.zze());
    }

    public static /* synthetic */ zzgnm zzb(zzgon zzgonVar) {
        zzgsy zzgsyVarZza = zzgsz.zza();
        zzgsyVarZza.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzgqn zzgqnVarZzc = zzgqo.zzc();
        zzgqnVarZzc.zzb(zzg(zzgonVar));
        zzgqnVarZzc.zza(zzgonVar.zzc());
        zzgsyVarZza.zzc(((zzgqo) zzgqnVarZzc.zzbr()).zzaN());
        zzgsyVarZza.zza(zzh(zzgonVar.zzf()));
        return zzgnm.zzb((zzgsz) zzgsyVarZza.zzbr());
    }

    public static /* synthetic */ zzgoe zzc(zzgnl zzgnlVar, zzger zzgerVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
        try {
            zzgql zzgqlVarZze = zzgql.zze(zzgnlVar.zze(), zzgxi.zza());
            if (zzgqlVarZze.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgok zzgokVarZze = zzgon.zze();
            zzgokVarZze.zza(zzgqlVarZze.zzg().zzd());
            zzgokVarZze.zzb(zzgqlVarZze.zzf().zza());
            zzgokVarZze.zzc(zzf(zzgnlVar.zzc()));
            zzgon zzgonVarZzd = zzgokVarZze.zzd();
            zzgoc zzgocVarZza = zzgoe.zza();
            zzgocVarZza.zzc(zzgonVarZzd);
            zzgocVarZza.zza(zzgvs.zzb(zzgqlVarZze.zzg().zzA(), zzgerVar));
            zzgocVarZza.zzb(zzgnlVar.zzf());
            return zzgocVarZza.zzd();
        } catch (zzgyn | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }

    public static /* synthetic */ zzgon zzd(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            zzgqo zzgqoVarZze = zzgqo.zze(zzgnmVar.zzc().zzh(), zzgxi.zza());
            zzgok zzgokVarZze = zzgon.zze();
            zzgokVarZze.zza(zzgqoVarZze.zza());
            zzgokVarZze.zzb(zzgqoVarZze.zzf().zza());
            zzgokVarZze.zzc(zzf(zzgnmVar.zzc().zzg()));
            return zzgokVarZze.zzd();
        } catch (zzgyn e) {
            throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
        }
    }

    public static void zze(zzgmk zzgmkVar) {
        zzgmkVar.zzi(zzc);
        zzgmkVar.zzh(zzd);
        zzgmkVar.zzg(zze);
        zzgmkVar.zzf(zzf);
    }

    private static zzgol zzf(zzgtz zzgtzVar) throws GeneralSecurityException {
        int iOrdinal = zzgtzVar.ordinal();
        if (iOrdinal == 1) {
            return zzgol.zza;
        }
        if (iOrdinal == 2) {
            return zzgol.zzc;
        }
        if (iOrdinal == 3) {
            return zzgol.zzd;
        }
        if (iOrdinal == 4) {
            return zzgol.zzb;
        }
        throw new GeneralSecurityException(k31.k(zzgtzVar.zza(), "Unable to parse OutputPrefixType: "));
    }

    private static zzgqr zzg(zzgon zzgonVar) {
        zzgqq zzgqqVarZzc = zzgqr.zzc();
        zzgqqVarZzc.zza(zzgonVar.zzb());
        return (zzgqr) zzgqqVarZzc.zzbr();
    }

    private static zzgtz zzh(zzgol zzgolVar) throws GeneralSecurityException {
        if (zzgol.zza.equals(zzgolVar)) {
            return zzgtz.TINK;
        }
        if (zzgol.zzb.equals(zzgolVar)) {
            return zzgtz.CRUNCHY;
        }
        if (zzgol.zzd.equals(zzgolVar)) {
            return zzgtz.RAW;
        }
        if (zzgol.zzc.equals(zzgolVar)) {
            return zzgtz.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzgolVar)));
    }
}
