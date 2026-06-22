package defpackage;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class pq0 implements Map.Entry {
    public final rq0 g;
    public final int h;
    public final int i;

    public pq0(rq0 rq0Var, int i) {
        qg0.l(rq0Var, "map");
        this.g = rq0Var;
        this.h = i;
        this.i = rq0Var.n;
    }

    public final void a() {
        if (this.g.n != this.i) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return qg0.d(entry.getKey(), getKey()) && qg0.d(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        a();
        return this.g.g[this.h];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        a();
        Object[] objArr = this.g.h;
        qg0.h(objArr);
        return objArr[this.h];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        a();
        rq0 rq0Var = this.g;
        rq0Var.c();
        Object[] objArr = rq0Var.h;
        if (objArr == null) {
            int length = rq0Var.g.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            rq0Var.h = objArr;
        }
        int i = this.h;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
