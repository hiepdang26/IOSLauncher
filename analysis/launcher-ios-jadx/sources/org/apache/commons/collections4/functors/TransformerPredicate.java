package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes.dex */
public final class TransformerPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = -2407966402920578741L;
    private final Transformer<? super T, Boolean> iTransformer;

    public TransformerPredicate(Transformer<? super T, Boolean> transformer) {
        this.iTransformer = transformer;
    }

    public static <T> Predicate<T> transformerPredicate(Transformer<? super T, Boolean> transformer) {
        if (transformer != null) {
            return new TransformerPredicate(transformer);
        }
        throw new NullPointerException("The transformer to call must not be null");
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        Boolean boolTransform = this.iTransformer.transform(t);
        if (boolTransform != null) {
            return boolTransform.booleanValue();
        }
        throw new FunctorException("Transformer must return an instanceof Boolean, it was a null object");
    }

    public Transformer<? super T, Boolean> getTransformer() {
        return this.iTransformer;
    }
}
