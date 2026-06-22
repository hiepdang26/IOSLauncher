package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class x4 {
    public static final eb0 a;

    static {
        try {
            eb0 eb0Var = w4.a;
            if (eb0Var == null) {
                throw new NullPointerException("Scheduler Callable returned null");
            }
            a = eb0Var;
        } catch (Throwable th) {
            throw a10.a(th);
        }
    }

    public static eb0 a() {
        eb0 eb0Var = a;
        if (eb0Var != null) {
            return eb0Var;
        }
        throw new NullPointerException("scheduler == null");
    }
}
