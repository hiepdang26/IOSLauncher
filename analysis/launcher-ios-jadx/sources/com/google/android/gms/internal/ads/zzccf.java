package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
final class zzccf implements zzheo, AutoCloseable {
    private final ByteBuffer zza;

    public zzccf(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.duplicate();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.google.android.gms.internal.ads.zzheo
    public final int zza(ByteBuffer byteBuffer) {
        if (this.zza.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), this.zza.remaining());
        byte[] bArr = new byte[iMin];
        this.zza.get(bArr);
        byteBuffer.put(bArr);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzheo
    public final long zzb() {
        return this.zza.position();
    }

    @Override // com.google.android.gms.internal.ads.zzheo
    public final long zzc() {
        return this.zza.limit();
    }

    @Override // com.google.android.gms.internal.ads.zzheo
    public final ByteBuffer zzd(long j, long j2) {
        ByteBuffer byteBuffer = this.zza;
        int i = (int) j;
        int iPosition = byteBuffer.position();
        byteBuffer.position(i);
        ByteBuffer byteBufferSlice = this.zza.slice();
        byteBufferSlice.limit((int) j2);
        this.zza.position(iPosition);
        return byteBufferSlice;
    }

    @Override // com.google.android.gms.internal.ads.zzheo
    public final void zze(long j) {
        this.zza.position((int) j);
    }
}
