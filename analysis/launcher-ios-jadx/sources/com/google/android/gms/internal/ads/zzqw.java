package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzqw {
    private static final byte[] zza = {79, 103, 103, 83, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, -43, -59, -9, 1, 19, 79, 112, 117, 115, 72, 101, 97, 100, 1, 2, 56, 1, -128, -69, 0, 0, 0, 0, 0};
    private static final byte[] zzb = {79, 103, 103, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 11, -103, 87, 83, 1, 16, 79, 112, 117, 115, 84, 97, 103, 115, 0, 0, 0, 0, 0, 0, 0, 0};
    private ByteBuffer zzc = zzct.zza;
    private int zze = 0;
    private int zzd = 2;

    private static final void zzc(ByteBuffer byteBuffer, long j, int i, int i2, boolean z) {
        byteBuffer.put((byte) 79);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 83);
        byteBuffer.put((byte) 0);
        byteBuffer.put(true != z ? (byte) 0 : (byte) 2);
        byteBuffer.putLong(j);
        byteBuffer.putInt(0);
        byteBuffer.putInt(i);
        byteBuffer.putInt(0);
        byteBuffer.put(zzgas.zza(i2));
    }

    public final void zza(zzhd zzhdVar, List list) {
        int length;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2 = zzhdVar.zzc;
        byteBuffer2.getClass();
        if (byteBuffer2.limit() - zzhdVar.zzc.position() == 0) {
            return;
        }
        byte[] bArr = null;
        if (this.zzd == 2 && (list.size() == 1 || list.size() == 3)) {
            bArr = (byte[]) list.get(0);
        }
        ByteBuffer byteBuffer3 = zzhdVar.zzc;
        int iPosition = byteBuffer3.position();
        int iLimit = byteBuffer3.limit();
        int i = iLimit - iPosition;
        int i2 = (i + 255) / 255;
        int i3 = i2 + 27 + i;
        if (this.zzd == 2) {
            length = bArr != null ? bArr.length + 28 : 47;
            i3 += length + 44;
        } else {
            length = 0;
        }
        if (this.zzc.capacity() < i3) {
            this.zzc = ByteBuffer.allocate(i3).order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.zzc.clear();
        }
        ByteBuffer byteBuffer4 = this.zzc;
        if (this.zzd == 2) {
            if (bArr != null) {
                byteBuffer = byteBuffer4;
                zzc(byteBuffer, 0L, 0, 1, true);
                int length2 = bArr.length;
                byteBuffer.put(zzgas.zza(length2));
                byteBuffer.put(bArr);
                int i4 = length2 + 28;
                byteBuffer.putInt(22, zzet.zze(byteBuffer.array(), byteBuffer.arrayOffset(), i4, 0));
                byteBuffer.position(i4);
            } else {
                byteBuffer = byteBuffer4;
                byteBuffer.put(zza);
            }
            byteBuffer.put(zzb);
        } else {
            byteBuffer = byteBuffer4;
        }
        int iZzc = this.zze + zzade.zzc(byteBuffer3);
        this.zze = iZzc;
        ByteBuffer byteBuffer5 = byteBuffer;
        zzc(byteBuffer5, iZzc, this.zzd, i2, false);
        for (int i5 = 0; i5 < i2; i5++) {
            if (i >= 255) {
                byteBuffer5.put((byte) -1);
                i -= 255;
            } else {
                byteBuffer5.put((byte) i);
                i = 0;
            }
        }
        while (iPosition < iLimit) {
            byteBuffer5.put(byteBuffer3.get(iPosition));
            iPosition++;
        }
        byteBuffer3.position(byteBuffer3.limit());
        byteBuffer5.flip();
        if (this.zzd == 2) {
            byteBuffer5.putInt(length + 66, zzet.zze(byteBuffer5.array(), byteBuffer5.arrayOffset() + length + 44, byteBuffer5.limit() - byteBuffer5.position(), 0));
        } else {
            byteBuffer5.putInt(22, zzet.zze(byteBuffer5.array(), byteBuffer5.arrayOffset(), byteBuffer5.limit() - byteBuffer5.position(), 0));
        }
        this.zzd++;
        this.zzc = byteBuffer5;
        zzhdVar.zzb();
        zzhdVar.zzi(this.zzc.remaining());
        zzhdVar.zzc.put(this.zzc);
        zzhdVar.zzj();
    }

    public final void zzb() {
        this.zzc = zzct.zza;
        this.zze = 0;
        this.zzd = 2;
    }
}
