package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgup {
    public static final void zza(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        if (i < 0 || byteBuffer2.remaining() < i || byteBuffer3.remaining() < i || byteBuffer.remaining() < i) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i2 = 0; i2 < i; i2++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static byte[] zzb(byte[]... bArr) throws GeneralSecurityException {
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= bArr.length) {
                byte[] bArr2 = new byte[i2];
                int i3 = 0;
                for (byte[] bArr3 : bArr) {
                    int length = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i3, length);
                    i3 += length;
                }
                return bArr2;
            }
            int length2 = bArr[i].length;
            if (i2 > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - length2) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            i2 += length2;
            i++;
        }
    }

    public static final byte[] zzc(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length == bArr2.length) {
            return zzd(bArr, 0, bArr2, 0, length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    public static final byte[] zzd(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr.length - i3 < i || bArr2.length - i3 < i2) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            bArr3[i4] = (byte) (bArr[i4 + i] ^ bArr2[i4 + i2]);
        }
        return bArr3;
    }
}
