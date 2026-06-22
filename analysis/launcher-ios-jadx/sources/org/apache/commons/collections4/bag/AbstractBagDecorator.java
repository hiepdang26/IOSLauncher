package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBagDecorator<E> extends AbstractCollectionDecorator<E> implements Bag<E> {
    private static final long serialVersionUID = -3768146017343785417L;

    public AbstractBagDecorator() {
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E e, int i) {
        return decorated().add(e, i);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object obj) {
        return decorated().getCount(obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object obj, int i) {
        return decorated().remove(obj, i);
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        return decorated().uniqueSet();
    }

    public AbstractBagDecorator(Bag<E> bag) {
        super(bag);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public Bag<E> decorated() {
        return (Bag) super.decorated();
    }
}
