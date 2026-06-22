package org.apache.commons.collections4.map;

import defpackage.uo;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.map.AbstractHashedMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractLinkedMap<K, V> extends AbstractHashedMap<K, V> implements OrderedMap<K, V> {
    transient LinkEntry<K, V> header;

    public static class EntrySetIterator<K, V> extends LinkIterator<K, V> implements OrderedIterator<Map.Entry<K, V>>, ResettableIterator<Map.Entry<K, V>> {
        public EntrySetIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return super.nextEntry();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public Map.Entry<K, V> previous() {
            return super.previousEntry();
        }
    }

    public static class KeySetIterator<K> extends LinkIterator<K, Object> implements OrderedIterator<K>, ResettableIterator<K> {
        public KeySetIterator(AbstractLinkedMap<K, ?> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return super.previousEntry().getKey();
        }
    }

    public static class LinkEntry<K, V> extends AbstractHashedMap.HashEntry<K, V> {
        protected LinkEntry<K, V> after;
        protected LinkEntry<K, V> before;

        public LinkEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i, Object obj, V v) {
            super(hashEntry, i, obj, v);
        }
    }

    public static abstract class LinkIterator<K, V> {
        protected int expectedModCount;
        protected LinkEntry<K, V> last;
        protected LinkEntry<K, V> next;
        protected final AbstractLinkedMap<K, V> parent;

        public LinkIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            this.parent = abstractLinkedMap;
            this.next = abstractLinkedMap.header.after;
            this.expectedModCount = abstractLinkedMap.modCount;
        }

        public LinkEntry<K, V> currentEntry() {
            return this.last;
        }

        public boolean hasNext() {
            return this.next != this.parent.header;
        }

        public boolean hasPrevious() {
            return this.next.before != this.parent.header;
        }

        public LinkEntry<K, V> nextEntry() {
            AbstractLinkedMap<K, V> abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            LinkEntry<K, V> linkEntry = this.next;
            if (linkEntry == abstractLinkedMap.header) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            this.last = linkEntry;
            this.next = linkEntry.after;
            return linkEntry;
        }

        public LinkEntry<K, V> previousEntry() {
            AbstractLinkedMap<K, V> abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            LinkEntry<K, V> linkEntry = this.next.before;
            if (linkEntry == abstractLinkedMap.header) {
                throw new NoSuchElementException("No previous() entry in the iteration");
            }
            this.next = linkEntry;
            this.last = linkEntry;
            return linkEntry;
        }

        public void remove() {
            LinkEntry<K, V> linkEntry = this.last;
            if (linkEntry == null) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            AbstractLinkedMap<K, V> abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            abstractLinkedMap.remove(linkEntry.getKey());
            this.last = null;
            this.expectedModCount = this.parent.modCount;
        }

        public void reset() {
            this.last = null;
            this.next = this.parent.header.after;
        }

        public String toString() {
            if (this.last == null) {
                return "Iterator[]";
            }
            return "Iterator[" + this.last.getKey() + "=" + this.last.getValue() + "]";
        }
    }

    public static class LinkMapIterator<K, V> extends LinkIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        public LinkMapIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            LinkEntry<K, V> linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry != null) {
                return linkEntryCurrentEntry.getKey();
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            LinkEntry<K, V> linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry != null) {
                return linkEntryCurrentEntry.getValue();
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return super.previousEntry().getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            LinkEntry<K, V> linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry != null) {
                return linkEntryCurrentEntry.setValue(v);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }
    }

    public static class ValuesIterator<V> extends LinkIterator<Object, V> implements OrderedIterator<V>, ResettableIterator<V> {
        public ValuesIterator(AbstractLinkedMap<?, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public V next() {
            return super.nextEntry().getValue();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public V previous() {
            return super.previousEntry().getValue();
        }
    }

    public AbstractLinkedMap() {
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void addEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i) {
        LinkEntry<K, V> linkEntry = (LinkEntry) hashEntry;
        LinkEntry<K, V> linkEntry2 = this.header;
        linkEntry.after = linkEntry2;
        linkEntry.before = linkEntry2.before;
        linkEntry2.before.after = linkEntry;
        linkEntry2.before = linkEntry;
        this.data[i] = linkEntry;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        super.clear();
        LinkEntry<K, V> linkEntry = this.header;
        linkEntry.after = linkEntry;
        linkEntry.before = linkEntry;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        if (obj == null) {
            LinkEntry<K, V> linkEntry = this.header;
            do {
                linkEntry = linkEntry.after;
                if (linkEntry == this.header) {
                    return false;
                }
            } while (linkEntry.getValue() != null);
            return true;
        }
        LinkEntry<K, V> linkEntry2 = this.header;
        do {
            linkEntry2 = linkEntry2.after;
            if (linkEntry2 == this.header) {
                return false;
            }
        } while (!isEqualValue(obj, linkEntry2.getValue()));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public /* bridge */ /* synthetic */ AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i, Object obj, Object obj2) {
        return createEntry((AbstractHashedMap.HashEntry<Object, Object>) hashEntry, i, obj, obj2);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        return size() == 0 ? EmptyOrderedIterator.emptyOrderedIterator() : new EntrySetIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<K> createKeySetIterator() {
        return size() == 0 ? EmptyOrderedIterator.emptyOrderedIterator() : new KeySetIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<V> createValuesIterator() {
        return size() == 0 ? EmptyOrderedIterator.emptyOrderedIterator() : new ValuesIterator(this);
    }

    public LinkEntry<K, V> entryAfter(LinkEntry<K, V> linkEntry) {
        return linkEntry.after;
    }

    public LinkEntry<K, V> entryBefore(LinkEntry<K, V> linkEntry) {
        return linkEntry.before;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (this.size != 0) {
            return this.header.after.getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void init() {
        LinkEntry<K, V> linkEntryCreateEntry = createEntry((AbstractHashedMap.HashEntry) null, -1, (Object) null, (Object) null);
        this.header = linkEntryCreateEntry;
        linkEntryCreateEntry.after = linkEntryCreateEntry;
        linkEntryCreateEntry.before = linkEntryCreateEntry;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        if (this.size != 0) {
            return this.header.before.getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(Object obj) {
        LinkEntry<K, V> linkEntry;
        LinkEntry<K, V> entry = getEntry(obj);
        if (entry == null || (linkEntry = entry.after) == this.header) {
            return null;
        }
        return linkEntry.getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(Object obj) {
        LinkEntry<K, V> linkEntry;
        LinkEntry<K, V> entry = getEntry(obj);
        if (entry == null || (linkEntry = entry.before) == this.header) {
            return null;
        }
        return linkEntry.getKey();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void removeEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i, AbstractHashedMap.HashEntry<K, V> hashEntry2) {
        LinkEntry linkEntry = (LinkEntry) hashEntry;
        LinkEntry<K, V> linkEntry2 = linkEntry.before;
        linkEntry2.after = linkEntry.after;
        linkEntry.after.before = linkEntry2;
        linkEntry.after = null;
        linkEntry.before = null;
        super.removeEntry(hashEntry, i, hashEntry2);
    }

    public AbstractLinkedMap(int i, float f, int i2) {
        super(i, f, i2);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public LinkEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i, K k, V v) {
        return new LinkEntry<>(hashEntry, i, convertKey(k), v);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public LinkEntry<K, V> getEntry(Object obj) {
        return (LinkEntry) super.getEntry(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return this.size == 0 ? EmptyOrderedMapIterator.emptyOrderedMapIterator() : new LinkMapIterator(this);
    }

    public AbstractLinkedMap(int i) {
        super(i);
    }

    public LinkEntry<K, V> getEntry(int i) {
        if (i >= 0) {
            int i2 = this.size;
            if (i < i2) {
                if (i < i2 / 2) {
                    LinkEntry<K, V> linkEntry = this.header.after;
                    for (int i3 = 0; i3 < i; i3++) {
                        linkEntry = linkEntry.after;
                    }
                    return linkEntry;
                }
                LinkEntry<K, V> linkEntry2 = this.header;
                while (i2 > i) {
                    linkEntry2 = linkEntry2.before;
                    i2--;
                }
                return linkEntry2;
            }
            StringBuilder sbL = uo.l(i, "Index ", " is invalid for size ");
            sbL.append(this.size);
            throw new IndexOutOfBoundsException(sbL.toString());
        }
        throw new IndexOutOfBoundsException(uo.d(i, "Index ", " is less than zero"));
    }

    public AbstractLinkedMap(int i, float f) {
        super(i, f);
    }

    public AbstractLinkedMap(Map<? extends K, ? extends V> map) {
        super(map);
    }
}
