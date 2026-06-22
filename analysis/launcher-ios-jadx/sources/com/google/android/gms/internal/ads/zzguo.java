package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class zzguo implements zzgdo {
    private final SecretKey zza;
    private final byte[] zzb;

    private zzguo(byte[] bArr, zzgvr zzgvrVar) throws GeneralSecurityException {
        if (!zzgkr.zza(2)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzgvp.zza(bArr.length);
        this.zza = new SecretKeySpec(bArr, "AES");
        this.zzb = zzgvrVar.zzc();
    }

    public static zzgdo zzb(zzggf zzggfVar) {
        zzggfVar.zzb();
        zzggfVar.zzb();
        return new zzguo(zzggfVar.zzd().zzd(zzgdx.zza()), zzggfVar.zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        byte[] bArr3 = this.zzb;
        if (bArr.length < bArr3.length + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzgoa.zzc(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArr4 = new byte[12];
        System.arraycopy(bArr, this.zzb.length, bArr4, 0, 12);
        int i = zzgka.zza;
        Objects.equals(System.getProperty("java.vendor"), "The Android Project");
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr4, 0, 12);
        SecretKey secretKey = this.zza;
        Cipher cipherZza = zzgka.zza();
        cipherZza.init(2, secretKey, gCMParameterSpec);
        if (bArr2 != null && bArr2.length != 0) {
            cipherZza.updateAAD(bArr2);
        }
        return cipherZza.doFinal(bArr, 12 + this.zzb.length, (r2 - r8) - 12);
    }
}
