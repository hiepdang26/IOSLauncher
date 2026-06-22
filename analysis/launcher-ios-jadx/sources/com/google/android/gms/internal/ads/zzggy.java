package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes.dex */
public final class zzggy {
    private Integer zza = null;
    private zzggz zzb = zzggz.zzc;

    private zzggy() {
    }

    public final zzggy zza(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
        }
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzggy zzb(zzggz zzggzVar) {
        this.zzb = zzggzVar;
        return this;
    }

    public final zzghb zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.zzb != null) {
            return new zzghb(num.intValue(), this.zzb, null);
        }
        throw new GeneralSecurityException("Variant is not set");
    }

    public /* synthetic */ zzggy(zzggx zzggxVar) {
    }
}
