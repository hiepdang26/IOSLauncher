package defpackage;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class fh0 extends td1 {
    public static final ad1 b;
    public static final ad1 c;
    public static final eh0 f;
    public static final boolean g;
    public static final ch0 h;
    public final AtomicReference a;
    public static final TimeUnit e = TimeUnit.SECONDS;
    public static final long d = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    static {
        eh0 eh0Var = new eh0(new ad1("RxCachedThreadSchedulerShutdown"));
        f = eh0Var;
        eh0Var.b();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        ad1 ad1Var = new ad1(false, "RxCachedThreadScheduler", iMax);
        b = ad1Var;
        c = new ad1(false, "RxCachedWorkerPoolEvictor", iMax);
        g = Boolean.getBoolean("rx2.io-scheduled-release");
        ch0 ch0Var = new ch0(0L, null, ad1Var);
        h = ch0Var;
        ch0Var.i.b();
        ScheduledFuture scheduledFuture = ch0Var.k;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = ch0Var.j;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    public fh0() {
        AtomicReference atomicReference;
        ad1 ad1Var = b;
        ch0 ch0Var = h;
        this.a = new AtomicReference(ch0Var);
        ch0 ch0Var2 = new ch0(d, e, ad1Var);
        do {
            atomicReference = this.a;
            if (atomicReference.compareAndSet(ch0Var, ch0Var2)) {
                return;
            }
        } while (atomicReference.get() == ch0Var);
        ch0Var2.i.b();
        ScheduledFuture scheduledFuture = ch0Var2.k;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = ch0Var2.j;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    @Override // defpackage.td1
    public final sd1 a() {
        return new dh0((ch0) this.a.get());
    }
}
