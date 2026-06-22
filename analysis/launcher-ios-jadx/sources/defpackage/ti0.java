package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class ti0 extends np0 implements dw, cf0, o70 {
    public xi0 j;

    @Override // defpackage.cf0
    public final boolean a() {
        return true;
    }

    @Override // defpackage.dw
    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2;
        xi0 xi0VarL = l();
        while (true) {
            Object objZ = xi0VarL.z();
            if (objZ instanceof ti0) {
                if (objZ != this) {
                    return;
                }
                qz qzVar = hg0.j;
                do {
                    atomicReferenceFieldUpdater2 = xi0.g;
                    if (atomicReferenceFieldUpdater2.compareAndSet(xi0VarL, objZ, qzVar)) {
                        return;
                    }
                } while (atomicReferenceFieldUpdater2.get(xi0VarL) == objZ);
            } else {
                if (!(objZ instanceof cf0) || ((cf0) objZ).f() == null) {
                    return;
                }
                while (true) {
                    Object objI = i();
                    if (objI instanceof ca1) {
                        np0 np0Var = ((ca1) objI).a;
                        return;
                    }
                    if (objI == this) {
                        return;
                    }
                    qg0.i(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                    np0 np0Var2 = (np0) objI;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = np0.i;
                    ca1 ca1Var = (ca1) atomicReferenceFieldUpdater3.get(np0Var2);
                    if (ca1Var == null) {
                        ca1Var = new ca1(np0Var2);
                        atomicReferenceFieldUpdater3.lazySet(np0Var2, ca1Var);
                    }
                    do {
                        atomicReferenceFieldUpdater = np0.g;
                        if (atomicReferenceFieldUpdater.compareAndSet(this, objI, ca1Var)) {
                            np0Var2.g();
                            return;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == objI);
                }
            }
        }
    }

    @Override // defpackage.cf0
    public final px0 f() {
        return null;
    }

    public final xi0 l() {
        xi0 xi0Var = this.j;
        if (xi0Var != null) {
            return xi0Var;
        }
        qg0.O("job");
        throw null;
    }

    public abstract void m(Throwable th);

    @Override // defpackage.np0
    public final String toString() {
        return getClass().getSimpleName() + '@' + os.e(this) + "[job@" + os.e(l()) + ']';
    }
}
