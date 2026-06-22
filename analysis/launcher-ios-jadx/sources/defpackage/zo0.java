package defpackage;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zo0 {
    public static final yo0 c = new yo0(Object.class, Object.class, Object.class, Collections.singletonList(new ts(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new jl1(5), null)), null);
    public final e9 a = new e9(0);
    public final AtomicReference b = new AtomicReference();

    public final void a(Class cls, Class cls2, Class cls3, yo0 yo0Var) {
        synchronized (this.a) {
            e9 e9Var = this.a;
            tu0 tu0Var = new tu0(cls, cls2, cls3);
            if (yo0Var == null) {
                yo0Var = c;
            }
            e9Var.put(tu0Var, yo0Var);
        }
    }
}
