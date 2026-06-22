package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzggq {
    private zzghb zza = null;
    private zzgvs zzb = null;
    private Integer zzc = null;

    private zzggq() {
    }

    public final zzggq zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzggq zzb(zzgvs zzgvsVar) {
        this.zzb = zzgvsVar;
        return this;
    }

    public final zzggq zzc(zzghb zzghbVar) {
        this.zza = zzghbVar;
        return this;
    }

    public final zzggs zzd() throws GeneralSecurityException {
        zzgvs zzgvsVar;
        zzgvr zzgvrVarZzb;
        zzghb zzghbVar = this.zza;
        if (zzghbVar == null || (zzgvsVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzghbVar.zzb() != zzgvsVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzghbVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzggz.zzc) {
            zzgvrVarZzb = zzgml.zza;
        } else if (this.zza.zzd() == zzggz.zzb) {
            zzgvrVarZzb = zzgml.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzggz.zza) {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
            }
            zzgvrVarZzb = zzgml.zzb(this.zzc.intValue());
        }
        return new zzggs(this.zza, this.zzb, zzgvrVarZzb, this.zzc, null);
    }

    public /* synthetic */ zzggq(zzggp zzggpVar) {
    }
}
