package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class zzgur implements zzgdo {
    private final zzgvj zza;
    private final zzgem zzb;
    private final int zzc;
    private final byte[] zzd;

    private zzgur(zzgvj zzgvjVar, zzgem zzgemVar, int i, byte[] bArr) {
        this.zza = zzgvjVar;
        this.zzb = zzgemVar;
        this.zzc = i;
        this.zzd = bArr;
    }

    public static zzgdo zzb(zzgff zzgffVar) {
        zzguk zzgukVar = new zzguk(zzgffVar.zzd().zzd(zzgdx.zza()), zzgffVar.zzb().zzd());
        String strValueOf = String.valueOf(zzgffVar.zzb().zzg());
        return new zzgur(zzgukVar, new zzgvo(new zzgvn("HMAC".concat(strValueOf), new SecretKeySpec(zzgffVar.zze().zzd(zzgdx.zza()), "HMAC")), zzgffVar.zzb().zze()), zzgffVar.zzb().zze(), zzgffVar.zzc().zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzd;
        int i = this.zzc;
        int length = bArr3.length;
        int length2 = bArr.length;
        if (length2 < i + length) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        }
        if (!zzgoa.zzc(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, this.zzd.length, length2 - this.zzc);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, length2 - this.zzc, length2);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        if (MessageDigest.isEqual(((zzgvo) this.zzb).zzc(zzgup.zzb(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8))), bArrCopyOfRange2)) {
            return this.zza.zza(bArrCopyOfRange);
        }
        throw new GeneralSecurityException("invalid MAC");
    }
}
