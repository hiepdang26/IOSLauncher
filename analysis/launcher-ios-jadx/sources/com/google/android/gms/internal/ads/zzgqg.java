package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgqg {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgkw zzc;
    private static final zzgkw zzd;
    private static final zzgmt zze;
    private static final zzgmp zzf;
    private static final zzglg zzg;
    private static final zzglc zzh;

    static {
        zzgvr zzgvrVarZzb = zzgoa.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zzgvrVarZzb;
        zzgku zzgkuVarZza = zzgkw.zza();
        zzgkuVarZza.zza(zzgtz.RAW, zzgpe.zzd);
        zzgkuVarZza.zza(zzgtz.TINK, zzgpe.zza);
        zzgkuVarZza.zza(zzgtz.LEGACY, zzgpe.zzc);
        zzgkuVarZza.zza(zzgtz.CRUNCHY, zzgpe.zzb);
        zzc = zzgkuVarZza.zzb();
        zzgku zzgkuVarZza2 = zzgkw.zza();
        zzgkuVarZza2.zza(zzgsi.SHA1, zzgpd.zza);
        zzgkuVarZza2.zza(zzgsi.SHA224, zzgpd.zzb);
        zzgkuVarZza2.zza(zzgsi.SHA256, zzgpd.zzc);
        zzgkuVarZza2.zza(zzgsi.SHA384, zzgpd.zzd);
        zzgkuVarZza2.zza(zzgsi.SHA512, zzgpd.zze);
        zzd = zzgkuVarZza2.zzb();
        zze = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgqc
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgnq zza(zzgen zzgenVar) {
                return zzgqg.zzb((zzgpg) zzgenVar);
            }
        }, zzgpg.class, zzgnm.class);
        zzf = zzgmp.zzb(new zzgmn() { // from class: com.google.android.gms.internal.ads.zzgqd
            @Override // com.google.android.gms.internal.ads.zzgmn
            public final zzgen zza(zzgnq zzgnqVar) {
                return zzgqg.zzd((zzgnm) zzgnqVar);
            }
        }, zzgvrVarZzb, zzgnm.class);
        zzg = zzglg.zzb(new zzgle() { // from class: com.google.android.gms.internal.ads.zzgqe
            @Override // com.google.android.gms.internal.ads.zzgle
            public final zzgnq zza(zzgdy zzgdyVar, zzger zzgerVar) {
                return zzgqg.zza((zzgov) zzgdyVar, zzgerVar);
            }
        }, zzgov.class, zzgnl.class);
        zzh = zzglc.zzb(new zzgla() { // from class: com.google.android.gms.internal.ads.zzgqf
            @Override // com.google.android.gms.internal.ads.zzgla
            public final zzgdy zza(zzgnq zzgnqVar, zzger zzgerVar) {
                return zzgqg.zzc((zzgnl) zzgnqVar, zzgerVar);
            }
        }, zzgvrVarZzb, zzgnl.class);
    }

    public static /* synthetic */ zzgnl zza(zzgov zzgovVar, zzger zzgerVar) {
        zzgsk zzgskVarZzc = zzgsl.zzc();
        zzgskVarZzc.zzb(zzf(zzgovVar.zzb()));
        byte[] bArrZzd = zzgovVar.zzd().zzd(zzgerVar);
        zzgskVarZzc.zza(zzgwm.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzgsl) zzgskVarZzc.zzbr()).zzaN(), zzgsu.SYMMETRIC, (zzgtz) zzc.zzb(zzgovVar.zzb().zzg()), zzgovVar.zze());
    }

    public static /* synthetic */ zzgnm zzb(zzgpg zzgpgVar) {
        zzgsy zzgsyVarZza = zzgsz.zza();
        zzgsyVarZza.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzgsn zzgsnVarZzd = zzgso.zzd();
        zzgsnVarZzd.zzb(zzf(zzgpgVar));
        zzgsnVarZzd.zza(zzgpgVar.zzc());
        zzgsyVarZza.zzc(((zzgso) zzgsnVarZzd.zzbr()).zzaN());
        zzgsyVarZza.zza((zzgtz) zzc.zzb(zzgpgVar.zzg()));
        return zzgnm.zzb((zzgsz) zzgsyVarZza.zzbr());
    }

    public static /* synthetic */ zzgov zzc(zzgnl zzgnlVar, zzger zzgerVar) throws GeneralSecurityException {
        if (!zzgnlVar.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            zzgsl zzgslVarZzf = zzgsl.zzf(zzgnlVar.zze(), zzgxi.zza());
            if (zzgslVarZzf.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgpc zzgpcVarZze = zzgpg.zze();
            zzgpcVarZze.zzb(zzgslVarZzf.zzh().zzd());
            zzgpcVarZze.zzc(zzgslVarZzf.zzg().zza());
            zzgpcVarZze.zza((zzgpd) zzd.zzc(zzgslVarZzf.zzg().zzc()));
            zzgpcVarZze.zzd((zzgpe) zzc.zzc(zzgnlVar.zzc()));
            zzgpg zzgpgVarZze = zzgpcVarZze.zze();
            zzgot zzgotVarZza = zzgov.zza();
            zzgotVarZza.zzc(zzgpgVarZze);
            zzgotVarZza.zzb(zzgvs.zzb(zzgslVarZzf.zzh().zzA(), zzgerVar));
            zzgotVarZza.zza(zzgnlVar.zzf());
            return zzgotVarZza.zzd();
        } catch (zzgyn | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    public static /* synthetic */ zzgpg zzd(zzgnm zzgnmVar) throws GeneralSecurityException {
        if (!zzgnmVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnmVar.zzc().zzi())));
        }
        try {
            zzgso zzgsoVarZzg = zzgso.zzg(zzgnmVar.zzc().zzh(), zzgxi.zza());
            if (zzgsoVarZzg.zzc() != 0) {
                throw new GeneralSecurityException(k31.k(zzgsoVarZzg.zzc(), "Parsing HmacParameters failed: unknown Version "));
            }
            zzgpc zzgpcVarZze = zzgpg.zze();
            zzgpcVarZze.zzb(zzgsoVarZzg.zza());
            zzgpcVarZze.zzc(zzgsoVarZzg.zzh().zza());
            zzgpcVarZze.zza((zzgpd) zzd.zzc(zzgsoVarZzg.zzh().zzc()));
            zzgpcVarZze.zzd((zzgpe) zzc.zzc(zzgnmVar.zzc().zzg()));
            return zzgpcVarZze.zze();
        } catch (zzgyn e) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
        }
    }

    public static void zze(zzgmk zzgmkVar) {
        zzgmkVar.zzi(zze);
        zzgmkVar.zzh(zzf);
        zzgmkVar.zzg(zzg);
        zzgmkVar.zzf(zzh);
    }

    private static zzgsr zzf(zzgpg zzgpgVar) {
        zzgsq zzgsqVarZzd = zzgsr.zzd();
        zzgsqVarZzd.zzb(zzgpgVar.zzb());
        zzgsqVarZzd.zza((zzgsi) zzd.zzb(zzgpgVar.zzf()));
        return (zzgsr) zzgsqVarZzd.zzbr();
    }
}
