package defpackage;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class fq0 {
    public final LinkedHashMap a = new LinkedHashMap(100, 0.75f, true);
    public final long b;
    public long c;

    public fq0(long j) {
        this.b = j;
    }

    public final synchronized Object a(Object obj) {
        eq0 eq0Var;
        eq0Var = (eq0) this.a.get(obj);
        return eq0Var != null ? eq0Var.a : null;
    }

    public int b(Object obj) {
        return 1;
    }

    public final synchronized Object d(Object obj, Object obj2) {
        int iB = b(obj2);
        long j = iB;
        if (j >= this.b) {
            c(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.c += j;
        }
        eq0 eq0Var = (eq0) this.a.put(obj, obj2 == null ? null : new eq0(obj2, iB));
        if (eq0Var != null) {
            this.c -= (long) eq0Var.b;
            if (!eq0Var.a.equals(obj2)) {
                c(obj, eq0Var.a);
            }
        }
        e(this.b);
        return eq0Var != null ? eq0Var.a : null;
    }

    public final synchronized void e(long j) {
        while (this.c > j) {
            Iterator it = this.a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            eq0 eq0Var = (eq0) entry.getValue();
            this.c -= (long) eq0Var.b;
            Object key = entry.getKey();
            it.remove();
            c(key, eq0Var.a);
        }
    }

    public void c(Object obj, Object obj2) {
    }
}
