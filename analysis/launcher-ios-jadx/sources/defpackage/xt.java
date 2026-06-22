package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class xt extends vd1 {
    public static final xt j;

    static {
        int i = um1.c;
        int i2 = um1.d;
        long j2 = um1.e;
        String str = um1.a;
        xt xtVar = new xt();
        xtVar.i = new fp(i, i2, j2, str);
        j = xtVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // defpackage.cp
    public final String toString() {
        return "Dispatchers.Default";
    }
}
