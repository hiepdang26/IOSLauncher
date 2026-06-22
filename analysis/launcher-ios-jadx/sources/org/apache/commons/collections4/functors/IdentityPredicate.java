package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final class IdentityPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = -89901658494523293L;
    private final T iValue;

    public IdentityPredicate(T t) {
        this.iValue = t;
    }

    public static <T> Predicate<T> identityPredicate(T t) {
        return t == null ? NullPredicate.nullPredicate() : new IdentityPredicate(t);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        return this.iValue == t;
    }

    public T getValue() {
        return this.iValue;
    }
}
