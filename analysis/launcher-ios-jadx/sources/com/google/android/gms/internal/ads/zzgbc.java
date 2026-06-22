package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgbc extends AbstractExecutorService implements zzgcu {
    @Override // java.util.concurrent.AbstractExecutorService
    public final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return zzgdj.zze(runnable, obj);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final /* synthetic */ Future submit(Runnable runnable) {
        return (do0) super.submit(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzgcu
    public final do0 zza(Runnable runnable) {
        return (do0) super.submit(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzgcu
    public final do0 zzb(Callable callable) {
        return (do0) super.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final RunnableFuture newTaskFor(Callable callable) {
        return new zzgdj(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (do0) super.submit(runnable, obj);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final /* synthetic */ Future submit(Callable callable) {
        return (do0) super.submit(callable);
    }
}
