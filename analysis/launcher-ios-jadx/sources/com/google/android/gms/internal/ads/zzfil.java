package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class zzfil implements zzhfc {
    private final zzhfu zza;

    public zzfil(zzhfu zzhfuVar) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        ThreadFactory threadFactory = (ThreadFactory) this.zza.zzb();
        zzfrt.zza();
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, threadFactory));
        zzhfk.zzb(scheduledExecutorServiceUnconfigurableScheduledExecutorService);
        return scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }
}
