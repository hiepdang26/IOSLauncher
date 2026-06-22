package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final class OnePredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = -8125389089924745785L;

    public OnePredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    public static <T> Predicate<T> onePredicate(Predicate<? super T>... predicateArr) {
        FunctorUtils.validate(predicateArr);
        return predicateArr.length == 0 ? FalsePredicate.falsePredicate() : predicateArr.length == 1 ? (Predicate<T>) predicateArr[0] : new OnePredicate(FunctorUtils.copy(predicateArr));
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        boolean z = false;
        for (Predicate<? super T> predicate : this.iPredicates) {
            if (predicate.evaluate(t)) {
                if (z) {
                    return false;
                }
                z = true;
            }
        }
        return z;
    }

    public static <T> Predicate<T> onePredicate(Collection<? extends Predicate<? super T>> collection) {
        return new OnePredicate(FunctorUtils.validate(collection));
    }
}
