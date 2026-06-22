package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class zzaof implements zzaog {
    private final ByteBuffer zza;

    public zzaof(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.slice();
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final long zza() {
        return this.zza.capacity();
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void zzb(MessageDigest[] messageDigestArr, long j, int i) {
        ByteBuffer byteBufferSlice;
        synchronized (this.zza) {
            int i2 = (int) j;
            this.zza.position(i2);
            this.zza.limit(i2 + i);
            byteBufferSlice = this.zza.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            byteBufferSlice.position(0);
            messageDigest.update(byteBufferSlice);
        }
    }
}
