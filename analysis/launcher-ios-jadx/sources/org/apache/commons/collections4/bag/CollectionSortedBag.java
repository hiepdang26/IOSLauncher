package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections4.SortedBag;

/* JADX INFO: loaded from: classes.dex */
public final class CollectionSortedBag<E> extends AbstractSortedBagDecorator<E> {
    private static final long serialVersionUID = -2560033712679053143L;

    public CollectionSortedBag(SortedBag<E> sortedBag) {
        super(sortedBag);
    }

    public static <E> SortedBag<E> collectionSortedBag(SortedBag<E> sortedBag) {
        return new CollectionSortedBag(sortedBag);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        setCollection((Collection) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(decorated());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e) {
        return add(e, 1);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        boolean z;
        Iterator<? extends E> it = collection.iterator();
        while (true) {
            while (it.hasNext()) {
                z = z || add(it.next(), 1);
            }
            return z;
        }
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        return remove(obj, 1);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        boolean z;
        if (collection == null) {
            return decorated().removeAll(null);
        }
        while (true) {
            for (Object obj : collection) {
                z = z || remove(obj, getCount(obj));
            }
            return z;
        }
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        if (collection == null) {
            return decorated().retainAll(null);
        }
        Iterator<E> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // org.apache.commons.collections4.bag.AbstractBagDecorator, org.apache.commons.collections4.Bag
    public boolean add(E e, int i) {
        decorated().add(e, i);
        return true;
    }
}
