package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzapk {
    private final AtomicInteger zza;
    private final Set zzb;
    private final PriorityBlockingQueue zzc;
    private final PriorityBlockingQueue zzd;
    private final zzaor zze;
    private final zzapa zzf;
    private final zzapb[] zzg;
    private zzaot zzh;
    private final List zzi;
    private final List zzj;
    private final zzaoy zzk;

    public zzapk(zzaor zzaorVar, zzapa zzapaVar, int i) {
        zzaoy zzaoyVar = new zzaoy(new Handler(Looper.getMainLooper()));
        this.zza = new AtomicInteger();
        this.zzb = new HashSet();
        this.zzc = new PriorityBlockingQueue();
        this.zzd = new PriorityBlockingQueue();
        this.zzi = new ArrayList();
        this.zzj = new ArrayList();
        this.zze = zzaorVar;
        this.zzf = zzapaVar;
        this.zzg = new zzapb[4];
        this.zzk = zzaoyVar;
    }

    public final zzaph zza(zzaph zzaphVar) {
        zzaphVar.zzf(this);
        synchronized (this.zzb) {
            this.zzb.add(zzaphVar);
        }
        zzaphVar.zzg(this.zza.incrementAndGet());
        zzaphVar.zzm("add-to-queue");
        zzc(zzaphVar, 0);
        this.zzc.add(zzaphVar);
        return zzaphVar;
    }

    public final void zzb(zzaph zzaphVar) {
        synchronized (this.zzb) {
            this.zzb.remove(zzaphVar);
        }
        synchronized (this.zzi) {
            try {
                Iterator it = this.zzi.iterator();
                while (it.hasNext()) {
                    ((zzapj) it.next()).zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzc(zzaphVar, 5);
    }

    public final void zzc(zzaph zzaphVar, int i) {
        synchronized (this.zzj) {
            try {
                Iterator it = this.zzj.iterator();
                while (it.hasNext()) {
                    ((zzapi) it.next()).zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzd() {
        zzaot zzaotVar = this.zzh;
        if (zzaotVar != null) {
            zzaotVar.zzb();
        }
        zzapb[] zzapbVarArr = this.zzg;
        for (int i = 0; i < 4; i++) {
            zzapb zzapbVar = zzapbVarArr[i];
            if (zzapbVar != null) {
                zzapbVar.zza();
            }
        }
        zzaot zzaotVar2 = new zzaot(this.zzc, this.zzd, this.zze, this.zzk);
        this.zzh = zzaotVar2;
        zzaotVar2.start();
        for (int i2 = 0; i2 < 4; i2++) {
            zzapb zzapbVar2 = new zzapb(this.zzd, this.zzf, this.zze, this.zzk);
            this.zzg[i2] = zzapbVar2;
            zzapbVar2.start();
        }
    }
}
