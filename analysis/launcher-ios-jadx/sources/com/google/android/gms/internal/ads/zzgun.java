package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class zzgun implements zzgdo {
    private static final ThreadLocal zza = new zzgul();
    private static final ThreadLocal zzb = new zzgum();
    private final byte[] zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final SecretKeySpec zzf;
    private final int zzg;

    private zzgun(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        if (!zzgkr.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zzg = i;
        zzgvp.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zzf = secretKeySpec;
        Cipher cipher = (Cipher) zza.get();
        cipher.init(1, secretKeySpec);
        byte[] bArrZzc = zzc(cipher.doFinal(new byte[16]));
        this.zzc = bArrZzc;
        this.zzd = zzc(bArrZzc);
        this.zze = bArr2;
    }

    public static zzgdo zzb(zzgft zzgftVar) throws GeneralSecurityException {
        if (!zzgkr.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        zzgftVar.zzb();
        return new zzgun(zzgftVar.zzd().zzd(zzgdx.zza()), zzgftVar.zzb().zzb(), zzgftVar.zzc().zzc());
    }

    private static byte[] zzc(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            byte b = bArr[i];
            int i2 = i + 1;
            bArr2[i] = (byte) (((b + b) ^ ((bArr[i2] & 255) >>> 7)) & 255);
            i = i2;
        }
        byte b2 = bArr[15];
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (b2 + b2));
        return bArr2;
    }

    private final byte[] zzd(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws BadPaddingException, IllegalBlockSizeException {
        int length;
        byte[] bArrZzf;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(zzf(bArr2, this.zzc));
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        int i4 = 0;
        int i5 = 0;
        while (i3 - i5 > 16) {
            for (int i6 = 0; i6 < 16; i6++) {
                bArrDoFinal[i6] = (byte) (bArr[(i2 + i5) + i6] ^ bArrDoFinal[i6]);
            }
            bArrDoFinal = cipher.doFinal(bArrDoFinal);
            i5 += 16;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i5 + i2, i2 + i3);
        if (bArrCopyOfRange.length == 16) {
            bArrZzf = zzf(bArrCopyOfRange, this.zzc);
        } else {
            byte[] bArrCopyOf = Arrays.copyOf(this.zzd, 16);
            while (true) {
                length = bArrCopyOfRange.length;
                if (i4 >= length) {
                    break;
                }
                bArrCopyOf[i4] = (byte) (bArrCopyOf[i4] ^ bArrCopyOfRange[i4]);
                i4++;
            }
            bArrCopyOf[length] = (byte) (bArrCopyOf[length] ^ 128);
            bArrZzf = bArrCopyOf;
        }
        return cipher.doFinal(zzf(bArrDoFinal, bArrZzf));
    }

    private final byte[] zze(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = (length - this.zzg) - 16;
        if (i < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        Cipher cipher = (Cipher) zza.get();
        cipher.init(1, this.zzf);
        byte[] bArrZzd = zzd(cipher, 0, bArr, 0, this.zzg);
        byte[] bArr3 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrZzd2 = zzd(cipher, 1, bArr3, 0, bArr3.length);
        byte[] bArrZzd3 = zzd(cipher, 2, bArr, this.zzg, i);
        int i2 = length - 16;
        byte b = 0;
        for (int i3 = 0; i3 < 16; i3++) {
            b = (byte) (b | (((bArr[i2 + i3] ^ bArrZzd2[i3]) ^ bArrZzd[i3]) ^ bArrZzd3[i3]));
        }
        if (b != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = (Cipher) zzb.get();
        cipher2.init(1, this.zzf, new IvParameterSpec(bArrZzd));
        return cipher2.doFinal(bArr, this.zzg, i);
    }

    private static byte[] zzf(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zze;
        if (bArr3.length == 0) {
            return zze(bArr, bArr2);
        }
        if (!zzgoa.zzc(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArr4 = this.zze;
        return zze(Arrays.copyOfRange(bArr, bArr4.length, bArr.length), bArr2);
    }
}
