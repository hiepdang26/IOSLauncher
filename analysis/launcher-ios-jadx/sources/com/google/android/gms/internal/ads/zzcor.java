package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import defpackage.hd2;
import defpackage.nj;
import defpackage.us;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzcor implements zzayp {
    private final ScheduledExecutorService zza;
    private final nj zzb;
    private ScheduledFuture zzc;
    private long zzd = -1;
    private long zze = -1;
    private Runnable zzf = null;
    private boolean zzg = false;

    public zzcor(ScheduledExecutorService scheduledExecutorService, nj njVar) {
        this.zza = scheduledExecutorService;
        this.zzb = njVar;
        hd2.B.f.zzc(this);
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public final void zza(boolean z) {
        if (z) {
            zzc();
        } else {
            zzb();
        }
    }

    public final synchronized void zzb() {
        try {
            if (this.zzg) {
                return;
            }
            ScheduledFuture scheduledFuture = this.zzc;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                this.zze = -1L;
            } else {
                this.zzc.cancel(true);
                long j = this.zzd;
                ((us) this.zzb).getClass();
                this.zze = j - SystemClock.elapsedRealtime();
            }
            this.zzg = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzc() {
        ScheduledFuture scheduledFuture;
        try {
            if (this.zzg) {
                if (this.zze > 0 && (scheduledFuture = this.zzc) != null && scheduledFuture.isCancelled()) {
                    this.zzc = this.zza.schedule(this.zzf, this.zze, TimeUnit.MILLISECONDS);
                }
                this.zzg = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzd(int i, Runnable runnable) {
        this.zzf = runnable;
        ((us) this.zzb).getClass();
        long j = i;
        this.zzd = SystemClock.elapsedRealtime() + j;
        this.zzc = this.zza.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }
}
