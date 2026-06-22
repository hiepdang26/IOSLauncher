package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class jc0 implements fi1 {
    public final t50 g;
    public boolean h;
    public final /* synthetic */ pc0 i;

    public jc0(pc0 pc0Var) {
        this.i = pc0Var;
        this.g = new t50(pc0Var.c.h.timeout());
    }

    public final void a() {
        pc0 pc0Var = this.i;
        int i = pc0Var.e;
        if (i == 6) {
            return;
        }
        if (i != 5) {
            throw new IllegalStateException("state: " + pc0Var.e);
        }
        t50 t50Var = this.g;
        yn1 yn1Var = t50Var.e;
        t50Var.e = yn1.d;
        yn1Var.a();
        yn1Var.b();
        pc0Var.e = 6;
    }

    @Override // defpackage.fi1
    public long read(fe feVar, long j) throws IOException {
        pc0 pc0Var = this.i;
        try {
            return pc0Var.c.read(feVar, j);
        } catch (IOException e) {
            pc0Var.b.i();
            a();
            throw e;
        }
    }

    @Override // defpackage.fi1
    public final yn1 timeout() {
        return this.g;
    }
}
