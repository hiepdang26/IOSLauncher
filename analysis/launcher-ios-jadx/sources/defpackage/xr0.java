package defpackage;

import com.luutinhit.launcher6.widget.WidgetsContainerView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class xr0 implements wr0, cw {
    public final wr0 g;
    public final yr0 h;
    public cw i;

    public xr0(wr0 wr0Var, yr0 yr0Var) {
        this.g = wr0Var;
        this.h = yr0Var;
    }

    @Override // defpackage.wr0
    public final void a(Object obj) {
        cw cwVar = this.i;
        ew ewVar = ew.g;
        if (cwVar == ewVar) {
            return;
        }
        try {
            this.h.getClass();
            this.i = ewVar;
            this.g.a(obj);
            e();
        } catch (Throwable th) {
            hg0.C(th);
            f(th);
        }
    }

    @Override // defpackage.cw
    public final void b() {
        try {
            this.h.getClass();
        } catch (Throwable th) {
            hg0.C(th);
            e42.m(th);
        }
        this.i.b();
        this.i = ew.g;
    }

    @Override // defpackage.wr0
    public final void c(cw cwVar) {
        wr0 wr0Var = this.g;
        if (this.i != null) {
            cwVar.b();
            e42.m(new qj("Disposable already set!"));
            return;
        }
        try {
            this.h.getClass();
            this.i = cwVar;
            wr0Var.c(this);
        } catch (Throwable th) {
            hg0.C(th);
            cwVar.b();
            this.i = ew.g;
            wr0Var.c(tz.g);
            wr0Var.onError(th);
        }
    }

    @Override // defpackage.wr0
    public final void d() {
        cw cwVar = this.i;
        ew ewVar = ew.g;
        if (cwVar == ewVar) {
            return;
        }
        try {
            this.h.getClass();
            this.i = ewVar;
            this.g.d();
            e();
        } catch (Throwable th) {
            hg0.C(th);
            f(th);
        }
    }

    public final void e() {
        try {
            this.h.getClass();
        } catch (Throwable th) {
            hg0.C(th);
            e42.m(th);
        }
    }

    public final void f(Throwable th) {
        try {
            Object obj = this.h.o;
            int i = WidgetsContainerView.i0;
        } catch (Throwable th2) {
            hg0.C(th2);
            th = new gl(Arrays.asList(th, th2));
        }
        this.i = ew.g;
        this.g.onError(th);
        e();
    }

    @Override // defpackage.wr0
    public final void onError(Throwable th) {
        if (this.i == ew.g) {
            e42.m(th);
        } else {
            f(th);
        }
    }
}
