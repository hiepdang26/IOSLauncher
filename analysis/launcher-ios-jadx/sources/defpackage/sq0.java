package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class sq0 extends r {
    public final /* synthetic */ int g;
    public final rq0 h;

    public /* synthetic */ sq0(rq0 rq0Var, int i) {
        this.g = i;
        this.h = rq0Var;
    }

    @Override // defpackage.r
    public final int a() {
        switch (this.g) {
        }
        return this.h.o;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.g) {
            case 0:
                qg0.l((Map.Entry) obj, "element");
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        switch (this.g) {
            case 0:
                qg0.l(collection, "elements");
                throw new UnsupportedOperationException();
            default:
                qg0.l(collection, "elements");
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.g) {
            case 0:
                this.h.clear();
                break;
            default:
                this.h.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.g) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                qg0.l(entry, "element");
                return this.h.f(entry);
            default:
                return this.h.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.g) {
            case 0:
                qg0.l(collection, "elements");
                return this.h.e(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.g) {
        }
        return this.h.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.g) {
            case 0:
                rq0 rq0Var = this.h;
                rq0Var.getClass();
                return new oq0(rq0Var, 0);
            default:
                rq0 rq0Var2 = this.h;
                rq0Var2.getClass();
                return new oq0(rq0Var2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.g) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    qg0.l(entry, "element");
                    rq0 rq0Var = this.h;
                    rq0Var.getClass();
                    rq0Var.c();
                    int iH = rq0Var.h(entry.getKey());
                    if (iH >= 0) {
                        Object[] objArr = rq0Var.h;
                        qg0.h(objArr);
                        if (qg0.d(objArr[iH], entry.getValue())) {
                            rq0Var.l(iH);
                            break;
                        }
                    }
                }
                break;
            default:
                rq0 rq0Var2 = this.h;
                rq0Var2.c();
                int iH2 = rq0Var2.h(obj);
                if (iH2 >= 0) {
                    rq0Var2.l(iH2);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        switch (this.g) {
            case 0:
                qg0.l(collection, "elements");
                this.h.c();
                break;
            default:
                qg0.l(collection, "elements");
                this.h.c();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        switch (this.g) {
            case 0:
                qg0.l(collection, "elements");
                this.h.c();
                break;
            default:
                qg0.l(collection, "elements");
                this.h.c();
                break;
        }
        return super.retainAll(collection);
    }
}
