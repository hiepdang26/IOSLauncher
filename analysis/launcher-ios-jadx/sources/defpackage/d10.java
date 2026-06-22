package defpackage;

import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes.dex */
public final class d10 extends s50 {
    public final long g;
    public long h;
    public boolean i;
    public boolean j;
    public final /* synthetic */ e10 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d10(e10 e10Var, fi1 fi1Var, long j) {
        super(fi1Var);
        this.k = e10Var;
        this.g = j;
        if (j == 0) {
            a(null);
        }
    }

    public final IOException a(IOException iOException) {
        if (this.i) {
            return iOException;
        }
        this.i = true;
        return this.k.a(true, false, iOException);
    }

    @Override // defpackage.s50, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.j) {
            return;
        }
        this.j = true;
        try {
            super.close();
            a(null);
        } catch (IOException e) {
            throw a(e);
        }
    }

    @Override // defpackage.s50, defpackage.fi1
    public final long read(fe feVar, long j) throws IOException {
        if (this.j) {
            throw new IllegalStateException("closed");
        }
        try {
            long j2 = delegate().read(feVar, j);
            if (j2 == -1) {
                a(null);
                return -1L;
            }
            long j3 = this.h + j2;
            long j4 = this.g;
            if (j4 == -1 || j3 <= j4) {
                this.h = j3;
                if (j3 == j4) {
                    a(null);
                }
                return j2;
            }
            throw new ProtocolException("expected " + j4 + " bytes but received " + j3);
        } catch (IOException e) {
            throw a(e);
        }
    }
}
