package com.google.android.gms.internal.ads;

import defpackage.k31;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
final class zzfhx implements ThreadFactory {
    private final AtomicInteger zza = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, k31.k(this.zza.getAndIncrement(), "AdWorker(NG) #"));
    }
}
