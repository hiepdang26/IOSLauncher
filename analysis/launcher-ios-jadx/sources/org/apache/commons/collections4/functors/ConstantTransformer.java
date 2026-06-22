package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes.dex */
public class ConstantTransformer<I, O> implements Transformer<I, O>, Serializable {
    public static final Transformer NULL_INSTANCE = new ConstantTransformer(null);
    private static final long serialVersionUID = 6374440726369055124L;
    private final O iConstant;

    public ConstantTransformer(O o) {
        this.iConstant = o;
    }

    public static <I, O> Transformer<I, O> constantTransformer(O o) {
        return o == null ? nullTransformer() : new ConstantTransformer(o);
    }

    public static <I, O> Transformer<I, O> nullTransformer() {
        return NULL_INSTANCE;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConstantTransformer)) {
            return false;
        }
        Object constant = ((ConstantTransformer) obj).getConstant();
        return constant == getConstant() || (constant != null && constant.equals(getConstant()));
    }

    public O getConstant() {
        return this.iConstant;
    }

    public int hashCode() {
        if (getConstant() != null) {
            return getConstant().hashCode() | (-144463148);
        }
        return -144463148;
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I i) {
        return this.iConstant;
    }
}
