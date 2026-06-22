package defpackage;

import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes.dex */
public final class c10 implements ih1, AutoCloseable {
    public final ih1 g;
    public boolean h;
    public final long i;
    public long j;
    public boolean k;
    public final /* synthetic */ e10 l;

    public c10(e10 e10Var, ih1 ih1Var, long j) {
        this.l = e10Var;
        if (ih1Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.g = ih1Var;
        this.i = j;
    }

    public final void a() {
        this.g.close();
    }

    public final IOException b(IOException iOException) {
        if (this.h) {
            return iOException;
        }
        this.h = true;
        return this.l.a(false, true, iOException);
    }

    @Override // defpackage.ih1
    public final void c(fe feVar, long j) throws IOException {
        if (this.k) {
            throw new IllegalStateException("closed");
        }
        long j2 = this.i;
        if (j2 == -1 || this.j + j <= j2) {
            try {
                this.g.c(feVar, j);
                this.j += j;
                return;
            } catch (IOException e) {
                throw b(e);
            }
        }
        throw new ProtocolException("expected " + j2 + " bytes but received " + (this.j + j));
    }

    @Override // defpackage.ih1, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.k) {
            return;
        }
        this.k = true;
        long j = this.i;
        if (j != -1 && this.j != j) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            a();
            b(null);
        } catch (IOException e) {
            throw b(e);
        }
    }

    @Override // defpackage.ih1, java.io.Flushable
    public final void flush() throws IOException {
        try {
            h();
        } catch (IOException e) {
            throw b(e);
        }
    }

    public final void h() {
        this.g.flush();
    }

    @Override // defpackage.ih1
    public final yn1 timeout() {
        return this.g.timeout();
    }

    public final String toString() {
        return c10.class.getSimpleName() + "(" + this.g.toString() + ")";
    }
}
