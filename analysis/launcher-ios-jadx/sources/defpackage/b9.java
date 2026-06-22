package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class b9 implements Iterator {
    public int g;
    public int h;
    public boolean i;
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public b9(int i) {
        this.g = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.h < this.g;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objF;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.h;
        switch (this.j) {
            case 0:
                objF = ((e9) this.k).f(i);
                break;
            case 1:
                objF = ((e9) this.k).j(i);
                break;
            default:
                objF = ((g9) this.k).h[i];
                break;
        }
        this.h++;
        this.i = true;
        return objF;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.i) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i = this.h - 1;
        this.h = i;
        switch (this.j) {
            case 0:
                ((e9) this.k).h(i);
                break;
            case 1:
                ((e9) this.k).h(i);
                break;
            default:
                ((g9) this.k).a(i);
                break;
        }
        this.g--;
        this.i = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b9(g9 g9Var) {
        this(g9Var.i);
        this.j = 2;
        this.k = g9Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b9(e9 e9Var, int i) {
        this(e9Var.i);
        this.j = i;
        switch (i) {
            case 1:
                this.k = e9Var;
                this(e9Var.i);
                break;
            default:
                this.k = e9Var;
                break;
        }
    }
}
