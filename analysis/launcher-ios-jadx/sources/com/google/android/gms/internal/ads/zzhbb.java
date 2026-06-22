package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
abstract class zzhbb {
    public static final String zzc(ByteBuffer byteBuffer, int i, int i2) throws zzgyn {
        int i3;
        if ((((byteBuffer.limit() - i) - i2) | i | i2) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i4 = i + i2;
        char[] cArr = new char[i2];
        int i5 = 0;
        while (i < i4) {
            byte b = byteBuffer.get(i);
            if (!zzhba.zzd(b)) {
                break;
            }
            i++;
            cArr[i5] = (char) b;
            i5++;
        }
        int i6 = i5;
        while (i < i4) {
            int i7 = i + 1;
            byte b2 = byteBuffer.get(i);
            if (zzhba.zzd(b2)) {
                cArr[i6] = (char) b2;
                i6++;
                i = i7;
                while (i < i4) {
                    byte b3 = byteBuffer.get(i);
                    if (zzhba.zzd(b3)) {
                        i++;
                        cArr[i6] = (char) b3;
                        i6++;
                    }
                }
            } else {
                if (zzhba.zzf(b2)) {
                    if (i7 >= i4) {
                        throw zzgyn.zzd();
                    }
                    i3 = i6 + 1;
                    i += 2;
                    zzhba.zzc(b2, byteBuffer.get(i7), cArr, i6);
                } else if (zzhba.zze(b2)) {
                    if (i7 >= i4 - 1) {
                        throw zzgyn.zzd();
                    }
                    i3 = i6 + 1;
                    int i8 = i + 2;
                    i += 3;
                    zzhba.zzb(b2, byteBuffer.get(i7), byteBuffer.get(i8), cArr, i6);
                } else {
                    if (i7 >= i4 - 2) {
                        throw zzgyn.zzd();
                    }
                    byte b4 = byteBuffer.get(i7);
                    int i9 = i + 3;
                    byte b5 = byteBuffer.get(i + 2);
                    i += 4;
                    zzhba.zza(b2, b4, b5, byteBuffer.get(i9), cArr, i6);
                    i6 += 2;
                }
                i6 = i3;
            }
        }
        return new String(cArr, 0, i6);
    }

    public abstract int zza(int i, byte[] bArr, int i2, int i3);

    public abstract String zzb(byte[] bArr, int i, int i2);
}
