package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class zzgkj implements zzgdo {
    private final byte[] zza;
    private final byte[] zzb;

    private zzgkj(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!zzgkr.zza(1)) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        if (!zzc()) {
            throw new GeneralSecurityException("JCE does not support algorithm: ChaCha20-Poly1305");
        }
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zza = bArr;
        this.zzb = bArr2;
    }

    public static zzgdo zzb(zzgiq zzgiqVar) {
        return new zzgkj(zzgiqVar.zzd().zzd(zzgdx.zza()), zzgiqVar.zzc().zzc());
    }

    public static boolean zzc() {
        return zzgjs.zzc() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        byte[] bArr3 = this.zzb;
        if (bArr.length < bArr3.length + 40) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzgoa.zzc(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArr4 = new byte[24];
        System.arraycopy(bArr, this.zzb.length, bArr4, 0, 24);
        int[] iArrZzd = zzgjy.zzd(zzgjy.zze(this.zza), zzgjy.zze(bArr4));
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(iArrZzd.length * 4).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrZzd);
        SecretKeySpec secretKeySpec = new SecretKeySpec(byteBufferOrder.array(), "ChaCha20");
        byte[] bArr5 = new byte[12];
        System.arraycopy(bArr4, 16, bArr5, 4, 8);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr5);
        Cipher cipherZzc = zzgjs.zzc();
        cipherZzc.init(2, secretKeySpec, ivParameterSpec);
        if (bArr2 != null && bArr2.length != 0) {
            cipherZzc.updateAAD(bArr2);
        }
        return cipherZzc.doFinal(bArr, this.zzb.length + 24, (r1 - r10) - 24);
    }
}
