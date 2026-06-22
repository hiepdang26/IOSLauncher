package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzgcz extends zzgcw implements ScheduledExecutorService, zzgcu {
    final ScheduledExecutorService zza;

    public zzgcz(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzgdj zzgdjVarZze = zzgdj.zze(runnable, null);
        return new zzgcx(zzgdjVarZze, scheduledExecutorService.schedule(zzgdjVarZze, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzgcy zzgcyVar = new zzgcy(runnable);
        return new zzgcx(zzgcyVar, this.zza.scheduleAtFixedRate(zzgcyVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzgcy zzgcyVar = new zzgcy(runnable);
        return new zzgcx(zzgcyVar, this.zza.scheduleWithFixedDelay(zzgcyVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzgdj zzgdjVar = new zzgdj(callable);
        return new zzgcx(zzgdjVar, this.zza.schedule(zzgdjVar, j, timeUnit));
    }
}
