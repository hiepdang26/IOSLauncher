package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
final class zzgcn implements do0 {
    static final do0 zza = new zzgcn(null);
    private static final zzgct zzb = new zzgct(zzgcn.class);
    private final Object zzc;

    public zzgcn(Object obj) {
        this.zzc = obj;
    }

    @Override // defpackage.do0
    public final void addListener(Runnable runnable, Executor executor) {
        zzfuu.zzc(runnable, "Runnable was null.");
        zzfuu.zzc(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            zzb.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.ImmediateFuture", "addListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.zzc;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        Object obj = this.zzc;
        return super.toString() + "[status=SUCCESS, result=[" + String.valueOf(obj) + "]]";
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        return this.zzc;
    }
}
