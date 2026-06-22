package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgfd {
    private zzgfp zza = null;
    private zzgvs zzb = null;
    private zzgvs zzc = null;
    private Integer zzd = null;

    private zzgfd() {
    }

    public final zzgfd zza(zzgvs zzgvsVar) {
        this.zzb = zzgvsVar;
        return this;
    }

    public final zzgfd zzb(zzgvs zzgvsVar) {
        this.zzc = zzgvsVar;
        return this;
    }

    public final zzgfd zzc(Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzgfd zzd(zzgfp zzgfpVar) {
        this.zza = zzgfpVar;
        return this;
    }

    public final zzgff zze() throws GeneralSecurityException {
        zzgvr zzgvrVarZzb;
        zzgfp zzgfpVar = this.zza;
        if (zzgfpVar == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        zzgvs zzgvsVar = this.zzb;
        if (zzgvsVar == null || this.zzc == null) {
            throw new GeneralSecurityException("Cannot build without key material");
        }
        if (zzgfpVar.zzb() != zzgvsVar.zza()) {
            throw new GeneralSecurityException("AES key size mismatch");
        }
        if (zzgfpVar.zzc() != this.zzc.zza()) {
            throw new GeneralSecurityException("HMAC key size mismatch");
        }
        if (this.zza.zza() && this.zzd == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzd != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzh() == zzgfn.zzc) {
            zzgvrVarZzb = zzgml.zza;
        } else if (this.zza.zzh() == zzgfn.zzb) {
            zzgvrVarZzb = zzgml.zza(this.zzd.intValue());
        } else {
            if (this.zza.zzh() != zzgfn.zza) {
                throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(this.zza.zzh())));
            }
            zzgvrVarZzb = zzgml.zzb(this.zzd.intValue());
        }
        return new zzgff(this.zza, this.zzb, this.zzc, zzgvrVarZzb, this.zzd, null);
    }

    public /* synthetic */ zzgfd(zzgfc zzgfcVar) {
    }
}
