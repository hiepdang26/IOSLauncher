package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzgda {
    public static zzgcu zza(ExecutorService executorService) {
        return executorService instanceof zzgcu ? (zzgcu) executorService : executorService instanceof ScheduledExecutorService ? new zzgcz((ScheduledExecutorService) executorService) : new zzgcw(executorService);
    }

    public static Executor zzb() {
        return zzgbx.INSTANCE;
    }

    public static Executor zzc(Executor executor, zzgax zzgaxVar) {
        executor.getClass();
        return executor == zzgbx.INSTANCE ? executor : new zzgcv(executor, zzgaxVar);
    }
}
