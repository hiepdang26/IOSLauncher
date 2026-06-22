package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzghx extends zzgew {
    private final zzgid zza;
    private final zzgvr zzb;
    private final Integer zzc;

    private zzghx(zzgid zzgidVar, zzgvr zzgvrVar, Integer num) {
        this.zza = zzgidVar;
        this.zzb = zzgvrVar;
        this.zzc = num;
    }

    public static zzghx zza(zzgid zzgidVar, Integer num) throws GeneralSecurityException {
        zzgvr zzgvrVarZzb;
        if (zzgidVar.zzc() == zzgib.zzb) {
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzgvrVarZzb = zzgml.zza;
        } else {
            if (zzgidVar.zzc() != zzgib.zza) {
                throw new GeneralSecurityException("Unknown Variant: ".concat(String.valueOf(zzgidVar.zzc())));
            }
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzgvrVarZzb = zzgml.zzb(num.intValue());
        }
        return new zzghx(zzgidVar, zzgvrVarZzb, num);
    }

    public final zzgid zzb() {
        return this.zza;
    }

    public final zzgvr zzc() {
        return this.zzb;
    }

    public final Integer zzd() {
        return this.zzc;
    }
}
