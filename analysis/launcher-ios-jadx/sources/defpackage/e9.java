package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e9 extends ug1 implements Map {
    public a9 j;
    public c9 k;
    public w8 l;

    @Override // java.util.Map
    public final Set entrySet() {
        a9 a9Var = this.j;
        if (a9Var != null) {
            return a9Var;
        }
        a9 a9Var2 = new a9(this);
        this.j = a9Var2;
        return a9Var2;
    }

    public final boolean k(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public final Set keySet() {
        c9 c9Var = this.k;
        if (c9Var != null) {
            return c9Var;
        }
        c9 c9Var2 = new c9(this);
        this.k = c9Var2;
        return c9Var2;
    }

    public final boolean l(Collection collection) {
        int i = this.i;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i != this.i;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.i);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        w8 w8Var = this.l;
        if (w8Var != null) {
            return w8Var;
        }
        w8 w8Var2 = new w8(this, 1);
        this.l = w8Var2;
        return w8Var2;
    }
}
