package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class zzapb extends Thread {
    private final BlockingQueue zza;
    private final zzapa zzb;
    private final zzaor zzc;
    private volatile boolean zzd = false;
    private final zzaoy zze;

    public zzapb(BlockingQueue blockingQueue, zzapa zzapaVar, zzaor zzaorVar, zzaoy zzaoyVar) {
        this.zza = blockingQueue;
        this.zzb = zzapaVar;
        this.zzc = zzaorVar;
        this.zze = zzaoyVar;
    }

    private void zzb() {
        zzaph zzaphVar = (zzaph) this.zza.take();
        SystemClock.elapsedRealtime();
        zzaphVar.zzt(3);
        try {
            try {
                zzaphVar.zzm("network-queue-take");
                zzaphVar.zzw();
                TrafficStats.setThreadStatsTag(zzaphVar.zzc());
                zzapd zzapdVarZza = this.zzb.zza(zzaphVar);
                zzaphVar.zzm("network-http-complete");
                if (zzapdVarZza.zze && zzaphVar.zzv()) {
                    zzaphVar.zzp("not-modified");
                    zzaphVar.zzr();
                } else {
                    zzapn zzapnVarZzh = zzaphVar.zzh(zzapdVarZza);
                    zzaphVar.zzm("network-parse-complete");
                    if (zzapnVarZzh.zzb != null) {
                        this.zzc.zzd(zzaphVar.zzj(), zzapnVarZzh.zzb);
                        zzaphVar.zzm("network-cache-written");
                    }
                    zzaphVar.zzq();
                    this.zze.zzb(zzaphVar, zzapnVarZzh, null);
                    zzaphVar.zzs(zzapnVarZzh);
                }
            } catch (zzapq e) {
                SystemClock.elapsedRealtime();
                this.zze.zza(zzaphVar, e);
                zzaphVar.zzr();
            } catch (Exception e2) {
                zzapt.zzc(e2, "Unhandled exception %s", e2.toString());
                zzapq zzapqVar = new zzapq(e2);
                SystemClock.elapsedRealtime();
                this.zze.zza(zzaphVar, zzapqVar);
                zzaphVar.zzr();
            }
            zzaphVar.zzt(4);
        } catch (Throwable th) {
            zzaphVar.zzt(4);
            throw th;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzapt.zzb("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
