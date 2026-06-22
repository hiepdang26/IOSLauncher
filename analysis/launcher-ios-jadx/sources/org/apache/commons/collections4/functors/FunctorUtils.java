package org.apache.commons.collections4.functors;

import defpackage.uo;
import java.util.Collection;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes.dex */
class FunctorUtils {
    private FunctorUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Closure<T> coerce(Closure<? super T> closure) {
        return closure;
    }

    public static <T> Predicate<T>[] copy(Predicate<? super T>... predicateArr) {
        if (predicateArr == null) {
            return null;
        }
        return (Predicate[]) predicateArr.clone();
    }

    public static void validate(Predicate<?>... predicateArr) {
        if (predicateArr == null) {
            throw new NullPointerException("The predicate array must not be null");
        }
        for (int i = 0; i < predicateArr.length; i++) {
            if (predicateArr[i] == null) {
                throw new NullPointerException(uo.d(i, "The predicate array must not contain a null predicate, index ", " was null"));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Predicate<T> coerce(Predicate<? super T> predicate) {
        return predicate;
    }

    public static <E> Closure<E>[] copy(Closure<? super E>... closureArr) {
        if (closureArr == null) {
            return null;
        }
        return (Closure[]) closureArr.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <I, O> Transformer<I, O> coerce(Transformer<? super I, ? extends O> transformer) {
        return transformer;
    }

    public static <I, O> Transformer<I, O>[] copy(Transformer<? super I, ? extends O>... transformerArr) {
        if (transformerArr == null) {
            return null;
        }
        return (Transformer[]) transformerArr.clone();
    }

    public static <T> Predicate<? super T>[] validate(Collection<? extends Predicate<? super T>> collection) {
        if (collection != null) {
            Predicate<? super T>[] predicateArr = new Predicate[collection.size()];
            int i = 0;
            for (Predicate<? super T> predicate : collection) {
                predicateArr[i] = predicate;
                if (predicate == null) {
                    throw new NullPointerException(uo.d(i, "The predicate collection must not contain a null predicate, index ", " was null"));
                }
                i++;
            }
            return predicateArr;
        }
        throw new NullPointerException("The predicate collection must not be null");
    }

    public static void validate(Closure<?>... closureArr) {
        if (closureArr != null) {
            for (int i = 0; i < closureArr.length; i++) {
                if (closureArr[i] == null) {
                    throw new NullPointerException(uo.d(i, "The closure array must not contain a null closure, index ", " was null"));
                }
            }
            return;
        }
        throw new NullPointerException("The closure array must not be null");
    }

    public static void validate(Transformer<?, ?>... transformerArr) {
        if (transformerArr != null) {
            for (int i = 0; i < transformerArr.length; i++) {
                if (transformerArr[i] == null) {
                    throw new NullPointerException(uo.d(i, "The transformer array must not contain a null transformer, index ", " was null"));
                }
            }
            return;
        }
        throw new NullPointerException("The transformer array must not be null");
    }
}
