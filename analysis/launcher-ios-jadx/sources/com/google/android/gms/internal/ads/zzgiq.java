package com.google.android.gms.internal.ads;

import defpackage.k31;
import defpackage.uo;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgiq extends zzgew {
    private final zzgiw zza;
    private final zzgvs zzb;
    private final zzgvr zzc;
    private final Integer zzd;

    private zzgiq(zzgiw zzgiwVar, zzgvs zzgvsVar, zzgvr zzgvrVar, Integer num) {
        this.zza = zzgiwVar;
        this.zzb = zzgvsVar;
        this.zzc = zzgvrVar;
        this.zzd = num;
    }

    public static zzgiq zza(zzgiv zzgivVar, zzgvs zzgvsVar, Integer num) throws GeneralSecurityException {
        zzgvr zzgvrVarZzb;
        zzgiv zzgivVar2 = zzgiv.zzc;
        if (zzgivVar != zzgivVar2 && num == null) {
            throw new GeneralSecurityException(uo.t("For given Variant ", zzgivVar.toString(), " the value of idRequirement must be non-null"));
        }
        if (zzgivVar == zzgivVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzgvsVar.zza() != 32) {
            throw new GeneralSecurityException(k31.k(zzgvsVar.zza(), "XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not "));
        }
        zzgiw zzgiwVarZzc = zzgiw.zzc(zzgivVar);
        if (zzgiwVarZzc.zzb() == zzgivVar2) {
            zzgvrVarZzb = zzgml.zza;
        } else if (zzgiwVarZzc.zzb() == zzgiv.zzb) {
            zzgvrVarZzb = zzgml.zza(num.intValue());
        } else {
            if (zzgiwVarZzc.zzb() != zzgiv.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzgiwVarZzc.zzb().toString()));
            }
            zzgvrVarZzb = zzgml.zzb(num.intValue());
        }
        return new zzgiq(zzgiwVarZzc, zzgvsVar, zzgvrVarZzb, num);
    }

    public final zzgiw zzb() {
        return this.zza;
    }

    public final zzgvr zzc() {
        return this.zzc;
    }

    public final zzgvs zzd() {
        return this.zzb;
    }

    public final Integer zze() {
        return this.zzd;
    }
}
