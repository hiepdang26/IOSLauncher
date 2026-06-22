package defpackage;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class m9 implements ih1, AutoCloseable {
    public final /* synthetic */ int g;
    public final /* synthetic */ hd0 h;
    public final /* synthetic */ Object i;

    public /* synthetic */ m9(hd0 hd0Var, Object obj, int i) {
        this.g = i;
        this.h = hd0Var;
        this.i = obj;
    }

    @Override // defpackage.ih1
    public final void c(fe feVar, long j) throws IOException {
        switch (this.g) {
            case 0:
                xq1.a(feVar.h, 0L, j);
                long j2 = j;
                while (true) {
                    long j3 = 0;
                    if (j2 <= 0) {
                        return;
                    }
                    ze1 ze1Var = feVar.g;
                    while (true) {
                        if (j3 < 65536) {
                            j3 += (long) (ze1Var.c - ze1Var.b);
                            if (j3 >= j2) {
                                j3 = j2;
                            } else {
                                ze1Var = ze1Var.f;
                            }
                        }
                    }
                    hd0 hd0Var = this.h;
                    hd0Var.i();
                    try {
                        try {
                            ((m9) this.i).c(feVar, j3);
                            j2 -= j3;
                            hd0Var.j(true);
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
                }
                break;
            default:
                xq1.a(feVar.h, 0L, j);
                while (j > 0) {
                    this.h.f();
                    ze1 ze1Var2 = feVar.g;
                    int iMin = (int) Math.min(j, ze1Var2.c - ze1Var2.b);
                    ((OutputStream) this.i).write(ze1Var2.a, ze1Var2.b, iMin);
                    int i = ze1Var2.b + iMin;
                    ze1Var2.b = i;
                    long j4 = iMin;
                    j -= j4;
                    feVar.h -= j4;
                    if (i == ze1Var2.c) {
                        feVar.g = ze1Var2.a();
                        bf1.s(ze1Var2);
                    }
                }
                return;
        }
    }

    @Override // defpackage.ih1, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        switch (this.g) {
            case 0:
                hd0 hd0Var = this.h;
                hd0Var.i();
                try {
                    try {
                        ((m9) this.i).close();
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
                ((OutputStream) this.i).close();
                return;
        }
    }

    @Override // defpackage.ih1, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.g) {
            case 0:
                hd0 hd0Var = this.h;
                hd0Var.i();
                try {
                    try {
                        ((m9) this.i).flush();
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
                ((OutputStream) this.i).flush();
                return;
        }
    }

    @Override // defpackage.ih1
    public final yn1 timeout() {
        switch (this.g) {
        }
        return this.h;
    }

    public final String toString() {
        switch (this.g) {
            case 0:
                return "AsyncTimeout.sink(" + ((m9) this.i) + ")";
            default:
                return "sink(" + ((OutputStream) this.i) + ")";
        }
    }
}
