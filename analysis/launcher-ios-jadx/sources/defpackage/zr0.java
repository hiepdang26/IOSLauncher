package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zr0 extends AtomicReference implements wr0, cw {
    public final yc1 g = new yc1();
    public final wr0 h;

    public zr0(wr0 wr0Var) {
        this.h = wr0Var;
    }

    @Override // defpackage.wr0
    public final void a(Object obj) {
        this.h.a(obj);
    }

    @Override // defpackage.cw
    public final void b() {
        ew.a(this);
        yc1 yc1Var = this.g;
        yc1Var.getClass();
        ew.a(yc1Var);
    }

    @Override // defpackage.wr0
    public final void c(cw cwVar) {
        ew.d(this, cwVar);
    }

    @Override // defpackage.wr0
    public final void d() {
        this.h.d();
    }

    @Override // defpackage.wr0
    public final void onError(Throwable th) {
        this.h.onError(th);
    }
}
