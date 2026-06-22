package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzgcx extends zzgcd implements ScheduledFuture {
    private final ScheduledFuture zza;

    public zzgcx(do0 do0Var, ScheduledFuture scheduledFuture) {
        super(do0Var);
        this.zza = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzgcc, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean zCancel = zzb().cancel(z);
        if (zCancel) {
            this.zza.cancel(z);
        }
        return zCancel;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.zza.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }
}
