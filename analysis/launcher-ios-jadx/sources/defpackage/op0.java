package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class op0 {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(op0.class, Object.class, "_cur");
    private volatile Object _cur = new qp0(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            qp0 qp0Var = (qp0) atomicReferenceFieldUpdater.get(this);
            int iA = qp0Var.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                qp0 qp0VarC = qp0Var.c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, qp0Var, qp0VarC) && atomicReferenceFieldUpdater.get(this) == qp0Var) {
                }
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            qp0 qp0Var = (qp0) atomicReferenceFieldUpdater.get(this);
            if (qp0Var.b()) {
                return;
            }
            qp0 qp0VarC = qp0Var.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, qp0Var, qp0VarC) && atomicReferenceFieldUpdater.get(this) == qp0Var) {
            }
        }
    }

    public final int c() {
        qp0 qp0Var = (qp0) a.get(this);
        qp0Var.getClass();
        long j = qp0.f.get(qp0Var);
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j)));
    }

    public final Object d() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            qp0 qp0Var = (qp0) atomicReferenceFieldUpdater.get(this);
            Object objD = qp0Var.d();
            if (objD != qp0.g) {
                return objD;
            }
            qp0 qp0VarC = qp0Var.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, qp0Var, qp0VarC) && atomicReferenceFieldUpdater.get(this) == qp0Var) {
            }
        }
    }
}
