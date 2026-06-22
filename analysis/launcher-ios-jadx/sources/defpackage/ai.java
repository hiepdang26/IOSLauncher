package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class ai extends hi0 {
    public final gg k;

    public ai(gg ggVar) {
        this.k = ggVar;
    }

    @Override // defpackage.o70
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) throws IllegalAccessException, InvocationTargetException {
        m((Throwable) obj);
        return zp1.a;
    }

    @Override // defpackage.ti0
    public final void m(Throwable th) throws IllegalAccessException, InvocationTargetException {
        xi0 xi0VarL = l();
        gg ggVar = this.k;
        ggVar.getClass();
        CancellationException cancellationExceptionW = xi0VarL.w();
        if (ggVar.s()) {
            eo eoVar = ggVar.j;
            qg0.i(eoVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            yv yvVar = (yv) eoVar;
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = yv.n;
                Object obj = atomicReferenceFieldUpdater.get(yvVar);
                wg1 wg1Var = np1.b;
                if (!qg0.d(obj, wg1Var)) {
                    if (!(obj instanceof Throwable)) {
                        while (!atomicReferenceFieldUpdater.compareAndSet(yvVar, obj, null)) {
                            if (atomicReferenceFieldUpdater.get(yvVar) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    return;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(yvVar, wg1Var, cancellationExceptionW)) {
                    if (atomicReferenceFieldUpdater.get(yvVar) != wg1Var) {
                        break;
                    }
                }
                return;
            }
        }
        ggVar.k(cancellationExceptionW);
        if (ggVar.s()) {
            return;
        }
        ggVar.l();
    }
}
