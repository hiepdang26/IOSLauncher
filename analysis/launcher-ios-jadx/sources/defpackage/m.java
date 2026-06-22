package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Runnable {
    public final nf1 g;
    public final do0 h;

    public m(nf1 nf1Var, do0 do0Var) {
        this.g = nf1Var;
        this.h = do0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.g.g != this) {
            return;
        }
        if (p.l.d(this.g, this, p.e(this.h))) {
            p.b(this.g);
        }
    }
}
