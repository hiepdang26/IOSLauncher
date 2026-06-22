package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgqh implements zzgem {
    private zzgqh(zzgem zzgemVar, zzgtz zzgtzVar, byte[] bArr) {
    }

    public static zzgem zza(zzglj zzgljVar) throws GeneralSecurityException {
        byte[] bArrZzc;
        zzgnl zzgnlVarZza = zzgljVar.zza(zzgdx.zza());
        zzgst zzgstVarZza = zzgsv.zza();
        zzgstVarZza.zzb(zzgnlVarZza.zzg());
        zzgstVarZza.zzc(zzgnlVarZza.zze());
        zzgstVarZza.zza(zzgnlVarZza.zzb());
        zzgem zzgemVar = (zzgem) zzgeq.zzb((zzgsv) zzgstVarZza.zzbr(), zzgem.class);
        zzgtz zzgtzVarZzc = zzgnlVarZza.zzc();
        int iOrdinal = zzgtzVarZzc.ordinal();
        if (iOrdinal == 1) {
            bArrZzc = zzgml.zzb(zzgljVar.zzb().intValue()).zzc();
        } else if (iOrdinal == 2) {
            bArrZzc = zzgml.zza(zzgljVar.zzb().intValue()).zzc();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrZzc = zzgml.zza(zzgljVar.zzb().intValue()).zzc();
        } else {
            bArrZzc = zzgml.zza.zzc();
        }
        return new zzgqh(zzgemVar, zzgtzVarZzc, bArrZzc);
    }
}
