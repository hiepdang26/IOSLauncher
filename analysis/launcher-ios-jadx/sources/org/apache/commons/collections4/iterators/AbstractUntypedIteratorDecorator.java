package org.apache.commons.collections4.iterators;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractUntypedIteratorDecorator<I, O> implements Iterator<O> {
    private final Iterator<I> iterator;

    public AbstractUntypedIteratorDecorator(Iterator<I> it) {
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.iterator = it;
    }

    public Iterator<I> getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }
}
