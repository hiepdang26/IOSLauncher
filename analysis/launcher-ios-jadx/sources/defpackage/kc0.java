package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class kc0 implements ih1, AutoCloseable {
    public final t50 g;
    public boolean h;
    public final /* synthetic */ pc0 i;

    public kc0(pc0 pc0Var) {
        this.i = pc0Var;
        this.g = new t50(pc0Var.d.h.timeout());
    }

    @Override // defpackage.ih1
    public final void c(fe feVar, long j) {
        if (this.h) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return;
        }
        pc0 pc0Var = this.i;
        a81 a81Var = pc0Var.d;
        if (a81Var.i) {
            throw new IllegalStateException("closed");
        }
        a81Var.g.M(j);
        a81Var.a();
        a81 a81Var2 = pc0Var.d;
        a81Var2.t("\r\n");
        a81Var2.c(feVar, j);
        a81Var2.t("\r\n");
    }

    @Override // defpackage.ih1, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final synchronized void close() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.i.d.t("0\r\n\r\n");
        pc0 pc0Var = this.i;
        t50 t50Var = this.g;
        pc0Var.getClass();
        yn1 yn1Var = t50Var.e;
        t50Var.e = yn1.d;
        yn1Var.a();
        yn1Var.b();
        this.i.e = 3;
    }

    @Override // defpackage.ih1, java.io.Flushable
    public final synchronized void flush() {
        if (this.h) {
            return;
        }
        this.i.d.flush();
    }

    @Override // defpackage.ih1
    public final yn1 timeout() {
        return this.g;
    }
}
