package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class n9 implements fi1, AutoCloseable {
    public final /* synthetic */ int g = 0;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;

    public n9(yn1 yn1Var, InputStream inputStream) {
        this.h = yn1Var;
        this.i = inputStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.g) {
            case 0:
                hd0 hd0Var = (hd0) this.i;
                hd0Var.i();
                try {
                    try {
                        ((n9) this.h).close();
                        hd0Var.j(true);
                        return;
                    } catch (IOException e) {
                        if (!hd0Var.k()) {
                            throw e;
                        }
                        throw hd0Var.l(e);
                    }
                } catch (Throwable th) {
                    hd0Var.j(false);
                    throw th;
                }
            default:
                ((InputStream) this.i).close();
                return;
        }
    }

    @Override // defpackage.fi1
    public final long read(fe feVar, long j) throws IOException {
        switch (this.g) {
            case 0:
                hd0 hd0Var = (hd0) this.i;
                hd0Var.i();
                try {
                    try {
                        long j2 = ((n9) this.h).read(feVar, j);
                        hd0Var.j(true);
                        return j2;
                    } catch (IOException e) {
                        if (hd0Var.k()) {
                            throw hd0Var.l(e);
                        }
                        throw e;
                    }
                } catch (Throwable th) {
                    hd0Var.j(false);
                    throw th;
                }
            default:
                if (j < 0) {
                    throw new IllegalArgumentException(uo.f("byteCount < 0: ", j));
                }
                if (j == 0) {
                    return 0L;
                }
                try {
                    ((yn1) this.h).f();
                    ze1 ze1VarI = feVar.I(1);
                    int i = ((InputStream) this.i).read(ze1VarI.a, ze1VarI.c, (int) Math.min(j, 8192 - ze1VarI.c));
                    if (i == -1) {
                        return -1L;
                    }
                    ze1VarI.c += i;
                    long j3 = i;
                    feVar.h += j3;
                    return j3;
                } catch (AssertionError e2) {
                    if (e2.getCause() == null || e2.getMessage() == null || !e2.getMessage().contains("getsockname failed")) {
                        throw e2;
                    }
                    throw new IOException(e2);
                }
        }
    }

    @Override // defpackage.fi1
    public final yn1 timeout() {
        switch (this.g) {
            case 0:
                return (hd0) this.i;
            default:
                return (yn1) this.h;
        }
    }

    public final String toString() {
        switch (this.g) {
            case 0:
                return "AsyncTimeout.source(" + ((n9) this.h) + ")";
            default:
                return "source(" + ((InputStream) this.i) + ")";
        }
    }

    public n9(hd0 hd0Var, n9 n9Var) {
        this.i = hd0Var;
        this.h = n9Var;
    }
}
