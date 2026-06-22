package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class ff1 implements Iterator, eo {
    public int g;
    public Object h;
    public Iterator i;
    public eo j;

    public final RuntimeException a() {
        int i = this.g;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.g);
    }

    @Override // defpackage.eo
    public final yo getContext() {
        return sz.g;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.g;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw a();
                }
                Iterator it = this.i;
                qg0.h(it);
                if (it.hasNext()) {
                    this.g = 2;
                    return true;
                }
                this.i = null;
            }
            this.g = 5;
            eo eoVar = this.j;
            qg0.h(eoVar);
            this.j = null;
            eoVar.resumeWith(zp1.a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.g;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i == 2) {
            this.g = 1;
            Iterator it = this.i;
            qg0.h(it);
            return it.next();
        }
        if (i != 3) {
            throw a();
        }
        this.g = 0;
        Object obj = this.h;
        this.h = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // defpackage.eo
    public final void resumeWith(Object obj) {
        np1.I(obj);
        this.g = 4;
    }
}
