package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzghl implements zzgdo {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = new byte[0];
    private static final Set zzc;
    private final String zzd;
    private final zzgdo zze;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzc = Collections.unmodifiableSet(hashSet);
    }

    @Deprecated
    public zzghl(zzgsz zzgszVar, zzgdo zzgdoVar) throws GeneralSecurityException {
        if (!zzc.contains(zzgszVar.zzi())) {
            throw new IllegalArgumentException(uo.t("Unsupported DEK key type: ", zzgszVar.zzi(), ". Only Tink AEAD key types are supported."));
        }
        this.zzd = zzgszVar.zzi();
        zzgsy zzgsyVarZzc = zzgsz.zzc(zzgszVar);
        zzgsyVarZzc.zza(zzgtz.RAW);
        zzget.zza(((zzgsz) zzgsyVarZzc.zzbr()).zzaV());
        this.zze = zzgdoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i = byteBufferWrap.getInt();
            if (i <= 0 || i > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i];
            byteBufferWrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            byte[] bArrZza = this.zze.zza(bArr3, zzb);
            String str = this.zzd;
            zzgwm zzgwmVar = zzgwm.zzb;
            return ((zzgdo) zzgmh.zza().zzc(zzgmk.zzc().zza(zzgnl.zza(str, zzgwm.zzv(bArrZza, 0, bArrZza.length), zzgsu.SYMMETRIC, zzgtz.RAW, null), zzgdx.zza()), zzgdo.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException e) {
            e = e;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (NegativeArraySizeException e2) {
            e = e2;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (BufferUnderflowException e3) {
            e = e3;
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }
}
