package org.apache.commons.collections4.multimap;

import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FluentIterable;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes.dex */
public class TransformedMultiValuedMap<K, V> extends AbstractMultiValuedMapDecorator<K, V> {
    private static final long serialVersionUID = 20150612;
    private final Transformer<? super K, ? extends K> keyTransformer;
    private final Transformer<? super V, ? extends V> valueTransformer;

    public TransformedMultiValuedMap(MultiValuedMap<K, V> multiValuedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        super(multiValuedMap);
        this.keyTransformer = transformer;
        this.valueTransformer = transformer2;
    }

    public static <K, V> TransformedMultiValuedMap<K, V> transformedMap(MultiValuedMap<K, V> multiValuedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        TransformedMultiValuedMap<K, V> transformedMultiValuedMap = new TransformedMultiValuedMap<>(multiValuedMap, transformer, transformer2);
        if (!multiValuedMap.isEmpty()) {
            ArrayListValuedHashMap arrayListValuedHashMap = new ArrayListValuedHashMap(multiValuedMap);
            transformedMultiValuedMap.clear();
            transformedMultiValuedMap.putAll(arrayListValuedHashMap);
        }
        return transformedMultiValuedMap;
    }

    public static <K, V> TransformedMultiValuedMap<K, V> transformingMap(MultiValuedMap<K, V> multiValuedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return new TransformedMultiValuedMap<>(multiValuedMap, transformer, transformer2);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean put(K k, V v) {
        return decorated().put(transformKey(k), transformValue(v));
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        if (iterable == null) {
            throw new NullPointerException("Values must not be null.");
        }
        Iterator<E> it = FluentIterable.of((Iterable) iterable).transform(this.valueTransformer).iterator();
        return it.hasNext() && CollectionUtils.addAll(decorated().get(transformKey(k)), it);
    }

    public K transformKey(K k) {
        Transformer<? super K, ? extends K> transformer = this.keyTransformer;
        return transformer == null ? k : transformer.transform(k);
    }

    public V transformValue(V v) {
        Transformer<? super V, ? extends V> transformer = this.valueTransformer;
        return transformer == null ? v : transformer.transform(v);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(Map<? extends K, ? extends V> map) {
        if (map != null) {
            boolean zPut = false;
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                zPut |= put(entry.getKey(), entry.getValue());
            }
            return zPut;
        }
        throw new NullPointerException("Map must not be null.");
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(MultiValuedMap<? extends K, ? extends V> multiValuedMap) {
        if (multiValuedMap != null) {
            boolean zPut = false;
            for (Map.Entry<? extends K, ? extends V> entry : multiValuedMap.entries()) {
                zPut |= put(entry.getKey(), entry.getValue());
            }
            return zPut;
        }
        throw new NullPointerException("Map must not be null.");
    }
}
