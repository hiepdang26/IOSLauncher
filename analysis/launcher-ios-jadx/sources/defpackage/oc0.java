package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class oc0 extends jc0 {
    public boolean j;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.h) {
            return;
        }
        if (!this.j) {
            a();
        }
        this.h = true;
    }

    @Override // defpackage.jc0, defpackage.fi1
    public final long read(fe feVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException(uo.f("byteCount < 0: ", j));
        }
        if (this.h) {
            throw new IllegalStateException("closed");
        }
        if (this.j) {
            return -1L;
        }
        long j2 = super.read(feVar, j);
        if (j2 != -1) {
            return j2;
        }
        this.j = true;
        a();
        return -1L;
    }
}
