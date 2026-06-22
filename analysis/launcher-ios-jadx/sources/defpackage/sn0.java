package defpackage;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class sn0 implements ListIterator {
    public int h;
    public int j;
    public final q k;
    public final /* synthetic */ int g = 0;
    public int i = -1;

    public sn0(un0 un0Var, int i) {
        this.k = un0Var;
        this.h = i;
        this.j = ((AbstractList) un0Var).modCount;
    }

    public final void a() {
        switch (this.g) {
            case 0:
                if (((AbstractList) ((tn0) this.k).k).modCount != this.j) {
                    throw new ConcurrentModificationException();
                }
                return;
            default:
                if (((AbstractList) ((un0) this.k)).modCount != this.j) {
                    throw new ConcurrentModificationException();
                }
                return;
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.g) {
            case 0:
                a();
                int i = this.h;
                this.h = i + 1;
                tn0 tn0Var = (tn0) this.k;
                tn0Var.add(i, obj);
                this.i = -1;
                this.j = ((AbstractList) tn0Var).modCount;
                break;
            default:
                a();
                int i2 = this.h;
                this.h = i2 + 1;
                un0 un0Var = (un0) this.k;
                un0Var.add(i2, obj);
                this.i = -1;
                this.j = ((AbstractList) un0Var).modCount;
                break;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.g) {
            case 0:
                if (this.h < ((tn0) this.k).i) {
                }
                break;
            default:
                if (this.h < ((un0) this.k).h) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.g) {
            case 0:
                if (this.h > 0) {
                }
                break;
            default:
                if (this.h > 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.g) {
            case 0:
                a();
                int i = this.h;
                tn0 tn0Var = (tn0) this.k;
                if (i >= tn0Var.i) {
                    throw new NoSuchElementException();
                }
                this.h = i + 1;
                this.i = i;
                return tn0Var.g[tn0Var.h + i];
            default:
                a();
                int i2 = this.h;
                un0 un0Var = (un0) this.k;
                if (i2 >= un0Var.h) {
                    throw new NoSuchElementException();
                }
                this.h = i2 + 1;
                this.i = i2;
                return un0Var.g[i2];
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.g) {
        }
        return this.h;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.g) {
            case 0:
                a();
                int i = this.h;
                if (i <= 0) {
                    throw new NoSuchElementException();
                }
                int i2 = i - 1;
                this.h = i2;
                this.i = i2;
                tn0 tn0Var = (tn0) this.k;
                return tn0Var.g[tn0Var.h + i2];
            default:
                a();
                int i3 = this.h;
                if (i3 <= 0) {
                    throw new NoSuchElementException();
                }
                int i4 = i3 - 1;
                this.h = i4;
                this.i = i4;
                return ((un0) this.k).g[i4];
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        switch (this.g) {
        }
        return this.h - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.g) {
            case 0:
                a();
                int i = this.i;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                tn0 tn0Var = (tn0) this.k;
                tn0Var.b(i);
                this.h = this.i;
                this.i = -1;
                this.j = ((AbstractList) tn0Var).modCount;
                return;
            default:
                a();
                int i2 = this.i;
                if (i2 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                un0 un0Var = (un0) this.k;
                un0Var.b(i2);
                this.h = this.i;
                this.i = -1;
                this.j = ((AbstractList) un0Var).modCount;
                return;
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.g) {
            case 0:
                a();
                int i = this.i;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((tn0) this.k).set(i, obj);
                return;
            default:
                a();
                int i2 = this.i;
                if (i2 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((un0) this.k).set(i2, obj);
                return;
        }
    }

    public sn0(tn0 tn0Var, int i) {
        this.k = tn0Var;
        this.h = i;
        this.j = ((AbstractList) tn0Var).modCount;
    }
}
