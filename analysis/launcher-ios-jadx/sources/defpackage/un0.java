package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class un0 extends q implements RandomAccess, Serializable {
    public static final un0 j;
    public Object[] g;
    public int h;
    public boolean i;

    static {
        un0 un0Var = new un0(0);
        un0Var.i = true;
        j = un0Var;
    }

    public un0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.g = new Object[i];
    }

    @Override // defpackage.q
    public final int a() {
        return this.h;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        f();
        int i = this.h;
        ((AbstractList) this).modCount++;
        g(i, 1);
        this.g[i] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        qg0.l(collection, "elements");
        f();
        int size = collection.size();
        d(this.h, collection, size);
        return size > 0;
    }

    @Override // defpackage.q
    public final Object b(int i) {
        f();
        int i2 = this.h;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
        }
        return h(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        i(0, this.h);
    }

    public final void d(int i, Collection collection, int i2) {
        ((AbstractList) this).modCount++;
        g(i, i2);
        Iterator it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.g[i + i3] = it.next();
        }
    }

    public final void e(int i, Object obj) {
        ((AbstractList) this).modCount++;
        g(i, 1);
        this.g[i] = obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            if (hg0.a(this.g, 0, this.h, (List) obj)) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (this.i) {
            throw new UnsupportedOperationException();
        }
    }

    public final void g(int i, int i2) {
        int i3 = this.h + i2;
        if (i3 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.g;
        if (i3 > objArr.length) {
            int length = objArr.length;
            int i4 = length + (length >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            if (i4 - 2147483639 > 0) {
                i4 = i3 > 2147483639 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : 2147483639;
            }
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i4);
            qg0.k(objArrCopyOf, "copyOf(...)");
            this.g = objArrCopyOf;
        }
        Object[] objArr2 = this.g;
        h9.B(objArr2, i + i2, objArr2, i, this.h);
        this.h += i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2 = this.h;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
        }
        return this.g[i];
    }

    public final Object h(int i) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.g;
        Object obj = objArr[i];
        h9.B(objArr, i, objArr, i + 1, this.h);
        Object[] objArr2 = this.g;
        int i2 = this.h - 1;
        qg0.l(objArr2, "<this>");
        objArr2[i2] = null;
        this.h--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.g;
        int i = this.h;
        int iHashCode = 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i, int i2) {
        if (i2 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.g;
        h9.B(objArr, i, objArr, i + i2, this.h);
        Object[] objArr2 = this.g;
        int i3 = this.h;
        hg0.A(i3 - i2, i3, objArr2);
        this.h -= i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.h; i++) {
            if (qg0.d(this.g[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.h == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i, int i2, Collection collection, boolean z) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.g[i5]) == z) {
                Object[] objArr = this.g;
                i3++;
                objArr[i4 + i] = objArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        Object[] objArr2 = this.g;
        h9.B(objArr2, i + i4, objArr2, i2 + i, this.h);
        Object[] objArr3 = this.g;
        int i7 = this.h;
        hg0.A(i7 - i6, i7, objArr3);
        if (i6 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.h -= i6;
        return i6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i = this.h - 1; i >= 0; i--) {
            if (qg0.d(this.g[i], obj)) {
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
        f();
        return j(0, this.h, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        qg0.l(collection, "elements");
        f();
        return j(0, this.h, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        f();
        int i2 = this.h;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
        }
        Object[] objArr = this.g;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        qg0.n(i, i2, this.h);
        return new tn0(this.g, i, i2 - i, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        qg0.l(objArr, "array");
        int length = objArr.length;
        int i = this.h;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.g, 0, i, objArr.getClass());
            qg0.k(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        h9.B(this.g, 0, objArr, 0, i);
        int i2 = this.h;
        if (i2 < objArr.length) {
            objArr[i2] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return hg0.b(this.g, 0, this.h, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        int i2 = this.h;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
        }
        return new sn0(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        qg0.l(collection, "elements");
        f();
        int i2 = this.h;
        if (i >= 0 && i <= i2) {
            int size = collection.size();
            d(i, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        f();
        int i2 = this.h;
        if (i >= 0 && i <= i2) {
            ((AbstractList) this).modCount++;
            g(i, 1);
            this.g[i] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return h9.D(0, this.h, this.g);
    }
}
