package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class e00 implements Runnable {
    public final /* synthetic */ int g;
    public final yg1 h;
    public final /* synthetic */ h00 i;

    public /* synthetic */ e00(h00 h00Var, yg1 yg1Var, int i) {
        this.g = i;
        this.i = h00Var;
        this.h = yg1Var;
    }

    private final void a() {
        yg1 yg1Var = this.h;
        yg1Var.a.a();
        synchronized (yg1Var.b) {
            synchronized (this.i) {
                try {
                    g00 g00Var = this.i.g;
                    yg1 yg1Var2 = this.h;
                    g00Var.getClass();
                    if (g00Var.g.contains(new f00(yg1Var2, wd.s))) {
                        h00 h00Var = this.i;
                        yg1 yg1Var3 = this.h;
                        h00Var.getClass();
                        try {
                            yg1Var3.f(h00Var.w, 5);
                        } catch (Throwable th) {
                            throw new sf(th);
                        }
                    }
                    this.i.d();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                a();
                return;
            default:
                yg1 yg1Var = this.h;
                yg1Var.a.a();
                synchronized (yg1Var.b) {
                    synchronized (this.i) {
                        try {
                            g00 g00Var = this.i.g;
                            yg1 yg1Var2 = this.h;
                            g00Var.getClass();
                            if (g00Var.g.contains(new f00(yg1Var2, wd.s))) {
                                this.i.y.a();
                                h00 h00Var = this.i;
                                yg1 yg1Var3 = this.h;
                                h00Var.getClass();
                                try {
                                    yg1Var3.g(h00Var.y, h00Var.u, h00Var.B);
                                    this.i.j(this.h);
                                } catch (Throwable th) {
                                    throw new sf(th);
                                }
                            }
                            this.i.d();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                return;
        }
    }
}
