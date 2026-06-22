package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzgfa implements zzgdo {
    private final zzgnj zza;

    public /* synthetic */ zzgfa(zzgnj zzgnjVar, zzgez zzgezVar) {
        this.zza = zzgnjVar;
        if (zzgnjVar.zzg()) {
            zzglp zzglpVarZza = zzgmf.zzb().zza();
            zzglu zzgluVarZza = zzglx.zza(zzgnjVar);
            zzglpVarZza.zza(zzgluVarZza, "aead", "encrypt");
            zzglpVarZza.zza(zzgluVarZza, "aead", "decrypt");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 5) {
            for (zzgnh zzgnhVar : this.zza.zzf(Arrays.copyOf(bArr, 5))) {
                try {
                    byte[] bArrZza = ((zzgdo) zzgnhVar.zzd()).zza(bArr, bArr2);
                    zzgnhVar.zza();
                    return bArrZza;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzgnh zzgnhVar2 : this.zza.zzf(zzgdt.zza)) {
            try {
                byte[] bArrZza2 = ((zzgdo) zzgnhVar2.zzd()).zza(bArr, bArr2);
                zzgnhVar2.zza();
                return bArrZza2;
            } catch (GeneralSecurityException unused2) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
