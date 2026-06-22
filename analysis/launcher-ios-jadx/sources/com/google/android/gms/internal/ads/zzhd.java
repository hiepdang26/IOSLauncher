package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class zzhd extends zzgx {
    public zzaf zza;
    public final zzha zzb = new zzha();
    public ByteBuffer zzc;
    public boolean zzd;
    public long zze;
    public ByteBuffer zzf;
    private final int zzg;

    static {
        zzbd.zzb("media3.decoder");
    }

    public zzhd(int i, int i2) {
        this.zzg = i;
    }

    private final ByteBuffer zzl(int i) {
        int i2 = this.zzg;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.zzc;
        throw new zzhc(byteBuffer == null ? 0 : byteBuffer.capacity(), i);
    }

    @Override // com.google.android.gms.internal.ads.zzgx
    public void zzb() {
        super.zzb();
        ByteBuffer byteBuffer = this.zzc;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.zzf;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.zzd = false;
    }

    public final void zzi(int i) {
        ByteBuffer byteBuffer = this.zzc;
        if (byteBuffer == null) {
            this.zzc = zzl(i);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i2 = i + iPosition;
        if (iCapacity >= i2) {
            this.zzc = byteBuffer;
            return;
        }
        ByteBuffer byteBufferZzl = zzl(i2);
        byteBufferZzl.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferZzl.put(byteBuffer);
        }
        this.zzc = byteBufferZzl;
    }

    public final void zzj() {
        ByteBuffer byteBuffer = this.zzc;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.zzf;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean zzk() {
        return zzd(1073741824);
    }
}
