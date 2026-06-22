package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.AbstractHashedMap;

/* JADX INFO: loaded from: classes.dex */
public class MultiKeyMap<K, V> extends AbstractMapDecorator<MultiKey<? extends K>, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = -1788199231038721040L;

    public MultiKeyMap() {
        this(new HashedMap());
    }

    public static <K, V> MultiKeyMap<K, V> multiKeyMap(AbstractHashedMap<MultiKey<? extends K>, V> abstractHashedMap) {
        if (abstractHashedMap == null) {
            throw new NullPointerException("Map must not be null");
        }
        if (abstractHashedMap.size() <= 0) {
            return new MultiKeyMap<>(abstractHashedMap);
        }
        throw new IllegalArgumentException("Map must be empty");
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    public void checkKey(MultiKey<?> multiKey) {
        if (multiKey == null) {
            throw new NullPointerException("Key must not be null");
        }
    }

    public boolean containsKey(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2)) {
                return true;
            }
        }
        return false;
    }

    public V get(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public int hash(Object obj, Object obj2) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = i ^ (i >>> 14);
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2) {
        MultiKey<? extends K> key = hashEntry.getKey();
        return key.size() == 2 && (obj == key.getKey(0) || (obj != null && obj.equals(key.getKey(0)))) && (obj2 == key.getKey(1) || (obj2 != null && obj2.equals(key.getKey(1))));
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public MapIterator<MultiKey<? extends K>, V> mapIterator() {
        return decorated().mapIterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends MultiKey<? extends K>, ? extends V> map) {
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            checkKey((MultiKey) it.next());
        }
        super.putAll(map);
    }

    public boolean removeAll(Object obj) {
        MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
        boolean z = false;
        while (mapIterator.hasNext()) {
            MultiKey<? extends K> next = mapIterator.next();
            if (next.size() >= 1) {
                if (obj == null) {
                    if (next.getKey(0) == null) {
                        mapIterator.remove();
                        z = true;
                    }
                } else if (obj.equals(next.getKey(0))) {
                    mapIterator.remove();
                    z = true;
                }
            }
        }
        return z;
    }

    public V removeMultiKey(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = null;
        for (AbstractHashedMap.HashEntry<K, V> hashEntry2 = decorated().data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(hashEntry2, obj, obj2)) {
                V value = hashEntry2.getValue();
                decorated().removeMapping(hashEntry2, iHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    public MultiKeyMap(AbstractHashedMap<MultiKey<? extends K>, V> abstractHashedMap) {
        super(abstractHashedMap);
        this.map = abstractHashedMap;
    }

    public MultiKeyMap<K, V> clone() {
        try {
            return (MultiKeyMap) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public AbstractHashedMap<MultiKey<? extends K>, V> decorated() {
        return (AbstractHashedMap) super.decorated();
    }

    public V put(K k, K k2, V v) {
        int iHash = hash(k, k2);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, k, k2)) {
                V value = hashEntry.getValue();
                decorated().updateEntry(hashEntry, v);
                return value;
            }
        }
        decorated().addMapping(iHashIndex, iHash, new MultiKey<>(k, k2), v);
        return null;
    }

    public int hash(Object obj, Object obj2, Object obj3) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = i ^ (i >>> 14);
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2, Object obj3) {
        MultiKey<? extends K> key = hashEntry.getKey();
        return key.size() == 3 && (obj == key.getKey(0) || (obj != null && obj.equals(key.getKey(0)))) && ((obj2 == key.getKey(1) || (obj2 != null && obj2.equals(key.getKey(1)))) && (obj3 == key.getKey(2) || (obj3 != null && obj3.equals(key.getKey(2)))));
    }

    public V get(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public int hash(Object obj, Object obj2, Object obj3, Object obj4) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        if (obj4 != null) {
            iHashCode ^= obj4.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = i ^ (i >>> 14);
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x002f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean removeAll(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            org.apache.commons.collections4.MapIterator r0 = r6.mapIterator()
            r1 = 0
            r2 = 0
        L6:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L45
            java.lang.Object r3 = r0.next()
            org.apache.commons.collections4.keyvalue.MultiKey r3 = (org.apache.commons.collections4.keyvalue.MultiKey) r3
            int r4 = r3.size()
            r5 = 2
            if (r4 < r5) goto L6
            if (r7 != 0) goto L22
            java.lang.Object r4 = r3.getKey(r1)
            if (r4 != 0) goto L6
            goto L2c
        L22:
            java.lang.Object r4 = r3.getKey(r1)
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L6
        L2c:
            r4 = 1
            if (r8 != 0) goto L36
            java.lang.Object r3 = r3.getKey(r4)
            if (r3 != 0) goto L6
            goto L40
        L36:
            java.lang.Object r3 = r3.getKey(r4)
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L6
        L40:
            r0.remove()
            r2 = 1
            goto L6
        L45:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.map.MultiKeyMap.removeAll(java.lang.Object, java.lang.Object):boolean");
    }

    public V removeMultiKey(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = null;
        for (AbstractHashedMap.HashEntry<K, V> hashEntry2 = decorated().data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(hashEntry2, obj, obj2, obj3)) {
                V value = hashEntry2.getValue();
                decorated().removeMapping(hashEntry2, iHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int iHash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
                if (isEqualKey(hashEntry, obj5, obj6, obj7, obj8)) {
                    return true;
                }
            } else {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
            }
            hashEntry = hashEntry.next;
            obj = obj5;
            obj2 = obj6;
            obj3 = obj7;
            obj4 = obj8;
        }
        return false;
    }

    public int hash(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        if (obj4 != null) {
            iHashCode ^= obj4.hashCode();
        }
        if (obj5 != null) {
            iHashCode ^= obj5.hashCode();
        }
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = i ^ (i >>> 14);
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2, Object obj3, Object obj4) {
        MultiKey<? extends K> key = hashEntry.getKey();
        return key.size() == 4 && (obj == key.getKey(0) || (obj != null && obj.equals(key.getKey(0)))) && ((obj2 == key.getKey(1) || (obj2 != null && obj2.equals(key.getKey(1)))) && ((obj3 == key.getKey(2) || (obj3 != null && obj3.equals(key.getKey(2)))) && (obj4 == key.getKey(3) || (obj4 != null && obj4.equals(key.getKey(3))))));
    }

    public V put(K k, K k2, K k3, V v) {
        int iHash = hash(k, k2, k3);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, k, k2, k3)) {
                V value = hashEntry.getValue();
                decorated().updateEntry(hashEntry, v);
                return value;
            }
        }
        decorated().addMapping(iHashIndex, iHash, new MultiKey<>(k, k2, k3), v);
        return null;
    }

    public V get(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int iHash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
                if (isEqualKey(hashEntry, obj5, obj6, obj7, obj8)) {
                    return hashEntry.getValue();
                }
            } else {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
            }
            hashEntry = hashEntry.next;
            obj = obj5;
            obj2 = obj6;
            obj3 = obj7;
            obj4 = obj8;
        }
        return null;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object obj6;
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj6 = obj;
                if (isEqualKey(hashEntry, obj6, obj2, obj3, obj4, obj5)) {
                    return true;
                }
            } else {
                obj6 = obj;
            }
            hashEntry = hashEntry.next;
            obj = obj6;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x002f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean removeAll(java.lang.Object r7, java.lang.Object r8, java.lang.Object r9) {
        /*
            r6 = this;
            org.apache.commons.collections4.MapIterator r0 = r6.mapIterator()
            r1 = 0
            r2 = 0
        L6:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L59
            java.lang.Object r3 = r0.next()
            org.apache.commons.collections4.keyvalue.MultiKey r3 = (org.apache.commons.collections4.keyvalue.MultiKey) r3
            int r4 = r3.size()
            r5 = 3
            if (r4 < r5) goto L6
            if (r7 != 0) goto L22
            java.lang.Object r4 = r3.getKey(r1)
            if (r4 != 0) goto L6
            goto L2c
        L22:
            java.lang.Object r4 = r3.getKey(r1)
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L6
        L2c:
            r4 = 1
            if (r8 != 0) goto L36
            java.lang.Object r5 = r3.getKey(r4)
            if (r5 != 0) goto L6
            goto L40
        L36:
            java.lang.Object r5 = r3.getKey(r4)
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L6
        L40:
            r5 = 2
            if (r9 != 0) goto L4a
            java.lang.Object r3 = r3.getKey(r5)
            if (r3 != 0) goto L6
            goto L54
        L4a:
            java.lang.Object r3 = r3.getKey(r5)
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L6
        L54:
            r0.remove()
            r2 = 1
            goto L6
        L59:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.map.MultiKeyMap.removeAll(java.lang.Object, java.lang.Object, java.lang.Object):boolean");
    }

    public V removeMultiKey(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int iHash = hash(obj, obj2, obj3, obj4);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex];
        AbstractHashedMap.HashEntry<K, V> hashEntry2 = null;
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
                if (isEqualKey(hashEntry, obj5, obj6, obj7, obj8)) {
                    V value = hashEntry.getValue();
                    decorated().removeMapping(hashEntry, iHashIndex, hashEntry2);
                    return value;
                }
            } else {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
            }
            hashEntry2 = hashEntry;
            obj2 = obj6;
            obj3 = obj7;
            obj4 = obj8;
            hashEntry = hashEntry.next;
            obj = obj5;
        }
        return null;
    }

    public V get(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object obj6;
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj6 = obj;
                if (isEqualKey(hashEntry, obj6, obj2, obj3, obj4, obj5)) {
                    return hashEntry.getValue();
                }
            } else {
                obj6 = obj;
            }
            hashEntry = hashEntry.next;
            obj = obj6;
        }
        return null;
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        MultiKey<? extends K> key = hashEntry.getKey();
        return key.size() == 5 && (obj == key.getKey(0) || (obj != null && obj.equals(key.getKey(0)))) && ((obj2 == key.getKey(1) || (obj2 != null && obj2.equals(key.getKey(1)))) && ((obj3 == key.getKey(2) || (obj3 != null && obj3.equals(key.getKey(2)))) && ((obj4 == key.getKey(3) || (obj4 != null && obj4.equals(key.getKey(3)))) && (obj5 == key.getKey(4) || (obj5 != null && obj5.equals(key.getKey(4)))))));
    }

    public V put(K k, K k2, K k3, K k4, V v) {
        K k5;
        K k6;
        K k7;
        K k8;
        int iHash = hash(k, k2, k3, k4);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                k5 = k;
                k6 = k2;
                k7 = k3;
                k8 = k4;
                if (isEqualKey(hashEntry, k5, k6, k7, k8)) {
                    V value = hashEntry.getValue();
                    decorated().updateEntry(hashEntry, v);
                    return value;
                }
            } else {
                k5 = k;
                k6 = k2;
                k7 = k3;
                k8 = k4;
            }
            hashEntry = hashEntry.next;
            k = k5;
            k2 = k6;
            k3 = k7;
            k4 = k8;
        }
        decorated().addMapping(iHashIndex, iHash, new MultiKey<>(k, k2, k3, k4), v);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x004a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x002f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean removeAll(java.lang.Object r7, java.lang.Object r8, java.lang.Object r9, java.lang.Object r10) {
        /*
            r6 = this;
            org.apache.commons.collections4.MapIterator r0 = r6.mapIterator()
            r1 = 0
            r2 = 0
        L6:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L6d
            java.lang.Object r3 = r0.next()
            org.apache.commons.collections4.keyvalue.MultiKey r3 = (org.apache.commons.collections4.keyvalue.MultiKey) r3
            int r4 = r3.size()
            r5 = 4
            if (r4 < r5) goto L6
            if (r7 != 0) goto L22
            java.lang.Object r4 = r3.getKey(r1)
            if (r4 != 0) goto L6
            goto L2c
        L22:
            java.lang.Object r4 = r3.getKey(r1)
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L6
        L2c:
            r4 = 1
            if (r8 != 0) goto L36
            java.lang.Object r5 = r3.getKey(r4)
            if (r5 != 0) goto L6
            goto L40
        L36:
            java.lang.Object r5 = r3.getKey(r4)
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L6
        L40:
            r5 = 2
            if (r9 != 0) goto L4a
            java.lang.Object r5 = r3.getKey(r5)
            if (r5 != 0) goto L6
            goto L54
        L4a:
            java.lang.Object r5 = r3.getKey(r5)
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L6
        L54:
            r5 = 3
            if (r10 != 0) goto L5e
            java.lang.Object r3 = r3.getKey(r5)
            if (r3 != 0) goto L6
            goto L68
        L5e:
            java.lang.Object r3 = r3.getKey(r5)
            boolean r3 = r10.equals(r3)
            if (r3 == 0) goto L6
        L68:
            r0.remove()
            r2 = 1
            goto L6
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.map.MultiKeyMap.removeAll(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):boolean");
    }

    public V removeMultiKey(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex];
        AbstractHashedMap.HashEntry<K, V> hashEntry2 = null;
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3, obj4, obj5)) {
                V value = hashEntry.getValue();
                decorated().removeMapping(hashEntry, iHashIndex, hashEntry2);
                return value;
            }
            AbstractHashedMap.HashEntry<K, V> hashEntry3 = hashEntry;
            hashEntry = hashEntry.next;
            hashEntry2 = hashEntry3;
        }
        return null;
    }

    public V put(K k, K k2, K k3, K k4, K k5, V v) {
        int iHash = hash(k, k2, k3, k4, k5);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, k, k2, k3, k4, k5)) {
                V value = hashEntry.getValue();
                decorated().updateEntry(hashEntry, v);
                return value;
            }
        }
        decorated().addMapping(iHashIndex, iHash, new MultiKey<>(k, k2, k3, k4, k5), v);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public V put(MultiKey<? extends K> multiKey, V v) {
        checkKey(multiKey);
        return (V) super.put(multiKey, v);
    }
}
