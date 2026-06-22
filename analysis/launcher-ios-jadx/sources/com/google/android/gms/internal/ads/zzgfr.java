package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgfr {
    private zzggb zza = null;
    private zzgvs zzb = null;
    private Integer zzc = null;

    private zzgfr() {
    }

    public final zzgfr zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgfr zzb(zzgvs zzgvsVar) {
        this.zzb = zzgvsVar;
        return this;
    }

    public final zzgfr zzc(zzggb zzggbVar) {
        this.zza = zzggbVar;
        return this;
    }

    public final zzgft zzd() throws GeneralSecurityException {
        zzgvs zzgvsVar;
        zzgvr zzgvrVarZzb;
        zzggb zzggbVar = this.zza;
        if (zzggbVar == null || (zzgvsVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzggbVar.zzc() != zzgvsVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzggbVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zze() == zzgfz.zzc) {
            zzgvrVarZzb = zzgml.zza;
        } else if (this.zza.zze() == zzgfz.zzb) {
            zzgvrVarZzb = zzgml.zza(this.zzc.intValue());
        } else {
            if (this.zza.zze() != zzgfz.zza) {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(this.zza.zze())));
            }
            zzgvrVarZzb = zzgml.zzb(this.zzc.intValue());
        }
        return new zzgft(this.zza, this.zzb, zzgvrVarZzb, this.zzc, null);
    }

    public /* synthetic */ zzgfr(zzgfq zzgfqVar) {
    }
}
