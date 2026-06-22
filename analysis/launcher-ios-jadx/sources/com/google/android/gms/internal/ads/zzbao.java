package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.PushbackInputStream;

/* JADX INFO: loaded from: classes.dex */
final class zzbao extends PushbackInputStream implements AutoCloseable {
    final /* synthetic */ zzbap zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbao(zzbap zzbapVar, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zza = zzbapVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        zzbar.zze(this.zza.zzc);
        super.close();
    }
}
