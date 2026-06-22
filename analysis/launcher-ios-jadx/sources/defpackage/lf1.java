package defpackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class lf1 extends r implements Serializable {
    public static final lf1 h;
    public final rq0 g;

    static {
        rq0 rq0Var = rq0.t;
        h = new lf1(rq0.t);
    }

    public lf1(rq0 rq0Var) {
        qg0.l(rq0Var, "backing");
        this.g = rq0Var;
    }

    @Override // defpackage.r
    public final int a() {
        return this.g.o;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        return this.g.a(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        qg0.l(collection, "elements");
        this.g.c();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.g.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.g.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.g.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        rq0 rq0Var = this.g;
        rq0Var.getClass();
        return new oq0(rq0Var, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        rq0 rq0Var = this.g;
        rq0Var.c();
        int iH = rq0Var.h(obj);
        if (iH < 0) {
            return false;
        }
        rq0Var.l(iH);
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        qg0.l(collection, "elements");
        this.g.c();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        qg0.l(collection, "elements");
        this.g.c();
        return super.retainAll(collection);
    }

    public lf1() {
        this(new rq0());
    }
}
