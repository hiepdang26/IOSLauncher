package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class jn0 extends cp implements ju {
    public static final AtomicIntegerFieldUpdater m = AtomicIntegerFieldUpdater.newUpdater(jn0.class, "runningWorkers");
    public final cq1 i;
    public final int j;
    public final op0 k;
    public final Object l;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public jn0(cq1 cq1Var, int i) {
        this.i = cq1Var;
        this.j = i;
        if ((cq1Var instanceof ju ? (ju) cq1Var : null) == null) {
            int i2 = zs.a;
        }
        this.k = new op0();
        this.l = new Object();
    }

    @Override // defpackage.cp
    public final void A(yo yoVar, Runnable runnable) {
        Runnable runnableC;
        this.k.a(runnable);
        if (m.get(this) >= this.j || !D() || (runnableC = C()) == null) {
            return;
        }
        this.i.A(this, new el0(this, runnableC, 3));
    }

    public final Runnable C() {
        while (true) {
            Runnable runnable = (Runnable) this.k.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.l) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = m;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.k.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean D() {
        synchronized (this.l) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = m;
            if (atomicIntegerFieldUpdater.get(this) >= this.j) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // defpackage.cp
    public final void z(yo yoVar, Runnable runnable) {
        Runnable runnableC;
        this.k.a(runnable);
        if (m.get(this) >= this.j || !D() || (runnableC = C()) == null) {
            return;
        }
        this.i.z(this, new el0(this, runnableC, 3));
    }
}
