package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzgcb extends zzgca {
    private final do0 zza;

    public zzgcb(do0 do0Var) {
        do0Var.getClass();
        this.zza = do0Var;
    }

    @Override // com.google.android.gms.internal.ads.zzgax, defpackage.do0
    public final void addListener(Runnable runnable, Executor executor) {
        this.zza.addListener(runnable, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzgax, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.zza.cancel(z);
    }

    @Override // com.google.android.gms.internal.ads.zzgax, java.util.concurrent.Future
    public final Object get() {
        return this.zza.get();
    }

    @Override // com.google.android.gms.internal.ads.zzgax, java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    @Override // com.google.android.gms.internal.ads.zzgax, java.util.concurrent.Future
    public final boolean isDone() {
        return this.zza.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgax, java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.zza.get(j, timeUnit);
    }
}
