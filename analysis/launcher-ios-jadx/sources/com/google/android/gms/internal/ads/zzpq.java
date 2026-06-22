package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
final class zzpq extends zzcu {
    private int[] zzd;
    private int[] zze;

    @Override // com.google.android.gms.internal.ads.zzct
    public final void zze(ByteBuffer byteBuffer) {
        int[] iArr = this.zze;
        iArr.getClass();
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferZzj = zzj(((iLimit - iPosition) / this.zzb.zze) * this.zzc.zze);
        while (iPosition < iLimit) {
            for (int i : iArr) {
                byteBufferZzj.putShort(byteBuffer.getShort(i + i + iPosition));
            }
            iPosition += this.zzb.zze;
        }
        byteBuffer.position(iLimit);
        byteBufferZzj.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final zzcr zzi(zzcr zzcrVar) throws zzcs {
        int[] iArr = this.zzd;
        if (iArr == null) {
            return zzcr.zza;
        }
        if (zzcrVar.zzd != 2) {
            throw new zzcs("Unhandled input format:", zzcrVar);
        }
        boolean z = zzcrVar.zzc != iArr.length;
        int i = 0;
        while (true) {
            int length = iArr.length;
            if (i >= length) {
                return z ? new zzcr(zzcrVar.zzb, length, 2) : zzcr.zza;
            }
            int i2 = iArr[i];
            if (i2 >= zzcrVar.zzc) {
                throw new zzcs("Unhandled input format:", zzcrVar);
            }
            z |= i2 != i;
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final void zzk() {
        this.zze = this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    public final void zzm() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzo(int[] iArr) {
        this.zzd = iArr;
    }
}
