package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes.dex */
public final class zzggl {
    private Integer zza = null;
    private Integer zzb = null;
    private Integer zzc = null;
    private zzggm zzd = zzggm.zzc;

    private zzggl() {
    }

    public final zzggl zza(int i) {
        this.zzb = 12;
        return this;
    }

    public final zzggl zzb(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 24 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
        }
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzggl zzc(int i) {
        this.zzc = 16;
        return this;
    }

    public final zzggl zzd(zzggm zzggmVar) {
        this.zzd = zzggmVar;
        return this;
    }

    public final zzggo zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("Tag size is not set");
        }
        int iIntValue = num.intValue();
        this.zzb.getClass();
        this.zzc.getClass();
        return new zzggo(iIntValue, 12, 16, this.zzd, null);
    }

    public /* synthetic */ zzggl(zzggk zzggkVar) {
    }
}
