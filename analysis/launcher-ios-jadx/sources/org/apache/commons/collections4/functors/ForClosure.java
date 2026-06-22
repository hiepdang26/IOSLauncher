package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;

/* JADX INFO: loaded from: classes.dex */
public class ForClosure<E> implements Closure<E> {
    private final Closure<? super E> iClosure;
    private final int iCount;

    public ForClosure(int i, Closure<? super E> closure) {
        this.iCount = i;
        this.iClosure = closure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Closure<E> forClosure(int i, Closure<? super E> closure) {
        return (i <= 0 || closure == 0) ? NOPClosure.nopClosure() : i == 1 ? closure : new ForClosure(i, closure);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e) {
        for (int i = 0; i < this.iCount; i++) {
            this.iClosure.execute(e);
        }
    }

    public Closure<? super E> getClosure() {
        return this.iClosure;
    }

    public int getCount() {
        return this.iCount;
    }
}
