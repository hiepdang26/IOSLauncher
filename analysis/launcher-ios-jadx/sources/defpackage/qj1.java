package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class qj1 implements Runnable {
    public final s31 g;
    public final bj1 h;
    public final boolean i;
    public final int j;

    public qj1(s31 s31Var, bj1 bj1Var, boolean z, int i) {
        qg0.l(s31Var, "processor");
        qg0.l(bj1Var, "token");
        this.g = s31Var;
        this.h = bj1Var;
        this.i = z;
        this.j = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        uz1 uz1VarB;
        if (this.i) {
            s31 s31Var = this.g;
            bj1 bj1Var = this.h;
            int i = this.j;
            s31Var.getClass();
            String str = bj1Var.a.a;
            synchronized (s31Var.k) {
                uz1VarB = s31Var.b(str);
            }
            s31.e(uz1VarB, i);
        } else {
            this.g.l(this.h, this.j);
        }
        ka0 ka0VarJ = ka0.j();
        ka0.r("StopWorkRunnable");
        zy1 zy1Var = this.h.a;
        ka0VarJ.getClass();
    }
}
