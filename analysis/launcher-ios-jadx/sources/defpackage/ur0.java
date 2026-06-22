package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class ur0 extends p02 implements Callable {
    public final Callable m;

    public ur0(Callable callable) {
        this.m = callable;
    }

    @Override // defpackage.p02
    public final void A(wr0 wr0Var) {
        yc1 yc1Var = new yc1(m90.b);
        wr0Var.c(yc1Var);
        if (yc1Var.a()) {
            return;
        }
        try {
            Object objCall = this.m.call();
            if (yc1Var.a()) {
                return;
            }
            if (objCall == null) {
                wr0Var.d();
            } else {
                wr0Var.a(objCall);
            }
        } catch (Throwable th) {
            hg0.C(th);
            if (yc1Var.a()) {
                e42.m(th);
            } else {
                wr0Var.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.m.call();
    }
}
