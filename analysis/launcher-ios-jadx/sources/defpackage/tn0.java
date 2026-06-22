package defpackage;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class tn0 extends q implements RandomAccess, Serializable {
    public Object[] g;
    public final int h;
    public int i;
    public final tn0 j;
    public final un0 k;

    public tn0(Object[] objArr, int i, int i2, tn0 tn0Var, un0 un0Var) {
        qg0.l(objArr, "backing");
        qg0.l(un0Var, "root");
        this.g = objArr;
        this.h = i;
        this.i = i2;
        this.j = tn0Var;
        this.k = un0Var;
        ((AbstractList) this).modCount = ((AbstractList) un0Var).modCount;
    }

    @Override // defpackage.q
    public final int a() {
        f();
        return this.i;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g();
        f();
        e(this.h + this.i, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        qg0.l(collection, "elements");
        g();
        f();
        int size = collection.size();
        d(this.h + this.i, collection, size);
        return size > 0;
    }

    @Override // defpackage.q
    public final Object b(int i) {
        g();
        f();
        int i2 = this.i;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
        }
        return h(this.h + i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        g();
        f();
        i(this.h, this.i);
    }

    public final void d(int i, Collection collection, int i2) {
        ((AbstractList) this).modCount++;
        un0 un0Var = this.k;
        tn0 tn0Var = this.j;
        if (tn0Var != null) {
            tn0Var.d(i, collection, i2);
        } else {
            un0 un0Var2 = un0.j;
            un0Var.d(i, collection, i2);
        }
        this.g = un0Var.g;
        this.i += i2;
    }

    public final void e(int i, Object obj) {
        ((AbstractList) this).modCount++;
        un0 un0Var = this.k;
        tn0 tn0Var = this.j;
        if (tn0Var != null) {
            tn0Var.e(i, obj);
        } else {
            un0 un0Var2 = un0.j;
            un0Var.e(i, obj);
        }
        this.g = un0Var.g;
        this.i++;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        f();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return hg0.a(this.g, this.h, this.i, (List) obj);
        }
        return false;
    }

    public final void f() {
        if (((AbstractList) this.k).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void g() {
        if (this.k.i) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        f();
        int i2 = this.i;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
        }
        return this.g[this.h + i];
    }

    public final Object h(int i) {
        Object objH;
        ((AbstractList) this).modCount++;
        tn0 tn0Var = this.j;
        if (tn0Var != null) {
            objH = tn0Var.h(i);
        } else {
            un0 un0Var = un0.j;
            objH = this.k.h(i);
        }
        this.i--;
        return objH;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        f();
        Object[] objArr = this.g;
        int i = this.i;
        int iHashCode = 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[this.h + i2];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i, int i2) {
        if (i2 > 0) {
            ((AbstractList) this).modCount++;
        }
        tn0 tn0Var = this.j;
        if (tn0Var != null) {
            tn0Var.i(i, i2);
        } else {
            un0 un0Var = un0.j;
            this.k.i(i, i2);
        }
        this.i -= i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        f();
        for (int i = 0; i < this.i; i++) {
            if (qg0.d(this.g[this.h + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        f();
        return this.i == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i, int i2, Collection collection, boolean z) {
        int iJ;
        tn0 tn0Var = this.j;
        if (tn0Var != null) {
            iJ = tn0Var.j(i, i2, collection, z);
        } else {
            un0 un0Var = un0.j;
            iJ = this.k.j(i, i2, collection, z);
        }
        if (iJ > 0) {
            ((AbstractList) this).modCount++;
        }
        this.i -= iJ;
        return iJ;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        f();
        for (int i = this.i - 1; i >= 0; i--) {
            if (qg0.d(this.g[this.h + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        g();
        f();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            b(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        qg0.l(collection, "elements");
        g();
        f();
        return j(this.h, this.i, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        qg0.l(collection, "elements");
        g();
        f();
        return j(this.h, this.i, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        g();
        f();
        int i2 = this.i;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
        }
        Object[] objArr = this.g;
        int i3 = this.h;
        Object obj2 = objArr[i3 + i];
        objArr[i3 + i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        qg0.n(i, i2, this.i);
        return new tn0(this.g, this.h + i, i2 - i, this, this.k);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        qg0.l(objArr, "array");
        f();
        int length = objArr.length;
        int i = this.i;
        int i2 = this.h;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.g, i2, i + i2, objArr.getClass());
            qg0.k(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        h9.B(this.g, 0, objArr, i2, i + i2);
        int i3 = this.i;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        f();
        return hg0.b(this.g, this.h, this.i, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        f();
        int i2 = this.i;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
        }
        return new sn0(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        g();
        f();
        int i2 = this.i;
        if (i >= 0 && i <= i2) {
            e(this.h + i, obj);
            return;
        }
        throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        qg0.l(collection, "elements");
        g();
        f();
        int i2 = this.i;
        if (i >= 0 && i <= i2) {
            int size = collection.size();
            d(this.h + i, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        f();
        Object[] objArr = this.g;
        int i = this.i;
        int i2 = this.h;
        return h9.D(i2, i + i2, objArr);
    }
}
