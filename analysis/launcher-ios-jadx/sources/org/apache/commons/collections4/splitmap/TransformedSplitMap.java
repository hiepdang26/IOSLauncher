package org.apache.commons.collections4.splitmap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Put;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.LinkedMap;

/* JADX INFO: loaded from: classes.dex */
public class TransformedSplitMap<J, K, U, V> extends AbstractIterableGetMapDecorator<K, V> implements Put<J, U>, Serializable {
    private static final long serialVersionUID = 5966875321133456994L;
    private final Transformer<? super J, ? extends K> keyTransformer;
    private final Transformer<? super U, ? extends V> valueTransformer;

    public TransformedSplitMap(Map<K, V> map, Transformer<? super J, ? extends K> transformer, Transformer<? super U, ? extends V> transformer2) {
        super(map);
        if (transformer == null) {
            throw new NullPointerException("KeyTransformer must not be null.");
        }
        this.keyTransformer = transformer;
        if (transformer2 == null) {
            throw new NullPointerException("ValueTransformer must not be null.");
        }
        this.valueTransformer = transformer2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    public static <J, K, U, V> TransformedSplitMap<J, K, U, V> transformingMap(Map<K, V> map, Transformer<? super J, ? extends K> transformer, Transformer<? super U, ? extends V> transformer2) {
        return new TransformedSplitMap<>(map, transformer, transformer2);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(decorated());
    }

    public V checkSetValue(U u) {
        return this.valueTransformer.transform(u);
    }

    @Override // org.apache.commons.collections4.Put
    public void clear() {
        decorated().clear();
    }

    @Override // org.apache.commons.collections4.Put
    public V put(J j, U u) {
        return decorated().put(transformKey(j), transformValue(u));
    }

    @Override // org.apache.commons.collections4.Put
    public void putAll(Map<? extends J, ? extends U> map) {
        decorated().putAll(transformMap(map));
    }

    public K transformKey(J j) {
        return this.keyTransformer.transform(j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<K, V> transformMap(Map<? extends J, ? extends U> map) {
        if (map.isEmpty()) {
            return map;
        }
        LinkedMap linkedMap = new LinkedMap(map.size());
        for (Map.Entry entry : map.entrySet()) {
            linkedMap.put(transformKey(entry.getKey()), transformValue(entry.getValue()));
        }
        return linkedMap;
    }

    public V transformValue(U u) {
        return this.valueTransformer.transform(u);
    }
}
