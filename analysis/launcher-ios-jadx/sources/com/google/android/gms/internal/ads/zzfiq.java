package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzfiq implements do0 {
    private final Object zza;
    private final String zzb;
    private final do0 zzc;

    public zzfiq(Object obj, String str, do0 do0Var) {
        this.zza = obj;
        this.zzb = str;
        this.zzc = do0Var;
    }

    @Override // defpackage.do0
    public final void addListener(Runnable runnable, Executor executor) {
        this.zzc.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.zzc.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.zzc.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zzc.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.zzc.isDone();
    }

    public final String toString() {
        return this.zzb + "@" + System.identityHashCode(this);
    }

    public final Object zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.zzc.get(j, timeUnit);
    }
}
