package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes.dex */
public class ChainedTransformer<T> implements Transformer<T, T>, Serializable {
    private static final long serialVersionUID = 3514945074733160196L;
    private final Transformer<? super T, ? extends T>[] iTransformers;

    private ChainedTransformer(boolean z, Transformer<? super T, ? extends T>[] transformerArr) {
        this.iTransformers = z ? FunctorUtils.copy(transformerArr) : transformerArr;
    }

    public static <T> Transformer<T, T> chainedTransformer(Transformer<? super T, ? extends T>... transformerArr) {
        FunctorUtils.validate(transformerArr);
        return transformerArr.length == 0 ? NOPTransformer.nopTransformer() : new ChainedTransformer(transformerArr);
    }

    public Transformer<? super T, ? extends T>[] getTransformers() {
        return FunctorUtils.copy(this.iTransformers);
    }

    @Override // org.apache.commons.collections4.Transformer
    public T transform(T t) {
        for (Transformer<? super T, ? extends T> transformer : this.iTransformers) {
            t = transformer.transform(t);
        }
        return t;
    }

    public ChainedTransformer(Transformer<? super T, ? extends T>... transformerArr) {
        this(true, transformerArr);
    }

    public static <T> Transformer<T, T> chainedTransformer(Collection<? extends Transformer<? super T, ? extends T>> collection) {
        if (collection != null) {
            if (collection.size() == 0) {
                return NOPTransformer.nopTransformer();
            }
            Transformer[] transformerArr = (Transformer[]) collection.toArray(new Transformer[collection.size()]);
            FunctorUtils.validate((Transformer<?, ?>[]) transformerArr);
            return new ChainedTransformer(false, transformerArr);
        }
        throw new NullPointerException("Transformer collection must not be null");
    }
}
