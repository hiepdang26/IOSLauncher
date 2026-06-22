package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class zzaqy extends zzhej {
    public zzaqy(String str) {
        super(str);
    }

    @Override // com.google.android.gms.internal.ads.zzhej
    public final void zze(ByteBuffer byteBuffer) {
        byteBuffer.position(byteBuffer.remaining() + byteBuffer.position());
    }
}
