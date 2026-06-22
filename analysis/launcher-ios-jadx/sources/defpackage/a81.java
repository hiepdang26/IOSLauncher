package defpackage;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class a81 implements ne, AutoCloseable {
    public final fe g = new fe();
    public final ih1 h;
    public boolean i;

    public a81(ih1 ih1Var) {
        this.h = ih1Var;
    }

    public final ne a() {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        fe feVar = this.g;
        long jB = feVar.b();
        if (jB > 0) {
            this.h.c(feVar, jB);
        }
        return this;
    }

    public final ne b(int i) {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        this.g.K(i);
        a();
        return this;
    }

    @Override // defpackage.ih1
    public final void c(fe feVar, long j) {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        this.g.c(feVar, j);
        a();
    }

    @Override // defpackage.ih1, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws Throwable {
        ih1 ih1Var = this.h;
        if (this.i) {
            return;
        }
        try {
            fe feVar = this.g;
            long j = feVar.h;
            if (j > 0) {
                ih1Var.c(feVar, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            ih1Var.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.i = true;
        if (th == null) {
            return;
        }
        Charset charset = xq1.a;
        throw th;
    }

    @Override // defpackage.ne
    public final fe d() {
        return this.g;
    }

    @Override // defpackage.ih1, java.io.Flushable
    public final void flush() {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        fe feVar = this.g;
        long j = feVar.h;
        ih1 ih1Var = this.h;
        if (j > 0) {
            ih1Var.c(feVar, j);
        }
        ih1Var.flush();
    }

    public final ne h(int i) {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        this.g.N(i);
        a();
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.i;
    }

    @Override // defpackage.ne
    public final ne m(byte[] bArr) {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        fe feVar = this.g;
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        feVar.J(bArr, 0, bArr.length);
        a();
        return this;
    }

    @Override // defpackage.ne
    public final long o(fi1 fi1Var) throws IOException {
        long j = 0;
        while (true) {
            long j2 = ((n9) fi1Var).read(this.g, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            a();
        }
    }

    @Override // defpackage.ne
    public final ne p(int i, byte[] bArr, int i2) {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        this.g.J(bArr, i, i2);
        a();
        return this;
    }

    @Override // defpackage.ne
    public final ne t(String str) {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        this.g.O(0, str.length(), str);
        a();
        return this;
    }

    @Override // defpackage.ih1
    public final yn1 timeout() {
        return this.h.timeout();
    }

    public final String toString() {
        return "buffer(" + this.h + ")";
    }

    @Override // defpackage.ne
    public final ne u(long j) {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        this.g.L(j);
        a();
        return this;
    }

    @Override // defpackage.ne
    public final ne w(df dfVar) {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        fe feVar = this.g;
        if (dfVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        dfVar.m(feVar);
        a();
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.g.write(byteBuffer);
        a();
        return iWrite;
    }
}
