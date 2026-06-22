package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class lx0 extends sd1 {
    public final ScheduledExecutorService g;
    public volatile boolean h;

    public lx0(ad1 ad1Var) {
        boolean z = wd1.a;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, ad1Var);
        if (wd1.a && (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            wd1.d.put((ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool, scheduledExecutorServiceNewScheduledThreadPool);
        }
        this.g = scheduledExecutorServiceNewScheduledThreadPool;
    }

    @Override // defpackage.sd1
    public final cw a(rd1 rd1Var) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return this.h ? tz.g : c(rd1Var, null);
    }

    @Override // defpackage.cw
    public final void b() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.g.shutdownNow();
    }

    public final qd1 c(Runnable runnable, el elVar) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        qd1 qd1Var = new qd1(runnable, elVar);
        if (elVar == null || elVar.a(qd1Var)) {
            try {
                qd1Var.a(this.g.submit((Callable) qd1Var));
                return qd1Var;
            } catch (RejectedExecutionException e) {
                if (elVar != null) {
                    elVar.g(qd1Var);
                }
                e42.m(e);
            }
        }
        return qd1Var;
    }
}
