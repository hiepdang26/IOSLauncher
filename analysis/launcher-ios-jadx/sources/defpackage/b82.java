package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class b82 implements cz0, ty0 {
    public final /* synthetic */ int g;
    public Object h;
    public final Executor i;
    public final Object j;

    public b82(l10 l10Var, b82 b82Var) {
        this.g = 2;
        this.j = new Object();
        this.i = l10Var;
        this.h = b82Var;
    }

    private final void c() {
        synchronized (this.j) {
            this.h = null;
        }
    }

    private final void d() {
        synchronized (this.j) {
            this.h = null;
        }
    }

    private final void e() {
        synchronized (this.j) {
            this.h = null;
        }
    }

    private final void g(pm1 pm1Var) {
        if (((od2) pm1Var).d) {
            synchronized (this.j) {
                try {
                    if (((b82) this.h) == null) {
                        return;
                    }
                    l10 l10Var = (l10) this.i;
                    da2 da2Var = new da2(this, 2);
                    l10Var.getClass();
                    da2Var.run();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private final void h(pm1 pm1Var) {
        synchronized (this.j) {
            try {
                if (((py0) this.h) == null) {
                    return;
                }
                this.i.execute(new gb2(this, pm1Var, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void i(pm1 pm1Var) {
        if (pm1Var.d() || ((od2) pm1Var).d) {
            return;
        }
        synchronized (this.j) {
            try {
                if (((ty0) this.h) == null) {
                    return;
                }
                this.i.execute(new gb2(this, pm1Var, 4));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.cz0
    public void a(Object obj) {
        ((od2) this.h).h(obj);
    }

    public final void b() {
        switch (this.g) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                throw new UnsupportedOperationException();
            case 2:
                c();
                return;
            case 3:
                d();
                return;
            case 4:
                e();
                return;
            default:
                synchronized (this.j) {
                    this.h = null;
                    break;
                }
                return;
        }
    }

    public final void f(pm1 pm1Var) {
        switch (this.g) {
            case 0:
                this.i.execute(new el0(this, pm1Var, 25));
                return;
            case 1:
                ((dz1) this.i).execute(new el0(this, pm1Var, 27));
                return;
            case 2:
                g(pm1Var);
                return;
            case 3:
                h(pm1Var);
                return;
            case 4:
                i(pm1Var);
                return;
            default:
                if (pm1Var.d()) {
                    synchronized (this.j) {
                        try {
                            if (((cz0) this.h) != null) {
                                this.i.execute(new gb2(this, pm1Var, 5));
                            }
                        } finally {
                        }
                    }
                    return;
                }
                return;
        }
    }

    @Override // defpackage.ty0
    public void onFailure(Exception exc) {
        ((od2) this.h).g(exc);
    }

    public /* synthetic */ b82(Executor executor, fo foVar, od2 od2Var, int i) {
        this.g = i;
        this.i = executor;
        this.j = foVar;
        this.h = od2Var;
    }

    public b82(Executor executor, py0 py0Var) {
        this.g = 3;
        this.j = new Object();
        this.i = executor;
        this.h = py0Var;
    }

    public b82(Executor executor, ty0 ty0Var) {
        this.g = 4;
        this.j = new Object();
        this.i = executor;
        this.h = ty0Var;
    }

    public b82(Executor executor, cz0 cz0Var) {
        this.g = 5;
        this.j = new Object();
        this.i = executor;
        this.h = cz0Var;
    }
}
