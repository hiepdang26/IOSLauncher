package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzgvq implements zzgdo {
    private final zzgkg zza;
    private final byte[] zzb;

    private zzgvq(byte[] bArr, byte[] bArr2) {
        this.zza = new zzgkg(bArr);
        this.zzb = bArr2;
    }

    public static zzgdo zzb(zzgiq zzgiqVar) {
        return new zzgvq(zzgiqVar.zzd().zzd(zzgdx.zza()), zzgiqVar.zzc().zzc());
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length < 40) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return this.zza.zzb(ByteBuffer.wrap(bArr, 24, length - 24), Arrays.copyOf(bArr, 24), bArr2);
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return zzc(bArr, bArr2);
        }
        if (!zzgoa.zzc(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArr4 = this.zzb;
        return zzc(Arrays.copyOfRange(bArr, bArr4.length, bArr.length), bArr2);
    }
}
