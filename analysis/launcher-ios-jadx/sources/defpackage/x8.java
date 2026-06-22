package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class x8 extends q {
    public static final Object[] j = new Object[0];
    public int g;
    public Object[] h = j;
    public int i;

    @Override // defpackage.q
    public final int a() {
        return this.i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int length;
        int i2 = this.i;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
        }
        if (i == i2) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        i();
        d(this.i + 1);
        int iH = h(this.g + i);
        int i3 = this.i;
        if (i < ((i3 + 1) >> 1)) {
            if (iH == 0) {
                Object[] objArr = this.h;
                qg0.l(objArr, "<this>");
                iH = objArr.length;
            }
            int i4 = iH - 1;
            int i5 = this.g;
            if (i5 == 0) {
                Object[] objArr2 = this.h;
                qg0.l(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i5 - 1;
            }
            int i6 = this.g;
            if (i4 >= i6) {
                Object[] objArr3 = this.h;
                objArr3[length] = objArr3[i6];
                h9.B(objArr3, i6, objArr3, i6 + 1, i4 + 1);
            } else {
                Object[] objArr4 = this.h;
                h9.B(objArr4, i6 - 1, objArr4, i6, objArr4.length);
                Object[] objArr5 = this.h;
                objArr5[objArr5.length - 1] = objArr5[0];
                h9.B(objArr5, 0, objArr5, 1, i4 + 1);
            }
            this.h[i4] = obj;
            this.g = length;
        } else {
            int iH2 = h(i3 + this.g);
            if (iH < iH2) {
                Object[] objArr6 = this.h;
                h9.B(objArr6, iH + 1, objArr6, iH, iH2);
            } else {
                Object[] objArr7 = this.h;
                h9.B(objArr7, 1, objArr7, 0, iH2);
                Object[] objArr8 = this.h;
                objArr8[0] = objArr8[objArr8.length - 1];
                h9.B(objArr8, iH + 1, objArr8, iH, objArr8.length - 1);
            }
            this.h[iH] = obj;
        }
        this.i++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        qg0.l(collection, "elements");
        int i2 = this.i;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i == this.i) {
            return addAll(collection);
        }
        i();
        d(collection.size() + this.i);
        int iH = h(this.i + this.g);
        int iH2 = h(this.g + i);
        int size = collection.size();
        if (i >= ((this.i + 1) >> 1)) {
            int i3 = iH2 + size;
            if (iH2 < iH) {
                int i4 = size + iH;
                Object[] objArr = this.h;
                if (i4 <= objArr.length) {
                    h9.B(objArr, i3, objArr, iH2, iH);
                } else if (i3 >= objArr.length) {
                    h9.B(objArr, i3 - objArr.length, objArr, iH2, iH);
                } else {
                    int length = iH - (i4 - objArr.length);
                    h9.B(objArr, 0, objArr, length, iH);
                    Object[] objArr2 = this.h;
                    h9.B(objArr2, i3, objArr2, iH2, length);
                }
            } else {
                Object[] objArr3 = this.h;
                h9.B(objArr3, size, objArr3, 0, iH);
                Object[] objArr4 = this.h;
                if (i3 >= objArr4.length) {
                    h9.B(objArr4, i3 - objArr4.length, objArr4, iH2, objArr4.length);
                } else {
                    h9.B(objArr4, 0, objArr4, objArr4.length - size, objArr4.length);
                    Object[] objArr5 = this.h;
                    h9.B(objArr5, i3, objArr5, iH2, objArr5.length - size);
                }
            }
            c(iH2, collection);
            return true;
        }
        int i5 = this.g;
        int length2 = i5 - size;
        if (iH2 < i5) {
            Object[] objArr6 = this.h;
            h9.B(objArr6, length2, objArr6, i5, objArr6.length);
            if (size >= iH2) {
                Object[] objArr7 = this.h;
                h9.B(objArr7, objArr7.length - size, objArr7, 0, iH2);
            } else {
                Object[] objArr8 = this.h;
                h9.B(objArr8, objArr8.length - size, objArr8, 0, size);
                Object[] objArr9 = this.h;
                h9.B(objArr9, 0, objArr9, size, iH2);
            }
        } else if (length2 >= 0) {
            Object[] objArr10 = this.h;
            h9.B(objArr10, length2, objArr10, i5, iH2);
        } else {
            Object[] objArr11 = this.h;
            length2 += objArr11.length;
            int i6 = iH2 - i5;
            int length3 = objArr11.length - length2;
            if (length3 >= i6) {
                h9.B(objArr11, length2, objArr11, i5, iH2);
            } else {
                h9.B(objArr11, length2, objArr11, i5, i5 + length3);
                Object[] objArr12 = this.h;
                h9.B(objArr12, 0, objArr12, this.g + length3, iH2);
            }
        }
        this.g = length2;
        c(f(iH2 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        i();
        d(this.i + 1);
        int length = this.g;
        if (length == 0) {
            Object[] objArr = this.h;
            qg0.l(objArr, "<this>");
            length = objArr.length;
        }
        int i = length - 1;
        this.g = i;
        this.h[i] = obj;
        this.i++;
    }

    public final void addLast(Object obj) {
        i();
        d(a() + 1);
        this.h[h(a() + this.g)] = obj;
        this.i = a() + 1;
    }

    @Override // defpackage.q
    public final Object b(int i) {
        int i2 = this.i;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(k31.j(i, i2, "index: ", ", size: "));
        }
        if (i == xj.u(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        i();
        int iH = h(this.g + i);
        Object[] objArr = this.h;
        Object obj = objArr[iH];
        if (i < (this.i >> 1)) {
            int i3 = this.g;
            if (iH >= i3) {
                h9.B(objArr, i3 + 1, objArr, i3, iH);
            } else {
                h9.B(objArr, 1, objArr, 0, iH);
                Object[] objArr2 = this.h;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i4 = this.g;
                h9.B(objArr2, i4 + 1, objArr2, i4, objArr2.length - 1);
            }
            Object[] objArr3 = this.h;
            int i5 = this.g;
            objArr3[i5] = null;
            this.g = e(i5);
        } else {
            int iH2 = h(xj.u(this) + this.g);
            if (iH <= iH2) {
                Object[] objArr4 = this.h;
                h9.B(objArr4, iH, objArr4, iH + 1, iH2 + 1);
            } else {
                Object[] objArr5 = this.h;
                h9.B(objArr5, iH, objArr5, iH + 1, objArr5.length);
                Object[] objArr6 = this.h;
                objArr6[objArr6.length - 1] = objArr6[0];
                h9.B(objArr6, 0, objArr6, 1, iH2 + 1);
            }
            this.h[iH2] = null;
        }
        this.i--;
        return obj;
    }

    public final void c(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.h.length;
        while (i < length && it.hasNext()) {
            this.h[i] = it.next();
            i++;
        }
        int i2 = this.g;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.h[i3] = it.next();
        }
        this.i = collection.size() + this.i;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            i();
            g(this.g, h(a() + this.g));
        }
        this.g = 0;
        this.i = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.h;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == j) {
            if (i < 10) {
                i = 10;
            }
            this.h = new Object[i];
            return;
        }
        int length = objArr.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = i > 2147483639 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : 2147483639;
        }
        Object[] objArr2 = new Object[i2];
        h9.B(objArr, 0, objArr2, this.g, objArr.length);
        Object[] objArr3 = this.h;
        int length2 = objArr3.length;
        int i3 = this.g;
        h9.B(objArr3, length2 - i3, objArr2, 0, i3);
        this.g = 0;
        this.h = objArr2;
    }

    public final int e(int i) {
        qg0.l(this.h, "<this>");
        if (i == r0.length - 1) {
            return 0;
        }
        return i + 1;
    }

    public final int f(int i) {
        return i < 0 ? i + this.h.length : i;
    }

    public final void g(int i, int i2) {
        if (i < i2) {
            h9.E(this.h, null, i, i2);
            return;
        }
        Object[] objArr = this.h;
        Arrays.fill(objArr, i, objArr.length, (Object) null);
        h9.E(this.h, null, 0, i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int iA = a();
        if (i < 0 || i >= iA) {
            throw new IndexOutOfBoundsException(k31.j(i, iA, "index: ", ", size: "));
        }
        return this.h[h(this.g + i)];
    }

    public final int h(int i) {
        Object[] objArr = this.h;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final void i() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iH = h(a() + this.g);
        int length = this.g;
        if (length < iH) {
            while (length < iH) {
                if (qg0.d(obj, this.h[length])) {
                    i = this.g;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iH) {
            return -1;
        }
        int length2 = this.h.length;
        while (true) {
            if (length >= length2) {
                for (int i2 = 0; i2 < iH; i2++) {
                    if (qg0.d(obj, this.h[i2])) {
                        length = i2 + this.h.length;
                        i = this.g;
                    }
                }
                return -1;
            }
            if (qg0.d(obj, this.h[length])) {
                i = this.g;
                break;
            }
            length++;
        }
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return a() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int iH = h(this.i + this.g);
        int i2 = this.g;
        if (i2 < iH) {
            length = iH - 1;
            if (i2 <= length) {
                while (!qg0.d(obj, this.h[length])) {
                    if (length != i2) {
                        length--;
                    }
                }
                i = this.g;
                return length - i;
            }
            return -1;
        }
        if (i2 > iH) {
            int i3 = iH - 1;
            while (true) {
                if (-1 >= i3) {
                    Object[] objArr = this.h;
                    qg0.l(objArr, "<this>");
                    length = objArr.length - 1;
                    int i4 = this.g;
                    if (i4 <= length) {
                        while (!qg0.d(obj, this.h[length])) {
                            if (length != i4) {
                                length--;
                            }
                        }
                        i = this.g;
                    }
                } else {
                    if (qg0.d(obj, this.h[i3])) {
                        length = i3 + this.h.length;
                        i = this.g;
                        break;
                    }
                    i3--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        b(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iH;
        qg0.l(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.h.length != 0) {
            int iH2 = h(this.i + this.g);
            int i = this.g;
            if (i < iH2) {
                iH = i;
                while (i < iH2) {
                    Object obj = this.h[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.h[iH] = obj;
                        iH++;
                    }
                    i++;
                }
                h9.E(this.h, null, iH, iH2);
            } else {
                int length = this.h.length;
                int i2 = i;
                boolean z2 = false;
                while (i < length) {
                    Object[] objArr = this.h;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.h[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                iH = h(i2);
                for (int i3 = 0; i3 < iH2; i3++) {
                    Object[] objArr2 = this.h;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.h[iH] = obj3;
                        iH = e(iH);
                    }
                }
                z = z2;
            }
            if (z) {
                i();
                this.i = f(iH - this.g);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        i();
        Object[] objArr = this.h;
        int i = this.g;
        Object obj = objArr[i];
        objArr[i] = null;
        this.g = e(i);
        this.i = a() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        i();
        int iH = h(xj.u(this) + this.g);
        Object[] objArr = this.h;
        Object obj = objArr[iH];
        objArr[iH] = null;
        this.i = a() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        qg0.n(i, i2, this.i);
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == this.i) {
            clear();
            return;
        }
        if (i3 == 1) {
            b(i);
            return;
        }
        i();
        if (i < this.i - i2) {
            int iH = h((i - 1) + this.g);
            int iH2 = h((i2 - 1) + this.g);
            while (i > 0) {
                int i4 = iH + 1;
                int iMin = Math.min(i, Math.min(i4, iH2 + 1));
                Object[] objArr = this.h;
                int i5 = iH2 - iMin;
                int i6 = iH - iMin;
                h9.B(objArr, i5 + 1, objArr, i6 + 1, i4);
                iH = f(i6);
                iH2 = f(i5);
                i -= iMin;
            }
            int iH3 = h(this.g + i3);
            g(this.g, iH3);
            this.g = iH3;
        } else {
            int iH4 = h(this.g + i2);
            int iH5 = h(this.g + i);
            int i7 = this.i;
            while (true) {
                i7 -= i2;
                if (i7 <= 0) {
                    break;
                }
                Object[] objArr2 = this.h;
                i2 = Math.min(i7, Math.min(objArr2.length - iH4, objArr2.length - iH5));
                Object[] objArr3 = this.h;
                int i8 = iH4 + i2;
                h9.B(objArr3, iH5, objArr3, iH4, i8);
                iH4 = h(i8);
                iH5 = h(iH5 + i2);
            }
            int iH6 = h(this.i + this.g);
            g(f(iH6 - i3), iH6);
        }
        this.i -= i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iH;
        qg0.l(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.h.length != 0) {
            int iH2 = h(this.i + this.g);
            int i = this.g;
            if (i < iH2) {
                iH = i;
                while (i < iH2) {
                    Object obj = this.h[i];
                    if (collection.contains(obj)) {
                        this.h[iH] = obj;
                        iH++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                h9.E(this.h, null, iH, iH2);
            } else {
                int length = this.h.length;
                int i2 = i;
                boolean z2 = false;
                while (i < length) {
                    Object[] objArr = this.h;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        this.h[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iH = h(i2);
                for (int i3 = 0; i3 < iH2; i3++) {
                    Object[] objArr2 = this.h;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        this.h[iH] = obj3;
                        iH = e(iH);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                i();
                this.i = f(iH - this.g);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int iA = a();
        if (i < 0 || i >= iA) {
            throw new IndexOutOfBoundsException(k31.j(i, iA, "index: ", ", size: "));
        }
        int iH = h(this.g + i);
        Object[] objArr = this.h;
        Object obj2 = objArr[iH];
        objArr[iH] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        qg0.l(objArr, "array");
        int length = objArr.length;
        int i = this.i;
        if (length < i) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
            qg0.i(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) objNewInstance;
        }
        int iH = h(this.i + this.g);
        int i2 = this.g;
        if (i2 < iH) {
            h9.C(this.h, i2, objArr, iH, 2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.h;
            h9.B(objArr2, 0, objArr, this.g, objArr2.length);
            Object[] objArr3 = this.h;
            h9.B(objArr3, objArr3.length - this.g, objArr, 0, iH);
        }
        int i3 = this.i;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        qg0.l(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        i();
        d(collection.size() + a());
        c(h(a() + this.g), collection);
        return true;
    }
}
