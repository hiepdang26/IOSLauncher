package org.apache.commons.collections4.iterators;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractIteratorDecorator<E> extends AbstractUntypedIteratorDecorator<E, E> {
    public AbstractIteratorDecorator(Iterator<E> it) {
        super(it);
    }

    @Override // java.util.Iterator
    public E next() {
        return getIterator().next();
    }
}
