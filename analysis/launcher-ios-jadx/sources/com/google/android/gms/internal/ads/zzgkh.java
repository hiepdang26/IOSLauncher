package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzgkh implements zzgdo {
    private final zzgdo zza;
    private final byte[] zzb;

    private zzgkh(zzgdo zzgdoVar, byte[] bArr) {
        this.zza = zzgdoVar;
        int length = bArr.length;
        if (length != 0 && length != 5) {
            throw new IllegalArgumentException("identifier has an invalid length");
        }
        this.zzb = bArr;
    }

    public static zzgdo zzb(zzglj zzgljVar) throws GeneralSecurityException {
        byte[] bArrZzc;
        zzgnl zzgnlVarZza = zzgljVar.zza(zzgdx.zza());
        zzgst zzgstVarZza = zzgsv.zza();
        zzgstVarZza.zzb(zzgnlVarZza.zzg());
        zzgstVarZza.zzc(zzgnlVarZza.zze());
        zzgstVarZza.zza(zzgnlVarZza.zzb());
        zzgdo zzgdoVar = (zzgdo) zzgeq.zzb((zzgsv) zzgstVarZza.zzbr(), zzgdo.class);
        zzgtz zzgtzVarZzc = zzgnlVarZza.zzc();
        int iOrdinal = zzgtzVarZzc.ordinal();
        if (iOrdinal == 1) {
            bArrZzc = zzgml.zzb(zzgljVar.zzb().intValue()).zzc();
        } else if (iOrdinal == 2) {
            bArrZzc = zzgml.zza(zzgljVar.zzb().intValue()).zzc();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type ".concat(String.valueOf(zzgtzVarZzc)));
            }
            bArrZzc = zzgml.zza(zzgljVar.zzb().intValue()).zzc();
        } else {
            bArrZzc = zzgml.zza.zzc();
        }
        return new zzgkh(zzgdoVar, bArrZzc);
    }

    public static zzgdo zzc(zzgdo zzgdoVar, zzgvr zzgvrVar) {
        return new zzgkh(zzgdoVar, zzgvrVar.zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzgoa.zzc(bArr3, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }
}
