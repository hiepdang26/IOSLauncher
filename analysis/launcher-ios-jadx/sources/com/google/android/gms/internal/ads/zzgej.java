package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzgej {
    private final zzgth zza;
    private final List zzb;
    private final zzgln zzc;

    public /* synthetic */ zzgej(zzgth zzgthVar, List list, zzgln zzglnVar, zzgei zzgeiVar) {
        this.zza = zzgthVar;
        this.zzb = list;
        this.zzc = zzglnVar;
    }

    public static final zzgej zza(zzgth zzgthVar) throws GeneralSecurityException {
        zzh(zzgthVar);
        return new zzgej(zzgthVar, zzg(zzgthVar));
    }

    public static final zzgej zzb(zzgen zzgenVar) {
        zzgef zzgefVar = new zzgef();
        zzged zzgedVar = new zzged(zzgenVar, null);
        zzgedVar.zzd();
        zzgedVar.zzc();
        zzgefVar.zza(zzgedVar);
        return zzgefVar.zzb();
    }

    private final Object zzf(zzgkx zzgkxVar, Class cls, Class cls2) throws GeneralSecurityException {
        int i = zzgeu.zza;
        zzgth zzgthVar = this.zza;
        int iZzc = zzgthVar.zzc();
        int i2 = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzgtg zzgtgVar : zzgthVar.zzh()) {
            if (zzgtgVar.zzk() == 3) {
                if (!zzgtgVar.zzj()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzgtgVar.zza())));
                }
                if (zzgtgVar.zzf() == zzgtz.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzgtgVar.zza())));
                }
                if (zzgtgVar.zzk() == 2) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzgtgVar.zza())));
                }
                if (zzgtgVar.zza() == iZzc) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                z2 &= zzgtgVar.zzc().zzc() == zzgsu.ASYMMETRIC_PUBLIC;
                i2++;
            }
        }
        if (i2 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        zzgnf zzgnfVarZzb = zzgnj.zzb(cls2);
        zzgnfVarZzb.zzc(this.zzc);
        for (int i3 = 0; i3 < this.zzb.size(); i3++) {
            zzgtg zzgtgVarZze = this.zza.zze(i3);
            if (zzgtgVarZze.zzk() == 3) {
                zzgeh zzgehVar = (zzgeh) this.zzb.get(i3);
                if (zzgehVar == null) {
                    throw new GeneralSecurityException("Key parsing of key with index " + i3 + " and type_url " + zzgtgVarZze.zzc().zzg() + " failed, unable to get primitive");
                }
                zzgdy zzgdyVarZza = zzgehVar.zza();
                try {
                    Object objZzc = zzgmh.zza().zzc(zzgdyVarZza, cls2);
                    if (zzgtgVarZze.zza() == this.zza.zzc()) {
                        zzgnfVarZzb.zzb(objZzc, zzgdyVarZza, zzgtgVarZze);
                    } else {
                        zzgnfVarZzb.zza(objZzc, zzgdyVarZza, zzgtgVarZze);
                    }
                } catch (GeneralSecurityException e) {
                    throw new GeneralSecurityException("Unable to get primitive " + cls2.toString() + " for key of type " + zzgtgVarZze.zzc().zzg() + ", see https://developers.google.com/tink/faq/registration_errors", e);
                }
            }
        }
        zzgnj zzgnjVarZzd = zzgnfVarZzb.zzd();
        int i4 = zzgeq.zza;
        return zzgmh.zza().zzd(zzgnjVarZzd, cls);
    }

    private static List zzg(zzgth zzgthVar) {
        zzgdy zzgljVar;
        int iZzk;
        zzgea zzgeaVar;
        ArrayList arrayList = new ArrayList(zzgthVar.zza());
        for (zzgtg zzgtgVar : zzgthVar.zzh()) {
            int iZza = zzgtgVar.zza();
            try {
                zzgnl zzgnlVarZza = zzgnl.zza(zzgtgVar.zzc().zzg(), zzgtgVar.zzc().zzf(), zzgtgVar.zzc().zzc(), zzgtgVar.zzf(), zzgtgVar.zzf() == zzgtz.RAW ? null : Integer.valueOf(zzgtgVar.zza()));
                zzgmk zzgmkVarZzc = zzgmk.zzc();
                zzger zzgerVarZza = zzger.zza();
                zzgljVar = !zzgmkVarZzc.zzj(zzgnlVarZza) ? new zzglj(zzgnlVarZza, zzgerVarZza) : zzgmkVarZzc.zza(zzgnlVarZza, zzgerVarZza);
                iZzk = zzgtgVar.zzk() - 2;
            } catch (GeneralSecurityException unused) {
                arrayList.add(null);
            }
            if (iZzk == 1) {
                zzgeaVar = zzgea.zza;
            } else if (iZzk == 2) {
                zzgeaVar = zzgea.zzb;
            } else {
                if (iZzk != 3) {
                    throw new GeneralSecurityException("Unknown key status");
                }
                zzgeaVar = zzgea.zzc;
            }
            arrayList.add(new zzgeh(zzgljVar, zzgeaVar, iZza, iZza == zzgthVar.zzc(), null));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzh(zzgth zzgthVar) throws GeneralSecurityException {
        if (zzgthVar == null || zzgthVar.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public final String toString() {
        int i = zzgeu.zza;
        zzgtj zzgtjVarZza = zzgtm.zza();
        zzgth zzgthVar = this.zza;
        zzgtjVarZza.zzb(zzgthVar.zzc());
        for (zzgtg zzgtgVar : zzgthVar.zzh()) {
            zzgtk zzgtkVarZza = zzgtl.zza();
            zzgtkVarZza.zzc(zzgtgVar.zzc().zzg());
            zzgtkVarZza.zzd(zzgtgVar.zzk());
            zzgtkVarZza.zzb(zzgtgVar.zzf());
            zzgtkVarZza.zza(zzgtgVar.zza());
            zzgtjVarZza.zza((zzgtl) zzgtkVarZza.zzbr());
        }
        return ((zzgtm) zzgtjVarZza.zzbr()).toString();
    }

    public final zzgth zzc() {
        return this.zza;
    }

    public final Object zzd(zzgds zzgdsVar, Class cls) throws GeneralSecurityException {
        Class clsZza = zzgeq.zza(cls);
        if (clsZza != null) {
            return zzf((zzgkx) zzgdsVar, cls, clsZza);
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.getName()));
    }

    private zzgej(zzgth zzgthVar, List list) {
        this.zza = zzgthVar;
        this.zzb = list;
        this.zzc = zzgln.zza;
    }
}
