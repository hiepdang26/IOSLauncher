package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzghp extends zzgew {
    private final zzghr zza;
    private final zzgvr zzb;
    private final Integer zzc;

    private zzghp(zzghr zzghrVar, zzgvr zzgvrVar, Integer num) {
        this.zza = zzghrVar;
        this.zzb = zzgvrVar;
        this.zzc = num;
    }

    public static zzghp zza(zzghr zzghrVar, Integer num) throws GeneralSecurityException {
        zzgvr zzgvrVarZzb;
        if (zzghrVar.zzb() == zzghq.zza) {
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzgvrVarZzb = zzgvr.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        } else {
            if (zzghrVar.zzb() != zzghq.zzb) {
                throw new GeneralSecurityException("Unknown Variant: ".concat(zzghrVar.zzb().toString()));
            }
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzgvrVarZzb = zzgvr.zzb(new byte[0]);
        }
        return new zzghp(zzghrVar, zzgvrVarZzb, num);
    }

    public final zzghr zzb() {
        return this.zza;
    }

    public final zzgvr zzc() {
        return this.zzb;
    }

    public final Integer zzd() {
        return this.zzc;
    }
}
