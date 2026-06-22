package defpackage;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class g6 {
    public static final g9 g = new g9(0);
    public static final Object h = new Object();

    public static void d(q6 q6Var) {
        synchronized (h) {
            try {
                g9 g9Var = g;
                g9Var.getClass();
                b9 b9Var = new b9(g9Var);
                while (b9Var.hasNext()) {
                    g6 g6Var = (g6) ((WeakReference) b9Var.next()).get();
                    if (g6Var == q6Var || g6Var == null) {
                        b9Var.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public abstract boolean e(int i);

    public abstract void f(int i);

    public abstract void g(CharSequence charSequence);
}
