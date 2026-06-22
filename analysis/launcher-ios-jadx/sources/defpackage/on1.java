package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class on1 {
    public static final ThreadLocal a = new ThreadLocal();

    public static v00 a() {
        ThreadLocal threadLocal = a;
        v00 v00Var = (v00) threadLocal.get();
        if (v00Var != null) {
            return v00Var;
        }
        tc tcVar = new tc(Thread.currentThread());
        threadLocal.set(tcVar);
        return tcVar;
    }
}
