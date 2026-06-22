package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final class AnyPredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = 7429999530934647542L;

    public AnyPredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    public static <T> Predicate<T> anyPredicate(Predicate<? super T>... predicateArr) {
        FunctorUtils.validate(predicateArr);
        return predicateArr.length == 0 ? FalsePredicate.falsePredicate() : predicateArr.length == 1 ? (Predicate<T>) predicateArr[0] : new AnyPredicate(FunctorUtils.copy(predicateArr));
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        for (Predicate<? super T> predicate : this.iPredicates) {
            if (predicate.evaluate(t)) {
                return true;
            }
        }
        return false;
    }

    public static <T> Predicate<T> anyPredicate(Collection<? extends Predicate<? super T>> collection) {
        Predicate<T>[] predicateArrValidate = FunctorUtils.validate(collection);
        if (predicateArrValidate.length == 0) {
            return FalsePredicate.falsePredicate();
        }
        if (predicateArrValidate.length == 1) {
            return predicateArrValidate[0];
        }
        return new AnyPredicate(predicateArrValidate);
    }
}
