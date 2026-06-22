package org.apache.commons.collections4.queue;

import java.util.Queue;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractQueueDecorator<E> extends AbstractCollectionDecorator<E> implements Queue<E> {
    private static final long serialVersionUID = -2629815475789577029L;

    public AbstractQueueDecorator() {
    }

    @Override // java.util.Queue
    public E element() {
        return decorated().element();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        return decorated().offer(e);
    }

    @Override // java.util.Queue
    public E peek() {
        return decorated().peek();
    }

    @Override // java.util.Queue
    public E poll() {
        return decorated().poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return decorated().remove();
    }

    public AbstractQueueDecorator(Queue<E> queue) {
        super(queue);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public Queue<E> decorated() {
        return (Queue) super.decorated();
    }
}
