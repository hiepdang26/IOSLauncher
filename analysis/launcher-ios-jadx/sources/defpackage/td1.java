package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class td1 {
    static {
        Boolean.getBoolean("rx2.scheduler.use-nanotime");
        TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15L).longValue());
    }

    public abstract sd1 a();

    public cw b(Runnable runnable) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return c(runnable);
    }

    public cw c(Runnable runnable) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        sd1 sd1VarA = a();
        rd1 rd1Var = new rd1(runnable, sd1VarA);
        sd1VarA.a(rd1Var);
        return rd1Var;
    }
}
