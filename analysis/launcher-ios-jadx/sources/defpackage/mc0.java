package defpackage;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class mc0 extends jc0 {
    public long j;
    public final /* synthetic */ pc0 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mc0(pc0 pc0Var, long j) {
        super(pc0Var);
        this.k = pc0Var;
        this.j = j;
        if (j == 0) {
            a();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zP;
        if (this.h) {
            return;
        }
        if (this.j != 0) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            try {
                zP = wq1.p(this, 100);
            } catch (IOException unused) {
                zP = false;
            }
            if (!zP) {
                this.k.b.i();
                a();
            }
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
        long j2 = this.j;
        if (j2 == 0) {
            return -1L;
        }
        long j3 = super.read(feVar, Math.min(j2, j));
        if (j3 == -1) {
            this.k.b.i();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a();
            throw protocolException;
        }
        long j4 = this.j - j3;
        this.j = j4;
        if (j4 == 0) {
            a();
        }
        return j3;
    }
}
