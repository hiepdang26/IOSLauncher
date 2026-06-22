package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class sz implements yo, Serializable {
    public static final sz g = new sz();

    public final int hashCode() {
        return 0;
    }

    @Override // defpackage.yo
    public final yo k(yo yoVar) {
        qg0.l(yoVar, "context");
        return yoVar;
    }

    @Override // defpackage.yo
    public final wo n(xo xoVar) {
        qg0.l(xoVar, "key");
        return null;
    }

    @Override // defpackage.yo
    public final yo r(xo xoVar) {
        qg0.l(xoVar, "key");
        return this;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // defpackage.yo
    public final Object h(Object obj, s70 s70Var) {
        return obj;
    }
}
