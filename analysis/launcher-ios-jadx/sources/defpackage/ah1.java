package defpackage;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class ah1 extends td1 {
    public static final ad1 b;
    public static final ScheduledExecutorService c;
    public final AtomicReference a;

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        c = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        b = new ad1(true, "RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())));
    }

    public ah1() {
        AtomicReference atomicReference = new AtomicReference();
        this.a = atomicReference;
        boolean z = wd1.a;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, b);
        if (wd1.a && (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            wd1.d.put((ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool, scheduledExecutorServiceNewScheduledThreadPool);
        }
        atomicReference.lazySet(scheduledExecutorServiceNewScheduledThreadPool);
    }

    @Override // defpackage.td1
    public final sd1 a() {
        return new zg1((ScheduledExecutorService) this.a.get());
    }

    @Override // defpackage.td1
    public final cw c(Runnable runnable) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        pd1 pd1Var = new pd1(runnable);
        try {
            pd1Var.a(((ScheduledExecutorService) this.a.get()).submit(pd1Var));
            return pd1Var;
        } catch (RejectedExecutionException e) {
            e42.m(e);
            return tz.g;
        }
    }
}
