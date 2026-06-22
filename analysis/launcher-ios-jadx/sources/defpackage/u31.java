package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class u31 extends f implements v31, ph {
    public final je j;

    public u31(yo yoVar, je jeVar) {
        super(yoVar, true);
        this.j = jeVar;
    }

    @Override // defpackage.f
    public final void O(boolean z, Throwable th) throws IllegalAccessException, InvocationTargetException {
        if (this.j.j(false, th) || z) {
            return;
        }
        os.h(this.i, th);
    }

    @Override // defpackage.f
    public final void P(Object obj) {
        hg0.k(this.j);
    }

    public final void R(ri0 ri0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        je jeVar = this.j;
        jeVar.getClass();
        do {
            atomicReferenceFieldUpdater = je.p;
            if (atomicReferenceFieldUpdater.compareAndSet(jeVar, null, ri0Var)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(jeVar) == null);
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(jeVar);
            wg1 wg1Var = le.q;
            if (obj != wg1Var) {
                if (obj == le.r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
            wg1 wg1Var2 = le.r;
            while (!atomicReferenceFieldUpdater.compareAndSet(jeVar, wg1Var, wg1Var2)) {
                if (atomicReferenceFieldUpdater.get(jeVar) != wg1Var) {
                    break;
                }
            }
            ri0Var.invoke(jeVar.o());
            return;
        }
    }

    @Override // defpackage.xi0, defpackage.fi0, defpackage.j81
    public final void b(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        Object objZ = z();
        if (objZ instanceof uk) {
            return;
        }
        if ((objZ instanceof vi0) && ((vi0) objZ).d()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new gi0(q(), null, this);
        }
        o(cancellationException);
    }

    @Override // defpackage.df1
    public final Object d(ff0 ff0Var, jk jkVar) {
        return this.j.d(ff0Var, jkVar);
    }

    @Override // defpackage.j81
    public final Object e() {
        return this.j.e();
    }

    @Override // defpackage.df1
    public final Object f(Object obj) {
        return this.j.f(obj);
    }

    @Override // defpackage.j81
    public final Object g(lk lkVar) {
        je jeVar = this.j;
        jeVar.getClass();
        return je.y(jeVar, lkVar);
    }

    @Override // defpackage.xi0
    public final void o(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        this.j.j(true, cancellationException);
        m(cancellationException);
    }
}
