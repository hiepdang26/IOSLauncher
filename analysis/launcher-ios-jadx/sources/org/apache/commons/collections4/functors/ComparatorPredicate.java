package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class ComparatorPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = -1863209236504077399L;
    private final Comparator<T> comparator;
    private final Criterion criterion;
    private final T object;

    /* JADX INFO: renamed from: org.apache.commons.collections4.functors.ComparatorPredicate$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion;

        static {
            int[] iArr = new int[Criterion.values().length];
            $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion = iArr;
            try {
                iArr[Criterion.EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[Criterion.GREATER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[Criterion.LESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[Criterion.GREATER_OR_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[Criterion.LESS_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum Criterion {
        EQUAL,
        GREATER,
        LESS,
        GREATER_OR_EQUAL,
        LESS_OR_EQUAL
    }

    public ComparatorPredicate(T t, Comparator<T> comparator, Criterion criterion) {
        this.object = t;
        this.comparator = comparator;
        this.criterion = criterion;
    }

    public static <T> Predicate<T> comparatorPredicate(T t, Comparator<T> comparator) {
        return comparatorPredicate(t, comparator, Criterion.EQUAL);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        int iCompare = this.comparator.compare(this.object, t);
        int i = AnonymousClass1.$SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion[this.criterion.ordinal()];
        if (i == 1) {
            return iCompare == 0;
        }
        if (i == 2) {
            return iCompare > 0;
        }
        if (i == 3) {
            return iCompare < 0;
        }
        if (i == 4) {
            return iCompare >= 0;
        }
        if (i == 5) {
            return iCompare <= 0;
        }
        throw new IllegalStateException("The current criterion '" + this.criterion + "' is invalid.");
    }

    public static <T> Predicate<T> comparatorPredicate(T t, Comparator<T> comparator, Criterion criterion) {
        if (comparator == null) {
            throw new NullPointerException("Comparator must not be null.");
        }
        if (criterion != null) {
            return new ComparatorPredicate(t, comparator, criterion);
        }
        throw new NullPointerException("Criterion must not be null.");
    }
}
