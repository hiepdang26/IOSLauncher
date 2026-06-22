package defpackage;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class ch0 implements Runnable {
    public final long g;
    public final ConcurrentLinkedQueue h;
    public final el i;
    public final ScheduledExecutorService j;
    public final ScheduledFuture k;
    public final ad1 l;

    public ch0(long j, TimeUnit timeUnit, ad1 ad1Var) {
        ch0 ch0Var;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
        ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
        long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
        this.g = nanos;
        this.h = new ConcurrentLinkedQueue();
        this.i = new el(0);
        this.l = ad1Var;
        if (timeUnit != null) {
            scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, fh0.c);
            ch0Var = this;
            scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(ch0Var, nanos, nanos, TimeUnit.NANOSECONDS);
        } else {
            ch0Var = this;
            scheduledExecutorServiceNewScheduledThreadPool = null;
            scheduledFutureScheduleWithFixedDelay = null;
        }
        ch0Var.j = scheduledExecutorServiceNewScheduledThreadPool;
        ch0Var.k = scheduledFutureScheduleWithFixedDelay;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentLinkedQueue<eh0> concurrentLinkedQueue = this.h;
        if (concurrentLinkedQueue.isEmpty()) {
            return;
        }
        long jNanoTime = System.nanoTime();
        for (eh0 eh0Var : concurrentLinkedQueue) {
            if (eh0Var.i > jNanoTime) {
                return;
            }
            if (concurrentLinkedQueue.remove(eh0Var)) {
                this.i.g(eh0Var);
            }
        }
    }
}
