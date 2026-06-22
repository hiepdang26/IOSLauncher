package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgok {
    private Integer zza = null;
    private Integer zzb = null;
    private zzgol zzc = zzgol.zzd;

    private zzgok() {
    }

    public final zzgok zza(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i * 8)));
        }
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzgok zzb(int i) throws GeneralSecurityException {
        if (i < 10 || i > 16) {
            throw new GeneralSecurityException(k31.k(i, "Invalid tag size for AesCmacParameters: "));
        }
        this.zzb = Integer.valueOf(i);
        return this;
    }

    public final zzgok zzc(zzgol zzgolVar) {
        this.zzc = zzgolVar;
        return this;
    }

    public final zzgon zzd() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("tag size not set");
        }
        if (this.zzc != null) {
            return new zzgon(num.intValue(), this.zzb.intValue(), this.zzc, null);
        }
        throw new GeneralSecurityException("variant not set");
    }

    public /* synthetic */ zzgok(zzgoj zzgojVar) {
    }
}
