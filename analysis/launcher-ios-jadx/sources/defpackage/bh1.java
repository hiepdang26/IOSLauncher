package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class bh1 extends AtomicReference implements xg1, cw, Runnable {
    public final AtomicReference g;
    public final yc1 h = new yc1();
    public final mc1 i;

    /* JADX WARN: Multi-variable type inference failed */
    public bh1(xg1 xg1Var, mc1 mc1Var) {
        this.g = (AtomicReference) xg1Var;
        this.i = mc1Var;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicReference, xg1] */
    @Override // defpackage.xg1
    public final void a(Object obj) {
        this.g.a(obj);
    }

    @Override // defpackage.cw
    public final void b() {
        ew.a(this);
        yc1 yc1Var = this.h;
        yc1Var.getClass();
        ew.a(yc1Var);
    }

    @Override // defpackage.xg1
    public final void c(cw cwVar) {
        ew.d(this, cwVar);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicReference, xg1] */
    @Override // defpackage.xg1
    public final void onError(Throwable th) {
        this.g.onError(th);
    }

    @Override // java.lang.Runnable
    public final void run() {
        mc1 mc1Var = this.i;
        mc1Var.getClass();
        try {
            mc1Var.B(this);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            hg0.C(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
