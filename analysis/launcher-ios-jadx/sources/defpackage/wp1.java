package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class wp1 implements wo, xo {
    public static final wp1 g = new wp1();

    @Override // defpackage.yo
    public final Object h(Object obj, s70 s70Var) {
        return s70Var.d(obj, this);
    }

    @Override // defpackage.yo
    public final yo k(yo yoVar) {
        return p02.s(this, yoVar);
    }

    @Override // defpackage.yo
    public final wo n(xo xoVar) {
        qg0.l(xoVar, "key");
        if (qg0.d(this, xoVar)) {
            return this;
        }
        return null;
    }

    @Override // defpackage.yo
    public final yo r(xo xoVar) {
        return p02.o(this, xoVar);
    }

    @Override // defpackage.wo
    public final xo getKey() {
        return this;
    }
}
