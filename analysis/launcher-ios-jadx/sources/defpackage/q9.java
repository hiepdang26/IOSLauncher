package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class q9 extends nz0 {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(q9.class, Object.class, "_consensus");
    private volatile Object _consensus = os.a;

    @Override // defpackage.nz0
    public final Object a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        wg1 wg1Var = os.a;
        if (obj2 == wg1Var) {
            wg1 wg1VarC = c(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == wg1Var) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, wg1Var, wg1VarC)) {
                        obj2 = wg1VarC;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != wg1Var) {
                        obj2 = atomicReferenceFieldUpdater.get(this);
                        break;
                    }
                }
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract wg1 c(Object obj);
}
