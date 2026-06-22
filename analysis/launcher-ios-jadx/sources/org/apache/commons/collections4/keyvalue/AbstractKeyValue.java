package org.apache.commons.collections4.keyvalue;

import org.apache.commons.collections4.KeyValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractKeyValue<K, V> implements KeyValue<K, V> {
    private K key;
    private V value;

    public AbstractKeyValue(K k, V v) {
        this.key = k;
        this.value = v;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public K getKey() {
        return this.key;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public V getValue() {
        return this.value;
    }

    public K setKey(K k) {
        K k2 = this.key;
        this.key = k;
        return k2;
    }

    public V setValue(V v) {
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
