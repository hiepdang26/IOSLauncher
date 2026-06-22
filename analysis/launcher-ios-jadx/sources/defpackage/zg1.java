package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zg1 extends sd1 {
    public final ScheduledExecutorService g;
    public final el h = new el(0);
    public volatile boolean i;

    public zg1(ScheduledExecutorService scheduledExecutorService) {
        this.g = scheduledExecutorService;
    }

    @Override // defpackage.sd1
    public final cw a(rd1 rd1Var) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        boolean z = this.i;
        tz tzVar = tz.g;
        if (z) {
            return tzVar;
        }
        qd1 qd1Var = new qd1(rd1Var, this.h);
        this.h.a(qd1Var);
        try {
            qd1Var.a(this.g.submit((Callable) qd1Var));
            return qd1Var;
        } catch (RejectedExecutionException e) {
            b();
            e42.m(e);
            return tzVar;
        }
    }

    @Override // defpackage.cw
    public final void b() {
        if (this.i) {
            return;
        }
        this.i = true;
        this.h.b();
    }
}
