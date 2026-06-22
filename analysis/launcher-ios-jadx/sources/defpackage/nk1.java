package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class nk1 {
    public final Object a;
    public final lk1 b;
    public volatile boolean c = true;

    public nk1(Object obj, lk1 lk1Var) {
        this.a = obj;
        this.b = lk1Var;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof nk1) {
            nk1 nk1Var = (nk1) obj;
            if (this.a == nk1Var.a && this.b.equals(nk1Var.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b.f.hashCode() + this.a.hashCode();
    }
}
