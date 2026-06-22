package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgot {
    private zzgpg zza = null;
    private zzgvs zzb = null;
    private Integer zzc = null;

    private zzgot() {
    }

    public final zzgot zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgot zzb(zzgvs zzgvsVar) {
        this.zzb = zzgvsVar;
        return this;
    }

    public final zzgot zzc(zzgpg zzgpgVar) {
        this.zza = zzgpgVar;
        return this;
    }

    public final zzgov zzd() throws GeneralSecurityException {
        zzgvs zzgvsVar;
        zzgvr zzgvrVarZza;
        zzgpg zzgpgVar = this.zza;
        if (zzgpgVar == null || (zzgvsVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgpgVar.zzc() != zzgvsVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgpgVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzg() == zzgpe.zzd) {
            zzgvrVarZza = zzgml.zza;
        } else if (this.zza.zzg() == zzgpe.zzc || this.zza.zzg() == zzgpe.zzb) {
            zzgvrVarZza = zzgml.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzg() != zzgpe.zza) {
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(this.zza.zzg())));
            }
            zzgvrVarZza = zzgml.zzb(this.zzc.intValue());
        }
        return new zzgov(this.zza, this.zzb, zzgvrVarZza, this.zzc, null);
    }

    public /* synthetic */ zzgot(zzgos zzgosVar) {
    }
}
