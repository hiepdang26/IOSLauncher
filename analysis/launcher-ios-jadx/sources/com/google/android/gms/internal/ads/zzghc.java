package com.google.android.gms.internal.ads;

import defpackage.k31;
import defpackage.uo;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzghc extends zzgew {
    private final zzghh zza;
    private final zzgvs zzb;
    private final zzgvr zzc;
    private final Integer zzd;

    private zzghc(zzghh zzghhVar, zzgvs zzgvsVar, zzgvr zzgvrVar, Integer num) {
        this.zza = zzghhVar;
        this.zzb = zzgvsVar;
        this.zzc = zzgvrVar;
        this.zzd = num;
    }

    public static zzghc zza(zzghg zzghgVar, zzgvs zzgvsVar, Integer num) throws GeneralSecurityException {
        zzgvr zzgvrVarZzb;
        zzghg zzghgVar2 = zzghg.zzc;
        if (zzghgVar != zzghgVar2 && num == null) {
            throw new GeneralSecurityException(uo.t("For given Variant ", zzghgVar.toString(), " the value of idRequirement must be non-null"));
        }
        if (zzghgVar == zzghgVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzgvsVar.zza() != 32) {
            throw new GeneralSecurityException(k31.k(zzgvsVar.zza(), "ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not "));
        }
        zzghh zzghhVarZzc = zzghh.zzc(zzghgVar);
        if (zzghhVarZzc.zzb() == zzghgVar2) {
            zzgvrVarZzb = zzgml.zza;
        } else if (zzghhVarZzc.zzb() == zzghg.zzb) {
            zzgvrVarZzb = zzgml.zza(num.intValue());
        } else {
            if (zzghhVarZzc.zzb() != zzghg.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzghhVarZzc.zzb().toString()));
            }
            zzgvrVarZzb = zzgml.zzb(num.intValue());
        }
        return new zzghc(zzghhVarZzc, zzgvsVar, zzgvrVarZzb, num);
    }

    public final zzghh zzb() {
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
