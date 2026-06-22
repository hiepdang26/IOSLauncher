package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class zzaot extends Thread {
    private static final boolean zza = zzapt.zzb;
    private final BlockingQueue zzb;
    private final BlockingQueue zzc;
    private final zzaor zzd;
    private volatile boolean zze = false;
    private final zzapu zzf;
    private final zzaoy zzg;

    public zzaot(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzaor zzaorVar, zzaoy zzaoyVar) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzaorVar;
        this.zzg = zzaoyVar;
        this.zzf = new zzapu(this, blockingQueue2, zzaoyVar);
    }

    private void zzc() {
        zzaph zzaphVar = (zzaph) this.zzb.take();
        zzaphVar.zzm("cache-queue-take");
        zzaphVar.zzt(1);
        try {
            zzaphVar.zzw();
            zzaoq zzaoqVarZza = this.zzd.zza(zzaphVar.zzj());
            if (zzaoqVarZza == null) {
                zzaphVar.zzm("cache-miss");
                if (!this.zzf.zzc(zzaphVar)) {
                    this.zzc.put(zzaphVar);
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (zzaoqVarZza.zza(jCurrentTimeMillis)) {
                    zzaphVar.zzm("cache-hit-expired");
                    zzaphVar.zze(zzaoqVarZza);
                    if (!this.zzf.zzc(zzaphVar)) {
                        this.zzc.put(zzaphVar);
                    }
                } else {
                    zzaphVar.zzm("cache-hit");
                    zzapn zzapnVarZzh = zzaphVar.zzh(new zzapd(zzaoqVarZza.zza, zzaoqVarZza.zzg));
                    zzaphVar.zzm("cache-hit-parsed");
                    if (!zzapnVarZzh.zzc()) {
                        zzaphVar.zzm("cache-parsing-failed");
                        this.zzd.zzc(zzaphVar.zzj(), true);
                        zzaphVar.zze(null);
                        if (!this.zzf.zzc(zzaphVar)) {
                            this.zzc.put(zzaphVar);
                        }
                    } else if (zzaoqVarZza.zzf < jCurrentTimeMillis) {
                        zzaphVar.zzm("cache-hit-refresh-needed");
                        zzaphVar.zze(zzaoqVarZza);
                        zzapnVarZzh.zzd = true;
                        if (this.zzf.zzc(zzaphVar)) {
                            this.zzg.zzb(zzaphVar, zzapnVarZzh, null);
                        } else {
                            this.zzg.zzb(zzaphVar, zzapnVarZzh, new zzaos(this, zzaphVar));
                        }
                    } else {
                        this.zzg.zzb(zzaphVar, zzapnVarZzh, null);
                    }
                }
            }
            zzaphVar.zzt(2);
        } catch (Throwable th) {
            zzaphVar.zzt(2);
            throw th;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (zza) {
            zzapt.zzd("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzb();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzapt.zzb("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zzb() {
        this.zze = true;
        interrupt();
    }
}
