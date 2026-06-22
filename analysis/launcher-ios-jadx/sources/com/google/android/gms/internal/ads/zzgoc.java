package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgoc {
    private zzgon zza = null;
    private zzgvs zzb = null;
    private Integer zzc = null;

    private zzgoc() {
    }

    public final zzgoc zza(zzgvs zzgvsVar) {
        this.zzb = zzgvsVar;
        return this;
    }

    public final zzgoc zzb(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgoc zzc(zzgon zzgonVar) {
        this.zza = zzgonVar;
        return this;
    }

    public final zzgoe zzd() throws GeneralSecurityException {
        zzgvs zzgvsVar;
        zzgvr zzgvrVarZza;
        zzgon zzgonVar = this.zza;
        if (zzgonVar == null || (zzgvsVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgonVar.zzc() != zzgvsVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgonVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzf() == zzgol.zzd) {
            zzgvrVarZza = zzgml.zza;
        } else if (this.zza.zzf() == zzgol.zzc || this.zza.zzf() == zzgol.zzb) {
            zzgvrVarZza = zzgml.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzgol.zza) {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(this.zza.zzf())));
            }
            zzgvrVarZza = zzgml.zzb(this.zzc.intValue());
        }
        return new zzgoe(this.zza, this.zzb, zzgvrVarZza, this.zzc, null);
    }

    public /* synthetic */ zzgoc(zzgob zzgobVar) {
    }
}
