package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class nc0 implements ih1, AutoCloseable {
    public final t50 g;
    public boolean h;
    public final /* synthetic */ pc0 i;

    public nc0(pc0 pc0Var) {
        this.i = pc0Var;
        this.g = new t50(pc0Var.d.h.timeout());
    }

    @Override // defpackage.ih1
    public final void c(fe feVar, long j) {
        if (this.h) {
            throw new IllegalStateException("closed");
        }
        long j2 = feVar.h;
        byte[] bArr = wq1.a;
        if (j < 0 || 0 > j2 || j2 < j) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.i.d.c(feVar, j);
    }

    @Override // defpackage.ih1, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.h) {
            return;
        }
        this.h = true;
        pc0 pc0Var = this.i;
        pc0Var.getClass();
        t50 t50Var = this.g;
        yn1 yn1Var = t50Var.e;
        t50Var.e = yn1.d;
        yn1Var.a();
        yn1Var.b();
        pc0Var.e = 3;
    }

    @Override // defpackage.ih1, java.io.Flushable
    public final void flush() {
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
