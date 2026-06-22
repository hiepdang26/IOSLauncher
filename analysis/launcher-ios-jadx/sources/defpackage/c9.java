package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c9 implements Set {
    public final /* synthetic */ e9 g;

    public c9(e9 e9Var) {
        this.g = e9Var;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.g.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.g.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.g.k(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        e9 e9Var = this.g;
        try {
            if (e9Var.i == set.size()) {
                return e9Var.k(set);
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        e9 e9Var = this.g;
        int iHashCode = 0;
        for (int i = e9Var.i - 1; i >= 0; i--) {
            Object objF = e9Var.f(i);
            iHashCode += objF == null ? 0 : objF.hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.g.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new b9(this.g, 0);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        e9 e9Var = this.g;
        int iD = e9Var.d(obj);
        if (iD < 0) {
            return false;
        }
        e9Var.h(iD);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        return this.g.l(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        e9 e9Var = this.g;
        int i = e9Var.i;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (!collection.contains(e9Var.f(i2))) {
                e9Var.h(i2);
            }
        }
        return i != e9Var.i;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.g.i;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        e9 e9Var = this.g;
        int i = e9Var.i;
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = e9Var.f(i2);
        }
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        e9 e9Var = this.g;
        int i = e9Var.i;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = e9Var.f(i2);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}
