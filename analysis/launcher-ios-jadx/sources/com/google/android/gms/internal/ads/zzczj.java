package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import defpackage.nj;
import defpackage.us;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzczj extends zzdch {
    private final ScheduledExecutorService zzb;
    private final nj zzc;
    private long zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private ScheduledFuture zzi;
    private ScheduledFuture zzj;

    public zzczj(ScheduledExecutorService scheduledExecutorService, nj njVar) {
        super(Collections.EMPTY_SET);
        this.zzd = -1L;
        this.zze = -1L;
        this.zzf = -1L;
        this.zzg = -1L;
        this.zzh = false;
        this.zzb = scheduledExecutorService;
        this.zzc = njVar;
    }

    private final synchronized void zzf(long j) {
        try {
            ScheduledFuture scheduledFuture = this.zzi;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                this.zzi.cancel(false);
            }
            ((us) this.zzc).getClass();
            this.zzd = SystemClock.elapsedRealtime() + j;
            this.zzi = this.zzb.schedule(new zzczg(this, null), j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzg(long j) {
        try {
            ScheduledFuture scheduledFuture = this.zzj;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                this.zzj.cancel(false);
            }
            ((us) this.zzc).getClass();
            this.zze = SystemClock.elapsedRealtime() + j;
            this.zzj = this.zzb.schedule(new zzczi(this, null), j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zza() {
        this.zzh = false;
        zzf(0L);
    }

    public final synchronized void zzb() {
        try {
            if (this.zzh) {
                return;
            }
            ScheduledFuture scheduledFuture = this.zzi;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                this.zzf = -1L;
            } else {
                this.zzi.cancel(false);
                long j = this.zzd;
                ((us) this.zzc).getClass();
                this.zzf = j - SystemClock.elapsedRealtime();
            }
            ScheduledFuture scheduledFuture2 = this.zzj;
            if (scheduledFuture2 == null || scheduledFuture2.isCancelled()) {
                this.zzg = -1L;
            } else {
                this.zzj.cancel(false);
                long j2 = this.zze;
                ((us) this.zzc).getClass();
                this.zzg = j2 - SystemClock.elapsedRealtime();
            }
            this.zzh = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzc() {
        try {
            if (this.zzh) {
                if (this.zzf > 0 && this.zzi.isCancelled()) {
                    zzf(this.zzf);
                }
                if (this.zzg > 0 && this.zzj.isCancelled()) {
                    zzg(this.zzg);
                }
                this.zzh = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzd(int i) {
        if (i > 0) {
            long millis = TimeUnit.SECONDS.toMillis(i);
            if (this.zzh) {
                long j = this.zzf;
                if (j <= 0 || millis >= j) {
                    millis = j;
                }
                this.zzf = millis;
                return;
            }
            ((us) this.zzc).getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = this.zzd;
            if (jElapsedRealtime > j2 || j2 - jElapsedRealtime > millis) {
                zzf(millis);
            }
        }
    }

    public final synchronized void zze(int i) {
        if (i > 0) {
            long millis = TimeUnit.SECONDS.toMillis(i);
            if (this.zzh) {
                long j = this.zzg;
                if (j <= 0 || millis >= j) {
                    millis = j;
                }
                this.zzg = millis;
                return;
            }
            ((us) this.zzc).getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = this.zze;
            if (jElapsedRealtime > j2 || j2 - jElapsedRealtime > millis) {
                zzg(millis);
            }
        }
    }
}
