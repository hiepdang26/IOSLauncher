package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class d9 implements Iterator, Map.Entry {
    public int g;
    public int h = -1;
    public boolean i;
    public final /* synthetic */ e9 j;

    public d9(e9 e9Var) {
        this.j = e9Var;
        this.g = e9Var.i - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.i) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i = this.h;
        e9 e9Var = this.j;
        return qg0.d(key, e9Var.f(i)) && qg0.d(entry.getValue(), e9Var.j(this.h));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.i) {
            return this.j.f(this.h);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.i) {
            return this.j.j(this.h);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.h < this.g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.i) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i = this.h;
        e9 e9Var = this.j;
        Object objF = e9Var.f(i);
        Object objJ = e9Var.j(this.h);
        return (objF == null ? 0 : objF.hashCode()) ^ (objJ != null ? objJ.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.h++;
        this.i = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.i) {
            throw new IllegalStateException();
        }
        this.j.h(this.h);
        this.h--;
        this.g--;
        this.i = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.i) {
            return this.j.i(this.h, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
