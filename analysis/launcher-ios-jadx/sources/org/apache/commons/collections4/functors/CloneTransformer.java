package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes.dex */
public class CloneTransformer<T> implements Transformer<T, T> {
    public static final Transformer INSTANCE = new CloneTransformer();

    private CloneTransformer() {
    }

    public static <T> Transformer<T, T> cloneTransformer() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Transformer
    public T transform(T t) {
        if (t == null) {
            return null;
        }
        return (T) PrototypeFactory.prototypeFactory(t).create();
    }
}
