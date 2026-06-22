package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class rd1 implements cw, Runnable {
    public final Runnable g;
    public final sd1 h;
    public Thread i;

    public rd1(Runnable runnable, sd1 sd1Var) {
        this.g = runnable;
        this.h = sd1Var;
    }

    @Override // defpackage.cw
    public final void b() {
        if (this.i == Thread.currentThread()) {
            sd1 sd1Var = this.h;
            if (sd1Var instanceof lx0) {
                lx0 lx0Var = (lx0) sd1Var;
                if (lx0Var.h) {
                    return;
                }
                lx0Var.h = true;
                lx0Var.g.shutdown();
                return;
            }
        }
        this.h.b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.i = Thread.currentThread();
        try {
            this.g.run();
        } finally {
            b();
            this.i = null;
        }
    }
}
