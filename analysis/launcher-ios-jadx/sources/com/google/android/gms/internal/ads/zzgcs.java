package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
abstract class zzgcs extends AtomicReference implements Runnable {
    private static final Runnable zza = new zzgcr(null);
    private static final Runnable zzb = new zzgcr(null);

    private final void zzc(Thread thread) {
        Runnable runnable = (Runnable) get();
        zzgcp zzgcpVar = null;
        boolean z = false;
        int i = 0;
        while (true) {
            if (!(runnable instanceof zzgcp)) {
                if (runnable != zzb) {
                    break;
                }
            } else {
                zzgcpVar = (zzgcp) runnable;
            }
            i++;
            if (i > 1000) {
                Runnable runnable2 = zzb;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(zzgcpVar);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        Object objZza = null;
        if (compareAndSet(null, threadCurrentThread)) {
            boolean zZzg = zzg();
            if (!zZzg) {
                try {
                    objZza = zza();
                } catch (Throwable th) {
                    try {
                        zzgdb.zza(th);
                        if (!compareAndSet(threadCurrentThread, zza)) {
                            zzc(threadCurrentThread);
                        }
                        zzd(th);
                        return;
                    } catch (Throwable th2) {
                        if (!compareAndSet(threadCurrentThread, zza)) {
                            zzc(threadCurrentThread);
                        }
                        zze(null);
                        throw th2;
                    }
                }
            }
            if (!compareAndSet(threadCurrentThread, zza)) {
                zzc(threadCurrentThread);
            }
            if (zZzg) {
                return;
            }
            zze(objZza);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        Runnable runnable = (Runnable) get();
        return uo.i(runnable == zza ? "running=[DONE]" : runnable instanceof zzgcp ? "running=[INTERRUPTED]" : runnable instanceof Thread ? uo.t("running=[RUNNING ON ", ((Thread) runnable).getName(), "]") : "running=[NOT STARTED YET]", ", ", zzb());
    }

    public abstract Object zza();

    public abstract String zzb();

    public abstract void zzd(Throwable th);

    public abstract void zze(Object obj);

    public abstract boolean zzg();

    public final void zzh() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            zzgcp zzgcpVar = new zzgcp(this, null);
            zzgcpVar.setExclusiveOwnerThread(Thread.currentThread());
            if (compareAndSet(runnable, zzgcpVar)) {
                try {
                    Thread thread = (Thread) runnable;
                    thread.interrupt();
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark(thread);
                    }
                } catch (Throwable th) {
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark((Thread) runnable);
                    }
                    throw th;
                }
            }
        }
    }
}
