package defpackage;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class ju0 {
    public static final ArrayDeque b;
    public Object a;

    static {
        char[] cArr = vq1.a;
        b = new ArrayDeque(0);
    }

    public static ju0 a(Object obj) {
        ju0 ju0Var;
        ArrayDeque arrayDeque = b;
        synchronized (arrayDeque) {
            ju0Var = (ju0) arrayDeque.poll();
        }
        if (ju0Var == null) {
            ju0Var = new ju0();
        }
        ju0Var.a = obj;
        return ju0Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ju0)) {
            return false;
        }
        ju0 ju0Var = (ju0) obj;
        ju0Var.getClass();
        return this.a.equals(ju0Var.a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
