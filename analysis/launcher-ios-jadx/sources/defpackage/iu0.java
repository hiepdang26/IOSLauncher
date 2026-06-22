package defpackage;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class iu0 extends fq0 {
    @Override // defpackage.fq0
    public final void c(Object obj, Object obj2) {
        ju0 ju0Var = (ju0) obj;
        ju0Var.getClass();
        ArrayDeque arrayDeque = ju0.b;
        synchronized (arrayDeque) {
            arrayDeque.offer(ju0Var);
        }
    }
}
