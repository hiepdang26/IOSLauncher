package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class g9 implements Collection, Set {
    public int[] g = z71.a;
    public Object[] h = z71.b;
    public int i;

    public g9(int i) {
        if (i > 0) {
            hs0.a(this, i);
        }
    }

    public final void a(int i) {
        int i2 = this.i;
        Object[] objArr = this.h;
        Object obj = objArr[i];
        if (i2 <= 1) {
            clear();
            return;
        }
        int i3 = i2 - 1;
        int[] iArr = this.g;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            if (i < i3) {
                int i4 = i + 1;
                h9.A(i, i4, i2, iArr, iArr);
                Object[] objArr2 = this.h;
                h9.B(objArr2, i, objArr2, i4, i2);
            }
            this.h[i3] = null;
        } else {
            hs0.a(this, i2 > 8 ? i2 + (i2 >> 1) : 8);
            if (i > 0) {
                h9.A(0, 0, i, iArr, this.g);
                h9.C(objArr, 0, this.h, i, 6);
            }
            if (i < i3) {
                int i5 = i + 1;
                h9.A(i, i5, i2, iArr, this.g);
                h9.B(objArr, i, this.h, i5, i2);
            }
        }
        if (i2 != this.i) {
            throw new ConcurrentModificationException();
        }
        this.i = i3;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i;
        int iN;
        int i2 = this.i;
        if (obj == null) {
            iN = hs0.n(this, null, 0);
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iN = hs0.n(this, obj, iHashCode);
        }
        if (iN >= 0) {
            return false;
        }
        int i3 = ~iN;
        int[] iArr = this.g;
        if (i2 >= iArr.length) {
            int i4 = 8;
            if (i2 >= 8) {
                i4 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.h;
            hs0.a(this, i4);
            if (i2 != this.i) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.g;
            if (iArr2.length != 0) {
                h9.A(0, 0, iArr.length, iArr, iArr2);
                h9.C(objArr, 0, this.h, objArr.length, 6);
            }
        }
        if (i3 < i2) {
            int[] iArr3 = this.g;
            int i5 = i3 + 1;
            h9.A(i5, i3, i2, iArr3, iArr3);
            Object[] objArr2 = this.h;
            h9.B(objArr2, i5, objArr2, i3, i2);
        }
        int i6 = this.i;
        if (i2 == i6) {
            int[] iArr4 = this.g;
            if (i3 < iArr4.length) {
                iArr4[i3] = i;
                this.h[i3] = obj;
                this.i = i6 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        qg0.l(collection, "elements");
        int size = collection.size() + this.i;
        int i = this.i;
        int[] iArr = this.g;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.h;
            hs0.a(this, size);
            int i2 = this.i;
            if (i2 > 0) {
                h9.A(0, 0, i2, iArr, this.g);
                h9.C(objArr, 0, this.h, this.i, 6);
            }
        }
        if (this.i != i) {
            throw new ConcurrentModificationException();
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.i != 0) {
            this.g = z71.a;
            this.h = z71.b;
            this.i = 0;
        }
        if (this.i != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? hs0.n(this, null, 0) : hs0.n(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        qg0.l(collection, "elements");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || this.i != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = this.i;
            for (int i2 = 0; i2 < i; i2++) {
                if (!((Set) obj).contains(this.h[i2])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.g;
        int i = this.i;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.i <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new b9(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iN = obj == null ? hs0.n(this, null, 0) : hs0.n(this, obj, obj.hashCode());
        if (iN < 0) {
            return false;
        }
        a(iN);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        qg0.l(collection, "elements");
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean zContains;
        qg0.l(collection, "elements");
        int i = this.i - 1;
        boolean z = false;
        while (true) {
            int iIndexOf = -1;
            if (-1 >= i) {
                return z;
            }
            Collection collection2 = collection;
            Object obj = this.h[i];
            if (collection2 instanceof Collection) {
                zContains = collection2.contains(obj);
            } else {
                if (!(collection2 instanceof List)) {
                    Iterator it = collection2.iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (i2 < 0) {
                            throw new ArithmeticException("Index overflow has happened.");
                        }
                        if (qg0.d(obj, next)) {
                            iIndexOf = i2;
                            break;
                        }
                        i2++;
                    }
                } else {
                    iIndexOf = ((List) collection2).indexOf(obj);
                }
                zContains = iIndexOf >= 0;
            }
            if (!zContains) {
                a(i);
                z = true;
            }
            i--;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.i;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return h9.D(0, this.i, this.h);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.i * 14);
        sb.append('{');
        int i = this.i;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.h[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        qg0.k(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        qg0.l(objArr, "array");
        int i = this.i;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        } else if (objArr.length > i) {
            objArr[i] = null;
        }
        h9.B(this.h, 0, objArr, 0, this.i);
        return objArr;
    }
}
