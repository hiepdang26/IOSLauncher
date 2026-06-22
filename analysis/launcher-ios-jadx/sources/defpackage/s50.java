package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class s50 implements fi1, AutoCloseable {
    private final fi1 delegate;

    public s50(fi1 fi1Var) {
        if (fi1Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = fi1Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final fi1 delegate() {
        return this.delegate;
    }

    @Override // defpackage.fi1
    public long read(fe feVar, long j) {
        return this.delegate.read(feVar, j);
    }

    @Override // defpackage.fi1
    public yn1 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
