package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzggd {
    private zzggo zza = null;
    private zzgvs zzb = null;
    private Integer zzc = null;

    private zzggd() {
    }

    public final zzggd zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzggd zzb(zzgvs zzgvsVar) {
        this.zzb = zzgvsVar;
        return this;
    }

    public final zzggd zzc(zzggo zzggoVar) {
        this.zza = zzggoVar;
        return this;
    }

    public final zzggf zzd() throws GeneralSecurityException {
        zzgvs zzgvsVar;
        zzgvr zzgvrVarZzb;
        zzggo zzggoVar = this.zza;
        if (zzggoVar == null || (zzgvsVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzggoVar.zzb() != zzgvsVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzggoVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzggm.zzc) {
            zzgvrVarZzb = zzgml.zza;
        } else if (this.zza.zzd() == zzggm.zzb) {
            zzgvrVarZzb = zzgml.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzggm.zza) {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
            }
            zzgvrVarZzb = zzgml.zzb(this.zzc.intValue());
        }
        return new zzggf(this.zza, this.zzb, zzgvrVarZzb, this.zzc, null);
    }

    public /* synthetic */ zzggd(zzggc zzggcVar) {
    }
}
