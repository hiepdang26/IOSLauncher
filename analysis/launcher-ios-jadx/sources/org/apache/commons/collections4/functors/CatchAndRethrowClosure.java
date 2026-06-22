package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.FunctorException;

/* JADX INFO: loaded from: classes.dex */
public abstract class CatchAndRethrowClosure<E> implements Closure<E> {
    @Override // org.apache.commons.collections4.Closure
    public void execute(E e) {
        try {
            executeAndThrow(e);
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Throwable th) {
            throw new FunctorException(th);
        }
    }

    public abstract void executeAndThrow(E e);
}
