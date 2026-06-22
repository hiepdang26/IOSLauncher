package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class g implements wo {
    public final xo g;

    public g(xo xoVar) {
        this.g = xoVar;
    }

    @Override // defpackage.wo
    public final xo getKey() {
        return this.g;
    }

    @Override // defpackage.yo
    public final Object h(Object obj, s70 s70Var) {
        return s70Var.d(obj, this);
    }

    @Override // defpackage.yo
    public final yo k(yo yoVar) {
        return p02.s(this, yoVar);
    }

    @Override // defpackage.yo
    public wo n(xo xoVar) {
        qg0.l(xoVar, "key");
        if (qg0.d(getKey(), xoVar)) {
            return this;
        }
        return null;
    }

    @Override // defpackage.yo
    public yo r(xo xoVar) {
        return p02.o(this, xoVar);
    }
}
