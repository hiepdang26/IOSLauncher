package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class jg0 implements Iterator {
    public final int g;
    public final int h;
    public boolean i;
    public int j;

    public jg0(int i, int i2, int i3) {
        this.g = i3;
        this.h = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.i = z;
        this.j = z ? i : i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.i;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.j;
        if (i != this.h) {
            this.j = this.g + i;
        } else {
            if (!this.i) {
                throw new NoSuchElementException();
            }
            this.i = false;
        }
        return Integer.valueOf(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
