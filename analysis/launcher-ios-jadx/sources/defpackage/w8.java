package defpackage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class w8 implements Collection {
    public final /* synthetic */ int g;
    public final Object h;

    public /* synthetic */ w8(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        switch (this.g) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.g) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Collection
    public final void clear() {
        switch (this.g) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                ((e9) this.h).clear();
                return;
        }
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        int i;
        switch (this.g) {
            case 0:
                Object[] objArr = (Object[]) this.h;
                qg0.l(objArr, "<this>");
                if (obj == null) {
                    int length = objArr.length;
                    i = 0;
                    while (i < length) {
                        if (objArr[i] != null) {
                            i++;
                        }
                    }
                    i = -1;
                } else {
                    int length2 = objArr.length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        if (obj.equals(objArr[i2])) {
                            i = i2;
                        }
                    }
                    i = -1;
                }
                if (i >= 0) {
                }
                break;
            default:
                if (((e9) this.h).a(obj) >= 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.g) {
            case 0:
                qg0.l(collection, "elements");
                Collection collection2 = collection;
                if (!collection2.isEmpty()) {
                    Iterator it = collection2.iterator();
                    while (it.hasNext()) {
                        if (!contains(it.next())) {
                            break;
                        }
                    }
                    break;
                }
                break;
            default:
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!contains(it2.next())) {
                        break;
                    }
                }
                break;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        switch (this.g) {
            case 0:
                return ((Object[]) this.h).length == 0;
            default:
                return ((e9) this.h).isEmpty();
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.g) {
            case 0:
                return new y8((Object[]) this.h, 0);
            default:
                return new b9((e9) this.h, 1);
        }
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.g) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                e9 e9Var = (e9) this.h;
                int iA = e9Var.a(obj);
                if (iA < 0) {
                    return false;
                }
                e9Var.h(iA);
                return true;
        }
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.g) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                e9 e9Var = (e9) this.h;
                int i = e9Var.i;
                int i2 = 0;
                boolean z = false;
                while (i2 < i) {
                    if (collection.contains(e9Var.j(i2))) {
                        e9Var.h(i2);
                        i2--;
                        i--;
                        z = true;
                    }
                    i2++;
                }
                return z;
        }
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.g) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                e9 e9Var = (e9) this.h;
                int i = e9Var.i;
                int i2 = 0;
                boolean z = false;
                while (i2 < i) {
                    if (!collection.contains(e9Var.j(i2))) {
                        e9Var.h(i2);
                        i2--;
                        i--;
                        z = true;
                    }
                    i2++;
                }
                return z;
        }
    }

    @Override // java.util.Collection
    public final int size() {
        switch (this.g) {
            case 0:
                return ((Object[]) this.h).length;
            default:
                return ((e9) this.h).i;
        }
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        switch (this.g) {
            case 0:
                Object[] objArr = (Object[]) this.h;
                if (objArr.getClass().equals(Object[].class)) {
                    return objArr;
                }
                Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
                qg0.k(objArrCopyOf, "copyOf(...)");
                return objArrCopyOf;
            default:
                e9 e9Var = (e9) this.h;
                int i = e9Var.i;
                Object[] objArr2 = new Object[i];
                for (int i2 = 0; i2 < i; i2++) {
                    objArr2[i2] = e9Var.j(i2);
                }
                return objArr2;
        }
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.g) {
            case 0:
                qg0.l(objArr, "array");
                return qg0.Q(this, objArr);
            default:
                e9 e9Var = (e9) this.h;
                int i = e9Var.i;
                if (objArr.length < i) {
                    objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
                }
                for (int i2 = 0; i2 < i; i2++) {
                    objArr[i2] = e9Var.j(i2);
                }
                if (objArr.length > i) {
                    objArr[i] = null;
                }
                return objArr;
        }
    }
}
