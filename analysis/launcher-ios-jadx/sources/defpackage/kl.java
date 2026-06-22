package defpackage;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class kl extends td1 {
    public static final il b;
    public static final ad1 c;
    public static final int d;
    public static final jl e;
    public final AtomicReference a;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        int iIntValue = Integer.getInteger("rx2.computation-threads", 0).intValue();
        if (iIntValue > 0 && iIntValue <= iAvailableProcessors) {
            iAvailableProcessors = iIntValue;
        }
        d = iAvailableProcessors;
        jl jlVar = new jl(new ad1("RxComputationShutdown"));
        e = jlVar;
        jlVar.b();
        ad1 ad1Var = new ad1(true, "RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())));
        c = ad1Var;
        il ilVar = new il(0, ad1Var);
        b = ilVar;
        for (jl jlVar2 : ilVar.b) {
            jlVar2.b();
        }
    }

    public kl() {
        AtomicReference atomicReference;
        ad1 ad1Var = c;
        il ilVar = b;
        this.a = new AtomicReference(ilVar);
        il ilVar2 = new il(d, ad1Var);
        do {
            atomicReference = this.a;
            if (atomicReference.compareAndSet(ilVar, ilVar2)) {
                return;
            }
        } while (atomicReference.get() == ilVar);
        for (jl jlVar : ilVar2.b) {
            jlVar.b();
        }
    }

    @Override // defpackage.td1
    public final sd1 a() {
        jl jlVar;
        il ilVar = (il) this.a.get();
        int i = ilVar.a;
        if (i == 0) {
            jlVar = e;
        } else {
            long j = ilVar.c;
            ilVar.c = 1 + j;
            jlVar = ilVar.b[(int) (j % ((long) i))];
        }
        return new hl(jlVar);
    }

    @Override // defpackage.td1
    public final cw c(Runnable runnable) {
        jl jlVar;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        il ilVar = (il) this.a.get();
        int i = ilVar.a;
        if (i == 0) {
            jlVar = e;
        } else {
            long j = ilVar.c;
            ilVar.c = 1 + j;
            jlVar = ilVar.b[(int) (j % ((long) i))];
        }
        jlVar.getClass();
        pd1 pd1Var = new pd1(runnable);
        try {
            pd1Var.a(jlVar.g.submit(pd1Var));
            return pd1Var;
        } catch (RejectedExecutionException e2) {
            e42.m(e2);
            return tz.g;
        }
    }
}
