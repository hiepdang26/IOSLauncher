package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class vr0 extends AtomicReference implements wr0, cw, Runnable, xg1 {
    public final /* synthetic */ int g;
    public final eb0 h;
    public Object i;
    public Throwable j;
    public final Object k;

    public /* synthetic */ vr0(Object obj, eb0 eb0Var, int i) {
        this.g = i;
        this.k = obj;
        this.h = eb0Var;
    }

    @Override // defpackage.wr0
    public final void a(Object obj) {
        switch (this.g) {
            case 0:
                this.i = obj;
                eb0 eb0Var = this.h;
                eb0Var.getClass();
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                ew.c(this, eb0Var.c(this));
                break;
            default:
                this.i = obj;
                eb0 eb0Var2 = this.h;
                eb0Var2.getClass();
                TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                ew.c(this, eb0Var2.c(this));
                break;
        }
    }

    @Override // defpackage.cw
    public final void b() {
        switch (this.g) {
            case 0:
                ew.a(this);
                break;
            default:
                ew.a(this);
                break;
        }
    }

    @Override // defpackage.wr0
    public final void c(cw cwVar) {
        switch (this.g) {
            case 0:
                if (ew.d(this, cwVar)) {
                    ((wr0) this.k).c(this);
                }
                break;
            default:
                if (ew.d(this, cwVar)) {
                    ((xg1) this.k).c(this);
                }
                break;
        }
    }

    @Override // defpackage.wr0
    public void d() {
        eb0 eb0Var = this.h;
        eb0Var.getClass();
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        ew.c(this, eb0Var.c(this));
    }

    @Override // defpackage.wr0
    public final void onError(Throwable th) {
        switch (this.g) {
            case 0:
                this.j = th;
                eb0 eb0Var = this.h;
                eb0Var.getClass();
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                ew.c(this, eb0Var.c(this));
                break;
            default:
                this.j = th;
                eb0 eb0Var2 = this.h;
                eb0Var2.getClass();
                TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                ew.c(this, eb0Var2.c(this));
                break;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                Throwable th = this.j;
                wr0 wr0Var = (wr0) this.k;
                if (th == null) {
                    Object obj = this.i;
                    if (obj == null) {
                        wr0Var.d();
                    } else {
                        this.i = null;
                        wr0Var.a(obj);
                    }
                } else {
                    this.j = null;
                    wr0Var.onError(th);
                }
                break;
            default:
                Throwable th2 = this.j;
                xg1 xg1Var = (xg1) this.k;
                if (th2 == null) {
                    xg1Var.a(this.i);
                } else {
                    xg1Var.onError(th2);
                }
                break;
        }
    }
}
