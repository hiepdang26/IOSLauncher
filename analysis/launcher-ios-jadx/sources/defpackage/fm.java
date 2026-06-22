package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class fm implements ef1 {
    public final AtomicReference a;

    public fm(if1 if1Var) {
        this.a = new AtomicReference(if1Var);
    }

    @Override // defpackage.ef1
    public final Iterator iterator() {
        ef1 ef1Var = (ef1) this.a.getAndSet(null);
        if (ef1Var != null) {
            return ef1Var.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
