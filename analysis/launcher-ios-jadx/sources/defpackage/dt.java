package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class dt extends i10 implements Executor {
    public static final dt i = new dt();
    public static final cp j;

    static {
        cq1 cq1Var = cq1.i;
        int i2 = ul1.a;
        if (64 >= i2) {
            i2 = 64;
        }
        int iT = e42.t(i2, 12, "kotlinx.coroutines.io.parallelism");
        cq1Var.getClass();
        if (iT < 1) {
            throw new IllegalArgumentException(k31.k(iT, "Expected positive parallelism level, but got ").toString());
        }
        cp jn0Var = cq1Var;
        if (iT < um1.d) {
            if (iT < 1) {
                throw new IllegalArgumentException(k31.k(iT, "Expected positive parallelism level, but got ").toString());
            }
            jn0Var = new jn0(cq1Var, iT);
        }
        j = jn0Var;
    }

    @Override // defpackage.cp
    public final void A(yo yoVar, Runnable runnable) {
        j.A(yoVar, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        z(sz.g, runnable);
    }

    @Override // defpackage.cp
    public final String toString() {
        return "Dispatchers.IO";
    }

    @Override // defpackage.cp
    public final void z(yo yoVar, Runnable runnable) {
        j.z(yoVar, runnable);
    }
}
