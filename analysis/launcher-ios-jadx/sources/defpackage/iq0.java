package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class iq0 extends fq0 {
    public d00 d;

    @Override // defpackage.fq0
    public final int b(Object obj) {
        eb1 eb1Var = (eb1) obj;
        if (eb1Var == null) {
            return 1;
        }
        return eb1Var.c();
    }

    @Override // defpackage.fq0
    public final void c(Object obj, Object obj2) {
        eb1 eb1Var = (eb1) obj2;
        d00 d00Var = this.d;
        if (d00Var == null || eb1Var == null) {
            return;
        }
        d00Var.e.d(eb1Var, true);
    }

    public final void f(int i) {
        long j;
        if (i >= 40) {
            e(0L);
        } else if (i >= 20 || i == 15) {
            synchronized (this) {
                j = this.b;
            }
            e(j / 2);
        }
    }
}
