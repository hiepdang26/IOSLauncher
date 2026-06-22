package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
final class zzaqp extends ThreadLocal {
    public zzaqp(zzaqq zzaqqVar) {
    }

    @Override // java.lang.ThreadLocal
    public final /* synthetic */ Object initialValue() {
        return ByteBuffer.allocate(32);
    }
}
